package com.fl.saas.base.base;

import android.content.Context;
import android.text.TextUtils;
import com.fl.saas.base.interfaces.AdViewListener;
import com.fl.saas.config.exception.YdError;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class BaseBuilder<T> implements AdViewListener {
    protected T builder;
    private final WeakReference<Context> contextRef;
    private String key;
    private int timeout = -1;

    public BaseBuilder(Context context) {
        this.contextRef = new WeakReference<>(context);
    }

    public T getBuilder() {
        return this.builder;
    }

    public WeakReference<Context> getContextRef() {
        return this.contextRef;
    }

    public String getKey() {
        return this.key;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public boolean isValid() {
        return (this.contextRef.get() == null || TextUtils.isEmpty(this.key)) ? false : true;
    }

    @Override // com.fl.saas.base.interfaces.AdViewListener
    public abstract void onAdFailed(YdError ydError);

    public T setKey(String str) {
        this.key = str;
        return this.builder;
    }

    public T setTimeOut(int i) {
        this.timeout = i;
        return this.builder;
    }
}
