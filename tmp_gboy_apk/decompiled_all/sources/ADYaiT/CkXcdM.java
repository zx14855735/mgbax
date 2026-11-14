package ADYaiT;

import AaHO0E.DuwtYk;
import AaHO0E.GYpKKt;
import AaHO0E.H6qKiO;
import AaHO0E.HSHyT0;
import COJEAR.De4eam;
import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ContentFrameLayout;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.qq.e.comm.adevent.AdEventType;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CkXcdM extends BJ7GGh implements AZkASS.AcNBzu, LayoutInflater.Factory2 {

    /* renamed from: DvK7DB, reason: collision with root package name */
    public static final B25kr6.AzWtSf f153DvK7DB = new B25kr6.AzWtSf();

    /* renamed from: DyaChj, reason: collision with root package name */
    public static final int[] f154DyaChj = {R.attr.windowBackground};

    /* renamed from: ECyGFg, reason: collision with root package name */
    public static final boolean f155ECyGFg = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: B9tovu, reason: collision with root package name */
    public final Object f156B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public final Context f157BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public Window f158BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public CQhlFr f159BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public final Object f160BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public A2egSU f161BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public AZOQYO.AZkASS f162BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public CharSequence f163BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public DuwtYk f164BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public BPw6Q8 f165BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public BTvldC f166BniPrB;
    public AZOQYO.A4TApA BpkvW3;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public ActionBarContextView f167C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public PopupWindow f168C4FrIb;

    /* renamed from: CASmeH, reason: collision with root package name */
    public BNL6CD f169CASmeH;

    /* renamed from: COJEAR, reason: collision with root package name */
    public boolean f171COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public ViewGroup f172CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public TextView f173CSDoyG;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public View f174CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public boolean f175CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public boolean f176Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public boolean f177CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public boolean f178CkXcdM;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public boolean f179CmUvjW;

    /* renamed from: CqNSpT, reason: collision with root package name */
    public boolean f180CqNSpT;

    /* renamed from: CrfGsy, reason: collision with root package name */
    public boolean f181CrfGsy;

    /* renamed from: CtFAbx, reason: collision with root package name */
    public boolean f182CtFAbx;

    /* renamed from: CtxOCS, reason: collision with root package name */
    public CikNvS[] f183CtxOCS;

    /* renamed from: D07BeM, reason: collision with root package name */
    public CikNvS f184D07BeM;

    /* renamed from: D6DOie, reason: collision with root package name */
    public boolean f185D6DOie;

    /* renamed from: D6yqiO, reason: collision with root package name */
    public boolean f186D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public boolean f187D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public boolean f188D8cQ8b;

    /* renamed from: D9tr6l, reason: collision with root package name */
    public Configuration f189D9tr6l;

    /* renamed from: DAk1zC, reason: collision with root package name */
    public final int f190DAk1zC;

    /* renamed from: DG07BK, reason: collision with root package name */
    public int f191DG07BK;

    /* renamed from: DRlcZ9, reason: collision with root package name */
    public int f192DRlcZ9;

    /* renamed from: DUi7mC, reason: collision with root package name */
    public boolean f193DUi7mC;

    /* renamed from: DV2E8K, reason: collision with root package name */
    public CSDoyG f194DV2E8K;

    /* renamed from: DXnQ0V, reason: collision with root package name */
    public CSDoyG f195DXnQ0V;
    public boolean DXuj49;

    /* renamed from: DaOi9o, reason: collision with root package name */
    public int f196DaOi9o;

    /* renamed from: DdagTj, reason: collision with root package name */
    public boolean f198DdagTj;
    public Rect Ddcejp;

    /* renamed from: De4eam, reason: collision with root package name */
    public Rect f199De4eam;

    /* renamed from: DjONCG, reason: collision with root package name */
    public D07BeM f200DjONCG;

    /* renamed from: Dphsd2, reason: collision with root package name */
    public OnBackInvokedDispatcher f201Dphsd2;

    /* renamed from: DuwtYk, reason: collision with root package name */
    public OnBackInvokedCallback f202DuwtYk;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public De4eam f170CNPG0E = null;

    /* renamed from: DcUJf1, reason: collision with root package name */
    public final BNL6CD f197DcUJf1 = new BNL6CD(this, 0);

    static {
        ycvf();
    }

    public CkXcdM(Context context, Window window, B3GDIM b3gdim, Object obj) {
        B2KMhB b2KMhB = null;
        this.f190DAk1zC = -100;
        this.f157BChYOn = context;
        this.f160BJ7GGh = b3gdim;
        this.f156B9tovu = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof B2KMhB)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        } else {
                            context = ((ContextWrapper) context).getBaseContext();
                        }
                    } else {
                        b2KMhB = (B2KMhB) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (b2KMhB != null) {
                this.f190DAk1zC = ((CkXcdM) b2KMhB.getDelegate()).f190DAk1zC;
            }
        }
        if (this.f190DAk1zC == -100) {
            B25kr6.AzWtSf azWtSf = f153DvK7DB;
            Integer num = (Integer) azWtSf.get(this.f156B9tovu.getClass().getName());
            if (num != null) {
                this.f190DAk1zC = num.intValue();
                azWtSf.remove(this.f156B9tovu.getClass().getName());
            }
        }
        if (window != null) {
            B25kr6(window);
        }
        AaHO0E.BNL6CD.ADYaiT();
    }

    public static C2rE4F.AYUAbz B2KMhB(Context context) {
        C2rE4F.AYUAbz aYUAbz;
        C2rE4F.AYUAbz A4TApA2;
        int i = Build.VERSION.SDK_INT;
        if (i >= 33 || (aYUAbz = BJ7GGh.f99AmA8tU) == null) {
            return null;
        }
        C2rE4F.AYUAbz BPw6Q82 = BPw6Q8(context.getApplicationContext().getResources().getConfiguration());
        C2rE4F.AZkASS aZkASS = aYUAbz.f1538A2egSU;
        int i2 = 0;
        if (i < 24) {
            A4TApA2 = aZkASS.isEmpty() ? C2rE4F.AYUAbz.f1537A4TApA : C2rE4F.AYUAbz.A4TApA(BniPrB.A4TApA(aZkASS.get(0)));
        } else if (aZkASS.isEmpty()) {
            A4TApA2 = C2rE4F.AYUAbz.f1537A4TApA;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (i2 < BPw6Q82.f1538A2egSU.size() + aZkASS.size()) {
                Locale locale = i2 < aZkASS.size() ? aZkASS.get(i2) : BPw6Q82.f1538A2egSU.get(i2 - aZkASS.size());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i2++;
            }
            A4TApA2 = C2rE4F.AYUAbz.A2egSU((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
        }
        return A4TApA2.f1538A2egSU.isEmpty() ? BPw6Q82 : A4TApA2;
    }

    public static Configuration B9tovu(Context context, int i, C2rE4F.AYUAbz aYUAbz, Configuration configuration, boolean z) {
        int i2 = i != 1 ? i != 2 ? z ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        if (aYUAbz != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                C2rE4F.ADYaiT(configuration2, aYUAbz);
                return configuration2;
            }
            C2rE4F.AZkASS aZkASS = aYUAbz.f1538A2egSU;
            configuration2.setLocale(aZkASS.get(0));
            configuration2.setLayoutDirection(aZkASS.get(0));
        }
        return configuration2;
    }

    public static C2rE4F.AYUAbz BPw6Q8(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? C2rE4F.A4TApA(configuration) : C2rE4F.AYUAbz.A4TApA(BniPrB.A4TApA(configuration.locale));
    }

    private static /* synthetic */ void ycvf() {
        char[] charArray = "¾²°óº¼°¸ó¿²¤ó®µ¸±±ó\u0097³´\u009f¯´¹º¸".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 221);
        }
        String str = new String(charArray);
        char[] charArray2 = "¾±´³´©".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 221);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // ADYaiT.BJ7GGh
    public final void A2egSU() {
        if (this.f161BNL6CD != null) {
            BV3sI0();
            if (this.f161BNL6CD.ARc23Z()) {
                return;
            }
            BmvVmW(0);
        }
    }

    @Override // ADYaiT.BJ7GGh
    public final void A5SV6n() {
        String str;
        this.f186D6yqiO = true;
        AzWtSf(false, true);
        BJ7GGh();
        Object obj = this.f156B9tovu;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    str = androidx.core.app.AaHO0E.A5SV6n(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                A2egSU a2egSU = this.f161BNL6CD;
                if (a2egSU == null) {
                    this.f198DdagTj = true;
                } else {
                    a2egSU.AcNBzu(true);
                }
            }
            synchronized (BJ7GGh.f104B4ZgIw) {
                BJ7GGh.AMqCpz(this);
                BJ7GGh.f103B3GDIM.add(new WeakReference(this));
            }
        }
        this.f189D9tr6l = new Configuration(this.f157BChYOn.getResources().getConfiguration());
        this.f187D8MqeW = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // ADYaiT.BJ7GGh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ADYaiT() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f156B9tovu
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = ADYaiT.BJ7GGh.f104B4ZgIw
            monitor-enter(r0)
            ADYaiT.BJ7GGh.AMqCpz(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r1
        L11:
            boolean r0 = r3.DXuj49
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.f158BI9f7h
            android.view.View r0 = r0.getDecorView()
            ADYaiT.BNL6CD r1 = r3.f197DcUJf1
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.f188D8cQ8b = r0
            int r0 = r3.f190DAk1zC
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.f156B9tovu
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            B25kr6.AzWtSf r0 = ADYaiT.CkXcdM.f153DvK7DB
            java.lang.Object r1 = r3.f156B9tovu
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f190DAk1zC
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            B25kr6.AzWtSf r0 = ADYaiT.CkXcdM.f153DvK7DB
            java.lang.Object r1 = r3.f156B9tovu
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            ADYaiT.A2egSU r0 = r3.f161BNL6CD
            if (r0 == 0) goto L63
            r0.AYUAbz()
        L63:
            ADYaiT.CSDoyG r0 = r3.f194DV2E8K
            if (r0 == 0) goto L6a
            r0.ADYaiT()
        L6a:
            ADYaiT.CSDoyG r0 = r3.f195DXnQ0V
            if (r0 == 0) goto L71
            r0.ADYaiT()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ADYaiT.CkXcdM.ADYaiT():void");
    }

    @Override // ADYaiT.BJ7GGh
    public final boolean ARc23Z(int i) {
        if (i == 8) {
            i = 108;
        } else if (i == 9) {
            i = AdEventType.AD_RENDER_SUCCESS;
        }
        if (this.f181CrfGsy && i == 108) {
            return false;
        }
        if (this.f177CikNvS && i == 1) {
            this.f177CikNvS = false;
        }
        if (i == 1) {
            CNPG0E();
            this.f181CrfGsy = true;
            return true;
        }
        if (i == 2) {
            CNPG0E();
            this.f175CcAIMM = true;
            return true;
        }
        if (i == 5) {
            CNPG0E();
            this.f176Cd8JRx = true;
            return true;
        }
        if (i == 10) {
            CNPG0E();
            this.f179CmUvjW = true;
            return true;
        }
        if (i == 108) {
            CNPG0E();
            this.f177CikNvS = true;
            return true;
        }
        if (i != 109) {
            return this.f158BI9f7h.requestFeature(i);
        }
        CNPG0E();
        this.f178CkXcdM = true;
        return true;
    }

    @Override // ADYaiT.BJ7GGh
    public final void ASJ6gh(int i) {
        BIYEnU();
        ViewGroup viewGroup = (ViewGroup) this.f172CQhlFr.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f157BChYOn).inflate(i, viewGroup);
        this.f159BIYEnU.A2egSU(this.f158BI9f7h.getCallback());
    }

    @Override // ADYaiT.BJ7GGh
    public final void AYUAbz(View view) {
        BIYEnU();
        ViewGroup viewGroup = (ViewGroup) this.f172CQhlFr.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f159BIYEnU.A2egSU(this.f158BI9f7h.getCallback());
    }

    @Override // ADYaiT.BJ7GGh
    public final void AZOQYO(View view, ViewGroup.LayoutParams layoutParams) {
        BIYEnU();
        ViewGroup viewGroup = (ViewGroup) this.f172CQhlFr.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f159BIYEnU.A2egSU(this.f158BI9f7h.getCallback());
    }

    @Override // AZkASS.AcNBzu
    public final boolean AZkASS(AZkASS.AmA8tU amA8tU, MenuItem menuItem) {
        CikNvS cikNvS;
        Window.Callback callback = this.f158BI9f7h.getCallback();
        if (callback != null && !this.f188D8cQ8b) {
            AZkASS.AmA8tU AaHO0E2 = amA8tU.AaHO0E();
            CikNvS[] cikNvSArr = this.f183CtxOCS;
            int length = cikNvSArr != null ? cikNvSArr.length : 0;
            int i = 0;
            while (true) {
                if (i < length) {
                    cikNvS = cikNvSArr[i];
                    if (cikNvS != null && cikNvS.f144AYUAbz == AaHO0E2) {
                        break;
                    }
                    i++;
                } else {
                    cikNvS = null;
                    break;
                }
            }
            if (cikNvS != null) {
                return callback.onMenuItemSelected(cikNvS.f138A2egSU, menuItem);
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
    
        if (r6.AlLFFp() != false) goto L20;
     */
    @Override // AZkASS.AcNBzu
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AcNBzu(AZkASS.AmA8tU r6) {
        /*
            r5 = this;
            AaHO0E.DuwtYk r6 = r5.f164BV3sI0
            r0 = 1
            r1 = 0
            if (r6 == 0) goto Ld3
            androidx.appcompat.widget.ActionBarOverlayLayout r6 = (androidx.appcompat.widget.ActionBarOverlayLayout) r6
            r6.AMqCpz()
            AaHO0E.DvK7DB r6 = r6.f8113B25kr6
            AaHO0E.H6qKiO r6 = (AaHO0E.H6qKiO) r6
            androidx.appcompat.widget.Toolbar r6 = r6.f898A2egSU
            int r2 = r6.getVisibility()
            if (r2 != 0) goto Ld3
            androidx.appcompat.widget.ActionMenuView r6 = r6.f8219AcNBzu
            if (r6 == 0) goto Ld3
            boolean r6 = r6.f8139BmvVmW
            if (r6 == 0) goto Ld3
            android.content.Context r6 = r5.f157BChYOn
            android.view.ViewConfiguration r6 = android.view.ViewConfiguration.get(r6)
            boolean r6 = r6.hasPermanentMenuKey()
            if (r6 == 0) goto L4a
            AaHO0E.DuwtYk r6 = r5.f164BV3sI0
            androidx.appcompat.widget.ActionBarOverlayLayout r6 = (androidx.appcompat.widget.ActionBarOverlayLayout) r6
            r6.AMqCpz()
            AaHO0E.DvK7DB r6 = r6.f8113B25kr6
            AaHO0E.H6qKiO r6 = (AaHO0E.H6qKiO) r6
            androidx.appcompat.widget.Toolbar r6 = r6.f898A2egSU
            androidx.appcompat.widget.ActionMenuView r6 = r6.f8219AcNBzu
            if (r6 == 0) goto Ld3
            AaHO0E.AzWtSf r6 = r6.f8140BniPrB
            if (r6 == 0) goto Ld3
            AaHO0E.AZkASS r2 = r6.f622C2rE4F
            if (r2 != 0) goto L4a
            boolean r6 = r6.AlLFFp()
            if (r6 == 0) goto Ld3
        L4a:
            android.view.Window r6 = r5.f158BI9f7h
            android.view.Window$Callback r6 = r6.getCallback()
            AaHO0E.DuwtYk r2 = r5.f164BV3sI0
            androidx.appcompat.widget.ActionBarOverlayLayout r2 = (androidx.appcompat.widget.ActionBarOverlayLayout) r2
            r2.AMqCpz()
            AaHO0E.DvK7DB r2 = r2.f8113B25kr6
            AaHO0E.H6qKiO r2 = (AaHO0E.H6qKiO) r2
            androidx.appcompat.widget.Toolbar r2 = r2.f898A2egSU
            boolean r2 = r2.B25kr6()
            r3 = 108(0x6c, float:1.51E-43)
            if (r2 == 0) goto L8c
            AaHO0E.DuwtYk r0 = r5.f164BV3sI0
            androidx.appcompat.widget.ActionBarOverlayLayout r0 = (androidx.appcompat.widget.ActionBarOverlayLayout) r0
            r0.AMqCpz()
            AaHO0E.DvK7DB r0 = r0.f8113B25kr6
            AaHO0E.H6qKiO r0 = (AaHO0E.H6qKiO) r0
            androidx.appcompat.widget.Toolbar r0 = r0.f898A2egSU
            androidx.appcompat.widget.ActionMenuView r0 = r0.f8219AcNBzu
            if (r0 == 0) goto L7e
            AaHO0E.AzWtSf r0 = r0.f8140BniPrB
            if (r0 == 0) goto L7e
            boolean r0 = r0.AcNBzu()
        L7e:
            boolean r0 = r5.f188D8cQ8b
            if (r0 != 0) goto Ld2
            ADYaiT.CikNvS r0 = r5.BTvldC(r1)
            AZkASS.AmA8tU r0 = r0.f144AYUAbz
            r6.onPanelClosed(r3, r0)
            return
        L8c:
            if (r6 == 0) goto Ld2
            boolean r2 = r5.f188D8cQ8b
            if (r2 != 0) goto Ld2
            boolean r2 = r5.DXuj49
            if (r2 == 0) goto La9
            int r2 = r5.f196DaOi9o
            r0 = r0 & r2
            if (r0 == 0) goto La9
            android.view.Window r0 = r5.f158BI9f7h
            android.view.View r0 = r0.getDecorView()
            ADYaiT.BNL6CD r2 = r5.f197DcUJf1
            r0.removeCallbacks(r2)
            r2.run()
        La9:
            ADYaiT.CikNvS r0 = r5.BTvldC(r1)
            AZkASS.AmA8tU r2 = r0.f144AYUAbz
            if (r2 == 0) goto Ld2
            boolean r4 = r0.f151AzWtSf
            if (r4 != 0) goto Ld2
            android.view.View r4 = r0.f143ASJ6gh
            boolean r1 = r6.onPreparePanel(r1, r4, r2)
            if (r1 == 0) goto Ld2
            AZkASS.AmA8tU r0 = r0.f144AYUAbz
            r6.onMenuOpened(r3, r0)
            AaHO0E.DuwtYk r6 = r5.f164BV3sI0
            androidx.appcompat.widget.ActionBarOverlayLayout r6 = (androidx.appcompat.widget.ActionBarOverlayLayout) r6
            r6.AMqCpz()
            AaHO0E.DvK7DB r6 = r6.f8113B25kr6
            AaHO0E.H6qKiO r6 = (AaHO0E.H6qKiO) r6
            androidx.appcompat.widget.Toolbar r6 = r6.f898A2egSU
            r6.BChYOn()
        Ld2:
            return
        Ld3:
            ADYaiT.CikNvS r6 = r5.BTvldC(r1)
            r6.f150AmA8tU = r0
            r5.B7CMnp(r6, r1)
            r0 = 0
            r5.C2rE4F(r6, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ADYaiT.CkXcdM.AcNBzu(AZkASS.AmA8tU):void");
    }

    @Override // ADYaiT.BJ7GGh
    public final void AlLFFp(CharSequence charSequence) {
        this.f163BTvldC = charSequence;
        DuwtYk duwtYk = this.f164BV3sI0;
        if (duwtYk != null) {
            duwtYk.setWindowTitle(charSequence);
            return;
        }
        A2egSU a2egSU = this.f161BNL6CD;
        if (a2egSU != null) {
            a2egSU.B2KMhB(charSequence);
            return;
        }
        TextView textView = this.f173CSDoyG;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0049  */
    /* JADX WARN: Type inference failed for: r4v0, types: [ADYaiT.B3GDIM, java.lang.Object] */
    @Override // ADYaiT.BJ7GGh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final AZOQYO.A4TApA AmA8tU(AZOQYO.A2egSU r10) {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ADYaiT.CkXcdM.AmA8tU(AZOQYO.A2egSU):AZOQYO.A4TApA");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0199  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean AzWtSf(boolean r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ADYaiT.CkXcdM.AzWtSf(boolean, boolean):boolean");
    }

    public final void B25kr6(Window window) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback;
        if (this.f158BI9f7h != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof CQhlFr) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        CQhlFr cQhlFr = new CQhlFr(this, callback);
        this.f159BIYEnU = cQhlFr;
        window.setCallback(cQhlFr);
        GYpKKt AMqCpz = GYpKKt.AMqCpz(this.f157BChYOn, null, f154DyaChj);
        Drawable A5SV6n2 = AMqCpz.A5SV6n(0);
        if (A5SV6n2 != null) {
            window.setBackgroundDrawable(A5SV6n2);
        }
        AMqCpz.ASJ6gh();
        this.f158BI9f7h = window;
        if (Build.VERSION.SDK_INT < 33 || (onBackInvokedDispatcher = this.f201Dphsd2) != null) {
            return;
        }
        if (onBackInvokedDispatcher != null && (onBackInvokedCallback = this.f202DuwtYk) != null) {
            COJEAR.A5SV6n(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f202DuwtYk = null;
        }
        Object obj = this.f156B9tovu;
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            if (activity.getWindow() != null) {
                this.f201Dphsd2 = COJEAR.A2egSU(activity);
                COJEAR();
            }
        }
        this.f201Dphsd2 = null;
        COJEAR();
    }

    public final void B3GDIM(int i, CikNvS cikNvS, AZkASS.AmA8tU amA8tU) {
        if (amA8tU == null) {
            if (cikNvS == null && i >= 0) {
                CikNvS[] cikNvSArr = this.f183CtxOCS;
                if (i < cikNvSArr.length) {
                    cikNvS = cikNvSArr[i];
                }
            }
            if (cikNvS != null) {
                amA8tU = cikNvS.f144AYUAbz;
            }
        }
        if ((cikNvS == null || cikNvS.f149AlLFFp) && !this.f188D8cQ8b) {
            CQhlFr cQhlFr = this.f159BIYEnU;
            Window.Callback callback = this.f158BI9f7h.getCallback();
            cQhlFr.getClass();
            try {
                cQhlFr.f128B25kr6 = true;
                callback.onPanelClosed(i, amA8tU);
            } finally {
                cQhlFr.f128B25kr6 = false;
            }
        }
    }

    public final void B4ZgIw(AZkASS.AmA8tU amA8tU) {
        AaHO0E.AzWtSf azWtSf;
        if (this.f182CtFAbx) {
            return;
        }
        this.f182CtFAbx = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f164BV3sI0;
        actionBarOverlayLayout.AMqCpz();
        ActionMenuView actionMenuView = ((H6qKiO) actionBarOverlayLayout.f8113B25kr6).f898A2egSU.f8219AcNBzu;
        if (actionMenuView != null && (azWtSf = actionMenuView.f8140BniPrB) != null) {
            azWtSf.AcNBzu();
            AaHO0E.AYUAbz aYUAbz = azWtSf.BpkvW3;
            if (aYUAbz != null && aYUAbz.A4TApA()) {
                aYUAbz.f568AZOQYO.dismiss();
            }
        }
        Window.Callback callback = this.f158BI9f7h.getCallback();
        if (callback != null && !this.f188D8cQ8b) {
            callback.onPanelClosed(108, amA8tU);
        }
        this.f182CtFAbx = false;
    }

    public final void B7CMnp(CikNvS cikNvS, boolean z) {
        Cd8JRx cd8JRx;
        DuwtYk duwtYk;
        if (z && cikNvS.f138A2egSU == 0 && (duwtYk = this.f164BV3sI0) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) duwtYk;
            actionBarOverlayLayout.AMqCpz();
            if (((H6qKiO) actionBarOverlayLayout.f8113B25kr6).f898A2egSU.B25kr6()) {
                B4ZgIw(cikNvS.f144AYUAbz);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.f157BChYOn.getSystemService("window");
        if (windowManager != null && cikNvS.f149AlLFFp && (cd8JRx = cikNvS.AMqCpz) != null) {
            windowManager.removeView(cd8JRx);
            if (z) {
                B3GDIM(cikNvS.f138A2egSU, cikNvS, null);
            }
        }
        cikNvS.f147AaHO0E = false;
        cikNvS.f148AcNBzu = false;
        cikNvS.f149AlLFFp = false;
        cikNvS.f142ARc23Z = null;
        cikNvS.f150AmA8tU = true;
        if (this.f184D07BeM == cikNvS) {
            this.f184D07BeM = null;
        }
        if (cikNvS.f138A2egSU == 0) {
            COJEAR();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
    
        if (r4.dispatchKeyEvent(r7) != false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00f0, code lost:
    
        if (r7.AcNBzu() != false) goto L81;
     */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean BChYOn(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ADYaiT.CkXcdM.BChYOn(android.view.KeyEvent):boolean");
    }

    public final void BI9f7h(int i) {
        CikNvS BTvldC2 = BTvldC(i);
        if (BTvldC2.f144AYUAbz != null) {
            Bundle bundle = new Bundle();
            BTvldC2.f144AYUAbz.B9tovu(bundle);
            if (bundle.size() > 0) {
                BTvldC2.f152B25kr6 = bundle;
            }
            BTvldC2.f144AYUAbz.BJ7GGh();
            BTvldC2.f144AYUAbz.clear();
        }
        BTvldC2.f151AzWtSf = true;
        BTvldC2.f150AmA8tU = true;
        if ((i == 108 || i == 0) && this.f164BV3sI0 != null) {
            CikNvS BTvldC3 = BTvldC(0);
            BTvldC3.f147AaHO0E = false;
            CASmeH(BTvldC3, null);
        }
    }

    public final void BIYEnU() {
        ViewGroup viewGroup;
        if (this.f171COJEAR) {
            return;
        }
        int[] iArr = R$styleable.f8022AZkASS;
        Context context = this.f157BChYOn;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!obtainStyledAttributes.hasValue(117)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(126, false)) {
            ARc23Z(1);
        } else if (obtainStyledAttributes.getBoolean(117, false)) {
            ARc23Z(108);
        }
        if (obtainStyledAttributes.getBoolean(TTVideoEngine.PLAYER_BUFFERING_DATA_OF_MILLISECONDS, false)) {
            ARc23Z(AdEventType.AD_RENDER_SUCCESS);
        }
        if (obtainStyledAttributes.getBoolean(119, false)) {
            ARc23Z(10);
        }
        this.f180CqNSpT = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        BJ7GGh();
        this.f158BI9f7h.getDecorView();
        LayoutInflater from = LayoutInflater.from(context);
        if (this.f181CrfGsy) {
            viewGroup = this.f179CmUvjW ? (ViewGroup) from.inflate(2131492888, (ViewGroup) null) : (ViewGroup) from.inflate(2131492887, (ViewGroup) null);
        } else if (this.f180CqNSpT) {
            viewGroup = (ViewGroup) from.inflate(2131492878, (ViewGroup) null);
            this.f178CkXcdM = false;
            this.f177CikNvS = false;
        } else if (this.f177CikNvS) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(2130968587, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new AZOQYO.ADYaiT(context, typedValue.resourceId) : context).inflate(2131492889, (ViewGroup) null);
            DuwtYk duwtYk = (DuwtYk) viewGroup.findViewById(2131296565);
            this.f164BV3sI0 = duwtYk;
            duwtYk.setWindowCallback(this.f158BI9f7h.getCallback());
            if (this.f178CkXcdM) {
                ((ActionBarOverlayLayout) this.f164BV3sI0).ADYaiT(AdEventType.AD_RENDER_SUCCESS);
            }
            if (this.f175CcAIMM) {
                ((ActionBarOverlayLayout) this.f164BV3sI0).ADYaiT(2);
            }
            if (this.f176Cd8JRx) {
                ((ActionBarOverlayLayout) this.f164BV3sI0).ADYaiT(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f177CikNvS + ", windowActionBarOverlay: " + this.f178CkXcdM + ", android:windowIsFloating: " + this.f180CqNSpT + ", windowActionModeOverlay: " + this.f179CmUvjW + ", windowNoTitle: " + this.f181CrfGsy + " }");
        }
        BPw6Q8 bPw6Q8 = new BPw6Q8(this);
        WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
        COJEAR.CmUvjW.B9tovu(viewGroup, bPw6Q8);
        if (this.f164BV3sI0 == null) {
            this.f173CSDoyG = (TextView) viewGroup.findViewById(2131298106);
        }
        boolean z = HSHyT0.f933A2egSU;
        try {
            Method method = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(viewGroup, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(2131296320);
        ViewGroup viewGroup2 = (ViewGroup) this.f158BI9f7h.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f158BI9f7h.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new BTvldC(this));
        this.f172CQhlFr = viewGroup;
        Object obj = this.f156B9tovu;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.f163BTvldC;
        if (!TextUtils.isEmpty(title)) {
            DuwtYk duwtYk2 = this.f164BV3sI0;
            if (duwtYk2 != null) {
                duwtYk2.setWindowTitle(title);
            } else {
                A2egSU a2egSU = this.f161BNL6CD;
                if (a2egSU != null) {
                    a2egSU.B2KMhB(title);
                } else {
                    TextView textView = this.f173CSDoyG;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.f172CQhlFr.findViewById(R.id.content);
        View decorView = this.f158BI9f7h.getDecorView();
        contentFrameLayout2.f8170B3GDIM.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        if (contentFrameLayout2.isLaidOut()) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(iArr);
        obtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
        obtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
        if (obtainStyledAttributes2.hasValue(122)) {
            obtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
        }
        if (obtainStyledAttributes2.hasValue(123)) {
            obtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
        }
        if (obtainStyledAttributes2.hasValue(AVMDLDataLoaderConfigure.DEFAULT_SOCKET_IDLE_TIMEOUT)) {
            obtainStyledAttributes2.getValue(AVMDLDataLoaderConfigure.DEFAULT_SOCKET_IDLE_TIMEOUT, contentFrameLayout2.getFixedHeightMajor());
        }
        if (obtainStyledAttributes2.hasValue(121)) {
            obtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
        }
        obtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.f171COJEAR = true;
        CikNvS BTvldC2 = BTvldC(0);
        if (this.f188D8cQ8b || BTvldC2.f144AYUAbz != null) {
            return;
        }
        BmvVmW(108);
    }

    public final void BJ7GGh() {
        if (this.f158BI9f7h == null) {
            Object obj = this.f156B9tovu;
            if (obj instanceof Activity) {
                B25kr6(((Activity) obj).getWindow());
            }
        }
        if (this.f158BI9f7h == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final CcAIMM BNL6CD(Context context) {
        if (this.f194DV2E8K == null) {
            if (DUi7mC.f237B25kr6 == null) {
                Context applicationContext = context.getApplicationContext();
                DUi7mC.f237B25kr6 = new DUi7mC(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.f194DV2E8K = new CSDoyG(this, DUi7mC.f237B25kr6);
        }
        return this.f194DV2E8K;
    }

    public final CikNvS BTvldC(int i) {
        CikNvS[] cikNvSArr = this.f183CtxOCS;
        if (cikNvSArr == null || cikNvSArr.length <= i) {
            CikNvS[] cikNvSArr2 = new CikNvS[i + 1];
            if (cikNvSArr != null) {
                System.arraycopy(cikNvSArr, 0, cikNvSArr2, 0, cikNvSArr.length);
            }
            this.f183CtxOCS = cikNvSArr2;
            cikNvSArr = cikNvSArr2;
        }
        CikNvS cikNvS = cikNvSArr[i];
        if (cikNvS != null) {
            return cikNvS;
        }
        CikNvS cikNvS2 = new CikNvS();
        cikNvS2.f138A2egSU = i;
        cikNvS2.f150AmA8tU = false;
        cikNvSArr[i] = cikNvS2;
        return cikNvS2;
    }

    public final void BV3sI0() {
        BIYEnU();
        if (this.f177CikNvS && this.f161BNL6CD == null) {
            Object obj = this.f156B9tovu;
            if (obj instanceof Activity) {
                this.f161BNL6CD = new DXuj49((Activity) obj, this.f178CkXcdM);
            } else if (obj instanceof Dialog) {
                this.f161BNL6CD = new DXuj49((Dialog) obj);
            }
            A2egSU a2egSU = this.f161BNL6CD;
            if (a2egSU != null) {
                a2egSU.AcNBzu(this.f198DdagTj);
            }
        }
    }

    public final void BmvVmW(int i) {
        this.f196DaOi9o = (1 << i) | this.f196DaOi9o;
        if (this.DXuj49) {
            return;
        }
        View decorView = this.f158BI9f7h.getDecorView();
        BNL6CD bnl6cd = this.f197DcUJf1;
        WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
        decorView.postOnAnimation(bnl6cd);
        this.DXuj49 = true;
    }

    public final int BniPrB(Context context, int i) {
        if (i != -100) {
            if (i != -1) {
                if (i != 0) {
                    if (i != 1 && i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                        }
                        if (this.f195DXnQ0V == null) {
                            this.f195DXnQ0V = new CSDoyG(this, context);
                        }
                        return this.f195DXnQ0V.ARc23Z();
                    }
                } else if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return BNL6CD(context).ARc23Z();
                }
            }
            return i;
        }
        return -1;
    }

    public final boolean BpkvW3() {
        boolean z = this.f185D6DOie;
        this.f185D6DOie = false;
        CikNvS BTvldC2 = BTvldC(0);
        if (!BTvldC2.f149AlLFFp) {
            AZOQYO.A4TApA a4TApA = this.BpkvW3;
            if (a4TApA != null) {
                a4TApA.A2egSU();
                return true;
            }
            BV3sI0();
            A2egSU a2egSU = this.f161BNL6CD;
            if (a2egSU == null || !a2egSU.A4TApA()) {
                return false;
            }
        } else if (!z) {
            B7CMnp(BTvldC2, true);
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0175, code lost:
    
        if (r3.f486B2KMhB.getCount() > 0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0155, code lost:
    
        if (r3 != null) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C2rE4F(ADYaiT.CikNvS r18, android.view.KeyEvent r19) {
        /*
            Method dump skipped, instructions count: 473
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ADYaiT.CkXcdM.C2rE4F(ADYaiT.CikNvS, android.view.KeyEvent):void");
    }

    public final boolean C4FrIb(CikNvS cikNvS, int i, KeyEvent keyEvent) {
        AZkASS.AmA8tU amA8tU;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((cikNvS.f147AaHO0E || CASmeH(cikNvS, keyEvent)) && (amA8tU = cikNvS.f144AYUAbz) != null) {
            return amA8tU.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d5, code lost:
    
        if (r13.f144AYUAbz == null) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean CASmeH(ADYaiT.CikNvS r13, android.view.KeyEvent r14) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ADYaiT.CkXcdM.CASmeH(ADYaiT.CikNvS, android.view.KeyEvent):boolean");
    }

    public final void CNPG0E() {
        if (this.f171COJEAR) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void COJEAR() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z = false;
            if (this.f201Dphsd2 != null && (BTvldC(0).f149AlLFFp || this.BpkvW3 != null)) {
                z = true;
            }
            if (z && this.f202DuwtYk == null) {
                this.f202DuwtYk = COJEAR.A4TApA(this.f201Dphsd2, this);
            } else {
                if (z || (onBackInvokedCallback = this.f202DuwtYk) == null) {
                    return;
                }
                COJEAR.A5SV6n(this.f201Dphsd2, onBackInvokedCallback);
                this.f202DuwtYk = null;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x00f1, code lost:
    
        if (r13.equals("ImageButton") == false) goto L20;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.view.LayoutInflater.Factory2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onCreateView(android.view.View r12, java.lang.String r13, android.content.Context r14, android.util.AttributeSet r15) {
        /*
            Method dump skipped, instructions count: 694
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ADYaiT.CkXcdM.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
