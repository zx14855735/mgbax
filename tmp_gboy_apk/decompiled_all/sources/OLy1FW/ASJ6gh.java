package OLy1FW;

import LLiCI0.BChYOn;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ASJ6gh {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ADYaiT f6362A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f6363A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int[] f6364A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final BChYOn f6365ADYaiT;

    public ASJ6gh(List list) {
        this.f6363A4TApA = ((A2egSU) J3FDQU.A2egSU.AlLFFp(list, 1)).f6338A5SV6n + 1;
        HashSet hashSet = new HashSet();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(Short.valueOf(((A2egSU) it.next()).f6338A5SV6n));
        }
        this.f6364A5SV6n = new int[this.f6363A4TApA];
        short s = 0;
        while (true) {
            int i = this.f6363A4TApA;
            if (s >= i) {
                this.f6362A2egSU = new ADYaiT((short) 514, (short) 16, (i * 4) + 16);
                this.f6365ADYaiT = new BChYOn(list, hashSet, i);
                return;
            } else {
                if (hashSet.contains(Short.valueOf(s))) {
                    this.f6364A5SV6n[s] = 1073741824;
                }
                s = (short) (s + 1);
            }
        }
    }
}
