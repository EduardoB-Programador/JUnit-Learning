package com.eduardo.repository;

import com.eduardo.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class ObjectInstances {

    private static int CUSTOMERS_ID = 1;
    private static int CATEGORIES_ID = 1;

    private final static List<Category> CATEGORIES;
    private final static List<Customer> CUSTOMERS;
    private final static Random GENERATOR = new Random();

    static {
        Category c1 = new Category(CATEGORIES_ID++, "Common Customer", 0);
        Category c2 = new Category(CATEGORIES_ID++, "Monthly Buyer", 5);
        Category c3 = new Category(CATEGORIES_ID++, "Company", 7);
        Category c4 = new Category(CATEGORIES_ID++, "High Demand Buyer", 10);
        Category c5 = new Category(CATEGORIES_ID++, "Low Demand Buyer", 4);

        CATEGORIES = Arrays.asList(c1, c2, c3, c4, c5);

        CUSTOMERS = new ArrayList<>();

        //AI generated info
        CUSTOMERS.add(new Customer(CUSTOMERS_ID++, "Jack Baker", "0000-0000", "jackbaker@example.com", c1));// this one
        CUSTOMERS.add(new Customer(CUSTOMERS_ID++, "Ethan Winters", "1111-0000", "ethanw@example.com", c1));// and this one are not AI generated
        CUSTOMERS.add(new Customer(CUSTOMERS_ID++, "John Smith", "2222-0000", "johnsmth@example.com", c2));
        CUSTOMERS.add(new Customer(CUSTOMERS_ID++, "Emily Davis", "3333-0000", "emilydvs@example.com", c2));
        CUSTOMERS.add(new Customer(CUSTOMERS_ID++, "Michael Johnson", "4444-0000", "michjs@example.com", c3));
        CUSTOMERS.add(new Customer(CUSTOMERS_ID++, "Sarah Brown", "5555-0000", "sarahb@example.com", c3));
        CUSTOMERS.add(new Customer(CUSTOMERS_ID++, "David Wilson", "6666-0000", "davidwlsn@example.com", c4));
        CUSTOMERS.add(new Customer(CUSTOMERS_ID++, "Jessica Taylor", "7777-0000", "jesstay@example.com", c4));
        CUSTOMERS.add(new Customer(CUSTOMERS_ID++, "Robert Anderson", "8888-0000", "roband@example.com", c5));
        CUSTOMERS.add(new Customer(CUSTOMERS_ID++, "Laura Martinez", "9999-0000", "laumar@example.com", c5));
        CUSTOMERS.add(new Customer(CUSTOMERS_ID++, "James Thomas", "0000-0001", "jayth@example.com", c1));
        CUSTOMERS.add(new Customer(CUSTOMERS_ID++, "Megan Lewis", "1111-0001", "megal@example.com", c1));
        CUSTOMERS.add(new Customer(CUSTOMERS_ID++, "Daniel White", "2222-0001", "danwhi@example.com", c2));
        CUSTOMERS.add(new Customer(CUSTOMERS_ID++, "Rachel Harris", "3333-0001", "racharr@example.com", c2));
        CUSTOMERS.add(new Customer(CUSTOMERS_ID++, "Anthony Clark", "4444-0001", "anthcla@example.com", c3));
        CUSTOMERS.add(new Customer(CUSTOMERS_ID++, "Amanda Hall", "5555-0001", "amanha@example.com", c3));

    }

    public static Customer fetchRandomCustomer() {
        return CUSTOMERS.get(getRandomNumber(CUSTOMERS));
    }

    public static Category fetchRandomCategory() {
        return CATEGORIES.get(getRandomNumber(CATEGORIES));
    }

    private static int getRandomNumber(List<?> l) {
        return GENERATOR.nextInt(l.size());
    }

}
