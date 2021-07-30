package com.user.mangment.util;

import com.user.mangment.entities.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserUtil {

    public static List<String> getRoleName(User user) {
        List<String> roleNames = user.
                getRoles().
                stream().
                map(value -> value.getRoleName())
                .collect(Collectors.toList());
        return roleNames;
    }

}
