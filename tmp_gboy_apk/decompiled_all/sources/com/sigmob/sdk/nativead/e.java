package com.sigmob.sdk.nativead;

import android.content.Context;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.TouchLocation;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.models.rtb.NativeAdSetting;
import com.sigmob.sdk.base.models.rtb.SingleNativeAdSetting;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e extends com.sigmob.sdk.base.common.i {
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private Boolean s;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i, int i2, int i3, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            Map<String, String> options = pointEntitySigmob.getOptions();
            options.put("video_time", String.valueOf(i));
            options.put("begin_time", String.valueOf(i2));
            options.put("end_time", String.valueOf(i3));
            options.put("is_first", String.valueOf(i2 == 0 ? 1 : 0));
            options.put("is_last", String.valueOf(i3 >= i + (-1000) ? 1 : 0));
            pointEntitySigmob.setOptions(options);
        }
    }

    public static e d(BaseAdUnit baseAdUnit) {
        e eVar = new e();
        eVar.b(baseAdUnit);
        return eVar;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void b(BaseAdUnit baseAdUnit) {
        super.b(baseAdUnit);
        NativeAdSetting nativeAdSetting = baseAdUnit.getNativeAdSetting();
        SingleNativeAdSetting singleNativeSetting = baseAdUnit.getSingleNativeSetting();
        if (singleNativeSetting != null) {
            this.r = singleNativeSetting.use_na_video_component.booleanValue();
        }
        if (nativeAdSetting != null) {
            this.m = nativeAdSetting.preview_page_video_mute.intValue();
            this.n = nativeAdSetting.detail_page_video_mute.intValue();
            this.o = nativeAdSetting.impression_percent.intValue();
            this.p = nativeAdSetting.impression_time.intValue();
            this.l = nativeAdSetting.video_auto_play.intValue();
            this.q = nativeAdSetting.end_impression_time.intValue();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.sigmob.sdk.videoAd.d(com.sigmob.sdk.base.common.a.k, 0.25f));
        arrayList.add(new com.sigmob.sdk.videoAd.d(com.sigmob.sdk.base.common.a.m, 0.5f));
        arrayList.add(new com.sigmob.sdk.videoAd.d(com.sigmob.sdk.base.common.a.n, 0.75f));
        a((List<com.sigmob.sdk.videoAd.d>) arrayList);
    }

    public void c(Context context, BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.common.ae.a(PointCategory.TEMPLATE_SHOW, (String) null, baseAdUnit);
    }

    public void e(Context context, BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.common.ae.b("ad_show", null, baseAdUnit);
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "ad_show");
    }

    public void f(Context context, BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.common.ae.b("feed_click", null, baseAdUnit);
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "feed_click");
    }

    public boolean l() {
        return this.r;
    }

    public int m() {
        return this.l;
    }

    public boolean n() {
        Boolean bool = this.s;
        return bool != null ? bool.booleanValue() : this.m == 0;
    }

    public boolean o() {
        return this.n != 0;
    }

    public int p() {
        return this.o;
    }

    public int q() {
        return this.p;
    }

    public int r() {
        return this.q;
    }

    public int s() {
        int i = this.o;
        if (i >= 0) {
            return i;
        }
        return 50;
    }

    public int t() {
        int i = this.p;
        if (i >= 0) {
            return i;
        }
        return 1;
    }

    public boolean u() {
        int m = m();
        return m == 0 || (m == 1 && ClientMetadata.getInstance().getActiveNetworkType() == 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(int i, int i2, Object obj) {
        if (obj instanceof PointEntitySigmob) {
            PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
            Map<String, String> options = pointEntitySigmob.getOptions();
            options.put("video_time", String.valueOf(i));
            options.put("begin_time", String.valueOf(i2));
            pointEntitySigmob.setOptions(options);
        }
    }

    public void d(Context context, BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.common.ae.a(PointCategory.TEMPLATE_CLOSE, (String) null, baseAdUnit);
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(Context context, TouchLocation touchLocation, TouchLocation touchLocation2, com.sigmob.sdk.base.a aVar, BaseAdUnit baseAdUnit) {
        String coordinate;
        SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
        if (macroCommon == null) {
            coordinate = "";
        } else {
            macroCommon.updateClickMarco(touchLocation, touchLocation2);
            coordinate = macroCommon.getCoordinate();
        }
        a(aVar, coordinate, true);
    }

    public void a(BaseAdUnit baseAdUnit, int i, int i2) {
        com.sigmob.sdk.base.common.ae.a("video_start", (String) null, baseAdUnit, new com.fl.saas.s2s.sdk.helper.ADYaiT(i, i2));
        SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
        macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(i2));
        macroCommon.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(i));
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "video_start");
    }

    public void a(BaseAdUnit baseAdUnit, final int i, final int i2, final int i3) {
        com.sigmob.sdk.base.common.ae.a("video_pause", (String) null, baseAdUnit, new ae.a() { // from class: com.sigmob.sdk.nativead.AZOQYO
            @Override // com.sigmob.sdk.base.common.ae.a
            public final void onAddExtra(Object obj) {
                e.a(i3, i2, i, obj);
            }
        });
        SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
        macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(i3));
        macroCommon.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(i2));
        macroCommon.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(i));
        macroCommon.addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, String.valueOf(i2 == 0 ? 1 : 0));
        macroCommon.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(i));
        macroCommon.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(i));
        com.sigmob.sdk.base.network.g.a(baseAdUnit, "video_pause");
    }

    public void a(boolean z) {
        this.s = Boolean.valueOf(z);
    }
}
