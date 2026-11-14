package io.dcloud.api.custom.type;

import android.app.Activity;
import io.dcloud.api.custom.base.UniAdConst;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.feed.UniAdCustomNativeAd;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.naaaaaaa.aaaaaaaa;
import io.dcloud.openapi.core.module.DCBaseAOL;
import io.dcloud.openapi.core.util.AOLErrorUtil;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class UniAdCustomBaseLoader {
    protected aaaaaaaa aaaaaaaa;

    public final void aaaaaaaa(Activity activity, UniAdSlot uniAdSlot, aaaaaaaa aaaaaaaaVar) {
        this.aaaaaaaa = aaaaaaaaVar;
        try {
            load(activity, uniAdSlot);
        } catch (Throwable unused) {
            onLoadFail(-4002, AOLErrorUtil.getErrorMsg(-4002));
        }
    }

    public abstract void destroy();

    @UniAdConst.CustomBidType
    public int getBidType() {
        aaaaaaaa aaaaaaaaVar = this.aaaaaaaa;
        if (aaaaaaaaVar != null) {
            return aaaaaaaaVar.aaaaaeaa();
        }
        return 0;
    }

    public abstract boolean isReady();

    public abstract void load(Activity activity, UniAdSlot uniAdSlot);

    public void onAdClicked() {
        aaaaaaaa aaaaaaaaVar = this.aaaaaaaa;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.onAdClicked();
        }
    }

    public void onAdClosed() {
        aaaaaaaa aaaaaaaaVar = this.aaaaaaaa;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaan();
        }
    }

    public void onAdPlayEnd() {
        aaaaaaaa aaaaaaaaVar = this.aaaaaaaa;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaao();
        }
    }

    public void onAdPlayError(int i, String str) {
        aaaaaaaa aaaaaaaaVar = this.aaaaaaaa;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaaa(i, str);
        }
    }

    public void onAdShow() {
        aaaaaaaa aaaaaaaaVar = this.aaaaaaaa;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.onAdShow();
        }
    }

    public void onAdSkip() {
        aaaaaaaa aaaaaaaaVar = this.aaaaaaaa;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaau();
        }
    }

    public void onBidFail(int i, int i2) {
    }

    public void onBidSuccess(int i, int i2) {
    }

    public void onLoadFail(int i, String str) {
        aaaaaaaa aaaaaaaaVar = this.aaaaaaaa;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaa0(i, str);
        }
    }

    public void onLoadSuccess(List<? extends UniAdCustomNativeAd> list) {
        aaaaaaaa aaaaaaaaVar = this.aaaaaaaa;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaaa(list);
        }
    }

    public void setBidPrice(int i) {
        Object obj = this.aaaaaaaa;
        if ((obj instanceof DCBaseAOL) && ((DCBaseAOL) obj).isSlotSupportBidding()) {
            ((DCBaseAOL) this.aaaaaaaa).setBiddingECPM(i);
        }
    }

    public abstract void show(Object obj);

    public void onLoadSuccess() {
        aaaaaaaa aaaaaaaaVar = this.aaaaaaaa;
        if (aaaaaaaaVar != null) {
            aaaaaaaaVar.aaaaaaeo();
        }
    }
}
