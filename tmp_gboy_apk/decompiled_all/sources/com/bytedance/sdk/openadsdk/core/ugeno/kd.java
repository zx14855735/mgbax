package com.bytedance.sdk.openadsdk.core.ugeno;

import android.content.Context;
import com.bytedance.adsdk.ugeno.kd.y;
import com.bytedance.adsdk.ugeno.w.hf.u;
import com.bytedance.adsdk.ugeno.w.yo;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.p;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.pl;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    public static void xj() {
        com.bytedance.adsdk.ugeno.u.xj().xj(pz.getContext(), new com.bytedance.adsdk.ugeno.w.w() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1
            @Override // com.bytedance.adsdk.ugeno.w.w
            public List<com.bytedance.adsdk.ugeno.w.hf> xj() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("View") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.1
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.adsdk.ugeno.yoga.widget.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("CustomComponent") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.12
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.adsdk.ugeno.yoga.widget.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("Text") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.23
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.text.hf(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("Image") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.33
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.image.hf(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("UpieImage") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.34
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.w.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("FlexLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.35
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.adsdk.ugeno.flexbox.kd(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("FrameLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.36
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.frame.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("InteractContainerView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.37
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new p(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("ScrollLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.38
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.scroll.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("RichText") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.2
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.text.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("Input") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.3
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.input.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("Dislike") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.4
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.dislike.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("RatingBar") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.5
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.ratingbar.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("RatingStar") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.6
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.ratingbar.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("UgenProgressView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.7
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.progressbar.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("ProgressButton") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.8
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.progressbar.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("Button") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.9
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.xj.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("RecyclerLayout") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.10
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.hf.y(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("Video") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.11
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.video.hf(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("Gif") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.13
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.gif.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("VideoPlaceholder") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.14
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.u.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("Lottie") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.15
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.hf(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("InterLottie") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.16
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.lottie.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("InteractionWebView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.17
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new pl(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("WebView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.18
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.webview.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("Blur") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.19
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("Swiper") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.20
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.adsdk.ugeno.hf(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("FVCountdown") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.21
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("RVCountdown") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.22
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("CycleCountDownView") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.24
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.hf(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("CycleSkip") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.25
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.skip.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("RewardClickCountdown") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.26
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.u(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("Icon") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.27
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.xj.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("FVSkip") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.28
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.skip.hf(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("RVSkip") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.29
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.skip.hf(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("VideoV3") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.30
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.u.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("PlayableComponent") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.31
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.adsdk.ugeno.widget.frame.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.hf("CsjRefreshTip") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.1.32
                    @Override // com.bytedance.adsdk.ugeno.w.hf
                    public com.bytedance.adsdk.ugeno.hf.w xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.w(context);
                    }
                });
                return arrayList;
            }
        }, new u());
        com.bytedance.adsdk.ugeno.u.xj().xj(new com.bytedance.adsdk.ugeno.kd.f() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.2
            @Override // com.bytedance.adsdk.ugeno.kd.f
            public List<com.bytedance.adsdk.ugeno.kd.c> xj() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.bytedance.adsdk.ugeno.kd.c("shake") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.2.1
                    @Override // com.bytedance.adsdk.ugeno.kd.c
                    public com.bytedance.adsdk.ugeno.kd.w.hf xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.hf.xj(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.kd.c("twist") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.2.2
                    @Override // com.bytedance.adsdk.ugeno.kd.c
                    public com.bytedance.adsdk.ugeno.kd.w.hf xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.hf.hf(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.kd.c("videoProgress") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.2.3
                    @Override // com.bytedance.adsdk.ugeno.kd.c
                    public com.bytedance.adsdk.ugeno.kd.w.hf xj(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.hf.w(context);
                    }
                });
                return arrayList;
            }
        });
        com.bytedance.adsdk.ugeno.u.xj().xj(new com.bytedance.adsdk.hf.w());
        com.bytedance.adsdk.ugeno.u.xj().xj(new com.bytedance.adsdk.ugeno.w.hf.u() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.3
            @Override // com.bytedance.adsdk.ugeno.w.hf.u
            public u.xj xj(Context context, com.bytedance.adsdk.ugeno.hf.w wVar) {
                return new y(context, wVar);
            }
        });
        com.bytedance.adsdk.ugeno.u.xj().xj(new com.bytedance.adsdk.ugeno.w.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.4
            @Override // com.bytedance.adsdk.ugeno.w.xj.xj
            public com.bytedance.adsdk.ugeno.w.xj.hf xj(yo yoVar) {
                return new d(yoVar);
            }
        });
        com.bytedance.adsdk.ugeno.u.xj().xj(new com.bytedance.adsdk.ugeno.kd.w() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.5
            @Override // com.bytedance.adsdk.ugeno.kd.w
            public List<com.bytedance.adsdk.ugeno.kd.hf> xj() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.bytedance.adsdk.ugeno.kd.hf("interactiveFinish") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.5.1
                    @Override // com.bytedance.adsdk.ugeno.kd.hf
                    public com.bytedance.adsdk.ugeno.kd.hf.xj xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
                        return new com.bytedance.adsdk.ugeno.kd.hf.w(wVar, str, xjVar);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.kd.hf("nextVideoCancel") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.5.2
                    @Override // com.bytedance.adsdk.ugeno.kd.hf
                    public com.bytedance.adsdk.ugeno.kd.hf.xj xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
                        return new com.bytedance.adsdk.ugeno.kd.hf.w(wVar, str, xjVar);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.kd.hf("haptic") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.5.3
                    @Override // com.bytedance.adsdk.ugeno.kd.hf
                    public com.bytedance.adsdk.ugeno.kd.hf.xj xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
                        return new com.bytedance.adsdk.ugeno.kd.hf.w(wVar, str, xjVar);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.kd.hf("closeWidget") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.5.4
                    @Override // com.bytedance.adsdk.ugeno.kd.hf
                    public com.bytedance.adsdk.ugeno.kd.hf.xj xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
                        return new com.bytedance.adsdk.ugeno.kd.hf.w(wVar, str, xjVar);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.kd.hf("dismiss") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.5.5
                    @Override // com.bytedance.adsdk.ugeno.kd.hf
                    public com.bytedance.adsdk.ugeno.kd.hf.xj xj(com.bytedance.adsdk.ugeno.hf.w wVar, String str, y.xj xjVar) {
                        return new com.bytedance.adsdk.ugeno.kd.hf.w(wVar, str, xjVar);
                    }
                });
                return arrayList;
            }
        });
    }
}
