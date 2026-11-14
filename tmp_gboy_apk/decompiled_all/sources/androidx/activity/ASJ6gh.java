package androidx.activity;

import AaHO0E.D8MqeW;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh extends androidx.activity.result.ASJ6gh {

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f7943AYUAbz;

    public ASJ6gh(ComponentActivity componentActivity) {
        this.f7943AYUAbz = componentActivity;
    }

    @Override // androidx.activity.result.ASJ6gh
    public final void A4TApA(int i, A4TApA.A4TApA a4TApA, Object obj) {
        Bundle bundle;
        int i2;
        ComponentActivity componentActivity = this.f7943AYUAbz;
        A4TApA.A2egSU A4TApA2 = a4TApA.A4TApA(componentActivity, obj);
        if (A4TApA2 != null) {
            new Handler(Looper.getMainLooper()).post(new D8MqeW(this, i, A4TApA2, 5));
            return;
        }
        Intent A2egSU2 = a4TApA.A2egSU(componentActivity, obj);
        if (A2egSU2.getExtras() != null && A2egSU2.getExtras().getClassLoader() == null) {
            A2egSU2.setExtrasClassLoader(componentActivity.getClassLoader());
        }
        if (A2egSU2.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundle = A2egSU2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            A2egSU2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        } else {
            bundle = null;
        }
        Bundle bundle2 = bundle;
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(A2egSU2.getAction())) {
            String[] stringArrayExtra = A2egSU2.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            androidx.core.app.AYUAbz.requestPermissions(componentActivity, stringArrayExtra, i);
            return;
        }
        if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(A2egSU2.getAction())) {
            androidx.core.app.AYUAbz.startActivityForResult(componentActivity, A2egSU2, i, bundle2);
            return;
        }
        androidx.activity.result.AZOQYO azoqyo = (androidx.activity.result.AZOQYO) A2egSU2.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            i2 = i;
            try {
                componentActivity.startIntentSenderForResult(azoqyo.f8006AcNBzu, i2, azoqyo.f8007AlLFFp, azoqyo.f8008AmA8tU, azoqyo.f8009AzWtSf, 0, bundle2);
            } catch (IntentSender.SendIntentException e) {
                e = e;
                new Handler(Looper.getMainLooper()).post(new D8MqeW(this, i2, e, 6));
            }
        } catch (IntentSender.SendIntentException e2) {
            e = e2;
            i2 = i;
        }
    }
}
