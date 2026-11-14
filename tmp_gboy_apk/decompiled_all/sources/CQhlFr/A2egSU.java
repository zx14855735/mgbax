package CQhlFr;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU extends ClickableSpan {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f1754AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final AYUAbz f1755AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f1756AmA8tU;

    public A2egSU(int i, AYUAbz aYUAbz, int i2) {
        this.f1754AcNBzu = i;
        this.f1755AlLFFp = aYUAbz;
        this.f1756AmA8tU = i2;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f1754AcNBzu);
        this.f1755AlLFFp.f1773A2egSU.performAction(this.f1756AmA8tU, bundle);
    }
}
