package com.fl.saas.base.manager.api;

import com.fl.saas.base.interfaces.PreloadDoneCallback;
import com.fl.saas.common.saas.bean.AdPlace;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface LoadAPI {
    void preload(AdPlace adPlace, PreloadDoneCallback preloadDoneCallback);

    void request(String str);
}
