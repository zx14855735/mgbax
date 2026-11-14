package DaOi9o;

import COJEAR.CmUvjW;
import COJEAR.DG07BK;
import COJEAR.DyaChj;
import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class B4ZgIw implements Cloneable {

    /* renamed from: COJEAR, reason: collision with root package name */
    public static final Animator[] f2234COJEAR = new Animator[0];

    /* renamed from: CQhlFr, reason: collision with root package name */
    public static final int[] f2235CQhlFr = {2, 1, 3, 4};

    /* renamed from: CSDoyG, reason: collision with root package name */
    public static final B2KMhB f2236CSDoyG = new B2KMhB();

    /* renamed from: CTkVKb, reason: collision with root package name */
    public static final ThreadLocal f2237CTkVKb = new ThreadLocal();

    /* renamed from: BIYEnU, reason: collision with root package name */
    public ArrayList f2250BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public ArrayList f2251BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public B7CMnp[] f2252BNL6CD;

    /* renamed from: CASmeH, reason: collision with root package name */
    public A2egSU f2260CASmeH;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final String f2238AcNBzu = getClass().getName();

    /* renamed from: AlLFFp, reason: collision with root package name */
    public long f2239AlLFFp = -1;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public long f2240AmA8tU = -1;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public TimeInterpolator f2241AzWtSf = null;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final ArrayList f2242B25kr6 = new ArrayList();

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final ArrayList f2243B2KMhB = new ArrayList();

    /* renamed from: B3GDIM, reason: collision with root package name */
    public ArrayList f2244B3GDIM = null;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public ArrayList f2245B4ZgIw = null;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public AZOQYO.ARc23Z f2246B7CMnp = new AZOQYO.ARc23Z(1);

    /* renamed from: B9tovu, reason: collision with root package name */
    public AZOQYO.ARc23Z f2247B9tovu = new AZOQYO.ARc23Z(1);

    /* renamed from: BChYOn, reason: collision with root package name */
    public BPw6Q8 f2248BChYOn = null;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public final int[] f2249BI9f7h = f2235CQhlFr;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public final ArrayList f2253BPw6Q8 = new ArrayList();

    /* renamed from: BTvldC, reason: collision with root package name */
    public Animator[] f2254BTvldC = f2234COJEAR;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public int f2255BV3sI0 = 0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public boolean f2256BmvVmW = false;

    /* renamed from: BniPrB, reason: collision with root package name */
    public boolean f2257BniPrB = false;
    public B4ZgIw BpkvW3 = null;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public ArrayList f2258C2rE4F = null;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public ArrayList f2259C4FrIb = new ArrayList();

    /* renamed from: CNPG0E, reason: collision with root package name */
    public B2KMhB f2261CNPG0E = f2236CSDoyG;

    public static abstract class A2egSU {
    }

    static {
        bsLQmP();
    }

    public static void A5SV6n(AZOQYO.ARc23Z aRc23Z, View view, BmvVmW bmvVmW) {
        ((B25kr6.ADYaiT) aRc23Z.f363AcNBzu).put(view, bmvVmW);
        int id = view.getId();
        if (id >= 0) {
            SparseArray sparseArray = (SparseArray) aRc23Z.f364AlLFFp;
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
        String AaHO0E2 = CmUvjW.AaHO0E(view);
        if (AaHO0E2 != null) {
            B25kr6.ADYaiT aDYaiT = (B25kr6.ADYaiT) aRc23Z.f366AzWtSf;
            if (aDYaiT.containsKey(AaHO0E2)) {
                aDYaiT.put(AaHO0E2, null);
            } else {
                aDYaiT.put(AaHO0E2, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                B25kr6.AYUAbz aYUAbz = (B25kr6.AYUAbz) aRc23Z.f365AmA8tU;
                if (aYUAbz.ARc23Z(itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    aYUAbz.AYUAbz(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) aYUAbz.ADYaiT(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    aYUAbz.AYUAbz(itemIdAtPosition, null);
                }
            }
        }
    }

    public static B25kr6.ADYaiT B3GDIM() {
        ThreadLocal threadLocal = f2237CTkVKb;
        B25kr6.ADYaiT aDYaiT = (B25kr6.ADYaiT) threadLocal.get();
        if (aDYaiT != null) {
            return aDYaiT;
        }
        B25kr6.ADYaiT aDYaiT2 = new B25kr6.ADYaiT();
        threadLocal.set(aDYaiT2);
        return aDYaiT2;
    }

    private static /* synthetic */ void bsLQmP() {
        char[] charArray = "zvt7~xt|7{v`7jq|uu7Swp[kp}~|".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 25);
        }
        String str = new String(charArray);
        char[] charArray2 = "zupwpm".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 25);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void A2egSU(B7CMnp b7CMnp) {
        if (this.f2258C2rE4F == null) {
            this.f2258C2rE4F = new ArrayList();
        }
        this.f2258C2rE4F.add(b7CMnp);
    }

    public void A4TApA(View view) {
        this.f2243B2KMhB.add(view);
    }

    public abstract void ADYaiT(BmvVmW bmvVmW);

    public final void AMqCpz(View view, boolean z) {
        if (view == null) {
            return;
        }
        view.getId();
        ArrayList arrayList = this.f2244B3GDIM;
        if (arrayList == null || !arrayList.contains(view)) {
            ArrayList arrayList2 = this.f2245B4ZgIw;
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    if (((Class) this.f2245B4ZgIw.get(i)).isInstance(view)) {
                        return;
                    }
                }
            }
            if (view.getParent() instanceof ViewGroup) {
                BmvVmW bmvVmW = new BmvVmW(view);
                if (z) {
                    ASJ6gh(bmvVmW);
                } else {
                    ADYaiT(bmvVmW);
                }
                bmvVmW.f2283A5SV6n.add(this);
                ARc23Z(bmvVmW);
                if (z) {
                    A5SV6n(this.f2246B7CMnp, view, bmvVmW);
                } else {
                    A5SV6n(this.f2247B9tovu, view, bmvVmW);
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    AMqCpz(viewGroup.getChildAt(i2), z);
                }
            }
        }
    }

    public void ARc23Z(BmvVmW bmvVmW) {
    }

    public abstract void ASJ6gh(BmvVmW bmvVmW);

    public final void AYUAbz(ViewGroup viewGroup, boolean z) {
        AZOQYO(z);
        ArrayList arrayList = this.f2242B25kr6;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f2243B2KMhB;
        if (size <= 0 && arrayList2.size() <= 0) {
            AMqCpz(viewGroup, z);
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            View findViewById = viewGroup.findViewById(((Integer) arrayList.get(i)).intValue());
            if (findViewById != null) {
                BmvVmW bmvVmW = new BmvVmW(findViewById);
                if (z) {
                    ASJ6gh(bmvVmW);
                } else {
                    ADYaiT(bmvVmW);
                }
                bmvVmW.f2283A5SV6n.add(this);
                ARc23Z(bmvVmW);
                if (z) {
                    A5SV6n(this.f2246B7CMnp, findViewById, bmvVmW);
                } else {
                    A5SV6n(this.f2247B9tovu, findViewById, bmvVmW);
                }
            }
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            View view = (View) arrayList2.get(i2);
            BmvVmW bmvVmW2 = new BmvVmW(view);
            if (z) {
                ASJ6gh(bmvVmW2);
            } else {
                ADYaiT(bmvVmW2);
            }
            bmvVmW2.f2283A5SV6n.add(this);
            ARc23Z(bmvVmW2);
            if (z) {
                A5SV6n(this.f2246B7CMnp, view, bmvVmW2);
            } else {
                A5SV6n(this.f2247B9tovu, view, bmvVmW2);
            }
        }
    }

    public final void AZOQYO(boolean z) {
        if (z) {
            ((B25kr6.ADYaiT) this.f2246B7CMnp.f363AcNBzu).clear();
            ((SparseArray) this.f2246B7CMnp.f364AlLFFp).clear();
            ((B25kr6.AYUAbz) this.f2246B7CMnp.f365AmA8tU).A4TApA();
        } else {
            ((B25kr6.ADYaiT) this.f2247B9tovu.f363AcNBzu).clear();
            ((SparseArray) this.f2247B9tovu.f364AlLFFp).clear();
            ((B25kr6.AYUAbz) this.f2247B9tovu.f365AmA8tU).A4TApA();
        }
    }

    @Override // 
    /* renamed from: AZkASS */
    public B4ZgIw clone() {
        try {
            B4ZgIw b4ZgIw = (B4ZgIw) super.clone();
            b4ZgIw.f2259C4FrIb = new ArrayList();
            b4ZgIw.f2246B7CMnp = new AZOQYO.ARc23Z(1);
            b4ZgIw.f2247B9tovu = new AZOQYO.ARc23Z(1);
            b4ZgIw.f2250BIYEnU = null;
            b4ZgIw.f2251BJ7GGh = null;
            b4ZgIw.BpkvW3 = this;
            b4ZgIw.f2258C2rE4F = null;
            return b4ZgIw;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public Animator AaHO0E(ViewGroup viewGroup, BmvVmW bmvVmW, BmvVmW bmvVmW2) {
        return null;
    }

    public void AcNBzu(ViewGroup viewGroup, AZOQYO.ARc23Z aRc23Z, AZOQYO.ARc23Z aRc23Z2, ArrayList arrayList, ArrayList arrayList2) {
        int i;
        int i2;
        View view;
        BmvVmW bmvVmW;
        Animator animator;
        BmvVmW bmvVmW2;
        B25kr6.ADYaiT B3GDIM2 = B3GDIM();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        B2KMhB().getClass();
        int i3 = 0;
        while (i3 < size) {
            BmvVmW bmvVmW3 = (BmvVmW) arrayList.get(i3);
            BmvVmW bmvVmW4 = (BmvVmW) arrayList2.get(i3);
            if (bmvVmW3 != null && !bmvVmW3.f2283A5SV6n.contains(this)) {
                bmvVmW3 = null;
            }
            if (bmvVmW4 != null && !bmvVmW4.f2283A5SV6n.contains(this)) {
                bmvVmW4 = null;
            }
            if ((bmvVmW3 != null || bmvVmW4 != null) && (bmvVmW3 == null || bmvVmW4 == null || B9tovu(bmvVmW3, bmvVmW4))) {
                Animator AaHO0E2 = AaHO0E(viewGroup, bmvVmW3, bmvVmW4);
                if (AaHO0E2 != null) {
                    String str = this.f2238AcNBzu;
                    if (bmvVmW4 != null) {
                        String[] B4ZgIw2 = B4ZgIw();
                        view = bmvVmW4.f2282A4TApA;
                        if (B4ZgIw2 != null && B4ZgIw2.length > 0) {
                            bmvVmW2 = new BmvVmW(view);
                            BmvVmW bmvVmW5 = (BmvVmW) ((B25kr6.ADYaiT) aRc23Z2.f363AcNBzu).get(view);
                            i = size;
                            if (bmvVmW5 != null) {
                                int i4 = 0;
                                while (i4 < B4ZgIw2.length) {
                                    HashMap hashMap = bmvVmW2.f2281A2egSU;
                                    int i5 = i3;
                                    String str2 = B4ZgIw2[i4];
                                    hashMap.put(str2, bmvVmW5.f2281A2egSU.get(str2));
                                    i4++;
                                    i3 = i5;
                                }
                            }
                            i2 = i3;
                            int i6 = B3GDIM2.f1011AmA8tU;
                            int i7 = 0;
                            while (true) {
                                if (i7 >= i6) {
                                    animator = AaHO0E2;
                                    break;
                                }
                                B3GDIM b3gdim = (B3GDIM) B3GDIM2.get((Animator) B3GDIM2.ARc23Z(i7));
                                if (b3gdim.f2231A5SV6n != null && b3gdim.f2229A2egSU == view && b3gdim.f2230A4TApA.equals(str) && b3gdim.f2231A5SV6n.equals(bmvVmW2)) {
                                    animator = null;
                                    break;
                                }
                                i7++;
                            }
                        } else {
                            i = size;
                            i2 = i3;
                            animator = AaHO0E2;
                            bmvVmW2 = null;
                        }
                        AaHO0E2 = animator;
                        bmvVmW = bmvVmW2;
                    } else {
                        i = size;
                        i2 = i3;
                        view = bmvVmW3.f2282A4TApA;
                        bmvVmW = null;
                    }
                    if (AaHO0E2 != null) {
                        WindowId windowId = viewGroup.getWindowId();
                        B3GDIM b3gdim2 = new B3GDIM();
                        b3gdim2.f2229A2egSU = view;
                        b3gdim2.f2230A4TApA = str;
                        b3gdim2.f2231A5SV6n = bmvVmW;
                        b3gdim2.f2232ADYaiT = windowId;
                        b3gdim2.AMqCpz = this;
                        b3gdim2.f2233ARc23Z = AaHO0E2;
                        B3GDIM2.put(AaHO0E2, b3gdim2);
                        this.f2259C4FrIb.add(AaHO0E2);
                    }
                    i3 = i2 + 1;
                    size = i;
                }
            }
            i = size;
            i2 = i3;
            i3 = i2 + 1;
            size = i;
        }
        if (sparseIntArray.size() != 0) {
            for (int i8 = 0; i8 < sparseIntArray.size(); i8++) {
                B3GDIM b3gdim3 = (B3GDIM) B3GDIM2.get((Animator) this.f2259C4FrIb.get(sparseIntArray.keyAt(i8)));
                b3gdim3.f2233ARc23Z.setStartDelay(b3gdim3.f2233ARc23Z.getStartDelay() + (sparseIntArray.valueAt(i8) - Long.MAX_VALUE));
            }
        }
    }

    public final void AlLFFp() {
        int i = this.f2255BV3sI0 - 1;
        this.f2255BV3sI0 = i;
        if (i == 0) {
            BI9f7h(this, B9tovu.f2263A4TApA);
            for (int i2 = 0; i2 < ((B25kr6.AYUAbz) this.f2246B7CMnp.f365AmA8tU).AZkASS(); i2++) {
                View view = (View) ((B25kr6.AYUAbz) this.f2246B7CMnp.f365AmA8tU).AaHO0E(i2);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i3 = 0; i3 < ((B25kr6.AYUAbz) this.f2247B9tovu.f365AmA8tU).AZkASS(); i3++) {
                View view2 = (View) ((B25kr6.AYUAbz) this.f2247B9tovu.f365AmA8tU).AaHO0E(i3);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.f2257BniPrB = true;
        }
    }

    public B4ZgIw AmA8tU(View view) {
        ArrayList arrayList = this.f2244B3GDIM;
        if (view != null) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            if (!arrayList.contains(view)) {
                arrayList.add(view);
            }
        }
        this.f2244B3GDIM = arrayList;
        return this;
    }

    public void AzWtSf() {
        ArrayList arrayList = this.f2245B4ZgIw;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        if (!arrayList.contains(TextView.class)) {
            arrayList.add(TextView.class);
        }
        this.f2245B4ZgIw = arrayList;
    }

    public final BmvVmW B25kr6(View view, boolean z) {
        BPw6Q8 bPw6Q8 = this.f2248BChYOn;
        if (bPw6Q8 != null) {
            return bPw6Q8.B25kr6(view, z);
        }
        ArrayList arrayList = z ? this.f2250BIYEnU : this.f2251BJ7GGh;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            BmvVmW bmvVmW = (BmvVmW) arrayList.get(i);
            if (bmvVmW == null) {
                return null;
            }
            if (bmvVmW.f2282A4TApA == view) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            return (BmvVmW) (z ? this.f2251BJ7GGh : this.f2250BIYEnU).get(i);
        }
        return null;
    }

    public final B4ZgIw B2KMhB() {
        BPw6Q8 bPw6Q8 = this.f2248BChYOn;
        return bPw6Q8 != null ? bPw6Q8.B2KMhB() : this;
    }

    public String[] B4ZgIw() {
        return null;
    }

    public final BmvVmW B7CMnp(View view, boolean z) {
        BPw6Q8 bPw6Q8 = this.f2248BChYOn;
        if (bPw6Q8 != null) {
            return bPw6Q8.B7CMnp(view, z);
        }
        return (BmvVmW) ((B25kr6.ADYaiT) (z ? this.f2246B7CMnp : this.f2247B9tovu).f363AcNBzu).get(view);
    }

    public boolean B9tovu(BmvVmW bmvVmW, BmvVmW bmvVmW2) {
        if (bmvVmW != null && bmvVmW2 != null) {
            String[] B4ZgIw2 = B4ZgIw();
            HashMap hashMap = bmvVmW.f2281A2egSU;
            HashMap hashMap2 = bmvVmW2.f2281A2egSU;
            if (B4ZgIw2 != null) {
                for (String str : B4ZgIw2) {
                    Object obj = hashMap.get(str);
                    Object obj2 = hashMap2.get(str);
                    if ((obj == null && obj2 == null) ? false : (obj == null || obj2 == null) ? true : !obj.equals(obj2)) {
                        return true;
                    }
                }
            } else {
                for (String str2 : hashMap.keySet()) {
                    Object obj3 = hashMap.get(str2);
                    Object obj4 = hashMap2.get(str2);
                    if ((obj3 == null && obj4 == null) ? false : (obj3 == null || obj4 == null) ? true : !obj3.equals(obj4)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean BChYOn(View view) {
        int id = view.getId();
        ArrayList arrayList = this.f2244B3GDIM;
        if (arrayList != null && arrayList.contains(view)) {
            return false;
        }
        ArrayList arrayList2 = this.f2245B4ZgIw;
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                if (((Class) this.f2245B4ZgIw.get(i)).isInstance(view)) {
                    return false;
                }
            }
        }
        ArrayList arrayList3 = this.f2242B25kr6;
        int size2 = arrayList3.size();
        ArrayList arrayList4 = this.f2243B2KMhB;
        return (size2 == 0 && arrayList4.size() == 0) || arrayList3.contains(Integer.valueOf(id)) || arrayList4.contains(view);
    }

    public final void BI9f7h(B4ZgIw b4ZgIw, B9tovu b9tovu) {
        B4ZgIw b4ZgIw2 = this.BpkvW3;
        if (b4ZgIw2 != null) {
            b4ZgIw2.BI9f7h(b4ZgIw, b9tovu);
        }
        ArrayList arrayList = this.f2258C2rE4F;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.f2258C2rE4F.size();
        B7CMnp[] b7CMnpArr = this.f2252BNL6CD;
        if (b7CMnpArr == null) {
            b7CMnpArr = new B7CMnp[size];
        }
        this.f2252BNL6CD = null;
        B7CMnp[] b7CMnpArr2 = (B7CMnp[]) this.f2258C2rE4F.toArray(b7CMnpArr);
        for (int i = 0; i < size; i++) {
            b9tovu.A2egSU(b7CMnpArr2[i], b4ZgIw);
            b7CMnpArr2[i] = null;
        }
        this.f2252BNL6CD = b7CMnpArr2;
    }

    public void BIYEnU(ViewGroup viewGroup) {
        if (this.f2257BniPrB) {
            return;
        }
        ArrayList arrayList = this.f2253BPw6Q8;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.f2254BTvldC);
        this.f2254BTvldC = f2234COJEAR;
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            animator.pause();
        }
        this.f2254BTvldC = animatorArr;
        BI9f7h(this, B9tovu.f2265ADYaiT);
        this.f2256BmvVmW = true;
    }

    public B4ZgIw BJ7GGh(B7CMnp b7CMnp) {
        B4ZgIw b4ZgIw;
        ArrayList arrayList = this.f2258C2rE4F;
        if (arrayList != null) {
            if (!arrayList.remove(b7CMnp) && (b4ZgIw = this.BpkvW3) != null) {
                b4ZgIw.BJ7GGh(b7CMnp);
            }
            if (this.f2258C2rE4F.size() == 0) {
                this.f2258C2rE4F = null;
            }
        }
        return this;
    }

    public void BNL6CD(View view) {
        this.f2243B2KMhB.remove(view);
    }

    public void BPw6Q8(View view) {
        if (this.f2256BmvVmW) {
            if (!this.f2257BniPrB) {
                ArrayList arrayList = this.f2253BPw6Q8;
                int size = arrayList.size();
                Animator[] animatorArr = (Animator[]) arrayList.toArray(this.f2254BTvldC);
                this.f2254BTvldC = f2234COJEAR;
                for (int i = size - 1; i >= 0; i--) {
                    Animator animator = animatorArr[i];
                    animatorArr[i] = null;
                    animator.resume();
                }
                this.f2254BTvldC = animatorArr;
                BI9f7h(this, B9tovu.AMqCpz);
            }
            this.f2256BmvVmW = false;
        }
    }

    public void BTvldC() {
        CASmeH();
        B25kr6.ADYaiT B3GDIM2 = B3GDIM();
        Iterator it = this.f2259C4FrIb.iterator();
        while (it.hasNext()) {
            Animator animator = (Animator) it.next();
            if (B3GDIM2.containsKey(animator)) {
                CASmeH();
                if (animator != null) {
                    animator.addListener(new DyaChj(this, 1, B3GDIM2));
                    long j = this.f2240AmA8tU;
                    if (j >= 0) {
                        animator.setDuration(j);
                    }
                    long j2 = this.f2239AlLFFp;
                    if (j2 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j2);
                    }
                    TimeInterpolator timeInterpolator = this.f2241AzWtSf;
                    if (timeInterpolator != null) {
                        animator.setInterpolator(timeInterpolator);
                    }
                    animator.addListener(new AaHO0E.A5SV6n(2, this));
                    animator.start();
                }
            }
        }
        this.f2259C4FrIb.clear();
        AlLFFp();
    }

    public void BV3sI0(long j) {
        this.f2240AmA8tU = j;
    }

    public void BmvVmW(A2egSU a2egSU) {
        this.f2260CASmeH = a2egSU;
    }

    public void BniPrB(TimeInterpolator timeInterpolator) {
        this.f2241AzWtSf = timeInterpolator;
    }

    public void BpkvW3(B2KMhB b2KMhB) {
        if (b2KMhB == null) {
            this.f2261CNPG0E = f2236CSDoyG;
        } else {
            this.f2261CNPG0E = b2KMhB;
        }
    }

    public void C2rE4F() {
    }

    public void C4FrIb(long j) {
        this.f2239AlLFFp = j;
    }

    public final void CASmeH() {
        if (this.f2255BV3sI0 == 0) {
            BI9f7h(this, B9tovu.f2262A2egSU);
            this.f2257BniPrB = false;
        }
        this.f2255BV3sI0++;
    }

    public String CNPG0E(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.f2240AmA8tU != -1) {
            sb.append("dur(");
            sb.append(this.f2240AmA8tU);
            sb.append(") ");
        }
        if (this.f2239AlLFFp != -1) {
            sb.append("dly(");
            sb.append(this.f2239AlLFFp);
            sb.append(") ");
        }
        if (this.f2241AzWtSf != null) {
            sb.append("interp(");
            sb.append(this.f2241AzWtSf);
            sb.append(") ");
        }
        ArrayList arrayList = this.f2242B25kr6;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f2243B2KMhB;
        if (size > 0 || arrayList2.size() > 0) {
            sb.append("tgts(");
            if (arrayList.size() > 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList.get(i));
                }
            }
            if (arrayList2.size() > 0) {
                for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    sb.append(arrayList2.get(i2));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    public void cancel() {
        ArrayList arrayList = this.f2253BPw6Q8;
        int size = arrayList.size();
        Animator[] animatorArr = (Animator[]) arrayList.toArray(this.f2254BTvldC);
        this.f2254BTvldC = f2234COJEAR;
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            animator.cancel();
        }
        this.f2254BTvldC = animatorArr;
        BI9f7h(this, B9tovu.f2264A5SV6n);
    }

    public final String toString() {
        return CNPG0E("");
    }
}
