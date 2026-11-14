package com.bytedance.pangle.y;

import android.os.SystemClock;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.d;
import com.bytedance.pangle.util.g;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {

    public interface xj {
        boolean xj(String str, int i);
    }

    public static synchronized void hf() {
        synchronized (y.class) {
            try {
                Map<String, ?> all = hf.xj(Zeus.getAppApplication()).getAll();
                if (all.size() > 0) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat start:" + entry.getKey());
                        if (w().xj(entry.getKey(), ((Integer) entry.getValue()).intValue())) {
                            hf.xj(Zeus.getAppApplication()).edit().remove(entry.getKey()).apply();
                            ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat success:" + entry.getKey());
                            g.xj().w(entry.getKey(), ((Integer) entry.getValue()).intValue(), true);
                            ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat markDexOptState:" + entry.getKey());
                        } else {
                            ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat failed:" + entry.getKey());
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static xj w() {
        return d.d() ? new kd() : d.c() ? new u() : d.w() ? new w() : new xj() { // from class: com.bytedance.pangle.y.y.2
            @Override // com.bytedance.pangle.y.y.xj
            public boolean xj(String str, int i) {
                return true;
            }
        };
    }

    public static void xj() {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_DEX_OPT, "start");
        if (GlobalParam.getInstance().isCloseBgDex2oat()) {
            return;
        }
        if ((d.c() || d.d() || d.w()) && com.bytedance.pangle.kd.u.hf(Zeus.getAppApplication())) {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_DEX_OPT, "post");
            com.bytedance.pangle.kd.kd.hf(new Runnable() { // from class: com.bytedance.pangle.y.y.1
                @Override // java.lang.Runnable
                public void run() {
                    GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_DEX_OPT, "exec");
                    SystemClock.sleep(GlobalParam.getInstance().getDexOptDelayTime());
                    y.hf();
                }
            });
        }
    }
}
