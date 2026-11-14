package com.sigmob.sdk.mraid;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.logger.SigmobLogger;
import com.sigmob.sdk.base.views.am;
import com.sigmob.sdk.base.views.ap;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class l extends o {
    private final String e;
    private com.sigmob.sdk.base.views.v f;

    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public l(android.content.Context r1, java.lang.String r2, int r3, com.sigmob.sdk.base.models.BaseAdUnit r4) {
        /*
            r0 = this;
            r0.<init>(r2)
            java.lang.String r2 = "l"
            r0.e = r2
            if (r3 == 0) goto L27
            r2 = 1
            if (r3 == r2) goto L21
            r2 = 2
            if (r3 == r2) goto L1b
            r2 = 3
            if (r3 == r2) goto L13
            goto L2d
        L13:
            com.sigmob.sdk.base.views.ap r2 = new com.sigmob.sdk.base.views.ap
            r2.<init>(r1)
        L18:
            r0.f = r2
            goto L2d
        L1b:
            com.sigmob.sdk.base.views.am r2 = new com.sigmob.sdk.base.views.am
            r2.<init>(r1)
            goto L18
        L21:
            com.sigmob.sdk.base.views.aw r2 = new com.sigmob.sdk.base.views.aw
            r2.<init>(r1)
            goto L18
        L27:
            com.sigmob.sdk.base.views.ac r2 = new com.sigmob.sdk.base.views.ac
            r2.<init>(r1)
            goto L18
        L2d:
            r0.a(r1, r3)
            com.sigmob.sdk.base.views.v r1 = r0.f
            boolean r1 = com.sigmob.sdk.base.utils.q.b(r1)
            if (r1 == 0) goto L3d
            com.sigmob.sdk.base.views.v r1 = r0.f
            r1.a()
        L3d:
            com.sigmob.sdk.base.common.am$a r1 = r0.c
            boolean r1 = com.sigmob.sdk.base.utils.q.b(r1)
            if (r1 == 0) goto L4e
            com.sigmob.sdk.base.common.am$a r1 = r0.c
            com.sigmob.sdk.base.models.SensorEntity r2 = com.sigmob.sdk.base.models.SensorEntity.format(r4)
            r1.a(r2)
        L4e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid.l.<init>(android.content.Context, java.lang.String, int, com.sigmob.sdk.base.models.BaseAdUnit):void");
    }

    @Override // com.sigmob.sdk.mraid.n
    public View a() {
        return this.f;
    }

    @Override // com.sigmob.sdk.mraid.n
    public void b() {
        if (com.sigmob.sdk.base.utils.q.b(this.f)) {
            com.sigmob.sdk.base.utils.r.a(this.f);
            this.f = null;
        }
        if (com.sigmob.sdk.base.utils.q.b(this.c)) {
            this.c.c();
        }
    }

    @Override // com.sigmob.sdk.mraid.o
    public void a(float f) {
        com.sigmob.sdk.base.views.v vVar = this.f;
        if (vVar != null && (vVar instanceof ap)) {
            ((ap) vVar).a(f);
            SigmobLogger.d(this.e, "onMotionViewUpdateProcess: progress = " + f, new Object[0]);
        }
    }

    @Override // com.sigmob.sdk.mraid.o
    public void b(float f) {
        com.sigmob.sdk.base.views.v vVar = this.f;
        if (vVar != null && (vVar instanceof am)) {
            ((am) vVar).a(f);
            SigmobLogger.d(this.e, "onMotionViewUpdateScreen: progress = " + f, new Object[0]);
        }
    }

    public void a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (this.f == null || jSONObject == null || (optJSONObject = jSONObject.optJSONObject("frame")) == null) {
            return;
        }
        Context e = com.sigmob.sdk.b.e();
        int optDouble = (int) optJSONObject.optDouble("x", 0.0d);
        int optDouble2 = (int) optJSONObject.optDouble("y", 0.0d);
        int optDouble3 = (int) optJSONObject.optDouble(IAdInterListener.AdReqParam.WIDTH, -1.0d);
        int optDouble4 = (int) optJSONObject.optDouble("h", -1.0d);
        if (optDouble3 > 0) {
            optDouble3 = Dips.dipsToIntPixels(optDouble3, e);
        }
        if (optDouble4 > 0) {
            optDouble4 = Dips.dipsToIntPixels(optDouble4, e);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optDouble3, optDouble4);
        this.f.setX(Dips.dipsToIntPixels(optDouble, e));
        this.f.setY(Dips.dipsToIntPixels(optDouble2, e));
        this.f.setLayoutParams(layoutParams);
        this.f.requestLayout();
    }

    public void a(boolean z) {
        com.sigmob.sdk.base.views.v vVar = this.f;
        if (vVar == null || this.c == null) {
            return;
        }
        if (z) {
            vVar.setVisibility(4);
            this.c.b();
        } else {
            vVar.setVisibility(0);
            this.c.a();
        }
    }
}
