package ms.bz.bd.c.Pgl;

import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.sdk.component.utils.pl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class o1 extends pblw {

    /* renamed from: A4TApA, reason: collision with root package name */
    public SDKMonitor f14032A4TApA;

    final class pgla implements SDKMonitor.IGetExtendParams {
    }

    @Override // ms.bz.bd.c.Pgl.pblw
    public final void A5SV6n(long j, long j2, String str, String str2, int i) {
        SDKMonitor sDKMonitor = this.f14032A4TApA;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorApiError(j, j2, str, (String) null, str2, i, (JSONObject) null);
    }

    @Override // ms.bz.bd.c.Pgl.pblw
    public final void ADYaiT(long j, long j2, String str, String str2, int i) {
        SDKMonitor sDKMonitor = this.f14032A4TApA;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorSLA(j, j2, str, (String) null, str2, i, (JSONObject) null);
    }

    @Override // ms.bz.bd.c.Pgl.pblw
    public final void AMqCpz(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "28895c", new byte[]{16, com.sigmob.sdk.archives.tar.e.N, 74, 95, 14, 117, 35, 60, Byte.MAX_VALUE, 108, 45, 46, com.sigmob.sdk.archives.tar.e.T, 66, 13, 89, com.sigmob.sdk.archives.tar.e.H, 23, 104, 110, 38, 40, 11, 94, 15, 102, 39, 16, 106, 108, 45, 59, 70, 72, 74, 57, 124, 84, 41});
        if (this.f14032A4TApA == null) {
            return;
        }
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "218b31", new byte[]{com.sigmob.sdk.archives.tar.e.H, com.sigmob.sdk.archives.tar.e.N, 89, 0, 5, 37, com.sigmob.sdk.archives.tar.e.L, 30, 104, 63, 38}), str);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d7d139", new byte[]{118, com.sigmob.sdk.archives.tar.e.L, 3, 64, 11, 33, 117, 15}), jSONObject);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4e2978", new byte[]{40, 98, 85, 95, 1, 44}), jSONObject2);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "157b25", new byte[]{44, 56, 67, com.sigmob.sdk.archives.tar.e.K, 21, com.sigmob.sdk.archives.tar.e.N, 32}), jSONObject3);
            pl.u((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1d042f", new byte[]{13, 67, 119, 97, 62, 84, 17}), jSONObject4.toString());
        } catch (JSONException e) {
            pl.xj(e);
        }
        if (jSONObject.length() > 0 || jSONObject2.length() > 0) {
            this.f14032A4TApA.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0028 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // ms.bz.bd.c.Pgl.pblw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean ARc23Z(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.o1.ARc23Z(java.lang.String):boolean");
    }
}
