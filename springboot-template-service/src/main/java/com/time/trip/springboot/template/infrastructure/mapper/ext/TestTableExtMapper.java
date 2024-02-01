package com.time.trip.springboot.template.infrastructure.mapper.ext;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.time.trip.springboot.template.infrastructure.model.TestTableDO;
import com.time.trip.springboot.template.infrastructure.model.ext.TestTableExtDO;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author trip
 * @since 2024-02-01
 */
public interface TestTableExtMapper extends BaseMapper<TestTableDO> {

    TestTableExtDO getByName(String name);

}
