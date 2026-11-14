package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.u.w;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ra extends pz {
    public ra(Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        super(context, wsVar, hfVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf
    public com.bytedance.sdk.openadsdk.core.multipro.hf.xj p() {
        WeakReference<pl> weakReference = this.kd;
        if (weakReference != null && weakReference.get() != null) {
            return this.kd.get().getVideoModel();
        }
        NativeExpressView nativeExpressView = ((pz) this).xj;
        if (!(nativeExpressView instanceof NativeExpressVideoView)) {
            return null;
        }
        ((NativeExpressVideoView) nativeExpressView).qt();
        return ((NativeExpressVideoView) ((pz) this).xj).getVideoModel();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.pz
    public void xj(Context context, ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(context, wsVar, hfVar, "embeded_ad");
        ((pz) this).xj = nativeExpressVideoView;
        xj(nativeExpressVideoView, this.w);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hf, com.bytedance.sdk.openadsdk.zg.w.hf.am
    public void xj(final com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar) {
        NativeExpressView nativeExpressView = ((pz) this).xj;
        if (nativeExpressView != null) {
            nativeExpressView.setVideoAdListener(new w.u() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ra.1
                @Override // com.bykv.vk.openvk.component.video.api.u.w.u
                public void p_() {
                    com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.xj();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.u.w.u
                public void xj(int i, int i2) {
                    com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.xj(i, i2);
                    }
                }
            });
            ((pz) this).xj.setVideoAdInteractionListener(new w.InterfaceC0013w() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ra.2
                @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
                public void q_() {
                    com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.hf();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
                public void r_() {
                    com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.w();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
                public void s_() {
                    com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.u();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
                public void t_() {
                    com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.kd();
                    }
                }

                @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
                public void xj(long j, long j2) {
                    com.bytedance.sdk.openadsdk.et.xj.hf.xj.w wVar2 = wVar;
                    if (wVar2 != null) {
                        wVar2.xj(j, j2);
                    }
                }
            });
        }
    }
}
