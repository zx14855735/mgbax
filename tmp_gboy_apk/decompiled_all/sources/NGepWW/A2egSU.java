package NGepWW;

import COJEAR.F32kj0;
import COJEAR.FG7pZc;
import android.animation.AnimatorSet;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.game.boy.activity.DownLoadActivity;
import com.game.boy.activity.MainActivity;
import com.game.boy.activity.PackageActivity;
import com.game.boy.activity.SplashActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.internal.NavigationMenuView;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.internal.bind.TreeTypeAdapter;
import io.dcloud.ads.core.v2.splash.DCSplashAdListener;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements EsrwYR, EPdU4G, COJEAR.BNL6CD, Oay4Bh.COJEAR, Oay4Bh.AZOQYO, PCV8se.B3GDIM, com.bumptech.glide.load.data.ASJ6gh, androidx.swiperefreshlayout.widget.AZOQYO, O0Tw8S.ADYaiT, DCSplashAdListener, com.google.gson.internal.AlLFFp, JsonSerializationContext, JsonDeserializationContext {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f5657AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Object f5658AlLFFp;

    public /* synthetic */ A2egSU() {
        this.f5657AcNBzu = 9;
    }

    private final void AaHO0E(int i) {
    }

    private final void AcNBzu(Bundle bundle) {
    }

    @Override // NGepWW.EsrwYR
    public void A2egSU(Bundle bundle) {
        switch (this.f5657AcNBzu) {
            case 0:
                A4TApA a4TApA = (A4TApA) this.f5658AlLFFp;
                ReentrantLock reentrantLock = a4TApA.f5670AlLFFp;
                ReentrantLock reentrantLock2 = a4TApA.f5670AlLFFp;
                reentrantLock.lock();
                try {
                    a4TApA.f5668AaHO0E = NOd7IU.A2egSU.f5852B25kr6;
                    A4TApA.ARc23Z(a4TApA);
                    return;
                } finally {
                    reentrantLock2.unlock();
                }
            default:
                return;
        }
    }

    @Override // NGepWW.EsrwYR
    public void A4TApA(NOd7IU.A2egSU a2egSU) {
        A4TApA a4TApA = (A4TApA) this.f5658AlLFFp;
        ReentrantLock reentrantLock = a4TApA.f5670AlLFFp;
        ReentrantLock reentrantLock2 = a4TApA.f5670AlLFFp;
        reentrantLock.lock();
        try {
            a4TApA.f5668AaHO0E = a2egSU;
            A4TApA.ARc23Z(a4TApA);
        } finally {
            reentrantLock2.unlock();
        }
    }

    @Override // NGepWW.EPdU4G
    public NCeV4Q.ASJ6gh A5SV6n(NCeV4Q.ASJ6gh aSJ6gh) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // NGepWW.EPdU4G
    public void ADYaiT(NOd7IU.A2egSU a2egSU, NSK3xo.AYUAbz aYUAbz) {
    }

    @Override // com.bumptech.glide.load.data.ASJ6gh
    public void AMqCpz() {
        ((I3HV03.BPw6Q8) this.f5658AlLFFp).A4TApA();
    }

    @Override // PCV8se.B3GDIM
    public PCV8se.ADYaiT ARc23Z(PCV8se.ADYaiT aDYaiT) {
        if (aDYaiT instanceof PCV8se.AzWtSf) {
            return aDYaiT;
        }
        Paint paint = PCV8se.AaHO0E.f7039CikNvS;
        return new PCV8se.A4TApA(-((PCV8se.AaHO0E) this.f5658AlLFFp).AaHO0E(), aDYaiT);
    }

    @Override // OpB85q.AzWtSf
    public void ASJ6gh(MenuItem menuItem) {
        MainActivity mainActivity = (MainActivity) this.f5658AlLFFp;
        int itemId = menuItem.getItemId();
        int i = MainActivity.f11062B9tovu;
        if (itemId == 2131297686) {
            mainActivity.AaHO0E("home");
        } else if (itemId == 2131297687) {
            mainActivity.AaHO0E("notifications");
        }
    }

    @Override // com.bumptech.glide.load.data.ASJ6gh
    public Object AYUAbz() {
        I3HV03.BPw6Q8 bPw6Q8 = (I3HV03.BPw6Q8) this.f5658AlLFFp;
        bPw6Q8.reset();
        return bPw6Q8;
    }

    @Override // Oay4Bh.COJEAR
    public FG7pZc AZOQYO(View view, FG7pZc fG7pZc, Oay4Bh.CQhlFr cQhlFr) {
        boolean z;
        BottomAppBar bottomAppBar = (BottomAppBar) this.f5658AlLFFp;
        if (bottomAppBar.f11361Dphsd2) {
            bottomAppBar.f11367EH1KK8 = fG7pZc.A2egSU();
        }
        boolean z2 = false;
        if (bottomAppBar.f11362DuwtYk) {
            z = bottomAppBar.f11369EQurEW != fG7pZc.A4TApA();
            bottomAppBar.f11369EQurEW = fG7pZc.A4TApA();
        } else {
            z = false;
        }
        if (bottomAppBar.f11363DvK7DB) {
            boolean z3 = bottomAppBar.f11368EPdU4G != fG7pZc.A5SV6n();
            bottomAppBar.f11368EPdU4G = fG7pZc.A5SV6n();
            z2 = z3;
        }
        if (!z && !z2) {
            return fG7pZc;
        }
        AnimatorSet animatorSet = bottomAppBar.f11355DXnQ0V;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = bottomAppBar.f11354DV2E8K;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        bottomAppBar.BV3sI0();
        bottomAppBar.BTvldC();
        return fG7pZc;
    }

    @Override // com.google.gson.internal.AlLFFp
    public Object AZkASS() {
        Constructor constructor = (Constructor) this.f5658AlLFFp;
        try {
            return constructor.newInstance(null);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Failed to invoke " + constructor + " with no args", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("Failed to invoke " + constructor + " with no args", e3.getTargetException());
        }
    }

    @Override // COJEAR.BNL6CD
    public FG7pZc B3GDIM(View view, FG7pZc fG7pZc) {
        switch (this.f5657AcNBzu) {
            case 3:
                AppBarLayout appBarLayout = (AppBarLayout) this.f5658AlLFFp;
                FG7pZc fG7pZc2 = appBarLayout.getFitsSystemWindows() ? fG7pZc : null;
                if (!Objects.equals(appBarLayout.f11287B3GDIM, fG7pZc2)) {
                    appBarLayout.f11287B3GDIM = fG7pZc2;
                    appBarLayout.setWillNotDraw(!(appBarLayout.f11302C4FrIb != null && appBarLayout.getTopInset() > 0));
                    appBarLayout.requestLayout();
                }
                return fG7pZc;
            default:
                OpB85q.B9tovu b9tovu = (OpB85q.B9tovu) this.f5658AlLFFp;
                if (b9tovu.f6577AlLFFp == null) {
                    b9tovu.f6577AlLFFp = new Rect();
                }
                b9tovu.f6577AlLFFp.set(fG7pZc.A4TApA(), fG7pZc.ADYaiT(), fG7pZc.A5SV6n(), fG7pZc.A2egSU());
                Oay4Bh.BI9f7h bI9f7h = b9tovu.f6801B7CMnp;
                bI9f7h.getClass();
                int ADYaiT2 = fG7pZc.ADYaiT();
                if (bI9f7h.f6570COJEAR != ADYaiT2) {
                    bI9f7h.f6570COJEAR = ADYaiT2;
                    int i = (bI9f7h.f6547AlLFFp.getChildCount() <= 0 && bI9f7h.f6568CASmeH) ? bI9f7h.f6570COJEAR : 0;
                    NavigationMenuView navigationMenuView = bI9f7h.f6546AcNBzu;
                    navigationMenuView.setPadding(0, i, 0, navigationMenuView.getPaddingBottom());
                }
                NavigationMenuView navigationMenuView2 = bI9f7h.f6546AcNBzu;
                navigationMenuView2.setPadding(0, navigationMenuView2.getPaddingTop(), 0, fG7pZc.A2egSU());
                COJEAR.DG07BK.A4TApA(bI9f7h.f6547AlLFFp, fG7pZc);
                F32kj0 f32kj0 = fG7pZc.f1747A2egSU;
                b9tovu.setWillNotDraw(f32kj0.AZkASS().equals(BV3sI0.A5SV6n.AMqCpz) || b9tovu.f6576AcNBzu == null);
                b9tovu.postInvalidateOnAnimation();
                return f32kj0.A5SV6n();
        }
    }

    @Override // NGepWW.EPdU4G
    public void a() {
        EUIRHA euirha = (EUIRHA) this.f5658AlLFFp;
        Iterator it = euirha.f5804A2egSU.values().iterator();
        while (it.hasNext()) {
            ((NUY5pn.BJ7GGh) ((NSK3xo.ARc23Z) it.next())).AYUAbz();
        }
        euirha.f5809ASJ6gh.f5785B25kr6 = Collections.EMPTY_SET;
    }

    @Override // NGepWW.EPdU4G
    public boolean b() {
        return true;
    }

    @Override // NGepWW.EPdU4G
    public void c() {
        EUIRHA euirha = (EUIRHA) this.f5658AlLFFp;
        euirha.f5811AZOQYO.lock();
        try {
            euirha.f5816AmA8tU = new DuwtYk(euirha, euirha.f5806A5SV6n, euirha.f5807ADYaiT, euirha.f5814AcNBzu, euirha.AMqCpz, euirha.f5811AZOQYO, euirha.f5813AaHO0E);
            euirha.f5816AmA8tU.a();
            euirha.f5812AZkASS.signalAll();
        } finally {
            euirha.f5811AZOQYO.unlock();
        }
    }

    @Override // com.google.gson.JsonDeserializationContext
    public Object deserialize(JsonElement jsonElement, Type type) {
        return ((TreeTypeAdapter) this.f5658AlLFFp).f12158A5SV6n.fromJson(jsonElement, type);
    }

    @Override // io.dcloud.ads.core.v2.splash.DCSplashAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaa0aaa.aaaaaaao
    public void onClick() {
    }

    @Override // io.dcloud.ads.core.v2.splash.DCSplashAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaa0aaa.aaaaaaao
    public void onClose() {
        int i = SplashActivity.f11087BChYOn;
        ((SplashActivity) this.f5658AlLFFp).AZOQYO();
    }

    @Override // androidx.swiperefreshlayout.widget.AZOQYO
    public void onRefresh() {
        switch (this.f5657AcNBzu) {
            case 13:
                int i = DownLoadActivity.f10972BI9f7h;
                DownLoadActivity downLoadActivity = (DownLoadActivity) this.f5658AlLFFp;
                downLoadActivity.f10978B9tovu.execute(new com.game.boy.activity.ASJ6gh(0, downLoadActivity));
                break;
            default:
                int i2 = PackageActivity.f11068BI9f7h;
                ((PackageActivity) this.f5658AlLFFp).AYUAbz();
                break;
        }
    }

    @Override // io.dcloud.ads.core.v2.splash.DCSplashAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaa0aaa.aaaaaaao
    public void onShow() {
        int i = SplashActivity.f11087BChYOn;
        SplashActivity splashActivity = (SplashActivity) this.f5658AlLFFp;
        splashActivity.getClass();
        splashActivity.AYUAbz();
    }

    @Override // io.dcloud.ads.core.v2.splash.DCSplashAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaa0aaa.aaaaaaao
    public void onShowError(int i, String str) {
        int i2 = SplashActivity.f11087BChYOn;
        ((SplashActivity) this.f5658AlLFFp).AZOQYO();
    }

    @Override // io.dcloud.ads.core.v2.splash.DCSplashAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaa0aaa.aaaaaaao
    public void onSkip() {
        int i = SplashActivity.f11087BChYOn;
        ((SplashActivity) this.f5658AlLFFp).AZOQYO();
    }

    @Override // io.dcloud.ads.core.v2.splash.DCSplashAdListener, io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaa0aaa.aaaaaaao
    public void onVideoPlayEnd() {
        int i = SplashActivity.f11087BChYOn;
        ((SplashActivity) this.f5658AlLFFp).AZOQYO();
    }

    @Override // com.google.gson.JsonSerializationContext
    public JsonElement serialize(Object obj) {
        return ((TreeTypeAdapter) this.f5658AlLFFp).f12158A5SV6n.toJsonTree(obj);
    }

    public /* synthetic */ A2egSU(int i, Object obj) {
        this.f5657AcNBzu = i;
        this.f5658AlLFFp = obj;
    }

    public A2egSU(InputStream inputStream, HZUvgL.AaHO0E aaHO0E) {
        this.f5657AcNBzu = 12;
        I3HV03.BPw6Q8 bPw6Q8 = new I3HV03.BPw6Q8(inputStream, aaHO0E);
        this.f5658AlLFFp = bPw6Q8;
        bPw6Q8.mark(AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_MEMORY_SIZE);
    }

    @Override // com.google.gson.JsonSerializationContext
    public JsonElement serialize(Object obj, Type type) {
        return ((TreeTypeAdapter) this.f5658AlLFFp).f12158A5SV6n.toJsonTree(obj, type);
    }

    @Override // NGepWW.EsrwYR
    public void a(int i) {
        switch (this.f5657AcNBzu) {
            case 0:
                A4TApA a4TApA = (A4TApA) this.f5658AlLFFp;
                ReentrantLock reentrantLock = a4TApA.f5670AlLFFp;
                ReentrantLock reentrantLock2 = a4TApA.f5670AlLFFp;
                reentrantLock.lock();
                try {
                    if (a4TApA.f5669AcNBzu) {
                        a4TApA.f5669AcNBzu = false;
                        A4TApA.A2egSU(a4TApA, i);
                    } else {
                        a4TApA.f5669AcNBzu = true;
                        a4TApA.f5662ADYaiT.a(i);
                    }
                    return;
                } finally {
                    reentrantLock2.unlock();
                }
            default:
                return;
        }
    }

    public A2egSU(com.bumptech.glide.ASJ6gh aSJ6gh) {
        this.f5657AcNBzu = 11;
        this.f5658AlLFFp = Collections.unmodifiableMap(new HashMap(aSJ6gh.f9928A2egSU));
    }
}
