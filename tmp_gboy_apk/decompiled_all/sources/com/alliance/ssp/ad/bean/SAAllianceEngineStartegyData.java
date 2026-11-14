package com.alliance.ssp.ad.bean;

import A5SV6n.A2egSU;
import java.util.List;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class SAAllianceEngineStartegyData {
    private List<SAAllianceAdStrategyData> data;
    private String message;
    private boolean flag = false;
    private int code = 0;

    public int getCode() {
        return this.code;
    }

    public List<SAAllianceAdStrategyData> getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isFlag() {
        return this.flag;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setData(List<SAAllianceAdStrategyData> list) {
        this.data = list;
    }

    public void setFlag(boolean z) {
        this.flag = z;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
