package com.vincent.dao;

import java.util.Date;
import java.util.List;

public class Stock {

    private String code;
    private Date date;
    private double openPrice;
    private double highPrice;
    private double lowPrice;
    private double closePrice;
    private double change;
    private double volume;
    private double money;
    private double traded_market_value;
    private double market_value;
    private double turnover;
    private double adjust_price;
    private Date report_type;
    private Date report_date;
    private double pe;
    private double ps;
    private double pc;
    private double pb;
    private double adjust_price_f;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(double openPrice) {
        this.openPrice = openPrice;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(double closePrice) {
        this.closePrice = closePrice;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getTraded_market_value() {
        return traded_market_value;
    }

    public void setTraded_market_value(double traded_market_value) {
        this.traded_market_value = traded_market_value;
    }

    public double getMarket_value() {
        return market_value;
    }

    public void setMarket_value(double market_value) {
        this.market_value = market_value;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    public double getAdjust_price() {
        return adjust_price;
    }

    public void setAdjust_price(double adjust_price) {
        this.adjust_price = adjust_price;
    }

    public Date getReport_type() {
        return report_type;
    }

    public void setReport_type(Date report_type) {
        this.report_type = report_type;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public double getPe() {
        return pe;
    }

    public void setPe(double pe) {
        this.pe = pe;
    }

    public double getPs() {
        return ps;
    }

    public void setPs(double ps) {
        this.ps = ps;
    }

    public double getPc() {
        return pc;
    }

    public void setPc(double pc) {
        this.pc = pc;
    }

    public double getPb() {
        return pb;
    }

    public void setPb(double pb) {
        this.pb = pb;
    }

    public double getAdjust_price_f() {
        return adjust_price_f;
    }

    public void setAdjust_price_f(double adjust_price_f) {
        this.adjust_price_f = adjust_price_f;
    }

}
