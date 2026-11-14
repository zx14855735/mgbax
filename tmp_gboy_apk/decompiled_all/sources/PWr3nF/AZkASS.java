package PWr3nF;

import COJEAR.Ddcejp;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZkASS extends AzWtSf {
    public final int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final int f7309ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public final TimeInterpolator f7310ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public AutoCompleteTextView f7311AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public final Dphsd2.A2egSU f7312AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public final A2egSU f7313AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final AZOQYO f7314AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f7315AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public boolean f7316AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public boolean f7317AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public long f7318AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public AccessibilityManager f7319B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public ValueAnimator f7320B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public ValueAnimator f7321B3GDIM;

    /* JADX WARN: Type inference failed for: r0v2, types: [PWr3nF.AZOQYO] */
    public AZkASS(AmA8tU amA8tU) {
        super(amA8tU);
        this.f7312AZOQYO = new Dphsd2.A2egSU(6, this);
        this.f7313AZkASS = new A2egSU(this, 1);
        this.f7314AaHO0E = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: PWr3nF.AZOQYO
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                AZkASS aZkASS = AZkASS.this;
                AutoCompleteTextView autoCompleteTextView = aZkASS.f7311AYUAbz;
                if (autoCompleteTextView == null || com.bumptech.glide.AMqCpz.CASmeH(autoCompleteTextView)) {
                    return;
                }
                aZkASS.f7352ADYaiT.setImportantForAccessibility(z ? 2 : 1);
            }
        };
        this.f7318AzWtSf = Long.MAX_VALUE;
        this.f7309ARc23Z = com.bumptech.glide.A5SV6n.D07BeM(amA8tU.getContext(), 2130969626, 67);
        this.AMqCpz = com.bumptech.glide.A5SV6n.D07BeM(amA8tU.getContext(), 2130969626, 50);
        this.f7310ASJ6gh = com.bumptech.glide.A5SV6n.D6DOie(amA8tU.getContext(), 2130969635, NdEzCJ.A2egSU.f6036A2egSU);
    }

    @Override // PWr3nF.AzWtSf
    public final void A2egSU() {
        if (this.f7319B25kr6.isTouchExplorationEnabled() && com.bumptech.glide.AMqCpz.CASmeH(this.f7311AYUAbz) && !this.f7352ADYaiT.hasFocus()) {
            this.f7311AYUAbz.dismissDropDown();
        }
        this.f7311AYUAbz.post(new CtFAbx.A2egSU(11, this));
    }

    @Override // PWr3nF.AzWtSf
    public final int A5SV6n() {
        return 2131886300;
    }

    @Override // PWr3nF.AzWtSf
    public final int ADYaiT() {
        return 2131231371;
    }

    @Override // PWr3nF.AzWtSf
    public final View.OnFocusChangeListener AMqCpz() {
        return this.f7313AZkASS;
    }

    @Override // PWr3nF.AzWtSf
    public final View.OnClickListener ARc23Z() {
        return this.f7312AZOQYO;
    }

    @Override // PWr3nF.AzWtSf
    public final AccessibilityManager.TouchExplorationStateChangeListener AYUAbz() {
        return this.f7314AaHO0E;
    }

    @Override // PWr3nF.AzWtSf
    public final boolean AZOQYO(int i) {
        return i != 0;
    }

    @Override // PWr3nF.AzWtSf
    public final boolean AZkASS() {
        return this.f7315AcNBzu;
    }

    @Override // PWr3nF.AzWtSf
    public final boolean AcNBzu() {
        return this.f7317AmA8tU;
    }

    @Override // PWr3nF.AzWtSf
    public final void AlLFFp(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.f7311AYUAbz = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new FdMWEC.AMqCpz(2, this));
        this.f7311AYUAbz.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: PWr3nF.AYUAbz
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                AZkASS aZkASS = AZkASS.this;
                aZkASS.f7316AlLFFp = true;
                aZkASS.f7318AzWtSf = SystemClock.uptimeMillis();
                aZkASS.B7CMnp(false);
            }
        });
        this.f7311AYUAbz.setThreshold(0);
        TextInputLayout textInputLayout = this.f7349A2egSU;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (!com.bumptech.glide.AMqCpz.CASmeH(editText) && this.f7319B25kr6.isTouchExplorationEnabled()) {
            this.f7352ADYaiT.setImportantForAccessibility(2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // PWr3nF.AzWtSf
    public final void AmA8tU(CQhlFr.AYUAbz aYUAbz) {
        if (!com.bumptech.glide.AMqCpz.CASmeH(this.f7311AYUAbz)) {
            aYUAbz.AZkASS(Spinner.class.getName());
        }
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = aYUAbz.f1773A2egSU;
        if (i >= 26 ? accessibilityNodeInfo.isShowingHintText() : aYUAbz.AMqCpz(4)) {
            if (i >= 26) {
                accessibilityNodeInfo.setHintText(null);
            } else {
                accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", null);
            }
        }
    }

    @Override // PWr3nF.AzWtSf
    public final void AzWtSf(AccessibilityEvent accessibilityEvent) {
        if (!this.f7319B25kr6.isEnabled() || com.bumptech.glide.AMqCpz.CASmeH(this.f7311AYUAbz)) {
            return;
        }
        boolean z = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f7317AmA8tU && !this.f7311AYUAbz.isPopupShowing();
        if (accessibilityEvent.getEventType() == 1 || z) {
            B9tovu();
            this.f7316AlLFFp = true;
            this.f7318AzWtSf = SystemClock.uptimeMillis();
        }
    }

    @Override // PWr3nF.AzWtSf
    public final void B3GDIM() {
        int i = 11;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f7310ASJ6gh;
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.setDuration(this.f7309ARc23Z);
        ofFloat.addUpdateListener(new Ddcejp(i, this));
        this.f7321B3GDIM = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration(this.AMqCpz);
        ofFloat2.addUpdateListener(new Ddcejp(i, this));
        this.f7320B2KMhB = ofFloat2;
        ofFloat2.addListener(new AaHO0E.A5SV6n(14, this));
        this.f7319B25kr6 = (AccessibilityManager) this.f7351A5SV6n.getSystemService("accessibility");
    }

    @Override // PWr3nF.AzWtSf
    public final void B4ZgIw() {
        AutoCompleteTextView autoCompleteTextView = this.f7311AYUAbz;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.f7311AYUAbz.setOnDismissListener(null);
        }
    }

    public final void B7CMnp(boolean z) {
        if (this.f7317AmA8tU != z) {
            this.f7317AmA8tU = z;
            this.f7321B3GDIM.cancel();
            this.f7320B2KMhB.start();
        }
    }

    public final void B9tovu() {
        if (this.f7311AYUAbz == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.f7318AzWtSf;
        if (uptimeMillis < 0 || uptimeMillis > 300) {
            this.f7316AlLFFp = false;
        }
        if (this.f7316AlLFFp) {
            this.f7316AlLFFp = false;
            return;
        }
        B7CMnp(!this.f7317AmA8tU);
        if (!this.f7317AmA8tU) {
            this.f7311AYUAbz.dismissDropDown();
        } else {
            this.f7311AYUAbz.requestFocus();
            this.f7311AYUAbz.showDropDown();
        }
    }
}
