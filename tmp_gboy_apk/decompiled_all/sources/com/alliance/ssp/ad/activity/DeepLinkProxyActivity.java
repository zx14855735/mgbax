package com.alliance.ssp.ad.activity;

import G58fqA.A2egSU;
import GJee0v.AZOQYO;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class DeepLinkProxyActivity extends Activity {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f9612AcNBzu = false;

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        requestWindowFeature(1);
        int i = AZOQYO.f3039AcNBzu;
        if (getIntent() == null || (str = new String[]{getIntent().getStringExtra("adn_sdk_deeplink_url")}[0]) == null || str.isEmpty()) {
            A2egSU.A5SV6n(this, "SA_TARGET_YT_DEEPLINK_OPEN_FAIL");
            finish();
            return;
        }
        String stringExtra = getIntent().getStringExtra("adn_sdk_deeplink_url");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringExtra));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            A2egSU.A5SV6n(this, "SA_TARGET_YT_DEEPLINK_OPEN_FAIL");
            finish();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        int i = AZOQYO.f3039AcNBzu;
        A2egSU.A5SV6n(this, "SA_TARGET_YT_DEEPLINK_OPEN_FINISH");
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        this.f9612AcNBzu = true;
        int i = AZOQYO.f3039AcNBzu;
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.f9612AcNBzu) {
            A2egSU.A5SV6n(this, "SA_TARGET_YT_DEEPLINK_OPEN_FAIL");
            finish();
        }
        int i = AZOQYO.f3039AcNBzu;
    }

    @Override // android.app.Activity
    public final void onStop() {
        super.onStop();
        int i = AZOQYO.f3039AcNBzu;
        if (isFinishing()) {
            return;
        }
        finish();
    }
}
