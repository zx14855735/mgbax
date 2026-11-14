package com.bytedance.pangle.f;

import android.content.pm.Signature;
import com.bytedance.pangle.f.w;
import com.kuaishou.weapon.p0.t;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.Certificate;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    public static qt xj(String str, int i) {
        int[] iArr;
        if (i > 3) {
            throw new e(4, "No signature found in package of version " + i + " or newer for package " + str);
        }
        RandomAccessFile randomAccessFile = null;
        Signature[] signatureArr = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, t.k);
                try {
                    try {
                        y.xj(str, randomAccessFile2, -262969152, 1896449818);
                        try {
                            try {
                                w.C0088w xj = w.xj(randomAccessFile2, str);
                                Signature[] xj2 = xj(new Certificate[][]{xj.xj});
                                w.hf hfVar = xj.hf;
                                if (hfVar != null) {
                                    int size = hfVar.xj.size();
                                    Signature[] signatureArr2 = new Signature[size];
                                    iArr = new int[xj.hf.hf.size()];
                                    for (int i2 = 0; i2 < size; i2++) {
                                        signatureArr2[i2] = new Signature(xj.hf.xj.get(i2).getEncoded());
                                        iArr[i2] = xj.hf.hf.get(i2).intValue();
                                    }
                                    signatureArr = signatureArr2;
                                } else {
                                    iArr = null;
                                }
                                qt qtVar = new qt(xj2, 3, signatureArr, iArr);
                                try {
                                    randomAccessFile2.close();
                                } catch (Exception unused) {
                                }
                                return qtVar;
                            } catch (Exception e) {
                                throw new e(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v3", e);
                            }
                        } catch (am e2) {
                            if (i >= 3) {
                                throw new e(4, "No APK Signature Scheme v3 signature in package ".concat(String.valueOf(str)), e2);
                            }
                            if (i > 2) {
                                throw new e(4, "No signature found in package of version " + i + " or newer for package " + str);
                            }
                            try {
                                try {
                                    qt qtVar2 = new qt(xj(hf.xj(randomAccessFile2, str)), 2);
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Exception unused2) {
                                    }
                                    return qtVar2;
                                } catch (Exception e3) {
                                    throw new e(4, "Failed to collect certificates from " + str + " using APK Signature Scheme v2", e3);
                                }
                            } catch (am e4) {
                                if (i >= 2) {
                                    throw new e(4, "No APK Signature Scheme v2 signature in package ".concat(String.valueOf(str)), e4);
                                }
                                if (i <= 1) {
                                    qt xj3 = xj.xj(str, true);
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Exception unused3) {
                                    }
                                    return xj3;
                                }
                                throw new e(4, "No signature found in package of version " + i + " or newer for package " + str);
                            }
                        }
                    } catch (Exception e5) {
                        throw new e(4, "Failed to collect certificates from " + str + " when findSignatureInfo at once", e5);
                    }
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused5) {
            throw new e(6, "failed to read apk file, minSignatureSchemeVersion : " + i + ", apkPath : " + str);
        }
    }

    public static Signature[] xj(Certificate[][] certificateArr) {
        Signature[] signatureArr = new Signature[certificateArr.length];
        for (int i = 0; i < certificateArr.length; i++) {
            if (com.bytedance.pangle.util.d.u()) {
                Constructor xj = com.bytedance.pangle.hf.hf.xj.xj((Class<?>) Signature.class, (Class<?>[]) new Class[]{Certificate[].class});
                if (xj != null) {
                    xj.setAccessible(true);
                }
                if (xj != null && xj.isAccessible()) {
                    try {
                        signatureArr[i] = (Signature) xj.newInstance(certificateArr[i]);
                    } catch (IllegalAccessException e) {
                        com.bytedance.sdk.openadsdk.api.y.xj(e);
                    } catch (InstantiationException e2) {
                        com.bytedance.sdk.openadsdk.api.y.xj(e2);
                    } catch (InvocationTargetException e3) {
                        com.bytedance.sdk.openadsdk.api.y.xj(e3);
                    }
                }
            } else {
                signatureArr[i] = new Signature(certificateArr[i][0].getEncoded());
            }
        }
        return signatureArr;
    }
}
