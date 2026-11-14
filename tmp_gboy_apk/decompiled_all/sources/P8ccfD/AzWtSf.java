package P8ccfD;

import COJEAR.Ddcejp;
import Oay4Bh.BNL6CD;
import Oay4Bh.C4FrIb;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.search.SearchBar;
import com.google.android.material.search.SearchView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AzWtSf {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final SearchView f6989A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final View f6990A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ClippableRoundedCornerLayout f6991A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final FrameLayout f6992ADYaiT;
    public final FrameLayout AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final MaterialToolbar f6993ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final Toolbar f6994ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final LinearLayout f6995AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final TextView f6996AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final EditText f6997AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final ImageButton f6998AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final View f6999AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final TouchObserverFrameLayout f7000AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Ogw3zR.AYUAbz f7001AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public AnimatorSet f7002AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public SearchBar f7003B25kr6;

    public AzWtSf(SearchView searchView) {
        this.f6989A2egSU = searchView;
        this.f6990A4TApA = searchView.f11759AcNBzu;
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = searchView.f11760AlLFFp;
        this.f6991A5SV6n = clippableRoundedCornerLayout;
        this.f6992ADYaiT = searchView.f11763B25kr6;
        this.AMqCpz = searchView.f11764B2KMhB;
        this.f6993ARc23Z = searchView.f11765B3GDIM;
        this.f6994ASJ6gh = searchView.f11766B4ZgIw;
        this.f6996AZOQYO = searchView.f11767B7CMnp;
        this.f6997AZkASS = searchView.f11769BChYOn;
        this.f6998AaHO0E = searchView.f11770BI9f7h;
        this.f6999AcNBzu = searchView.f11771BIYEnU;
        this.f7000AlLFFp = searchView.f11772BJ7GGh;
        this.f6995AYUAbz = searchView.f11768B9tovu;
        this.f7001AmA8tU = new Ogw3zR.AYUAbz(clippableRoundedCornerLayout);
    }

    public static void A2egSU(AzWtSf azWtSf, float f) {
        ActionMenuView AZOQYO2;
        azWtSf.f6998AaHO0E.setAlpha(f);
        azWtSf.f6999AcNBzu.setAlpha(f);
        azWtSf.f7000AlLFFp.setAlpha(f);
        if (!azWtSf.f6989A2egSU.f11781CASmeH || (AZOQYO2 = C4FrIb.AZOQYO(azWtSf.f6993ARc23Z)) == null) {
            return;
        }
        AZOQYO2.setAlpha(f);
    }

    public static AnimatorSet AYUAbz(boolean z, View view, int i, int i2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i, 0.0f);
        ofFloat.addUpdateListener(new Oay4Bh.AaHO0E(new COJEAR.AZOQYO(13), new View[]{view}));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(i2, 0.0f);
        ofFloat2.addUpdateListener(Oay4Bh.AaHO0E.A2egSU(view));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(z ? 300L : 250L);
        animatorSet.setInterpolator(BNL6CD.A2egSU(z, NdEzCJ.A2egSU.f6037A4TApA));
        return animatorSet;
    }

    public final void A4TApA(AnimatorSet animatorSet) {
        ImageButton AaHO0E2 = C4FrIb.AaHO0E(this.f6993ARc23Z);
        if (AaHO0E2 == null) {
            return;
        }
        Drawable DdagTj2 = com.bumptech.glide.A5SV6n.DdagTj(AaHO0E2.getDrawable());
        if (!this.f6989A2egSU.f11780C4FrIb) {
            if (DdagTj2 instanceof ARc23Z.AZkASS) {
                ARc23Z.AZkASS aZkASS = (ARc23Z.AZkASS) DdagTj2;
                if (aZkASS.f312AZOQYO != 1.0f) {
                    aZkASS.f312AZOQYO = 1.0f;
                    aZkASS.invalidateSelf();
                }
            }
            if (DdagTj2 instanceof Oay4Bh.ARc23Z) {
                ((Oay4Bh.ARc23Z) DdagTj2).A2egSU(1.0f);
                return;
            }
            return;
        }
        if (DdagTj2 instanceof ARc23Z.AZkASS) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new Ddcejp(7, (ARc23Z.AZkASS) DdagTj2));
            animatorSet.playTogether(ofFloat);
        }
        if (DdagTj2 instanceof Oay4Bh.ARc23Z) {
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat2.addUpdateListener(new Ddcejp(8, (Oay4Bh.ARc23Z) DdagTj2));
            animatorSet.playTogether(ofFloat2);
        }
        SearchBar searchBar = this.f7003B25kr6;
        if (searchBar == null || searchBar.getNavigationIcon() != null) {
            return;
        }
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat3.addUpdateListener(new Ddcejp(6, AaHO0E2));
        animatorSet.playTogether(ofFloat3);
    }

    public final AnimatorSet A5SV6n(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        MaterialToolbar materialToolbar = this.f6993ARc23Z;
        ImageButton AaHO0E2 = C4FrIb.AaHO0E(materialToolbar);
        if (AaHO0E2 != null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(AZkASS(C4FrIb.AaHO0E(this.f7003B25kr6), AaHO0E2), 0.0f);
            ofFloat.addUpdateListener(new Oay4Bh.AaHO0E(new COJEAR.AZOQYO(13), new View[]{AaHO0E2}));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(ARc23Z(), 0.0f);
            ofFloat2.addUpdateListener(Oay4Bh.AaHO0E.A2egSU(AaHO0E2));
            animatorSet.playTogether(ofFloat, ofFloat2);
        }
        ActionMenuView AZOQYO2 = C4FrIb.AZOQYO(materialToolbar);
        if (AZOQYO2 != null) {
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(AZkASS(C4FrIb.AZOQYO(this.f7003B25kr6), AZOQYO2), 0.0f);
            ofFloat3.addUpdateListener(new Oay4Bh.AaHO0E(new COJEAR.AZOQYO(13), new View[]{AZOQYO2}));
            ValueAnimator ofFloat4 = ValueAnimator.ofFloat(ARc23Z(), 0.0f);
            ofFloat4.addUpdateListener(Oay4Bh.AaHO0E.A2egSU(AZOQYO2));
            animatorSet.playTogether(ofFloat3, ofFloat4);
        }
        animatorSet.setDuration(z ? 300L : 250L);
        animatorSet.setInterpolator(BNL6CD.A2egSU(z, NdEzCJ.A2egSU.f6037A4TApA));
        return animatorSet;
    }

    public final AnimatorSet ADYaiT(boolean z) {
        char c;
        char c2;
        char c3;
        char c4;
        EditText editText;
        Animator animator;
        AnimatorSet animatorSet = new AnimatorSet();
        if (this.f7002AzWtSf != null) {
            c = 7;
            c2 = 6;
        } else {
            AnimatorSet animatorSet2 = new AnimatorSet();
            A4TApA(animatorSet2);
            c = 7;
            c2 = 6;
            animatorSet2.setDuration(z ? 300L : 250L);
            animatorSet2.setInterpolator(BNL6CD.A2egSU(z, NdEzCJ.A2egSU.f6037A4TApA));
            animatorSet.playTogether(animatorSet2, A5SV6n(z));
        }
        Interpolator interpolator = z ? NdEzCJ.A2egSU.f6036A2egSU : NdEzCJ.A2egSU.f6037A4TApA;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(z ? 300L : 250L);
        ofFloat.setStartDelay(z ? 100L : 0L);
        ofFloat.setInterpolator(BNL6CD.A2egSU(z, interpolator));
        ofFloat.addUpdateListener(new Oay4Bh.AaHO0E(new COJEAR.AZOQYO(16), new View[]{this.f6990A4TApA}));
        Ogw3zR.AYUAbz aYUAbz = this.f7001AmA8tU;
        Rect rect = aYUAbz.f6650AZkASS;
        Rect rect2 = aYUAbz.f6651AaHO0E;
        SearchView searchView = this.f6989A2egSU;
        if (rect != null) {
            c3 = 0;
            c4 = 3;
        } else {
            c3 = 0;
            c4 = 3;
            rect = new Rect(searchView.getLeft(), searchView.getTop(), searchView.getRight(), searchView.getBottom());
        }
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = this.f6991A5SV6n;
        if (rect2 == null) {
            rect2 = C4FrIb.A5SV6n(clippableRoundedCornerLayout, this.f7003B25kr6);
        }
        final Rect rect3 = new Rect(rect2);
        final float cornerSize = this.f7003B25kr6.getCornerSize();
        float[] cornerRadii = clippableRoundedCornerLayout.getCornerRadii();
        float[] A4TApA2 = aYUAbz.A4TApA();
        float max = Math.max(cornerRadii[c3], A4TApA2[c3]);
        float max2 = Math.max(cornerRadii[1], A4TApA2[1]);
        float max3 = Math.max(cornerRadii[2], A4TApA2[2]);
        float max4 = Math.max(cornerRadii[c4], A4TApA2[c4]);
        float max5 = Math.max(cornerRadii[4], A4TApA2[4]);
        float max6 = Math.max(cornerRadii[5], A4TApA2[5]);
        float max7 = Math.max(cornerRadii[c2], A4TApA2[c2]);
        float max8 = Math.max(cornerRadii[c], A4TApA2[c]);
        final float[] fArr = new float[8];
        fArr[c3] = max;
        fArr[1] = max2;
        fArr[2] = max3;
        fArr[c4] = max4;
        fArr[4] = max5;
        fArr[5] = max6;
        fArr[c2] = max7;
        fArr[c] = max8;
        DcUJf1.ASJ6gh aSJ6gh = new DcUJf1.ASJ6gh(rect3);
        Object[] objArr = new Object[2];
        objArr[c3] = rect2;
        objArr[1] = rect;
        ValueAnimator ofObject = ValueAnimator.ofObject(aSJ6gh, objArr);
        ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: P8ccfD.AcNBzu
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AzWtSf azWtSf = AzWtSf.this;
                azWtSf.getClass();
                float animatedFraction = valueAnimator.getAnimatedFraction();
                float[] fArr2 = fArr;
                float f = fArr2[0];
                float f2 = cornerSize;
                float[] fArr3 = {NdEzCJ.A2egSU.A2egSU(f2, f, animatedFraction), NdEzCJ.A2egSU.A2egSU(f2, fArr2[1], animatedFraction), NdEzCJ.A2egSU.A2egSU(f2, fArr2[2], animatedFraction), NdEzCJ.A2egSU.A2egSU(f2, fArr2[3], animatedFraction), NdEzCJ.A2egSU.A2egSU(f2, fArr2[4], animatedFraction), NdEzCJ.A2egSU.A2egSU(f2, fArr2[5], animatedFraction), NdEzCJ.A2egSU.A2egSU(f2, fArr2[6], animatedFraction), NdEzCJ.A2egSU.A2egSU(f2, fArr2[7], animatedFraction)};
                ClippableRoundedCornerLayout clippableRoundedCornerLayout2 = azWtSf.f6991A5SV6n;
                clippableRoundedCornerLayout2.getClass();
                Rect rect4 = rect3;
                clippableRoundedCornerLayout2.A2egSU(rect4.left, rect4.top, rect4.right, rect4.bottom, fArr3);
            }
        });
        ofObject.setDuration(z ? 300L : 250L);
        D8cQ8b.A4TApA a4TApA = NdEzCJ.A2egSU.f6037A4TApA;
        ofObject.setInterpolator(BNL6CD.A2egSU(z, a4TApA));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.setDuration(z ? 50L : 42L);
        ofFloat2.setStartDelay(z ? 250L : 0L);
        LinearInterpolator linearInterpolator = NdEzCJ.A2egSU.f6036A2egSU;
        ofFloat2.setInterpolator(BNL6CD.A2egSU(z, linearInterpolator));
        View[] viewArr = new View[1];
        viewArr[c3] = this.f6998AaHO0E;
        ofFloat2.addUpdateListener(new Oay4Bh.AaHO0E(new COJEAR.AZOQYO(16), viewArr));
        AnimatorSet animatorSet3 = new AnimatorSet();
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat3.setDuration(z ? 150L : 83L);
        ofFloat3.setStartDelay(z ? 75L : 0L);
        ofFloat3.setInterpolator(BNL6CD.A2egSU(z, linearInterpolator));
        View view = this.f6999AcNBzu;
        TouchObserverFrameLayout touchObserverFrameLayout = this.f7000AlLFFp;
        View[] viewArr2 = new View[2];
        viewArr2[c3] = view;
        viewArr2[1] = touchObserverFrameLayout;
        ofFloat3.addUpdateListener(new Oay4Bh.AaHO0E(new COJEAR.AZOQYO(16), viewArr2));
        float[] fArr2 = new float[2];
        fArr2[c3] = (touchObserverFrameLayout.getHeight() * 0.050000012f) / 2.0f;
        fArr2[1] = 0.0f;
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(fArr2);
        ofFloat4.setDuration(z ? 300L : 250L);
        ofFloat4.setInterpolator(BNL6CD.A2egSU(z, a4TApA));
        View[] viewArr3 = new View[1];
        viewArr3[c3] = view;
        ofFloat4.addUpdateListener(Oay4Bh.AaHO0E.A2egSU(viewArr3));
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(0.95f, 1.0f);
        ofFloat5.setDuration(z ? 300L : 250L);
        ofFloat5.setInterpolator(BNL6CD.A2egSU(z, a4TApA));
        View[] viewArr4 = new View[1];
        viewArr4[c3] = touchObserverFrameLayout;
        ofFloat5.addUpdateListener(new Oay4Bh.AaHO0E(new COJEAR.AZOQYO(15), viewArr4));
        Animator[] animatorArr = new Animator[3];
        animatorArr[c3] = ofFloat3;
        animatorArr[1] = ofFloat4;
        animatorArr[2] = ofFloat5;
        animatorSet3.playTogether(animatorArr);
        View view2 = this.f6992ADYaiT;
        Animator AYUAbz2 = AYUAbz(z, view2, AMqCpz(view2), ARc23Z());
        Toolbar toolbar = this.f6994ASJ6gh;
        Animator AYUAbz3 = AYUAbz(z, toolbar, AMqCpz(toolbar), ARc23Z());
        ValueAnimator ofFloat6 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat6.setDuration(z ? 300L : 250L);
        ofFloat6.setInterpolator(BNL6CD.A2egSU(z, a4TApA));
        if (searchView.f11781CASmeH) {
            ofFloat6.addUpdateListener(new Fyurov.AcNBzu(C4FrIb.AZOQYO(toolbar), C4FrIb.AZOQYO(this.f6993ARc23Z)));
        }
        EditText editText2 = this.f6997AZkASS;
        Animator AZOQYO2 = AZOQYO(editText2, z);
        Animator AZOQYO3 = AZOQYO(this.f6996AZOQYO, z);
        AnimatorSet animatorSet4 = new AnimatorSet();
        if (this.f7003B25kr6 == null || TextUtils.equals(editText2.getText(), this.f7003B25kr6.getText())) {
            editText = editText2;
        } else {
            ValueAnimator ofFloat7 = ValueAnimator.ofFloat(0.0f, 1.0f);
            editText = editText2;
            ofFloat7.addUpdateListener(new Ddcejp(9, this));
            Animator[] animatorArr2 = new Animator[1];
            animatorArr2[c3] = ofFloat7;
            animatorSet4.playTogether(animatorArr2);
        }
        if (this.f7003B25kr6 == null || !TextUtils.equals(editText.getText(), this.f7003B25kr6.getText())) {
            animator = AYUAbz2;
        } else {
            animator = AYUAbz2;
            Rect rect4 = new Rect(0, 0, editText.getWidth(), editText.getHeight());
            ValueAnimator ofInt = ValueAnimator.ofInt(this.f7003B25kr6.getTextView().getWidth(), editText.getWidth());
            ofInt.addUpdateListener(new Nm94Z2.A4TApA(this, 2, rect4));
            animatorSet4.playTogether(ofInt);
        }
        animatorSet4.setDuration(z ? 300L : 250L);
        animatorSet4.setInterpolator(BNL6CD.A2egSU(z, linearInterpolator));
        Animator[] animatorArr3 = new Animator[10];
        animatorArr3[0] = ofFloat;
        animatorArr3[1] = ofObject;
        animatorArr3[2] = ofFloat2;
        animatorArr3[3] = animatorSet3;
        animatorArr3[4] = animator;
        animatorArr3[5] = AYUAbz3;
        animatorArr3[c2] = ofFloat6;
        animatorArr3[c] = AZOQYO2;
        animatorArr3[8] = AZOQYO3;
        animatorArr3[9] = animatorSet4;
        animatorSet.playTogether(animatorArr3);
        animatorSet.addListener(new AmA8tU(this, z));
        return animatorSet;
    }

    public final int AMqCpz(View view) {
        int marginEnd = ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).getMarginEnd();
        int AaHO0E2 = AaHO0E(this.f7003B25kr6);
        return C4FrIb.AlLFFp(this.f7003B25kr6) ? AaHO0E2 - marginEnd : ((this.f7003B25kr6.getWidth() + AaHO0E2) + marginEnd) - this.f6989A2egSU.getWidth();
    }

    public final int ARc23Z() {
        FrameLayout frameLayout = this.AMqCpz;
        int height = (frameLayout.getHeight() / 2) + frameLayout.getTop();
        SearchBar searchBar = this.f7003B25kr6;
        int top = searchBar.getTop();
        for (ViewParent parent = searchBar.getParent(); (parent instanceof View) && parent != this.f6989A2egSU.getParent(); parent = parent.getParent()) {
            top += ((View) parent).getTop();
        }
        return ((this.f7003B25kr6.getHeight() / 2) + top) - height;
    }

    public final AnimatorSet ASJ6gh(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        ClippableRoundedCornerLayout clippableRoundedCornerLayout = this.f6991A5SV6n;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(clippableRoundedCornerLayout.getHeight(), 0.0f);
        ofFloat.addUpdateListener(Oay4Bh.AaHO0E.A2egSU(clippableRoundedCornerLayout));
        animatorSet.playTogether(ofFloat);
        A4TApA(animatorSet);
        animatorSet.setInterpolator(BNL6CD.A2egSU(z, NdEzCJ.A2egSU.f6037A4TApA));
        animatorSet.setDuration(z ? 350L : 300L);
        return animatorSet;
    }

    public final AnimatorSet AZOQYO(View view, boolean z) {
        TextView placeholderTextView = this.f7003B25kr6.getPlaceholderTextView();
        if (TextUtils.isEmpty(placeholderTextView.getText()) || z) {
            placeholderTextView = this.f7003B25kr6.getTextView();
        }
        return AYUAbz(z, view, AaHO0E(placeholderTextView) - (this.f6995AYUAbz.getLeft() + view.getLeft()), ARc23Z());
    }

    public final int AZkASS(View view, View view2) {
        if (view != null) {
            return AaHO0E(view) - AaHO0E(view2);
        }
        int marginStart = ((ViewGroup.MarginLayoutParams) view2.getLayoutParams()).getMarginStart();
        int paddingStart = this.f7003B25kr6.getPaddingStart();
        int AaHO0E2 = AaHO0E(this.f7003B25kr6);
        return C4FrIb.AlLFFp(this.f7003B25kr6) ? (((this.f7003B25kr6.getWidth() + AaHO0E2) + marginStart) - paddingStart) - this.f6989A2egSU.getRight() : (AaHO0E2 - marginStart) + paddingStart;
    }

    public final int AaHO0E(View view) {
        int left = view.getLeft();
        for (ViewParent parent = view.getParent(); (parent instanceof View) && parent != this.f6989A2egSU.getParent(); parent = parent.getParent()) {
            left += ((View) parent).getLeft();
        }
        return left;
    }

    public final AnimatorSet AcNBzu() {
        SearchBar searchBar = this.f7003B25kr6;
        SearchView searchView = this.f6989A2egSU;
        if (searchBar != null) {
            if (searchView.AYUAbz()) {
                searchView.ARc23Z();
            }
            AnimatorSet ADYaiT2 = ADYaiT(false);
            ADYaiT2.addListener(new AlLFFp(this, 1));
            ADYaiT2.start();
            return ADYaiT2;
        }
        if (searchView.AYUAbz()) {
            searchView.ARc23Z();
        }
        AnimatorSet ASJ6gh2 = ASJ6gh(false);
        ASJ6gh2.addListener(new AlLFFp(this, 3));
        ASJ6gh2.start();
        return ASJ6gh2;
    }
}
