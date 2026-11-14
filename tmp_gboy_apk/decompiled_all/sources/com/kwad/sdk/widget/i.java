package com.kwad.sdk.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.m;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class i {
    private final by aQG;
    private final k biH;
    private boolean biJ;
    private boolean biK;
    private ViewTreeObserver.OnScrollChangedListener biM;
    private final View mView;
    private final int oB;
    private float biI = 0.1f;
    private boolean biL = true;

    public i(View view, k kVar) {
        this.mView = view;
        this.biH = kVar;
        this.aQG = new by(view);
        this.oB = m.getScreenHeight(view.getContext());
    }

    private void MA() {
        if (this.biM == null) {
            return;
        }
        try {
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnScrollChangedListener(this.biM);
            }
            this.biM = null;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private void Mz() {
        if (this.biM == null) {
            this.biM = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.kwad.sdk.widget.i.1
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    if (i.this.UJ()) {
                        i.this.aS();
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.mView.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnScrollChangedListener(this.biM);
            }
        }
    }

    private void UI() {
        if (UJ()) {
            aS();
        } else {
            MA();
            Mz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean UJ() {
        if (this.aQG.Ug()) {
            if (Math.abs(this.aQG.bgF.height() - this.mView.getHeight()) <= (1.0f - this.biI) * this.mView.getHeight() && this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
                Rect rect = this.aQG.bgF;
                if (rect.bottom > 0 && rect.top < this.oB) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS() {
        try {
            MA();
            k kVar = this.biH;
            if (kVar != null) {
                kVar.G(this.mView);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void qC() {
        if (this.biL) {
            UI();
        }
    }

    public final void UH() {
        if (this.biK) {
            qC();
        }
    }

    public final void cs(boolean z) {
        this.biL = z;
    }

    public final void d(int i, int i2, int i3, int i4) {
        this.biK = false;
        if (this.biJ || (i3 | i4) != 0 || (i | i2) == 0) {
            return;
        }
        this.biK = true;
        this.biJ = true;
    }

    public final float getVisiblePercent() {
        return this.biI;
    }

    public final void onAttachedToWindow() {
        Mz();
    }

    public final void onDetachedFromWindow() {
        MA();
        this.biJ = false;
    }

    public final void setVisiblePercent(float f) {
        this.biI = f;
    }
}
