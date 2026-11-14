package com.bykv.vk.component.ttvideo.log;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.kuaishou.weapon.p0.t;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public a f10014a;
    public String b;
    public String g;
    public String c = "";
    public String d = "";
    public String e = "";
    public int h = Integer.MIN_VALUE;
    public String f = com.bykv.vk.component.ttvideo.utils.b.a(null);

    public c(a aVar, Context context) {
        this.f10014a = aVar;
    }

    public void a() {
        b();
    }

    public void b() {
        Map versionInfo;
        a aVar = this.f10014a;
        if (aVar == null || (versionInfo = aVar.versionInfo()) == null) {
            return;
        }
        this.c = (String) versionInfo.get(t.x);
        this.d = (String) versionInfo.get("sv");
        this.e = (String) versionInfo.get(PluginConstants.KEY_SDK_VERSION);
    }

    public void a(String str) {
        this.b = str;
        this.f = com.bykv.vk.component.ttvideo.utils.b.b(str);
    }

    public void b(String str) {
    }
}
