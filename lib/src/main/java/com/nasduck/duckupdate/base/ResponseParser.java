package com.nasduck.duckupdate.base;

import com.nasduck.duckupdate2.bean.ResponseBean;

/**
 * 此类用于解析通过{@link Requester}访问的地址返回的数据。解析出框架所需的{@link ResponseBean}实体类数据并提供给框架内部各处使用
 *
 * <p>配置方式：通过{@link UpdateConfig#setUpdateParser(UpdateParser)}或者{@link UpdateBuilder#setUpdateParser(ResponseParser)}
 *
 * @author haoge
 */
public abstract class ResponseParser {

    /**
     * 当更新api网络任务请求成功时。将会触发到此，在此根据网络数据解析创建出对应的更新数据实体类并返回给框架层使用。
     *
     * @param response 更新api返回数据。
     * @return 被创建的更新数据实体类。不能为null
     * @throws Exception 捕获异常。防止crash并统一异常流程
     */
    public abstract ResponseBean parse(String response) throws Exception;
}

