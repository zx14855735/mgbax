package com.octopus.ad.b.h;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private String f12376a;
    private String b;
    private final a c;

    public interface a {
        String a(String str, String str2, String str3);
    }

    public g(a aVar) {
        this.c = aVar;
    }

    private void b(Context context) {
        if (TextUtils.isEmpty(this.b)) {
            try {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(this.f12376a, 64).signatures;
                if (signatureArr == null || signatureArr.length <= 0) {
                    return;
                }
                this.b = a(signatureArr[0].toByteArray());
            } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
            }
        }
    }

    public String a(Context context, String str) {
        a(context);
        b(context);
        a aVar = this.c;
        if (aVar == null) {
            return "";
        }
        String a2 = aVar.a(this.f12376a, this.b, str);
        return TextUtils.isEmpty(a2) ? "" : a2;
    }

    private void a(Context context) {
        if (TextUtils.isEmpty(this.f12376a)) {
            this.f12376a = context.getPackageName();
        }
    }

    private String a(byte[] bArr) {
        byte[] digest = MessageDigest.getInstance("SHA1").digest(bArr);
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", Integer.valueOf(b & 255)));
        }
        return sb.toString();
    }
}
