package io.dcloud.api.custom.type.feed;

import android.view.View;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaa0;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class UniAdCustomNativeAd {
    private int aaaaaaa0 = 0;
    protected aaaaaaa0 aaaaaaaa;

    public void aaaaaaaa(aaaaaaa0 aaaaaaa0Var) {
        this.aaaaaaaa = aaaaaaa0Var;
        render();
    }

    public abstract void destroy();

    public final int getBidPrice() {
        return this.aaaaaaa0;
    }

    public abstract View getNativeAd();

    public final void onAdClicked() {
        aaaaaaa0 aaaaaaa0Var = this.aaaaaaaa;
        if (aaaaaaa0Var != null) {
            aaaaaaa0Var.onAdClicked();
        }
    }

    public final void onAdClosed(String str) {
        aaaaaaa0 aaaaaaa0Var = this.aaaaaaaa;
        if (aaaaaaa0Var != null) {
            aaaaaaa0Var.aaaaaaaa(str);
        }
    }

    public final void onAdShow() {
        aaaaaaa0 aaaaaaa0Var = this.aaaaaaaa;
        if (aaaaaaa0Var != null) {
            aaaaaaa0Var.onAdShow();
        }
    }

    public void onBidFail(int i, int i2) {
    }

    public void onBidSuccess(int i, int i2) {
    }

    public void onRenderFail(int i, String str) {
        aaaaaaa0 aaaaaaa0Var = this.aaaaaaaa;
        if (aaaaaaa0Var != null) {
            aaaaaaa0Var.onRenderFail();
        }
    }

    public void onRenderSuccess() {
        aaaaaaa0 aaaaaaa0Var = this.aaaaaaaa;
        if (aaaaaaa0Var != null) {
            aaaaaaa0Var.onRenderSuccess();
        }
    }

    public final void onShowError(int i, String str) {
        aaaaaaa0 aaaaaaa0Var = this.aaaaaaaa;
        if (aaaaaaa0Var != null) {
            aaaaaaa0Var.onShowError(i, str);
        }
    }

    public abstract void render();

    public final void setBidPrice(int i) {
        this.aaaaaaa0 = i;
    }
}
