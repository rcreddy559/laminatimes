package com.lamina.stock.service;

import com.lamina.stock.beans.Stock;
import com.lamina.stock.dao.StockDao;
import com.lamina.stock.request.StockResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Component
@EnableTransactionManagement
public class StockService {
    static final Logger logger = LoggerFactory.getLogger(StockService.class);

    @Qualifier("getStockDaoImpl")
    @Autowired
    private StockDao stockDao;

    public List<StockResponse> findAll() {
        return stockDao.getAllStock()
                .stream()
                .filter(o -> o.getActive() == 0)
                .map(StockResponse::new)
                .collect(Collectors.toList());
    }

    public List<StockResponse> getByUserId(Long userId) {

        return stockDao.getByUserId(userId)
                .stream()
                .map(StockResponse::new)
                .collect(Collectors.toList());
    }

    public StockResponse findById(long id) {
        return new StockResponse(stockDao.getStock(id));
    }


    public List<StockResponse> addAll(List<StockResponse> stockResponses) {
        List<Stock> stocks = stockResponses.stream()
                                            .map(StockResponse::createStock)
                                            .collect(Collectors.toList());
        stockDao.addAll(stocks);
        return findAll();
    }

    public StockResponse addStock(StockResponse stockResponse) {
        return findById(stockDao.addStock(stockResponse.createStock()));
    }

    public BigInteger getUnCommitted() {
        logger.info("--------getUnCommitted---------");
        return stockDao.getUnCommitted();
    }
}
