package com.bytedance.msdk.api.u.xj.hf.y;

import P8ccfD.AaHO0E;
import android.content.Context;
import android.util.SparseArray;
import com.baidu.mobads.sdk.internal.cn;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.xj.hf.w.hf;
import com.bytedance.msdk.y.hf.kd;
import com.bytedance.msdk.y.hf.w;
import com.bytedance.sdk.openadsdk.core.wo.u;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends u {
    private static final String w = "TTMediationSDK_xj";
    private Function<SparseArray<Object>, Object> c;
    private hf u;
    private final AtomicBoolean kd = new AtomicBoolean(false);
    protected long xj = 0;
    protected int hf = 0;
    private final Function<SparseArray<Object>, Object> y = w.xj(com.bytedance.msdk.core.xj.p().a()).xj();

    static {
        NpvEWK();
    }

    private static /* synthetic */ void NpvEWK() {
        char[] charArray = "óÿý¾÷ñýõ¾òÿé¾ãøõüü¾ÚþùÒâùô÷õ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 144);
        }
        String str = new String(charArray);
        char[] charArray2 = "óüùþùä".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 144);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8216) {
            this.c = AaHO0E.AYUAbz(pluginValueSet.objectValue(8402, AaHO0E.ARc23Z()));
        } else if (i == 8219) {
            xj();
        } else {
            if (i == 8220) {
                return (T) Boolean.valueOf(hf());
            }
            if (i == 8270) {
                long longValue = pluginValueSet.longValue(8073);
                this.hf = pluginValueSet.intValue(8557);
                this.xj = longValue;
            }
        }
        return (T) com.bytedance.msdk.core.zg.xj.xj(cls);
    }

    public void c() {
        this.hf = 0;
        this.xj = 0L;
    }

    public final boolean hf() {
        return this.kd.get();
    }

    public long kd() {
        return this.xj;
    }

    public String u() {
        return cn.d;
    }

    public String w() {
        Object apply;
        if (this.c == null) {
            return null;
        }
        apply = this.c.apply(A2egSU.ARc23Z(AVMDLDataLoader.KeyIsLoaderFactoryP2PStragetyLevel, String.class));
        return apply instanceof String ? (String) apply : "";
    }

    public final void xj() {
        this.kd.set(true);
    }

    public int y() {
        return this.hf;
    }

    public void hf(Context context, hf hfVar, Map<String, Object> map) {
        if (hfVar != null) {
            com.bytedance.sdk.openadsdk.zg.u xj = A2egSU.AZOQYO(AVMDLDataLoader.KeyIsLiveLoaderEnable, Void.class).xj(8089, com.bytedance.msdk.core.xj.p().a().sparseArray()).xj(8545, com.bytedance.sdk.openadsdk.zg.w.u.xj(hfVar.xj())).xj(8400, map).xj(8401, this).xj(8098, Boolean.TRUE);
            kd.xj(xj);
            this.y.apply(xj.hf());
        }
    }

    public final void xj(Context context, hf hfVar, Map<String, Object> map) {
        this.kd.set(false);
        this.u = hfVar;
        hf(context, hfVar, map);
    }

    public String xj(Context context, Map<String, Object> map) {
        Object apply;
        if (this.c == null) {
            return null;
        }
        apply = this.c.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8139).xj(String.class).xj(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).xj(8075, map).hf());
        return apply instanceof String ? (String) apply : "";
    }

    public String hf(Context context, Map<String, Object> map) {
        Object apply;
        if (this.c == null) {
            return null;
        }
        apply = this.c.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(AVMDLDataLoader.KeyIsLoaderFactoryXYLibValue).xj(String.class).xj(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).xj(8075, map).hf());
        return apply instanceof String ? (String) apply : "";
    }
}
