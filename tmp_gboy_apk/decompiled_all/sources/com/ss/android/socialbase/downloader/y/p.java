package com.ss.android.socialbase.downloader.y;

import ADYaiT.CtFAbx;
import J3FDQU.A2egSU;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.aw;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.ss.android.socialbase.downloader.d.kd;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.w;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class p implements w.xj, y {
    private final boolean ai;
    private long dk;
    private BaseException e;
    private long et;
    private long g;
    private final am hf;

    /* renamed from: io, reason: collision with root package name */
    private float f13861io;
    private final com.ss.android.socialbase.downloader.tf.kd jk;
    private final c kd;
    private com.ss.android.socialbase.downloader.model.u p;
    private final com.ss.android.socialbase.downloader.d.kd pz;
    private long ra;
    private com.ss.android.socialbase.downloader.model.u tf;
    private final com.ss.android.socialbase.downloader.d.y u;
    private final hf w;
    private int x;
    private final DownloadInfo xj;
    private volatile boolean yo;
    private int zg;
    private volatile boolean y = false;
    private volatile boolean c = false;
    private final List<g> f = new ArrayList();
    private final List<e> d = new ArrayList();

    /* renamed from: pl, reason: collision with root package name */
    private volatile boolean f13862pl = true;
    private final LinkedList<d> am = new LinkedList<>();
    private final List<d> qt = new ArrayList();
    private final Object v = new Object();
    private volatile boolean ht = false;
    private final kd.hf q = new kd.hf() { // from class: com.ss.android.socialbase.downloader.y.p.1
        private int hf;

        @Override // com.ss.android.socialbase.downloader.d.kd.hf
        public long xj() {
            if (p.this.y || p.this.c) {
                return -1L;
            }
            synchronized (p.this) {
                try {
                    if (p.this.tf == null && p.this.p == null) {
                        long j = p.this.ra;
                        if (j <= 0) {
                            return -1L;
                        }
                        this.hf++;
                        g xj = p.this.xj(false, System.currentTimeMillis(), j);
                        if (xj == null) {
                            return j;
                        }
                        com.bytedance.sdk.component.utils.pl.xj("SegmentDispatcher", "connectWatcher: switchUrl and reconnect");
                        p.this.w(xj);
                        xj.y();
                        return ((this.hf / p.this.d.size()) + 1) * j;
                    }
                    return -1L;
                } finally {
                }
            }
        }
    };
    private final kd.hf z = new kd.hf() { // from class: com.ss.android.socialbase.downloader.y.p.2
        @Override // com.ss.android.socialbase.downloader.d.kd.hf
        public long xj() {
            return p.this.yo();
        }
    };

    public p(DownloadInfo downloadInfo, am amVar, com.ss.android.socialbase.downloader.d.y yVar) {
        this.xj = downloadInfo;
        this.hf = amVar;
        hf hfVar = new hf(amVar.u(), amVar.kd());
        this.w = hfVar;
        this.u = yVar;
        this.kd = new c(downloadInfo, yVar, hfVar);
        this.pz = new com.ss.android.socialbase.downloader.d.kd();
        this.jk = new com.ss.android.socialbase.downloader.tf.kd();
        this.ai = com.ss.android.socialbase.downloader.f.xj.xj(downloadInfo.getId()).hf(aw.f9748a) == 1;
    }

    private boolean am() {
        long j = this.g;
        if (j <= 0) {
            this.yo = false;
            return false;
        }
        synchronized (this) {
            try {
                long xj = qt.xj(this.qt);
                com.ss.android.socialbase.downloader.w.xj.w("SegmentDispatcher", "isAllContentDownloaded: firstOffset = ".concat(String.valueOf(xj)));
                if (xj >= j) {
                    this.yo = true;
                    return true;
                }
                this.yo = false;
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void d() {
        List<String> backUpUrls;
        int pl2 = this.hf.pl();
        if (pl2 <= 0) {
            this.f13862pl = false;
            kd();
            return;
        }
        com.ss.android.socialbase.downloader.network.w xj = com.ss.android.socialbase.downloader.network.w.xj();
        xj.xj(this.xj.getUrl(), this, 2000L);
        if (pl2 <= 2 || (backUpUrls = this.xj.getBackUpUrls()) == null) {
            return;
        }
        for (String str : backUpUrls) {
            if (!TextUtils.isEmpty(str)) {
                xj.xj(str, this, 2000L);
            }
        }
    }

    private d e() {
        int tf;
        d dVar = null;
        int i = Integer.MAX_VALUE;
        for (d dVar2 : this.qt) {
            if (xj(dVar2) > 0 && (tf = dVar2.tf()) < i) {
                dVar = dVar2;
                i = tf;
            }
        }
        return dVar;
    }

    private void f() {
        if (this.dk > 0) {
            this.et = System.currentTimeMillis();
            this.pz.xj(this.z, 0L);
        }
    }

    private void g() {
        int size;
        if (this.g > 0 && (size = this.qt.size()) > 1) {
            ArrayList<d> arrayList = null;
            int i = 0;
            for (int i2 = 1; i2 < size; i2++) {
                d dVar = this.qt.get(i);
                d dVar2 = this.qt.get(i2);
                if (dVar.kd() > dVar2.w() && dVar2.xj() <= 0 && dVar2.xj == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(dVar2);
                    if (this.ai) {
                        com.bytedance.sdk.component.utils.pl.hf("SegmentDispatcher", "clearCovered, covered = " + dVar2 + ", prev = " + dVar);
                    }
                } else if (dVar2.kd() > dVar.kd()) {
                    i++;
                }
            }
            if (arrayList != null) {
                for (d dVar3 : arrayList) {
                    this.qt.remove(dVar3);
                    for (g gVar : this.f) {
                        if (gVar.xj == dVar3) {
                            if (this.ai) {
                                com.bytedance.sdk.component.utils.pl.hf("SegmentDispatcher", "clearCoveredSegmentLocked: reconnect, segment = " + dVar3 + ", threadIndex = " + gVar.w);
                            }
                            gVar.xj(true);
                        }
                    }
                }
            }
        }
    }

    private void p() {
        com.ss.android.socialbase.downloader.w.xj.w("SegmentDispatcher", "onComplete");
        this.w.w();
        synchronized (this.v) {
            this.v.notify();
        }
    }

    private boolean pl() {
        Iterator<g> it = this.f.iterator();
        while (it.hasNext()) {
            if (!it.next().c()) {
                return false;
            }
        }
        return true;
    }

    private long qt() {
        Iterator<g> it = this.f.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().hf();
        }
        return j;
    }

    private e tf() {
        e eVar;
        synchronized (this) {
            try {
                int size = this.zg % this.d.size();
                if (this.hf.hf()) {
                    this.zg++;
                }
                eVar = this.d.get(size);
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long yo() {
        if (this.y || this.c) {
            return -1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            try {
                hf(currentTimeMillis);
                long p = this.hf.p();
                if (p > 0) {
                    long j = this.et;
                    if (j > 0 && currentTimeMillis - j > p && xj(currentTimeMillis, p)) {
                        this.et = currentTimeMillis;
                        this.x++;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return 2000L;
    }

    private d zg() {
        d e;
        p pVar;
        int i = 0;
        while (true) {
            e = e();
            if (e != null) {
                g gVar = e.xj;
                if (gVar == null) {
                    break;
                }
                if (e.tf() >= 2) {
                    return null;
                }
                long currentTimeMillis = System.currentTimeMillis();
                hf(currentTimeMillis);
                if (currentTimeMillis - gVar.y > 2000) {
                    pVar = this;
                    if (pVar.xj(gVar, currentTimeMillis - 2000, currentTimeMillis, 500L, 1.0d)) {
                        if (pVar.ai) {
                            com.bytedance.sdk.component.utils.pl.xj("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + e + ", owner.threadIndex = " + gVar.w);
                            return e;
                        }
                    }
                } else {
                    pVar = this;
                }
                int i2 = i + 1;
                if (i <= 2) {
                    try {
                        synchronized (this) {
                            wait(500L);
                        }
                        i = i2;
                    } catch (InterruptedException unused) {
                        return null;
                    }
                } else if (pVar.ai) {
                    com.bytedance.sdk.component.utils.pl.xj("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = ".concat(String.valueOf(e)));
                }
            } else {
                return null;
            }
        }
        return e;
    }

    private void c() {
        am amVar = this.hf;
        this.ra = amVar.tf();
        this.dk = amVar.p();
        this.f13861io = amVar.qt();
        int i = this.x;
        if (i > 0) {
            this.pz.xj(this.q, i);
        }
    }

    private void hf(List<d> list) {
        long totalBytes = this.xj.getTotalBytes();
        this.g = totalBytes;
        if (totalBytes <= 0) {
            this.g = this.xj.getExpectFileLength();
            com.ss.android.socialbase.downloader.w.xj.w("SegmentDispatcher", "initSegments: getExpectFileLength = " + this.g);
        }
        synchronized (this) {
            try {
                this.am.clear();
                if (list != null && !list.isEmpty()) {
                    Iterator<d> it = list.iterator();
                    while (it.hasNext()) {
                        xj((List<d>) this.am, new d(it.next()), false);
                    }
                    u(this.am);
                    w(this.am);
                    com.ss.android.socialbase.downloader.w.xj.w("SegmentDispatcher", "initSegments: totalLength = " + this.g);
                }
                xj((List<d>) this.am, new d(0L, -1L), false);
                com.ss.android.socialbase.downloader.w.xj.w("SegmentDispatcher", "initSegments: totalLength = " + this.g);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void kd() {
        int i;
        if (this.g <= 0 || this.f13862pl) {
            i = 1;
        } else {
            i = this.hf.xj();
            int f = (int) (this.g / this.hf.f());
            if (i > f) {
                i = f;
            }
        }
        com.ss.android.socialbase.downloader.w.xj.w("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.g + ", threadCount = " + i);
        int i2 = i > 0 ? i : 1;
        synchronized (this) {
            do {
                try {
                    if (this.f.size() >= i2) {
                        break;
                    }
                    if (!this.c && !this.y) {
                        xj(tf());
                    }
                    return;
                } finally {
                }
            } while (!this.hf.y());
        }
    }

    private void u() {
        try {
            this.kd.xj((u) this.w);
        } catch (zg unused) {
        } catch (BaseException e) {
            com.ss.android.socialbase.downloader.w.xj.kd("SegmentDispatcher", "dispatchSegments: loopAndWrite e = ".concat(String.valueOf(e)));
            xj(e);
            throw e;
        }
        if (this.c || this.y) {
            return;
        }
        try {
            synchronized (this) {
                while (!this.am.isEmpty()) {
                    try {
                        d poll = this.am.poll();
                        if (poll != null) {
                            xj(this.qt, poll, true);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                w(this.qt);
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.utils.pl.xj(th2);
        }
        if (!this.ht || this.e == null) {
            if (this.xj.getCurBytes() != this.xj.getTotalBytes()) {
                com.ss.android.socialbase.downloader.u.xj.xj(this.xj, this.qt);
            }
            com.ss.android.socialbase.downloader.w.xj.w("SegmentDispatcher", "dispatchSegments::download finished");
        } else {
            com.ss.android.socialbase.downloader.w.xj.kd("SegmentDispatcher", "dispatchSegments: loopAndWrite  failedException = " + this.e);
            throw this.e;
        }
    }

    private void w() {
        BaseException baseException;
        synchronized (this.v) {
            try {
                if (this.tf == null && this.p == null) {
                    this.v.wait();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.tf == null && this.p == null && (baseException = this.e) != null) {
            throw baseException;
        }
    }

    private void y() {
        this.d.add(new e(this.xj.getUrl(), true));
        List<String> backUpUrls = this.xj.getBackUpUrls();
        if (backUpUrls != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    this.d.add(new e(str, false));
                }
            }
        }
        this.hf.xj(this.d.size());
    }

    public boolean xj(List<d> list) {
        try {
            y();
            hf(list);
            kd();
            c();
            d();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                w();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                this.xj.increaseAllConnectTime(currentTimeMillis2);
                this.xj.setFirstSpeedTime(currentTimeMillis2);
                if (!this.c && !this.y) {
                    this.u.xj(this.g);
                    f();
                    u();
                    return true;
                }
                if (!this.c && !this.y) {
                    com.ss.android.socialbase.downloader.w.xj.w("SegmentDispatcher", "finally pause");
                    hf();
                }
                this.pz.hf();
                return true;
            } catch (Throwable th) {
                long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                this.xj.increaseAllConnectTime(currentTimeMillis3);
                this.xj.setFirstSpeedTime(currentTimeMillis3);
                throw th;
            }
        } finally {
            if (!this.c && !this.y) {
                com.ss.android.socialbase.downloader.w.xj.w("SegmentDispatcher", "finally pause");
                hf();
            }
            this.pz.hf();
        }
    }

    private void w(List<d> list) {
        long hf = qt.hf(list);
        com.ss.android.socialbase.downloader.w.xj.w("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.xj.getCurBytes() + ", totalBytes = " + this.xj.getTotalBytes() + ", downloadedBytes = " + hf);
        if (hf > this.xj.getTotalBytes() && this.xj.getTotalBytes() > 0) {
            hf = this.xj.getTotalBytes();
        }
        if (this.xj.getCurBytes() == this.xj.getTotalBytes() || this.xj.getCurBytes() == hf) {
            return;
        }
        this.xj.setCurBytes(hf);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0099, code lost:
    
        if ((r19.kd() - r23.kd()) < (r13 / 2)) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void kd(com.ss.android.socialbase.downloader.y.g r22, com.ss.android.socialbase.downloader.y.d r23) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.y.p.kd(com.ss.android.socialbase.downloader.y.g, com.ss.android.socialbase.downloader.y.d):void");
    }

    private void hf(String str, List<e> list) {
        int xj;
        if (this.ai) {
            Iterator<e> it = list.iterator();
            while (it.hasNext()) {
                com.bytedance.sdk.component.utils.pl.xj("SegmentDispatcher", "addIpListLocked: urlRecord = ".concat(String.valueOf(it.next())));
            }
        }
        int pl2 = this.hf.pl();
        if ((pl2 == 1 || pl2 == 3) && (xj = xj(str)) >= 0 && xj < this.d.size()) {
            this.d.addAll(xj + 1, list);
        } else {
            this.d.addAll(list);
        }
    }

    private List<e> w(String str, List<InetAddress> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            for (InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (this.ai) {
                            com.bytedance.sdk.component.utils.pl.xj("SegmentDispatcher", "onDnsResolved: ip = ".concat(String.valueOf(hostAddress)));
                        }
                        e eVar = new e(str, hostAddress);
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(eVar.w);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(eVar.w, linkedList);
                        }
                        linkedList.add(eVar);
                        i++;
                    }
                }
            }
            if (i > 0) {
                ArrayList arrayList = new ArrayList();
                do {
                    Iterator it = linkedHashMap.entrySet().iterator();
                    z = false;
                    while (it.hasNext()) {
                        LinkedList linkedList2 = (LinkedList) ((Map.Entry) it.next()).getValue();
                        if (linkedList2 != null && !linkedList2.isEmpty()) {
                            arrayList.add((e) linkedList2.pollFirst());
                            i--;
                            z = true;
                        }
                    }
                    if (i <= 0) {
                        break;
                    }
                } while (z);
                return arrayList;
            }
        }
        return null;
    }

    private void u(List<d> list) {
        d dVar = list.get(0);
        long w = dVar.w();
        if (w > 0) {
            d dVar2 = new d(0L, w - 1);
            com.bytedance.sdk.component.utils.pl.hf("SegmentDispatcher", "fixSegmentsLocked: first = " + dVar + ", add new first = " + dVar2);
            xj(list, dVar2, true);
        }
        Iterator<d> it = list.iterator();
        if (it.hasNext()) {
            d next = it.next();
            while (it.hasNext()) {
                d next2 = it.next();
                if (next.y() < next2.w() - 1) {
                    com.ss.android.socialbase.downloader.w.xj.u("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.w() - 1));
                    next.w(next2.w() - 1);
                }
                next = next2;
            }
        }
        d dVar3 = (d) A2egSU.AlLFFp(list, 1);
        long totalBytes = this.xj.getTotalBytes();
        if (totalBytes <= 0 || (dVar3.y() != -1 && dVar3.y() < totalBytes - 1)) {
            com.ss.android.socialbase.downloader.w.xj.u("SegmentDispatcher", "fixSegment: last segment = " + dVar3 + ", new end=-1");
            dVar3.w(-1L);
        }
    }

    private d hf(g gVar, e eVar) {
        while (!this.am.isEmpty()) {
            d poll = this.am.poll();
            if (poll != null) {
                xj(this.qt, poll, true);
                if (xj(poll) > 0 || this.g <= 0) {
                    return poll;
                }
            }
        }
        g();
        d w = w(gVar, eVar);
        if (w != null && xj(w) > 0) {
            xj(this.qt, w, true);
            return w;
        }
        d zg = zg();
        if (zg != null) {
            return zg;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.y.y
    public void hf(g gVar, d dVar) {
        synchronized (this) {
            kd(gVar, dVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.w.xj
    public void xj(String str, List<InetAddress> list) {
        List<e> list2;
        if (this.c || this.y) {
            return;
        }
        try {
            list2 = w(str, list);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.pl.xj(th);
            list2 = null;
        }
        synchronized (this) {
            if (list2 != null) {
                try {
                    hf(str, list2);
                } finally {
                }
            }
            this.f13862pl = false;
            this.hf.xj(this.d.size());
            com.bytedance.sdk.component.utils.pl.xj("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
            kd();
        }
    }

    @Override // com.ss.android.socialbase.downloader.y.y
    public void hf(g gVar) {
        com.ss.android.socialbase.downloader.w.xj.w("SegmentDispatcher", "onReaderExit: threadIndex = " + gVar.w);
        synchronized (this) {
            try {
                gVar.w(true);
                this.f.remove(gVar);
                g();
                if (!this.f.isEmpty()) {
                    if (am()) {
                        com.bytedance.sdk.component.utils.pl.xj("SegmentDispatcher", "onReaderExit: allContentDownloaded");
                        Iterator<g> it = this.f.iterator();
                        while (it.hasNext()) {
                            it.next().kd();
                        }
                    }
                }
                p();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.y.y
    public void w(g gVar, d dVar) {
        synchronized (this) {
            try {
                if (dVar.xj == gVar) {
                    com.ss.android.socialbase.downloader.w.xj.w("SegmentDispatcher", "unApplySegment ".concat(String.valueOf(dVar)));
                    dVar.u(gVar.u());
                    dVar.xj = null;
                    gVar.xj();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w(g gVar) {
        synchronized (this) {
            try {
                e u = u(gVar);
                if (u == null) {
                    return false;
                }
                return gVar.xj(u);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private int xj(String str) {
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(this.d.get(i).xj, str)) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.ss.android.socialbase.downloader.y.y
    public kd u(g gVar, d dVar) {
        kd xj;
        synchronized (this) {
            pl plVar = new pl(this.xj, this.w, dVar);
            this.kd.xj(plVar);
            xj = plVar.xj();
        }
        return xj;
    }

    private void xj(List<d> list, d dVar, boolean z) {
        long w = dVar.w();
        int size = list.size();
        int i = 0;
        while (i < size && w >= list.get(i).w()) {
            i++;
        }
        list.add(i, dVar);
        if (z) {
            dVar.xj(size);
        }
    }

    private void hf(g gVar, d dVar, e eVar, com.ss.android.socialbase.downloader.model.u uVar) {
        g gVar2 = dVar.xj;
        if (gVar2 != null && gVar2 != gVar) {
            throw new tf(1, "segment already has an owner");
        }
        if (gVar.f() == dVar.kd()) {
            if (!uVar.hf()) {
                if (dVar.kd() <= 0) {
                    com.ss.android.socialbase.downloader.w.xj.kd("SegmentDispatcher", "parseHttpResponse: segment.getCurrentOffsetRead = " + dVar.kd());
                    if (!uVar.xj()) {
                        throw new com.ss.android.socialbase.downloader.exception.hf(PluginConstants.ERROR_PLUGIN_DOWNLOAD, uVar.w, "2: response code error : " + uVar.w + " segment=" + dVar);
                    }
                } else {
                    throw new com.ss.android.socialbase.downloader.exception.hf(PluginConstants.ERROR_PLUGIN_DOWNLOAD, uVar.w, "1: response code error : " + uVar.w + " segment=" + dVar);
                }
            }
            if (eVar.u) {
                if (this.tf == null) {
                    this.tf = uVar;
                    synchronized (this.v) {
                        this.v.notify();
                    }
                    com.ss.android.socialbase.downloader.d.y yVar = this.u;
                    if (yVar != null) {
                        yVar.xj(eVar.xj, uVar.hf, dVar.kd());
                    }
                    long tf = uVar.tf();
                    if (tf > 0) {
                        for (d dVar2 : this.qt) {
                            if (dVar2.y() <= 0 || dVar2.y() > tf - 1) {
                                dVar2.w(tf - 1);
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            xj(uVar);
            if (this.p == null) {
                this.p = uVar;
                if (this.xj.getTotalBytes() <= 0) {
                    long tf2 = uVar.tf();
                    StringBuilder B2KMhB2 = CtFAbx.B2KMhB("checkSegmentHttpResponse:len=", tf2, ",url=");
                    B2KMhB2.append(eVar.xj);
                    com.ss.android.socialbase.downloader.w.xj.w("SegmentDispatcher", B2KMhB2.toString());
                    this.xj.setTotalBytes(tf2);
                }
                synchronized (this.v) {
                    this.v.notify();
                }
                return;
            }
            return;
        }
        throw new tf(5, "applySegment");
    }

    private e u(g gVar) {
        e eVar;
        Iterator<e> it = this.d.iterator();
        e eVar2 = null;
        while (true) {
            if (!it.hasNext()) {
                eVar = null;
                break;
            }
            eVar = it.next();
            if (eVar != gVar.hf && !eVar.u()) {
                if (eVar2 == null) {
                    eVar2 = eVar;
                }
                if (eVar.xj() <= 0) {
                    break;
                }
            }
        }
        if (this.hf.hf()) {
            if (eVar != null) {
                return eVar;
            }
            if (this.hf.w()) {
                return null;
            }
        }
        return eVar2;
    }

    private d w(g gVar, e eVar) {
        String str;
        int size = this.qt.size();
        long j = -1;
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            long xj = xj(i2, size);
            if (xj > j) {
                i = i2;
                j = xj;
            }
        }
        long c = this.hf.c();
        long d = this.hf.d();
        if (i < 0 || j <= c) {
            return null;
        }
        d dVar = this.qt.get(i);
        int am = this.qt.size() < this.f.size() ? 2 : this.hf.am();
        if (am == 1) {
            g gVar2 = dVar.xj;
            if (gVar2 != null) {
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = currentTimeMillis - 4000;
                long xj2 = gVar2.xj(j2, currentTimeMillis);
                long xj3 = gVar.xj(j2, currentTimeMillis);
                float f = (xj2 <= 0 || xj3 <= 0) ? -1.0f : xj3 / (xj2 + xj3);
                if (f == -1.0f) {
                    long hf = gVar2.hf();
                    long hf2 = gVar.hf();
                    if (hf > 0 && hf2 > 0) {
                        f = hf2 / (hf + hf2);
                    }
                }
                if (f > 0.0f) {
                    float f2 = f * 0.9f;
                    long j3 = (long) (j * f2);
                    if (j3 < c) {
                        j3 = c;
                    }
                    long j4 = (d <= 0 || j3 <= d) ? j3 : d;
                    long j5 = c / 2;
                    long j6 = j - j5;
                    if (j4 > j6) {
                        j4 = j6;
                    } else if (j4 < j5) {
                        j4 = j5;
                    }
                    d dVar2 = new d((j - j4) + dVar.kd(), dVar.y());
                    com.ss.android.socialbase.downloader.w.xj.w("SegmentDispatcher", "obtainSegment: parent = " + dVar + ", child = " + dVar2 + ", maxRemainBytes = " + j + ", childLength = " + j4 + ", ratio = " + f2 + ", threadIndex = " + gVar.w);
                    return dVar2;
                }
            }
            str = "SegmentDispatcher";
        } else {
            str = "SegmentDispatcher";
            if (am == 2) {
                long curBytes = this.g - this.xj.getCurBytes();
                float u = u(gVar, eVar);
                long j7 = (long) (curBytes * u);
                if (j7 < c) {
                    j7 = c;
                }
                if (d > 0 && j7 > d) {
                    j7 = d;
                }
                long j8 = c / 2;
                long j9 = j - j8;
                if (j7 > j9) {
                    j7 = j9;
                } else if (j7 < j8) {
                    j7 = j8;
                }
                d dVar3 = new d((j - j7) + dVar.kd(), dVar.y());
                com.ss.android.socialbase.downloader.w.xj.w(str, "obtainSegment: parent = " + dVar + ", child = " + dVar3 + ", maxRemainBytes = " + j + ", childLength = " + j7 + ", ratio = " + u + ", threadIndex = " + gVar.w);
                return dVar3;
            }
        }
        d dVar4 = new d((j / 2) + dVar.kd(), dVar.y());
        com.ss.android.socialbase.downloader.w.xj.w(str, "obtainSegment: parent = " + dVar + ",child = " + dVar4);
        return dVar4;
    }

    private void xj(e eVar) {
        g gVar = new g(this.xj, this, this.w, eVar, this.f.size());
        this.f.add(gVar);
        gVar.xj(com.ss.android.socialbase.downloader.downloader.w.e().submit(gVar));
    }

    private float u(g gVar, e eVar) {
        long hf = gVar.hf();
        int size = this.f.size();
        if (size <= 1) {
            size = this.hf.xj();
        }
        float f = 1.0f;
        if (hf <= 0) {
            float g = this.hf.g();
            if (g <= 0.0f || g >= 1.0f) {
                g = 1.0f / size;
            }
            if (gVar.w == 0) {
                return g;
            }
            if (size > 1) {
                f = 1.0f - g;
                size--;
            }
        } else {
            long qt = qt();
            if (qt > hf) {
                return hf / qt;
            }
        }
        return f / size;
    }

    @Override // com.ss.android.socialbase.downloader.y.y
    public void xj(g gVar) {
        if (this.ai) {
            com.ss.android.socialbase.downloader.w.xj.w("SegmentDispatcher", "onReaderRun, threadIndex = " + gVar.w);
        }
    }

    @Override // com.ss.android.socialbase.downloader.y.y
    public d xj(g gVar, e eVar) {
        if (this.y || this.c) {
            return null;
        }
        synchronized (this) {
            try {
                d hf = hf(gVar, eVar);
                if (hf != null) {
                    hf.f();
                    if (hf.tf() > 1) {
                        return new d(hf);
                    }
                }
                return hf;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.y.y
    public void xj(g gVar, d dVar) {
        synchronized (this) {
            dVar.d();
        }
    }

    @Override // com.ss.android.socialbase.downloader.y.y
    public void xj(g gVar, d dVar, e eVar, com.ss.android.socialbase.downloader.model.u uVar) {
        synchronized (this) {
            try {
                if (!this.y && !this.c) {
                    hf(gVar, dVar, eVar, uVar);
                    gVar.hf(false);
                    if (this.g <= 0) {
                        long totalBytes = this.xj.getTotalBytes();
                        this.g = totalBytes;
                        if (totalBytes <= 0) {
                            this.g = uVar.tf();
                        }
                        kd();
                    } else if (this.hf.y()) {
                        kd();
                    }
                } else {
                    throw new zg("connected");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.y.y
    public void xj(g gVar, e eVar, d dVar, BaseException baseException, int i, int i2) {
        boolean hf = com.ss.android.socialbase.downloader.tf.y.hf(baseException);
        int errorCode = baseException.getErrorCode();
        if (errorCode == 1047 || errorCode == 1074 || errorCode == 1055) {
            hf = true;
        }
        if (hf || i >= i2) {
            w(gVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.y.y
    public void xj(g gVar, e eVar, d dVar, BaseException baseException) {
        synchronized (this) {
            try {
                com.ss.android.socialbase.downloader.w.xj.kd("SegmentDispatcher", "onSegmentFailed: segment = " + dVar + ", e = " + baseException);
                gVar.hf(true);
                if (gVar.w == 0) {
                    this.e = baseException;
                }
                if (pl()) {
                    if (this.e == null) {
                        this.e = baseException;
                    }
                    this.ht = true;
                    xj(this.e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void hf() {
        com.ss.android.socialbase.downloader.w.xj.w("SegmentDispatcher", "pause1");
        this.c = true;
        synchronized (this) {
            try {
                Iterator<g> it = this.f.iterator();
                while (it.hasNext()) {
                    it.next().kd();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.kd.hf();
        this.w.w();
    }

    private void xj(BaseException baseException) {
        com.ss.android.socialbase.downloader.w.xj.kd("SegmentDispatcher", "onError, e = ".concat(String.valueOf(baseException)));
        this.e = baseException;
        this.w.w();
        synchronized (this) {
            try {
                Iterator<g> it = this.f.iterator();
                while (it.hasNext()) {
                    it.next().kd();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void hf(long j) {
        this.jk.xj(this.xj.getCurBytes(), j);
        Iterator<g> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().hf(j);
        }
    }

    private void xj(com.ss.android.socialbase.downloader.model.u uVar) {
        com.ss.android.socialbase.downloader.model.u uVar2 = this.tf;
        if (uVar2 == null && (uVar2 = this.p) == null) {
            return;
        }
        long tf = uVar.tf();
        long tf2 = uVar2.tf();
        if (tf != tf2) {
            StringBuilder B2KMhB2 = CtFAbx.B2KMhB("total len not equals,len=", tf, ",sLen=");
            B2KMhB2.append(tf2);
            B2KMhB2.append(",code=");
            B2KMhB2.append(uVar.w);
            B2KMhB2.append(",sCode=");
            B2KMhB2.append(uVar2.w);
            B2KMhB2.append(",range=");
            B2KMhB2.append(uVar.kd());
            B2KMhB2.append(",sRange = ");
            B2KMhB2.append(uVar2.kd());
            B2KMhB2.append(",url = ");
            B2KMhB2.append(uVar.xj);
            B2KMhB2.append(",sUrl=");
            B2KMhB2.append(uVar2.xj);
            String sb = B2KMhB2.toString();
            com.ss.android.socialbase.downloader.w.xj.kd("SegmentDispatcher", sb);
            if (tf > 0 && tf2 > 0) {
                throw new BaseException(1074, sb);
            }
        }
        String w = uVar.w();
        String w2 = uVar2.w();
        if (TextUtils.equals(w, w2)) {
            return;
        }
        String str = "etag not equals with main url, etag = " + w + ", mainEtag = " + w2;
        com.ss.android.socialbase.downloader.w.xj.kd("SegmentDispatcher", str);
        if (!TextUtils.isEmpty(w) && !TextUtils.isEmpty(w2) && !w.equalsIgnoreCase(w2)) {
            throw new BaseException(1074, str);
        }
    }

    public void xj() {
        com.ss.android.socialbase.downloader.w.xj.w("SegmentDispatcher", "cancel");
        this.y = true;
        synchronized (this) {
            try {
                Iterator<g> it = this.f.iterator();
                while (it.hasNext()) {
                    it.next().kd();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.kd.xj();
        this.w.w();
    }

    private int xj(long j) {
        int size = this.qt.size();
        for (int i = 0; i < size; i++) {
            d dVar = this.qt.get(i);
            if (dVar.w() == j) {
                return i;
            }
            if (dVar.w() > j) {
                return -1;
            }
        }
        return -1;
    }

    private long xj(int i, int i2) {
        d dVar = this.qt.get(i);
        long xj = xj(dVar);
        int i3 = i + 1;
        d dVar2 = i3 < i2 ? this.qt.get(i3) : null;
        if (dVar2 == null) {
            return xj;
        }
        long w = dVar2.w() - dVar.kd();
        return xj == -1 ? w : Math.min(xj, w);
    }

    private long xj(d dVar) {
        long hf = dVar.hf();
        if (hf == -1) {
            long j = this.g;
            if (j > 0) {
                return j - dVar.kd();
            }
        }
        return hf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g xj(boolean z, long j, long j2) {
        g gVar = null;
        for (g gVar2 : this.f) {
            if (gVar2.w != 0 || z) {
                if (gVar2.u > 0 && gVar2.kd <= 0 && j - gVar2.u > j2 && (gVar == null || gVar2.u < gVar.u)) {
                    gVar = gVar2;
                }
            }
        }
        return gVar;
    }

    private boolean xj(g gVar, long j, long j2, long j3, double d) {
        if (gVar.y <= 0) {
            return false;
        }
        long hf = this.jk.hf(j, j2);
        int size = this.f.size();
        long j4 = size > 0 ? hf / size : hf;
        long xj = gVar.xj(j, j2);
        if (xj >= j3 && xj >= j4 * d) {
            return false;
        }
        StringBuilder B2KMhB2 = CtFAbx.B2KMhB("isDownloadSpeedPoor: totalSpeed = ", hf, ", threadAvgSpeed = ");
        B2KMhB2.append(j4);
        B2KMhB2.append(", poorSpeed = ");
        B2KMhB2.append(j3);
        B2KMhB2.append(", speed = ");
        B2KMhB2.append(xj);
        B2KMhB2.append(",threadIndex = ");
        B2KMhB2.append(gVar.w);
        com.bytedance.sdk.component.utils.pl.xj("SegmentDispatcher", B2KMhB2.toString());
        return true;
    }

    private boolean xj(long j, long j2) {
        long j3 = j - j2;
        long hf = this.jk.hf(j3, j);
        int size = this.f.size();
        if (size > 0) {
            hf /= size;
        }
        g xj = xj(j3, j, (long) Math.max(10.0f, hf * this.f13861io), size / 2);
        if (xj != null) {
            w(xj);
            com.ss.android.socialbase.downloader.w.xj.u("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + xj.w);
            xj.y();
            return true;
        }
        g xj2 = xj(true, j, j2);
        if (xj2 == null) {
            return false;
        }
        w(xj2);
        com.ss.android.socialbase.downloader.w.xj.u("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + xj2.w);
        xj2.y();
        return true;
    }

    private g xj(long j, long j2, long j3, int i) {
        long j4 = Long.MAX_VALUE;
        int i2 = 0;
        g gVar = null;
        for (g gVar2 : this.f) {
            if (gVar2.y > 0) {
                int i3 = i2 + 1;
                if (gVar2.y < j) {
                    long xj = gVar2.xj(j, j2);
                    if (this.ai) {
                        StringBuilder B2KMhB2 = CtFAbx.B2KMhB("findPoorReadThread: speed = ", xj, ", threadIndex = ");
                        B2KMhB2.append(gVar2.w);
                        com.bytedance.sdk.component.utils.pl.xj("SegmentDispatcher", B2KMhB2.toString());
                    }
                    if (xj >= 0 && xj < j4) {
                        j4 = xj;
                        gVar = gVar2;
                    }
                }
                i2 = i3;
            }
        }
        if (gVar == null || i2 < i || j4 >= j3) {
            return null;
        }
        StringBuilder B2KMhB3 = CtFAbx.B2KMhB("findPoorReadThread: ----------- minSpeed = ", j4, ", threadIndex = ");
        B2KMhB3.append(gVar.w);
        com.ss.android.socialbase.downloader.w.xj.w("SegmentDispatcher", B2KMhB3.toString());
        return gVar;
    }
}
