package com.lamina.stock.service;

import com.lamina.stock.beans.Stock;
import com.lamina.stock.dao.StockDao;
import com.lamina.stock.dao.StockDaoImpl;
import com.lamina.stock.request.StockResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockService {
    static final Logger logger = LoggerFactory.getLogger(StockService.class);

    @Qualifier("getStockDaoImpl")
    @Autowired
    private StockDao stockDao;

    private static StockResponse stockCalculate(Stock stock) {

        StockResponse stockResponse = new StockResponse();
        BeanUtils.copyProperties(stock, stockResponse);

        double dayDiff = stockResponse.getCurrentPrice() - stockResponse.getLtp();
        stockResponse.setDayPl(BigDecimal.valueOf(dayDiff).setScale(10, RoundingMode.HALF_UP).doubleValue());
        stockResponse.setDayPlPercentage(BigDecimal.valueOf(dayDiff / stockResponse.getAvgPrice() * 100)
                     .setScale(2,RoundingMode.HALF_UP).doubleValue());

        double investment = stockResponse.getAvgPrice() * stockResponse.getNetQty();
        stockResponse.setInvestment(investment);

        double overallPrice = stockResponse.getCurrentPrice() * stockResponse.getNetQty();
        stockResponse.setCurrentValue(overallPrice);


        double investmentDiff = overallPrice - investment;
        BigDecimal bigDecimal = BigDecimal.valueOf(investmentDiff / investment * 100).setScale(2, RoundingMode.HALF_UP);

        stockResponse.setOverallPl(investmentDiff);
        stockResponse.setOverallPlPercentage(bigDecimal.doubleValue());

        return stockResponse;
    }

    public List<Stock> getAll() {
        return stockDao.getAllStock();
    }
    public List<StockResponse> findAll() {

        List<Stock> stocks = stockDao.getAllStock();

        return stocks.stream()
                .filter(o -> o.getActive() == 0)
                .map(StockService::stockCalculate).collect(Collectors.toList());
    }

    public List<StockResponse> findByUserId(long userId) {

        return stockDao.findByUserId(userId)
                .stream()
                .map(StockService::stockCalculate)
                .collect(Collectors.toList());
    }

    public StockResponse findById(long id) {
        return stockCalculate(stockDao.findById(id));
    }
}
