package com.octopus.ad.b.h;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.octopus.ad.b.h.c;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final a f12374a;

    public d(a aVar) {
        this.f12374a = aVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f12374a.f12369a = c.a.a(iBinder);
        synchronized (this.f12374a.d) {
            this.f12374a.d.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f12374a.f12369a = null;
    }
}
