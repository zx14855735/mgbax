package com.bytedance.sdk.component.panglearmor.xj.xj.hf.xj.xj;

import com.bytedance.sdk.component.panglearmor.xj.hf.hf;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static com.bytedance.sdk.component.panglearmor.xj.hf.xj hf(ByteBuffer byteBuffer) {
        ByteBuffer xj = com.bytedance.sdk.component.panglearmor.xj.xj.hf.xj.xj.xj(byteBuffer);
        xj.get(new byte[xj.remaining()]);
        xj.flip();
        xj.position(0);
        com.bytedance.sdk.component.panglearmor.xj.xj.hf.xj.xj.xj(xj);
        byte[] hf = com.bytedance.sdk.component.panglearmor.xj.xj.hf.xj.xj.hf(com.bytedance.sdk.component.panglearmor.xj.xj.hf.xj.xj.xj(xj));
        try {
            return new com.bytedance.sdk.component.panglearmor.xj.hf.xj(String.valueOf(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(hf))).getSubjectDN()), hf);
        } catch (Exception unused) {
            return null;
        }
    }

    public static List<com.bytedance.sdk.component.panglearmor.xj.hf.xj> xj(hf hfVar, com.bytedance.sdk.component.panglearmor.xj.xj.w.hf hfVar2) {
        return xj(com.bytedance.sdk.component.panglearmor.xj.xj.hf.xj.xj.xj(hfVar, hfVar2, 1896449818).xj);
    }

    public static List<com.bytedance.sdk.component.panglearmor.xj.hf.xj> xj(ByteBuffer byteBuffer) {
        try {
            ByteBuffer xj = com.bytedance.sdk.component.panglearmor.xj.xj.hf.xj.xj.xj(byteBuffer);
            if (!xj.hasRemaining()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (xj.hasRemaining()) {
                try {
                    arrayList.add(hf(com.bytedance.sdk.component.panglearmor.xj.xj.hf.xj.xj.xj(xj)));
                } catch (Exception unused) {
                    return null;
                }
            }
            return arrayList;
        } catch (Exception unused2) {
            return null;
        }
    }
}
