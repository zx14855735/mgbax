package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class b {
    public static void A2egSU(Context context, File file, File file2) {
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        String str;
        boolean z = true;
        AssetManager assets = context.getAssets();
        InputStream inputStream2 = null;
        try {
            String str2 = h.f12962A2egSU;
            String[] list = assets.list("gdt_plugin");
            if (Arrays.binarySearch(list, "gdtadv2.jar") < 0) {
                if (list != null && list.length > 0) {
                    str = TextUtils.join(",", list);
                    String str3 = "Asset Error " + str;
                    GDTLogger.e(str3);
                    throw new Exception(str3);
                }
                str = "no asset";
                String str32 = "Asset Error " + str;
                GDTLogger.e(str32);
                throw new Exception(str32);
            }
            String str4 = "gdt_plugin" + File.separator + "gdtadv2.jar";
            String str5 = Sig.ASSET_PLUGIN_SIG;
            if (str5 == null) {
                str5 = "";
            }
            h.A4TApA(context);
            h.A5SV6n(file2, SDKStatus.getBuildInPluginVersion() + "#####" + str5);
            if (TextUtils.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                z = h.a(assets.open(str4), file);
                fileOutputStream = null;
            } else {
                inputStream = assets.open(str4);
                try {
                    if (!file.canWrite()) {
                        file.setWritable(true);
                    }
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes(Charset.forName("UTF-8"));
                        byte[] bArr = new byte[1024];
                        int length = bytes.length;
                        int i = 0;
                        int i2 = 0;
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            int i3 = 0;
                            while (i3 < read) {
                                int i4 = i2 + 1;
                                if (i2 >= 64) {
                                    bArr[i3] = (byte) (bytes[i % length] ^ bArr[i3]);
                                    i++;
                                }
                                i3++;
                                i2 = i4;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        inputStream2 = inputStream;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            GDTLogger.e("插件加载失败", th);
                            throw th;
                        } finally {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    inputStream2 = inputStream;
                    inputStream = inputStream2;
                    GDTLogger.e("插件加载失败", th);
                    throw th;
                }
            }
            if (z) {
                try {
                    z = h.AMqCpz(context, file);
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = inputStream2;
                    GDTLogger.e("插件加载失败", th);
                    throw th;
                }
            }
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException unused) {
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused2) {
                }
            }
            if (!z) {
                throw new Exception("Plugin prepare failed");
            }
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }
}
