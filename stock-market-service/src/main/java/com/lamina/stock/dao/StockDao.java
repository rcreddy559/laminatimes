package com.lamina.stock.dao;

import com.lamina.stock.beans.Stock;

import java.math.BigInteger;
import java.util.List;

public interface StockDao {
    List<Stock> getAllStock();

    List<Stock> getAllStockByUserId(long userId);

    Stock getStock(long id);

    Long addStock(Stock stock);

    void updateStock(Stock stock);

    void deleteStock(Stock stock);

    List<Stock> getByUserId(long userId);

    List<Long> addAll(List<Stock> stockResponses);

    BigInteger getUnCommitted();
}
