package com.paka.mvcmission;

public class ThingDTO {

    private String name;
    private int price;
    private long categoryCode;
    private String stockStatus;

    public ThingDTO() {}

    public ThingDTO(String name, int price, long categoryCode, String stockStatus) {
        this.name = name;
        this.price = price;
        this.categoryCode = categoryCode;
        this.stockStatus = stockStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(long categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    @Override
    public String toString() {
        return "ThingDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", categoryCode=" + categoryCode +
                ", stockStatus='" + stockStatus + '\'' +
                '}';
    }
}
