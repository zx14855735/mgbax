package com.bytedance.pangle.c;

import ADYaiT.CtFAbx;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.tf;
import com.bytedance.pangle.u;
import com.bytedance.pangle.w;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends w.xj {
    private static volatile xj xj;

    public static xj hf() {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    @Override // com.bytedance.pangle.w
    public boolean xj(String str) {
        return PluginManager.getInstance().checkPluginInstalled(str);
    }

    @Override // com.bytedance.pangle.w
    public boolean xj(String str, String str2) {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_PLUGIN_INSTALL, CtFAbx.AmA8tU("start install pkg:", str, ", path:", str2));
        return PluginManager.getInstance().syncInstall(str, new File(str2));
    }

    @Override // com.bytedance.pangle.w
    public int hf(String str) {
        return PluginManager.getInstance().getPlugin(str).getVersion();
    }

    @Override // com.bytedance.pangle.w
    public void xj(int i, u uVar) {
        Zeus.registerPluginStateListener(new w(uVar, i));
    }

    @Override // com.bytedance.pangle.w
    public void xj(int i) {
        ZeusPluginStateListener zeusPluginStateListener;
        List<ZeusPluginStateListener> w = tf.xj().w();
        Iterator<ZeusPluginStateListener> it = w.iterator();
        while (true) {
            if (!it.hasNext()) {
                zeusPluginStateListener = null;
                break;
            }
            zeusPluginStateListener = it.next();
            if ((zeusPluginStateListener instanceof w) && ((w) zeusPluginStateListener).xj() == i) {
                break;
            }
        }
        if (zeusPluginStateListener != null) {
            w.remove(zeusPluginStateListener);
        }
    }
}
