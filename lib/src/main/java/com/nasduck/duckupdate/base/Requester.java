package com.nasduck.duckupdate.base;

import com.nasduck.duckupdate2.UpdateBuilder;
import com.nasduck.duckupdate2.bean.RequestBean;
import com.nasduck.duckupdate2.bean.ResponseBean;

public abstract class Requester implements Runnable {

    protected UpdateBuilder builder;

    public final void setBuilder(UpdateBuilder builder) {
        this.builder = builder;
    }

    @Override
    public void run() {
        try {
            onResponse(update(builder.getRequestBean()));
        } catch (Throwable t) {
            onError(t);
        }
    }

    protected String update(RequestBean request) throws Exception {
        throw new RuntimeException("UpdateBuilder.update must be implemented!");
    }

    public final void onResponse(String response) {
        try {
            ResponseParser jsonParser = builder.getResponseParser();
            ResponseBean responseBean = jsonParser.parse(response);
            if (responseBean == null) {
                throw new IllegalArgumentException("The response parser result is null");
            }
            if (builder.getUpdateChecker().check(responseBean)) {
                sendHasUpdate(responseBean);
            } else {
                sendNoUpdate();
            }
        } catch (Throwable t) {
            onError(t);
        }
    }

    public final void onError(Throwable t) {
        sendOnErrorMsg(t);
    }

    private void sendHasUpdate(final ResponseBean update) {
        if (builder.getUpdateCallBack() == null) return;
        Utils.getMainHandler().post(new Runnable() {
            @Override
            public void run() {
                if (builder.getUpdateCallBack() == null) return;
                builder.getUpdateCallBack().onNewUpdate(update);
            }
        });
    }

    private void sendNoUpdate() {
        if (builder.getUpdateCallBack() == null) return;
        Utils.getMainHandler().post(new Runnable() {
            @Override
            public void run() {
                if (builder.getUpdateCallBack() == null) return;
                builder.getUpdateCallBack().onNoUpdate();
            }
        });
    }

    private void sendOnErrorMsg(final Throwable t) {
        if (builder.getUpdateCallBack() == null) return;
        Utils.getMainHandler().post(new Runnable() {
            @Override
            public void run() {
                if (builder.getUpdateCallBack() == null) return;
                builder.getUpdateCallBack().onUpdateError(t);
            }
        });
    }

}
