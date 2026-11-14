package com.octopus.ad.b.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        boolean z;
        if (context == null || intent == null) {
            return;
        }
        boolean z2 = false;
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        if (intExtra == 1) {
            z = TextUtils.equals(intent.getStringExtra("openIdPackage"), context.getPackageName());
        } else {
            if (intExtra == 2) {
                ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
                if (stringArrayListExtra != null) {
                    z2 = stringArrayListExtra.contains(context.getPackageName());
                }
            } else if (intExtra == 0) {
                z2 = true;
            }
            z = z2;
        }
        if (z) {
            String stringExtra = intent.getStringExtra("openIdType");
            d a2 = d.a();
            b bVar = "oaid".equals(stringExtra) ? a2.b : "vaid".equals(stringExtra) ? a2.c : "aaid".equals(stringExtra) ? a2.d : "udid".equals(stringExtra) ? a2.f12364a : null;
            if (bVar == null) {
                return;
            }
            bVar.b();
        }
    }
}
