package com.lamina.stock.request;

import java.time.LocalDateTime;

public class StockResponse {
    private long id;
    private long userId;
    private int active;
    private String name;
    private String symbol;
    private LocalDateTime date;
    private long netQty;
    private double avgPrice;
    private double ltp;
    private double currentPrice;
    private double dayPl;
    private double dayPlPercentage;
    private double overallPl;
    private double overallPlPercentage;
    private double investment;
    private double currentValue;

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public double getInvestment() {
        return investment;
    }

    public void setInvestment(double investment) {
        this.investment = investment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public long getNetQty() {
        return netQty;
    }

    public void setNetQty(long netQty) {
        this.netQty = netQty;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public double getLtp() {
        return ltp;
    }

    public void setLtp(double ltp) {
        this.ltp = ltp;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getDayPl() {
        return dayPl;
    }

    public void setDayPl(double dayPl) {
        this.dayPl = dayPl;
    }

    public double getDayPlPercentage() {
        return dayPlPercentage;
    }

    public void setDayPlPercentage(double dayPlPercentage) {
        this.dayPlPercentage = dayPlPercentage;
    }

    public double getOverallPl() {
        return overallPl;
    }

    public void setOverallPl(double overallPl) {
        this.overallPl = overallPl;
    }

    public double getOverallPlPercentage() {
        return overallPlPercentage;
    }

    public void setOverallPlPercentage(double overallPlPercentage) {
        this.overallPlPercentage = overallPlPercentage;
    }
}