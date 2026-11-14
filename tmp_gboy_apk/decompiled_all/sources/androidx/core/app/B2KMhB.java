package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B2KMhB extends BI9f7h {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final Context f8486ADYaiT;
    public final PowerManager.WakeLock AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final PowerManager.WakeLock f8487ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f8488ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public boolean f8489AYUAbz;

    public B2KMhB(Context context, ComponentName componentName) {
        super(componentName);
        this.f8486ADYaiT = context.getApplicationContext();
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
        this.AMqCpz = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
        this.f8487ARc23Z = newWakeLock2;
        newWakeLock2.setReferenceCounted(false);
    }

    @Override // androidx.core.app.BI9f7h
    public final void A2egSU(Intent intent) {
        Intent intent2 = new Intent(intent);
        intent2.setComponent(this.f8499A2egSU);
        if (this.f8486ADYaiT.startService(intent2) != null) {
            synchronized (this) {
                try {
                    if (!this.f8488ASJ6gh) {
                        this.f8488ASJ6gh = true;
                        if (!this.f8489AYUAbz) {
                            this.AMqCpz.acquire(60000L);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // androidx.core.app.BI9f7h
    public final void A5SV6n() {
        synchronized (this) {
            try {
                if (this.f8489AYUAbz) {
                    if (this.f8488ASJ6gh) {
                        this.AMqCpz.acquire(60000L);
                    }
                    this.f8489AYUAbz = false;
                    this.f8487ARc23Z.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.core.app.BI9f7h
    public final void ADYaiT() {
        synchronized (this) {
            try {
                if (!this.f8489AYUAbz) {
                    this.f8489AYUAbz = true;
                    this.f8487ARc23Z.acquire(600000L);
                    this.AMqCpz.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.core.app.BI9f7h
    public final void AMqCpz() {
        synchronized (this) {
            this.f8488ASJ6gh = false;
        }
    }
}
