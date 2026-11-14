package MOpbMP;

import ADYaiT.CtFAbx;
import ADYaiT.DUi7mC;
import COJEAR.DG07BK;
import COJEAR.FG7pZc;
import NGepWW.EdhSi6;
import NGepWW.EiK8oA;
import android.app.Application;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.game.boy.MyApp;
import com.game.boy.activity.KeyMappingSettings;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4985AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Object f4986AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Object f4987AmA8tU;

    public /* synthetic */ A2egSU(Object obj, int i, Object obj2) {
        this.f4985AcNBzu = i;
        this.f4987AmA8tU = obj;
        this.f4986AlLFFp = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FragmentActivity activity;
        NUY5pn.C4FrIb c4FrIb;
        int i = 2;
        int i2 = 1;
        switch (this.f4985AcNBzu) {
            case 0:
                MaterialButton materialButton = ((A4TApA) this.f4987AmA8tU).f4989AlLFFp.f4996AzWtSf;
                if (materialButton != null) {
                    materialButton.setEnabled(true);
                }
                MyApp.A2egSU((String) this.f4986AlLFFp);
                return;
            case 1:
                A5SV6n a5SV6n = (A5SV6n) this.f4987AmA8tU;
                if (a5SV6n.f4991AlLFFp.f4996AzWtSf == null) {
                    return;
                }
                MTKlkd.A2egSU a2egSU = (MTKlkd.A2egSU) this.f4986AlLFFp;
                boolean A5SV6n2 = a2egSU.A5SV6n();
                ARc23Z aRc23Z = a5SV6n.f4991AlLFFp;
                if (A5SV6n2) {
                    aRc23Z.AzWtSf(new ADYaiT(aRc23Z, i));
                    MyApp.A2egSU(a2egSU.A2egSU());
                    return;
                } else {
                    aRc23Z.f4996AzWtSf.setEnabled(true);
                    MyApp.A2egSU(a2egSU.A2egSU());
                    return;
                }
            case 2:
                MaterialButton materialButton2 = ((A5SV6n) this.f4987AmA8tU).f4991AlLFFp.f4996AzWtSf;
                if (materialButton2 != null) {
                    materialButton2.setEnabled(true);
                }
                MyApp.A2egSU((String) this.f4986AlLFFp);
                return;
            case 3:
                MTKlkd.A2egSU a2egSU2 = (MTKlkd.A2egSU) this.f4986AlLFFp;
                A4TApA a4TApA = (A4TApA) this.f4987AmA8tU;
                ARc23Z aRc23Z2 = a4TApA.f4989AlLFFp;
                MyApp.A2egSU(a2egSU2.A2egSU());
                if (a2egSU2.A5SV6n()) {
                    a4TApA.f4989AlLFFp.B3GDIM(true);
                    return;
                } else {
                    a4TApA.f4989AlLFFp.AmA8tU();
                    return;
                }
            case 4:
                ((A4TApA) this.f4987AmA8tU).f4989AlLFFp.AmA8tU();
                MyApp.A2egSU((String) this.f4986AlLFFp);
                return;
            case 5:
                ARc23Z aRc23Z3 = (ARc23Z) this.f4987AmA8tU;
                if (!aRc23Z3.f5013C2rE4F || !aRc23Z3.isAdded() || aRc23Z3.getView() == null || (activity = aRc23Z3.getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
                try {
                    ((Runnable) this.f4986AlLFFp).run();
                    return;
                } catch (Throwable unused) {
                    return;
                }
            case 6:
                A5SV6n a5SV6n2 = (A5SV6n) this.f4987AmA8tU;
                if (a5SV6n2.f4991AlLFFp.f4996AzWtSf == null) {
                    return;
                }
                MTKlkd.AZkASS aZkASS = (MTKlkd.AZkASS) this.f4986AlLFFp;
                boolean AYUAbz2 = aZkASS.AYUAbz();
                ARc23Z aRc23Z4 = a5SV6n2.f4991AlLFFp;
                if (AYUAbz2) {
                    ARc23Z.B2KMhB(aZkASS, aRc23Z4.f5009BTvldC);
                    aRc23Z4.dismiss();
                    return;
                } else {
                    aRc23Z4.f4996AzWtSf.setEnabled(true);
                    MyApp.A2egSU(aZkASS.AMqCpz());
                    return;
                }
            case 7:
                MaterialButton materialButton3 = ((A5SV6n) this.f4987AmA8tU).f4991AlLFFp.f4996AzWtSf;
                if (materialButton3 != null) {
                    materialButton3.setEnabled(true);
                }
                MyApp.A2egSU((String) this.f4986AlLFFp);
                return;
            case 8:
                AZOQYO azoqyo = ((AYUAbz) this.f4987AmA8tU).f5016AcNBzu;
                azoqyo.getClass();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                azoqyo.getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                int i3 = displayMetrics.heightPixels;
                FG7pZc AZOQYO2 = DG07BK.AZOQYO(azoqyo.requireActivity().getWindow().getDecorView());
                int i4 = i3 - (AZOQYO2 != null ? AZOQYO2.f1747A2egSU.ARc23Z(1).f1483A4TApA : 0);
                FrameLayout frameLayout = (FrameLayout) this.f4986AlLFFp;
                ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
                layoutParams.height = i4;
                frameLayout.setLayoutParams(layoutParams);
                azoqyo.f5019AmA8tU.setPeekHeight(i4);
                BottomSheetBehavior bottomSheetBehavior = azoqyo.f5019AmA8tU;
                bottomSheetBehavior.f11400BI9f7h = i4;
                bottomSheetBehavior.setState(3);
                return;
            case 9:
                ((MaterialButton) ((I3HV03.A4TApA) this.f4987AmA8tU).f3808AlLFFp).setChecked(((MTKlkd.A2egSU) this.f4986AlLFFp).A4TApA());
                return;
            case 10:
                IQ76hF.AmA8tU amA8tU = (IQ76hF.AmA8tU) this.f4987AmA8tU;
                ((BV3sI0) amA8tU.f3956AlLFFp).f5055A5SV6n.f5071B7CMnp.notifyDataSetChanged();
                MTKlkd.ASJ6gh aSJ6gh = (MTKlkd.ASJ6gh) this.f4986AlLFFp;
                boolean isEmpty = aSJ6gh.A2egSU().isEmpty();
                BV3sI0 bV3sI0 = (BV3sI0) amA8tU.f3956AlLFFp;
                if (isEmpty) {
                    Toast.makeText(bV3sI0.f5055A5SV6n.requireActivity(), "未找到相关结果", 0).show();
                    return;
                }
                Toast.makeText(bV3sI0.f5055A5SV6n.requireActivity(), "找到 " + aSJ6gh.A5SV6n() + " 个结果", 0).show();
                return;
            case 11:
                C2rE4F c2rE4F = (C2rE4F) this.f4987AmA8tU;
                c2rE4F.f5087B9tovu.f11049B2KMhB = KeyMappingSettings.AYUAbz(c2rE4F.f5087B9tovu.getIntent().getStringExtra("profile-name"));
                c2rE4F.getActivity().runOnUiThread(new LLYwnm.AMqCpz(10, this));
                return;
            case 12:
                try {
                    MhxuEA.A5SV6n a5SV6n3 = (MhxuEA.A5SV6n) this.f4987AmA8tU;
                    if (a5SV6n3.f5365AcNBzu.compareAndSet(false, true)) {
                        a5SV6n3.f5359ARc23Z.submit(new MhxuEA.A2egSU(a5SV6n3, r3));
                    }
                    MhxuEA.A5SV6n a5SV6n4 = (MhxuEA.A5SV6n) this.f4987AmA8tU;
                    if (a5SV6n4.f5366AlLFFp.compareAndSet(false, true)) {
                        a5SV6n4.f5360ASJ6gh.scheduleWithFixedDelay(new MhxuEA.A2egSU(a5SV6n4, i2), 0L, 10L, TimeUnit.MILLISECONDS);
                    }
                    Thread.sleep(50L);
                    int hashCode = UUID.randomUUID().hashCode() & Integer.MAX_VALUE;
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                    MdiDtx.A5SV6n a5SV6n5 = new MdiDtx.A5SV6n(hashCode, ((MhxuEA.A5SV6n) this.f4987AmA8tU).f5355A2egSU, (InetSocketAddress) this.f4986AlLFFp, new DUi7mC(this, hashCode, atomicBoolean, countDownLatch));
                    ((MhxuEA.A5SV6n) this.f4987AmA8tU).f5356A4TApA.put(Integer.valueOf(hashCode), a5SV6n5);
                    while (r3 < 3) {
                        a5SV6n5.ADYaiT(MhxuEA.A5SV6n.f5350B3GDIM);
                        a5SV6n5.A2egSU(System.currentTimeMillis());
                        if (countDownLatch.await(3000L, TimeUnit.MILLISECONDS) && atomicBoolean.get()) {
                            MhxuEA.A5SV6n.A2egSU((MhxuEA.A5SV6n) this.f4987AmA8tU);
                            return;
                        }
                        r3++;
                    }
                    ((MhxuEA.A5SV6n) this.f4987AmA8tU).f5356A4TApA.remove(Integer.valueOf(hashCode));
                    IQ76hF.AmA8tU amA8tU2 = ((MhxuEA.A5SV6n) this.f4987AmA8tU).f5370B2KMhB;
                    Exception exc = new Exception("Handshake timeout after 3 retries");
                    amA8tU2.getClass();
                    Objects.toString(exc);
                    return;
                } catch (Exception e) {
                    ((MhxuEA.A5SV6n) this.f4987AmA8tU).f5370B2KMhB.getClass();
                    Objects.toString(e);
                    return;
                }
            case 13:
                SwipeRefreshLayout swipeRefreshLayout = ((Mi9UWv.ASJ6gh) this.f4987AmA8tU).f5405B2KMhB;
                if (swipeRefreshLayout != null) {
                    swipeRefreshLayout.setRefreshing(false);
                }
                MyApp.A2egSU("房间数据解析错误: " + ((String) this.f4986AlLFFp));
                return;
            case 14:
                NGepWW.A5SV6n a5SV6n6 = (NGepWW.A5SV6n) this.f4987AmA8tU;
                a5SV6n6.getClass();
                NGepWW.CASmeH cASmeH = (NGepWW.CASmeH) this.f4986AlLFFp;
                NOd7IU.A2egSU a2egSU3 = cASmeH.f5710AlLFFp;
                if (a2egSU3.A5SV6n()) {
                    NUY5pn.AaHO0E aaHO0E = cASmeH.f5711AmA8tU;
                    a2egSU3 = aaHO0E.f5956AmA8tU;
                    if (a2egSU3.A5SV6n()) {
                        EiK8oA eiK8oA = a5SV6n6.f5677ASJ6gh;
                        NUY5pn.C4FrIb A2egSU2 = NUY5pn.A2egSU.A2egSU(aaHO0E.f5955AlLFFp);
                        Set set = a5SV6n6.f5675ADYaiT;
                        eiK8oA.getClass();
                        if (A2egSU2 == null || set == null) {
                            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                            eiK8oA.A2egSU(new NOd7IU.A2egSU(4));
                        } else {
                            eiK8oA.f5832A5SV6n = A2egSU2;
                            eiK8oA.f5833ADYaiT = set;
                            if (eiK8oA.AMqCpz) {
                                ((NUY5pn.BJ7GGh) eiK8oA.f5831A4TApA).A5SV6n(A2egSU2, set);
                            }
                        }
                        a5SV6n6.f5676ARc23Z.AYUAbz();
                        return;
                    }
                    String valueOf = String.valueOf(a2egSU3);
                    Log.wtf("SignInCoordinator", CtFAbx.B25kr6(new StringBuilder(valueOf.length() + 48), "Sign-in succeeded with resolve account failure: ", valueOf), new Exception());
                }
                a5SV6n6.f5677ASJ6gh.A2egSU(a2egSU3);
                a5SV6n6.f5676ARc23Z.AYUAbz();
                return;
            case 15:
                ((EdhSi6) this.f4987AmA8tU).A4TApA((NOd7IU.A2egSU) this.f4986AlLFFp);
                return;
            case 16:
                NOd7IU.A2egSU a2egSU4 = (NOd7IU.A2egSU) this.f4986AlLFFp;
                boolean A5SV6n3 = a2egSU4.A5SV6n();
                EiK8oA eiK8oA2 = (EiK8oA) this.f4987AmA8tU;
                if (!A5SV6n3) {
                    ((EdhSi6) eiK8oA2.f5830A2egSU.f5842B25kr6.get(null)).A4TApA(a2egSU4);
                    return;
                }
                eiK8oA2.AMqCpz = true;
                NSK3xo.ARc23Z aRc23Z5 = eiK8oA2.f5831A4TApA;
                if (!aRc23Z5.i()) {
                    ((NUY5pn.BJ7GGh) aRc23Z5).A5SV6n(null, Collections.EMPTY_SET);
                    return;
                } else {
                    if (!eiK8oA2.AMqCpz || (c4FrIb = eiK8oA2.f5832A5SV6n) == null) {
                        return;
                    }
                    ((NUY5pn.BJ7GGh) aRc23Z5).A5SV6n(c4FrIb, eiK8oA2.f5833ADYaiT);
                    return;
                }
            case 17:
                CqNSpT.ARc23Z aRc23Z6 = ((SwipeDismissBehavior) this.f4987AmA8tU).f11342AcNBzu;
                if (aRc23Z6 == null || !aRc23Z6.ASJ6gh()) {
                    return;
                }
                ((View) this.f4986AlLFFp).postOnAnimation(this);
                return;
            case 18:
                ((androidx.core.app.AZOQYO) this.f4986AlLFFp).f8473A2egSU = this.f4987AmA8tU;
                return;
            case 19:
                ((Application) this.f4986AlLFFp).unregisterActivityLifecycleCallbacks((androidx.core.app.AZOQYO) this.f4987AmA8tU);
                return;
            case 20:
                try {
                    Method method = androidx.core.app.AZkASS.f8481ADYaiT;
                    Object obj = this.f4987AmA8tU;
                    Object obj2 = this.f4986AlLFFp;
                    if (method != null) {
                        method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        androidx.core.app.AZkASS.AMqCpz.invoke(obj2, obj, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e2) {
                    if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                        throw e2;
                    }
                    return;
                } catch (Throwable unused2) {
                    return;
                }
            default:
                OOnEhG.A4TApA a4TApA2 = new OOnEhG.A4TApA(((com.game.boy.activity.B4ZgIw) this.f4987AmA8tU).f10911AcNBzu.f10914AmA8tU);
                ADYaiT.AZOQYO azoqyo2 = a4TApA2.f81AcNBzu;
                azoqyo2.AMqCpz = "游戏启动失败";
                String str = (String) this.f4986AlLFFp;
                if (str == null) {
                    str = "错误";
                }
                azoqyo2.f28ASJ6gh = str;
                a4TApA2.AzWtSf("确定", new DRlcZ9.ASJ6gh(12, this));
                a4TApA2.ASJ6gh();
                a4TApA2.AMqCpz();
                return;
        }
    }

    public /* synthetic */ A2egSU(Object obj, Object obj2, int i, boolean z) {
        this.f4985AcNBzu = i;
        this.f4986AlLFFp = obj;
        this.f4987AmA8tU = obj2;
    }

    public A2egSU(SwipeDismissBehavior swipeDismissBehavior, View view, boolean z) {
        this.f4985AcNBzu = 17;
        this.f4987AmA8tU = swipeDismissBehavior;
        this.f4986AlLFFp = view;
    }
}
