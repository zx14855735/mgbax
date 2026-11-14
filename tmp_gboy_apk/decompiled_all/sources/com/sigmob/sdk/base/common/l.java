package com.sigmob.sdk.base.common;

import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.VideoStatusCommon;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointParamKey;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class l implements t {

    /* renamed from: a, reason: collision with root package name */
    protected final String f13144a = getClass().getSimpleName();

    public void a(BaseAdUnit baseAdUnit, String str, String str2, HashMap<String, String> hashMap) {
        ae.a(str, str2, baseAdUnit, new ARc23Z(hashMap, 1));
    }

    public void a(BaseAdUnit baseAdUnit, String str, boolean z, String str2) {
        SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
        VideoStatusCommon videoCommon = baseAdUnit.getVideoCommon();
        macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(videoCommon.video_time));
        macroCommon.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(videoCommon.begin_time));
        macroCommon.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(videoCommon.end_time));
        macroCommon.addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, String.valueOf(videoCommon.is_first));
        macroCommon.addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, String.valueOf(videoCommon.is_last));
        macroCommon.addMarcoKey(SigMacroCommon._SCENE_, String.valueOf(videoCommon.scene));
        macroCommon.addMarcoKey(SigMacroCommon._TYPE_, String.valueOf(videoCommon.type));
        macroCommon.addMarcoKey(SigMacroCommon._BEHAVIOR_, String.valueOf(videoCommon.is_auto_play));
        macroCommon.addMarcoKey(SigMacroCommon._STATUS_, String.valueOf(videoCommon.status));
        com.sigmob.sdk.base.network.g.a(baseAdUnit, str, z);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("video_time", String.valueOf(videoCommon.video_time));
        hashMap.put("begin_time", String.valueOf(videoCommon.begin_time));
        hashMap.put("end_time", String.valueOf(videoCommon.end_time));
        hashMap.put("is_first", String.valueOf(videoCommon.is_first));
        hashMap.put("scene", String.valueOf(videoCommon.scene));
        hashMap.put(PointParamKey.TYPE, String.valueOf(videoCommon.type));
        hashMap.put("is_auto_play", String.valueOf(videoCommon.is_auto_play));
        hashMap.put("status", String.valueOf(videoCommon.status));
        a(baseAdUnit, str2, (String) null, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(HashMap hashMap, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            if (com.sigmob.sdk.base.utils.e.b(hashMap)) {
                pointEntitySigmob.getOptions().putAll(hashMap);
            }
        }
    }

    @Override // com.sigmob.sdk.base.common.t
    public boolean a(BaseAdUnit baseAdUnit) {
        return true;
    }

    @Override // com.sigmob.sdk.base.common.t
    public boolean a(BaseAdUnit baseAdUnit, int i, int i2) {
        return false;
    }

    @Override // com.sigmob.sdk.base.common.t
    public boolean a(BaseAdUnit baseAdUnit, boolean z, int i) {
        return false;
    }
}
