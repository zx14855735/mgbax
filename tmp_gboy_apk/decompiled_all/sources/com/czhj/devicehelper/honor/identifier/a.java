package com.czhj.devicehelper.honor.identifier;

import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class a {

    /* renamed from: com.czhj.devicehelper.honor.identifier.a$a, reason: collision with other inner class name */
    public static final class C0213a {

        /* renamed from: a, reason: collision with root package name */
        public String f10526a;
        public boolean b;
    }

    private a() {
    }

    public static C0213a a(Context context) {
        b bVar = new b();
        bVar.b = context;
        if (!bVar.a(context)) {
            return null;
        }
        C0213a c0213a = bVar.f10527a;
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "oaid");
            if (!TextUtils.isEmpty(string)) {
                c0213a.b = false;
                c0213a.f10526a = string;
                return c0213a;
            }
        } catch (Exception unused) {
        }
        try {
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            context.bindService(intent, bVar, 1);
            bVar.e.await(2000L, TimeUnit.MILLISECONDS);
            bVar.a();
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            bVar.a();
        }
        return c0213a;
    }

    public static boolean b(Context context) {
        return new b().a(context);
    }
}
