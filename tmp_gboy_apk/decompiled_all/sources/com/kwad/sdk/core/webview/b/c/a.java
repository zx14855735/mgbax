package com.kwad.sdk.core.webview.b.c;

import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import J3FDQU.A2egSU;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    public static String J(Context context, String str) {
        String cg = cg(context);
        if (TextUtils.isEmpty(cg)) {
            return null;
        }
        return CtFAbx.B25kr6(AYUAbz.A4TApA(cg), File.separator, str);
    }

    public static String K(Context context, String str) {
        String cg = cg(context);
        if (TextUtils.isEmpty(cg)) {
            return null;
        }
        return A2egSU.B3GDIM(AYUAbz.A4TApA(cg), File.separator, str, ".zip");
    }

    public static String L(Context context, String str) {
        String cg = cg(context);
        if (TextUtils.isEmpty(cg)) {
            return null;
        }
        return CtFAbx.B25kr6(AYUAbz.A4TApA(cg), File.separator, str);
    }

    public static String M(Context context, String str) {
        String cg = cg(context);
        if (TextUtils.isEmpty(cg)) {
            return null;
        }
        StringBuilder A4TApA2 = AYUAbz.A4TApA(cg);
        String str2 = File.separator;
        return com.bykv.vk.component.ttvideo.player.A2egSU.AzWtSf(A4TApA2, str2, str, str2, "_manifest_.json");
    }

    private static File cf(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            return filesDir;
        }
        return new File("/data/data/" + context.getPackageName() + "/file/");
    }

    private static String cg(Context context) {
        File cf = cf(context);
        StringBuilder sb = new StringBuilder();
        sb.append(cf);
        String B25kr62 = CtFAbx.B25kr6(sb, File.separator, "offlinepackage");
        File file = new File(B25kr62);
        if (!file.exists()) {
            file.mkdirs();
        }
        return B25kr62;
    }

    public static File ch(Context context) {
        String cg = cg(context);
        if (TextUtils.isEmpty(cg)) {
            return null;
        }
        fs(cg);
        File file = new File(cg, "packageIndex.json");
        if (!file.exists()) {
            file.createNewFile();
        }
        return file;
    }

    public static void f(Context context, String str, String str2) {
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String name = nextEntry.getName();
            String cg = cg(context);
            if (!new File(cg, name).getAbsolutePath().startsWith(cg)) {
                break;
            }
            if (!nextEntry.isDirectory()) {
                File file = new File(CtFAbx.B25kr6(AYUAbz.A4TApA(str2), File.separator, name));
                if (!file.exists()) {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = zipInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                    fileOutputStream.flush();
                }
                com.kwad.sdk.crash.utils.b.closeQuietly(fileOutputStream);
            } else if (!name.contains("../")) {
                new File(CtFAbx.B25kr6(AYUAbz.A4TApA(str2), File.separator, CtFAbx.AMqCpz(1, 0, name))).mkdirs();
            }
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
    }

    public static String fq(String str) {
        try {
            return Uri.parse(str).getQueryParameter("sceneId");
        } catch (Throwable unused) {
            com.kwad.sdk.core.d.c.e("HybridFileUtils", "getSceneId This isn't a hierarchical URI url is " + str);
            return "";
        }
    }

    public static String fr(String str) {
        try {
            List<String> pathSegments = Uri.parse(str).getPathSegments();
            String str2 = (pathSegments == null || pathSegments.size() <= 0) ? null : pathSegments.get(pathSegments.size() - 1);
            return (TextUtils.isEmpty(str2) || !str2.contains(".zip")) ? "" : str2.substring(0, str2.indexOf(".zip"));
        } catch (Throwable unused) {
            com.kwad.sdk.core.d.c.e("HybridFileUtils", "getZipName This isn't a hierarchical URI url is " + str);
            return "";
        }
    }

    private static boolean fs(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }
}
