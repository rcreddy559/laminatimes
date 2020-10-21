package com.lamina.stock.aggregation;

import com.lamina.stock.request.StockResponse;

import java.util.List;
import java.util.Optional;

public interface Aggregation {
    Optional<StockResponse> calculate(List<StockResponse> stock);
}
