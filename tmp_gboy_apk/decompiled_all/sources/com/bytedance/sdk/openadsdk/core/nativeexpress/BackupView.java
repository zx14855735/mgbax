package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.ra.h;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import org.json.JSONException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class BackupView extends FrameLayout implements com.bytedance.sdk.component.adexpress.theme.xj {
    protected int c;
    protected boolean d;
    protected int f;
    private NativeVideoTsView g;
    protected ws hf;
    protected String kd;
    protected String p;

    /* renamed from: pl, reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.multipro.hf.xj f10374pl;
    protected boolean tf;
    protected Dialog u;
    protected com.bytedance.sdk.openadsdk.core.dislike.ui.xj w;
    protected Context xj;
    protected int y;

    public BackupView(Context context) {
        super(context);
        this.kd = "embeded_ad";
        this.d = true;
        this.tf = true;
        this.f10374pl = new com.bytedance.sdk.openadsdk.core.multipro.hf.xj();
        xj();
    }

    private boolean hf() {
        if (u()) {
            return w();
        }
        ws wsVar = this.hf;
        return wsVar != null && ws.hf(wsVar);
    }

    private boolean u() {
        return TextUtils.equals(this.kd, "splash_ad") || TextUtils.equals(this.kd, "cache_splash_ad");
    }

    private boolean w() {
        com.bykv.vk.openvk.component.video.api.w.w am;
        ws wsVar = this.hf;
        return (wsVar == null || wsVar.ss() == 1 || (am = h.am(this.hf)) == null || TextUtils.isEmpty(am.pl())) ? false : true;
    }

    private void xj() {
        setTag("tt_express_backup_fl_tag_26");
    }

    public void b_(int i) {
    }

    public String getDescription() {
        return !TextUtils.isEmpty(this.hf.kr()) ? this.hf.kr() : !TextUtils.isEmpty(this.hf.uj()) ? this.hf.uj() : "";
    }

    public ws getMeta() {
        return this.hf;
    }

    public String getNameOrSource() {
        ws wsVar = this.hf;
        return wsVar == null ? "" : (wsVar.vh() == null || TextUtils.isEmpty(this.hf.vh().w())) ? !TextUtils.isEmpty(this.hf.ci()) ? this.hf.ci() : "" : this.hf.vh().w();
    }

    public float getRealHeight() {
        return r.u(this.xj, this.c);
    }

    public float getRealWidth() {
        return r.u(this.xj, this.y);
    }

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    public String getTitle() {
        return (this.hf.vh() == null || TextUtils.isEmpty(this.hf.vh().w())) ? !TextUtils.isEmpty(this.hf.ci()) ? this.hf.ci() : !TextUtils.isEmpty(this.hf.kr()) ? this.hf.kr() : "" : this.hf.vh().w();
    }

    public com.bytedance.sdk.openadsdk.core.multipro.hf.xj getVideoModel() {
        return this.f10374pl;
    }

    public void kd() {
        Dialog dialog = this.u;
        if (dialog != null) {
            dialog.show();
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.xj xjVar = this.w;
        if (xjVar != null) {
            xjVar.xj();
        } else {
            TTDelegateActivity.xj(getContext(), this.hf);
        }
    }

    public void setDislikeInner(com.bytedance.sdk.openadsdk.zg.w.hf.c cVar) {
        if (cVar instanceof com.bytedance.sdk.openadsdk.core.dislike.ui.xj) {
            this.w = (com.bytedance.sdk.openadsdk.core.dislike.ui.xj) cVar;
        }
    }

    public void setDislikeOuter(Dialog dialog) {
        this.u = dialog;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    public void setThemeChangeReceiver(ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        if (themeStatusBroadcastReceiver == null) {
            return;
        }
        themeStatusBroadcastReceiver.xj(this);
    }

    public abstract void xj(View view, int i, com.bytedance.sdk.openadsdk.core.ra.ra raVar);

    public void xj(View view, boolean z) {
        final com.bytedance.sdk.openadsdk.core.hf.hf hfVar;
        if (view == null) {
            return;
        }
        if (z) {
            Context context = this.xj;
            ws wsVar = this.hf;
            String str = this.kd;
            hfVar = new com.bytedance.sdk.openadsdk.core.hf.xj(context, wsVar, str, wo.hf(str));
        } else {
            Context context2 = this.xj;
            ws wsVar2 = this.hf;
            String str2 = this.kd;
            hfVar = new com.bytedance.sdk.openadsdk.core.hf.hf(context2, wsVar2, str2, wo.hf(str2));
        }
        view.setOnTouchListener(hfVar);
        view.setOnClickListener(hfVar);
        w wVar = new w() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.w
            public void xj(View view2, int i, com.bytedance.sdk.openadsdk.core.ra.ra raVar) {
                try {
                    raVar.xj().put("click_extra_map", ((com.bytedance.sdk.openadsdk.core.hf.xj.w.xj) hfVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.w.xj.class)).kd());
                } catch (JSONException unused) {
                }
                BackupView.this.xj(view2, i, raVar);
            }
        };
        com.bytedance.sdk.openadsdk.core.hf.xj.hf.xj xjVar = (com.bytedance.sdk.openadsdk.core.hf.xj.hf.xj) hfVar.xj(com.bytedance.sdk.openadsdk.core.hf.xj.hf.xj.class);
        if (xjVar != null) {
            xjVar.xj(wVar);
            xjVar.xj(z ? 2 : 1);
        }
    }

    public void hf(int i) {
        this.tf = com.bytedance.sdk.openadsdk.core.pz.hf().u(this.f);
        int c = com.bytedance.sdk.openadsdk.core.pz.hf().c(i);
        if (3 == c) {
            this.d = false;
            return;
        }
        if (1 != c || !com.bytedance.sdk.component.utils.am.u(this.xj)) {
            if (2 == c) {
                if (com.bytedance.sdk.component.utils.am.kd(this.xj) || com.bytedance.sdk.component.utils.am.u(this.xj) || com.bytedance.sdk.component.utils.am.y(this.xj)) {
                    this.d = true;
                    return;
                }
                return;
            }
            if (5 != c) {
                return;
            }
            if (!com.bytedance.sdk.component.utils.am.u(this.xj) && !com.bytedance.sdk.component.utils.am.y(this.xj)) {
                return;
            }
        }
        this.d = true;
    }

    public View xj(final NativeExpressView nativeExpressView) {
        BackupView backupView;
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2 = this.g;
        if (nativeVideoTsView2 != null) {
            return nativeVideoTsView2;
        }
        if (this.hf != null && this.xj != null) {
            if (hf()) {
                try {
                    backupView = this;
                } catch (Throwable unused) {
                    backupView = this;
                }
                try {
                    NativeVideoTsView xj = backupView.xj(this.xj, this.hf, this.kd, true, false);
                    backupView.g = xj;
                    xj.setAdCreativeClickListener(new NativeVideoTsView.xj() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.2
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.xj
                        public void xj(View view, int i) {
                            xj expressInteractionListener = nativeExpressView.getExpressInteractionListener();
                            if (expressInteractionListener == null) {
                                return;
                            }
                            expressInteractionListener.xj(view, i);
                        }
                    });
                    backupView.g.setVideoCacheUrl(backupView.p);
                    backupView.g.setControllerStatusCallBack(new NativeVideoTsView.u() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.3
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.u
                        public void xj(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                            com.bytedance.sdk.openadsdk.core.multipro.hf.xj xjVar = BackupView.this.f10374pl;
                            xjVar.xj = z;
                            xjVar.kd = j;
                            xjVar.y = j2;
                            xjVar.c = j3;
                            xjVar.u = z2;
                            xjVar.f = z3;
                        }
                    });
                    backupView.g.setIsAutoPlay(backupView.d);
                    backupView.g.setIsQuiet(backupView.tf);
                } catch (Throwable unused2) {
                    backupView.g = null;
                    if (hf()) {
                        return backupView.g;
                    }
                    return null;
                }
            } else {
                backupView = this;
            }
            if (hf() && (nativeVideoTsView = backupView.g) != null && nativeVideoTsView.xj(0L, true, false)) {
                return backupView.g;
            }
        }
        return null;
    }

    public NativeVideoTsView xj(Context context, ws wsVar, String str, boolean z, boolean z2) {
        return new NativeVideoTsView(context, wsVar, str, z, z2);
    }

    public void xj(View view) {
        if (h.am(this.hf) == null || view == null) {
            return;
        }
        xj(view, this.hf.dq() == 1 && this.d);
    }
}
