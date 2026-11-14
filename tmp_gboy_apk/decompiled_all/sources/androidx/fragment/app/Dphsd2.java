package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class Dphsd2 {
    public static void ADYaiT(List list, View view) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == view) {
                return;
            }
        }
        WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
        if (COJEAR.CmUvjW.AaHO0E(view) != null) {
            list.add(view);
        }
        for (int i2 = size; i2 < list.size(); i2++) {
            View view2 = (View) list.get(i2);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = viewGroup.getChildAt(i3);
                    int i4 = 0;
                    while (true) {
                        if (i4 < size) {
                            if (list.get(i4) == childAt) {
                                break;
                            } else {
                                i4++;
                            }
                        } else if (COJEAR.CmUvjW.AaHO0E(childAt) != null) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    public static void ASJ6gh(Rect rect, View view) {
        WeakHashMap weakHashMap = COJEAR.DG07BK.f1680A2egSU;
        if (view.isAttachedToWindow()) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            view.getRootView().getLocationOnScreen(new int[2]);
            rectF.offset(r1[0], r1[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public static boolean AYUAbz(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void A2egSU(View view, Object obj);

    public abstract void A4TApA(Object obj, ArrayList arrayList);

    public abstract void A5SV6n(ViewGroup viewGroup, Object obj);

    public abstract boolean AMqCpz(Object obj);

    public abstract Object ARc23Z(Object obj);

    public abstract Object AZOQYO(Object obj, Object obj2, Object obj3);

    public abstract Object AZkASS(Object obj, Object obj2);

    public abstract void AaHO0E(Object obj, View view, ArrayList arrayList);

    public abstract void AcNBzu(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2);

    public abstract void AlLFFp(View view, Object obj);

    public abstract void AmA8tU(Object obj, Rect rect);

    public void AzWtSf(Object obj, C2rE4F.AMqCpz aMqCpz, AYUAbz aYUAbz) {
        aYUAbz.run();
    }

    public abstract void B25kr6(Object obj, View view, ArrayList arrayList);

    public abstract void B2KMhB(Object obj, ArrayList arrayList, ArrayList arrayList2);

    public abstract Object B3GDIM(Object obj);
}
