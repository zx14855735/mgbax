package com.sigmob.sdk.videoplayer;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13776a = "URL_KEY_DEFAULT";
    public int b;
    public LinkedHashMap c;
    public HashMap<String, String> d;
    public boolean e;
    public String title;

    public g(Object obj) {
        this.c = new LinkedHashMap();
        this.title = "";
        this.d = new HashMap<>();
        this.e = false;
        this.c.put(f13776a, obj);
        this.b = 0;
    }

    public Object a() {
        return b(this.b);
    }

    public Object b() {
        return a(this.b);
    }

    public g c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.c);
        return new g(linkedHashMap, this.title);
    }

    public g(String str) {
        this.c = new LinkedHashMap();
        this.title = "";
        this.d = new HashMap<>();
        this.e = false;
        this.c.put(f13776a, str);
        this.b = 0;
    }

    public String a(int i) {
        int i2 = 0;
        for (Object obj : this.c.keySet()) {
            if (i2 == i) {
                return obj.toString();
            }
            i2++;
        }
        return null;
    }

    public Object b(int i) {
        int i2 = 0;
        for (Object obj : this.c.keySet()) {
            if (i2 == i) {
                return this.c.get(obj);
            }
            i2++;
        }
        return null;
    }

    public g(String str, String str2) {
        this.c = new LinkedHashMap();
        this.title = "";
        this.d = new HashMap<>();
        this.e = false;
        this.c.put(f13776a, str);
        this.title = str2;
        this.b = 0;
    }

    public boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.c.containsValue(obj);
    }

    public g(LinkedHashMap linkedHashMap) {
        this.c = new LinkedHashMap();
        this.title = "";
        this.d = new HashMap<>();
        this.e = false;
        this.c.clear();
        this.c.putAll(linkedHashMap);
        this.b = 0;
    }

    public g(LinkedHashMap linkedHashMap, String str) {
        this.c = new LinkedHashMap();
        this.title = "";
        this.d = new HashMap<>();
        this.e = false;
        this.c.clear();
        this.c.putAll(linkedHashMap);
        this.title = str;
        this.b = 0;
    }
}
