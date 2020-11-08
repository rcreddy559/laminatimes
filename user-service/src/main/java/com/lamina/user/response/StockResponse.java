package com.lamina.user.response;


public class StockResponse {
    private long id;
    private long userId;
    private int active;
    private String name;
    private String symbol;
    private String date;
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
    private String[] links;

    public String[] getLinks() {
        return links;
    }

    public void setLinks(String[] links) {
        this.links = links;
    }

    public void setDayPl(double dayPl) {
        this.dayPl = dayPl;
    }

    public void setDayPlPercentage(double dayPlPercentage) {
        this.dayPlPercentage = dayPlPercentage;
    }

    public void setOverallPl(double overallPl) {
        this.overallPl = overallPl;
    }

    public void setOverallPlPercentage(double overallPlPercentage) {
        this.overallPlPercentage = overallPlPercentage;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

//class Links {
//    private String rel;
//    private String href;
//
//    public String getRel() {
//        return rel;
//    }
//
//    public void setRel(String rel) {
//        this.rel = rel;
//    }
//
//    public String getHref() {
//        return href;
//    }
//
//    public void setHref(String href) {
//        this.href = href;
//    }
//}