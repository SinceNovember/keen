package com.simple.keen.common.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * .
 *
 * @author SinceNovember
 * @date 2023/3/25
 */
public class OnlineUtils {

    /**
     * 在线用户id
     */
    private static final Set<Integer> onlineUserId = new HashSet<>();

    public static void online(Integer id) {
        onlineUserId.add(id);
    }

    public static void offline(Integer id) {
        if (onlineUserId.contains(id)) {
            onlineUserId.remove(id);
        }
    }

    public static boolean isOnline(Integer id) {
        return onlineUserId.contains(id);
    }

    public static boolean isOffline(Integer id) {
        return !onlineUserId.contains(id);
    }

    public static int onlineCount() {
        return onlineUserId.size();
    }

}
