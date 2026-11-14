package MOpbMP;

import AaHO0E.FG7pZc;
import COJEAR.DG07BK;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class AZOQYO extends com.google.android.material.bottomsheet.AMqCpz {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public View f5017AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public BottomSheetDragHandleView f5018AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public BottomSheetBehavior f5019AmA8tU;

    public abstract int AcNBzu();

    @Override // androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override // com.google.android.material.bottomsheet.AMqCpz, ADYaiT.CrfGsy, androidx.fragment.app.B4ZgIw
    public final Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.ADYaiT aDYaiT = (com.google.android.material.bottomsheet.ADYaiT) super.onCreateDialog(bundle);
        aDYaiT.getWindow().setSoftInputMode(16);
        aDYaiT.setOnShowListener(new AYUAbz(this));
        aDYaiT.setOnKeyListener(new LLcl8r.A5SV6n(1, this));
        return aDYaiT;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(AcNBzu(), viewGroup, false);
        this.f5017AcNBzu = inflate;
        BottomSheetDragHandleView bottomSheetDragHandleView = (BottomSheetDragHandleView) inflate.findViewById(2131296610);
        this.f5018AlLFFp = bottomSheetDragHandleView;
        if (bottomSheetDragHandleView != null) {
            this.f5018AlLFFp.setOnTouchListener(new FG7pZc(2, new GestureDetector(requireContext(), new GJee0v.AzWtSf(1, this))));
        }
        return this.f5017AcNBzu;
    }

    @Override // androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        com.google.android.material.bottomsheet.ADYaiT aDYaiT = (com.google.android.material.bottomsheet.ADYaiT) getDialog();
        if (aDYaiT == null || (window = aDYaiT.getWindow()) == null) {
            return;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        COJEAR.FG7pZc AZOQYO2 = DG07BK.AZOQYO(requireActivity().getWindow().getDecorView());
        window.setLayout(-1, i - (AZOQYO2 == null ? 0 : AZOQYO2.f1747A2egSU.ARc23Z(1).f1483A4TApA));
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setGravity(80);
    }
}
