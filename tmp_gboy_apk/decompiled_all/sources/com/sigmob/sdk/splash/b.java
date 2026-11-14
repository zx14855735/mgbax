package com.sigmob.sdk.splash;

import android.content.Context;
import android.widget.RelativeLayout;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class b extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    protected int f13669a;

    public b(Context context) {
        super(context);
    }

    public static b a(Context context, BaseAdUnit baseAdUnit) {
        MaterialMeta material;
        Integer num;
        if (context == null || baseAdUnit == null || (material = baseAdUnit.getMaterial()) == null || (num = material.creative_type) == null) {
            return null;
        }
        return num.intValue() == n.CreativeTypeSplashVideo.a() ? new g(context, baseAdUnit) : new c(context);
    }

    public void b() {
    }

    public void c() {
    }

    public int getDuration() {
        return this.f13669a;
    }

    public void setAspectRatio(float f) {
    }

    public void a() {
        setVisibility(0);
    }

    public boolean a(BaseAdUnit baseAdUnit) {
        return false;
    }
}
