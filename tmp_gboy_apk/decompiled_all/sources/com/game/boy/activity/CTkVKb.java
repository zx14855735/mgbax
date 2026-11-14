package com.game.boy.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class CTkVKb implements DialogInterface.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10948AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ PermissionsActivity f10949AlLFFp;

    public /* synthetic */ CTkVKb(PermissionsActivity permissionsActivity, int i) {
        this.f10948AcNBzu = i;
        this.f10949AlLFFp = permissionsActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        PermissionsActivity permissionsActivity = this.f10949AlLFFp;
        switch (this.f10948AcNBzu) {
            case 0:
                String[] strArr = PermissionsActivity.f11076BI9f7h;
                permissionsActivity.AzWtSf();
                break;
            case 1:
                if (Build.VERSION.SDK_INT < 30) {
                    PermissionsActivity.AYUAbz(permissionsActivity);
                    break;
                } else {
                    try {
                        Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                        intent.setData(Uri.parse("package:" + permissionsActivity.getPackageName()));
                        permissionsActivity.startActivityForResult(intent, 101);
                        break;
                    } catch (Exception unused) {
                        PermissionsActivity.AYUAbz(permissionsActivity);
                        return;
                    }
                }
            default:
                PermissionsActivity.AYUAbz(permissionsActivity);
                break;
        }
    }
}
