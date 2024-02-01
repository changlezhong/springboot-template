package com.time.trip.springboot.template.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.time.trip.springboot.template.infrastructure.model.TestTableDO;
import com.time.trip.springboot.template.infrastructure.model.ext.TestTableExtDO;
import com.time.trip.springboot.template.service.ITestTableService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author trip
 * @since 2024-02-01
 */
@Controller
@RequestMapping("/test")
public class TestTableController {

    @Resource
    private ITestTableService testTableService;

    @GetMapping("/table")
    public TestTableDO testTableDO(@RequestParam String name) {
        LambdaQueryWrapper<TestTableDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TestTableDO::getName, name);
        return testTableService.getOne(wrapper);
    }

    @GetMapping("/ext/table")
    public TestTableExtDO testTableExtDO(@RequestParam String name) {
        return testTableService.getByName(name);
    }

}
