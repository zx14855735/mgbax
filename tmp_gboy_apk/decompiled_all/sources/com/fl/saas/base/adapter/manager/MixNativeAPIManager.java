package com.fl.saas.base.adapter.manager;

import com.fl.saas.base.adapter.MixNativeAPI;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MixNativeAPIManager<T extends MixNativeAPI> extends APIManager<T> {
    public MixNativeAPIManager(Class<T> cls) {
        super(cls);
    }

    @Override // com.fl.saas.base.adapter.manager.APIManager
    public Class<?> registerClass() {
        return MixNativeAPI.class;
    }
}
