package com.baidu.mobads.sdk.internal.a;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface a extends IOAdEvent {
    IAdInterListener getDelegator();

    Object handleEvent(String str, String str2, Object[] objArr);
}
