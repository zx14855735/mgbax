package androidx.activity;

import MOpbMP.BmvVmW;
import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.CtxOCS;
import com.game.boy.activity.MainActivity;
import com.google.android.material.search.SearchView;
import java.util.Iterator;
import java.util.ListIterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Runnable f7980A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final RD2OKB.ARc23Z f7981A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public BmvVmW f7982A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final OnBackInvokedCallback f7983ADYaiT;
    public OnBackInvokedDispatcher AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f7984ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public boolean f7985ASJ6gh;

    public final class LifecycleOnBackPressedCancellable implements androidx.lifecycle.B4ZgIw, A5SV6n {

        /* renamed from: AcNBzu, reason: collision with root package name */
        public final androidx.lifecycle.AzWtSf f7986AcNBzu;

        /* renamed from: AlLFFp, reason: collision with root package name */
        public final BmvVmW f7987AlLFFp;

        /* renamed from: AmA8tU, reason: collision with root package name */
        public B4ZgIw f7988AmA8tU;

        /* renamed from: AzWtSf, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f7989AzWtSf;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, androidx.lifecycle.AzWtSf azWtSf, BmvVmW bmvVmW) {
            RXb0Sz.ARc23Z.AMqCpz(bmvVmW, "onBackPressedCallback");
            this.f7989AzWtSf = onBackPressedDispatcher;
            this.f7986AcNBzu = azWtSf;
            this.f7987AlLFFp = bmvVmW;
            azWtSf.A2egSU(this);
        }

        @Override // androidx.activity.A5SV6n
        public final void cancel() {
            this.f7986AcNBzu.A5SV6n(this);
            this.f7987AlLFFp.f5057A4TApA.remove(this);
            B4ZgIw b4ZgIw = this.f7988AmA8tU;
            if (b4ZgIw != null) {
                b4ZgIw.cancel();
            }
            this.f7988AmA8tU = null;
        }

        @Override // androidx.lifecycle.B4ZgIw
        public final void onStateChanged(androidx.lifecycle.B9tovu b9tovu, androidx.lifecycle.AlLFFp alLFFp) {
            if (alLFFp != androidx.lifecycle.AlLFFp.ON_START) {
                if (alLFFp != androidx.lifecycle.AlLFFp.ON_STOP) {
                    if (alLFFp == androidx.lifecycle.AlLFFp.ON_DESTROY) {
                        cancel();
                        return;
                    }
                    return;
                } else {
                    B4ZgIw b4ZgIw = this.f7988AmA8tU;
                    if (b4ZgIw != null) {
                        b4ZgIw.cancel();
                        return;
                    }
                    return;
                }
            }
            OnBackPressedDispatcher onBackPressedDispatcher = this.f7989AzWtSf;
            onBackPressedDispatcher.getClass();
            BmvVmW bmvVmW = this.f7987AlLFFp;
            RXb0Sz.ARc23Z.AMqCpz(bmvVmW, "onBackPressedCallback");
            onBackPressedDispatcher.f7981A4TApA.addLast(bmvVmW);
            B4ZgIw b4ZgIw2 = new B4ZgIw(onBackPressedDispatcher, bmvVmW);
            bmvVmW.f5057A4TApA.add(b4ZgIw2);
            onBackPressedDispatcher.ADYaiT();
            bmvVmW.f5058A5SV6n = new B7CMnp(1, onBackPressedDispatcher);
            this.f7988AmA8tU = b4ZgIw2;
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f7980A2egSU = runnable;
        this.f7981A4TApA = new RD2OKB.ARc23Z();
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            this.f7983ADYaiT = i >= 34 ? B3GDIM.f7965A2egSU.A2egSU(new AmA8tU(0, this), new AmA8tU(1, this), new AzWtSf(0, this), new AzWtSf(1, this)) : B25kr6.f7960A2egSU.A2egSU(new AzWtSf(2, this));
        }
    }

    public final void A2egSU(androidx.lifecycle.B9tovu b9tovu, BmvVmW bmvVmW) {
        RXb0Sz.ARc23Z.AMqCpz(b9tovu, "owner");
        RXb0Sz.ARc23Z.AMqCpz(bmvVmW, "onBackPressedCallback");
        androidx.lifecycle.AzWtSf lifecycle = b9tovu.getLifecycle();
        if (lifecycle.A4TApA() == androidx.lifecycle.AmA8tU.f8977AcNBzu) {
            return;
        }
        bmvVmW.f5057A4TApA.add(new LifecycleOnBackPressedCancellable(this, lifecycle, bmvVmW));
        ADYaiT();
        bmvVmW.f5058A5SV6n = new B7CMnp(0, this);
    }

    public final void A4TApA() {
        Object obj;
        RD2OKB.ARc23Z aRc23Z = this.f7981A4TApA;
        ListIterator listIterator = aRc23Z.listIterator(aRc23Z.A2egSU());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            } else {
                obj = listIterator.previous();
                if (((BmvVmW) obj).f5056A2egSU) {
                    break;
                }
            }
        }
        BmvVmW bmvVmW = (BmvVmW) obj;
        this.f7982A5SV6n = null;
        if (bmvVmW == null) {
            Runnable runnable = this.f7980A2egSU;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        switch (bmvVmW.f5059ADYaiT) {
            case 0:
                ((SearchView) bmvVmW.AMqCpz).ASJ6gh();
                break;
            case 1:
                CtxOCS ctxOCS = (CtxOCS) bmvVmW.AMqCpz;
                ctxOCS.BIYEnU(true);
                if (!ctxOCS.f8835AYUAbz.f5056A2egSU) {
                    ctxOCS.f8834ASJ6gh.A4TApA();
                    break;
                } else {
                    ctxOCS.Cd8JRx();
                    break;
                }
            default:
                ((MainActivity) bmvVmW.AMqCpz).moveTaskToBack(true);
                break;
        }
    }

    public final void A5SV6n(boolean z) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.AMqCpz;
        OnBackInvokedCallback onBackInvokedCallback = this.f7983ADYaiT;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        B25kr6 b25kr6 = B25kr6.f7960A2egSU;
        if (z && !this.f7984ARc23Z) {
            b25kr6.A4TApA(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f7984ARc23Z = true;
        } else {
            if (z || !this.f7984ARc23Z) {
                return;
            }
            b25kr6.A5SV6n(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f7984ARc23Z = false;
        }
    }

    public final void ADYaiT() {
        boolean z = this.f7985ASJ6gh;
        boolean z2 = false;
        RD2OKB.ARc23Z aRc23Z = this.f7981A4TApA;
        if (!(aRc23Z != null) || !aRc23Z.isEmpty()) {
            Iterator it = aRc23Z.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((BmvVmW) it.next()).f5056A2egSU) {
                    z2 = true;
                    break;
                }
            }
        }
        this.f7985ASJ6gh = z2;
        if (z2 == z || Build.VERSION.SDK_INT < 33) {
            return;
        }
        A5SV6n(z2);
    }

    public OnBackPressedDispatcher() {
        this(null);
    }
}
