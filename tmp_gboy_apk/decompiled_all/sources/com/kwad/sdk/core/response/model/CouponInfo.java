package com.kwad.sdk.core.response.model;

import ADYaiT.CtFAbx;
import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.d.c;
import java.io.Serializable;
import java.text.DecimalFormat;

@KsJson
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class CouponInfo extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b, Serializable {
    private static final float COUPON_DISCOUNT_THRESHOLD = 20.0f;
    public static final String JINNIIU_DISCOUNT = "2";
    public static final String JINNIIU_PRICE_BREAK_DISCOUNT = "1";
    private static final long serialVersionUID = -9143537899646897962L;
    public String displayActionWords;
    public String displayBase;
    public String displayDiscount;
    public String displayName;
    public String displayTitle;
    public String displayType;
    public String displayValue;
    public String endFetchTime;
    public String startFetchTime;

    public static String jinniuFormatCoupon(CouponInfo couponInfo) {
        if (couponInfo == null) {
            return null;
        }
        String displayType = couponInfo.getDisplayType();
        String rinToYuan = rinToYuan(couponInfo.getDisplayValue());
        displayType.getClass();
        if (displayType.equals("1")) {
            String rinToYuan2 = rinToYuan(couponInfo.getDisplayBase());
            if (!TextUtils.isEmpty(rinToYuan2) && !TextUtils.isEmpty(rinToYuan)) {
                return couponInfo.isNoPreRequirement() ? CtFAbx.BChYOn("¥", rinToYuan) : CtFAbx.AlLFFp(rinToYuan2, "减", rinToYuan);
            }
        } else if (displayType.equals("2") && !TextUtils.isEmpty(rinToYuan)) {
            try {
                if (Float.parseFloat(rinToYuan) >= COUPON_DISCOUNT_THRESHOLD) {
                    return "¥" + rinToYuan;
                }
                return couponInfo.getFormattedDisplayDiscount() + "折";
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static String rinToYuan(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new DecimalFormat("#.#").format(Float.parseFloat(str) / 1000.0f);
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            return null;
        }
    }

    public String getDisplayActionWords() {
        return this.displayActionWords;
    }

    public String getDisplayBase() {
        return this.displayBase;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getDisplayTitle() {
        return this.displayTitle;
    }

    public String getDisplayType() {
        return this.displayType;
    }

    public String getDisplayValue() {
        return this.displayValue;
    }

    public String getEndFetchTime() {
        return this.endFetchTime;
    }

    public String getFormattedDisplayDiscount() {
        try {
            return new DecimalFormat("#.#").format(Float.valueOf(this.displayDiscount).floatValue() / 10.0f);
        } catch (Exception e) {
            c.printStackTraceOnly(e);
            return null;
        }
    }

    public String getFormattedJinniuPrefix() {
        String displayType = getDisplayType();
        if (isNoPreRequirement()) {
            return "券";
        }
        if ("1".equals(displayType)) {
            return "满";
        }
        if ("2".equals(displayType)) {
            return "券";
        }
        return null;
    }

    public String getStartFetchTime() {
        return this.startFetchTime;
    }

    public boolean isNoPreRequirement() {
        String str = this.displayBase;
        if (str == null) {
            return false;
        }
        return Float.parseFloat(str) <= 0.0f;
    }

    public void setDisplayDiscount(String str) {
        this.displayDiscount = str;
    }

    public void setEndFetchTime(String str) {
        this.endFetchTime = str;
    }

    public void setStartFetchTime(String str) {
        this.startFetchTime = str;
    }
}
