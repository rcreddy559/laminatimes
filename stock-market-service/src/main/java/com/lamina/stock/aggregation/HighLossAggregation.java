package com.lamina.stock.aggregation;

import com.lamina.stock.controller.StockAggregationController;
import com.lamina.stock.request.StockResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class HighLossAggregation implements Aggregation {
    static final Logger logger = LoggerFactory.getLogger(HighLossAggregation.class);

    @Override
    public Optional<StockResponse> calculate(List<StockResponse> stock) {
        logger.info("Calculating high loss aggregation ");
        return stock.stream()
                .filter(s->s.getActive() == 0 && s.getOverallPlPercentage() < 0)
                .min(Comparator.comparing(StockResponse::getOverallPlPercentage));
    }
}
