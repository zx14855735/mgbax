package com.kwad.components.core.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.FrameLayout;
import com.kwad.sdk.utils.aq;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class f extends FrameLayout {
    private boolean ang;
    protected g kQ;
    protected boolean li;
    protected Context mContext;

    public f(Context context) {
        super(context);
        this.mContext = context;
        this.li = aq.SM();
    }

    private void xH() {
        boolean SM = aq.SM();
        if (!this.ang || SM == this.li) {
            return;
        }
        this.li = SM;
        g gVar = this.kQ;
        if (gVar != null) {
            gVar.k(!SM);
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        xH();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.ang = i == 0;
        xH();
    }

    public final void setOrientationChangeListener(g gVar) {
        this.kQ = gVar;
    }
}
