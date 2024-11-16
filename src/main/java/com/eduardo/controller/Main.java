package com.eduardo.controller;

import com.eduardo.model.*;

public class Main {
    public static void main(String[] args) {
        Category category1 = new Category(1, "High Demand Buyer", 12);

        Customer customer = new Customer(1, "Lívia Macedo", "0000-0000", "livimac@example.com", category1);

        System.out.println(customer.applyDiscountPrice(211));
    }
}
