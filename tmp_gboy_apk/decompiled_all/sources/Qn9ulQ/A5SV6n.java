package Qn9ulQ;

import android.text.TextUtils;
import android.util.SparseArray;
import com.volcengine.mobsecBiz.matrix.pgla;
import ms.bz.bd.c.Pgl.m0;
import ms.bz.bd.c.Pgl.n0;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A5SV6n implements n0.pgla {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final m0 f7761A2egSU;

    public A5SV6n(m0 m0Var) {
        this.f7761A2egSU = m0Var;
    }

    public final void A2egSU(String str) {
        m0 m0Var = this.f7761A2egSU;
        if (m0Var.f14019A2egSU == -1 || TextUtils.isEmpty(str)) {
            return;
        }
        SparseArray sparseArray = pbly.f14067A2egSU;
        pgla.a(33554433, 0, m0Var.f14019A2egSU, str, m0Var.f14020A4TApA);
    }
}
