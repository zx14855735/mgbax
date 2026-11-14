package com.sigmob.sdk.nativead;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.czhj.sdk.common.utils.Preconditions;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.IntentActions;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class APKStatusBroadcastReceiver extends BaseBroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    com.sigmob.sdk.base.common.b f13578a;
    IntentFilter b;

    public APKStatusBroadcastReceiver(com.sigmob.sdk.base.common.b bVar, String str) {
        super(str);
        this.f13578a = bVar;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (this.b == null) {
            IntentFilter intentFilter = new IntentFilter();
            this.b = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
            this.b.addAction(IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_PAUSE);
            this.b.addAction(IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
            this.b.addAction(IntentActions.ACTION_INTERSTITIAL_INSTALL_START);
            this.b.addAction(IntentActions.ACTION_INTERSTITIAL_INSTALL_END);
        }
        return this.b;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public void b(BroadcastReceiver broadcastReceiver) {
        super.b(broadcastReceiver);
        this.f13578a = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action;
        boolean equalsIgnoreCase;
        long longExtra;
        Preconditions.NoThrow.checkNotNull(context);
        Preconditions.NoThrow.checkNotNull(intent);
        if (this.f13578a == null || !a(intent) || (action = intent.getAction()) == null) {
            return;
        }
        equalsIgnoreCase = "1".equalsIgnoreCase(intent.getStringExtra("result"));
        longExtra = intent.getLongExtra("downloadId", -1L);
        switch (action) {
            case "action.interstitial.download.end":
                this.f13578a.b(equalsIgnoreCase, longExtra);
                break;
            case "action.interstitial.download.pause":
                this.f13578a.c(equalsIgnoreCase, longExtra);
                break;
            case "action.interstitial.download.start":
                this.f13578a.a(equalsIgnoreCase, longExtra);
                break;
            case "action.interstitial.install.end":
                this.f13578a.b(equalsIgnoreCase);
                break;
            case "action.interstitial.install.start":
                this.f13578a.a(equalsIgnoreCase);
                break;
        }
    }
}
