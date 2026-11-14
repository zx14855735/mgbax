package com.bytedance.sdk.openadsdk.core.l;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.utils.pl;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f {
    private final com.bytedance.sdk.openadsdk.core.l.hf hf;
    private final Context xj;
    private boolean w = false;
    private int u = 0;

    public static class hf {
        private static volatile hf kd;
        private final Runnable c = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.l.f.hf.2
            @Override // java.lang.Runnable
            public void run() {
                hf.this.xj();
            }
        };
        private Network hf;
        private boolean u;
        private ConnectivityManager.NetworkCallback w;
        private ConnectivityManager xj;
        private Handler y;

        private hf(Context context) {
            try {
                this.xj = (ConnectivityManager) context.getSystemService("connectivity");
                this.y = new Handler(Looper.getMainLooper());
            } catch (Exception e) {
                pl.xj(e);
            }
        }

        public static hf xj(Context context) {
            if (kd == null) {
                synchronized (hf.class) {
                    try {
                        if (kd == null) {
                            kd = new hf(context);
                        }
                    } finally {
                    }
                }
            }
            return kd;
        }

        @TargetApi(21)
        public void xj(final ConnectivityManager.NetworkCallback networkCallback) {
            NetworkInfo networkInfo;
            this.y.removeCallbacks(this.c);
            ConnectivityManager connectivityManager = this.xj;
            if (connectivityManager == null) {
                pl.xj("transmit_business", "forceNet mConnectivityManager is null");
                return;
            }
            Network network = this.hf;
            if (network != null && !this.u && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
                pl.xj("transmit_business", "forceNet reuse network");
                networkCallback.onAvailable(this.hf);
                return;
            }
            ConnectivityManager.NetworkCallback networkCallback2 = this.w;
            if (networkCallback2 != null) {
                try {
                    this.xj.unregisterNetworkCallback(networkCallback2);
                } catch (Exception e) {
                    pl.xj(e);
                    this.w = null;
                }
                pl.xj("transmit_business", "forceNet clear");
            }
            NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
            ConnectivityManager.NetworkCallback networkCallback3 = new ConnectivityManager.NetworkCallback() { // from class: com.bytedance.sdk.openadsdk.core.l.f.hf.1
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network2) {
                    try {
                        if (hf.this.xj.getNetworkCapabilities(network2).hasTransport(0)) {
                            hf.this.hf = network2;
                            networkCallback.onAvailable(network2);
                            hf.this.u = false;
                        } else {
                            pl.xj("transmit_business", "forceNet check fail...");
                            hf.this.hf = null;
                            networkCallback.onAvailable(null);
                            hf.this.u = true;
                        }
                    } catch (Exception e2) {
                        pl.xj(e2);
                        networkCallback.onAvailable(null);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network2) {
                    hf.this.u = true;
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onUnavailable() {
                    super.onUnavailable();
                    if (Build.VERSION.SDK_INT >= 26) {
                        networkCallback.onUnavailable();
                    }
                }
            };
            this.w = networkCallback3;
            if (Build.VERSION.SDK_INT >= 26) {
                this.xj.requestNetwork(build, networkCallback3, 5000);
            } else {
                this.xj.requestNetwork(build, networkCallback3);
            }
        }

        public void xj(long j) {
            this.y.postDelayed(this.c, j);
        }

        public void xj() {
            if (this.xj == null) {
                return;
            }
            try {
                if (this.w == null) {
                    return;
                }
                pl.xj("transmit_business", "unregisterNetwork");
                this.xj.unregisterNetworkCallback(this.w);
                this.w = null;
                this.hf = null;
            } catch (Exception e) {
                pl.xj(e);
            }
        }
    }

    public static final class xj {
        public static String xj(int i) {
            switch (i) {
                case 200:
                    return "200_但取号失败";
                case 102101:
                    return "无网络状态";
                case 102102:
                    return "网络异常";
                case 102103:
                    return "预取号只开WiFi";
                case 102203:
                    return "输入参数错误";
                case 102204:
                    return "崩溃错误";
                case 102508:
                    return "数据网络切换失败";
                case 200010:
                    return "imsi获取失败或者没有sim卡，预取号失败";
                case 200050:
                    return "EOF异常";
                default:
                    return "wifi取号失败....";
            }
        }
    }

    public f(Context context, com.bytedance.sdk.openadsdk.core.l.hf hfVar) {
        this.xj = context;
        this.hf = hfVar;
    }

    public void xj(String str, u uVar) {
        if (uVar == null) {
            return;
        }
        boolean xj2 = y.xj(this.xj);
        this.u = y.xj(this.xj, xj2);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("headers");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("params");
            Map<String, List<String>> xj3 = xj(optJSONObject);
            String upperCase = jSONObject.optString("method").toUpperCase();
            String optString = jSONObject.optString("url");
            this.hf.xj("method", upperCase);
            this.hf.xj("url", optString);
            try {
                if (xj(xj2, this.hf, uVar)) {
                    if (this.w) {
                        xj(xj3, optJSONObject2, uVar);
                    } else {
                        xj(null, xj3, optJSONObject2, uVar);
                    }
                }
            } catch (Throwable th) {
                pl.xj(th);
                uVar.xj(false, this.u, 102204, xj.xj(102204), null, null);
            }
        } catch (JSONException e) {
            pl.xj(e);
            uVar.xj(false, this.u, 102203, xj.xj(102203), null, null);
        }
    }

    private Map<String, List<String>> xj(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                List list = (List) hashMap.get(next);
                if (list == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(optString);
                    hashMap.put(next, arrayList);
                } else {
                    list.add(optString);
                }
            }
        } catch (Exception e) {
            pl.xj(e);
        }
        return hashMap;
    }

    private boolean xj(boolean z, com.bytedance.sdk.openadsdk.core.l.hf hfVar, u uVar) {
        hfVar.xj("networktype", this.u);
        pl.xj("transmit_business", "preCheck networkType:" + this.u);
        String packageName = this.xj.getPackageName();
        String xj2 = w.xj(kd.xj(this.xj, packageName));
        hfVar.xj("apppackage", packageName);
        hfVar.xj("appsign", xj2);
        int i = this.u;
        if (i == 3) {
            this.w = true;
        }
        if (!z) {
            uVar.xj(false, i, 200010, xj.xj(200010), null, null);
            return false;
        }
        if (i == 0) {
            uVar.xj(false, i, 102101, xj.xj(102101), null, null);
            return false;
        }
        if (i != 2) {
            return true;
        }
        uVar.xj(false, i, 102103, xj.xj(102103), null, null);
        return false;
    }

    @TargetApi(21)
    private void xj(final Map<String, List<String>> map, final JSONObject jSONObject, final u uVar) {
        pl.xj("transmit_business", "wifiSwitchAndDoRequest");
        final hf xj2 = hf.xj(this.xj);
        hf.xj(this.xj).xj(new ConnectivityManager.NetworkCallback() { // from class: com.bytedance.sdk.openadsdk.core.l.f.1
            private final AtomicBoolean y = new AtomicBoolean(false);

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                pl.xj("transmit_business", "wifiSwitchAndDoRequest onAvailable:".concat(String.valueOf(network)));
                if (this.y.getAndSet(true) || network == null) {
                    return;
                }
                f.this.xj(network, map, jSONObject, uVar);
                xj2.xj(1000L);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onUnavailable() {
                pl.xj("transmit_business", "wifiSwitchAndDoRequest onUnavailable");
                uVar.xj(false, f.this.u, 102508, xj.xj(102508), null, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Network network, Map<String, List<String>> map, JSONObject jSONObject, u uVar) {
        String xj2 = this.hf.xj("url");
        String xj3 = this.hf.xj("method");
        d dVar = new d(xj2, xj3, map, jSONObject);
        dVar.xj(this.hf.xj("apppackage"));
        dVar.hf(this.hf.xj("appsign"));
        if ("get".equalsIgnoreCase(xj3)) {
            dVar.xj("Content-Type", "application/x-www-form-urlencoded");
        }
        try {
            com.bytedance.sdk.openadsdk.core.l.xj.xj.xj(dVar, this.hf.hf("networktype"), this.hf.xj("apppackage"));
            xj(network, dVar, uVar);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0211  */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.lang.CharSequence, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.lang.CharSequence, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r18v0, types: [com.bytedance.sdk.openadsdk.core.l.f] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v23, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.io.Closeable] */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void xj(android.net.Network r19, com.bytedance.sdk.openadsdk.core.l.d r20, com.bytedance.sdk.openadsdk.core.l.u r21) {
        /*
            Method dump skipped, instructions count: 583
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.l.f.xj(android.net.Network, com.bytedance.sdk.openadsdk.core.l.d, com.bytedance.sdk.openadsdk.core.l.u):void");
    }

    private void xj(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                pl.xj(e);
            }
        }
    }
}
