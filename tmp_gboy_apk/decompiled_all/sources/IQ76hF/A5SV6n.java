package IQ76hF;

import ADYaiT.CTkVKb;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n implements A4TApA {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Context f3935AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final I3HV03.A4TApA f3936AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f3937AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f3938AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final CTkVKb f3939B25kr6 = new CTkVKb(2, this);

    public A5SV6n(Context context, I3HV03.A4TApA a4TApA) {
        this.f3935AcNBzu = context.getApplicationContext();
        this.f3936AlLFFp = a4TApA;
    }

    public static boolean A2egSU(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        ItGa5w.ARc23Z.A5SV6n(connectivityManager, "Argument must not be null");
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException unused) {
            Log.isLoggable("ConnectivityMonitor", 5);
            return true;
        }
    }

    @Override // IQ76hF.AYUAbz
    public final void onDestroy() {
    }

    @Override // IQ76hF.AYUAbz
    public final void onStart() {
        if (this.f3938AzWtSf) {
            return;
        }
        Context context = this.f3935AcNBzu;
        this.f3937AmA8tU = A2egSU(context);
        try {
            context.registerReceiver(this.f3939B25kr6, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f3938AzWtSf = true;
        } catch (SecurityException unused) {
            Log.isLoggable("ConnectivityMonitor", 5);
        }
    }

    @Override // IQ76hF.AYUAbz
    public final void onStop() {
        if (this.f3938AzWtSf) {
            this.f3935AcNBzu.unregisterReceiver(this.f3939B25kr6);
            this.f3938AzWtSf = false;
        }
    }
}
