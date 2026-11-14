package com.game.boy.activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.game.boy.MyApp;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ASJ6gh implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f10893AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f10894AlLFFp;

    public /* synthetic */ ASJ6gh(int i, Object obj) {
        this.f10893AcNBzu = i;
        this.f10894AlLFFp = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c = 1;
        Object obj = this.f10894AlLFFp;
        switch (this.f10893AcNBzu) {
            case 0:
                DownLoadActivity downLoadActivity = (DownLoadActivity) obj;
                downLoadActivity.f10976B4ZgIw.clear();
                ArrayList arrayList = downLoadActivity.f10976B4ZgIw;
                L5dZB6.A2egSU a2egSU = downLoadActivity.f10977B7CMnp;
                a2egSU.getClass();
                ArrayList arrayList2 = new ArrayList();
                SQLiteDatabase readableDatabase = a2egSU.getReadableDatabase();
                Cursor query = readableDatabase.query("downloads", null, null, null, null, null, "create_time DESC");
                if (query != null) {
                    if (query.moveToFirst()) {
                        do {
                            arrayList2.add(L5dZB6.A2egSU.A2egSU(query));
                        } while (query.moveToNext());
                    }
                    query.close();
                }
                readableDatabase.close();
                arrayList.addAll(arrayList2);
                downLoadActivity.runOnUiThread(new LLYwnm.AMqCpz(29, this));
                return;
            case 1:
                ((B7CMnp) ((ASJ6gh) obj).f10894AlLFFp).f10914AmA8tU.f11017CcAIMM.dismiss();
                return;
            case 2:
                B7CMnp b7CMnp = (B7CMnp) obj;
                try {
                    InetAddress byName = InetAddress.getByName(b7CMnp.f10913AlLFFp);
                    EmulatorActivity emulatorActivity = b7CMnp.f10914AmA8tU;
                    if (byName == null) {
                        MyApp.A2egSU(emulatorActivity.getString(2131886385));
                    } else {
                        emulatorActivity.f11015CSDoyG = EmulatorActivity.B25kr6(emulatorActivity);
                        EmulatorActivity.B2KMhB(emulatorActivity, "wifi_client");
                        KpHwm4.B25kr6 b25kr6 = emulatorActivity.f11015CSDoyG;
                        b25kr6.AMqCpz = false;
                        b25kr6.f4354ARc23Z = false;
                        b25kr6.ASJ6gh(new KpHwm4.AlLFFp(b25kr6, b25kr6, byName));
                    }
                    return;
                } catch (UnknownHostException unused) {
                    b7CMnp.f10914AmA8tU.runOnUiThread(new ASJ6gh(c == true ? 1 : 0, this));
                    MyApp.A2egSU(b7CMnp.f10914AmA8tU.getString(2131886385));
                    return;
                }
            case 3:
                BI9f7h bI9f7h = (BI9f7h) obj;
                if (bI9f7h.f10917AcNBzu.BniPrB()) {
                    bI9f7h.f10917AcNBzu.f11011CASmeH.ASJ6gh();
                    EmulatorActivity emulatorActivity2 = bI9f7h.f10917AcNBzu;
                    emulatorActivity2.getClass();
                    emulatorActivity2.AzWtSf(null);
                    bI9f7h.f10917AcNBzu.f11011CASmeH.AMqCpz();
                    bI9f7h.f10917AcNBzu.getClass();
                    return;
                }
                return;
            case 4:
                C4FrIb.B4ZgIw b4ZgIw = (C4FrIb.B4ZgIw) obj;
                ((ADYaiT.AmA8tU) b4ZgIw.f1584AmA8tU).dismiss();
                LayoutEditor layoutEditor = (LayoutEditor) b4ZgIw.f1585AzWtSf;
                int width = layoutEditor.f11057B3GDIM.getWidth();
                int height = layoutEditor.f11057B3GDIM.getHeight();
                layoutEditor.AZOQYO(layoutEditor.f11056B2KMhB.AZkASS(width, height, width > height));
                return;
            default:
                PermissionsActivity permissionsActivity = (PermissionsActivity) obj;
                try {
                    try {
                        LLiCI0.CASmeH cASmeH = permissionsActivity.f11084BChYOn;
                        if (cASmeH == null || cASmeH.f4772AcNBzu.size() <= 0) {
                            return;
                        }
                        LLiCI0.CASmeH cASmeH2 = permissionsActivity.f11084BChYOn;
                        cASmeH2.notifyItemRangeChanged(0, cASmeH2.f4772AcNBzu.size());
                        permissionsActivity.B25kr6(permissionsActivity.f11080B3GDIM.getCurrentItem());
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        String[] strArr = PermissionsActivity.f11076BI9f7h;
                        permissionsActivity.getClass();
                        return;
                    }
                } catch (Throwable th) {
                    String[] strArr2 = PermissionsActivity.f11076BI9f7h;
                    permissionsActivity.getClass();
                    throw th;
                }
        }
    }
}
