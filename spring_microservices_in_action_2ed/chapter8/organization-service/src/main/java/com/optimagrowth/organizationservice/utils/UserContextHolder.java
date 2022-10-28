package com.optimagrowth.organizationservice.utils;

import org.springframework.util.Assert;

public class UserContextHolder {

    /**
     * Stores {@link UserContext} in a static {@link ThreadLocal} variable
     */
    private static final ThreadLocal<UserContext> userContext = new ThreadLocal<>();

    /**
     * Retrieves the {@link UserContext} object for consumption.
     */
    public static final UserContext getContext() {
        UserContext context = userContext.get();

        if (context == null) {
            context = createEmptyContext();
            userContext.set(context);
        }
        return userContext.get();
    }

    public static final void setContext(UserContext context) {
        Assert.notNull(context, "Only non-null UserContext instances are permitted");
        userContext.set(context);
    }

    public static final UserContext createEmptyContext() {
        return new UserContext();
    }
}
