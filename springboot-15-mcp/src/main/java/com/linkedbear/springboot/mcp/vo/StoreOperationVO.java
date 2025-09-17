package com.linkedbear.springboot.mcp.vo;

import org.springframework.ai.tool.annotation.ToolParam;

public record StoreOperationVO(@ToolParam(description = "商品ID，纯数字") String productId,
                               @ToolParam(description = "库位号，纯数字") String location,
                               @ToolParam(description = "扣减库存数量，只能为正整数")int count) {
}
