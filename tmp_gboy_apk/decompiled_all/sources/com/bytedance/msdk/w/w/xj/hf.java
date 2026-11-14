package com.bytedance.msdk.w.w.xj;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.core.u.u;
import com.bytedance.msdk.f.j;
import com.bytedance.msdk.f.jk;
import com.bytedance.msdk.f.q;
import com.bytedance.msdk.w.w.xj.xj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf implements com.bytedance.msdk.w.hf.hf.xj, xj {
    private String c;
    private List<Integer> d;
    private com.bytedance.msdk.api.xj.hf f;
    protected com.bytedance.msdk.w.y.xj.xj hf;
    private com.bytedance.msdk.w.y.xj.hf kd;
    private com.bytedance.msdk.w.c.hf.xj p;
    private Handler tf;
    protected long u;
    Map<Integer, List<com.bytedance.msdk.core.tf.tf>> xj;
    private com.bytedance.msdk.core.tf.hf y;
    protected final List<com.bytedance.msdk.core.tf.tf> w = new CopyOnWriteArrayList();

    /* renamed from: pl, reason: collision with root package name */
    private boolean f10165pl = false;

    public hf() {
        Looper hf = com.bytedance.msdk.xj.kd.y.hf();
        if (hf != null) {
            this.tf = new Handler(hf) { // from class: com.bytedance.msdk.w.w.xj.hf.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    hf.this.xj(message);
                }
            };
        } else {
            com.bytedance.msdk.xj.kd.y.xj();
            this.tf = new Handler(com.bytedance.msdk.xj.kd.y.hf()) { // from class: com.bytedance.msdk.w.w.xj.hf.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    hf.this.xj(message);
                }
            };
        }
    }

    private void u(int i) {
        if (this.kd.xj() || kd()) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "已经触发过成功、失败回调...");
            return;
        }
        if (this.kd.y()) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "已经触发过destroy操作...");
            return;
        }
        if (hf()) {
            return;
        }
        if (i >= this.d.size()) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "第 " + i + " 层没有广告可以请求...");
            return;
        }
        Integer num = this.d.get(i);
        int intValue = num.intValue();
        if (this.hf.w(intValue)) {
            w(i + 1);
            return;
        }
        if (com.bytedance.msdk.w.f.c.hf(intValue) && this.hf.hf() == -1) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "开启serverBidding exchange 请求....");
            xj(this.xj.get(num));
            xj(i);
            return;
        }
        this.hf.hf(intValue);
        xj(intValue, i);
        if (com.bytedance.msdk.w.f.c.w(intValue) || com.bytedance.msdk.w.f.c.hf(intValue)) {
            com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "第 " + i + "层 ClientBidding,ServerBidding 广告，levelSort：" + intValue + "，同时请求下一层广告...");
            w(i + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(int i) {
        if (i < 0) {
            return;
        }
        if (!com.bytedance.msdk.w.f.c.xj(i, this.d)) {
            u(i);
            return;
        }
        int dc = this.y.dc();
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "the " + i + " level is first level normal ad and ParallelNum:" + dc);
        for (int i2 = 0; i2 < dc; i2++) {
            u(i + i2);
        }
    }

    public boolean kd() {
        if (this.kd.hf()) {
            return (this.f10165pl && com.bytedance.msdk.f.hf.xj.xj(this.y)) ? false : true;
        }
        return false;
    }

    @Override // com.bytedance.msdk.w.w.xj.xj
    public void hf(xj.InterfaceC0086xj interfaceC0086xj) {
        ((com.bytedance.msdk.core.u.y) com.bytedance.msdk.core.u.kd.xj()).xj(this.kd.a(), this.u, this.f, this.y, new u.xj() { // from class: com.bytedance.msdk.w.w.xj.hf.3
            @Override // com.bytedance.msdk.core.u.u.xj
            public void xj(com.bytedance.msdk.core.u.hf hfVar) {
                Map<Integer, List<com.bytedance.msdk.core.tf.tf>> map = hf.this.xj;
                List<com.bytedance.msdk.core.tf.tf> list = map != null ? map.get(0) : null;
                hf hfVar2 = hf.this;
                hfVar2.xj(hfVar2.f, list, hfVar);
            }
        });
    }

    public boolean hf() {
        return hf(null, 3);
    }

    public boolean hf(com.bytedance.msdk.core.tf.tf tfVar, int i) {
        if (this.kd.xj() || kd()) {
            return true;
        }
        if (this.hf.kd()) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "触发总超时或全部代码位响应结束.....totalTimeout：" + this.hf.kd() + "  allWtfFinish:" + this.hf.f());
            if (q.xj(this.kd.c()) && q.xj(this.kd.f()) && q.xj(this.kd.tf())) {
                if (com.bytedance.msdk.f.hf.xj.hf(this.y)) {
                    com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "总加载时间超时.......isCallback:true");
                    if (com.bytedance.msdk.f.hf.xj.xj(this.kd, this.d, this.xj)) {
                        w();
                        return true;
                    }
                }
                this.f10165pl = true;
                xj(new com.bytedance.msdk.api.xj(AVMDLDataLoader.KeyIsStoRingBufferSizeKB, com.bytedance.msdk.api.xj.xj(AVMDLDataLoader.KeyIsStoRingBufferSizeKB)));
            } else {
                w();
            }
            return true;
        }
        if (this.hf.f()) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "全部广告完成响应...");
            if (q.xj(this.kd.c()) && q.xj(this.kd.f()) && q.xj(this.kd.tf())) {
                xj(new com.bytedance.msdk.api.xj(20005, com.bytedance.msdk.api.xj.xj(20005)));
            } else {
                w();
            }
            return true;
        }
        if (this.kd.am()) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "p层广告已经满足返回条件...");
            w();
            return true;
        }
        if (!(this.y.z() && this.hf.w()) && this.y.z()) {
            return false;
        }
        if (tfVar == null) {
            if (this.kd.qt() && this.kd.e()) {
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "p层&普通层广告 已经满足返回条件 V1 .........");
                w();
                return true;
            }
            if (!this.kd.zg() || !this.hf.d() || !this.hf.tf() || !this.kd.yo()) {
                return false;
            }
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "p层&普通&Bidding层广告 已经满足返回条件 V2 .........");
            w();
            return true;
        }
        if (this.kd.qt() && this.kd.e()) {
            Iterator<com.bytedance.msdk.hf.w> it = this.kd.f().iterator();
            while (it.hasNext()) {
                com.bytedance.msdk.hf.w next = it.next();
                com.bytedance.msdk.w.c.xj.xj xj = com.bytedance.msdk.w.c.xj.u.xj(this.y);
                com.bytedance.msdk.w.y.xj.hf hfVar = this.kd;
                Map<Integer, List<com.bytedance.msdk.core.tf.tf>> map = this.xj;
                if (xj.xj(hfVar, next, map == null ? null : map.get(Integer.valueOf(com.bytedance.msdk.w.f.c.xj(this.y, next))))) {
                    com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "p层&普通层广告 已经满足返回条件 V3 .........");
                    w();
                    return true;
                }
            }
            return false;
        }
        if (!this.kd.zg() || !this.hf.d() || !this.hf.tf() || !this.kd.yo()) {
            return false;
        }
        com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "p层&普通&Bidding层广告 已经满足返回条件 V4 .........");
        w();
        return true;
    }

    @Override // com.bytedance.msdk.w.w.xj.xj
    public void xj(xj.InterfaceC0086xj interfaceC0086xj) {
        com.bytedance.msdk.w.y.xj.hf xj = interfaceC0086xj.xj();
        this.kd = xj;
        xj.xj(this.tf);
        this.hf = this.kd.g();
        this.y = this.kd.pl();
        com.bytedance.msdk.api.xj.hf v = this.kd.v();
        this.f = v;
        this.c = v.ra();
        this.xj = this.y.io();
        ArrayList arrayList = new ArrayList();
        this.d = arrayList;
        arrayList.addAll(this.xj.keySet());
        com.bytedance.msdk.core.c.hf.xj(this.d);
        this.hf.xj(this.d);
        this.hf.c(this.y.ra());
        List<com.bytedance.msdk.core.tf.tf> xj2 = com.bytedance.msdk.w.f.c.xj(this.y.yy());
        List<com.bytedance.msdk.core.tf.tf> hf = com.bytedance.msdk.w.f.c.hf(this.y.yy());
        this.hf.f(xj2 == null ? 0 : xj2.size());
        this.hf.d(hf == null ? 0 : hf.size());
        Handler handler = this.tf;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(6, this.y.b());
        }
        if (!this.kd.ht()) {
            com.bytedance.msdk.kd.y.xj(this.f, this.y.hl(), !this.kd.ra(), this.kd.ff().xj, 0, (Map<String, Object>) null);
        }
        if (this.y.g()) {
            interfaceC0086xj.xj(interfaceC0086xj.xj());
        } else {
            if (com.bytedance.msdk.xj.kd.w.hf()) {
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "开始加载广告 num:" + this.y.ra());
            }
            w(0);
        }
        com.bytedance.msdk.core.am.hf.xj(com.bytedance.msdk.core.hf.hf()).hf(1);
    }

    private void w(com.bytedance.msdk.core.tf.tf tfVar, int i) {
        int i2;
        if (tfVar == null || this.tf == null) {
            return;
        }
        if (tfVar.en()) {
            i2 = 1;
        } else if (tfVar.j() || tfVar.l()) {
            i2 = 2;
        } else {
            i2 = tfVar.z() ? 3 : 4;
        }
        if (tfVar.a()) {
            this.tf.removeMessages(i2, jk.xj(i));
        } else {
            this.tf.removeMessages(i2);
        }
    }

    public void w() {
        this.f10165pl = false;
        this.kd.u();
    }

    private void w(List<com.bytedance.msdk.hf.w> list) {
        if (list == null) {
            return;
        }
        for (com.bytedance.msdk.hf.w wVar : list) {
            if (wVar != null) {
                com.bytedance.msdk.core.kd.hf.u.xj().xj(this.c, new com.bytedance.msdk.core.kd.hf.c(wVar, this.kd.ai(), this.f));
            }
        }
    }

    public void u() {
        this.kd.kd();
    }

    private void xj(int i, int i2) {
        long r;
        Handler handler;
        Map<Integer, List<com.bytedance.msdk.core.tf.tf>> map = this.xj;
        if (map == null) {
            return;
        }
        final List<com.bytedance.msdk.core.tf.tf> list = map.get(Integer.valueOf(i));
        StringBuilder sb = new StringBuilder();
        sb.append(com.bytedance.msdk.xj.kd.kd.xj(this.y));
        sb.append("loadLevelWaterFall start...执行当前加载层级 ：");
        sb.append(i2);
        sb.append(" levelSort:");
        sb.append(i);
        sb.append("  waterFallConfig.size:");
        sb.append(list == null ? 0 : list.size());
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, sb.toString());
        if (q.xj(list)) {
            return;
        }
        this.hf.xj(i, list.size());
        if (com.bytedance.msdk.w.f.c.w(i)) {
            r = this.y.pz();
        } else {
            r = this.y.r();
        }
        Message obtain = Message.obtain();
        if (com.bytedance.msdk.w.f.c.xj(i)) {
            obtain.what = 1;
        } else if (com.bytedance.msdk.w.f.c.w(i)) {
            obtain.what = 2;
        } else if (com.bytedance.msdk.w.f.c.hf(i)) {
            obtain.what = 3;
        } else {
            obtain.what = 4;
            obtain.obj = jk.xj(i);
        }
        obtain.arg1 = i;
        Handler handler2 = this.tf;
        if (handler2 != null) {
            handler2.sendMessageDelayed(obtain, r);
        }
        long wo = this.y.wo();
        if (wo != 0 && (handler = this.tf) != null) {
            handler.removeMessages(5);
            this.tf.sendEmptyMessageDelayed(5, wo);
        }
        for (final int i3 = 0; i3 < list.size(); i3++) {
            try {
                com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.w.w.xj.hf.4
                    @Override // java.lang.Runnable
                    public void run() {
                        hf.this.xj((com.bytedance.msdk.core.tf.tf) list.get(i3), list.size());
                    }
                });
                if (this.kd.ra()) {
                    this.kd.x();
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.pl.xj(th);
            }
        }
    }

    public int hf(int i) {
        int indexOf;
        List<Integer> list = this.d;
        if (list == null || (indexOf = list.indexOf(Integer.valueOf(i))) == -1) {
            return -1;
        }
        return indexOf + 1;
    }

    private void hf(List<com.bytedance.msdk.hf.w> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        String cy = list.get(0).cy();
        if (list.get(0).my() && com.bytedance.msdk.core.kd.xj.xj.xj().kd(this.c, cy, this.f.kd()) == 1) {
            ArrayList arrayList = new ArrayList();
            for (com.bytedance.msdk.hf.w wVar : list) {
                if (wVar != null) {
                    arrayList.add(new com.bytedance.msdk.core.kd.hf.c(wVar, 0L, this.f));
                }
            }
            if (arrayList.size() > 0) {
                com.bytedance.msdk.hf.w wVar2 = ((com.bytedance.msdk.core.kd.hf.c) arrayList.get(0)).xj;
                com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "--==-- 广告复用:广告缓存成功 -------" + wVar2.lw() + ", adType: " + com.bytedance.msdk.hf.xj.xj(wVar2.ci(), wVar2.tj()) + ", adnSlotId: " + wVar2.cy() + ", ad个数: " + arrayList.size());
                com.bytedance.msdk.core.kd.xj.xj.xj().xj(cy, (List<com.bytedance.msdk.core.kd.hf.c>) arrayList, false);
            }
        }
    }

    public void xj(com.bytedance.msdk.core.tf.tf tfVar, int i) {
        hf hfVar;
        if (tfVar == null || this.f == null) {
            hfVar = this;
        } else {
            hfVar = this;
            hfVar.xj(tfVar.yo(), tfVar.qt(), tfVar.zg(), com.bytedance.msdk.hf.xj.xj(this.f.ht(), tfVar.y()), 0, "广告请求中");
        }
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(hfVar.y) + "开始 某一层级的waterFallConfig请求 WaterFallConfig:" + tfVar.toString());
        com.bytedance.msdk.w.y.hf.hf xj = com.bytedance.msdk.w.y.hf.hf.xj(tfVar, this);
        xj.w(1);
        xj.hf(1);
        xj.xj(i);
        xj.xj(!hfVar.kd.ra());
        xj.xj(SystemClock.elapsedRealtime());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.bytedance.msdk.w.w.hf.hf());
        arrayList.add(new com.bytedance.msdk.w.w.hf.c());
        arrayList.add(new com.bytedance.msdk.w.w.hf.u());
        arrayList.add(new com.bytedance.msdk.w.w.hf.y());
        arrayList.add(new com.bytedance.msdk.w.w.hf.w());
        new com.bytedance.msdk.w.w.hf.kd(arrayList).xj(hfVar.kd, xj);
    }

    public void xj(final List<com.bytedance.msdk.core.tf.tf> list) {
        final Context context = this.kd.getContext();
        if (context != null) {
            com.bytedance.msdk.xj.kd.y.u(new Runnable() { // from class: com.bytedance.msdk.w.w.xj.hf.5
                @Override // java.lang.Runnable
                public void run() {
                    hf hfVar = hf.this;
                    hfVar.xj(context, hfVar.f, list, !hf.this.kd.ra());
                }
            });
        }
    }

    public void xj(final int i) {
        com.bytedance.msdk.w.c.hf.xj xj = com.bytedance.msdk.w.c.hf.kd.xj(this.y);
        this.p = xj;
        Handler handler = this.tf;
        com.bytedance.msdk.core.tf.hf hfVar = this.y;
        xj.xj(handler, hfVar, new com.bytedance.msdk.w.c.hf.hf(hfVar, new Runnable() { // from class: com.bytedance.msdk.w.w.xj.hf.6
            @Override // java.lang.Runnable
            public void run() {
                hf.this.w(i + 1);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(Message message) {
        int i = message.arg1;
        switch (message.what) {
            case 1:
            case 4:
                StringBuilder sb = new StringBuilder();
                sb.append(com.bytedance.msdk.xj.kd.kd.xj(this.y));
                sb.append(message.what == 1 ? "P层" : "普通层");
                sb.append("广告触发层超时.........levelSort:");
                sb.append(i);
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, sb.toString());
                this.hf.u(i);
                if (!hf()) {
                    w(hf(i));
                    break;
                }
                break;
            case 2:
            case 3:
                StringBuilder sb2 = new StringBuilder();
                sb2.append(com.bytedance.msdk.xj.kd.kd.xj(this.y));
                sb2.append(message.what == 2 ? "ClientBidding层" : "ServerBidding层层");
                sb2.append("广告触发层超时.........levelSort:");
                sb2.append(i);
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, sb2.toString());
                this.hf.u(i);
                hf();
                break;
            case 5:
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "触发最小层超时.........levelSort:" + i);
                hf();
                break;
            case 6:
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "触发总超时.........");
                this.hf.u();
                this.kd.ff().y = true;
                hf();
                break;
        }
    }

    @Override // com.bytedance.msdk.w.hf.hf.xj
    public void xj(List<com.bytedance.msdk.hf.w> list, com.bytedance.msdk.core.tf.tf tfVar) {
        if (q.xj(list) || tfVar == null) {
            return;
        }
        xj(list, this.y);
        xj(tfVar.yo(), tfVar.qt(), tfVar.zg(), com.bytedance.msdk.hf.xj.xj(tfVar.g(), tfVar.y()), 0, "广告加载成功");
        com.bytedance.msdk.core.c.w.xj(this.c, tfVar, !q.hf(list) ? list.get(0) : null);
        hf(list);
        int xj = com.bytedance.msdk.w.f.c.xj(this.y, tfVar);
        if (tfVar.a() && com.bytedance.msdk.w.c.xj.xj(this.hf, this.w, tfVar.yo())) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "返回的普通广告被server Bidding过滤了......slotId:" + tfVar.yo());
            this.kd.d().addAll(list);
            return;
        }
        com.bytedance.msdk.w.f.xj.xj(this.kd, list, false);
        this.hf.xj(xj, tfVar.yo());
        if (this.kd.ra()) {
            w(list);
        }
        if (this.hf.kd()) {
            xj((List<com.bytedance.msdk.hf.w>) null, new com.bytedance.msdk.api.xj(10012, "load ad timeout !!!"));
        } else {
            xj(list, (com.bytedance.msdk.api.xj) null);
        }
        this.kd.xj(list);
        if (hf(tfVar, 1) || this.hf.y(xj) != 0 || tfVar.ff()) {
            return;
        }
        int hf = hf(xj);
        w(tfVar, xj);
        com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "onAdLoaded levelSort: " + xj + " 广告全部响应结束&不满足返回条件，直接请求下一层广告 nextIdx：" + hf);
        w(hf);
    }

    @Override // com.bytedance.msdk.w.hf.hf.xj
    public void xj(com.bytedance.msdk.api.xj xjVar, com.bytedance.msdk.core.tf.tf tfVar) {
        hf hfVar;
        if (tfVar == null) {
            return;
        }
        xj((List<com.bytedance.msdk.hf.w>) null, xjVar);
        if (xjVar != null) {
            hfVar = this;
            hfVar.xj(tfVar.yo(), tfVar.e(), tfVar.zg(), com.bytedance.msdk.hf.xj.xj(tfVar.g(), tfVar.y()), xjVar.w, xjVar.u);
        } else {
            hfVar = this;
        }
        com.bytedance.msdk.core.c.w.xj(xjVar, tfVar);
        if (tfVar.a() && com.bytedance.msdk.w.c.xj.xj(hfVar.hf, hfVar.w, tfVar.yo())) {
            return;
        }
        int xj = com.bytedance.msdk.w.f.c.xj(hfVar.y, tfVar);
        hfVar.hf.xj(xj, tfVar.yo());
        if (hf(tfVar, 2) || hfVar.hf.kd(xj) || hfVar.hf.y(xj) != 0 || tfVar.ff()) {
            return;
        }
        int hf = hf(xj);
        w(tfVar, xj);
        com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(hfVar.y) + "onAdFailed levelSort " + xj + " 广告全部响应结束&不满足返回条件，直接请求下一层广告 nextIdx：" + hf);
        w(hf);
    }

    @Override // com.bytedance.msdk.w.hf.hf.xj
    public void xj() {
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "onAdVideoCache.....");
        u();
    }

    public void xj(com.bytedance.msdk.api.xj xjVar) {
        this.kd.xj(xjVar);
    }

    public void xj(List<com.bytedance.msdk.hf.w> list, com.bytedance.msdk.api.xj xjVar) {
        this.kd.xj(list, xjVar);
    }

    public void xj(Context context, final com.bytedance.msdk.api.xj.hf hfVar, final List<com.bytedance.msdk.core.tf.tf> list, boolean z) {
        com.bytedance.msdk.core.u.u xj = com.bytedance.msdk.core.u.kd.xj();
        if (xj != null) {
            this.hf.xj(0);
            this.kd.ff().u = true;
            com.bytedance.msdk.core.u.w wVar = new com.bytedance.msdk.core.u.w();
            wVar.xj = hfVar;
            wVar.hf = list;
            wVar.u = this.y;
            wVar.y = z;
            wVar.kd = hfVar != null ? hfVar.w() : 1;
            xj.xj(this.kd.pz(), context, wVar, new u.xj() { // from class: com.bytedance.msdk.w.w.xj.hf.7
                @Override // com.bytedance.msdk.core.u.u.xj
                public void xj(com.bytedance.msdk.core.u.hf hfVar2) {
                    hf.this.xj(hfVar, list, hfVar2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(com.bytedance.msdk.api.xj.hf hfVar, List<com.bytedance.msdk.core.tf.tf> list, com.bytedance.msdk.core.u.hf hfVar2) {
        com.bytedance.msdk.w.c.hf.xj xjVar;
        if (this.kd != null && hfVar2 != null && !TextUtils.isEmpty(hfVar2.u)) {
            this.kd.ff().xj = hfVar2.u;
        }
        com.bytedance.msdk.core.tf.hf hfVar3 = this.y;
        if (hfVar3 != null && hfVar2 != null) {
            hfVar3.y().put("price_source", Integer.valueOf(hfVar2.g));
        }
        if (hfVar2 != null) {
            com.bytedance.msdk.kd.y.xj(hfVar, hfVar2, this.hf.kd() ? 1 : 0);
        }
        if (hfVar2 != null && !q.xj(hfVar2.hf)) {
            this.hf.xj(1);
            if (this.kd.xj() || this.kd.hf()) {
                return;
            }
            this.w.clear();
            this.w.addAll(hfVar2.hf);
            Handler handler = this.tf;
            if (handler != null) {
                handler.removeMessages(1);
                this.tf.removeMessages(4);
                this.tf.removeMessages(5);
            }
            j.xj(hfVar2.hf);
            this.xj = com.bytedance.msdk.w.f.c.xj(hfVar2.hf, this.y.pl());
            ArrayList arrayList = new ArrayList();
            this.d = arrayList;
            arrayList.addAll(this.xj.keySet());
            com.bytedance.msdk.core.c.hf.xj(this.d);
            this.hf.xj(this.d);
            this.hf.xj(hfVar2.hf, com.bytedance.msdk.w.f.c.xj(this.y.yy()), com.bytedance.msdk.w.f.c.w(this.y.yy()));
            com.bytedance.msdk.w.c.xj.xj(this.y, this.kd, hfVar2.hf);
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "serverBidding响应回来..........开始从头开始请求waterFallConfig  代码位总数量：" + hfVar2.hf.size());
            w(0);
            hf();
        } else {
            this.hf.xj(2);
            if (this.kd.xj() || this.kd.hf()) {
                return;
            }
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(this.y) + "serverBidding响应失败了.......... ");
            this.hf.hf(0);
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    com.bytedance.msdk.core.tf.tf tfVar = list.get(i);
                    this.hf.xj(com.bytedance.msdk.w.f.c.xj(this.y, tfVar), tfVar.yo());
                }
            }
            if (!hf() && (xjVar = this.p) != null) {
                xjVar.xj();
            }
        }
        if (this.y != null && hfVar2 != null) {
            com.bytedance.msdk.core.d.hf.u().xj(hfVar2.f10132pl, hfVar2.am, this.y.ff(), this.y.en());
        }
        if (hfVar2 == null || !hfVar2.w) {
            return;
        }
        com.bytedance.msdk.core.am.hf.xj(com.bytedance.msdk.core.hf.hf()).xj().hf(1);
    }

    public void xj(List<com.bytedance.msdk.hf.w> list, com.bytedance.msdk.core.tf.hf hfVar) {
        com.bytedance.msdk.core.d.u.xj(list, hfVar);
        com.bytedance.msdk.core.hf.xj.xj(list, hfVar);
    }

    public void xj(String str, String str2, String str3, String str4, int i, String str5) {
        com.bytedance.msdk.api.hf hfVar = this.kd.dk().get(str);
        if (hfVar == null) {
            hfVar = new com.bytedance.msdk.api.hf();
        }
        hfVar.hf(str).w(str2).u(str3).xj(i).kd(str5).xj(str4);
        this.kd.dk().put(str, hfVar);
    }
}
