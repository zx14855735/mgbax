package AZkASS;

import ADYaiT.CtFAbx;
import ADYaiT.D8MqeW;
import AaHO0E.DUi7mC;
import AaHO0E.FOAO9d;
import COJEAR.DG07BK;
import COJEAR.FG7pZc;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.ContentInfo;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.CTkVKb;
import androidx.lifecycle.CikNvS;
import androidx.lifecycle.CqNSpT;
import androidx.preference.Preference;
import androidx.viewpager2.widget.ViewPager2;
import com.game.boy.activity.WebViewActivity;
import com.game.boy.service.FileService;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Objects;
import java.util.WeakHashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ARc23Z implements FOAO9d, BJ7GGh, DUi7mC, AaHO0E.B3GDIM, COJEAR.BNL6CD, COJEAR.ASJ6gh, CqNSpT, CQhlFr.B7CMnp, Fyurov.AZkASS, Ixu71n.A2egSU, Hjvs0g.BIYEnU, Hjvs0g.A2egSU, I3HV03.AmA8tU, IQ76hF.AcNBzu, IsbtnO.A5SV6n, Callback, DRlcZ9.AmA8tU, N8W1LJ.AZOQYO {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f450AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object f451AlLFFp;

    public /* synthetic */ ARc23Z(int i) {
        this.f450AcNBzu = i;
    }

    public static File BChYOn(Context context) {
        String path = (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && context.getExternalCacheDir() != null) ? context.getExternalCacheDir().getPath() : context.getCacheDir().getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        return new File(CtFAbx.B25kr6(JrXYwF.A4TApA.AMqCpz(path), File.separator, "com.alliance.ssp.ad.image"));
    }

    public static void BIYEnU(ARc23Z aRc23Z, com.game.boy.activity.A5SV6n a5SV6n, String str, String str2) {
        aRc23Z.getClass();
        Intent intent = new Intent(a5SV6n, (Class<?>) WebViewActivity.class);
        intent.putExtra("extra_url", str);
        intent.putExtra("extra_title", str2);
        a5SV6n.startActivity(intent);
    }

    public static ARc23Z BJ7GGh(int i, int i2, int i3, boolean z) {
        return new ARc23Z(6, AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
    }

    @Override // AZkASS.BJ7GGh
    public void A2egSU(AmA8tU amA8tU, boolean z) {
        if (amA8tU instanceof BpkvW3) {
            ((BpkvW3) amA8tU).f591CQhlFr.AaHO0E().A5SV6n(false);
        }
        BJ7GGh bJ7GGh = ((AaHO0E.AzWtSf) this.f451AlLFFp).f436B25kr6;
        if (bJ7GGh != null) {
            bJ7GGh.A2egSU(amA8tU, z);
        }
    }

    @Override // androidx.lifecycle.CqNSpT
    public CikNvS A4TApA(Class cls) {
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    @Override // COJEAR.ASJ6gh
    public ClipData A5SV6n() {
        ClipData clip;
        clip = ((ContentInfo) this.f451AlLFFp).getClip();
        return clip;
    }

    @Override // CQhlFr.B7CMnp
    public boolean ADYaiT(View view) {
        int currentItem = ((ViewPager2) view).getCurrentItem() - 1;
        ViewPager2 viewPager2 = ((De4eam.AZkASS) this.f451AlLFFp).f2413ADYaiT;
        if (viewPager2.f9602BV3sI0) {
            viewPager2.A5SV6n(currentItem, true);
        }
        return true;
    }

    @Override // AZkASS.BJ7GGh
    public boolean AMqCpz(AmA8tU amA8tU) {
        AaHO0E.AzWtSf azWtSf = (AaHO0E.AzWtSf) this.f451AlLFFp;
        if (amA8tU == azWtSf.f434AmA8tU) {
            return false;
        }
        azWtSf.f625CNPG0E = ((BpkvW3) amA8tU).f592CSDoyG.f520AcNBzu;
        BJ7GGh bJ7GGh = azWtSf.f436B25kr6;
        if (bJ7GGh != null) {
            return bJ7GGh.AMqCpz(amA8tU);
        }
        return false;
    }

    @Override // Ixu71n.A2egSU
    public Object ARc23Z() {
        BTvldC.ADYaiT aDYaiT = (BTvldC.ADYaiT) this.f451AlLFFp;
        return new HXc4pW.AZkASS((HXc4pW.AmA8tU) aDYaiT.f1448AlLFFp, (ADYaiT.DUi7mC) aDYaiT.f1449AmA8tU);
    }

    @Override // I3HV03.AmA8tU
    public int ASJ6gh() {
        return (AcNBzu() << 8) | AcNBzu();
    }

    @Override // Hjvs0g.BIYEnU
    public Hjvs0g.BI9f7h AYUAbz(Hjvs0g.BmvVmW bmvVmW) {
        return new Hjvs0g.A4TApA((AssetManager) this.f451AlLFFp, 0, this);
    }

    @Override // AaHO0E.FOAO9d
    public void AZOQYO(AmA8tU amA8tU, B25kr6 b25kr6) {
        AYUAbz aYUAbz = (AYUAbz) this.f451AlLFFp;
        aYUAbz.f459B2KMhB.removeCallbacksAndMessages(null);
        ArrayList arrayList = aYUAbz.f461B4ZgIw;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (amA8tU == ((ASJ6gh) arrayList.get(i)).f453A4TApA) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        int i2 = i + 1;
        aYUAbz.f459B2KMhB.postAtTime(new AMqCpz(this, i2 < arrayList.size() ? (ASJ6gh) arrayList.get(i2) : null, b25kr6, amA8tU, 0), amA8tU, SystemClock.uptimeMillis() + 200);
    }

    @Override // AaHO0E.DUi7mC
    public void AZkASS(int i) {
    }

    @Override // DRlcZ9.AmA8tU
    public boolean AaHO0E(Preference preference) {
        MS6BTZ.A4TApA a4TApA = (MS6BTZ.A4TApA) this.f451AlLFFp;
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        a4TApA.f5162B7CMnp.A2egSU(intent);
        return true;
    }

    @Override // I3HV03.AmA8tU
    public short AcNBzu() {
        int read = ((InputStream) this.f451AlLFFp).read();
        if (read != -1) {
            return (short) read;
        }
        throw new I3HV03.AlLFFp();
    }

    @Override // IsbtnO.A5SV6n
    public IsbtnO.A4TApA AlLFFp(int i) {
        if (i == 5) {
            return IsbtnO.A2egSU.f4063AcNBzu;
        }
        if (((Hdahpu.AZOQYO) this.f451AlLFFp) == null) {
            this.f451AlLFFp = new Hdahpu.AZOQYO(19);
        }
        return (Hdahpu.AZOQYO) this.f451AlLFFp;
    }

    @Override // Hjvs0g.A2egSU
    public com.bumptech.glide.load.data.AMqCpz AmA8tU(AssetManager assetManager, String str) {
        return new com.bumptech.glide.load.data.AaHO0E(assetManager, str, 1);
    }

    @Override // androidx.lifecycle.CqNSpT
    public CikNvS AzWtSf(Class cls, D9tr6l.ADYaiT aDYaiT) {
        CTkVKb cTkVKb = null;
        for (D9tr6l.AMqCpz aMqCpz : (D9tr6l.AMqCpz[]) this.f451AlLFFp) {
            if (aMqCpz.f2054A2egSU.equals(cls)) {
                cTkVKb = new CTkVKb();
            }
        }
        if (cTkVKb != null) {
            return cTkVKb;
        }
        throw new IllegalArgumentException("No initializer set for given class ".concat(cls.getName()));
    }

    @Override // COJEAR.ASJ6gh
    public int B25kr6() {
        int flags;
        flags = ((ContentInfo) this.f451AlLFFp).getFlags();
        return flags;
    }

    @Override // COJEAR.ASJ6gh
    public ContentInfo B2KMhB() {
        return (ContentInfo) this.f451AlLFFp;
    }

    @Override // COJEAR.BNL6CD
    public FG7pZc B3GDIM(View view, FG7pZc fG7pZc) {
        CoordinatorLayout.A2egSU a2egSU;
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f451AlLFFp;
        if (!Objects.equals(coordinatorLayout.f8462BNL6CD, fG7pZc)) {
            coordinatorLayout.f8462BNL6CD = fG7pZc;
            boolean z = fG7pZc.ADYaiT() > 0;
            coordinatorLayout.f8463BPw6Q8 = z;
            coordinatorLayout.setWillNotDraw(!z && coordinatorLayout.getBackground() == null);
            if (!fG7pZc.f1747A2egSU.AlLFFp()) {
                int childCount = coordinatorLayout.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = coordinatorLayout.getChildAt(i);
                    WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
                    if (childAt.getFitsSystemWindows() && (a2egSU = ((androidx.coordinatorlayout.widget.A5SV6n) childAt.getLayoutParams()).f8427A2egSU) != null) {
                        fG7pZc = a2egSU.onApplyWindowInsets(coordinatorLayout, childAt, fG7pZc);
                        if (fG7pZc.f1747A2egSU.AlLFFp()) {
                            break;
                        }
                    }
                }
            }
            coordinatorLayout.requestLayout();
        }
        return fG7pZc;
    }

    @Override // AaHO0E.DUi7mC
    public void B4ZgIw(int i) {
    }

    @Override // AaHO0E.DUi7mC
    public void B7CMnp(int i, float f) {
    }

    @Override // AaHO0E.FOAO9d
    public void B9tovu(AmA8tU amA8tU, B25kr6 b25kr6) {
        ((AYUAbz) this.f451AlLFFp).f459B2KMhB.removeCallbacksAndMessages(amA8tU);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0066 -> B:29:0x0078). Please report as a decompilation issue!!! */
    public void BI9f7h(String str, Bitmap bitmap) {
        G58fqA.A2egSU a2egSU;
        try {
            if (!TextUtils.isEmpty(str) && ((H0R8Px.AMqCpz) this.f451AlLFFp) != null) {
                String AYUAbz2 = NOd7IU.AlLFFp.AYUAbz(str);
                H0R8Px.AMqCpz aMqCpz = (H0R8Px.AMqCpz) this.f451AlLFFp;
                try {
                    try {
                        try {
                            a2egSU = aMqCpz.A2egSU(AYUAbz2);
                            if (a2egSU != null) {
                                try {
                                    if (bitmap.compress(Bitmap.CompressFormat.PNG, 100, a2egSU.A2egSU())) {
                                        boolean z = a2egSU.f2977A2egSU;
                                        H0R8Px.AMqCpz aMqCpz2 = (H0R8Px.AMqCpz) a2egSU.f2979A5SV6n;
                                        if (z) {
                                            H0R8Px.AMqCpz.ADYaiT(aMqCpz2, a2egSU, false);
                                            aMqCpz2.AcNBzu(((H0R8Px.A5SV6n) a2egSU.f2978A4TApA).f3133A2egSU);
                                        } else {
                                            H0R8Px.AMqCpz.ADYaiT(aMqCpz2, a2egSU, true);
                                        }
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    if (a2egSU != null) {
                                        try {
                                            H0R8Px.AMqCpz.ADYaiT((H0R8Px.AMqCpz) a2egSU.f2979A5SV6n, a2egSU, false);
                                        } catch (Exception e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                    e.printStackTrace();
                                    aMqCpz.ASJ6gh();
                                    return;
                                }
                            }
                            aMqCpz.ASJ6gh();
                        } catch (Exception e3) {
                            e = e3;
                            a2egSU = null;
                        }
                    } finally {
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public void BNL6CD(String str) {
        FileService.f11117B25kr6 = false;
        FileService.f11121B7CMnp = str;
        ((FileService) this.f451AlLFFp).ARc23Z();
    }

    public void BPw6Q8(String str, String str2, String str3) {
        FileService.f11117B25kr6 = true;
        FileService.f11118B2KMhB = str;
        FileService.f11119B3GDIM = str2;
        FileService.f11120B4ZgIw = str3;
        boolean z = FileService.f11116AzWtSf;
        FileService fileService = (FileService) this.f451AlLFFp;
        if (!z) {
            fileService.A5SV6n();
        }
        fileService.ARc23Z();
        new Handler(Looper.getMainLooper()).postDelayed(new LLYwnm.AMqCpz(14, this), 1500L);
    }

    public synchronized void BTvldC(HPJABZ.A5SV6n a5SV6n) {
        a5SV6n.f3435A4TApA = null;
        a5SV6n.f3436A5SV6n = null;
        ((ArrayDeque) this.f451AlLFFp).offer(a5SV6n);
    }

    @Override // Fyurov.AZkASS
    public void a(View view) {
        ((TextView) view).setHighlightColor(0);
        FOAO9d.AcNBzu acNBzu = (FOAO9d.AcNBzu) this.f451AlLFFp;
        FOAO9d.AcNBzu.ECyGFg(acNBzu, acNBzu.f2622GEYgCP.getPermissionUrl());
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        acNBzu.EY4UKY(4);
    }

    @Override // Fyurov.AZkASS
    public void b(View view) {
        ((TextView) view).setHighlightColor(0);
        FOAO9d.AcNBzu acNBzu = (FOAO9d.AcNBzu) this.f451AlLFFp;
        FOAO9d.AcNBzu.ECyGFg(acNBzu, acNBzu.f2622GEYgCP.getPrivacyUrl());
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        acNBzu.EY4UKY(4);
    }

    @Override // Fyurov.AZkASS
    public void c(View view) {
        ((TextView) view).setHighlightColor(0);
        FOAO9d.AcNBzu acNBzu = (FOAO9d.AcNBzu) this.f451AlLFFp;
        FOAO9d.AcNBzu.ECyGFg(acNBzu, acNBzu.f2622GEYgCP.getAppIntro());
        int i = GJee0v.AZOQYO.f3039AcNBzu;
        acNBzu.EY4UKY(4);
    }

    @Override // COJEAR.ASJ6gh
    public int getSource() {
        int source;
        source = ((ContentInfo) this.f451AlLFFp).getSource();
        return source;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        try {
            L2suez.B25kr6.A2egSU((L2suez.B25kr6) this.f451AlLFFp, iOException);
        } finally {
            L2suez.B2KMhB.f4386A4TApA.set(false);
        }
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        try {
            boolean isSuccessful = response.isSuccessful();
            L2suez.B25kr6 b25kr6 = (L2suez.B25kr6) this.f451AlLFFp;
            if (isSuccessful) {
                try {
                    String string = response.body().string();
                    Context context = (Context) b25kr6.f4380A2egSU.get();
                    if (context != null) {
                        SharedPreferences.Editor edit = context.getSharedPreferences(context.getPackageName() + "_preferences", 0).edit();
                        edit.apply();
                        edit.putString("updater", string).apply();
                    }
                    b25kr6.f4383ADYaiT.post(new C4FrIb.A2egSU(this, (MTKlkd.AZOQYO) new Gson().fromJson(string, MTKlkd.AZOQYO.class), 10, false));
                } catch (Exception unused) {
                    if (b25kr6.f4384ARc23Z != null) {
                        b25kr6.f4383ADYaiT.post(new D8MqeW(b25kr6, "数据解析失败"));
                    }
                }
            } else {
                L2suez.B25kr6.A2egSU(b25kr6, new IOException("Server error: " + response.code()));
            }
        } finally {
            response.close();
            L2suez.B2KMhB.f4386A4TApA.set(false);
        }
    }

    @Override // I3HV03.AmA8tU
    public long skip(long j) {
        if (j < 0) {
            return 0L;
        }
        long j2 = j;
        while (j2 > 0) {
            InputStream inputStream = (InputStream) this.f451AlLFFp;
            long skip = inputStream.skip(j2);
            if (skip > 0) {
                j2 -= skip;
            } else {
                if (inputStream.read() == -1) {
                    break;
                }
                j2--;
            }
        }
        return j - j2;
    }

    public String toString() {
        switch (this.f450AcNBzu) {
            case 5:
                return "ContentInfoCompat{" + ((ContentInfo) this.f451AlLFFp) + "}";
            case 19:
                return super.toString() + "{fragment=" + ((IQ76hF.AZkASS) this.f451AlLFFp) + "}";
            default:
                return super.toString();
        }
    }

    public /* synthetic */ ARc23Z(int i, Object obj) {
        this.f450AcNBzu = i;
        this.f451AlLFFp = obj;
    }

    public ARc23Z(com.game.boy.activity.A5SV6n a5SV6n) {
        this.f450AcNBzu = 24;
        OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(a5SV6n);
        ADYaiT.AZOQYO azoqyo = a4TApA.f81AcNBzu;
        azoqyo.AMqCpz = "用户协议与隐私政策";
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "欢迎使用 GBoy模拟器。\n\n");
        spannableStringBuilder.append((CharSequence) "在开始使用前\n请您仔细阅读并理解以下全部条款：\n\n");
        spannableStringBuilder.append((CharSequence) "• ");
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) "《用户协议》");
        spannableStringBuilder.setSpan(new M0ztbm.A5SV6n(this, a5SV6n, 0), length, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append((CharSequence) "\n");
        spannableStringBuilder.append((CharSequence) "• ");
        int length2 = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) "《隐私政策》");
        spannableStringBuilder.setSpan(new M0ztbm.A5SV6n(this, a5SV6n, 1), length2, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append((CharSequence) "\n");
        spannableStringBuilder.append((CharSequence) "• ");
        int length3 = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) "《免责声明》");
        spannableStringBuilder.setSpan(new M0ztbm.A5SV6n(this, a5SV6n, 2), length3, spannableStringBuilder.length(), 33);
        spannableStringBuilder.append((CharSequence) "\n\n");
        spannableStringBuilder.append((CharSequence) "点击“同意”即表示您已阅读、理解并同意上述全部条款。\n");
        spannableStringBuilder.append((CharSequence) "若您拒绝，将无法使用本应用。");
        float f = a5SV6n.getResources().getDisplayMetrics().density;
        TextView textView = new TextView(a5SV6n);
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        int i = (int) ((32.0f * f) + 0.5f);
        int i2 = (int) ((8.0f * f) + 0.5f);
        textView.setPadding(i, i2, i, i2);
        textView.setTextSize(2, 14.0f);
        textView.setLineSpacing(f * 5.0f, 1.0f);
        ScrollView scrollView = new ScrollView(a5SV6n);
        scrollView.addView(textView);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        azoqyo.f41B7CMnp = scrollView;
        a4TApA.AzWtSf("同意", new M0ztbm.ADYaiT(this, 0, a5SV6n));
        a4TApA.AcNBzu("拒绝", new DRlcZ9.ASJ6gh(1, a5SV6n));
        azoqyo.f35AmA8tU = false;
        a4TApA.AMqCpz();
    }

    public ARc23Z(D9tr6l.AMqCpz[] aMqCpzArr) {
        this.f450AcNBzu = 10;
        RXb0Sz.ARc23Z.AMqCpz(aMqCpzArr, "initializers");
        this.f451AlLFFp = aMqCpzArr;
    }

    public ARc23Z(TextView textView) {
        this.f450AcNBzu = 9;
        this.f451AlLFFp = new D07BeM.AZOQYO(textView);
    }

    public ARc23Z() {
        this.f450AcNBzu = 18;
        char[] cArr = ItGa5w.AlLFFp.f4092A2egSU;
        this.f451AlLFFp = new ArrayDeque(0);
    }

    public ARc23Z(ContentInfo contentInfo) {
        this.f450AcNBzu = 5;
        contentInfo.getClass();
        this.f451AlLFFp = COJEAR.ADYaiT.ASJ6gh(contentInfo);
    }
}
