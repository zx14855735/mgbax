package MOpbMP;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import java.io.File;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CTkVKb extends com.google.android.material.bottomsheet.AMqCpz {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static final int[] f5108B4ZgIw = {10, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    /* renamed from: AcNBzu, reason: collision with root package name */
    public CSDoyG f5109AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public RecyclerView f5110AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public TabLayout f5111AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public View f5112AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final ArrayList f5113B25kr6 = new ArrayList();

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final ArrayList f5114B2KMhB = new ArrayList();

    /* renamed from: B3GDIM, reason: collision with root package name */
    public String f5115B3GDIM;

    public static void AcNBzu(CTkVKb cTkVKb, int i, int i2) {
        if (cTkVKb.getActivity() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("saveSlot", i2);
        intent.putExtra("action", i);
        cTkVKb.getActivity().setResult(-1, intent);
        cTkVKb.getActivity().finish();
    }

    public static File AlLFFp(File file) {
        return new File(KpHwm4.AYUAbz.A2egSU("screenshot").getAbsolutePath() + "/" + file.getName() + ".png");
    }

    public static File AmA8tU(int i, String str) {
        return new File(KpHwm4.AYUAbz.A2egSU("save"), str + ".SaveType" + i);
    }

    public final void AzWtSf(int i) {
        if (i != 0) {
            if (i == 1) {
                this.f5110AlLFFp.setVisibility(8);
                this.f5112AzWtSf.setVisibility(0);
                return;
            }
            return;
        }
        this.f5110AlLFFp.setVisibility(0);
        this.f5112AzWtSf.setVisibility(8);
        ArrayList arrayList = this.f5113B25kr6;
        arrayList.clear();
        ArrayList arrayList2 = this.f5114B2KMhB;
        arrayList2.clear();
        int[] iArr = f5108B4ZgIw;
        for (int i2 = 0; i2 < 11; i2++) {
            int i3 = iArr[i2];
            arrayList.add(AmA8tU(i3, this.f5115B3GDIM));
            arrayList2.add(Integer.valueOf(i3));
        }
        this.f5109AcNBzu.notifyDataSetChanged();
    }

    @Override // com.google.android.material.bottomsheet.AMqCpz, ADYaiT.CrfGsy, androidx.fragment.app.B4ZgIw
    public final Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.ADYaiT aDYaiT = (com.google.android.material.bottomsheet.ADYaiT) super.onCreateDialog(bundle);
        aDYaiT.setOnShowListener(new CASmeH());
        return aDYaiT;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(2131492902, viewGroup, false);
        this.f5115B3GDIM = getActivity().getIntent().getStringExtra("romName");
        TabLayout tabLayout = (TabLayout) inflate.findViewById(2131298055);
        this.f5111AmA8tU = tabLayout;
        TabLayout.A2egSU AZkASS2 = tabLayout.AZkASS();
        TabLayout tabLayout2 = AZkASS2.f11894ARc23Z;
        if (tabLayout2 == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        AZkASS2.A2egSU(tabLayout2.getResources().getText(2131886842));
        tabLayout.A4TApA(AZkASS2);
        TabLayout tabLayout3 = this.f5111AmA8tU;
        TabLayout.A2egSU AZkASS3 = tabLayout3.AZkASS();
        TabLayout tabLayout4 = AZkASS3.f11894ARc23Z;
        if (tabLayout4 == null) {
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }
        AZkASS3.A2egSU(tabLayout4.getResources().getText(2131886843));
        tabLayout3.A4TApA(AZkASS3);
        this.f5111AmA8tU.A2egSU(new CNPG0E(this));
        this.f5112AzWtSf = inflate.findViewById(2131297914);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(2131297796);
        this.f5110AlLFFp = recyclerView;
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        CSDoyG cSDoyG = new CSDoyG(this, this, this.f5113B25kr6, this.f5114B2KMhB);
        this.f5109AcNBzu = cSDoyG;
        this.f5110AlLFFp.setAdapter(cSDoyG);
        AzWtSf(0);
        return inflate;
    }

    @Override // androidx.fragment.app.B4ZgIw, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        getActivity().finish();
    }

    @Override // androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onStart() {
        View findViewById;
        super.onStart();
        com.google.android.material.bottomsheet.ADYaiT aDYaiT = (com.google.android.material.bottomsheet.ADYaiT) getDialog();
        if (aDYaiT == null || aDYaiT.getWindow() == null || (findViewById = aDYaiT.findViewById(2131296576)) == null) {
            return;
        }
        BottomSheetBehavior AaHO0E2 = BottomSheetBehavior.AaHO0E(findViewById);
        AaHO0E2.setState(3);
        AaHO0E2.f11423CrfGsy = true;
        AaHO0E2.setPeekHeight(getResources().getDisplayMetrics().heightPixels);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.height = -1;
        findViewById.setLayoutParams(layoutParams);
    }
}
