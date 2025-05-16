package com.isaac.model;

public class Moeda {
    private String base_code;
    private String target_code;
    private double conversion_rate;

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    @Override
    public String toString() {
        return "Moeda{" +
                "base_code='" + base_code + '\'' +
                ", target_code='" + target_code + '\'' +
                ", conversion_rate=" + conversion_rate +
                '}';
    }
}
