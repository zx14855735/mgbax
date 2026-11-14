package com.octopus.ad.internal;

import android.os.Handler;
import com.octopus.ad.internal.utilities.HTTPGet;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    private int f12523a = 0;
    private final String b;
    private final String c;
    private final String d;
    private final long e;
    private final String f;
    private boolean g;
    private HTTPGet.ResponseListener h;

    public u(String str, String str2, String str3, long j, String str4, boolean z) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = j;
        this.f = str4;
        this.g = z;
    }

    public static /* synthetic */ int c(u uVar) {
        int i = uVar.f12523a;
        uVar.f12523a = i - 1;
        return i;
    }

    public void a(HTTPGet.ResponseListener responseListener) {
        this.h = responseListener;
    }

    public void a() {
        i iVar = new i(this.f);
        if (this.g) {
            iVar.a(new HTTPGet.ResponseListener() { // from class: com.octopus.ad.internal.u.1
                @Override // com.octopus.ad.internal.utilities.HTTPGet.ResponseListener
                public void getResponse(int i, boolean z, String str) {
                    if (z) {
                        if (u.this.h != null) {
                            u.this.h.getResponse(i, z, str);
                            return;
                        }
                        return;
                    }
                    if (u.this.f12523a > 0) {
                        new Handler().postDelayed(new Runnable() { // from class: com.octopus.ad.internal.u.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                u.this.a();
                                u.c(u.this);
                            }
                        }, 200L);
                    }
                    if (u.this.f12523a == 0) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("url", u.this.f);
                            jSONObject.put("http_status_code", i);
                            u.this.a(jSONObject.toString());
                        } catch (Exception e) {
                            com.octopus.ad.utils.b.f.a("OctopusAd", "An Exception Caught", e);
                        }
                    }
                }
            });
        } else {
            HTTPGet.ResponseListener responseListener = this.h;
            if (responseListener != null) {
                responseListener.getResponse(200, true, "");
            }
        }
        iVar.execute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        o.a(new l("IMP".equals(this.b) ? "IMPFALL" : "CLKFALL", this.c, this.d, System.currentTimeMillis() - this.e, str));
    }
}
