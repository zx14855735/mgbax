package com.bytedance.sdk.openadsdk.tools;

import com.bytedance.component.sdk.annotation.Keep;
import com.bytedance.sdk.openadsdk.api.TTILog;
import com.bytedance.sdk.openadsdk.core.ai;
import com.bytedance.sdk.openadsdk.core.wo.xj.w;

@Keep
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class LogAdapter implements com.bytedance.sdk.component.xj {
    public static LogAdapter xj;
    private w.xj hf;

    private LogAdapter() {
    }

    @Keep
    public static void zzz(TTILog tTILog) {
        if (ai.w > 5300 && xj == null && tTILog != null) {
            xj((w.xj) new w.hf(tTILog), false);
        }
    }

    @Override // com.bytedance.sdk.component.xj
    public void hf(String str, String str2) {
        w.xj xjVar = this.hf;
        if (xjVar != null) {
            xjVar.u(str, str2);
        }
    }

    public void u(String str, String str2) {
        w.xj xjVar = this.hf;
        if (xjVar != null) {
            xjVar.hf(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.xj
    public void w(String str, String str2) {
        w.xj xjVar = this.hf;
        if (xjVar != null) {
            xjVar.kd(str, str2);
        }
    }

    public w.xj xj() {
        return this.hf;
    }

    public static void xj(w.xj xjVar, boolean z) {
        LogAdapter logAdapter = new LogAdapter();
        xj = logAdapter;
        if (z) {
            logAdapter.hf = new xj(xjVar);
        } else {
            logAdapter.hf = xjVar;
        }
    }

    @Override // com.bytedance.sdk.component.xj
    public void hf(String str, String str2, Throwable th) {
        w.xj xjVar = this.hf;
        if (xjVar != null) {
            xjVar.hf(str, str2, th);
        }
    }

    @Override // com.bytedance.sdk.component.xj
    public void xj(String str, String str2) {
        w.xj xjVar = this.hf;
        if (xjVar != null) {
            xjVar.w(str, str2);
        }
    }

    @Override // com.bytedance.sdk.component.xj
    public void xj(String str, String str2, Throwable th) {
        w.xj xjVar = this.hf;
        if (xjVar != null) {
            xjVar.xj(str, str2, th);
        }
    }

    @Override // com.bytedance.sdk.component.xj
    public void xj(String str, Throwable th) {
        w.xj xjVar = this.hf;
        if (xjVar != null) {
            xjVar.xj(str, th);
        }
    }
}
