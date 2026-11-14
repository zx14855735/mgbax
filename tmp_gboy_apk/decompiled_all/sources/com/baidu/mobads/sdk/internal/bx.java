package com.baidu.mobads.sdk.internal;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.sdk.internal.cb;
import com.baidu.mobads.sdk.internal.ck;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class bx extends Thread {
    private static final String b = "ApkDownloadThread";
    private static final int c = 900000;
    private static volatile bx h;
    private volatile String d;
    private String e;
    private double f;
    private Handler g;
    private final Context i;
    private final bz k;
    private ck j = null;
    private bv l = bv.a();

    /* renamed from: a, reason: collision with root package name */
    ck.a f9773a = new by(this);

    private bx(Context context, bz bzVar, String str, Handler handler) {
        this.e = null;
        this.i = context;
        this.k = bzVar;
        a(bzVar.c());
        this.g = handler;
        this.e = str;
    }

    private boolean b() {
        try {
            try {
                this.j = new ck(this.i, new URL(this.d), this.k, this.f9773a);
            } catch (MalformedURLException unused) {
                this.j = new ck(this.i, this.d, this.k, this.f9773a);
            }
            double d = cb.q != null ? cb.q.b : cb.p != null ? cb.p.b > 0.0d ? cb.p.b : cb.p.b : 0.0d;
            this.l.a(b, "isNewApkAvailable: local apk version is: " + d + ", remote apk version: " + this.k.b());
            if (d > 0.0d) {
                if (this.k.b() <= 0.0d) {
                    this.l.a(b, "remote is null, local apk version is null, do not upgrade");
                    return false;
                }
                this.l.a(b, "remote not null, local apk version is null, force upgrade");
                this.f = this.k.b();
                return true;
            }
            if (this.k.b() > 0.0d) {
                if (this.k.b() <= d) {
                    return false;
                }
                this.f = this.k.b();
                return true;
            }
            this.l.a(b, "remote apk version is: null, local apk version is: " + d + ", do not upgrade");
            return false;
        } catch (Exception e) {
            String str = "parse apk failed, error:" + e.toString();
            this.l.a(b, str);
            throw new cb.a(str);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                try {
                    a();
                    this.l.a(b, "download apk successfully, downloader exit");
                    h = null;
                } catch (IOException e) {
                    this.l.a(b, "create File or HTTP Get failed, exception: " + e.getMessage());
                }
                this.l.a(b, "no newer apk, downloader exit");
                h = null;
            }
        } catch (Throwable unused) {
        }
    }

    public static bx a(Context context, bz bzVar, String str, Handler handler) {
        if (h == null) {
            h = new bx(context, bzVar, str, handler);
        }
        return h;
    }

    public void a(String str) {
        this.d = str;
        interrupt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, bz bzVar, String str2) {
        if (str.equals(cb.k) || str.equals(cb.l)) {
            Message obtainMessage = this.g.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putParcelable(cb.m, bzVar);
            bundle.putString(cb.n, str);
            obtainMessage.setData(bundle);
            this.g.sendMessage(obtainMessage);
        }
    }

    private String a() {
        String str = "__xadsdk__remote__final__" + UUID.randomUUID().toString() + ".jar";
        String B25kr62 = CtFAbx.B25kr6(new StringBuilder(), this.e, str);
        File file = new File(B25kr62);
        try {
            file.createNewFile();
            this.j.a(this.e, str);
            return B25kr62;
        } catch (IOException e) {
            file.delete();
            throw e;
        }
    }
}
