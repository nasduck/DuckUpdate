package com.nasduck.duckupdate11111.base;

import com.nasduck.duckupdate11111.bean.ResponseBean;

public abstract class UpdateChecker {

    public abstract boolean check(ResponseBean bean) throws Exception;
}

