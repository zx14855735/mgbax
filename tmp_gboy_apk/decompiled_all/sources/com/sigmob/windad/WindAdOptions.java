package com.sigmob.windad;

import com.sigmob.sdk.base.utils.o;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class WindAdOptions {

    /* renamed from: a, reason: collision with root package name */
    private String f13782a;
    private String b;
    private HashMap<String, String> c;
    private WindCustomController d;

    public WindAdOptions(String str, String str2) {
        if (o.b(str)) {
            this.f13782a = str.trim();
        }
        this.b = str2;
    }

    public String getAppId() {
        return this.f13782a;
    }

    public String getAppKey() {
        return this.b;
    }

    public WindCustomController getCustomController() {
        return this.d;
    }

    public HashMap<String, String> getExtData() {
        return this.c;
    }

    public WindAdOptions setCustomController(WindCustomController windCustomController) {
        this.d = windCustomController;
        return this;
    }

    public WindAdOptions setExtData(HashMap<String, String> hashMap) {
        this.c = hashMap;
        return this;
    }
}
