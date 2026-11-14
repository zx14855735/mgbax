package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.internal.bj;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class bm implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IOAdEvent f9762a;
    final /* synthetic */ bj.a b;

    public bm(bj.a aVar, IOAdEvent iOAdEvent) {
        this.b = aVar;
        this.f9762a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap hashMap;
        IOAdEvent iOAdEvent = this.f9762a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f9762a.getType();
        if (x.K.equals(type)) {
            bj.this.a(this.f9762a);
            return;
        }
        if (x.N.equals(type)) {
            bj.this.n = this.f9762a.getMessage();
            bj.this.q();
            return;
        }
        if (x.O.equals(type)) {
            bj.this.e(this.f9762a);
            return;
        }
        if (x.P.equals(type)) {
            bj.this.f(this.f9762a);
            return;
        }
        if (x.X.equals(type)) {
            bj.this.g(this.f9762a);
            return;
        }
        String str = "";
        int i = 0;
        int i2 = 0;
        r5 = false;
        boolean z = false;
        if (x.s.equals(type)) {
            HashMap hashMap2 = (HashMap) this.f9762a.getData();
            if (hashMap2 != null) {
                str = (String) hashMap2.get("error_message");
                Object obj = hashMap2.get("error_code");
                Object obj2 = obj;
                if (obj == null) {
                    obj2 = 0;
                }
                i = ((Integer) obj2).intValue();
            }
            bj.this.b(str, i);
            return;
        }
        if (x.M.equals(type)) {
            HashMap hashMap3 = (HashMap) this.f9762a.getData();
            if (hashMap3 != null) {
                str = (String) hashMap3.get("error_message");
                Object obj3 = hashMap3.get("error_code");
                Object obj4 = obj3;
                if (obj3 == null) {
                    obj4 = 0;
                }
                i2 = ((Integer) obj4).intValue();
            }
            bj.this.a(i2, str);
            return;
        }
        if (x.I.equals(type)) {
            bj.this.h(this.f9762a);
            return;
        }
        if (x.Y.equals(type)) {
            bj.this.d();
            return;
        }
        if (x.Z.equals(type)) {
            bj.this.d(this.f9762a);
            return;
        }
        if (x.ab.equals(type)) {
            bj.this.s();
            return;
        }
        if (x.ac.equals(type)) {
            IOAdEvent iOAdEvent2 = this.f9762a;
            if (iOAdEvent2 != null && (hashMap = (HashMap) iOAdEvent2.getData()) != null) {
                z = "1".equals((String) hashMap.get("serverVerify"));
            }
            bj.this.b(z);
            return;
        }
        if (x.ad.equals(type)) {
            bj.this.b_();
            return;
        }
        if (x.ae.equals(type)) {
            bj.this.c_();
            return;
        }
        if (x.L.equals(type)) {
            bj.this.b(this.f9762a);
            return;
        }
        if (x.af.equals(type)) {
            bj.this.a(this.f9762a.getMessage(), 1 == this.f9762a.getCode());
            return;
        }
        if (x.ag.equals(type)) {
            bj.this.e(this.f9762a.getMessage());
            return;
        }
        if (x.ah.equals(type)) {
            bj.this.f(this.f9762a.getMessage());
            return;
        }
        if (x.ai.equals(type)) {
            bj.this.d(this.f9762a.getMessage());
            return;
        }
        if (x.E.equals(type)) {
            bj.this.g(this.f9762a.getMessage());
            return;
        }
        if (x.aa.equals(type)) {
            bj.this.t();
            return;
        }
        if (x.aj.equals(type)) {
            bj.this.b(this.f9762a.getMessage(), 1 == this.f9762a.getCode());
            return;
        }
        if (x.am.equals(type)) {
            bj.this.c(this.f9762a);
            return;
        }
        if (x.ak.equals(type)) {
            bj.this.u();
            return;
        }
        if (x.al.equals(type)) {
            bj.this.v();
            return;
        }
        if (x.ao.equals(type)) {
            bj.this.i(this.f9762a);
        } else if (x.ap.equals(type)) {
            bj.this.j(this.f9762a);
        } else if (x.an.equals(type)) {
            bj.this.k(this.f9762a);
        }
    }
}
