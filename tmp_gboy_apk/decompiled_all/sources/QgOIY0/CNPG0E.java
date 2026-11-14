package QgOIY0;

import COJEAR.CmUvjW;
import COJEAR.DG07BK;
import android.view.View;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class CNPG0E implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f7674AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f7675AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final ArrayList f7676AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final ArrayList f7677AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final ArrayList f7678B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final ArrayList f7679B2KMhB;

    public /* synthetic */ CNPG0E(int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, int i2) {
        this.f7674AcNBzu = i2;
        this.f7675AlLFFp = i;
        this.f7676AmA8tU = arrayList;
        this.f7677AzWtSf = arrayList2;
        this.f7678B25kr6 = arrayList3;
        this.f7679B2KMhB = arrayList4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f7679B2KMhB;
        ArrayList arrayList2 = this.f7678B25kr6;
        ArrayList arrayList3 = this.f7677AzWtSf;
        ArrayList arrayList4 = this.f7676AmA8tU;
        int i = this.f7675AlLFFp;
        int i2 = 0;
        switch (this.f7674AcNBzu) {
            case 0:
                while (i2 < i) {
                    ((View) arrayList4.get(i2)).setTransitionName((String) arrayList3.get(i2));
                    ((View) arrayList2.get(i2)).setTransitionName((String) arrayList.get(i2));
                    i2++;
                }
                break;
            default:
                while (i2 < i) {
                    View view = (View) arrayList4.get(i2);
                    String str = (String) arrayList3.get(i2);
                    WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
                    CmUvjW.BChYOn(view, str);
                    CmUvjW.BChYOn((View) arrayList2.get(i2), (String) arrayList.get(i2));
                    i2++;
                }
                break;
        }
    }
}
