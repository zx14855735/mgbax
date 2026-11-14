package com.bytedance.embedapplog;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.embedapplog.collector.Collector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class a implements Handler.Callback, Comparator<vl> {
    private static long g;
    private static a hf;
    private aq c;
    private ws d;
    private Handler f;
    private final ArrayList<vl> kd = new ArrayList<>(32);
    private Handler p;

    /* renamed from: pl, reason: collision with root package name */
    private b f10099pl;
    private com.bytedance.embedapplog.util.xj tf;
    private wn u;
    private en w;
    public Application xj;
    private h y;

    private a() {
    }

    private void p() {
        if (cu.hf) {
            cu.xj("packAndSend once, " + this.d.xj() + ", hadUI:" + this.d.hf(), null);
        }
        b bVar = this.f10099pl;
        if (bVar != null) {
            bVar.f();
        }
        if (this.f != null) {
            this.f10099pl.xj(no.xj());
            this.f.sendMessage(this.p.obtainMessage(6, this.f10099pl));
        }
    }

    private void tf() {
        if (this.u.ht()) {
            if (this.w == null) {
                en enVar = new en(this);
                this.w = enVar;
                this.f.obtainMessage(6, enVar).sendToTarget();
                return;
            }
            return;
        }
        en enVar2 = this.w;
        if (enVar2 != null) {
            enVar2.kd();
            this.w = null;
        }
    }

    public static void xj() {
        if (hf != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - g) > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                g = currentTimeMillis;
                hf.xj((String[]) null, true);
            }
        }
    }

    public static a y() {
        if (hf == null) {
            synchronized (a.class) {
                try {
                    if (hf == null) {
                        hf = new a();
                    }
                } finally {
                }
            }
        }
        return hf;
    }

    public ws c() {
        return this.d;
    }

    public void d() {
        Handler handler = this.p;
        if (handler == null || handler.hasMessages(89)) {
            return;
        }
        this.p.sendEmptyMessage(89);
    }

    public com.bytedance.embedapplog.util.xj f() {
        if (this.tf == null) {
            com.bytedance.embedapplog.util.xj p = this.u.hl().p();
            this.tf = p;
            if (p == null) {
                this.tf = com.bytedance.embedapplog.util.hf.xj(0);
            }
        }
        return this.tf;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i;
        try {
            i = message.what;
        } catch (Throwable th) {
            cu.xj("engine:" + th.getMessage());
        }
        if (i == 1) {
            cu.xj = this.u.ra();
            if (!this.c.y()) {
                this.p.removeMessages(1);
                this.p.sendEmptyMessageDelayed(1, 1000L);
            } else if (this.u.yo()) {
                Looper hf2 = no.hf(this.u);
                if (hf2 == null) {
                    HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
                    handlerThread.start();
                    hf2 = handlerThread.getLooper();
                }
                Handler handler = new Handler(hf2, this);
                this.f = handler;
                handler.sendEmptyMessage(2);
                if (this.kd.size() > 0) {
                    this.p.removeMessages(4);
                    this.p.sendEmptyMessageDelayed(4, 1000L);
                }
                cu.u("net|worker start", null);
            }
            tj.xj();
            return true;
        }
        if (i == 2) {
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(new r(this));
            arrayList.add(new ff(this));
            b bVar = new b(this);
            this.f10099pl = bVar;
            arrayList.add(bVar);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                if (lVar instanceof b) {
                    this.f10099pl.xj(no.xj());
                }
                long c = lVar.c();
                if (c < 864000000) {
                    this.f.sendMessageDelayed(this.p.obtainMessage(6, lVar), c);
                }
            }
            this.f10099pl.xj(true);
            tf();
            return true;
        }
        if (i == 4) {
            xj((String[]) null, false);
            return true;
        }
        if (i == 5) {
            xj((String[]) message.obj, false);
            return true;
        }
        if (i == 6) {
            l lVar2 = (l) message.obj;
            if (!lVar2.y()) {
                long c2 = lVar2.c();
                if (c2 < 864000000) {
                    this.f.sendMessageDelayed(this.p.obtainMessage(6, lVar2), c2);
                }
                tf();
            }
            this.f10099pl.xj(true);
            return true;
        }
        if (i == 7) {
            synchronized (this.kd) {
                this.kd.add(ws.kd());
            }
            xj((String[]) null, false);
            return true;
        }
        if (i != 89) {
            cu.hf((Throwable) null);
            return true;
        }
        aq aqVar = this.c;
        if (aqVar != null) {
            aqVar.kd();
            return true;
        }
        return true;
    }

    public Context hf() {
        return this.xj;
    }

    public aq kd() {
        return this.c;
    }

    public wn u() {
        return this.u;
    }

    public h w() {
        return this.y;
    }

    public void xj(Application application, wn wnVar, aq aqVar, yo yoVar) {
        this.xj = application;
        this.y = new h(this);
        this.u = wnVar;
        this.c = aqVar;
        this.d = new ws(this.c, this.u);
        this.xj.registerActivityLifecycleCallbacks(yoVar);
        Looper xj = no.xj(wnVar);
        if (xj == null) {
            HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
            handlerThread.start();
            xj = handlerThread.getLooper();
        }
        Handler handler = new Handler(xj, this);
        this.p = handler;
        handler.sendEmptyMessage(1);
        my.xj(wnVar.d() != 0);
    }

    private void xj(String[] strArr, boolean z) {
        ArrayList<vl> arrayList;
        synchronized (this.kd) {
            arrayList = (ArrayList) this.kd.clone();
            this.kd.clear();
        }
        int i = 0;
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            for (String str : strArr) {
                arrayList.add(vl.xj(str));
            }
        }
        boolean xj = this.u.xj(arrayList);
        if (arrayList.size() > 0) {
            if (this.u.yo()) {
                if (!xj && arrayList.size() <= 100) {
                    synchronized (this.kd) {
                        this.kd.addAll(arrayList);
                    }
                    return;
                }
                Collections.sort(arrayList, this);
                ArrayList<vl> arrayList2 = new ArrayList<>(arrayList.size());
                Iterator<vl> it = arrayList.iterator();
                boolean z2 = false;
                boolean z3 = false;
                while (it.hasNext()) {
                    vl next = it.next();
                    z2 |= this.d.xj(next, arrayList2);
                    if (next instanceof k) {
                        z3 = ws.xj(next);
                        i = 1;
                    }
                }
                this.y.xj(arrayList2);
                if (i != 0) {
                    if (z3) {
                        this.p.removeMessages(7);
                    } else if (!no.hf() && no.xj()) {
                        this.p.sendEmptyMessageDelayed(7, this.u.dk());
                    }
                }
                if (z2 || z) {
                    p();
                    return;
                }
                return;
            }
            Intent intent = new Intent(this.xj, (Class<?>) Collector.class);
            int size = arrayList.size();
            String[] strArr2 = new String[size];
            int i2 = 0;
            while (i < size) {
                String jSONObject = arrayList.get(i).kd().toString();
                strArr2[i] = jSONObject;
                i2 += jSONObject.length();
                i++;
            }
            if (i2 >= 307200) {
                cu.hf((Throwable) null);
            }
            intent.putExtra("EMBED_K_DATA", strArr2);
            try {
                this.xj.sendBroadcast(intent);
            } catch (Exception e) {
                cu.hf(e);
            }
        }
    }

    public static void xj(vl vlVar) {
        int size;
        Handler handler;
        a aVar = hf;
        if (aVar == null) {
            cu.hf("Init comes First!", null);
            tj.xj(vlVar);
            return;
        }
        if (vlVar.hf == 0) {
            cu.hf((Throwable) null);
        }
        synchronized (aVar.kd) {
            size = aVar.kd.size();
            aVar.kd.add(vlVar);
        }
        if (size % 10 != 0 || (handler = aVar.p) == null) {
            return;
        }
        handler.removeMessages(4);
        aVar.p.sendEmptyMessageDelayed(4, size == 0 ? 500L : 250L);
    }

    public static void xj(String[] strArr) {
        a aVar = hf;
        if (aVar == null) {
            cu.hf(new RuntimeException("Init comes First!"));
            return;
        }
        Handler handler = aVar.p;
        if (handler != null) {
            handler.removeMessages(4);
            aVar.p.obtainMessage(5, strArr).sendToTarget();
        }
    }

    @Override // java.util.Comparator
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public int compare(vl vlVar, vl vlVar2) {
        long j = vlVar.hf - vlVar2.hf;
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }
}
