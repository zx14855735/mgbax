package AZOQYO;

import ADYaiT.CtFAbx;
import AZkASS.B25kr6;
import AZkASS.B9tovu;
import COJEAR.B4ZgIw;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Menu f372A2egSU;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public boolean f378AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public int f379AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public int f380AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public CharSequence f381AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public CharSequence f382AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public int f383AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public char f384AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f385AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public char f386B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f387B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f388B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f389B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f390B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f391B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public int f392BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f393BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public String f394BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public String f395BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public COJEAR.A5SV6n f396BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public CharSequence f397BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public CharSequence f398BTvldC;

    /* renamed from: BniPrB, reason: collision with root package name */
    public final /* synthetic */ AZkASS f401BniPrB;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public ColorStateList f399BV3sI0 = null;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public PorterDuff.Mode f400BmvVmW = null;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f373A4TApA = 0;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f374A5SV6n = 0;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f375ADYaiT = 0;
    public int AMqCpz = 0;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f376ARc23Z = true;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f377ASJ6gh = true;

    public AZOQYO(AZkASS aZkASS, Menu menu) {
        this.f401BniPrB = aZkASS;
        this.f372A2egSU = menu;
    }

    public final Object A2egSU(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.f401BniPrB.f405A5SV6n.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public final void A4TApA(MenuItem menuItem) {
        boolean z = false;
        menuItem.setChecked(this.f389B4ZgIw).setVisible(this.f390B7CMnp).setEnabled(this.f391B9tovu).setCheckable(this.f388B3GDIM >= 1).setTitleCondensed(this.f382AcNBzu).setIcon(this.f383AlLFFp);
        int i = this.f392BChYOn;
        if (i >= 0) {
            menuItem.setShowAsAction(i);
        }
        String str = this.f395BJ7GGh;
        AZkASS aZkASS = this.f401BniPrB;
        if (str != null) {
            if (aZkASS.f405A5SV6n.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            if (aZkASS.f406ADYaiT == null) {
                aZkASS.f406ADYaiT = AZkASS.A2egSU(aZkASS.f405A5SV6n);
            }
            Object obj = aZkASS.f406ADYaiT;
            String str2 = this.f395BJ7GGh;
            AYUAbz aYUAbz = new AYUAbz();
            aYUAbz.f370AcNBzu = obj;
            Class<?> cls = obj.getClass();
            try {
                aYUAbz.f371AlLFFp = cls.getMethod(str2, AYUAbz.f369AmA8tU);
                menuItem.setOnMenuItemClickListener(aYUAbz);
            } catch (Exception e) {
                StringBuilder B3GDIM2 = CtFAbx.B3GDIM("Couldn't resolve menu item onClick handler ", str2, " in class ");
                B3GDIM2.append(cls.getName());
                InflateException inflateException = new InflateException(B3GDIM2.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }
        if (this.f388B3GDIM >= 2) {
            if (menuItem instanceof B25kr6) {
                ((B25kr6) menuItem).ARc23Z(true);
            } else if (menuItem instanceof B9tovu) {
                B9tovu b9tovu = (B9tovu) menuItem;
                try {
                    Method method = b9tovu.f557AzWtSf;
                    BniPrB.A2egSU a2egSU = b9tovu.f556AmA8tU;
                    if (method == null) {
                        b9tovu.f557AzWtSf = a2egSU.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                    }
                    b9tovu.f557AzWtSf.invoke(a2egSU, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
        String str3 = this.f394BIYEnU;
        if (str3 != null) {
            menuItem.setActionView((View) A2egSU(str3, AZkASS.AMqCpz, aZkASS.f403A2egSU));
            z = true;
        }
        int i2 = this.f393BI9f7h;
        if (i2 > 0 && !z) {
            menuItem.setActionView(i2);
        }
        COJEAR.A5SV6n a5SV6n = this.f396BNL6CD;
        if (a5SV6n != null && (menuItem instanceof BniPrB.A2egSU)) {
            ((BniPrB.A2egSU) menuItem).A2egSU(a5SV6n);
        }
        CharSequence charSequence = this.f397BPw6Q8;
        boolean z2 = menuItem instanceof BniPrB.A2egSU;
        if (z2) {
            ((BniPrB.A2egSU) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            B4ZgIw.AYUAbz(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.f398BTvldC;
        if (z2) {
            ((BniPrB.A2egSU) menuItem).setTooltipText(charSequence2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            B4ZgIw.AlLFFp(menuItem, charSequence2);
        }
        char c = this.f384AmA8tU;
        int i3 = this.f385AzWtSf;
        if (z2) {
            ((BniPrB.A2egSU) menuItem).setAlphabeticShortcut(c, i3);
        } else if (Build.VERSION.SDK_INT >= 26) {
            B4ZgIw.ASJ6gh(menuItem, c, i3);
        }
        char c2 = this.f386B25kr6;
        int i4 = this.f387B2KMhB;
        if (z2) {
            ((BniPrB.A2egSU) menuItem).setNumericShortcut(c2, i4);
        } else if (Build.VERSION.SDK_INT >= 26) {
            B4ZgIw.AaHO0E(menuItem, c2, i4);
        }
        PorterDuff.Mode mode = this.f400BmvVmW;
        if (mode != null) {
            if (z2) {
                ((BniPrB.A2egSU) menuItem).setIconTintMode(mode);
            } else if (Build.VERSION.SDK_INT >= 26) {
                B4ZgIw.AZkASS(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.f399BV3sI0;
        if (colorStateList != null) {
            if (z2) {
                ((BniPrB.A2egSU) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                B4ZgIw.AZOQYO(menuItem, colorStateList);
            }
        }
    }
}
