package com.time.trip.springboot.template.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.time.trip.springboot.template.infrastructure.model.TestTableDO;
import com.time.trip.springboot.template.infrastructure.model.ext.TestTableExtDO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author trip
 * @since 2024-02-01
 */
public interface ITestTableService extends IService<TestTableDO> {

    TestTableExtDO getByName(String name);

}
