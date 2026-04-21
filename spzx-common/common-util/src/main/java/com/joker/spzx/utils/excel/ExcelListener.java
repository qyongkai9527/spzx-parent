package com.joker.spzx.utils.excel;

import com.alibaba.excel.read.listener.ReadListener;

import java.util.Map;

public interface ExcelListener<T> extends ReadListener<T> {

    ExcelResult<T> getExcelResult();

    /**
     * 设置预表头数据
     *
     * @param preHeaderData 预表头数据
     */
    void setPreHeaderData(Map<String, String> preHeaderData);
}

