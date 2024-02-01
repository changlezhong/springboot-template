package com.time.trip.springboot.template.controller.test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.time.trip.springboot.template.infrastructure.model.TestTableDO;
import com.time.trip.springboot.template.infrastructure.response.SingleResponse;
import com.time.trip.springboot.template.service.ITestTableService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestTableController {

    @Resource
    private ITestTableService testTableService;

    @GetMapping("/table")
    public SingleResponse<TestTableDO> testTableDO(@RequestParam String name) {
        LambdaQueryWrapper<TestTableDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(TestTableDO::getName, name);
        return SingleResponse.of(testTableService.getOne(wrapper));
    }

}
