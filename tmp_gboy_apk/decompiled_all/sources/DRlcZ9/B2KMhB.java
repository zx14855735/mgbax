package DRlcZ9;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.preference.DialogPreference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class B2KMhB extends androidx.fragment.app.B4ZgIw implements DialogInterface.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public DialogPreference f2092AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public CharSequence f2093AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public CharSequence f2094AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public CharSequence f2095AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public CharSequence f2096B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int f2097B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public BitmapDrawable f2098B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public int f2099B4ZgIw;

    public final DialogPreference AcNBzu() {
        if (this.f2092AcNBzu == null) {
            this.f2092AcNBzu = (DialogPreference) ((B4ZgIw) ((A4TApA) getTargetFragment())).AZkASS(requireArguments().getString("key"));
        }
        return this.f2092AcNBzu;
    }

    public void AlLFFp(View view) {
        int i;
        View findViewById = view.findViewById(R.id.message);
        if (findViewById != null) {
            CharSequence charSequence = this.f2096B25kr6;
            if (TextUtils.isEmpty(charSequence)) {
                i = 8;
            } else {
                if (findViewById instanceof TextView) {
                    ((TextView) findViewById).setText(charSequence);
                }
                i = 0;
            }
            if (findViewById.getVisibility() != i) {
                findViewById.setVisibility(i);
            }
        }
    }

    public abstract void AmA8tU(boolean z);

    public void AzWtSf(ADYaiT.AlLFFp alLFFp) {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f2099B4ZgIw = i;
    }

    @Override // androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        DV2E8K.ARc23Z targetFragment = getTargetFragment();
        if (!(targetFragment instanceof A4TApA)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        A4TApA a4TApA = (A4TApA) targetFragment;
        String string = requireArguments().getString("key");
        if (bundle != null) {
            this.f2093AlLFFp = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.f2094AmA8tU = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.f2095AzWtSf = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.f2096B25kr6 = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.f2097B2KMhB = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.f2098B3GDIM = new BitmapDrawable(getResources(), bitmap);
                return;
            }
            return;
        }
        DialogPreference dialogPreference = (DialogPreference) ((B4ZgIw) a4TApA).AZkASS(string);
        this.f2092AcNBzu = dialogPreference;
        this.f2093AlLFFp = dialogPreference.f9060D6yqiO;
        this.f2094AmA8tU = dialogPreference.f9063D9tr6l;
        this.f2095AzWtSf = dialogPreference.f9064DAk1zC;
        this.f2096B25kr6 = dialogPreference.f9061D8MqeW;
        this.f2097B2KMhB = dialogPreference.f9065DG07BK;
        Drawable drawable = dialogPreference.f9062D8cQ8b;
        if (drawable == null || (drawable instanceof BitmapDrawable)) {
            this.f2098B3GDIM = (BitmapDrawable) drawable;
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        this.f2098B3GDIM = new BitmapDrawable(getResources(), createBitmap);
    }

    @Override // androidx.fragment.app.B4ZgIw
    public Dialog onCreateDialog(Bundle bundle) {
        this.f2099B4ZgIw = -2;
        ADYaiT.AlLFFp alLFFp = new ADYaiT.AlLFFp(requireContext());
        CharSequence charSequence = this.f2093AlLFFp;
        ADYaiT.AZOQYO azoqyo = alLFFp.f81AcNBzu;
        azoqyo.AMqCpz = charSequence;
        azoqyo.f26ADYaiT = this.f2098B3GDIM;
        alLFFp.A5SV6n(this.f2094AmA8tU, this);
        azoqyo.f31AZkASS = this.f2095AzWtSf;
        azoqyo.f32AaHO0E = this;
        requireContext();
        int i = this.f2097B2KMhB;
        View inflate = i != 0 ? getLayoutInflater().inflate(i, (ViewGroup) null) : null;
        if (inflate != null) {
            AlLFFp(inflate);
            azoqyo.f41B7CMnp = inflate;
        } else {
            azoqyo.f28ASJ6gh = this.f2096B25kr6;
        }
        AzWtSf(alLFFp);
        ADYaiT.AmA8tU A2egSU2 = alLFFp.A2egSU();
        if (this instanceof ADYaiT) {
            Window window = A2egSU2.getWindow();
            if (Build.VERSION.SDK_INT >= 30) {
                B25kr6.A2egSU(window);
                return A2egSU2;
            }
            ADYaiT aDYaiT = (ADYaiT) this;
            aDYaiT.f2076BI9f7h = SystemClock.currentThreadTimeMillis();
            aDYaiT.B25kr6();
        }
        return A2egSU2;
    }

    @Override // androidx.fragment.app.B4ZgIw, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        AmA8tU(this.f2099B4ZgIw == -1);
    }

    @Override // androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f2093AlLFFp);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f2094AmA8tU);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f2095AzWtSf);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.f2096B25kr6);
        bundle.putInt("PreferenceDialogFragment.layout", this.f2097B2KMhB);
        BitmapDrawable bitmapDrawable = this.f2098B3GDIM;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }
}
