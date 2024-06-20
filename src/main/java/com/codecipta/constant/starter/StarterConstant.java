package com.codecipta.constant.starter;

import jakarta.validation.ValidationException;

public enum StarterConstant {
    FIRST_CONSTANT("FIRST CONSTANT", 1),
    SECOND_CONSTANT("SECOND CONSTANT", 2);

    public final String name;
    public final Integer code;

    StarterConstant(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {
        return code;
    }

    public static Integer getStarterConstantCodeByName(String name) {
        for (StarterConstant constant : StarterConstant.values()) {
            if (constant.getName().equals(name)) {
                return constant.getCode();
            }
        }
        throw new ValidationException("Invalid Starter Name!");
    }

    public static String getStarterConstantNameByCode(Integer code) {
        for (StarterConstant constant : StarterConstant.values()) {
            if (constant.getCode().equals(code)) {
                return constant.getName();
            }
        }
        throw new ValidationException("Invalid Starter Code!");
    }
}
