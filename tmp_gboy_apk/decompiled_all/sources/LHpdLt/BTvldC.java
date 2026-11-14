package LHpdLt;

import android.R;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.game.boy.activity.EmulatorActivity;
import com.game.boy.viewUi.Material3AutoCompleteTextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.gson.Gson;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BTvldC {

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public static final Object f4559Cd8JRx = new Object();

    /* renamed from: CikNvS, reason: collision with root package name */
    public static volatile BTvldC f4560CikNvS;

    /* renamed from: A2egSU, reason: collision with root package name */
    public Activity f4561A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public ViewGroup f4562A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public View f4563A5SV6n;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public float f4565ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public float f4566ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public int f4567AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int f4568AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public int f4569AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public int f4570AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public FrameLayout f4571AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public ShapeableImageView[] f4572AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public TextView[] f4573AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Button f4574AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public Button f4575B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public EmulatorActivity f4576B2KMhB;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public TextView f4579B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final ColorStateList f4580B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final ColorStateList f4581BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public MaterialButton f4582BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public LinearLayout f4583BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public LinearLayout f4584BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public ShapeableImageView[] f4585BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public View f4586BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public Material3AutoCompleteTextView f4587BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public Material3AutoCompleteTextView f4588BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public Material3AutoCompleteTextView f4589BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public Material3AutoCompleteTextView f4590BniPrB;
    public RecyclerView BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public BIYEnU f4591C2rE4F;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public AmA8tU f4597CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public LLYwnm.AYUAbz f4598CTkVKb;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public volatile boolean f4564ADYaiT = false;
    public volatile boolean AMqCpz = false;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final Gson f4577B3GDIM = new Gson();

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f4578B4ZgIw = false;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public final ArrayList f4592C4FrIb = new ArrayList();

    /* renamed from: CASmeH, reason: collision with root package name */
    public boolean f4593CASmeH = true;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public long f4594CNPG0E = PushUIConfig.dismissTime;

    /* renamed from: COJEAR, reason: collision with root package name */
    public final HashMap f4595COJEAR = new HashMap();

    /* renamed from: CQhlFr, reason: collision with root package name */
    public final Handler f4596CQhlFr = new Handler(Looper.getMainLooper());

    /* renamed from: CcAIMM, reason: collision with root package name */
    public final AzWtSf f4599CcAIMM = new AzWtSf(0, this);

    static {
        cuki();
    }

    public BTvldC(Activity activity, LLYwnm.AYUAbz aYUAbz) {
        this.f4565ARc23Z = 0.0f;
        this.f4566ASJ6gh = 0.0f;
        this.f4561A2egSU = activity;
        new AtomicInteger(1);
        this.f4598CTkVKb = aYUAbz;
        int identifier = activity.getResources().getIdentifier("colorOnSurfaceVariant", "attr", activity.getPackageName());
        if (identifier != 0) {
            this.f4580B9tovu = ColorStateList.valueOf(identifier);
        } else {
            this.f4580B9tovu = ColorStateList.valueOf(Color.parseColor("#6200EE"));
        }
        this.f4581BChYOn = ColorStateList.valueOf(-16711936);
        try {
            AZkASS();
        } catch (Exception unused) {
        }
        try {
            AcNBzu();
        } catch (Exception unused2) {
            this.f4565ARc23Z = 0.0f;
            this.f4566ASJ6gh = 0.0f;
        }
        try {
            B2KMhB();
        } catch (Exception unused3) {
        }
    }

    public static float A2egSU(BTvldC bTvldC, float f, float f2) {
        bTvldC.getClass();
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f > f2 ? f2 : f;
    }

    public static void A4TApA(BTvldC bTvldC, String str, int i) {
        LLYwnm.AYUAbz aYUAbz;
        if (bTvldC.AMqCpz || (aYUAbz = bTvldC.f4598CTkVKb) == null || !aYUAbz.f4626A2egSU.ADYaiT()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, Integer.valueOf(i));
        LLYwnm.AYUAbz aYUAbz2 = bTvldC.f4598CTkVKb;
        AcNBzu acNBzu = new AcNBzu(0);
        aYUAbz2.getClass();
        if (hashMap.isEmpty()) {
            aYUAbz2.A5SV6n(new JrXYwF.A2egSU(acNBzu, 4));
            return;
        }
        HashMap hashMap2 = new HashMap(hashMap);
        hashMap2.put("action", "update_room_settings");
        aYUAbz2.ARc23Z(hashMap2, "room_settings_updated", acNBzu);
    }

    public static void A5SV6n(BTvldC bTvldC, Material3AutoCompleteTextView material3AutoCompleteTextView, Object obj) {
        bTvldC.getClass();
        if (material3AutoCompleteTextView == null || obj == null) {
            return;
        }
        try {
            material3AutoCompleteTextView.setSelectedValue(String.valueOf(((Number) obj).intValue()));
        } catch (Exception unused) {
        }
    }

    public static void ADYaiT(BTvldC bTvldC) {
        LLYwnm.AYUAbz aYUAbz;
        if (bTvldC.AMqCpz || (aYUAbz = bTvldC.f4598CTkVKb) == null || !aYUAbz.f4626A2egSU.ADYaiT()) {
            return;
        }
        try {
            LLYwnm.AYUAbz aYUAbz2 = bTvldC.f4598CTkVKb;
            aYUAbz2.getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("action", "get_invite_list");
            aYUAbz2.ARc23Z(hashMap, null, null);
        } catch (Exception unused) {
        }
    }

    public static boolean AMqCpz(ArrayList arrayList, ArrayList arrayList2) {
        int i;
        if (arrayList.size() == arrayList2.size()) {
            while (i < arrayList.size()) {
                BJ7GGh bJ7GGh = (BJ7GGh) arrayList.get(i);
                BJ7GGh bJ7GGh2 = (BJ7GGh) arrayList2.get(i);
                i = (ASJ6gh(bJ7GGh.f4548A2egSU, bJ7GGh2.f4548A2egSU) && ASJ6gh(bJ7GGh.f4549A4TApA, bJ7GGh2.f4549A4TApA) && ASJ6gh(bJ7GGh.f4550A5SV6n, bJ7GGh2.f4550A5SV6n)) ? i + 1 : 0;
            }
            return true;
        }
        return false;
    }

    public static boolean ASJ6gh(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0045 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046 A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:11:0x0027, B:13:0x002b, B:16:0x0030, B:17:0x0041, B:20:0x005f, B:23:0x0046, B:25:0x0050, B:26:0x005c, B:27:0x003a), top: B:10:0x0027 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static LHpdLt.BTvldC AzWtSf(android.app.Activity r3, LLYwnm.AYUAbz r4) {
        /*
            if (r4 != 0) goto L4
            r3 = 0
            return r3
        L4:
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L24
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            r0.<init>(r1)
            C4FrIb.A2egSU r1 = new C4FrIb.A2egSU
            r2 = 19
            r1.<init>(r3, r2, r4)
            r0.post(r1)
            LHpdLt.BTvldC r3 = LHpdLt.BTvldC.f4560CikNvS
            return r3
        L24:
            java.lang.Object r0 = LHpdLt.BTvldC.f4559Cd8JRx
            monitor-enter(r0)
            LHpdLt.BTvldC r1 = LHpdLt.BTvldC.f4560CikNvS     // Catch: java.lang.Throwable -> L38
            if (r1 == 0) goto L3a
            boolean r2 = r1.AMqCpz     // Catch: java.lang.Throwable -> L38
            if (r2 == 0) goto L30
            goto L3a
        L30:
            r1.f4561A2egSU = r3     // Catch: java.lang.Throwable -> L38
            r1.f4598CTkVKb = r4     // Catch: java.lang.Throwable -> L38
            r3 = 0
            r1.AMqCpz = r3     // Catch: java.lang.Throwable -> L38
            goto L41
        L38:
            r3 = move-exception
            goto L61
        L3a:
            LHpdLt.BTvldC r1 = new LHpdLt.BTvldC     // Catch: java.lang.Throwable -> L38
            r1.<init>(r3, r4)     // Catch: java.lang.Throwable -> L38
            LHpdLt.BTvldC.f4560CikNvS = r1     // Catch: java.lang.Throwable -> L38
        L41:
            boolean r3 = r1.AMqCpz     // Catch: java.lang.Throwable -> L38
            if (r3 == 0) goto L46
            goto L5f
        L46:
            android.os.Looper r3 = android.os.Looper.myLooper()     // Catch: java.lang.Throwable -> L38
            android.os.Looper r4 = android.os.Looper.getMainLooper()     // Catch: java.lang.Throwable -> L38
            if (r3 == r4) goto L5c
            android.os.Handler r3 = r1.f4596CQhlFr     // Catch: java.lang.Throwable -> L38
            LHpdLt.AmA8tU r4 = new LHpdLt.AmA8tU     // Catch: java.lang.Throwable -> L38
            r2 = 1
            r4.<init>(r1, r2)     // Catch: java.lang.Throwable -> L38
            r3.post(r4)     // Catch: java.lang.Throwable -> L38
            goto L5f
        L5c:
            r1.AmA8tU()     // Catch: java.lang.Throwable -> L38
        L5f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L38
            return r1
        L61:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L38
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: LHpdLt.BTvldC.AzWtSf(android.app.Activity, LLYwnm.AYUAbz):LHpdLt.BTvldC");
    }

    public static float B25kr6(Object obj) {
        if (obj == null) {
            return 0.0f;
        }
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).floatValue();
        }
        if (obj instanceof Long) {
            return ((Long) obj).floatValue();
        }
        if (obj instanceof Double) {
            return ((Double) obj).floatValue();
        }
        if (!(obj instanceof String)) {
            return 0.0f;
        }
        try {
            return Float.parseFloat((String) obj);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    private static /* synthetic */ void cuki() {
        char[] charArray = "\u0018\u0014\u0016U\u001c\u001a\u0016\u001eU\u0019\u0014\u0002U\b\u0013\u001e\u0017\u0017U1\u0015\u00129\t\u0012\u001f\u001c\u001e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '{');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0018\u0017\u0012\u0015\u0012\u000f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '{');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void ARc23Z(B7CMnp b7CMnp) {
        if (this.AMqCpz || b7CMnp == null) {
            return;
        }
        long j = b7CMnp.AMqCpz;
        if (j > 0) {
            this.f4594CNPG0E = j * 1000;
        }
        this.f4593CASmeH = b7CMnp.f4529A2egSU;
        B2KMhB b2KMhB = new B2KMhB(this, b7CMnp.f4533ARc23Z == null ? new ArrayList() : new ArrayList(b7CMnp.f4533ARc23Z));
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f4596CQhlFr.post(b2KMhB);
        } else {
            b2KMhB.run();
        }
    }

    public final void AYUAbz(boolean z) {
        LLYwnm.AYUAbz aYUAbz;
        if (this.AMqCpz) {
            return;
        }
        this.AMqCpz = true;
        if (z && (aYUAbz = this.f4598CTkVKb) != null && aYUAbz.f4626A2egSU.ADYaiT()) {
            try {
                LLYwnm.AYUAbz aYUAbz2 = this.f4598CTkVKb;
                aYUAbz2.getClass();
                HashMap hashMap = new HashMap();
                hashMap.put("action", "leave_room");
                aYUAbz2.ARc23Z(hashMap, "leave_room", null);
            } catch (Exception unused) {
            }
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f4596CQhlFr.post(new AmA8tU(this, 3));
        } else {
            AZOQYO();
        }
    }

    public final void AZOQYO() {
        try {
            LLYwnm.AYUAbz aYUAbz = this.f4598CTkVKb;
            if (aYUAbz != null) {
                aYUAbz.f4630ARc23Z.remove(this.f4599CcAIMM);
            }
        } catch (Exception unused) {
        }
        AmA8tU amA8tU = this.f4597CSDoyG;
        if (amA8tU != null) {
            this.f4596CQhlFr.removeCallbacks(amA8tU);
            this.f4597CSDoyG = null;
        }
        if (this.f4564ADYaiT && this.f4563A5SV6n != null && this.f4562A4TApA != null) {
            try {
                AlLFFp();
                ViewParent parent = this.f4563A5SV6n.getParent();
                ViewGroup viewGroup = this.f4562A4TApA;
                if (parent == viewGroup) {
                    viewGroup.removeView(this.f4563A5SV6n);
                }
            } catch (Exception unused2) {
            }
            this.f4564ADYaiT = false;
        }
        this.f4592C4FrIb.clear();
        BIYEnU bIYEnU = this.f4591C2rE4F;
        if (bIYEnU != null) {
            bIYEnU.notifyDataSetChanged();
            this.f4591C2rE4F = null;
        }
        this.f4595COJEAR.clear();
        this.f4576B2KMhB = null;
        this.f4561A2egSU = null;
        this.f4562A4TApA = null;
        this.f4563A5SV6n = null;
        this.f4571AcNBzu = null;
        this.f4572AlLFFp = null;
        this.f4585BNL6CD = null;
        this.f4573AmA8tU = null;
        this.f4582BI9f7h = null;
        this.f4574AzWtSf = null;
        this.f4575B25kr6 = null;
        this.f4579B7CMnp = null;
        this.f4583BIYEnU = null;
        this.f4584BJ7GGh = null;
        this.BpkvW3 = null;
        this.f4586BPw6Q8 = null;
        this.f4587BTvldC = null;
        this.f4588BV3sI0 = null;
        this.f4589BmvVmW = null;
        this.f4590BniPrB = null;
        synchronized (f4559Cd8JRx) {
            try {
                if (f4560CikNvS == this) {
                    f4560CikNvS = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void AZkASS() {
        View inflate = LayoutInflater.from(this.f4561A2egSU).inflate(2131492957, (ViewGroup) new FrameLayout(this.f4561A2egSU), false);
        this.f4563A5SV6n = inflate;
        this.f4571AcNBzu = (FrameLayout) inflate.findViewById(2131297836);
        this.f4574AzWtSf = (Button) this.f4563A5SV6n.findViewById(2131296448);
        this.f4575B25kr6 = (Button) this.f4563A5SV6n.findViewById(2131296430);
        this.f4579B7CMnp = (TextView) this.f4563A5SV6n.findViewById(2131298108);
        this.f4582BI9f7h = (MaterialButton) this.f4563A5SV6n.findViewById(2131297648);
        this.f4583BIYEnU = (LinearLayout) this.f4563A5SV6n.findViewById(2131296548);
        this.f4584BJ7GGh = (LinearLayout) this.f4563A5SV6n.findViewById(2131298330);
        this.f4582BI9f7h.setOnClickListener(new B3GDIM(this, 0));
        this.f4572AlLFFp = new ShapeableImageView[4];
        this.f4585BNL6CD = new ShapeableImageView[4];
        this.f4573AmA8tU = new TextView[4];
        int[] iArr = {2131296396, 2131296397, 2131296398, 2131296399};
        int[] iArr2 = {2131296277, 2131296278, 2131296279, 2131296280};
        int[] iArr3 = {2131297706, 2131297707, 2131297708, 2131297709};
        for (int i = 0; i < 4; i++) {
            this.f4572AlLFFp[i] = (ShapeableImageView) this.f4563A5SV6n.findViewById(iArr[i]);
            this.f4585BNL6CD[i] = (ShapeableImageView) this.f4563A5SV6n.findViewById(iArr2[i]);
            this.f4573AmA8tU[i] = (TextView) this.f4563A5SV6n.findViewById(iArr3[i]);
            TextView textView = this.f4573AmA8tU[i];
            if (textView != null) {
                textView.setText("空");
            }
            ShapeableImageView shapeableImageView = this.f4572AlLFFp[i];
            ColorStateList colorStateList = this.f4580B9tovu;
            if (shapeableImageView != null) {
                shapeableImageView.setStrokeColor(colorStateList);
            }
            ShapeableImageView shapeableImageView2 = this.f4585BNL6CD[i];
            if (shapeableImageView2 != null) {
                shapeableImageView2.setStrokeColor(colorStateList);
            }
        }
        this.f4574AzWtSf.setText("准备");
        this.f4575B25kr6.setText("取消");
        this.f4574AzWtSf.setOnClickListener(new B3GDIM(this, 1));
        this.f4575B25kr6.setOnClickListener(new B3GDIM(this, 2));
        View findViewById = this.f4563A5SV6n.findViewById(2131296610);
        if (findViewById == null) {
            findViewById = this.f4571AcNBzu;
        }
        findViewById.setOnTouchListener(new B4ZgIw(this));
        this.f4586BPw6Q8 = this.f4563A5SV6n.findViewById(2131296656);
        this.f4587BTvldC = (Material3AutoCompleteTextView) this.f4563A5SV6n.findViewById(2131296362);
        this.f4588BV3sI0 = (Material3AutoCompleteTextView) this.f4563A5SV6n.findViewById(2131296365);
        this.f4589BmvVmW = (Material3AutoCompleteTextView) this.f4563A5SV6n.findViewById(2131296361);
        this.f4590BniPrB = (Material3AutoCompleteTextView) this.f4563A5SV6n.findViewById(2131296366);
        View view = this.f4586BPw6Q8;
        if (view != null) {
            view.setVisibility(8);
        }
        Material3AutoCompleteTextView material3AutoCompleteTextView = this.f4587BTvldC;
        if (material3AutoCompleteTextView != null) {
            material3AutoCompleteTextView.setOnValueSelectedListener(new AaHO0E(this, 2));
        }
        Material3AutoCompleteTextView material3AutoCompleteTextView2 = this.f4588BV3sI0;
        if (material3AutoCompleteTextView2 != null) {
            material3AutoCompleteTextView2.setOnValueSelectedListener(new AZkASS(this, 0));
        }
        Material3AutoCompleteTextView material3AutoCompleteTextView3 = this.f4590BniPrB;
        if (material3AutoCompleteTextView3 != null) {
            material3AutoCompleteTextView3.setOnValueSelectedListener(new AaHO0E(this, 0));
        }
        Material3AutoCompleteTextView material3AutoCompleteTextView4 = this.f4589BmvVmW;
        if (material3AutoCompleteTextView4 != null) {
            material3AutoCompleteTextView4.setOnValueSelectedListener(new AZkASS(this, 1));
        }
        RecyclerView recyclerView = (RecyclerView) this.f4563A5SV6n.findViewById(2131297833);
        this.BpkvW3 = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        this.BpkvW3.setItemAnimator(null);
        BIYEnU bIYEnU = new BIYEnU(this.f4592C4FrIb, this.f4595COJEAR, new AaHO0E(this, 1), new AZkASS(this, 2));
        this.f4591C2rE4F = bIYEnU;
        this.BpkvW3.setAdapter(bIYEnU);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0033, code lost:
    
        r3.setTag(null);
        r3.setImageResource(2131689472);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AaHO0E(com.google.android.material.imageview.ShapeableImageView r3, java.lang.String r4) {
        /*
            r2 = this;
            if (r3 != 0) goto L3
            goto L3c
        L3:
            java.lang.Object r0 = r3.getTag()     // Catch: java.lang.Exception -> L3c
            if (r4 == 0) goto L31
            boolean r1 = r4.isEmpty()     // Catch: java.lang.Exception -> L3c
            if (r1 == 0) goto L10
            goto L31
        L10:
            boolean r0 = r4.equals(r0)     // Catch: java.lang.Exception -> L3c
            if (r0 != 0) goto L3c
            r3.setTag(r4)     // Catch: java.lang.Exception -> L3c
            android.app.Activity r0 = r2.f4561A2egSU     // Catch: java.lang.Exception -> L3c
            if (r0 == 0) goto L3c
            boolean r0 = r0.isFinishing()     // Catch: java.lang.Exception -> L3c
            if (r0 != 0) goto L3c
            android.app.Activity r0 = r2.f4561A2egSU     // Catch: java.lang.Exception -> L3c
            boolean r0 = r0.isDestroyed()     // Catch: java.lang.Exception -> L3c
            if (r0 != 0) goto L3c
            android.app.Activity r0 = r2.f4561A2egSU     // Catch: java.lang.Exception -> L3c
            L2suez.AZOQYO.A4TApA(r0, r4, r3)     // Catch: java.lang.Exception -> L3c
            return
        L31:
            if (r0 == 0) goto L3c
            r4 = 0
            r3.setTag(r4)     // Catch: java.lang.Exception -> L3c
            r4 = 2131689472(0x7f0f0000, float:1.900796E38)
            r3.setImageResource(r4)     // Catch: java.lang.Exception -> L3c
        L3c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: LHpdLt.BTvldC.AaHO0E(com.google.android.material.imageview.ShapeableImageView, java.lang.String):void");
    }

    public final void AcNBzu() {
        Activity activity = this.f4561A2egSU;
        if (activity == null) {
            return;
        }
        SharedPreferences sharedPreferences = activity.getSharedPreferences("FloatWindowPrefs", 0);
        try {
            Object obj = sharedPreferences.getAll().get("playe_x");
            Object obj2 = sharedPreferences.getAll().get("playe_y");
            this.f4565ARc23Z = B25kr6(obj);
            this.f4566ASJ6gh = B25kr6(obj2);
        } catch (Exception unused) {
            this.f4565ARc23Z = 0.0f;
            this.f4566ASJ6gh = 0.0f;
        }
    }

    public final void AlLFFp() {
        Activity activity = this.f4561A2egSU;
        if (activity == null) {
            return;
        }
        try {
            activity.getSharedPreferences("FloatWindowPrefs", 0).edit().putFloat("playe_x", this.f4565ARc23Z).putFloat("playe_y", this.f4566ASJ6gh).apply();
        } catch (Exception unused) {
        }
    }

    public final void AmA8tU() {
        Activity activity;
        AzWtSf azWtSf;
        if (this.AMqCpz || this.f4564ADYaiT || (activity = this.f4561A2egSU) == null || activity.isFinishing() || this.f4561A2egSU.isDestroyed() || this.f4563A5SV6n == null) {
            return;
        }
        try {
            ViewGroup viewGroup = (ViewGroup) this.f4561A2egSU.findViewById(R.id.content);
            this.f4562A4TApA = viewGroup;
            if (viewGroup == null) {
                return;
            }
            if (this.f4563A5SV6n.getParent() == this.f4562A4TApA) {
                this.f4564ADYaiT = true;
                return;
            }
            this.f4563A5SV6n.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            BTvldC bTvldC = f4560CikNvS;
            if (bTvldC != null && bTvldC != this && !bTvldC.AMqCpz && bTvldC.f4564ADYaiT) {
                try {
                    bTvldC.AYUAbz(false);
                } catch (Exception unused) {
                }
            }
            f4560CikNvS = this;
            this.f4562A4TApA.addView(this.f4563A5SV6n);
            this.f4563A5SV6n.post(new AmA8tU(this, 2));
            this.f4564ADYaiT = true;
            LLYwnm.AYUAbz aYUAbz = this.f4598CTkVKb;
            if (aYUAbz != null && (azWtSf = this.f4599CcAIMM) != null) {
                aYUAbz.f4630ARc23Z.add(azWtSf);
            }
            AmA8tU amA8tU = this.f4597CSDoyG;
            if (amA8tU != null) {
                this.f4596CQhlFr.removeCallbacks(amA8tU);
                this.f4597CSDoyG = null;
            }
            if (this.AMqCpz) {
                return;
            }
            AmA8tU amA8tU2 = new AmA8tU(this, 0);
            this.f4597CSDoyG = amA8tU2;
            this.f4596CQhlFr.postDelayed(amA8tU2, PushUIConfig.dismissTime);
        } catch (Exception unused2) {
        }
    }

    public final void B2KMhB() {
        if (this.f4561A2egSU == null) {
            return;
        }
        ViewGroup viewGroup = this.f4562A4TApA;
        if (viewGroup != null && viewGroup.getWidth() > 0) {
            this.f4567AYUAbz = this.f4562A4TApA.getWidth();
            this.f4568AZOQYO = this.f4562A4TApA.getHeight();
            return;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.f4561A2egSU.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.f4567AYUAbz = displayMetrics.widthPixels;
            this.f4568AZOQYO = displayMetrics.heightPixels;
        } catch (Exception unused) {
            this.f4567AYUAbz = 1080;
            this.f4568AZOQYO = 1920;
        }
    }

    public final void B3GDIM(List list) {
        if (this.AMqCpz || list == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f4596CQhlFr.post(new C4FrIb.A2egSU(this, list, 18, false));
        } else {
            B4ZgIw(list);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x003d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B4ZgIw(java.util.List r10) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: LHpdLt.BTvldC.B4ZgIw(java.util.List):void");
    }
}
