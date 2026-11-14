package com.baidu.mobads.sdk.api;

import com.baidu.mobads.sdk.internal.bv;
import com.sigmob.sdk.base.mta.PointParamKey;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BDDialogParams {
    public static final int ANIM_STYLE_BREATHE = 1;
    public static final int ANIM_STYLE_GUIDE = 3;
    public static final int ANIM_STYLE_NONE = 0;
    public static final int ANIM_STYLE_SWIPE = 2;
    public static final int TYPE_BOTTOM_POPUP = 0;
    public static final int TYPE_CENTER_DECORATE = 2;
    public static final int TYPE_CENTER_NORMAL = 1;
    private final Builder mBuilder;

    public static class Builder {
        private int mDlDialogType = 0;
        private int mDlDialogAnimStyle = 0;

        public BDDialogParams build() {
            return new BDDialogParams(this);
        }

        public Builder setDlDialogAnimStyle(int i) {
            this.mDlDialogAnimStyle = i;
            return this;
        }

        public Builder setDlDialogType(int i) {
            this.mDlDialogType = i;
            return this;
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PointParamKey.TYPE, this.mBuilder.mDlDialogType);
            jSONObject.put("anim_style", this.mBuilder.mDlDialogAnimStyle);
            return jSONObject;
        } catch (JSONException e) {
            bv.a().a(e);
            return jSONObject;
        }
    }

    private BDDialogParams(Builder builder) {
        this.mBuilder = builder;
    }
}
