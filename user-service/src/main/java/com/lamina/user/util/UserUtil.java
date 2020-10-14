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
    
}
