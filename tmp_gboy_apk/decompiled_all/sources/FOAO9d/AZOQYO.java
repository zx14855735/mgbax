package FOAO9d;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alliance.ssp.ad.bean.SAAllianceAdData;
import com.alliance.ssp.ad.bean.SAAllianceEngineData;
import java.util.List;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO implements GYpKKt.A2egSU, GnQT2j.AaHO0E {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2590AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Context f2591AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ AcNBzu f2592AmA8tU;

    public /* synthetic */ AZOQYO(int i, AcNBzu acNBzu, Context context) {
        this.f2590AcNBzu = i;
        this.f2592AmA8tU = acNBzu;
        this.f2591AlLFFp = context;
    }

    @Override // GYpKKt.A2egSU
    public void AMqCpz(Object obj) {
        Context context = this.f2591AlLFFp;
        SAAllianceEngineData sAAllianceEngineData = (SAAllianceEngineData) obj;
        AcNBzu acNBzu = this.f2592AmA8tU;
        if (sAAllianceEngineData == null) {
            AcNBzu.DvK7DB(acNBzu, 8193, "002", "无广告填充，请联系技术进行排查。");
            return;
        }
        try {
            List<SAAllianceAdData> data = sAAllianceEngineData.getData();
            if (data == null) {
                AcNBzu.DvK7DB(acNBzu, sAAllianceEngineData.getCode(), "001", sAAllianceEngineData.getMessage());
                return;
            }
            if (data.size() > 0 && sAAllianceEngineData.getData() != null && !sAAllianceEngineData.getData().isEmpty()) {
                for (SAAllianceAdData sAAllianceAdData : data) {
                    if (sAAllianceAdData.getLoadtype() == 1) {
                        acNBzu.AmA8tU(8195, "001", "广告渲染方式和代码位ID类型不符，请联系运营排查。");
                        com.bumptech.glide.A5SV6n.ARc23Z();
                        ASJ6gh aSJ6gh = acNBzu.f2642HPJABZ;
                        if (aSJ6gh != null) {
                            aSJ6gh.removeCallbacksAndMessages(null);
                            acNBzu.f2642HPJABZ = null;
                            return;
                        }
                        return;
                    }
                    H0qugq.AcNBzu acNBzu2 = acNBzu.f3207BTvldC;
                    long cacheTimeout = sAAllianceAdData.getCacheTimeout();
                    acNBzu2.getClass();
                    sAAllianceAdData.setDeadlineTime(H0qugq.AcNBzu.A4TApA(cacheTimeout));
                    H0qugq.AcNBzu acNBzu3 = acNBzu.f3207BTvldC;
                    String price = sAAllianceAdData.getPrice();
                    acNBzu3.getClass();
                    sAAllianceAdData.setPriceD(H0qugq.AcNBzu.A2egSU(price));
                    if (acNBzu.f3207BTvldC != null) {
                        H0qugq.AcNBzu.ARc23Z(context, acNBzu.f2628GTPRn3, sAAllianceAdData.getWaitLoadTimeout());
                        if (sAAllianceAdData.isNeedCache()) {
                            sAAllianceAdData.setRequestid(acNBzu.f3200B9tovu);
                            acNBzu.f3207BTvldC.AMqCpz(context, sAAllianceAdData, acNBzu.f2628GTPRn3);
                        }
                    }
                    if (!acNBzu.f2645HXc4pW) {
                        ASJ6gh aSJ6gh2 = acNBzu.f2642HPJABZ;
                        if (aSJ6gh2 != null) {
                            aSJ6gh2.removeCallbacksAndMessages(null);
                            acNBzu.f2642HPJABZ = null;
                        }
                        AcNBzu.DyaChj(acNBzu, acNBzu.f2643HSHyT0, sAAllianceAdData);
                    }
                }
                return;
            }
            AcNBzu.DvK7DB(acNBzu, sAAllianceEngineData.getCode(), "003", sAAllianceEngineData.getMessage());
        } catch (Exception e) {
            e.toString();
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            CtFAbx.B4ZgIw(e, JrXYwF.A4TApA.AMqCpz("NMExpressFeedAdImpl 001: "), new EY4UKY.ADYaiT(), "004", e);
            acNBzu.AmA8tU(8194, "001", "渲染失败。");
            com.bumptech.glide.A5SV6n.ARc23Z();
        }
    }

    @Override // GnQT2j.AaHO0E
    public void a(Bitmap bitmap) {
        GIi2tl.A2egSU a2egSU;
        FrameLayout frameLayout;
        AcNBzu acNBzu = this.f2592AmA8tU;
        Context context = this.f2591AlLFFp;
        switch (this.f2590AcNBzu) {
            case 1:
                int i = GJee0v.AZOQYO.f3039AcNBzu;
                ImageView imageView = new ImageView(context);
                imageView.setImageBitmap(bitmap);
                acNBzu.D9tr6l();
                if (acNBzu.f2601EicXu4 != 4) {
                    if (acNBzu.f2630GcSJYy == null) {
                        if (acNBzu.f2607F1loUV.f2671A5SV6n != 40) {
                            acNBzu.DuwtYk(3, null, 200002, "模板信息流布局加载失败");
                        }
                        acNBzu.BTvldC("1", "布局失败");
                        break;
                    } else {
                        if (acNBzu.GZqyMh != null) {
                            acNBzu.GZqyMh.ADYaiT(acNBzu.f2630GcSJYy, bitmap.copy(bitmap.getConfig(), true));
                        }
                        acNBzu.f2630GcSJYy.addView(imageView);
                        acNBzu.EPdU4G(acNBzu.f2630GcSJYy);
                        if (!((String) acNBzu.f2629GYpKKt.get(0)).endsWith(".gif") && (a2egSU = acNBzu.GZqyMh) != null && (frameLayout = a2egSU.f3011B7CMnp) != null) {
                            acNBzu.f2630GcSJYy.addView(frameLayout);
                        }
                        acNBzu.f2669J3EcKw = 2;
                        acNBzu.G2rdQT = true;
                        if (acNBzu.G16Pvp) {
                            acNBzu.DuwtYk(4, acNBzu.f2608F32kj0, 0, null);
                            break;
                        }
                    }
                } else if (acNBzu.f2631GhvxjZ.get(0) == null) {
                    if (acNBzu.f2607F1loUV.f2671A5SV6n != 40) {
                        acNBzu.DuwtYk(3, null, 200002, "模板信息流多图布局加载失败");
                    }
                    acNBzu.BTvldC("1", "多图布局失败");
                    break;
                } else {
                    if (acNBzu.GZqyMh != null) {
                        acNBzu.GZqyMh.ADYaiT((View) acNBzu.f2631GhvxjZ.get(0), bitmap.copy(bitmap.getConfig(), true));
                    }
                    ((ViewGroup) acNBzu.f2631GhvxjZ.get(0)).addView(imageView);
                    acNBzu.f2669J3EcKw = 2;
                    acNBzu.G2rdQT = true;
                    if (acNBzu.G16Pvp) {
                        acNBzu.DuwtYk(4, acNBzu.f2608F32kj0, 0, null);
                        break;
                    }
                }
                break;
            default:
                int i2 = GJee0v.AZOQYO.f3039AcNBzu;
                acNBzu.f2635H1wUHe = AcNBzu.Dphsd2(acNBzu, bitmap, com.bumptech.glide.A5SV6n.A2egSU(context, 56.0f), com.bumptech.glide.A5SV6n.A2egSU(context, 56.0f), com.bumptech.glide.A5SV6n.A2egSU(context, 8.0f));
                break;
        }
    }

    @Override // GnQT2j.AaHO0E
    public void a(Exception exc) {
        switch (this.f2590AcNBzu) {
            case 1:
                Objects.toString(exc);
                int i = GJee0v.AZOQYO.f3039AcNBzu;
                AcNBzu acNBzu = this.f2592AmA8tU;
                if (acNBzu.f2607F1loUV.f2671A5SV6n != 40) {
                    acNBzu.DuwtYk(3, null, 200002, "模板信息流图片素材加载失败");
                }
                acNBzu.BTvldC("1", "加载素材失败");
                break;
            default:
                Objects.toString(exc);
                int i2 = GJee0v.AZOQYO.f3039AcNBzu;
                break;
        }
    }

    @Override // GYpKKt.A2egSU
    public void a(int i, String str) {
        AcNBzu.DvK7DB(this.f2592AmA8tU, i, "004", str);
    }
}
