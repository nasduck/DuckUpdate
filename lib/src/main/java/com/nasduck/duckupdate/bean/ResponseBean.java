package com.nasduck.duckupdate.bean;

/**
 * 此实体类用于存储框架所需的更新数据。
 */
public class ResponseBean {

    private boolean forced;
    private boolean ignore;
    private String updateContent;
    private String updateUrl;
    private int versionCode;
    private String versionName;
    private String md5;

    public boolean isForced() {
        return forced;
    }

    public void setForced(boolean forced) {
        this.forced = forced;
    }

    public boolean isIgnore() {
        return ignore;
    }

    public void setIgnore(boolean ignore) {
        this.ignore = ignore;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public String toString() {
        return "UpdateResponseBean{" +
                "forced=" + forced +
                ", ignore=" + ignore +
                ", updateContent='" + updateContent + '\'' +
                ", updateUrl='" + updateUrl + '\'' +
                ", versionCode=" + versionCode +
                ", versionName='" + versionName + '\'' +
                ", md5='" + md5 + '\'' +
                '}';
    }
}
