package com.bytedance.msdk.core.u;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.core.g.xj;
import com.bytedance.msdk.core.tf.c;
import com.bytedance.msdk.core.tf.f;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.core.u.u;
import com.bytedance.msdk.f.q;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y implements u {
    @Override // com.bytedance.msdk.core.u.u
    public void xj(Map<String, com.bytedance.msdk.w.xj.xj> map, Context context, final w wVar, final u.xj xjVar) {
        if (wVar != null && wVar.xj != null && wVar.u != null && !q.xj(wVar.hf)) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(wVar.xj.ra()) + "开启server bidding网络请求......：");
            com.bytedance.msdk.kd.y.xj(wVar.xj, (JSONObject) null);
            final long currentTimeMillis = System.currentTimeMillis();
            final int[] iArr = {4};
            com.bytedance.msdk.core.g.xj.xj().xj(map, context, wVar.xj, wVar.hf, wVar.w, wVar.u, wVar.kd, wVar.y, new xj.InterfaceC0057xj() { // from class: com.bytedance.msdk.core.u.y.1
                @Override // com.bytedance.msdk.core.g.xj.InterfaceC0057xj
                public void xj(c cVar) {
                    y yVar = y.this;
                    long j = currentTimeMillis;
                    w wVar2 = wVar;
                    yVar.xj(j, wVar2.xj, wVar2.u, iArr[0], cVar, xjVar);
                }

                @Override // com.bytedance.msdk.core.g.xj.InterfaceC0057xj
                public void xj(com.bytedance.msdk.api.xj xjVar2) {
                    y.this.xj(currentTimeMillis, iArr[0], xjVar2, wVar.xj, xjVar);
                }
            });
            return;
        }
        xjVar.xj(null);
    }

    public void xj(String str, final long j, final com.bytedance.msdk.api.xj.hf hfVar, final com.bytedance.msdk.core.tf.hf hfVar2, final u.xj xjVar) {
        com.bytedance.msdk.core.g.xj.xj().xj(str, new xj.InterfaceC0057xj() { // from class: com.bytedance.msdk.core.u.y.2
            @Override // com.bytedance.msdk.core.g.xj.InterfaceC0057xj
            public void xj(c cVar) {
                y.this.xj(j, hfVar, hfVar2, 4, cVar, xjVar);
            }

            @Override // com.bytedance.msdk.core.g.xj.InterfaceC0057xj
            public void xj(com.bytedance.msdk.api.xj xjVar2) {
                y.this.xj(j, 4, xjVar2, hfVar, xjVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(long j, com.bytedance.msdk.api.xj.hf hfVar, com.bytedance.msdk.core.tf.hf hfVar2, int i, c cVar, u.xj xjVar) {
        int i2;
        hf hfVar3;
        int i3;
        tf y;
        com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(hfVar.ra()) + "server bidding网络请求响返回.............");
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (hfVar2 != null && cVar != null && !q.xj(cVar.u())) {
            List<f> u = cVar.u();
            hfVar3 = new hf();
            hfVar3.f10132pl = cVar.xj();
            hfVar3.g = cVar.hf();
            hfVar3.am = cVar.w();
            hfVar3.p = cVar.c();
            hfVar3.d = u.size();
            hfVar3.xj = cVar.d();
            hfVar3.tf = hfVar2.c();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder("winners : {");
            for (f fVar : u) {
                if (fVar != null && (y = hfVar2.y(fVar.c())) != null) {
                    tf kd = y.kd();
                    sb.append(" [ AdnName:" + kd.qt() + ",slotId:" + kd.yo() + ",loadSort:" + kd.dk() + ",showSort:" + kd.et() + "] ");
                    kd.xj(fVar);
                    arrayList.add(kd);
                }
            }
            sb.append("}");
            if (q.xj(arrayList)) {
                i2 = q.xj(cVar.d()) ? i : 2;
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(hfVar.ra()) + "server bidding网络请求响应失败......：数据有返回，但没有返回winner数据......");
            } else {
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(hfVar.ra()) + "server bidding网络请求响应成功......：" + sb.toString());
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.addAll(arrayList);
                List<tf> xj = xj(cVar.d(), hfVar2, hfVar3);
                if (xj != null && xj.size() > 0) {
                    com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(hfVar.ra()) + "server bidding网络请求响应成功......waterfall+server bidding物料......");
                    copyOnWriteArrayList.addAll(xj);
                    i3 = 1;
                } else {
                    com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(hfVar.ra()) + "server bidding网络请求响应成功......server bidding物料......");
                    i3 = 3;
                }
                hfVar3.hf = copyOnWriteArrayList;
                i2 = i3;
            }
        } else {
            i2 = (cVar == null || q.xj(cVar.d())) ? i : 2;
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(hfVar.ra()) + "server bidding网络请求响应失败......没有返回serverBiddingModel相关数据");
            hfVar3 = null;
        }
        if (cVar != null) {
            String y2 = cVar.y();
            if (!TextUtils.isEmpty(y2)) {
                if (hfVar3 == null) {
                    hfVar3 = new hf();
                }
                hfVar3.u = y2;
            }
            if (cVar.f()) {
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(hfVar.ra()) + "server bidding发现config过期了，需要重新拉取配置......：");
                if (hfVar3 == null) {
                    hfVar3 = new hf();
                }
                hfVar3.w = true;
            }
            if (!q.xj(cVar.kd())) {
                if (hfVar3 == null) {
                    hfVar3 = new hf();
                }
                hfVar3.kd = cVar.kd();
            }
        }
        if (hfVar3 == null) {
            hfVar3 = new hf();
        }
        hfVar3.y = i2;
        hfVar3.c = currentTimeMillis;
        if (xjVar != null) {
            xjVar.xj(hfVar3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(long j, int i, com.bytedance.msdk.api.xj xjVar, com.bytedance.msdk.api.xj.hf hfVar, u.xj xjVar2) {
        int i2 = (xjVar == null || xjVar.xj != -1) ? 5 : 4;
        com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(hfVar.ra()) + "server bidding网络请求响应失败......onFail  result:" + i2);
        hf hfVar2 = new hf();
        hfVar2.y = i2;
        hfVar2.c = System.currentTimeMillis() - j;
        hfVar2.f = xjVar;
        if (xjVar2 != null) {
            xjVar2.xj(hfVar2);
        }
    }

    private List<tf> xj(List<tf> list, com.bytedance.msdk.core.tf.hf hfVar, hf hfVar2) {
        List<tf> yy;
        if (list == null || list.size() == 0 || hfVar == null) {
            return null;
        }
        boolean booleanValue = hfVar.y().get("serverBidding_timeout") instanceof Boolean ? ((Boolean) hfVar.y().get("serverBidding_timeout")).booleanValue() : false;
        if (hfVar.c() == 4 && !booleanValue) {
            com.bytedance.msdk.core.tf.hf xj = com.bytedance.msdk.c.xj.w.xj().xj(hfVar.ff(), hfVar.a(), 102);
            if (xj == null) {
                return null;
            }
            yy = com.bytedance.msdk.core.d.w.xj(xj, xj.ff(), hfVar2 == null ? 0.0d : hfVar2.f10132pl, hfVar2 != null ? hfVar2.am : 0.0d);
            hfVar.y().putAll(xj.y());
        } else {
            yy = hfVar.yy();
        }
        if (yy != null && yy.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (tf tfVar : yy) {
                Iterator<tf> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        tf next = it.next();
                        if (tfVar != null && next != null && tfVar.v() == 0 && !TextUtils.isEmpty(tfVar.yo()) && tfVar.yo().equals(next.yo())) {
                            arrayList.add(tfVar);
                            break;
                        }
                    }
                }
            }
            return arrayList;
        }
        return null;
    }
}
