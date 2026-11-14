package com.bytedance.sdk.openadsdk.api.plugin.xj;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class xj implements Function<SparseArray<Object>, Object> {
    private static volatile xj xj;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a5  */
    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object apply(android.util.SparseArray<java.lang.Object> r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L4
            goto L6a
        L4:
            IzHBwY.ADYaiT r5 = com.bykv.vk.component.ttvideo.player.A2egSU.AMqCpz(r5)
            r1 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            r2 = 0
            int r1 = r5.intValue(r1, r2)
            r3 = -99999986(0xfffffffffa0a1f0e, float:-1.792917E35)
            if (r1 == r3) goto Ld5
            r3 = 13
            if (r1 == r3) goto Lca
            switch(r1) {
                case 4: goto Lbf;
                case 5: goto Lb2;
                case 6: goto La5;
                case 7: goto L98;
                case 8: goto L73;
                default: goto L1c;
            }
        L1c:
            switch(r1) {
                case 100: goto L6b;
                case 101: goto L54;
                case 102: goto L45;
                case 103: goto L36;
                case 104: goto L98;
                case 105: goto La5;
                case 106: goto L20;
                default: goto L1f;
            }
        L1f:
            goto L6a
        L20:
            java.lang.Class<com.bytedance.sdk.openadsdk.TTPluginListener> r1 = com.bytedance.sdk.openadsdk.TTPluginListener.class
            java.lang.Object r5 = r5.objectValue(r2, r1)
            com.bytedance.sdk.openadsdk.TTPluginListener r5 = (com.bytedance.sdk.openadsdk.TTPluginListener) r5
            if (r5 == 0) goto L6a
            android.content.Context r1 = com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext()
            com.bytedance.sdk.openadsdk.api.plugin.d r1 = com.bytedance.sdk.openadsdk.api.plugin.d.xj(r1)
            r1.hf(r5)
            return r0
        L36:
            com.bytedance.pangle.plugin.Plugin r5 = r4.xj(r5)
            if (r5 == 0) goto L6a
            int r5 = r5.getVersion()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            return r5
        L45:
            com.bytedance.pangle.plugin.Plugin r5 = r4.xj(r5)
            if (r5 == 0) goto L6a
            int r5 = r5.getInternalVersionCode()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            return r5
        L54:
            android.content.Context r1 = com.bytedance.sdk.openadsdk.TTAppContextHolder.getContext()
            com.bytedance.sdk.openadsdk.api.plugin.d.xj(r1)
            com.bytedance.pangle.plugin.Plugin r5 = r4.xj(r5)
            if (r5 == 0) goto L6a
            int r5 = r5.getApiVersionCode()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            return r5
        L6a:
            return r0
        L6b:
            java.lang.String r5 = r5.stringValue(r2, r0)
            com.bytedance.pangle.Zeus.unInstallPlugin(r5)
            return r0
        L73:
            java.lang.String r5 = r5.stringValue(r2, r0)
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L8c
            java.lang.String r0 = com.bytedance.sdk.openadsdk.api.plugin.d.xj(r5)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L8e
            java.lang.String r0 = com.bytedance.sdk.openadsdk.api.plugin.d.hf(r5)
            goto L8e
        L8c:
            java.lang.String r0 = ""
        L8e:
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 == 0) goto L97
            java.lang.String r5 = "0.0.0.0"
            return r5
        L97:
            return r0
        L98:
            java.lang.String r5 = r5.stringValue(r2, r0)
            boolean r5 = com.bytedance.pangle.Zeus.isPluginLoaded(r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            return r5
        La5:
            java.lang.String r5 = r5.stringValue(r2, r0)
            boolean r5 = com.bytedance.pangle.Zeus.isPluginInstalled(r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            return r5
        Lb2:
            java.lang.String r5 = r5.stringValue(r2, r0)
            boolean r5 = com.bytedance.pangle.Zeus.loadPlugin(r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            return r5
        Lbf:
            java.lang.String r5 = r5.stringValue(r2, r0)
            com.bytedance.pangle.plugin.Plugin r5 = com.bytedance.pangle.Zeus.getPlugin(r5)
            com.bytedance.pangle.PluginClassLoader r5 = r5.mClassLoader
            return r5
        Lca:
            com.bytedance.pangle.plugin.Plugin r5 = r4.xj(r5)
            if (r5 == 0) goto Ld5
            org.json.JSONObject r5 = r5.getJsonConfig()
            return r5
        Ld5:
            IzHBwY.ARc23Z r5 = IzHBwY.ARc23Z.A4TApA()
            r0 = 10000(0x2710, float:1.4013E-41)
            r1 = 4
            r5.ADYaiT(r0, r1)
            IzHBwY.ADYaiT r5 = r5.A2egSU()
            android.util.SparseArray r5 = r5.sparseArray()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.xj.xj.apply(android.util.SparseArray):java.lang.Object");
    }

    public static xj xj() {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    private Plugin xj(ValueSet valueSet) {
        if (valueSet == null) {
            return null;
        }
        String stringValue = valueSet.stringValue(0);
        if (TextUtils.isEmpty(stringValue)) {
            return null;
        }
        return Zeus.getPlugin(stringValue);
    }
}
