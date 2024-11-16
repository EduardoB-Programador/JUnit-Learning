package com.eduardo;

import com.eduardo.model.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static com.eduardo.repository.ObjectInstances.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerTest {

    Customer customer;
    static Category CATEGORY;

    @BeforeAll
    static void getRandomCategory() {
        CATEGORY = fetchRandomCategory();
        System.out.println("------CATEGORY CHOSEN------\n" + CATEGORY + "\n\n");
    }

    @AfterEach
    void closeCustomerInstance() {
        this.customer = null;
    }

    @Test
    void instaceSuccessTest() {
        boolean assertion;

        try {
            customer = new Customer(1, "Johnathan Clark", "0000-0000", "johncla@example.com", CATEGORY);
            assertion = false;
        } catch (IllegalArgumentException e) {
            assertion = true;
            System.out.println(e.getMessage());
        }

        assertFalse(assertion, "Instance of Customer Failed in succeeding");
    }

    @Test
    void instaceFailTest() {
        boolean assertion;

        try {
            customer = new Customer(0, "Louis Serra", "0000-0000", "louser@example.com", CATEGORY);
            assertion = false;
        } catch (IllegalArgumentException e) {
            assertion = true;
            System.out.println(e.getMessage());
        }

        assertTrue(assertion, "Instance of Customer Succeeded in failing");
    }

    @Test
    void applyDiscountPriceSuccessTest() {
        this.customer = instanceOfCustomer();
        //Input value in method will be 235
        double expected = 235 - (235 * ((double) CATEGORY.discount() / 100));
        assertEquals(expected, customer.applyDiscountPrice(235));
    }

    @Test
    void applyDiscountPriceFailTest() {
        this.customer = instanceOfCustomer();
        assertThrows(ArithmeticException.class, () -> this.customer.applyDiscountPrice(0), "Exception wasn't thrown");
    }

    static Customer instanceOfCustomer() {
        return new Customer(1, "Johnathan Clark", "0000-0000", "johncla@example.com", CATEGORY);
    }
}
