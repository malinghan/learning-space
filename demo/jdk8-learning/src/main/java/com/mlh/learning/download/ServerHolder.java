package com.mlh.learning.download;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.CoreConnectionPNames;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wangbo on 16/1/11.
 */
public class ServerHolder {
    private ServerHolder() {
    }

    private static ServerHolder ins = new ServerHolder();

    public static ServerHolder getInstance() {
        return ins;
    }

    /** 线程池 暂且使用cpu个数做线程个数 */
    private final ExecutorService executorService = Executors
            .newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private ConcurrentMap<String, String> statusMap = new ConcurrentHashMap<String, String>();

    public ExecutorService getExecutorService() {
        return executorService;
    }

    /**
     * 创建带连接池的httpclient，线程安全<br>
     * 默认每host最大100连接，timeout时间为5秒
     * */
    public DefaultHttpClient createClientWithPool() {
        ThreadSafeClientConnManager connectionManager = new ThreadSafeClientConnManager();
        connectionManager.setDefaultMaxPerRoute(300);
        DefaultHttpClient client = new DefaultHttpClient(connectionManager);
//        client.getParams().setParameter(CoreProtocolPNames.USER_AGENT, "hotel");
        client.getParams().setIntParameter(CoreConnectionPNames.SO_TIMEOUT,
                10 * 60 * 1000);
        client.getParams().setIntParameter(
                CoreConnectionPNames.CONNECTION_TIMEOUT, 10 * 1000);

        // client.addRequestInterceptor(new MonitorRequestInterceptor());
        // client.addResponseInterceptor(new MonitorResponseInterceptor());

        return client;
    }

    public void shutdown() {
        executorService.shutdownNow();
    }

    public void markStatus(String key, String value) {
        statusMap.put(key, value);
    }

    public String getStatus() {
        return statusMap.toString();
    }
}
