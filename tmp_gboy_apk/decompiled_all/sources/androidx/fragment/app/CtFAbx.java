package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CtFAbx extends A4TApA.A4TApA {
    @Override // A4TApA.A4TApA
    public final Intent A2egSU(Context context, Object obj) {
        Bundle bundleExtra;
        androidx.activity.result.AZOQYO azoqyo = (androidx.activity.result.AZOQYO) obj;
        Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
        Intent intent2 = azoqyo.f8007AlLFFp;
        if (intent2 != null && (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
            intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                azoqyo = new androidx.activity.result.AZOQYO(azoqyo.f8006AcNBzu, null, azoqyo.f8008AmA8tU, azoqyo.f8009AzWtSf);
            }
        }
        intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", azoqyo);
        if (CtxOCS.C4FrIb(2)) {
            intent.toString();
        }
        return intent;
    }

    @Override // A4TApA.A4TApA
    public final Object A5SV6n(int i, Intent intent) {
        return new androidx.activity.result.A2egSU(i, intent);
    }
}
