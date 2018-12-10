package com.nasduck.duckupdate.base;

import com.nasduck.duckupdate2.bean.ResponseBean;

import java.io.File;

public interface UpdateCallBack {

    void onUpdateStart();

    void onNewUpdate(ResponseBean responseBean);

    void onNoUpdate();

    void onUpdateError(Throwable t);

   // void onUpdateCancel();

    /**
     * 当用户点击忽略此版本更新时触发到此回调中。触发入口在{@link CheckNotifier#sendUserIgnore()}和{@link InstallNotifier#sendCheckIgnore()}
     *
     * <p>回调线程：UI
     * @param update Update entity
     */
    //void onCheckIgnore(Update update);

    void onDownloadStart();

    void onDownloadComplete(File file);

    void onDownloadProgress(long current, long total);

    void onDownloadError(Throwable t);

}
