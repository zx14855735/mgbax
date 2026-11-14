package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.sdk.internal.cb;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class cd extends Handler {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cb f9781a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cd(cb cbVar, Looper looper) {
        super(looper);
        this.f9781a = cbVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        bv bvVar;
        boolean z;
        Context context;
        bv bvVar2;
        boolean z2;
        boolean p;
        String string = message.getData().getString(cb.n);
        bz bzVar = (bz) message.getData().getParcelable(cb.m);
        if (!cb.k.equals(string)) {
            bvVar = this.f9781a.z;
            bvVar.a(cb.f9778a, "mOnApkDownloadCompleted: download failed, code: " + string);
            this.f9781a.a(false);
            z = this.f9781a.A;
            if (z) {
                this.f9781a.A = false;
                this.f9781a.a(false, "Refused to download remote for version...");
                return;
            }
            return;
        }
        String e = bzVar.e();
        context = this.f9781a.y;
        bu buVar = new bu(e, context, bzVar);
        try {
            try {
                cb cbVar = this.f9781a;
                if (cbVar.u == cb.t) {
                    buVar.a();
                    buVar.a(cb.f());
                    if (cb.p != null) {
                        cb.p.b = bzVar.b();
                    }
                    this.f9781a.l();
                    z2 = this.f9781a.A;
                    if (z2) {
                        this.f9781a.A = false;
                        cb cbVar2 = this.f9781a;
                        p = cbVar2.p();
                        cbVar2.a(p, "load remote file just downloaded");
                    }
                } else {
                    cbVar.a(buVar);
                    buVar.a(cb.f());
                    this.f9781a.a(true);
                }
            } catch (cb.a e2) {
                String str = "download apk file failed: " + e2.toString();
                this.f9781a.a(false);
                bvVar2 = this.f9781a.z;
                bvVar2.a(cb.f9778a, str);
            }
            buVar.delete();
        } catch (Throwable th) {
            buVar.delete();
            throw th;
        }
    }
}
