package com.sigmob.sdk.base.common;

import android.os.Bundle;
import com.sigmob.sdk.base.models.BaseAdUnit;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    protected p f13165a;
    protected BaseAdUnit b;
    private EventForwardingBroadcastReceiver c;

    public y(p pVar) {
        this.f13165a = pVar;
    }

    public abstract void a(p pVar);

    public void a(BaseAdUnit baseAdUnit, Bundle bundle) {
        EventForwardingBroadcastReceiver eventForwardingBroadcastReceiver = new EventForwardingBroadcastReceiver(baseAdUnit, this.f13165a, baseAdUnit.getUuid());
        this.c = eventForwardingBroadcastReceiver;
        eventForwardingBroadcastReceiver.a(eventForwardingBroadcastReceiver);
    }

    public abstract boolean a(BaseAdUnit baseAdUnit);

    public void b(BaseAdUnit baseAdUnit) {
        if (baseAdUnit != null) {
            h.b(baseAdUnit);
            baseAdUnit.destroy();
        }
        this.b = null;
        EventForwardingBroadcastReceiver eventForwardingBroadcastReceiver = this.c;
        if (eventForwardingBroadcastReceiver != null) {
            eventForwardingBroadcastReceiver.b(eventForwardingBroadcastReceiver);
        }
    }

    public void a(Map<String, Object> map, BaseAdUnit baseAdUnit) {
        this.b = baseAdUnit;
        a(this.f13165a);
    }
}
