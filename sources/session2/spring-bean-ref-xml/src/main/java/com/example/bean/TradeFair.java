package com.example.bean;

public class TradeFair {


    private IndustrialProduct industrialProduct;

    private ConsumerProduct consumerProduct;

    public TradeFair() {
    }

    public TradeFair(IndustrialProduct industrialProduct, ConsumerProduct consumerProduct) {
        this.industrialProduct = industrialProduct;
        this.consumerProduct = consumerProduct;
    }


    public void setIndustrialProduct(IndustrialProduct industrialProduct) {
        this.industrialProduct = industrialProduct;
    }


    public void setConsumerProduct(ConsumerProduct consumerProduct) {
        this.consumerProduct = consumerProduct;
    }

    public int getIndustrialProductPrice() {
        return industrialProduct.getQualifiedPrice();
    }

    public int getConsumerProductPrice() {
        return consumerProduct.getQualifiedPrice();
    }

    public String getQualifiedProductPrice() {

        return "IndustrialProduct with price " + getIndustrialProductPrice() + " IRR and" +
                "ConsumerProduct with price " + getConsumerProductPrice() + " IRR";
    }
}
