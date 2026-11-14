package com.bytedance.sdk.openadsdk.core.ugeno.kd;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.component.adexpress.kd.kd;
import com.bytedance.sdk.component.adexpress.u.tf;
import com.bytedance.sdk.component.adexpress.xj.hf.u;
import com.bytedance.sdk.component.adexpress.xj.hf.w;
import com.bytedance.sdk.component.adexpress.xj.w.xj;
import com.bytedance.sdk.component.tf.c;
import com.bytedance.sdk.component.tf.d;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.utils.y;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ugeno.y.hf;
import com.bytedance.sdk.openadsdk.core.v;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj extends w {
    private static AtomicReference<hf> kd = new AtomicReference<>(null);
    private static volatile File w;
    private static volatile xj xj;
    private AtomicBoolean hf = new AtomicBoolean(false);
    private AtomicBoolean u = new AtomicBoolean(false);

    static {
        xnukH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            if (kd.get() != null) {
                return;
            }
            File file = new File(xj(), "package_ugen_temp.json");
            long length = file.length();
            Long valueOf = Long.valueOf(length);
            if (length > 0 && file.exists() && file.isFile()) {
                byte[] bArr = new byte[valueOf.intValue()];
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    kd.set(hf.hf(new JSONObject(new String(bArr, "utf-8"))));
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        pl.w("PlayComponentEngineCacheManager", "version init error", th);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return;
                            } catch (IOException e) {
                                pl.xj(e);
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e2) {
                                pl.xj(e2);
                            }
                        }
                        throw th3;
                    }
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e3) {
                    pl.xj(e3);
                }
            }
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
        }
    }

    public static xj hf() {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    private static /* synthetic */ void xnukH() {
        char[] charArray = "\u008a\u0086\u0084Ç\u008e\u0088\u0084\u008cÇ\u008b\u0086\u0090Ç\u009a\u0081\u008c\u0085\u0085Ç£\u0087\u0080«\u009b\u0080\u008d\u008e\u008c".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 233);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u008a\u0085\u0080\u0087\u0080\u009d".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 233);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void c() {
        hf hfVar = kd.get();
        if (hfVar == null || !hfVar.y()) {
            return;
        }
        boolean xj2 = xj(hfVar.getResources());
        if (!xj2) {
            kd();
        }
        this.u.set(xj2);
    }

    public boolean f() {
        AtomicBoolean atomicBoolean = this.u;
        return atomicBoolean != null && atomicBoolean.get();
    }

    public void kd() {
        w.hf(xj(), kd.get(), "package_ugen_temp.json");
        kd.set(null);
    }

    public void u() {
        try {
            if (this.hf.get()) {
                return;
            }
            boolean z = true;
            this.hf.set(true);
            hf hfVar = new hf(pz.xj().xj(2));
            hf hfVar2 = kd.get();
            if (!hfVar.y()) {
                this.hf.set(false);
                return;
            }
            if (!w.xj(hfVar2, hfVar.w())) {
                this.hf.set(false);
                return;
            }
            v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.xj.2
                @Override // java.lang.Runnable
                public void run() {
                    kd.xj().hf();
                }
            });
            List<xj.C0107xj> hf = hf(hfVar, hfVar2);
            if (hf == null) {
                z = false;
            }
            if (hf == null) {
                this.hf.set(false);
            }
            if (z && xj(hfVar.getResources())) {
                kd.set(hfVar);
                w.xj(xj(), kd.get(), "package_ugen_temp.json");
                hf(hf);
            }
            c();
            this.hf.set(false);
        } catch (Throwable unused) {
        }
    }

    public void w() {
        c.xj(new d("enginecache-init") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.kd.xj.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    xj.this.d();
                    xj.this.c();
                    xj.this.u();
                } catch (Throwable unused) {
                }
            }
        });
    }

    public void y() {
        try {
            kd();
            File xj2 = xj();
            if (xj2 == null || !xj2.exists()) {
                return;
            }
            if (xj2.getParentFile() != null) {
                y.w(xj2.getParentFile());
            } else {
                y.w(xj2);
            }
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.xj.hf.w
    public File xj() {
        if (w == null) {
            try {
                File file = new File(new File(u.xj(), "tt_ugen_pkg"), "engine");
                file.mkdirs();
                w = file;
            } catch (Throwable th) {
                pl.w("PlayComponentEngineCacheManager", "ge", th);
            }
        }
        return w;
    }

    private File hf(String str) {
        hf hfVar;
        if (!f() || (hfVar = kd.get()) == null) {
            return null;
        }
        Iterator<xj.C0107xj> it = hfVar.getResources().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            xj.C0107xj next = it.next();
            if (next.xj() != null && next.xj().equals(str)) {
                File file = new File(xj(), com.bytedance.sdk.component.utils.kd.hf(next.xj()));
                String xj2 = com.bytedance.sdk.component.utils.kd.xj(file);
                if (next.hf() == null || !next.hf().equals(xj2)) {
                    break;
                }
                return file;
            }
        }
        return null;
    }

    public WebResourceResponse xj(WebView webView, tf.xj xjVar, String str) {
        File hf;
        try {
            if (TextUtils.isEmpty(str) || xjVar == tf.xj.IMAGE || (hf = hf(str)) == null) {
                return null;
            }
            return new WebResourceResponse(xjVar.getType(), "utf-8", new FileInputStream(hf));
        } catch (Throwable th) {
            pl.w("PlayComponentEngineCacheManager", "grwe", th);
            return null;
        }
    }
}
