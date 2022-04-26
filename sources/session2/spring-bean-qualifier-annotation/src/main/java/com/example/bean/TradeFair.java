package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TradeFair {

    private GenericProduct genericProduct;

    public TradeFair(@Qualifier("industrialProduct") GenericProduct genericProduct) {
        this.genericProduct = genericProduct;
    }

    public GenericProduct getGenericProduct() {
        return genericProduct;
    }

    public void setGenericProduct(GenericProduct genericProduct) {
        this.genericProduct = genericProduct;
    }

    public String getQualifiedProductPrice() {

        return "IndustrialProduct with price " + genericProduct.getQualifiedPrice() + " IRR";
    }
}
