package com.bytedance.sdk.openadsdk.live.xj;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.android.live.base.api.IHostPermission;
import com.bytedance.android.live.base.api.LocationProvider;
import com.bytedance.sdk.openadsdk.zg.xj.w.w;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements IHostPermission {
    private final Function<SparseArray<Object>, Object> xj;

    public xj(Function<SparseArray<Object>, Object> function) {
        this.xj = function == null ? ARc23Z.f4112ADYaiT : function;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean alist() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 262103);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getAndroidID() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(262112, sparseArray, -99999987, -99999985, String.class);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevImei() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(262105, sparseArray, -99999987, -99999985, String.class);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getDevOaid() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(262109, sparseArray, -99999987, -99999985, String.class);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public String getMacAddress() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        A2egSU.B2KMhB(262107, sparseArray, -99999987, -99999985, String.class);
        apply = this.xj.apply(sparseArray);
        return (String) apply;
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public LocationProvider getTTLocation() {
        Object apply;
        SparseArray sparseArray = new SparseArray(1);
        A2egSU.B2KMhB(262102, sparseArray, -99999987, -99999985, com.bytedance.sdk.openadsdk.LocationProvider.class);
        apply = this.xj.apply(sparseArray);
        final w wVar = apply instanceof SparseArray ? new w(A2egSU.AMqCpz((SparseArray) apply)) : null;
        if (wVar == null) {
            return null;
        }
        return new LocationProvider() { // from class: com.bytedance.sdk.openadsdk.live.xj.xj.1
            @Override // com.bytedance.android.live.base.api.LocationProvider
            public double getLatitude() {
                return wVar.getLatitude();
            }

            @Override // com.bytedance.android.live.base.api.LocationProvider
            public double getLongitude() {
                return wVar.getLongitude();
            }
        };
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanGetAndUseAndroidID() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 262110);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseLocation() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 262101);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUsePhoneState() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 262104);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWifiState() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 262106);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }

    @Override // com.bytedance.android.live.base.api.IHostPermission
    public boolean isCanUseWriteExternal() {
        Object apply;
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 262108);
        sparseArray.put(-99999985, Boolean.TYPE);
        apply = this.xj.apply(sparseArray);
        return ((Boolean) apply).booleanValue();
    }
}
