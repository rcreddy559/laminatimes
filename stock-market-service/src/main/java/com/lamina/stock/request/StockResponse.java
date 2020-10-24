package com.lamina.stock.request;

import com.lamina.stock.beans.Stock;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.beans.BeanUtils.copyProperties;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

public class StockResponse extends RepresentationModel<StockResponse> {
    private long id;
    private long userId;
    private int active;
    private String name;
    private String symbol;
    private LocalDateTime date;
    private long netQty;
    private double avgPrice;
    private double currentPrice;
    private double ltp;
    private double dayPl;
    private double dayPlPercentage;
    private double overallPl;
    private double overallPlPercentage;
    private double investment;
    private double currentValue;
    public StockResponse(){}

    public Stock createStock() {
        Stock stock = new Stock();
        copyProperties(this, stock);
        return stock;
    }
    public StockResponse(Stock stock) {
        copyProperties(stock, this);
        calculatePl();
        calculateInvestment();
        calculateOverallPl();
    }

    private void calculateOverallPl() {
        this.overallPl = BigDecimal.valueOf(this.currentValue)
                .subtract(BigDecimal.valueOf(this.investment))
                .doubleValue();
        this.overallPlPercentage =
                BigDecimal.valueOf(this.overallPl / this.investment * 100)
                            .setScale(2, RoundingMode.HALF_UP)
                            .doubleValue();
    }

    private void calculateInvestment() {
        this.investment = this.avgPrice * this.netQty;
        this.currentValue = this.currentPrice * this.netQty;
    }

    private void calculatePl() {
        double dayDiff = this.getCurrentPrice() - this.getLtp();
        this.dayPl = (BigDecimal.valueOf(dayDiff).setScale(10, RoundingMode.HALF_UP).doubleValue());
        this.dayPlPercentage = (BigDecimal.valueOf(dayDiff / this.getAvgPrice() * 100)
                .setScale(2, RoundingMode.HALF_UP).doubleValue());
    }

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

    public double getDayPlPercentage() {
        return dayPlPercentage;
    }

    public double getOverallPl() {
        return overallPl;
    }

    public double getOverallPlPercentage() {
        return overallPlPercentage;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", userId=" + userId +
                ", active=" + active +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", date=" + date +
                ", netQty=" + netQty +
                ", avgPrice=" + avgPrice +
                ", currentPrice=" + currentPrice +
                ", ltp=" + ltp +
                ", dayPl=" + dayPl +
                ", dayPlPercentage=" + dayPlPercentage +
                ", overallPl=" + overallPl +
                ", overallPlPercentage=" + overallPlPercentage +
                ", investment=" + investment +
                ", currentValue=" + currentValue +
                '}';
    }
}