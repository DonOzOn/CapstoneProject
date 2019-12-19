package com.realestatebrokerage.service;

public class UsernameAlreadyUsedException extends RuntimeException {

    public UsernameAlreadyUsedException() {
        super("Tên tài khoản đã tồn tại!");
    }

}
