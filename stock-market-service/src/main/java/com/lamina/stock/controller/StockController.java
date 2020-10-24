package com.lamina.stock.controller;

import com.lamina.stock.request.StockResponse;
import com.lamina.stock.service.StockService;
import com.lamina.stock.util.StockUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {

    static final Logger logger = LoggerFactory.getLogger(StockController.class);

    @Autowired
    private StockService service;

    @GetMapping
    public ResponseEntity<List<StockResponse>> findAll() {
        logger.info("find all");
        List<StockResponse> stock = service.findAll();
        StockUtil.addLink(stock);
        logger.info("Stock size :{}", stock.size());
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<StockResponse>> getAll() {
        List<StockResponse> stock = service.findAll();
        StockUtil.addLink (stock);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockResponse> findById(@PathVariable Long id) {
        StockResponse stock = service.findById (id);
        StockUtil.addLink(stock);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @GetMapping("/userid/{userId}")
    public ResponseEntity<List<StockResponse>> findByUserId(@PathVariable Long userId) {
        List<StockResponse> stock = service.getByUserId (userId);
        StockUtil.addLink (stock);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @PostMapping("/addAll")
    public ResponseEntity<List<StockResponse>> addAll(@RequestBody List<StockResponse> stockResponses) {
        List<StockResponse> stock = service.addAll(stockResponses);
        StockUtil.addLink (stock);
        return new ResponseEntity<>( stock, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StockResponse> add(@RequestBody StockResponse stockResponse) {
        StockResponse stock = service.addStock(stockResponse);
        StockUtil.addLink(stock);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @GetMapping("/uncommitted")
    public ResponseEntity<BigInteger> getUnCommitted() {
        BigInteger stocks = service.getUnCommitted();
    return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

}
