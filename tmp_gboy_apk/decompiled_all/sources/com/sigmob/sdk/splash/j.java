package com.sigmob.sdk.splash;

import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.ah;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class j implements ah {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13684a = "SplashViewAbilitySessionManager";
    private final HashSet<i> b;
    private BaseAdUnit c;

    public j() {
        HashSet<i> hashSet = new HashSet<>();
        this.b = hashSet;
        hashSet.add(new i());
    }

    @Override // com.sigmob.sdk.base.common.ah
    public void a() {
        if (this.c == null || com.sigmob.sdk.base.utils.e.a(this.b)) {
            SigmobLog.e("endDisplaySession() called adUnit is null.");
            return;
        }
        Iterator<i> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().b(this.c);
        }
        BaseAdUnit baseAdUnit = this.c;
        if (baseAdUnit == null) {
            return;
        }
        baseAdUnit.setSessionManager(null);
        this.c.destroy();
        this.c = null;
    }

    @Override // com.sigmob.sdk.base.common.ah
    public void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null || com.sigmob.sdk.base.utils.e.a(this.b)) {
            SigmobLog.e("createDisplaySession() called adUnit is null.");
            return;
        }
        Iterator<i> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(baseAdUnit);
        }
        this.c = baseAdUnit;
        baseAdUnit.setSessionManager(this);
    }

    @Override // com.sigmob.sdk.base.common.ah
    public void a(String str, int i) {
        SigmobLog.d("SplashViewAbilitySessionManager#recordDisplayEvent: event = " + str + ", currentPosition = " + i);
        if (this.c == null || com.sigmob.sdk.base.utils.e.a(this.b)) {
            SigmobLog.e("recordDisplayEvent() called adUnit is null.");
            return;
        }
        Iterator<i> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(this.c, str, i);
        }
    }
}
