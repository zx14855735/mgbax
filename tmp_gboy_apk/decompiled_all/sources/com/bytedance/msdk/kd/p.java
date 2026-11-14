package com.bytedance.msdk.kd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class p implements com.bytedance.sdk.component.f.xj.y {
    public static final p xj = new p();
    private volatile SQLiteDatabase hf;

    static {
        ZfVMs();
    }

    private static /* synthetic */ void ZfVMs() {
        char[] charArray = "\u0089\u0085\u0087Ä\u008d\u008b\u0087\u008fÄ\u0088\u0085\u0093Ä\u0099\u0082\u008f\u0086\u0086Ä \u0084\u0083¨\u0098\u0083\u008e\u008d\u008f".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 234);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0089\u0086\u0083\u0084\u0083\u009e".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 234);
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
        return null;
    }

    @Override // com.bytedance.sdk.component.f.xj.y
    public String u() {
        return null;
    }

    @Override // com.bytedance.sdk.component.f.xj.y
    public String w() {
        return "adevent_applog";
    }

    @Override // com.bytedance.sdk.component.f.xj.y
    public String xj() {
        return null;
    }

    @Override // com.bytedance.sdk.component.f.xj.y
    public String y() {
        return null;
    }

    @Override // com.bytedance.sdk.component.f.xj.y
    public SQLiteDatabase xj(Context context) {
        if (this.hf == null) {
            synchronized (this) {
                try {
                    if (this.hf == null) {
                        this.hf = com.bytedance.msdk.kd.xj.y.xj(context).xj().xj();
                        com.bytedance.msdk.xj.kd.w.xj("---------------DB CREATE  SUCCESS new------------");
                    }
                } finally {
                }
            }
        }
        return this.hf;
    }
}
