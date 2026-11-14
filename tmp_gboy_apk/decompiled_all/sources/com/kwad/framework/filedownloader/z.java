package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class z extends e implements v {
    private final ArrayList<a.InterfaceC0332a> aqH = new ArrayList<>();

    @Override // com.kwad.framework.filedownloader.v
    public final boolean d(a.InterfaceC0332a interfaceC0332a) {
        return !this.aqH.isEmpty() && this.aqH.contains(interfaceC0332a);
    }

    @Override // com.kwad.framework.filedownloader.v
    public final void e(a.InterfaceC0332a interfaceC0332a) {
        if (this.aqH.isEmpty()) {
            return;
        }
        synchronized (this.aqH) {
            this.aqH.remove(interfaceC0332a);
        }
    }

    @Override // com.kwad.framework.filedownloader.v
    public final boolean f(a.InterfaceC0332a interfaceC0332a) {
        r.zm();
        if (!r.zo()) {
            synchronized (this.aqH) {
                try {
                    r.zm();
                    if (!r.zo()) {
                        if (com.kwad.framework.filedownloader.f.d.atL) {
                            com.kwad.framework.filedownloader.f.d.c(this, "Waiting for connecting with the downloader service... %d", Integer.valueOf(interfaceC0332a.yv().getId()));
                        }
                        n.ze().aO(com.kwad.framework.filedownloader.f.c.Bd());
                        if (!this.aqH.contains(interfaceC0332a)) {
                            interfaceC0332a.free();
                            this.aqH.add(interfaceC0332a);
                        }
                        return true;
                    }
                } finally {
                }
            }
        }
        e(interfaceC0332a);
        return false;
    }

    @Override // com.kwad.framework.filedownloader.e
    public final void yO() {
        w zp = r.zm().zp();
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "The downloader service is connected.", new Object[0]);
        }
        synchronized (this.aqH) {
            try {
                List<a.InterfaceC0332a> list = (List) this.aqH.clone();
                this.aqH.clear();
                ArrayList arrayList = new ArrayList(zp.zt());
                for (a.InterfaceC0332a interfaceC0332a : list) {
                    int yx = interfaceC0332a.yx();
                    if (zp.bS(yx)) {
                        interfaceC0332a.yv().ye().yD();
                        if (!arrayList.contains(Integer.valueOf(yx))) {
                            arrayList.add(Integer.valueOf(yx));
                        }
                    } else {
                        interfaceC0332a.yB();
                    }
                }
                zp.q(arrayList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.kwad.framework.filedownloader.e
    public final void yP() {
        if (yQ() != DownloadServiceConnectChangedEvent.ConnectStatus.lost) {
            if (h.yT().size() > 0) {
                com.kwad.framework.filedownloader.f.d.d(this, "file download service has be unbound but the size of active tasks are not empty %d ", Integer.valueOf(h.yT().size()));
                return;
            }
            return;
        }
        w zp = r.zm().zp();
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "lost the connection to the file download service, and current active task size is %d", Integer.valueOf(h.yT().size()));
        }
        if (h.yT().size() > 0) {
            synchronized (this.aqH) {
                try {
                    h.yT().p(this.aqH);
                    Iterator<a.InterfaceC0332a> it = this.aqH.iterator();
                    while (it.hasNext()) {
                        it.next().free();
                    }
                    zp.zs();
                } catch (Throwable th) {
                    throw th;
                }
            }
            r.zm().zn();
        }
    }
}
