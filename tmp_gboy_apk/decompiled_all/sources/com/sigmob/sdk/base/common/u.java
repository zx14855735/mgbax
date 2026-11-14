package com.sigmob.sdk.base.common;

import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class u implements ah {

    /* renamed from: a, reason: collision with root package name */
    public static final String f13160a = "ExternalViewAbilitySessionManager";
    private final Set<t> b;
    private BaseAdUnit c;

    public u() {
        HashSet hashSet = new HashSet();
        this.b = hashSet;
        hashSet.add(new af());
    }

    @Override // com.sigmob.sdk.base.common.ah
    public void a() {
        SigmobLog.d("endDisplaySession() called");
        if (this.c == null) {
            SigmobLog.e("endDisplaySession() called mAdUnit is null");
            return;
        }
        Iterator<t> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().b(this.c);
        }
        this.c.setSessionManager(null);
        this.c.destroy();
        this.c = null;
    }

    public void a(int i, int i2) {
        if (this.c == null) {
            SigmobLog.e("onVideoPrepared() called mAdUnit is null");
            return;
        }
        Iterator<t> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(this.c, i, i2);
        }
    }

    @Override // com.sigmob.sdk.base.common.ah
    public void a(BaseAdUnit baseAdUnit) {
        if (baseAdUnit == null) {
            SigmobLog.e("createDisplaySession() called adUnit is null");
            return;
        }
        this.c = baseAdUnit;
        baseAdUnit.setSessionManager(this);
        Iterator<t> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(baseAdUnit);
        }
    }

    @Override // com.sigmob.sdk.base.common.ah
    public void a(String str, int i) {
        SigmobLog.d("ExternalViewAbilitySessionManager#recordDisplayEvent: event = " + str + ", currentPosition = " + i);
        if (this.c == null) {
            SigmobLog.e("recordDisplayEvent() called mAdUnit is null");
            return;
        }
        Iterator<t> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(this.c, str, i);
        }
    }

    public void a(boolean z, int i) {
        if (this.c == null) {
            SigmobLog.e("onVideoShowSkip() called mAdUnit is null");
            return;
        }
        Iterator<t> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(this.c, z, i);
        }
    }
}
