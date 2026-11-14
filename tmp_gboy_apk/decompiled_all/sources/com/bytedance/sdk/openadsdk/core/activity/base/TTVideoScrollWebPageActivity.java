package com.bytedance.sdk.openadsdk.core.activity.base;

import android.os.Bundle;
import android.view.View;
import com.bykv.vk.openvk.component.video.api.u.w;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.u;
import com.bytedance.sdk.openadsdk.res.kd;
import com.bytedance.sdk.openadsdk.widget.TTScrollView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class TTVideoScrollWebPageActivity extends TTVideoWebPageActivity {
    private TTScrollView d;

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseLandingPageActivity, com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TTScrollView tTScrollView = (TTScrollView) findViewById(2114387873);
        this.d = tTScrollView;
        tTScrollView.setListener(new TTScrollView.xj() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity.1
            @Override // com.bytedance.sdk.openadsdk.widget.TTScrollView.xj
            public void xj(boolean z) {
                try {
                    w wVar = TTVideoScrollWebPageActivity.this.f;
                    if (wVar != null && (wVar instanceof u)) {
                        if (!z || wVar.jk()) {
                            TTVideoScrollWebPageActivity.this.f.y();
                        } else {
                            ((u) TTVideoScrollWebPageActivity.this.f).y(false);
                        }
                    }
                } catch (Throwable th) {
                    pl.w("TTVideoScrollWebPageActivity", "onCreate isShow error", th);
                }
            }
        });
        w wVar = this.f;
        if (wVar != null) {
            wVar.u(false);
        }
        NativeVideoTsView nativeVideoTsView = ((TTVideoWebPageActivity) this).c;
        if (nativeVideoTsView != null) {
            nativeVideoTsView.setVideoAdInteractionListener(new w.InterfaceC0013w() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity.2
                @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
                public void q_() {
                    w wVar2;
                    if (TTVideoScrollWebPageActivity.this.d == null || TTVideoScrollWebPageActivity.this.d.xj() || (wVar2 = TTVideoScrollWebPageActivity.this.f) == null) {
                        return;
                    }
                    wVar2.c();
                }

                @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
                public void r_() {
                }

                @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
                public void s_() {
                }

                @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
                public void t_() {
                }

                @Override // com.bykv.vk.openvk.component.video.api.u.w.InterfaceC0013w
                public void xj(long j, long j2) {
                }
            });
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        super.setContentView(kd.r(this));
    }
}
