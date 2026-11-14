package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class r {
    private static r c;
    private static Application d;

    /* renamed from: a, reason: collision with root package name */
    public boolean f12295a;
    private String e;
    private static Random f = new Random();
    private static Map<String, s> g = new ConcurrentHashMap();
    private static Map<String, s> h = new ConcurrentHashMap();
    public static List<Integer> b = new ArrayList();

    static {
        WYBV();
    }

    private r() {
    }

    private static /* synthetic */ void WYBV() {
        char[] charArray = "üðò±øþòú±ýðæ±ì÷úóó±ÕñöÝíöûøú".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 159);
        }
        String str = new String(charArray);
        char[] charArray2 = "üóöñöë".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 159);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static r a(Context context, boolean z) {
        try {
            if (c == null) {
                d = (Application) context.getApplicationContext();
                c = new r();
            }
        } catch (Throwable unused) {
        }
        return c;
    }

    public static boolean e(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (file.exists()) {
                return true;
            }
            file.mkdirs();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean b(String str) {
        s sVar = h.get(str);
        if (sVar == null) {
            return false;
        }
        g.remove(sVar.e);
        h.remove(str);
        dn.c(sVar.m);
        Application application = d;
        if (application == null) {
            return true;
        }
        dn.c(application.getFileStreamPath(sVar.c).getAbsolutePath());
        return true;
    }

    public s c(String str) {
        try {
            return g.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public s d(String str) {
        try {
            return h.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static r a() {
        return c;
    }

    public boolean a(s sVar, boolean z) {
        this.f12295a = z;
        this.e = sVar.d;
        return a(sVar);
    }

    public Map<String, s> b() {
        return h;
    }

    private synchronized boolean a(s sVar) {
        boolean z;
        if (sVar != null) {
            if (!TextUtils.isEmpty(sVar.e)) {
                s sVar2 = g.get(sVar.e);
                if (sVar2 != null) {
                    if (sVar2.d.equals(sVar.d)) {
                        return true;
                    }
                    a(sVar2.e);
                }
                try {
                    sVar.f = d;
                    if (sVar.p == 1) {
                        try {
                            try {
                                if (!TextUtils.isEmpty(sVar.c) && !TextUtils.isEmpty(sVar.e)) {
                                    sVar.m = d.getFilesDir().getCanonicalPath() + bi.j + sVar.f12296a;
                                    String str = sVar.m + "/dex";
                                    String str2 = sVar.m + "/lib/" + this.e;
                                    dn.c(sVar.m + "/lib");
                                    String str3 = str2 + "/" + f.nextInt();
                                    e(str);
                                    dn.a(str, Boolean.FALSE);
                                    e(str3);
                                    a(sVar, str3, str, false);
                                    h.put(sVar.c, sVar);
                                    g.put(sVar.e, sVar);
                                } else {
                                    throw new RuntimeException("apkPackageName or apkPkgPath is null");
                                }
                            } catch (Throwable unused) {
                                return false;
                            }
                        } catch (Throwable unused2) {
                            a(sVar.e);
                            z = true;
                        }
                    }
                    z = false;
                    if (sVar.p != 1 || z) {
                        PackageInfo packageInfo = sVar.r;
                        if (packageInfo == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)) {
                            packageInfo = d.getPackageManager().getPackageArchiveInfo(sVar.e, 1);
                        }
                        if (!TextUtils.isEmpty(packageInfo.packageName) && packageInfo.packageName.startsWith("com.kuaishou.weapon")) {
                            if (sVar.p != 1 && sVar.b != 1 && !((Boolean) a(sVar.j, sVar.e).first).booleanValue()) {
                                return false;
                            }
                            sVar.c = packageInfo.packageName;
                            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                            sVar.o = applicationInfo.className;
                            sVar.d = packageInfo.versionName;
                            sVar.l = packageInfo.activities;
                            sVar.q = applicationInfo.theme;
                            sVar.m = d.getFilesDir().getCanonicalPath() + bi.j + sVar.f12296a;
                            String str4 = sVar.m + "/dex";
                            String str5 = sVar.m + "/lib/" + this.e;
                            dn.c(sVar.m + "/lib");
                            String str6 = str5 + "/" + f.nextInt();
                            e(str4);
                            dn.a(str4, Boolean.FALSE);
                            e(str6);
                            a(sVar, str6, str4, true);
                            h.put(sVar.c, sVar);
                            g.put(sVar.e, sVar);
                            b.add(Integer.valueOf(sVar.f12296a));
                        } else {
                            throw new Exception("weapon package name check failed");
                        }
                    }
                    return true;
                } catch (Throwable unused3) {
                    a(sVar.e);
                    return false;
                }
            }
        }
        return false;
    }

    private Pair<Boolean, String> a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (!dn.a(file)) {
                return new Pair<>(Boolean.FALSE, "");
            }
            String a2 = f.a(file);
            if (TextUtils.isEmpty(a2)) {
                return new Pair<>(Boolean.FALSE, "");
            }
            if (!a2.equalsIgnoreCase(str)) {
                return new Pair<>(Boolean.FALSE, a2);
            }
            return new Pair<>(Boolean.TRUE, "");
        }
        return new Pair<>(Boolean.FALSE, "");
    }

    public boolean a(String str) {
        s sVar = g.get(str);
        if (sVar == null) {
            return false;
        }
        g.remove(str);
        h.remove(sVar.c);
        dn.c(sVar.m);
        Application application = d;
        if (application == null) {
            return true;
        }
        dn.c(application.getFileStreamPath(sVar.c).getAbsolutePath());
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:27|(1:224)(12:31|32|33|34|(4:36|(4:38|39|40|(1:42))(1:220)|43|(3:52|53|54))(1:221)|55|56|57|58|(3:59|60|(4:62|63|64|66)(1:157))|158|159)|160|161|(1:197)(8:166|167|168|169|170|(3:171|172|(4:174|175|176|178)(1:188))|189|190)|183|184|54|24|25) */
    /* JADX WARN: Can't wrap try/catch for region: R(30:0|1|(2:5|(26:9|10|(1:12)(1:260)|13|(1:15)|16|17|18|19|21|22|23|(10:27|(1:224)(12:31|32|33|34|(4:36|(4:38|39|40|(1:42))(1:220)|43|(3:52|53|54))(1:221)|55|56|57|58|(3:59|60|(4:62|63|64|66)(1:157))|158|159)|160|161|(1:197)(8:166|167|168|169|170|(3:171|172|(4:174|175|176|178)(1:188))|189|190)|183|184|54|24|25)|225|226|(1:228)|(1:230)|231|77|(6:79|80|81|(2:83|(1:85)(1:117))|119|(0)(0))(3:121|122|(1:124))|86|(1:92)|97|98|99|(2:101|(3:107|108|110)(1:105))(1:114)))|261|10|(0)(0)|13|(0)|16|17|18|19|21|22|23|(2:24|25)|225|226|(0)|(0)|231|77|(0)(0)|86|(3:88|90|92)|97|98|99|(0)(0)|(2:(1:252)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x02bf, code lost:
    
        r18.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02bd, code lost:
    
        if (r18 != null) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0226, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x025a, code lost:
    
        r1 = r23;
        r3 = r25;
        r4 = r7;
        r7 = r12;
        r6 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x0267, code lost:
    
        r1 = r23;
        r3 = r25;
        r4 = r7;
        r7 = r12;
        r6 = r13;
        r8 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x024d, code lost:
    
        r1 = r23;
        r3 = r25;
        r4 = r7;
        r7 = r12;
        r6 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0245, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x0246, code lost:
    
        r14 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0247, code lost:
    
        r17 = null;
        r18 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x02dc, code lost:
    
        if (r18 != null) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x02c2, code lost:
    
        r2 = r24;
        r3 = r25;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x03d9 A[Catch: all -> 0x044f, TryCatch #30 {all -> 0x044f, blocks: (B:99:0x03b8, B:101:0x03d9, B:103:0x03e3, B:111:0x042d, B:112:0x044e, B:108:0x03ed), top: B:98:0x03b8, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x044f A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0357 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006d A[Catch: all -> 0x00a7, IOException -> 0x00cd, EOFException -> 0x00d1, FileNotFoundException | ZipException -> 0x00d5, TryCatch #3 {all -> 0x00a7, blocks: (B:25:0x0067, B:27:0x006d, B:29:0x0083, B:31:0x0089, B:34:0x0090, B:36:0x0096, B:40:0x00a0, B:43:0x00af, B:45:0x00b5, B:47:0x00bb, B:49:0x00c1, B:55:0x00db, B:141:0x02b0, B:70:0x02cf, B:131:0x02e7, B:185:0x0229, B:187:0x022f), top: B:18:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0383  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.kuaishou.weapon.p0.s r24, java.lang.String r25, java.lang.String r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 1120
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.r.a(com.kuaishou.weapon.p0.s, java.lang.String, java.lang.String, boolean):void");
    }

    private void a(s sVar, String str, String str2, HashSet<String> hashSet, byte[] bArr, StringBuilder sb, boolean z) {
        File file;
        String str3;
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(sVar.e));
        FileOutputStream fileOutputStream = null;
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    break;
                }
                String name = nextEntry.getName();
                if (!name.contains("../")) {
                    if (name.startsWith("lib/") && !nextEntry.isDirectory()) {
                        String str4 = Build.CPU_ABI;
                        try {
                            str3 = Build.CPU_ABI2;
                        } catch (Throwable unused) {
                            str3 = null;
                        }
                        if (!name.contains(str4)) {
                            if (!TextUtils.isEmpty(str3) && name.contains(str3)) {
                            }
                            if (name.contains("armeabi")) {
                                if (!"armeabi-v7a".equalsIgnoreCase(str4)) {
                                    if (!TextUtils.isEmpty(str3) && "armeabi-v7a".equalsIgnoreCase(str3)) {
                                    }
                                }
                            }
                        }
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        sb2.append(name.substring(3).replace(".so", str2 + ".so"));
                        String sb3 = sb2.toString();
                        String substring = sb3.substring(0, sb3.lastIndexOf(47));
                        hashSet.add(substring.substring(substring.lastIndexOf(47) + 1));
                        e(substring);
                        File file2 = new File(sb3);
                        file2.delete();
                        file2.createNewFile();
                        FileOutputStream fileOutputStream2 = new FileOutputStream(sb3);
                        while (true) {
                            try {
                                int read = zipInputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                } else {
                                    fileOutputStream2.write(bArr, 0, read);
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                zipInputStream.close();
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw th;
                            }
                        }
                        fileOutputStream2.close();
                        dn.a(sb3, Boolean.TRUE);
                        fileOutputStream = fileOutputStream2;
                    }
                    try {
                        if (name.endsWith(".dex") && !nextEntry.isDirectory() && z) {
                            String str5 = sVar.m;
                            e(str5);
                            file = new File(str5, sVar.f12296a + "-" + sVar.d + ".dex");
                            try {
                                file.delete();
                                file.createNewFile();
                                FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                                while (true) {
                                    try {
                                        int read2 = zipInputStream.read(bArr);
                                        if (read2 <= 0) {
                                            break;
                                        } else {
                                            fileOutputStream3.write(bArr, 0, read2);
                                        }
                                    } catch (Throwable unused2) {
                                        fileOutputStream = fileOutputStream3;
                                        if (file != null && file.exists()) {
                                            file.delete();
                                        }
                                        zipInputStream.closeEntry();
                                    }
                                }
                                fileOutputStream3.close();
                                if (sb.length() > 0) {
                                    sb.setLength(0);
                                }
                                sb.append(file.getAbsolutePath());
                                dn.a(sb.toString(), Boolean.TRUE);
                                fileOutputStream = fileOutputStream3;
                            } catch (Throwable unused3) {
                            }
                        }
                    } catch (Throwable unused4) {
                        file = null;
                    }
                    zipInputStream.closeEntry();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        zipInputStream.close();
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
    }
}
