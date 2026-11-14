package IlwJBd;

import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ADYaiT implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4053AcNBzu = 0;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Object f4054AlLFFp;

    public ADYaiT(AMqCpz aMqCpz) {
        this.f4054AlLFFp = new WeakReference(aMqCpz);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        switch (this.f4053AcNBzu) {
            case 0:
                Log.isLoggable("CustomViewTarget", 2);
                AMqCpz aMqCpz = (AMqCpz) ((WeakReference) this.f4054AlLFFp).get();
                if (aMqCpz != null) {
                    ArrayList arrayList = aMqCpz.f4057A4TApA;
                    if (!arrayList.isEmpty()) {
                        ImageView imageView = aMqCpz.f4056A2egSU;
                        int paddingRight = imageView.getPaddingRight() + imageView.getPaddingLeft();
                        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                        int A2egSU2 = aMqCpz.A2egSU(imageView.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
                        int paddingBottom = imageView.getPaddingBottom() + imageView.getPaddingTop();
                        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                        int A2egSU3 = aMqCpz.A2egSU(imageView.getHeight(), layoutParams2 != null ? layoutParams2.height : 0, paddingBottom);
                        if (A2egSU2 > 0 || A2egSU2 == Integer.MIN_VALUE) {
                            if (A2egSU3 > 0 || A2egSU3 == Integer.MIN_VALUE) {
                                Iterator it = new ArrayList(arrayList).iterator();
                                while (it.hasNext()) {
                                    ((IhMMDv.ASJ6gh) ((ASJ6gh) it.next())).AcNBzu(A2egSU2, A2egSU3);
                                }
                                ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
                                if (viewTreeObserver.isAlive()) {
                                    viewTreeObserver.removeOnPreDrawListener(aMqCpz.f4058A5SV6n);
                                }
                                aMqCpz.f4058A5SV6n = null;
                                arrayList.clear();
                                break;
                            }
                        }
                    }
                }
                break;
            case 1:
                Log.isLoggable("ViewTarget", 2);
                AZOQYO azoqyo = (AZOQYO) ((WeakReference) this.f4054AlLFFp).get();
                if (azoqyo != null) {
                    ArrayList arrayList2 = azoqyo.f4061A4TApA;
                    if (!arrayList2.isEmpty()) {
                        ImageView imageView2 = azoqyo.f4060A2egSU;
                        int paddingRight2 = imageView2.getPaddingRight() + imageView2.getPaddingLeft();
                        ViewGroup.LayoutParams layoutParams3 = imageView2.getLayoutParams();
                        int A2egSU4 = azoqyo.A2egSU(imageView2.getWidth(), layoutParams3 != null ? layoutParams3.width : 0, paddingRight2);
                        int paddingBottom2 = imageView2.getPaddingBottom() + imageView2.getPaddingTop();
                        ViewGroup.LayoutParams layoutParams4 = imageView2.getLayoutParams();
                        int A2egSU5 = azoqyo.A2egSU(imageView2.getHeight(), layoutParams4 != null ? layoutParams4.height : 0, paddingBottom2);
                        if (A2egSU4 > 0 || A2egSU4 == Integer.MIN_VALUE) {
                            if (A2egSU5 > 0 || A2egSU5 == Integer.MIN_VALUE) {
                                Iterator it2 = new ArrayList(arrayList2).iterator();
                                while (it2.hasNext()) {
                                    ((IhMMDv.ASJ6gh) ((ASJ6gh) it2.next())).AcNBzu(A2egSU4, A2egSU5);
                                }
                                ViewTreeObserver viewTreeObserver2 = imageView2.getViewTreeObserver();
                                if (viewTreeObserver2.isAlive()) {
                                    viewTreeObserver2.removeOnPreDrawListener(azoqyo.f4062A5SV6n);
                                }
                                azoqyo.f4062A5SV6n = null;
                                arrayList2.clear();
                                break;
                            }
                        }
                    }
                }
                break;
            default:
                ((CoordinatorLayout) this.f4054AlLFFp).AZOQYO(0);
                break;
        }
        return true;
    }

    public ADYaiT(AZOQYO azoqyo) {
        this.f4054AlLFFp = new WeakReference(azoqyo);
    }

    public ADYaiT(CoordinatorLayout coordinatorLayout) {
        this.f4054AlLFFp = coordinatorLayout;
    }
}
