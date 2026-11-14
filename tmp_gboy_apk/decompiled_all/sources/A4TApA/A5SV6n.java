package A4TApA;

import BPw6Q8.ASJ6gh;
import RD2OKB.AcNBzu;
import RD2OKB.BChYOn;
import RD2OKB.BNL6CD;
import RD2OKB.BPw6Q8;
import RXb0Sz.ARc23Z;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n extends A4TApA {
    @Override // A4TApA.A4TApA
    public final Intent A2egSU(Context context, Object obj) {
        String[] strArr = (String[]) obj;
        ARc23Z.AMqCpz(strArr, "input");
        Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
        ARc23Z.ADYaiT(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
        return putExtra;
    }

    @Override // A4TApA.A4TApA
    public final A2egSU A4TApA(Context context, Object obj) {
        String[] strArr = (String[]) obj;
        ARc23Z.AMqCpz(strArr, "input");
        if (strArr.length == 0) {
            return new A2egSU(BChYOn.f7847AcNBzu);
        }
        for (String str : strArr) {
            if (ASJ6gh.A2egSU(context, str) != 0) {
                return null;
            }
        }
        int A2egSU2 = BNL6CD.A2egSU(strArr.length);
        if (A2egSU2 < 16) {
            A2egSU2 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(A2egSU2);
        for (String str2 : strArr) {
            linkedHashMap.put(str2, Boolean.TRUE);
        }
        return new A2egSU(linkedHashMap);
    }

    @Override // A4TApA.A4TApA
    public final Object A5SV6n(int i, Intent intent) {
        BChYOn bChYOn = BChYOn.f7847AcNBzu;
        if (i == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra != null && stringArrayExtra != null) {
                ArrayList arrayList = new ArrayList(intArrayExtra.length);
                for (int i2 : intArrayExtra) {
                    arrayList.add(Boolean.valueOf(i2 == 0));
                }
                ArrayList arrayList2 = new ArrayList();
                for (String str : stringArrayExtra) {
                    if (str != null) {
                        arrayList2.add(str);
                    }
                }
                Iterator it = arrayList2.iterator();
                Iterator it2 = arrayList.iterator();
                ArrayList arrayList3 = new ArrayList(Math.min(AcNBzu.ASJ6gh(arrayList2, 10), AcNBzu.ASJ6gh(arrayList, 10)));
                while (it.hasNext() && it2.hasNext()) {
                    arrayList3.add(new R8Rbcg.A4TApA(it.next(), it2.next()));
                }
                return BPw6Q8.A4TApA(arrayList3);
            }
        }
        return bChYOn;
    }
}
