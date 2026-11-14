package LCJm5h;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AYUAbz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static volatile Context f4437A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public static volatile Map f4438A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static volatile Map f4439A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final AtomicBoolean f4440ADYaiT;
    public static final Object AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final AtomicBoolean f4441ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static volatile ArrayList f4442ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static volatile String f4443AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static volatile long f4444AZOQYO;

    static {
        Map map = Collections.EMPTY_MAP;
        f4438A4TApA = map;
        f4439A5SV6n = map;
        f4440ADYaiT = new AtomicBoolean(false);
        AMqCpz = new Object();
        f4441ARc23Z = new AtomicBoolean(false);
        f4442ASJ6gh = null;
        f4443AYUAbz = null;
        f4444AZOQYO = 0L;
        Unxt();
    }

    public static void A2egSU() {
        FileWriter fileWriter;
        synchronized (AMqCpz) {
            try {
                ADYaiT();
                File externalStorageDirectory = Environment.getExternalStorageDirectory();
                if (externalStorageDirectory == null) {
                    Context context = f4437A2egSU;
                    externalStorageDirectory = context != null ? context.getFilesDir() : new File(".");
                }
                File file = new File(externalStorageDirectory, "GBoy/rom");
                File AMqCpz2 = AMqCpz();
                ArrayList arrayList = f4442ASJ6gh;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Map map = f4438A4TApA;
                    HashMap hashMap = new HashMap();
                    ArrayList arrayList2 = new ArrayList();
                    HashSet hashSet = new HashSet();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        File file2 = (File) it.next();
                        if (file2 != null && file2.exists()) {
                            String ARc23Z2 = ARc23Z(file2, file);
                            hashSet.add(ARc23Z2);
                            ASJ6gh aSJ6gh = (ASJ6gh) map.get(ARc23Z2);
                            if (aSJ6gh != null && aSJ6gh.f4435A5SV6n == file2.lastModified() && aSJ6gh.f4436ADYaiT == file2.length()) {
                                hashMap.put(ARc23Z2, aSJ6gh);
                            } else {
                                arrayList2.add(file2);
                            }
                        }
                    }
                    Iterator it2 = map.keySet().iterator();
                    int i = 0;
                    while (it2.hasNext()) {
                        if (!hashSet.contains((String) it2.next())) {
                            i++;
                        }
                    }
                    if (arrayList2.isEmpty() && i == 0) {
                        return;
                    }
                    arrayList2.size();
                    HashMap hashMap2 = new HashMap(arrayList2.size());
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        File file3 = (File) it3.next();
                        String A4TApA2 = A4TApA(file3);
                        if (A4TApA2 != null) {
                            String ARc23Z3 = ARc23Z(file3, file);
                            hashMap2.put(ARc23Z3, new ASJ6gh(ARc23Z3, A4TApA2, file3.lastModified(), file3.length()));
                        }
                    }
                    HashMap hashMap3 = new HashMap(hashMap.size() + hashMap2.size());
                    hashMap3.putAll(hashMap);
                    hashMap3.putAll(hashMap2);
                    FileWriter fileWriter2 = null;
                    try {
                        try {
                            fileWriter = new FileWriter(AMqCpz2);
                        } catch (IOException unused) {
                        }
                        try {
                            Iterator it4 = hashMap3.values().iterator();
                            while (it4.hasNext()) {
                                fileWriter.write(((ASJ6gh) it4.next()).A4TApA());
                                fileWriter.write(10);
                            }
                            hashMap3.size();
                            AMqCpz2.getAbsolutePath();
                            fileWriter.close();
                        } catch (Exception unused2) {
                            fileWriter2 = fileWriter;
                            if (fileWriter2 != null) {
                                fileWriter2.close();
                            }
                            AZOQYO(hashMap3);
                        } catch (Throwable th) {
                            th = th;
                            fileWriter2 = fileWriter;
                            if (fileWriter2 != null) {
                                try {
                                    fileWriter2.close();
                                } catch (IOException unused3) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception unused4) {
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    AZOQYO(hashMap3);
                }
            } finally {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x005f, code lost:
    
        if (r1 == null) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v10, types: [android.os.Looper] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.io.FileInputStream, java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String A4TApA(java.io.File r4) {
        /*
            r0 = 0
            if (r4 == 0) goto La0
            boolean r1 = r4.exists()
            if (r1 != 0) goto Lb
            goto La0
        Lb:
            java.lang.String r1 = r4.getName()
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toLowerCase(r2)
            java.lang.String r2 = ".zip"
            boolean r1 = r1.endsWith(r2)
            if (r1 == 0) goto L69
            java.util.zip.ZipInputStream r1 = new java.util.zip.ZipInputStream     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
        L27:
            java.util.zip.ZipEntry r2 = r1.getNextEntry()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5c
            if (r2 == 0) goto L55
            boolean r3 = r2.isDirectory()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5c
            if (r3 == 0) goto L34
            goto L27
        L34:
            java.lang.String r2 = r2.getName()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5c
            java.util.Locale r3 = java.util.Locale.ROOT     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5c
            java.lang.String r2 = r2.toLowerCase(r3)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5c
            java.lang.String r3 = ".gba"
            boolean r2 = r2.endsWith(r3)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5c
            if (r2 == 0) goto L51
            java.lang.String r0 = ASJ6gh(r1)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5c
            r1.close()     // Catch: java.io.IOException -> L62
            return r0
        L4e:
            r4 = move-exception
            r0 = r1
            goto L63
        L51:
            r1.closeEntry()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5c
            goto L27
        L55:
            r1.close()     // Catch: java.io.IOException -> L62
            goto L62
        L59:
            r4 = move-exception
            goto L63
        L5b:
            r1 = r0
        L5c:
            r4.getName()     // Catch: java.lang.Throwable -> L4e
            if (r1 == 0) goto L62
            goto L55
        L62:
            return r0
        L63:
            if (r0 == 0) goto L68
            r0.close()     // Catch: java.io.IOException -> L68
        L68:
            throw r4
        L69:
            boolean r1 = r4.exists()
            if (r1 != 0) goto L70
            return r0
        L70:
            android.os.Looper r1 = android.os.Looper.myLooper()
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            if (r1 != r2) goto L7e
            r4.getName()
            return r0
        L7e:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L8e java.lang.Exception -> L90
            java.lang.String r0 = ASJ6gh(r1)     // Catch: java.lang.Throwable -> L8b java.lang.Exception -> L91
            r1.close()     // Catch: java.io.IOException -> L99
            return r0
        L8b:
            r4 = move-exception
            r0 = r1
            goto L9a
        L8e:
            r4 = move-exception
            goto L9a
        L90:
            r1 = r0
        L91:
            r4.getName()     // Catch: java.lang.Throwable -> L8b
            if (r1 == 0) goto L99
            r1.close()     // Catch: java.io.IOException -> L99
        L99:
            return r0
        L9a:
            if (r0 == 0) goto L9f
            r0.close()     // Catch: java.io.IOException -> L9f
        L9f:
            throw r4
        La0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: LCJm5h.AYUAbz.A4TApA(java.io.File):java.lang.String");
    }

    public static void A5SV6n() {
        if (f4440ADYaiT.get()) {
            return;
        }
        synchronized (AMqCpz) {
            ADYaiT();
        }
    }

    public static void ADYaiT() {
        AtomicBoolean atomicBoolean = f4440ADYaiT;
        if (atomicBoolean.get()) {
            return;
        }
        System.currentTimeMillis();
        File AMqCpz2 = AMqCpz();
        HashMap hashMap = new HashMap();
        if (AMqCpz2.exists()) {
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(AMqCpz2));
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine == null) {
                                break;
                            }
                            ASJ6gh A2egSU2 = ASJ6gh.A2egSU(readLine);
                            if (A2egSU2 != null) {
                                hashMap.put(A2egSU2.f4433A2egSU, A2egSU2);
                            }
                        } catch (Exception unused) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            AZOQYO(hashMap);
                            atomicBoolean.set(true);
                            System.currentTimeMillis();
                            hashMap.size();
                            Looper.myLooper();
                            Looper.getMainLooper();
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th;
                        }
                    }
                    hashMap.size();
                    AMqCpz2.getAbsolutePath();
                    bufferedReader2.close();
                } catch (IOException unused3) {
                }
            } catch (Exception unused4) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        AZOQYO(hashMap);
        atomicBoolean.set(true);
        System.currentTimeMillis();
        hashMap.size();
        Looper.myLooper();
        Looper.getMainLooper();
    }

    public static File AMqCpz() {
        Context context = f4437A2egSU;
        if (context != null) {
            File file = new File(context.getFilesDir(), "rommd5");
            if (!file.exists()) {
                file.mkdirs();
            }
            return new File(file, "md5.txt");
        }
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            Context context2 = f4437A2egSU;
            externalStorageDirectory = context2 != null ? context2.getFilesDir() : new File(".");
        }
        File file2 = new File(externalStorageDirectory, "GBoy/.md5");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return new File(file2, "md5.txt");
    }

    public static String ARc23Z(File file, File file2) {
        try {
            String canonicalPath = file2.getCanonicalPath();
            String canonicalPath2 = file.getCanonicalPath();
            if (canonicalPath2.startsWith(canonicalPath)) {
                return canonicalPath2.substring(canonicalPath.length() + 1);
            }
        } catch (Exception unused) {
        }
        return file.getName();
    }

    public static String ASJ6gh(InputStream inputStream) {
        int i;
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] bArr = new byte[65536];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            messageDigest.update(bArr, 0, read);
        }
        byte[] digest = messageDigest.digest();
        char[] charArray = "0123456789abcdef".toCharArray();
        char[] cArr = new char[32];
        for (i = 0; i < 16; i++) {
            byte b = digest[i];
            int i2 = i * 2;
            cArr[i2] = charArray[(b & 255) >>> 4];
            cArr[i2 + 1] = charArray[b & 15];
        }
        return new String(cArr);
    }

    public static String AYUAbz(ArrayList arrayList) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder(arrayList.size() * 40);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (file != null) {
                sb.append(file.getAbsolutePath());
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    public static void AZOQYO(HashMap hashMap) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            Context context = f4437A2egSU;
            externalStorageDirectory = context != null ? context.getFilesDir() : new File(".");
        }
        File file = new File(externalStorageDirectory, "GBoy/rom");
        HashMap hashMap2 = new HashMap(hashMap.size());
        HashMap hashMap3 = new HashMap(hashMap.size());
        for (ASJ6gh aSJ6gh : hashMap.values()) {
            if (aSJ6gh != null) {
                hashMap2.put(aSJ6gh.f4433A2egSU, aSJ6gh);
                hashMap3.put(aSJ6gh.f4434A4TApA.toLowerCase(Locale.ROOT), new File(file, aSJ6gh.f4433A2egSU));
            }
        }
        f4438A4TApA = hashMap2;
        f4439A5SV6n = hashMap3;
        hashMap2.size();
        hashMap3.size();
    }

    private static /* synthetic */ void Unxt() {
        char[] charArray = " ¬®í¤¢®¦í¡¬ºí°«¦¯¯í\u0089\u00adª\u0081±ª§¤¦".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 195);
        }
        String str = new String(charArray);
        char[] charArray2 = " ¯ª\u00adª·".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 195);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
