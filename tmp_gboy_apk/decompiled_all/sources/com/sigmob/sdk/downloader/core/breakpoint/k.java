package com.sigmob.sdk.downloader.core.breakpoint;

import android.util.SparseArray;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, Integer> f13356a;
    private final SparseArray<String> b;

    public k() {
        this(new HashMap(), new SparseArray());
    }

    public Integer a(com.sigmob.sdk.downloader.f fVar) {
        Integer num = this.f13356a.get(b(fVar));
        if (num != null) {
            return num;
        }
        return null;
    }

    public String b(com.sigmob.sdk.downloader.f fVar) {
        return fVar.i() + fVar.h() + fVar.d();
    }

    public k(HashMap<String, Integer> hashMap, SparseArray<String> sparseArray) {
        this.f13356a = hashMap;
        this.b = sparseArray;
    }

    public void a(int i) {
        String str = this.b.get(i);
        if (str != null) {
            this.f13356a.remove(str);
            this.b.remove(i);
        }
    }

    public void a(com.sigmob.sdk.downloader.f fVar, int i) {
        String b = b(fVar);
        this.f13356a.put(b, Integer.valueOf(i));
        this.b.put(i, b);
    }
}
