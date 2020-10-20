package com.lamina.stock.controller;

import com.lamina.stock.beans.Stock;
import com.lamina.stock.request.StockResponse;
import com.lamina.stock.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {

    static final Logger logger = LoggerFactory.getLogger(StockController.class);

    @Autowired
    private StockService service;

    @GetMapping
    public ResponseEntity<List<StockResponse>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Stock>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockResponse> findById(@PathVariable String id) {
        return new ResponseEntity<>(service.findById(Long.parseLong(id)), HttpStatus.OK);
    }

    @GetMapping("/userid/{userId}")
    public ResponseEntity<List<StockResponse>> findByUserId(@PathVariable String userId) {
        return new ResponseEntity<>(service.findByUserId(Long.parseLong(userId)), HttpStatus.OK);
    }
}
