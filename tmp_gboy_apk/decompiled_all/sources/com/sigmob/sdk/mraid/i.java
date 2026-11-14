package com.sigmob.sdk.mraid;

import android.os.Bundle;
import android.text.TextUtils;
import com.czhj.wire.okio.ByteString;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class i extends com.sigmob.sdk.base.common.y {
    public i(com.sigmob.sdk.base.common.p pVar) {
        super(pVar);
    }

    public static boolean c(BaseAdUnit baseAdUnit) {
        return (baseAdUnit == null || baseAdUnit.getMaterial() == null || TextUtils.isEmpty(baseAdUnit.getCrid())) ? false : true;
    }

    @Override // com.sigmob.sdk.base.common.y
    public void a(com.sigmob.sdk.base.common.p pVar) {
        this.f13165a = pVar;
    }

    @Override // com.sigmob.sdk.base.common.y
    public void b(BaseAdUnit baseAdUnit) {
        super.b(baseAdUnit);
    }

    @Override // com.sigmob.sdk.base.common.y
    public void a(BaseAdUnit baseAdUnit, Bundle bundle) {
        List<BaseAdUnit> e;
        if (baseAdUnit.getCreativeType() == com.sigmob.sdk.base.common.n.CreativeTypeMRAIDTWO.a() && (e = com.sigmob.sdk.base.common.h.e(baseAdUnit.getUuid())) == null) {
            com.sigmob.sdk.mraid2.c.a().a(baseAdUnit.getUuid(), new com.sigmob.sdk.mraid2.e(com.sigmob.sdk.b.e(), e));
        }
        super.a(baseAdUnit, bundle);
    }

    @Override // com.sigmob.sdk.base.common.y
    public boolean a(BaseAdUnit baseAdUnit) {
        return c(baseAdUnit);
    }

    public static boolean a(MaterialMeta materialMeta) {
        if (materialMeta.creative_type.intValue() != com.sigmob.sdk.base.common.n.CreativeTypeMRAID.a()) {
            return false;
        }
        if (!TextUtils.isEmpty(materialMeta.html_url)) {
            return true;
        }
        ByteString byteString = materialMeta.html_snippet;
        return byteString != null && byteString.size() > 10;
    }
}
