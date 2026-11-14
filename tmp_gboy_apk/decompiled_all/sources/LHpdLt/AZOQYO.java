package LHpdLt;

import AaHO0E.FG7pZc;
import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.game.boy.MyApp;
import com.game.boy.activity.EmulatorActivity;
import com.game.boy.viewUi.BadgedMaterialCardView;
import com.game.boy.viewUi.QuoteTextInputLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZOQYO {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final SharedPreferences f4471A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final EmulatorActivity f4472A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Activity f4473A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public ViewGroup f4474ADYaiT;
    public final View AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public volatile boolean f4475ARc23Z = false;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f4476ASJ6gh = false;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public float f4477AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public float f4478AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public int f4479AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public int f4480AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public int f4481AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f4482AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final View f4483AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final TextInputEditText f4484AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final QuoteTextInputLayout f4485B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final MaterialButton f4486B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final MaterialButton f4487B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final TabLayout f4488B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final RecyclerView f4489B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final LLiCI0.BTvldC f4490B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final ArrayList f4491BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final MaterialButton f4492BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public final BadgedMaterialCardView f4493BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final ArrayList f4494BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public final ArrayList f4495BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public int f4496BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public boolean f4497BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public boolean f4498BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public final Gson f4499BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final AMqCpz f4500BniPrB;
    public float BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public float f4501C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public float f4502C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public float f4503CASmeH;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public LLYwnm.AYUAbz f4504CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public final I3HV03.A4TApA f4505COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public final Object f4506CQhlFr;

    public AZOQYO(EmulatorActivity emulatorActivity) {
        this.f4477AYUAbz = 0.0f;
        this.f4478AZOQYO = 0.0f;
        ArrayList arrayList = new ArrayList();
        this.f4491BChYOn = arrayList;
        this.f4494BJ7GGh = new ArrayList();
        this.f4495BNL6CD = new ArrayList();
        this.f4496BPw6Q8 = 1;
        this.f4497BTvldC = false;
        this.f4498BV3sI0 = false;
        this.f4499BmvVmW = new Gson();
        this.f4506CQhlFr = new Object();
        this.f4472A4TApA = emulatorActivity;
        this.f4473A5SV6n = emulatorActivity;
        this.AMqCpz = LayoutInflater.from(emulatorActivity).inflate(2131492956, (ViewGroup) new FrameLayout(emulatorActivity), false);
        this.f4505COJEAR = new I3HV03.A4TApA((Context) emulatorActivity);
        this.f4483AmA8tU = this.AMqCpz.findViewById(2131296343);
        this.f4485B25kr6 = (QuoteTextInputLayout) this.AMqCpz.findViewById(2131298100);
        this.f4484AzWtSf = (TextInputEditText) this.AMqCpz.findViewById(2131297643);
        this.f4486B2KMhB = (MaterialButton) this.AMqCpz.findViewById(2131297908);
        this.f4487B3GDIM = (MaterialButton) this.AMqCpz.findViewById(2131296549);
        this.f4488B4ZgIw = (TabLayout) this.AMqCpz.findViewById(2131298053);
        this.f4489B7CMnp = (RecyclerView) this.AMqCpz.findViewById(2131297794);
        this.f4492BI9f7h = (MaterialButton) this.AMqCpz.findViewById(2131297648);
        this.f4493BIYEnU = (BadgedMaterialCardView) this.AMqCpz.findViewById(2131297649);
        SharedPreferences sharedPreferences = emulatorActivity.getSharedPreferences(DRlcZ9.BNL6CD.A2egSU(emulatorActivity), 0);
        this.f4471A2egSU = sharedPreferences;
        int i = sharedPreferences.getInt("floating_window_size", 48);
        int i2 = this.f4471A2egSU.getInt("floating_window_alpha", 5);
        AaHO0E(i);
        AZkASS(i2);
        B2KMhB(this.f4505COJEAR.AzWtSf("danmaku_enabled"));
        B25kr6();
        this.f4489B7CMnp.setLayoutManager(new LinearLayoutManager(1));
        androidx.recyclerview.widget.AzWtSf azWtSf = new androidx.recyclerview.widget.AzWtSf();
        azWtSf.f9428A5SV6n = 300L;
        azWtSf.f9430ARc23Z = 300L;
        azWtSf.AMqCpz = 300L;
        this.f4489B7CMnp.setItemAnimator(azWtSf);
        LLiCI0.BTvldC bTvldC = new LLiCI0.BTvldC();
        bTvldC.f4748AcNBzu = emulatorActivity;
        bTvldC.f4749AlLFFp = arrayList;
        this.f4490B9tovu = bTvldC;
        this.f4489B7CMnp.setAdapter(bTvldC);
        this.f4490B9tovu.f4750AmA8tU = new AZkASS.ARc23Z(23, this);
        this.f4483AmA8tU.setOnTouchListener(new FG7pZc(1, this));
        this.f4493BIYEnU.setOnTouchListener(new ASJ6gh(this));
        this.f4492BI9f7h.setOnClickListener(new AYUAbz(this, 0));
        this.f4485B25kr6.setOnSendListener(new IQ76hF.AmA8tU(4, this));
        this.f4486B2KMhB.setOnClickListener(new AYUAbz(this, 1));
        this.f4487B3GDIM.setOnClickListener(new AYUAbz(this, 2));
        this.f4488B4ZgIw.A2egSU(new ARc23Z(this));
        AMqCpz aMqCpz = new AMqCpz(this, emulatorActivity, 0);
        this.f4500BniPrB = aMqCpz;
        if (aMqCpz.canDetectOrientation()) {
            this.f4500BniPrB.enable();
        }
        try {
            SharedPreferences sharedPreferences2 = emulatorActivity.getSharedPreferences("FloatWindowPrefs", 0);
            Object obj = sharedPreferences2.getAll().get("last_x");
            Object obj2 = sharedPreferences2.getAll().get("last_y");
            this.f4477AYUAbz = AmA8tU(obj);
            this.f4478AZOQYO = AmA8tU(obj2);
        } catch (Exception unused) {
            this.f4477AYUAbz = 0.0f;
            this.f4478AZOQYO = 0.0f;
        }
        AzWtSf();
    }

    public static void A2egSU(AZOQYO azoqyo) {
        azoqyo.AzWtSf();
        View view = azoqyo.AMqCpz;
        if (view == null || view.getWidth() <= 0) {
            return;
        }
        azoqyo.f4481AcNBzu = azoqyo.AMqCpz.getWidth();
        azoqyo.f4482AlLFFp = azoqyo.AMqCpz.getHeight();
    }

    public static void A4TApA(AZOQYO azoqyo) {
        if (azoqyo.f4476ASJ6gh) {
            azoqyo.f4493BIYEnU.setVisibility(8);
            azoqyo.f4483AmA8tU.setVisibility(0);
            azoqyo.f4476ASJ6gh = false;
        } else {
            azoqyo.f4483AmA8tU.setVisibility(8);
            azoqyo.f4493BIYEnU.setVisibility(0);
            azoqyo.f4476ASJ6gh = true;
            TextInputEditText textInputEditText = azoqyo.f4484AzWtSf;
            InputMethodManager inputMethodManager = (InputMethodManager) azoqyo.f4473A5SV6n.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(textInputEditText.getWindowToken(), 0);
            }
        }
        azoqyo.AMqCpz.post(new A2egSU(azoqyo, 0));
    }

    public static void A5SV6n(AZOQYO azoqyo) {
        String sendContent = azoqyo.f4485B25kr6.getSendContent();
        if (sendContent.isEmpty()) {
            MyApp.A2egSU("请输入内容");
            return;
        }
        if (sendContent.length() > 200) {
            MyApp.A2egSU("聊天内容超过200字符。");
            return;
        }
        StringBuilder sb = new StringBuilder(sendContent.length() * 2);
        for (int i = 0; i < sendContent.length(); i++) {
            char charAt = sendContent.charAt(i);
            if (charAt == '\f') {
                sb.append("\\f");
            } else if (charAt == '\r') {
                sb.append("\\r");
            } else if (charAt == '\"') {
                sb.append("\\\"");
            } else if (charAt != '\\') {
                switch (charAt) {
                    case '\b':
                        sb.append("\\b");
                        break;
                    case '\t':
                        sb.append("\\t");
                        break;
                    case '\n':
                        sb.append("\\n");
                        break;
                    default:
                        if (charAt < ' ') {
                            sb.append(String.format(Locale.ROOT, "\\u%04X", Integer.valueOf(charAt)));
                            break;
                        } else {
                            sb.append(charAt);
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        String sb2 = sb.toString();
        LLYwnm.AYUAbz aYUAbz = azoqyo.f4504CNPG0E;
        if (aYUAbz == null || !aYUAbz.f4626A2egSU.ADYaiT()) {
            MyApp.A2egSU("未连接服务器");
        } else {
            azoqyo.f4504CNPG0E.ADYaiT(sb2, azoqyo.f4496BPw6Q8 == 0 ? Mi9UWv.ASJ6gh.f5401BmvVmW : null, new A4TApA(azoqyo, sb2));
        }
    }

    public static void ADYaiT(AZOQYO azoqyo) {
        if (azoqyo.AMqCpz == null) {
            return;
        }
        float max = Math.max(0, azoqyo.f4479AZkASS - azoqyo.f4481AcNBzu);
        float max2 = Math.max(0, azoqyo.f4480AaHO0E - azoqyo.f4482AlLFFp);
        azoqyo.f4477AYUAbz = ASJ6gh(azoqyo.f4477AYUAbz, max);
        azoqyo.f4478AZOQYO = ASJ6gh(azoqyo.f4478AZOQYO, max2);
        azoqyo.AMqCpz.setX(azoqyo.f4477AYUAbz);
        azoqyo.AMqCpz.setY(azoqyo.f4478AZOQYO);
    }

    public static TabLayout.A2egSU AMqCpz(AZOQYO azoqyo) {
        CharSequence charSequence;
        if (azoqyo.f4488B4ZgIw == null) {
            return null;
        }
        for (int i = 0; i < azoqyo.f4488B4ZgIw.getTabCount(); i++) {
            TabLayout.A2egSU AZOQYO2 = azoqyo.f4488B4ZgIw.AZOQYO(i);
            if (AZOQYO2 != null && (charSequence = AZOQYO2.f11891A4TApA) != null && charSequence.toString().startsWith("大厅")) {
                return AZOQYO2;
            }
        }
        return null;
    }

    public static float ASJ6gh(float f, float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f < 0.0f) {
            return 0.0f;
        }
        return f > f2 ? f2 : f;
    }

    public static float AmA8tU(Object obj) {
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
        return 0.0f;
    }

    public final void ARc23Z(ArrayList arrayList, BV3sI0 bV3sI0, String str, boolean z) {
        Activity activity;
        if (this.f4490B9tovu == null || (activity = this.f4473A5SV6n) == null) {
            synchronized (this.f4506CQhlFr) {
                arrayList.add(bV3sI0);
            }
        } else {
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            activity.runOnUiThread(new A5SV6n(this, activity, arrayList, bV3sI0, z, str));
        }
    }

    public final void AYUAbz(String str) {
        Activity activity;
        MTKlkd.AYUAbz aYUAbz;
        if (this.f4490B9tovu == null || (activity = this.f4473A5SV6n) == null || activity.isFinishing() || activity.isDestroyed() || (aYUAbz = (MTKlkd.AYUAbz) this.f4499BmvVmW.fromJson(str, MTKlkd.AYUAbz.class)) == null || !aYUAbz.ARc23Z()) {
            return;
        }
        activity.runOnUiThread(new ADYaiT(this, activity, aYUAbz));
    }

    public final void AZOQYO() {
        try {
            this.f4473A5SV6n.getSharedPreferences("FloatWindowPrefs", 0).edit().putFloat("last_x", this.f4477AYUAbz).putFloat("last_y", this.f4478AZOQYO).apply();
        } catch (Exception unused) {
        }
    }

    public final void AZkASS(int i) {
        int max = Math.max(0, Math.min(i, 10));
        this.f4493BIYEnU.setAlpha(1.0f - (max * 0.1f));
        if (max != 0) {
            BadgedMaterialCardView badgedMaterialCardView = this.f4493BIYEnU;
            if (badgedMaterialCardView != null) {
                badgedMaterialCardView.setCardBackgroundColor(0);
                return;
            } else {
                badgedMaterialCardView.setBackgroundColor(0);
                return;
            }
        }
        TypedArray obtainStyledAttributes = this.f4473A5SV6n.obtainStyledAttributes(new int[]{R.attr.colorPrimary});
        int color = obtainStyledAttributes.getColor(0, -16776961);
        obtainStyledAttributes.recycle();
        BadgedMaterialCardView badgedMaterialCardView2 = this.f4493BIYEnU;
        if (badgedMaterialCardView2 != null) {
            badgedMaterialCardView2.setCardBackgroundColor(color);
        } else {
            badgedMaterialCardView2.setBackgroundColor(color);
        }
    }

    public final void AaHO0E(int i) {
        int i2 = (int) (i * this.f4473A5SV6n.getResources().getDisplayMetrics().density);
        ViewGroup.LayoutParams layoutParams = this.f4493BIYEnU.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.f4493BIYEnU.setLayoutParams(layoutParams);
    }

    public final void AcNBzu(boolean z) {
        synchronized (this.f4506CQhlFr) {
            try {
                if (z) {
                    if (!this.f4497BTvldC) {
                        this.f4498BV3sI0 = true;
                        TabLayout tabLayout = this.f4488B4ZgIw;
                        TabLayout.A2egSU AZkASS2 = tabLayout.AZkASS();
                        AZkASS2.A2egSU("房间");
                        tabLayout.A5SV6n(AZkASS2, 0, true);
                        this.f4497BTvldC = true;
                        this.f4494BJ7GGh.clear();
                        this.f4496BPw6Q8 = 0;
                        AlLFFp();
                        this.f4498BV3sI0 = false;
                    }
                } else if (this.f4497BTvldC) {
                    this.f4498BV3sI0 = true;
                    this.f4488B4ZgIw.AlLFFp();
                    this.f4497BTvldC = false;
                    this.f4494BJ7GGh.clear();
                    this.f4496BPw6Q8 = 1;
                    AlLFFp();
                    this.f4498BV3sI0 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void AlLFFp() {
        synchronized (this.f4506CQhlFr) {
            try {
                this.f4491BChYOn.clear();
                if (this.f4496BPw6Q8 == 0) {
                    this.f4491BChYOn.addAll(this.f4494BJ7GGh);
                } else {
                    this.f4491BChYOn.addAll(this.f4495BNL6CD);
                }
                this.f4490B9tovu.notifyDataSetChanged();
                if (!this.f4491BChYOn.isEmpty()) {
                    this.f4489B7CMnp.smoothScrollToPosition(this.f4491BChYOn.size() - 1);
                }
                this.f4489B7CMnp.setLayoutAnimation(new LayoutAnimationController(AnimationUtils.loadAnimation(this.f4473A5SV6n, R.anim.fade_in), 0.1f));
                this.f4489B7CMnp.scheduleLayoutAnimation();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void AzWtSf() {
        ViewGroup viewGroup = this.f4474ADYaiT;
        if (viewGroup != null && viewGroup.getWidth() > 0) {
            this.f4479AZkASS = this.f4474ADYaiT.getWidth();
            this.f4480AaHO0E = this.f4474ADYaiT.getHeight();
            return;
        }
        EmulatorActivity emulatorActivity = this.f4472A4TApA;
        if (emulatorActivity != null) {
            try {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                emulatorActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                this.f4479AZkASS = displayMetrics.widthPixels;
                this.f4480AaHO0E = displayMetrics.heightPixels;
            } catch (Exception unused) {
                this.f4479AZkASS = 1080;
                this.f4480AaHO0E = 1920;
            }
        }
    }

    public final void B25kr6() {
        Activity activity = this.f4473A5SV6n;
        WindowManager windowManager = (WindowManager) activity.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        ViewGroup.LayoutParams layoutParams = this.f4483AmA8tU.getLayoutParams();
        if (activity.getResources().getConfiguration().orientation == 1) {
            layoutParams.width = (int) ((i * 2) / 3.0d);
            layoutParams.height = i2 / 2;
        } else {
            layoutParams.width = (int) (i / 3.0d);
            layoutParams.height = i2;
        }
        this.f4483AmA8tU.setLayoutParams(layoutParams);
    }

    public final void B2KMhB(boolean z) {
        if (z) {
            this.f4487B3GDIM.setIconResource(2131230986);
        } else {
            this.f4487B3GDIM.setIconResource(2131230985);
        }
        Activity activity = this.f4473A5SV6n;
        if (activity instanceof EmulatorActivity) {
            ((EmulatorActivity) activity).f10995B3GDIM.setDanmakuEnabled(z);
        }
    }
}
