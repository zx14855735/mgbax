package PWr3nF;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B3GDIM {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f7358A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f7359A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f7360A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final TimeInterpolator f7361ADYaiT;
    public final TimeInterpolator AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final TimeInterpolator f7362ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final Context f7363ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final TextInputLayout f7364AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public LinearLayout f7365AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public int f7366AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public FrameLayout f7367AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public AnimatorSet f7368AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final float f7369AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public int f7370AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f7371AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public CharSequence f7372B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f7373B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public AppCompatTextView f7374B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public CharSequence f7375B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f7376B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public int f7377B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public ColorStateList f7378BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public CharSequence f7379BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public boolean f7380BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public AppCompatTextView f7381BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public int f7382BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public ColorStateList f7383BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public Typeface f7384BTvldC;

    public B3GDIM(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f7363ASJ6gh = context;
        this.f7364AYUAbz = textInputLayout;
        this.f7369AlLFFp = context.getResources().getDimensionPixelSize(2131165332);
        this.f7358A2egSU = com.bumptech.glide.A5SV6n.D07BeM(context, 2130969627, 217);
        this.f7359A4TApA = com.bumptech.glide.A5SV6n.D07BeM(context, 2130969623, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_STRENGTH_OPTION);
        this.f7360A5SV6n = com.bumptech.glide.A5SV6n.D07BeM(context, 2130969627, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_STRENGTH_OPTION);
        this.f7361ADYaiT = com.bumptech.glide.A5SV6n.D6DOie(context, 2130969632, NdEzCJ.A2egSU.f6039ADYaiT);
        LinearInterpolator linearInterpolator = NdEzCJ.A2egSU.f6036A2egSU;
        this.AMqCpz = com.bumptech.glide.A5SV6n.D6DOie(context, 2130969632, linearInterpolator);
        this.f7362ARc23Z = com.bumptech.glide.A5SV6n.D6DOie(context, 2130969635, linearInterpolator);
    }

    public final void A2egSU(AppCompatTextView appCompatTextView, int i) {
        if (this.f7365AZOQYO == null && this.f7367AaHO0E == null) {
            Context context = this.f7363ASJ6gh;
            LinearLayout linearLayout = new LinearLayout(context);
            this.f7365AZOQYO = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.f7365AZOQYO;
            TextInputLayout textInputLayout = this.f7364AYUAbz;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.f7367AaHO0E = new FrameLayout(context);
            this.f7365AZOQYO.addView(this.f7367AaHO0E, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                A4TApA();
            }
        }
        if (i == 0 || i == 1) {
            this.f7367AaHO0E.setVisibility(0);
            this.f7367AaHO0E.addView(appCompatTextView);
        } else {
            this.f7365AZOQYO.addView(appCompatTextView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f7365AZOQYO.setVisibility(0);
        this.f7366AZkASS++;
    }

    public final void A4TApA() {
        if (this.f7365AZOQYO != null) {
            TextInputLayout textInputLayout = this.f7364AYUAbz;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.f7363ASJ6gh;
                boolean CNPG0E2 = com.bumptech.glide.AMqCpz.CNPG0E(context);
                LinearLayout linearLayout = this.f7365AZOQYO;
                int paddingStart = editText.getPaddingStart();
                if (CNPG0E2) {
                    paddingStart = context.getResources().getDimensionPixelSize(2131166321);
                }
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131166320);
                if (CNPG0E2) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(2131166322);
                }
                int paddingEnd = editText.getPaddingEnd();
                if (CNPG0E2) {
                    paddingEnd = context.getResources().getDimensionPixelSize(2131166321);
                }
                linearLayout.setPaddingRelative(paddingStart, dimensionPixelSize, paddingEnd, 0);
            }
        }
    }

    public final void A5SV6n() {
        AnimatorSet animatorSet = this.f7368AcNBzu;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void ADYaiT(ArrayList arrayList, boolean z, AppCompatTextView appCompatTextView, int i, int i2, int i3) {
        if (appCompatTextView == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            boolean z2 = i3 == i;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.ALPHA, z2 ? 1.0f : 0.0f);
            int i4 = this.f7360A5SV6n;
            ofFloat.setDuration(z2 ? this.f7359A4TApA : i4);
            ofFloat.setInterpolator(z2 ? this.AMqCpz : this.f7362ARc23Z);
            if (i == i3 && i2 != 0) {
                ofFloat.setStartDelay(i4);
            }
            arrayList.add(ofFloat);
            if (i3 != i || i2 == 0) {
                return;
            }
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.TRANSLATION_Y, -this.f7369AlLFFp, 0.0f);
            ofFloat2.setDuration(this.f7358A2egSU);
            ofFloat2.setInterpolator(this.f7361ADYaiT);
            ofFloat2.setStartDelay(i4);
            arrayList.add(ofFloat2);
        }
    }

    public final TextView AMqCpz(int i) {
        if (i == 1) {
            return this.f7374B3GDIM;
        }
        if (i != 2) {
            return null;
        }
        return this.f7381BJ7GGh;
    }

    public final void ARc23Z() {
        this.f7372B25kr6 = null;
        A5SV6n();
        if (this.f7370AmA8tU == 1) {
            if (!this.f7380BIYEnU || TextUtils.isEmpty(this.f7379BI9f7h)) {
                this.f7371AzWtSf = 0;
            } else {
                this.f7371AzWtSf = 2;
            }
        }
        AZOQYO(this.f7370AmA8tU, this.f7371AzWtSf, AYUAbz(this.f7374B3GDIM, ""));
    }

    public final void ASJ6gh(AppCompatTextView appCompatTextView, int i) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.f7365AZOQYO;
        if (linearLayout == null) {
            return;
        }
        if ((i == 0 || i == 1) && (frameLayout = this.f7367AaHO0E) != null) {
            frameLayout.removeView(appCompatTextView);
        } else {
            linearLayout.removeView(appCompatTextView);
        }
        int i2 = this.f7366AZkASS - 1;
        this.f7366AZkASS = i2;
        LinearLayout linearLayout2 = this.f7365AZOQYO;
        if (i2 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean AYUAbz(AppCompatTextView appCompatTextView, CharSequence charSequence) {
        TextInputLayout textInputLayout = this.f7364AYUAbz;
        if (textInputLayout.isLaidOut() && textInputLayout.isEnabled()) {
            return (this.f7371AzWtSf == this.f7370AmA8tU && appCompatTextView != null && TextUtils.equals(appCompatTextView.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    public final void AZOQYO(int i, int i2, boolean z) {
        TextView AMqCpz;
        TextView AMqCpz2;
        B3GDIM b3gdim = this;
        if (i == i2) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            b3gdim.f7368AcNBzu = animatorSet;
            ArrayList arrayList = new ArrayList();
            b3gdim.ADYaiT(arrayList, b3gdim.f7380BIYEnU, b3gdim.f7381BJ7GGh, 2, i, i2);
            b3gdim.ADYaiT(arrayList, b3gdim.f7373B2KMhB, b3gdim.f7374B3GDIM, 1, i, i2);
            int size = arrayList.size();
            long j = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Animator animator = (Animator) arrayList.get(i3);
                j = Math.max(j, animator.getDuration() + animator.getStartDelay());
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
            ofInt.setDuration(j);
            arrayList.add(0, ofInt);
            animatorSet.playTogether(arrayList);
            B25kr6 b25kr6 = new B25kr6(this, i2, AMqCpz(i), i, b3gdim.AMqCpz(i2));
            b3gdim = this;
            animatorSet.addListener(b25kr6);
            animatorSet.start();
        } else if (i != i2) {
            if (i2 != 0 && (AMqCpz2 = b3gdim.AMqCpz(i2)) != null) {
                AMqCpz2.setVisibility(0);
                AMqCpz2.setAlpha(1.0f);
            }
            if (i != 0 && (AMqCpz = AMqCpz(i)) != null) {
                AMqCpz.setVisibility(4);
                if (i == 1) {
                    AMqCpz.setText((CharSequence) null);
                }
            }
            b3gdim.f7370AmA8tU = i2;
        }
        TextInputLayout textInputLayout = b3gdim.f7364AYUAbz;
        textInputLayout.B7CMnp();
        textInputLayout.BI9f7h(z, false);
        textInputLayout.BNL6CD();
    }
}
