package MOpbMP;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.g;
import java.util.ArrayList;
import java.util.Set;

@TargetApi(5)
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AZkASS extends com.google.android.material.bottomsheet.AMqCpz implements View.OnClickListener, DialogInterface.OnDismissListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public BluetoothAdapter f5020AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public LLiCI0.AZOQYO f5021AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Button f5022AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final ADYaiT.CTkVKb f5023AzWtSf = new ADYaiT.CTkVKb(4, this);

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        int i = Build.VERSION.SDK_INT;
        ADYaiT.CTkVKb cTkVKb = this.f5023AzWtSf;
        if (i >= 33) {
            requireContext().registerReceiver(cTkVKb, intentFilter, 2);
        } else {
            requireContext().registerReceiver(cTkVKb, intentFilter);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        if (android.provider.Settings.Secure.getInt(requireContext().getContentResolver(), "location_mode", 0) != 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0021, code lost:
    
        if (r1 != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AcNBzu() {
        /*
            r5 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            r2 = 0
            r3 = 31
            if (r0 < r1) goto L4e
            if (r0 >= r3) goto L4e
            r1 = 28
            if (r0 < r1) goto L24
            android.content.Context r1 = r5.requireContext()
            java.lang.String r4 = "location"
            java.lang.Object r1 = r1.getSystemService(r4)
            android.location.LocationManager r1 = (android.location.LocationManager) r1
            if (r1 == 0) goto L35
            boolean r1 = I3HV03.ADYaiT.BIYEnU(r1)
            if (r1 == 0) goto L35
            goto L4e
        L24:
            android.content.Context r1 = r5.requireContext()
            android.content.ContentResolver r1 = r1.getContentResolver()
            java.lang.String r4 = "location_mode"
            int r1 = android.provider.Settings.Secure.getInt(r1, r4, r2)
            if (r1 == 0) goto L35
            goto L4e
        L35:
            android.content.Context r0 = r5.requireContext()
            java.lang.String r1 = "请先开启位置服务以便蓝牙扫描"
            r2 = 1
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)
            r0.show()
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "android.settings.LOCATION_SOURCE_SETTINGS"
            r0.<init>(r1)
            r5.startActivity(r0)
            return
        L4e:
            if (r0 < r3) goto L53
            java.lang.String r0 = "android.permission.BLUETOOTH_SCAN"
            goto L55
        L53:
            java.lang.String r0 = "android.permission.BLUETOOTH"
        L55:
            android.content.Context r1 = r5.requireContext()
            int r0 = BPw6Q8.ASJ6gh.A2egSU(r1, r0)
            if (r0 == 0) goto L6d
            android.content.Context r0 = r5.requireContext()
            java.lang.String r1 = "蓝牙扫描权限未授予"
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r1, r2)
            r0.show()
            return
        L6d:
            android.bluetooth.BluetoothAdapter r0 = r5.f5020AcNBzu
            boolean r0 = r0.isDiscovering()
            if (r0 == 0) goto L7a
            android.bluetooth.BluetoothAdapter r0 = r5.f5020AcNBzu
            r0.cancelDiscovery()
        L7a:
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            r0.<init>(r1)
            LLYwnm.AMqCpz r1 = new LLYwnm.AMqCpz
            r2 = 7
            r1.<init>(r2, r5)
            r2 = 200(0xc8, double:9.9E-322)
            r0.postDelayed(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: MOpbMP.AZkASS.AcNBzu():void");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2) {
            if (i2 == -1) {
                AcNBzu();
            } else {
                Toast.makeText(requireContext(), "蓝牙未开启", 0).show();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() == 2131296457) {
            String[] strArr = Build.VERSION.SDK_INT >= 31 ? new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN", g.g} : new String[]{"android.permission.BLUETOOTH", g.g};
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    BluetoothAdapter bluetoothAdapter = this.f5020AcNBzu;
                    if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
                        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 2);
                    } else {
                        AcNBzu();
                    }
                } else {
                    if (BPw6Q8.ASJ6gh.A2egSU(requireContext(), strArr[i]) != 0) {
                        androidx.core.app.AYUAbz.requestPermissions(requireActivity(), Build.VERSION.SDK_INT >= 31 ? new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN", g.g} : new String[]{"android.permission.BLUETOOTH", g.g}, 1);
                    } else {
                        i++;
                    }
                }
            }
            this.f5022AmA8tU.setVisibility(8);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2131492912, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(2131297796);
        requireContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        ArrayList arrayList = new ArrayList();
        IQ76hF.AmA8tU amA8tU = new IQ76hF.AmA8tU(7, this);
        LLiCI0.AZOQYO azoqyo = new LLiCI0.AZOQYO();
        azoqyo.f4690AcNBzu = arrayList;
        azoqyo.f4691AlLFFp = amA8tU;
        this.f5021AlLFFp = azoqyo;
        recyclerView.setAdapter(azoqyo);
        Button button = (Button) inflate.findViewById(2131296457);
        this.f5022AmA8tU = button;
        button.setOnClickListener(this);
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        this.f5020AcNBzu = defaultAdapter;
        if (defaultAdapter == null) {
            Toast.makeText(requireContext(), "设备不支持蓝牙", 1).show();
            dismiss();
            return inflate;
        }
        if (BPw6Q8.ASJ6gh.A2egSU(requireContext(), Build.VERSION.SDK_INT >= 31 ? "android.permission.BLUETOOTH_CONNECT" : "android.permission.BLUETOOTH") == 0) {
            Set<BluetoothDevice> bondedDevices = this.f5020AcNBzu.getBondedDevices();
            if (bondedDevices.isEmpty()) {
                this.f5021AlLFFp.A2egSU(new L2suez.A4TApA(getString(2131886651), "", 0));
            } else {
                for (BluetoothDevice bluetoothDevice : bondedDevices) {
                    this.f5021AlLFFp.A2egSU(new L2suez.A4TApA(bluetoothDevice.getName(), bluetoothDevice.getAddress(), 0));
                }
            }
        }
        registerReceiver();
        return inflate;
    }

    @Override // androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        BluetoothAdapter bluetoothAdapter = this.f5020AcNBzu;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.cancelDiscovery();
        }
        requireContext().unregisterReceiver(this.f5023AzWtSf);
    }

    @Override // androidx.fragment.app.B4ZgIw, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        activity.finish();
    }
}
