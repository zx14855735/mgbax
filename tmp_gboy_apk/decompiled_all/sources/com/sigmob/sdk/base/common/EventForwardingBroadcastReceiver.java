package com.sigmob.sdk.base.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class EventForwardingBroadcastReceiver extends BaseBroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13093a = "EventForwardingBroadcastReceiver";
    private static IntentFilter c;
    public BaseAdUnit b;
    private p d;

    public EventForwardingBroadcastReceiver(BaseAdUnit baseAdUnit, p pVar, String str) {
        super(str);
        this.b = baseAdUnit;
        this.d = pVar;
        a();
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public IntentFilter a() {
        if (c == null) {
            IntentFilter intentFilter = new IntentFilter();
            c = intentFilter;
            intentFilter.addAction(IntentActions.ACTION_INTERSTITIAL_FAIL);
            c.addAction(IntentActions.ACTION_INTERSTITIAL_SHOW);
            c.addAction(IntentActions.ACTION_INTERSTITIAL_DISMISS);
            c.addAction(IntentActions.ACTION_INTERSTITIAL_CLICK);
            c.addAction(IntentActions.ACTION_INTERSTITIAL_VOPEN);
        }
        return c;
    }

    @Override // com.sigmob.sdk.base.common.BaseBroadcastReceiver
    public void b(BroadcastReceiver broadcastReceiver) {
        super.b(broadcastReceiver);
        this.d = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.d == null || this.b == null || !a(intent)) {
            return;
        }
        String requestId = this.b.getRequestId();
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        com.bykv.vk.component.ttvideo.player.A2egSU.BIYEnU(sb, f13093a, "#onReceive: action = ", action, ", requestId = ");
        sb.append(requestId);
        SigmobLog.d(sb.toString());
        switch (action) {
            case "action.interstitial.dismiss":
                this.d.d(this.b);
                b(this);
                this.b = null;
                break;
            case "action.interstitial.click":
                this.d.c(this.b);
                break;
            case "action.interstitial.vopen":
                this.d.e(this.b);
                break;
            case "action.interstitial.fail":
                this.d.b(this.b, intent.getStringExtra("error"));
                break;
            case "action.interstitial.show":
                this.d.b(this.b);
                break;
        }
    }
}
