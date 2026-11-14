package com.bykv.vk.openvk.api.proto;

import android.annotation.TargetApi;
import android.content.Context;

@TargetApi(24)
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface Initializer {
    Manager getManager();

    void init(Context context, ValueSet valueSet);

    boolean isInitSuccess();
}
