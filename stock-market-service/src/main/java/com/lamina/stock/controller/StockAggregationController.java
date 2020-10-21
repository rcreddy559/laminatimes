package com.lamina.stock.controller;

import com.lamina.stock.aggregation.AggregationFactory;
import com.lamina.stock.aggregation.StockProfit;
import com.lamina.stock.request.StockResponse;
import com.lamina.stock.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/stock/aggregation")
public class StockAggregationController {
    static final Logger logger = LoggerFactory.getLogger(StockAggregationController.class);

    @Autowired
    private StockService service;

    @GetMapping
    public ResponseEntity<StockResponse> getAggregation(@RequestHeader("aggregation") String aggregation, @RequestHeader Long userId){
        logger.info("aggregation()");
        logger.info("aggregation--------->{}", aggregation);
        List<StockResponse> stocks = service.getByUserId(userId);

        logger.info("User's Stock size:  {}", stocks.size());

        Optional<StockResponse> calculate = Objects.requireNonNull(AggregationFactory.of(StockProfit.valueOf(aggregation))).calculate(stocks);
        logger.info("-------------calculate---------->: {}", calculate);

        return new ResponseEntity(calculate.orElse(null), HttpStatus.OK);
    }
}
