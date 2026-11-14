package com.bytedance.sdk.component.adexpress.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ThemeStatusBroadcastReceiver extends BroadcastReceiver {
    private WeakReference<xj> xj;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("theme_status_change", 0);
        WeakReference<xj> weakReference = this.xj;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.xj.get().b_(intExtra);
    }

    public void xj(xj xjVar) {
        this.xj = new WeakReference<>(xjVar);
    }
}
