package com.lamina.stock.controller;

import com.lamina.stock.aggregation.AggregationFactory;
import com.lamina.stock.aggregation.StockProfit;
import com.lamina.stock.exception.BadRequestException;
import com.lamina.stock.exception.StockNotFoundException;
import com.lamina.stock.request.StockResponse;
import com.lamina.stock.service.StockService;
import com.lamina.stock.util.StockUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/stock/aggregation")
public class StockAggregationController {
    static final Logger logger = LoggerFactory.getLogger(StockAggregationController.class);

    @Autowired
    private StockService service;

    @GetMapping
    public ResponseEntity<StockResponse> getAggregation(@RequestHeader String aggregation,
                                                        @Valid @RequestHeader Long userId){
        logger.info("aggregation: {}, userId: {}", aggregation, userId);
        validateAggregationRequest (aggregation, userId);

        List<StockResponse> stocks = service.getByUserId(userId);
        logger.info("User's Stock size:  {}", stocks.size());

        Optional<StockResponse> calculate = Objects.requireNonNull(AggregationFactory.of(StockProfit.valueOf(aggregation))).calculate(stocks);
        logger.info("-------------calculate---------->: {}", calculate);
        StockResponse response = calculate
                .orElseThrow (()->new StockNotFoundException (
                            "Stock not found with aggregation:" + aggregation
                            + ", userId: " + userId));
        StockUtil.addLink(response);
        return new ResponseEntity(calculate.orElse(null), HttpStatus.OK);
    }


    private void validateAggregationRequest(String aggregation, Long userId) {
        if (aggregation.isEmpty ()
                || aggregation.isBlank ()
                || userId < 1) {
            throw new BadRequestException ("Provide correct headers; aggregation: "
                    + aggregation + ", userId: "
                    + userId);
        }
        try {
            StockProfit.valueOf (aggregation);
        } catch (Exception e) {
            throw new BadRequestException ("Provide valid aggregation: " + aggregation);
        }
    }


}
