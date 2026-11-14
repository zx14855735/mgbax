package com.bytedance.sdk.openadsdk.core.ht;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.openadsdk.core.pz;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f implements com.bytedance.sdk.component.f.xj.y {
    public static final f xj = new f();
    private volatile SQLiteDatabase hf;

    static {
        aFzk();
    }

    private static /* synthetic */ void aFzk() {
        char[] charArray = "\u0002\u000e\fO\u0006\u0000\f\u0004O\u0003\u000e\u0018O\u0012\t\u0004\r\rO+\u000f\b#\u0013\b\u0005\u0006\u0004".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'a');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0002\r\b\u000f\b\u0015".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'a');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.sdk.component.f.xj.y
    public String hf() {
        return "adevent";
    }

    @Override // com.bytedance.sdk.component.f.xj.y
    public String kd() {
        return "logstatsbatch";
    }

    @Override // com.bytedance.sdk.component.f.xj.y
    public String u() {
        return "logstats";
    }

    @Override // com.bytedance.sdk.component.f.xj.y
    public String w() {
        return null;
    }

    @Override // com.bytedance.sdk.component.f.xj.y
    public SQLiteDatabase xj(Context context) {
        if (this.hf == null) {
            synchronized (f.class) {
                try {
                    if (this.hf == null) {
                        com.bytedance.sdk.openadsdk.core.tf.u xj2 = com.bytedance.sdk.openadsdk.core.tf.w.xj(pz.getContext()).xj();
                        xj2.xj();
                        this.hf = xj2.hf();
                    }
                } finally {
                }
            }
        }
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.f.xj.y
    public String y() {
        return null;
    }

    @Override // com.bytedance.sdk.component.f.xj.y
    public String xj() {
        return "loghighpriority";
    }
}
