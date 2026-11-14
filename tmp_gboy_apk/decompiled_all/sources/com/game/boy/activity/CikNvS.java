package com.game.boy.activity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.view.View;
import android.widget.Toast;
import com.kuaishou.weapon.p0.g;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class CikNvS implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10957AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ PermissionsActivity f10958AlLFFp;

    public /* synthetic */ CikNvS(PermissionsActivity permissionsActivity, int i) {
        this.f10957AcNBzu = i;
        this.f10958AlLFFp = permissionsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        CcAIMM ccAIMM;
        boolean isIgnoringBatteryOptimizations;
        PermissionsActivity permissionsActivity = this.f10958AlLFFp;
        boolean z = false;
        switch (this.f10957AcNBzu) {
            case 0:
                int currentItem = permissionsActivity.f11080B3GDIM.getCurrentItem();
                int size = permissionsActivity.f11084BChYOn.f4772AcNBzu.size() - 1;
                LLiCI0.C2rE4F c2rE4F = (LLiCI0.C2rE4F) permissionsActivity.f11084BChYOn.f4772AcNBzu.get(currentItem);
                if (!c2rE4F.AMqCpz) {
                    if (!permissionsActivity.AaHO0E(c2rE4F.f4767ADYaiT)) {
                        if (currentItem >= size) {
                            permissionsActivity.AmA8tU();
                            break;
                        } else {
                            permissionsActivity.f11080B3GDIM.A4TApA(currentItem + 1, true);
                            break;
                        }
                    } else if (currentItem > 0) {
                        permissionsActivity.f11080B3GDIM.A4TApA(currentItem - 1, true);
                        break;
                    }
                } else if (currentItem > 0) {
                    permissionsActivity.f11080B3GDIM.A4TApA(currentItem - 1, true);
                    break;
                }
                break;
            default:
                int currentItem2 = permissionsActivity.f11080B3GDIM.getCurrentItem();
                int size2 = permissionsActivity.f11084BChYOn.f4772AcNBzu.size() - 1;
                LLiCI0.C2rE4F c2rE4F2 = (LLiCI0.C2rE4F) permissionsActivity.f11084BChYOn.f4772AcNBzu.get(currentItem2);
                int i = c2rE4F2.f4767ADYaiT;
                if (i != 0 && !permissionsActivity.AaHO0E(i) && (ccAIMM = (CcAIMM) permissionsActivity.f11078B25kr6.get(c2rE4F2.f4767ADYaiT)) != null) {
                    switch (ccAIMM.f10950A2egSU) {
                        case 0:
                            String[] strArr = PermissionsActivity.f11076BI9f7h;
                            ccAIMM.f10951A4TApA.AcNBzu(1, "通知权限", "需要通知权限以便及时接收重要消息", new String[]{"android.permission.POST_NOTIFICATIONS"});
                            break;
                        case 1:
                            int i2 = Build.VERSION.SDK_INT;
                            PermissionsActivity permissionsActivity2 = ccAIMM.f10951A4TApA;
                            if (i2 >= 30) {
                                String[] strArr2 = PermissionsActivity.f11076BI9f7h;
                                if (i2 >= 30) {
                                    try {
                                        z = Environment.isExternalStorageManager();
                                    } catch (Exception unused) {
                                    }
                                } else {
                                    z = true;
                                }
                                if (!z) {
                                    permissionsActivity2.AlLFFp();
                                    break;
                                }
                            }
                            permissionsActivity2.AcNBzu(2, "存储权限", "需要存储权限以保存游戏进度和截图", PermissionsActivity.f11076BI9f7h);
                            break;
                        case 2:
                            String[] strArr3 = PermissionsActivity.f11076BI9f7h;
                            int i3 = Build.VERSION.SDK_INT;
                            PermissionsActivity permissionsActivity3 = ccAIMM.f10951A4TApA;
                            if (i3 < 23) {
                                permissionsActivity3.AzWtSf();
                                break;
                            } else {
                                PowerManager powerManager = (PowerManager) permissionsActivity3.getSystemService("power");
                                if (powerManager != null) {
                                    isIgnoringBatteryOptimizations = powerManager.isIgnoringBatteryOptimizations(permissionsActivity3.getPackageName());
                                    if (isIgnoringBatteryOptimizations) {
                                        permissionsActivity3.AzWtSf();
                                        break;
                                    }
                                }
                                try {
                                    try {
                                        try {
                                            Intent intent = new Intent();
                                            intent.setAction("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                                            intent.setData(Uri.parse("package:" + permissionsActivity3.getPackageName()));
                                            permissionsActivity3.startActivityForResult(intent, 103);
                                            break;
                                        } catch (Exception unused2) {
                                            permissionsActivity3.startActivityForResult(new Intent("android.settings.IGNORE_BATTERY_OPTIMIZATION_SETTINGS"), 103);
                                            return;
                                        }
                                    } catch (Exception unused3) {
                                        Toast.makeText(permissionsActivity3, "无法打开电池优化设置，请手动前往设置", 0).show();
                                        permissionsActivity3.AzWtSf();
                                        return;
                                    }
                                } catch (Exception unused4) {
                                    Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                                    intent2.setData(Uri.parse("package:" + permissionsActivity3.getPackageName()));
                                    permissionsActivity3.startActivityForResult(intent2, 103);
                                    return;
                                }
                            }
                        default:
                            int i4 = Build.VERSION.SDK_INT;
                            PermissionsActivity permissionsActivity4 = ccAIMM.f10951A4TApA;
                            if (i4 >= 23) {
                                BluetoothAdapter bluetoothAdapter = permissionsActivity4.f11079B2KMhB;
                                if (bluetoothAdapter != null) {
                                    boolean isEnabled = bluetoothAdapter.isEnabled();
                                    String[] strArr4 = PermissionsActivity.f11077BIYEnU;
                                    if (isEnabled) {
                                        permissionsActivity4.AcNBzu(4, "蓝牙权限", "需要蓝牙权限以连接外部设备", strArr4);
                                        break;
                                    } else if (i4 >= 31) {
                                        permissionsActivity4.AcNBzu(4, "蓝牙权限", "需要蓝牙权限以连接外部设备", strArr4);
                                        break;
                                    } else {
                                        try {
                                            Intent intent3 = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
                                            if (i4 < 23) {
                                                permissionsActivity4.startActivityForResult(intent3, 102);
                                            } else if (permissionsActivity4.AZOQYO(new String[]{g.g})) {
                                                permissionsActivity4.startActivityForResult(intent3, 102);
                                            } else {
                                                permissionsActivity4.AcNBzu(4, "蓝牙权限", "需要蓝牙和位置权限以连接外部设备", strArr4);
                                            }
                                            break;
                                        } catch (Exception unused5) {
                                            Toast.makeText(permissionsActivity4, "无法启用蓝牙", 0).show();
                                            permissionsActivity4.AzWtSf();
                                            return;
                                        }
                                    }
                                } else {
                                    Toast.makeText(permissionsActivity4, "设备不支持蓝牙", 0).show();
                                    permissionsActivity4.AzWtSf();
                                    break;
                                }
                            } else {
                                String[] strArr5 = PermissionsActivity.f11076BI9f7h;
                                permissionsActivity4.AzWtSf();
                                break;
                            }
                    }
                } else if (currentItem2 >= size2) {
                    permissionsActivity.AmA8tU();
                    break;
                } else {
                    permissionsActivity.f11080B3GDIM.A4TApA(currentItem2 + 1, true);
                    break;
                }
                break;
        }
    }
}
