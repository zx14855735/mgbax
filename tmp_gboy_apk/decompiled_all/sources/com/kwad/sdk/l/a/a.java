package com.kwad.sdk.l.a;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class a implements c {
    protected List<c> bbC;
    protected boolean enabled;

    public a(boolean z) {
        this.enabled = z;
    }

    private List<c> getChildren() {
        return this.bbC;
    }

    @Override // com.kwad.sdk.l.a.c
    public final boolean cu(Context context) {
        if (!this.enabled) {
            return false;
        }
        List<c> children = getChildren();
        if (children == null || children.size() <= 0) {
            try {
                return cv(context);
            } catch (Throwable unused) {
                return false;
            }
        }
        Iterator<c> it = children.iterator();
        while (it.hasNext()) {
            if (it.next().cu(context)) {
                return true;
            }
        }
        return false;
    }

    public boolean cv(Context context) {
        return false;
    }

    public a() {
        this.enabled = true;
    }
}
