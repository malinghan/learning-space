package com.example.demo.test1;

public class CommonHelper {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static ThreadLocal<String> getThreadLocal() {
        return threadLocal;
    }

    public static String getThreadLocalString() {
        return threadLocal.get();
    }

    public static void setThreadLocal(ThreadLocal<String> threadLocal) {
        CommonHelper.threadLocal = threadLocal;
    }

    public static void setThreadLocalString(String companyId) {
        threadLocal.set(companyId);
    }
}
