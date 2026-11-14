package com.sigmob.sdk.videocache;

import com.czhj.sdk.logger.SigmobLog;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class n {

    /* renamed from: a, reason: collision with root package name */
    private static final String f13737a = "ping";
    private static final String b = "ping ok";
    private final ExecutorService c = Executors.newSingleThreadExecutor();
    private final String d;
    private final int e;

    public class a implements Callable<Boolean> {
        private a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            return Boolean.valueOf(n.this.b());
        }
    }

    public n(String str, int i) {
        this.d = (String) o.a(str);
        this.e = i;
    }

    private List<Proxy> a() {
        try {
            return ProxySelector.getDefault().select(new URI(c()));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        u a2 = t.a(c());
        try {
            try {
                byte[] bytes = b.getBytes();
                a2.a(0L);
                byte[] bArr = new byte[bytes.length];
                a2.a(bArr);
                boolean equals = Arrays.equals(bytes, bArr);
                SigmobLog.i("Ping response: `" + new String(bArr) + "`, pinged? " + equals);
                return equals;
            } catch (q e) {
                SigmobLog.e("Error reading ping response", e);
                a2.b();
                return false;
            }
        } finally {
            a2.b();
        }
    }

    private String c() {
        Locale locale = Locale.US;
        return "http://" + this.d + ":" + this.e + "/ping";
    }

    public void a(Socket socket) {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write(b.getBytes());
    }

    public boolean a(int i, int i2) {
        int i3 = 0;
        while (i3 < i) {
            try {
            } catch (InterruptedException e) {
                e = e;
                SigmobLog.w("Error pinging server due to unexpected error", e);
            } catch (ExecutionException e2) {
                e = e2;
                SigmobLog.w("Error pinging server due to unexpected error", e);
            } catch (TimeoutException unused) {
                SigmobLog.w("Error pinging server (attempt: " + i3 + ", timeout: " + i2 + "). ");
            }
            if (((Boolean) this.c.submit(new a()).get(i2, TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            i3++;
            i2 *= 2;
        }
        SigmobLog.e(String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). Default proxies are: %s", Integer.valueOf(i3), Integer.valueOf(i2 / 2), a()));
        return false;
    }

    public boolean a(String str) {
        return f13737a.equals(str);
    }
}
