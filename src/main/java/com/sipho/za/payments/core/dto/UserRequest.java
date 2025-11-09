package com.sipho.za.payments.core.dto;

public record UserRequest(String email, String password, String firstName, String lastName, String idNumber) {
}
