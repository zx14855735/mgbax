package com.sigmob.sdk.newInterstitial;

import Cd8JRx.ADYaiT;
import android.os.Bundle;
import com.sigmob.sdk.base.BaseAdActivity;
import com.sigmob.sdk.base.common.AdActivity;
import com.sigmob.sdk.base.common.TransparentAdActivity;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.common.p;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.windad.WindAdRequest;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class f extends com.sigmob.sdk.mraid.i {
    public f(p pVar) {
        super(pVar);
    }

    private static boolean c(MaterialMeta materialMeta) {
        return materialMeta.creative_type.intValue() == n.CreativeTypeNewInterstitial.a() && materialMeta.template_id.intValue() != 0;
    }

    public static boolean d(BaseAdUnit baseAdUnit) {
        boolean c = com.sigmob.sdk.mraid.i.c(baseAdUnit);
        MaterialMeta material = baseAdUnit.getMaterial();
        return c && (b(material) || c(material));
    }

    @Override // com.sigmob.sdk.mraid.i, com.sigmob.sdk.base.common.y
    public void a(p pVar) {
        super.a(pVar);
    }

    @Override // com.sigmob.sdk.mraid.i, com.sigmob.sdk.base.common.y
    public void b(BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.common.h.b(baseAdUnit);
        super.b(baseAdUnit);
    }

    private static boolean b(MaterialMeta materialMeta) {
        return materialMeta.creative_type.intValue() == n.CreativeTypeMRAIDTWO.a();
    }

    @Override // com.sigmob.sdk.mraid.i, com.sigmob.sdk.base.common.y
    public void a(BaseAdUnit baseAdUnit, Bundle bundle) {
        com.sigmob.sdk.base.common.h.a(baseAdUnit);
        super.a(baseAdUnit, bundle);
        if (this.f13165a instanceof e) {
            NewInterstitialAdBroadcastReceiver newInterstitialAdBroadcastReceiver = new NewInterstitialAdBroadcastReceiver(baseAdUnit, (e) this.f13165a, baseAdUnit.getUuid());
            newInterstitialAdBroadcastReceiver.a(newInterstitialAdBroadcastReceiver);
        }
        int ad_type = baseAdUnit.getAd_type();
        String str = BaseAdActivity.j;
        if (ad_type == 6) {
            if (baseAdUnit.getCreativeType() == n.CreativeTypeMRAIDTWO.a()) {
                str = BaseAdActivity.d;
            } else {
                n.CreativeTypeNewInterstitial.a();
            }
        }
        ae.a(PointCategory.VOPEN, (String) null, baseAdUnit, (WindAdRequest) null, (LoadAdRequest) null, new ADYaiT(16, baseAdUnit.getAdslot_id()));
        BaseAdActivity.a(com.sigmob.sdk.b.e(), (baseAdUnit.getMaterial().theme_data.intValue() == 1 || baseAdUnit.getTemplateType() == 1) ? TransparentAdActivity.class : AdActivity.class, baseAdUnit.getUuid(), bundle, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, Object obj) {
        Map<String, String> options;
        if (!(obj instanceof PointEntitySigmob) || (options = ((PointEntitySigmob) obj).getOptions()) == null) {
            return;
        }
        options.put("show_count", String.valueOf(com.sigmob.sdk.base.common.h.h(str)));
        com.sigmob.sdk.base.common.h.g(str);
    }

    @Override // com.sigmob.sdk.mraid.i, com.sigmob.sdk.base.common.y
    public boolean a(BaseAdUnit baseAdUnit) {
        boolean a2 = super.a(baseAdUnit);
        MaterialMeta material = baseAdUnit.getMaterial();
        return a2 && (b(material) || c(material));
    }
}
