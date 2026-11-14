package com.google.android.material.search;

import ADYaiT.DUi7mC;
import AaHO0E.H0R8Px;
import COJEAR.BNL6CD;
import COJEAR.CmUvjW;
import COJEAR.DG07BK;
import COJEAR.Ddcejp;
import COJEAR.FG7pZc;
import HFjH17.AMqCpz;
import MOpbMP.B3GDIM;
import MOpbMP.BmvVmW;
import MOpbMP.BpkvW3;
import NOd7IU.AlLFFp;
import OLy1FW.AYUAbz;
import Oay4Bh.ADYaiT;
import Oay4Bh.C4FrIb;
import Ogw3zR.A4TApA;
import Ogw3zR.ASJ6gh;
import P8ccfD.ARc23Z;
import P8ccfD.AZOQYO;
import P8ccfD.AZkASS;
import P8ccfD.AzWtSf;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.B7CMnp;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.A2egSU;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.bumptech.glide.A5SV6n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.game.boy.activity.MainActivity;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.search.SearchView;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class SearchView extends FrameLayout implements A2egSU, A4TApA {

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public static final /* synthetic */ int f11758Cd8JRx = 0;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final View f11759AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ClippableRoundedCornerLayout f11760AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final View f11761AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final View f11762AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final FrameLayout f11763B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final FrameLayout f11764B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final MaterialToolbar f11765B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final Toolbar f11766B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final TextView f11767B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final LinearLayout f11768B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final EditText f11769BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final ImageButton f11770BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final View f11771BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final TouchObserverFrameLayout f11772BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final boolean f11773BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public final AzWtSf f11774BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public final DUi7mC f11775BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public final boolean f11776BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final OSA5Fl.A2egSU f11777BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final LinkedHashSet f11778BniPrB;
    public SearchBar BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public int f11779C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public boolean f11780C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public boolean f11781CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public boolean f11782CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public final int f11783COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public boolean f11784CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public boolean f11785CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public AZkASS f11786CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public HashMap f11787CcAIMM;

    public static class Behavior extends CoordinatorLayout.A2egSU {
        public Behavior() {
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.A2egSU
        public final boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            SearchView searchView = (SearchView) view;
            if (searchView.BpkvW3 != null || !(view2 instanceof SearchBar)) {
                return false;
            }
            searchView.setupWithSearchBar((SearchBar) view2);
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        super(PXXBzr.A2egSU.A2egSU(context, attributeSet, 2130969569, 2131952772), attributeSet, 2130969569);
        this.f11775BTvldC = new DUi7mC(this, this);
        this.f11778BniPrB = new LinkedHashSet();
        this.f11779C2rE4F = 16;
        this.f11786CTkVKb = AZkASS.f6976AlLFFp;
        Context context2 = getContext();
        TypedArray AmA8tU2 = C4FrIb.AmA8tU(context2, attributeSet, R$styleable.f11254CmUvjW, 2130969569, 2131952772, new int[0]);
        this.f11783COJEAR = AmA8tU2.getColor(11, 0);
        int resourceId = AmA8tU2.getResourceId(16, -1);
        int resourceId2 = AmA8tU2.getResourceId(0, -1);
        String string = AmA8tU2.getString(3);
        String string2 = AmA8tU2.getString(4);
        String string3 = AmA8tU2.getString(24);
        boolean z = AmA8tU2.getBoolean(27, false);
        this.f11780C4FrIb = AmA8tU2.getBoolean(8, true);
        this.f11781CASmeH = AmA8tU2.getBoolean(7, true);
        boolean z2 = AmA8tU2.getBoolean(17, false);
        this.f11782CNPG0E = AmA8tU2.getBoolean(9, true);
        this.f11776BV3sI0 = AmA8tU2.getBoolean(10, true);
        AmA8tU2.recycle();
        LayoutInflater.from(context2).inflate(2131493260, this);
        this.f11773BNL6CD = true;
        this.f11759AcNBzu = findViewById(2131297735);
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = (ClippableRoundedCornerLayout) findViewById(2131297734);
        this.f11760AlLFFp = clippableRoundedCornerLayout;
        this.f11761AmA8tU = findViewById(2131297727);
        View findViewById = findViewById(2131297737);
        this.f11762AzWtSf = findViewById;
        this.f11763B25kr6 = (FrameLayout) findViewById(2131297733);
        this.f11764B2KMhB = (FrameLayout) findViewById(2131297740);
        MaterialToolbar materialToolbar = (MaterialToolbar) findViewById(2131297739);
        this.f11765B3GDIM = materialToolbar;
        this.f11766B4ZgIw = (Toolbar) findViewById(2131297731);
        this.f11767B7CMnp = (TextView) findViewById(2131297736);
        this.f11768B9tovu = (LinearLayout) findViewById(2131297738);
        EditText editText = (EditText) findViewById(2131297732);
        this.f11769BChYOn = editText;
        ImageButton imageButton = (ImageButton) findViewById(2131297728);
        this.f11770BI9f7h = imageButton;
        View findViewById2 = findViewById(2131297730);
        this.f11771BIYEnU = findViewById2;
        TouchObserverFrameLayout touchObserverFrameLayout = (TouchObserverFrameLayout) findViewById(2131297729);
        this.f11772BJ7GGh = touchObserverFrameLayout;
        this.f11774BPw6Q8 = new AzWtSf(this);
        this.f11777BmvVmW = new OSA5Fl.A2egSU(context2);
        clippableRoundedCornerLayout.setOnTouchListener(new AMqCpz(1));
        setUpBackgroundViewElevationOverlay(getOverlayElevation());
        setUpHeaderLayout(resourceId);
        setSearchPrefixText(string3);
        if (resourceId2 != -1) {
            JrXYwF.A4TApA.DRlcZ9(editText, resourceId2);
        }
        editText.setText(string);
        editText.setHint(string2);
        if (z2) {
            materialToolbar.setNavigationIcon((Drawable) null);
        } else {
            materialToolbar.setNavigationOnClickListener(new P8ccfD.AMqCpz(this, 2));
            if (z) {
                ARc23Z.AZkASS aZkASS = new ARc23Z.AZkASS(getContext());
                int ASJ6gh2 = AYUAbz.ASJ6gh(2130968872, this);
                Paint paint = aZkASS.f305A2egSU;
                if (ASJ6gh2 != paint.getColor()) {
                    paint.setColor(ASJ6gh2);
                    aZkASS.invalidateSelf();
                }
                materialToolbar.setNavigationIcon(aZkASS);
            }
        }
        imageButton.setOnClickListener(new P8ccfD.AMqCpz(this, 0));
        editText.addTextChangedListener(new Mi9UWv.AMqCpz(2, this));
        touchObserverFrameLayout.setOnTouchListener(new FdMWEC.AMqCpz(1, this));
        C4FrIb.ASJ6gh(materialToolbar, new P8ccfD.AYUAbz(this));
        final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) findViewById2.getLayoutParams();
        final int i = marginLayoutParams.leftMargin;
        final int i2 = marginLayoutParams.rightMargin;
        BNL6CD bnl6cd = new BNL6CD() { // from class: P8ccfD.ASJ6gh
            @Override // COJEAR.BNL6CD
            public final FG7pZc B3GDIM(View view, FG7pZc fG7pZc) {
                int i3 = SearchView.f11758Cd8JRx;
                BV3sI0.A5SV6n ARc23Z2 = fG7pZc.f1747A2egSU.ARc23Z(MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_START_OFFSET);
                int i4 = i + ARc23Z2.f1482A2egSU;
                ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
                marginLayoutParams2.leftMargin = i4;
                marginLayoutParams2.rightMargin = i2 + ARc23Z2.f1484A5SV6n;
                return fG7pZc;
            }
        };
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        CmUvjW.B9tovu(findViewById2, bnl6cd);
        setUpStatusBarSpacer(getStatusBarHeight());
        CmUvjW.B9tovu(findViewById, new P8ccfD.AYUAbz(this));
    }

    public static void AMqCpz(SearchView searchView, FG7pZc fG7pZc) {
        int i = fG7pZc.f1747A2egSU.ARc23Z(MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_START_OFFSET).f1483A4TApA;
        searchView.setUpStatusBarSpacer(i);
        if (searchView.f11785CSDoyG) {
            return;
        }
        searchView.setStatusBarSpacerEnabledInternal(i > 0);
    }

    private Window getActivityWindow() {
        Activity activity = ADYaiT.getActivity(getContext());
        if (activity == null) {
            return null;
        }
        return activity.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar searchBar = this.BpkvW3;
        return searchBar != null ? searchBar.getCompatElevation() : getResources().getDimension(2131166140);
    }

    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private void setStatusBarSpacerEnabledInternal(boolean z) {
        this.f11762AzWtSf.setVisibility(z ? 0 : 8);
    }

    private void setUpBackgroundViewElevationOverlay(float f) {
        View view;
        OSA5Fl.A2egSU a2egSU = this.f11777BmvVmW;
        if (a2egSU == null || (view = this.f11761AmA8tU) == null) {
            return;
        }
        view.setBackgroundColor(a2egSU.A2egSU(f, this.f11783COJEAR));
    }

    private void setUpHeaderLayout(int i) {
        if (i != -1) {
            LayoutInflater from = LayoutInflater.from(getContext());
            FrameLayout frameLayout = this.f11763B25kr6;
            frameLayout.addView(from.inflate(i, (ViewGroup) frameLayout, false));
            frameLayout.setVisibility(0);
        }
    }

    private void setUpStatusBarSpacer(int i) {
        View view = this.f11762AzWtSf;
        if (view.getLayoutParams().height != i) {
            view.getLayoutParams().height = i;
            view.requestLayout();
        }
    }

    @Override // Ogw3zR.A4TApA
    public final void A2egSU(androidx.activity.A4TApA a4TApA) {
        SearchBar searchBar;
        if (AZOQYO() || (searchBar = this.BpkvW3) == null) {
            return;
        }
        searchBar.setPlaceholderText(this.f11769BChYOn.getText().toString());
        AzWtSf azWtSf = this.f11774BPw6Q8;
        SearchBar searchBar2 = azWtSf.f7003B25kr6;
        Ogw3zR.AYUAbz aYUAbz = azWtSf.f7001AmA8tU;
        aYUAbz.f6641ARc23Z = a4TApA;
        View view = aYUAbz.f6638A4TApA;
        aYUAbz.f6650AZkASS = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (searchBar2 != null) {
            aYUAbz.f6651AaHO0E = C4FrIb.A5SV6n(view, searchBar2);
        }
        aYUAbz.f6649AZOQYO = a4TApA.f7936A4TApA;
    }

    @Override // Ogw3zR.A4TApA
    public final void A4TApA(androidx.activity.A4TApA a4TApA) {
        if (AZOQYO() || this.BpkvW3 == null || Build.VERSION.SDK_INT < 34) {
            return;
        }
        AzWtSf azWtSf = this.f11774BPw6Q8;
        azWtSf.getClass();
        float f = a4TApA.f7937A5SV6n;
        if (f <= 0.0f) {
            return;
        }
        SearchBar searchBar = azWtSf.f7003B25kr6;
        float cornerSize = searchBar.getCornerSize();
        Ogw3zR.AYUAbz aYUAbz = azWtSf.f7001AmA8tU;
        androidx.activity.A4TApA a4TApA2 = aYUAbz.f6641ARc23Z;
        aYUAbz.f6641ARc23Z = a4TApA;
        if (a4TApA2 != null) {
            if (searchBar.getVisibility() != 4) {
                searchBar.setVisibility(4);
            }
            boolean z = a4TApA.f7938ADYaiT == 0;
            float interpolation = aYUAbz.f6637A2egSU.getInterpolation(f);
            View view = aYUAbz.f6638A4TApA;
            float width = view.getWidth();
            float height = view.getHeight();
            if (width > 0.0f && height > 0.0f) {
                float A2egSU2 = NdEzCJ.A2egSU.A2egSU(1.0f, 0.9f, interpolation);
                float f2 = aYUAbz.f6647ASJ6gh;
                float A2egSU3 = NdEzCJ.A2egSU.A2egSU(0.0f, Math.max(0.0f, ((width - (0.9f * width)) / 2.0f) - f2), interpolation) * (z ? 1 : -1);
                float min = Math.min(Math.max(0.0f, ((height - (A2egSU2 * height)) / 2.0f) - f2), aYUAbz.f6648AYUAbz);
                float f3 = a4TApA.f7936A4TApA - aYUAbz.f6649AZOQYO;
                float A2egSU4 = NdEzCJ.A2egSU.A2egSU(0.0f, min, Math.abs(f3) / height) * Math.signum(f3);
                if (!Float.isNaN(A2egSU2) && !Float.isNaN(A2egSU3) && !Float.isNaN(A2egSU4)) {
                    view.setScaleX(A2egSU2);
                    view.setScaleY(A2egSU2);
                    view.setTranslationX(A2egSU3);
                    view.setTranslationY(A2egSU4);
                    if (view instanceof ClippableRoundedCornerLayout) {
                        float[] A4TApA2 = aYUAbz.A4TApA();
                        ((ClippableRoundedCornerLayout) view).A2egSU(r22.getLeft(), r22.getTop(), r22.getRight(), r22.getBottom(), new float[]{NdEzCJ.A2egSU.A2egSU(A4TApA2[0], cornerSize, interpolation), NdEzCJ.A2egSU.A2egSU(A4TApA2[1], cornerSize, interpolation), NdEzCJ.A2egSU.A2egSU(A4TApA2[2], cornerSize, interpolation), NdEzCJ.A2egSU.A2egSU(A4TApA2[3], cornerSize, interpolation), NdEzCJ.A2egSU.A2egSU(A4TApA2[4], cornerSize, interpolation), NdEzCJ.A2egSU.A2egSU(A4TApA2[5], cornerSize, interpolation), NdEzCJ.A2egSU.A2egSU(A4TApA2[6], cornerSize, interpolation), NdEzCJ.A2egSU.A2egSU(A4TApA2[7], cornerSize, interpolation)});
                    }
                }
            }
        }
        AnimatorSet animatorSet = azWtSf.f7002AzWtSf;
        if (animatorSet != null) {
            animatorSet.setCurrentPlayTime((long) (f * animatorSet.getDuration()));
            return;
        }
        SearchView searchView = azWtSf.f6989A2egSU;
        if (searchView.AYUAbz()) {
            searchView.ARc23Z();
        }
        if (searchView.f11780C4FrIb) {
            AnimatorSet animatorSet2 = new AnimatorSet();
            azWtSf.A4TApA(animatorSet2);
            animatorSet2.setDuration(250L);
            animatorSet2.setInterpolator(Oay4Bh.BNL6CD.A2egSU(false, NdEzCJ.A2egSU.f6037A4TApA));
            azWtSf.f7002AzWtSf = animatorSet2;
            animatorSet2.start();
            azWtSf.f7002AzWtSf.pause();
        }
    }

    @Override // Ogw3zR.A4TApA
    public final void A5SV6n() {
        long totalDuration;
        if (AZOQYO()) {
            return;
        }
        AzWtSf azWtSf = this.f11774BPw6Q8;
        Ogw3zR.AYUAbz aYUAbz = azWtSf.f7001AmA8tU;
        androidx.activity.A4TApA a4TApA = aYUAbz.f6641ARc23Z;
        aYUAbz.f6641ARc23Z = null;
        if (Build.VERSION.SDK_INT < 34 || this.BpkvW3 == null || a4TApA == null) {
            ASJ6gh();
            return;
        }
        totalDuration = azWtSf.AcNBzu().getTotalDuration();
        SearchBar searchBar = azWtSf.f7003B25kr6;
        Ogw3zR.AYUAbz aYUAbz2 = azWtSf.f7001AmA8tU;
        AnimatorSet A2egSU2 = aYUAbz2.A2egSU(searchBar);
        A2egSU2.setDuration(totalDuration);
        A2egSU2.start();
        aYUAbz2.f6649AZOQYO = 0.0f;
        aYUAbz2.f6650AZkASS = null;
        aYUAbz2.f6651AaHO0E = null;
        if (azWtSf.f7002AzWtSf != null) {
            azWtSf.A5SV6n(false).start();
            azWtSf.f7002AzWtSf.resume();
        }
        azWtSf.f7002AzWtSf = null;
    }

    @Override // Ogw3zR.A4TApA
    public final void ADYaiT() {
        int i = 2;
        if (AZOQYO() || this.BpkvW3 == null || Build.VERSION.SDK_INT < 34) {
            return;
        }
        AzWtSf azWtSf = this.f11774BPw6Q8;
        SearchBar searchBar = azWtSf.f7003B25kr6;
        Ogw3zR.AYUAbz aYUAbz = azWtSf.f7001AmA8tU;
        androidx.activity.A4TApA a4TApA = aYUAbz.f6641ARc23Z;
        aYUAbz.f6641ARc23Z = null;
        if (a4TApA != null) {
            AnimatorSet A2egSU2 = aYUAbz.A2egSU(searchBar);
            View view = aYUAbz.f6638A4TApA;
            if (view instanceof ClippableRoundedCornerLayout) {
                ClippableRoundedCornerLayout clippableRoundedCornerLayout = (ClippableRoundedCornerLayout) view;
                ValueAnimator ofObject = ValueAnimator.ofObject(new ASJ6gh(), clippableRoundedCornerLayout.getCornerRadii(), aYUAbz.A4TApA());
                ofObject.addUpdateListener(new Ddcejp(i, clippableRoundedCornerLayout));
                A2egSU2.playTogether(ofObject);
            }
            A2egSU2.setDuration(aYUAbz.AMqCpz);
            A2egSU2.start();
            aYUAbz.f6649AZOQYO = 0.0f;
            aYUAbz.f6650AZkASS = null;
            aYUAbz.f6651AaHO0E = null;
        }
        AnimatorSet animatorSet = azWtSf.f7002AzWtSf;
        if (animatorSet != null) {
            animatorSet.reverse();
        }
        azWtSf.f7002AzWtSf = null;
    }

    public final void ARc23Z() {
        this.f11769BChYOn.post(new ARc23Z(this, 1));
    }

    public final void ASJ6gh() {
        if (this.f11786CTkVKb.equals(AZkASS.f6976AlLFFp) || this.f11786CTkVKb.equals(AZkASS.f6975AcNBzu)) {
            return;
        }
        SearchBar searchBar = this.BpkvW3;
        AzWtSf azWtSf = this.f11774BPw6Q8;
        if (searchBar == null || !searchBar.isAttachedToWindow()) {
            azWtSf.AcNBzu();
            return;
        }
        this.BpkvW3.setPlaceholderText(this.f11769BChYOn.getText().toString());
        SearchBar searchBar2 = this.BpkvW3;
        Objects.requireNonNull(azWtSf);
        searchBar2.post(new P8ccfD.ADYaiT(azWtSf, 0));
    }

    public final boolean AYUAbz() {
        return this.f11779C2rE4F == 48;
    }

    public final boolean AZOQYO() {
        return this.f11786CTkVKb.equals(AZkASS.f6976AlLFFp) || this.f11786CTkVKb.equals(AZkASS.f6975AcNBzu);
    }

    public final void AZkASS() {
        if (this.f11782CNPG0E) {
            this.f11769BChYOn.postDelayed(new ARc23Z(this, 0), 100L);
        }
    }

    public final void AaHO0E(AZkASS aZkASS, boolean z) {
        if (this.f11786CTkVKb.equals(aZkASS)) {
            return;
        }
        AZkASS aZkASS2 = AZkASS.f6976AlLFFp;
        AZkASS aZkASS3 = AZkASS.f6978AzWtSf;
        if (z) {
            if (aZkASS == aZkASS3) {
                setModalForAccessibility(true);
            } else if (aZkASS == aZkASS2) {
                setModalForAccessibility(false);
            }
        }
        this.f11786CTkVKb = aZkASS;
        Iterator it = new LinkedHashSet(this.f11778BniPrB).iterator();
        while (it.hasNext()) {
            BpkvW3 bpkvW3 = ((B3GDIM) it.next()).f5037A2egSU;
            BmvVmW bmvVmW = bpkvW3.f5075BIYEnU;
            bmvVmW.f5056A2egSU = aZkASS == aZkASS3;
            B7CMnp b7CMnp = bmvVmW.f5058A5SV6n;
            if (b7CMnp != null) {
                b7CMnp.invoke();
            }
            if (bpkvW3.getActivity() != null) {
                if (aZkASS == aZkASS3) {
                    BmvVmW bmvVmW2 = ((MainActivity) bpkvW3.getActivity()).f11066B4ZgIw;
                    bmvVmW2.f5056A2egSU = false;
                    B7CMnp b7CMnp2 = bmvVmW2.f5058A5SV6n;
                    if (b7CMnp2 != null) {
                        b7CMnp2.invoke();
                    }
                } else if (aZkASS == aZkASS2) {
                    BmvVmW bmvVmW3 = ((MainActivity) bpkvW3.getActivity()).f11066B4ZgIw;
                    bmvVmW3.f5056A2egSU = true;
                    B7CMnp b7CMnp3 = bmvVmW3.f5058A5SV6n;
                    if (b7CMnp3 != null) {
                        b7CMnp3.invoke();
                    }
                }
            }
            if (bpkvW3.getActivity() != null) {
                MainActivity mainActivity = (MainActivity) bpkvW3.getActivity();
                if (mainActivity.AYUAbz() != null) {
                    if (aZkASS == AZkASS.f6977AmA8tU) {
                        mainActivity.AYUAbz().setVisibility(8);
                    } else if (aZkASS == AZkASS.f6975AcNBzu) {
                        mainActivity.AYUAbz().setVisibility(0);
                    }
                }
            }
        }
        AmA8tU(aZkASS);
        SearchBar searchBar = this.BpkvW3;
        if (searchBar == null || aZkASS != aZkASS2) {
            return;
        }
        searchBar.sendAccessibilityEvent(8);
    }

    public final void AcNBzu() {
        if (this.f11786CTkVKb.equals(AZkASS.f6978AzWtSf)) {
            return;
        }
        AZkASS aZkASS = this.f11786CTkVKb;
        AZkASS aZkASS2 = AZkASS.f6977AmA8tU;
        if (aZkASS.equals(aZkASS2)) {
            return;
        }
        AzWtSf azWtSf = this.f11774BPw6Q8;
        SearchBar searchBar = azWtSf.f7003B25kr6;
        SearchView searchView = azWtSf.f6989A2egSU;
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = azWtSf.f6991A5SV6n;
        if (searchBar == null) {
            if (searchView.AYUAbz()) {
                searchView.postDelayed(new ARc23Z(searchView, 3), 150L);
            }
            clippableRoundedCornerLayout.setVisibility(4);
            clippableRoundedCornerLayout.post(new P8ccfD.ADYaiT(azWtSf, 1));
            return;
        }
        if (searchView.AYUAbz()) {
            searchView.AZkASS();
        }
        searchView.setTransitionState(aZkASS2);
        Toolbar toolbar = azWtSf.f6994ASJ6gh;
        Menu menu = toolbar.getMenu();
        if (menu != null) {
            menu.clear();
        }
        if (azWtSf.f7003B25kr6.getMenuResId() == -1 || !searchView.f11781CASmeH) {
            toolbar.setVisibility(8);
        } else {
            toolbar.AlLFFp(azWtSf.f7003B25kr6.getMenuResId());
            ActionMenuView AZOQYO2 = C4FrIb.AZOQYO(toolbar);
            if (AZOQYO2 != null) {
                for (int i = 0; i < AZOQYO2.getChildCount(); i++) {
                    View childAt = AZOQYO2.getChildAt(i);
                    childAt.setClickable(false);
                    childAt.setFocusable(false);
                    childAt.setFocusableInTouchMode(false);
                }
            }
            toolbar.setVisibility(0);
        }
        CharSequence text = azWtSf.f7003B25kr6.getText();
        EditText editText = azWtSf.f6997AZkASS;
        editText.setText(text);
        editText.setSelection(editText.getText().length());
        clippableRoundedCornerLayout.setVisibility(4);
        clippableRoundedCornerLayout.post(new P8ccfD.ADYaiT(azWtSf, 2));
    }

    public final void AlLFFp(ViewGroup viewGroup, boolean z) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt != this) {
                if (childAt.findViewById(this.f11760AlLFFp.getId()) != null) {
                    AlLFFp((ViewGroup) childAt, z);
                } else if (z) {
                    this.f11787CcAIMM.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                    childAt.setImportantForAccessibility(4);
                } else {
                    HashMap hashMap = this.f11787CcAIMM;
                    if (hashMap != null && hashMap.containsKey(childAt)) {
                        childAt.setImportantForAccessibility(((Integer) this.f11787CcAIMM.get(childAt)).intValue());
                    }
                }
            }
        }
    }

    public final void AmA8tU(AZkASS aZkASS) {
        if (this.BpkvW3 == null || !this.f11776BV3sI0) {
            return;
        }
        boolean equals = aZkASS.equals(AZkASS.f6978AzWtSf);
        DUi7mC dUi7mC = this.f11775BTvldC;
        if (equals) {
            dUi7mC.BChYOn(false);
        } else if (aZkASS.equals(AZkASS.f6976AlLFFp)) {
            dUi7mC.BIYEnU();
        }
    }

    public final void AzWtSf() {
        ImageButton AaHO0E2 = C4FrIb.AaHO0E(this.f11765B3GDIM);
        if (AaHO0E2 == null) {
            return;
        }
        int i = this.f11760AlLFFp.getVisibility() == 0 ? 1 : 0;
        Drawable DdagTj2 = A5SV6n.DdagTj(AaHO0E2.getDrawable());
        if (DdagTj2 instanceof ARc23Z.AZkASS) {
            ARc23Z.AZkASS aZkASS = (ARc23Z.AZkASS) DdagTj2;
            float f = i;
            if (aZkASS.f312AZOQYO != f) {
                aZkASS.f312AZOQYO = f;
                aZkASS.invalidateSelf();
            }
        }
        if (DdagTj2 instanceof Oay4Bh.ARc23Z) {
            ((Oay4Bh.ARc23Z) DdagTj2).A2egSU(i);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.f11773BNL6CD) {
            this.f11772BJ7GGh.addView(view, i, layoutParams);
        } else {
            super.addView(view, i, layoutParams);
        }
    }

    public Ogw3zR.AYUAbz getBackHelper() {
        return this.f11774BPw6Q8.f7001AmA8tU;
    }

    @Override // androidx.coordinatorlayout.widget.A2egSU
    public CoordinatorLayout.A2egSU getBehavior() {
        return new Behavior();
    }

    public AZkASS getCurrentTransitionState() {
        return this.f11786CTkVKb;
    }

    public int getDefaultNavigationIconResource() {
        return 2131230958;
    }

    public EditText getEditText() {
        return this.f11769BChYOn;
    }

    public CharSequence getHint() {
        return this.f11769BChYOn.getHint();
    }

    public TextView getSearchPrefix() {
        return this.f11767B7CMnp;
    }

    public CharSequence getSearchPrefixText() {
        return this.f11767B7CMnp.getText();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getSoftInputMode() {
        return this.f11779C2rE4F;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public Editable getText() {
        return this.f11769BChYOn.getText();
    }

    public Toolbar getToolbar() {
        return this.f11765B3GDIM;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        AlLFFp.D07BeM(this);
        AZkASS currentTransitionState = getCurrentTransitionState();
        if (currentTransitionState == AZkASS.f6978AzWtSf) {
            setModalForAccessibility(true);
        } else if (currentTransitionState == AZkASS.f6976AlLFFp) {
            setModalForAccessibility(false);
        }
        AmA8tU(currentTransitionState);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setModalForAccessibility(false);
        this.f11775BTvldC.BIYEnU();
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        Window activityWindow = getActivityWindow();
        if (activityWindow != null) {
            this.f11779C2rE4F = activityWindow.getAttributes().softInputMode;
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof AZOQYO)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        AZOQYO azoqyo = (AZOQYO) parcelable;
        super.onRestoreInstanceState(azoqyo.getSuperState());
        setText(azoqyo.f6973AcNBzu);
        setVisible(azoqyo.f6974AlLFFp == 0);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        AZOQYO azoqyo = new AZOQYO(super.onSaveInstanceState());
        Editable text = getText();
        azoqyo.f6973AcNBzu = text == null ? null : text.toString();
        azoqyo.f6974AlLFFp = this.f11760AlLFFp.getVisibility();
        return azoqyo;
    }

    public void setAnimatedNavigationIcon(boolean z) {
        this.f11780C4FrIb = z;
    }

    public void setAutoShowKeyboard(boolean z) {
        this.f11782CNPG0E = z;
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        setUpBackgroundViewElevationOverlay(f);
    }

    public void setHint(CharSequence charSequence) {
        this.f11769BChYOn.setHint(charSequence);
    }

    public void setMenuItemsAnimated(boolean z) {
        this.f11781CASmeH = z;
    }

    public void setModalForAccessibility(boolean z) {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (z) {
            this.f11787CcAIMM = new HashMap(viewGroup.getChildCount());
        }
        AlLFFp(viewGroup, z);
        if (z) {
            return;
        }
        this.f11787CcAIMM = null;
    }

    public void setOnMenuItemClickListener(H0R8Px h0R8Px) {
        this.f11765B3GDIM.setOnMenuItemClickListener(h0R8Px);
    }

    public void setSearchPrefixText(CharSequence charSequence) {
        TextView textView = this.f11767B7CMnp;
        textView.setText(charSequence);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public void setStatusBarSpacerEnabled(boolean z) {
        this.f11785CSDoyG = true;
        setStatusBarSpacerEnabledInternal(z);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setText(CharSequence charSequence) {
        this.f11769BChYOn.setText(charSequence);
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z) {
        this.f11765B3GDIM.setTouchscreenBlocksFocus(z);
    }

    public void setTransitionState(AZkASS aZkASS) {
        AaHO0E(aZkASS, true);
    }

    public void setUseWindowInsetsController(boolean z) {
        this.f11784CQhlFr = z;
    }

    public void setVisible(boolean z) {
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = this.f11760AlLFFp;
        boolean z2 = clippableRoundedCornerLayout.getVisibility() == 0;
        clippableRoundedCornerLayout.setVisibility(z ? 0 : 8);
        AzWtSf();
        AaHO0E(z ? AZkASS.f6978AzWtSf : AZkASS.f6976AlLFFp, z2 != z);
    }

    public void setupWithSearchBar(SearchBar searchBar) {
        this.BpkvW3 = searchBar;
        this.f11774BPw6Q8.f7003B25kr6 = searchBar;
        if (searchBar != null) {
            searchBar.setOnClickListener(new P8ccfD.AMqCpz(this, 1));
            if (Build.VERSION.SDK_INT >= 34) {
                try {
                    searchBar.setHandwritingDelegatorCallback(new ARc23Z(this, 2));
                    this.f11769BChYOn.setIsHandwritingDelegate(true);
                } catch (LinkageError unused) {
                }
            }
        }
        MaterialToolbar materialToolbar = this.f11765B3GDIM;
        if (materialToolbar != null && !(A5SV6n.DdagTj(materialToolbar.getNavigationIcon()) instanceof ARc23Z.AZkASS)) {
            int defaultNavigationIconResource = getDefaultNavigationIconResource();
            if (this.BpkvW3 == null) {
                materialToolbar.setNavigationIcon(defaultNavigationIconResource);
            } else {
                Drawable DvK7DB2 = A5SV6n.DvK7DB(AlLFFp.CQhlFr(getContext(), defaultNavigationIconResource).mutate());
                if (materialToolbar.getNavigationIconTint() != null) {
                    DvK7DB2.setTint(materialToolbar.getNavigationIconTint().intValue());
                }
                A5SV6n.D8cQ8b(DvK7DB2, getLayoutDirection());
                materialToolbar.setNavigationIcon(new Oay4Bh.ARc23Z(this.BpkvW3.getNavigationIcon(), DvK7DB2));
                AzWtSf();
            }
        }
        setUpBackgroundViewElevationOverlay(getOverlayElevation());
        AmA8tU(getCurrentTransitionState());
    }

    public void setHint(int i) {
        this.f11769BChYOn.setHint(i);
    }

    public void setText(int i) {
        this.f11769BChYOn.setText(i);
    }
}
