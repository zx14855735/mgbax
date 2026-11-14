package com.bytedance.sdk.component.tf;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c extends y {
    public static xj hf;
    public static final int xj = Runtime.getRuntime().availableProcessors();
    public static boolean w = true;
    public static int u = AVMDLDataLoaderConfigure.DEFAULT_SOCKET_IDLE_TIMEOUT;

    static {
        gAdZusw();
    }

    private static /* synthetic */ void gAdZusw() {
        char[] charArray = "ÅÉË\u0088ÁÇËÃ\u0088ÄÉß\u0088ÕÎÃÊÊ\u0088ìÈÏäÔÏÂÁÃ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 166);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÅÊÏÈÏÒ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 166);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void hf(d dVar) {
        xj().execute(dVar);
    }

    public static boolean kd() {
        return w;
    }

    public static void u(d dVar) {
        p.hf.g().execute(dVar);
    }

    public static void w(d dVar) {
        hf().execute(dVar);
    }

    public static void xj(d dVar) {
        dVar.setPriority(10);
        p.hf.tf().execute(dVar);
    }

    public static ThreadPoolExecutor hf() {
        return p.hf.d();
    }

    public static void kd(d dVar) {
        p.hf.tf().execute(dVar);
    }

    public static ScheduledExecutorService u() {
        return p.hf.pl();
    }

    public static ExecutorService w() {
        return xj();
    }

    public static void hf(d dVar, int i) {
        dVar.setPriority(i);
        p.hf.g().execute(dVar);
    }

    public static ExecutorService xj() {
        return p.hf.g();
    }

    public static void xj(d dVar, int i) {
        dVar.setPriority(i);
        p.hf.g().execute(dVar);
    }

    public static void xj(boolean z) {
        w = z;
    }

    public static void xj(xj xjVar) {
        hf = xjVar;
    }

    public static void xj(int i) {
        u = i;
    }
}
