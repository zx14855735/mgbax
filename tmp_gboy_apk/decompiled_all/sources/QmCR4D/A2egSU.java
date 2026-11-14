package QmCR4D;

import QgOIY0.BNL6CD;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A2egSU implements LayoutInflater.Factory2, LayoutInflater.Factory {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final A4TApA f7758AcNBzu;

    public A2egSU(A4TApA a4TApA) {
        this.f7758AcNBzu = a4TApA;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        ((BNL6CD) this.f7758AcNBzu).ASJ6gh(null, str, context, attributeSet);
        return null;
    }

    public final String toString() {
        return getClass().getName() + "{" + this.f7758AcNBzu + "}";
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        ((BNL6CD) this.f7758AcNBzu).ASJ6gh(view, str, context, attributeSet);
        return null;
    }
}
