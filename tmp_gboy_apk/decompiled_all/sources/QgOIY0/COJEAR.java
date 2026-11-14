package QgOIY0;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class COJEAR implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f7680AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ArrayList f7681AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final QkAq4X.A4TApA f7682AmA8tU;

    public /* synthetic */ COJEAR(ArrayList arrayList, QkAq4X.A4TApA a4TApA, int i) {
        this.f7680AcNBzu = i;
        this.f7681AlLFFp = arrayList;
        this.f7682AmA8tU = a4TApA;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        switch (this.f7680AcNBzu) {
            case 0:
                ArrayList arrayList = this.f7681AlLFFp;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view = (View) arrayList.get(i);
                    String transitionName = view.getTransitionName();
                    if (transitionName != null) {
                        Iterator it = this.f7682AmA8tU.entrySet().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                if (transitionName.equals(entry.getValue())) {
                                    str = (String) entry.getKey();
                                }
                            } else {
                                str = null;
                            }
                        }
                        view.setTransitionName(str);
                    }
                }
                break;
            default:
                ArrayList arrayList2 = this.f7681AlLFFp;
                int size2 = arrayList2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    View view2 = (View) arrayList2.get(i2);
                    view2.setTransitionName((String) this.f7682AmA8tU.get(view2.getTransitionName()));
                }
                break;
        }
    }
}
