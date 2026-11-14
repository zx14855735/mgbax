package DaOi9o;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BIYEnU implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public B4ZgIw f2268AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public ViewGroup f2269AlLFFp;

    /* JADX WARN: Removed duplicated region for block: B:116:0x01f3 A[EDGE_INSN: B:116:0x01f3->B:117:0x01f3 BREAK  A[LOOP:1: B:17:0x0087->B:29:0x01ea], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x008c  */
    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onPreDraw() {
        /*
            Method dump skipped, instructions count: 702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: DaOi9o.BIYEnU.onPreDraw():boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        ViewGroup viewGroup = this.f2269AlLFFp;
        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
        viewGroup.removeOnAttachStateChangeListener(this);
        ArrayList arrayList = BJ7GGh.f2272A5SV6n;
        ViewGroup viewGroup2 = this.f2269AlLFFp;
        arrayList.remove(viewGroup2);
        ArrayList arrayList2 = (ArrayList) BJ7GGh.A4TApA().get(viewGroup2);
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((B4ZgIw) it.next()).BPw6Q8(viewGroup2);
            }
        }
        this.f2268AcNBzu.AZOQYO(true);
    }
}
