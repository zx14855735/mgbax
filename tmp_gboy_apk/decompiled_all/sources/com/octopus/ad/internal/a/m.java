package com.octopus.ad.internal.a;

import B4ZgIw.AYUAbz;
import com.octopus.ad.internal.utilities.HaoboLog;
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
class m {

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f12399a = Executors.newSingleThreadExecutor();
    private final String b;
    private final int c;

    public class a implements Callable<Boolean> {
        private a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            return Boolean.valueOf(m.this.b());
        }
    }

    public m(String str, int i) {
        this.b = (String) n.a(str);
        this.c = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        j jVar = new j(c());
        try {
            try {
                byte[] bytes = "ping ok".getBytes();
                jVar.a(0L);
                byte[] bArr = new byte[bytes.length];
                jVar.a(bArr);
                boolean equals = Arrays.equals(bytes, bArr);
                HaoboLog.i(HaoboLog.pingerLogTag, "Ping response: `" + new String(bArr) + "`, pinged? " + equals);
                return equals;
            } catch (p e) {
                HaoboLog.e(HaoboLog.pingerLogTag, "Error reading ping response", e);
                jVar.b();
                return false;
            }
        } finally {
            jVar.b();
        }
    }

    private String c() {
        Locale locale = Locale.US;
        return "http://" + this.b + ":" + this.c + "/ping";
    }

    public boolean a(int i, int i2) {
        n.a(i >= 1);
        n.a(i2 > 0);
        int i3 = 0;
        while (i3 < i) {
            try {
            } catch (InterruptedException e) {
                e = e;
                HaoboLog.e(HaoboLog.pingerLogTag, "Error pinging server due to unexpected error", e);
            } catch (ExecutionException e2) {
                e = e2;
                HaoboLog.e(HaoboLog.pingerLogTag, "Error pinging server due to unexpected error", e);
            } catch (TimeoutException unused) {
                HaoboLog.w(HaoboLog.pingerLogTag, "Error pinging server (attempt: " + i3 + ", timeout: " + i2 + "). ");
            }
            if (((Boolean) this.f12399a.submit(new a()).get(i2, TimeUnit.MILLISECONDS)).booleanValue()) {
                return true;
            }
            i3++;
            i2 *= 2;
        }
        String format = String.format(Locale.US, "Error pinging server (attempts: %d, max timeout: %d). If you see this message, please, report at https://github.com/danikula/AndroidVideoCache/issues/134. Default proxies are: %s", Integer.valueOf(i3), Integer.valueOf(i2 / 2), a());
        String str = HaoboLog.pingerLogTag;
        StringBuilder A4TApA2 = AYUAbz.A4TApA(format);
        A4TApA2.append(new p(format));
        HaoboLog.e(str, A4TApA2.toString());
        return false;
    }

    private List<Proxy> a() {
        try {
            return ProxySelector.getDefault().select(new URI(c()));
        } catch (URISyntaxException e) {
            throw new IllegalStateException(e);
        }
    }

    public boolean a(String str) {
        return "ping".equals(str);
    }

    public void a(Socket socket) {
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\n\n".getBytes());
        outputStream.write("ping ok".getBytes());
    }
}
