package com.bytedance.msdk.kd;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.core.s.t;
import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f {
    private static volatile f xj;
    private Key hf;
    private Cipher w;

    private f() {
        try {
            this.hf = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(com.bytedance.msdk.core.hf.hf().hl(), 0)));
            this.w = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    public static f xj() {
        if (xj == null) {
            synchronized (f.class) {
                try {
                    if (xj == null) {
                        xj = new f();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public String xj(byte[] bArr) {
        byte[] doFinal;
        if (bArr == null) {
            return null;
        }
        if (this.w == null) {
            this.hf = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(com.bytedance.msdk.core.hf.hf().hl(), 0)));
            this.w = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        }
        this.w.init(1, this.hf);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = length - i;
            if (i3 > 0) {
                if (i3 > 117) {
                    doFinal = this.w.doFinal(bArr, i, 117);
                } else {
                    doFinal = this.w.doFinal(bArr, i, i3);
                }
                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                i2++;
                i = i2 * 117;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return Base64.encodeToString(byteArray, 2);
            }
        }
    }

    public String xj(com.bytedance.msdk.hf.w wVar) {
        if (wVar == null || MediationConstant.ADN_PANGLE.equals(wVar.lw())) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(wVar.vw())) {
                jSONObject.putOpt(t.TAG, wVar.vw());
            }
            if (!TextUtils.isEmpty(wVar.uf())) {
                jSONObject.putOpt(com.kuaishou.weapon.p0.t.t, wVar.uf());
            }
            jSONObject.putOpt("e", String.valueOf(wVar.da()));
            if (!TextUtils.isEmpty(wVar.vl())) {
                jSONObject.putOpt("an", wVar.vl());
            }
            if (!TextUtils.isEmpty(wVar.h())) {
                jSONObject.putOpt("aun", wVar.h());
            }
        } catch (JSONException e) {
            pl.xj(e);
        }
        if (jSONObject.length() <= 0) {
            return null;
        }
        try {
            return xj(jSONObject.toString().getBytes());
        } catch (Exception e2) {
            pl.xj(e2);
            return null;
        }
    }
}
