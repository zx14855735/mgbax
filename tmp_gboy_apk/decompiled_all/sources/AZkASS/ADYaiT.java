package AZkASS;

import ADYaiT.CtFAbx;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alliance.ssp.ad.activity.NMRewardVideoActivity;
import com.alliance.ssp.ad.utils.DeviceUtil;
import com.czhj.sdk.common.Constants;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT implements View.OnAttachStateChangeListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f443AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f444AlLFFp;

    public /* synthetic */ ADYaiT(int i, Object obj) {
        this.f443AcNBzu = i;
        this.f444AlLFFp = obj;
    }

    private final void A2egSU(View view) {
    }

    private final void A4TApA(View view) {
    }

    private final void A5SV6n(View view) {
    }

    private final void ADYaiT(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        HFjH17.ADYaiT aDYaiT;
        AccessibilityManager accessibilityManager;
        int i = 3;
        int i2 = 2;
        boolean z = false;
        Object obj = this.f444AlLFFp;
        switch (this.f443AcNBzu) {
            case 0:
            case 1:
                break;
            case 2:
                int i3 = GJee0v.AZOQYO.f3039AcNBzu;
                FZu94u.A4TApA a4TApA = NMRewardVideoActivity.f9613F1loUV;
                NMRewardVideoActivity nMRewardVideoActivity = (NMRewardVideoActivity) obj;
                nMRewardVideoActivity.getClass();
                FrameLayout frameLayout = (FrameLayout) nMRewardVideoActivity.findViewById(2131296683);
                nMRewardVideoActivity.f9619B2KMhB = frameLayout;
                if (frameLayout != null && (aDYaiT = nMRewardVideoActivity.f9620B3GDIM) != null) {
                    nMRewardVideoActivity.f9630BTvldC.addView(aDYaiT.f3300AmA8tU.A4TApA(new K1Z3yj.A2egSU(aDYaiT, new ADYaiT.BmvVmW(15), 25, z)));
                    HFjH17.ADYaiT aDYaiT2 = NMRewardVideoActivity.f9613F1loUV.f2778FdMWEC;
                    if (aDYaiT2 != null) {
                        try {
                            nMRewardVideoActivity.f9619B2KMhB.addView(aDYaiT2.f3302B25kr6);
                        } catch (Exception unused) {
                        }
                    }
                    TextView textView = nMRewardVideoActivity.f9635C4FrIb;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                    LinearLayout linearLayout = nMRewardVideoActivity.f9623B9tovu;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                    }
                }
                nMRewardVideoActivity.f9671DyaChj.setBackground(null);
                nMRewardVideoActivity.f9673EGM26s.setBackground(null);
                nMRewardVideoActivity.f9672ECyGFg.setBackground(null);
                if (nMRewardVideoActivity.f9671DyaChj != null) {
                    if (nMRewardVideoActivity.f9651D07BeM.getIconurl() != null && !nMRewardVideoActivity.f9651D07BeM.getIconurl().isEmpty()) {
                        GnQT2j.AcNBzu.A2egSU().A4TApA(nMRewardVideoActivity.f9651D07BeM.getIconurl(), new KCxDWD.A5SV6n(16, nMRewardVideoActivity));
                    } else if (nMRewardVideoActivity.f9660DUi7mC != 1) {
                        nMRewardVideoActivity.f9671DyaChj.setImageResource(2131231419);
                        nMRewardVideoActivity.f9672ECyGFg.setImageResource(2131231419);
                        nMRewardVideoActivity.f9673EGM26s.setImageResource(2131231419);
                    } else {
                        nMRewardVideoActivity.f9671DyaChj.setImageResource(2131231398);
                        nMRewardVideoActivity.f9672ECyGFg.setImageResource(2131231398);
                        nMRewardVideoActivity.f9673EGM26s.setImageResource(2131231398);
                    }
                }
                if (nMRewardVideoActivity.f9651D07BeM.getTitle() != null && !nMRewardVideoActivity.f9651D07BeM.getTitle().isEmpty()) {
                    nMRewardVideoActivity.f9637CNPG0E.setText(com.bumptech.glide.AMqCpz.AMqCpz(nMRewardVideoActivity.f9651D07BeM.getTitle()));
                    nMRewardVideoActivity.f9639CQhlFr.setText(com.bumptech.glide.AMqCpz.AMqCpz(nMRewardVideoActivity.f9651D07BeM.getTitle()));
                    nMRewardVideoActivity.f9638COJEAR.setText(com.bumptech.glide.AMqCpz.AMqCpz(nMRewardVideoActivity.f9651D07BeM.getTitle()));
                } else if (nMRewardVideoActivity.f9660DUi7mC != 1) {
                    nMRewardVideoActivity.f9637CNPG0E.setText("查看网页");
                    nMRewardVideoActivity.f9639CQhlFr.setText("查看网页");
                    nMRewardVideoActivity.f9638COJEAR.setText("查看网页");
                } else {
                    nMRewardVideoActivity.f9637CNPG0E.setText("Android应用");
                    nMRewardVideoActivity.f9639CQhlFr.setText("Android应用");
                    nMRewardVideoActivity.f9638COJEAR.setText("Android应用");
                }
                FZu94u.A4TApA a4TApA2 = NMRewardVideoActivity.f9613F1loUV;
                if (a4TApA2 != null) {
                    if (nMRewardVideoActivity.f9619B2KMhB != null) {
                        if (nMRewardVideoActivity.f9620B3GDIM != null) {
                            int i4 = GJee0v.AZOQYO.f3039AcNBzu;
                            a4TApA2.De4eam(0, null, null);
                            SharedPreferences sharedPreferences = GJee0v.AmA8tU.A2egSU().f3053A2egSU;
                            if (sharedPreferences != null) {
                                SharedPreferences.Editor edit = sharedPreferences.edit();
                                edit.clear();
                                edit.commit();
                            }
                            a4TApA2.f3225CrfGsy = Constants.FAIL;
                            a4TApA2.f3226CtFAbx = Constants.FAIL;
                            long currentTimeMillis = System.currentTimeMillis();
                            a4TApA2.f3209BmvVmW = CtFAbx.AaHO0E("", currentTimeMillis);
                            a4TApA2.f3210BniPrB = String.valueOf((int) (currentTimeMillis / 1000));
                            a4TApA2.AYUAbz();
                            a4TApA2.DAk1zC(a4TApA2.f3187AYUAbz);
                            Context A4TApA2 = GJee0v.A2egSU.A4TApA(a4TApA2.f3185ARc23Z);
                            HFjH17.ADYaiT aDYaiT3 = a4TApA2.f2778FdMWEC;
                            if (aDYaiT3 != null) {
                                aDYaiT3.AmA8tU();
                            }
                            Fyurov.B4ZgIw b4ZgIw = a4TApA2.G16Pvp;
                            if (b4ZgIw != null) {
                                b4ZgIw.A5SV6n();
                            }
                            if (a4TApA2.f3207BTvldC != null) {
                                H0qugq.AcNBzu.ASJ6gh(A4TApA2, a4TApA2.f2776FSFw2u, a4TApA2.f2782FpcJKS);
                            }
                            nMRewardVideoActivity.f9620B3GDIM.AZkASS();
                            break;
                        }
                    } else {
                        a4TApA2.DyaChj(nMRewardVideoActivity.f9617AzWtSf);
                        HFjH17.ADYaiT aDYaiT4 = nMRewardVideoActivity.f9620B3GDIM;
                        if (aDYaiT4 != null) {
                            aDYaiT4.AlLFFp();
                        }
                        FZu94u.A4TApA a4TApA3 = NMRewardVideoActivity.f9613F1loUV;
                        if (a4TApA3 != null) {
                            a4TApA3.DuwtYk(nMRewardVideoActivity.f9617AzWtSf);
                            break;
                        }
                    }
                }
                break;
            case 3:
                int i5 = GJee0v.AZOQYO.f3039AcNBzu;
                FdMWEC.AZkASS aZkASS = (FdMWEC.AZkASS) obj;
                Context A4TApA3 = GJee0v.A2egSU.A4TApA(aZkASS.f3185ARc23Z);
                if (A4TApA3 != null) {
                    if (A4TApA3 instanceof Activity) {
                        Activity activity = (Activity) A4TApA3;
                        aZkASS.f2829GEYgCP = activity.getRequestedOrientation();
                        if (DeviceUtil.AzWtSf(activity)) {
                            activity.setRequestedOrientation(0);
                        } else {
                            activity.setRequestedOrientation(1);
                        }
                    } else {
                        Activity A5SV6n2 = GJee0v.A2egSU.A5SV6n();
                        if (A5SV6n2 != null) {
                            aZkASS.f2829GEYgCP = A5SV6n2.getRequestedOrientation();
                            if (DeviceUtil.AzWtSf(A5SV6n2)) {
                                A5SV6n2.setRequestedOrientation(0);
                            } else {
                                A5SV6n2.setRequestedOrientation(1);
                            }
                        }
                    }
                }
                if (!aZkASS.f2837GcSJYy) {
                    aZkASS.f2837GcSJYy = true;
                    aZkASS.Dphsd2(2, null);
                    HFjH17.ADYaiT aDYaiT5 = aZkASS.f2841H0qugq;
                    if (aDYaiT5 != null) {
                        aDYaiT5.AZkASS();
                    }
                    aZkASS.AYUAbz();
                    aZkASS.DAk1zC(aZkASS.f3187AYUAbz);
                    aZkASS.f2865IQ76hF = 5;
                    HFjH17.ADYaiT aDYaiT6 = aZkASS.f2841H0qugq;
                    if (aDYaiT6 != null) {
                        aDYaiT6.AmA8tU();
                    }
                    if (aZkASS.f3202BI9f7h >= 5.0f) {
                        aZkASS.f3202BI9f7h = 4.0f;
                    }
                    TextView textView2 = aZkASS.f2819FOAO9d;
                    if (textView2 != null) {
                        textView2.setText("跳过 5");
                    }
                    Fyurov.B4ZgIw b4ZgIw2 = aZkASS.f2857HtmBAy;
                    if (b4ZgIw2 != null) {
                        b4ZgIw2.A5SV6n();
                    }
                    WeakReference weakReference = aZkASS.f3185ARc23Z;
                    if (weakReference == null || weakReference.get() == null) {
                        aZkASS.f2853HZUvgL = GJee0v.A2egSU.A5SV6n();
                    } else {
                        aZkASS.f2853HZUvgL = (Activity) aZkASS.f3185ARc23Z.get();
                    }
                    if (aZkASS.f2853HZUvgL != null) {
                        if (aZkASS.f2835GTPRn3) {
                            GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new FdMWEC.ASJ6gh(aZkASS, i2));
                        } else if (aZkASS.f2834GL2Jh7) {
                            GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new FdMWEC.ASJ6gh(aZkASS, i));
                        }
                    }
                    if (aZkASS.f3207BTvldC != null) {
                        H0qugq.AcNBzu.ASJ6gh(A4TApA3, aZkASS.G2rdQT, aZkASS.H6qKiO);
                        break;
                    }
                }
                break;
            case 4:
                FOAO9d.AcNBzu acNBzu = (FOAO9d.AcNBzu) obj;
                acNBzu.EY4UKY(6);
                acNBzu.EY4UKY(3);
                if (view == null) {
                    int i6 = GJee0v.AZOQYO.f3039AcNBzu;
                } else {
                    int i7 = GJee0v.AZOQYO.f3039AcNBzu;
                    EQurEW.A4TApA a4TApA4 = new EQurEW.A4TApA();
                    a4TApA4.f2491A2egSU = view;
                    a4TApA4.f2493A5SV6n = new FOAO9d.AYUAbz(acNBzu);
                    a4TApA4.f2492A4TApA = new EQurEW.A2egSU(a4TApA4);
                    view.getViewTreeObserver().addOnScrollChangedListener(a4TApA4.f2492A4TApA);
                    acNBzu.f2641HMGPfW = a4TApA4;
                }
                if (acNBzu.f2599EdhSi6 == 2 && acNBzu.f2636H3v3Sq != null) {
                    if (!acNBzu.f2613FSFw2u) {
                        acNBzu.f2613FSFw2u = true;
                        if (!acNBzu.f2657IOxIEW) {
                            acNBzu.f2657IOxIEW = true;
                            acNBzu.BPw6Q8(acNBzu.f3187AYUAbz);
                        }
                    }
                    acNBzu.f2612FOAO9d = false;
                }
                if (!acNBzu.f2620Fyurov) {
                    acNBzu.f2620Fyurov = true;
                    acNBzu.f2650HtmBAy.sendEmptyMessageDelayed(0, 50L);
                    try {
                        if (acNBzu.f2646HZUvgL.get(0) != null && ((HashMap) acNBzu.f2646HZUvgL.get(0)).get(1) != null && ((String) ((HashMap) acNBzu.f2646HZUvgL.get(0)).get(1)).contains("true")) {
                            acNBzu.f2660Ifhupb.sendEmptyMessageDelayed(0, 50L);
                        }
                        if (acNBzu.f2601EicXu4 == 4) {
                            if (acNBzu.f2646HZUvgL.get(1) != null && ((HashMap) acNBzu.f2646HZUvgL.get(0)).get(1) != null && ((String) ((HashMap) acNBzu.f2646HZUvgL.get(0)).get(1)).contains("true")) {
                                acNBzu.f2661IhMMDv.sendEmptyMessageDelayed(0, 50L);
                            }
                            if (acNBzu.f2646HZUvgL.get(2) != null && ((HashMap) acNBzu.f2646HZUvgL.get(0)).get(1) != null && ((String) ((HashMap) acNBzu.f2646HZUvgL.get(0)).get(1)).contains("true")) {
                                acNBzu.f2662IlwJBd.sendEmptyMessageDelayed(0, 50L);
                                break;
                            }
                        }
                    } catch (NullPointerException e) {
                        EY4UKY.ADYaiT aDYaiT7 = new EY4UKY.ADYaiT();
                        StringBuilder AMqCpz = JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 011: ");
                        AMqCpz.append(e.getMessage());
                        aDYaiT7.AmA8tU("004", AMqCpz.toString(), e);
                        return;
                    }
                }
                break;
            case 5:
            case 6:
                break;
            default:
                PWr3nF.AmA8tU amA8tU = (PWr3nF.AmA8tU) obj;
                if (amA8tU.BpkvW3 != null && (accessibilityManager = amA8tU.f7347BniPrB) != null && amA8tU.isAttachedToWindow()) {
                    accessibilityManager.addTouchExplorationStateChangeListener(amA8tU.BpkvW3);
                    break;
                }
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        AccessibilityManager accessibilityManager2;
        AccessibilityManager accessibilityManager3;
        Object obj = this.f444AlLFFp;
        switch (this.f443AcNBzu) {
            case 0:
                AYUAbz aYUAbz = (AYUAbz) obj;
                ViewTreeObserver viewTreeObserver = aYUAbz.f476CASmeH;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        aYUAbz.f476CASmeH = view.getViewTreeObserver();
                    }
                    aYUAbz.f476CASmeH.removeGlobalOnLayoutListener(aYUAbz.f462B7CMnp);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 1:
                BniPrB bniPrB = (BniPrB) obj;
                ViewTreeObserver viewTreeObserver2 = bniPrB.f585BNL6CD;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        bniPrB.f585BNL6CD = view.getViewTreeObserver();
                    }
                    bniPrB.f585BNL6CD.removeGlobalOnLayoutListener(bniPrB.f579B7CMnp);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 2:
                int i = GJee0v.AZOQYO.f3039AcNBzu;
                break;
            case 3:
                int i2 = GJee0v.AZOQYO.f3039AcNBzu;
                FdMWEC.AZkASS aZkASS = (FdMWEC.AZkASS) obj;
                aZkASS.f2865IQ76hF = 6;
                aZkASS.f3195B25kr6 = true;
                Fyurov.ASJ6gh aSJ6gh = aZkASS.f2821FZu94u;
                if (aSJ6gh != null) {
                    aSJ6gh.A2egSU();
                    break;
                }
                break;
            case 4:
                FOAO9d.AcNBzu acNBzu = (FOAO9d.AcNBzu) obj;
                acNBzu.EY4UKY(5);
                acNBzu.f2612FOAO9d = true;
                acNBzu.EY4UKY(4);
                break;
            case 5:
                HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = (HideBottomViewOnScrollBehavior) obj;
                NrhEUx.A2egSU a2egSU = hideBottomViewOnScrollBehavior.f11325B4ZgIw;
                if (a2egSU != null && (accessibilityManager = hideBottomViewOnScrollBehavior.f11324B3GDIM) != null) {
                    accessibilityManager.removeTouchExplorationStateChangeListener(a2egSU);
                    hideBottomViewOnScrollBehavior.f11325B4ZgIw = null;
                    break;
                }
                break;
            case 6:
                HideViewOnScrollBehavior hideViewOnScrollBehavior = (HideViewOnScrollBehavior) obj;
                NrhEUx.A2egSU a2egSU2 = hideViewOnScrollBehavior.f11332AmA8tU;
                if (a2egSU2 != null && (accessibilityManager2 = hideViewOnScrollBehavior.f11331AlLFFp) != null) {
                    accessibilityManager2.removeTouchExplorationStateChangeListener(a2egSU2);
                    hideViewOnScrollBehavior.f11332AmA8tU = null;
                    break;
                }
                break;
            default:
                PWr3nF.AmA8tU amA8tU = (PWr3nF.AmA8tU) obj;
                AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = amA8tU.BpkvW3;
                if (touchExplorationStateChangeListener != null && (accessibilityManager3 = amA8tU.f7347BniPrB) != null) {
                    accessibilityManager3.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
                    break;
                }
                break;
        }
    }
}
