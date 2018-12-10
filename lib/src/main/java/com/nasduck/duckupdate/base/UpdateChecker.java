package com.nasduck.duckupdate.base;

import com.nasduck.duckupdate2.bean.ResponseBean;

public abstract class UpdateChecker {

    public abstract boolean check(ResponseBean bean) throws Exception;
}

