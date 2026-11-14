package com.bytedance.sdk.openadsdk.zg.xj;

import IzHBwY.ARc23Z;
import android.util.Pair;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.jk.xj.xj.xj.kd;
import com.bytedance.sdk.openadsdk.jk.xj.xj.xj.u;
import com.bytedance.sdk.openadsdk.jk.xj.xj.xj.w;
import com.bytedance.sdk.openadsdk.jk.xj.xj.xj.y;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj {

    /* renamed from: com.bytedance.sdk.openadsdk.zg.xj.xj$xj, reason: collision with other inner class name */
    public static class C0210xj implements TTAdNative {
        private final xj xj;

        public C0210xj(xj xjVar) {
            this.xj = xjVar;
        }

        private ValueSet xj(AdSlot adSlot) {
            ARc23Z aRc23Z = new ARc23Z(com.bytedance.sdk.openadsdk.zg.xj.w.hf.xj(adSlot));
            aRc23Z.AMqCpz(8302, MediationAdClassLoader.getInstance());
            return aRc23Z.A2egSU();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadBannerExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.xj.d(xj(adSlot), new kd(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> xj = this.xj.xj(e);
                    nativeExpressAdListener.onError(((Integer) xj.first).intValue(), (String) xj.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadDrawFeedAd(AdSlot adSlot, TTAdNative.DrawFeedAdListener drawFeedAdListener) {
            try {
                this.xj.w(xj(adSlot), new com.bytedance.sdk.openadsdk.jk.xj.xj.xj.xj(drawFeedAdListener));
            } catch (Exception e) {
                if (drawFeedAdListener != null) {
                    Pair<Integer, String> xj = this.xj.xj(e);
                    drawFeedAdListener.onError(((Integer) xj.first).intValue(), (String) xj.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadExpressDrawFeedAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.xj.f(xj(adSlot), new kd(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> xj = this.xj.xj(e);
                    nativeExpressAdListener.onError(((Integer) xj.first).intValue(), (String) xj.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFeedAd(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.xj.xj(xj(adSlot), new com.bytedance.sdk.openadsdk.jk.xj.xj.xj.hf(feedAdListener));
            } catch (Exception e) {
                if (feedAdListener != null) {
                    Pair<Integer, String> xj = this.xj.xj(e);
                    feedAdListener.onError(((Integer) xj.first).intValue(), (String) xj.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadFullScreenVideoAd(AdSlot adSlot, TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
            try {
                this.xj.y(xj(adSlot), new w(fullScreenVideoAdListener));
            } catch (Exception e) {
                if (fullScreenVideoAdListener != null) {
                    Pair<Integer, String> xj = this.xj.xj(e);
                    fullScreenVideoAdListener.onError(((Integer) xj.first).intValue(), (String) xj.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeAd(AdSlot adSlot, TTAdNative.NativeAdListener nativeAdListener) {
            try {
                this.xj.u(xj(adSlot), new u(nativeAdListener));
            } catch (Exception e) {
                if (nativeAdListener != null) {
                    Pair<Integer, String> xj = this.xj.xj(e);
                    nativeAdListener.onError(((Integer) xj.first).intValue(), (String) xj.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadNativeExpressAd(AdSlot adSlot, TTAdNative.NativeExpressAdListener nativeExpressAdListener) {
            try {
                this.xj.c(xj(adSlot), new kd(nativeExpressAdListener));
            } catch (Exception e) {
                if (nativeExpressAdListener != null) {
                    Pair<Integer, String> xj = this.xj.xj(e);
                    nativeExpressAdListener.onError(((Integer) xj.first).intValue(), (String) xj.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadRewardVideoAd(AdSlot adSlot, TTAdNative.RewardVideoAdListener rewardVideoAdListener) {
            try {
                this.xj.kd(xj(adSlot), new y(rewardVideoAdListener));
            } catch (Exception e) {
                if (rewardVideoAdListener != null) {
                    Pair<Integer, String> xj = this.xj.xj(e);
                    rewardVideoAdListener.onError(((Integer) xj.first).intValue(), (String) xj.second);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadSplashAd(AdSlot adSlot, TTAdNative.CSJSplashAdListener cSJSplashAdListener, int i) {
            try {
                this.xj.xj(xj(adSlot), new hf(cSJSplashAdListener), i);
            } catch (Exception e) {
                if (cSJSplashAdListener != null) {
                    final Pair<Integer, String> xj = this.xj.xj(e);
                    cSJSplashAdListener.onSplashLoadFail(new CSJAdError() { // from class: com.bytedance.sdk.openadsdk.zg.xj.xj.xj.1
                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public int getCode() {
                            return ((Integer) xj.first).intValue();
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJAdError
                        public String getMsg() {
                            return (String) xj.second;
                        }
                    });
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative
        public void loadStream(AdSlot adSlot, TTAdNative.FeedAdListener feedAdListener) {
            try {
                this.xj.hf(xj(adSlot), new com.bytedance.sdk.openadsdk.jk.xj.xj.xj.hf(feedAdListener));
            } catch (Exception e) {
                if (feedAdListener != null) {
                    Pair<Integer, String> xj = this.xj.xj(e);
                    feedAdListener.onError(((Integer) xj.first).intValue(), (String) xj.second);
                }
            }
        }
    }

    public abstract void c(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void d(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void f(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void hf(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void kd(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void u(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void w(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract Pair<Integer, String> xj(Exception exc);

    public TTAdNative xj() {
        return new C0210xj(this);
    }

    public abstract void xj(ValueSet valueSet, Function<SparseArray<Object>, Object> function);

    public abstract void xj(ValueSet valueSet, Function<SparseArray<Object>, Object> function, int i);

    public abstract void y(ValueSet valueSet, Function<SparseArray<Object>, Object> function);
}
