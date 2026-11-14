package com.sigmob.sdk.base.views;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.Dips;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class as extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private y f13273a;
    private final int b;

    public as(Context context) {
        super(context);
        y yVar = new y(context);
        this.f13273a = yVar;
        setImageDrawable(yVar);
        this.b = Dips.dipsToIntPixels(2.0f, context);
    }

    public void a(int i) {
        this.f13273a.a(i);
    }

    @Deprecated
    public y getImageViewDrawable() {
        return this.f13273a;
    }

    public void setAnchorId(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.b);
        layoutParams.addRule(12, i);
        setLayoutParams(layoutParams);
    }

    @Deprecated
    public void setImageViewDrawable(y yVar) {
        this.f13273a = yVar;
    }

    public void a(int i, int i2) {
        this.f13273a.a(i, i2);
        setVisibility(0);
    }
}
