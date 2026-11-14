package com.kwad.sdk.api.model.liveModel;

import A5SV6n.A2egSU;
import ADYaiT.CtFAbx;
import java.io.Serializable;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class KsCouponInfo implements Serializable {
    private static final long serialVersionUID = 2072285066847893997L;
    private String displayBase;
    private String displayType;
    private String displayValue;
    private String endFetchTime;
    private String startFetchTime;

    public String getDisplayBase() {
        return this.displayBase;
    }

    public String getDisplayType() {
        return this.displayType;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }

    public String getEndFetchTime() {
        return this.endFetchTime;
    }

    public String getStartFetchTime() {
        return this.startFetchTime;
    }

    public void setDisplayBase(String str) {
        this.displayBase = str;
    }

    public void setDisplayType(String str) {
        this.displayType = str;
    }

    public void setDisplayValue(String str) {
        this.displayValue = str;
    }

    public void setEndFetchTime(String str) {
        this.endFetchTime = str;
    }

    public void setStartFetchTime(String str) {
        this.startFetchTime = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("KsCouponInfo{displayType='");
        sb.append(this.displayType);
        sb.append("', displayBase='");
        sb.append(this.displayBase);
        sb.append("', displayValue='");
        sb.append(this.displayValue);
        sb.append("', startFetchTime='");
        sb.append(this.startFetchTime);
        sb.append("', endFetchTime='");
        return CtFAbx.B25kr6(sb, this.endFetchTime, "'}");
    }
}
