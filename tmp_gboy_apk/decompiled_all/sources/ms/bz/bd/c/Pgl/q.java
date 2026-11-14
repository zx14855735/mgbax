package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.sdk.openadsdk.api.plugin.hf;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class q extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        Context context = pblv.f14062A4TApA.f14063A2egSU;
        String[] split = str.split((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3a0c32", new byte[]{30, Byte.MAX_VALUE}));
        String str2 = split[0];
        String str3 = split[1];
        SharedPreferences.Editor edit = hf.hf(context, str2, 0).edit();
        edit.putString(str3, (String) obj);
        edit.commit();
        return null;
    }
}
