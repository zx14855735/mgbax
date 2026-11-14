package com.bytedance.sdk.component.f.hf.xj.xj.xj;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bytedance.sdk.component.f.xj.y;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements y {
    public static final hf xj = new hf();
    private volatile SQLiteDatabase hf;

    static {
        pVTLf();
    }

    private static /* synthetic */ void pVTLf() {
        char[] charArray = "¾²°óº¼°¸ó¿²¤ó®µ¸±±ó\u0097³´\u009f¯´¹º¸".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 221);
        }
        String str = new String(charArray);
        char[] charArray2 = "¾±´³´©".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 221);
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
            synchronized (this) {
                try {
                    if (this.hf == null) {
                        this.hf = new xj(context, this).getWritableDatabase();
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
