package com.bytedance.sdk.component.panglearmor;

import android.util.Base64;
import com.bytedance.sdk.component.utils.pl;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u {
    private static boolean xj;

    private static PublicKey xj() {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKtjHB7PDkflFl5bX4x/25mE9x2/C6kd\n8wVgzXFiC67Jx+meptu1hL54XgnPnI+AvxXhEgN/+DZUmrRPdvB+UZECAwEAAQ==".getBytes(Charset.forName("UTF-8")), 2)));
    }

    public static boolean xj(String str, String str2) {
        PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(xj().getEncoded()));
        Signature signature = Signature.getInstance("Sha1withRSA");
        signature.initVerify(generatePublic);
        signature.update(str.getBytes());
        return signature.verify(Base64.decode(str2.getBytes(Charset.forName("UTF-8")), 2));
    }

    public static boolean xj(final String str) {
        try {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.u.1
                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    try {
                        str2 = InetAddress.getByName(str).getHostAddress();
                    } catch (Exception unused) {
                        str2 = "";
                    }
                    if (str2.equals("127.0.0.1") || str2.equals("::1")) {
                        boolean unused2 = u.xj = true;
                    }
                }
            });
        } catch (UnsatisfiedLinkError e) {
            pl.xj(e);
        }
        return xj;
    }
}
