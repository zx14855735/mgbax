package com.sigmob.sdk.mraid2;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private final View f13570a;

    public w(View view) {
        this.f13570a = view;
    }

    public int a() {
        return this.f13570a.getLayoutParams().height;
    }

    public int b() {
        return this.f13570a.getLayoutParams().width;
    }

    public void a(int i) {
        this.f13570a.getLayoutParams().height = i;
        this.f13570a.requestLayout();
    }

    public void b(int i) {
        this.f13570a.getLayoutParams().width = i;
        this.f13570a.requestLayout();
    }
}
