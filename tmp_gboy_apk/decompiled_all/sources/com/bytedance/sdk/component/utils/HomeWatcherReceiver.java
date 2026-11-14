package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class HomeWatcherReceiver extends BroadcastReceiver {
    private xj xj;

    public interface xj {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            pl.xj("HomeReceiver", "onReceive: action: ".concat(String.valueOf(action)));
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
                String stringExtra = intent.getStringExtra(MediationConstant.KEY_REASON);
                pl.xj("HomeReceiver", "reason: ".concat(String.valueOf(stringExtra)));
                if ("homekey".equals(stringExtra)) {
                    pl.xj("HomeReceiver", "homekey");
                } else if ("recentapps".equals(stringExtra)) {
                    pl.xj("HomeReceiver", "long press home key or activity switch");
                } else if ("assist".equals(stringExtra)) {
                    pl.xj("HomeReceiver", "assist");
                }
            }
        } catch (Throwable unused) {
            pl.u("HomeReceiver", "ACTION_CLOSE_SYSTEM_DIALOGS throw");
        }
    }
}
