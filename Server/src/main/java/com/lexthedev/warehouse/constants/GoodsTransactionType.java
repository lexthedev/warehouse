package com.lexthedev.warehouse.constants;

public enum GoodsTransactionType {
    SELL("SELL"), BUY("BUY");

    private final String name;

    private GoodsTransactionType(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        // (otherName == null) check is not needed because name.equals(null) returns false
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
