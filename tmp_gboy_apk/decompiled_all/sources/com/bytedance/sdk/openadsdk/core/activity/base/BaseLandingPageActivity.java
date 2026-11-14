package com.bytedance.sdk.openadsdk.core.activity.base;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.sdk.openadsdk.core.a.r;
import com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner;
import com.bytedance.sdk.openadsdk.core.hf.hf;
import com.bytedance.sdk.openadsdk.core.qt.f;
import com.bytedance.sdk.openadsdk.core.ra.kd;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.zg;
import com.bytedance.sdk.openadsdk.core.ugeno.y.xj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.sigmob.sdk.base.n;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BaseLandingPageActivity extends BaseThemeActivity {
    private boolean c;
    protected String hf;
    protected int u;
    protected String w;
    protected String xj;
    private UgenBanner y;

    private boolean hf() {
        zg yt = this.kd.yt();
        if (yt == null) {
            return false;
        }
        yt.xj(true);
        int w = yt.w();
        return (w == 1 || w == 2) && !this.c;
    }

    private xj xj() {
        zg yt = this.kd.yt();
        if (yt == null) {
            return null;
        }
        String y = yt.y();
        if (TextUtils.isEmpty(y)) {
            return null;
        }
        xj xjVar = new xj();
        xjVar.w(y);
        xjVar.hf(yt.c());
        xjVar.xj(y);
        return xjVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.w = intent.getStringExtra("event_tag");
        this.xj = intent.getStringExtra(MediationConstant.EXTRA_ADID);
        this.hf = intent.getStringExtra("log_extra");
        this.u = intent.getIntExtra(n.l, -1);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        zg yt;
        super.onDestroy();
        UgenBanner ugenBanner = this.y;
        if (ugenBanner != null) {
            ugenBanner.xj();
        }
        ws wsVar = this.kd;
        if (wsVar == null || (yt = wsVar.yt()) == null) {
            return;
        }
        yt.xj(false);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Window window = getWindow();
        if (window != null) {
            f.xj(window.getDecorView());
        }
        if (this.kd == null || !hf()) {
            return;
        }
        if (this.y == null) {
            this.y = new UgenBanner(this);
        }
        addContentView(this.y, new ViewGroup.LayoutParams(-1, -2));
        this.c = true;
        kd vh = this.kd.vh();
        String w = vh != null ? vh.w() : this.kd.ci();
        this.y.setTopMargin(r.w(this, 50.0f));
        this.y.xj(xj(), this.kd, new hf(this, this.kd, this.w, this.u), w, this.kd.kr(), "立即打开", true);
    }
}
