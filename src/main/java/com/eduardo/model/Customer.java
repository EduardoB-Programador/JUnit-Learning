package com.eduardo.model;

public record Customer(int id, String name, String phoneNumber, String email, Category category) {

    public Customer(int id, String name, String phoneNumber, String email, Category category) {

        if (id > 0)
            this.id = id;
        else
            throw new IllegalArgumentException("Id must be greater than 0");

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Customer:\nID = " + this.id + "\nName = " + this.name + "\nPhone number = " + this.phoneNumber +
                "\nEmail = " + this.email + "\n" + this.category;
    }

    public int getThisCustomerDiscount() {
        return this.category.discount();
    }

    public double applyDiscountPrice(double price) {
        if (this.category.discount() == 0)
            return price;

        if (this.category.discount() == 100)
            return 0;

        if (price <= 0)
            throw new ArithmeticException("Price must be greater than 0");

        return price - (price * ((double) this.category.discount() / 100));
    }

}
