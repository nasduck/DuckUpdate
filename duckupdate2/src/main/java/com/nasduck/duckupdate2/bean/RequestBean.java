package com.nasduck.duckupdate11111.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置的更新api实体类。此实体类将被{@link CheckWorker}进行使用。
 *
 * <p>配置方式：通过{@link UpdateConfig#setCheckEntity(CheckEntity)}对复杂api数据进行定制，或者通过{@link UpdateConfig#setUrl(String)}对简单GET请求的更新api进行定制。
 */
public class RequestBean {

    private String method = "GET";
    private String url;
    private Map<String, String> params;
    private Map<String, String> headers;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getParams() {
        if (params == null) {
            params = new HashMap<>();
        }
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        if (headers == null) {
            headers = new HashMap<>();
        }
        this.headers = headers;
    }
}
