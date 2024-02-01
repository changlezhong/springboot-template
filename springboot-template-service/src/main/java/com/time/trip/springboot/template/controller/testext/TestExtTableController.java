package com.time.trip.springboot.template.controller.testext;

import com.time.trip.springboot.template.infrastructure.model.ext.TestTableExtDO;
import com.time.trip.springboot.template.infrastructure.response.SingleResponse;
import com.time.trip.springboot.template.service.ITestTableService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/ext")
public class TestExtTableController {

    @Resource
    private ITestTableService testTableService;


    @GetMapping("/table")
    public SingleResponse<TestTableExtDO> testTableExtDO(@RequestParam String name) {
        return SingleResponse.of(testTableService.getByName(name));
    }

}
