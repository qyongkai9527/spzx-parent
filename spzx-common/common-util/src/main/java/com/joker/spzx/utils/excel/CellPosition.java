package com.joker.spzx.utils.excel;

import lombok.Data;

/**
 * 单元格位置类
 * 用于表示Excel中的单元格位置
 *
 * @author joker
 * @since 2025/05/16 11:30
 **/
@Data
public class CellPosition {

    /**
     * 行索引
     */
    private final int row;

    /**
     * 列索引
     */
    private final int column;


    /**
     * 构造函数
     * 将列字母转换为列索引
     *
     * @param row          行索引
     * @param columnLetter 列字母
     */
    public CellPosition(int row, String columnLetter) {
        this.row = row - 1;
        column = getColumnIndex(columnLetter);
    }

    /**
     * 将列字母转换为列索引
     *
     * @param columnLetter 列字母
     * @return 列索引
     */
    private static int getColumnIndex(String columnLetter) {
        int columnIndex = 0;
        for (int i = 0; i < columnLetter.length(); i++) {
            columnIndex = columnIndex * 26 + (columnLetter.charAt(i) - 'A' + 1);
        }
        return columnIndex - 1;
    }
}

