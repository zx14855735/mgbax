package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.hf.am;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.multipro.hf.xj;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.yo.xj;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    private String c;
    private FullRewardExpressView d;
    private ViewGroup f;
    private final TTBaseVideoActivity kd;
    com.bytedance.sdk.openadsdk.core.pl.hf.w xj;
    private ws y;
    boolean hf = false;
    boolean w = false;
    boolean u = false;

    public kd(TTBaseVideoActivity tTBaseVideoActivity) {
        this.kd = tTBaseVideoActivity;
    }

    public void c() {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.zg();
    }

    public int d() {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getDynamicShowType();
        }
        return 0;
    }

    public void f() {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.e();
            this.d.yo();
        }
    }

    public void g() {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView != null && fullRewardExpressView.getJsObject() != null) {
            this.d.getJsObject().c(true);
        }
        xj("isVerifyReward", (JSONObject) null);
    }

    public boolean hf() {
        return this.hf;
    }

    public void kd() {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.yo();
        }
    }

    public am p() {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView == null) {
            return null;
        }
        return fullRewardExpressView.getRenderResult();
    }

    public FullRewardExpressView pl() {
        return this.d;
    }

    public boolean tf() {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView == null) {
            return true;
        }
        return fullRewardExpressView.am();
    }

    public void u() {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.g();
        }
    }

    public boolean w() {
        return this.w;
    }

    public boolean y() {
        FullRewardExpressView fullRewardExpressView = this.d;
        return (fullRewardExpressView == null || fullRewardExpressView.pz()) ? false : true;
    }

    public void hf(boolean z) {
        this.w = z;
    }

    public void w(boolean z) {
        ViewGroup viewGroup = this.f;
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 8);
        }
    }

    public void xj(ws wsVar, com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, String str, boolean z, String str2) {
        if (this.u) {
            return;
        }
        this.u = true;
        this.y = wsVar;
        this.c = str;
        this.d = new FullRewardExpressView(this.kd, wsVar, hfVar, str, z, str2);
        FrameLayout expressFrameContainer = this.kd.l().getExpressFrameContainer();
        this.f = expressFrameContainer;
        expressFrameContainer.addView(this.d, new FrameLayout.LayoutParams(-2, -2));
        this.d.setEasyPlayableContainer(this.kd.l().getEasyPlayableContainer());
    }

    public void xj(CharSequence charSequence, int i, int i2, boolean z) {
        if (this.d == null || !y()) {
            return;
        }
        this.d.xj(charSequence, i, i2, z);
    }

    public FrameLayout xj() {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getVideoFrameLayout();
        }
        return null;
    }

    public void xj(boolean z) {
        this.hf = z;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.nativeexpress.kd kdVar, com.bytedance.sdk.openadsdk.core.nativeexpress.u uVar) {
        ws wsVar;
        if (this.d == null || (wsVar = this.y) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.pl.hf.w xj = xj(wsVar);
        this.xj = xj;
        if (xj != null) {
            xj.xj();
            if (this.d.getContext() != null && (this.d.getContext() instanceof Activity)) {
                this.xj.xj((Activity) this.d.getContext());
            }
        }
        com.bytedance.sdk.openadsdk.core.am.u.xj(this.y);
        EmptyView xj2 = xj((ViewGroup) this.d);
        if (xj2 == null) {
            ws wsVar2 = this.y;
            EmptyView emptyView = new EmptyView(this.kd, this.d, wsVar2 != null ? wsVar2.cm() : 1000);
            emptyView.xj(this.y, this.c);
            this.d.addView(emptyView);
            xj2 = emptyView;
        }
        xj2.setNeedCheckingShow(false);
        xj2.setCallback(new EmptyView.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.kd.1
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void hf() {
                com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = kd.this.xj;
                if (wVar != null) {
                    wVar.hf();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void xj(View view, Map<String, Object> map) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void xj(boolean z) {
                com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = kd.this.xj;
                if (wVar == null || !z) {
                    return;
                }
                wVar.xj();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.xj
            public void xj() {
                com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = kd.this.xj;
                if (wVar != null) {
                    wVar.xj(false);
                }
            }
        });
        kdVar.xj(this.d);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) kdVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.xj);
        this.d.setClickListener(kdVar);
        uVar.xj(this.d);
        ((com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj) uVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.xj.xj.class)).xj(this.xj);
        this.d.setClickCreativeListener(uVar);
        xj2.setNeedCheckingShow(false);
        xj(this.xj, this.d);
    }

    private void xj(com.bytedance.sdk.openadsdk.core.pl.hf.w wVar, NativeExpressView nativeExpressView) {
        final String str;
        if (wVar == null || nativeExpressView == null) {
            return;
        }
        ws wsVar = this.y;
        if (wsVar != null) {
            str = wsVar.ho();
        } else {
            str = "";
        }
        wVar.xj(new com.bytedance.sdk.openadsdk.core.pl.hf.xj() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.layout.kd.2
            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void hf(long j, long j2, String str2, String str3) {
                kd.this.kd.xj("下载暂停");
                if (j > 0) {
                    xj.C0198xj.xj(str, 2, (int) ((j2 * 100) / j));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void w(long j, long j2, String str2, String str3) {
                kd.this.kd.xj("下载失败");
                if (j > 0) {
                    xj.C0198xj.xj(str, 4, (int) ((j2 * 100) / j));
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj() {
                kd.this.kd.xj("点击开始下载");
                xj.C0198xj.xj(str, 1, 0);
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj(long j, long j2, String str2, String str3) {
                if (j > 0) {
                    int i = (int) ((j2 * 100) / j);
                    kd.this.kd.xj("已下载" + i + "%");
                    xj.C0198xj.xj(str, 3, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj(long j, String str2, String str3) {
                kd.this.kd.xj("点击安装");
                xj.C0198xj.xj(str, 5, 100);
            }

            @Override // com.bytedance.sdk.openadsdk.core.pl.hf.xj
            public void xj(String str2, String str3) {
                kd.this.kd.xj("点击打开");
                xj.C0198xj.xj(str, 6, 100);
            }
        });
    }

    private com.bytedance.sdk.openadsdk.core.pl.hf.w xj(ws wsVar) {
        if (wsVar.vw() == 4) {
            return com.bytedance.sdk.openadsdk.core.pl.f.xj((Context) this.kd, wsVar, this.c, false);
        }
        return null;
    }

    private EmptyView xj(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void xj(com.bytedance.sdk.openadsdk.core.nativeexpress.tf tfVar) {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressVideoListenerProxy(tfVar);
    }

    public void xj(com.bytedance.sdk.openadsdk.core.nativeexpress.xj xjVar) {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView == null) {
            return;
        }
        fullRewardExpressView.setExpressInteractionListener(xjVar);
    }

    public void xj(com.bykv.vk.openvk.component.video.api.u.w wVar) {
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.setVideoController(wVar);
        }
    }

    public void xj(String str, JSONObject jSONObject) {
        j jsObject;
        FullRewardExpressView fullRewardExpressView = this.d;
        if (fullRewardExpressView == null || (jsObject = fullRewardExpressView.getJsObject()) == null || this.kd.isFinishing()) {
            return;
        }
        jsObject.xj(str, jSONObject);
    }

    public void xj(xj.InterfaceC0173xj interfaceC0173xj) {
        com.bytedance.sdk.openadsdk.core.pl.hf.w wVar = this.xj;
        if (wVar != null) {
            wVar.xj(interfaceC0173xj);
        }
    }

    public void xj(com.bytedance.sdk.openadsdk.core.component.reward.kd.w wVar) {
        if (this.d != null) {
            this.d.xj((int) (wVar.xj() / 1000), wVar.kd(), wVar.hf(), wVar.u());
        }
    }
}
