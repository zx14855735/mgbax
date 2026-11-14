package LQ734U;

import android.content.SharedPreferences;
import android.hardware.SensorManager;
import android.view.Display;
import android.view.WindowManager;
import com.game.boy.activity.EmulatorActivity;
import com.sigmob.sdk.base.views.r;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz extends A2egSU {

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public static final float[] f4831B4ZgIw = {30.0f, 20.0f, 15.0f, 10.0f, 8.0f, 6.0f, 5.0f, 3.0f, 2.0f, 1.0f};

    /* renamed from: B7CMnp, reason: collision with root package name */
    public static final int[] f4832B7CMnp = {32, 16, 64, r.b.d};

    /* renamed from: B9tovu, reason: collision with root package name */
    public static final int[] f4833B9tovu = {32, 16, 0, 0};

    /* renamed from: BChYOn, reason: collision with root package name */
    public static final int[] f4834BChYOn = {512, 256, 0, 0};

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Display f4835AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final SensorManager f4836AzWtSf;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public int[] f4838B2KMhB;

    /* renamed from: B25kr6, reason: collision with root package name */
    public float f4837B25kr6 = f4831B4ZgIw[7];

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final ADYaiT f4839B3GDIM = new ADYaiT(this);

    public AMqCpz(EmulatorActivity emulatorActivity) {
        this.f4836AzWtSf = (SensorManager) emulatorActivity.getSystemService("sensor");
        this.f4835AmA8tU = ((WindowManager) emulatorActivity.getSystemService("window")).getDefaultDisplay();
    }

    @Override // LQ734U.A2egSU
    public final void A4TApA(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString("useSensor", null);
        this.f4838B2KMhB = "left_right".equals(string) ? f4833B9tovu : "tl_tr".equals(string) ? f4834BChYOn : f4832B7CMnp;
        int i = sharedPreferences.getInt("sensorSensitivity", 5);
        if (i < 0) {
            i = 0;
        }
        if (i >= 10) {
            i = 9;
        }
        this.f4837B25kr6 = f4831B4ZgIw[i];
    }

    @Override // LQ734U.A2egSU
    public final void ADYaiT() {
        SensorManager sensorManager = this.f4836AzWtSf;
        sensorManager.registerListener(this.f4839B3GDIM, sensorManager.getDefaultSensor(3), 1);
    }

    @Override // LQ734U.A2egSU
    public final void AMqCpz() {
        this.f4836AzWtSf.unregisterListener(this.f4839B3GDIM);
    }
}
