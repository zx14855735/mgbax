package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.qt;
import com.bytedance.embedapplog.tf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class wo extends zd<qt> {
    public wo() {
        super("com.asus.msa.SupplementaryDID");
    }

    @Override // com.bytedance.embedapplog.zd
    public Intent w(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        return intent;
    }

    @Override // com.bytedance.embedapplog.zd
    public tf.hf<qt, String> xj() {
        return new tf.hf<qt, String>() { // from class: com.bytedance.embedapplog.wo.1
            @Override // com.bytedance.embedapplog.tf.hf
            /* renamed from: hf, reason: merged with bridge method [inline-methods] */
            public qt xj(IBinder iBinder) {
                return qt.xj.xj(iBinder);
            }

            @Override // com.bytedance.embedapplog.tf.hf
            public String xj(qt qtVar) {
                if (qtVar == null) {
                    return null;
                }
                return qtVar.w();
            }
        };
    }
}
