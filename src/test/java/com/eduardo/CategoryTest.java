package com.eduardo;

import com.eduardo.model.Category;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    Category category;
    static int id = 0;

    CategoryTest() {
        id++;
    }

    @Test
    void instaceSuccessTest() {
        assertDoesNotThrow(() -> category = new Category(id, "Common Customer", 0), "Instance of Category Failed in succeeding");
        System.out.println("Succeess");
        System.out.println(category);
    }

    @Test
    void instanceFailTest() {
        assertThrows(IllegalArgumentException.class, () -> category = new Category(id, "Monthly Buyer", -1), "Instance of Category Failed in failing");
        System.out.println("Succeess");
        System.out.println(category);
    }

}
