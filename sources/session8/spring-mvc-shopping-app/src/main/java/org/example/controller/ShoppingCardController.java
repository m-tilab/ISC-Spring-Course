package org.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.example.domain.Invoice;
import org.example.domain.InvoiceDetail;
import org.example.domain.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("invoice")
public class ShoppingCardController {

    @Autowired
    private ProductService productService;

    @ModelAttribute
    public Invoice getInvoice() {

        return new Invoice();
    }

    @GetMapping("/addToCard")
    public String addToCard(Model model, @RequestParam(defaultValue = "0") long productId) {

        model.addAttribute("invoiceDetail", new InvoiceDetail(productId));
        model.addAttribute("product", productService.getProduct(productId));

        return "addToCard";
    }

    @PostMapping("/addToCard")
    public String addToCard(@ModelAttribute Invoice invoice, InvoiceDetail invoiceDetail) {

        long productPrice = productService.getProduct(invoiceDetail.getProductId()).getPrice();
        invoiceDetail.setPrice(productPrice * invoiceDetail.getQuantity());

        List<InvoiceDetail> invoiceDetails = invoice.getInvoiceDetails();

        if (invoiceDetails == null)
            invoiceDetails = new ArrayList<>();

        invoiceDetails.add(invoiceDetail);
        invoice.setInvoiceDetails(invoiceDetails);

        Long totalPrice = 0L;

        for (InvoiceDetail curInvoiceDetail : invoiceDetails) {

            totalPrice +=curInvoiceDetail.getPrice();
        }

        invoice.setTotalPrice(totalPrice);

        return "/home";
    }

    @GetMapping("/card")
    public String viewCard(@SessionAttribute(value = "invoice", required = false) Invoice invoice,
            Model model) {

        if (invoice == null)
            invoice = new Invoice();

        model.addAttribute("invoice", invoice);

        var products = new ArrayList<Product>();

        if (invoice.getInvoiceDetails() != null) {

            for (InvoiceDetail invoiceDetail : invoice.getInvoiceDetails())
                products.add(productService.getProduct(invoiceDetail.getProductId()));
        }

        model.addAttribute("products", products);

        return "/shoppingcard";
    }

    @GetMapping("clearcard")
    public String clearCard(SessionStatus sessionStatus) {

        sessionStatus.setComplete();

        return "/home";
    }
}
