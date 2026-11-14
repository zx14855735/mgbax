package AZkASS;

import COJEAR.DUi7mC;
import COJEAR.DXnQ0V;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AmA8tU implements Menu {

    /* renamed from: COJEAR, reason: collision with root package name */
    public static final int[] f492COJEAR = {1, 4, 5, 3, 2, 0};

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Context f493AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Resources f494AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f495AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final boolean f496AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public AcNBzu f497B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final ArrayList f498B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final ArrayList f499B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f500B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final ArrayList f501B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public final ArrayList f502B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public boolean f503BChYOn;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public CharSequence f505BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public Drawable f506BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public View f507BNL6CD;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public B25kr6 f514C4FrIb;

    /* renamed from: CNPG0E, reason: collision with root package name */
    public boolean f516CNPG0E;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public int f504BI9f7h = 0;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public boolean f508BPw6Q8 = false;

    /* renamed from: BTvldC, reason: collision with root package name */
    public boolean f509BTvldC = false;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public boolean f510BV3sI0 = false;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public boolean f511BmvVmW = false;

    /* renamed from: BniPrB, reason: collision with root package name */
    public boolean f512BniPrB = false;
    public final ArrayList BpkvW3 = new ArrayList();

    /* renamed from: C2rE4F, reason: collision with root package name */
    public final CopyOnWriteArrayList f513C2rE4F = new CopyOnWriteArrayList();

    /* renamed from: CASmeH, reason: collision with root package name */
    public boolean f515CASmeH = false;

    public AmA8tU(Context context) {
        boolean z;
        boolean z2 = false;
        this.f493AcNBzu = context;
        Resources resources = context.getResources();
        this.f494AlLFFp = resources;
        this.f498B2KMhB = new ArrayList();
        this.f499B3GDIM = new ArrayList();
        this.f500B4ZgIw = true;
        this.f501B7CMnp = new ArrayList();
        this.f502B9tovu = new ArrayList();
        this.f503BChYOn = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = DXnQ0V.f1686A2egSU;
            if (Build.VERSION.SDK_INT >= 28) {
                z = DUi7mC.A4TApA(viewConfiguration);
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                z = identifier != 0 && resources2.getBoolean(identifier);
            }
            if (z) {
                z2 = true;
            }
        }
        this.f496AzWtSf = z2;
    }

    public B25kr6 A2egSU(int i, int i2, int i3, CharSequence charSequence) {
        int i4;
        int i5 = ((-65536) & i3) >> 16;
        if (i5 < 0 || i5 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i6 = (f492COJEAR[i5] << 16) | (65535 & i3);
        B25kr6 b25kr6 = new B25kr6(this, i, i2, i3, i6, charSequence, this.f504BI9f7h);
        ArrayList arrayList = this.f498B2KMhB;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i4 = 0;
                break;
            }
            if (((B25kr6) arrayList.get(size)).f523AzWtSf <= i6) {
                i4 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i4, b25kr6);
        B25kr6(true);
        return b25kr6;
    }

    public final void A4TApA(BNL6CD bnl6cd, Context context) {
        this.f513C2rE4F.add(new WeakReference(bnl6cd));
        bnl6cd.AZkASS(context, this);
        this.f503BChYOn = true;
    }

    public final void A5SV6n(boolean z) {
        if (this.f512BniPrB) {
            return;
        }
        this.f512BniPrB = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f513C2rE4F;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            BNL6CD bnl6cd = (BNL6CD) weakReference.get();
            if (bnl6cd == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                bnl6cd.A2egSU(this, z);
            }
        }
        this.f512BniPrB = false;
    }

    public boolean ADYaiT(B25kr6 b25kr6) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f513C2rE4F;
        boolean z = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f514C4FrIb == b25kr6) {
            BJ7GGh();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                BNL6CD bnl6cd = (BNL6CD) weakReference.get();
                if (bnl6cd == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    z = bnl6cd.ASJ6gh(b25kr6);
                    if (z) {
                        break;
                    }
                }
            }
            BIYEnU();
            if (z) {
                this.f514C4FrIb = null;
            }
        }
        return z;
    }

    public boolean AMqCpz(AmA8tU amA8tU, MenuItem menuItem) {
        AcNBzu acNBzu = this.f497B25kr6;
        return acNBzu != null && acNBzu.AZkASS(amA8tU, menuItem);
    }

    public boolean ARc23Z(B25kr6 b25kr6) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f513C2rE4F;
        boolean z = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        BJ7GGh();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            BNL6CD bnl6cd = (BNL6CD) weakReference.get();
            if (bnl6cd == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                z = bnl6cd.AZOQYO(b25kr6);
                if (z) {
                    break;
                }
            }
        }
        BIYEnU();
        if (z) {
            this.f514C4FrIb = b25kr6;
        }
        return z;
    }

    public final B25kr6 ASJ6gh(int i, KeyEvent keyEvent) {
        ArrayList arrayList = this.BpkvW3;
        arrayList.clear();
        AYUAbz(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (B25kr6) arrayList.get(0);
        }
        boolean AmA8tU2 = AmA8tU();
        for (int i2 = 0; i2 < size; i2++) {
            B25kr6 b25kr6 = (B25kr6) arrayList.get(i2);
            char c = AmA8tU2 ? b25kr6.f529B9tovu : b25kr6.f527B4ZgIw;
            char[] cArr = keyData.meta;
            if ((c == cArr[0] && (metaState & 2) == 0) || ((c == cArr[2] && (metaState & 2) != 0) || (AmA8tU2 && c == '\b' && i == 67))) {
                return b25kr6;
            }
        }
        return null;
    }

    public final void AYUAbz(ArrayList arrayList, int i, KeyEvent keyEvent) {
        boolean AmA8tU2 = AmA8tU();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            ArrayList arrayList2 = this.f498B2KMhB;
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                B25kr6 b25kr6 = (B25kr6) arrayList2.get(i2);
                if (b25kr6.hasSubMenu()) {
                    b25kr6.f534BNL6CD.AYUAbz(arrayList, i, keyEvent);
                }
                char c = AmA8tU2 ? b25kr6.f529B9tovu : b25kr6.f527B4ZgIw;
                if ((modifiers & 69647) == ((AmA8tU2 ? b25kr6.f530BChYOn : b25kr6.f528B7CMnp) & 69647) && c != 0) {
                    char[] cArr = keyData.meta;
                    if ((c == cArr[0] || c == cArr[2] || (AmA8tU2 && c == '\b' && i == 67)) && b25kr6.isEnabled()) {
                        arrayList.add(b25kr6);
                    }
                }
            }
        }
    }

    public final void AZOQYO() {
        ArrayList AcNBzu2 = AcNBzu();
        if (this.f503BChYOn) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.f513C2rE4F;
            Iterator it = copyOnWriteArrayList.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                BNL6CD bnl6cd = (BNL6CD) weakReference.get();
                if (bnl6cd == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    z |= bnl6cd.A5SV6n();
                }
            }
            ArrayList arrayList = this.f501B7CMnp;
            ArrayList arrayList2 = this.f502B9tovu;
            if (z) {
                arrayList.clear();
                arrayList2.clear();
                int size = AcNBzu2.size();
                for (int i = 0; i < size; i++) {
                    B25kr6 b25kr6 = (B25kr6) AcNBzu2.get(i);
                    if ((b25kr6.f542CASmeH & 32) == 32) {
                        arrayList.add(b25kr6);
                    } else {
                        arrayList2.add(b25kr6);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(AcNBzu());
            }
            this.f503BChYOn = false;
        }
    }

    public String AZkASS() {
        return "android:menu:actionviewstates";
    }

    public AmA8tU AaHO0E() {
        return this;
    }

    public final ArrayList AcNBzu() {
        boolean z = this.f500B4ZgIw;
        ArrayList arrayList = this.f499B3GDIM;
        if (!z) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f498B2KMhB;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            B25kr6 b25kr6 = (B25kr6) arrayList2.get(i);
            if (b25kr6.isVisible()) {
                arrayList.add(b25kr6);
            }
        }
        this.f500B4ZgIw = false;
        this.f503BChYOn = true;
        return arrayList;
    }

    public boolean AlLFFp() {
        return this.f515CASmeH;
    }

    public boolean AmA8tU() {
        return this.f495AmA8tU;
    }

    public boolean AzWtSf() {
        return this.f496AzWtSf;
    }

    public void B25kr6(boolean z) {
        if (this.f508BPw6Q8) {
            this.f509BTvldC = true;
            if (z) {
                this.f510BV3sI0 = true;
                return;
            }
            return;
        }
        if (z) {
            this.f500B4ZgIw = true;
            this.f503BChYOn = true;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.f513C2rE4F;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        BJ7GGh();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            BNL6CD bnl6cd = (BNL6CD) weakReference.get();
            if (bnl6cd == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                bnl6cd.A4TApA(z);
            }
        }
        BIYEnU();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean B2KMhB(android.view.MenuItem r7, AZkASS.BNL6CD r8, int r9) {
        /*
            r6 = this;
            AZkASS.B25kr6 r7 = (AZkASS.B25kr6) r7
            r0 = 0
            if (r7 == 0) goto Lda
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Ld
            goto Lda
        Ld:
            android.view.MenuItem$OnMenuItemClickListener r1 = r7.f535BPw6Q8
            r2 = 1
            if (r1 == 0) goto L1a
            boolean r1 = r1.onMenuItemClick(r7)
            if (r1 == 0) goto L1a
        L18:
            r1 = 1
            goto L42
        L1a:
            AZkASS.AmA8tU r1 = r7.f533BJ7GGh
            boolean r3 = r1.AMqCpz(r1, r7)
            if (r3 == 0) goto L23
            goto L18
        L23:
            android.content.Intent r3 = r7.f526B3GDIM
            if (r3 == 0) goto L32
            android.content.Context r1 = r1.getContext()     // Catch: android.content.ActivityNotFoundException -> L31
            android.content.Intent r3 = r7.f526B3GDIM     // Catch: android.content.ActivityNotFoundException -> L31
            r1.startActivity(r3)     // Catch: android.content.ActivityNotFoundException -> L31
            goto L18
        L31:
        L32:
            COJEAR.A5SV6n r1 = r7.f545CQhlFr
            if (r1 == 0) goto L41
            AZkASS.B2KMhB r1 = (AZkASS.B2KMhB) r1
            android.view.ActionProvider r1 = r1.f549A5SV6n
            boolean r1 = r1.onPerformDefaultAction()
            if (r1 == 0) goto L41
            goto L18
        L41:
            r1 = 0
        L42:
            COJEAR.A5SV6n r3 = r7.f545CQhlFr
            if (r3 == 0) goto L53
            r4 = r3
            AZkASS.B2KMhB r4 = (AZkASS.B2KMhB) r4
            android.view.ActionProvider r4 = r4.f549A5SV6n
            boolean r4 = r4.hasSubMenu()
            if (r4 == 0) goto L53
            r4 = 1
            goto L54
        L53:
            r4 = 0
        L54:
            boolean r5 = r7.AMqCpz()
            if (r5 == 0) goto L66
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto Ld9
            r6.A5SV6n(r2)
            goto Ld9
        L66:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L77
            if (r4 == 0) goto L6f
            goto L77
        L6f:
            r7 = r9 & 1
            if (r7 != 0) goto Ld9
            r6.A5SV6n(r2)
            goto Ld9
        L77:
            r9 = r9 & 4
            if (r9 != 0) goto L7e
            r6.A5SV6n(r0)
        L7e:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L94
            AZkASS.BpkvW3 r9 = new AZkASS.BpkvW3
            android.content.Context r5 = r6.getContext()
            r9.<init>(r5, r6, r7)
            r7.f534BNL6CD = r9
            java.lang.CharSequence r5 = r7.f524B25kr6
            r9.setHeaderTitle(r5)
        L94:
            AZkASS.BpkvW3 r7 = r7.f534BNL6CD
            if (r4 == 0) goto La1
            AZkASS.B2KMhB r3 = (AZkASS.B2KMhB) r3
            AZkASS.B9tovu r9 = r3.f550ADYaiT
            android.view.ActionProvider r9 = r3.f549A5SV6n
            r9.onPrepareSubMenu(r7)
        La1:
            java.util.concurrent.CopyOnWriteArrayList r9 = r6.f513C2rE4F
            boolean r3 = r9.isEmpty()
            if (r3 == 0) goto Laa
            goto Ld3
        Laa:
            if (r8 == 0) goto Lb0
            boolean r0 = r8.ARc23Z(r7)
        Lb0:
            java.util.Iterator r8 = r9.iterator()
        Lb4:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto Ld3
            java.lang.Object r3 = r8.next()
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3
            java.lang.Object r4 = r3.get()
            AZkASS.BNL6CD r4 = (AZkASS.BNL6CD) r4
            if (r4 != 0) goto Lcc
            r9.remove(r3)
            goto Lb4
        Lcc:
            if (r0 != 0) goto Lb4
            boolean r0 = r4.ARc23Z(r7)
            goto Lb4
        Ld3:
            r1 = r1 | r0
            if (r1 != 0) goto Ld9
            r6.A5SV6n(r2)
        Ld9:
            return r1
        Lda:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: AZkASS.AmA8tU.B2KMhB(android.view.MenuItem, AZkASS.BNL6CD, int):boolean");
    }

    public final void B3GDIM(BNL6CD bnl6cd) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f513C2rE4F;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            BNL6CD bnl6cd2 = (BNL6CD) weakReference.get();
            if (bnl6cd2 == null || bnl6cd2 == bnl6cd) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    public final void B4ZgIw(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(AZkASS());
        int size = this.f498B2KMhB.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((BpkvW3) item.getSubMenu()).B4ZgIw(bundle);
            }
        }
        int i2 = bundle.getInt("android:menu:expandedactionview");
        if (i2 <= 0 || (findItem = findItem(i2)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    public final void B7CMnp(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.f513C2rE4F;
            if (copyOnWriteArrayList.isEmpty()) {
                return;
            }
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                BNL6CD bnl6cd = (BNL6CD) weakReference.get();
                if (bnl6cd == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    int id = bnl6cd.getId();
                    if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        bnl6cd.ADYaiT(parcelable);
                    }
                }
            }
        }
    }

    public final void B9tovu(Bundle bundle) {
        int size = this.f498B2KMhB.size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((BpkvW3) item.getSubMenu()).B9tovu(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(AZkASS(), sparseArray);
        }
    }

    public final void BChYOn(Bundle bundle) {
        Parcelable AYUAbz2;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f513C2rE4F;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            BNL6CD bnl6cd = (BNL6CD) weakReference.get();
            if (bnl6cd == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                int id = bnl6cd.getId();
                if (id > 0 && (AYUAbz2 = bnl6cd.AYUAbz()) != null) {
                    sparseArray.put(id, AYUAbz2);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
    }

    public final void BI9f7h(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resources = getResources();
        if (view != null) {
            this.f507BNL6CD = view;
            this.f505BIYEnU = null;
            this.f506BJ7GGh = null;
        } else {
            if (i > 0) {
                this.f505BIYEnU = resources.getText(i);
            } else if (charSequence != null) {
                this.f505BIYEnU = charSequence;
            }
            if (i2 > 0) {
                this.f506BJ7GGh = BPw6Q8.A2egSU.A4TApA(getContext(), i2);
            } else if (drawable != null) {
                this.f506BJ7GGh = drawable;
            }
            this.f507BNL6CD = null;
        }
        B25kr6(false);
    }

    public final void BIYEnU() {
        this.f508BPw6Q8 = false;
        if (this.f509BTvldC) {
            this.f509BTvldC = false;
            B25kr6(this.f510BV3sI0);
        }
    }

    public final void BJ7GGh() {
        if (this.f508BPw6Q8) {
            return;
        }
        this.f508BPw6Q8 = true;
        this.f509BTvldC = false;
        this.f510BV3sI0 = false;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return A2egSU(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.f493AcNBzu.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            B25kr6 A2egSU2 = A2egSU(i, i2, i3, resolveInfo.loadLabel(packageManager));
            A2egSU2.setIcon(resolveInfo.loadIcon(packageManager));
            A2egSU2.f526B3GDIM = intent2;
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = A2egSU2;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        B25kr6 b25kr6 = this.f514C4FrIb;
        if (b25kr6 != null) {
            ADYaiT(b25kr6);
        }
        this.f498B2KMhB.clear();
        B25kr6(true);
    }

    public final void clearHeader() {
        this.f506BJ7GGh = null;
        this.f505BIYEnU = null;
        this.f507BNL6CD = null;
        B25kr6(false);
    }

    @Override // android.view.Menu
    public final void close() {
        A5SV6n(true);
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        MenuItem findItem;
        ArrayList arrayList = this.f498B2KMhB;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            B25kr6 b25kr6 = (B25kr6) arrayList.get(i2);
            if (b25kr6.f520AcNBzu == i) {
                return b25kr6;
            }
            if (b25kr6.hasSubMenu() && (findItem = b25kr6.f534BNL6CD.findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public Context getContext() {
        return this.f493AcNBzu;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return (MenuItem) this.f498B2KMhB.get(i);
    }

    public Resources getResources() {
        return this.f494AlLFFp;
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.f516CNPG0E) {
            return true;
        }
        ArrayList arrayList = this.f498B2KMhB;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((B25kr6) arrayList.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ASJ6gh(i, keyEvent) != null;
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i2) {
        return B2KMhB(findItem(i), null, i2);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        B25kr6 ASJ6gh2 = ASJ6gh(i, keyEvent);
        boolean B2KMhB2 = ASJ6gh2 != null ? B2KMhB(ASJ6gh2, null, i2) : false;
        if ((i2 & 2) != 0) {
            A5SV6n(true);
        }
        return B2KMhB2;
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        ArrayList arrayList = this.f498B2KMhB;
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (((B25kr6) arrayList.get(i3)).f521AlLFFp == i) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            int size2 = arrayList.size() - i3;
            while (true) {
                int i4 = i2 + 1;
                if (i2 >= size2 || ((B25kr6) arrayList.get(i3)).f521AlLFFp != i) {
                    break;
                }
                if (i3 >= 0) {
                    ArrayList arrayList2 = this.f498B2KMhB;
                    if (i3 < arrayList2.size()) {
                        arrayList2.remove(i3);
                    }
                }
                i2 = i4;
            }
            B25kr6(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        ArrayList arrayList = this.f498B2KMhB;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (((B25kr6) arrayList.get(i2)).f520AcNBzu == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            ArrayList arrayList2 = this.f498B2KMhB;
            if (i2 >= arrayList2.size()) {
                return;
            }
            arrayList2.remove(i2);
            B25kr6(true);
        }
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z, boolean z2) {
        ArrayList arrayList = this.f498B2KMhB;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            B25kr6 b25kr6 = (B25kr6) arrayList.get(i2);
            if (b25kr6.f521AlLFFp == i) {
                b25kr6.ARc23Z(z2);
                b25kr6.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.f515CASmeH = z;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z) {
        ArrayList arrayList = this.f498B2KMhB;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            B25kr6 b25kr6 = (B25kr6) arrayList.get(i2);
            if (b25kr6.f521AlLFFp == i) {
                b25kr6.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z) {
        ArrayList arrayList = this.f498B2KMhB;
        int size = arrayList.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            B25kr6 b25kr6 = (B25kr6) arrayList.get(i2);
            if (b25kr6.f521AlLFFp == i) {
                int i3 = b25kr6.f542CASmeH;
                int i4 = (i3 & (-9)) | (z ? 0 : 8);
                b25kr6.f542CASmeH = i4;
                if (i3 != i4) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            B25kr6(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f495AmA8tU = z;
        B25kr6(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f498B2KMhB.size();
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return A2egSU(0, 0, 0, this.f494AlLFFp.getString(i));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f494AlLFFp.getString(i));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return A2egSU(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        B25kr6 A2egSU2 = A2egSU(i, i2, i3, charSequence);
        BpkvW3 bpkvW3 = new BpkvW3(this.f493AcNBzu, this, A2egSU2);
        A2egSU2.f534BNL6CD = bpkvW3;
        bpkvW3.setHeaderTitle(A2egSU2.f524B25kr6);
        return bpkvW3;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, int i4) {
        return A2egSU(i, i2, i3, this.f494AlLFFp.getString(i4));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f494AlLFFp.getString(i4));
    }
}
