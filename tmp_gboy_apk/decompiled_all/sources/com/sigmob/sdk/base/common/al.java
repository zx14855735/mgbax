package com.sigmob.sdk.base.common;

import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.windad.WindAdRequest;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class al {

    /* renamed from: a, reason: collision with root package name */
    private String f13109a;
    private String b;
    private String c;
    private String d;
    private WindAdRequest e;
    private LoadAdRequest f;
    private ae.a g;
    private BaseAdUnit h;

    private al() {
    }

    public al a(ae.a aVar) {
        this.g = aVar;
        return this;
    }

    public al b(String str) {
        this.c = str;
        return this;
    }

    public al c(String str) {
        this.b = str;
        return this;
    }

    public al d(String str) {
        this.d = str;
        return this;
    }

    public al a(BaseAdUnit baseAdUnit) {
        this.h = baseAdUnit;
        return this;
    }

    public al a(LoadAdRequest loadAdRequest) {
        this.f = loadAdRequest;
        return this;
    }

    public al a(WindAdRequest windAdRequest) {
        this.e = windAdRequest;
        return this;
    }

    public static al a(String str) {
        al alVar = new al();
        alVar.f13109a = str;
        return alVar;
    }

    public void a() {
        PointEntitySigmob pointEntitySigmob = new PointEntitySigmob();
        pointEntitySigmob.setAc_type("5");
        pointEntitySigmob.setCategory(this.f13109a);
        pointEntitySigmob.setSub_category(this.b);
        if (com.sigmob.sdk.base.utils.o.b(this.c)) {
            pointEntitySigmob.setAdtype(this.c);
        }
        ae.a(this.f13109a, this.b, pointEntitySigmob, this.e);
        ae.a(this.f13109a, this.b, pointEntitySigmob, this.f);
        ae.a(this.f13109a, this.b, this.h, pointEntitySigmob);
        if (com.sigmob.sdk.base.utils.q.b(this.g)) {
            this.g.onAddExtra(pointEntitySigmob);
        }
        ae.a(pointEntitySigmob);
        pointEntitySigmob.commit();
    }
}
