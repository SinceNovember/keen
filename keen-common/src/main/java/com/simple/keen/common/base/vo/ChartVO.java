package com.simple.keen.common.base.vo;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/4/23
 */
@Data
@ToString
@Builder
public class ChartVO {

    private List<String> nameList;

    private List<Object> valueList;

}
