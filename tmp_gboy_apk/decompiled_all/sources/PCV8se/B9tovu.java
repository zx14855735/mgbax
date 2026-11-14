package PCV8se;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B9tovu extends BNL6CD {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ ArrayList f7117A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ Matrix f7118ADYaiT;

    public B9tovu(ArrayList arrayList, Matrix matrix) {
        this.f7117A5SV6n = arrayList;
        this.f7118ADYaiT = matrix;
    }

    @Override // PCV8se.BNL6CD
    public final void A2egSU(Matrix matrix, P94amq.A2egSU a2egSU, int i, Canvas canvas) {
        Iterator it = this.f7117A5SV6n.iterator();
        while (it.hasNext()) {
            ((BNL6CD) it.next()).A2egSU(this.f7118ADYaiT, a2egSU, i, canvas);
        }
    }
}
