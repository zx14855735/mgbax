package com.octopus.ad.internal.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.kuaishou.weapon.p0.g;
import com.octopus.ad.internal.utilities.HTTPGet;
import com.octopus.ad.internal.utilities.HTTPResponse;
import com.octopus.ad.internal.utilities.HttpErrorCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static c f12506a;
    private ArrayList<a> b = new ArrayList<>();
    private Timer c;
    private boolean d;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        String f12509a;
        int b = 0;

        public a(String str) {
            this.f12509a = str;
        }
    }

    private c(Context context) {
        if (context != null) {
            this.d = context.getPackageManager().checkPermission(g.b, context.getPackageName()) == 0;
        }
    }

    private void c(Context context) {
        if (this.c == null) {
            final WeakReference weakReference = new WeakReference(context);
            Timer timer = new Timer();
            this.c = timer;
            timer.scheduleAtFixedRate(new TimerTask() { // from class: com.octopus.ad.internal.network.c.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    Context context2 = (Context) weakReference.get();
                    if (context2 == null) {
                        c.this.a();
                        return;
                    }
                    while (!c.this.b.isEmpty() && c.this.b(context2)) {
                        boolean z = false;
                        final a aVar = (a) c.this.b.remove(0);
                        if (aVar.b < 3) {
                            new HTTPGet(z) { // from class: com.octopus.ad.internal.network.c.1.1
                                @Override // com.octopus.ad.internal.utilities.HTTPGet
                                public String getUrl() {
                                    return aVar.f12509a;
                                }

                                @Override // com.octopus.ad.internal.utilities.HTTPGet
                                public void onPostExecute(HTTPResponse hTTPResponse) {
                                    if (hTTPResponse == null || (!hTTPResponse.getSucceeded() && hTTPResponse.getErrorCode() == HttpErrorCode.CONNECTION_FAILURE)) {
                                        aVar.b++;
                                        c.this.b.add(aVar);
                                    }
                                }
                            }.execute();
                        }
                    }
                    if (c.this.b.isEmpty()) {
                        c.this.a();
                    }
                }
            }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
    }

    public static c a(Context context) {
        if (f12506a == null) {
            f12506a = new c(context);
        }
        return f12506a;
    }

    public boolean b(Context context) {
        if (!this.d) {
            return true;
        }
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

    public synchronized void a(String str, Context context) {
        this.b.add(new a(str));
        c(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Timer timer = this.c;
        if (timer != null) {
            timer.cancel();
            this.c = null;
        }
    }
}
