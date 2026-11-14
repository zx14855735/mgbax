package com.kwad.components.ad.reward.model;

import android.text.TextUtils;
import com.kwad.components.ad.reward.n.r;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class a {
    private String liveStartTime;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private String originPrice;
    private int playableStyle;
    private String price;
    private String ta;
    private String tb;
    private String title;
    private List<String> uU;
    private String uV;
    private String uW;
    private String uX;
    private boolean uY;
    private String uZ;
    private String va = "查看详情";
    private String vb = "立即预约";
    private List<String> vc;
    private AdTemplate vd;

    public static a R(AdTemplate adTemplate) {
        CouponInfo firstCouponList;
        if (adTemplate == null) {
            return null;
        }
        AdInfo er = e.er(adTemplate);
        AdProductInfo cW = com.kwad.sdk.core.response.b.a.cW(er);
        a aVar = new a();
        String name = cW.getName();
        aVar.title = name;
        if (TextUtils.isEmpty(name)) {
            aVar.title = com.kwad.sdk.core.response.b.a.ay(er);
        }
        aVar.ta = cW.getIcon();
        aVar.tb = com.kwad.sdk.core.response.b.a.av(er);
        aVar.price = cW.getPrice();
        aVar.originPrice = cW.getOriginPrice();
        if (!cW.isCouponListEmpty() && (firstCouponList = cW.getFirstCouponList()) != null) {
            aVar.T(CouponInfo.jinniuFormatCoupon(firstCouponList));
            aVar.S(firstCouponList.getFormattedJinniuPrefix());
        }
        return aVar;
    }

    public static a S(AdTemplate adTemplate) {
        AdMatrixInfo.MerchantLiveReservationInfo dx = com.kwad.sdk.core.response.b.b.dx(adTemplate);
        a aVar = new a();
        aVar.ta = dx.userHeadUrl;
        aVar.liveStartTime = dx.liveStartTime;
        aVar.title = dx.title;
        aVar.uY = dx.needShowSubscriberCount();
        aVar.uZ = dx.getFormattedLiveSubscribeCount();
        aVar.vc = dx.bookUserUrlList;
        AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo = dx.playEndCard;
        aVar.va = liveReservationPlayEndInfo.detailBtnTitle;
        aVar.vb = liveReservationPlayEndInfo.reservationBtnTitle;
        aVar.vd = adTemplate;
        return aVar;
    }

    private void T(String str) {
        this.uX = str;
    }

    public static a a(r rVar, boolean z) {
        AdTemplate adTemplate;
        if (rVar == null || (adTemplate = rVar.getAdTemplate()) == null) {
            return null;
        }
        AdInfo er = e.er(adTemplate);
        a aVar = new a();
        aVar.title = com.kwad.sdk.core.response.b.a.cm(er);
        aVar.ta = com.kwad.sdk.core.response.b.a.cp(er);
        aVar.tb = com.kwad.sdk.core.response.b.a.av(er);
        aVar.uU = com.kwad.sdk.core.response.b.d.ei(adTemplate);
        aVar.uV = com.kwad.sdk.core.response.b.a.aF(er);
        aVar.playableStyle = e.l(adTemplate, z);
        aVar.vd = adTemplate;
        aVar.mApkDownloadHelper = rVar.ik();
        return aVar;
    }

    public final String getOriginPrice() {
        return this.originPrice;
    }

    public final String getPrice() {
        return this.price;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String hp() {
        return this.ta;
    }

    public final String hq() {
        return this.tb;
    }

    public final String ih() {
        return this.uX;
    }

    public final String ii() {
        return this.uW;
    }

    public final AdTemplate ij() {
        return this.vd;
    }

    public final com.kwad.components.core.e.d.d ik() {
        return this.mApkDownloadHelper;
    }

    public final List<String> il() {
        return this.uU;
    }

    public final boolean im() {
        List<String> list = this.uU;
        return list == null || list.size() == 0;
    }

    public final int in() {
        return this.playableStyle;
    }

    public final String io() {
        return this.uZ;
    }

    public final String ip() {
        return this.vb;
    }

    public final boolean iq() {
        return this.uY;
    }

    public final List<String> ir() {
        return this.vc;
    }

    public final String is() {
        return this.liveStartTime;
    }

    private void S(String str) {
        this.uW = str;
    }
}
