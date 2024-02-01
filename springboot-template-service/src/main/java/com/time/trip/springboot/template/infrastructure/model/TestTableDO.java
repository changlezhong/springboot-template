package com.time.trip.springboot.template.infrastructure.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.time.trip.springboot.template.infrastructure.BaseDO;
import java.io.Serializable;
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
public class TestTableDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    private String name;
}
