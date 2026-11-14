package com.kwad.framework.filedownloader.services;

import android.text.TextUtils;
import com.kwad.framework.filedownloader.download.DownloadLaunchRunnable;
import com.kwad.framework.filedownloader.y;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class g implements y {
    private final h atA = new h(com.kwad.framework.filedownloader.download.b.zG().zJ());

    private static com.kwad.framework.filedownloader.b.a AV() {
        return com.kwad.framework.filedownloader.download.b.zG().zI();
    }

    private boolean ct(int i) {
        return a(AV().bV(i));
    }

    public final void AW() {
        List<Integer> AZ = this.atA.AZ();
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "pause all tasks %d", Integer.valueOf(AZ.size()));
        }
        Iterator<Integer> it = AZ.iterator();
        while (it.hasNext()) {
            bO(it.next().intValue());
        }
    }

    public final void An() {
        AV().clear();
    }

    @Override // com.kwad.framework.filedownloader.y
    public final boolean a(com.kwad.framework.filedownloader.d.c cVar) {
        if (cVar == null) {
            return false;
        }
        boolean cv = this.atA.cv(cVar.getId());
        if (com.kwad.framework.filedownloader.d.d.cq(cVar.yn())) {
            return cv;
        }
        if (cv) {
            return true;
        }
        com.kwad.framework.filedownloader.f.d.a(this, "%d status is[%s](not finish) & but not in the pool", Integer.valueOf(cVar.getId()), Byte.valueOf(cVar.yn()));
        return false;
    }

    public final synchronized void b(String str, String str2, boolean z, int i, int i2, int i3, boolean z2, com.kwad.framework.filedownloader.d.b bVar, boolean z3) {
        com.kwad.framework.filedownloader.d.c cVar;
        List<com.kwad.framework.filedownloader.d.a> list;
        boolean z4 = true;
        synchronized (this) {
            try {
                if (com.kwad.framework.filedownloader.f.d.atL) {
                    com.kwad.framework.filedownloader.f.d.c(this, "request start the task with url(%s) path(%s) isDirectory(%B)", str, str2, Boolean.valueOf(z));
                }
                int g = com.kwad.framework.filedownloader.f.f.g(str, str2, z);
                com.kwad.framework.filedownloader.b.a AV = AV();
                com.kwad.framework.filedownloader.d.c bV = AV.bV(g);
                if (z || bV != null) {
                    cVar = bV;
                    list = null;
                } else {
                    int g2 = com.kwad.framework.filedownloader.f.f.g(str, com.kwad.framework.filedownloader.f.f.bR(str2), true);
                    com.kwad.framework.filedownloader.d.c bV2 = AV.bV(g2);
                    if (bV2 == null || !str2.equals(bV2.getTargetFilePath())) {
                        list = null;
                    } else {
                        if (com.kwad.framework.filedownloader.f.d.atL) {
                            com.kwad.framework.filedownloader.f.d.c(this, "task[%d] find model by dirCaseId[%d]", Integer.valueOf(g), Integer.valueOf(g2));
                        }
                        list = AV.bW(g2);
                    }
                    cVar = bV2;
                }
                if (com.kwad.framework.filedownloader.f.c.a(g, cVar, (y) this, true)) {
                    if (com.kwad.framework.filedownloader.f.d.atL) {
                        com.kwad.framework.filedownloader.f.d.c(this, "has already started download %d", Integer.valueOf(g));
                    }
                    return;
                }
                String targetFilePath = cVar != null ? cVar.getTargetFilePath() : com.kwad.framework.filedownloader.f.f.a(str2, z, (String) null);
                if (com.kwad.framework.filedownloader.f.c.a(g, targetFilePath, z2, true)) {
                    if (com.kwad.framework.filedownloader.f.d.atL) {
                        com.kwad.framework.filedownloader.f.d.c(this, "has already completed downloading %d", Integer.valueOf(g));
                    }
                    return;
                }
                if (com.kwad.framework.filedownloader.f.c.a(g, cVar != null ? cVar.AD() : 0L, cVar != null ? cVar.zV() : com.kwad.framework.filedownloader.f.f.bP(targetFilePath), targetFilePath, this)) {
                    if (com.kwad.framework.filedownloader.f.d.atL) {
                        com.kwad.framework.filedownloader.f.d.c(this, "there is an another task with the same target-file-path %d %s", Integer.valueOf(g), targetFilePath);
                        if (cVar != null) {
                            AV.bY(g);
                            AV.bX(g);
                        }
                    }
                    return;
                }
                if (cVar == null || !(cVar.yn() == -2 || cVar.yn() == -1 || cVar.yn() == 1 || cVar.yn() == 6 || cVar.yn() == 2)) {
                    if (cVar == null) {
                        cVar = new com.kwad.framework.filedownloader.d.c();
                    }
                    cVar.setUrl(str);
                    cVar.d(str2, z);
                    cVar.setId(g);
                    cVar.Z(0L);
                    cVar.ab(0L);
                    cVar.d((byte) 1);
                    cVar.co(1);
                } else if (cVar.getId() != g) {
                    AV.bY(cVar.getId());
                    AV.bX(cVar.getId());
                    cVar.setId(g);
                    cVar.d(str2, z);
                    if (list != null) {
                        for (com.kwad.framework.filedownloader.d.a aVar : list) {
                            aVar.setId(g);
                            AV.a(aVar);
                        }
                    }
                } else if (TextUtils.equals(str, cVar.getUrl())) {
                    z4 = false;
                } else {
                    cVar.setUrl(str);
                }
                if (z4) {
                    AV.b(cVar);
                }
                this.atA.a(new DownloadLaunchRunnable.a().e(cVar).b(bVar).a(this).f(Integer.valueOf(i2)).g(Integer.valueOf(i)).a(Boolean.valueOf(z2)).b(Boolean.valueOf(z3)).h(Integer.valueOf(i3)).zW());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean bO(int i) {
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "request pause the task %d", Integer.valueOf(i));
        }
        com.kwad.framework.filedownloader.d.c bV = AV().bV(i);
        if (bV == null) {
            return false;
        }
        bV.d((byte) -2);
        this.atA.cancel(i);
        return true;
    }

    public final byte bP(int i) {
        com.kwad.framework.filedownloader.d.c bV = AV().bV(i);
        if (bV == null) {
            return (byte) 0;
        }
        return bV.yn();
    }

    public final boolean bQ(int i) {
        if (i == 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "The task[%d] id is invalid, can't clear it.", Integer.valueOf(i));
            return false;
        }
        if (ct(i)) {
            com.kwad.framework.filedownloader.f.d.d(this, "The task[%d] is downloading, can't clear it.", Integer.valueOf(i));
            return false;
        }
        com.kwad.framework.filedownloader.b.a AV = AV();
        AV.bY(i);
        AV.bX(i);
        return true;
    }

    public final synchronized boolean ci(int i) {
        return this.atA.ci(i);
    }

    public final long ck(int i) {
        com.kwad.framework.filedownloader.d.c bV = AV().bV(i);
        if (bV == null) {
            return 0L;
        }
        return bV.getTotal();
    }

    public final long cu(int i) {
        com.kwad.framework.filedownloader.b.a AV = AV();
        com.kwad.framework.filedownloader.d.c bV = AV.bV(i);
        if (bV == null) {
            return 0L;
        }
        int AG = bV.AG();
        if (AG <= 1) {
            return bV.AD();
        }
        List<com.kwad.framework.filedownloader.d.a> bW = AV.bW(i);
        if (bW == null || bW.size() != AG) {
            return 0L;
        }
        return com.kwad.framework.filedownloader.d.a.s(bW);
    }

    public final boolean isIdle() {
        return this.atA.AY() <= 0;
    }

    @Override // com.kwad.framework.filedownloader.y
    public final int p(String str, int i) {
        return this.atA.p(str, i);
    }

    public final boolean z(String str, String str2) {
        return ct(com.kwad.framework.filedownloader.f.f.B(str, str2));
    }
}
