package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.os.Looper;
import android.view.View;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class e extends com.bytedance.sdk.component.adexpress.hf.xj<BackupView> {
    private View hf;
    private com.bytedance.sdk.component.adexpress.hf.c kd;
    private com.bytedance.sdk.component.adexpress.hf.w u;
    private ThemeStatusBroadcastReceiver w;
    private BackupView xj;
    private com.bytedance.sdk.component.adexpress.hf.g y;

    public e(View view, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.component.adexpress.hf.g gVar) {
        this.hf = view;
        this.w = themeStatusBroadcastReceiver;
        this.y = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hf() {
        com.bytedance.sdk.component.adexpress.hf.w wVar = this.u;
        if (wVar == null || !wVar.xj((NativeExpressView) this.hf, 0)) {
            this.kd.xj(107, (String) null);
            return;
        }
        this.y.c().tf();
        BackupView backupView = (BackupView) this.hf.findViewWithTag("tt_express_backup_fl_tag_26");
        this.xj = backupView;
        if (backupView == null) {
            this.kd.xj(107, (String) null);
            return;
        }
        backupView.setThemeChangeReceiver(this.w);
        com.bytedance.sdk.component.adexpress.hf.am amVar = new com.bytedance.sdk.component.adexpress.hf.am();
        BackupView backupView2 = this.xj;
        float realWidth = backupView2 == null ? 0.0f : backupView2.getRealWidth();
        BackupView backupView3 = this.xj;
        float realHeight = backupView3 != null ? backupView3.getRealHeight() : 0.0f;
        amVar.xj(true);
        amVar.xj(realWidth);
        amVar.hf(realHeight);
        this.kd.xj(this.xj, amVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.u
    public void xj(com.bytedance.sdk.component.adexpress.hf.c cVar) {
        this.kd = cVar;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            hf();
        } else {
            com.bytedance.sdk.openadsdk.core.v.y().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.e.1
                @Override // java.lang.Runnable
                public void run() {
                    e.this.hf();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.u
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public BackupView c() {
        return this.xj;
    }

    @Override // com.bytedance.sdk.component.adexpress.hf.xj
    public void xj(com.bytedance.sdk.component.adexpress.hf.w wVar) {
        this.u = wVar;
    }
}
