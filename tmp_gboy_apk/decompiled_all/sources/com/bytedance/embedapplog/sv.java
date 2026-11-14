package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.g;
import com.bytedance.embedapplog.tf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class sv extends zd<g> {
    public sv() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.zd
    public Intent w(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }

    @Override // com.bytedance.embedapplog.zd
    public tf.hf<g, String> xj() {
        return new tf.hf<g, String>() { // from class: com.bytedance.embedapplog.sv.1
            @Override // com.bytedance.embedapplog.tf.hf
            /* renamed from: hf, reason: merged with bridge method [inline-methods] */
            public g xj(IBinder iBinder) {
                return g.xj.xj(iBinder);
            }

            @Override // com.bytedance.embedapplog.tf.hf
            public String xj(g gVar) {
                return gVar.xj();
            }
        };
    }
}
