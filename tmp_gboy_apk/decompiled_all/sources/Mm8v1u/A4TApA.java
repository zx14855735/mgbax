package Mm8v1u;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.Space;
import androidx.fragment.app.FragmentActivity;
import com.skydoves.colorpickerview.ColorPickerView;
import com.skydoves.colorpickerview.sliders.AlphaSlideBar;
import com.skydoves.colorpickerview.sliders.BrightnessSlideBar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends OOnEhG.A4TApA {

    /* renamed from: B25kr6, reason: collision with root package name */
    public final AaHO0E.BJ7GGh f5458B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final ColorPickerView f5459B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public boolean f5460B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f5461B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public int f5462B7CMnp;

    public A4TApA(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.f5460B3GDIM = true;
        this.f5461B4ZgIw = true;
        this.f5462B7CMnp = (int) ((10 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
        View inflate = LayoutInflater.from(getContext()).inflate(2131492919, (ViewGroup) null, false);
        int i = 2131296374;
        AlphaSlideBar alphaSlideBar = (AlphaSlideBar) com.bumptech.glide.AMqCpz.BJ7GGh(2131296374, inflate);
        if (alphaSlideBar != null) {
            i = 2131296375;
            FrameLayout frameLayout = (FrameLayout) com.bumptech.glide.AMqCpz.BJ7GGh(2131296375, inflate);
            if (frameLayout != null) {
                i = 2131296418;
                BrightnessSlideBar brightnessSlideBar = (BrightnessSlideBar) com.bumptech.glide.AMqCpz.BJ7GGh(2131296418, inflate);
                if (brightnessSlideBar != null) {
                    i = 2131296419;
                    FrameLayout frameLayout2 = (FrameLayout) com.bumptech.glide.AMqCpz.BJ7GGh(2131296419, inflate);
                    if (frameLayout2 != null) {
                        i = 2131296516;
                        ColorPickerView colorPickerView = (ColorPickerView) com.bumptech.glide.AMqCpz.BJ7GGh(2131296516, inflate);
                        if (colorPickerView != null) {
                            i = 2131296517;
                            FrameLayout frameLayout3 = (FrameLayout) com.bumptech.glide.AMqCpz.BJ7GGh(2131296517, inflate);
                            if (frameLayout3 != null) {
                                i = 2131298000;
                                Space space = (Space) com.bumptech.glide.AMqCpz.BJ7GGh(2131298000, inflate);
                                if (space != null) {
                                    this.f5458B25kr6 = new AaHO0E.BJ7GGh((ScrollView) inflate, alphaSlideBar, frameLayout, brightnessSlideBar, frameLayout2, colorPickerView, frameLayout3, space);
                                    this.f5459B2KMhB = colorPickerView;
                                    colorPickerView.f13804B4ZgIw = alphaSlideBar;
                                    alphaSlideBar.f7474AcNBzu = colorPickerView;
                                    alphaSlideBar.ADYaiT();
                                    if (colorPickerView.getPreferenceName() != null) {
                                        alphaSlideBar.setPreferenceName(colorPickerView.getPreferenceName());
                                    }
                                    ColorPickerView colorPickerView2 = this.f5459B2KMhB;
                                    BrightnessSlideBar brightnessSlideBar2 = (BrightnessSlideBar) this.f5458B25kr6.f658A5SV6n;
                                    colorPickerView2.f13805B7CMnp = brightnessSlideBar2;
                                    brightnessSlideBar2.f7474AcNBzu = colorPickerView2;
                                    brightnessSlideBar2.ADYaiT();
                                    if (colorPickerView2.getPreferenceName() != null) {
                                        brightnessSlideBar2.setPreferenceName(colorPickerView2.getPreferenceName());
                                    }
                                    this.f5459B2KMhB.setColorListener(new A2egSU());
                                    this.f81AcNBzu.f41B7CMnp = (ScrollView) this.f5458B25kr6.f656A2egSU;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // OOnEhG.A4TApA, ADYaiT.AlLFFp
    public final ADYaiT.AmA8tU A2egSU() {
        if (this.f5459B2KMhB != null) {
            ((FrameLayout) this.f5458B25kr6.AMqCpz).removeAllViews();
            ((FrameLayout) this.f5458B25kr6.AMqCpz).addView(this.f5459B2KMhB);
            AlphaSlideBar alphaSlideBar = this.f5459B2KMhB.getAlphaSlideBar();
            boolean z = this.f5460B3GDIM;
            if (z && alphaSlideBar != null) {
                ((FrameLayout) this.f5458B25kr6.f657A4TApA).removeAllViews();
                ((FrameLayout) this.f5458B25kr6.f657A4TApA).addView(alphaSlideBar);
                ColorPickerView colorPickerView = this.f5459B2KMhB;
                colorPickerView.f13804B4ZgIw = alphaSlideBar;
                alphaSlideBar.f7474AcNBzu = colorPickerView;
                alphaSlideBar.ADYaiT();
                if (colorPickerView.getPreferenceName() != null) {
                    alphaSlideBar.setPreferenceName(colorPickerView.getPreferenceName());
                }
            } else if (!z) {
                ((FrameLayout) this.f5458B25kr6.f657A4TApA).removeAllViews();
            }
            BrightnessSlideBar brightnessSlider = this.f5459B2KMhB.getBrightnessSlider();
            boolean z2 = this.f5461B4ZgIw;
            if (z2 && brightnessSlider != null) {
                ((FrameLayout) this.f5458B25kr6.f659ADYaiT).removeAllViews();
                ((FrameLayout) this.f5458B25kr6.f659ADYaiT).addView(brightnessSlider);
                ColorPickerView colorPickerView2 = this.f5459B2KMhB;
                colorPickerView2.f13805B7CMnp = brightnessSlider;
                brightnessSlider.f7474AcNBzu = colorPickerView2;
                brightnessSlider.ADYaiT();
                if (colorPickerView2.getPreferenceName() != null) {
                    brightnessSlider.setPreferenceName(colorPickerView2.getPreferenceName());
                }
            } else if (!z2) {
                ((FrameLayout) this.f5458B25kr6.f659ADYaiT).removeAllViews();
            }
            if (this.f5460B3GDIM || this.f5461B4ZgIw) {
                ((Space) this.f5458B25kr6.f660ARc23Z).setVisibility(0);
                ((Space) this.f5458B25kr6.f660ARc23Z).getLayoutParams().height = this.f5462B7CMnp;
            } else {
                ((Space) this.f5458B25kr6.f660ARc23Z).setVisibility(8);
            }
        }
        this.f81AcNBzu.f41B7CMnp = (ScrollView) this.f5458B25kr6.f656A2egSU;
        return super.A2egSU();
    }

    @Override // OOnEhG.A4TApA, ADYaiT.AlLFFp
    public final void A4TApA(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        super.A4TApA(charSequenceArr, zArr, onMultiChoiceClickListener);
    }

    @Override // OOnEhG.A4TApA, ADYaiT.AlLFFp
    public final void A5SV6n(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        super.AzWtSf(null, null);
    }

    @Override // OOnEhG.A4TApA, ADYaiT.AlLFFp
    public final void ADYaiT(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
        super.ADYaiT(charSequenceArr, i, onClickListener);
    }

    @Override // OOnEhG.A4TApA
    public final OOnEhG.A4TApA ARc23Z(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        throw null;
    }

    @Override // OOnEhG.A4TApA
    public final OOnEhG.A4TApA ASJ6gh() {
        throw null;
    }

    @Override // OOnEhG.A4TApA
    public final OOnEhG.A4TApA AYUAbz() {
        throw null;
    }

    @Override // OOnEhG.A4TApA
    public final OOnEhG.A4TApA AZOQYO(int i) {
        throw null;
    }

    @Override // OOnEhG.A4TApA
    /* renamed from: AZkASS */
    public final OOnEhG.A4TApA A4TApA(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        super.A4TApA(charSequenceArr, zArr, onMultiChoiceClickListener);
        return this;
    }

    @Override // OOnEhG.A4TApA
    public final OOnEhG.A4TApA AaHO0E(int i, DialogInterface.OnClickListener onClickListener) {
        throw null;
    }

    @Override // OOnEhG.A4TApA
    public final OOnEhG.A4TApA AcNBzu(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        throw null;
    }

    @Override // OOnEhG.A4TApA
    public final OOnEhG.A4TApA AlLFFp(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        throw null;
    }

    @Override // OOnEhG.A4TApA
    public final OOnEhG.A4TApA AmA8tU(int i, DialogInterface.OnClickListener onClickListener) {
        throw null;
    }

    @Override // OOnEhG.A4TApA
    public final OOnEhG.A4TApA AzWtSf(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        super.AzWtSf(null, null);
        return this;
    }

    @Override // OOnEhG.A4TApA
    /* renamed from: B25kr6 */
    public final OOnEhG.A4TApA ADYaiT(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
        super.ADYaiT(charSequenceArr, i, onClickListener);
        return this;
    }

    @Override // OOnEhG.A4TApA
    public final OOnEhG.A4TApA B2KMhB(int i) {
        throw null;
    }

    public final void B3GDIM(String str, DialogInterface.OnClickListener onClickListener) {
        super.AcNBzu(str, onClickListener);
    }

    public final void B4ZgIw(DialogInterface.OnClickListener onClickListener) {
        super.AlLFFp("默认", onClickListener);
    }

    public final void B7CMnp(String str, QTPNDK.A2egSU a2egSU) {
        super.AzWtSf(str, new M0ztbm.ADYaiT(this, 6, a2egSU));
    }
}
