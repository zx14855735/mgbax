package com.kwad.sdk.api.loader;

import android.annotation.SuppressLint;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

@SuppressLint({"LongLogTag"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
final class z {

    public static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static String c(ClassLoader classLoader) {
            Object obj = z.c(classLoader, "pathList").get(classLoader);
            return z.u(Arrays.asList((File[]) z.c(obj, "nativeLibraryDirectories").get(obj)));
        }
    }

    public static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static String c(ClassLoader classLoader) {
            Object obj = z.c(classLoader, "pathList").get(classLoader);
            return z.u((List) z.c(obj, "nativeLibraryDirectories").get(obj));
        }
    }

    public static final class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static String c(ClassLoader classLoader) {
            Object obj = z.c(classLoader, "pathList").get(classLoader);
            return z.u((List) z.c(obj, "nativeLibraryDirectories").get(obj));
        }
    }

    public static final class d {
        /* JADX INFO: Access modifiers changed from: private */
        public static String g(ClassLoader classLoader) {
            Object obj = z.c(classLoader, "pathList").get(classLoader);
            return z.u((List) z.c(obj, "nativeLibraryDirectories").get(obj));
        }
    }

    public static final class e {
        /* JADX INFO: Access modifiers changed from: private */
        public static String c(ClassLoader classLoader) {
            return String.valueOf(z.c(classLoader, "libPath").get(classLoader));
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:3|4|(1:6)|(2:17|(3:31|32|10)(3:19|(2:22|23)(1:21)|10))|8|9|10) */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:
    
        java.lang.String.format("installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23", java.lang.Integer.valueOf(android.os.Build.VERSION.SDK_INT), r4.getMessage());
        r8 = com.kwad.sdk.api.loader.z.b.c(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
    
        if (r6 == 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized java.lang.String b(java.lang.ClassLoader r8) {
        /*
            r0 = 1
            r1 = 0
            r2 = 2
            java.lang.Class<com.kwad.sdk.api.loader.z> r3 = com.kwad.sdk.api.loader.z.class
            monitor-enter(r3)
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L13
            r5 = 25
            if (r4 != r5) goto L16
            int r6 = com.bytedance.pangle.activity.A2egSU.A2egSU()     // Catch: java.lang.Throwable -> L13
            if (r6 != 0) goto L18
            goto L16
        L13:
            r8 = move-exception
            goto L88
        L16:
            if (r4 <= r5) goto L38
        L18:
            java.lang.String r8 = com.kwad.sdk.api.loader.z.d.h(r8)     // Catch: java.lang.Throwable -> L1d
            goto L86
        L1d:
            r4 = move-exception
            java.lang.String r5 = "installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23"
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L13
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L13
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> L13
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L13
            r2[r1] = r6     // Catch: java.lang.Throwable -> L13
            r2[r0] = r4     // Catch: java.lang.Throwable -> L13
            java.lang.String.format(r5, r2)     // Catch: java.lang.Throwable -> L13
            java.lang.String r8 = com.kwad.sdk.api.loader.z.b.e(r8)     // Catch: java.lang.Throwable -> L13
            goto L86
        L38:
            r5 = 24
            if (r4 != r5) goto L5d
            java.lang.String r8 = com.kwad.sdk.api.loader.z.c.f(r8)     // Catch: java.lang.Throwable -> L41
            goto L86
        L41:
            r4 = move-exception
            java.lang.String r5 = "installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14"
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L13
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L13
            java.lang.String r7 = r4.getMessage()     // Catch: java.lang.Throwable -> L13
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L13
            r2[r1] = r6     // Catch: java.lang.Throwable -> L13
            r2[r0] = r7     // Catch: java.lang.Throwable -> L13
            java.lang.String.format(r5, r2)     // Catch: java.lang.Throwable -> L13
            java.lang.String r8 = com.kwad.sdk.api.loader.z.a.d(r8)     // Catch: java.lang.Throwable -> L5c
            goto L86
        L5c:
            throw r4     // Catch: java.lang.Throwable -> L13
        L5d:
            r5 = 23
            if (r4 < r5) goto L82
            java.lang.String r8 = com.kwad.sdk.api.loader.z.b.e(r8)     // Catch: java.lang.Throwable -> L66
            goto L86
        L66:
            r4 = move-exception
            java.lang.String r5 = "installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14"
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L13
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Throwable -> L13
            java.lang.String r7 = r4.getMessage()     // Catch: java.lang.Throwable -> L13
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L13
            r2[r1] = r6     // Catch: java.lang.Throwable -> L13
            r2[r0] = r7     // Catch: java.lang.Throwable -> L13
            java.lang.String.format(r5, r2)     // Catch: java.lang.Throwable -> L13
            java.lang.String r8 = com.kwad.sdk.api.loader.z.a.d(r8)     // Catch: java.lang.Throwable -> L81
            goto L86
        L81:
            throw r4     // Catch: java.lang.Throwable -> L13
        L82:
            java.lang.String r8 = com.kwad.sdk.api.loader.z.a.d(r8)     // Catch: java.lang.Throwable -> L13
        L86:
            monitor-exit(r3)
            return r8
        L88:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L13
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.api.loader.z.b(java.lang.ClassLoader):java.lang.String");
    }

    public static Field c(Object obj, String str) {
        for (Class<?> cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String u(List<File> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).getAbsolutePath());
            if (i < list.size() - 1) {
                sb.append(File.pathSeparator);
            }
        }
        return sb.toString();
    }
}
