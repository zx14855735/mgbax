package FOAO9d;

import ADYaiT.CtFAbx;
import Fyurov.B4ZgIw;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh extends Handler {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f2587A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AcNBzu f2588A4TApA;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ASJ6gh(AcNBzu acNBzu, Looper looper, int i) {
        super(looper);
        this.f2587A2egSU = i;
        this.f2588A4TApA = acNBzu;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        FrameLayout frameLayout4;
        FrameLayout frameLayout5;
        FrameLayout frameLayout6;
        FrameLayout frameLayout7;
        boolean z = true;
        AcNBzu acNBzu = this.f2588A4TApA;
        switch (this.f2587A2egSU) {
            case 0:
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                super.handleMessage(message);
                try {
                    if (acNBzu.f2608F32kj0.getVisibility() != 0) {
                        int i = acNBzu.f2619FpcJKS + 100;
                        acNBzu.f2619FpcJKS = i;
                        if (i >= 2000) {
                            acNBzu.B4ZgIw("信息流广告展示超时", "1", "加载超时导致素材不可用");
                        } else {
                            acNBzu.f2650HtmBAy.sendEmptyMessageDelayed(0, 100L);
                        }
                    } else if (acNBzu.f2641HMGPfW == null) {
                        acNBzu.DaOi9o();
                    } else {
                        if (EQurEW.A4TApA.A2egSU(acNBzu.f2608F32kj0) < 50.0f) {
                            z = false;
                        }
                        acNBzu.f2638HH6JFw = z;
                        if (z) {
                            acNBzu.DaOi9o();
                        }
                    }
                    break;
                } catch (Exception e) {
                    CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 020: "), new EY4UKY.ADYaiT(), "004", e);
                    return;
                }
            case 1:
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                super.handleMessage(message);
                try {
                    if (!acNBzu.f2616Ff5QvW) {
                        int i2 = acNBzu.f2619FpcJKS + 100;
                        acNBzu.f2619FpcJKS = i2;
                        if (i2 >= 5000) {
                            acNBzu.D07BeM(acNBzu.f3187AYUAbz);
                            acNBzu.DuwtYk(3, null, 200007, "模板信息流视频素材加载超时");
                            acNBzu.BTvldC("2", "视频下载超时");
                            HFjH17.ADYaiT aDYaiT = acNBzu.f2636H3v3Sq;
                            if (aDYaiT != null) {
                                aDYaiT.AlLFFp();
                                acNBzu.f2636H3v3Sq = null;
                            }
                        } else {
                            acNBzu.f2659IYh8XG.sendEmptyMessageDelayed(0, 100L);
                        }
                    }
                    break;
                } catch (Exception e2) {
                    CtFAbx.B4ZgIw(e2, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 022: "), new EY4UKY.ADYaiT(), "004", e2);
                    return;
                }
            case 2:
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                super.handleMessage(message);
                try {
                    HashMap hashMap = (HashMap) acNBzu.f2646HZUvgL.get(0);
                    if (hashMap != null && hashMap.get(2) != null && ((String) hashMap.get(2)).contains("finish")) {
                        if (hashMap.get(3) != null && !((String) hashMap.get(3)).isEmpty()) {
                            ImageView imageView = new ImageView(GJee0v.A2egSU.A4TApA(acNBzu.f3185ARc23Z));
                            imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                            JrXYwF.A4TApA.AYUAbz(acNBzu.f3185ARc23Z, imageView, (String) hashMap.get(3), 0.1f);
                            if (acNBzu.f2601EicXu4 != 4) {
                                FrameLayout frameLayout8 = acNBzu.f2630GcSJYy;
                                if (frameLayout8 != null) {
                                    frameLayout8.addView(imageView);
                                    acNBzu.EPdU4G(acNBzu.f2630GcSJYy);
                                    GIi2tl.A2egSU a2egSU = acNBzu.GZqyMh;
                                    if (a2egSU != null && (frameLayout = a2egSU.f3011B7CMnp) != null) {
                                        acNBzu.f2630GcSJYy.addView(frameLayout);
                                    }
                                }
                            } else if (!acNBzu.f2631GhvxjZ.isEmpty() && acNBzu.f2631GhvxjZ.get(0) != null) {
                                ((ViewGroup) acNBzu.f2631GhvxjZ.get(0)).removeAllViews();
                                ((ViewGroup) acNBzu.f2631GhvxjZ.get(0)).addView(imageView);
                                acNBzu.EPdU4G((View) acNBzu.f2631GhvxjZ.get(0));
                            }
                            if (acNBzu.f2669J3EcKw == 4 && (frameLayout2 = acNBzu.f2634H0qugq) != null && (frameLayout3 = acNBzu.f2630GcSJYy) != null) {
                                frameLayout3.bringChildToFront(frameLayout2);
                                acNBzu.f2630GcSJYy.requestLayout();
                                acNBzu.f2630GcSJYy.invalidate();
                                break;
                            }
                        }
                    } else {
                        int i3 = acNBzu.f2619FpcJKS + 100;
                        acNBzu.f2619FpcJKS = i3;
                        if (i3 < 6000) {
                            acNBzu.f2660Ifhupb.sendEmptyMessageDelayed(0, 100L);
                            break;
                        } else {
                            acNBzu.B4ZgIw("gif01加载超时", "1", "加载超时导致素材不可用");
                            break;
                        }
                    }
                } catch (Exception e3) {
                    CtFAbx.B4ZgIw(e3, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 023: "), new EY4UKY.ADYaiT(), "004", e3);
                    return;
                }
                break;
            case 3:
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                super.handleMessage(message);
                try {
                    HashMap hashMap2 = (HashMap) acNBzu.f2646HZUvgL.get(1);
                    if (hashMap2 != null && hashMap2.get(2) != null && ((String) hashMap2.get(2)).contains("finish")) {
                        if (hashMap2.get(3) != null && !((String) hashMap2.get(3)).isEmpty()) {
                            ImageView imageView2 = new ImageView(GJee0v.A2egSU.A4TApA(acNBzu.f3185ARc23Z));
                            imageView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                            JrXYwF.A4TApA.AYUAbz(acNBzu.f3185ARc23Z, imageView2, (String) hashMap2.get(3), 0.1f);
                            if (!acNBzu.f2631GhvxjZ.isEmpty() && acNBzu.f2631GhvxjZ.get(1) != null) {
                                ((ViewGroup) acNBzu.f2631GhvxjZ.get(1)).removeAllViews();
                                ((ViewGroup) acNBzu.f2631GhvxjZ.get(1)).addView(imageView2);
                                acNBzu.EPdU4G((View) acNBzu.f2631GhvxjZ.get(1));
                            }
                            if (acNBzu.f2669J3EcKw == 4 && (frameLayout4 = acNBzu.f2634H0qugq) != null && (frameLayout5 = acNBzu.f2630GcSJYy) != null) {
                                frameLayout5.bringChildToFront(frameLayout4);
                                acNBzu.f2630GcSJYy.requestLayout();
                                acNBzu.f2630GcSJYy.invalidate();
                                break;
                            }
                        }
                    } else {
                        int i4 = acNBzu.f2619FpcJKS + 100;
                        acNBzu.f2619FpcJKS = i4;
                        if (i4 < 6000) {
                            acNBzu.f2661IhMMDv.sendEmptyMessageDelayed(0, 100L);
                            break;
                        } else {
                            acNBzu.B4ZgIw("gif02加载超时", "1", "加载超时导致素材不可用");
                            break;
                        }
                    }
                } catch (Exception e4) {
                    CtFAbx.B4ZgIw(e4, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 024: "), new EY4UKY.ADYaiT(), "004", e4);
                    return;
                }
                break;
            case 4:
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                super.handleMessage(message);
                try {
                    HashMap hashMap3 = (HashMap) acNBzu.f2646HZUvgL.get(2);
                    if (hashMap3 != null && hashMap3.get(2) != null && ((String) hashMap3.get(2)).contains("finish")) {
                        if (hashMap3.get(3) != null && !((String) hashMap3.get(3)).isEmpty()) {
                            ImageView imageView3 = new ImageView(GJee0v.A2egSU.A4TApA(acNBzu.f3185ARc23Z));
                            imageView3.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                            JrXYwF.A4TApA.AYUAbz(acNBzu.f3185ARc23Z, imageView3, (String) hashMap3.get(3), 0.1f);
                            if (!acNBzu.f2631GhvxjZ.isEmpty() && acNBzu.f2631GhvxjZ.get(2) != null) {
                                ((ViewGroup) acNBzu.f2631GhvxjZ.get(2)).removeAllViews();
                                ((ViewGroup) acNBzu.f2631GhvxjZ.get(2)).addView(imageView3);
                                acNBzu.EPdU4G((View) acNBzu.f2631GhvxjZ.get(2));
                            }
                            if (acNBzu.f2669J3EcKw == 4 && (frameLayout6 = acNBzu.f2634H0qugq) != null && (frameLayout7 = acNBzu.f2630GcSJYy) != null) {
                                frameLayout7.bringChildToFront(frameLayout6);
                                acNBzu.f2630GcSJYy.requestLayout();
                                acNBzu.f2630GcSJYy.invalidate();
                                break;
                            }
                        }
                    } else {
                        int i5 = acNBzu.f2619FpcJKS + 100;
                        acNBzu.f2619FpcJKS = i5;
                        if (i5 < 6000) {
                            acNBzu.f2662IlwJBd.sendEmptyMessageDelayed(0, 100L);
                            break;
                        } else {
                            acNBzu.B4ZgIw("gif03加载超时", "1", "加载超时导致素材不可用");
                            break;
                        }
                    }
                } catch (Exception e5) {
                    CtFAbx.B4ZgIw(e5, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 025: "), new EY4UKY.ADYaiT(), "004", e5);
                    return;
                }
                break;
            case 5:
                int i6 = message.what;
                int i7 = GJee0v.AZOQYO.f3039AcNBzu;
                if (i6 == 1) {
                    GJee0v.AZkASS.f3040ADYaiT.f3043A5SV6n.post(new CtFAbx.A2egSU(2, this));
                    break;
                } else if (i6 == 3) {
                    B4ZgIw b4ZgIw = acNBzu.f2653I3bnmY;
                    if (b4ZgIw != null) {
                        b4ZgIw.A5SV6n();
                        break;
                    }
                } else if (i6 == 4) {
                    B4ZgIw b4ZgIw2 = acNBzu.f2653I3bnmY;
                    if (b4ZgIw2 != null) {
                        b4ZgIw2.A4TApA();
                        break;
                    }
                } else if (i6 == 5) {
                    HFjH17.ADYaiT aDYaiT2 = acNBzu.f2636H3v3Sq;
                    if (aDYaiT2 != null && !acNBzu.f2612FOAO9d && aDYaiT2.AcNBzu()) {
                        acNBzu.CTkVKb(acNBzu.f3187AYUAbz);
                        acNBzu.f2657IOxIEW = false;
                    }
                    acNBzu.f2668IzHBwY = 6;
                    acNBzu.EY4UKY(4);
                    break;
                } else if (i6 == 6) {
                    HFjH17.ADYaiT aDYaiT3 = acNBzu.f2636H3v3Sq;
                    if (aDYaiT3 != null && !acNBzu.f2612FOAO9d && aDYaiT3.AmA8tU() && !acNBzu.f2657IOxIEW) {
                        acNBzu.f2657IOxIEW = true;
                        acNBzu.BPw6Q8(acNBzu.f3187AYUAbz);
                    }
                    acNBzu.f2668IzHBwY = 5;
                    break;
                }
                break;
            case 6:
                super.handleMessage(message);
                int i8 = message.what;
                if (i8 > 0 && i8 <= 100) {
                    if (!acNBzu.f2663IsbtnO && acNBzu.f3196B2KMhB == 1) {
                        acNBzu.f2663IsbtnO = true;
                    }
                    if (i8 != acNBzu.f2664IssTRV) {
                        acNBzu.f2664IssTRV = i8;
                        Cd8JRx.ADYaiT aDYaiT4 = acNBzu.H6qKiO;
                        if (aDYaiT4 != null) {
                            aDYaiT4.A2egSU(i8);
                        }
                        if (i8 == 100) {
                            acNBzu.f3196B2KMhB = 2;
                            acNBzu.C2rE4F();
                            break;
                        }
                    }
                }
                break;
            default:
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                super.handleMessage(message);
                int i9 = GJee0v.AZOQYO.f3039AcNBzu;
                AcNBzu.DyaChj(acNBzu, acNBzu.f2643HSHyT0, null);
                break;
        }
    }
}
