package com.bytedance.sdk.openadsdk.zg.xj.w;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w implements LocationProvider {
    private ValueSet xj;

    public w(ValueSet valueSet) {
        this.xj = valueSet == null ? ARc23Z.f4110A4TApA : valueSet;
    }

    public static SparseArray<Object> xj(LocationProvider locationProvider) {
        if (locationProvider == null) {
            return null;
        }
        ARc23Z A4TApA2 = ARc23Z.A4TApA();
        Double valueOf = Double.valueOf(locationProvider.getLatitude());
        SparseArray sparseArray = A4TApA2.f4113A2egSU;
        sparseArray.put(262001, valueOf);
        sparseArray.put(262002, Double.valueOf(locationProvider.getLongitude()));
        return A4TApA2.A2egSU().sparseArray();
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.xj.doubleValue(262001);
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.xj.doubleValue(262002);
    }
}
