package com.lamina.stock.dao;

import com.lamina.stock.beans.Stock;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StockDao {
    public List<Stock> getAllStock();
    public List<Stock> getAllStockByUserId(long userId);
    public Stock getStock(long id);
    public Stock addStock(Stock stock);
    public void updateStock(Stock stock);
    public void deleteStock(Stock stock);
}
