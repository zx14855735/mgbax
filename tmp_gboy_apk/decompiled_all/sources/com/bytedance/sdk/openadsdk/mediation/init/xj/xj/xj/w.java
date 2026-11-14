package com.bytedance.sdk.openadsdk.mediation.init.xj.xj.xj;

import IzHBwY.ARc23Z;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    public static final SparseArray<Object> xj(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        ARc23Z A4TApA2 = ARc23Z.A4TApA();
        if (mediationConfigUserInfoForSegment == null) {
            return null;
        }
        A4TApA2.AMqCpz(265007, mediationConfigUserInfoForSegment.getCustomInfos());
        A4TApA2.ARc23Z(265001, mediationConfigUserInfoForSegment.getUserId());
        A4TApA2.ARc23Z(265002, mediationConfigUserInfoForSegment.getChannel());
        A4TApA2.ARc23Z(265003, mediationConfigUserInfoForSegment.getSubChannel());
        A4TApA2.ADYaiT(265004, mediationConfigUserInfoForSegment.getAge());
        A4TApA2.ARc23Z(265005, mediationConfigUserInfoForSegment.getGender());
        A4TApA2.ARc23Z(265006, mediationConfigUserInfoForSegment.getUserValueGroup());
        return A4TApA2.A2egSU().sparseArray();
    }
}
