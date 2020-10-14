package com.lamina.user.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public final class UserUtil {
    private UserUtil() {}

    private static final  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public static String encodePassword(String password) {
        password = encoder.encode(password);
        return password;
    }

    public static boolean matchesPassword(String rawString, String encodedPassword) {
        return encoder.matches(rawString, encodedPassword);
    }

    public static void main(String[] args) {
        System.out.println(matchesPassword("test", "$2a$12$TC.qsL1OzITQVpJ/QR1V3OtzaqxNLJ4xI7YJonNQsYxfgV1M9bBAC"));
    }

}
