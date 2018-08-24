package com.db.design_patterns.solid_2;

public enum Operation {
    PLUS("+"), MINUS("-");

    private String sign;

    Operation(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return sign;
    }
}
