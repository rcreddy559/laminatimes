package com.lamina.stock.aggregation;

import com.lamina.stock.controller.StockAggregationController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AggregationFactory {
    static final Logger logger = LoggerFactory.getLogger(AggregationFactory.class);

    public static Aggregation of(StockProfit input) {
    logger.info("Aggregation: of {}", input);

        switch (input) {
            case HIGH_PROFIT:
                return new HighProfitAggregation();
            case LOW_PROFIT:
                return new LowProfitAggregation();
            case HIGH_LOOS:
                return new HighLossAggregation();
            case LOW_LOOS:
                return new LowLossAggregation();
            default: {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        Aggregation aggregation = AggregationFactory.of(StockProfit.HIGH_LOOS);
    }
}
