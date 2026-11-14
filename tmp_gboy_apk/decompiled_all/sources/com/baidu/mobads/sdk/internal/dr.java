package com.baidu.mobads.sdk.internal;

import android.os.CountDownTimer;
import android.widget.TextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class dr extends CountDownTimer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ dp f9829a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dr(dp dpVar, long j, long j2) {
        super(j, j2);
        this.f9829a = dpVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f9829a.b.a("CountDownTimer finished");
        this.f9829a.c();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        TextView textView;
        int i = (int) (j / 1000);
        if (i > 5) {
            i = 5;
        }
        textView = this.f9829a.d;
        textView.setText(String.valueOf(i));
    }
}
