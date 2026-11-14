package PWr3nF;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT extends AzWtSf {
    public final int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final int f7296ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final TimeInterpolator f7297ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final TimeInterpolator f7298AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public EditText f7299AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final Dphsd2.A2egSU f7300AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final A2egSU f7301AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public AnimatorSet f7302AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public ValueAnimator f7303AlLFFp;

    public ADYaiT(AmA8tU amA8tU) {
        super(amA8tU);
        this.f7300AZkASS = new Dphsd2.A2egSU(5, this);
        this.f7301AaHO0E = new A2egSU(this, 0);
        this.AMqCpz = com.bumptech.glide.A5SV6n.D07BeM(amA8tU.getContext(), 2130969626, 100);
        this.f7296ARc23Z = com.bumptech.glide.A5SV6n.D07BeM(amA8tU.getContext(), 2130969626, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS);
        this.f7297ASJ6gh = com.bumptech.glide.A5SV6n.D6DOie(amA8tU.getContext(), 2130969635, NdEzCJ.A2egSU.f6036A2egSU);
        this.f7298AYUAbz = com.bumptech.glide.A5SV6n.D6DOie(amA8tU.getContext(), 2130969633, NdEzCJ.A2egSU.f6039ADYaiT);
    }

    @Override // PWr3nF.AzWtSf
    public final void A2egSU() {
        if (this.f7350A4TApA.f7343BPw6Q8 != null) {
            return;
        }
        B7CMnp(B9tovu());
    }

    @Override // PWr3nF.AzWtSf
    public final int A5SV6n() {
        return 2131886184;
    }

    @Override // PWr3nF.AzWtSf
    public final int ADYaiT() {
        return 2131231374;
    }

    @Override // PWr3nF.AzWtSf
    public final View.OnFocusChangeListener AMqCpz() {
        return this.f7301AaHO0E;
    }

    @Override // PWr3nF.AzWtSf
    public final View.OnClickListener ARc23Z() {
        return this.f7300AZkASS;
    }

    @Override // PWr3nF.AzWtSf
    public final View.OnFocusChangeListener ASJ6gh() {
        return this.f7301AaHO0E;
    }

    @Override // PWr3nF.AzWtSf
    public final void AlLFFp(EditText editText) {
        this.f7299AZOQYO = editText;
        this.f7349A2egSU.setEndIconVisible(B9tovu());
    }

    @Override // PWr3nF.AzWtSf
    public final void B25kr6(boolean z) {
        if (this.f7350A4TApA.f7343BPw6Q8 == null) {
            return;
        }
        B7CMnp(z);
    }

    @Override // PWr3nF.AzWtSf
    public final void B3GDIM() {
        final int i = 1;
        final int i2 = 0;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(this.f7298AYUAbz);
        ofFloat.setDuration(this.f7296ARc23Z);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: PWr3nF.A4TApA

            /* renamed from: A4TApA, reason: collision with root package name */
            public final /* synthetic */ ADYaiT f7293A4TApA;

            {
                this.f7293A4TApA = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i) {
                    case 0:
                        ADYaiT aDYaiT = this.f7293A4TApA;
                        aDYaiT.getClass();
                        aDYaiT.f7352ADYaiT.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        ADYaiT aDYaiT2 = this.f7293A4TApA;
                        aDYaiT2.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = aDYaiT2.f7352ADYaiT;
                        checkableImageButton.setScaleX(floatValue);
                        checkableImageButton.setScaleY(floatValue);
                        break;
                }
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f7297ASJ6gh;
        ofFloat2.setInterpolator(timeInterpolator);
        int i3 = this.AMqCpz;
        ofFloat2.setDuration(i3);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: PWr3nF.A4TApA

            /* renamed from: A4TApA, reason: collision with root package name */
            public final /* synthetic */ ADYaiT f7293A4TApA;

            {
                this.f7293A4TApA = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i2) {
                    case 0:
                        ADYaiT aDYaiT = this.f7293A4TApA;
                        aDYaiT.getClass();
                        aDYaiT.f7352ADYaiT.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        ADYaiT aDYaiT2 = this.f7293A4TApA;
                        aDYaiT2.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = aDYaiT2.f7352ADYaiT;
                        checkableImageButton.setScaleX(floatValue);
                        checkableImageButton.setScaleY(floatValue);
                        break;
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.f7302AcNBzu = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.f7302AcNBzu.addListener(new A5SV6n(this, i2));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(timeInterpolator);
        ofFloat3.setDuration(i3);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: PWr3nF.A4TApA

            /* renamed from: A4TApA, reason: collision with root package name */
            public final /* synthetic */ ADYaiT f7293A4TApA;

            {
                this.f7293A4TApA = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i2) {
                    case 0:
                        ADYaiT aDYaiT = this.f7293A4TApA;
                        aDYaiT.getClass();
                        aDYaiT.f7352ADYaiT.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        ADYaiT aDYaiT2 = this.f7293A4TApA;
                        aDYaiT2.getClass();
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = aDYaiT2.f7352ADYaiT;
                        checkableImageButton.setScaleX(floatValue);
                        checkableImageButton.setScaleY(floatValue);
                        break;
                }
            }
        });
        this.f7303AlLFFp = ofFloat3;
        ofFloat3.addListener(new A5SV6n(this, i));
    }

    @Override // PWr3nF.AzWtSf
    public final void B4ZgIw() {
        EditText editText = this.f7299AZOQYO;
        if (editText != null) {
            editText.post(new CtFAbx.A2egSU(10, this));
        }
    }

    public final void B7CMnp(boolean z) {
        boolean z2 = this.f7350A4TApA.ADYaiT() == z;
        if (z && !this.f7302AcNBzu.isRunning()) {
            this.f7303AlLFFp.cancel();
            this.f7302AcNBzu.start();
            if (z2) {
                this.f7302AcNBzu.end();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.f7302AcNBzu.cancel();
        this.f7303AlLFFp.start();
        if (z2) {
            this.f7303AlLFFp.end();
        }
    }

    public final boolean B9tovu() {
        EditText editText = this.f7299AZOQYO;
        if (editText != null) {
            return (editText.hasFocus() || this.f7352ADYaiT.hasFocus()) && this.f7299AZOQYO.getText().length() > 0;
        }
        return false;
    }
}
