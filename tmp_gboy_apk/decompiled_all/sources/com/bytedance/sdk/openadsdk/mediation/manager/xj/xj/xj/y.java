package com.bytedance.sdk.openadsdk.mediation.manager.xj.xj.xj;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdLoadInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager;
import com.bytedance.sdk.openadsdk.zg.xj.xj.qt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y implements MediationSplashManager {
    private final Function<SparseArray<Object>, Object> xj;

    public y(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? ARc23Z.f4112ADYaiT : function;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager
    public void destroy() {
        SparseArray sparseArray = new SparseArray(1);
        A2egSU.B2KMhB(270007, sparseArray, -99999987, -99999985, Void.class);
        this.xj.apply(sparseArray);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdLoadInfo> getAdLoadInfo() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        A2egSU.B2KMhB(270002, sparseArray, -99999987, -99999985, List.class);
        apply = this.xj.apply(sparseArray);
        List list = (List) apply;
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new hf(qt.xj(it.next())));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getBestEcpm() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999985, Object.class);
        sparseArray.put(-99999987, 270004);
        apply = this.xj.apply(sparseArray);
        return new xj(qt.xj(apply));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getCacheList() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        A2egSU.B2KMhB(270005, sparseArray, -99999987, -99999985, List.class);
        apply = this.xj.apply(sparseArray);
        List list = (List) apply;
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new xj(qt.xj(it.next())));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public List<MediationAdEcpmInfo> getMultiBiddingEcpm() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        A2egSU.B2KMhB(270003, sparseArray, -99999987, -99999985, List.class);
        apply = this.xj.apply(sparseArray);
        List list = (List) apply;
        if (list == null) {
            list = new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new xj(qt.xj(it.next())));
        }
        return arrayList;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public MediationAdEcpmInfo getShowEcpm() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 270006);
        sparseArray.put(-99999985, Object.class);
        apply = this.xj.apply(sparseArray);
        return new xj(qt.xj(apply));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.MediationBaseManager
    public boolean isReady() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        sparseArray.put(-99999987, 270001);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }
}
