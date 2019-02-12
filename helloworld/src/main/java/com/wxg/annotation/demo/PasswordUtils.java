package com.wxg.annotation.demo;

import com.wxg.annotation.UseCase;

import java.util.List;

/**
 * 2019年1月9日16:47:04
 * 《Java编程思想 第4版》
 */
public class PasswordUtils {

    @UseCase(id = 47,
            desc = "Passwords must contain at least one numeric")
    public boolean validatePassword(String password) {
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49,
            desc = "New passwords can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords,
                                       String password) {
        return !prevPasswords.contains(password);
    }
}
