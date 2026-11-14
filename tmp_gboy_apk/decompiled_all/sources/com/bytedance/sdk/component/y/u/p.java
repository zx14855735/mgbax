package com.bytedance.sdk.component.y.u;

import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class p extends xj {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // com.bytedance.sdk.component.y.u.d
    public void xj(com.bytedance.sdk.component.y.w.w wVar) {
        com.bytedance.sdk.component.y.w.w wVar2;
        final com.bytedance.sdk.component.y.w.y pl2 = wVar.pl();
        com.bytedance.sdk.component.y.kd u = pl2.u();
        wVar.xj(false);
        try {
            com.bytedance.sdk.component.y.c call = u.call(new com.bytedance.sdk.component.y.hf.w(wVar.getUrl(), wVar.y(), wVar.c(), wVar.qt()));
            int hf = call.hf();
            wVar.xj(call.xj());
            wVar2 = 200;
            try {
                if (call.hf() != 200) {
                    pl2.f();
                    String.valueOf(call);
                    Object w = call.w();
                    xj(hf, call.u(), w instanceof Throwable ? (Throwable) w : null, wVar);
                    return;
                }
                final byte[] bArr = (byte[]) call.w();
                wVar.xj(new hf(bArr, call));
                final String rawCacheKey = wVar.getRawCacheKey();
                final com.bytedance.sdk.component.y.hf g = wVar.g();
                if (g.isRawMemoryCache()) {
                    pl2.hf(wVar.g()).xj(rawCacheKey, bArr);
                }
                final com.bytedance.sdk.component.y.w.w wVar3 = wVar;
                try {
                    pl2.y().submit(new Runnable() { // from class: com.bytedance.sdk.component.y.u.p.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (g.isDiskCache()) {
                                pl2.w(wVar3.g()).xj(rawCacheKey, bArr);
                            }
                        }
                    });
                } catch (Throwable th) {
                    th = th;
                    wVar2 = wVar3;
                    xj(PluginConstants.ERROR_PLUGIN_DOWNLOAD, "net request failed!", th, wVar2);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            wVar2 = wVar;
        }
    }

    private void xj(int i, String str, Throwable th, com.bytedance.sdk.component.y.w.w wVar) {
        wVar.xj(new f(i, str, th));
    }

    @Override // com.bytedance.sdk.component.y.u.d
    public String xj() {
        return "net_request";
    }
}
