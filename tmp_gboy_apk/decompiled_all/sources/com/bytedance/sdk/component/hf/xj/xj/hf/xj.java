package com.bytedance.sdk.component.hf.xj.xj.hf;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.an;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.d;
import com.bytedance.sdk.component.hf.xj.p;
import com.bytedance.sdk.component.hf.xj.qt;
import com.bytedance.sdk.component.hf.xj.zg;
import com.bytedance.sdk.component.utils.pl;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj implements com.bytedance.sdk.component.hf.xj.hf {
    u hf;
    am xj;
    private volatile boolean y;
    private AtomicBoolean kd = new AtomicBoolean(false);
    final String w = com.bytedance.sdk.component.hf.xj.hf.u.xj(UUID.randomUUID().toString()).xj();
    p u = new p();

    /* renamed from: com.bytedance.sdk.component.hf.xj.xj.hf.xj$xj, reason: collision with other inner class name */
    public final class C0114xj extends com.bytedance.sdk.component.hf.xj.hf.kd {
        private final xj u;
        private final com.bytedance.sdk.component.hf.xj.w w;

        public C0114xj(com.bytedance.sdk.component.hf.xj.w wVar, xj xjVar) {
            super("net-async-call", new Object[0]);
            this.w = wVar;
            this.u = xjVar;
        }

        @Override // com.bytedance.sdk.component.hf.xj.hf.kd
        public void hf() {
            p pVar;
            try {
                xj xjVar = this.u;
                if (xjVar != null && (pVar = xjVar.u) != null) {
                    pVar.xj();
                }
                zg kd = xj.this.kd();
                if (kd == null) {
                    this.w.onFailure(xj.this, new IOException("response is null"));
                } else {
                    this.w.onResponse(xj.this, kd);
                }
            } catch (Throwable th) {
                try {
                    if (th instanceof IOException) {
                        this.w.onFailure(xj.this, th);
                    } else {
                        this.w.onFailure(xj.this, new IOException(th));
                    }
                    try {
                        this.u.hf.hf(this);
                    } catch (Throwable th2) {
                        pl.xj(th2);
                    }
                } finally {
                    try {
                        this.u.hf.hf(this);
                    } catch (Throwable th3) {
                        pl.xj(th3);
                    }
                }
            }
        }

        public void xj() {
            p pVar;
            xj xjVar = this.u;
            if (xjVar == null || (pVar = xjVar.u) == null) {
                return;
            }
            pVar.u();
        }
    }

    public xj(am amVar, u uVar) {
        this.xj = amVar;
        this.hf = uVar;
    }

    private boolean c() {
        if (this.xj.u() == null) {
            return false;
        }
        return this.xj.u().containsKey("Content-Type");
    }

    private boolean w(qt qtVar) {
        am amVar;
        return (qtVar == null || (amVar = this.xj) == null || !an.b.equalsIgnoreCase(amVar.w()) || qtVar.y != qt.xj.STRING_TYPE || TextUtils.isEmpty(qtVar.u)) ? false : true;
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf
    public zg hf() {
        synchronized (this) {
            if (this.y) {
                throw new IllegalStateException("Already Executed");
            }
            this.y = true;
        }
        try {
            this.hf.xj(this);
            return kd();
        } finally {
            this.hf.hf(this);
        }
    }

    public zg kd() {
        List<d> list;
        if (this.kd.get()) {
            return null;
        }
        try {
            com.bytedance.sdk.component.hf.xj.pl plVar = this.xj.xj;
            if (plVar == null || (list = plVar.xj) == null || list.size() <= 0) {
                return xj(this.xj);
            }
            ArrayList arrayList = new ArrayList(this.xj.xj.xj);
            arrayList.add(new d() { // from class: com.bytedance.sdk.component.hf.xj.xj.hf.xj.1
                @Override // com.bytedance.sdk.component.hf.xj.d
                public zg xj(d.xj xjVar) {
                    return xj.this.xj(xjVar.xj());
                }
            });
            return ((d) arrayList.get(0)).xj(new hf(arrayList, this.xj));
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf
    public boolean u() {
        return this.kd.get();
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf
    public am xj() {
        return this.xj;
    }

    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.hf.xj.hf clone() {
        return new xj(this.xj, this.hf);
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf
    public void xj(com.bytedance.sdk.component.hf.xj.w wVar) {
        try {
            synchronized (this) {
                if (this.y) {
                    throw new IllegalStateException("Already Executed");
                }
                this.y = true;
            }
            this.hf.xj(new C0114xj(wVar, this));
        } catch (Throwable th) {
            if (wVar != null) {
                wVar.onFailure(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.hf.xj.hf
    public void w() {
        this.kd.set(true);
    }

    private boolean hf(qt qtVar) {
        am amVar;
        byte[] bArr;
        return qtVar != null && (amVar = this.xj) != null && an.b.equalsIgnoreCase(amVar.w()) && qtVar.y == qt.xj.BYTE_ARRAY_TYPE && (bArr = qtVar.kd) != null && bArr.length > 0;
    }

    public zg xj(am amVar) {
        try {
            p pVar = this.u;
            if (pVar != null) {
                pVar.hf();
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(amVar.hf().xj().toString()).openConnection();
            if (amVar.u() != null && amVar.u().size() > 0) {
                for (Map.Entry<String, List<String>> entry : amVar.u().entrySet()) {
                    Iterator<String> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), it.next());
                    }
                }
            }
            com.bytedance.sdk.component.hf.xj.pl plVar = amVar.xj;
            if (plVar != null) {
                TimeUnit timeUnit = plVar.w;
                if (timeUnit != null) {
                    httpURLConnection.setConnectTimeout((int) timeUnit.toMillis(plVar.hf));
                }
                com.bytedance.sdk.component.hf.xj.pl plVar2 = amVar.xj;
                TimeUnit timeUnit2 = plVar2.kd;
                if (timeUnit2 != null) {
                    httpURLConnection.setReadTimeout((int) timeUnit2.toMillis(plVar2.u));
                }
            }
            if (amVar.y() == null) {
                httpURLConnection.setRequestMethod(an.c);
            } else {
                if (!c() && amVar.y().w != null) {
                    httpURLConnection.addRequestProperty("Content-Type", amVar.y().w.toString());
                }
                httpURLConnection.setRequestMethod(amVar.w());
                if (xj(amVar.y())) {
                    xj(httpURLConnection);
                }
                if (an.b.equalsIgnoreCase(amVar.w())) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    if (w(amVar.y())) {
                        outputStream.write(amVar.y().u.getBytes());
                    } else if (xj(amVar.y())) {
                        xj(amVar.y().kd, outputStream, amVar.y().hf(), amVar.y().xj());
                    } else if (hf(amVar.y())) {
                        outputStream.write(amVar.y().kd);
                    }
                    outputStream.flush();
                    outputStream.close();
                }
            }
            httpURLConnection.connect();
            long currentTimeMillis = System.currentTimeMillis();
            p pVar2 = this.u;
            if (pVar2 != null) {
                pVar2.w();
                this.u.xj(currentTimeMillis);
            }
            httpURLConnection.getResponseCode();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (this.kd.get()) {
                httpURLConnection.disconnect();
                return null;
            }
            y yVar = new y(httpURLConnection, amVar);
            yVar.u = currentTimeMillis;
            yVar.w = currentTimeMillis2;
            p pVar3 = this.u;
            if (pVar3 != null) {
                pVar3.hf(currentTimeMillis2);
            }
            yVar.kd = this.u;
            return yVar;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private void xj(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.w);
    }

    private void xj(byte[] bArr, OutputStream outputStream, String str, String str2) {
        if (bArr == null || outputStream == null) {
            return;
        }
        PrintWriter printWriter = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
        printWriter.append((CharSequence) ("--" + this.w)).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) A2egSU.AzWtSf(new StringBuilder("Content-Disposition: form-data; name=\""), str, "\"; filename=\"", str2, "\"")).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) "Content-Type: multipart/form-data").append((CharSequence) "\r\n");
        printWriter.append((CharSequence) ("Content-Length: " + bArr.length)).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) "\r\n");
        printWriter.flush();
        outputStream.write(bArr);
        printWriter.append((CharSequence) "\r\n");
        printWriter.append((CharSequence) ("--" + this.w + "--")).append((CharSequence) "\r\n");
        printWriter.flush();
        printWriter.close();
    }

    private boolean xj(qt qtVar) {
        am amVar;
        byte[] bArr;
        return qtVar != null && (amVar = this.xj) != null && an.b.equalsIgnoreCase(amVar.w()) && qtVar.y == qt.xj.FILE_TYPE && (bArr = qtVar.kd) != null && bArr.length > 0;
    }
}
