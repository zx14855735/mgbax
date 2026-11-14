package com.octopus.ad.b.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.octopus.ad.b.b.b;
import com.octopus.ad.b.b.c;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a implements com.octopus.ad.b.c {

    /* renamed from: a, reason: collision with root package name */
    private static String f12352a = "";

    /* renamed from: com.octopus.ad.b.b.a$a, reason: collision with other inner class name */
    public static final class BinderC0396a extends b.a {
        @Override // com.octopus.ad.b.b.b
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        private BinderC0396a() {
        }

        @Override // com.octopus.ad.b.b.b
        public void a(int i, Bundle bundle) {
            if (i != 0 || bundle == null) {
                return;
            }
            String string = bundle.getString("oa_id_flag");
            if (a.a(string)) {
                String unused = a.f12352a = string;
            }
        }
    }

    public static final class b implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        boolean f12353a;
        private final LinkedBlockingQueue<IBinder> b;

        public IBinder a() {
            if (this.f12353a) {
                throw new IllegalStateException();
            }
            this.f12353a = true;
            return this.b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private b() {
            this.f12353a = false;
            this.b = new LinkedBlockingQueue<>();
        }
    }

    @Override // com.octopus.ad.b.c
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!Boolean.parseBoolean(Settings.Secure.getString(context.getContentResolver(), "oaid_limit_state"))) {
                String string = Settings.Global.getString(context.getContentResolver(), "oaid");
                if (a(string)) {
                    f12352a = string;
                    return string;
                }
            }
        } catch (Throwable unused) {
        }
        b bVar = new b();
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        if (context.bindService(intent, bVar, 1)) {
            try {
                c.a.a(bVar.a()).a(new BinderC0396a());
                return f12352a;
            } catch (Exception unused2) {
            } finally {
                context.unbindService(bVar);
            }
        }
        return null;
    }

    public static boolean a(String str) {
        return (TextUtils.isEmpty(str) || str.equalsIgnoreCase("00000000-0000-0000-0000-000000000000")) ? false : true;
    }
}
