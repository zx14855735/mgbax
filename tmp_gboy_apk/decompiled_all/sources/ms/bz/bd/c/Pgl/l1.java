package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class l1 {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static l1 f14016A5SV6n;

    /* renamed from: A2egSU, reason: collision with root package name */
    public Context f14017A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public ArrayList f14018A4TApA;

    public static l1 A5SV6n(Context context) {
        if (f14016A5SV6n == null) {
            synchronized (l1.class) {
                try {
                    if (f14016A5SV6n == null) {
                        l1 l1Var = new l1();
                        l1Var.f14017A2egSU = null;
                        l1Var.f14018A4TApA = new ArrayList();
                        l1Var.f14017A2egSU = context;
                        f14016A5SV6n = l1Var;
                    }
                } finally {
                }
            }
        }
        return f14016A5SV6n;
    }

    public final int A2egSU() {
        Intent registerReceiver = this.f14017A2egSU.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "034497", new byte[]{32, 63, 67, 82, 9, 41, com.sigmob.sdk.archives.tar.e.O, 92, 108, 106, com.sigmob.sdk.archives.tar.e.M, com.sigmob.sdk.archives.tar.e.L, 73, 84, 72, 33, com.sigmob.sdk.archives.tar.e.H, 6, 108, 107, 47, Byte.MAX_VALUE, 101, 97, com.sigmob.sdk.archives.tar.e.J, 20, 22, 32, 92, 91, 2, 25, 102, 110, 33, 5, 23})));
        if (registerReceiver == null) {
            return -1;
        }
        return registerReceiver.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b9faad", new byte[]{99, com.sigmob.sdk.archives.tar.e.O, 0, 18, 89, 118, 101}), -1);
    }

    public final int A4TApA() {
        if (this.f14017A2egSU.registerReceiver(null, new IntentFilter((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f6668b", new byte[]{118, 58, 65, 80, 8, 124, 97, 89, 110, 104, 99, com.sigmob.sdk.archives.tar.e.I, 75, 86, 73, 116, 102, 3, 110, 105, 121, 122, com.sigmob.sdk.archives.tar.e.T, 99, com.sigmob.sdk.archives.tar.e.K, 65, 64, 37, 94, 89, 84, 28, 100, 108, 32, 80, 65}))) == null) {
            return -1;
        }
        return Math.round(((r1.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "34228b", new byte[]{46, com.sigmob.sdk.archives.tar.e.K, 87, 67, 11}), -1) / r1.getIntExtra((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cb09c5", new byte[]{97, 99, 66, 65, 89}), -1)) * 100.0f) * 10.0f) / 10;
    }
}
