package com.bytedance.embedapplog.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.embedapplog.a;
import com.bytedance.embedapplog.cu;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class Collector extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String[] stringArrayExtra = intent.getStringArrayExtra("EMBED_K_DATA");
        if (stringArrayExtra == null || stringArrayExtra.length <= 0) {
            cu.hf((Throwable) null);
        } else {
            a.xj(stringArrayExtra);
        }
    }
}
