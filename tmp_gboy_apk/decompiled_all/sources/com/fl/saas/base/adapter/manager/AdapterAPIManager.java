package com.fl.saas.base.adapter.manager;

import com.fl.saas.base.base.AdapterAPI;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdapterAPIManager<T extends AdapterAPI> extends APIManager<T> {
    public AdapterAPIManager(Class<T> cls) {
        super(cls);
    }

    @Override // com.fl.saas.base.adapter.manager.APIManager
    public Class<?> registerClass() {
        return AdapterAPI.class;
    }
}
