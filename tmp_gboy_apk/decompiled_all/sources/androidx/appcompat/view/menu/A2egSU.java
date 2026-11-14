package androidx.appcompat.view.menu;

import AZkASS.AlLFFp;
import AZkASS.BmvVmW;
import AaHO0E.EicXu4;
import androidx.appcompat.view.menu.ActionMenuItemView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU extends EicXu4 {

    /* renamed from: B9tovu, reason: collision with root package name */
    public final /* synthetic */ ActionMenuItemView f8046B9tovu;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A2egSU(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.f8046B9tovu = actionMenuItemView;
    }

    @Override // AaHO0E.EicXu4
    public final BmvVmW A4TApA() {
        ActionMenuItemView.A2egSU a2egSU = this.f8046B9tovu.f8052BIYEnU;
        if (a2egSU != null) {
            return a2egSU.A2egSU();
        }
        return null;
    }

    @Override // AaHO0E.EicXu4
    public final boolean A5SV6n() {
        BmvVmW A4TApA2;
        ActionMenuItemView actionMenuItemView = this.f8046B9tovu;
        AlLFFp alLFFp = actionMenuItemView.f8050BChYOn;
        return alLFFp != null && alLFFp.A4TApA(actionMenuItemView.f8047B4ZgIw) && (A4TApA2 = A4TApA()) != null && A4TApA2.isShowing();
    }
}
