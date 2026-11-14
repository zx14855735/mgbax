package com.kwad.framework.filedownloader.download;

import com.kuaishou.weapon.p0.g;
import com.kwad.framework.filedownloader.download.c;
import com.kwad.framework.filedownloader.download.e;
import com.kwad.framework.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.kwad.framework.filedownloader.exception.FileDownloadHttpException;
import com.kwad.framework.filedownloader.exception.FileDownloadNetworkPolicyException;
import com.kwad.framework.filedownloader.exception.FileDownloadOutOfSpaceException;
import com.kwad.framework.filedownloader.y;
import com.kwad.sdk.crash.utils.h;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class DownloadLaunchRunnable implements f, Runnable {
    private static final ThreadPoolExecutor arM = com.kwad.framework.filedownloader.f.b.bM("ConnectionBlock");
    private final int arA;
    private final com.kwad.framework.filedownloader.d.c arB;
    private final com.kwad.framework.filedownloader.d.b arC;
    private final boolean arD;
    private final boolean arE;
    private final y arF;
    private boolean arG;
    int arH;
    private final boolean arI;
    private final ArrayList<c> arJ;
    private e arK;
    private boolean arL;
    private boolean arN;
    private boolean arO;
    private boolean arP;
    private final AtomicBoolean arQ;
    private volatile boolean arR;
    private volatile Exception arS;
    private String arT;
    private long arU;
    private long arV;
    private long arW;
    private long arX;
    private final com.kwad.framework.filedownloader.b.a arw;
    private final d arz;
    private volatile boolean ne;

    public class DiscardSafely extends Throwable {
        private static final long serialVersionUID = 4243896780616180062L;

        public DiscardSafely() {
        }
    }

    public class RetryDirectly extends Throwable {
        private static final long serialVersionUID = -4127585119566978768L;

        public RetryDirectly() {
        }
    }

    public static class a {
        private com.kwad.framework.filedownloader.d.c arB;
        private y arF;
        private Integer arY;
        private Integer arZ;
        private com.kwad.framework.filedownloader.d.b ari;
        private Boolean asa;
        private Boolean asb;
        private Integer asc;

        public final a a(y yVar) {
            this.arF = yVar;
            return this;
        }

        public final a b(com.kwad.framework.filedownloader.d.b bVar) {
            this.ari = bVar;
            return this;
        }

        public final a e(com.kwad.framework.filedownloader.d.c cVar) {
            this.arB = cVar;
            return this;
        }

        public final a f(Integer num) {
            this.arY = num;
            return this;
        }

        public final a g(Integer num) {
            this.arZ = num;
            return this;
        }

        public final a h(Integer num) {
            this.asc = num;
            return this;
        }

        public final DownloadLaunchRunnable zW() {
            if (this.arB == null || this.arF == null || this.arY == null || this.arZ == null || this.asa == null || this.asb == null || this.asc == null) {
                throw new IllegalArgumentException();
            }
            return new DownloadLaunchRunnable(this.arB, this.ari, this.arF, this.arY.intValue(), this.arZ.intValue(), this.asa.booleanValue(), this.asb.booleanValue(), this.asc.intValue(), (byte) 0);
        }

        public final a a(Boolean bool) {
            this.asa = bool;
            return this;
        }

        public final a b(Boolean bool) {
            this.asb = bool;
            return this;
        }
    }

    static {
        PCJfOUj();
    }

    public /* synthetic */ DownloadLaunchRunnable(com.kwad.framework.filedownloader.d.c cVar, com.kwad.framework.filedownloader.d.b bVar, y yVar, int i, int i2, boolean z, boolean z2, int i3, byte b) {
        this(cVar, bVar, yVar, i, i2, z, z2, i3);
    }

    private static /* synthetic */ void PCJfOUj() {
        char[] charArray = "äèê©àæêâ©åèþ©ôïâëë©ÍéîÅõîãàâ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 135);
        }
        String str = new String(charArray);
        char[] charArray2 = "äëîéîó".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 135);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private void a(Map<String, List<String>> map, ConnectTask connectTask, com.kwad.framework.filedownloader.a.b bVar) {
        int id = this.arB.getId();
        int responseCode = bVar.getResponseCode();
        this.arO = responseCode == 206 || responseCode == 1;
        boolean z = responseCode == 200 || responseCode == 201 || responseCode == 0;
        String AE = this.arB.AE();
        String a2 = com.kwad.framework.filedownloader.f.f.a(id, bVar);
        if (responseCode != 412 && ((AE == null || AE.equals(a2) || !(z || this.arO)) && (!(responseCode == 201 && connectTask.zC()) && (responseCode != 416 || this.arB.AD() <= 0)))) {
            this.arT = connectTask.zD();
            if (!this.arO && !z) {
                throw new FileDownloadHttpException(responseCode, map, bVar.zv());
            }
            long b = com.kwad.framework.filedownloader.f.f.b(id, bVar);
            String a3 = this.arB.yj() ? com.kwad.framework.filedownloader.f.f.a(bVar, this.arB.getUrl()) : null;
            boolean z2 = b == -1;
            this.arP = z2;
            if (!z2) {
                b += this.arB.AD();
            }
            this.arz.a(this.arN && this.arO, b, a2, a3);
            return;
        }
        if (this.arN) {
            com.kwad.framework.filedownloader.f.d.d(this, "there is precondition failed on this request[%d] with old etag[%s]、new etag[%s]、response requestHttpCode is %d", Integer.valueOf(id), AE, a2, Integer.valueOf(responseCode));
        }
        this.arw.bX(this.arB.getId());
        com.kwad.framework.filedownloader.f.f.C(this.arB.getTargetFilePath(), this.arB.zV());
        this.arN = false;
        if (AE != null && AE.equals(a2)) {
            com.kwad.framework.filedownloader.f.d.d(this, "the old etag[%s] is the same to the new etag[%s], but the response status requestHttpCode is %d not Partial(206), so wo have to start this task from very beginning for task[%d]!", AE, a2, Integer.valueOf(responseCode), Integer.valueOf(id));
            a2 = null;
        }
        this.arB.Z(0L);
        this.arB.ab(0L);
        this.arB.bJ(a2);
        this.arB.AH();
        this.arw.a(id, this.arB.AE(), this.arB.AD(), this.arB.getTotal(), this.arB.AG());
        throw new RetryDirectly();
    }

    private void b(List<com.kwad.framework.filedownloader.d.a> list, long j) {
        int id = this.arB.getId();
        String AE = this.arB.AE();
        String str = this.arT;
        if (str == null) {
            str = this.arB.getUrl();
        }
        String zV = this.arB.zV();
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "fetch data with multiple connection(count: [%d]) for task[%d] totalLength[%d]", Integer.valueOf(list.size()), Integer.valueOf(id), Long.valueOf(j));
        }
        boolean z = this.arN;
        long j2 = 0;
        long j3 = 0;
        for (com.kwad.framework.filedownloader.d.a aVar : list) {
            long Az = aVar.AA() == j2 ? j - aVar.Az() : (aVar.AA() - aVar.Az()) + 1;
            j3 = (aVar.Az() - aVar.getStartOffset()) + j3;
            if (Az != j2) {
                c zX = new c.a().ce(id).i(Integer.valueOf(aVar.getIndex())).a(this).bE(str).bF(z ? AE : null).c(this.arC).bk(this.arE).b(new com.kwad.framework.filedownloader.download.a(aVar.getStartOffset(), aVar.Az(), aVar.AA(), Az)).bG(zV).zX();
                if (com.kwad.framework.filedownloader.f.d.atL) {
                    com.kwad.framework.filedownloader.f.d.c(this, "enable multiple connection: %s", aVar);
                }
                this.arJ.add(zX);
            } else if (com.kwad.framework.filedownloader.f.d.atL) {
                com.kwad.framework.filedownloader.f.d.c(this, "pass connection[%d-%d], because it has been completed", Integer.valueOf(aVar.getId()), Integer.valueOf(aVar.getIndex()));
            }
            j2 = 0;
        }
        if (j3 != this.arB.AD()) {
            com.kwad.framework.filedownloader.f.d.d(this, "correct the sofar[%d] from connection table[%d]", Long.valueOf(this.arB.AD()), Long.valueOf(j3));
            this.arB.Z(j3);
        }
        ArrayList arrayList = new ArrayList(this.arJ.size());
        Iterator<c> it = this.arJ.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (this.ne) {
                next.pause();
            } else {
                arrayList.add(Executors.callable(next));
            }
        }
        if (this.ne) {
            this.arB.d((byte) -2);
            return;
        }
        List<Future> invokeAll = arM.invokeAll(arrayList);
        if (com.kwad.framework.filedownloader.f.d.atL) {
            for (Future future : invokeAll) {
                com.kwad.framework.filedownloader.f.d.c(this, "finish sub-task for [%d] %B %B", Integer.valueOf(id), Boolean.valueOf(future.isDone()), Boolean.valueOf(future.isCancelled()));
            }
        }
    }

    private void d(long j, int i) {
        long j2 = j / i;
        int id = this.arB.getId();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        long j3 = 0;
        while (i2 < i) {
            long j4 = i2 == i + (-1) ? 0L : (j3 + j2) - 1;
            com.kwad.framework.filedownloader.d.a aVar = new com.kwad.framework.filedownloader.d.a();
            aVar.setId(id);
            aVar.setIndex(i2);
            aVar.setStartOffset(j3);
            aVar.X(j3);
            aVar.Y(j4);
            arrayList.add(aVar);
            this.arw.a(aVar);
            j3 += j2;
            i2++;
        }
        this.arB.co(i);
        this.arw.u(id, i);
        b(arrayList, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.kwad.framework.filedownloader.download.a r(java.util.List<com.kwad.framework.filedownloader.d.a> r21) {
        /*
            r20 = this;
            r0 = r20
            com.kwad.framework.filedownloader.d.c r1 = r0.arB
            int r1 = r1.AG()
            com.kwad.framework.filedownloader.d.c r2 = r0.arB
            java.lang.String r2 = r2.zV()
            com.kwad.framework.filedownloader.d.c r3 = r0.arB
            java.lang.String r3 = r3.getTargetFilePath()
            r4 = 0
            r5 = 1
            if (r1 <= r5) goto L1a
            r6 = 1
            goto L1b
        L1a:
            r6 = 0
        L1b:
            r7 = 0
            if (r6 == 0) goto L23
            boolean r9 = r0.arI
            if (r9 == 0) goto L54
        L23:
            com.kwad.framework.filedownloader.d.c r9 = r0.arB
            int r9 = r9.getId()
            com.kwad.framework.filedownloader.d.c r10 = r0.arB
            boolean r9 = com.kwad.framework.filedownloader.f.f.b(r9, r10)
            if (r9 == 0) goto L54
            boolean r9 = r0.arI
            if (r9 != 0) goto L40
            java.io.File r1 = new java.io.File
            r1.<init>(r2)
            long r9 = r1.length()
        L3e:
            r14 = r9
            goto L55
        L40:
            if (r6 == 0) goto L4d
            int r6 = r21.size()
            if (r1 != r6) goto L54
            long r9 = com.kwad.framework.filedownloader.d.a.s(r21)
            goto L3e
        L4d:
            com.kwad.framework.filedownloader.d.c r1 = r0.arB
            long r9 = r1.AD()
            goto L3e
        L54:
            r14 = r7
        L55:
            com.kwad.framework.filedownloader.d.c r1 = r0.arB
            r1.Z(r14)
            int r1 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r1 <= 0) goto L5f
            r4 = 1
        L5f:
            r0.arN = r4
            if (r4 != 0) goto L71
            com.kwad.framework.filedownloader.b.a r1 = r0.arw
            com.kwad.framework.filedownloader.d.c r4 = r0.arB
            int r4 = r4.getId()
            r1.bX(r4)
            com.kwad.framework.filedownloader.f.f.C(r3, r2)
        L71:
            com.kwad.framework.filedownloader.download.a r11 = new com.kwad.framework.filedownloader.download.a
            com.kwad.framework.filedownloader.d.c r1 = r0.arB
            long r1 = r1.getTotal()
            long r18 = r1 - r14
            r12 = 0
            r16 = 0
            r11.<init>(r12, r14, r16, r18)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.DownloadLaunchRunnable.r(java.util.List):com.kwad.framework.filedownloader.download.a");
    }

    private boolean zR() {
        return (!this.arN || this.arB.AG() > 1) && this.arO && this.arI && !this.arP;
    }

    private void zT() {
        if (this.arE && !com.kwad.framework.filedownloader.f.f.bT(g.b)) {
            throw new FileDownloadGiveUpRetryException(com.kwad.framework.filedownloader.f.f.c("Task[%d] can't start the download runnable, because this task require wifi, but user application nor current process has %s, so we can't check whether the network type connection.", Integer.valueOf(this.arB.getId()), g.b));
        }
        if (this.arE && com.kwad.framework.filedownloader.f.f.Bk()) {
            throw new FileDownloadNetworkPolicyException();
        }
    }

    private void zU() {
        int id = this.arB.getId();
        if (this.arB.yj()) {
            String targetFilePath = this.arB.getTargetFilePath();
            int B = com.kwad.framework.filedownloader.f.f.B(this.arB.getUrl(), targetFilePath);
            if (com.kwad.framework.filedownloader.f.c.a(id, targetFilePath, this.arD, false)) {
                this.arw.bY(id);
                this.arw.bX(id);
                throw new DiscardSafely();
            }
            com.kwad.framework.filedownloader.d.c bV = this.arw.bV(B);
            if (bV != null) {
                if (com.kwad.framework.filedownloader.f.c.a(id, bV, this.arF, false)) {
                    this.arw.bY(id);
                    this.arw.bX(id);
                    throw new DiscardSafely();
                }
                List<com.kwad.framework.filedownloader.d.a> bW = this.arw.bW(B);
                this.arw.bY(B);
                this.arw.bX(B);
                com.kwad.framework.filedownloader.f.f.bX(this.arB.getTargetFilePath());
                if (com.kwad.framework.filedownloader.f.f.b(B, bV)) {
                    this.arB.Z(bV.AD());
                    this.arB.ab(bV.getTotal());
                    this.arB.bJ(bV.AE());
                    this.arB.co(bV.AG());
                    this.arw.b(this.arB);
                    if (bW != null) {
                        for (com.kwad.framework.filedownloader.d.a aVar : bW) {
                            aVar.setId(id);
                            this.arw.a(aVar);
                        }
                    }
                    throw new RetryDirectly();
                }
            }
            if (com.kwad.framework.filedownloader.f.c.a(id, this.arB.AD(), this.arB.zV(), targetFilePath, this.arF)) {
                this.arw.bY(id);
                this.arw.bX(id);
                throw new DiscardSafely();
            }
        }
    }

    public final int getId() {
        return this.arB.getId();
    }

    public final boolean isAlive() {
        return this.arQ.get() || this.arz.isAlive();
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void onProgress(long j) {
        if (this.ne) {
            return;
        }
        this.arz.onProgress(j);
    }

    public final void pause() {
        this.ne = true;
        e eVar = this.arK;
        if (eVar != null) {
            eVar.pause();
        }
        Iterator it = ((ArrayList) this.arJ.clone()).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null) {
                cVar.pause();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:164:0x00a0, code lost:
    
        if (com.kwad.framework.filedownloader.f.d.atL == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x00a2, code lost:
    
        com.kwad.framework.filedownloader.f.d.c(r15, "High concurrent cause, start runnable but already paused %d", java.lang.Integer.valueOf(r15.arB.getId()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x00b3, code lost:
    
        r15.arz.zY();
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x00ba, code lost:
    
        if (r15.ne == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x00bf, code lost:
    
        if (r15.arR == false) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x00c2, code lost:
    
        r15.arz.Ad();
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x00c8, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0120, code lost:
    
        if (r15.ne == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0122, code lost:
    
        r15.arB.d((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0127, code lost:
    
        if (r7 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0129, code lost:
    
        r7.zw();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x012c, code lost:
    
        r15.arz.zY();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0133, code lost:
    
        if (r15.ne == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0139, code lost:
    
        if (r15.arR == false) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x013d, code lost:
    
        r15.arz.Ad();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0144, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x015e, code lost:
    
        zU();
        r13 = r15.arB.getTotal();
        a(r13, r15.arB.zV());
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0174, code lost:
    
        if (zR() == false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0178, code lost:
    
        if (r15.arN == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x017a, code lost:
    
        r8 = r15.arB.AG();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x019d, code lost:
    
        if (r8 <= 0) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01a1, code lost:
    
        if (r15.ne == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01a3, code lost:
    
        r15.arB.d((byte) -2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01a8, code lost:
    
        if (r7 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01aa, code lost:
    
        r7.zw();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01ad, code lost:
    
        r15.arz.zY();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01b4, code lost:
    
        if (r15.ne == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01ba, code lost:
    
        if (r15.arR == false) goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01be, code lost:
    
        r15.arz.Ad();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01c5, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01c8, code lost:
    
        if (r8 != 1) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01ca, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01cd, code lost:
    
        r15.arL = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01cf, code lost:
    
        if (r9 == false) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01d1, code lost:
    
        a(r6.zE(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0204, code lost:
    
        if (r7 == null) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0206, code lost:
    
        r7.zw();
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01d9, code lost:
    
        if (r7 == null) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01db, code lost:
    
        r7.zw();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01e0, code lost:
    
        r15.arz.Ab();
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01e7, code lost:
    
        if (r15.arN == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01e9, code lost:
    
        a(r8, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0203, code lost:
    
        r7 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0200, code lost:
    
        d(r13, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01df, code lost:
    
        r5 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01cc, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0219, code lost:
    
        throw new java.lang.IllegalAccessException(com.kwad.framework.filedownloader.f.f.c("invalid connection count %d, the connection count must be larger than 0", r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0181, code lost:
    
        r8 = com.kwad.framework.filedownloader.download.b.zG().a(r15.arB.getId(), r15.arB.getUrl(), r15.arB.getPath(), r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x019c, code lost:
    
        r8 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0251 A[Catch: all -> 0x01ed, TryCatch #2 {all -> 0x01ed, blocks: (B:36:0x00cf, B:87:0x01e0, B:89:0x01e9, B:91:0x0200, B:121:0x024b, B:123:0x0251, B:129:0x0259, B:111:0x021e), top: B:120:0x024b }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0259 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0264 A[Catch: all -> 0x0030, TryCatch #5 {all -> 0x0030, blocks: (B:3:0x0004, B:6:0x0012, B:8:0x001a, B:10:0x001e, B:25:0x0034, B:26:0x0091, B:28:0x0095, B:30:0x009a, B:163:0x009e, B:165:0x00a2, B:32:0x00ca, B:42:0x0129, B:61:0x01aa, B:76:0x0206, B:135:0x0264, B:136:0x0267, B:101:0x022d, B:114:0x0226, B:131:0x025e), top: B:2:0x0004 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 688
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.framework.filedownloader.download.DownloadLaunchRunnable.run():void");
    }

    public final void zQ() {
        if (this.arB.AG() > 1) {
            List<com.kwad.framework.filedownloader.d.a> bW = this.arw.bW(this.arB.getId());
            if (this.arB.AG() == bW.size()) {
                this.arB.Z(com.kwad.framework.filedownloader.d.a.s(bW));
            } else {
                this.arB.Z(0L);
                this.arw.bX(this.arB.getId());
            }
        }
        this.arz.zZ();
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void zS() {
        this.arw.b(this.arB.getId(), this.arB.AD());
    }

    public final String zV() {
        return this.arB.zV();
    }

    private DownloadLaunchRunnable(com.kwad.framework.filedownloader.d.c cVar, com.kwad.framework.filedownloader.d.b bVar, y yVar, int i, int i2, boolean z, boolean z2, int i3) {
        this.arA = 5;
        this.arJ = new ArrayList<>(5);
        this.arU = 0L;
        this.arV = 0L;
        this.arW = 0L;
        this.arX = 0L;
        this.arQ = new AtomicBoolean(true);
        this.ne = false;
        this.arG = false;
        this.arB = cVar;
        this.arC = bVar;
        this.arD = z;
        this.arE = z2;
        this.arw = b.zG().zI();
        this.arI = b.zG().zK();
        this.arF = yVar;
        this.arH = i3;
        this.arz = new d(cVar, i3, i, i2);
    }

    private void a(com.kwad.framework.filedownloader.download.a aVar, com.kwad.framework.filedownloader.a.b bVar) {
        if (!this.arO) {
            this.arB.Z(0L);
            aVar = new com.kwad.framework.filedownloader.download.a(0L, 0L, aVar.arr, aVar.contentLength);
        }
        e.a aVar2 = new e.a();
        aVar2.b(this).ch(this.arB.getId()).cg(-1).bm(this.arE).d(bVar).c(aVar).bH(this.arB.zV());
        this.arB.co(1);
        this.arw.u(this.arB.getId(), 1);
        this.arK = aVar2.Ak();
        if (this.ne) {
            this.arB.d((byte) -2);
            this.arK.pause();
        } else {
            this.arK.run();
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void b(Exception exc) {
        this.arR = true;
        this.arS = exc;
        if (this.ne) {
            if (com.kwad.framework.filedownloader.f.d.atL) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the error callback", Integer.valueOf(this.arB.getId()));
            }
        } else {
            Iterator it = ((ArrayList) this.arJ.clone()).iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar != null) {
                    cVar.zc();
                }
            }
        }
    }

    private void a(int i, List<com.kwad.framework.filedownloader.d.a> list) {
        if (i > 1 && list.size() == i) {
            b(list, this.arB.getTotal());
            return;
        }
        throw new IllegalArgumentException();
    }

    private void a(long j, String str) {
        com.kwad.framework.filedownloader.e.a aVar = null;
        if (j != -1) {
            try {
                aVar = com.kwad.framework.filedownloader.f.f.bV(this.arB.zV());
                long length = new File(str).length();
                long j2 = j - length;
                long availableBytes = h.getAvailableBytes(str);
                if (availableBytes >= j2) {
                    if (!com.kwad.framework.filedownloader.f.e.Bf().atR) {
                        aVar.setLength(j);
                    }
                } else {
                    throw new FileDownloadOutOfSpaceException(availableBytes, j2, length);
                }
            } finally {
            }
        }
        if (aVar != null) {
            aVar.close();
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void a(c cVar, long j, long j2) {
        if (this.ne) {
            if (com.kwad.framework.filedownloader.f.d.atL) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the completed callback", Integer.valueOf(this.arB.getId()));
                return;
            }
            return;
        }
        int i = cVar == null ? -1 : cVar.asg;
        if (com.kwad.framework.filedownloader.f.d.atL) {
            com.kwad.framework.filedownloader.f.d.c(this, "the connection has been completed(%d): [%d, %d)  %d", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.arB.getTotal()));
        }
        if (!this.arL) {
            synchronized (this.arJ) {
                this.arJ.remove(cVar);
            }
        } else {
            if (j == 0 || j2 == this.arB.getTotal()) {
                return;
            }
            com.kwad.framework.filedownloader.f.d.a(this, "the single task not completed corrected(%d, %d != %d) for task(%d)", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(this.arB.getTotal()), Integer.valueOf(this.arB.getId()));
        }
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final boolean a(Exception exc) {
        if (exc instanceof FileDownloadHttpException) {
            int code = ((FileDownloadHttpException) exc).getCode();
            if (this.arL && code == 416 && !this.arG) {
                com.kwad.framework.filedownloader.f.f.C(this.arB.getTargetFilePath(), this.arB.zV());
                this.arG = true;
                return true;
            }
        }
        return this.arH > 0 && !(exc instanceof FileDownloadGiveUpRetryException);
    }

    @Override // com.kwad.framework.filedownloader.download.f
    public final void a(Exception exc, long j) {
        if (this.ne) {
            if (com.kwad.framework.filedownloader.f.d.atL) {
                com.kwad.framework.filedownloader.f.d.c(this, "the task[%d] has already been paused, so pass the retry callback", Integer.valueOf(this.arB.getId()));
            }
        } else {
            int i = this.arH;
            int i2 = i - 1;
            this.arH = i2;
            if (i < 0) {
                com.kwad.framework.filedownloader.f.d.a(this, "valid retry times is less than 0(%d) for download task(%d)", Integer.valueOf(i2), Integer.valueOf(this.arB.getId()));
            }
            this.arz.a(exc, this.arH, j);
        }
    }
}
