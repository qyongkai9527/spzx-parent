package com.joker.spzx.utils.excel;

import java.util.List;

public interface ExcelResult<T> {

    /**
     * 对象列表
     */
    List<T> getList();

    /**
     * 错误列表
     */
    List<String> getErrorList();

    /**
     * 导入回执
     */
    String getAnalysis();

    Boolean isSuccess();
}

