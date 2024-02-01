package com.time.trip.springboot.template.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.time.trip.springboot.template.infrastructure.mapper.TestTableMapper;
import com.time.trip.springboot.template.infrastructure.mapper.ext.TestTableExtMapper;
import com.time.trip.springboot.template.infrastructure.model.TestTableDO;
import com.time.trip.springboot.template.infrastructure.model.ext.TestTableExtDO;
import com.time.trip.springboot.template.service.ITestTableService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author trip
 * @since 2024-02-01
 */
@Service
public class TestTableServiceImpl extends ServiceImpl<TestTableMapper, TestTableDO> implements ITestTableService {
    @Resource
    private TestTableExtMapper testTableExtMapper;

    @Override
    public TestTableExtDO getByName(String name) {
        return testTableExtMapper.getByName(name);
    }
}
