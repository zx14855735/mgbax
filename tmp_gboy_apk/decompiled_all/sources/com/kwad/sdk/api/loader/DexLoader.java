package com.kwad.sdk.api.loader;

import A5SV6n.A2egSU;
import ADYaiT.CtFAbx;
import B4ZgIw.AYUAbz;
import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Objects;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DexLoader {
    private static final String DEX_ROOT_DIR_NAME = "ksad_dex";
    private static final String TAG = "DexLoader";
    private static final String TARGET_DEX_NAME = "dexJar.jar";
    private static final String dexJarCheckFileName = "ksaddex_makejar.check";
    private static final String dexJarFileName = "ksad_data.jar";
    private static String sDexPathRoot;

    private static boolean checkLocal(Context context, String str, int i) {
        if (i != 4092001) {
            return false;
        }
        File file = new File(getTargetDexFilePath(context));
        return file.exists() && Objects.equals(y.getFileMD5(file), str);
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable, java.io.InputStream] */
    private static File copyAssetsToData(Context context, String str, DexLoadError dexLoadError) {
        Closeable closeable;
        Closeable closeable2;
        FileOutputStream fileOutputStream;
        File file;
        Closeable closeable3 = null;
        try {
            try {
                AssetManager assets = context.getAssets();
                File file2 = new File(getDexRootPath(context));
                if (!file2.exists()) {
                    file2.mkdir();
                }
                file = new File(getTargetDexFilePath(context));
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                str = assets.open(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
            closeable2 = null;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            closeable = null;
            closeQuietly(closeable3);
            closeQuietly(closeable);
            throw th;
        }
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                int a2 = p.a(getTargetDexFilePath(context), (InputStream) str, p.bk(context));
                if (a2 != 1 && dexLoadError != null) {
                    dexLoadError.setErrorCode(a2);
                }
                fileOutputStream.flush();
                file.setReadable(true);
                file.setWritable(false);
                closeQuietly(str);
                closeQuietly(fileOutputStream);
                return file;
            } catch (IOException e2) {
                e = e2;
                closeable2 = str;
                e.printStackTrace();
                if (dexLoadError != null) {
                    dexLoadError.setErrorCode(-3);
                    dexLoadError.setErrorMsg(e.getMessage());
                }
                closeQuietly(closeable2);
                closeQuietly(fileOutputStream);
                return null;
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
            closeable2 = str;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            closeable3 = str;
            closeQuietly(closeable3);
            closeQuietly(closeable);
            throw th;
        }
    }

    private static void copyFile(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    private static ClassLoader createDexClassLoader(Context context, ClassLoader classLoader, String str, DexLoadError dexLoadError) {
        try {
            String b = z.b(classLoader);
            Objects.toString(classLoader);
            ClassLoader a2 = g.a(context, classLoader, str, context.getCacheDir().getAbsolutePath(), b);
            Objects.toString(a2.loadClass("com.kwad.sdk.KsAdSDKImpl"));
            return a2;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            if (dexLoadError == null) {
                return null;
            }
            dexLoadError.setErrorMsg(e.getMessage());
            dexLoadError.setErrorCode(-1);
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            if (dexLoadError == null) {
                return null;
            }
            dexLoadError.setErrorMsg(th.getMessage());
            dexLoadError.setErrorCode(-2);
            return null;
        }
    }

    private static String getDexRootPath(Context context) {
        String str = sDexPathRoot;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(context.getApplicationInfo().dataDir);
        return CtFAbx.B25kr6(sb, File.separator, DEX_ROOT_DIR_NAME);
    }

    public static String getTargetDexFilePath(Context context) {
        return CtFAbx.B25kr6(AYUAbz.A4TApA(getDexRootPath(context)), File.separator, TARGET_DEX_NAME);
    }

    public static ClassLoader initDex(Context context, ClassLoader classLoader) {
        q Fb = r.Fb();
        if (Fb != null) {
            Fb.onInit(context);
        }
        Objects.toString(Fb);
        DexLoadError dexLoadError = new DexLoadError();
        String prepareDexFile = prepareDexFile(context, dexLoadError);
        dexLoadError.toString();
        if (!dexLoadError.success()) {
            if (Fb != null) {
                Fb.reportDexLoadError(context, dexLoadError);
            }
            return null;
        }
        ClassLoader createDexClassLoader = createDexClassLoader(context, classLoader, prepareDexFile, dexLoadError);
        dexLoadError.toString();
        if (dexLoadError.success()) {
            return createDexClassLoader;
        }
        if (Fb != null) {
            Fb.reportDexLoadError(context, dexLoadError);
        }
        return null;
    }

    private static boolean isTargetDexFileExist(Context context) {
        return false;
    }

    private static String obtainCheckMd5(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("\n");
        if (split.length == 0) {
            return null;
        }
        return split[0];
    }

    private static int obtainVersionCode(String str) {
        if (str == null) {
            return -1;
        }
        String[] split = str.split("\n");
        if (split.length == 0) {
            return -1;
        }
        int length = split.length;
        for (int i = 0; i < length; i++) {
            String str2 = split[i];
            if (str2.startsWith("versionCode:")) {
                try {
                    return Integer.parseInt(str2.replace("versionCode:", "").trim());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;
    }

    private static String prepareDexFile(Context context, DexLoadError dexLoadError) {
        String targetDexFilePath = getTargetDexFilePath(context);
        String readCheckFile = readCheckFile(context);
        String obtainCheckMd5 = obtainCheckMd5(readCheckFile);
        if (checkLocal(context, obtainCheckMd5, obtainVersionCode(readCheckFile))) {
            return targetDexFilePath;
        }
        File copyAssetsToData = copyAssetsToData(context, dexJarFileName, dexLoadError);
        if (copyAssetsToData == null || !copyAssetsToData.exists()) {
            return targetDexFilePath;
        }
        String fileMD5 = y.getFileMD5(copyAssetsToData);
        if (Objects.equals(fileMD5, obtainCheckMd5)) {
            return copyAssetsToData.getAbsolutePath();
        }
        dexLoadError.setErrorCode(-4);
        dexLoadError.setErrorMsg("targetMd5:" + fileMD5 + ", assetJarFileMd5:" + obtainCheckMd5);
        return targetDexFilePath;
    }

    private static String readCheckFile(Context context) {
        Closeable closeable;
        Throwable th;
        InputStream inputStream;
        InputStream inputStream2;
        BufferedReader bufferedReader;
        InputStream open;
        AssetManager assets = context.getAssets();
        try {
            try {
                open = assets.open(dexJarCheckFileName);
            } catch (Throwable th2) {
                th = th2;
                inputStream = assets;
            }
        } catch (IOException e) {
            e = e;
            inputStream2 = null;
            bufferedReader = null;
        } catch (Throwable th3) {
            closeable = null;
            th = th3;
            inputStream = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(open, "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        String trim = sb.toString().trim();
                        closeQuietly(open);
                        closeQuietly(bufferedReader);
                        return trim;
                    }
                    sb.append(readLine);
                    sb.append("\n");
                } catch (IOException e2) {
                    e = e2;
                    inputStream2 = open;
                    e.printStackTrace();
                    closeQuietly(inputStream2);
                    closeQuietly(bufferedReader);
                    return null;
                }
            }
        } catch (IOException e3) {
            e = e3;
            bufferedReader = null;
            inputStream2 = open;
        } catch (Throwable th4) {
            closeable = null;
            th = th4;
            inputStream = open;
            closeQuietly(inputStream);
            closeQuietly(closeable);
            throw th;
        }
    }
}
