package com.bytedance.sdk.openadsdk.api;

import ADYaiT.CtFAbx;
import IzHBwY.A4TApA;
import IzHBwY.ADYaiT;
import IzHBwY.ARc23Z;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdConfig;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitCLassLoader;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj {
    private TTAdSdk.InitCallback xj;

    public interface hf<T> {
        void xj(T t);
    }

    public class u implements Function<SparseArray<Object>, Object> {
        private u() {
        }

        @Override // java.util.function.Function
        /* renamed from: xj, reason: merged with bridge method [inline-methods] */
        public Object apply(SparseArray<Object> sparseArray) {
            SparseArray sparseArray2;
            if (sparseArray != null && (sparseArray2 = (SparseArray) new ARc23Z(sparseArray).A2egSU().objectValue(-99999979, SparseArray.class)) != null) {
                ADYaiT AMqCpz = A2egSU.AMqCpz(sparseArray2);
                xj xjVar = xj.this;
                A4TApA ADYaiT2 = A4TApA.ADYaiT();
                ADYaiT2.f4104A4TApA = AMqCpz.intValue(-999900, 0);
                ADYaiT2.f4106ADYaiT = AMqCpz.stringValue(-999901, null);
                ADYaiT2.f4105A5SV6n = AMqCpz.booleanValue(-999903, false);
                ADYaiT2.AMqCpz = A2egSU.AMqCpz((SparseArray) AMqCpz.objectValue(-999902, SparseArray.class));
                xjVar.hf(ADYaiT2.A5SV6n());
            }
            return null;
        }
    }

    public static abstract class w implements TTAdManager {
        private volatile boolean hf;
        private Map<hf<Manager>, Object> u = new WeakHashMap();
        private volatile boolean w;
        private volatile Manager xj;

        /* renamed from: com.bytedance.sdk.openadsdk.api.xj$w$1, reason: invalid class name */
        public class AnonymousClass1 extends AbstractC0132xj<Loader> {
            final hf<Manager> hf;
            final /* synthetic */ SoftReference w;
            Loader xj;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SoftReference softReference) {
                super();
                this.w = softReference;
                this.hf = new hf<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.xj.w.1.1
                    @Override // com.bytedance.sdk.openadsdk.api.xj.hf
                    public void xj(Manager manager) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        anonymousClass1.xj = manager.createLoader((Context) anonymousClass1.w.get());
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.api.xj.AbstractC0132xj
            public void xj(final hf<Loader> hfVar, int i) {
                Loader loader = this.xj;
                if (loader != null) {
                    hfVar.xj(loader);
                } else {
                    w.this.call(new hf<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.xj.w.1.2
                        @Override // com.bytedance.sdk.openadsdk.api.xj.hf
                        public void xj(Manager manager) {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            w.this.xj(anonymousClass1.hf);
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            anonymousClass12.xj = manager.createLoader((Context) anonymousClass12.w.get());
                            hfVar.xj(AnonymousClass1.this.xj);
                        }
                    }, i + 10000);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(final hf<Manager> hfVar, final int i) {
            if (com.bytedance.sdk.openadsdk.api.kd.xj()) {
                return;
            }
            if (this.xj == null) {
                if (!this.hf && i > 10000) {
                    throw new IllegalStateException("广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告");
                }
                com.bytedance.sdk.openadsdk.yo.xj.xj().xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.xj.w.7
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (w.this.xj != null) {
                                hfVar.xj(w.this.xj);
                                return;
                            }
                            y.u("_tt_ad_sdk_", "Not ready, no manager: " + i);
                        } catch (Throwable th) {
                            y.u("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                            w.this.xj(th);
                        }
                    }
                });
                return;
            }
            try {
                hfVar.xj(this.xj);
            } catch (Throwable th) {
                y.u("_tt_ad_sdk_", "Unexpected manager call error: " + th.getMessage());
                xj(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T hf(Manager manager, Class<T> cls, Bundle bundle) {
            Function<SparseArray<Object>, Object> xj;
            Object apply;
            if (com.bytedance.sdk.openadsdk.api.kd.xj()) {
                return null;
            }
            ARc23Z A5SV6n2 = ARc23Z.A5SV6n(3);
            SparseArray sparseArray = A5SV6n2.f4113A2egSU;
            sparseArray.put(9, cls);
            sparseArray.put(10, bundle);
            A5SV6n2.ADYaiT(-99999987, 6);
            sparseArray.put(-99999985, cls);
            SparseArray sparseArray2 = A5SV6n2.A2egSU().sparseArray();
            if (!(manager instanceof com.bytedance.sdk.openadsdk.api.w) || (xj = ((com.bytedance.sdk.openadsdk.api.w) manager).xj(1)) == null) {
                return null;
            }
            apply = xj.apply(sparseArray2);
            return (T) apply;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public TTAdNative createAdNative(Context context) {
            if (com.bytedance.sdk.openadsdk.api.kd.xj()) {
                return null;
            }
            return new kd(new AnonymousClass1(new SoftReference(context))).xj();
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot) {
            return getBiddingToken(adSlot, false, adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType());
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public <T> T getExtra(final Class<T> cls, final Bundle bundle) {
            if (com.bytedance.sdk.openadsdk.api.kd.xj()) {
                return null;
            }
            if (this.xj != null) {
                return (T) hf(this.xj, cls, bundle);
            }
            call(new hf<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.xj.w.4
                @Override // com.bytedance.sdk.openadsdk.api.xj.hf
                public void xj(Manager manager) {
                    w.hf(w.this.xj, cls, bundle);
                }
            }, 6);
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getPluginVersion() {
            return this.xj != null ? this.xj.values().stringValue(12) : "";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getSDKVersion() {
            return "7.1.3.2";
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public int getThemeStatus() {
            if (this.xj != null) {
                return this.xj.values().intValue(11);
            }
            return 0;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public Bundle handleEvent(Bundle bundle) {
            Function<SparseArray<Object>, Object> xj;
            Object apply;
            ARc23Z A4TApA2 = ARc23Z.A4TApA();
            A4TApA2.f4113A2egSU.put(20, bundle);
            A4TApA2.ADYaiT(-99999987, 19);
            A4TApA2.f4113A2egSU.put(-99999985, Bundle.class);
            ADYaiT A2egSU2 = A4TApA2.A2egSU();
            if (!(this.xj instanceof com.bytedance.sdk.openadsdk.api.w) || (xj = ((com.bytedance.sdk.openadsdk.api.w) this.xj).xj(1)) == null) {
                return null;
            }
            apply = xj.apply(A2egSU2.sparseArray());
            if (apply instanceof Bundle) {
                return (Bundle) apply;
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void register(final Object obj) {
            if (com.bytedance.sdk.openadsdk.api.kd.xj()) {
                return;
            }
            call(new hf<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.xj.w.2
                @Override // com.bytedance.sdk.openadsdk.api.xj.hf
                public void xj(Manager manager) {
                    Function<SparseArray<Object>, Object> xj;
                    Object xj2 = w.this.xj(obj);
                    ARc23Z A5SV6n2 = ARc23Z.A5SV6n(2);
                    SparseArray sparseArray = A5SV6n2.f4113A2egSU;
                    sparseArray.put(8, xj2);
                    A5SV6n2.ADYaiT(-99999987, 4);
                    sparseArray.put(-99999985, Void.class);
                    SparseArray sparseArray2 = A5SV6n2.A2egSU().sparseArray();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.w) || (xj = ((com.bytedance.sdk.openadsdk.api.w) manager).xj(1)) == null) {
                        return;
                    }
                    xj.apply(sparseArray2);
                }
            }, 4);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void requestPermissionIfNecessary(final Context context) {
            if (com.bytedance.sdk.openadsdk.api.kd.xj()) {
                return;
            }
            call(new hf<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.xj.w.5
                @Override // com.bytedance.sdk.openadsdk.api.xj.hf
                public void xj(Manager manager) {
                    Function<SparseArray<Object>, Object> xj;
                    ARc23Z A5SV6n2 = ARc23Z.A5SV6n(2);
                    Context context2 = context;
                    SparseArray sparseArray = A5SV6n2.f4113A2egSU;
                    sparseArray.put(7, context2);
                    A5SV6n2.ADYaiT(-99999987, 3);
                    sparseArray.put(-99999985, Void.class);
                    SparseArray sparseArray2 = A5SV6n2.A2egSU().sparseArray();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.w) || (xj = ((com.bytedance.sdk.openadsdk.api.w) manager).xj(1)) == null) {
                        return;
                    }
                    xj.apply(sparseArray2);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void setThemeStatus(final int i) {
            if (com.bytedance.sdk.openadsdk.api.kd.xj()) {
                return;
            }
            call(new hf<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.xj.w.6
                @Override // com.bytedance.sdk.openadsdk.api.xj.hf
                public void xj(Manager manager) {
                    Function<SparseArray<Object>, Object> xj;
                    ARc23Z A4TApA2 = ARc23Z.A4TApA();
                    A4TApA2.ADYaiT(11, i);
                    A4TApA2.ADYaiT(-99999987, 1);
                    A4TApA2.f4113A2egSU.put(-99999985, Void.class);
                    ADYaiT A2egSU2 = A4TApA2.A2egSU();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.w) || (xj = ((com.bytedance.sdk.openadsdk.api.w) manager).xj(1)) == null) {
                        return;
                    }
                    xj.apply(A2egSU2.sparseArray());
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public boolean tryShowInstallDialogWhenExit(Activity activity, ExitInstallListener exitInstallListener) {
            if (!com.bytedance.sdk.openadsdk.api.kd.xj()) {
                HashMap hashMap = new HashMap();
                hashMap.put(TTDownloadField.TT_ACTIVITY, activity);
                hashMap.put(TTDownloadField.TT_EXIT_INSTALL_LISTENER, new com.bytedance.sdk.openadsdk.zg.xj.hf.xj(exitInstallListener));
                ARc23Z A5SV6n2 = ARc23Z.A5SV6n(2);
                SparseArray sparseArray = A5SV6n2.f4113A2egSU;
                sparseArray.put(0, hashMap);
                A5SV6n2.ADYaiT(-99999987, 0);
                sparseArray.put(-99999985, Boolean.class);
                Object apply = com.bytedance.sdk.openadsdk.downloadnew.w.xj(TTAppContextHolder.getContext()).apply(A5SV6n2.A2egSU().sparseArray());
                if (apply != null) {
                    return ((Boolean) apply).booleanValue();
                }
            }
            return false;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public void unregister(final Object obj) {
            if (com.bytedance.sdk.openadsdk.api.kd.xj()) {
                return;
            }
            call(new hf<Manager>() { // from class: com.bytedance.sdk.openadsdk.api.xj.w.3
                @Override // com.bytedance.sdk.openadsdk.api.xj.hf
                public void xj(Manager manager) {
                    Function<SparseArray<Object>, Object> xj;
                    Object obj2 = obj;
                    if (com.bytedance.sdk.openadsdk.ai.hf.xj(obj2)) {
                        obj2 = new com.bytedance.sdk.openadsdk.ai.hf(obj);
                    }
                    ARc23Z A5SV6n2 = ARc23Z.A5SV6n(2);
                    SparseArray sparseArray = A5SV6n2.f4113A2egSU;
                    sparseArray.put(8, obj2);
                    A5SV6n2.ADYaiT(-99999987, 5);
                    sparseArray.put(-99999985, Void.class);
                    SparseArray sparseArray2 = A5SV6n2.A2egSU().sparseArray();
                    if (!(manager instanceof com.bytedance.sdk.openadsdk.api.w) || (xj = ((com.bytedance.sdk.openadsdk.api.w) manager).xj(1)) == null) {
                        return;
                    }
                    xj.apply(sparseArray2);
                }
            }, 5);
        }

        public Object xj(Object obj) {
            return obj;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdManager
        public String getBiddingToken(AdSlot adSlot, boolean z, int i) {
            Function<SparseArray<Object>, Object> xj;
            Object apply;
            if (com.bytedance.sdk.openadsdk.api.kd.xj()) {
                return null;
            }
            if (i <= 0) {
                i = adSlot.getAdType() > 0 ? adSlot.getAdType() : adSlot.getNativeAdType();
            }
            ARc23Z aRc23Z = new ARc23Z(com.bytedance.sdk.openadsdk.zg.xj.w.hf.xj(adSlot));
            aRc23Z.ASJ6gh(13, z);
            aRc23Z.ADYaiT(14, i);
            aRc23Z.ADYaiT(-99999987, 2);
            aRc23Z.f4113A2egSU.put(-99999985, String.class);
            ADYaiT A2egSU2 = aRc23Z.A2egSU();
            if (!(this.xj instanceof com.bytedance.sdk.openadsdk.api.w) || (xj = ((com.bytedance.sdk.openadsdk.api.w) this.xj).xj(1)) == null) {
                return null;
            }
            apply = xj.apply(A2egSU2.sparseArray());
            if (apply instanceof String) {
                return (String) apply;
            }
            return null;
        }

        public void xj(Throwable th) {
        }

        public void xj(boolean z) {
            this.hf = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xj(Manager manager, boolean z) {
            if (com.bytedance.sdk.openadsdk.api.kd.xj()) {
                return;
            }
            this.w = z;
            this.xj = manager;
            if (this.xj == null || !z) {
                return;
            }
            try {
                Iterator<hf<Manager>> it = this.u.keySet().iterator();
                while (it.hasNext()) {
                    it.next().xj(this.xj);
                }
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xj(hf<Manager> hfVar) {
            if (com.bytedance.sdk.openadsdk.api.kd.xj() || this.w) {
                return;
            }
            this.u.put(hfVar, null);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.api.xj$xj, reason: collision with other inner class name */
    public static abstract class AbstractC0132xj<T> {
        private AbstractC0132xj() {
        }

        public abstract void xj(hf<T> hfVar, int i);
    }

    public abstract w hf();

    public abstract void hf(Context context, ARc23Z aRc23Z);

    public boolean hf(Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        return false;
    }

    public abstract com.bytedance.sdk.openadsdk.w.w w();

    public void xj(Result result) {
    }

    public abstract boolean xj();

    public abstract boolean xj(Context context, ARc23Z aRc23Z);

    public static class kd extends com.bytedance.sdk.openadsdk.zg.xj.xj {
        private AbstractC0132xj<Loader> xj;

        public kd(AbstractC0132xj<Loader> abstractC0132xj) {
            this.xj = abstractC0132xj;
        }

        private void xj(hf<Loader> hfVar, int i) {
            y.hf("_tt_ad_sdk_", "load ad slot type: ".concat(String.valueOf(i)));
            this.xj.xj(hfVar, i);
        }

        @Override // com.bytedance.sdk.openadsdk.zg.xj.xj
        public void c(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            xj(new hf<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.xj.kd.9
                @Override // com.bytedance.sdk.openadsdk.api.xj.hf
                public void xj(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    ARc23Z aRc23Z = new ARc23Z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>());
                    aRc23Z.ASJ6gh(2, true);
                    aRc23Z.f4113A2egSU.put(1, function);
                    loader.load(5, aRc23Z.A2egSU(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.zg.xj.xj
        public void d(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            xj(new hf<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.xj.kd.2
                @Override // com.bytedance.sdk.openadsdk.api.xj.hf
                public void xj(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    ARc23Z aRc23Z = new ARc23Z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>());
                    aRc23Z.ASJ6gh(2, true);
                    aRc23Z.f4113A2egSU.put(1, function);
                    loader.load(1, aRc23Z.A2egSU(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.zg.xj.xj
        public void f(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            xj(new hf<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.xj.kd.10
                @Override // com.bytedance.sdk.openadsdk.api.xj.hf
                public void xj(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    ARc23Z aRc23Z = new ARc23Z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>());
                    aRc23Z.ASJ6gh(2, true);
                    aRc23Z.f4113A2egSU.put(1, function);
                    loader.load(9, aRc23Z.A2egSU(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.zg.xj.xj
        public void hf(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            xj(new hf<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.xj.kd.3
                @Override // com.bytedance.sdk.openadsdk.api.xj.hf
                public void xj(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    ARc23Z aRc23Z = new ARc23Z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>());
                    aRc23Z.f4113A2egSU.put(1, function);
                    loader.load(6, aRc23Z.A2egSU(), null);
                }
            }, 6);
        }

        @Override // com.bytedance.sdk.openadsdk.zg.xj.xj
        public void kd(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            xj(new hf<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.xj.kd.7
                @Override // com.bytedance.sdk.openadsdk.api.xj.hf
                public void xj(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    ARc23Z aRc23Z = new ARc23Z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>());
                    aRc23Z.f4113A2egSU.put(1, function);
                    loader.load(7, aRc23Z.A2egSU(), null);
                }
            }, 7);
        }

        @Override // com.bytedance.sdk.openadsdk.zg.xj.xj
        public void u(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            xj(new hf<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.xj.kd.5
                @Override // com.bytedance.sdk.openadsdk.api.xj.hf
                public void xj(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    ARc23Z aRc23Z = new ARc23Z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>());
                    aRc23Z.f4113A2egSU.put(1, function);
                    loader.load(1, aRc23Z.A2egSU(), null);
                }
            }, 1);
        }

        @Override // com.bytedance.sdk.openadsdk.zg.xj.xj
        public void w(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            xj(new hf<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.xj.kd.4
                @Override // com.bytedance.sdk.openadsdk.api.xj.hf
                public void xj(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    ARc23Z aRc23Z = new ARc23Z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>());
                    aRc23Z.f4113A2egSU.put(1, function);
                    loader.load(9, aRc23Z.A2egSU(), null);
                }
            }, 9);
        }

        @Override // com.bytedance.sdk.openadsdk.zg.xj.xj
        public void y(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            xj(new hf<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.xj.kd.8
                @Override // com.bytedance.sdk.openadsdk.api.xj.hf
                public void xj(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    ARc23Z aRc23Z = new ARc23Z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>());
                    aRc23Z.f4113A2egSU.put(1, function);
                    loader.load(8, aRc23Z.A2egSU(), null);
                }
            }, 8);
        }

        @Override // com.bytedance.sdk.openadsdk.zg.xj.xj
        public void xj(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function) {
            xj(new hf<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.xj.kd.1
                @Override // com.bytedance.sdk.openadsdk.api.xj.hf
                public void xj(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    ARc23Z aRc23Z = new ARc23Z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>());
                    aRc23Z.f4113A2egSU.put(1, function);
                    loader.load(5, aRc23Z.A2egSU(), null);
                }
            }, 5);
        }

        @Override // com.bytedance.sdk.openadsdk.zg.xj.xj
        public void xj(final ValueSet valueSet, final Function<SparseArray<Object>, Object> function, final int i) {
            xj(new hf<Loader>() { // from class: com.bytedance.sdk.openadsdk.api.xj.kd.6
                @Override // com.bytedance.sdk.openadsdk.api.xj.hf
                public void xj(Loader loader) {
                    ValueSet valueSet2 = valueSet;
                    ARc23Z aRc23Z = new ARc23Z(valueSet2 != null ? valueSet2.sparseArray() : new SparseArray<>());
                    aRc23Z.ADYaiT(3, i);
                    aRc23Z.f4113A2egSU.put(1, function);
                    loader.load(3, aRc23Z.A2egSU(), null);
                }
            }, 3);
        }

        @Override // com.bytedance.sdk.openadsdk.zg.xj.xj
        public Pair<Integer, String> xj(Exception exc) {
            y.u("_tt_ad_sdk_", "Load ad failed: " + exc.getMessage());
            if ((exc instanceof IllegalStateException) && "广告SDK未Ready, 请在load(请求广告）之前，先调用init and start方法，以避免无法请求广告".equals(exc.getMessage())) {
                return new Pair<>(4208, exc.getMessage());
            }
            return new Pair<>(Integer.valueOf(TTAdConstant.INIT_FAILED_CREATE_INVOKE_FAILED), CtFAbx.AZOQYO(exc, new StringBuilder("Load ad failed: ")));
        }
    }

    public void hf(Result result) {
        xj(result);
        if (result.isSuccess()) {
            y.hf("_tt_ad_sdk_", "init sdk success ");
            TTAdSdk.InitCallback initCallback = this.xj;
            if (initCallback != null) {
                initCallback.success();
            }
        } else {
            y.kd("_tt_ad_sdk_", "int sdk failed, code: " + result.code() + ", message: " + result.message());
            TTAdSdk.InitCallback initCallback2 = this.xj;
            if (initCallback2 != null) {
                initCallback2.fail(result.code(), result.message() != null ? result.message() : "");
            }
        }
        this.xj = null;
    }

    public void xj(final Context context, AdConfig adConfig, TTAdSdk.InitCallback initCallback) {
        if (com.bytedance.sdk.openadsdk.api.kd.xj()) {
            if (initCallback != null) {
                initCallback.fail(4209, "init csj sdk fail, that only support android os >= android 7.0（API-24）");
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.w.u.xj().xj(w());
        if (hf(context, adConfig, initCallback)) {
            this.xj = initCallback;
            final ARc23Z aRc23Z = new ARc23Z(com.bytedance.sdk.openadsdk.zg.xj.w.xj.xj(adConfig));
            aRc23Z.f4113A2egSU.put(1, Long.valueOf(SystemClock.elapsedRealtime()));
            aRc23Z.ARc23Z(5, "main");
            aRc23Z.ASJ6gh(4, true);
            aRc23Z.ADYaiT(6, 999);
            aRc23Z.ADYaiT(10, 7132);
            aRc23Z.ARc23Z(11, "7.1.3.2");
            aRc23Z.ARc23Z(12, "com.byted.pangle");
            aRc23Z.ASJ6gh(14, true);
            aRc23Z.AMqCpz(16, com.bytedance.sdk.openadsdk.w.u.xj());
            aRc23Z.AMqCpz(17, com.bytedance.sdk.openadsdk.yo.xj.xj().hf());
            Thread currentThread = Thread.currentThread();
            aRc23Z.ARc23Z(2, currentThread.getName());
            aRc23Z.ADYaiT(3, currentThread.getPriority());
            aRc23Z.AMqCpz(15, new u());
            aRc23Z.AMqCpz(8301, new MediationInitCLassLoader());
            if (!xj(context, aRc23Z)) {
                com.bytedance.sdk.openadsdk.yo.xj.xj().xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.api.xj.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xj.this.hf(context, aRc23Z);
                    }
                });
            }
            hf().xj(true);
        }
    }

    public void xj(Manager manager, boolean z) {
        y.hf("_tt_ad_sdk_", "update manager");
        hf().xj(manager, z);
        hf().register(com.bytedance.sdk.openadsdk.w.u.xj());
    }
}
