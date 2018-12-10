package com.nasduck.duckupdate;

import com.nasduck.duckupdate2.base.Requester;
import com.nasduck.duckupdate2.base.ResponseParser;

public class UpdateConfig {

    private Requester httpWorker;
    private String url;
    private ResponseParser responseParser;
    /**
    private Class<? extends DownloadWorker> downloadWorker;
    private CheckEntity entity;
    private UpdateStrategy updateStrategy;
    private CheckNotifier checkNotifier;
    private InstallNotifier installNotifier;
    private DownloadNotifier downloadNotifier;
    private FileCreator fileCreator;
    private UpdateChecker updateChecker;
    private FileChecker fileChecker;
    private InstallStrategy installStrategy;
    private ExecutorService executor;
    private CheckCallback checkCallback;
    private DownloadCallback downloadCallback;
     **/

    private static UpdateConfig DEFAULT;

    /**
     * 获取一个全局默认的更新配置。正常情况下，使用的即是此默认的更新配置。
     *
     * <p>当使用{@link UpdateBuilder#update()}建立新的更新任务时，则将使用此默认的更新配置进行默认配置提供
     * @return 默认的更新配置。
     */
    public static UpdateConfig instance() {
        if (DEFAULT == null) {
            DEFAULT = new UpdateConfig();
        }
        return DEFAULT;
    }

    public UpdateConfig setUrl(String url) {
        this.url = url;
        return this;
    }

    public ResponseParser getResponseParser() {
        return responseParser;
    }

    public void setResponseParser(ResponseParser responseParser) {
        this.responseParser = responseParser;
    }

    public Requester getRequester() {
        return httpWorker;
    }
}
