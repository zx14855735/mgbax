package androidx.fragment.app;

import java.util.ArrayList;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CkXcdM implements androidx.activity.result.A4TApA {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f8824AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ CtxOCS f8825AlLFFp;

    public /* synthetic */ CkXcdM(CtxOCS ctxOCS, int i) {
        this.f8824AcNBzu = i;
        this.f8825AlLFFp = ctxOCS;
    }

    @Override // androidx.activity.result.A4TApA
    public final void A5SV6n(Object obj) {
        switch (this.f8824AcNBzu) {
            case 0:
                Map map = (Map) obj;
                String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
                }
                CtxOCS ctxOCS = this.f8825AlLFFp;
                D07BeM d07BeM = (D07BeM) ctxOCS.f8856BV3sI0.pollFirst();
                if (d07BeM != null) {
                    Fragment A5SV6n2 = ctxOCS.f8831A5SV6n.A5SV6n(d07BeM.f8866AcNBzu);
                    if (A5SV6n2 != null) {
                        A5SV6n2.onRequestPermissionsResult(d07BeM.f8867AlLFFp, strArr, iArr);
                        break;
                    }
                }
                break;
            case 1:
                androidx.activity.result.A2egSU a2egSU = (androidx.activity.result.A2egSU) obj;
                CtxOCS ctxOCS2 = this.f8825AlLFFp;
                D07BeM d07BeM2 = (D07BeM) ctxOCS2.f8856BV3sI0.pollLast();
                if (d07BeM2 != null) {
                    Fragment A5SV6n3 = ctxOCS2.f8831A5SV6n.A5SV6n(d07BeM2.f8866AcNBzu);
                    if (A5SV6n3 != null) {
                        A5SV6n3.onActivityResult(d07BeM2.f8867AlLFFp, a2egSU.f7990AcNBzu, a2egSU.f7991AlLFFp);
                        break;
                    }
                }
                break;
            default:
                androidx.activity.result.A2egSU a2egSU2 = (androidx.activity.result.A2egSU) obj;
                CtxOCS ctxOCS3 = this.f8825AlLFFp;
                D07BeM d07BeM3 = (D07BeM) ctxOCS3.f8856BV3sI0.pollFirst();
                if (d07BeM3 != null) {
                    Fragment A5SV6n4 = ctxOCS3.f8831A5SV6n.A5SV6n(d07BeM3.f8866AcNBzu);
                    if (A5SV6n4 != null) {
                        A5SV6n4.onActivityResult(d07BeM3.f8867AlLFFp, a2egSU2.f7990AcNBzu, a2egSU2.f7991AlLFFp);
                        break;
                    }
                }
                break;
        }
    }
}
