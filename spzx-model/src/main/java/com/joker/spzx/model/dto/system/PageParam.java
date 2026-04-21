package com.joker.spzx.model.dto.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.beans.Transient;

@Data
public class PageParam<T> {

    private Integer pageSize = 10;

    private Integer pageNum = 1;

    @Transient
    public IPage<T> getPage() {
        return new Page<T>(this.pageNum, this.pageSize);
    }

}
