package com.fl.saas.config.exception;

import J3FDQU.A2egSU;
import android.text.TextUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class YdError {
    private int code;
    private int errorType;
    private String message;

    public YdError() {
    }

    public static YdError create(int i, int i2, String str) {
        return new YdError(i, i2, str);
    }

    public int getCode() {
        return this.code;
    }

    public int getErrorType() {
        return this.errorType;
    }

    public String getMsg() {
        return TextUtils.isEmpty(this.message) ? "" : this.message;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setErrorType(int i) {
        this.errorType = i;
    }

    public void setMsg(String str) {
        this.message = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{code=");
        sb.append(this.code);
        sb.append(", message='");
        sb.append(this.message);
        sb.append("', errorType=");
        return A2egSU.B2KMhB(sb, this.errorType, '}');
    }

    public YdError(int i, int i2, String str) {
        this.code = i;
        this.message = str;
        this.errorType = i2;
    }

    public static YdError create(int i, String str) {
        return new YdError(i, str);
    }

    public YdError(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public static YdError create(String str) {
        return new YdError(str);
    }

    public YdError(String str) {
        this.message = str;
    }
}
