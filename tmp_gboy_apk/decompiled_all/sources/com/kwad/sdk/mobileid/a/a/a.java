package com.kwad.sdk.mobileid.a.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private ConnectivityManager.NetworkCallback aYl;
    private ConnectivityManager aYm;
    private volatile boolean aYn = false;

    /* renamed from: com.kwad.sdk.mobileid.a.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0383a {
        void Pn();
    }

    private static ConnectivityManager ct(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    public final void Pi() {
        synchronized (this) {
            ConnectivityManager.NetworkCallback networkCallback = this.aYl;
            if (networkCallback == null) {
                return;
            }
            try {
                ConnectivityManager connectivityManager = this.aYm;
                if (connectivityManager != null) {
                    connectivityManager.unregisterNetworkCallback(networkCallback);
                }
            } catch (Exception e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                this.aYm.bindProcessToNetwork(null);
            }
            this.aYl = null;
        }
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.aYn = true;
        return true;
    }

    @SuppressLint({"MissingPermission"})
    public final void a(Context context, final InterfaceC0383a interfaceC0383a) {
        synchronized (this) {
            try {
                this.aYm = ct(context);
                try {
                    if (Build.VERSION.SDK_INT >= 24) {
                        NetworkRequest build = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();
                        if (this.aYl == null) {
                            this.aYl = new ConnectivityManager.NetworkCallback() { // from class: com.kwad.sdk.mobileid.a.a.a.1
                                @Override // android.net.ConnectivityManager.NetworkCallback
                                public final void onAvailable(Network network) {
                                    a.this.aYm.bindProcessToNetwork(network);
                                    if (interfaceC0383a != null && !a.this.aYn) {
                                        interfaceC0383a.Pn();
                                    }
                                    a.a(a.this, true);
                                }

                                @Override // android.net.ConnectivityManager.NetworkCallback
                                public final void onLost(Network network) {
                                    a.this.aYm.bindProcessToNetwork(null);
                                    c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "onLost unbindNetwork");
                                    a.this.Pi();
                                }

                                @Override // android.net.ConnectivityManager.NetworkCallback
                                public final void onUnavailable() {
                                    a.this.aYm.bindProcessToNetwork(null);
                                    c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "onUnavailable unbindNetwork");
                                    a.this.Pi();
                                }
                            };
                        }
                        if (!this.aYn) {
                            this.aYm.requestNetwork(build, this.aYl);
                        } else {
                            c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "isRequestUaidToken is true unbindNetwork");
                            Pi();
                        }
                    }
                } catch (Exception e) {
                    ServiceProvider.reportSdkCaughtException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
