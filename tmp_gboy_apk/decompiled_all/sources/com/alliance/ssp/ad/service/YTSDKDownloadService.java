package com.alliance.ssp.ad.service;

import G58fqA.A2egSU;
import android.app.IntentService;
import android.content.Intent;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class YTSDKDownloadService extends IntentService {
    public YTSDKDownloadService() {
        super("YTSDKDownloadService");
    }

    @Override // android.app.IntentService
    public final void onHandleIntent(Intent intent) {
        if (intent == null || intent.getAction() == null) {
            return;
        }
        String action = intent.getAction();
        action.getClass();
        if (action.equals("SA_TARGET_YT_NOTIFICATION_CLICK")) {
            A2egSU.A5SV6n(this, "SA_TARGET_YT_NOTIFICATION_CLICK");
        } else if (action.equals("SA_TARGET_YT_NOTIFICATION_CANCEL")) {
            A2egSU.A5SV6n(this, "SA_TARGET_YT_NOTIFICATION_CANCEL");
        }
    }
}
