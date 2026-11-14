package HFjH17;

import ADYaiT.CtFAbx;
import PCV8se.B2KMhB;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaPlayer;
import android.util.StateSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f3319A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public Object f3320A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public Object f3321A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public Object f3322ADYaiT;
    public Object AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public Object f3323ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public Object f3324ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public Object f3325AYUAbz;

    public ARc23Z(B2KMhB b2KMhB) {
        AYUAbz();
        ASJ6gh(StateSet.WILD_CARD, b2KMhB);
    }

    public static void AMqCpz(SeekBar seekBar) {
        seekBar.setPadding(0, 0, 0, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutParams.setMargins(0, 0, 0, 0);
        seekBar.setLayoutParams(layoutParams);
        Drawable progressDrawable = seekBar.getProgressDrawable();
        int parseColor = Color.parseColor("#2F80ED");
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        progressDrawable.setColorFilter(parseColor, mode);
        Drawable background = seekBar.getBackground();
        if (background != null) {
            background.setColorFilter(Color.parseColor("#F2F6F9"), mode);
        }
        seekBar.setThumb(null);
        seekBar.setOnTouchListener(new AMqCpz(0));
    }

    public int A2egSU(float f) {
        return (int) ((f * ((Context) this.f3320A4TApA).getResources().getDisplayMetrics().density) + 0.5f);
    }

    public FrameLayout A4TApA(K1Z3yj.A2egSU a2egSU) {
        this.f3324ASJ6gh = a2egSU;
        Context context = (Context) this.f3320A4TApA;
        this.f3325AYUAbz = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        ((FrameLayout) this.f3325AYUAbz).setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(context);
        this.f3323ARc23Z = imageView;
        imageView.setOnClickListener(new Dphsd2.A2egSU(3, this));
        ((FrameLayout) this.f3325AYUAbz).addView((ImageView) this.f3323ARc23Z);
        return (FrameLayout) this.f3325AYUAbz;
    }

    public void A5SV6n(int i) {
        ImageView imageView;
        MediaPlayer mediaPlayer;
        if (((FrameLayout) this.f3325AYUAbz) == null || (imageView = (ImageView) this.f3323ARc23Z) == null || (mediaPlayer = (MediaPlayer) this.f3321A5SV6n) == null || ((K1Z3yj.A2egSU) this.f3324ASJ6gh) == null) {
            int i2 = GJee0v.AZOQYO.f3039AcNBzu;
            return;
        }
        try {
            if (i == 0) {
                if (ARc23Z()) {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                }
                ((ImageView) this.f3323ARc23Z).setImageResource(2131231399);
                K1Z3yj.A2egSU a2egSU = (K1Z3yj.A2egSU) this.f3324ASJ6gh;
                ((A5SV6n) a2egSU.f4174AlLFFp).a(false);
                ((ADYaiT) a2egSU.f4175AmA8tU).f3291ADYaiT = true;
            } else if (i != 1) {
                imageView.setImageResource(2131231399);
                int i3 = GJee0v.AZOQYO.f3039AcNBzu;
            } else {
                if (ARc23Z()) {
                    mediaPlayer.setVolume(1.0f, 1.0f);
                }
                ((ImageView) this.f3323ARc23Z).setImageResource(2131231400);
                K1Z3yj.A2egSU a2egSU2 = (K1Z3yj.A2egSU) this.f3324ASJ6gh;
                ((A5SV6n) a2egSU2.f4174AlLFFp).a(true);
                ((ADYaiT) a2egSU2.f4175AmA8tU).f3291ADYaiT = false;
            }
            this.f3319A2egSU = i;
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("VideoDecorator 001: "), new EY4UKY.ADYaiT(), "004", e);
        }
    }

    public void ADYaiT(ViewGroup viewGroup, String str, float f, float f2, float f3, float f4) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setCornerRadii(new float[]{A2egSU(f), A2egSU(f), A2egSU(f2), A2egSU(f2), A2egSU(f3), A2egSU(f3), A2egSU(f4), A2egSU(f4)});
        viewGroup.setBackground(gradientDrawable);
    }

    public boolean ARc23Z() {
        MediaPlayer mediaPlayer = (MediaPlayer) this.f3321A5SV6n;
        if (mediaPlayer != null) {
            try {
                if (mediaPlayer.isPlaying()) {
                    return true;
                }
                if (mediaPlayer.getCurrentPosition() >= 0) {
                    return true;
                }
            } catch (IllegalStateException e) {
                e.getMessage();
                int i = GJee0v.AZOQYO.f3039AcNBzu;
            }
        }
        return false;
    }

    public void ASJ6gh(int[] iArr, B2KMhB b2KMhB) {
        int i = this.f3319A2egSU;
        if (i == 0 || iArr.length == 0) {
            this.f3320A4TApA = b2KMhB;
        }
        int[][] iArr2 = (int[][]) this.f3321A5SV6n;
        if (i >= iArr2.length) {
            int i2 = i + 10;
            int[][] iArr3 = new int[i2][];
            System.arraycopy(iArr2, 0, iArr3, 0, i);
            this.f3321A5SV6n = iArr3;
            B2KMhB[] b2KMhBArr = new B2KMhB[i2];
            System.arraycopy((B2KMhB[]) this.f3322ADYaiT, 0, b2KMhBArr, 0, i);
            this.f3322ADYaiT = b2KMhBArr;
        }
        int[][] iArr4 = (int[][]) this.f3321A5SV6n;
        int i3 = this.f3319A2egSU;
        iArr4[i3] = iArr;
        ((B2KMhB[]) this.f3322ADYaiT)[i3] = b2KMhB;
        this.f3319A2egSU = i3 + 1;
    }

    public void AYUAbz() {
        this.f3320A4TApA = new B2KMhB();
        this.f3321A5SV6n = new int[10][];
        this.f3322ADYaiT = new B2KMhB[10];
    }
}
