package com.lamina.stock.util;

import com.lamina.stock.aggregation.StockProfit;
import com.lamina.stock.controller.StockController;
import com.lamina.stock.request.StockResponse;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class StockUtil {
    public static void main(String[] args) {
        System.out.println(StockProfit.valueOf("HIsGH_PROFIT"));
    }

    public static void addLink(StockResponse response) {
        response.add (linkTo(methodOn(StockController.class)
                        .findById (response.getId ())).withRel ("Id"),
                linkTo(methodOn(StockController.class)
                        .findByUserId (response.getUserId ())).withRel ("User Id"),
                linkTo(methodOn(StockController.class)
                        .findAll()).withRel ("All")
        );
    }
    public static void addLink(List<StockResponse> stocks) {
        stocks.stream().peek(StockUtil::addLink).collect(Collectors.toList());
    }

}
