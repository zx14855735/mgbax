package com.kwad.sdk.core;

import BPw6Q8.ASJ6gh;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.kuaishou.weapon.p0.g;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class NetworkMonitor {
    private static volatile boolean aBb;
    private final List<a> aBc;
    private final WeakHashMap<a, AdTemplate> aBd;
    private final Map<a, AdTemplate> aBe;
    private boolean aBf;
    private final BroadcastReceiver aBg;

    public enum Holder {
        INSTANCE;

        private final NetworkMonitor mInstance = new NetworkMonitor(0);

        static {
            BbyLGy();
        }

        Holder() {
        }

        private static /* synthetic */ void BbyLGy() {
            char[] charArray = "Q]_\u001cUS_W\u001cP]K\u001cAZW^^\u001cx\\[p@[VUW".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '2');
            }
            String str = new String(charArray);
            char[] charArray2 = "Q^[\\[F".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '2');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public final NetworkMonitor getInstance() {
            return this.mInstance;
        }
    }

    public enum NetworkState {
        NETWORK_NONE,
        NETWORK_MOBILE,
        NETWORK_WIFI;

        static {
            jWXl();
        }

        private static /* synthetic */ void jWXl() {
            char[] charArray = "¾²°óº¼°¸ó¿²¤ó®µ¸±±ó\u0097³´\u009f¯´¹º¸".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 221);
            }
            String str = new String(charArray);
            char[] charArray2 = "¾±´³´©".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 221);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public interface a {
        void a(NetworkState networkState);
    }

    public /* synthetic */ NetworkMonitor(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NetworkState networkState) {
        Iterator<a> it = this.aBc.iterator();
        while (it.hasNext()) {
            it.next().a(networkState);
        }
    }

    private synchronized void by(Context context) {
        if (aBb || context == null) {
            return;
        }
        try {
            context.getApplicationContext().registerReceiver(this.aBg, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            aBb = true;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    public static NetworkMonitor getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    private NetworkMonitor() {
        this.aBc = new CopyOnWriteArrayList();
        WeakHashMap<a, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.aBd = weakHashMap;
        this.aBe = Collections.synchronizedMap(weakHashMap);
        this.aBf = false;
        this.aBg = new BroadcastReceiver() { // from class: com.kwad.sdk.core.NetworkMonitor.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                ConnectivityManager connectivityManager;
                try {
                    if (ASJ6gh.A2egSU(context, g.b) == 0 && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
                        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                            NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                            return;
                        }
                        if (1 == activeNetworkInfo.getType()) {
                            NetworkMonitor.this.b(NetworkState.NETWORK_WIFI);
                        } else if (activeNetworkInfo.getType() == 0) {
                            NetworkMonitor.this.b(NetworkState.NETWORK_MOBILE);
                        } else {
                            NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
    }

    public final void a(Context context, a aVar) {
        by(context);
        if (this.aBc.contains(aVar)) {
            return;
        }
        this.aBc.add(aVar);
    }

    public final void a(Context context, a aVar, AdTemplate adTemplate) {
        by(context);
        this.aBe.put(aVar, adTemplate);
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        this.aBc.remove(aVar);
    }
}
