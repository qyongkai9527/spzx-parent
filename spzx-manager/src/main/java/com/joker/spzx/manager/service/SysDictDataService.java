package com.joker.spzx.manager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.joker.spzx.model.entity.system.SysDictData;

import java.util.List;

/**
 * <p>
 * 字典数据表 服务类
 * </p>
 *
 * @author joker
 * @since 2025-04-28 16:21:28
 */
public interface SysDictDataService extends IService<SysDictData> {

    List<SysDictData> getList(String dictType);

    void saveData(SysDictData sysDictData);

    void updateData(SysDictData sysDictData);
}
