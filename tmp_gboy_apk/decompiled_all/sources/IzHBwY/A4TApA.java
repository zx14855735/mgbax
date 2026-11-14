package IzHBwY;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.game.boy.activity.EmulatorActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.sidesheet.SideSheetBehavior;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f4103A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f4104A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f4105A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public Object f4106ADYaiT;
    public Object AMqCpz;

    public /* synthetic */ A4TApA() {
        this.f4103A2egSU = 0;
    }

    public static final A4TApA ADYaiT() {
        A4TApA a4TApA = new A4TApA();
        a4TApA.f4105A5SV6n = false;
        a4TApA.f4104A4TApA = -1;
        a4TApA.f4106ADYaiT = null;
        a4TApA.AMqCpz = null;
        return a4TApA;
    }

    public void A2egSU(int i) {
        switch (this.f4103A2egSU) {
            case 2:
                BottomSheetBehavior bottomSheetBehavior = (BottomSheetBehavior) this.AMqCpz;
                WeakReference weakReference = bottomSheetBehavior.f11436DV2E8K;
                if (weakReference != null && weakReference.get() != null) {
                    this.f4104A4TApA = i;
                    if (!this.f4105A5SV6n) {
                        ((View) bottomSheetBehavior.f11436DV2E8K.get()).postOnAnimation((LLYwnm.AMqCpz) this.f4106ADYaiT);
                        this.f4105A5SV6n = true;
                        break;
                    }
                }
                break;
            default:
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) this.AMqCpz;
                WeakReference weakReference2 = sideSheetBehavior.f11803BPw6Q8;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.f4104A4TApA = i;
                    if (!this.f4105A5SV6n) {
                        ((View) sideSheetBehavior.f11803BPw6Q8.get()).postOnAnimation((CtFAbx.A2egSU) this.f4106ADYaiT);
                        this.f4105A5SV6n = true;
                        break;
                    }
                }
                break;
        }
    }

    public boolean A4TApA() {
        EmulatorActivity emulatorActivity = (EmulatorActivity) this.f4106ADYaiT;
        BluetoothAdapter bluetoothAdapter = (BluetoothAdapter) this.AMqCpz;
        if (bluetoothAdapter == null) {
            Toast.makeText(emulatorActivity, "设备不支持蓝牙", 0).show();
            this.f4105A5SV6n = false;
        } else if (bluetoothAdapter.isEnabled()) {
            this.f4105A5SV6n = true;
            Toast.makeText(emulatorActivity, "蓝牙已启用", 0).show();
        } else {
            emulatorActivity.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), this.f4104A4TApA);
            this.f4105A5SV6n = false;
        }
        return this.f4105A5SV6n;
    }

    public A2egSU A5SV6n() {
        boolean z = this.f4105A5SV6n;
        int i = this.f4104A4TApA;
        String str = (String) this.f4106ADYaiT;
        ValueSet valueSet = (ValueSet) this.AMqCpz;
        if (valueSet == null) {
            valueSet = ARc23Z.A4TApA().A2egSU();
        }
        return new A2egSU(z, i, str, valueSet);
    }

    public A4TApA(EmulatorActivity emulatorActivity, int i) {
        this.f4103A2egSU = 1;
        this.f4105A5SV6n = false;
        this.f4106ADYaiT = emulatorActivity;
        this.f4104A4TApA = i;
        this.AMqCpz = BluetoothAdapter.getDefaultAdapter();
    }

    public A4TApA(SideSheetBehavior sideSheetBehavior) {
        this.f4103A2egSU = 3;
        this.AMqCpz = sideSheetBehavior;
        this.f4106ADYaiT = new CtFAbx.A2egSU(8, this);
    }

    public A4TApA(BottomSheetBehavior bottomSheetBehavior) {
        this.f4103A2egSU = 2;
        this.AMqCpz = bottomSheetBehavior;
        this.f4106ADYaiT = new LLYwnm.AMqCpz(20, this);
    }
}
