package com.fl.saas.base.manager.api;

import com.fl.saas.base.base.BaseBuilder;
import com.fl.saas.base.interfaces.PreloadDoneCallback;
import com.fl.saas.common.saas.bean.AdPlace;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface ManagerAPI<T extends BaseBuilder<?>> extends ManagerInfoAPI {
    void preload(T t, AdPlace adPlace, PreloadDoneCallback preloadDoneCallback);

    void request(T t);
}
