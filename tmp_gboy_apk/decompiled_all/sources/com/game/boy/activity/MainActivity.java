package com.game.boy.activity;

import ADYaiT.D8MqeW;
import MOpbMP.CmUvjW;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.fragment.app.CtxOCS;
import androidx.fragment.app.Fragment;
import com.game.boy.MyApp;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigationrail.NavigationRailView;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class MainActivity extends A5SV6n {

    /* renamed from: B9tovu, reason: collision with root package name */
    public static final /* synthetic */ int f11062B9tovu = 0;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public BottomNavigationView f11064B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public NavigationRailView f11065B3GDIM;

    /* renamed from: B25kr6, reason: collision with root package name */
    public String f11063B25kr6 = "home";

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final MOpbMP.BmvVmW f11066B4ZgIw = new MOpbMP.BmvVmW(this);

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f11067B7CMnp = true;

    public final OpB85q.B2KMhB AYUAbz() {
        if (getResources().getConfiguration().orientation == 2) {
            NavigationRailView navigationRailView = this.f11065B3GDIM;
            if (navigationRailView != null) {
                return navigationRailView;
            }
            return null;
        }
        BottomNavigationView bottomNavigationView = this.f11064B2KMhB;
        if (bottomNavigationView != null) {
            return bottomNavigationView;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x0042, code lost:
    
        if (r2 == 0) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AZOQYO(android.content.Intent r10) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.game.boy.activity.MainActivity.AZOQYO(android.content.Intent):void");
    }

    public final void AZkASS(Uri uri) {
        I3HV03.A4TApA a4TApA = new I3HV03.A4TApA(this, uri, 23, false);
        AtomicBoolean atomicBoolean = LCJm5h.ARc23Z.f4432ADYaiT;
        if (atomicBoolean.get()) {
            LCJm5h.ARc23Z.f4430A4TApA.post(new D8MqeW(27, a4TApA));
            return;
        }
        atomicBoolean.set(true);
        LCJm5h.ARc23Z.f4429A2egSU.execute(new C4FrIb.B4ZgIw(this, uri, a4TApA, 5));
    }

    public final void AaHO0E(String str) {
        if (this.f11063B25kr6.equals(str)) {
            return;
        }
        CtxOCS supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.getClass();
        androidx.fragment.app.A2egSU a2egSU = new androidx.fragment.app.A2egSU(supportFragmentManager);
        Fragment BTvldC2 = supportFragmentManager.BTvldC(this.f11063B25kr6);
        Fragment BTvldC3 = supportFragmentManager.BTvldC(str);
        if (BTvldC3 == null) {
            switch (str) {
                case "dashboard":
                    BTvldC3 = new MOpbMP.AmA8tU();
                    break;
                case "home":
                    BTvldC3 = new MOpbMP.BpkvW3();
                    break;
                case "notifications":
                    BTvldC3 = new CmUvjW();
                    break;
                default:
                    throw new IllegalArgumentException("Unknown fragment tag: ".concat(str));
            }
            a2egSU.AZOQYO(2131296695, BTvldC3, str, 1);
        }
        if (BTvldC2 != null) {
            a2egSU.AZkASS(BTvldC2);
        }
        a2egSU.AzWtSf(BTvldC3);
        a2egSU.B2KMhB(false);
        this.f11063B25kr6 = str;
    }

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public final void onCreate(Bundle bundle) {
        int i = 1;
        super.onCreate(bundle);
        setContentView(2131492899);
        if (!getSharedPreferences("privacy_prefs", 0).getBoolean("has_agreed_all", false)) {
            new AZkASS.ARc23Z(this).f451AlLFFp = new OLy1FW.AzWtSf(17, (byte) 0);
        }
        getOnBackPressedDispatcher().A2egSU(this, this.f11066B4ZgIw);
        MyApp myApp = MyApp.f10877AcNBzu;
        L2suez.B2KMhB.A2egSU(this, false, null);
        AZOQYO(getIntent());
        this.f11064B2KMhB = (BottomNavigationView) findViewById(2131296413);
        this.f11065B3GDIM = (NavigationRailView) findViewById(2131297700);
        BottomNavigationView bottomNavigationView = this.f11064B2KMhB;
        if (bottomNavigationView != null) {
            bottomNavigationView.setOnNavigationItemSelectedListener(new NGepWW.A2egSU(14, this));
            this.f11064B2KMhB.setOnNavigationItemReselectedListener(new OLy1FW.AzWtSf(18, (byte) 0));
        }
        NavigationRailView navigationRailView = this.f11065B3GDIM;
        if (navigationRailView != null) {
            navigationRailView.setOnItemSelectedListener(new CNPG0E(this));
            this.f11065B3GDIM.setOnItemReselectedListener(new OLy1FW.AzWtSf(19, (byte) 0));
            NavigationRailView navigationRailView2 = this.f11065B3GDIM;
            if (navigationRailView2 != null) {
                navigationRailView2.setOnKeyListener(new DRlcZ9.BniPrB(2, this));
            }
        }
        if (bundle != null) {
            this.f11063B25kr6 = bundle.getString("current_fragment", "home");
        }
        if (bundle == null) {
            CtxOCS supportFragmentManager = getSupportFragmentManager();
            supportFragmentManager.getClass();
            androidx.fragment.app.A2egSU a2egSU = new androidx.fragment.app.A2egSU(supportFragmentManager);
            a2egSU.AZOQYO(2131296695, new MOpbMP.BpkvW3(), "home", 1);
            MOpbMP.AmA8tU amA8tU = new MOpbMP.AmA8tU();
            CmUvjW cmUvjW = new CmUvjW();
            a2egSU.AZOQYO(2131296695, amA8tU, "dashboard", 1);
            a2egSU.AZkASS(amA8tU);
            a2egSU.AZOQYO(2131296695, cmUvjW, "notifications", 1);
            a2egSU.AZkASS(cmUvjW);
            a2egSU.B2KMhB(false);
        }
        if (LCJm5h.AYUAbz.f4437A2egSU == null) {
            synchronized (LCJm5h.AYUAbz.class) {
                try {
                    if (LCJm5h.AYUAbz.f4437A2egSU == null) {
                        LCJm5h.AYUAbz.f4437A2egSU = getApplicationContext();
                    }
                } finally {
                }
            }
        }
        if (LCJm5h.AYUAbz.f4440ADYaiT.get()) {
            return;
        }
        new Thread(new JrXYwF.A2egSU(i), "RomMd5Preload").start();
    }

    @Override // ADYaiT.B2KMhB, android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        NavigationRailView navigationRailView;
        if (i != 108 || (navigationRailView = this.f11065B3GDIM) == null) {
            return super.onKeyDown(i, keyEvent);
        }
        boolean z = this.f11067B7CMnp;
        this.f11067B7CMnp = !z;
        navigationRailView.setVisibility(!z ? 0 : 8);
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        AZOQYO(intent);
    }

    @Override // com.game.boy.activity.A5SV6n, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        WeakReference weakReference = EmulatorActivity.f10988DG07BK;
        EmulatorActivity emulatorActivity = weakReference != null ? (EmulatorActivity) weakReference.get() : null;
        if (emulatorActivity != null && !emulatorActivity.isFinishing() && !emulatorActivity.isDestroyed()) {
            Intent intent = new Intent(this, (Class<?>) EmulatorActivity.class);
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("gbalink://resume"));
            startActivity(intent);
            return;
        }
        String str = this.f11063B25kr6;
        str.getClass();
        int i = !str.equals("home") ? !str.equals("notifications") ? -1 : 2131297687 : 2131297686;
        if (i != -1) {
            BottomNavigationView bottomNavigationView = this.f11064B2KMhB;
            if (bottomNavigationView != null) {
                bottomNavigationView.setSelectedItemId(i);
            }
            NavigationRailView navigationRailView = this.f11065B3GDIM;
            if (navigationRailView != null) {
                navigationRailView.setSelectedItemId(i);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("current_fragment", this.f11063B25kr6);
    }
}
