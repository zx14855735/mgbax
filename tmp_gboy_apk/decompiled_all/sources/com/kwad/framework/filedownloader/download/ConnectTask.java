package com.kwad.framework.filedownloader.download;

import J3FDQU.A2egSU;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ConnectTask {
    final int arh;
    final com.kwad.framework.filedownloader.d.b ari;
    private com.kwad.framework.filedownloader.download.a arj;
    private String ark;
    private Map<String, List<String>> arl;
    private List<String> arm;
    final String url;

    public class Reconnect extends Throwable {
        private static final long serialVersionUID = 2940866805654257562L;

        public Reconnect() {
        }
    }

    public static class a {
        private com.kwad.framework.filedownloader.d.b ari;
        private String ark;
        private Integer arn;
        private com.kwad.framework.filedownloader.download.a aro;
        private String url;

        public final a a(com.kwad.framework.filedownloader.d.b bVar) {
            this.ari = bVar;
            return this;
        }

        public final a bB(String str) {
            this.url = str;
            return this;
        }

        public final a bC(String str) {
            this.ark = str;
            return this;
        }

        public final a cd(int i) {
            this.arn = Integer.valueOf(i);
            return this;
        }

        public final ConnectTask zF() {
            com.kwad.framework.filedownloader.download.a aVar;
            Integer num = this.arn;
            if (num == null || (aVar = this.aro) == null || this.url == null) {
                throw new IllegalArgumentException();
            }
            return new ConnectTask(aVar, num.intValue(), this.url, this.ark, this.ari, (byte) 0);
        }

        public final a a(com.kwad.framework.filedownloader.download.a aVar) {
            this.aro = aVar;
            return this;
        }
    }

    public /* synthetic */ ConnectTask(com.kwad.framework.filedownloader.download.a aVar, int i, String str, String str2, com.kwad.framework.filedownloader.d.b bVar, byte b) {
        this(aVar, i, str, str2, bVar);
    }

    private void a(com.kwad.framework.filedownloader.a.b bVar) {
        HashMap<String, List<String>> AC;
        com.kwad.framework.filedownloader.d.b bVar2 = this.ari;
        if (bVar2 == null || (AC = bVar2.AC()) == null) {
            return;
        }
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.e(this, "%d add outside header: %s", Integer.valueOf(this.arh), AC);
        }
        for (Map.Entry<String, List<String>> entry : AC.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (value != null) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    bVar.addHeader(key, it.next());
                }
            }
        }
    }

    private void b(com.kwad.framework.filedownloader.a.b bVar) {
        if (!TextUtils.isEmpty(this.ark)) {
            bVar.addHeader(com.sigmob.sdk.downloader.core.c.c, this.ark);
        }
        com.kwad.framework.filedownloader.download.a aVar = this.arj;
        bVar.addHeader(com.sigmob.sdk.downloader.core.c.b, aVar.arr == 0 ? com.kwad.framework.filedownloader.f.f.c("bytes=%d-", Long.valueOf(aVar.arq)) : com.kwad.framework.filedownloader.f.f.c("bytes=%d-%d", Long.valueOf(aVar.arq), Long.valueOf(this.arj.arr)));
    }

    private void c(com.kwad.framework.filedownloader.a.b bVar) {
        com.kwad.framework.filedownloader.d.b bVar2 = this.ari;
        if (bVar2 == null || bVar2.AC().get("User-Agent") == null) {
            bVar.addHeader("User-Agent", com.kwad.framework.filedownloader.f.f.Bl());
        }
    }

    public final Map<String, List<String>> getRequestHeader() {
        return this.arl;
    }

    public final com.kwad.framework.filedownloader.a.b zB() {
        com.kwad.framework.filedownloader.a.b bD = b.zG().bD(this.url);
        a(bD);
        b(bD);
        c(bD);
        this.arl = bD.zu();
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "%s request header %s", Integer.valueOf(this.arh), this.arl);
        }
        bD.execute();
        ArrayList arrayList = new ArrayList();
        this.arm = arrayList;
        return com.kwad.framework.filedownloader.a.d.a(this.arl, bD, arrayList);
    }

    public final boolean zC() {
        return this.arj.arq > 0;
    }

    public final String zD() {
        List<String> list = this.arm;
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String) A2egSU.AlLFFp(this.arm, 1);
    }

    public final com.kwad.framework.filedownloader.download.a zE() {
        return this.arj;
    }

    private ConnectTask(com.kwad.framework.filedownloader.download.a aVar, int i, String str, String str2, com.kwad.framework.filedownloader.d.b bVar) {
        this.arh = i;
        this.url = str;
        this.ark = str2;
        this.ari = bVar;
        this.arj = aVar;
    }
}
