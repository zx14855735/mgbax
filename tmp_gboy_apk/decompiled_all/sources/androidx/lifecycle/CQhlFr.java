package androidx.lifecycle;

import ADYaiT.DUi7mC;
import android.os.Bundle;
import android.view.View;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class CQhlFr {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final CkXcdM f9015A2egSU = new CkXcdM();

    /* renamed from: A4TApA, reason: collision with root package name */
    public static final CkXcdM f9016A4TApA = new CkXcdM();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final CkXcdM f9017A5SV6n = new CkXcdM();

    static {
        tjTkzsN();
    }

    public static final void A2egSU(CikNvS cikNvS, DV2E8K.ADYaiT aDYaiT, AzWtSf azWtSf) {
        Object obj;
        RXb0Sz.ARc23Z.AMqCpz(aDYaiT, "registry");
        RXb0Sz.ARc23Z.AMqCpz(azWtSf, "lifecycle");
        HashMap hashMap = cikNvS.f9030A2egSU;
        if (hashMap == null) {
            obj = null;
        } else {
            synchronized (hashMap) {
                obj = cikNvS.f9030A2egSU.get("androidx.lifecycle.savedstate.vm.tag");
            }
        }
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
        if (savedStateHandleController == null || savedStateHandleController.f9058AmA8tU) {
            return;
        }
        savedStateHandleController.A2egSU(aDYaiT, azWtSf);
        AmA8tU A4TApA2 = azWtSf.A4TApA();
        if (A4TApA2 == AmA8tU.f8978AlLFFp || A4TApA2.compareTo(AmA8tU.f8980AzWtSf) >= 0) {
            aDYaiT.ADYaiT();
        } else {
            azWtSf.A2egSU(new LegacySavedStateHandleController$tryToAddRecreator$1(aDYaiT, azWtSf));
        }
    }

    public static COJEAR A4TApA(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            if (bundle2 == null) {
                return new COJEAR();
            }
            HashMap hashMap = new HashMap();
            for (String str : bundle2.keySet()) {
                RXb0Sz.ARc23Z.ADYaiT(str, "key");
                hashMap.put(str, bundle2.get(str));
            }
            return new COJEAR(hashMap);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = parcelableArrayList.size();
        for (int i = 0; i < size; i++) {
            Object obj = parcelableArrayList.get(i);
            RXb0Sz.ARc23Z.A5SV6n(obj, "null cannot be cast to non-null type kotlin.String");
            linkedHashMap.put((String) obj, parcelableArrayList2.get(i));
        }
        return new COJEAR(linkedHashMap);
    }

    public static final COJEAR A5SV6n(D9tr6l.ADYaiT aDYaiT) {
        CkXcdM ckXcdM = f9015A2egSU;
        LinkedHashMap linkedHashMap = aDYaiT.f2052A2egSU;
        DV2E8K.ARc23Z aRc23Z = (DV2E8K.ARc23Z) linkedHashMap.get(ckXcdM);
        if (aRc23Z == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        D07BeM d07BeM = (D07BeM) linkedHashMap.get(f9016A4TApA);
        if (d07BeM == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) linkedHashMap.get(f9017A5SV6n);
        String str = (String) linkedHashMap.get(CkXcdM.f9034A4TApA);
        if (str == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        }
        DV2E8K.A5SV6n A4TApA2 = aRc23Z.getSavedStateRegistry().A4TApA();
        CSDoyG cSDoyG = A4TApA2 instanceof CSDoyG ? (CSDoyG) A4TApA2 : null;
        if (cSDoyG == null) {
            throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
        }
        LinkedHashMap linkedHashMap2 = AMqCpz(d07BeM).f9022ADYaiT;
        COJEAR cojear = (COJEAR) linkedHashMap2.get(str);
        if (cojear != null) {
            return cojear;
        }
        Class[] clsArr = COJEAR.f9010ARc23Z;
        cSDoyG.A2egSU();
        Bundle bundle2 = cSDoyG.f9020A5SV6n;
        Bundle bundle3 = bundle2 != null ? bundle2.getBundle(str) : null;
        Bundle bundle4 = cSDoyG.f9020A5SV6n;
        if (bundle4 != null) {
            bundle4.remove(str);
        }
        Bundle bundle5 = cSDoyG.f9020A5SV6n;
        if (bundle5 != null && bundle5.isEmpty()) {
            cSDoyG.f9020A5SV6n = null;
        }
        COJEAR A4TApA3 = A4TApA(bundle3, bundle);
        linkedHashMap2.put(str, A4TApA3);
        return A4TApA3;
    }

    public static final void ADYaiT(DV2E8K.ARc23Z aRc23Z) {
        AmA8tU A4TApA2 = aRc23Z.getLifecycle().A4TApA();
        if (A4TApA2 != AmA8tU.f8978AlLFFp && A4TApA2 != AmA8tU.f8979AmA8tU) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (aRc23Z.getSavedStateRegistry().A4TApA() == null) {
            CSDoyG cSDoyG = new CSDoyG(aRc23Z.getSavedStateRegistry(), (D07BeM) aRc23Z);
            aRc23Z.getSavedStateRegistry().A5SV6n("androidx.lifecycle.internal.SavedStateHandlesProvider", cSDoyG);
            aRc23Z.getLifecycle().A2egSU(new SavedStateHandleAttacher(cSDoyG));
        }
    }

    public static final CTkVKb AMqCpz(D07BeM d07BeM) {
        D9tr6l.A5SV6n a5SV6n = new D9tr6l.A5SV6n();
        RXb0Sz.AZOQYO.f7892A2egSU.getClass();
        RXb0Sz.ADYaiT aDYaiT = new RXb0Sz.ADYaiT(CTkVKb.class);
        ArrayList arrayList = a5SV6n.f2053A2egSU;
        Class A2egSU2 = aDYaiT.A2egSU();
        RXb0Sz.ARc23Z.A5SV6n(A2egSU2, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        arrayList.add(new D9tr6l.AMqCpz(A2egSU2));
        D9tr6l.AMqCpz[] aMqCpzArr = (D9tr6l.AMqCpz[]) arrayList.toArray(new D9tr6l.AMqCpz[0]);
        return (CTkVKb) new DUi7mC(d07BeM.getViewModelStore(), new AZkASS.ARc23Z((D9tr6l.AMqCpz[]) Arrays.copyOf(aMqCpzArr, aMqCpzArr.length)), d07BeM instanceof AZOQYO ? ((AZOQYO) d07BeM).getDefaultViewModelCreationExtras() : D9tr6l.A2egSU.f2051A4TApA).AmA8tU("androidx.lifecycle.internal.SavedStateHandlesVM", CTkVKb.class);
    }

    public static final void ARc23Z(View view, B9tovu b9tovu) {
        RXb0Sz.ARc23Z.AMqCpz(view, "<this>");
        view.setTag(2131298308, b9tovu);
    }

    private static /* synthetic */ void tjTkzsN() {
        char[] charArray = "OCA\u0002KMAI\u0002NCU\u0002_DI@@\u0002fBEn^EHKI".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ',');
        }
        String str = new String(charArray);
        char[] charArray2 = "O@EBEX".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ',');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
