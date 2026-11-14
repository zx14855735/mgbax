package com.fl.saas.base.manager.api;

import com.fl.saas.base.interfaces.AdLoadEvent;
import com.fl.saas.config.exception.YdError;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface FailedLoader extends AdLoadEvent {
    boolean isFailedCallBack();

    void onAdFailed(YdError ydError);
}
