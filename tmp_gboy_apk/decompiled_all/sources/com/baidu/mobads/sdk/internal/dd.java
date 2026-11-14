package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CPUDramaListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class dd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IOAdEvent f9815a;
    final /* synthetic */ dc b;

    public dd(dc dcVar, IOAdEvent iOAdEvent) {
        this.b = dcVar;
        this.f9815a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        CPUDramaListener cPUDramaListener;
        String str;
        CPUDramaListener cPUDramaListener2;
        CPUDramaListener cPUDramaListener3;
        IOAdEvent iOAdEvent = this.f9815a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f9815a.getType();
        cPUDramaListener = this.b.f9814a.s;
        if (cPUDramaListener == null) {
            return;
        }
        if ("onContentLoaded".equals(type)) {
            cPUDramaListener3 = this.b.f9814a.s;
            cPUDramaListener3.onContentLoaded();
            return;
        }
        if (!"onContentFailed".equals(type)) {
            if (x.as.equals(type)) {
                this.b.f9814a.l(this.f9815a);
                return;
            } else {
                if (x.at.equals(type)) {
                    this.b.f9814a.m(this.f9815a);
                    return;
                }
                return;
            }
        }
        HashMap hashMap = (HashMap) this.f9815a.getData();
        int i = 0;
        if (hashMap != null) {
            str = (String) hashMap.get("error_message");
            Object obj = hashMap.get("error_code");
            if (obj == null) {
                obj = 0;
            }
            i = ((Integer) obj).intValue();
        } else {
            str = "";
        }
        cPUDramaListener2 = this.b.f9814a.s;
        cPUDramaListener2.onContentFailed(i, str);
    }
}
