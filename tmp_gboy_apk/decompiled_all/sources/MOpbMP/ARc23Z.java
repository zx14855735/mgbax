package MOpbMP;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.game.boy.MyApp;
import com.game.boy.activity.SaveSlotsActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ARc23Z extends AZOQYO {

    /* renamed from: AzWtSf, reason: collision with root package name */
    public MaterialButton f4996AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public MaterialButton f4997B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public MaterialButton f4998B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public MaterialButton f4999B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public TextInputEditText f5000B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public TextInputEditText f5001B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public TextInputEditText f5002B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public TextInputEditText f5003BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public TextInputEditText f5004BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public TextInputLayout f5005BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public View f5006BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public View f5007BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public View f5008BPw6Q8;

    /* renamed from: BTvldC, reason: collision with root package name */
    public I3HV03.A4TApA f5009BTvldC;

    /* renamed from: BV3sI0, reason: collision with root package name */
    public LlW7FF.ASJ6gh f5010BV3sI0;

    /* renamed from: BmvVmW, reason: collision with root package name */
    public Handler f5011BmvVmW;

    /* renamed from: BniPrB, reason: collision with root package name */
    public long f5012BniPrB = 0;
    public boolean BpkvW3 = false;

    /* renamed from: C2rE4F, reason: collision with root package name */
    public boolean f5013C2rE4F = false;

    /* renamed from: C4FrIb, reason: collision with root package name */
    public ADYaiT f5014C4FrIb;

    public static void AlLFFp(I3HV03.A4TApA a4TApA) {
        if (a4TApA == null) {
            return;
        }
        a4TApA.BNL6CD("user_data");
        a4TApA.BNL6CD("user_token");
        a4TApA.BNL6CD("user_name");
        a4TApA.BNL6CD("user_avatar");
        a4TApA.BNL6CD("user_group");
        a4TApA.BNL6CD("user_email");
        a4TApA.BNL6CD("user_id");
        a4TApA.BI9f7h("is_logged_in", false);
    }

    public static String B25kr6(TextInputEditText textInputEditText) {
        return (textInputEditText == null || textInputEditText.getText() == null) ? "" : textInputEditText.getText().toString().trim();
    }

    public static void B2KMhB(MTKlkd.AZkASS aZkASS, I3HV03.A4TApA a4TApA) {
        if (a4TApA == null) {
            return;
        }
        if (!aZkASS.AYUAbz()) {
            AlLFFp(a4TApA);
            return;
        }
        a4TApA.BJ7GGh("user_token", aZkASS.ARc23Z());
        a4TApA.BJ7GGh("user_name", aZkASS.ASJ6gh());
        a4TApA.BJ7GGh("user_avatar", aZkASS.A2egSU());
        a4TApA.BJ7GGh("user_email", aZkASS.A5SV6n());
        a4TApA.BJ7GGh("user_group", aZkASS.ADYaiT());
        a4TApA.BI9f7h("is_logged_in", true);
        ((SharedPreferences.Editor) a4TApA.f3809AmA8tU).putLong("login_time", System.currentTimeMillis()).apply();
    }

    @Override // MOpbMP.AZOQYO
    public final int AcNBzu() {
        return 2131493199;
    }

    public final void AmA8tU() {
        MaterialButton materialButton = this.f4999B3GDIM;
        if (materialButton != null) {
            materialButton.setEnabled(true);
            this.f4999B3GDIM.setText("获取验证码");
        }
        this.BpkvW3 = false;
        this.f5012BniPrB = 0L;
    }

    public final void AzWtSf(Runnable runnable) {
        A2egSU a2egSU = new A2egSU(this, 5, runnable);
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            new Handler(Looper.getMainLooper()).post(a2egSU);
        } else {
            activity.runOnUiThread(a2egSU);
        }
    }

    public final void B3GDIM(boolean z) {
        ADYaiT aDYaiT;
        if (this.f5011BmvVmW == null) {
            return;
        }
        if (z) {
            this.f5012BniPrB = System.currentTimeMillis() + 300000;
        } else if (this.f5012BniPrB <= System.currentTimeMillis()) {
            AmA8tU();
            return;
        }
        Handler handler = this.f5011BmvVmW;
        if (handler != null && (aDYaiT = this.f5014C4FrIb) != null) {
            handler.removeCallbacks(aDYaiT);
        }
        this.f5014C4FrIb = null;
        this.BpkvW3 = true;
        AzWtSf(new ADYaiT(this, 0));
        ADYaiT aDYaiT2 = new ADYaiT(this, 1);
        this.f5014C4FrIb = aDYaiT2;
        this.f5011BmvVmW.postDelayed(aDYaiT2, 500L);
    }

    @Override // MOpbMP.AZOQYO, androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f5009BTvldC = new I3HV03.A4TApA(activity, (String) null);
        } else {
            this.f5009BTvldC = new I3HV03.A4TApA(MyApp.f10877AcNBzu, (String) null);
        }
        this.f5010BV3sI0 = MyApp.f10880AzWtSf;
        this.f5011BmvVmW = new Handler(Looper.getMainLooper());
        if (bundle != null) {
            this.f5012BniPrB = bundle.getLong("timer_end_time", 0L);
        }
    }

    @Override // androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        ADYaiT aDYaiT;
        super.onDestroyView();
        this.f5013C2rE4F = false;
        Handler handler = this.f5011BmvVmW;
        if (handler != null && (aDYaiT = this.f5014C4FrIb) != null) {
            handler.removeCallbacks(aDYaiT);
        }
        this.f5014C4FrIb = null;
        this.BpkvW3 = false;
        Handler handler2 = this.f5011BmvVmW;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
        this.f4996AzWtSf = null;
        this.f4997B25kr6 = null;
        this.f4998B2KMhB = null;
        this.f4999B3GDIM = null;
        this.f5000B4ZgIw = null;
        this.f5001B7CMnp = null;
        this.f5002B9tovu = null;
        this.f5003BChYOn = null;
        this.f5004BI9f7h = null;
        this.f5005BIYEnU = null;
        this.f5006BJ7GGh = null;
        this.f5007BNL6CD = null;
        this.f5008BPw6Q8 = null;
    }

    @Override // androidx.fragment.app.B4ZgIw, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.f5013C2rE4F = false;
        FragmentActivity activity = getActivity();
        if (!(activity instanceof SaveSlotsActivity) || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        activity.finish();
    }

    @Override // androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putLong("timer_end_time", this.f5012BniPrB);
    }

    @Override // MOpbMP.AZOQYO, androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f5013C2rE4F = true;
        if (getView() == null || this.BpkvW3 || this.f5012BniPrB <= System.currentTimeMillis()) {
            return;
        }
        B3GDIM(false);
    }

    @Override // androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f5013C2rE4F = false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f5013C2rE4F = true;
        this.f4996AzWtSf = (MaterialButton) view.findViewById(2131296449);
        this.f4997B25kr6 = (MaterialButton) view.findViewById(2131296442);
        this.f4998B2KMhB = (MaterialButton) view.findViewById(2131296450);
        this.f4999B3GDIM = (MaterialButton) view.findViewById(2131296436);
        this.f5000B4ZgIw = (TextInputEditText) view.findViewById(2131296642);
        this.f5001B7CMnp = (TextInputEditText) view.findViewById(2131296641);
        this.f5002B9tovu = (TextInputEditText) view.findViewById(2131296637);
        this.f5004BI9f7h = (TextInputEditText) view.findViewById(2131296638);
        this.f5003BChYOn = (TextInputEditText) view.findViewById(2131296639);
        this.f5005BIYEnU = (TextInputLayout) view.findViewById(2131297544);
        this.f5006BJ7GGh = view.findViewById(2131297525);
        this.f5007BNL6CD = view.findViewById(2131297529);
        this.f5008BPw6Q8 = view.findViewById(2131297530);
        MaterialButton materialButton = this.f4997B25kr6;
        if (materialButton != null) {
            materialButton.setOnClickListener(new AMqCpz(this, 0));
        }
        MaterialButton materialButton2 = this.f4998B2KMhB;
        if (materialButton2 != null) {
            materialButton2.setOnClickListener(new AMqCpz(this, 1));
        }
        MaterialButton materialButton3 = this.f4996AzWtSf;
        if (materialButton3 != null) {
            materialButton3.setOnClickListener(new AMqCpz(this, 2));
        }
        MaterialButton materialButton4 = this.f4999B3GDIM;
        if (materialButton4 != null) {
            materialButton4.setOnClickListener(new AMqCpz(this, 3));
        }
        AzWtSf(new ADYaiT(this, 2));
        if (this.f5012BniPrB > System.currentTimeMillis()) {
            B3GDIM(false);
        } else {
            this.f5012BniPrB = 0L;
            this.BpkvW3 = false;
        }
    }
}
