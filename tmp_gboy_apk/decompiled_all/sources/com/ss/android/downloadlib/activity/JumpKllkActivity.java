package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.t;
import com.sigmob.sdk.downloader.core.breakpoint.f;
import com.sigmob.sdk.nativead.ab;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.socialbase.appdownloader.w;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class JumpKllkActivity extends TTDelegateActivity {
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        w.xj((Activity) this);
    }

    @Override // com.ss.android.downloadlib.activity.TTDelegateActivity
    public void xj() {
        Intent intent = getIntent();
        if (getIntent() == null) {
            com.ss.android.downloadlib.kd.w.xj().xj("handleIntent is null");
            w.xj((Activity) this);
            return;
        }
        String stringExtra = intent.getStringExtra(t.b);
        long longExtra = intent.getLongExtra(f.f13353a, 0L);
        if (TextUtils.isEmpty(stringExtra) || longExtra == 0) {
            com.ss.android.downloadlib.kd.w.xj().xj("getPackage or id is null");
            w.xj((Activity) this);
        }
        boolean booleanExtra = intent.getBooleanExtra("dl", false);
        String stringExtra2 = intent.getStringExtra("bk");
        if ((!TextUtils.isEmpty(stringExtra2)) && booleanExtra) {
            com.ss.android.downloadlib.c.f.xj((Context) this, stringExtra, longExtra, stringExtra2, true);
            w.xj((Activity) this);
            return;
        }
        int optInt = pl.d().optInt(ab.f13593a, 0);
        com.ss.android.downloadlib.c.f.xj(this, stringExtra, longExtra, optInt == 1);
        if (optInt != 1) {
            w.xj((Activity) this);
        }
    }
}
