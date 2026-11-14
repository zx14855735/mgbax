package com.bytedance.embedapplog;

import android.content.Context;
import android.os.SystemProperties;
import com.bytedance.embedapplog.m;
import com.czhj.sdk.common.Constants;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class ew implements m {
    private static final xv<Boolean> xj = new xv<Boolean>() { // from class: com.bytedance.embedapplog.ew.1
        @Override // com.bytedance.embedapplog.xv
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public Boolean xj(Object... objArr) {
            return Boolean.valueOf("1".equals(ew.hf("persist.sys.identifierid.supported", Constants.FAIL)));
        }
    };

    static {
        cPmj();
    }

    public ew(Context context) {
    }

    private static /* synthetic */ void cPmj() {
        char[] charArray = "µ¹»ø±·»³ø´¹¯ø¥¾³ººø\u009c¸¿\u0094¤¿²±³".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 214);
        }
        String str = new String(charArray);
        char[] charArray2 = "µº¿¸¿¢".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 214);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // com.bytedance.embedapplog.m
    public m.xj hf(Context context) {
        m.xj xjVar = new m.xj();
        xjVar.hf = xj(context, 0, null);
        return xjVar;
    }

    public static boolean xj() {
        return xj.hf(new Object[0]).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String hf(String str, String str2) {
        try {
            return SystemProperties.get(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    @Override // com.bytedance.embedapplog.m
    public boolean xj(Context context) {
        return xj();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String xj(android.content.Context r8, int r9, java.lang.String r10) {
        /*
            r1 = 0
            if (r9 == 0) goto L2a
            r0 = 1
            if (r9 == r0) goto L1b
            r0 = 2
            if (r9 == r0) goto Lb
            r3 = r1
            goto L31
        Lb:
            java.lang.String r9 = java.lang.String.valueOf(r10)
            java.lang.String r10 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            java.lang.String r9 = r10.concat(r9)
            android.net.Uri r9 = android.net.Uri.parse(r9)
        L19:
            r3 = r9
            goto L31
        L1b:
            java.lang.String r9 = java.lang.String.valueOf(r10)
            java.lang.String r10 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            java.lang.String r9 = r10.concat(r9)
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L19
        L2a:
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r9 = android.net.Uri.parse(r9)
            goto L19
        L31:
            if (r3 == 0) goto L6e
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            r6 = 0
            r7 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L60
            if (r8 == 0) goto L59
            boolean r9 = r8.moveToNext()     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L56
            if (r9 == 0) goto L59
            java.lang.String r9 = "value"
            int r9 = r8.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L56
            java.lang.String r1 = r8.getString(r9)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L56
            goto L59
        L52:
            r0 = move-exception
            r9 = r0
            r1 = r8
            goto L6a
        L56:
            r0 = move-exception
            r9 = r0
            goto L63
        L59:
            com.bytedance.embedapplog.no.xj(r8)
            return r1
        L5d:
            r0 = move-exception
            r9 = r0
            goto L6a
        L60:
            r0 = move-exception
            r9 = r0
            r8 = r1
        L63:
            com.bytedance.embedapplog.cu.xj(r9)     // Catch: java.lang.Throwable -> L52
            com.bytedance.embedapplog.no.xj(r8)
            goto L6e
        L6a:
            com.bytedance.embedapplog.no.xj(r1)
            throw r9
        L6e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.embedapplog.ew.xj(android.content.Context, int, java.lang.String):java.lang.String");
    }
}
