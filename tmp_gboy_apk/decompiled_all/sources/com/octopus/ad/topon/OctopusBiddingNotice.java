package com.octopus.ad.topon;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBiddingNotice;
import com.octopus.ad.ADBidEvent;
import com.octopus.ad.IBidding;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class OctopusBiddingNotice implements ATBiddingNotice {
    private IBidding octopusAd;

    public OctopusBiddingNotice(IBidding iBidding) {
        this.octopusAd = iBidding;
    }

    public ATAdConst.CURRENCY getNoticePriceCurrency() {
        return ATAdConst.CURRENCY.RMB_CENT;
    }

    public void notifyBidDisplay(boolean z, double d) {
    }

    public void notifyBidLoss(String str, double d, Map<String, Object> map) {
        String str2;
        if (this.octopusAd != null) {
            str.getClass();
            switch (str) {
                case "2":
                    str2 = ADBidEvent.TIMEOUT_FILTER;
                    break;
                case "102":
                case "103":
                    str2 = ADBidEvent.PRICE_LOW_FILTER;
                    break;
                default:
                    str2 = ADBidEvent.OTHER;
                    break;
            }
            this.octopusAd.sendLossNotice((int) d, str2, ADBidEvent.OTHER);
            this.octopusAd = null;
        }
    }

    public void notifyBidWin(double d, double d2, Map<String, Object> map) {
        IBidding iBidding = this.octopusAd;
        if (iBidding != null) {
            iBidding.sendWinNotice((int) d2);
            this.octopusAd = null;
        }
    }
}
