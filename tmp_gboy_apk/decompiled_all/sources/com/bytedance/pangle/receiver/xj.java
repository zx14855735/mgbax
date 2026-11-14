package com.bytedance.pangle.receiver;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.d;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class xj {
    private static final w xj;

    public static class hf extends kd {
        private hf() {
            super();
        }

        @Override // com.bytedance.pangle.receiver.xj.kd, com.bytedance.pangle.receiver.xj.C0092xj, com.bytedance.pangle.receiver.xj.w
        public boolean xj(Context context) {
            return false;
        }
    }

    public static class kd extends C0092xj {
        private kd() {
            super();
        }

        @Override // com.bytedance.pangle.receiver.xj.C0092xj, com.bytedance.pangle.receiver.xj.w
        public boolean xj(Context context) {
            Object xj = xj(context, "mWhiteListMap");
            if (!(xj instanceof Map)) {
                return false;
            }
            Map map = (Map) xj;
            List list = (List) map.get(0);
            if (list == null) {
                list = new ArrayList();
                map.put(0, list);
            }
            list.add(context.getPackageName());
            return true;
        }
    }

    public static class u extends C0092xj {
        private u() {
            super();
        }

        @Override // com.bytedance.pangle.receiver.xj.C0092xj, com.bytedance.pangle.receiver.xj.w
        public boolean xj(Context context) {
            Object xj = xj(context, "mWhiteList");
            if (!(xj instanceof List)) {
                return false;
            }
            ((List) xj).add(context.getPackageName());
            return true;
        }
    }

    public interface w {
        boolean xj(Context context);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i < 24) {
            xj = new C0092xj();
            return;
        }
        if (i < 26) {
            xj = new u();
        } else if (i < 28) {
            xj = new kd();
        } else {
            xj = new hf();
            yveHlVA();
        }
    }

    public static void xj(Application application) {
        if (application != null) {
            try {
                if (d.jk()) {
                    xj.xj(application.getBaseContext());
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static /* synthetic */ void yveHlVA() {
        char[] charArray = "³¿½þ·±½µþ²¿©þ£¸µ¼¼þ\u009a¾¹\u0092¢¹´·µ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 208);
        }
        String str = new String(charArray);
        char[] charArray2 = "³¼¹¾¹¤".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 208);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    /* renamed from: com.bytedance.pangle.receiver.xj$xj, reason: collision with other inner class name */
    public static class C0092xj implements w {
        private C0092xj() {
        }

        private Object hf(Context context) {
            Field field;
            Object readField;
            try {
                Field field2 = FieldUtils.getField(Class.forName("android.app.LoadedApk"), "mReceiverResource");
                if (field2 == null || (field = FieldUtils.getField(Class.forName("android.app.ContextImpl"), "mPackageInfo")) == null || (readField = FieldUtils.readField(field, context)) == null) {
                    return null;
                }
                return FieldUtils.readField(field2, readField);
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // com.bytedance.pangle.receiver.xj.w
        public boolean xj(Context context) {
            Object hf = hf(context);
            Object xj = xj(hf, "mWhiteList");
            if (!(xj instanceof String[])) {
                if (hf == null) {
                    return false;
                }
                FieldUtils.writeField(hf, "mResourceConfig", (Object) null);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(context.getPackageName());
            Collections.addAll(arrayList, (String[]) xj);
            FieldUtils.writeField(hf, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
            return true;
        }

        public Object xj(Context context, String str) {
            return xj(hf(context), str);
        }

        private Object xj(Object obj, String str) {
            if (obj == null) {
                return null;
            }
            try {
                return FieldUtils.readField(obj, str);
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
