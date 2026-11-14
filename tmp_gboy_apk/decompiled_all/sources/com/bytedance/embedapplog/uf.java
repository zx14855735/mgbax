package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.am;
import com.bytedance.embedapplog.tf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class uf extends zd<am> {
    public uf() {
        super("com.zui.deviceidservice");
    }

    @Override // com.bytedance.embedapplog.zd
    public Intent w(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }

    @Override // com.bytedance.embedapplog.zd
    public tf.hf<am, String> xj() {
        return new tf.hf<am, String>() { // from class: com.bytedance.embedapplog.uf.1
            @Override // com.bytedance.embedapplog.tf.hf
            /* renamed from: hf, reason: merged with bridge method [inline-methods] */
            public am xj(IBinder iBinder) {
                return am.xj.xj(iBinder);
            }

            @Override // com.bytedance.embedapplog.tf.hf
            public String xj(am amVar) {
                if (amVar == null) {
                    return null;
                }
                return amVar.xj();
            }
        };
    }
}
