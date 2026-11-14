package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.embedapplog.e;
import com.bytedance.embedapplog.m;
import com.bytedance.embedapplog.tf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class ut extends zd<e> {
    public ut() {
        super("com.mdid.msa");
    }

    @Override // com.bytedance.embedapplog.zd, com.bytedance.embedapplog.m
    public m.xj hf(Context context) {
        xj(context, context.getPackageName());
        return super.hf(context);
    }

    @Override // com.bytedance.embedapplog.zd
    public Intent w(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction("com.bun.msa.action.bindto.service");
        intent.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
        return intent;
    }

    @Override // com.bytedance.embedapplog.zd
    public tf.hf<e, String> xj() {
        return new tf.hf<e, String>() { // from class: com.bytedance.embedapplog.ut.1
            @Override // com.bytedance.embedapplog.tf.hf
            /* renamed from: hf, reason: merged with bridge method [inline-methods] */
            public e xj(IBinder iBinder) {
                return e.xj.xj(iBinder);
            }

            @Override // com.bytedance.embedapplog.tf.hf
            public String xj(e eVar) {
                if (eVar == null) {
                    return null;
                }
                return eVar.xj();
            }
        };
    }

    private void xj(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
        intent.setAction("com.bun.msa.action.start.service");
        intent.putExtra("com.bun.msa.param.pkgname", str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            context.startService(intent);
        } catch (Exception e) {
            cu.xj(e);
        }
    }
}
