package com.bytedance.sdk.openadsdk.core.pl.xj;

import com.bytedance.sdk.openadsdk.core.pl.u.w;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements ITTDownloadAdapter.OnEventLogHandler {
    private w.xj mPluginLogHandler;

    public xj(w.xj xjVar) {
        this.mPluginLogHandler = xjVar;
    }

    public boolean onEventLog(int i, String str, String str2, String str3, Object obj) {
        w.xj xjVar = this.mPluginLogHandler;
        if (xjVar != null) {
            return xjVar.xj(i, str, str2, str3, obj);
        }
        return false;
    }
}
