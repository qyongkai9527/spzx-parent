package com.joker.spzx.utils.excel;

import com.alibaba.excel.EasyExcel;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.compress.utils.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Excel相关处理
 *
 * @author 鲁子狄
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExcelUtil {

    /**
     * 同步导入(适用于小数据量)
     *
     * @param is 输入流
     * @return 转换后集合
     */
    public static <T> List<T> importExcel(InputStream is, Class<T> clazz) {
        return EasyExcel.read(is).head(clazz).autoCloseStream(false).sheet().doReadSync();
    }


    /**
     * 使用校验监听器 异步导入 同步返回
     *
     * @param is         输入流
     * @param clazz      对象类型
     * @param isValidate 是否 Validator 检验 默认为是
     * @return 转换后集合
     */
    public static <T> ExcelResult<T> importExcel(InputStream is, Class<T> clazz, boolean isValidate) {
        DefaultExcelListener<T> listener = new DefaultExcelListener<>(isValidate);
        EasyExcel.read(is, clazz, listener).sheet().doRead();
        return listener.getExcelResult();
    }

    /**
     * 使用自定义监听器 异步导入 自定义返回
     *
     * @param is       输入流
     * @param clazz    对象类型
     * @param listener 自定义监听器
     * @return 转换后集合
     */
    public static <T> ExcelResult<T> importExcel(InputStream is, Class<T> clazz, ExcelListener<T> listener) {
        EasyExcel.read(is, clazz, listener).sheet().doRead();
        return listener.getExcelResult();
    }

    /**
     * 使用自定义监听器 异步导入 自定义返回
     *
     * @param is          输入流
     * @param clazz       对象类型
     * @param targetCells 获取表头对应的单元格
     * @param headRowNum  表头行
     * @param listener    自定义监听器
     * @return 转换后集合
     */
    public static <T> ExcelResult<T> importExcel(InputStream is, Class<T> clazz, Set<CellPosition> targetCells, Integer headRowNum, ExcelListener<T> listener) {
        byte[] inputStreamBytes;
        try {
            inputStreamBytes = IOUtils.toByteArray(is);
        } catch (IOException e) {
            throw new RuntimeException("读取输入流异常", e);
        }

        if (targetCells != null) {
            // 同步读取预表头数据
            PreHeaderListener preHeaderListener = new PreHeaderListener(targetCells);
            // 注册监听器前先设置读取模式为无模型读取
            try (InputStream preHeaderInputStream = new ByteArrayInputStream(inputStreamBytes)) {
                EasyExcel.read(preHeaderInputStream)
                    .sheet()
                    .headRowNumber(0)
                    .registerReadListener(preHeaderListener)
                    .doReadSync();
            } catch (IOException e) {
                throw new RuntimeException("读取预表头数据异常", e);
            }
            // 获取预表头数据
            Map<String, String> preHeaderData = preHeaderListener.getPreHeaderData();
            listener.setPreHeaderData(preHeaderData);
        }

        // 使用新的输入流重新读取文件，这次是为了读取实际数据
        try (InputStream inputStream = new ByteArrayInputStream(inputStreamBytes)) {
            EasyExcel.read(inputStream)
                .sheet()
                .head(clazz)
                .headRowNumber(headRowNum)
                .registerReadListener(listener)
                .doRead();
        } catch (IOException e) {
            throw new RuntimeException("导出Excel异常", e);
        }

        return listener.getExcelResult();
    }
}
