package com.bytedance.sdk.openadsdk.core;

import android.os.Build;
import android.os.Environment;
import android.os.FileObserver;
import java.io.File;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class x {
    private static hf y;
    public static String xj = Environment.DIRECTORY_DCIM;
    private static String hf = Environment.DIRECTORY_PICTURES;
    private static String w = "Screenshots";
    private static volatile boolean u = false;
    private static volatile boolean kd = false;
    private static long c = 0;

    public interface xj {
        void xj(String str);
    }

    static {
        Nhth();
    }

    private static /* synthetic */ void Nhth() {
        char[] charArray = "ÀÌÎ\u008dÄÂÎÆ\u008dÁÌÚ\u008dÐËÆÏÏ\u008déÍÊáÑÊÇÄÆ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 163);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÀÏÊÍÊ×".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 163);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void hf() {
        int checkSelfPermission;
        kd = true;
        if (u) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            checkSelfPermission = pz.getContext().checkSelfPermission(com.kuaishou.weapon.p0.g.j);
            if (checkSelfPermission != 0) {
                return;
            }
        }
        com.bytedance.sdk.component.tf.c.u(new com.bytedance.sdk.component.tf.d("sso") { // from class: com.bytedance.sdk.openadsdk.core.x.1
            @Override // java.lang.Runnable
            public void run() {
                x.kd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void kd() {
        File y2;
        if (u || (y2 = y()) == null) {
            return;
        }
        y = hf.xj(y2, new xj() { // from class: com.bytedance.sdk.openadsdk.core.x.2
            @Override // com.bytedance.sdk.openadsdk.core.x.xj
            public void xj(String str) {
                long unused = x.c = System.currentTimeMillis();
            }
        });
        u = true;
        y2.exists();
        hf hfVar = y;
        if (hfVar != null) {
            hfVar.startWatching();
        }
    }

    public static long w() {
        return c;
    }

    private static File y() {
        return null;
    }

    public static final class hf extends FileObserver {
        private xj xj;

        private hf(String str, int i, xj xjVar) {
            super(str, i);
            this.xj = xjVar;
        }

        public static hf xj(File file, xj xjVar) {
            if (file == null || xjVar == null) {
                return null;
            }
            return Build.VERSION.SDK_INT >= 29 ? new hf(file, 256, xjVar) : new hf(file.getAbsolutePath(), 256, xjVar);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            xj xjVar = this.xj;
            if (xjVar != null) {
                xjVar.xj(str);
            }
        }

        private hf(File file, int i, xj xjVar) {
            super(file, i);
            this.xj = xjVar;
        }
    }

    public static void xj() {
        if (!kd || u) {
            return;
        }
        try {
            hf();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.pl.u("ScreenShotObserver", "权限检查出错时,异常代码：" + e);
        }
    }
}
