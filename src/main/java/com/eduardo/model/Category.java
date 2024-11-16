package com.eduardo.model;

public record Category(int id, String categoryName, int discount) {

    public Category(int id, String categoryName, int discount) {
        this.id = id;
        this.categoryName = categoryName;

        if (discount <= 100 && discount > -1)
            this.discount = discount;
        else
            throw new IllegalArgumentException("The discount should be less than 101 and greater than -1");

    }

    @Override
    public String toString() {
        return "Category:\nCategory ID = " + this.id + "\nCategory name = " + this.categoryName + "\nCategory discount = " + this.discount;
    }

}
