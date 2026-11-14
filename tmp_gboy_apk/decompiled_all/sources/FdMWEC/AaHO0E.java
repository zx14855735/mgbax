package FdMWEC;

import ADYaiT.CtFAbx;
import COJEAR.DyaChj;
import Fyurov.AZOQYO;
import Fyurov.AlLFFp;
import Fyurov.B25kr6;
import Fyurov.B2KMhB;
import Fyurov.B4ZgIw;
import GJee0v.AzWtSf;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.bean.Swipe;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AaHO0E extends Handler {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f2866A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AZkASS f2867A4TApA;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AaHO0E(AZkASS aZkASS, Looper looper, int i) {
        super(looper);
        this.f2866A2egSU = i;
        this.f2867A4TApA = aZkASS;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        AZkASS aZkASS;
        View view;
        int i;
        int i2;
        B2KMhB b2KMhB;
        View view2 = null;
        AZkASS aZkASS2 = this.f2867A4TApA;
        int i3 = 3;
        switch (this.f2866A2egSU) {
            case 0:
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                super.handleMessage(message);
                if (!aZkASS2.f3189AZkASS) {
                    int i4 = aZkASS2.f2830GGG1xW + 100;
                    aZkASS2.f2830GGG1xW = i4;
                    if (i4 < 3000) {
                        aZkASS2.f2839GnQT2j.sendEmptyMessageDelayed(0, 100L);
                        break;
                    } else {
                        if (aZkASS2.f2834GL2Jh7) {
                            aZkASS2.D07BeM(aZkASS2.f3187AYUAbz);
                        }
                        aZkASS2.DRlcZ9();
                        aZkASS2.B4ZgIw("素材加载超时", "1", "加载超时导致素材不可用");
                        aZkASS2.f2865IQ76hF = 8;
                        break;
                    }
                } else {
                    FrameLayout frameLayout = aZkASS2.f2807EiK8oA;
                    int i5 = GJee0v.AZOQYO.f3039AcNBzu;
                    aZkASS2.f2865IQ76hF = 4;
                    if (aZkASS2.f3187AYUAbz == null || frameLayout == null) {
                        aZkASS = aZkASS2;
                        aZkASS.B4ZgIw("Show failure", "2", "container is null");
                        aZkASS.f2865IQ76hF = 8;
                        view2 = null;
                    } else {
                        Context A4TApA2 = GJee0v.A2egSU.A4TApA(aZkASS2.f3185ARc23Z);
                        if (A4TApA2 == null) {
                            aZkASS2.f2865IQ76hF = 8;
                        } else {
                            View inflate = LayoutInflater.from(A4TApA2).inflate(2131493183, (ViewGroup) null, false);
                            if (inflate == null) {
                                inflate = null;
                            } else {
                                aZkASS2.f2814F1loUV = (ImageView) inflate.findViewById(2131296794);
                                aZkASS2.f2812EwN40Z = (FrameLayout) inflate.findViewById(2131296685);
                                aZkASS2.f2815F32kj0 = (ImageView) inflate.findViewById(2131296778);
                                aZkASS2.f2819FOAO9d = (TextView) inflate.findViewById(2131298222);
                                aZkASS2.f2816F508T2 = (ImageView) inflate.findViewById(2131296795);
                                aZkASS2.f2818FM663C = (FrameLayout) inflate.findViewById(2131296793);
                                aZkASS2.f2817FG7pZc = (ImageView) inflate.findViewById(2131296779);
                                aZkASS2.f2809EmJGcg = (FrameLayout) inflate.findViewById(2131298360);
                                aZkASS2.f2810ErKPGd = (FrameLayout) inflate.findViewById(2131296684);
                                aZkASS2.f2811EsrwYR = (FrameLayout) inflate.findViewById(2131298361);
                                aZkASS2.f2808EicXu4 = (FrameLayout) inflate.findViewById(2131298359);
                                aZkASS2.f2820FSFw2u = (TextView) inflate.findViewById(2131298362);
                            }
                            if (inflate == null) {
                                aZkASS2.B4ZgIw("Show failure", "2", "layout view is null");
                                aZkASS2.f2865IQ76hF = 8;
                            } else {
                                inflate.addOnAttachStateChangeListener(new AZkASS.ADYaiT(i3, aZkASS2));
                                aZkASS2.f2808EicXu4.setOnClickListener(new A2egSU(aZkASS2, 1));
                                AzWtSf azWtSf = new AzWtSf();
                                azWtSf.f3055AlLFFp = aZkASS2;
                                aZkASS2.f2808EicXu4.setOnTouchListener(new AMqCpz(0, new GestureDetector(azWtSf)));
                                int i6 = aZkASS2.f2846HHLj6Q;
                                if (i6 == 1) {
                                    aZkASS = aZkASS2;
                                    view = inflate;
                                    try {
                                        if (aZkASS.f2825FmyuN2 != null) {
                                            if (aZkASS.f2824Fmmv0E.getTempid() == null || aZkASS.f2824Fmmv0E.getTempid().isEmpty() || aZkASS.f2824Fmmv0E.getTempid().equals("1100001") || !aZkASS.f2824Fmmv0E.getTempid().equals("1100002")) {
                                                i = 1;
                                                i2 = 108;
                                            } else {
                                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) aZkASS.f2809EmJGcg.getLayoutParams();
                                                int i7 = (int) ((MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET * A4TApA2.getResources().getDisplayMetrics().density) + 0.5f);
                                                layoutParams.width = i7;
                                                layoutParams.height = i7;
                                                aZkASS.f2809EmJGcg.setLayoutParams(layoutParams);
                                                i = 3;
                                                i2 = MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET;
                                            }
                                            Fyurov.ASJ6gh aSJ6gh = new Fyurov.ASJ6gh(A4TApA2, i, i2, aZkASS.f2825FmyuN2, new A4TApA(aZkASS));
                                            aZkASS.f2821FZu94u = aSJ6gh;
                                            aZkASS.f2809EmJGcg.addView(aSJ6gh.f2923AZOQYO);
                                            aZkASS.f2847HIguqb = aZkASS.f2825FmyuN2.getResetSensitivity();
                                        } else {
                                            aZkASS.f2809EmJGcg.setVisibility(8);
                                        }
                                    } catch (Exception e) {
                                        e.getMessage();
                                        int i8 = GJee0v.AZOQYO.f3039AcNBzu;
                                    }
                                } else if (i6 != 2) {
                                    aZkASS = aZkASS2;
                                    view = inflate;
                                } else {
                                    int width = (int) ((aZkASS2.f2807EiK8oA.getWidth() / A4TApA2.getResources().getDisplayMetrics().density) + 0.5f);
                                    boolean z = aZkASS2.f2842H1wUHe == 0;
                                    Swipe swipe = aZkASS2.f2826FpcJKS;
                                    AYUAbz aYUAbz = new AYUAbz(aZkASS2);
                                    if (width <= 0) {
                                        b2KMhB = null;
                                        aZkASS = aZkASS2;
                                        view = inflate;
                                    } else {
                                        B2KMhB b2KMhB2 = new B2KMhB();
                                        b2KMhB2.f2961A4TApA = 0;
                                        view = inflate;
                                        b2KMhB2.f2963ADYaiT = 15.0d;
                                        b2KMhB2.AMqCpz = 30;
                                        b2KMhB2.f2969AaHO0E = 0.0f;
                                        b2KMhB2.f2970AcNBzu = 0.0f;
                                        b2KMhB2.f2960A2egSU = A4TApA2;
                                        b2KMhB2.f2962A5SV6n = width;
                                        b2KMhB2.f2964ARc23Z = aYUAbz;
                                        if (swipe != null) {
                                            b2KMhB2.f2961A4TApA = swipe.getDirection();
                                            b2KMhB2.f2963ADYaiT = swipe.getLimitAngle();
                                            b2KMhB2.AMqCpz = swipe.getSwipeLengthDefault();
                                        }
                                        double d = width;
                                        float f = (float) (d * 1.2d);
                                        FrameLayout frameLayout2 = new FrameLayout(A4TApA2);
                                        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                                        FrameLayout frameLayout3 = new FrameLayout(A4TApA2);
                                        frameLayout3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                                        frameLayout2.addView(frameLayout3);
                                        RelativeLayout relativeLayout = new RelativeLayout(A4TApA2);
                                        relativeLayout.setGravity(80);
                                        float f2 = width;
                                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b2KMhB2.A2egSU(f2), b2KMhB2.A2egSU(f));
                                        layoutParams2.gravity = 80;
                                        relativeLayout.setLayoutParams(layoutParams2);
                                        frameLayout3.addView(relativeLayout);
                                        LinearLayout A5SV6n2 = b2KMhB2.A5SV6n(74.0f);
                                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, b2KMhB2.A2egSU(100.0f));
                                        FrameLayout frameLayout4 = new FrameLayout(A4TApA2);
                                        frameLayout4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                                        int i9 = (int) (d * 0.03d);
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(b2KMhB2.A4TApA(0, frameLayout4));
                                        arrayList.add(b2KMhB2.A4TApA(i9, frameLayout4));
                                        arrayList.add(b2KMhB2.A4TApA(i9 * 2, frameLayout4));
                                        arrayList.add(b2KMhB2.A4TApA(i9 * 3, frameLayout4));
                                        ImageView imageView = new ImageView(A4TApA2);
                                        imageView.setImageBitmap(BitmapFactory.decodeResource(A4TApA2.getResources(), 2131231420));
                                        frameLayout4.addView(imageView);
                                        A5SV6n2.addView(frameLayout4);
                                        LinearLayout A5SV6n3 = b2KMhB2.A5SV6n(237.0f);
                                        layoutParams3.addRule(6, A5SV6n3.getId());
                                        boolean z2 = z;
                                        relativeLayout.addView(A5SV6n3, new RelativeLayout.LayoutParams(-1, -2));
                                        relativeLayout.addView(A5SV6n2, layoutParams3);
                                        FrameLayout frameLayout5 = new FrameLayout(A4TApA2);
                                        frameLayout5.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                                        B25kr6 b25kr6 = new B25kr6(b2KMhB2, A4TApA2);
                                        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(b2KMhB2.A2egSU(f2), b2KMhB2.A2egSU((float) (f * 0.76d)));
                                        layoutParams4.gravity = 80;
                                        b25kr6.setLayoutParams(layoutParams4);
                                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 30.0f);
                                        ofFloat.setDuration(800L);
                                        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                                        ofFloat.addUpdateListener(new Fyurov.AaHO0E(b2KMhB2, b25kr6, imageView, arrayList));
                                        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(30.0f, 0.0f);
                                        ofFloat2.setDuration(800L);
                                        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                                        ofFloat2.addUpdateListener(new Fyurov.AcNBzu(b2KMhB2, b25kr6, arrayList, 0));
                                        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 30.0f);
                                        ofFloat3.setDuration(200L);
                                        ofFloat3.addUpdateListener(new AlLFFp(b2KMhB2, arrayList, 0));
                                        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 30.0f);
                                        ofFloat3.setDuration(200L);
                                        ofFloat4.addListener(new DyaChj(b2KMhB2, 2, imageView));
                                        ofFloat4.addUpdateListener(new AlLFFp(b2KMhB2, arrayList, 1));
                                        AnimatorSet animatorSet = new AnimatorSet();
                                        b2KMhB2.f2968AZkASS = animatorSet;
                                        animatorSet.playSequentially(ofFloat, ofFloat4, ofFloat2, ofFloat3);
                                        b2KMhB2.f2968AZkASS.addListener(new AaHO0E.A5SV6n(4, b2KMhB2));
                                        b2KMhB2.f2968AZkASS.start();
                                        LinearLayout linearLayout = new LinearLayout(A4TApA2);
                                        linearLayout.setOrientation(1);
                                        linearLayout.setGravity(17);
                                        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, -2, 80);
                                        layoutParams5.bottomMargin = b2KMhB2.A2egSU((float) (0.25d * d));
                                        linearLayout.setLayoutParams(layoutParams5);
                                        TextView textView = new TextView(A4TApA2);
                                        b2KMhB2.f2966AYUAbz = textView;
                                        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                                        b2KMhB2.f2966AYUAbz.setText("划一划或点击");
                                        b2KMhB2.f2966AYUAbz.setTextColor(-1);
                                        b2KMhB2.f2966AYUAbz.setGravity(17);
                                        b2KMhB2.f2966AYUAbz.setTextSize(18.0f);
                                        TextView textView2 = new TextView(A4TApA2);
                                        b2KMhB2.f2967AZOQYO = textView2;
                                        textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                                        b2KMhB2.f2967AZOQYO.setText("跳转详情页或第三方应用");
                                        b2KMhB2.f2967AZOQYO.setTextColor(-1);
                                        b2KMhB2.f2967AZOQYO.setGravity(17);
                                        b2KMhB2.f2967AZOQYO.setTextSize(14.0f);
                                        linearLayout.addView(b2KMhB2.f2966AYUAbz);
                                        linearLayout.addView(b2KMhB2.f2967AZOQYO);
                                        frameLayout5.addView(b25kr6);
                                        frameLayout5.addView(linearLayout);
                                        A5SV6n3.addView(frameLayout5);
                                        b2KMhB2.f2965ASJ6gh = frameLayout2;
                                        if (z2) {
                                            b2KMhB2.AMqCpz(frameLayout3, true);
                                        } else if (b2KMhB2.f2961A4TApA == 1) {
                                            b2KMhB2.AMqCpz(A5SV6n3, true);
                                        } else {
                                            b2KMhB2.AMqCpz(A5SV6n3, true);
                                            b2KMhB2.AMqCpz(frameLayout3, false);
                                        }
                                        aZkASS = aZkASS2;
                                        b2KMhB = b2KMhB2;
                                    }
                                    aZkASS.f2852HXc4pW = b2KMhB;
                                    if (b2KMhB != null) {
                                        aZkASS.f2813ExjC7D = b2KMhB.f2965ASJ6gh;
                                    }
                                    if (aZkASS.f2813ExjC7D != null && aZkASS.f2810ErKPGd != null) {
                                        aZkASS.f2808EicXu4.setVisibility(8);
                                        aZkASS.f2810ErKPGd.addView(aZkASS.f2813ExjC7D);
                                    }
                                    if (aZkASS.f2828G58fqA == 1) {
                                        B2KMhB b2KMhB3 = aZkASS.f2852HXc4pW;
                                        b2KMhB3.getClass();
                                        TextView textView3 = b2KMhB3.f2966AYUAbz;
                                        if (textView3 != null) {
                                            textView3.setText(" 划一划或点击");
                                        }
                                        TextView textView4 = b2KMhB3.f2967AZOQYO;
                                        if (textView4 != null) {
                                            textView4.setText("下载 App 或跳转至第三方应用");
                                        }
                                    }
                                }
                                view2 = view;
                                aZkASS.f2819FOAO9d.setOnClickListener(new FSFw2u.AMqCpz(aZkASS, 1, view2));
                                aZkASS.f2857HtmBAy = B4ZgIw.A2egSU(PushUIConfig.dismissTime, new DaOi9o.AYUAbz(aZkASS, 2, view2));
                                try {
                                    if (aZkASS.f2828G58fqA == 1) {
                                        AZOQYO.A2egSU a2egSU = new AZOQYO.A2egSU();
                                        FrameLayout frameLayout6 = aZkASS.f2811EsrwYR;
                                        Fyurov.AZOQYO azoqyo = a2egSU.f2939A2egSU;
                                        azoqyo.f2932ARc23Z = false;
                                        azoqyo.f2929A4TApA = frameLayout6;
                                        azoqyo.f2928A2egSU = 1;
                                        azoqyo.f2933ASJ6gh = 31;
                                        Material material = aZkASS.f2824Fmmv0E;
                                        azoqyo.f2930A5SV6n = A4TApA2;
                                        azoqyo.f2931ADYaiT = material;
                                        azoqyo.AMqCpz = new AZOQYO(aZkASS);
                                        a2egSU.A2egSU();
                                    } else {
                                        aZkASS.f2811EsrwYR.setVisibility(8);
                                        ImageView imageView2 = aZkASS.f2816F508T2;
                                        if (imageView2 != null) {
                                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView2.getLayoutParams();
                                            marginLayoutParams.bottomMargin = 16;
                                            aZkASS.f2816F508T2.setLayoutParams(marginLayoutParams);
                                        }
                                    }
                                } catch (Exception e2) {
                                    e2.getMessage();
                                    int i10 = GJee0v.AZOQYO.f3039AcNBzu;
                                }
                                int i11 = 2;
                                if (aZkASS.f2846HHLj6Q != 2) {
                                    aZkASS.f2808EicXu4.getViewTreeObserver().addOnGlobalLayoutListener(new HH6JFw.A4TApA(aZkASS, A4TApA2, i11));
                                }
                                TextView textView5 = aZkASS.f2820FSFw2u;
                                if (textView5 != null && aZkASS.f2828G58fqA == 1) {
                                    textView5.setText("点击下载 App 或跳转至第三方应用");
                                }
                                try {
                                    if (aZkASS.f2835GTPRn3) {
                                        aZkASS.EGM26s(view2, frameLayout);
                                        aZkASS.f2814F1loUV.setVisibility(0);
                                        aZkASS.f2818FM663C.setVisibility(8);
                                        aZkASS.f2812EwN40Z.setVisibility(8);
                                    } else if (aZkASS.f2834GL2Jh7) {
                                        aZkASS.EPdU4G(view2, frameLayout);
                                        aZkASS.f2814F1loUV.setVisibility(8);
                                        aZkASS.f2812EwN40Z.setVisibility(0);
                                        aZkASS.f2818FM663C.setVisibility(0);
                                    }
                                    aZkASS.f2819FOAO9d.setVisibility(0);
                                    aZkASS.ECyGFg(aZkASS.f2819FOAO9d, 16);
                                } catch (Exception e3) {
                                    CtFAbx.B4ZgIw(e3, JrXYwF.A4TApA.AMqCpz("NMSplashAdImpl 005: "), new EY4UKY.ADYaiT(), "004", null);
                                    aZkASS.f2865IQ76hF = 8;
                                }
                            }
                        }
                        aZkASS = aZkASS2;
                    }
                    if (view2 != null) {
                        view2.getViewTreeObserver().addOnWindowFocusChangeListener(new ARc23Z(0, aZkASS));
                        break;
                    }
                }
                break;
            default:
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                super.handleMessage(message);
                int i12 = GJee0v.AZOQYO.f3039AcNBzu;
                AZkASS.DvK7DB(aZkASS2, aZkASS2.f2843H3v3Sq, null);
                break;
        }
    }
}
