package De4eam;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA implements AaHO0E {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ArrayList f2402A2egSU = new ArrayList();

    @Override // De4eam.AaHO0E
    public final void transformPage(View view, float f) {
        Iterator it = this.f2402A2egSU.iterator();
        while (it.hasNext()) {
            ((AaHO0E) it.next()).transformPage(view, f);
        }
    }
}
