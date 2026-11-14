package com.bytedance.pangle.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.pangle.kd.kd;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BroadcastReceiverProxy extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (hf.xj().xj(hashCode())) {
            hf.xj().xj(context, intent);
        } else {
            kd.w(new Runnable() { // from class: com.bytedance.pangle.receiver.BroadcastReceiverProxy.1
                @Override // java.lang.Runnable
                public void run() {
                    hf.xj().xj(context, intent);
                }
            });
        }
    }
}
