package IQ76hF;

import COJEAR.DG07BK;
import COJEAR.F32kj0;
import COJEAR.FG7pZc;
import CQhlFr.B7CMnp;
import L2suez.B9tovu;
import LLiCI0.CTkVKb;
import MOpbMP.BV3sI0;
import MOpbMP.BpkvW3;
import MOpbMP.CmUvjW;
import Mm8v1u.BPw6Q8;
import NGepWW.EH1KK8;
import NGepWW.EsrwYR;
import NGepWW.EwN40Z;
import Oay4Bh.C4FrIb;
import Oay4Bh.COJEAR;
import Oay4Bh.CQhlFr;
import OpB85q.B2KMhB;
import QgOIY0.CcAIMM;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.emoji2.text.B3GDIM;
import androidx.emoji2.text.BNL6CD;
import androidx.preference.Preference;
import com.game.boy.MyApp;
import com.game.boy.activity.BI9f7h;
import com.game.boy.activity.EmulatorActivity;
import com.game.boy.activity.SaveSlotsActivity;
import com.game.boy.view.BiosFilePreference;
import com.game.boy.viewUi.navigationView.ExpandableNavigationView;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigationrail.NavigationRailView;
import com.google.gson.Gson;
import com.sigmob.sdk.base.views.r;
import io.dcloud.ads.core.v2.feed.DCFeedAd;
import io.dcloud.ads.core.v2.feed.DCFeedAdLoadListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AmA8tU implements AcNBzu, BPw6Q8, Callback, LlW7FF.AMqCpz, DCFeedAdLoadListener, androidx.activity.result.A4TApA, androidx.swiperefreshlayout.widget.AZOQYO, DRlcZ9.AmA8tU, Mt2q9w.A5SV6n, EsrwYR, B7CMnp, O1nrJm.A4TApA, OLvDpK.AZOQYO, AZkASS.AcNBzu, COJEAR, B3GDIM {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3955AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object f3956AlLFFp;

    public /* synthetic */ AmA8tU() {
        this.f3955AcNBzu = 29;
    }

    public static void AzWtSf(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((androidx.viewpager2.adapter.ARc23Z) it.next()).getClass();
        }
    }

    private final void B3GDIM(String str) {
    }

    @Override // NGepWW.EsrwYR
    public void A2egSU(Bundle bundle) {
        NGepWW.A4TApA a4TApA = (NGepWW.A4TApA) this.f3956AlLFFp;
        ReentrantLock reentrantLock = a4TApA.f5670AlLFFp;
        ReentrantLock reentrantLock2 = a4TApA.f5670AlLFFp;
        reentrantLock.lock();
        try {
            Bundle bundle2 = a4TApA.f5666AZOQYO;
            if (bundle2 == null) {
                a4TApA.f5666AZOQYO = bundle;
            } else if (bundle != null) {
                bundle2.putAll(bundle);
            }
            a4TApA.f5667AZkASS = NOd7IU.A2egSU.f5852B25kr6;
            NGepWW.A4TApA.ARc23Z(a4TApA);
        } finally {
            reentrantLock2.unlock();
        }
    }

    @Override // NGepWW.EsrwYR
    public void A4TApA(NOd7IU.A2egSU a2egSU) {
        NGepWW.A4TApA a4TApA = (NGepWW.A4TApA) this.f3956AlLFFp;
        ReentrantLock reentrantLock = a4TApA.f5670AlLFFp;
        ReentrantLock reentrantLock2 = a4TApA.f5670AlLFFp;
        reentrantLock.lock();
        try {
            a4TApA.f5667AZkASS = a2egSU;
            NGepWW.A4TApA.ARc23Z(a4TApA);
        } finally {
            reentrantLock2.unlock();
        }
    }

    @Override // androidx.activity.result.A4TApA
    public void A5SV6n(Object obj) {
        Intent intent;
        androidx.activity.result.A2egSU a2egSU = (androidx.activity.result.A2egSU) obj;
        if (a2egSU.f7990AcNBzu != -1 || (intent = a2egSU.f7991AlLFFp) == null) {
            return;
        }
        Uri data = intent.getData();
        MS6BTZ.A4TApA a4TApA = (MS6BTZ.A4TApA) this.f3956AlLFFp;
        if (a4TApA.f5163B9tovu == null || data == null) {
            return;
        }
        try {
            a4TApA.getActivity().getContentResolver().takePersistableUriPermission(data, 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        a4TApA.f5163B9tovu.BniPrB(data);
    }

    @Override // CQhlFr.B7CMnp
    public boolean ADYaiT(View view) {
        SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.f3956AlLFFp;
        if (!swipeDismissBehavior.AMqCpz(view)) {
            return false;
        }
        boolean z = view.getLayoutDirection() == 1;
        int i = swipeDismissBehavior.f11345AzWtSf;
        DG07BK.AcNBzu((!(i == 0 && z) && (i != 1 || z)) ? view.getWidth() : -view.getWidth(), view);
        view.setAlpha(0.0f);
        return true;
    }

    @Override // Mt2q9w.A5SV6n
    public void AMqCpz(Mt2q9w.ASJ6gh aSJ6gh) {
        MenuItem AaHO0E2;
        ArrayList arrayList = aSJ6gh.AMqCpz;
        if (arrayList == null || arrayList.isEmpty()) {
            ExpandableNavigationView expandableNavigationView = (ExpandableNavigationView) this.f3956AlLFFp;
            if (expandableNavigationView.f11200CkXcdM == null || (AaHO0E2 = ExpandableNavigationView.AaHO0E(expandableNavigationView, aSJ6gh.f5537A4TApA)) == null) {
                return;
            }
            ((EmulatorActivity) expandableNavigationView.f11200CkXcdM).CQhlFr(AaHO0E2);
        }
    }

    @Override // LlW7FF.AMqCpz
    public void ARc23Z(String str) {
        switch (this.f3955AcNBzu) {
            case 8:
                break;
            case 9:
                Toast.makeText(((BV3sI0) this.f3956AlLFFp).f5055A5SV6n.requireActivity(), str, 0).show();
                break;
            default:
                ((CmUvjW) this.f3956AlLFFp).f5126AzWtSf.setEnabled(true);
                break;
        }
    }

    @Override // Mt2q9w.A5SV6n
    public void ASJ6gh(Mt2q9w.AYUAbz aYUAbz) {
        MenuItem AaHO0E2;
        ExpandableNavigationView expandableNavigationView = (ExpandableNavigationView) this.f3956AlLFFp;
        if (expandableNavigationView.f11200CkXcdM == null || (AaHO0E2 = ExpandableNavigationView.AaHO0E(expandableNavigationView, aYUAbz.f5541A4TApA)) == null) {
            return;
        }
        ((EmulatorActivity) expandableNavigationView.f11200CkXcdM).CQhlFr(AaHO0E2);
    }

    @Override // androidx.emoji2.text.B3GDIM
    public boolean AYUAbz(CharSequence charSequence, int i, int i2, BNL6CD bnl6cd) {
        if (!TextUtils.equals(charSequence.subSequence(i, i2), (String) this.f3956AlLFFp)) {
            return true;
        }
        bnl6cd.f8690A5SV6n = (bnl6cd.f8690A5SV6n & 3) | 4;
        return false;
    }

    @Override // Oay4Bh.COJEAR
    public FG7pZc AZOQYO(View view, FG7pZc fG7pZc, CQhlFr cQhlFr) {
        F32kj0 f32kj0 = fG7pZc.f1747A2egSU;
        BV3sI0.A5SV6n ARc23Z2 = f32kj0.ARc23Z(7);
        BV3sI0.A5SV6n ARc23Z3 = f32kj0.ARc23Z(r.b.d);
        NavigationRailView navigationRailView = (NavigationRailView) this.f3956AlLFFp;
        Boolean bool = navigationRailView.f11725BChYOn;
        if (bool != null ? bool.booleanValue() : navigationRailView.getFitsSystemWindows()) {
            cQhlFr.f6613A4TApA += ARc23Z2.f1483A4TApA;
        }
        Boolean bool2 = navigationRailView.f11726BI9f7h;
        if (bool2 != null ? bool2.booleanValue() : navigationRailView.getFitsSystemWindows()) {
            cQhlFr.f6615ADYaiT += ARc23Z2.f1485ADYaiT;
        }
        Boolean bool3 = navigationRailView.f11727BIYEnU;
        if (bool3 != null ? bool3.booleanValue() : navigationRailView.getFitsSystemWindows()) {
            if (C4FrIb.AlLFFp(view)) {
                cQhlFr.f6612A2egSU = Math.max(ARc23Z2.f1484A5SV6n, ARc23Z3.f1484A5SV6n) + cQhlFr.f6612A2egSU;
            } else {
                cQhlFr.f6612A2egSU = Math.max(ARc23Z2.f1482A2egSU, ARc23Z3.f1482A2egSU) + cQhlFr.f6612A2egSU;
            }
        }
        view.setPaddingRelative(cQhlFr.f6612A2egSU, cQhlFr.f6613A4TApA, cQhlFr.f6614A5SV6n, cQhlFr.f6615ADYaiT);
        return fG7pZc;
    }

    @Override // AZkASS.AcNBzu
    public boolean AZkASS(AZkASS.AmA8tU amA8tU, MenuItem menuItem) {
        B2KMhB b2KMhB = (B2KMhB) this.f3956AlLFFp;
        if (b2KMhB.f6795B2KMhB != null && menuItem.getItemId() == b2KMhB.getSelectedItemId()) {
            b2KMhB.f6795B2KMhB.getClass();
            return true;
        }
        OpB85q.AzWtSf azWtSf = b2KMhB.f6794B25kr6;
        if (azWtSf == null) {
            return false;
        }
        azWtSf.ASJ6gh(menuItem);
        return false;
    }

    @Override // DRlcZ9.AmA8tU
    public boolean AaHO0E(Preference preference) {
        BiosFilePreference biosFilePreference = (BiosFilePreference) this.f3956AlLFFp;
        biosFilePreference.getClass();
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        DRlcZ9.AmA8tU amA8tU = biosFilePreference.f9082B2KMhB;
        if (amA8tU == null) {
            return true;
        }
        amA8tU.AaHO0E(biosFilePreference);
        return true;
    }

    @Override // AZkASS.AcNBzu
    public void AcNBzu(AZkASS.AmA8tU amA8tU) {
    }

    public void AlLFFp(BI9f7h bI9f7h, EmulatorActivity emulatorActivity) {
        MF4Id8.A2egSU a2egSU = new MF4Id8.A2egSU(bI9f7h);
        NfcAdapter nfcAdapter = (NfcAdapter) this.f3956AlLFFp;
        nfcAdapter.setNdefPushMessageCallback(a2egSU, emulatorActivity, new Activity[0]);
        nfcAdapter.setOnNdefPushCompleteCallback(a2egSU, emulatorActivity, new Activity[0]);
    }

    public ArrayList AmA8tU() {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((CopyOnWriteArrayList) this.f3956AlLFFp).iterator();
        while (it.hasNext()) {
            ((androidx.viewpager2.adapter.ASJ6gh) it.next()).getClass();
            arrayList.add(androidx.viewpager2.adapter.ASJ6gh.f9553A2egSU);
        }
        return arrayList;
    }

    public boolean B25kr6() {
        EwN40Z ewN40Z = ((EH1KK8) this.f3956AlLFFp).f5792BI9f7h;
        return ewN40Z != null && ewN40Z.d();
    }

    public void B2KMhB(String str) {
        MOpbMP.AZkASS aZkASS = (MOpbMP.AZkASS) this.f3956AlLFFp;
        BluetoothAdapter bluetoothAdapter = aZkASS.f5020AcNBzu;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.cancelDiscovery();
        }
        Intent intent = new Intent();
        intent.putExtra("device_address", str);
        aZkASS.requireActivity().setResult(-1, intent);
        aZkASS.dismiss();
    }

    public void B4ZgIw(float f, float f2, float f3) {
        N8W1LJ.AmA8tU amA8tU = (N8W1LJ.AmA8tU) this.f3956AlLFFp;
        if (amA8tU.ADYaiT() < amA8tU.f5572B25kr6 || f < 1.0f) {
            amA8tU.getClass();
            amA8tU.f5580BIYEnU.postScale(f, f, f2, f3);
            amA8tU.A2egSU();
        }
    }

    public void B7CMnp(MTKlkd.ASJ6gh aSJ6gh) {
        boolean z;
        boolean ADYaiT2 = aSJ6gh.ADYaiT();
        BpkvW3 bpkvW3 = ((BV3sI0) this.f3956AlLFFp).f5055A5SV6n;
        if (!ADYaiT2) {
            Toast.makeText(bpkvW3.requireActivity(), aSJ6gh.A4TApA(), 0).show();
            return;
        }
        List<MTKlkd.ARc23Z> A2egSU2 = aSJ6gh.A2egSU();
        new Gson().toJson(aSJ6gh.A2egSU());
        bpkvW3.f5068B2KMhB.AMqCpz.add(new CTkVKb("获取游戏: " + A2egSU2.size()));
        if (!A2egSU2.isEmpty()) {
            for (MTKlkd.ARc23Z aRc23Z : A2egSU2) {
                if (aRc23Z.AZOQYO() != null) {
                    try {
                        z = L2suez.A2egSU.A5SV6n(new File(B9tovu.A2egSU("GBoy/rom"), aRc23Z.ARc23Z() + aRc23Z.getType()).getAbsolutePath(), aRc23Z.AZOQYO());
                    } catch (Exception unused) {
                        z = false;
                    }
                    if (z) {
                        aRc23Z.B3GDIM(3);
                    } else {
                        aRc23Z.B3GDIM(4);
                    }
                } else {
                    if (L2suez.A2egSU.A4TApA(new File(B9tovu.A2egSU("GBoy/rom"), aRc23Z.ARc23Z() + aRc23Z.getType()).getAbsolutePath())) {
                        aRc23Z.B3GDIM(3);
                    }
                }
                bpkvW3.f5068B2KMhB.AMqCpz.add(aRc23Z);
            }
        }
        bpkvW3.f5072B9tovu.post(new MOpbMP.A2egSU(this, 10, aSJ6gh));
    }

    public void B9tovu() {
        QgOIY0.B3GDIM b3gdim = (QgOIY0.B3GDIM) this.f3956AlLFFp;
        if (b3gdim.f7594AZOQYO) {
            return;
        }
        b3gdim.f7594AZOQYO = true;
        CcAIMM ccAIMM = b3gdim.f7592ASJ6gh;
        if (ccAIMM != null) {
            ccAIMM.A5SV6n();
        } else if (!b3gdim.f7593AYUAbz) {
            CcAIMM A5SV6n2 = b3gdim.A5SV6n("(root)", true, false);
            b3gdim.f7592ASJ6gh = A5SV6n2;
            if (A5SV6n2 != null && !A5SV6n2.f7702ADYaiT) {
                A5SV6n2.A5SV6n();
            }
        }
        b3gdim.f7593AYUAbz = true;
    }

    public void BChYOn(Serializable serializable) {
        ((PrintWriter) this.f3956AlLFFp).println(serializable);
    }

    @Override // NGepWW.EsrwYR
    public void a(int i) {
        NOd7IU.A2egSU a2egSU;
        NGepWW.A4TApA a4TApA = (NGepWW.A4TApA) this.f3956AlLFFp;
        ReentrantLock reentrantLock = a4TApA.f5670AlLFFp;
        ReentrantLock reentrantLock2 = a4TApA.f5670AlLFFp;
        reentrantLock.lock();
        try {
            if (!a4TApA.f5669AcNBzu && (a2egSU = a4TApA.f5668AaHO0E) != null && a2egSU.A5SV6n()) {
                a4TApA.f5669AcNBzu = true;
                a4TApA.AMqCpz.a(i);
                return;
            }
            a4TApA.f5669AcNBzu = false;
            NGepWW.A4TApA.A2egSU(a4TApA, i);
        } finally {
            reentrantLock2.unlock();
        }
    }

    @Override // androidx.emoji2.text.B3GDIM
    public Object getResult() {
        return this;
    }

    @Override // io.dcloud.ads.core.v2.feed.DCFeedAdLoadListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaacaaaa.aaaaaaa0
    public void onError(int i, String str, JSONArray jSONArray) {
        MQlCFp.A5SV6n.AZkASS((MQlCFp.A5SV6n) this.f3956AlLFFp);
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        LlW7FF.A2egSU.f4866A5SV6n.post(new C4FrIb.A2egSU(this, iOException, 23, false));
    }

    @Override // io.dcloud.ads.core.v2.feed.DCFeedAdLoadListener
    public void onFeedAdLoad(List list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        DCFeedAd dCFeedAd = (DCFeedAd) list.get(0);
        dCFeedAd.setFeedAdListener(new I3HV03.A4TApA((MQlCFp.A5SV6n) this.f3956AlLFFp, dCFeedAd, 10, false));
        dCFeedAd.render();
    }

    @Override // androidx.swiperefreshlayout.widget.AZOQYO
    public void onRefresh() {
        Mi9UWv.ASJ6gh aSJ6gh = (Mi9UWv.ASJ6gh) this.f3956AlLFFp;
        if (new I3HV03.A4TApA(aSJ6gh.f5409B9tovu, (String) null).B25kr6("user_token") != null) {
            aSJ6gh.B9tovu();
        } else {
            aSJ6gh.f5409B9tovu.startActivityForResult(new Intent(aSJ6gh.f5409B9tovu, (Class<?>) SaveSlotsActivity.class).putExtra("romName", "login"), 1);
            aSJ6gh.f5405B2KMhB.setRefreshing(false);
        }
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        if (!response.isSuccessful()) {
            LlW7FF.A2egSU.f4866A5SV6n.post(new C4FrIb.A2egSU(this, response, 24, false));
            return;
        }
        try {
            MTKlkd.ASJ6gh aSJ6gh = (MTKlkd.ASJ6gh) LlW7FF.A2egSU.f4865A4TApA.fromJson(response.body().string(), MTKlkd.ASJ6gh.class);
            if (aSJ6gh.ADYaiT()) {
                ((AmA8tU) this.f3956AlLFFp).B7CMnp(aSJ6gh);
            } else {
                LlW7FF.A2egSU.f4866A5SV6n.post(new C4FrIb.A2egSU(this, aSJ6gh, 25, false));
            }
        } catch (Exception e) {
            LlW7FF.A2egSU.f4866A5SV6n.post(new C4FrIb.A2egSU(this, e, 26, false));
        }
    }

    @Override // LlW7FF.AMqCpz
    public void onSuccess(Object obj) {
        switch (this.f3955AcNBzu) {
            case 8:
                MTKlkd.A2egSU a2egSU = (MTKlkd.A2egSU) obj;
                if (a2egSU.A5SV6n()) {
                    LHpdLt.B9tovu b9tovu = (LHpdLt.B9tovu) this.f3956AlLFFp;
                    ((MOpbMP.B2KMhB) b9tovu.f4537AzWtSf).f5034B3GDIM.AlLFFp(a2egSU.A4TApA());
                    ((MaterialButton) b9tovu.f4536AmA8tU).setChecked(a2egSU.A4TApA());
                }
                MyApp.A2egSU(a2egSU.A2egSU());
                break;
            default:
                MTKlkd.AZkASS aZkASS = (MTKlkd.AZkASS) obj;
                CmUvjW cmUvjW = (CmUvjW) this.f3956AlLFFp;
                cmUvjW.f5126AzWtSf.setEnabled(true);
                if (aZkASS.AYUAbz()) {
                    cmUvjW.f5137BNL6CD.setText(CmUvjW.AZkASS(aZkASS.ADYaiT()));
                    cmUvjW.f5123AcNBzu.BJ7GGh("user_group", aZkASS.ADYaiT());
                }
                Toast.makeText(cmUvjW.getContext(), aZkASS.AMqCpz(), 0).show();
                break;
        }
    }

    public String toString() {
        switch (this.f3955AcNBzu) {
            case 0:
                return super.toString() + "{fragment=" + ((AzWtSf) this.f3956AlLFFp) + "}";
            default:
                return super.toString();
        }
    }

    public /* synthetic */ AmA8tU(int i, Object obj) {
        this.f3955AcNBzu = i;
        this.f3956AlLFFp = obj;
    }
}
