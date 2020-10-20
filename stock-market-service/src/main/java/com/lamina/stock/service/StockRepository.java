package com.lamina.stock.service;

import com.lamina.stock.beans.Stock;
import com.lamina.stock.request.StockResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findByUserId(long userId);
}
