package com.google.android.material.datepicker;

import COJEAR.CmUvjW;
import COJEAR.DG07BK;
import Oay4Bh.C4FrIb;
import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AmA8tU<S> extends androidx.fragment.app.B4ZgIw {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final LinkedHashSet f11612AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final LinkedHashSet f11613AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f11614AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public BI9f7h f11615AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public A4TApA f11616B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public ARc23Z f11617B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public AlLFFp f11618B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f11619B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public CharSequence f11620B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f11621B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int f11622BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f11623BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public CharSequence f11624BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public int f11625BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public CharSequence f11626BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public int f11627BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public CharSequence f11628BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public int f11629BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public CharSequence f11630BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public TextView f11631BniPrB;
    public CheckableImageButton BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public PCV8se.AaHO0E f11632C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public boolean f11633C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public CharSequence f11634CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public CharSequence f11635CNPG0E;

    public AmA8tU() {
        new LinkedHashSet();
        new LinkedHashSet();
        this.f11612AcNBzu = new LinkedHashSet();
        this.f11613AlLFFp = new LinkedHashSet();
    }

    public static int AlLFFp(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(2131166384);
        Calendar A4TApA2 = BTvldC.A4TApA();
        A4TApA2.set(5, 1);
        Calendar A2egSU2 = BTvldC.A2egSU(A4TApA2);
        A2egSU2.get(2);
        A2egSU2.get(1);
        int maximum = A2egSU2.getMaximum(7);
        A2egSU2.getActualMaximum(5);
        A2egSU2.getTimeInMillis();
        int dimensionPixelSize = resources.getDimensionPixelSize(2131166390) * maximum;
        return ((maximum - 1) * resources.getDimensionPixelOffset(2131166404)) + dimensionPixelSize + (dimensionPixelOffset * 2);
    }

    public static boolean AmA8tU(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(P3rngT.A4TApA.ADYaiT(context, 2130969551, AlLFFp.class.getCanonicalName()).data, new int[]{i});
        boolean z = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    public final void AcNBzu() {
        if (getArguments().getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
    }

    @Override // androidx.fragment.app.B4ZgIw, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it = this.f11612AcNBzu.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnCancelListener) it.next()).onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f11614AmA8tU = bundle.getInt("OVERRIDE_THEME_RES_ID");
        if (bundle.getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.f11616B25kr6 = (A4TApA) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f11617B2KMhB = (ARc23Z) bundle.getParcelable("DAY_VIEW_DECORATOR_KEY");
        this.f11619B4ZgIw = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f11620B7CMnp = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f11622BChYOn = bundle.getInt("INPUT_MODE_KEY");
        this.f11623BI9f7h = bundle.getInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f11624BIYEnU = bundle.getCharSequence("POSITIVE_BUTTON_TEXT_KEY");
        this.f11625BJ7GGh = bundle.getInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f11626BNL6CD = bundle.getCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        this.f11627BPw6Q8 = bundle.getInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY");
        this.f11628BTvldC = bundle.getCharSequence("NEGATIVE_BUTTON_TEXT_KEY");
        this.f11629BV3sI0 = bundle.getInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY");
        this.f11630BmvVmW = bundle.getCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY");
        CharSequence charSequence = this.f11620B7CMnp;
        if (charSequence == null) {
            charSequence = requireContext().getResources().getText(this.f11619B4ZgIw);
        }
        this.f11634CASmeH = charSequence;
        if (charSequence != null) {
            CharSequence[] split = TextUtils.split(String.valueOf(charSequence), "\n");
            if (split.length > 1) {
                charSequence = split[0];
            }
        } else {
            charSequence = null;
        }
        this.f11635CNPG0E = charSequence;
    }

    @Override // androidx.fragment.app.B4ZgIw
    public final Dialog onCreateDialog(Bundle bundle) {
        Context requireContext = requireContext();
        requireContext();
        int i = this.f11614AmA8tU;
        if (i == 0) {
            AcNBzu();
            throw null;
        }
        Dialog dialog = new Dialog(requireContext, i);
        Context context = dialog.getContext();
        this.f11621B9tovu = AmA8tU(context, R.attr.windowFullscreen);
        this.f11632C2rE4F = new PCV8se.AaHO0E(context, null, 2130969551, 2131952863);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.f11235BJ7GGh, 2130969551, 2131952863);
        int color = obtainStyledAttributes.getColor(1, 0);
        obtainStyledAttributes.recycle();
        this.f11632C2rE4F.AmA8tU(context);
        this.f11632C2rE4F.B3GDIM(ColorStateList.valueOf(color));
        this.f11632C2rE4F.B2KMhB(dialog.getWindow().getDecorView().getElevation());
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.f11621B9tovu ? 2131493251 : 2131493250, viewGroup);
        Context context = inflate.getContext();
        if (this.f11621B9tovu) {
            inflate.findViewById(2131297663).setLayoutParams(new LinearLayout.LayoutParams(AlLFFp(context), -2));
        } else {
            inflate.findViewById(2131297664).setLayoutParams(new LinearLayout.LayoutParams(AlLFFp(context), -1));
        }
        ((TextView) inflate.findViewById(2131297675)).setAccessibilityLiveRegion(1);
        this.BpkvW3 = (CheckableImageButton) inflate.findViewById(2131297677);
        this.f11631BniPrB = (TextView) inflate.findViewById(2131297681);
        this.BpkvW3.setTag("TOGGLE_BUTTON_TAG");
        CheckableImageButton checkableImageButton = this.BpkvW3;
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, NOd7IU.AlLFFp.CQhlFr(context, 2131231347));
        stateListDrawable.addState(new int[0], NOd7IU.AlLFFp.CQhlFr(context, 2131231349));
        checkableImageButton.setImageDrawable(stateListDrawable);
        this.BpkvW3.setChecked(this.f11622BChYOn != 0);
        DG07BK.B4ZgIw(this.BpkvW3, null);
        CheckableImageButton checkableImageButton2 = this.BpkvW3;
        this.BpkvW3.setContentDescription(this.f11622BChYOn == 1 ? checkableImageButton2.getContext().getString(2131886599) : checkableImageButton2.getContext().getString(2131886601));
        this.BpkvW3.setOnClickListener(new Dphsd2.A2egSU(9, this));
        AcNBzu();
        throw null;
    }

    @Override // androidx.fragment.app.B4ZgIw, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it = this.f11613AlLFFp.iterator();
        while (it.hasNext()) {
            ((DialogInterface.OnDismissListener) it.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f11614AmA8tU);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        A4TApA a4TApA = this.f11616B25kr6;
        A2egSU a2egSU = new A2egSU();
        int i = A2egSU.f11573A4TApA;
        int i2 = A2egSU.f11573A4TApA;
        long j = a4TApA.f11575AcNBzu.f11643B2KMhB;
        long j2 = a4TApA.f11576AlLFFp.f11643B2KMhB;
        a2egSU.f11574A2egSU = Long.valueOf(a4TApA.f11578AzWtSf.f11643B2KMhB);
        AlLFFp alLFFp = this.f11618B3GDIM;
        B2KMhB b2KMhB = alLFFp == null ? null : alLFFp.f11601B25kr6;
        if (b2KMhB != null) {
            a2egSU.f11574A2egSU = Long.valueOf(b2KMhB.f11643B2KMhB);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("DEEP_COPY_VALIDATOR_KEY", a4TApA.f11577AmA8tU);
        B2KMhB A4TApA2 = B2KMhB.A4TApA(j);
        B2KMhB A4TApA3 = B2KMhB.A4TApA(j2);
        AMqCpz aMqCpz = (AMqCpz) bundle2.getParcelable("DEEP_COPY_VALIDATOR_KEY");
        Long l = a2egSU.f11574A2egSU;
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", new A4TApA(A4TApA2, A4TApA3, aMqCpz, l != null ? B2KMhB.A4TApA(l.longValue()) : null, a4TApA.f11579B25kr6));
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", this.f11617B2KMhB);
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f11619B4ZgIw);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f11620B7CMnp);
        bundle.putInt("INPUT_MODE_KEY", this.f11622BChYOn);
        bundle.putInt("POSITIVE_BUTTON_TEXT_RES_ID_KEY", this.f11623BI9f7h);
        bundle.putCharSequence("POSITIVE_BUTTON_TEXT_KEY", this.f11624BIYEnU);
        bundle.putInt("POSITIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f11625BJ7GGh);
        bundle.putCharSequence("POSITIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f11626BNL6CD);
        bundle.putInt("NEGATIVE_BUTTON_TEXT_RES_ID_KEY", this.f11627BPw6Q8);
        bundle.putCharSequence("NEGATIVE_BUTTON_TEXT_KEY", this.f11628BTvldC);
        bundle.putInt("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_RES_ID_KEY", this.f11629BV3sI0);
        bundle.putCharSequence("NEGATIVE_BUTTON_CONTENT_DESCRIPTION_KEY", this.f11630BmvVmW);
    }

    @Override // androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f11621B9tovu) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f11632C2rE4F);
            if (!this.f11633C4FrIb) {
                View findViewById = requireView().findViewById(2131296701);
                ColorStateList C2rE4F2 = JrXYwF.A4TApA.C2rE4F(findViewById.getBackground());
                C4FrIb.A2egSU(window, true, C2rE4F2 != null ? Integer.valueOf(C2rE4F2.getDefaultColor()) : null);
                int paddingTop = findViewById.getPaddingTop();
                int paddingLeft = findViewById.getPaddingLeft();
                int paddingRight = findViewById.getPaddingRight();
                int i = findViewById.getLayoutParams().height;
                LqstKO.AMqCpz aMqCpz = new LqstKO.AMqCpz();
                aMqCpz.f4933AcNBzu = i;
                aMqCpz.f4937B25kr6 = findViewById;
                aMqCpz.f4934AlLFFp = paddingLeft;
                aMqCpz.f4935AmA8tU = paddingTop;
                aMqCpz.f4936AzWtSf = paddingRight;
                WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
                CmUvjW.B9tovu(findViewById, aMqCpz);
                this.f11633C4FrIb = true;
            }
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(2131166392);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f11632C2rE4F, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new OOnEhG.A2egSU(requireDialog(), rect));
        }
        requireContext();
        int i2 = this.f11614AmA8tU;
        if (i2 == 0) {
            AcNBzu();
            throw null;
        }
        AcNBzu();
        A4TApA a4TApA = this.f11616B25kr6;
        ARc23Z aRc23Z = this.f11617B2KMhB;
        AlLFFp alLFFp = new AlLFFp();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", a4TApA);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", aRc23Z);
        bundle.putParcelable("CURRENT_MONTH_KEY", a4TApA.f11578AzWtSf);
        alLFFp.setArguments(bundle);
        this.f11618B3GDIM = alLFFp;
        BI9f7h bI9f7h = alLFFp;
        if (this.f11622BChYOn == 1) {
            AcNBzu();
            A4TApA a4TApA2 = this.f11616B25kr6;
            BI9f7h b25kr6 = new B25kr6();
            Bundle bundle2 = new Bundle();
            bundle2.putInt("THEME_RES_ID_KEY", i2);
            bundle2.putParcelable("DATE_SELECTOR_KEY", null);
            bundle2.putParcelable("CALENDAR_CONSTRAINTS_KEY", a4TApA2);
            b25kr6.setArguments(bundle2);
            bI9f7h = b25kr6;
        }
        this.f11615AzWtSf = bI9f7h;
        this.f11631BniPrB.setText((this.f11622BChYOn == 1 && getResources().getConfiguration().orientation == 2) ? this.f11635CNPG0E : this.f11634CASmeH);
        AcNBzu();
        getContext();
        throw null;
    }

    @Override // androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onStop() {
        this.f11615AzWtSf.f11657AcNBzu.clear();
        super.onStop();
    }
}
