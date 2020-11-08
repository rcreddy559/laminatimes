package com.lamina.stock.service;

import com.lamina.stock.beans.Stock;
import com.lamina.stock.dao.StockDao;
import com.lamina.stock.request.StockResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockService {
    static final Logger logger = LoggerFactory.getLogger(StockService.class);

    @Autowired
    private StockRepository repository;

    public List<StockResponse> findAll() {
        return repository.findAll()
                .stream()
                .filter(o -> o.getActive() == 0)
                .map(StockResponse::new)
                .collect(Collectors.toList());
    }

    public List<StockResponse> getByUserId(Long userId) {

        return repository.getByUserId(userId)
                .stream()
                .map(StockResponse::new)
                .collect(Collectors.toList());
    }

    public StockResponse findById(long id) {
        return new StockResponse(repository.getOne(id));
    }


    public List<StockResponse> addAll(List<StockResponse> stockResponses) {
        List<Stock> stocks = stockResponses.stream()
                                            .map(StockResponse::createStock)
                                            .collect(Collectors.toList());
        repository.saveAll(stocks);
        return findAll();
    }

    public StockResponse addStock(StockResponse stockResponse) {
        List<Stock> all = repository.findAll();
        Stock save = repository.save(stockResponse.createStock());
        return new StockResponse(save);
    }

    public Integer getUnCommitted() {
        logger.info("--------getUnCommitted---------");
        return repository.findAll().size();
    }
}
