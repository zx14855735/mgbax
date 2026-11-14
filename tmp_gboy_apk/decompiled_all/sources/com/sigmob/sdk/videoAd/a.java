package com.sigmob.sdk.videoAd;

import android.content.Context;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.wire.Wire;
import com.sigmob.sdk.base.common.n;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.config.SigmobDialogSetting;
import com.sigmob.sdk.base.models.rtb.MaterialMeta;
import com.sigmob.sdk.base.models.rtb.RvAdSetting;
import com.sigmob.sdk.base.o;
import com.sigmob.sdk.base.views.n;
import java.io.Serializable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a extends com.sigmob.sdk.base.common.i implements Serializable {
    private static final long serialVersionUID = 2;
    private int r;
    private c t;
    private int u;
    private boolean v;
    protected float m = 1.0f;
    protected int n = -1000;
    protected int o = 100;
    protected boolean p = false;
    private int q = -1;
    private boolean s = false;
    protected boolean l = false;

    private a() {
    }

    public static a d(BaseAdUnit baseAdUnit) {
        a aVar = new a();
        aVar.c(baseAdUnit.getAd_type() == 1);
        aVar.d(baseAdUnit.getMaterial().video_reciprocal_millisecond.intValue());
        aVar.b(baseAdUnit.getMaterial().creative_type.intValue() != n.CreativeTypeVideo_transparent_html.a());
        RvAdSetting rvAdSetting = baseAdUnit.getRvAdSetting();
        SigmobDialogSetting y = o.a().y();
        aVar.a(y != null ? new c((String) Wire.get(y.title, ""), (String) Wire.get(y.body_text, ""), (String) Wire.get(y.cancel_button_text, ""), (String) Wire.get(y.close_button_text, "")) : new c(com.sigmob.sdk.base.k.l(), com.sigmob.sdk.base.k.k(), com.sigmob.sdk.base.k.n(), com.sigmob.sdk.base.k.m()));
        if (rvAdSetting != null) {
            aVar.a(rvAdSetting.enable_exit_on_video_close.booleanValue());
            aVar.a(rvAdSetting.finished.floatValue());
            aVar.c(rvAdSetting.end_time.intValue());
        }
        aVar.b(baseAdUnit);
        return aVar;
    }

    public void a(float f) {
        this.m = f;
    }

    public int b(int i) {
        int i2 = this.u;
        return (i2 == 0 || i2 * 1000 > i) ? i : i2 * 1000;
    }

    public void c(int i) {
        this.u = i;
    }

    public int e(int i) {
        return (int) ((this.o / 100.0f) * i);
    }

    @Override // com.sigmob.sdk.base.common.i
    public String f() {
        return this.h;
    }

    public int l() {
        return this.u;
    }

    public boolean m() {
        return this.s;
    }

    public float n() {
        return this.m;
    }

    public int o() {
        return this.n;
    }

    public boolean p() {
        return this.p;
    }

    public c q() {
        return this.t;
    }

    public int r() {
        return 0;
    }

    public boolean s() {
        return this.l;
    }

    public int t() {
        return this.q;
    }

    public static f e(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            return null;
        }
        MaterialMeta material = baseAdUnit.getMaterial();
        return new f(768, 1024, baseAdUnit.getInteractionType(), material.landing_page, material.deeplink_url, new com.sigmob.sdk.base.views.n(baseAdUnit.resourcePath(), baseAdUnit.getCreativeResourceType(), material.click_type.intValue() == 2 ? n.a.IMAGE : n.a.JAVASCRIPT, 720, 1024));
    }

    public void a(Context context, int i) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    @Override // com.sigmob.sdk.base.common.i
    public String b() {
        return this.i;
    }

    public void c(Context context, int i, int i2, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    @Override // com.sigmob.sdk.base.common.i
    public String d() {
        return this.f;
    }

    public void f(int i) {
        this.q = i;
    }

    public void a(Context context, int i, int i2, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void b(Context context, int i) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    @Override // com.sigmob.sdk.base.common.i
    public void c(String str) {
        if (str == null) {
            return;
        }
        this.f = str;
    }

    public void d(int i) {
        if (i == 0) {
            return;
        }
        this.n = i;
    }

    @Override // com.sigmob.sdk.base.common.i
    public String e() {
        return this.g;
    }

    private void c(boolean z) {
        this.l = z;
    }

    public void a(c cVar) {
        this.t = cVar;
    }

    public void b(Context context, int i, int i2, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    @Override // com.sigmob.sdk.base.common.i
    public void d(String str) {
        if (str == null) {
            return;
        }
        this.g = str;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void e(String str) {
        if (str == null) {
            return;
        }
        this.h = str;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void a(String str) {
        this.i = str;
    }

    @Override // com.sigmob.sdk.base.common.i
    public void b(Context context, int i, BaseAdUnit baseAdUnit) {
        Preconditions.NoThrow.checkNotNull(context, "context cannot be null");
    }

    public void a(boolean z) {
        this.s = z;
    }

    public void b(boolean z) {
        this.p = z;
    }

    public void a(boolean z, int i, int i2, BaseAdUnit baseAdUnit) {
    }
}
