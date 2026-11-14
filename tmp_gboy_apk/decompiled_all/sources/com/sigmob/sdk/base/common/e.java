package com.sigmob.sdk.base.common;

import android.text.TextUtils;
import com.czhj.sdk.common.Constants;
import com.sigmob.sdk.base.common.ae;
import com.sigmob.sdk.base.common.h;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.LoadAdRequest;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.windad.WindAdRequest;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e implements h.b {
    private final List<BaseAdUnit> b;
    private final h.b c;
    private final LoadAdRequest d;

    /* renamed from: a, reason: collision with root package name */
    private final String f13126a = "AdListCacheManger";
    private final List<BaseAdUnit> e = new ArrayList();

    public e(List<BaseAdUnit> list, h.b bVar, LoadAdRequest loadAdRequest) {
        this.b = list;
        this.c = bVar;
        this.d = loadAdRequest;
    }

    @Override // com.sigmob.sdk.base.common.h.b
    public void a(BaseAdUnit baseAdUnit) {
        if (com.sigmob.sdk.base.utils.q.b(this.c)) {
            this.c.a(baseAdUnit);
        }
    }

    @Override // com.sigmob.sdk.base.common.h.b
    public void a(BaseAdUnit baseAdUnit, String str) {
        if (com.sigmob.sdk.base.utils.e.a(this.b)) {
            return;
        }
        BaseAdUnit baseAdUnit2 = this.b.get(0);
        if (baseAdUnit != baseAdUnit2) {
            com.sigmob.sdk.base.network.g.a(baseAdUnit, TextUtils.isEmpty(str) ? a.x : a.y);
            ae.a(PointCategory.LOADEND, TextUtils.isEmpty(str) ? "1" : Constants.FAIL, baseAdUnit, (WindAdRequest) null, this.d, (ae.a) null);
        } else {
            if (com.sigmob.sdk.base.utils.q.b(this.c)) {
                this.c.a(baseAdUnit2, str);
            }
            this.e.size();
        }
    }

    public boolean a(boolean z) {
        if (com.sigmob.sdk.base.utils.e.b(this.b)) {
            if (z) {
                BaseAdUnit baseAdUnit = this.b.get(0);
                if (baseAdUnit.getPlayMode() == 2) {
                    this.e.add(baseAdUnit);
                    h.g().a(baseAdUnit, this);
                }
            } else {
                for (int i = 0; i < this.b.size(); i++) {
                    BaseAdUnit baseAdUnit2 = this.b.get(i);
                    if (baseAdUnit2.getPlayMode() != 2) {
                        this.e.add(baseAdUnit2);
                        baseAdUnit2.setCatchVideo(true);
                        h.g().a(baseAdUnit2, this);
                    }
                }
            }
            this.e.size();
        }
        return com.sigmob.sdk.base.utils.e.b(this.e);
    }
}
