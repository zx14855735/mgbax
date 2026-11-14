package com.fl.saas.common.listener;

import com.fl.saas.common.saas.bean.AdPlace;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface ApiSaaSListener {
    void onFailed(String str);

    void onSuccess(AdPlace adPlace);
}
