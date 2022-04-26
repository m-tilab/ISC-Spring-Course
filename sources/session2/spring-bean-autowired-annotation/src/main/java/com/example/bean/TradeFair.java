package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TradeFair {

    private  IndustrialProduct industrialProduct;

    private  ConsumerProduct consumerProduct;


    public TradeFair(IndustrialProduct industrialProduct, ConsumerProduct consumerProduct) {
        this.industrialProduct = industrialProduct;
        this.consumerProduct = consumerProduct;
    }

    public IndustrialProduct getIndustrialProduct() {
        return industrialProduct;
    }

    public void setIndustrialProduct(IndustrialProduct industrialProduct) {
        this.industrialProduct = industrialProduct;
    }

    public ConsumerProduct getConsumerProduct() {
        return consumerProduct;
    }

    public void setConsumerProduct(ConsumerProduct consumerProduct) {
        this.consumerProduct = consumerProduct;
    }

    public String getQualifiedProductPrice() {

        return "IndustrialProduct with price " + getIndustrialProduct().getQualifiedPrice() + " IRR and"
                + "ConsumerProduct with price " + getConsumerProduct().getQualifiedPrice() + " IRR";
    }
}
