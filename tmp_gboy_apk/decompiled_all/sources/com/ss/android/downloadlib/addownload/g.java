package com.ss.android.downloadlib.addownload;

import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class g {
    private static final String xj = "g";

    public static class hf {
        private static g xj = new g();

        static {
            RxQdB();
        }

        private static /* synthetic */ void RxQdB() {
            char[] charArray = "»·µö¿¹µ½öº·¡ö«°½´´ö\u0092¶±\u009aª±¼¿½".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 216);
            }
            String str = new String(charArray);
            char[] charArray2 = "»´±¶±¬".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 216);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public class xj implements Runnable {
        private final com.ss.android.downloadad.api.xj.hf hf;

        public xj(com.ss.android.downloadad.api.xj.hf hfVar) {
            this.hf = hfVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.hf.tf(true);
                    g.this.hf(this.hf);
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.pl.xj(e);
                }
            } finally {
                this.hf.tf(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf(com.ss.android.downloadad.api.xj.hf hfVar) {
        JSONObject jSONObject = new JSONObject();
        int xj2 = com.ss.android.downloadlib.c.kd.xj(hfVar);
        int hf2 = com.ss.android.downloadlib.c.kd.hf(hfVar);
        if (com.ss.android.downloadlib.c.kd.kd(hfVar) && com.ss.android.downloadlib.c.kd.u(hfVar)) {
            com.ss.android.downloadlib.c.pl.xj().xj(xj, "tryListenInstallFinishEvent", "上层库开启二级线程轮询检测策略");
            xj(hfVar, xj2, hf2, jSONObject);
        } else {
            com.ss.android.downloadlib.c.pl.xj().xj(xj, "tryListenInstallFinishEvent", "采用原有默认轮询策略");
            hf(hfVar, 15, 20000, jSONObject);
        }
    }

    private g() {
    }

    public static g xj() {
        return hf.xj;
    }

    public void xj(com.ss.android.downloadad.api.xj.hf hfVar) {
        com.ss.android.downloadlib.c.pl.xj().xj(xj, "tryListenInstallFinish", "开始通过轮询线程监听安装完成事件");
        com.ss.android.downloadlib.kd.xj().w(new xj(hfVar));
    }

    private void xj(com.ss.android.downloadad.api.xj.hf hfVar, int i, int i2, JSONObject jSONObject) {
        int y;
        if (hfVar.r() == 4) {
            y = pl.d().optInt("market_install_finish_check_time", 600);
        } else {
            y = com.ss.android.downloadlib.c.kd.y(hfVar);
        }
        int i3 = ((y * 1000) / 20000) + 1;
        com.ss.android.downloadlib.c.pl xj2 = com.ss.android.downloadlib.c.pl.xj();
        String str = xj;
        xj2.xj(str, "realListenInstallFinishEventOpt", "一级轮询次数，即广播生效期内的轮询次数为:".concat(String.valueOf(i3)));
        if (hf(hfVar, i3, 20000, jSONObject)) {
            return;
        }
        if (y * 1000 < com.ss.android.downloadlib.c.kd.c(hfVar)) {
            com.ss.android.downloadlib.c.pl.xj().xj(str, "tryListenInstallFinishEventOpt", "广播生效时间外，一级轮询完成且没有检测到安装完成事件，开始二级检测");
            if (hf(hfVar, i, i2, jSONObject)) {
                return;
            }
            com.ss.android.downloadlib.c.pl.xj().xj(str, "tryListenInstallFinishEventOpt", "监听时间结束,依然没有监听到安装完成事件");
            return;
        }
        com.ss.android.downloadlib.c.pl.xj().xj(str, "tryListenInstallFinishEventOpt", "一级轮询时间小于广播监听时间,且未监听到安装完成事件");
    }

    private boolean hf(com.ss.android.downloadad.api.xj.hf hfVar, int i, int i2, JSONObject jSONObject) {
        com.ss.android.downloadlib.c.pl.xj().xj(xj, "realListenInstallFinishEvent", A2egSU.AaHO0E(i2, i, "开始轮询检测,轮询时间间隔为", ",轮询次数为"));
        long j = i2;
        SystemClock.sleep(j);
        while (i > 0) {
            if (com.ss.android.downloadlib.c.g.hf(hfVar)) {
                com.ss.android.downloadlib.xj.xj().xj(hfVar.kd());
                com.ss.android.downloadlib.c.pl.xj().xj(xj, "realListenInstallFinishEvent", "检测到安装成功，当前剩余的轮询次数为".concat(String.valueOf(i)));
                return true;
            }
            i--;
            if (i == 0) {
                return false;
            }
            SystemClock.sleep(j);
        }
        return false;
    }
}
