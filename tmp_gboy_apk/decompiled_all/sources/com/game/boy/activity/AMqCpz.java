package com.game.boy.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import com.game.boy.service.FileService;
import com.kuaishou.weapon.p0.g;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10890AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ DeviceActivity f10891AlLFFp;

    public /* synthetic */ AMqCpz(DeviceActivity deviceActivity, int i) {
        this.f10890AcNBzu = i;
        this.f10891AlLFFp = deviceActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DeviceActivity deviceActivity = this.f10891AlLFFp;
        switch (this.f10890AcNBzu) {
            case 0:
                if (!FileService.f11116AzWtSf) {
                    int i = DeviceActivity.f10961BNL6CD;
                    int i2 = Build.VERSION.SDK_INT;
                    if (!(i2 >= 30 ? Environment.isExternalStorageManager() : BPw6Q8.ASJ6gh.A2egSU(deviceActivity, g.j) == 0)) {
                        if (i2 < 30) {
                            androidx.core.app.AYUAbz.requestPermissions(deviceActivity, new String[]{g.i, g.j}, 1002);
                            break;
                        } else {
                            try {
                                Intent intent = new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION");
                                intent.setData(Uri.parse("package:" + deviceActivity.getPackageName()));
                                deviceActivity.startActivityForResult(intent, 1002);
                                break;
                            } catch (Exception unused) {
                                deviceActivity.startActivityForResult(new Intent("android.settings.MANAGE_ALL_FILES_ACCESS_PERMISSION"), 1002);
                                return;
                            }
                        }
                    } else {
                        deviceActivity.AYUAbz("com.game.boy.utils.START_SERVER");
                        break;
                    }
                } else {
                    int i3 = DeviceActivity.f10961BNL6CD;
                    deviceActivity.AYUAbz("com.game.boy.utils.STOP_SERVER");
                    break;
                }
            default:
                if (!FileService.f11117B25kr6) {
                    int i4 = DeviceActivity.f10961BNL6CD;
                    deviceActivity.getClass();
                    String str = Build.VERSION.SDK_INT >= 33 ? "android.permission.NEARBY_WIFI_DEVICES" : g.g;
                    if (BPw6Q8.ASJ6gh.A2egSU(deviceActivity, str) != 0) {
                        androidx.core.app.AYUAbz.requestPermissions(deviceActivity, new String[]{str}, 1001);
                        break;
                    } else {
                        deviceActivity.AYUAbz("com.game.boy.utils.START_HOTSPOT");
                        break;
                    }
                } else {
                    int i5 = DeviceActivity.f10961BNL6CD;
                    deviceActivity.AYUAbz("com.game.boy.utils.STOP_HOTSPOT");
                    break;
                }
        }
    }
}
