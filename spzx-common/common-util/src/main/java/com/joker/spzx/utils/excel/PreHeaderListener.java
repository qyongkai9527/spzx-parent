package com.joker.spzx.utils.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 预表头监听器
 * 用于在读取Excel文件时处理预表头数据
 *
 * @author joker
 * @since 2025/05/16 14:55
 **/
@Slf4j
@Getter
public class PreHeaderListener extends AnalysisEventListener<Map<Integer, String>> {

    /**
     * 存储目标单元格的位置
     */
    private final Set<CellPosition> targetCells;
    /**
     * 存储预表头数据
     */
    private final Map<String, String> preHeaderData = new HashMap<>();

    /**
     * 构造函数
     *
     * @param targetCells 目标单元格的位置集合
     */
    public PreHeaderListener(Set<CellPosition> targetCells) {
        this.targetCells = targetCells;
    }

    /**
     * 将列索引转换为列字母
     *
     * @param columnIndex 列索引
     * @return 列字母
     */
    private static String getColumnLetter(int columnIndex) {
        StringBuilder columnLetter = new StringBuilder();
        while (columnIndex >= 0) {
            columnLetter.insert(0, (char) ('A' + columnIndex % 26));
            columnIndex = columnIndex / 26 - 1;
        }
        return columnLetter.toString();
    }

    /**
     * 处理每一行数据
     *
     * @param map     当前行的数据
     * @param context 分析上下文
     */
    @Override
    public void invoke(Map<Integer, String> map, AnalysisContext context) {
        int rowIndex = context.readRowHolder().getRowIndex();
        for (CellPosition position : targetCells) {
            if (position.getRow() == rowIndex) {
                int columnIndex = position.getColumn();
                if (map.containsKey(columnIndex)) {
                    String cellValue = map.get(columnIndex);
                    preHeaderData.put("行" + (rowIndex + 1) + "列" + getColumnLetter(columnIndex), cellValue);
                }
            }
        }
    }

    /**
     * 所有数据解析完成后调用
     *
     * @param analysisContext 分析上下文
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    }
}


