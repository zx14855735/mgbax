package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.x;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class k implements t {
    private a.InterfaceC0332a aqm;
    private a.c aqn;
    private Queue<MessageSnapshot> aqo;
    private boolean aqp = false;

    public k(a.InterfaceC0332a interfaceC0332a, a.c cVar) {
        a(interfaceC0332a, cVar);
    }

    private void a(a.InterfaceC0332a interfaceC0332a, a.c cVar) {
        this.aqm = interfaceC0332a;
        this.aqn = cVar;
        this.aqo = new LinkedBlockingQueue();
    }

    private void bN(int i) {
        if (com.kwad.framework.filedownloader.d.d.cq(i)) {
            if (!this.aqo.isEmpty()) {
                MessageSnapshot peek = this.aqo.peek();
                com.kwad.framework.filedownloader.f.d.d(this, "the messenger[%s](with id[%d]) has already accomplished all his job, but there still are some messages in parcel queue[%d] queue-top-status[%d]", this, Integer.valueOf(peek.getId()), Integer.valueOf(this.aqo.size()), Byte.valueOf(peek.yn()));
            }
            this.aqm = null;
        }
    }

    private void o(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify completed %s", this.aqm);
        }
        this.aqn.yE();
        p(messageSnapshot);
    }

    private void p(MessageSnapshot messageSnapshot) {
        a.InterfaceC0332a interfaceC0332a = this.aqm;
        if (interfaceC0332a == null) {
            if (com.kwad.framework.filedownloader.f.d.atL) {
                com.kwad.framework.filedownloader.f.d.c(this, "occur this case, it would be the host task of this messenger has been over(paused/warn/completed/error) on the other thread before receiving the snapshot(id[%d], status[%d])", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.yn()));
            }
        } else {
            if (!this.aqp && interfaceC0332a.yv().yk() != null) {
                this.aqo.offer(messageSnapshot);
                j.yV().a(this);
                return;
            }
            if ((l.isValid() || this.aqm.yC()) && messageSnapshot.yn() == 4) {
                this.aqn.yE();
            }
            bN(messageSnapshot.yn());
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void b(a.InterfaceC0332a interfaceC0332a, a.c cVar) {
        if (this.aqm != null) {
            throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.c("the messenger is working, can't re-appointment for %s", interfaceC0332a));
        }
        a(interfaceC0332a, cVar);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void f(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify pending %s", this.aqm);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void g(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify started %s", this.aqm);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void h(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify connected %s", this.aqm);
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void i(MessageSnapshot messageSnapshot) {
        a yv = this.aqm.yv();
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify progress %s %d %d", yv, Long.valueOf(yv.yl()), Long.valueOf(yv.ym()));
        }
        if (yv.yh() > 0) {
            p(messageSnapshot);
        } else if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify progress but client not request notify %s", this.aqm);
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void j(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify block completed %s %s", this.aqm, Thread.currentThread().getName());
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void k(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.atL) {
            a yv = this.aqm.yv();
            com.kwad.framework.filedownloader.f.d.c(this, "notify retry %s %d %d %s", this.aqm, Integer.valueOf(yv.yq()), Integer.valueOf(yv.yr()), yv.yp());
        }
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void l(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify warn %s", this.aqm);
        }
        this.aqn.yE();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void m(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.atL) {
            a.InterfaceC0332a interfaceC0332a = this.aqm;
            com.kwad.framework.filedownloader.f.d.c(this, "notify error %s %s", interfaceC0332a, interfaceC0332a.yv().yp());
        }
        this.aqn.yE();
        p(messageSnapshot);
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void n(MessageSnapshot messageSnapshot) {
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify paused %s", this.aqm);
        }
        this.aqn.yE();
        p(messageSnapshot);
    }

    public final String toString() {
        a.InterfaceC0332a interfaceC0332a = this.aqm;
        return com.kwad.framework.filedownloader.f.f.c("%d:%s", Integer.valueOf(interfaceC0332a == null ? -1 : interfaceC0332a.yv().getId()), super.toString());
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean yY() {
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "notify begin %s", this.aqm);
        }
        if (this.aqm == null) {
            com.kwad.framework.filedownloader.f.d.d(this, "can't begin the task, the holder fo the messenger is nil, %d", Integer.valueOf(this.aqo.size()));
            return false;
        }
        this.aqn.onBegin();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.framework.filedownloader.t
    public final void yZ() {
        if (this.aqp) {
            return;
        }
        MessageSnapshot poll = this.aqo.poll();
        byte yn = poll.yn();
        a.InterfaceC0332a interfaceC0332a = this.aqm;
        if (interfaceC0332a == null) {
            return;
        }
        a yv = interfaceC0332a.yv();
        i yk = yv.yk();
        x.a yw = interfaceC0332a.yw();
        bN(yn);
        if (yk == null) {
            return;
        }
        if (yn == 4) {
            try {
                yk.b(yv);
                o(((com.kwad.framework.filedownloader.message.a) poll).Ap());
                return;
            } catch (Throwable th) {
                m(yw.g(th));
                return;
            }
        }
        g gVar = yk instanceof g ? (g) yk : null;
        if (yn == -4) {
            yk.d(yv);
            return;
        }
        if (yn == -3) {
            yk.c(yv);
            return;
        }
        if (yn == -2) {
            if (gVar == null) {
                yk.c(yv, poll.Aq(), poll.Ar());
                return;
            } else {
                poll.Au();
                poll.As();
                return;
            }
        }
        if (yn == -1) {
            yk.a(yv, poll.Av());
            return;
        }
        if (yn == 1) {
            if (gVar == null) {
                yk.a(yv, poll.Aq(), poll.Ar());
                return;
            } else {
                poll.Au();
                poll.As();
                return;
            }
        }
        if (yn == 2) {
            if (gVar == null) {
                yk.a(yv, poll.getEtag(), poll.Ai(), yv.getSmallFileSoFarBytes(), poll.Ar());
                return;
            }
            poll.getEtag();
            poll.Ai();
            poll.As();
            return;
        }
        if (yn == 3) {
            if (gVar != null) {
                poll.Au();
                return;
            } else {
                yk.b(yv, poll.Aq(), yv.getSmallFileTotalBytes());
                return;
            }
        }
        if (yn != 5) {
            if (yn != 6) {
                return;
            }
            yk.a(yv);
        } else if (gVar != null) {
            poll.Av();
            poll.yr();
            poll.Au();
        } else {
            poll.Av();
            poll.yr();
            poll.Aq();
        }
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean za() {
        return this.aqm.yv().ys();
    }

    @Override // com.kwad.framework.filedownloader.t
    public final boolean zb() {
        return this.aqo.peek().yn() == 4;
    }

    @Override // com.kwad.framework.filedownloader.t
    public final void zc() {
        this.aqp = true;
    }
}
