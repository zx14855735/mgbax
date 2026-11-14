package I3HV03;

import COJEAR.DG07BK;
import COJEAR.EdQ5bb;
import COJEAR.EmJGcg;
import COJEAR.FG7pZc;
import MOpbMP.CmUvjW;
import Oay4Bh.CQhlFr;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.EdhSi6;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.game.boy.MyApp;
import com.game.boy.activity.EmulatorActivity;
import com.game.boy.activity.PackageActivity;
import com.game.boy.service.FileService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.imageview.ShapeableImageView;
import com.sigmob.sdk.base.mta.PointParamKey;
import io.dcloud.ads.core.v2.feed.DCFeedAd;
import io.dcloud.ads.core.v2.feed.DCFeedAdListener;
import io.dcloud.ads.core.v2.reward.DCRewardAd;
import io.dcloud.ads.core.v2.reward.DCRewardAdLoadListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA implements HSHyT0.B2KMhB, B3GDIM, LXWm8h.A2egSU, LlW7FF.AMqCpz, DCRewardAdLoadListener, DCFeedAdListener, COJEAR.BNL6CD, androidx.emoji2.text.B3GDIM, com.game.boy.activity.BTvldC {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public static A4TApA f3806AzWtSf;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f3807AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object f3808AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Object f3809AmA8tU;

    public /* synthetic */ A4TApA(int i) {
        this.f3807AcNBzu = i;
    }

    public static Rect AMqCpz(String str) {
        String[] split = str.split(",");
        return new Rect(Integer.parseInt(split[0].trim()), Integer.parseInt(split[1].trim()), Integer.parseInt(split[2].trim()), Integer.parseInt(split[3].trim()));
    }

    public static String AmA8tU() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                String name = nextElement.getName();
                if (name != null && (name.startsWith("wlan") || name.startsWith(IAdInterListener.AdReqParam.AP))) {
                    Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if ((nextElement2 instanceof Inet4Address) && !nextElement2.isLoopbackAddress()) {
                            return nextElement2.getHostAddress();
                        }
                    }
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private final void B9tovu(String str) {
    }

    private final void BChYOn(String str) {
    }

    @Override // com.game.boy.activity.BTvldC
    public void A2egSU(ADYaiT.AmA8tU amA8tU) {
        EmulatorActivity emulatorActivity = (EmulatorActivity) this.f3809AmA8tU;
        emulatorActivity.f11015CSDoyG = EmulatorActivity.B25kr6(emulatorActivity);
        EmulatorActivity.B2KMhB(emulatorActivity, "wifi_server");
        KpHwm4.B25kr6 b25kr6 = emulatorActivity.f11015CSDoyG;
        b25kr6.AMqCpz = true;
        b25kr6.f4354ARc23Z = false;
        b25kr6.ASJ6gh(new KpHwm4.A2egSU(b25kr6, b25kr6, (ServerSocket) this.f3808AlLFFp));
    }

    @Override // HSHyT0.B2KMhB
    public int A4TApA(HSHyT0.AmA8tU amA8tU) {
        return 2;
    }

    @Override // I3HV03.B3GDIM
    public void A5SV6n(HZUvgL.ADYaiT aDYaiT, Bitmap bitmap) {
        IOException iOException = ((ItGa5w.AMqCpz) this.f3809AmA8tU).f4078AlLFFp;
        if (iOException != null) {
            if (bitmap == null) {
                throw iOException;
            }
            aDYaiT.A4TApA(bitmap);
            throw iOException;
        }
    }

    @Override // I3HV03.B3GDIM
    public void ADYaiT() {
        BPw6Q8 bPw6Q8 = (BPw6Q8) this.f3808AlLFFp;
        synchronized (bPw6Q8) {
            bPw6Q8.f3860AmA8tU = bPw6Q8.f3858AcNBzu.length;
        }
    }

    @Override // LlW7FF.AMqCpz
    public void ARc23Z(String str) {
        int i = this.f3807AcNBzu;
    }

    @Override // HSHyT0.A4TApA
    public boolean ASJ6gh(Object obj, File file, HSHyT0.AmA8tU amA8tU) {
        return ((A5SV6n) this.f3809AmA8tU).ASJ6gh(new ARc23Z((HZUvgL.ADYaiT) this.f3808AlLFFp, ((BitmapDrawable) ((HXc4pW.BTvldC) obj).get()).getBitmap()), file, amA8tU);
    }

    @Override // androidx.emoji2.text.B3GDIM
    public boolean AYUAbz(CharSequence charSequence, int i, int i2, androidx.emoji2.text.BNL6CD bnl6cd) {
        if ((bnl6cd.f8690A5SV6n & 4) > 0) {
            return true;
        }
        if (((androidx.emoji2.text.BV3sI0) this.f3808AlLFFp) == null) {
            this.f3808AlLFFp = new androidx.emoji2.text.BV3sI0(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        ((androidx.emoji2.text.AZkASS) this.f3809AmA8tU).getClass();
        ((androidx.emoji2.text.BV3sI0) this.f3808AlLFFp).setSpan(new androidx.emoji2.text.BPw6Q8(bnl6cd), i, i2, 33);
        return true;
    }

    public void AZOQYO(String str, Object obj) {
        ArrayList arrayList = (ArrayList) this.f3808AlLFFp;
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(valueOf.length() + str.length() + 1);
        sb.append(str);
        sb.append("=");
        sb.append(valueOf);
        arrayList.add(sb.toString());
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    public Map AZkASS(int i, int i2, boolean z) {
        BufferedInputStream bufferedInputStream;
        File AaHO0E2 = AaHO0E(z);
        ?? exists = AaHO0E2.exists();
        HashMap hashMap = null;
        hashMap = null;
        hashMap = null;
        hashMap = null;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            if (exists != 0) {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(AaHO0E2));
                    try {
                        XmlPullParser newPullParser = Xml.newPullParser();
                        newPullParser.setInput(bufferedInputStream, "UTF-8");
                        HashMap hashMap2 = new HashMap();
                        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                            if (eventType == 2) {
                                if ("control".equals(newPullParser.getName())) {
                                    String attributeValue = newPullParser.getAttributeValue(null, PointParamKey.TYPE);
                                    String attributeValue2 = newPullParser.getAttributeValue(null, "bounds");
                                    if (attributeValue != null && attributeValue2 != null) {
                                        hashMap2.put(attributeValue, AMqCpz(attributeValue2));
                                    }
                                }
                            }
                        }
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        hashMap = hashMap2;
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (hashMap == null) {
                        }
                    }
                } catch (Exception e4) {
                    e = e4;
                    bufferedInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
            return (hashMap == null && hashMap.containsKey("video")) ? hashMap : ((Hdahpu.ASJ6gh) this.f3809AmA8tU).A2egSU(i, i2, z);
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = exists;
        }
    }

    public File AaHO0E(boolean z) {
        String str = z ? "landscape" : "portrait";
        return new File(KpHwm4.AYUAbz.A2egSU("config/layout"), Uri.encode((String) this.f3808AlLFFp) + "-" + str + ".xml");
    }

    public void AcNBzu() {
        int[] iArr = (int[]) this.f3808AlLFFp;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.f3809AmA8tU = null;
    }

    public void AlLFFp(int i) {
        int[] iArr = (int[]) this.f3808AlLFFp;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i, 10) + 1];
            this.f3808AlLFFp = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i >= iArr.length) {
            int length = iArr.length;
            while (length <= i) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.f3808AlLFFp = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = (int[]) this.f3808AlLFFp;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    public boolean AzWtSf(String str) {
        return ((SharedPreferences) this.f3808AlLFFp).getBoolean(str, false);
    }

    public String B25kr6(String str) {
        return ((SharedPreferences) this.f3808AlLFFp).getString(str, null);
    }

    public boolean B2KMhB() {
        return ((com.game.boy.activity.A5SV6n) this.f3808AlLFFp).getSharedPreferences("window_preferences", 0).getBoolean("edge_to_edge_enabled", Build.VERSION.SDK_INT >= 29);
    }

    @Override // COJEAR.BNL6CD
    public FG7pZc B3GDIM(View view, FG7pZc fG7pZc) {
        switch (this.f3807AcNBzu) {
            case 15:
                CQhlFr cQhlFr = new CQhlFr();
                CQhlFr cQhlFr2 = (CQhlFr) this.f3809AmA8tU;
                cQhlFr.f6612A2egSU = cQhlFr2.f6612A2egSU;
                cQhlFr.f6613A4TApA = cQhlFr2.f6613A4TApA;
                cQhlFr.f6614A5SV6n = cQhlFr2.f6614A5SV6n;
                cQhlFr.f6615ADYaiT = cQhlFr2.f6615ADYaiT;
                return ((Oay4Bh.COJEAR) this.f3808AlLFFp).AZOQYO(view, fG7pZc, cQhlFr);
            default:
                FG7pZc AmA8tU2 = DG07BK.AmA8tU(view, fG7pZc);
                if (AmA8tU2.f1747A2egSU.AlLFFp()) {
                    return AmA8tU2;
                }
                int A4TApA2 = AmA8tU2.A4TApA();
                Rect rect = (Rect) this.f3808AlLFFp;
                rect.left = A4TApA2;
                rect.top = AmA8tU2.ADYaiT();
                rect.right = AmA8tU2.A5SV6n();
                rect.bottom = AmA8tU2.A2egSU();
                androidx.viewpager.widget.AlLFFp alLFFp = (androidx.viewpager.widget.AlLFFp) this.f3809AmA8tU;
                int childCount = alLFFp.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    FG7pZc A4TApA3 = DG07BK.A4TApA(alLFFp.getChildAt(i), AmA8tU2);
                    rect.left = Math.min(A4TApA3.A4TApA(), rect.left);
                    rect.top = Math.min(A4TApA3.ADYaiT(), rect.top);
                    rect.right = Math.min(A4TApA3.A5SV6n(), rect.right);
                    rect.bottom = Math.min(A4TApA3.A2egSU(), rect.bottom);
                }
                int i2 = rect.left;
                int i3 = rect.top;
                int i4 = rect.right;
                int i5 = rect.bottom;
                EdQ5bb edQ5bb = new EdQ5bb(AmA8tU2);
                BV3sI0.A5SV6n A4TApA4 = BV3sI0.A5SV6n.A4TApA(i2, i3, i4, i5);
                EmJGcg emJGcg = edQ5bb.f1721A2egSU;
                emJGcg.ASJ6gh(A4TApA4);
                return emJGcg.A4TApA();
        }
    }

    public void B4ZgIw(int i, int i2) {
        int[] iArr = (int[]) this.f3808AlLFFp;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i3 = i + i2;
        AlLFFp(i3);
        int[] iArr2 = (int[]) this.f3808AlLFFp;
        System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
        Arrays.fill((int[]) this.f3808AlLFFp, i, i3, -1);
        ArrayList arrayList = (ArrayList) this.f3809AmA8tU;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            EdhSi6 edhSi6 = (EdhSi6) ((ArrayList) this.f3809AmA8tU).get(size);
            int i4 = edhSi6.f9387AcNBzu;
            if (i4 >= i) {
                edhSi6.f9387AcNBzu = i4 + i2;
            }
        }
    }

    public void B7CMnp(int i, int i2) {
        int[] iArr = (int[]) this.f3808AlLFFp;
        if (iArr == null || i >= iArr.length) {
            return;
        }
        int i3 = i + i2;
        AlLFFp(i3);
        int[] iArr2 = (int[]) this.f3808AlLFFp;
        System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
        int[] iArr3 = (int[]) this.f3808AlLFFp;
        Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
        ArrayList arrayList = (ArrayList) this.f3809AmA8tU;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            EdhSi6 edhSi6 = (EdhSi6) ((ArrayList) this.f3809AmA8tU).get(size);
            int i4 = edhSi6.f9387AcNBzu;
            if (i4 >= i) {
                if (i4 < i3) {
                    ((ArrayList) this.f3809AmA8tU).remove(size);
                } else {
                    edhSi6.f9387AcNBzu = i4 - i2;
                }
            }
        }
    }

    public void BI9f7h(String str, boolean z) {
        ((SharedPreferences.Editor) this.f3809AmA8tU).putBoolean(str, z).apply();
    }

    public void BIYEnU(String str, int i) {
        ((SharedPreferences.Editor) this.f3809AmA8tU).putInt(str, i).apply();
    }

    public void BJ7GGh(String str, String str2) {
        ((SharedPreferences.Editor) this.f3809AmA8tU).putString(str, str2).apply();
    }

    public void BNL6CD(String str) {
        ((SharedPreferences.Editor) this.f3809AmA8tU).remove(str).apply();
    }

    @Override // androidx.emoji2.text.B3GDIM
    public Object getResult() {
        return (androidx.emoji2.text.BV3sI0) this.f3808AlLFFp;
    }

    @Override // io.dcloud.ads.core.v2.feed.DCFeedAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaao
    public void onClick() {
        MQlCFp.A5SV6n.AZkASS((MQlCFp.A5SV6n) this.f3809AmA8tU);
    }

    @Override // io.dcloud.ads.core.v2.feed.DCFeedAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaao
    public void onClosed(String str) {
        MQlCFp.A5SV6n.AZkASS((MQlCFp.A5SV6n) this.f3809AmA8tU);
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdLoadListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaacaaaa.aaaaaaa0
    public void onError(int i, String str, JSONArray jSONArray) {
        switch (this.f3807AcNBzu) {
            case 9:
                MyApp.A2egSU("错误: " + str);
                break;
            case 20:
                EmulatorActivity.B3GDIM((EmulatorActivity) this.f3809AmA8tU);
                break;
            default:
                MyApp.A2egSU(str);
                break;
        }
    }

    @Override // io.dcloud.ads.core.v2.feed.DCFeedAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaao
    public void onRenderFail() {
        MQlCFp.A5SV6n.AZkASS((MQlCFp.A5SV6n) this.f3809AmA8tU);
    }

    @Override // io.dcloud.ads.core.v2.feed.DCFeedAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaao
    public void onRenderSuccess() {
        View feedAdView;
        MQlCFp.A5SV6n a5SV6n = (MQlCFp.A5SV6n) this.f3809AmA8tU;
        if (!a5SV6n.isAdded() || a5SV6n.requireActivity() == null || a5SV6n.getActivity() == null || (feedAdView = ((DCFeedAd) this.f3808AlLFFp).getFeedAdView(a5SV6n.requireActivity())) == null) {
            return;
        }
        a5SV6n.f5143AzWtSf.removeAllViews();
        a5SV6n.f5143AzWtSf.addView(feedAdView);
        a5SV6n.f5143AzWtSf.setVisibility(0);
    }

    @Override // io.dcloud.ads.core.v2.reward.DCRewardAdLoadListener
    public void onRewardAdLoad() {
        switch (this.f3807AcNBzu) {
            case 9:
                ((DCRewardAd) this.f3808AlLFFp).show(((CmUvjW) this.f3809AmA8tU).requireActivity());
                break;
            case 20:
                ((DCRewardAd) this.f3808AlLFFp).show((EmulatorActivity) this.f3809AmA8tU);
                break;
            default:
                ((DCRewardAd) this.f3808AlLFFp).show(((com.game.boy.activity.B9tovu) this.f3809AmA8tU).f10915AcNBzu);
                break;
        }
    }

    @Override // io.dcloud.ads.core.v2.feed.DCFeedAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaao
    public void onShow() {
    }

    @Override // io.dcloud.ads.core.v2.feed.DCFeedAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaca.aaaaaaao
    public void onShowError() {
        MQlCFp.A5SV6n.AZkASS((MQlCFp.A5SV6n) this.f3809AmA8tU);
    }

    @Override // LlW7FF.AMqCpz
    public void onSuccess(Object obj) {
        switch (this.f3807AcNBzu) {
            case 8:
                MTKlkd.A2egSU a2egSU = (MTKlkd.A2egSU) obj;
                if (a2egSU.A5SV6n()) {
                    ((MOpbMP.B2KMhB) this.f3809AmA8tU).f5034B3GDIM.AlLFFp(a2egSU.A4TApA());
                    ((MaterialButton) this.f3808AlLFFp).post(new MOpbMP.A2egSU(this, 9, a2egSU));
                    break;
                }
                break;
            default:
                MTKlkd.A2egSU a2egSU2 = (MTKlkd.A2egSU) obj;
                if (!a2egSU2.A5SV6n()) {
                    MyApp.A2egSU(a2egSU2.A2egSU());
                    break;
                } else {
                    OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA((PackageActivity) this.f3809AmA8tU);
                    MTKlkd.ADYaiT aDYaiT = (MTKlkd.ADYaiT) this.f3808AlLFFp;
                    String AMqCpz = aDYaiT.AMqCpz();
                    ADYaiT.AZOQYO azoqyo = a4TApA.f81AcNBzu;
                    azoqyo.AMqCpz = AMqCpz;
                    azoqyo.f28ASJ6gh = Html.fromHtml(aDYaiT.A4TApA());
                    a4TApA.AzWtSf("支付", new M0ztbm.ADYaiT(this, 9, a2egSU2));
                    a4TApA.AcNBzu("取消订单", new MS6BTZ.ASJ6gh(3));
                    a4TApA.AMqCpz();
                    break;
                }
        }
    }

    public String toString() {
        switch (this.f3807AcNBzu) {
            case 13:
                StringBuilder sb = new StringBuilder(100);
                sb.append(((NUtxJj.A2egSU) this.f3809AmA8tU).getClass().getSimpleName());
                sb.append('{');
                ArrayList arrayList = (ArrayList) this.f3808AlLFFp;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append((String) arrayList.get(i));
                    if (i < size - 1) {
                        sb.append(", ");
                    }
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public A4TApA(NUtxJj.A2egSU a2egSU) {
        this.f3807AcNBzu = 13;
        this.f3809AmA8tU = a2egSU;
        this.f3808AlLFFp = new ArrayList();
    }

    public /* synthetic */ A4TApA(Object obj, int i, Object obj2) {
        this.f3807AcNBzu = i;
        this.f3808AlLFFp = obj;
        this.f3809AmA8tU = obj2;
    }

    public /* synthetic */ A4TApA(Object obj, Object obj2, int i, boolean z) {
        this.f3807AcNBzu = i;
        this.f3809AmA8tU = obj;
        this.f3808AlLFFp = obj2;
    }

    public A4TApA(com.game.boy.activity.A5SV6n a5SV6n) {
        this.f3807AcNBzu = 4;
        this.f3808AlLFFp = a5SV6n;
        this.f3809AmA8tU = new Hdahpu.AZOQYO(23);
    }

    public A4TApA(Context context) {
        this.f3807AcNBzu = 3;
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        this.f3808AlLFFp = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        this.f3809AmA8tU = edit;
        edit.apply();
    }

    public A4TApA(Context context, M0ztbm.A4TApA a4TApA, com.game.boy.activity.B3GDIM b3gdim) {
        String str;
        String str2;
        this.f3807AcNBzu = 7;
        this.f3809AmA8tU = a4TApA;
        View inflate = LayoutInflater.from(context).inflate(2131492950, (ViewGroup) null, false);
        ShapeableImageView shapeableImageView = (ShapeableImageView) inflate.findViewById(2131296756);
        String str3 = a4TApA.AMqCpz;
        if (str3 != null && !str3.isEmpty()) {
            L2suez.AZOQYO.A4TApA(context, a4TApA.AMqCpz, shapeableImageView);
        } else {
            shapeableImageView.setImageResource(2131689472);
        }
        TextView textView = (TextView) inflate.findViewById(2131298204);
        String str4 = a4TApA.f4961ADYaiT;
        textView.setText(str4 == null ? "未知玩家" : str4);
        TextView textView2 = (TextView) inflate.findViewById(2131298237);
        if (a4TApA.f4967AaHO0E == 1) {
            str = "该房间已开始，无法加入";
        } else {
            str = "邀请你加入房间";
        }
        textView2.setText(str);
        TextView textView3 = (TextView) inflate.findViewById(2131298230);
        String str5 = a4TApA.f4963ASJ6gh;
        if (str5 != null && !str5.isEmpty()) {
            textView3.setText(a4TApA.f4963ASJ6gh);
        } else {
            textView3.setText("未知房间");
        }
        Chip chip = (Chip) inflate.findViewById(2131296503);
        String str6 = a4TApA.f4962ARc23Z;
        if (str6 != null && !str6.isEmpty()) {
            chip.setText("房间 " + a4TApA.f4962ARc23Z);
        } else {
            chip.setVisibility(8);
        }
        Chip chip2 = (Chip) inflate.findViewById(2131296501);
        if (a4TApA.f4965AZOQYO == 0) {
            str2 = "UDP 联机";
        } else if (a4TApA.f4964AYUAbz == 1) {
            str2 = "多游戏兼容";
        } else {
            str2 = "标准联机";
        }
        chip2.setText(str2);
        OOnEhG.A4TApA a4TApA2 = new OOnEhG.A4TApA(context);
        a4TApA2.f81AcNBzu.f41B7CMnp = inflate;
        a4TApA2.ASJ6gh();
        a4TApA2.AcNBzu("拒绝", new M0ztbm.A2egSU(b3gdim, a4TApA, 1));
        a4TApA2.AzWtSf("同意", new M0ztbm.A2egSU(b3gdim, a4TApA, 0));
        this.f3808AlLFFp = a4TApA2.A2egSU();
    }

    public A4TApA(FileService fileService) {
        this.f3807AcNBzu = 5;
        this.f3808AlLFFp = (WifiManager) fileService.getApplicationContext().getSystemService("wifi");
    }

    public A4TApA(Context context, String str) {
        this.f3807AcNBzu = 3;
        if (str == null) {
            str = context.getPackageName() + "_preferences";
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        this.f3808AlLFFp = sharedPreferences;
        SharedPreferences.Editor edit = sharedPreferences.edit();
        this.f3809AmA8tU = edit;
        edit.apply();
    }

    public A4TApA(androidx.viewpager.widget.AlLFFp alLFFp) {
        this.f3807AcNBzu = 18;
        this.f3809AmA8tU = alLFFp;
        this.f3808AlLFFp = new Rect();
    }

    public A4TApA(OCUYV2.AcNBzu acNBzu, OCUYV2.AcNBzu acNBzu2) {
        this.f3807AcNBzu = 14;
        if (acNBzu.f6250A2egSU <= acNBzu2.f6250A2egSU) {
            this.f3808AlLFFp = acNBzu;
            this.f3809AmA8tU = acNBzu2;
            return;
        }
        throw new IllegalArgumentException();
    }
}
