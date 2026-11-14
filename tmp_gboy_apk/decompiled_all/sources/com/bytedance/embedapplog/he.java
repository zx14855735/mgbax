package com.bytedance.embedapplog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.embedapplog.m;
import com.bytedance.embedapplog.pl;
import com.bytedance.embedapplog.tf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class he extends zd<pl> {
    private final Context xj;

    public he(Context context) {
        super("com.coolpad.deviceidsupport");
        this.xj = context;
    }

    @Override // com.bytedance.embedapplog.zd, com.bytedance.embedapplog.m
    public m.xj hf(Context context) {
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "coolos.oaid");
            if (!TextUtils.isEmpty(string)) {
                m.xj xjVar = new m.xj();
                xjVar.hf = string;
                return xjVar;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
        }
        return super.hf(context);
    }

    @Override // com.bytedance.embedapplog.zd
    public Intent w(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return intent;
    }

    @Override // com.bytedance.embedapplog.zd, com.bytedance.embedapplog.m
    public /* bridge */ /* synthetic */ boolean xj(Context context) {
        return super.xj(context);
    }

    @Override // com.bytedance.embedapplog.zd
    public tf.hf<pl, String> xj() {
        return new tf.hf<pl, String>() { // from class: com.bytedance.embedapplog.he.1
            @Override // com.bytedance.embedapplog.tf.hf
            /* renamed from: hf, reason: merged with bridge method [inline-methods] */
            public pl xj(IBinder iBinder) {
                return pl.xj.xj(iBinder);
            }

            @Override // com.bytedance.embedapplog.tf.hf
            public String xj(pl plVar) {
                if (plVar == null) {
                    return null;
                }
                return plVar.hf(he.this.xj.getPackageName());
            }
        };
    }
}
