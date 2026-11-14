package androidx.fragment.app;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class D9tr6l extends androidx.lifecycle.CikNvS {

    /* renamed from: AZkASS, reason: collision with root package name */
    public static final OLy1FW.AzWtSf f8880AZkASS = new OLy1FW.AzWtSf(12, (byte) 0);

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final boolean f8883ASJ6gh;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final HashMap f8881ADYaiT = new HashMap();
    public final HashMap AMqCpz = new HashMap();

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final HashMap f8882ARc23Z = new HashMap();

    /* renamed from: AYUAbz, reason: collision with root package name */
    public boolean f8884AYUAbz = false;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public boolean f8885AZOQYO = false;

    static {
        BkllpIy();
    }

    public D9tr6l(boolean z) {
        this.f8883ASJ6gh = z;
    }

    private static /* synthetic */ void BkllpIy() {
        char[] charArray = "ïãá¢ëíáé¢îãõ¢ÿäéàà¢ÆâåÎþåèëé".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 140);
        }
        String str = new String(charArray);
        char[] charArray2 = "ïàåâåø".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 140);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // androidx.lifecycle.CikNvS
    public final void A4TApA() {
        if (CtxOCS.C4FrIb(3)) {
            toString();
        }
        this.f8884AYUAbz = true;
    }

    public final void A5SV6n(Fragment fragment) {
        if (this.f8885AZOQYO) {
            CtxOCS.C4FrIb(2);
            return;
        }
        HashMap hashMap = this.f8881ADYaiT;
        if (hashMap.containsKey(fragment.mWho)) {
            return;
        }
        hashMap.put(fragment.mWho, fragment);
        if (CtxOCS.C4FrIb(2)) {
            fragment.toString();
        }
    }

    public final void ADYaiT(String str) {
        HashMap hashMap = this.AMqCpz;
        D9tr6l d9tr6l = (D9tr6l) hashMap.get(str);
        if (d9tr6l != null) {
            d9tr6l.A4TApA();
            hashMap.remove(str);
        }
        HashMap hashMap2 = this.f8882ARc23Z;
        androidx.lifecycle.CtxOCS ctxOCS = (androidx.lifecycle.CtxOCS) hashMap2.get(str);
        if (ctxOCS != null) {
            ctxOCS.A2egSU();
            hashMap2.remove(str);
        }
    }

    public final void AMqCpz(Fragment fragment) {
        if (this.f8885AZOQYO) {
            CtxOCS.C4FrIb(2);
        } else {
            if (this.f8881ADYaiT.remove(fragment.mWho) == null || !CtxOCS.C4FrIb(2)) {
                return;
            }
            fragment.toString();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && D9tr6l.class == obj.getClass()) {
            D9tr6l d9tr6l = (D9tr6l) obj;
            if (this.f8881ADYaiT.equals(d9tr6l.f8881ADYaiT) && this.AMqCpz.equals(d9tr6l.AMqCpz) && this.f8882ARc23Z.equals(d9tr6l.f8882ARc23Z)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f8882ARc23Z.hashCode() + ((this.AMqCpz.hashCode() + (this.f8881ADYaiT.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f8881ADYaiT.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.AMqCpz.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f8882ARc23Z.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
