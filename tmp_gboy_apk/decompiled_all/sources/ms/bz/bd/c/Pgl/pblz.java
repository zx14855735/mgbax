package ms.bz.bd.c.Pgl;

import com.bytedance.sdk.openadsdk.api.plugin.hf;
import java.io.File;
import ms.bz.bd.c.Pgl.pbly;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class pblz extends pbly.pgla {
    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object A4TApA(String str, Object obj) {
        File file = new File(hf.xj(pblv.f14062A4TApA.f14063A2egSU), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9efb08", new byte[]{102, 106, 6, 18, 14, 59, 59}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }
}
