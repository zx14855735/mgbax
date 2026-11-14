package com.bytedance.sdk.openadsdk.core.a;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.baidu.mobads.sdk.internal.bn;
import com.bytedance.sdk.openadsdk.core.ra.ai;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class eu {
    private static volatile eu xj;
    private String hf;
    private final Set<String> w = Collections.synchronizedSet(new HashSet());

    public static class xj {
        private final AtomicInteger hf = new AtomicInteger(0);
        private final AtomicInteger w = new AtomicInteger(0);
        private final String xj;

        public xj(String str) {
            this.xj = str;
        }

        public void hf() {
            this.w.incrementAndGet();
        }

        public int kd() {
            return this.w.get();
        }

        public int u() {
            return this.hf.get();
        }

        public String w() {
            return this.xj;
        }

        public void xj() {
            this.hf.incrementAndGet();
        }
    }

    private void hf(File file) {
        try {
            if (file.exists()) {
                long currentTimeMillis = System.currentTimeMillis();
                if (file.setLastModified(currentTimeMillis)) {
                    return;
                }
                file.renameTo(file);
                if (file.lastModified() < currentTimeMillis) {
                    com.bytedance.sdk.component.utils.pl.hf("WebCacheResourceManager", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String w(String str) {
        File file = new File(hf(), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static eu xj() {
        if (xj == null) {
            synchronized (eu.class) {
                try {
                    if (xj == null) {
                        xj = new eu();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    private String hf() {
        if (TextUtils.isEmpty(this.hf)) {
            try {
                File file = new File(com.bytedance.sdk.openadsdk.api.plugin.hf.hf(com.bytedance.sdk.openadsdk.core.pz.getContext()), "tt_web_resource");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.hf = file.getAbsolutePath();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.u("WebCacheResourceManager", "init root path error: ".concat(String.valueOf(th)));
            }
        }
        return this.hf;
    }

    public void xj(List<ai.w> list, ai.xj xjVar) {
        hf(list, xjVar);
        Iterator<ai.w> it = list.iterator();
        while (it.hasNext()) {
            xj(it.next(), xjVar);
        }
    }

    private void xj(final ai.w wVar, final ai.xj xjVar) {
        File[] listFiles;
        ai.u w = wVar.w();
        final String xj2 = wVar.w().xj();
        if (this.w.contains(xj2)) {
            return;
        }
        File file = new File(hf());
        if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    String name = file2.getName();
                    String substring = name.substring(0, name.indexOf("$"));
                    String substring2 = name.substring(name.indexOf("$") + 1);
                    if (!substring.equals(wVar.xj())) {
                        continue;
                    } else {
                        if (substring2.equals(com.bytedance.sdk.component.utils.kd.hf(w.hf()))) {
                            return;
                        }
                        com.bytedance.sdk.component.utils.y.w(file2);
                        if (xjVar != null) {
                            xjVar.hf(hf(wVar.xj()));
                        }
                    }
                }
            }
        }
        this.w.add(xj2);
        File file3 = new File(hf(), com.bytedance.sdk.component.utils.kd.hf(xj2));
        com.bytedance.sdk.component.d.hf.hf u = com.bytedance.sdk.openadsdk.core.et.kd.xj().hf().u();
        u.xj(xj2);
        u.xj(file3.getParent(), file3.getName());
        u.xj(new com.bytedance.sdk.component.d.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.a.eu.1
            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, final com.bytedance.sdk.component.d.hf hfVar) {
                eu.this.w.remove(xj2);
                if (hfVar.f() && hfVar.c() != null && hfVar.c().exists()) {
                    com.bytedance.sdk.component.tf.c.xj(new com.bytedance.sdk.component.tf.d("downloadZip") { // from class: com.bytedance.sdk.openadsdk.core.a.eu.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String absolutePath = hfVar.c().getAbsolutePath();
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                com.bytedance.sdk.component.utils.z.xj(absolutePath, eu.this.w(wVar.u()));
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                ai.xj xjVar2 = xjVar;
                                if (xjVar2 != null) {
                                    xjVar2.xj(wVar);
                                }
                            } catch (Throwable th) {
                                StringBuilder sb = new StringBuilder("unzip web resources failed：");
                                AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                                sb.append(eu.this.w(wVar.u()));
                                com.bytedance.sdk.component.utils.pl.w("WebCacheResourceManager", sb.toString(), th);
                            }
                            try {
                                hfVar.c().delete();
                            } catch (Throwable unused) {
                            }
                        }
                    }, 5);
                    return;
                }
                com.bytedance.sdk.component.utils.pl.u("WebCacheResourceManager", "download resources failed 1：" + xj2);
            }

            @Override // com.bytedance.sdk.component.d.xj.xj
            public void xj(com.bytedance.sdk.component.d.hf.u uVar, IOException iOException) {
                eu.this.w.remove(xj2);
                com.bytedance.sdk.component.utils.pl.u("WebCacheResourceManager", "download resources failed 2：" + xj2);
            }
        });
    }

    public void hf(List<ai.w> list, ai.xj xjVar) {
        File[] listFiles;
        File file = new File(hf());
        if (!file.exists() || (listFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.a.eu.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory();
            }
        })) == null) {
            return;
        }
        for (File file2 : listFiles) {
            String substring = file2.getName().substring(0, file2.getName().indexOf("$"));
            Iterator<ai.w> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().xj().equals(substring)) {
                        break;
                    }
                } else {
                    com.bytedance.sdk.component.utils.y.w(file2);
                    if (xjVar != null) {
                        xjVar.hf(hf(substring));
                    }
                }
            }
        }
    }

    public static ai.w hf(String str) {
        if (com.bytedance.sdk.openadsdk.core.ra.ai.xj().isEmpty()) {
            return null;
        }
        for (ai.w wVar : com.bytedance.sdk.openadsdk.core.ra.ai.xj()) {
            if (wVar.xj().equals(str)) {
                return wVar;
            }
        }
        return null;
    }

    private void xj(File file) {
        hf(file);
        try {
            com.bytedance.sdk.openadsdk.core.f.zg().b().xj(file);
        } catch (Throwable unused) {
        }
    }

    public List<ai.w> xj(String str) {
        if (!com.bytedance.sdk.openadsdk.core.ra.ai.xj || com.bytedance.sdk.openadsdk.core.ra.ai.xj().isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            String path = new URL(str).getPath();
            if (path != null && !path.isEmpty()) {
                for (ai.w wVar : com.bytedance.sdk.openadsdk.core.ra.ai.xj()) {
                    if (path.contains(wVar.hf())) {
                        arrayList.add(wVar);
                    }
                }
                return arrayList;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public WebResourceResponse xj(WebResourceResponse webResourceResponse, String str, List<ai.w> list, Map<String, xj> map) {
        xj xjVar;
        try {
            String path = new URL(str).getPath();
            if (map != null) {
                xjVar = map.get(path);
                if (xjVar == null) {
                    xjVar = new xj(path);
                    map.put(path, xjVar);
                }
            } else {
                xjVar = new xj(path);
            }
            String str2 = "text/html";
            for (ai.w wVar : list) {
                File file = new File(w(wVar.u()), path.substring(path.indexOf(wVar.hf())).replace(wVar.hf(), ""));
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    if (webResourceResponse == null) {
                        Iterator<ai.hf> it = wVar.w().w().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            ai.hf next = it.next();
                            if (TextUtils.equals(next.hf(), file.getName())) {
                                str2 = next.xj();
                                break;
                            }
                        }
                        WebResourceResponse webResourceResponse2 = new WebResourceResponse(str2, "utf-8", fileInputStream);
                        try {
                            xjVar.xj();
                            webResourceResponse = webResourceResponse2;
                        } catch (Exception unused) {
                            return webResourceResponse2;
                        }
                    }
                    webResourceResponse.setData(fileInputStream);
                    xj(new File(w(wVar.u())));
                    return webResourceResponse;
                }
            }
            xjVar.hf();
            return webResourceResponse;
        } catch (Exception unused2) {
            return webResourceResponse;
        }
    }

    public void xj(ai.xj xjVar) {
        try {
            for (File file : new File(hf()).listFiles()) {
                if (System.currentTimeMillis() - file.lastModified() >= bn.d) {
                    try {
                        com.bytedance.sdk.component.utils.y.w(file);
                        String name = file.getName();
                        String substring = name.substring(0, name.indexOf("$"));
                        if (xjVar != null) {
                            xjVar.hf(hf(substring));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }
}
