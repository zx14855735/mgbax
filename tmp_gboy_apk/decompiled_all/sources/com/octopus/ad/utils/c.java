package com.octopus.ad.utils;

import B4ZgIw.AYUAbz;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.C;
import com.octopus.ad.DownloadService;
import com.octopus.ad.internal.activity.DownloadDialogActivity;
import com.octopus.ad.internal.q;
import com.octopus.ad.model.ComplianceInfo;
import com.octopus.ad.model.c;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f12702a;
    private WeakReference<Context> b;
    private com.octopus.ad.a.a c;
    private int d;
    private String e;
    private boolean f;
    private boolean g;
    private boolean h;
    private b i;
    private c.b j;
    private ComplianceInfo k;

    private c(Context context) {
        this.b = new WeakReference<>(context);
    }

    public static c a(Context context) {
        if (f12702a == null) {
            synchronized (c.class) {
                try {
                    if (f12702a == null) {
                        f12702a = new c(context);
                    }
                } finally {
                }
            }
        }
        return f12702a;
    }

    private boolean g() {
        b bVar = this.i;
        if (bVar == null) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.a())) {
            com.octopus.ad.utils.b.f.c("ApkDownloadManager", "apkUrl can not be empty!");
            return false;
        }
        if (TextUtils.isEmpty(this.i.b())) {
            com.octopus.ad.utils.b.f.c("ApkDownloadManager", "apkName can not be empty!");
            return false;
        }
        if (this.i.b().endsWith(".apk")) {
            return true;
        }
        com.octopus.ad.utils.b.f.c("ApkDownloadManager", "apkName must endsWith .apk!");
        return false;
    }

    public ComplianceInfo b() {
        return this.k;
    }

    public void c() {
        if (q.a().s() || this.f) {
            e();
            return;
        }
        try {
            if (this.b.get() != null) {
                Intent intent = new Intent(this.b.get(), (Class<?>) DownloadDialogActivity.class);
                intent.setFlags(C.ENCODING_PCM_MU_LAW);
                this.b.get().startActivity(intent);
                com.octopus.ad.a.a aVar = this.c;
                if (aVar != null) {
                    aVar.b();
                }
            }
        } catch (Exception e) {
            com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void d() {
        com.octopus.ad.a.a aVar = this.c;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void e() {
        if (g()) {
            try {
                if (this.b.get() != null) {
                    this.b.get().startService(new Intent(this.b.get(), (Class<?>) DownloadService.class));
                }
            } catch (Exception e) {
                com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
            }
        }
    }

    public void f() {
        f12702a = null;
        this.b = null;
    }

    public c b(Context context) {
        this.b = new WeakReference<>(context);
        return this;
    }

    public void b(boolean z) {
        c.b bVar = this.j;
        if (bVar != null) {
            if (z) {
                if (this.h) {
                    return;
                } else {
                    this.h = true;
                }
            } else if (this.g) {
                return;
            } else {
                this.g = true;
            }
            List<c.i> t = bVar.t();
            if (t != null) {
                for (int i = 0; i < t.size(); i++) {
                    c.i iVar = t.get(i);
                    if (iVar != null && !TextUtils.isEmpty(iVar.d())) {
                        String d = iVar.d();
                        if (d.contains("track=oct")) {
                            if (z) {
                                d = d.concat("&opt=5");
                            } else if (this.d != 0) {
                                StringBuilder A5SV6n2 = AYUAbz.A5SV6n(d, "&opt=");
                                A5SV6n2.append(this.d);
                                d = A5SV6n2.toString();
                            }
                        }
                        new com.octopus.ad.internal.i(d).execute();
                    }
                }
            }
        }
    }

    public c a(boolean z) {
        this.f = z;
        return this;
    }

    public b a() {
        return this.i;
    }

    public c a(b bVar) {
        this.i = bVar;
        return this;
    }

    public c a(int i) {
        this.d = i;
        return this;
    }

    public c a(c.b bVar) {
        this.j = bVar;
        return this;
    }

    public c a(ComplianceInfo complianceInfo) {
        this.k = complianceInfo;
        return this;
    }

    public c a(com.octopus.ad.a.a aVar) {
        this.c = aVar;
        return this;
    }

    public c a(String str) {
        if (!str.equals(this.e)) {
            this.g = false;
            this.h = false;
        }
        this.e = str;
        return this;
    }
}
