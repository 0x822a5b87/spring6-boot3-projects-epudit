package com.linkedbear.springboot.mcp.service;

import com.linkedbear.springboot.mcp.vo.StoreOperationVO;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    
    @Tool(name = "获取指定商品库存", description = "查询指定商品的库存")
    public int getStock(String productId) {
        return switch (productId) {
            case "1" -> 100;
            case "2" -> 200;
            default -> 0;
        };
    }
    
    @Tool(description = "扣减指定库位上的商品库存，并返回扣减后的剩余库存数量")
    public int subtractStock(@ToolParam(description = "商品ID，纯数字") String abc,
            @ToolParam(description = "库位号，纯数字") String def,
            @ToolParam(description = "扣减库存数量，只能为正整数") int count) {
        System.out.println(abc);
        System.out.println(def);
        return switch (abc) {
            case "1" -> 100 - count;
            case "2" -> 200 - count;
            default -> 0;
        };
    }
    
    @Tool(description = "增加指定库位上的商品库存，并返回增加后的剩余库存数量")
    public int addStock(StoreOperationVO vo) {
        return switch (vo.productId()) {
            case "1" -> 100 + vo.count();
            case "2" -> 200 + vo.count();
            default -> 0;
        };
    }
    
    public String getLocation(String productId) {
        return switch (productId) {
            case "1" -> "库房";
            case "2" -> "天台";
            default -> "大厅";
        };
    }
}
