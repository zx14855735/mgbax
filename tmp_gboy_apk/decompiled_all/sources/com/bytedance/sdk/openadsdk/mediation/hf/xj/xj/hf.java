package com.bytedance.sdk.openadsdk.mediation.hf.xj.xj;

import IzHBwY.ARc23Z;
import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationManager;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.MediationAppDialogClickListener;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader;
import com.bytedance.sdk.openadsdk.mediation.hf.xj.hf.kd;
import com.bytedance.sdk.openadsdk.mediation.hf.xj.hf.u;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf implements IMediationManager {
    private Function<SparseArray<Object>, Object> xj;

    public hf(Function<SparseArray<Object>, Object> function) {
        hf(function);
    }

    private void hf(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            function = ARc23Z.f4112ADYaiT;
        }
        this.xj = function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public Map<String, Object> getMediationExtraInfo() {
        Object apply;
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(270024, sparseArray, -99999987, -99999985, Map.class);
        apply = this.xj.apply(sparseArray);
        return (Map) apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadDrawToken(Context context, AdSlot adSlot, IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, context);
        sparseArray.put(1, xj(adSlot));
        sparseArray.put(2, new com.bytedance.sdk.openadsdk.mediation.hf.xj.hf.xj(iMediationDrawAdTokenCallback));
        sparseArray.put(3, MediationAdClassLoader.getInstance());
        sparseArray.put(-99999987, 270022);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadNativeToken(Context context, AdSlot adSlot, IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, context);
        sparseArray.put(1, xj(adSlot));
        sparseArray.put(2, new com.bytedance.sdk.openadsdk.mediation.hf.xj.hf.w(iMediationNativeAdTokenCallback));
        sparseArray.put(3, MediationAdClassLoader.getInstance());
        sparseArray.put(-99999987, 270021);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public Object mtool(int i, SparseArray<Object> sparseArray) {
        Object apply;
        SparseArray sparseArray2 = new SparseArray(3);
        A2egSU.B2KMhB(271043, sparseArray2, -99999987, -99999985, Object.class);
        sparseArray2.put(0, Integer.valueOf(i));
        if (sparseArray != null) {
            sparseArray2.put(1, sparseArray);
        } else {
            sparseArray2.put(1, new SparseArray());
        }
        apply = this.xj.apply(sparseArray2);
        return apply;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void preload(Activity activity, List<IMediationPreloadRequestInfo> list, int i, int i2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, activity);
        if (list != null) {
            LinkedList linkedList = new LinkedList();
            Iterator<IMediationPreloadRequestInfo> it = list.iterator();
            while (it.hasNext()) {
                linkedList.add(new u(it.next()));
            }
            sparseArray.put(1, linkedList);
        }
        sparseArray.put(2, Integer.valueOf(i));
        sparseArray.put(3, Integer.valueOf(i2));
        sparseArray.put(4, MediationAdClassLoader.getInstance());
        sparseArray.put(-99999987, 270013);
        sparseArray.put(-99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void requestPermissionIfNecessary(Context context) {
        SparseArray sparseArray = new SparseArray(3);
        A2egSU.B2KMhB(270017, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, context);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setPulisherDid(String str) {
        SparseArray sparseArray = new SparseArray(2);
        A2egSU.B2KMhB(270015, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, str);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setThemeStatus(int i) {
        SparseArray sparseArray = new SparseArray(3);
        A2egSU.B2KMhB(270019, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, Integer.valueOf(i));
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        SparseArray sparseArray = new SparseArray(3);
        A2egSU.B2KMhB(270014, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj.w.xj(mediationConfigUserInfoForSegment));
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public int showOpenOrInstallAppDialog(MediationAppDialogClickListener mediationAppDialogClickListener) {
        Object apply;
        SparseArray sparseArray = new SparseArray(3);
        sparseArray.put(-99999987, 270020);
        sparseArray.put(-99999985, Integer.TYPE);
        sparseArray.put(0, new kd(mediationAppDialogClickListener));
        apply = this.xj.apply(sparseArray);
        return ((Integer) apply).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updateLocalExtra(Map<String, Object> map) {
        SparseArray sparseArray = new SparseArray(3);
        A2egSU.B2KMhB(271050, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, map);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updatePrivacyConfig(TTCustomController tTCustomController) {
        SparseArray sparseArray = new SparseArray(3);
        A2egSU.B2KMhB(270016, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, com.bytedance.sdk.openadsdk.zg.xj.w.u.xj(tTCustomController));
        this.xj.apply(sparseArray);
    }

    public void xj(Function<SparseArray<Object>, Object> function) {
        hf(function);
    }

    private SparseArray<Object> xj(AdSlot adSlot) {
        ARc23Z aRc23Z = new ARc23Z(com.bytedance.sdk.openadsdk.zg.xj.w.hf.xj(adSlot));
        aRc23Z.AMqCpz(8302, MediationAdClassLoader.getInstance());
        return aRc23Z.A2egSU().sparseArray();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void requestPermissionIfNecessary(Context context, int[] iArr) {
        SparseArray sparseArray = new SparseArray(3);
        A2egSU.B2KMhB(270018, sparseArray, -99999987, -99999985, Void.class);
        sparseArray.put(0, context);
        sparseArray.put(1, iArr);
        this.xj.apply(sparseArray);
    }
}
