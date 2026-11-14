package com.sigmob.sdk.videoAd;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;
import com.sigmob.sdk.base.views.y;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class i extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private y f13701a;
    private final int b;

    public i(Context context) {
        super(context);
        y yVar = new y(context);
        this.f13701a = yVar;
        setImageDrawable(yVar);
        this.b = Dips.dipsToIntPixels(2.0f, context);
    }

    public void a() {
        this.f13701a.a();
        this.f13701a.a(0);
    }

    @Deprecated
    public y getImageViewDrawable() {
        return this.f13701a;
    }

    public void setAnchorId(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.b);
        layoutParams.addRule(8, i);
        setLayoutParams(layoutParams);
    }

    @Deprecated
    public void setImageViewDrawable(y yVar) {
        this.f13701a = yVar;
    }

    public void a(int i) {
        this.f13701a.a(i);
    }

    public void a(int i, int i2) {
        this.f13701a.a(i, i2);
        setVisibility(0);
    }
}
