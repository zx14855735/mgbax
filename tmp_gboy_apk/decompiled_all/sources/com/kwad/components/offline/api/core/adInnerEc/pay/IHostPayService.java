package com.kwad.components.offline.api.core.adInnerEc.pay;

import A5SV6n.A2egSU;
import android.app.Activity;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface IHostPayService {
    void startMerchantPay(Activity activity, boolean z, String str, String str2, IHostPayResultListener iHostPayResultListener);

    void startPay(Activity activity, String str, String str2, IHostPayResultListener iHostPayResultListener);

    void withDraw(Activity activity, String str, IHostWithDrawListener iHostWithDrawListener);
}
