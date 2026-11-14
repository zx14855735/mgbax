package com.ss.android.downloadlib;

import com.ss.android.downloadlib.c.g;
import com.ss.android.downloadlib.c.pl;
import com.ss.android.socialbase.appdownloader.w.zg;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class d {
    private static boolean hf = false;
    private static final String xj = "d";

    public static class xj {
        private static d xj = new d();

        static {
            YxOE();
        }

        private static /* synthetic */ void YxOE() {
            char[] charArray = "^RP\u0013Z\\PX\u0013_RD\u0013NUXQQ\u0013wST\u007fOTYZX".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '=');
            }
            String str = new String(charArray);
            char[] charArray2 = "^QTSTI".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '=');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static d xj() {
        return xj.xj;
    }

    private d() {
    }

    public void xj(com.ss.android.downloadlib.addownload.hf.kd kdVar, final com.ss.android.downloadad.api.xj.hf hfVar) {
        if (!com.ss.android.downloadlib.c.kd.w(hfVar)) {
            pl.xj().xj(xj, "checkMarketInstallFinishEvent", "开关未开启, 不使用动态广播监听能力");
            return;
        }
        if (hfVar == null) {
            pl.xj().hf(xj, "checkMarketInstallFinishEvent", "nativeDownloadModel为空,不符合预期");
            return;
        }
        if (hfVar.dq()) {
            pl.xj().hf(xj, "checkMarketInstallFinishEvent", "正在监听中,不重复监听");
            return;
        }
        try {
            pl xj2 = pl.xj();
            String str = xj;
            xj2.xj(str, "checkMarketInstallFinishEvent", "针对商店直投广告,开始检测安装完成事件");
            if (com.ss.android.downloadlib.c.kd.u(hfVar)) {
                pl.xj().xj(str, "checkMarketInstallFinishEvent", "开始进行动态广播监听");
                int optInt = com.ss.android.downloadlib.addownload.pl.d().optInt("market_install_finish_check_time", 600);
                if (hfVar.nb() != 0 && System.currentTimeMillis() - hfVar.nb() <= optInt * 1000) {
                    pl.xj().xj(str, "checkMarketInstallFinishEvent", "目前仍在广播监听的生效期内,不进行重复注册");
                }
                hfVar.tf(System.currentTimeMillis());
                xj(optInt, new zg() { // from class: com.ss.android.downloadlib.d.1
                    @Override // com.ss.android.socialbase.appdownloader.w.zg
                    public void hf() {
                        pl.xj().xj(d.xj, "checkMarketInstallFinishEvent", "广播监听时间结束,主动解除了广播监听");
                        if (!g.hf(hfVar)) {
                            pl.xj().xj(d.xj, "checkMarketInstallFinishEvent", "监听结束依然没有完成安装");
                        }
                        hfVar.tf(false);
                        com.ss.android.downloadlib.addownload.hf.y.xj().xj(hfVar);
                    }

                    @Override // com.ss.android.socialbase.appdownloader.w.zg
                    public void xj() {
                        pl.xj().xj(d.xj, "checkMarketInstallFinishEvent", "注册广播监听成功,注册耗时" + (System.currentTimeMillis() - hfVar.nb()));
                        hfVar.tf(true);
                        com.ss.android.downloadlib.addownload.hf.y.xj().xj(hfVar);
                    }
                });
            }
            if (com.ss.android.downloadlib.c.kd.kd(hfVar)) {
                pl.xj().xj(str, "checkMarketInstallFinishEvent", "开启轮询线程能力,作为容灾手段");
                com.ss.android.downloadlib.addownload.g.xj().xj(hfVar);
            }
            com.ss.android.downloadlib.addownload.hf.d.xj().xj(hfVar);
        } catch (Exception unused) {
            com.ss.android.downloadlib.kd.w.xj().xj(false, "监听商店场景安装完成事件发生异常");
        }
    }

    public void xj(final com.ss.android.downloadad.api.xj.hf hfVar) {
        if (!com.ss.android.downloadlib.c.kd.w(hfVar)) {
            pl.xj().xj(xj, "checkMarketInstallFinishEventForReboot", "线程轮询总开关未开启,因此不执行兜底逻辑");
            return;
        }
        if (hfVar == null) {
            pl.xj().hf(xj, "checkMarketInstallFinishEventForReboot", "nativeDownloadModel为空,不符合预期");
            return;
        }
        if (hfVar.kd.get() && System.currentTimeMillis() - hfVar.nb() > 30000) {
            pl.xj().xj(xj, "checkMarketInstallFinishEventForReboot", "兜底过一次了,不进行重复兜底");
            return;
        }
        if (com.ss.android.downloadlib.c.kd.u(hfVar)) {
            long optInt = com.ss.android.downloadlib.addownload.pl.d().optInt("market_install_finish_check_time", 600) * 1000;
            if (System.currentTimeMillis() - hfVar.nb() >= optInt) {
                pl.xj().xj(xj, "checkMarketInstallFinishEventForReboot", "当前时间距离首次检测时间超出了广播生效期,不再执行兜底策略");
            } else {
                xj((int) (((hfVar.nb() + optInt) - System.currentTimeMillis()) / 1000), new zg() { // from class: com.ss.android.downloadlib.d.2
                    @Override // com.ss.android.socialbase.appdownloader.w.zg
                    public void hf() {
                        pl.xj().xj(d.xj, "checkMarketInstallFinishEventForReboot", "兜底监听执行完毕,解除广播监听");
                        if (!g.hf(hfVar)) {
                            pl.xj().xj(d.xj, "checkMarketInstallFinishEventForReboot", "监听结束依然没有完成安装");
                        }
                        hfVar.kd.compareAndSet(true, false);
                        hfVar.tf(false);
                        com.ss.android.downloadlib.addownload.hf.d.xj().xj(hfVar);
                    }

                    @Override // com.ss.android.socialbase.appdownloader.w.zg
                    public void xj() {
                        pl.xj().xj(d.xj, "checkMarketInstallFinishEventForReboot", "进程被杀,重新注册广播监听成功,正式执行冷启兜底逻辑");
                        hfVar.kd.compareAndSet(false, true);
                        com.ss.android.downloadlib.addownload.hf.d.xj().xj(hfVar);
                    }
                });
            }
        }
    }

    public void xj(int i, zg zgVar) {
        pl.xj().xj(xj, "registerMarketInstallFinishBroadcast", "动态广播监听的持续时间为:".concat(String.valueOf(i)));
        if (!hf) {
            com.ss.android.socialbase.appdownloader.u.p().xj(zgVar);
            hf = true;
        }
        com.ss.android.socialbase.appdownloader.u.p().xj(i);
    }
}
