package Dphsd2;

import ADYaiT.BmvVmW;
import ADYaiT.CtFAbx;
import C4FrIb.B4ZgIw;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alliance.ssp.ad.activity.NMRewardVideoActivity;
import com.alliance.ssp.ad.bean.Material;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class AaHO0E implements Fyurov.B3GDIM, Fyurov.A5SV6n, Fyurov.ARc23Z {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ NMRewardVideoActivity f2455AcNBzu;

    public /* synthetic */ AaHO0E(NMRewardVideoActivity nMRewardVideoActivity) {
        this.f2455AcNBzu = nMRewardVideoActivity;
    }

    @Override // Fyurov.B3GDIM
    public void A2egSU(double d, double d2) {
        Fyurov.ASJ6gh aSJ6gh;
        final NMRewardVideoActivity nMRewardVideoActivity = this.f2455AcNBzu;
        int max = (int) Math.max(0.0d, (nMRewardVideoActivity.f9659DRlcZ9 - d) + 1.0d);
        try {
            GJee0v.AZkASS aZkASS = GJee0v.AZkASS.f3040ADYaiT;
            aZkASS.f3043A5SV6n.post(new BTvldC.B25kr6(max, 1, nMRewardVideoActivity));
            if (!nMRewardVideoActivity.f9683ErKPGd && d > 0.0d && (aSJ6gh = nMRewardVideoActivity.f9653D6yqiO) != null) {
                nMRewardVideoActivity.f9683ErKPGd = true;
                aSJ6gh.ADYaiT();
            }
            Handler handler = aZkASS.f3043A5SV6n;
            handler.post(new FSFw2u.A4TApA(nMRewardVideoActivity, d, 3));
            if (d >= nMRewardVideoActivity.f9659DRlcZ9 || d2 <= 0.0d) {
                nMRewardVideoActivity.f9684EsrwYR = true;
                if (!nMRewardVideoActivity.f9664DcUJf1) {
                    nMRewardVideoActivity.f9664DcUJf1 = true;
                    if (NMRewardVideoActivity.f9613F1loUV != null) {
                        final int i = 0;
                        handler.post(new Runnable() { // from class: Dphsd2.AYUAbz
                            @Override // java.lang.Runnable
                            public final void run() {
                                EY4UKY.ADYaiT aDYaiT;
                                StringBuilder AMqCpz;
                                List<String> imgurl;
                                HFjH17.ARc23Z aRc23Z;
                                Material material;
                                List<String> imgurl2;
                                MediaPlayer mediaPlayer;
                                NMRewardVideoActivity nMRewardVideoActivity2 = nMRewardVideoActivity;
                                switch (i) {
                                    case 0:
                                        TextView textView = nMRewardVideoActivity2.f9635C4FrIb;
                                        if (textView != null && NMRewardVideoActivity.f9613F1loUV.f2789GJee0v) {
                                            textView.setText(nMRewardVideoActivity2.getResources().getString(2131886635));
                                            break;
                                        }
                                        break;
                                    case 1:
                                        int i2 = nMRewardVideoActivity2.f9662DXnQ0V;
                                        String str = "";
                                        if (i2 == 1) {
                                            HFjH17.ADYaiT aDYaiT2 = nMRewardVideoActivity2.f9620B3GDIM;
                                            if (aDYaiT2 != null) {
                                                if (aDYaiT2.AaHO0E() && (mediaPlayer = aDYaiT2.f3305B4ZgIw) != null) {
                                                    int i3 = GJee0v.AZOQYO.f3039AcNBzu;
                                                    try {
                                                        mediaPlayer.stop();
                                                        aDYaiT2.f3317BniPrB = 9;
                                                        aDYaiT2.ADYaiT(65541);
                                                    } catch (Exception unused) {
                                                    }
                                                }
                                                aDYaiT2.AlLFFp();
                                            }
                                            nMRewardVideoActivity2.f9630BTvldC.setVisibility(8);
                                            try {
                                                FrameLayout frameLayout = nMRewardVideoActivity2.f9658DG07BK.f2907B9tovu;
                                                if (frameLayout != null) {
                                                    if (frameLayout.getParent() != null) {
                                                        break;
                                                    } else {
                                                        nMRewardVideoActivity2.f9649CtFAbx.addView(frameLayout);
                                                    }
                                                }
                                                FrameLayout frameLayout2 = nMRewardVideoActivity2.BpkvW3;
                                                if (frameLayout2 != null) {
                                                    frameLayout2.setVisibility(8);
                                                }
                                                LinearLayout linearLayout = nMRewardVideoActivity2.f9625BI9f7h;
                                                if (linearLayout != null) {
                                                    linearLayout.setVisibility(8);
                                                }
                                                LinearLayout linearLayout2 = nMRewardVideoActivity2.f9624BChYOn;
                                                if (linearLayout2 != null) {
                                                    linearLayout2.setVisibility(8);
                                                }
                                                FrameLayout frameLayout3 = nMRewardVideoActivity2.f9622B7CMnp;
                                                if (frameLayout3 != null) {
                                                    frameLayout3.setVisibility(0);
                                                }
                                                TextView textView2 = nMRewardVideoActivity2.f9638COJEAR;
                                                if (textView2 != null) {
                                                    textView2.setVisibility(0);
                                                }
                                                FrameLayout frameLayout4 = nMRewardVideoActivity2.f9634C2rE4F;
                                                if (frameLayout4 != null) {
                                                    frameLayout4.setVisibility(0);
                                                }
                                                if (nMRewardVideoActivity2.f9644CikNvS != null && (material = nMRewardVideoActivity2.f9651D07BeM) != null) {
                                                    String adm = material.getAdm();
                                                    if (adm != null && !adm.isEmpty()) {
                                                        str = adm;
                                                    }
                                                    if (str.isEmpty() && (imgurl2 = nMRewardVideoActivity2.f9651D07BeM.getImgurl()) != null && !imgurl2.isEmpty() && imgurl2.get(0) != null) {
                                                        str = imgurl2.get(0);
                                                    }
                                                    if (str.isEmpty()) {
                                                        GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new B4ZgIw(2, nMRewardVideoActivity2, nMRewardVideoActivity2.f9651D07BeM.getVideourl(), nMRewardVideoActivity2.f9644CikNvS));
                                                    } else {
                                                        GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new AZOQYO(nMRewardVideoActivity2, str, nMRewardVideoActivity2.f9644CikNvS));
                                                    }
                                                    nMRewardVideoActivity2.f9644CikNvS.setVisibility(0);
                                                }
                                                FrameLayout frameLayout5 = nMRewardVideoActivity2.f9632BmvVmW;
                                                if (frameLayout5 != null && nMRewardVideoActivity2.Ddcejp) {
                                                    ViewGroup viewGroup = (ViewGroup) frameLayout5.getParent();
                                                    if (viewGroup != null) {
                                                        viewGroup.removeView(nMRewardVideoActivity2.f9632BmvVmW);
                                                    }
                                                    LinearLayout linearLayout3 = nMRewardVideoActivity2.f9628BNL6CD;
                                                    if (linearLayout3 != null) {
                                                        linearLayout3.addView(nMRewardVideoActivity2.f9632BmvVmW);
                                                    }
                                                    nMRewardVideoActivity2.f9632BmvVmW.setVisibility(0);
                                                    break;
                                                } else if (!nMRewardVideoActivity2.Ddcejp) {
                                                    nMRewardVideoActivity2.f9628BNL6CD.setVisibility(8);
                                                    break;
                                                }
                                            } catch (Exception e) {
                                                e = e;
                                                aDYaiT = new EY4UKY.ADYaiT();
                                                AMqCpz = JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl createVerticalFinishView: ");
                                            }
                                        } else if (i2 == 2) {
                                            HFjH17.ADYaiT aDYaiT3 = nMRewardVideoActivity2.f9620B3GDIM;
                                            boolean z = aDYaiT3 != null ? aDYaiT3.f3291ADYaiT : true;
                                            nMRewardVideoActivity2.f9630BTvldC.removeAllViews();
                                            FrameLayout frameLayout6 = nMRewardVideoActivity2.f9631BV3sI0;
                                            HFjH17.ADYaiT aDYaiT4 = nMRewardVideoActivity2.f9620B3GDIM;
                                            frameLayout6.addView(aDYaiT4.f3300AmA8tU.A4TApA(new K1Z3yj.A2egSU(aDYaiT4, new BmvVmW(16), 25, false)));
                                            HFjH17.ADYaiT aDYaiT5 = nMRewardVideoActivity2.f9620B3GDIM;
                                            if (aDYaiT5.f3305B4ZgIw != null && (aRc23Z = aDYaiT5.f3300AmA8tU) != null) {
                                                if (z) {
                                                    aRc23Z.A5SV6n(2);
                                                } else {
                                                    aRc23Z.A5SV6n(1);
                                                }
                                            }
                                            HFjH17.ADYaiT aDYaiT6 = nMRewardVideoActivity2.f9620B3GDIM;
                                            aDYaiT6.f3312BNL6CD = true;
                                            if (!nMRewardVideoActivity2.f9666De4eam) {
                                                float f = nMRewardVideoActivity2.f9663DaOi9o * 0.5f;
                                                aDYaiT6.AMqCpz((int) f, (int) ((f * 9.0f) / 16.0f));
                                            }
                                            nMRewardVideoActivity2.f9630BTvldC.setVisibility(8);
                                            nMRewardVideoActivity2.f9631BV3sI0.setVisibility(0);
                                            try {
                                                FrameLayout frameLayout7 = nMRewardVideoActivity2.f9658DG07BK.f2907B9tovu;
                                                if (frameLayout7 != null) {
                                                    if (frameLayout7.getParent() != null) {
                                                        break;
                                                    } else {
                                                        nMRewardVideoActivity2.f9648CrfGsy.addView(frameLayout7);
                                                    }
                                                }
                                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) nMRewardVideoActivity2.BpkvW3.getLayoutParams();
                                                layoutParams.width = (int) (nMRewardVideoActivity2.f9663DaOi9o * 0.5f);
                                                nMRewardVideoActivity2.BpkvW3.setLayoutParams(layoutParams);
                                                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nMRewardVideoActivity2.f9629BPw6Q8.getLayoutParams();
                                                layoutParams2.width = (int) (nMRewardVideoActivity2.f9663DaOi9o * 0.5f);
                                                nMRewardVideoActivity2.f9629BPw6Q8.setLayoutParams(layoutParams2);
                                                if (nMRewardVideoActivity2.f9623B9tovu != null) {
                                                    int AzWtSf2 = NOd7IU.AlLFFp.AzWtSf(nMRewardVideoActivity2, 20.0f);
                                                    int AzWtSf3 = NOd7IU.AlLFFp.AzWtSf(nMRewardVideoActivity2, 20.0f);
                                                    ((FrameLayout.LayoutParams) nMRewardVideoActivity2.f9623B9tovu.getLayoutParams()).setMargins(0, AzWtSf2, AzWtSf3, 0);
                                                    ((FrameLayout.LayoutParams) nMRewardVideoActivity2.f9635C4FrIb.getLayoutParams()).setMargins(AzWtSf3, AzWtSf2, 0, 0);
                                                }
                                                ImageView imageView = nMRewardVideoActivity2.f9643Cd8JRx;
                                                if (imageView != null) {
                                                    imageView.setVisibility(8);
                                                }
                                                LinearLayout linearLayout4 = nMRewardVideoActivity2.f9625BI9f7h;
                                                if (linearLayout4 != null) {
                                                    linearLayout4.setVisibility(8);
                                                }
                                                LinearLayout linearLayout5 = nMRewardVideoActivity2.f9624BChYOn;
                                                if (linearLayout5 != null) {
                                                    linearLayout5.setVisibility(8);
                                                }
                                                LinearLayout linearLayout6 = nMRewardVideoActivity2.f9626BIYEnU;
                                                if (linearLayout6 != null) {
                                                    linearLayout6.setVisibility(0);
                                                }
                                                FrameLayout frameLayout8 = nMRewardVideoActivity2.f9634C2rE4F;
                                                if (frameLayout8 != null) {
                                                    frameLayout8.setVisibility(0);
                                                }
                                                if (nMRewardVideoActivity2.f9644CikNvS != null) {
                                                    String adm2 = nMRewardVideoActivity2.f9651D07BeM.getAdm();
                                                    if (adm2 != null && !adm2.isEmpty()) {
                                                        str = adm2;
                                                    }
                                                    if (str.isEmpty() && (imgurl = nMRewardVideoActivity2.f9651D07BeM.getImgurl()) != null && !imgurl.isEmpty() && imgurl.get(0) != null) {
                                                        str = imgurl.get(0);
                                                    }
                                                    if (str.isEmpty()) {
                                                        GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new B4ZgIw(2, nMRewardVideoActivity2, nMRewardVideoActivity2.f9651D07BeM.getVideourl(), nMRewardVideoActivity2.f9644CikNvS));
                                                    } else {
                                                        GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new AZOQYO(nMRewardVideoActivity2, str, nMRewardVideoActivity2.f9644CikNvS));
                                                    }
                                                    nMRewardVideoActivity2.f9644CikNvS.setVisibility(0);
                                                }
                                                if (nMRewardVideoActivity2.f9620B3GDIM != null && nMRewardVideoActivity2.f9666De4eam && nMRewardVideoActivity2.f9651D07BeM != null) {
                                                    GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new DjONCG.A5SV6n(nMRewardVideoActivity2, 0));
                                                }
                                                TextView textView3 = nMRewardVideoActivity2.f9639CQhlFr;
                                                if (textView3 != null) {
                                                    textView3.setVisibility(0);
                                                }
                                                if (nMRewardVideoActivity2.f9621B4ZgIw != null) {
                                                    LinearLayout linearLayout7 = nMRewardVideoActivity2.f9627BJ7GGh;
                                                    if (linearLayout7 != null && nMRewardVideoActivity2.Ddcejp) {
                                                        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) linearLayout7.getLayoutParams();
                                                        layoutParams3.width = (int) (nMRewardVideoActivity2.f9663DaOi9o * 0.5f);
                                                        nMRewardVideoActivity2.f9627BJ7GGh.setLayoutParams(layoutParams3);
                                                        nMRewardVideoActivity2.f9632BmvVmW.setVisibility(0);
                                                        break;
                                                    } else if (!nMRewardVideoActivity2.Ddcejp) {
                                                        nMRewardVideoActivity2.f9628BNL6CD.setVisibility(8);
                                                        break;
                                                    }
                                                }
                                            } catch (Exception e2) {
                                                e = e2;
                                                aDYaiT = new EY4UKY.ADYaiT();
                                                AMqCpz = JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl createHorizontalFinishView: ");
                                            }
                                        }
                                        CtFAbx.B4ZgIw(e, AMqCpz, aDYaiT, "004", e);
                                        break;
                                    case 2:
                                        FZu94u.A4TApA a4TApA = NMRewardVideoActivity.f9613F1loUV;
                                        FZu94u.A4TApA a4TApA2 = NMRewardVideoActivity.f9613F1loUV;
                                        if (a4TApA2.f2775FOAO9d == 1) {
                                            a4TApA2.B2KMhB(nMRewardVideoActivity2.f9647CqNSpT, "1");
                                        } else {
                                            a4TApA2.B2KMhB(nMRewardVideoActivity2.f9621B4ZgIw, null);
                                        }
                                        if (nMRewardVideoActivity2.ASJ6gh("unuser", 0, false)) {
                                            FZu94u.A4TApA a4TApA3 = NMRewardVideoActivity.f9613F1loUV;
                                            a4TApA3.f3203BIYEnU = true;
                                            a4TApA3.BV3sI0();
                                            HFjH17.ADYaiT aDYaiT7 = nMRewardVideoActivity2.f9620B3GDIM;
                                            if (aDYaiT7 != null && nMRewardVideoActivity2.f9660DUi7mC != 1) {
                                                boolean AcNBzu2 = aDYaiT7.AcNBzu();
                                                FZu94u.A4TApA a4TApA4 = NMRewardVideoActivity.f9613F1loUV;
                                                if (a4TApA4 != null && AcNBzu2) {
                                                    a4TApA4.CTkVKb(a4TApA4.f3187AYUAbz);
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    default:
                                        FZu94u.A4TApA a4TApA5 = NMRewardVideoActivity.f9613F1loUV;
                                        try {
                                            if (nMRewardVideoActivity2.f9635C4FrIb.getVisibility() == 0) {
                                                int i4 = GJee0v.AZOQYO.f3039AcNBzu;
                                                TextView textView4 = nMRewardVideoActivity2.f9636CASmeH;
                                                if (textView4 != null) {
                                                    textView4.setOnClickListener(nMRewardVideoActivity2.EdQ5bb);
                                                }
                                                TextView textView5 = nMRewardVideoActivity2.f9635C4FrIb;
                                                if (textView5 != null) {
                                                    textView5.setVisibility(8);
                                                }
                                                LinearLayout linearLayout8 = nMRewardVideoActivity2.f9623B9tovu;
                                                if (linearLayout8 != null) {
                                                    linearLayout8.setVisibility(0);
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        } catch (Exception e3) {
                                            e3.getMessage();
                                            int i5 = GJee0v.AZOQYO.f3039AcNBzu;
                                        }
                                        break;
                                }
                            }
                        });
                        NMRewardVideoActivity.f9613F1loUV.DcUJf1();
                    }
                }
            }
            if (d >= nMRewardVideoActivity.f9682EmJGcg || d2 <= 0.0d) {
                nMRewardVideoActivity.f9665DdagTj = true;
                final int i2 = 1;
                handler.post(new Runnable() { // from class: Dphsd2.AYUAbz
                    @Override // java.lang.Runnable
                    public final void run() {
                        EY4UKY.ADYaiT aDYaiT;
                        StringBuilder AMqCpz;
                        List<String> imgurl;
                        HFjH17.ARc23Z aRc23Z;
                        Material material;
                        List<String> imgurl2;
                        MediaPlayer mediaPlayer;
                        NMRewardVideoActivity nMRewardVideoActivity2 = nMRewardVideoActivity;
                        switch (i2) {
                            case 0:
                                TextView textView = nMRewardVideoActivity2.f9635C4FrIb;
                                if (textView != null && NMRewardVideoActivity.f9613F1loUV.f2789GJee0v) {
                                    textView.setText(nMRewardVideoActivity2.getResources().getString(2131886635));
                                    break;
                                }
                                break;
                            case 1:
                                int i22 = nMRewardVideoActivity2.f9662DXnQ0V;
                                String str = "";
                                if (i22 == 1) {
                                    HFjH17.ADYaiT aDYaiT2 = nMRewardVideoActivity2.f9620B3GDIM;
                                    if (aDYaiT2 != null) {
                                        if (aDYaiT2.AaHO0E() && (mediaPlayer = aDYaiT2.f3305B4ZgIw) != null) {
                                            int i3 = GJee0v.AZOQYO.f3039AcNBzu;
                                            try {
                                                mediaPlayer.stop();
                                                aDYaiT2.f3317BniPrB = 9;
                                                aDYaiT2.ADYaiT(65541);
                                            } catch (Exception unused) {
                                            }
                                        }
                                        aDYaiT2.AlLFFp();
                                    }
                                    nMRewardVideoActivity2.f9630BTvldC.setVisibility(8);
                                    try {
                                        FrameLayout frameLayout = nMRewardVideoActivity2.f9658DG07BK.f2907B9tovu;
                                        if (frameLayout != null) {
                                            if (frameLayout.getParent() != null) {
                                                break;
                                            } else {
                                                nMRewardVideoActivity2.f9649CtFAbx.addView(frameLayout);
                                            }
                                        }
                                        FrameLayout frameLayout2 = nMRewardVideoActivity2.BpkvW3;
                                        if (frameLayout2 != null) {
                                            frameLayout2.setVisibility(8);
                                        }
                                        LinearLayout linearLayout = nMRewardVideoActivity2.f9625BI9f7h;
                                        if (linearLayout != null) {
                                            linearLayout.setVisibility(8);
                                        }
                                        LinearLayout linearLayout2 = nMRewardVideoActivity2.f9624BChYOn;
                                        if (linearLayout2 != null) {
                                            linearLayout2.setVisibility(8);
                                        }
                                        FrameLayout frameLayout3 = nMRewardVideoActivity2.f9622B7CMnp;
                                        if (frameLayout3 != null) {
                                            frameLayout3.setVisibility(0);
                                        }
                                        TextView textView2 = nMRewardVideoActivity2.f9638COJEAR;
                                        if (textView2 != null) {
                                            textView2.setVisibility(0);
                                        }
                                        FrameLayout frameLayout4 = nMRewardVideoActivity2.f9634C2rE4F;
                                        if (frameLayout4 != null) {
                                            frameLayout4.setVisibility(0);
                                        }
                                        if (nMRewardVideoActivity2.f9644CikNvS != null && (material = nMRewardVideoActivity2.f9651D07BeM) != null) {
                                            String adm = material.getAdm();
                                            if (adm != null && !adm.isEmpty()) {
                                                str = adm;
                                            }
                                            if (str.isEmpty() && (imgurl2 = nMRewardVideoActivity2.f9651D07BeM.getImgurl()) != null && !imgurl2.isEmpty() && imgurl2.get(0) != null) {
                                                str = imgurl2.get(0);
                                            }
                                            if (str.isEmpty()) {
                                                GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new B4ZgIw(2, nMRewardVideoActivity2, nMRewardVideoActivity2.f9651D07BeM.getVideourl(), nMRewardVideoActivity2.f9644CikNvS));
                                            } else {
                                                GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new AZOQYO(nMRewardVideoActivity2, str, nMRewardVideoActivity2.f9644CikNvS));
                                            }
                                            nMRewardVideoActivity2.f9644CikNvS.setVisibility(0);
                                        }
                                        FrameLayout frameLayout5 = nMRewardVideoActivity2.f9632BmvVmW;
                                        if (frameLayout5 != null && nMRewardVideoActivity2.Ddcejp) {
                                            ViewGroup viewGroup = (ViewGroup) frameLayout5.getParent();
                                            if (viewGroup != null) {
                                                viewGroup.removeView(nMRewardVideoActivity2.f9632BmvVmW);
                                            }
                                            LinearLayout linearLayout3 = nMRewardVideoActivity2.f9628BNL6CD;
                                            if (linearLayout3 != null) {
                                                linearLayout3.addView(nMRewardVideoActivity2.f9632BmvVmW);
                                            }
                                            nMRewardVideoActivity2.f9632BmvVmW.setVisibility(0);
                                            break;
                                        } else if (!nMRewardVideoActivity2.Ddcejp) {
                                            nMRewardVideoActivity2.f9628BNL6CD.setVisibility(8);
                                            break;
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        aDYaiT = new EY4UKY.ADYaiT();
                                        AMqCpz = JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl createVerticalFinishView: ");
                                    }
                                } else if (i22 == 2) {
                                    HFjH17.ADYaiT aDYaiT3 = nMRewardVideoActivity2.f9620B3GDIM;
                                    boolean z = aDYaiT3 != null ? aDYaiT3.f3291ADYaiT : true;
                                    nMRewardVideoActivity2.f9630BTvldC.removeAllViews();
                                    FrameLayout frameLayout6 = nMRewardVideoActivity2.f9631BV3sI0;
                                    HFjH17.ADYaiT aDYaiT4 = nMRewardVideoActivity2.f9620B3GDIM;
                                    frameLayout6.addView(aDYaiT4.f3300AmA8tU.A4TApA(new K1Z3yj.A2egSU(aDYaiT4, new BmvVmW(16), 25, false)));
                                    HFjH17.ADYaiT aDYaiT5 = nMRewardVideoActivity2.f9620B3GDIM;
                                    if (aDYaiT5.f3305B4ZgIw != null && (aRc23Z = aDYaiT5.f3300AmA8tU) != null) {
                                        if (z) {
                                            aRc23Z.A5SV6n(2);
                                        } else {
                                            aRc23Z.A5SV6n(1);
                                        }
                                    }
                                    HFjH17.ADYaiT aDYaiT6 = nMRewardVideoActivity2.f9620B3GDIM;
                                    aDYaiT6.f3312BNL6CD = true;
                                    if (!nMRewardVideoActivity2.f9666De4eam) {
                                        float f = nMRewardVideoActivity2.f9663DaOi9o * 0.5f;
                                        aDYaiT6.AMqCpz((int) f, (int) ((f * 9.0f) / 16.0f));
                                    }
                                    nMRewardVideoActivity2.f9630BTvldC.setVisibility(8);
                                    nMRewardVideoActivity2.f9631BV3sI0.setVisibility(0);
                                    try {
                                        FrameLayout frameLayout7 = nMRewardVideoActivity2.f9658DG07BK.f2907B9tovu;
                                        if (frameLayout7 != null) {
                                            if (frameLayout7.getParent() != null) {
                                                break;
                                            } else {
                                                nMRewardVideoActivity2.f9648CrfGsy.addView(frameLayout7);
                                            }
                                        }
                                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) nMRewardVideoActivity2.BpkvW3.getLayoutParams();
                                        layoutParams.width = (int) (nMRewardVideoActivity2.f9663DaOi9o * 0.5f);
                                        nMRewardVideoActivity2.BpkvW3.setLayoutParams(layoutParams);
                                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nMRewardVideoActivity2.f9629BPw6Q8.getLayoutParams();
                                        layoutParams2.width = (int) (nMRewardVideoActivity2.f9663DaOi9o * 0.5f);
                                        nMRewardVideoActivity2.f9629BPw6Q8.setLayoutParams(layoutParams2);
                                        if (nMRewardVideoActivity2.f9623B9tovu != null) {
                                            int AzWtSf2 = NOd7IU.AlLFFp.AzWtSf(nMRewardVideoActivity2, 20.0f);
                                            int AzWtSf3 = NOd7IU.AlLFFp.AzWtSf(nMRewardVideoActivity2, 20.0f);
                                            ((FrameLayout.LayoutParams) nMRewardVideoActivity2.f9623B9tovu.getLayoutParams()).setMargins(0, AzWtSf2, AzWtSf3, 0);
                                            ((FrameLayout.LayoutParams) nMRewardVideoActivity2.f9635C4FrIb.getLayoutParams()).setMargins(AzWtSf3, AzWtSf2, 0, 0);
                                        }
                                        ImageView imageView = nMRewardVideoActivity2.f9643Cd8JRx;
                                        if (imageView != null) {
                                            imageView.setVisibility(8);
                                        }
                                        LinearLayout linearLayout4 = nMRewardVideoActivity2.f9625BI9f7h;
                                        if (linearLayout4 != null) {
                                            linearLayout4.setVisibility(8);
                                        }
                                        LinearLayout linearLayout5 = nMRewardVideoActivity2.f9624BChYOn;
                                        if (linearLayout5 != null) {
                                            linearLayout5.setVisibility(8);
                                        }
                                        LinearLayout linearLayout6 = nMRewardVideoActivity2.f9626BIYEnU;
                                        if (linearLayout6 != null) {
                                            linearLayout6.setVisibility(0);
                                        }
                                        FrameLayout frameLayout8 = nMRewardVideoActivity2.f9634C2rE4F;
                                        if (frameLayout8 != null) {
                                            frameLayout8.setVisibility(0);
                                        }
                                        if (nMRewardVideoActivity2.f9644CikNvS != null) {
                                            String adm2 = nMRewardVideoActivity2.f9651D07BeM.getAdm();
                                            if (adm2 != null && !adm2.isEmpty()) {
                                                str = adm2;
                                            }
                                            if (str.isEmpty() && (imgurl = nMRewardVideoActivity2.f9651D07BeM.getImgurl()) != null && !imgurl.isEmpty() && imgurl.get(0) != null) {
                                                str = imgurl.get(0);
                                            }
                                            if (str.isEmpty()) {
                                                GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new B4ZgIw(2, nMRewardVideoActivity2, nMRewardVideoActivity2.f9651D07BeM.getVideourl(), nMRewardVideoActivity2.f9644CikNvS));
                                            } else {
                                                GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new AZOQYO(nMRewardVideoActivity2, str, nMRewardVideoActivity2.f9644CikNvS));
                                            }
                                            nMRewardVideoActivity2.f9644CikNvS.setVisibility(0);
                                        }
                                        if (nMRewardVideoActivity2.f9620B3GDIM != null && nMRewardVideoActivity2.f9666De4eam && nMRewardVideoActivity2.f9651D07BeM != null) {
                                            GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new DjONCG.A5SV6n(nMRewardVideoActivity2, 0));
                                        }
                                        TextView textView3 = nMRewardVideoActivity2.f9639CQhlFr;
                                        if (textView3 != null) {
                                            textView3.setVisibility(0);
                                        }
                                        if (nMRewardVideoActivity2.f9621B4ZgIw != null) {
                                            LinearLayout linearLayout7 = nMRewardVideoActivity2.f9627BJ7GGh;
                                            if (linearLayout7 != null && nMRewardVideoActivity2.Ddcejp) {
                                                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) linearLayout7.getLayoutParams();
                                                layoutParams3.width = (int) (nMRewardVideoActivity2.f9663DaOi9o * 0.5f);
                                                nMRewardVideoActivity2.f9627BJ7GGh.setLayoutParams(layoutParams3);
                                                nMRewardVideoActivity2.f9632BmvVmW.setVisibility(0);
                                                break;
                                            } else if (!nMRewardVideoActivity2.Ddcejp) {
                                                nMRewardVideoActivity2.f9628BNL6CD.setVisibility(8);
                                                break;
                                            }
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        aDYaiT = new EY4UKY.ADYaiT();
                                        AMqCpz = JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl createHorizontalFinishView: ");
                                    }
                                }
                                CtFAbx.B4ZgIw(e, AMqCpz, aDYaiT, "004", e);
                                break;
                            case 2:
                                FZu94u.A4TApA a4TApA = NMRewardVideoActivity.f9613F1loUV;
                                FZu94u.A4TApA a4TApA2 = NMRewardVideoActivity.f9613F1loUV;
                                if (a4TApA2.f2775FOAO9d == 1) {
                                    a4TApA2.B2KMhB(nMRewardVideoActivity2.f9647CqNSpT, "1");
                                } else {
                                    a4TApA2.B2KMhB(nMRewardVideoActivity2.f9621B4ZgIw, null);
                                }
                                if (nMRewardVideoActivity2.ASJ6gh("unuser", 0, false)) {
                                    FZu94u.A4TApA a4TApA3 = NMRewardVideoActivity.f9613F1loUV;
                                    a4TApA3.f3203BIYEnU = true;
                                    a4TApA3.BV3sI0();
                                    HFjH17.ADYaiT aDYaiT7 = nMRewardVideoActivity2.f9620B3GDIM;
                                    if (aDYaiT7 != null && nMRewardVideoActivity2.f9660DUi7mC != 1) {
                                        boolean AcNBzu2 = aDYaiT7.AcNBzu();
                                        FZu94u.A4TApA a4TApA4 = NMRewardVideoActivity.f9613F1loUV;
                                        if (a4TApA4 != null && AcNBzu2) {
                                            a4TApA4.CTkVKb(a4TApA4.f3187AYUAbz);
                                            break;
                                        }
                                    }
                                }
                                break;
                            default:
                                FZu94u.A4TApA a4TApA5 = NMRewardVideoActivity.f9613F1loUV;
                                try {
                                    if (nMRewardVideoActivity2.f9635C4FrIb.getVisibility() == 0) {
                                        int i4 = GJee0v.AZOQYO.f3039AcNBzu;
                                        TextView textView4 = nMRewardVideoActivity2.f9636CASmeH;
                                        if (textView4 != null) {
                                            textView4.setOnClickListener(nMRewardVideoActivity2.EdQ5bb);
                                        }
                                        TextView textView5 = nMRewardVideoActivity2.f9635C4FrIb;
                                        if (textView5 != null) {
                                            textView5.setVisibility(8);
                                        }
                                        LinearLayout linearLayout8 = nMRewardVideoActivity2.f9623B9tovu;
                                        if (linearLayout8 != null) {
                                            linearLayout8.setVisibility(0);
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                } catch (Exception e3) {
                                    e3.getMessage();
                                    int i5 = GJee0v.AZOQYO.f3039AcNBzu;
                                }
                                break;
                        }
                    }
                });
                final int i3 = 3;
                handler.post(new Runnable() { // from class: Dphsd2.AYUAbz
                    @Override // java.lang.Runnable
                    public final void run() {
                        EY4UKY.ADYaiT aDYaiT;
                        StringBuilder AMqCpz;
                        List<String> imgurl;
                        HFjH17.ARc23Z aRc23Z;
                        Material material;
                        List<String> imgurl2;
                        MediaPlayer mediaPlayer;
                        NMRewardVideoActivity nMRewardVideoActivity2 = nMRewardVideoActivity;
                        switch (i3) {
                            case 0:
                                TextView textView = nMRewardVideoActivity2.f9635C4FrIb;
                                if (textView != null && NMRewardVideoActivity.f9613F1loUV.f2789GJee0v) {
                                    textView.setText(nMRewardVideoActivity2.getResources().getString(2131886635));
                                    break;
                                }
                                break;
                            case 1:
                                int i22 = nMRewardVideoActivity2.f9662DXnQ0V;
                                String str = "";
                                if (i22 == 1) {
                                    HFjH17.ADYaiT aDYaiT2 = nMRewardVideoActivity2.f9620B3GDIM;
                                    if (aDYaiT2 != null) {
                                        if (aDYaiT2.AaHO0E() && (mediaPlayer = aDYaiT2.f3305B4ZgIw) != null) {
                                            int i32 = GJee0v.AZOQYO.f3039AcNBzu;
                                            try {
                                                mediaPlayer.stop();
                                                aDYaiT2.f3317BniPrB = 9;
                                                aDYaiT2.ADYaiT(65541);
                                            } catch (Exception unused) {
                                            }
                                        }
                                        aDYaiT2.AlLFFp();
                                    }
                                    nMRewardVideoActivity2.f9630BTvldC.setVisibility(8);
                                    try {
                                        FrameLayout frameLayout = nMRewardVideoActivity2.f9658DG07BK.f2907B9tovu;
                                        if (frameLayout != null) {
                                            if (frameLayout.getParent() != null) {
                                                break;
                                            } else {
                                                nMRewardVideoActivity2.f9649CtFAbx.addView(frameLayout);
                                            }
                                        }
                                        FrameLayout frameLayout2 = nMRewardVideoActivity2.BpkvW3;
                                        if (frameLayout2 != null) {
                                            frameLayout2.setVisibility(8);
                                        }
                                        LinearLayout linearLayout = nMRewardVideoActivity2.f9625BI9f7h;
                                        if (linearLayout != null) {
                                            linearLayout.setVisibility(8);
                                        }
                                        LinearLayout linearLayout2 = nMRewardVideoActivity2.f9624BChYOn;
                                        if (linearLayout2 != null) {
                                            linearLayout2.setVisibility(8);
                                        }
                                        FrameLayout frameLayout3 = nMRewardVideoActivity2.f9622B7CMnp;
                                        if (frameLayout3 != null) {
                                            frameLayout3.setVisibility(0);
                                        }
                                        TextView textView2 = nMRewardVideoActivity2.f9638COJEAR;
                                        if (textView2 != null) {
                                            textView2.setVisibility(0);
                                        }
                                        FrameLayout frameLayout4 = nMRewardVideoActivity2.f9634C2rE4F;
                                        if (frameLayout4 != null) {
                                            frameLayout4.setVisibility(0);
                                        }
                                        if (nMRewardVideoActivity2.f9644CikNvS != null && (material = nMRewardVideoActivity2.f9651D07BeM) != null) {
                                            String adm = material.getAdm();
                                            if (adm != null && !adm.isEmpty()) {
                                                str = adm;
                                            }
                                            if (str.isEmpty() && (imgurl2 = nMRewardVideoActivity2.f9651D07BeM.getImgurl()) != null && !imgurl2.isEmpty() && imgurl2.get(0) != null) {
                                                str = imgurl2.get(0);
                                            }
                                            if (str.isEmpty()) {
                                                GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new B4ZgIw(2, nMRewardVideoActivity2, nMRewardVideoActivity2.f9651D07BeM.getVideourl(), nMRewardVideoActivity2.f9644CikNvS));
                                            } else {
                                                GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new AZOQYO(nMRewardVideoActivity2, str, nMRewardVideoActivity2.f9644CikNvS));
                                            }
                                            nMRewardVideoActivity2.f9644CikNvS.setVisibility(0);
                                        }
                                        FrameLayout frameLayout5 = nMRewardVideoActivity2.f9632BmvVmW;
                                        if (frameLayout5 != null && nMRewardVideoActivity2.Ddcejp) {
                                            ViewGroup viewGroup = (ViewGroup) frameLayout5.getParent();
                                            if (viewGroup != null) {
                                                viewGroup.removeView(nMRewardVideoActivity2.f9632BmvVmW);
                                            }
                                            LinearLayout linearLayout3 = nMRewardVideoActivity2.f9628BNL6CD;
                                            if (linearLayout3 != null) {
                                                linearLayout3.addView(nMRewardVideoActivity2.f9632BmvVmW);
                                            }
                                            nMRewardVideoActivity2.f9632BmvVmW.setVisibility(0);
                                            break;
                                        } else if (!nMRewardVideoActivity2.Ddcejp) {
                                            nMRewardVideoActivity2.f9628BNL6CD.setVisibility(8);
                                            break;
                                        }
                                    } catch (Exception e) {
                                        e = e;
                                        aDYaiT = new EY4UKY.ADYaiT();
                                        AMqCpz = JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl createVerticalFinishView: ");
                                    }
                                } else if (i22 == 2) {
                                    HFjH17.ADYaiT aDYaiT3 = nMRewardVideoActivity2.f9620B3GDIM;
                                    boolean z = aDYaiT3 != null ? aDYaiT3.f3291ADYaiT : true;
                                    nMRewardVideoActivity2.f9630BTvldC.removeAllViews();
                                    FrameLayout frameLayout6 = nMRewardVideoActivity2.f9631BV3sI0;
                                    HFjH17.ADYaiT aDYaiT4 = nMRewardVideoActivity2.f9620B3GDIM;
                                    frameLayout6.addView(aDYaiT4.f3300AmA8tU.A4TApA(new K1Z3yj.A2egSU(aDYaiT4, new BmvVmW(16), 25, false)));
                                    HFjH17.ADYaiT aDYaiT5 = nMRewardVideoActivity2.f9620B3GDIM;
                                    if (aDYaiT5.f3305B4ZgIw != null && (aRc23Z = aDYaiT5.f3300AmA8tU) != null) {
                                        if (z) {
                                            aRc23Z.A5SV6n(2);
                                        } else {
                                            aRc23Z.A5SV6n(1);
                                        }
                                    }
                                    HFjH17.ADYaiT aDYaiT6 = nMRewardVideoActivity2.f9620B3GDIM;
                                    aDYaiT6.f3312BNL6CD = true;
                                    if (!nMRewardVideoActivity2.f9666De4eam) {
                                        float f = nMRewardVideoActivity2.f9663DaOi9o * 0.5f;
                                        aDYaiT6.AMqCpz((int) f, (int) ((f * 9.0f) / 16.0f));
                                    }
                                    nMRewardVideoActivity2.f9630BTvldC.setVisibility(8);
                                    nMRewardVideoActivity2.f9631BV3sI0.setVisibility(0);
                                    try {
                                        FrameLayout frameLayout7 = nMRewardVideoActivity2.f9658DG07BK.f2907B9tovu;
                                        if (frameLayout7 != null) {
                                            if (frameLayout7.getParent() != null) {
                                                break;
                                            } else {
                                                nMRewardVideoActivity2.f9648CrfGsy.addView(frameLayout7);
                                            }
                                        }
                                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) nMRewardVideoActivity2.BpkvW3.getLayoutParams();
                                        layoutParams.width = (int) (nMRewardVideoActivity2.f9663DaOi9o * 0.5f);
                                        nMRewardVideoActivity2.BpkvW3.setLayoutParams(layoutParams);
                                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nMRewardVideoActivity2.f9629BPw6Q8.getLayoutParams();
                                        layoutParams2.width = (int) (nMRewardVideoActivity2.f9663DaOi9o * 0.5f);
                                        nMRewardVideoActivity2.f9629BPw6Q8.setLayoutParams(layoutParams2);
                                        if (nMRewardVideoActivity2.f9623B9tovu != null) {
                                            int AzWtSf2 = NOd7IU.AlLFFp.AzWtSf(nMRewardVideoActivity2, 20.0f);
                                            int AzWtSf3 = NOd7IU.AlLFFp.AzWtSf(nMRewardVideoActivity2, 20.0f);
                                            ((FrameLayout.LayoutParams) nMRewardVideoActivity2.f9623B9tovu.getLayoutParams()).setMargins(0, AzWtSf2, AzWtSf3, 0);
                                            ((FrameLayout.LayoutParams) nMRewardVideoActivity2.f9635C4FrIb.getLayoutParams()).setMargins(AzWtSf3, AzWtSf2, 0, 0);
                                        }
                                        ImageView imageView = nMRewardVideoActivity2.f9643Cd8JRx;
                                        if (imageView != null) {
                                            imageView.setVisibility(8);
                                        }
                                        LinearLayout linearLayout4 = nMRewardVideoActivity2.f9625BI9f7h;
                                        if (linearLayout4 != null) {
                                            linearLayout4.setVisibility(8);
                                        }
                                        LinearLayout linearLayout5 = nMRewardVideoActivity2.f9624BChYOn;
                                        if (linearLayout5 != null) {
                                            linearLayout5.setVisibility(8);
                                        }
                                        LinearLayout linearLayout6 = nMRewardVideoActivity2.f9626BIYEnU;
                                        if (linearLayout6 != null) {
                                            linearLayout6.setVisibility(0);
                                        }
                                        FrameLayout frameLayout8 = nMRewardVideoActivity2.f9634C2rE4F;
                                        if (frameLayout8 != null) {
                                            frameLayout8.setVisibility(0);
                                        }
                                        if (nMRewardVideoActivity2.f9644CikNvS != null) {
                                            String adm2 = nMRewardVideoActivity2.f9651D07BeM.getAdm();
                                            if (adm2 != null && !adm2.isEmpty()) {
                                                str = adm2;
                                            }
                                            if (str.isEmpty() && (imgurl = nMRewardVideoActivity2.f9651D07BeM.getImgurl()) != null && !imgurl.isEmpty() && imgurl.get(0) != null) {
                                                str = imgurl.get(0);
                                            }
                                            if (str.isEmpty()) {
                                                GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new B4ZgIw(2, nMRewardVideoActivity2, nMRewardVideoActivity2.f9651D07BeM.getVideourl(), nMRewardVideoActivity2.f9644CikNvS));
                                            } else {
                                                GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new AZOQYO(nMRewardVideoActivity2, str, nMRewardVideoActivity2.f9644CikNvS));
                                            }
                                            nMRewardVideoActivity2.f9644CikNvS.setVisibility(0);
                                        }
                                        if (nMRewardVideoActivity2.f9620B3GDIM != null && nMRewardVideoActivity2.f9666De4eam && nMRewardVideoActivity2.f9651D07BeM != null) {
                                            GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new DjONCG.A5SV6n(nMRewardVideoActivity2, 0));
                                        }
                                        TextView textView3 = nMRewardVideoActivity2.f9639CQhlFr;
                                        if (textView3 != null) {
                                            textView3.setVisibility(0);
                                        }
                                        if (nMRewardVideoActivity2.f9621B4ZgIw != null) {
                                            LinearLayout linearLayout7 = nMRewardVideoActivity2.f9627BJ7GGh;
                                            if (linearLayout7 != null && nMRewardVideoActivity2.Ddcejp) {
                                                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) linearLayout7.getLayoutParams();
                                                layoutParams3.width = (int) (nMRewardVideoActivity2.f9663DaOi9o * 0.5f);
                                                nMRewardVideoActivity2.f9627BJ7GGh.setLayoutParams(layoutParams3);
                                                nMRewardVideoActivity2.f9632BmvVmW.setVisibility(0);
                                                break;
                                            } else if (!nMRewardVideoActivity2.Ddcejp) {
                                                nMRewardVideoActivity2.f9628BNL6CD.setVisibility(8);
                                                break;
                                            }
                                        }
                                    } catch (Exception e2) {
                                        e = e2;
                                        aDYaiT = new EY4UKY.ADYaiT();
                                        AMqCpz = JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl createHorizontalFinishView: ");
                                    }
                                }
                                CtFAbx.B4ZgIw(e, AMqCpz, aDYaiT, "004", e);
                                break;
                            case 2:
                                FZu94u.A4TApA a4TApA = NMRewardVideoActivity.f9613F1loUV;
                                FZu94u.A4TApA a4TApA2 = NMRewardVideoActivity.f9613F1loUV;
                                if (a4TApA2.f2775FOAO9d == 1) {
                                    a4TApA2.B2KMhB(nMRewardVideoActivity2.f9647CqNSpT, "1");
                                } else {
                                    a4TApA2.B2KMhB(nMRewardVideoActivity2.f9621B4ZgIw, null);
                                }
                                if (nMRewardVideoActivity2.ASJ6gh("unuser", 0, false)) {
                                    FZu94u.A4TApA a4TApA3 = NMRewardVideoActivity.f9613F1loUV;
                                    a4TApA3.f3203BIYEnU = true;
                                    a4TApA3.BV3sI0();
                                    HFjH17.ADYaiT aDYaiT7 = nMRewardVideoActivity2.f9620B3GDIM;
                                    if (aDYaiT7 != null && nMRewardVideoActivity2.f9660DUi7mC != 1) {
                                        boolean AcNBzu2 = aDYaiT7.AcNBzu();
                                        FZu94u.A4TApA a4TApA4 = NMRewardVideoActivity.f9613F1loUV;
                                        if (a4TApA4 != null && AcNBzu2) {
                                            a4TApA4.CTkVKb(a4TApA4.f3187AYUAbz);
                                            break;
                                        }
                                    }
                                }
                                break;
                            default:
                                FZu94u.A4TApA a4TApA5 = NMRewardVideoActivity.f9613F1loUV;
                                try {
                                    if (nMRewardVideoActivity2.f9635C4FrIb.getVisibility() == 0) {
                                        int i4 = GJee0v.AZOQYO.f3039AcNBzu;
                                        TextView textView4 = nMRewardVideoActivity2.f9636CASmeH;
                                        if (textView4 != null) {
                                            textView4.setOnClickListener(nMRewardVideoActivity2.EdQ5bb);
                                        }
                                        TextView textView5 = nMRewardVideoActivity2.f9635C4FrIb;
                                        if (textView5 != null) {
                                            textView5.setVisibility(8);
                                        }
                                        LinearLayout linearLayout8 = nMRewardVideoActivity2.f9623B9tovu;
                                        if (linearLayout8 != null) {
                                            linearLayout8.setVisibility(0);
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                } catch (Exception e3) {
                                    e3.getMessage();
                                    int i5 = GJee0v.AZOQYO.f3039AcNBzu;
                                }
                                break;
                        }
                    }
                });
            }
            FZu94u.A4TApA a4TApA = NMRewardVideoActivity.f9613F1loUV;
            if (a4TApA != null) {
                float f = a4TApA.f3202BI9f7h;
                if (f > 0.0f && ((float) d) == f && a4TApA.BniPrB()) {
                    final int i4 = 2;
                    handler.post(new Runnable() { // from class: Dphsd2.AYUAbz
                        @Override // java.lang.Runnable
                        public final void run() {
                            EY4UKY.ADYaiT aDYaiT;
                            StringBuilder AMqCpz;
                            List<String> imgurl;
                            HFjH17.ARc23Z aRc23Z;
                            Material material;
                            List<String> imgurl2;
                            MediaPlayer mediaPlayer;
                            NMRewardVideoActivity nMRewardVideoActivity2 = nMRewardVideoActivity;
                            switch (i4) {
                                case 0:
                                    TextView textView = nMRewardVideoActivity2.f9635C4FrIb;
                                    if (textView != null && NMRewardVideoActivity.f9613F1loUV.f2789GJee0v) {
                                        textView.setText(nMRewardVideoActivity2.getResources().getString(2131886635));
                                        break;
                                    }
                                    break;
                                case 1:
                                    int i22 = nMRewardVideoActivity2.f9662DXnQ0V;
                                    String str = "";
                                    if (i22 == 1) {
                                        HFjH17.ADYaiT aDYaiT2 = nMRewardVideoActivity2.f9620B3GDIM;
                                        if (aDYaiT2 != null) {
                                            if (aDYaiT2.AaHO0E() && (mediaPlayer = aDYaiT2.f3305B4ZgIw) != null) {
                                                int i32 = GJee0v.AZOQYO.f3039AcNBzu;
                                                try {
                                                    mediaPlayer.stop();
                                                    aDYaiT2.f3317BniPrB = 9;
                                                    aDYaiT2.ADYaiT(65541);
                                                } catch (Exception unused) {
                                                }
                                            }
                                            aDYaiT2.AlLFFp();
                                        }
                                        nMRewardVideoActivity2.f9630BTvldC.setVisibility(8);
                                        try {
                                            FrameLayout frameLayout = nMRewardVideoActivity2.f9658DG07BK.f2907B9tovu;
                                            if (frameLayout != null) {
                                                if (frameLayout.getParent() != null) {
                                                    break;
                                                } else {
                                                    nMRewardVideoActivity2.f9649CtFAbx.addView(frameLayout);
                                                }
                                            }
                                            FrameLayout frameLayout2 = nMRewardVideoActivity2.BpkvW3;
                                            if (frameLayout2 != null) {
                                                frameLayout2.setVisibility(8);
                                            }
                                            LinearLayout linearLayout = nMRewardVideoActivity2.f9625BI9f7h;
                                            if (linearLayout != null) {
                                                linearLayout.setVisibility(8);
                                            }
                                            LinearLayout linearLayout2 = nMRewardVideoActivity2.f9624BChYOn;
                                            if (linearLayout2 != null) {
                                                linearLayout2.setVisibility(8);
                                            }
                                            FrameLayout frameLayout3 = nMRewardVideoActivity2.f9622B7CMnp;
                                            if (frameLayout3 != null) {
                                                frameLayout3.setVisibility(0);
                                            }
                                            TextView textView2 = nMRewardVideoActivity2.f9638COJEAR;
                                            if (textView2 != null) {
                                                textView2.setVisibility(0);
                                            }
                                            FrameLayout frameLayout4 = nMRewardVideoActivity2.f9634C2rE4F;
                                            if (frameLayout4 != null) {
                                                frameLayout4.setVisibility(0);
                                            }
                                            if (nMRewardVideoActivity2.f9644CikNvS != null && (material = nMRewardVideoActivity2.f9651D07BeM) != null) {
                                                String adm = material.getAdm();
                                                if (adm != null && !adm.isEmpty()) {
                                                    str = adm;
                                                }
                                                if (str.isEmpty() && (imgurl2 = nMRewardVideoActivity2.f9651D07BeM.getImgurl()) != null && !imgurl2.isEmpty() && imgurl2.get(0) != null) {
                                                    str = imgurl2.get(0);
                                                }
                                                if (str.isEmpty()) {
                                                    GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new B4ZgIw(2, nMRewardVideoActivity2, nMRewardVideoActivity2.f9651D07BeM.getVideourl(), nMRewardVideoActivity2.f9644CikNvS));
                                                } else {
                                                    GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new AZOQYO(nMRewardVideoActivity2, str, nMRewardVideoActivity2.f9644CikNvS));
                                                }
                                                nMRewardVideoActivity2.f9644CikNvS.setVisibility(0);
                                            }
                                            FrameLayout frameLayout5 = nMRewardVideoActivity2.f9632BmvVmW;
                                            if (frameLayout5 != null && nMRewardVideoActivity2.Ddcejp) {
                                                ViewGroup viewGroup = (ViewGroup) frameLayout5.getParent();
                                                if (viewGroup != null) {
                                                    viewGroup.removeView(nMRewardVideoActivity2.f9632BmvVmW);
                                                }
                                                LinearLayout linearLayout3 = nMRewardVideoActivity2.f9628BNL6CD;
                                                if (linearLayout3 != null) {
                                                    linearLayout3.addView(nMRewardVideoActivity2.f9632BmvVmW);
                                                }
                                                nMRewardVideoActivity2.f9632BmvVmW.setVisibility(0);
                                                break;
                                            } else if (!nMRewardVideoActivity2.Ddcejp) {
                                                nMRewardVideoActivity2.f9628BNL6CD.setVisibility(8);
                                                break;
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            aDYaiT = new EY4UKY.ADYaiT();
                                            AMqCpz = JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl createVerticalFinishView: ");
                                        }
                                    } else if (i22 == 2) {
                                        HFjH17.ADYaiT aDYaiT3 = nMRewardVideoActivity2.f9620B3GDIM;
                                        boolean z = aDYaiT3 != null ? aDYaiT3.f3291ADYaiT : true;
                                        nMRewardVideoActivity2.f9630BTvldC.removeAllViews();
                                        FrameLayout frameLayout6 = nMRewardVideoActivity2.f9631BV3sI0;
                                        HFjH17.ADYaiT aDYaiT4 = nMRewardVideoActivity2.f9620B3GDIM;
                                        frameLayout6.addView(aDYaiT4.f3300AmA8tU.A4TApA(new K1Z3yj.A2egSU(aDYaiT4, new BmvVmW(16), 25, false)));
                                        HFjH17.ADYaiT aDYaiT5 = nMRewardVideoActivity2.f9620B3GDIM;
                                        if (aDYaiT5.f3305B4ZgIw != null && (aRc23Z = aDYaiT5.f3300AmA8tU) != null) {
                                            if (z) {
                                                aRc23Z.A5SV6n(2);
                                            } else {
                                                aRc23Z.A5SV6n(1);
                                            }
                                        }
                                        HFjH17.ADYaiT aDYaiT6 = nMRewardVideoActivity2.f9620B3GDIM;
                                        aDYaiT6.f3312BNL6CD = true;
                                        if (!nMRewardVideoActivity2.f9666De4eam) {
                                            float f2 = nMRewardVideoActivity2.f9663DaOi9o * 0.5f;
                                            aDYaiT6.AMqCpz((int) f2, (int) ((f2 * 9.0f) / 16.0f));
                                        }
                                        nMRewardVideoActivity2.f9630BTvldC.setVisibility(8);
                                        nMRewardVideoActivity2.f9631BV3sI0.setVisibility(0);
                                        try {
                                            FrameLayout frameLayout7 = nMRewardVideoActivity2.f9658DG07BK.f2907B9tovu;
                                            if (frameLayout7 != null) {
                                                if (frameLayout7.getParent() != null) {
                                                    break;
                                                } else {
                                                    nMRewardVideoActivity2.f9648CrfGsy.addView(frameLayout7);
                                                }
                                            }
                                            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) nMRewardVideoActivity2.BpkvW3.getLayoutParams();
                                            layoutParams.width = (int) (nMRewardVideoActivity2.f9663DaOi9o * 0.5f);
                                            nMRewardVideoActivity2.BpkvW3.setLayoutParams(layoutParams);
                                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) nMRewardVideoActivity2.f9629BPw6Q8.getLayoutParams();
                                            layoutParams2.width = (int) (nMRewardVideoActivity2.f9663DaOi9o * 0.5f);
                                            nMRewardVideoActivity2.f9629BPw6Q8.setLayoutParams(layoutParams2);
                                            if (nMRewardVideoActivity2.f9623B9tovu != null) {
                                                int AzWtSf2 = NOd7IU.AlLFFp.AzWtSf(nMRewardVideoActivity2, 20.0f);
                                                int AzWtSf3 = NOd7IU.AlLFFp.AzWtSf(nMRewardVideoActivity2, 20.0f);
                                                ((FrameLayout.LayoutParams) nMRewardVideoActivity2.f9623B9tovu.getLayoutParams()).setMargins(0, AzWtSf2, AzWtSf3, 0);
                                                ((FrameLayout.LayoutParams) nMRewardVideoActivity2.f9635C4FrIb.getLayoutParams()).setMargins(AzWtSf3, AzWtSf2, 0, 0);
                                            }
                                            ImageView imageView = nMRewardVideoActivity2.f9643Cd8JRx;
                                            if (imageView != null) {
                                                imageView.setVisibility(8);
                                            }
                                            LinearLayout linearLayout4 = nMRewardVideoActivity2.f9625BI9f7h;
                                            if (linearLayout4 != null) {
                                                linearLayout4.setVisibility(8);
                                            }
                                            LinearLayout linearLayout5 = nMRewardVideoActivity2.f9624BChYOn;
                                            if (linearLayout5 != null) {
                                                linearLayout5.setVisibility(8);
                                            }
                                            LinearLayout linearLayout6 = nMRewardVideoActivity2.f9626BIYEnU;
                                            if (linearLayout6 != null) {
                                                linearLayout6.setVisibility(0);
                                            }
                                            FrameLayout frameLayout8 = nMRewardVideoActivity2.f9634C2rE4F;
                                            if (frameLayout8 != null) {
                                                frameLayout8.setVisibility(0);
                                            }
                                            if (nMRewardVideoActivity2.f9644CikNvS != null) {
                                                String adm2 = nMRewardVideoActivity2.f9651D07BeM.getAdm();
                                                if (adm2 != null && !adm2.isEmpty()) {
                                                    str = adm2;
                                                }
                                                if (str.isEmpty() && (imgurl = nMRewardVideoActivity2.f9651D07BeM.getImgurl()) != null && !imgurl.isEmpty() && imgurl.get(0) != null) {
                                                    str = imgurl.get(0);
                                                }
                                                if (str.isEmpty()) {
                                                    GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new B4ZgIw(2, nMRewardVideoActivity2, nMRewardVideoActivity2.f9651D07BeM.getVideourl(), nMRewardVideoActivity2.f9644CikNvS));
                                                } else {
                                                    GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new AZOQYO(nMRewardVideoActivity2, str, nMRewardVideoActivity2.f9644CikNvS));
                                                }
                                                nMRewardVideoActivity2.f9644CikNvS.setVisibility(0);
                                            }
                                            if (nMRewardVideoActivity2.f9620B3GDIM != null && nMRewardVideoActivity2.f9666De4eam && nMRewardVideoActivity2.f9651D07BeM != null) {
                                                GJee0v.AZkASS.f3040ADYaiT.f3041A2egSU.execute(new DjONCG.A5SV6n(nMRewardVideoActivity2, 0));
                                            }
                                            TextView textView3 = nMRewardVideoActivity2.f9639CQhlFr;
                                            if (textView3 != null) {
                                                textView3.setVisibility(0);
                                            }
                                            if (nMRewardVideoActivity2.f9621B4ZgIw != null) {
                                                LinearLayout linearLayout7 = nMRewardVideoActivity2.f9627BJ7GGh;
                                                if (linearLayout7 != null && nMRewardVideoActivity2.Ddcejp) {
                                                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) linearLayout7.getLayoutParams();
                                                    layoutParams3.width = (int) (nMRewardVideoActivity2.f9663DaOi9o * 0.5f);
                                                    nMRewardVideoActivity2.f9627BJ7GGh.setLayoutParams(layoutParams3);
                                                    nMRewardVideoActivity2.f9632BmvVmW.setVisibility(0);
                                                    break;
                                                } else if (!nMRewardVideoActivity2.Ddcejp) {
                                                    nMRewardVideoActivity2.f9628BNL6CD.setVisibility(8);
                                                    break;
                                                }
                                            }
                                        } catch (Exception e2) {
                                            e = e2;
                                            aDYaiT = new EY4UKY.ADYaiT();
                                            AMqCpz = JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl createHorizontalFinishView: ");
                                        }
                                    }
                                    CtFAbx.B4ZgIw(e, AMqCpz, aDYaiT, "004", e);
                                    break;
                                case 2:
                                    FZu94u.A4TApA a4TApA2 = NMRewardVideoActivity.f9613F1loUV;
                                    FZu94u.A4TApA a4TApA22 = NMRewardVideoActivity.f9613F1loUV;
                                    if (a4TApA22.f2775FOAO9d == 1) {
                                        a4TApA22.B2KMhB(nMRewardVideoActivity2.f9647CqNSpT, "1");
                                    } else {
                                        a4TApA22.B2KMhB(nMRewardVideoActivity2.f9621B4ZgIw, null);
                                    }
                                    if (nMRewardVideoActivity2.ASJ6gh("unuser", 0, false)) {
                                        FZu94u.A4TApA a4TApA3 = NMRewardVideoActivity.f9613F1loUV;
                                        a4TApA3.f3203BIYEnU = true;
                                        a4TApA3.BV3sI0();
                                        HFjH17.ADYaiT aDYaiT7 = nMRewardVideoActivity2.f9620B3GDIM;
                                        if (aDYaiT7 != null && nMRewardVideoActivity2.f9660DUi7mC != 1) {
                                            boolean AcNBzu2 = aDYaiT7.AcNBzu();
                                            FZu94u.A4TApA a4TApA4 = NMRewardVideoActivity.f9613F1loUV;
                                            if (a4TApA4 != null && AcNBzu2) {
                                                a4TApA4.CTkVKb(a4TApA4.f3187AYUAbz);
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                default:
                                    FZu94u.A4TApA a4TApA5 = NMRewardVideoActivity.f9613F1loUV;
                                    try {
                                        if (nMRewardVideoActivity2.f9635C4FrIb.getVisibility() == 0) {
                                            int i42 = GJee0v.AZOQYO.f3039AcNBzu;
                                            TextView textView4 = nMRewardVideoActivity2.f9636CASmeH;
                                            if (textView4 != null) {
                                                textView4.setOnClickListener(nMRewardVideoActivity2.EdQ5bb);
                                            }
                                            TextView textView5 = nMRewardVideoActivity2.f9635C4FrIb;
                                            if (textView5 != null) {
                                                textView5.setVisibility(8);
                                            }
                                            LinearLayout linearLayout8 = nMRewardVideoActivity2.f9623B9tovu;
                                            if (linearLayout8 != null) {
                                                linearLayout8.setVisibility(0);
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    } catch (Exception e3) {
                                        e3.getMessage();
                                        int i5 = GJee0v.AZOQYO.f3039AcNBzu;
                                    }
                                    break;
                            }
                        }
                    });
                }
            }
        } catch (Exception e) {
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMRewardVideoActivity 009: "), new EY4UKY.ADYaiT(), "004", e);
        }
    }

    @Override // Fyurov.A5SV6n
    public void a(int i, boolean z) {
        FZu94u.A4TApA a4TApA = NMRewardVideoActivity.f9613F1loUV;
        NMRewardVideoActivity nMRewardVideoActivity = this.f2455AcNBzu;
        nMRewardVideoActivity.getClass();
        if (i == 1) {
            int i2 = GJee0v.AZOQYO.f3039AcNBzu;
            nMRewardVideoActivity.ASJ6gh("user", 1, z);
            return;
        }
        if (i == 2) {
            int i3 = GJee0v.AZOQYO.f3039AcNBzu;
            NMRewardVideoActivity.f9613F1loUV.AZkASS();
            FZu94u.A4TApA a4TApA2 = NMRewardVideoActivity.f9613F1loUV;
            a4TApA2.BIYEnU(a4TApA2.f3187AYUAbz);
            a4TApA2.f3204BJ7GGh = false;
            nMRewardVideoActivity.f9658DG07BK.ADYaiT(true);
            nMRewardVideoActivity.f9661DV2E8K = 3;
            return;
        }
        if (i == 3) {
            int i4 = GJee0v.AZOQYO.f3039AcNBzu;
            NMRewardVideoActivity.f9613F1loUV.AZOQYO();
            FZu94u.A4TApA a4TApA3 = NMRewardVideoActivity.f9613F1loUV;
            a4TApA3.BIYEnU(a4TApA3.f3187AYUAbz);
            a4TApA3.f3204BJ7GGh = false;
            nMRewardVideoActivity.f9661DV2E8K = 1;
            nMRewardVideoActivity.f9658DG07BK.ADYaiT(false);
            return;
        }
        if (i != 4) {
            if (i != 5) {
                return;
            }
            int i5 = GJee0v.AZOQYO.f3039AcNBzu;
            nMRewardVideoActivity.ASJ6gh("user", 1, z);
            return;
        }
        int i6 = GJee0v.AZOQYO.f3039AcNBzu;
        NMRewardVideoActivity.f9613F1loUV.C2rE4F();
        NMRewardVideoActivity.f9613F1loUV.DV2E8K();
        FZu94u.A4TApA a4TApA4 = NMRewardVideoActivity.f9613F1loUV;
        a4TApA4.BIYEnU(a4TApA4.f3187AYUAbz);
        a4TApA4.f3204BJ7GGh = false;
        FZu94u.A4TApA a4TApA5 = NMRewardVideoActivity.f9613F1loUV;
        if (a4TApA5.f2768EwN40Z != null) {
            a4TApA5.De4eam(4, null, null);
            a4TApA5.DdagTj();
        }
    }

    @Override // Fyurov.ARc23Z
    public void a(int[] iArr) {
        NMRewardVideoActivity nMRewardVideoActivity = this.f2455AcNBzu;
        if (nMRewardVideoActivity.f9656D9tr6l) {
            return;
        }
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        nMRewardVideoActivity.f9656D9tr6l = true;
        NMRewardVideoActivity.f9613F1loUV.f3205BNL6CD = iArr;
        if (nMRewardVideoActivity.ASJ6gh("shake", 0, false)) {
            return;
        }
        nMRewardVideoActivity.f9656D9tr6l = false;
    }
}
