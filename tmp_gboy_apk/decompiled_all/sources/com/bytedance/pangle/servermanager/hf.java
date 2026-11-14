package com.bytedance.pangle.servermanager;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.kd;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.w;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static w y;
    private static final Object xj = new Object();
    private static final Object hf = new Object();
    private static final Object w = new Object();
    private static final Map<String, Boolean> u = new ConcurrentHashMap();
    private static final Map<String, kd> kd = new ConcurrentHashMap();

    static {
        LdVWcME();
    }

    private static /* synthetic */ void LdVWcME() {
        char[] charArray = "\u009f\u0093\u0091Ò\u009b\u009d\u0091\u0099Ò\u009e\u0093\u0085Ò\u008f\u0094\u0099\u0090\u0090Ò¶\u0092\u0095¾\u008e\u0095\u0098\u009b\u0099".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 252);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u009f\u0090\u0095\u0092\u0095\u0088".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 252);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static kd xj(String str) {
        Boolean bool = u.get(str);
        if (bool == null || !bool.booleanValue()) {
            kd.remove(str);
        }
        Map<String, kd> map = kd;
        if (map.get(str) == null) {
            synchronized (hf) {
                try {
                    kd kdVar = (kd) xj("service", str);
                    if (kdVar == null) {
                        ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");
                        return null;
                    }
                    map.put(str, kdVar);
                } finally {
                }
            }
        }
        return map.get(str);
    }

    public static w xj() {
        Boolean bool = u.get("main");
        if (bool == null || !bool.booleanValue()) {
            y = null;
        }
        if (y == null) {
            synchronized (w) {
                try {
                    w wVar = (w) xj("package", "main");
                    if (wVar == null) {
                        ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");
                        return null;
                    }
                    y = wVar;
                } finally {
                }
            }
        }
        return y;
    }

    private static IBinder xj(Uri uri, String str) {
        Bundle call = Zeus.getAppApplication().getContentResolver().call(uri, "query_binder", str, (Bundle) null);
        if (call != null) {
            call.setClassLoader(AbsServerManager.class.getClassLoader());
            xj xjVar = (xj) call.getParcelable("binder");
            if (xjVar != null) {
                return xjVar.xj();
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0070 A[Catch: RemoteException -> 0x0075, TRY_LEAVE, TryCatch #0 {RemoteException -> 0x0075, blocks: (B:10:0x0032, B:21:0x006b, B:23:0x0070, B:25:0x0052, B:28:0x005c), top: B:9:0x0032 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.os.IInterface xj(java.lang.String r4, final java.lang.String r5) {
        /*
            boolean r0 = com.bytedance.pangle.Zeus.hasInit()
            if (r0 == 0) goto L8f
            java.util.HashMap r0 = com.bytedance.pangle.Zeus.getServerManagerHashMap()
            java.lang.Object r0 = r0.get(r5)
            android.content.pm.ProviderInfo r0 = (android.content.pm.ProviderInfo) r0
            if (r0 == 0) goto L7f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "content://"
            r1.<init>(r2)
            java.lang.String r0 = r0.authority
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.os.IBinder r0 = xj(r0, r4)
            if (r0 == 0) goto L7d
            boolean r1 = r0.isBinderAlive()
            if (r1 == 0) goto L7d
            com.bytedance.pangle.servermanager.hf$1 r1 = new com.bytedance.pangle.servermanager.hf$1     // Catch: android.os.RemoteException -> L75
            r1.<init>()     // Catch: android.os.RemoteException -> L75
            r2 = 0
            r0.linkToDeath(r1, r2)     // Catch: android.os.RemoteException -> L75
            java.util.Map<java.lang.String, java.lang.Boolean> r1 = com.bytedance.pangle.servermanager.hf.u     // Catch: android.os.RemoteException -> L75
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch: android.os.RemoteException -> L75
            r1.put(r5, r3)     // Catch: android.os.RemoteException -> L75
            int r5 = r4.hashCode()     // Catch: android.os.RemoteException -> L75
            r1 = -807062458(0xffffffffcfe53446, float:-7.6908165E9)
            r3 = 1
            if (r5 == r1) goto L5c
            r1 = 1984153269(0x7643c6b5, float:9.927033E32)
            if (r5 == r1) goto L52
            goto L65
        L52:
            java.lang.String r5 = "service"
            boolean r4 = r4.equals(r5)     // Catch: android.os.RemoteException -> L75
            if (r4 == 0) goto L65
            r2 = 1
            goto L66
        L5c:
            java.lang.String r5 = "package"
            boolean r4 = r4.equals(r5)     // Catch: android.os.RemoteException -> L75
            if (r4 == 0) goto L65
            goto L66
        L65:
            r2 = -1
        L66:
            if (r2 == 0) goto L70
            if (r2 == r3) goto L6b
            goto L7d
        L6b:
            com.bytedance.pangle.kd r4 = com.bytedance.pangle.kd.xj.xj(r0)     // Catch: android.os.RemoteException -> L75
            return r4
        L70:
            com.bytedance.pangle.w r4 = com.bytedance.pangle.w.xj.xj(r0)     // Catch: android.os.RemoteException -> L75
            return r4
        L75:
            r4 = move-exception
            java.lang.String r5 = "Zeus/server_pangle"
            java.lang.String r0 = "generateServerManager failed."
            com.bytedance.pangle.log.ZeusLogger.errReport(r5, r0, r4)
        L7d:
            r4 = 0
            return r4
        L7f:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r0 = "宿主中没有找对对应进程的serverManager "
            java.lang.String r5 = r0.concat(r5)
            r4.<init>(r5)
            throw r4
        L8f:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r0 = "generateServerManager 请先初始化Zeus, processName:"
            java.lang.String r5 = r0.concat(r5)
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.servermanager.hf.xj(java.lang.String, java.lang.String):android.os.IInterface");
    }
}
