package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.UUID;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class mg {
    private static xv<String> xj = new xv<String>() { // from class: com.bytedance.embedapplog.mg.1
        @Override // com.bytedance.embedapplog.xv
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public String xj(Object... objArr) {
            SharedPreferences sharedPreferences = (SharedPreferences) objArr[0];
            String string = sharedPreferences.getString("cdid", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            String uuid = UUID.randomUUID().toString();
            sharedPreferences.edit().putString("cdid", uuid).apply();
            return uuid;
        }
    };

    static {
        WhQaYh();
    }

    private static /* synthetic */ void WhQaYh() {
        char[] charArray = "~rp3z|px3\u007frd3nuxqq3Wst_otyzx".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 29);
        }
        String str = new String(charArray);
        char[] charArray2 = "~qtsti".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 29);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static String xj(SharedPreferences sharedPreferences) {
        return xj.hf(sharedPreferences);
    }
}
