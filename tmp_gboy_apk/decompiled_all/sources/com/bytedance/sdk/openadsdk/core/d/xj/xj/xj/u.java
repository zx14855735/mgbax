package com.bytedance.sdk.openadsdk.core.d.xj.xj.xj;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.core.a.en;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u extends xj {
    public u(ws wsVar, Context context, String str, com.bytedance.sdk.openadsdk.core.pl.w.w.w wVar, String str2) {
        this.xj = wsVar;
        this.hf = context;
        this.w = str;
        this.u = wVar;
        this.kd = str2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.xj
    public void hf(boolean z, int i) {
        com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(z, com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(this.xj, this.y), i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.xj
    public com.bytedance.sdk.openadsdk.core.pl.xj.hf u(final Map<String, Object> map) {
        final int w = xj.w(map);
        String str = this.w;
        com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(str, str, wo.v(this.xj), w);
        map.put("action_type_button", 2);
        ws wsVar = this.xj;
        if (wsVar != null && !TextUtils.isEmpty(wsVar.ho())) {
            map.put(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, Long.valueOf(Double.valueOf(this.xj.ho()).longValue()));
        }
        if (!w(w)) {
            xj(map, true);
            return null;
        }
        com.bytedance.sdk.openadsdk.core.pl.xj.hf hfVar = new com.bytedance.sdk.openadsdk.core.pl.xj.hf() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.u.1
            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleComplianceDialog(boolean z) {
            }

            @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
            public void handleMarketFailedComplianceDialog() {
                if (map == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(0, w);
                u uVar = u.this;
                uVar.u.xj(uVar.hf(w));
                map.remove("downloadButtonClickListener");
                if (u.this.xj((com.bytedance.sdk.openadsdk.core.ra.u) null, (com.bytedance.sdk.openadsdk.core.pl.xj.hf) null, map)) {
                    return;
                }
                u.this.xj(map, true);
            }
        };
        com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(map, hfVar);
        return hfVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.xj
    public boolean w(int i) {
        Function<SparseArray<Object>, Object> function = this.d;
        return function != null && com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(function, i) == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.xj
    public com.bytedance.sdk.openadsdk.core.pl.xj.kd xj(Map<String, Object> map, final en<String, Object> enVar) {
        final int w = xj.w(enVar);
        return new com.bytedance.sdk.openadsdk.core.pl.xj.kd() { // from class: com.bytedance.sdk.openadsdk.core.d.xj.xj.xj.u.2
            @Override // com.bytedance.sdk.openadsdk.core.pl.xj.kd
            public void onItemClick() {
                if (u.this.c || u.this.xj.ta()) {
                    com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.hf(1, w);
                    enVar.remove("itemClickListener");
                    u.this.d.apply(A2egSU.AZOQYO(17, Void.class).xj(0, enVar).hf());
                    return;
                }
                u uVar = u.this;
                ws wsVar = uVar.xj;
                Context context = uVar.hf;
                String str = uVar.w;
                com.bytedance.sdk.openadsdk.core.d.xj.xj.hf.xj xjVar = new com.bytedance.sdk.openadsdk.core.d.xj.xj.hf.xj(wsVar, context, str, wo.hf(str));
                xjVar.w(true);
                xjVar.xj((Map<String, Object>) new HashMap());
            }
        };
    }
}
