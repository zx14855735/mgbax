package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.kc;
import com.bytedance.embedapplog.m;
import com.bytedance.embedapplog.tf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class vw extends zd<kc> {
    final ci hf;
    final ic xj;

    public vw() {
        super("com.hihonor.id");
        this.xj = new ic();
        this.hf = new ci();
    }

    @Override // com.bytedance.embedapplog.zd, com.bytedance.embedapplog.m
    public m.xj hf(Context context) {
        new tf(context, w(context), xj()).xj();
        m.xj xjVar = new m.xj();
        xjVar.hf = this.xj.hf();
        xjVar.w = this.hf.hf();
        return xjVar;
    }

    @Override // com.bytedance.embedapplog.zd
    public Intent w(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        return intent;
    }

    @Override // com.bytedance.embedapplog.zd, com.bytedance.embedapplog.m
    public /* bridge */ /* synthetic */ boolean xj(Context context) {
        return super.xj(context);
    }

    @Override // com.bytedance.embedapplog.zd
    public tf.hf<kc, String> xj() {
        return new tf.hf<kc, String>() { // from class: com.bytedance.embedapplog.vw.1
            @Override // com.bytedance.embedapplog.tf.hf
            /* renamed from: hf, reason: merged with bridge method [inline-methods] */
            public kc xj(IBinder iBinder) {
                return kc.xj.xj(iBinder);
            }

            @Override // com.bytedance.embedapplog.tf.hf
            public String xj(kc kcVar) {
                if (kcVar == null) {
                    com.bytedance.sdk.component.utils.pl.u("honor# ", "service is null");
                    return null;
                }
                kcVar.xj(vw.this.xj);
                kcVar.hf(vw.this.hf);
                return "";
            }
        };
    }
}
