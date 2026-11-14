package com.game.boy.activity;

import L2suez.ASJ6gh;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Environment;
import android.widget.CheckBox;
import com.game.boy.MyApp;
import com.game.boy.emu.gba.Console;
import com.game.boy.emu.gba.Link;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AlLFFp implements DialogInterface.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10903AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ EmulatorActivity f10904AlLFFp;

    public /* synthetic */ AlLFFp(EmulatorActivity emulatorActivity, int i) {
        this.f10903AcNBzu = i;
        this.f10904AlLFFp = emulatorActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f10903AcNBzu) {
            case 0:
                EmulatorActivity emulatorActivity = this.f10904AlLFFp;
                emulatorActivity.f11001BIYEnU = true;
                if (!((CheckBox) ((Dialog) dialogInterface).findViewById(2131296520)).isChecked()) {
                    emulatorActivity.f11024CtFAbx.edit().putBoolean("confirmOnClose", false).apply();
                }
                emulatorActivity.CtFAbx();
                break;
            case 1:
                EmulatorActivity emulatorActivity2 = this.f10904AlLFFp;
                emulatorActivity2.f11001BIYEnU = true;
                emulatorActivity2.finish();
                break;
            case 2:
                KpHwm4.B25kr6 b25kr6 = this.f10904AlLFFp.f11015CSDoyG;
                if (b25kr6 != null) {
                    b25kr6.f4356AYUAbz = true;
                    b25kr6.f4355ASJ6gh = false;
                    McNXgv.A4TApA a4TApA = b25kr6.f4351A4TApA;
                    if (a4TApA != null) {
                        a4TApA.interrupt();
                        break;
                    }
                }
                break;
            case 3:
                MSeBzj.ASJ6gh aSJ6gh = new MSeBzj.ASJ6gh();
                ArrayList arrayList = new ArrayList();
                if (MOpbMP.BpkvW3.f5062CNPG0E != null) {
                    String absolutePath = new File(Environment.getExternalStorageDirectory(), "GBoy/rom").getAbsolutePath();
                    StringBuilder A4TApA2 = B4ZgIw.AYUAbz.A4TApA(absolutePath);
                    A4TApA2.append(File.separator);
                    String sb = A4TApA2.toString();
                    Iterator it = MOpbMP.BpkvW3.f5062CNPG0E.iterator();
                    while (it.hasNext()) {
                        ASJ6gh.A2egSU a2egSU = (ASJ6gh.A2egSU) it.next();
                        File file = a2egSU.f4366A2egSU;
                        if (file != null) {
                            String absolutePath2 = file.getAbsolutePath();
                            if (absolutePath2.equals(absolutePath) || absolutePath2.startsWith(sb)) {
                                arrayList.add(a2egSU);
                            }
                        }
                    }
                }
                ArrayList arrayList2 = aSJ6gh.f5186AcNBzu;
                arrayList2.clear();
                arrayList2.addAll(arrayList);
                ArrayList arrayList3 = aSJ6gh.f5187AlLFFp;
                arrayList3.clear();
                arrayList3.addAll(arrayList2);
                Collections.sort(arrayList3, new MSeBzj.A5SV6n());
                MSeBzj.ARc23Z aRc23Z = aSJ6gh.f5189AzWtSf;
                if (aRc23Z != null) {
                    aRc23Z.notifyDataSetChanged();
                }
                aSJ6gh.f5188AmA8tU = new BJ7GGh(this);
                aSJ6gh.show(this.f10904AlLFFp.getSupportFragmentManager(), "game_picker");
                break;
            default:
                EmulatorActivity emulatorActivity3 = this.f10904AlLFFp;
                Console console = (Console) emulatorActivity3.f11004BPw6Q8.f11101A4TApA.get(i);
                String romHash = console.getRomHash();
                Link link = console.f11095A4TApA;
                Console A4TApA3 = link.A4TApA(-1, romHash);
                if (A4TApA3 != null) {
                    link.f11101A4TApA.add(A4TApA3);
                }
                A4TApA3.getClass();
                A4TApA3.f11096A5SV6n = console.f11096A5SV6n;
                A4TApA3.f11097ADYaiT = console.f11097ADYaiT;
                A4TApA3.AMqCpz = console.AMqCpz;
                A4TApA3.A2egSU();
                emulatorActivity3.AlLFFp(A4TApA3);
                emulatorActivity3.BChYOn(A4TApA3);
                int indexOf = emulatorActivity3.f11004BPw6Q8.f11101A4TApA.indexOf(A4TApA3);
                if (indexOf > 0) {
                    MyApp.A2egSU(emulatorActivity3.getString(2131886225, Integer.valueOf(indexOf + 1)));
                    break;
                }
                break;
        }
    }
}
