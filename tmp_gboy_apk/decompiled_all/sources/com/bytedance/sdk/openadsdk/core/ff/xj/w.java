package com.bytedance.sdk.openadsdk.core.ff.xj;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import com.bytedance.sdk.component.utils.pl;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class w {
    private static volatile w xj;
    private ConnectivityManager hf;
    private boolean kd;
    private hf u;
    private Network w;

    public static class hf extends ConnectivityManager.NetworkCallback {
        private final w hf;
        private AtomicBoolean w = new AtomicBoolean(false);
        private xj xj;

        public hf(xj xjVar, w wVar) {
            this.xj = xjVar;
            this.hf = wVar;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            if (this.w.compareAndSet(false, true)) {
                try {
                    this.hf.w = network;
                    this.xj.xj(network);
                    this.hf.kd = false;
                } catch (Exception unused) {
                    this.hf.w = null;
                    this.xj.xj(null);
                }
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            this.hf.kd = true;
        }

        public void xj(xj xjVar) {
            this.xj = xjVar;
        }
    }

    public interface xj {
        void xj(Network network);
    }

    private w(Context context) {
        try {
            this.hf = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            pl.xj(e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void hf() {
        ConnectivityManager connectivityManager = this.hf;
        if (connectivityManager == null) {
            return;
        }
        try {
            try {
                hf hfVar = this.u;
                if (hfVar == null) {
                    return;
                }
                connectivityManager.unregisterNetworkCallback(hfVar);
            } catch (Exception unused) {
            }
        } finally {
            this.u = null;
            this.w = null;
        }
    }

    public static w xj(Context context) {
        if (xj == null) {
            synchronized (w.class) {
                try {
                    if (xj == null) {
                        xj = new w(context);
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    private static boolean xj(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public int xj() {
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = this.hf;
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (Build.VERSION.SDK_INT >= 23) {
                    activeNetwork = this.hf.getActiveNetwork();
                    if (activeNetwork == null || (networkCapabilities = this.hf.getNetworkCapabilities(activeNetwork)) == null) {
                        return 0;
                    }
                    boolean hasTransport = networkCapabilities.hasTransport(4);
                    boolean hasTransport2 = networkCapabilities.hasTransport(0);
                    boolean hasTransport3 = networkCapabilities.hasTransport(1);
                    if (hasTransport) {
                        return 4;
                    }
                    if (xj(this.hf) && hasTransport3) {
                        return 3;
                    }
                    if (!hasTransport3) {
                        if (hasTransport2) {
                            return 2;
                        }
                    }
                }
                int type = activeNetworkInfo.getType();
                return type == 1 ? xj(this.hf) ? 3 : 1 : type == 0 ? 2 : 5;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public void xj(xj xjVar) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = this.hf;
        if (connectivityManager == null) {
            xjVar.xj(null);
            return;
        }
        Network network = this.w;
        if (network != null && !this.kd && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
            xjVar.xj(this.w);
            return;
        }
        hf hfVar = this.u;
        if (hfVar != null) {
            hfVar.xj(xjVar);
            return;
        }
        NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        hf hfVar2 = new hf(xjVar, xj);
        this.u = hfVar2;
        try {
            this.hf.requestNetwork(build, hfVar2);
        } catch (Exception unused) {
            xjVar.xj(null);
        }
    }
}
