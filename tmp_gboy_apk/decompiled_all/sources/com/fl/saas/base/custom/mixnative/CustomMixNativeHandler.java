package com.fl.saas.base.custom.mixnative;

import android.content.Context;
import android.text.TextUtils;
import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.annotation.MixNativeLoad;
import com.fl.saas.base.custom.MedProConst;
import com.fl.saas.base.innterNative.NativeStyle;
import com.fl.saas.base.widget.JsonUtil;
import com.fl.saas.config.exception.YdError;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class CustomMixNativeHandler extends MixNativeHandler {
    @MixNativeLoad
    public void handle() {
        HashMap hashMap = new HashMap();
        hashMap.put(MedProConst.AD_APPID, getAdSource().app_id);
        hashMap.put(MedProConst.AD_PLACEID, getAdSource().tagid);
        hashMap.put(MedProConst.AD_APPKEY, getAdSource().app_key);
        if (!TextUtils.isEmpty(getAdSource().customParameJson)) {
            hashMap.clear();
            hashMap.putAll(JsonUtil.jsonObjectToMap(getAdSource().customParameJson));
        }
        if (getAdStyle() == NativeStyle.EXPRESS) {
            loadExpress(getContext(), hashMap, getAdParams().getExpressWidth(), getAdParams().getExpressHeight());
        } else {
            loadNative(getContext(), hashMap);
        }
    }

    @Override // com.fl.saas.base.adapter.MixNativeHandler
    public void init() {
    }

    public abstract void loadExpress(Context context, Map<String, Object> map, float f, float f2);

    public abstract void loadNative(Context context, Map<String, Object> map);

    public void onNativeAdLoadError(int i, String str) {
        onAdFailed(YdError.create(i, str));
    }
}
