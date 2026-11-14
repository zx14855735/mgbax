package LCJm5h;

import C4FrIb.B4ZgIw;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.fl.saas.common.util.FileTypeUtils;
import com.sigmob.sdk.archives.d;
import com.ss.android.download.api.constant.BaseConstants;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final ExecutorService f4429A2egSU = Executors.newSingleThreadExecutor();

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final Handler f4430A4TApA = new Handler(Looper.getMainLooper());

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final AtomicBoolean f4431A5SV6n = new AtomicBoolean(false);

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final AtomicBoolean f4432ADYaiT = new AtomicBoolean(false);

    static {
        mYYll();
    }

    public static String A2egSU(long j) {
        if (j >= ConstantsAPI.AppSupportContentFlag.MMAPP_SUPPORT_XLS) {
            return j < BaseConstants.MB_VALUE ? String.format(Locale.ROOT, "%.1f KB", Double.valueOf(j / 1024.0d)) : String.format(Locale.ROOT, "%.1f MB", Double.valueOf(j / 1048576.0d));
        }
        return j + " B";
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x007d A[Catch: IOException -> 0x0079, TRY_LEAVE, TryCatch #0 {IOException -> 0x0079, blocks: (B:51:0x0075, B:44:0x007d), top: B:50:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean A4TApA(android.content.Context r8, android.net.Uri r9, java.io.File r10) {
        /*
            r0 = 0
            r1 = 0
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5b
            java.io.InputStream r8 = r8.openInputStream(r9)     // Catch: java.lang.Throwable -> L58 java.io.IOException -> L5b
            if (r8 != 0) goto L18
            if (r8 == 0) goto L72
            r8.close()     // Catch: java.io.IOException -> L12
            return r0
        L12:
            r8 = move-exception
            r8.printStackTrace()
            goto L72
        L18:
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L56
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L53 java.io.IOException -> L56
            r1 = 8192(0x2000, float:1.14794E-41)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
            r2 = 0
            r4 = r2
        L24:
            int r6 = r8.read(r1)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
            if (r6 <= 0) goto L35
            r9.write(r1, r0, r6)     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
            long r6 = (long) r6     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
            long r4 = r4 + r6
            goto L24
        L30:
            r10 = move-exception
        L31:
            r1 = r8
            goto L73
        L33:
            r1 = r8
            goto L5c
        L35:
            boolean r1 = r10.exists()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
            if (r1 == 0) goto L4c
            long r6 = r10.length()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 <= 0) goto L4c
            long r1 = r10.length()     // Catch: java.lang.Throwable -> L30 java.io.IOException -> L33
            int r10 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r10 != 0) goto L4c
            r0 = 1
        L4c:
            r8.close()     // Catch: java.io.IOException -> L12
            r9.close()     // Catch: java.io.IOException -> L12
            return r0
        L53:
            r10 = move-exception
            r9 = r1
            goto L31
        L56:
            r9 = r1
            goto L33
        L58:
            r10 = move-exception
            r9 = r1
            goto L73
        L5b:
            r9 = r1
        L5c:
            boolean r8 = r10.exists()     // Catch: java.lang.Throwable -> L66
            if (r8 == 0) goto L68
            r10.delete()     // Catch: java.lang.Throwable -> L66
            goto L68
        L66:
            r10 = move-exception
            goto L73
        L68:
            if (r1 == 0) goto L6d
            r1.close()     // Catch: java.io.IOException -> L12
        L6d:
            if (r9 == 0) goto L72
            r9.close()     // Catch: java.io.IOException -> L12
        L72:
            return r0
        L73:
            if (r1 == 0) goto L7b
            r1.close()     // Catch: java.io.IOException -> L79
            goto L7b
        L79:
            r8 = move-exception
            goto L81
        L7b:
            if (r9 == 0) goto L84
            r9.close()     // Catch: java.io.IOException -> L79
            goto L84
        L81:
            r8.printStackTrace()
        L84:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: LCJm5h.ARc23Z.A4TApA(android.content.Context, android.net.Uri, java.io.File):boolean");
    }

    public static String A5SV6n(File file, String str) {
        String str2;
        String str3;
        String str4;
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0) {
            str3 = str.substring(0, lastIndexOf);
            str2 = str.substring(lastIndexOf);
        } else {
            str2 = "";
            str3 = str;
        }
        if (!new File(file, str).exists()) {
            return str;
        }
        int i = 1;
        do {
            str4 = str3 + " (" + i + ")" + str2;
            i++;
        } while (new File(file, str4).exists());
        return str4;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0081 A[Catch: IOException -> 0x007d, TRY_LEAVE, TryCatch #7 {IOException -> 0x007d, blocks: (B:61:0x0079, B:54:0x0081), top: B:60:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean ADYaiT(java.io.File r10, java.io.File r11) {
        /*
            r0 = 0
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58
            r2.<init>(r10)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L58
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L53
            r3.<init>(r11)     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L53
            r1 = 8192(0x2000, float:1.14794E-41)
            byte[] r1 = new byte[r1]     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L23
            r4 = 0
            r6 = r4
        L13:
            int r8 = r2.read(r1)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L23
            if (r8 <= 0) goto L25
            r3.write(r1, r0, r8)     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L23
            long r8 = (long) r8     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L23
            long r6 = r6 + r8
            goto L13
        L1f:
            r10 = move-exception
        L20:
            r1 = r2
            goto L77
        L23:
            r1 = r2
            goto L59
        L25:
            boolean r1 = r11.exists()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L23
            if (r1 == 0) goto L3d
            long r8 = r11.length()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L23
            int r1 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r1 <= 0) goto L3d
            long r4 = r11.length()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L23
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 != 0) goto L3d
            r1 = 1
            goto L3e
        L3d:
            r1 = 0
        L3e:
            if (r1 == 0) goto L43
            r10.delete()     // Catch: java.lang.Throwable -> L1f java.io.IOException -> L23
        L43:
            r2.close()     // Catch: java.io.IOException -> L4a
            r3.close()     // Catch: java.io.IOException -> L4a
            return r1
        L4a:
            r10 = move-exception
            r10.printStackTrace()
            r0 = r1
            goto L76
        L50:
            r10 = move-exception
            r3 = r1
            goto L20
        L53:
            r3 = r1
            goto L23
        L55:
            r10 = move-exception
            r3 = r1
            goto L77
        L58:
            r3 = r1
        L59:
            boolean r10 = r11.exists()     // Catch: java.lang.Throwable -> L63
            if (r10 == 0) goto L65
            r11.delete()     // Catch: java.lang.Throwable -> L63
            goto L65
        L63:
            r10 = move-exception
            goto L77
        L65:
            if (r1 == 0) goto L6d
            r1.close()     // Catch: java.io.IOException -> L6b
            goto L6d
        L6b:
            r10 = move-exception
            goto L73
        L6d:
            if (r3 == 0) goto L76
            r3.close()     // Catch: java.io.IOException -> L6b
            goto L76
        L73:
            r10.printStackTrace()
        L76:
            return r0
        L77:
            if (r1 == 0) goto L7f
            r1.close()     // Catch: java.io.IOException -> L7d
            goto L7f
        L7d:
            r11 = move-exception
            goto L85
        L7f:
            if (r3 == 0) goto L88
            r3.close()     // Catch: java.io.IOException -> L7d
            goto L88
        L85:
            r11.printStackTrace()
        L88:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: LCJm5h.ARc23Z.ADYaiT(java.io.File, java.io.File):boolean");
    }

    public static void AMqCpz(FragmentActivity fragmentActivity, Uri uri, File file, AMqCpz aMqCpz) {
        AtomicBoolean atomicBoolean = f4431A5SV6n;
        if (atomicBoolean.get()) {
            f4430A4TApA.post(new A4TApA(aMqCpz, 0));
            return;
        }
        atomicBoolean.set(true);
        f4429A2egSU.execute(new AZkASS.AMqCpz(fragmentActivity, uri, file, aMqCpz));
    }

    public static String ARc23Z(String str) {
        int lastIndexOf;
        return (str == null || str.trim().isEmpty() || (str.startsWith(".") && str.indexOf(46, 1) == -1) || (lastIndexOf = str.lastIndexOf(".")) == -1 || lastIndexOf == str.length() - 1) ? "" : str.substring(lastIndexOf + 1).toLowerCase(Locale.ROOT);
    }

    public static String ASJ6gh(String str) {
        String ARc23Z2 = ARc23Z(str);
        return ARc23Z2.isEmpty() ? "" : ".".concat(ARc23Z2);
    }

    public static String AYUAbz(Context context, Uri uri) {
        Throwable th;
        int columnIndex;
        Cursor cursor = null;
        try {
            Cursor query = context.getContentResolver().query(uri, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst() && (columnIndex = query.getColumnIndex("_display_name")) >= 0) {
                        String string = query.getString(columnIndex);
                        query.close();
                        return string;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor == null) {
                        throw th;
                    }
                    cursor.close();
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static int AZOQYO(String str) {
        String lowerCase = ARc23Z(str).toLowerCase(Locale.ROOT);
        if ("gba".equals(lowerCase)) {
            return 0;
        }
        if (d.e.equals(lowerCase)) {
            return 4;
        }
        if ("ips".equals(lowerCase) || "ups".equals(lowerCase) || "bps".equals(lowerCase)) {
            return 1;
        }
        if ("sav".equals(lowerCase) || lowerCase.contains("savetype")) {
            return 2;
        }
        return (FileTypeUtils.FILE_TYPE_PNG.equals(lowerCase) || FileTypeUtils.FILE_TYPE_JPEG.equals(lowerCase) || "jpeg".equals(lowerCase) || "webp".equals(lowerCase)) ? 3 : -1;
    }

    public static boolean AZkASS(byte[] bArr) {
        if (bArr.length >= 16 && !AcNBzu(bArr)) {
            for (int i = 0; i < Math.min(bArr.length, 64); i++) {
                byte b = bArr[i];
                if (b != 0 && b != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean AaHO0E(byte[] bArr) {
        if (bArr.length < 192 || (bArr[178] & 255) != 150 || 175 >= bArr.length) {
            return false;
        }
        for (int i = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DASH_ABR; i <= 175; i++) {
            byte b = bArr[i];
            if (b != 0 && (b < 32 || b > 126)) {
                return false;
            }
        }
        return true;
    }

    public static boolean AcNBzu(byte[] bArr) {
        if (bArr.length != 0) {
            boolean z = true;
            boolean z2 = true;
            for (byte b : bArr) {
                if (b != 0) {
                    z = false;
                }
                if (b != -1) {
                    z2 = false;
                }
                if (!z && !z2) {
                    break;
                }
            }
            if (!z && !z2) {
                return false;
            }
        }
        return true;
    }

    public static void AlLFFp(Context context, Uri uri, AMqCpz aMqCpz) {
        AtomicBoolean atomicBoolean = f4431A5SV6n;
        if (atomicBoolean.get()) {
            f4430A4TApA.post(new A4TApA(aMqCpz, 1));
            return;
        }
        atomicBoolean.set(true);
        f4429A2egSU.execute(new B4ZgIw(context, uri, aMqCpz, 6));
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a7, code lost:
    
        if (AcNBzu(r6) == false) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005d A[Catch: IOException -> 0x00af, TryCatch #3 {IOException -> 0x00af, blocks: (B:33:0x0053, B:34:0x0057, B:36:0x005d, B:39:0x0069, B:44:0x0081, B:50:0x00ab, B:70:0x004d, B:30:0x0034, B:32:0x003a, B:68:0x0047), top: B:10:0x0032, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0081 A[Catch: IOException -> 0x00af, TRY_LEAVE, TryCatch #3 {IOException -> 0x00af, blocks: (B:33:0x0053, B:34:0x0057, B:36:0x005d, B:39:0x0069, B:44:0x0081, B:50:0x00ab, B:70:0x004d, B:30:0x0034, B:32:0x003a, B:68:0x0047), top: B:10:0x0032, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x007d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int AmA8tU(java.io.File r9) {
        /*
            boolean r0 = r9.exists()
            r1 = 3
            if (r0 == 0) goto Ld7
            boolean r0 = r9.isFile()
            if (r0 == 0) goto Ld7
            boolean r0 = r9.canRead()
            if (r0 == 0) goto Ld7
            long r2 = r9.length()
            r4 = 1024(0x400, double:5.06E-321)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto Ld7
            java.lang.String r0 = r9.getName()
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r0 = r0.toLowerCase(r2)
            java.lang.String r2 = ".zip"
            boolean r0 = r0.endsWith(r2)
            r2 = 0
            r3 = 192(0xc0, float:2.69E-43)
            r4 = 2
            r5 = 1
            if (r0 == 0) goto Lb0
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L4d
            r6 = 24
            if (r0 < r6) goto L47
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch: java.lang.Exception -> L4d
            java.lang.String r0 = "GBK"
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)     // Catch: java.lang.Exception -> L4d
            java.util.zip.ZipFile r9 = ADYaiT.BpkvW3.B3GDIM(r9, r0)     // Catch: java.lang.Exception -> L4d
            goto L53
        L47:
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch: java.lang.Exception -> L4d
            r0.<init>(r9)     // Catch: java.lang.Exception -> L4d
            goto L52
        L4d:
            java.util.zip.ZipFile r0 = new java.util.zip.ZipFile     // Catch: java.io.IOException -> Laf
            r0.<init>(r9)     // Catch: java.io.IOException -> Laf
        L52:
            r9 = r0
        L53:
            java.util.Enumeration r0 = r9.entries()     // Catch: java.io.IOException -> Laf
        L57:
            boolean r6 = r0.hasMoreElements()     // Catch: java.io.IOException -> Laf
            if (r6 == 0) goto L7d
            java.lang.Object r6 = r0.nextElement()     // Catch: java.io.IOException -> Laf
            java.util.zip.ZipEntry r6 = (java.util.zip.ZipEntry) r6     // Catch: java.io.IOException -> Laf
            boolean r7 = r6.isDirectory()     // Catch: java.io.IOException -> Laf
            if (r7 != 0) goto L57
            java.lang.String r7 = r6.getName()     // Catch: java.io.IOException -> Laf
            java.util.Locale r8 = java.util.Locale.ROOT     // Catch: java.io.IOException -> Laf
            java.lang.String r7 = r7.toLowerCase(r8)     // Catch: java.io.IOException -> Laf
            java.lang.String r8 = ".gba"
            boolean r7 = r7.endsWith(r8)     // Catch: java.io.IOException -> Laf
            if (r7 == 0) goto L57
            r0 = 1
            goto L7f
        L7d:
            r6 = 0
            r0 = 0
        L7f:
            if (r0 != 0) goto L86
            r9.close()     // Catch: java.io.IOException -> Laf
            r1 = 2
            goto Laf
        L86:
            java.io.InputStream r0 = r9.getInputStream(r6)     // Catch: java.io.IOException -> Laa
            byte[] r6 = new byte[r3]     // Catch: java.io.IOException -> Laa
            int r0 = r0.read(r6)     // Catch: java.io.IOException -> Laa
            if (r0 >= r3) goto L94
        L92:
            r2 = 2
            goto Lab
        L94:
            boolean r0 = AaHO0E(r6)     // Catch: java.io.IOException -> Laa
            if (r0 == 0) goto L9b
            goto Lab
        L9b:
            boolean r0 = AZkASS(r6)     // Catch: java.io.IOException -> Laa
            if (r0 == 0) goto La3
        La1:
            r2 = 1
            goto Lab
        La3:
            boolean r0 = AcNBzu(r6)     // Catch: java.io.IOException -> Laa
            if (r0 != 0) goto L92
            goto La1
        Laa:
            r2 = 3
        Lab:
            r9.close()     // Catch: java.io.IOException -> Laf
            r1 = r2
        Laf:
            return r1
        Lb0:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.io.IOException -> Ld7
            r0.<init>(r9)     // Catch: java.io.IOException -> Ld7
            byte[] r9 = new byte[r3]     // Catch: java.io.IOException -> Ld7
            int r6 = r0.read(r9)     // Catch: java.io.IOException -> Ld7
            r0.close()     // Catch: java.io.IOException -> Ld7
            if (r6 >= r3) goto Lc1
            goto Ld6
        Lc1:
            boolean r0 = AaHO0E(r9)     // Catch: java.io.IOException -> Ld7
            if (r0 == 0) goto Lc8
            return r2
        Lc8:
            boolean r0 = AZkASS(r9)     // Catch: java.io.IOException -> Ld7
            if (r0 == 0) goto Lcf
            goto Ld5
        Lcf:
            boolean r9 = AcNBzu(r9)     // Catch: java.io.IOException -> Ld7
            if (r9 != 0) goto Ld6
        Ld5:
            return r5
        Ld6:
            return r4
        Ld7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: LCJm5h.ARc23Z.AmA8tU(java.io.File):int");
    }

    private static /* synthetic */ void mYYll() {
        char[] charArray = "ÍÁÃ\u0080ÉÏÃË\u0080ÌÁ×\u0080ÝÆËÂÂ\u0080äÀÇìÜÇÊÉË".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 174);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÍÂÇÀÇÚ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 174);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
