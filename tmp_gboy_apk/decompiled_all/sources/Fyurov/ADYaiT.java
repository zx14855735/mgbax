package Fyurov;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final String f2888A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final String f2889A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final String f2890A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final String f2891ADYaiT;
    public final HandlerThread AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final DG07BK.A2egSU f2892ARc23Z;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public final Context f2894AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final int f2895AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final float f2896AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final int f2897AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final A5SV6n f2898AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Cd8JRx.ADYaiT f2899AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public FrameLayout f2900AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public ProgressBar f2901AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public TextView f2902B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public FrameLayout f2903B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public FrameLayout f2904B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public ProgressBar f2905B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public TextView f2906B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public FrameLayout f2907B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public ProgressBar f2908BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public TextView f2909BI9f7h;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public volatile int f2911BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public int f2912BNL6CD;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public int f2893ASJ6gh = 0;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final Object f2910BIYEnU = new Object();

    public ADYaiT(Context context, float f, int i, int i2, A5SV6n a5SV6n) {
        this.f2888A2egSU = "立即下载";
        this.f2889A4TApA = "立即安装";
        this.f2890A5SV6n = "查看详情";
        this.f2891ADYaiT = "继续下载";
        this.AMqCpz = null;
        this.f2897AaHO0E = 11;
        this.f2894AYUAbz = context;
        this.f2896AZkASS = f;
        this.f2895AZOQYO = i2;
        this.f2898AcNBzu = a5SV6n;
        HandlerThread handlerThread = new HandlerThread("CTABtnDecoratorHandlerThread");
        this.AMqCpz = handlerThread;
        handlerThread.start();
        Looper looper = this.AMqCpz.getLooper();
        if (looper != null) {
            this.f2892ARc23Z = new DG07BK.A2egSU(this, looper, 3);
        }
        if (f <= 180.0f) {
            this.f2897AaHO0E = 8;
        } else if (f <= 240.0f) {
            this.f2897AaHO0E = 9;
        } else if (f <= 300.0f) {
            this.f2897AaHO0E = 10;
        }
        if (i == 1) {
            double d = f;
            A4TApA((float) (0.21d * d), (float) (0.06d * d), (float) (d * 0.03d));
            return;
        }
        if (i == 2) {
            this.f2888A2egSU = "下载";
            this.f2889A4TApA = "安装";
            this.f2890A5SV6n = "查看";
            this.f2891ADYaiT = "继续";
            double d2 = f;
            A4TApA((float) (0.14d * d2), (float) (0.05d * d2), (float) (d2 * 0.025d));
            return;
        }
        if (i == 3) {
            this.f2897AaHO0E = 16;
            double d3 = f;
            A4TApA(f, (float) (0.13d * d3), (float) (d3 * 0.017d));
        } else {
            if (i != 4) {
                if (i != 5) {
                    return;
                }
                this.f2897AaHO0E = 16;
                double d4 = f;
                A4TApA(f, (float) (0.2d * d4), (float) (d4 * 0.022d));
                return;
            }
            this.f2888A2egSU = "下载";
            this.f2889A4TApA = "安装";
            this.f2890A5SV6n = "查看";
            this.f2891ADYaiT = "继续";
            this.f2897AaHO0E = 14;
            double d5 = f;
            A4TApA(f, (float) (0.54d * d5), (float) (d5 * 0.077d));
        }
    }

    public final int A2egSU(float f) {
        Context context = this.f2894AYUAbz;
        if (context == null) {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
        } else {
            f = (f * context.getResources().getDisplayMetrics().density) + 0.5f;
        }
        return (int) f;
    }

    public final void A4TApA(float f, float f2, float f3) {
        char c;
        final int i = 0;
        final int i2 = 1;
        Context context = this.f2894AYUAbz;
        if (context == null) {
            return;
        }
        this.f2900AmA8tU = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(A2egSU(f), A2egSU(f2));
        layoutParams.gravity = 17;
        this.f2900AmA8tU.setLayoutParams(layoutParams);
        A5SV6n(this.f2900AmA8tU, f3);
        this.f2901AzWtSf = new ProgressBar(context, null, R.attr.progressBarStyleHorizontal);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, A2egSU(f2));
        layoutParams2.gravity = 17;
        this.f2901AzWtSf.setLayoutParams(layoutParams2);
        float A2egSU2 = A2egSU(f3);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{A2egSU2, A2egSU2, A2egSU2, A2egSU2, A2egSU2, A2egSU2, A2egSU2, A2egSU2}, null, null));
        shapeDrawable.getPaint().setColor(Color.parseColor("#FF739AFF"));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#00000000"));
        gradientDrawable.setCornerRadius(A2egSU2);
        this.f2901AzWtSf.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, new ClipDrawable(shapeDrawable, 5, 1)}));
        this.f2902B25kr6 = new TextView(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        TextView textView = this.f2902B25kr6;
        float f4 = this.f2897AaHO0E;
        textView.setTextSize(f4);
        this.f2902B25kr6.setTextColor(Color.parseColor("#ffffffff"));
        int i3 = this.f2895AZOQYO;
        if (i3 == 1) {
            c = 4;
            this.f2902B25kr6.setText(this.f2888A2egSU);
            this.f2899AlLFFp = new Cd8JRx.ADYaiT(2, this);
        } else if (i3 != 4) {
            String str = this.f2890A5SV6n;
            if (i3 != 5) {
                c = 4;
                this.f2902B25kr6.setText(str);
            } else {
                c = 4;
                this.f2902B25kr6.setText(str);
            }
        } else {
            c = 4;
            this.f2902B25kr6.setText(this.f2889A4TApA);
        }
        this.f2893ASJ6gh = i3;
        this.f2902B25kr6.setGravity(17);
        this.f2900AmA8tU.addView(this.f2901AzWtSf);
        this.f2900AmA8tU.addView(this.f2902B25kr6, layoutParams3);
        this.f2901AzWtSf.setOnClickListener(new View.OnClickListener(this) { // from class: Fyurov.A2egSU

            /* renamed from: AlLFFp, reason: collision with root package name */
            public final /* synthetic */ ADYaiT f2885AlLFFp;

            {
                this.f2885AlLFFp = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i) {
                    case 0:
                        ADYaiT aDYaiT = this.f2885AlLFFp;
                        A5SV6n a5SV6n = aDYaiT.f2898AcNBzu;
                        if (a5SV6n != null) {
                            a5SV6n.a(aDYaiT.f2893ASJ6gh, false);
                            break;
                        }
                        break;
                    case 1:
                        ADYaiT aDYaiT2 = this.f2885AlLFFp;
                        A5SV6n a5SV6n2 = aDYaiT2.f2898AcNBzu;
                        if (a5SV6n2 != null) {
                            a5SV6n2.a(aDYaiT2.f2893ASJ6gh, false);
                            break;
                        }
                        break;
                    default:
                        ADYaiT aDYaiT3 = this.f2885AlLFFp;
                        A5SV6n a5SV6n3 = aDYaiT3.f2898AcNBzu;
                        if (a5SV6n3 != null) {
                            a5SV6n3.a(aDYaiT3.f2893ASJ6gh, true);
                            break;
                        }
                        break;
                }
            }
        });
        double d = this.f2896AZkASS;
        this.f2903B2KMhB = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(A2egSU((float) (d * 0.22d)), A2egSU((float) (d * 0.06d)));
        layoutParams4.gravity = 17;
        this.f2903B2KMhB.setLayoutParams(layoutParams4);
        A5SV6n(this.f2903B2KMhB, (float) (0.03d * d));
        TextView textView2 = new TextView(context);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 17;
        textView2.setText("查看详情");
        textView2.setTextSize(f4);
        textView2.setTextColor(Color.parseColor("#ffffffff"));
        this.f2903B2KMhB.addView(textView2, layoutParams5);
        this.f2904B3GDIM = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams6.gravity = 17;
        this.f2904B3GDIM.setLayoutParams(layoutParams6);
        A5SV6n(this.f2904B3GDIM, 8.0f);
        this.f2905B4ZgIw = new ProgressBar(context, null, R.attr.progressBarStyleHorizontal);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams7.gravity = 17;
        this.f2905B4ZgIw.setLayoutParams(layoutParams7);
        float A2egSU3 = A2egSU(8.0f);
        float[] fArr = new float[8];
        fArr[0] = A2egSU3;
        fArr[1] = A2egSU3;
        fArr[2] = A2egSU3;
        fArr[3] = A2egSU3;
        fArr[c] = A2egSU3;
        fArr[5] = A2egSU3;
        fArr[6] = A2egSU3;
        fArr[7] = A2egSU3;
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new RoundRectShape(fArr, null, null));
        shapeDrawable2.getPaint().setColor(Color.parseColor("#FF739AFF"));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#00000000"));
        gradientDrawable2.setCornerRadius(A2egSU3);
        this.f2905B4ZgIw.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable2, new ClipDrawable(shapeDrawable2, 5, 1)}));
        this.f2906B7CMnp = new TextView(context);
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams8.gravity = 17;
        this.f2906B7CMnp.setTextSize(20.0f);
        this.f2906B7CMnp.setTextColor(Color.parseColor("#ffffffff"));
        int i4 = this.f2893ASJ6gh;
        if (i4 == 1) {
            this.f2906B7CMnp.setText("立即下载");
        } else if (i4 != 4) {
            this.f2906B7CMnp.setText("查看详情");
        } else {
            this.f2906B7CMnp.setText("立即安装");
        }
        this.f2904B3GDIM.addView(this.f2905B4ZgIw);
        this.f2904B3GDIM.addView(this.f2906B7CMnp, layoutParams8);
        final int i5 = 2;
        this.f2905B4ZgIw.setOnClickListener(new View.OnClickListener(this) { // from class: Fyurov.A2egSU

            /* renamed from: AlLFFp, reason: collision with root package name */
            public final /* synthetic */ ADYaiT f2885AlLFFp;

            {
                this.f2885AlLFFp = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i5) {
                    case 0:
                        ADYaiT aDYaiT = this.f2885AlLFFp;
                        A5SV6n a5SV6n = aDYaiT.f2898AcNBzu;
                        if (a5SV6n != null) {
                            a5SV6n.a(aDYaiT.f2893ASJ6gh, false);
                            break;
                        }
                        break;
                    case 1:
                        ADYaiT aDYaiT2 = this.f2885AlLFFp;
                        A5SV6n a5SV6n2 = aDYaiT2.f2898AcNBzu;
                        if (a5SV6n2 != null) {
                            a5SV6n2.a(aDYaiT2.f2893ASJ6gh, false);
                            break;
                        }
                        break;
                    default:
                        ADYaiT aDYaiT3 = this.f2885AlLFFp;
                        A5SV6n a5SV6n3 = aDYaiT3.f2898AcNBzu;
                        if (a5SV6n3 != null) {
                            a5SV6n3.a(aDYaiT3.f2893ASJ6gh, true);
                            break;
                        }
                        break;
                }
            }
        });
        this.f2907B9tovu = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams9 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams9.gravity = 17;
        this.f2907B9tovu.setLayoutParams(layoutParams9);
        A5SV6n(this.f2907B9tovu, 8.0f);
        this.f2908BChYOn = new ProgressBar(context, null, R.attr.progressBarStyleHorizontal);
        FrameLayout.LayoutParams layoutParams10 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams10.gravity = 17;
        this.f2908BChYOn.setLayoutParams(layoutParams10);
        float A2egSU4 = A2egSU(8.0f);
        ShapeDrawable shapeDrawable3 = new ShapeDrawable(new RoundRectShape(new float[]{A2egSU4, A2egSU4, A2egSU4, A2egSU4, A2egSU4, A2egSU4, A2egSU4, A2egSU4}, null, null));
        shapeDrawable3.getPaint().setColor(Color.parseColor("#FF739AFF"));
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#00000000"));
        gradientDrawable3.setCornerRadius(A2egSU4);
        this.f2908BChYOn.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable3, new ClipDrawable(shapeDrawable3, 5, 1)}));
        this.f2909BI9f7h = new TextView(context);
        FrameLayout.LayoutParams layoutParams11 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams11.gravity = 17;
        this.f2909BI9f7h.setTextSize(20.0f);
        this.f2909BI9f7h.setTextColor(Color.parseColor("#ffffffff"));
        int i6 = this.f2893ASJ6gh;
        if (i6 == 1) {
            this.f2909BI9f7h.setText("立即下载");
        } else if (i6 != 4) {
            this.f2909BI9f7h.setText("查看详情");
        } else {
            this.f2909BI9f7h.setText("立即安装");
        }
        this.f2907B9tovu.addView(this.f2908BChYOn);
        this.f2907B9tovu.addView(this.f2909BI9f7h, layoutParams11);
        this.f2908BChYOn.setOnClickListener(new View.OnClickListener(this) { // from class: Fyurov.A2egSU

            /* renamed from: AlLFFp, reason: collision with root package name */
            public final /* synthetic */ ADYaiT f2885AlLFFp;

            {
                this.f2885AlLFFp = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i2) {
                    case 0:
                        ADYaiT aDYaiT = this.f2885AlLFFp;
                        A5SV6n a5SV6n = aDYaiT.f2898AcNBzu;
                        if (a5SV6n != null) {
                            a5SV6n.a(aDYaiT.f2893ASJ6gh, false);
                            break;
                        }
                        break;
                    case 1:
                        ADYaiT aDYaiT2 = this.f2885AlLFFp;
                        A5SV6n a5SV6n2 = aDYaiT2.f2898AcNBzu;
                        if (a5SV6n2 != null) {
                            a5SV6n2.a(aDYaiT2.f2893ASJ6gh, false);
                            break;
                        }
                        break;
                    default:
                        ADYaiT aDYaiT3 = this.f2885AlLFFp;
                        A5SV6n a5SV6n3 = aDYaiT3.f2898AcNBzu;
                        if (a5SV6n3 != null) {
                            a5SV6n3.a(aDYaiT3.f2893ASJ6gh, true);
                            break;
                        }
                        break;
                }
            }
        });
    }

    public final void A5SV6n(FrameLayout frameLayout, float f) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#FF265AE0"));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(A2egSU(f));
        frameLayout.setBackground(gradientDrawable);
    }

    public final void ADYaiT(boolean z) {
        if (z) {
            DG07BK.A2egSU a2egSU = this.f2892ARc23Z;
            if (a2egSU != null) {
                Message obtainMessage = a2egSU.obtainMessage();
                obtainMessage.what = 2;
                this.f2892ARc23Z.sendMessage(obtainMessage);
                return;
            }
            return;
        }
        DG07BK.A2egSU a2egSU2 = this.f2892ARc23Z;
        if (a2egSU2 != null) {
            Message obtainMessage2 = a2egSU2.obtainMessage();
            obtainMessage2.what = 3;
            this.f2892ARc23Z.sendMessage(obtainMessage2);
        }
    }
}
