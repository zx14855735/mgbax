package com.bytedance.pangle.f;

import android.content.pm.Signature;
import com.sigmob.sdk.downloader.f;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static final AtomicReference<byte[]> xj = new AtomicReference<>();

    static {
        viXoPa();
    }

    private static /* synthetic */ void viXoPa() {
        char[] charArray = "\u0097\u009b\u0099Ú\u0093\u0095\u0099\u0091Ú\u0096\u009b\u008dÚ\u0087\u009c\u0091\u0098\u0098Ú¾\u009a\u009d¶\u0086\u009d\u0090\u0093\u0091".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 244);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0097\u0098\u009d\u009a\u009d\u0080".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 244);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static qt xj(String str, boolean z) {
        GeneralSecurityException generalSecurityException;
        Throwable th;
        Throwable th2;
        JarFile jarFile;
        JarFile jarFile2 = null;
        try {
            try {
                jarFile = new JarFile(str);
            } catch (Throwable th3) {
                th2 = th3;
            }
        } catch (IOException e) {
            e = e;
            th = e;
            throw new e(4, "Failed to collect certificates from ".concat(String.valueOf(str)), th);
        } catch (RuntimeException e2) {
            e = e2;
            th = e;
            throw new e(4, "Failed to collect certificates from ".concat(String.valueOf(str)), th);
        } catch (GeneralSecurityException e3) {
            generalSecurityException = e3;
        }
        try {
            ArrayList arrayList = new ArrayList();
            JarEntry jarEntry = jarFile.getJarEntry("AndroidManifest.xml");
            if (jarEntry == null) {
                throw new e(1, "Package " + str + " has no manifest");
            }
            Certificate[][] xj2 = xj(jarFile, jarEntry);
            if (com.bytedance.pangle.util.u.xj(xj2)) {
                throw new e(4, "Package " + str + " has no certificates at entry AndroidManifest.xml");
            }
            Signature[] xj3 = u.xj(xj2);
            if (z) {
                Enumeration<JarEntry> entries = jarFile.entries();
                while (entries.hasMoreElements()) {
                    JarEntry nextElement = entries.nextElement();
                    if (!nextElement.isDirectory()) {
                        String name = nextElement.getName();
                        if (!name.startsWith("META-INF/") && !name.equals("AndroidManifest.xml")) {
                            arrayList.add(nextElement);
                        }
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    JarEntry jarEntry2 = (JarEntry) it.next();
                    Certificate[][] xj4 = xj(jarFile, jarEntry2);
                    if (com.bytedance.pangle.util.u.xj(xj4)) {
                        throw new e(4, "Package " + str + " has no certificates at entry " + jarEntry2.getName());
                    }
                    if (!qt.xj(xj3, u.xj(xj4))) {
                        throw new e(3, "Package " + str + " has mismatched certificates at entry " + jarEntry2.getName());
                    }
                }
            }
            qt qtVar = new qt(xj3, 1, null, null, null);
            try {
                jarFile.close();
            } catch (Exception unused) {
            }
            return qtVar;
        } catch (IOException e4) {
            e = e4;
            th = e;
            throw new e(4, "Failed to collect certificates from ".concat(String.valueOf(str)), th);
        } catch (RuntimeException e5) {
            e = e5;
            th = e;
            throw new e(4, "Failed to collect certificates from ".concat(String.valueOf(str)), th);
        } catch (GeneralSecurityException e6) {
            generalSecurityException = e6;
            throw new e(2, "Failed to collect certificates from ".concat(String.valueOf(str)), generalSecurityException);
        } catch (Throwable th4) {
            th2 = th4;
            jarFile2 = jarFile;
            if (jarFile2 == null) {
                throw th2;
            }
            try {
                jarFile2.close();
                throw th2;
            } catch (Exception unused2) {
                throw th2;
            }
        }
    }

    private static Certificate[][] xj(JarFile jarFile, JarEntry jarEntry) {
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStream2 = jarFile.getInputStream(jarEntry);
                xj(inputStream2);
                Certificate[][] certificateArr = {jarEntry.getCertificates()};
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                        return certificateArr;
                    } catch (RuntimeException e) {
                        throw e;
                    } catch (Exception unused) {
                    }
                }
                return certificateArr;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | RuntimeException e3) {
            throw new e(5, "Failed reading " + jarEntry.getName() + " in " + jarFile, e3);
        }
    }

    private static void xj(InputStream inputStream) {
        byte[] andSet = xj.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[f.a.c];
        }
        while (inputStream.read(andSet, 0, andSet.length) != -1) {
        }
        xj.set(andSet);
    }
}
