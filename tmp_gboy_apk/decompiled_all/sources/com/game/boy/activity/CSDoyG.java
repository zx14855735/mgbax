package com.game.boy.activity;

import android.content.DialogInterface;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class CSDoyG implements DialogInterface.OnDismissListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10946AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ PermissionsActivity f10947AlLFFp;

    public /* synthetic */ CSDoyG(PermissionsActivity permissionsActivity, int i) {
        this.f10946AcNBzu = i;
        this.f10947AlLFFp = permissionsActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        PermissionsActivity permissionsActivity = this.f10947AlLFFp;
        switch (this.f10946AcNBzu) {
            case 0:
                String[] strArr = PermissionsActivity.f11076BI9f7h;
                permissionsActivity.AzWtSf();
                break;
            default:
                String[] strArr2 = PermissionsActivity.f11076BI9f7h;
                permissionsActivity.AzWtSf();
                break;
        }
    }
}
