package com.bytedance.msdk.w.w.xj;

import android.text.TextUtils;
import com.bytedance.msdk.f.q;
import com.bytedance.msdk.w.w.xj.xj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd implements xj {
    private int xj(int i) {
        switch (i) {
            case 1:
                return 840032;
            case 2:
                return 840033;
            case 3:
                return 840034;
            case 4:
            case 6:
            default:
                return 840029;
            case 5:
                return 840035;
            case 7:
                return 840036;
            case 8:
                return 840037;
            case 9:
                return 840030;
            case 10:
                return 840039;
        }
    }

    @Override // com.bytedance.msdk.w.w.xj.xj
    public void hf(xj.InterfaceC0086xj interfaceC0086xj) {
        com.bytedance.msdk.w.y.xj.hf xj = interfaceC0086xj.xj();
        if (xj.y()) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "调用过销毁方法_destroy()！！！");
            xj.xj(new com.bytedance.msdk.api.xj(41044, com.bytedance.msdk.api.xj.xj(41044)));
        } else if (xj.g().kd()) {
            xj.xj(new com.bytedance.msdk.api.xj(10010, "延长瀑布流总超时时长或者缩短层超时并添加兜底代码位"));
        } else {
            interfaceC0086xj.xj((String) null);
        }
    }

    @Override // com.bytedance.msdk.w.w.xj.xj
    public void xj(xj.InterfaceC0086xj interfaceC0086xj) {
        com.bytedance.msdk.w.y.xj.hf xj = interfaceC0086xj.xj();
        com.bytedance.msdk.api.xj.hf v = xj.v();
        com.bytedance.msdk.api.hf.xj xjVar = !com.bytedance.msdk.core.hf.hf().xj(xj.v().ra(), xj.v().ht()) ? new com.bytedance.msdk.api.hf.xj(840031, com.bytedance.msdk.api.xj.xj(840031)) : null;
        if (xjVar == null && !com.bytedance.msdk.core.hf.hf().xj(xj.v().ht())) {
            xjVar = new com.bytedance.msdk.api.hf.xj(xj(xj.v().ht()), com.bytedance.msdk.api.xj.xj(xj(xj.v().ht())));
        }
        if (xjVar == null && !com.bytedance.msdk.y.w.hf()) {
            xjVar = new com.bytedance.msdk.api.hf.xj(1, com.bytedance.msdk.api.xj.xj(1));
        }
        if (xjVar == null && xj.y()) {
            xjVar = new com.bytedance.msdk.api.hf.xj(41044, com.bytedance.msdk.api.xj.xj(41044));
        }
        if (xjVar == null && xj.getContext() == null) {
            com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, "Context为null！！！");
            xjVar = new com.bytedance.msdk.api.hf.xj(41005, com.bytedance.msdk.api.xj.xj(41005));
        }
        if (xjVar == null && TextUtils.isEmpty(xj.v().ra())) {
            xjVar = new com.bytedance.msdk.api.hf.xj(840026, "广告位id不能为空");
        }
        if (xjVar == null && (xj.pl() == null || q.xj(xj.pl().yy()))) {
            if (com.bytedance.msdk.c.xj.w.xj().w()) {
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(v.ra()) + "settings config.......没有settings config配置信息,AdUnitId = " + v.ra());
                xjVar = new com.bytedance.msdk.api.hf.xj(840040, com.bytedance.msdk.api.xj.xj(840040));
                com.bytedance.msdk.kd.y.hf(v, 1);
            } else if (xj.pl() == null || !q.xj(xj.pl().yy())) {
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(v.ra()) + "settings config.......注意，AdUnitId = " + v.ra() + " 的配置信息为 null ！！");
                xjVar = new com.bytedance.msdk.api.hf.xj(44406, "检查广告位ID的状态是否正常、初始化 useMediation 参数是否为 true、新建广告位ID生效期为20min左右");
                com.bytedance.msdk.kd.y.hf(v, 2);
            } else {
                com.bytedance.msdk.xj.kd.w.u(MediationConstant.TAG, com.bytedance.msdk.xj.kd.kd.xj(v.ra()) + "settings config.......注意，AdUnitId = " + v.ra() + "  没有对应的waterfall配置信息");
                com.bytedance.msdk.kd.y.hf(v, 3);
            }
            com.bytedance.msdk.core.am.hf.xj(com.bytedance.msdk.core.hf.hf()).hf(1);
        }
        if (xjVar == null) {
            String eu = v.eu();
            if (!TextUtils.isEmpty(eu) && !v.tj() && !com.bytedance.msdk.w.f.u.xj(v.ra(), eu)) {
                xjVar = new com.bytedance.msdk.api.hf.xj(840044, "本次请求未包含聚合广告位头层设价最高的代码位，导致聚合请求失败；请调整请求，确保包含聚合广告位头层设价最高的代码位。");
            }
        }
        com.bytedance.msdk.api.hf.xj xjVar2 = xjVar;
        if (xjVar2 == null) {
            interfaceC0086xj.xj(interfaceC0086xj.xj());
        } else {
            com.bytedance.msdk.kd.y.xj(v, xj.pl() != null ? xj.pl().hl() : null, !xj.ra(), xj.ff().xj, xjVar2.xj, (Map<String, Object>) null);
            xj.xj(xjVar2);
        }
    }
}
