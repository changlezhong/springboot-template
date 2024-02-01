package com.time.trip.springboot.template.infrastructure.mapper.ext;

import com.time.trip.springboot.template.infrastructure.model.ext.TestTableExtDO;

public interface TestTableExtMapper {

    TestTableExtDO getByName(String name);

}
