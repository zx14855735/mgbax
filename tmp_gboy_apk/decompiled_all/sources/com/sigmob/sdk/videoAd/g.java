package com.sigmob.sdk.videoAd;

import android.text.TextUtils;
import com.czhj.wire.okio.ByteString;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.common.p;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g extends com.sigmob.sdk.mraid.i {
    private RewardVideoAdBroadcastReceiver c;
    private final boolean d;

    public g(p pVar, boolean z) {
        super(pVar);
        this.d = z;
    }

    private static boolean c(MaterialMeta materialMeta) {
        ByteString byteString;
        return (materialMeta.creative_type.intValue() == n.CreativeTypeVideo_Html_Snippet.a() || materialMeta.creative_type.intValue() == n.CreativeTypeVideo_transparent_html.a()) && (byteString = materialMeta.html_snippet) != null && byteString.size() > 10 && !TextUtils.isEmpty(materialMeta.video_url);
    }

    public static boolean d(BaseAdUnit baseAdUnit) {
        boolean c = com.sigmob.sdk.mraid.i.c(baseAdUnit);
        MaterialMeta material = baseAdUnit.getMaterial();
        return c && (baseAdUnit.getCreativeType() == n.CreativeTypeMRAID.a() ? com.sigmob.sdk.mraid.i.a(material) : b(material) || c(material) || d(material));
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x004a  */
    @Override // com.sigmob.sdk.mraid.i, com.sigmob.sdk.base.common.y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.sigmob.sdk.base.models.BaseAdUnit r12, android.os.Bundle r13) {
        /*
            r11 = this;
            com.sigmob.sdk.base.common.h.a(r12)
            super.a(r12, r13)
            com.sigmob.sdk.base.common.p r0 = r11.f13165a
            boolean r0 = r0 instanceof com.sigmob.sdk.videoAd.h
            if (r0 == 0) goto L1e
            com.sigmob.sdk.videoAd.RewardVideoAdBroadcastReceiver r0 = new com.sigmob.sdk.videoAd.RewardVideoAdBroadcastReceiver
            com.sigmob.sdk.base.common.p r1 = r11.f13165a
            com.sigmob.sdk.videoAd.h r1 = (com.sigmob.sdk.videoAd.h) r1
            java.lang.String r2 = r12.getUuid()
            r0.<init>(r12, r1, r2)
            r11.c = r0
            r0.a(r0)
        L1e:
            int r0 = r12.getAd_type()
            r1 = 4
            r2 = 1
            if (r0 == r2) goto L28
            if (r0 != r1) goto L46
        L28:
            int r3 = r12.getCreativeType()
            com.sigmob.sdk.base.common.n r4 = com.sigmob.sdk.base.common.n.CreativeTypeMRAID
            int r4 = r4.a()
            if (r3 != r4) goto L37
            java.lang.String r3 = "mraid"
            goto L48
        L37:
            int r3 = r12.getCreativeType()
            com.sigmob.sdk.base.common.n r4 = com.sigmob.sdk.base.common.n.CreativeTypeMRAIDTWO
            int r4 = r4.a()
            if (r3 != r4) goto L46
            java.lang.String r3 = "mraid_two"
            goto L48
        L46:
            java.lang.String r3 = "reward"
        L48:
            if (r13 == 0) goto L51
            java.lang.String r4 = "isHalfInterstitial"
            boolean r5 = r11.d
            r13.putBoolean(r4, r5)
        L51:
            java.lang.String r4 = r12.getAdslot_id()
            com.sigmob.sdk.videoAd.ASJ6gh r10 = new com.sigmob.sdk.videoAd.ASJ6gh
            r5 = 1
            r10.<init>(r4, r5)
            r8 = 0
            r9 = 0
            java.lang.String r5 = "vopen"
            r6 = 0
            r7 = r12
            com.sigmob.sdk.base.common.ae.a(r5, r6, r7, r8, r9, r10)
            if (r0 != r1) goto L76
            com.sigmob.sdk.base.models.rtb.MaterialMeta r12 = r7.getMaterial()
            java.lang.Integer r12 = r12.theme_data
            int r12 = r12.intValue()
            if (r12 == r2) goto L94
            boolean r12 = r11.d
            if (r12 != 0) goto L94
        L76:
            int r12 = r7.getCreativeType()
            com.sigmob.sdk.base.common.n r0 = com.sigmob.sdk.base.common.n.CreativeTypeMRAIDTWO
            int r0 = r0.a()
            if (r12 != r0) goto L97
            com.sigmob.sdk.base.models.rtb.MaterialMeta r12 = r7.getMaterial()
            java.lang.Integer r12 = r12.theme_data
            int r12 = r12.intValue()
            if (r12 == r2) goto L94
            int r12 = r7.getTemplateType()
            if (r12 != r2) goto L97
        L94:
            java.lang.Class<com.sigmob.sdk.base.common.TransparentAdActivity> r12 = com.sigmob.sdk.base.common.TransparentAdActivity.class
            goto L99
        L97:
            java.lang.Class<com.sigmob.sdk.base.common.AdActivity> r12 = com.sigmob.sdk.base.common.AdActivity.class
        L99:
            android.content.Context r0 = com.sigmob.sdk.b.e()
            java.lang.String r1 = r7.getUuid()
            com.sigmob.sdk.base.BaseAdActivity.a(r0, r12, r1, r13, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoAd.g.a(com.sigmob.sdk.base.models.BaseAdUnit, android.os.Bundle):void");
    }

    @Override // com.sigmob.sdk.mraid.i, com.sigmob.sdk.base.common.y
    public void b(BaseAdUnit baseAdUnit) {
        RewardVideoAdBroadcastReceiver rewardVideoAdBroadcastReceiver = this.c;
        if (rewardVideoAdBroadcastReceiver != null) {
            rewardVideoAdBroadcastReceiver.b(rewardVideoAdBroadcastReceiver);
            this.c = null;
        }
        com.sigmob.sdk.base.common.h.b(baseAdUnit);
        super.b(baseAdUnit);
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

    private static boolean b(MaterialMeta materialMeta) {
        return (materialMeta.creative_type.intValue() != n.CreativeTypeVideo_Tar.a() || TextUtils.isEmpty(materialMeta.endcard_md5) || TextUtils.isEmpty(materialMeta.endcard_url) || TextUtils.isEmpty(materialMeta.video_url)) ? false : true;
    }

    private static boolean d(MaterialMeta materialMeta) {
        return (materialMeta.creative_type.intValue() != n.CreativeTypeVideo_EndCardURL.a() || TextUtils.isEmpty(materialMeta.html_url) || TextUtils.isEmpty(materialMeta.video_url)) ? false : true;
    }

    @Override // com.sigmob.sdk.mraid.i, com.sigmob.sdk.base.common.y
    public boolean a(BaseAdUnit baseAdUnit) {
        boolean a2 = super.a(baseAdUnit);
        MaterialMeta material = baseAdUnit.getMaterial();
        int creativeType = baseAdUnit.getCreativeType();
        return a2 && (creativeType == n.CreativeTypeMRAID.a() ? com.sigmob.sdk.mraid.i.a(material) : creativeType == n.CreativeTypeMRAIDTWO.a() || b(material) || c(material) || d(material));
    }
}
