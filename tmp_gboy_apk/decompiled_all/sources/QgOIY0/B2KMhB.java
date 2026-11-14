package QgOIY0;

import ADYaiT.CtFAbx;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sigmob.sdk.base.views.r;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class B2KMhB implements ComponentCallbacks, View.OnCreateContextMenuListener {

    /* renamed from: CtFAbx, reason: collision with root package name */
    public static final QkAq4X.AYUAbz f7550CtFAbx = new QkAq4X.AYUAbz();

    /* renamed from: CtxOCS, reason: collision with root package name */
    public static final Object f7551CtxOCS = new Object();

    /* renamed from: AcNBzu, reason: collision with root package name */
    public B3GDIM f7552AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public BNL6CD f7553AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public BPw6Q8 f7554AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public B2KMhB f7555AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f7556B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f7557B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public String f7558B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f7559B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f7560B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f7561B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public boolean f7562BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public boolean f7563BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public ViewGroup f7564BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public boolean f7565BJ7GGh;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public CcAIMM f7567BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public boolean f7568BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public boolean f7569BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public B25kr6 f7570BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public boolean f7571BniPrB;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public Bundle f7572C2rE4F;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public SparseArray f7573C4FrIb;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public String f7575CNPG0E;

    /* renamed from: COJEAR, reason: collision with root package name */
    public Bundle f7576COJEAR;

    /* renamed from: CQhlFr, reason: collision with root package name */
    public B2KMhB f7577CQhlFr;

    /* renamed from: CTkVKb, reason: collision with root package name */
    public int f7579CTkVKb;

    /* renamed from: CcAIMM, reason: collision with root package name */
    public boolean f7580CcAIMM;

    /* renamed from: Cd8JRx, reason: collision with root package name */
    public boolean f7581Cd8JRx;

    /* renamed from: CikNvS, reason: collision with root package name */
    public boolean f7582CikNvS;

    /* renamed from: CkXcdM, reason: collision with root package name */
    public boolean f7583CkXcdM;

    /* renamed from: CmUvjW, reason: collision with root package name */
    public boolean f7584CmUvjW;

    /* renamed from: CqNSpT, reason: collision with root package name */
    public int f7585CqNSpT;

    /* renamed from: CrfGsy, reason: collision with root package name */
    public BNL6CD f7586CrfGsy;
    public int BpkvW3 = 0;

    /* renamed from: CASmeH, reason: collision with root package name */
    public int f7574CASmeH = -1;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public int f7578CSDoyG = -1;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public boolean f7566BNL6CD = true;

    static {
        OQez();
    }

    public static B2KMhB A5SV6n(Context context, String str, Bundle bundle) {
        try {
            QkAq4X.AYUAbz aYUAbz = f7550CtFAbx;
            Class<?> cls = (Class) aYUAbz.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                aYUAbz.put(str, cls);
            }
            B2KMhB b2KMhB = (B2KMhB) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(b2KMhB.getClass().getClassLoader());
                b2KMhB.f7576COJEAR = bundle;
            }
            return b2KMhB;
        } catch (ClassNotFoundException e) {
            throw new DXnQ0V.A5SV6n(CtFAbx.BI9f7h("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
        } catch (IllegalAccessException e2) {
            throw new DXnQ0V.A5SV6n(CtFAbx.BI9f7h("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (InstantiationException e3) {
            throw new DXnQ0V.A5SV6n(CtFAbx.BI9f7h("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e3);
        }
    }

    private static /* synthetic */ void OQez() {
        char[] charArray = "p|~=tr~v=q|j=`{v\u007f\u007f=Y}zQazwtv".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 19);
        }
        String str = new String(charArray);
        char[] charArray2 = "p\u007fz}zg".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 19);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU() {
        if (this.f7552AcNBzu == null) {
            throw new IllegalStateException("Fragment has not been attached yet.");
        }
        BNL6CD bnl6cd = new BNL6CD();
        this.f7553AlLFFp = bnl6cd;
        B3GDIM b3gdim = this.f7552AcNBzu;
        AzWtSf azWtSf = new AzWtSf(this);
        if (bnl6cd.f7620AcNBzu != null) {
            throw new IllegalStateException("Already attached");
        }
        bnl6cd.f7620AcNBzu = b3gdim;
        bnl6cd.f7621AlLFFp = azWtSf;
        bnl6cd.f7622AmA8tU = this;
    }

    public final int A4TApA() {
        B25kr6 b25kr6 = this.f7570BmvVmW;
        if (b25kr6 == null) {
            return 0;
        }
        return b25kr6.f7545A2egSU;
    }

    public final void ADYaiT(int i, B2KMhB b2KMhB) {
        this.f7574CASmeH = i;
        if (b2KMhB == null) {
            this.f7575CNPG0E = "android:fragment:" + this.f7574CASmeH;
        } else {
            this.f7575CNPG0E = b2KMhB.f7575CNPG0E + ":" + this.f7574CASmeH;
        }
    }

    public void AMqCpz(B7CMnp b7CMnp) {
        this.f7563BI9f7h = true;
        B3GDIM b3gdim = this.f7552AcNBzu;
        if ((b3gdim == null ? null : b3gdim.f7587A2egSU) != null) {
            this.f7563BI9f7h = true;
        }
    }

    public void ARc23Z(Bundle bundle) {
        this.f7563BI9f7h = true;
        B2KMhB(bundle);
        BNL6CD bnl6cd = this.f7553AlLFFp;
        if (bnl6cd == null || bnl6cd.f7619AaHO0E >= 1) {
            return;
        }
        bnl6cd.f7623AzWtSf = false;
        bnl6cd.f7612A5SV6n = true;
        bnl6cd.A2egSU(1, false);
        bnl6cd.f7612A5SV6n = false;
    }

    public void ASJ6gh() {
    }

    public final B25kr6 AYUAbz() {
        if (this.f7570BmvVmW == null) {
            B25kr6 b25kr6 = new B25kr6();
            Object obj = f7551CtxOCS;
            b25kr6.f7548ADYaiT = obj;
            b25kr6.AMqCpz = obj;
            b25kr6.f7549ARc23Z = obj;
            this.f7570BmvVmW = b25kr6;
        }
        return this.f7570BmvVmW;
    }

    public LayoutInflater AZOQYO(Bundle bundle) {
        B7CMnp b7CMnp = this.f7552AcNBzu.f7595AZkASS;
        LayoutInflater cloneInContext = b7CMnp.getLayoutInflater().cloneInContext(b7CMnp);
        if (this.f7553AlLFFp == null) {
            A2egSU();
            int i = this.BpkvW3;
            if (i >= 5) {
                BNL6CD bnl6cd = this.f7553AlLFFp;
                bnl6cd.f7623AzWtSf = false;
                bnl6cd.f7612A5SV6n = true;
                bnl6cd.A2egSU(5, false);
                bnl6cd.f7612A5SV6n = false;
            } else if (i >= 4) {
                BNL6CD bnl6cd2 = this.f7553AlLFFp;
                bnl6cd2.f7623AzWtSf = false;
                bnl6cd2.f7612A5SV6n = true;
                bnl6cd2.A2egSU(4, false);
                bnl6cd2.f7612A5SV6n = false;
            } else if (i >= 2) {
                BNL6CD bnl6cd3 = this.f7553AlLFFp;
                bnl6cd3.f7623AzWtSf = false;
                bnl6cd3.f7612A5SV6n = true;
                bnl6cd3.A2egSU(2, false);
                bnl6cd3.f7612A5SV6n = false;
            } else if (i >= 1) {
                BNL6CD bnl6cd4 = this.f7553AlLFFp;
                bnl6cd4.f7623AzWtSf = false;
                bnl6cd4.f7612A5SV6n = true;
                bnl6cd4.A2egSU(1, false);
                bnl6cd4.f7612A5SV6n = false;
            }
        }
        BNL6CD bnl6cd5 = this.f7553AlLFFp;
        bnl6cd5.getClass();
        cloneInContext.setFactory2(new QmCR4D.A2egSU(bnl6cd5));
        return cloneInContext;
    }

    public final void AZkASS(int i) {
        if (this.f7570BmvVmW == null && i == 0) {
            return;
        }
        AYUAbz().f7545A2egSU = i;
    }

    public void AaHO0E(Bundle bundle) {
        this.f7563BI9f7h = true;
    }

    public void AcNBzu() {
        this.f7563BI9f7h = true;
    }

    public void AlLFFp(Bundle bundle) {
    }

    public void AmA8tU() {
        this.f7563BI9f7h = true;
        if (this.f7568BTvldC) {
            return;
        }
        this.f7568BTvldC = true;
        if (!this.f7569BV3sI0) {
            this.f7569BV3sI0 = true;
            this.f7567BPw6Q8 = this.f7552AcNBzu.A5SV6n(this.f7575CNPG0E, true, false);
        }
        CcAIMM ccAIMM = this.f7567BPw6Q8;
        if (ccAIMM != null) {
            ccAIMM.A5SV6n();
        }
    }

    public void AzWtSf() {
        this.f7563BI9f7h = true;
    }

    public void B25kr6() {
        this.f7563BI9f7h = true;
    }

    public final void B2KMhB(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        if (this.f7553AlLFFp == null) {
            A2egSU();
        }
        this.f7553AlLFFp.ARc23Z(parcelable, this.f7554AmA8tU);
        this.f7554AmA8tU = null;
        BNL6CD bnl6cd = this.f7553AlLFFp;
        bnl6cd.f7623AzWtSf = false;
        bnl6cd.f7612A5SV6n = true;
        bnl6cd.A2egSU(1, false);
        bnl6cd.f7612A5SV6n = false;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        this.f7563BI9f7h = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        B3GDIM b3gdim = this.f7552AcNBzu;
        (b3gdim == null ? null : b3gdim.f7587A2egSU).onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.f7563BI9f7h = true;
    }

    public void startActivityForResult(Intent intent, int i) {
        B3GDIM b3gdim = this.f7552AcNBzu;
        if (b3gdim == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        B7CMnp b7CMnp = b3gdim.f7595AZkASS;
        b7CMnp.f7534AcNBzu = true;
        try {
            if (i == -1) {
                b7CMnp.startActivityForResult(intent, -1, null);
            } else {
                AlLFFp.A2egSU(i);
                b7CMnp.startActivityForResult(intent, ((b7CMnp.ADYaiT(this) + 1) << 16) + (i & 65535), null);
            }
        } finally {
            b7CMnp.f7534AcNBzu = false;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(r.b.d);
        QkAq4X.ADYaiT.A4TApA(this, sb);
        if (this.f7574CASmeH >= 0) {
            sb.append(" #");
            sb.append(this.f7574CASmeH);
        }
        if (this.f7556B25kr6 != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f7556B25kr6));
        }
        if (this.f7558B3GDIM != null) {
            sb.append(" ");
            sb.append(this.f7558B3GDIM);
        }
        sb.append('}');
        return sb.toString();
    }
}
