package com.time.trip.springboot.template.infrastructure.model.ext;

import com.baomidou.mybatisplus.annotation.TableName;
import com.time.trip.springboot.template.infrastructure.BaseDO;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author trip
 * @since 2024-02-01
 */
@Getter
@Setter
@TableName("t_test_table")
public class TestTableExtDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    private String name;
}
