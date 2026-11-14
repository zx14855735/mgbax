package com.bytedance.msdk.w.xj;

import P8ccfD.AaHO0E;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class u extends com.bytedance.msdk.hf.w {
    protected Function<SparseArray<Object>, Object> d;
    protected com.bytedance.msdk.w.y.hf.xj tf;

    public u(com.bytedance.msdk.w.y.hf.xj xjVar) {
        this.tf = xjVar;
    }

    @Override // com.bytedance.msdk.hf.w, com.bytedance.sdk.openadsdk.core.wo.u
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8128) {
            this.d = AaHO0E.AYUAbz(pluginValueSet.objectValue(8035, AaHO0E.ARc23Z()));
        } else if (i == 8208) {
            String stringValue = pluginValueSet.stringValue(8058);
            if (!TextUtils.isEmpty(stringValue)) {
                am(stringValue);
            }
        } else if (i == 8209) {
            p(pluginValueSet.intValue(8060));
        } else if (i == 8140) {
            pl(pluginValueSet.intValue(8059));
        }
        return (T) xj(i, pluginValueSet, cls);
    }

    @Override // com.bytedance.msdk.hf.w
    public long db() {
        Object apply;
        if (this.d == null) {
            return super.db();
        }
        apply = this.d.apply(A2egSU.ARc23Z(8245, Long.class));
        if (apply instanceof Long) {
            return ((Long) apply).longValue();
        }
        return 0L;
    }

    @Override // com.bytedance.msdk.hf.w
    public void e() {
        super.e();
        if (this.d != null) {
            this.d.apply(A2egSU.ARc23Z(8148, Void.class));
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void hf(Map<String, Object> map) {
        if (lm() && this.d != null) {
            this.d.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8142).xj(Void.class).xj(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).hf());
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public boolean kd() {
        if (this.d == null) {
            return false;
        }
        this.d.apply(A2egSU.ARc23Z(8120, Boolean.class));
        return false;
    }

    @Override // com.bytedance.msdk.hf.w
    public long m() {
        Object apply;
        if (this.d == null) {
            return super.m();
        }
        apply = this.d.apply(A2egSU.ARc23Z(8246, Long.class));
        if (apply instanceof Long) {
            return ((Long) apply).longValue();
        }
        return 0L;
    }

    public boolean mq() {
        com.bytedance.msdk.w.y.hf.xj xjVar = this.tf;
        if (xjVar != null) {
            return xjVar.xj();
        }
        return false;
    }

    @Override // com.bytedance.msdk.hf.w
    public Map<String, Object> q() {
        Object apply;
        if (this.d != null) {
            apply = this.d.apply(A2egSU.ARc23Z(8239, Map.class));
            w(apply instanceof Map ? (Map) apply : null);
        }
        return super.q();
    }

    public abstract <T> T xj(int i, PluginValueSet pluginValueSet, Class<T> cls);

    @Override // com.bytedance.msdk.hf.w
    public void xj(Map<String, Object> map) {
        if (lm()) {
            Object obj = map.get("bidding_lose_reason_NUM");
            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
            if (intValue <= 0) {
                intValue = 10001;
            }
            map.put(MediationConstant.BIDDING_LOSE_REASON_DEX_ADAPTER, Integer.valueOf(com.bytedance.msdk.core.xj.xj.kd.xj(gh(), intValue)));
            if (this.d != null) {
                this.d.apply(com.bytedance.sdk.openadsdk.zg.u.xj().xj(8144).xj(Void.class).xj(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).hf());
            }
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void yo() {
        super.yo();
        if (this.d != null) {
            this.d.apply(A2egSU.ARc23Z(8109, Void.class));
        }
    }

    @Override // com.bytedance.msdk.hf.w
    public void zg() {
        super.zg();
        if (this.d != null) {
            this.d.apply(A2egSU.ARc23Z(8149, Void.class));
        }
    }
}
