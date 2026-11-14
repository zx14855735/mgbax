package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.ComponentActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class FragmentActivity extends ComponentActivity implements androidx.core.app.AMqCpz, androidx.core.app.ARc23Z {
    static final String LIFECYCLE_TAG = "android:support:lifecycle";
    boolean mCreated;
    boolean mResumed;
    final COJEAR mFragments = new COJEAR(new C2rE4F(this));
    final androidx.lifecycle.BI9f7h mFragmentLifecycleRegistry = new androidx.lifecycle.BI9f7h(this);
    boolean mStopped = true;

    public FragmentActivity() {
        getSavedStateRegistry().A5SV6n(LIFECYCLE_TAG, new BmvVmW(0, this));
        final int i = 0;
        addOnConfigurationChangedListener(new CNPG0E.A2egSU(this) { // from class: androidx.fragment.app.BniPrB

            /* renamed from: A4TApA, reason: collision with root package name */
            public final /* synthetic */ FragmentActivity f8800A4TApA;

            {
                this.f8800A4TApA = this;
            }

            @Override // CNPG0E.A2egSU
            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        this.f8800A4TApA.mFragments.A2egSU();
                        break;
                    default:
                        this.f8800A4TApA.mFragments.A2egSU();
                        break;
                }
            }
        });
        final int i2 = 1;
        addOnNewIntentListener(new CNPG0E.A2egSU(this) { // from class: androidx.fragment.app.BniPrB

            /* renamed from: A4TApA, reason: collision with root package name */
            public final /* synthetic */ FragmentActivity f8800A4TApA;

            {
                this.f8800A4TApA = this;
            }

            @Override // CNPG0E.A2egSU
            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        this.f8800A4TApA.mFragments.A2egSU();
                        break;
                    default:
                        this.f8800A4TApA.mFragments.A2egSU();
                        break;
                }
            }
        });
        addOnContextAvailableListener(new A2egSU.A4TApA() { // from class: androidx.fragment.app.BpkvW3
            @Override // A2egSU.A4TApA
            public final void A2egSU(ComponentActivity componentActivity) {
                C2rE4F c2rE4F = FragmentActivity.this.mFragments.f8810A2egSU;
                c2rE4F.f8814AzWtSf.A4TApA(c2rE4F, c2rE4F, null);
            }
        });
    }

    public static boolean ADYaiT(CtxOCS ctxOCS) {
        boolean z = false;
        for (Fragment fragment : ctxOCS.f8831A5SV6n.ARc23Z()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    z |= ADYaiT(fragment.getChildFragmentManager());
                }
                DuwtYk duwtYk = fragment.mViewLifecycleOwner;
                androidx.lifecycle.AmA8tU amA8tU = androidx.lifecycle.AmA8tU.f8980AzWtSf;
                if (duwtYk != null) {
                    duwtYk.A4TApA();
                    if (duwtYk.f8948B25kr6.f8988A5SV6n.compareTo(amA8tU) >= 0) {
                        fragment.mViewLifecycleOwner.f8948B25kr6.AYUAbz();
                        z = true;
                    }
                }
                if (fragment.mLifecycleRegistry.f8988A5SV6n.compareTo(amA8tU) >= 0) {
                    fragment.mLifecycleRegistry.AYUAbz();
                    z = true;
                }
            }
        }
        return z;
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.f8810A2egSU.f8814AzWtSf.f8833ARc23Z.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (shouldDumpInternalState(strArr)) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            String str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print(" mResumed=");
            printWriter.print(this.mResumed);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            if (getApplication() != null) {
                DAk1zC.A2egSU.A2egSU(this).A4TApA(str2, printWriter);
            }
            this.mFragments.f8810A2egSU.f8814AzWtSf.B9tovu(str, fileDescriptor, printWriter, strArr);
        }
    }

    public CtxOCS getSupportFragmentManager() {
        return this.mFragments.f8810A2egSU.f8814AzWtSf;
    }

    @Deprecated
    public DAk1zC.A2egSU getSupportLoaderManager() {
        return DAk1zC.A2egSU.A2egSU(this);
    }

    public void markFragmentsCreated() {
        while (ADYaiT(getSupportFragmentManager())) {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.A2egSU();
        super.onActivityResult(i, i2, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.AmA8tU, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.ARc23Z(androidx.lifecycle.AlLFFp.ON_CREATE);
        D8MqeW d8MqeW = this.mFragments.f8810A2egSU.f8814AzWtSf;
        d8MqeW.f8858BniPrB = false;
        d8MqeW.BpkvW3 = false;
        d8MqeW.f8864CQhlFr.f8885AZOQYO = false;
        d8MqeW.B7CMnp(1);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f8810A2egSU.f8814AzWtSf.AaHO0E();
        this.mFragmentLifecycleRegistry.ARc23Z(androidx.lifecycle.AlLFFp.ON_DESTROY);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 6) {
            return this.mFragments.f8810A2egSU.f8814AzWtSf.AZOQYO(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.f8810A2egSU.f8814AzWtSf.B7CMnp(5);
        this.mFragmentLifecycleRegistry.ARc23Z(androidx.lifecycle.AlLFFp.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.A2egSU();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.A2egSU();
        super.onResume();
        this.mResumed = true;
        this.mFragments.f8810A2egSU.f8814AzWtSf.BIYEnU(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.ARc23Z(androidx.lifecycle.AlLFFp.ON_RESUME);
        D8MqeW d8MqeW = this.mFragments.f8810A2egSU.f8814AzWtSf;
        d8MqeW.f8858BniPrB = false;
        d8MqeW.BpkvW3 = false;
        d8MqeW.f8864CQhlFr.f8885AZOQYO = false;
        d8MqeW.B7CMnp(7);
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.A2egSU();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            D8MqeW d8MqeW = this.mFragments.f8810A2egSU.f8814AzWtSf;
            d8MqeW.f8858BniPrB = false;
            d8MqeW.BpkvW3 = false;
            d8MqeW.f8864CQhlFr.f8885AZOQYO = false;
            d8MqeW.B7CMnp(4);
        }
        this.mFragments.f8810A2egSU.f8814AzWtSf.BIYEnU(true);
        this.mFragmentLifecycleRegistry.ARc23Z(androidx.lifecycle.AlLFFp.ON_START);
        D8MqeW d8MqeW2 = this.mFragments.f8810A2egSU.f8814AzWtSf;
        d8MqeW2.f8858BniPrB = false;
        d8MqeW2.BpkvW3 = false;
        d8MqeW2.f8864CQhlFr.f8885AZOQYO = false;
        d8MqeW2.B7CMnp(5);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.A2egSU();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        D8MqeW d8MqeW = this.mFragments.f8810A2egSU.f8814AzWtSf;
        d8MqeW.BpkvW3 = true;
        d8MqeW.f8864CQhlFr.f8885AZOQYO = true;
        d8MqeW.B7CMnp(4);
        this.mFragmentLifecycleRegistry.ARc23Z(androidx.lifecycle.AlLFFp.ON_STOP);
    }

    public void setEnterSharedElementCallback(androidx.core.app.D07BeM d07BeM) {
        androidx.core.app.A2egSU.A5SV6n(this, d07BeM != null ? new androidx.core.app.ASJ6gh(d07BeM) : null);
    }

    public void setExitSharedElementCallback(androidx.core.app.D07BeM d07BeM) {
        androidx.core.app.A2egSU.ADYaiT(this, d07BeM != null ? new androidx.core.app.ASJ6gh(d07BeM) : null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (i == -1) {
            startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        androidx.core.app.A2egSU.A2egSU(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateMenu();
    }

    public void supportPostponeEnterTransition() {
        androidx.core.app.A2egSU.A4TApA(this);
    }

    public void supportStartPostponedEnterTransition() {
        androidx.core.app.A2egSU.AMqCpz(this);
    }

    @Override // androidx.core.app.ARc23Z
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i) {
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            androidx.core.app.AYUAbz.startActivityForResult(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i, bundle);
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }
}
