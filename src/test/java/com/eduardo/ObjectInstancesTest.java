package com.eduardo;

import com.eduardo.model.*;
import static com.eduardo.repository.ObjectInstances.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ObjectInstancesTest {

    Customer randomCus;
    Category randomCat;

    @BeforeAll
    void beforeTests() {
        randomCus = fetchRandomCustomer();
        randomCat = randomCus.category();
    }

    @AfterAll
    void afterTests() {
        randomCus = null;
        randomCat = null;
    }

    @Test
    public void fetchRandomCustomerTest() {
        assertNotNull(randomCus, "Customer is null");
    }

    @Test
    public void checkCustomerInfo() {
        assertNotNull(randomCus.name(), "Customer's name is null");
        assertNotNull(randomCus.phoneNumber(), "Customer's phone number is null");
        assertNotNull(randomCus.email(), "Customer's email is null");
        assertNotNull(randomCus.category(), "Customer's CATEGORY is null");
        System.out.println(randomCus);

    }

    @Test
    public void fetchRandomCategoryTest() {
        assertNotNull(randomCat);
    }

    @Test
    public void checkCategoryInfo() {
        assertNotNull(randomCat.categoryName(), "Category name is null");
        System.out.println(randomCat);

    }

}
