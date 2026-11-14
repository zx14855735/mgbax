package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.embedapplog.m;
import com.bytedance.embedapplog.tf;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
abstract class zd<SERVICE> implements m {
    private xv<Boolean> hf = new xv<Boolean>() { // from class: com.bytedance.embedapplog.zd.1
        @Override // com.bytedance.embedapplog.xv
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public Boolean xj(Object... objArr) {
            return Boolean.valueOf(ey.xj((Context) objArr[0], zd.this.xj));
        }
    };
    private final String xj;

    public zd(String str) {
        this.xj = str;
    }

    @Override // com.bytedance.embedapplog.m
    public m.xj hf(Context context) {
        return xj((String) new tf(context, w(context), xj()).xj());
    }

    public abstract Intent w(Context context);

    public abstract tf.hf<SERVICE, String> xj();

    @Override // com.bytedance.embedapplog.m
    public boolean xj(Context context) {
        if (context == null) {
            return false;
        }
        return this.hf.hf(context).booleanValue();
    }

    private m.xj xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        m.xj xjVar = new m.xj();
        xjVar.hf = str;
        return xjVar;
    }
}
