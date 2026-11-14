package com.bytedance.pangle.f;

import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    public static boolean xj(String str, String str2, StringBuilder sb) {
        if (TextUtils.isEmpty(str)) {
            sb.append("apkPath null");
            return false;
        }
        try {
            qt xj = com.bytedance.pangle.util.d.xj() ? u.xj(str, 1) : xj.xj(str, true);
            Signature[] signatureArr = xj != null ? xj.hf : null;
            String str3 = Zeus.getPlugin(str2).mSignature;
            byte[] decode = Base64.decode(str3, 0);
            if (decode == null || decode.length == 0) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify get hostSignature error : ".concat(String.valueOf(str)));
                sb.append("hostSignature null ");
                if (TextUtils.isEmpty(str3)) {
                    sb.append("origin sign is null");
                }
                return false;
            }
            int i = 0;
            for (Signature signature : signatureArr) {
                i += signature.toByteArray().length;
            }
            byte[] bArr = new byte[i];
            int i2 = 0;
            for (Signature signature2 : signatureArr) {
                System.arraycopy(signature2.toByteArray(), 0, bArr, i2, signature2.toByteArray().length);
                i2 += signature2.toByteArray().length;
            }
            boolean xj2 = qt.xj(bArr, decode);
            if (!xj2) {
                sb.append("signature error");
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)));
            }
            return xj2;
        } catch (e e) {
            sb.append("verify e");
            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "ApkSignatureVerify verify plugin signature error : ".concat(String.valueOf(str)), e);
            return false;
        }
    }
}
