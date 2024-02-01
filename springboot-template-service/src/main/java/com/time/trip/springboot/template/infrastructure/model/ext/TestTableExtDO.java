package com.time.trip.springboot.template.infrastructure.model.ext;

import com.time.trip.springboot.template.infrastructure.BaseDO;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name = "TestTableDO", description = "")
public class TestTableExtDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Schema(description = "名称")
    private String name;
}
