package K1Z3yj;

import ADYaiT.BV3sI0;
import ADYaiT.CkXcdM;
import ADYaiT.CtFAbx;
import ADYaiT.D8MqeW;
import B4ZgIw.AYUAbz;
import COJEAR.CikNvS;
import COJEAR.DG07BK;
import COJEAR.De4eam;
import CikNvS.AZkASS;
import DRlcZ9.AmA8tU;
import GJee0v.ASJ6gh;
import GJee0v.AZOQYO;
import GnQT2j.AMqCpz;
import GnQT2j.AaHO0E;
import H0qugq.AcNBzu;
import HXc4pW.BpkvW3;
import Hjvs0g.BChYOn;
import ItGa5w.ARc23Z;
import JrXYwF.A4TApA;
import NOd7IU.AlLFFp;
import android.app.KeyguardManager;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.Choreographer;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import com.alliance.ssp.ad.activity.AppInfoViewActivity;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.bean.SAAllianceEngineData;
import com.bumptech.glide.A5SV6n;
import com.bumptech.glide.load.data.ADYaiT;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements AZkASS, AZOQYO.A2egSU, AmA8tU, AaHO0E, EmJGcg.A2egSU, GYpKKt.A2egSU, ASJ6gh, AMqCpz, ADYaiT {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static volatile A2egSU f4172AzWtSf;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4173AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object f4174AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Object f4175AmA8tU;

    public /* synthetic */ A2egSU(int i, Object obj) {
        this.f4173AcNBzu = i;
        this.f4175AmA8tU = obj;
    }

    public static byte[] AlLFFp(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException();
        }
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[str.length() / 2];
        int length = str.length();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            StringBuilder AMqCpz = A4TApA.AMqCpz("");
            AMqCpz.append(charArray[i]);
            AMqCpz.append(charArray[i + 1]);
            bArr[i2] = new Integer(Integer.parseInt(AMqCpz.toString(), 16) & 255).byteValue();
            i += 2;
            i2++;
        }
        return bArr;
    }

    public static A2egSU B9tovu() {
        if (f4172AzWtSf == null) {
            synchronized (A2egSU.class) {
                try {
                    if (f4172AzWtSf == null) {
                        f4172AzWtSf = new A2egSU(0, false);
                    }
                } finally {
                }
            }
        }
        return f4172AzWtSf;
    }

    @Override // GnQT2j.AMqCpz
    public void A2egSU() {
        EY4UKY.ADYaiT aDYaiT = new EY4UKY.ADYaiT();
        SAAllianceAdData sAAllianceAdData = (SAAllianceAdData) this.f4174AlLFFp;
        aDYaiT.B3GDIM(5, 1, sAAllianceAdData, sAAllianceAdData.getCrequestid(), "");
    }

    @Override // EmJGcg.A2egSU
    public void A4TApA(GEYgCP.A2egSU a2egSU) {
        if (((Context) this.f4174AlLFFp) != null) {
            KeyguardManager keyguardManager = (KeyguardManager) this.f4175AmA8tU;
            if (keyguardManager == null) {
                new GL2Jh7.A2egSU("KeyguardManager not found");
                return;
            }
            try {
                Object invoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(keyguardManager, new Object[0]);
                if (invoke == null) {
                    throw new GL2Jh7.A2egSU("OAID obtain failed");
                }
                AlLFFp.f5886AlLFFp = invoke.toString();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.ADYaiT
    public void A5SV6n(Exception exc) {
        BpkvW3 bpkvW3 = (BpkvW3) this.f4175AmA8tU;
        BChYOn bChYOn = (BChYOn) this.f4174AlLFFp;
        BChYOn bChYOn2 = bpkvW3.f3652B2KMhB;
        if (bChYOn2 == null || bChYOn2 != bChYOn) {
            return;
        }
        HXc4pW.AMqCpz aMqCpz = bpkvW3.f3653B3GDIM;
        com.bumptech.glide.load.data.AMqCpz aMqCpz2 = bChYOn.f3744A5SV6n;
        bpkvW3.f3648AlLFFp.A4TApA(aMqCpz, exc, aMqCpz2, aMqCpz2.getDataSource());
    }

    @Override // AZOQYO.A2egSU
    public boolean ADYaiT(AZOQYO.A4TApA a4TApA, AZkASS.AmA8tU amA8tU) {
        ViewGroup viewGroup = ((CkXcdM) this.f4175AmA8tU).f172CQhlFr;
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        CikNvS.A5SV6n(viewGroup);
        return ((AZOQYO.A2egSU) this.f4174AlLFFp).ADYaiT(a4TApA, amA8tU);
    }

    @Override // GYpKKt.A2egSU
    public void AMqCpz(Object obj) {
        switch (this.f4173AcNBzu) {
            case 17:
                Context context = (Context) this.f4174AlLFFp;
                SAAllianceEngineData sAAllianceEngineData = (SAAllianceEngineData) obj;
                FSFw2u.AZkASS aZkASS = (FSFw2u.AZkASS) this.f4175AmA8tU;
                if (sAAllianceEngineData == null) {
                    FSFw2u.AZkASS.DvK7DB(aZkASS, 8193, "002", "无广告填充，请联系技术进行排查。");
                    break;
                } else {
                    try {
                        List<SAAllianceAdData> data = sAAllianceEngineData.getData();
                        if (data == null) {
                            FSFw2u.AZkASS.DvK7DB(aZkASS, sAAllianceEngineData.getCode(), "001", sAAllianceEngineData.getMessage());
                            break;
                        } else {
                            if (data.size() > 0 && sAAllianceEngineData.getData() != null && !sAAllianceEngineData.getData().isEmpty()) {
                                for (SAAllianceAdData sAAllianceAdData : data) {
                                    AcNBzu acNBzu = aZkASS.f3207BTvldC;
                                    long cacheTimeout = sAAllianceAdData.getCacheTimeout();
                                    acNBzu.getClass();
                                    sAAllianceAdData.setDeadlineTime(AcNBzu.A4TApA(cacheTimeout));
                                    AcNBzu acNBzu2 = aZkASS.f3207BTvldC;
                                    String price = sAAllianceAdData.getPrice();
                                    acNBzu2.getClass();
                                    sAAllianceAdData.setPriceD(AcNBzu.A2egSU(price));
                                    if (aZkASS.f3207BTvldC != null) {
                                        AcNBzu.ARc23Z(context, aZkASS.HHoABE, sAAllianceAdData.getWaitLoadTimeout());
                                        if (sAAllianceAdData.isNeedCache()) {
                                            sAAllianceAdData.setRequestid(aZkASS.f3200B9tovu);
                                            aZkASS.f3207BTvldC.AMqCpz(context, sAAllianceAdData, aZkASS.HHoABE);
                                        }
                                    }
                                    if (!aZkASS.f2743HwAeAU) {
                                        HH6JFw.A2egSU a2egSU = aZkASS.f2737HXc4pW;
                                        if (a2egSU != null) {
                                            a2egSU.removeCallbacksAndMessages(null);
                                            aZkASS.f2737HXc4pW = null;
                                        }
                                        FSFw2u.AZkASS.DyaChj(aZkASS, aZkASS.f2741Hjvs0g, sAAllianceAdData);
                                    }
                                }
                                break;
                            }
                            FSFw2u.AZkASS.DvK7DB(aZkASS, sAAllianceEngineData.getCode(), "003", sAAllianceEngineData.getMessage());
                        }
                    } catch (Exception e) {
                        e.toString();
                        int i = AZOQYO.f3039AcNBzu;
                        CtFAbx.B4ZgIw(e, A4TApA.AMqCpz("NMInterstitialAdImpl 001: "), new EY4UKY.ADYaiT(), "004", e);
                        aZkASS.AmA8tU(8194, "001", "渲染失败。");
                        A5SV6n.ARc23Z();
                        return;
                    }
                }
                break;
            case 18:
            default:
                Context context2 = (Context) this.f4174AlLFFp;
                SAAllianceEngineData sAAllianceEngineData2 = (SAAllianceEngineData) obj;
                FdMWEC.AZkASS aZkASS2 = (FdMWEC.AZkASS) this.f4175AmA8tU;
                if (sAAllianceEngineData2 == null) {
                    FdMWEC.AZkASS.DuwtYk(aZkASS2, 8193, "002", "无广告填充，请联系技术进行排查。");
                    break;
                } else {
                    try {
                        List<SAAllianceAdData> data2 = sAAllianceEngineData2.getData();
                        if (data2 == null) {
                            FdMWEC.AZkASS.DuwtYk(aZkASS2, sAAllianceEngineData2.getCode(), "001", sAAllianceEngineData2.getMessage());
                            break;
                        } else {
                            if (data2.size() > 0 && sAAllianceEngineData2.getData() != null && !sAAllianceEngineData2.getData().isEmpty()) {
                                for (SAAllianceAdData sAAllianceAdData2 : data2) {
                                    AcNBzu acNBzu3 = aZkASS2.f3207BTvldC;
                                    long cacheTimeout2 = sAAllianceAdData2.getCacheTimeout();
                                    acNBzu3.getClass();
                                    sAAllianceAdData2.setDeadlineTime(AcNBzu.A4TApA(cacheTimeout2));
                                    AcNBzu acNBzu4 = aZkASS2.f3207BTvldC;
                                    String price2 = sAAllianceAdData2.getPrice();
                                    acNBzu4.getClass();
                                    sAAllianceAdData2.setPriceD(AcNBzu.A2egSU(price2));
                                    if (aZkASS2.f3207BTvldC != null) {
                                        AcNBzu.ARc23Z(context2, aZkASS2.G2rdQT, sAAllianceAdData2.getWaitLoadTimeout());
                                        if (sAAllianceAdData2.isNeedCache()) {
                                            sAAllianceAdData2.setRequestid(aZkASS2.f3200B9tovu);
                                            aZkASS2.f3207BTvldC.AMqCpz(context2, sAAllianceAdData2, aZkASS2.G2rdQT);
                                        }
                                    }
                                    if (!aZkASS2.f2844HFjH17) {
                                        FdMWEC.AaHO0E aaHO0E = aZkASS2.f2840H0R8Px;
                                        if (aaHO0E != null) {
                                            aaHO0E.removeCallbacksAndMessages(null);
                                            aZkASS2.f2840H0R8Px = null;
                                        }
                                        FdMWEC.AZkASS.DvK7DB(aZkASS2, aZkASS2.f2843H3v3Sq, sAAllianceAdData2);
                                    }
                                }
                                break;
                            }
                            FdMWEC.AZkASS.DuwtYk(aZkASS2, sAAllianceEngineData2.getCode(), "003", sAAllianceEngineData2.getMessage());
                        }
                    } catch (Exception e2) {
                        e2.getMessage();
                        int i2 = AZOQYO.f3039AcNBzu;
                        CtFAbx.B4ZgIw(e2, A4TApA.AMqCpz("NMSplashAdImpl 001: "), new EY4UKY.ADYaiT(), "004", e2);
                        aZkASS2.f2865IQ76hF = 8;
                        aZkASS2.AmA8tU(8194, "001", "渲染失败。");
                        A5SV6n.ARc23Z();
                    }
                }
                break;
            case 19:
                Context context3 = (Context) this.f4174AlLFFp;
                SAAllianceEngineData sAAllianceEngineData3 = (SAAllianceEngineData) obj;
                FZu94u.A4TApA a4TApA = (FZu94u.A4TApA) this.f4175AmA8tU;
                if (sAAllianceEngineData3 == null) {
                    FZu94u.A4TApA.DjONCG(a4TApA, 8193, "002", "无广告填充，请联系技术进行排查。");
                    break;
                } else {
                    try {
                        List<SAAllianceAdData> data3 = sAAllianceEngineData3.getData();
                        if (data3 == null) {
                            FZu94u.A4TApA.DjONCG(a4TApA, sAAllianceEngineData3.getCode(), "001", sAAllianceEngineData3.getMessage());
                            break;
                        } else {
                            if (data3.size() > 0 && sAAllianceEngineData3.getData() != null && !sAAllianceEngineData3.getData().isEmpty()) {
                                for (SAAllianceAdData sAAllianceAdData3 : data3) {
                                    AcNBzu acNBzu5 = a4TApA.f3207BTvldC;
                                    long cacheTimeout3 = sAAllianceAdData3.getCacheTimeout();
                                    acNBzu5.getClass();
                                    sAAllianceAdData3.setDeadlineTime(AcNBzu.A4TApA(cacheTimeout3));
                                    AcNBzu acNBzu6 = a4TApA.f3207BTvldC;
                                    String price3 = sAAllianceAdData3.getPrice();
                                    acNBzu6.getClass();
                                    sAAllianceAdData3.setPriceD(AcNBzu.A2egSU(price3));
                                    if (a4TApA.f3207BTvldC != null) {
                                        AcNBzu.ARc23Z(context3, a4TApA.f2776FSFw2u, sAAllianceAdData3.getWaitLoadTimeout());
                                        if (sAAllianceAdData3.isNeedCache()) {
                                            sAAllianceAdData3.setRequestid(a4TApA.f3200B9tovu);
                                            a4TApA.f3207BTvldC.AMqCpz(context3, sAAllianceAdData3, a4TApA.f2776FSFw2u);
                                        }
                                    }
                                    if (!a4TApA.f2783Fyurov) {
                                        HHLj6Q.A2egSU a2egSU2 = a4TApA.f2780Fmmv0E;
                                        if (a2egSU2 != null) {
                                            a2egSU2.removeCallbacksAndMessages(null);
                                            a4TApA.f2780Fmmv0E = null;
                                        }
                                        FZu94u.A4TApA.Dphsd2(a4TApA, a4TApA.f2781FmyuN2, sAAllianceAdData3);
                                    }
                                }
                                break;
                            }
                            FZu94u.A4TApA.DjONCG(a4TApA, sAAllianceEngineData3.getCode(), "003", sAAllianceEngineData3.getMessage());
                        }
                    } catch (Exception e3) {
                        e3.toString();
                        int i3 = AZOQYO.f3039AcNBzu;
                        CtFAbx.B4ZgIw(e3, A4TApA.AMqCpz("NMRewardVideoAdImpl 001: "), new EY4UKY.ADYaiT(), "004", e3);
                        a4TApA.AmA8tU(8194, "001", "渲染失败。");
                        A5SV6n.ARc23Z();
                        return;
                    }
                }
                break;
        }
    }

    @Override // AZOQYO.A2egSU
    public boolean ARc23Z(AZOQYO.A4TApA a4TApA, MenuItem menuItem) {
        return ((AZOQYO.A2egSU) this.f4174AlLFFp).ARc23Z(a4TApA, menuItem);
    }

    @Override // com.bumptech.glide.load.data.ADYaiT
    public void ASJ6gh(Object obj) {
        BpkvW3 bpkvW3 = (BpkvW3) this.f4175AmA8tU;
        BChYOn bChYOn = (BChYOn) this.f4174AlLFFp;
        BChYOn bChYOn2 = bpkvW3.f3652B2KMhB;
        if (bChYOn2 == null || bChYOn2 != bChYOn) {
            return;
        }
        HXc4pW.AlLFFp alLFFp = bpkvW3.f3647AcNBzu.f3516B25kr6;
        if (obj != null && alLFFp.A5SV6n(bChYOn.f3744A5SV6n.getDataSource())) {
            bpkvW3.f3651B25kr6 = obj;
            bpkvW3.f3648AlLFFp.AmA8tU();
            return;
        }
        HSHyT0.AZkASS aZkASS = bChYOn.f3742A2egSU;
        com.bumptech.glide.load.data.AMqCpz aMqCpz = bChYOn.f3744A5SV6n;
        bpkvW3.f3648AlLFFp.A5SV6n(aZkASS, obj, aMqCpz, aMqCpz.getDataSource(), bpkvW3.f3653B3GDIM);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [ADYaiT.B3GDIM, java.lang.Object] */
    @Override // AZOQYO.A2egSU
    public void AYUAbz(AZOQYO.A4TApA a4TApA) {
        ((AZOQYO.A2egSU) this.f4174AlLFFp).AYUAbz(a4TApA);
        CkXcdM ckXcdM = (CkXcdM) this.f4175AmA8tU;
        if (ckXcdM.f168C4FrIb != null) {
            ckXcdM.f158BI9f7h.getDecorView().removeCallbacks(ckXcdM.f169CASmeH);
        }
        if (ckXcdM.f167C2rE4F != null) {
            De4eam de4eam = ckXcdM.f170CNPG0E;
            if (de4eam != null) {
                de4eam.A4TApA();
            }
            De4eam A2egSU2 = DG07BK.A2egSU(ckXcdM.f167C2rE4F);
            A2egSU2.A2egSU(0.0f);
            ckXcdM.f170CNPG0E = A2egSU2;
            A2egSU2.ADYaiT(new BV3sI0(2, this));
        }
        ckXcdM.f160BJ7GGh.onSupportActionModeFinished(ckXcdM.BpkvW3);
        ckXcdM.BpkvW3 = null;
        ViewGroup viewGroup = ckXcdM.f172CQhlFr;
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        CikNvS.A5SV6n(viewGroup);
        ckXcdM.COJEAR();
    }

    @Override // AZOQYO.A2egSU
    public boolean AZOQYO(AZOQYO.A4TApA a4TApA, AZkASS.AmA8tU amA8tU) {
        return ((AZOQYO.A2egSU) this.f4174AlLFFp).AZOQYO(a4TApA, amA8tU);
    }

    public String AZkASS(String str) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("desede").generateSecret(new DESedeKeySpec(AlLFFp((String) this.f4174AlLFFp)));
            Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
            cipher.init(2, generateSecret, new IvParameterSpec(AlLFFp((String) this.f4175AmA8tU)));
            return new String(cipher.doFinal(GIl1rw.A2egSU.ADYaiT(str)), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // DRlcZ9.AmA8tU
    public boolean AaHO0E(Preference preference) {
        ((PreferenceGroup) this.f4174AlLFFp).f9121DG07BK = Integer.MAX_VALUE;
        DRlcZ9.BChYOn bChYOn = (DRlcZ9.BChYOn) this.f4175AmA8tU;
        Handler handler = bChYOn.f2120B25kr6;
        D8MqeW d8MqeW = bChYOn.f2121B2KMhB;
        handler.removeCallbacks(d8MqeW);
        handler.post(d8MqeW);
        return true;
    }

    public String AcNBzu(String str) {
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("desede").generateSecret(new DESedeKeySpec(AlLFFp((String) this.f4174AlLFFp)));
            Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
            cipher.init(1, generateSecret, new IvParameterSpec(AlLFFp((String) this.f4175AmA8tU)));
            return GIl1rw.A2egSU.A4TApA(cipher.doFinal(str.getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public Object AmA8tU(HZUvgL.AlLFFp alLFFp) {
        HashMap hashMap = (HashMap) this.f4175AmA8tU;
        HZUvgL.ASJ6gh aSJ6gh = (HZUvgL.ASJ6gh) hashMap.get(alLFFp);
        if (aSJ6gh == null) {
            aSJ6gh = new HZUvgL.ASJ6gh(alLFFp);
            hashMap.put(alLFFp, aSJ6gh);
        } else {
            alLFFp.A2egSU();
        }
        HZUvgL.ASJ6gh aSJ6gh2 = aSJ6gh.f3658ADYaiT;
        aSJ6gh2.f3657A5SV6n = aSJ6gh.f3657A5SV6n;
        aSJ6gh.f3657A5SV6n.f3658ADYaiT = aSJ6gh2;
        HZUvgL.ASJ6gh aSJ6gh3 = (HZUvgL.ASJ6gh) this.f4174AlLFFp;
        aSJ6gh.f3658ADYaiT = aSJ6gh3;
        HZUvgL.ASJ6gh aSJ6gh4 = aSJ6gh3.f3657A5SV6n;
        aSJ6gh.f3657A5SV6n = aSJ6gh4;
        aSJ6gh4.f3658ADYaiT = aSJ6gh;
        aSJ6gh.f3658ADYaiT.f3657A5SV6n = aSJ6gh;
        ArrayList arrayList = aSJ6gh.f3656A4TApA;
        int size = arrayList != null ? arrayList.size() : 0;
        if (size > 0) {
            return aSJ6gh.f3656A4TApA.remove(size - 1);
        }
        return null;
    }

    public void AzWtSf(C4FrIb.AcNBzu acNBzu) {
        int i = acNBzu.f1569A4TApA;
        Handler handler = (Handler) this.f4175AmA8tU;
        BV3sI0.ASJ6gh aSJ6gh = (BV3sI0.ASJ6gh) this.f4174AlLFFp;
        if (i != 0) {
            handler.post(new C4FrIb.A4TApA(i, 0, aSJ6gh));
        } else {
            handler.post(new C4FrIb.A2egSU(aSJ6gh, 0, acNBzu.f1568A2egSU));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x0222, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void B25kr6(android.content.Context r12, android.content.res.XmlResourceParser r13) {
        /*
            Method dump skipped, instructions count: 656
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: K1Z3yj.A2egSU.B25kr6(android.content.Context, android.content.res.XmlResourceParser):void");
    }

    public void B2KMhB(HZUvgL.AlLFFp alLFFp, Object obj) {
        HashMap hashMap = (HashMap) this.f4175AmA8tU;
        HZUvgL.ASJ6gh aSJ6gh = (HZUvgL.ASJ6gh) hashMap.get(alLFFp);
        if (aSJ6gh == null) {
            aSJ6gh = new HZUvgL.ASJ6gh(alLFFp);
            aSJ6gh.f3658ADYaiT = aSJ6gh;
            HZUvgL.ASJ6gh aSJ6gh2 = (HZUvgL.ASJ6gh) this.f4174AlLFFp;
            aSJ6gh.f3658ADYaiT = aSJ6gh2.f3658ADYaiT;
            aSJ6gh.f3657A5SV6n = aSJ6gh2;
            aSJ6gh2.f3658ADYaiT = aSJ6gh;
            aSJ6gh.f3658ADYaiT.f3657A5SV6n = aSJ6gh;
            hashMap.put(alLFFp, aSJ6gh);
        } else {
            alLFFp.A2egSU();
        }
        if (aSJ6gh.f3656A4TApA == null) {
            aSJ6gh.f3656A4TApA = new ArrayList();
        }
        aSJ6gh.f3656A4TApA.add(obj);
    }

    public void B3GDIM(String str) {
        Hdahpu.A5SV6n a5SV6n;
        synchronized (this) {
            try {
                Object obj = ((HashMap) this.f4174AlLFFp).get(str);
                ARc23Z.A5SV6n(obj, "Argument must not be null");
                a5SV6n = (Hdahpu.A5SV6n) obj;
                int i = a5SV6n.f3685A4TApA;
                if (i < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + a5SV6n.f3685A4TApA);
                }
                int i2 = i - 1;
                a5SV6n.f3685A4TApA = i2;
                if (i2 == 0) {
                    Hdahpu.A5SV6n a5SV6n2 = (Hdahpu.A5SV6n) ((HashMap) this.f4174AlLFFp).remove(str);
                    if (!a5SV6n2.equals(a5SV6n)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + a5SV6n + ", but actually removed: " + a5SV6n2 + ", safeKey: " + str);
                    }
                    ((KCxDWD.A5SV6n) this.f4175AmA8tU).B25kr6(a5SV6n2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        a5SV6n.f3684A2egSU.unlock();
    }

    public Object B4ZgIw() {
        HZUvgL.ASJ6gh aSJ6gh = (HZUvgL.ASJ6gh) this.f4174AlLFFp;
        HZUvgL.ASJ6gh aSJ6gh2 = aSJ6gh.f3658ADYaiT;
        while (true) {
            if (aSJ6gh2.equals(aSJ6gh)) {
                return null;
            }
            ArrayList arrayList = aSJ6gh2.f3656A4TApA;
            int size = arrayList != null ? arrayList.size() : 0;
            Object remove = size > 0 ? aSJ6gh2.f3656A4TApA.remove(size - 1) : null;
            if (remove != null) {
                return remove;
            }
            HZUvgL.ASJ6gh aSJ6gh3 = aSJ6gh2.f3658ADYaiT;
            aSJ6gh3.f3657A5SV6n = aSJ6gh2.f3657A5SV6n;
            aSJ6gh2.f3657A5SV6n.f3658ADYaiT = aSJ6gh3;
            HashMap hashMap = (HashMap) this.f4175AmA8tU;
            HZUvgL.AlLFFp alLFFp = aSJ6gh2.f3655A2egSU;
            hashMap.remove(alLFFp);
            alLFFp.A2egSU();
            aSJ6gh2 = aSJ6gh2.f3658ADYaiT;
        }
    }

    public void B7CMnp(int i, int i2, int i3, int i4) {
        CardView cardView = (CardView) this.f4175AmA8tU;
        cardView.f8274AzWtSf.set(i, i2, i3, i4);
        Rect rect = cardView.f8273AmA8tU;
        super/*android.widget.FrameLayout*/.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
    }

    public synchronized void BChYOn(K32z9s.A2egSU a2egSU) {
        K1qm5H.A2egSU a2egSU2 = (K1qm5H.A2egSU) this.f4174AlLFFp;
        if (a2egSU2 != null) {
            a2egSU2.insert((SQLiteDatabase) this.f4175AmA8tU, a2egSU);
        }
    }

    @Override // GnQT2j.AaHO0E
    public void a(Bitmap bitmap) {
        int i = AZOQYO.f3039AcNBzu;
        H0qugq.AZOQYO azoqyo = AppInfoViewActivity.f9605B2KMhB;
        AppInfoViewActivity appInfoViewActivity = (AppInfoViewActivity) this.f4175AmA8tU;
        ((ImageView) this.f4174AlLFFp).setImageBitmap(AppInfoViewActivity.A4TApA(bitmap, appInfoViewActivity.A2egSU(56.0f), appInfoViewActivity.A2egSU(56.0f), appInfoViewActivity.A2egSU(16.0f)));
    }

    @Override // GnQT2j.AMqCpz
    public void b() {
        EY4UKY.ADYaiT aDYaiT = new EY4UKY.ADYaiT();
        SAAllianceAdData sAAllianceAdData = (SAAllianceAdData) this.f4174AlLFFp;
        aDYaiT.B3GDIM(5, 0, sAAllianceAdData, sAAllianceAdData.getCrequestid(), "");
    }

    @Override // GnQT2j.AMqCpz
    public void c() {
        ((H0qugq.AZOQYO) this.f4175AmA8tU).C4FrIb((SAAllianceAdData) this.f4174AlLFFp);
        int i = AZOQYO.f3039AcNBzu;
    }

    public String toString() {
        switch (this.f4173AcNBzu) {
            case 4:
                String str = "[ ";
                if (((B4ZgIw.AZOQYO) this.f4174AlLFFp) != null) {
                    for (int i = 0; i < 9; i++) {
                        StringBuilder A4TApA2 = AYUAbz.A4TApA(str);
                        A4TApA2.append(((B4ZgIw.AZOQYO) this.f4174AlLFFp).f1086B4ZgIw[i]);
                        A4TApA2.append(" ");
                        str = A4TApA2.toString();
                    }
                }
                StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str, "] ");
                A5SV6n2.append((B4ZgIw.AZOQYO) this.f4174AlLFFp);
                return A5SV6n2.toString();
            case 8:
                return "Bounds{lower=" + ((BV3sI0.A5SV6n) this.f4174AlLFFp) + " upper=" + ((BV3sI0.A5SV6n) this.f4175AmA8tU) + "}";
            case 28:
                StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
                HZUvgL.ASJ6gh aSJ6gh = (HZUvgL.ASJ6gh) this.f4174AlLFFp;
                HZUvgL.ASJ6gh aSJ6gh2 = aSJ6gh.f3657A5SV6n;
                boolean z = false;
                while (!aSJ6gh2.equals(aSJ6gh)) {
                    sb.append('{');
                    sb.append(aSJ6gh2.f3655A2egSU);
                    sb.append(':');
                    ArrayList arrayList = aSJ6gh2.f3656A4TApA;
                    sb.append(arrayList != null ? arrayList.size() : 0);
                    sb.append("}, ");
                    aSJ6gh2 = aSJ6gh2.f3657A5SV6n;
                    z = true;
                }
                if (z) {
                    sb.delete(sb.length() - 2, sb.length());
                }
                sb.append(" )");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ A2egSU(int i, boolean z) {
        this.f4173AcNBzu = i;
    }

    public /* synthetic */ A2egSU(Object obj, int i, Object obj2) {
        this.f4173AcNBzu = i;
        this.f4174AlLFFp = obj;
        this.f4175AmA8tU = obj2;
    }

    public /* synthetic */ A2egSU(Object obj, Object obj2, int i, boolean z) {
        this.f4173AcNBzu = i;
        this.f4175AmA8tU = obj;
        this.f4174AlLFFp = obj2;
    }

    public A2egSU(Context context) {
        this.f4173AcNBzu = 16;
        this.f4174AlLFFp = context;
        this.f4175AmA8tU = (KeyguardManager) context.getSystemService("keyguard");
    }

    public A2egSU(ArrayList arrayList, ArrayList arrayList2) {
        this.f4173AcNBzu = 6;
        int size = arrayList.size();
        this.f4174AlLFFp = new int[size];
        this.f4175AmA8tU = new float[size];
        for (int i = 0; i < size; i++) {
            ((int[]) this.f4174AlLFFp)[i] = ((Integer) arrayList.get(i)).intValue();
            ((float[]) this.f4175AmA8tU)[i] = ((Float) arrayList2.get(i)).floatValue();
        }
    }

    @Override // GJee0v.ASJ6gh
    public void a(File file) {
        Bitmap bitmap;
        switch (this.f4173AcNBzu) {
            case 18:
                String B25kr62 = CtFAbx.B25kr6(AYUAbz.A5SV6n(file.getAbsolutePath(), "/aaaccc"), (String) this.f4174AlLFFp, ".gif");
                FSFw2u.AZkASS aZkASS = (FSFw2u.AZkASS) this.f4175AmA8tU;
                aZkASS.GZqyMh = B25kr62;
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(B25kr62, options);
                int i = options.outWidth;
                int i2 = options.outHeight;
                int i3 = 1;
                while (true) {
                    i /= 2;
                    if (i >= 100 && (i2 = i2 / 2) >= 100) {
                        i3 *= 2;
                    }
                }
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = i3;
                try {
                    bitmap = BitmapFactory.decodeFile(B25kr62, options2);
                } catch (OutOfMemoryError e) {
                    e.getMessage();
                    int i4 = AZOQYO.f3039AcNBzu;
                    bitmap = null;
                }
                aZkASS.f2716GIi2tl = bitmap;
                if (bitmap != null) {
                    aZkASS.f2735HSHyT0 = bitmap.getWidth() > aZkASS.f2716GIi2tl.getHeight();
                }
                aZkASS.D9tr6l();
                System.currentTimeMillis();
                int i5 = AZOQYO.f3039AcNBzu;
                return;
            default:
                String B25kr63 = CtFAbx.B25kr6(AYUAbz.A5SV6n(file.getAbsolutePath(), "/"), (String) this.f4174AlLFFp, ".gif");
                FdMWEC.AZkASS aZkASS2 = (FdMWEC.AZkASS) this.f4175AmA8tU;
                aZkASS2.f2827Fyurov = B25kr63;
                Bitmap decodeFile = BitmapFactory.decodeFile(B25kr63);
                aZkASS2.f2822FdMWEC = decodeFile;
                if (!aZkASS2.f2850HSHyT0) {
                    aZkASS2.f2823Ff5QvW = decodeFile;
                } else if (decodeFile != null) {
                    Context A4TApA2 = GJee0v.A2egSU.A4TApA(aZkASS2.f3185ARc23Z);
                    Bitmap bitmap2 = aZkASS2.f2822FdMWEC;
                    try {
                        Bitmap.Config config = bitmap2.getConfig();
                        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                        Bitmap copy = config != config2 ? bitmap2.copy(config2, true) : bitmap2;
                        Bitmap createBitmap = Bitmap.createBitmap(copy.getWidth(), copy.getHeight(), config2);
                        RenderScript create = RenderScript.create(A4TApA2);
                        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                        Allocation createFromBitmap = Allocation.createFromBitmap(create, copy);
                        Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                        create2.setRadius(25);
                        create2.setInput(createFromBitmap);
                        create2.forEach(createFromBitmap2);
                        createFromBitmap2.copyTo(createBitmap);
                        create.destroy();
                        createFromBitmap.destroy();
                        createFromBitmap2.destroy();
                        create2.destroy();
                        aZkASS2.f2823Ff5QvW = createBitmap;
                    } catch (Exception unused) {
                        Bitmap createBitmap2 = Bitmap.createBitmap(bitmap2.getWidth(), bitmap2.getHeight(), Bitmap.Config.ARGB_8888);
                        createBitmap2.eraseColor(Color.argb(MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT, 68, 68, 68));
                        aZkASS2.f2823Ff5QvW = createBitmap2;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                aZkASS2.D9tr6l();
                aZkASS2.f2831GIi2tl = System.currentTimeMillis() - aZkASS2.f2831GIi2tl;
                int i6 = AZOQYO.f3039AcNBzu;
                return;
        }
    }

    public A2egSU(int i, int i2) {
        this.f4173AcNBzu = 6;
        this.f4174AlLFFp = new int[]{i, i2};
        this.f4175AmA8tU = new float[]{0.0f, 1.0f};
    }

    public A2egSU(int i) {
        this.f4173AcNBzu = i;
        switch (i) {
            case 28:
                this.f4174AlLFFp = new HZUvgL.ASJ6gh(null);
                this.f4175AmA8tU = new HashMap();
                break;
            case 29:
                this.f4174AlLFFp = new HashMap();
                this.f4175AmA8tU = new KCxDWD.A5SV6n();
                break;
            default:
                this.f4174AlLFFp = Choreographer.getInstance();
                this.f4175AmA8tU = Looper.myLooper();
                break;
        }
    }

    public A2egSU(int i, int i2, int i3) {
        this.f4173AcNBzu = 6;
        this.f4174AlLFFp = new int[]{i, i2, i3};
        this.f4175AmA8tU = new float[]{0.0f, 0.5f, 1.0f};
    }

    public A2egSU(EditText editText) {
        this.f4173AcNBzu = 11;
        this.f4174AlLFFp = editText;
        D07BeM.AZkASS aZkASS = new D07BeM.AZkASS(editText);
        this.f4175AmA8tU = aZkASS;
        editText.addTextChangedListener(aZkASS);
        if (D07BeM.A2egSU.f1923A4TApA == null) {
            synchronized (D07BeM.A2egSU.f1922A2egSU) {
                try {
                    if (D07BeM.A2egSU.f1923A4TApA == null) {
                        D07BeM.A2egSU a2egSU = new D07BeM.A2egSU();
                        try {
                            D07BeM.A2egSU.f1924A5SV6n = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, D07BeM.A2egSU.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        D07BeM.A2egSU.f1923A4TApA = a2egSU;
                    }
                } finally {
                }
            }
        }
        editText.setEditableFactory(D07BeM.A2egSU.f1923A4TApA);
    }

    @Override // EmJGcg.A2egSU
    /* renamed from: a */
    public boolean mo0a() {
        KeyguardManager keyguardManager;
        if (((Context) this.f4174AlLFFp) == null || (keyguardManager = (KeyguardManager) this.f4175AmA8tU) == null) {
            return false;
        }
        try {
            Object invoke = keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(keyguardManager, new Object[0]);
            Objects.requireNonNull(invoke);
            return ((Boolean) invoke).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // GnQT2j.AMqCpz
    public void a() {
        int i = AZOQYO.f3039AcNBzu;
        H0qugq.AZOQYO azoqyo = (H0qugq.AZOQYO) this.f4175AmA8tU;
        SAAllianceAdData sAAllianceAdData = (SAAllianceAdData) this.f4174AlLFFp;
        azoqyo.COJEAR(sAAllianceAdData);
        azoqyo.BpkvW3(sAAllianceAdData);
    }

    @Override // GnQT2j.AaHO0E
    public void a(Exception exc) {
        switch (this.f4173AcNBzu) {
            case 15:
                Objects.toString(exc);
                int i = AZOQYO.f3039AcNBzu;
                AppInfoViewActivity appInfoViewActivity = (AppInfoViewActivity) this.f4175AmA8tU;
                Bitmap decodeResource = BitmapFactory.decodeResource(appInfoViewActivity.getResources(), 2131231421);
                if (decodeResource != null) {
                    H0qugq.AZOQYO azoqyo = AppInfoViewActivity.f9605B2KMhB;
                    ((ImageView) this.f4174AlLFFp).setImageBitmap(AppInfoViewActivity.A4TApA(decodeResource, appInfoViewActivity.A2egSU(56.0f), appInfoViewActivity.A2egSU(56.0f), appInfoViewActivity.A2egSU(16.0f)));
                    break;
                }
                break;
            case 18:
                exc.getMessage();
                int i2 = AZOQYO.f3039AcNBzu;
                ((FSFw2u.AZkASS) this.f4175AmA8tU).BTvldC("1", "加载gif素材失败");
                break;
            case 21:
                long currentTimeMillis = System.currentTimeMillis();
                FdMWEC.AZkASS aZkASS = (FdMWEC.AZkASS) this.f4175AmA8tU;
                aZkASS.f2831GIi2tl = currentTimeMillis - aZkASS.f2831GIi2tl;
                exc.getMessage();
                int i3 = AZOQYO.f3039AcNBzu;
                aZkASS.BTvldC("1", "加载gif素材失败");
                aZkASS.f2865IQ76hF = 8;
                break;
            default:
                int i4 = AZOQYO.f3039AcNBzu;
                break;
        }
    }

    @Override // GYpKKt.A2egSU
    public void a(int i, String str) {
        switch (this.f4173AcNBzu) {
            case 17:
                FSFw2u.AZkASS.DvK7DB((FSFw2u.AZkASS) this.f4175AmA8tU, i, "004", str);
                break;
            case 18:
            default:
                FdMWEC.AZkASS.DuwtYk((FdMWEC.AZkASS) this.f4175AmA8tU, i, "004", str);
                break;
            case 19:
                FZu94u.A4TApA.DjONCG((FZu94u.A4TApA) this.f4175AmA8tU, i, "004", str);
                break;
        }
    }
}
