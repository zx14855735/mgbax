package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.liteapi.encrypt.LiteEncryptUtils;
import com.kwad.sdk.service.ServiceProvider;
import java.io.InputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class v {
    private static String sAESKey = "";
    private static String sRSEPrivateKey = "";
    private static String sRSEPublicKey = "";

    public static String fg(int i) {
        InputStream inputStream;
        Context Re = ServiceProvider.Re();
        String str = sAESKey;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        TextUtils.isEmpty(LiteEncryptUtils.KEY_AES);
        try {
            try {
                inputStream = Re.getResources().getAssets().open("ksad_common_encrypt_image.png");
            } catch (Throwable th) {
                th.toString();
                inputStream = null;
            }
            if (inputStream == null) {
                inputStream = Re.getAssets().open("ksad_common_encrypt_image.png");
            }
            String readKey = readKey(LiteEncryptUtils.KEY_AES, inputStream);
            TextUtils.isEmpty(readKey);
            sAESKey = readKey;
            return readKey;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String readKey(String str, InputStream inputStream) {
        String gT;
        synchronized (v.class) {
            com.kwad.sdk.pngencrypt.o oVar = new com.kwad.sdk.pngencrypt.o(inputStream, true);
            oVar.Qm();
            gT = oVar.Ql().gT(str);
            oVar.end();
        }
        return gT;
    }
}
