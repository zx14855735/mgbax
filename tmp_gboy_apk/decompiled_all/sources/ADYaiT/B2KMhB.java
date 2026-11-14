package ADYaiT;

import AaHO0E.HIguqb;
import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class B2KMhB extends FragmentActivity implements B3GDIM, androidx.core.app.D6DOie {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private BJ7GGh mDelegate;
    private Resources mResources;

    public B2KMhB() {
        getSavedStateRegistry().A5SV6n(DELEGATE_TAG, new AzWtSf(this));
        addOnContextAvailableListener(new B25kr6(this));
    }

    public final void AMqCpz() {
        androidx.lifecycle.CQhlFr.ARc23Z(getWindow().getDecorView(), this);
        View decorView = getWindow().getDecorView();
        RXb0Sz.ARc23Z.AMqCpz(decorView, "<this>");
        decorView.setTag(2131298311, this);
        JrXYwF.A4TApA.CtFAbx(getWindow().getDecorView(), this);
        JrXYwF.A4TApA.CtxOCS(getWindow().getDecorView(), this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AMqCpz();
        CkXcdM ckXcdM = (CkXcdM) getDelegate();
        ckXcdM.BIYEnU();
        ((ViewGroup) ckXcdM.f172CQhlFr.findViewById(R.id.content)).addView(view, layoutParams);
        ckXcdM.f159BIYEnU.A2egSU(ckXcdM.f158BI9f7h.getCallback());
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        CkXcdM ckXcdM = (CkXcdM) getDelegate();
        ckXcdM.f186D6yqiO = true;
        int i9 = ckXcdM.f190DAk1zC;
        if (i9 == -100) {
            i9 = BJ7GGh.f98AlLFFp;
        }
        int BniPrB2 = ckXcdM.BniPrB(context, i9);
        if (BJ7GGh.A4TApA(context) && BJ7GGh.A4TApA(context)) {
            if (Build.VERSION.SDK_INT < 33) {
                synchronized (BJ7GGh.f105B7CMnp) {
                    try {
                        C2rE4F.AYUAbz aYUAbz = BJ7GGh.f99AmA8tU;
                        if (aYUAbz == null) {
                            if (BJ7GGh.f100AzWtSf == null) {
                                BJ7GGh.f100AzWtSf = C2rE4F.AYUAbz.A4TApA(androidx.core.app.AaHO0E.AMqCpz(context));
                            }
                            if (!BJ7GGh.f100AzWtSf.f1538A2egSU.isEmpty()) {
                                BJ7GGh.f99AmA8tU = BJ7GGh.f100AzWtSf;
                            }
                        } else if (!aYUAbz.equals(BJ7GGh.f100AzWtSf)) {
                            C2rE4F.AYUAbz aYUAbz2 = BJ7GGh.f99AmA8tU;
                            BJ7GGh.f100AzWtSf = aYUAbz2;
                            androidx.core.app.AaHO0E.ADYaiT(context, aYUAbz2.f1538A2egSU.A2egSU());
                        }
                    } finally {
                    }
                }
            } else if (!BJ7GGh.f102B2KMhB) {
                BJ7GGh.f97AcNBzu.execute(new B4ZgIw(context, 0));
            }
        }
        C2rE4F.AYUAbz B2KMhB2 = CkXcdM.B2KMhB(context);
        Configuration configuration = null;
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(CkXcdM.B9tovu(context, BniPrB2, B2KMhB2, null, false));
            } catch (IllegalStateException unused) {
            }
            super.attachBaseContext(context);
        }
        if (context instanceof AZOQYO.ADYaiT) {
            try {
                ((AZOQYO.ADYaiT) context).applyOverrideConfiguration(CkXcdM.B9tovu(context, BniPrB2, B2KMhB2, null, false));
            } catch (IllegalStateException unused2) {
            }
            super.attachBaseContext(context);
        }
        if (CkXcdM.f155ECyGFg) {
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (!configuration3.equals(configuration4)) {
                configuration = new Configuration();
                configuration.fontScale = 0.0f;
                if (configuration3.diff(configuration4) != 0) {
                    float f = configuration3.fontScale;
                    float f2 = configuration4.fontScale;
                    if (f != f2) {
                        configuration.fontScale = f2;
                    }
                    int i10 = configuration3.mcc;
                    int i11 = configuration4.mcc;
                    if (i10 != i11) {
                        configuration.mcc = i11;
                    }
                    int i12 = configuration3.mnc;
                    int i13 = configuration4.mnc;
                    if (i12 != i13) {
                        configuration.mnc = i13;
                    }
                    int i14 = Build.VERSION.SDK_INT;
                    if (i14 >= 24) {
                        C2rE4F.A2egSU(configuration3, configuration4, configuration);
                    } else if (!Objects.equals(configuration3.locale, configuration4.locale)) {
                        configuration.locale = configuration4.locale;
                    }
                    int i15 = configuration3.touchscreen;
                    int i16 = configuration4.touchscreen;
                    if (i15 != i16) {
                        configuration.touchscreen = i16;
                    }
                    int i17 = configuration3.keyboard;
                    int i18 = configuration4.keyboard;
                    if (i17 != i18) {
                        configuration.keyboard = i18;
                    }
                    int i19 = configuration3.keyboardHidden;
                    int i20 = configuration4.keyboardHidden;
                    if (i19 != i20) {
                        configuration.keyboardHidden = i20;
                    }
                    int i21 = configuration3.navigation;
                    int i22 = configuration4.navigation;
                    if (i21 != i22) {
                        configuration.navigation = i22;
                    }
                    int i23 = configuration3.navigationHidden;
                    int i24 = configuration4.navigationHidden;
                    if (i23 != i24) {
                        configuration.navigationHidden = i24;
                    }
                    int i25 = configuration3.orientation;
                    int i26 = configuration4.orientation;
                    if (i25 != i26) {
                        configuration.orientation = i26;
                    }
                    int i27 = configuration3.screenLayout & 15;
                    int i28 = configuration4.screenLayout & 15;
                    if (i27 != i28) {
                        configuration.screenLayout |= i28;
                    }
                    int i29 = configuration3.screenLayout & MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT;
                    int i30 = configuration4.screenLayout & MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT;
                    if (i29 != i30) {
                        configuration.screenLayout |= i30;
                    }
                    int i31 = configuration3.screenLayout & 48;
                    int i32 = configuration4.screenLayout & 48;
                    if (i31 != i32) {
                        configuration.screenLayout |= i32;
                    }
                    int i33 = configuration3.screenLayout & 768;
                    int i34 = configuration4.screenLayout & 768;
                    if (i33 != i34) {
                        configuration.screenLayout |= i34;
                    }
                    if (i14 >= 26) {
                        i = configuration3.colorMode;
                        int i35 = i & 3;
                        i2 = configuration4.colorMode;
                        if (i35 != (i2 & 3)) {
                            i7 = configuration.colorMode;
                            i8 = configuration4.colorMode;
                            configuration.colorMode = i7 | (i8 & 3);
                        }
                        i3 = configuration3.colorMode;
                        int i36 = i3 & 12;
                        i4 = configuration4.colorMode;
                        if (i36 != (i4 & 12)) {
                            i5 = configuration.colorMode;
                            i6 = configuration4.colorMode;
                            configuration.colorMode = i5 | (i6 & 12);
                        }
                    }
                    int i37 = configuration3.uiMode & 15;
                    int i38 = configuration4.uiMode & 15;
                    if (i37 != i38) {
                        configuration.uiMode |= i38;
                    }
                    int i39 = configuration3.uiMode & 48;
                    int i40 = configuration4.uiMode & 48;
                    if (i39 != i40) {
                        configuration.uiMode |= i40;
                    }
                    int i41 = configuration3.screenWidthDp;
                    int i42 = configuration4.screenWidthDp;
                    if (i41 != i42) {
                        configuration.screenWidthDp = i42;
                    }
                    int i43 = configuration3.screenHeightDp;
                    int i44 = configuration4.screenHeightDp;
                    if (i43 != i44) {
                        configuration.screenHeightDp = i44;
                    }
                    int i45 = configuration3.smallestScreenWidthDp;
                    int i46 = configuration4.smallestScreenWidthDp;
                    if (i45 != i46) {
                        configuration.smallestScreenWidthDp = i46;
                    }
                    int i47 = configuration3.densityDpi;
                    int i48 = configuration4.densityDpi;
                    if (i47 != i48) {
                        configuration.densityDpi = i48;
                    }
                }
            }
            Configuration B9tovu2 = CkXcdM.B9tovu(context, BniPrB2, B2KMhB2, configuration, true);
            AZOQYO.ADYaiT aDYaiT = new AZOQYO.ADYaiT(context, 2131952301);
            aDYaiT.applyOverrideConfiguration(B9tovu2);
            try {
                if (context.getTheme() != null) {
                    BTvldC.A4TApA.AYUAbz(aDYaiT.getTheme());
                }
            } catch (NullPointerException unused3) {
            }
            context = aDYaiT;
        }
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        A2egSU supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.A2egSU()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.core.app.AmA8tU, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        A2egSU supportActionBar = getSupportActionBar();
        if (keyCode == 82 && supportActionBar != null && supportActionBar.AZkASS(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public View findViewById(int i) {
        CkXcdM ckXcdM = (CkXcdM) getDelegate();
        ckXcdM.BIYEnU();
        return ckXcdM.f158BI9f7h.findViewById(i);
    }

    public BJ7GGh getDelegate() {
        if (this.mDelegate == null) {
            BI9f7h bI9f7h = BJ7GGh.f97AcNBzu;
            this.mDelegate = new CkXcdM(this, null, this, this);
        }
        return this.mDelegate;
    }

    public A4TApA getDrawerToggleDelegate() {
        ((CkXcdM) getDelegate()).getClass();
        return new BmvVmW(0);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        CkXcdM ckXcdM = (CkXcdM) getDelegate();
        if (ckXcdM.f162BPw6Q8 == null) {
            ckXcdM.BV3sI0();
            A2egSU a2egSU = ckXcdM.f161BNL6CD;
            ckXcdM.f162BPw6Q8 = new AZOQYO.AZkASS(a2egSU != null ? a2egSU.AMqCpz() : ckXcdM.f157BChYOn);
        }
        return ckXcdM.f162BPw6Q8;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = this.mResources;
        if (resources == null) {
            int i = HIguqb.f932A2egSU;
        }
        return resources == null ? super.getResources() : resources;
    }

    public A2egSU getSupportActionBar() {
        CkXcdM ckXcdM = (CkXcdM) getDelegate();
        ckXcdM.BV3sI0();
        return ckXcdM.f161BNL6CD;
    }

    @Override // androidx.core.app.D6DOie
    public Intent getSupportParentActivityIntent() {
        return androidx.core.app.AaHO0E.A2egSU(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().A2egSU();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        CkXcdM ckXcdM = (CkXcdM) getDelegate();
        if (ckXcdM.f177CikNvS && ckXcdM.f171COJEAR) {
            ckXcdM.BV3sI0();
            A2egSU a2egSU = ckXcdM.f161BNL6CD;
            if (a2egSU != null) {
                a2egSU.ASJ6gh();
            }
        }
        AaHO0E.BNL6CD A2egSU2 = AaHO0E.BNL6CD.A2egSU();
        Context context = ckXcdM.f157BChYOn;
        synchronized (A2egSU2) {
            A2egSU2.f663A2egSU.AcNBzu(context);
        }
        ckXcdM.f189D9tr6l = new Configuration(ckXcdM.f157BChYOn.getResources().getConfiguration());
        ckXcdM.AzWtSf(false, false);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(androidx.core.app.D6yqiO d6yqiO) {
        d6yqiO.getClass();
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = androidx.core.app.AaHO0E.A2egSU(this);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            B2KMhB b2KMhB = d6yqiO.f8566AlLFFp;
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(b2KMhB.getPackageManager());
            }
            ArrayList arrayList = d6yqiO.f8565AcNBzu;
            int size = arrayList.size();
            try {
                for (Intent A4TApA2 = androidx.core.app.AaHO0E.A4TApA(b2KMhB, component); A4TApA2 != null; A4TApA2 = androidx.core.app.AaHO0E.A4TApA(b2KMhB, A4TApA2.getComponent())) {
                    arrayList.add(size, A4TApA2);
                }
                arrayList.add(supportParentActivityIntent);
            } catch (PackageManager.NameNotFoundException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().ADYaiT();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    public void onLocalesChanged(C2rE4F.AYUAbz aYUAbz) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        A2egSU supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.ADYaiT() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    public void onNightModeChanged(int i) {
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((CkXcdM) getDelegate()).BIYEnU();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        CkXcdM ckXcdM = (CkXcdM) getDelegate();
        ckXcdM.BV3sI0();
        A2egSU a2egSU = ckXcdM.f161BNL6CD;
        if (a2egSU != null) {
            a2egSU.AzWtSf(true);
        }
    }

    public void onPrepareSupportNavigateUpTaskStack(androidx.core.app.D6yqiO d6yqiO) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        ((CkXcdM) getDelegate()).AzWtSf(true, false);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        CkXcdM ckXcdM = (CkXcdM) getDelegate();
        ckXcdM.BV3sI0();
        A2egSU a2egSU = ckXcdM.f161BNL6CD;
        if (a2egSU != null) {
            a2egSU.AzWtSf(false);
        }
    }

    @Override // ADYaiT.B3GDIM
    public void onSupportActionModeFinished(AZOQYO.A4TApA a4TApA) {
    }

    @Override // ADYaiT.B3GDIM
    public void onSupportActionModeStarted(AZOQYO.A4TApA a4TApA) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (!supportShouldUpRecreateTask(supportParentActivityIntent)) {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
        androidx.core.app.D6yqiO d6yqiO = new androidx.core.app.D6yqiO(this);
        onCreateSupportNavigateUpTaskStack(d6yqiO);
        onPrepareSupportNavigateUpTaskStack(d6yqiO);
        ArrayList arrayList = d6yqiO.f8565AcNBzu;
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        d6yqiO.f8566AlLFFp.startActivities(intentArr, null);
        try {
            finishAffinity();
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().AlLFFp(charSequence);
    }

    @Override // ADYaiT.B3GDIM
    public AZOQYO.A4TApA onWindowStartingSupportActionMode(AZOQYO.A2egSU a2egSU) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        A2egSU supportActionBar = getSupportActionBar();
        if (getWindow().hasFeature(0)) {
            if (supportActionBar == null || !supportActionBar.AaHO0E()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i) {
        AMqCpz();
        getDelegate().ASJ6gh(i);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        CkXcdM ckXcdM = (CkXcdM) getDelegate();
        if (ckXcdM.f156B9tovu instanceof Activity) {
            ckXcdM.BV3sI0();
            A2egSU a2egSU = ckXcdM.f161BNL6CD;
            if (a2egSU instanceof DXuj49) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            ckXcdM.f162BPw6Q8 = null;
            if (a2egSU != null) {
                a2egSU.AYUAbz();
            }
            ckXcdM.f161BNL6CD = null;
            if (toolbar != null) {
                Object obj = ckXcdM.f156B9tovu;
                DAk1zC dAk1zC = new DAk1zC(toolbar, obj instanceof Activity ? ((Activity) obj).getTitle() : ckXcdM.f163BTvldC, ckXcdM.f159BIYEnU);
                ckXcdM.f161BNL6CD = dAk1zC;
                ckXcdM.f159BIYEnU.f125AlLFFp = dAk1zC.f226A5SV6n;
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                ckXcdM.f159BIYEnU.f125AlLFFp = null;
            }
            ckXcdM.A2egSU();
        }
    }

    @Deprecated
    public void setSupportProgress(int i) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        ((CkXcdM) getDelegate()).f191DG07BK = i;
    }

    public AZOQYO.A4TApA startSupportActionMode(AZOQYO.A2egSU a2egSU) {
        return getDelegate().AmA8tU(a2egSU);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        getDelegate().A2egSU();
    }

    public void supportNavigateUpTo(Intent intent) {
        navigateUpTo(intent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().ARc23Z(i);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return shouldUpRecreateTask(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        AMqCpz();
        getDelegate().AYUAbz(view);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AMqCpz();
        getDelegate().AZOQYO(view, layoutParams);
    }
}
