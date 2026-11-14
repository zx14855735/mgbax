package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.config.item.InstallActivateReminderConfigItem;
import com.kwad.sdk.core.config.item.i;
import com.kwad.sdk.core.config.item.k;
import com.kwad.sdk.core.response.model.SdkConfigData;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class es {
    @InvokeBy(invokerClass = gu.class, methodId = "registerHolder")
    public static void Je() {
        gu.Jf().put(SdkConfigData.TemplateConfigMap.class, new lq());
        gu.Jf().put(ActivityInfo.class, new f());
        gu.Jf().put(SdkConfigData.CouponActiveConfig.class, new dd());
        gu.Jf().put(i.a.class, new fv());
        gu.Jf().put(com.kwad.sdk.core.response.model.a.class, new jb());
        gu.Jf().put(InstallActivateReminderConfigItem.InstallActivateReminderConfig.class, new gc());
        gu.Jf().put(k.a.class, new gb());
    }
}
