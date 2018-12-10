package com.nasduck.duckupdate;

import com.nasduck.duckupdate2.base.UpdateCallBack;
import com.nasduck.duckupdate2.base.UpdateChecker;
import com.nasduck.duckupdate2.bean.RequestBean;
import com.nasduck.duckupdate2.base.ResponseParser;

public class UpdateBuilder {

    private UpdateConfig config;

    private RequestBean requestBean;
    private ResponseParser responseParser;
    private UpdateChecker updateChecker;
    private UpdateCallBack updateCallBack;

    private UpdateBuilder(UpdateConfig config) {
        this.config = config;
        //callbackDelegate = new CallbackDelegate();
        //callbackDelegate.setCheckDelegate(config.getCheckCallback());
        //callbackDelegate.setDownloadDelegate(config.getDownloadCallback());
    }

    public static UpdateBuilder builder() {
        return create(UpdateConfig.getConfig());
    }

    public static UpdateBuilder create(UpdateConfig config) {
        return new UpdateBuilder(config);
    }

    /**
     * 启动更新任务。可在任意线程进行启动。
     */
    public void update() {
        //Launcher.getInstance().launchCheck(this);
    }

    public RequestBean getRequestBean() {
        if (this.requestBean == null) {
            this.requestBean = config.getCheckEntity();
        }
        return requestBean;
    }

    public void setRequestBean(RequestBean requestBean) {
        this.requestBean = requestBean;
    }

    public ResponseParser getResponseParser() {
        if (responseParser == null) {
            responseParser = config.getUpdateParser();
        }
        return responseParser;
    }

    public void setResponseParser(ResponseParser responseParser) {
        this.responseParser = responseParser;
    }

    public UpdateChecker getUpdateChecker() {
        if (updateChecker == null) {
            updateChecker = config.getUpdateChecker();
        }
        return updateChecker;
    }

    public void setUpdateChecker(UpdateChecker updateChecker) {
        this.updateChecker = updateChecker;
    }

    public UpdateCallBack getUpdateCallBack() {
        return updateCallBack;
    }

    public void setUpdateCallBack(UpdateCallBack updateCallBack) {
        this.updateCallBack = updateCallBack;
    }
}
