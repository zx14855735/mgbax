package AZkASS;

import android.content.Context;
import android.view.ActionProvider;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B2KMhB extends COJEAR.A5SV6n implements ActionProvider.VisibilityListener {

    /* renamed from: A4TApA, reason: collision with root package name */
    public KCxDWD.A5SV6n f548A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ActionProvider f549A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ B9tovu f550ADYaiT;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B2KMhB(B9tovu b9tovu, Context context, ActionProvider actionProvider) {
        super(context);
        this.f550ADYaiT = b9tovu;
        this.f549A5SV6n = actionProvider;
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z) {
        KCxDWD.A5SV6n a5SV6n = this.f548A4TApA;
        if (a5SV6n != null) {
            AmA8tU amA8tU = ((B25kr6) a5SV6n.f4241AlLFFp).f533BJ7GGh;
            amA8tU.f500B4ZgIw = true;
            amA8tU.B25kr6(true);
        }
    }
}
