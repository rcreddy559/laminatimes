package com.lamina.stock.service;

import com.lamina.stock.beans.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> getByUserId(long userId);
}
