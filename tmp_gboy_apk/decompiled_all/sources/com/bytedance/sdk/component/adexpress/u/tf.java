package com.bytedance.sdk.component.adexpress.u;

import android.net.Uri;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class tf {

    public enum xj {
        HTML("text/html"),
        CSS("text/css"),
        JS("application/x-javascript"),
        IMAGE("image/*");

        private String kd;

        static {
            bbspLtU();
        }

        xj(String str) {
            this.kd = str;
        }

        private static /* synthetic */ void bbspLtU() {
            char[] charArray = "ÁÍÏ\u008cÅÃÏÇ\u008cÀÍÛ\u008cÑÊÇÎÎ\u008cèÌËàÐËÆÅÇ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 162);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÁÎËÌËÖ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 162);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public String getType() {
            return this.kd;
        }
    }

    public static boolean hf(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null) {
            return false;
        }
        String path = parse.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.endsWith(".gif");
    }

    public static xj xj(String str) {
        xj xjVar = xj.IMAGE;
        if (!TextUtils.isEmpty(str)) {
            try {
                String path = Uri.parse(str).getPath();
                if (path != null) {
                    if (path.endsWith(".css")) {
                        return xj.CSS;
                    }
                    if (path.endsWith(".js")) {
                        return xj.JS;
                    }
                    if (!path.endsWith(".jpg") && !path.endsWith(".gif") && !path.endsWith(".png") && !path.endsWith(".jpeg") && !path.endsWith(".webp") && !path.endsWith(".bmp") && !path.endsWith(".ico") && path.endsWith(".html")) {
                        return xj.HTML;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return xjVar;
    }
}
