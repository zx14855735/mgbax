package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.R;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class g extends c {
    public g(Context context) {
        super(context);
        setmIsShowComplianceView(false);
        setRadiusDp(4);
    }

    @Override // com.kwad.components.ad.feed.widget.c, com.kwad.components.core.widget.b
    public final void bv() {
        super.bv();
        View findViewById = findViewById(R.id.ksad_feed_biserial_video);
        if (findViewById != null) {
            findViewById.setClipToOutline(true);
        }
    }

    @Override // com.kwad.components.ad.feed.widget.c
    public final void cq() {
        this.hL.setRatio(1.7857143f);
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_biserial_video;
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i) {
        if (com.kwad.sdk.core.config.e.HW()) {
            return;
        }
        setBackgroundColor(-1);
    }
}
