package com.lamina.stock.util;

import com.lamina.stock.controller.StockController;
import com.lamina.stock.request.StockResponse;
import com.lamina.stock.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StockUtil {
    public static void main(String[] args) {
//        readDefaultData(service);
        //System.out.println(StockProfit.valueOf("HIsGH_PROFIT"));
    }
    static final Logger logger = LoggerFactory.getLogger(StockUtil.class);

    public static void addLink(StockResponse response) {
        logger.info(response.toString());
//        response.add (linkTo(methodOn(StockController.class)
//                        .findById (response.getId ())).withRel ("Id"),
//                linkTo(methodOn(StockController.class)
//                        .findByUserId (response.getUserId ())).withRel ("User Id"),
//                linkTo(methodOn(StockController.class)
//                        .findAll()).withRel ("All")
//        );
    }
    public static void addLink(List<StockResponse> stocks) {
        stocks.stream().peek(StockUtil::addLink).collect(Collectors.toList());
    }

    public static void readDefaultData(StockService service) {
//        final String fileName = "PortFolioEqtSummary.csv";
        final String fileName = "/Users/ravi/Documents/GitHub/laminatimes/stock-market-service/src/main/resources/PortFolioEqtSummary.csv";
        try {
            List<String> stringList = Files.readAllLines(Path.of(fileName));
            stringList.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

     static StockResponse create(String lines) {
        String line[] = lines.split(",");
        int i = 0;
        StockResponse stockResponse = new StockResponse();
        stockResponse.setUserId(Long.parseLong(line[i++]));
        stockResponse.setActive(Integer.parseInt(line[i++].trim()));
        stockResponse.setName(line[i++]);
        stockResponse.setSymbol(line[i++]);
        String date[] = line[i++].split("-");
         LocalDateTime localDate = LocalDateTime.of(Integer.parseInt(date[0].trim()),
                 Integer.parseInt(date[1]),
                 Integer.parseInt(date[2]), 0, 0);
         stockResponse.setDate(localDate);
        stockResponse.setNetQty(Long.parseLong(line[i++].trim()));
        stockResponse.setAvgPrice(Double.parseDouble(line[i++].trim()));
         stockResponse.setLtp(Double.parseDouble(line[i++].trim()));
        stockResponse.setCurrentPrice(Double.parseDouble(line[i++].trim()));
         System.out.println(stockResponse.toString());

        return stockResponse;
    }

}
