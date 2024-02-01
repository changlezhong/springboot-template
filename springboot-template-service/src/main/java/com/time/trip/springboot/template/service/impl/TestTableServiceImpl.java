package com.time.trip.springboot.template.service.impl;

import com.time.trip.springboot.template.infrastructure.model.TestTableDO;
import com.time.trip.springboot.template.infrastructure.mapper.TestTableMapper;
import com.time.trip.springboot.template.service.ITestTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
