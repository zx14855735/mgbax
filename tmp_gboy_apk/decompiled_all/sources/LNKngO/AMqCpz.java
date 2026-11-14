package LNKngO;

import KpHwm4.AZkASS;
import KpHwm4.AaHO0E;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.game.boy.emu.gba.Console;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz implements SensorEventListener, A2egSU, AZkASS {

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final int[] f4804B25kr6 = {232, 224, 219, 210, 200, 186, 170, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CLOCK_DIFF, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 104, 80};

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final float[] f4805B2KMhB = {300.0f, 1000.0f, 2000.0f, 5000.0f, 8000.0f, 12000.0f, 16000.0f, 20000.0f, 30000.0f, 50000.0f};

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AaHO0E f4806AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Console f4807AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final SensorManager f4808AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Sensor f4809AzWtSf;

    public AMqCpz(SensorManager sensorManager, AaHO0E aaHO0E) {
        this.f4808AmA8tU = sensorManager;
        this.f4809AzWtSf = sensorManager.getDefaultSensor(5);
        this.f4806AcNBzu = aaHO0E;
        aaHO0E.f4295A4TApA = this;
        this.f4807AlLFFp = aaHO0E.f4307AzWtSf.f11100A2egSU;
    }

    @Override // KpHwm4.AZkASS
    public final void a() {
        Sensor sensor = this.f4809AzWtSf;
        if (sensor != null) {
            this.f4808AmA8tU.registerListener(this, sensor, 3);
        }
    }

    @Override // KpHwm4.AZkASS
    public final void b() {
        this.f4808AmA8tU.unregisterListener(this);
    }

    @Override // LNKngO.A2egSU
    public final void c() {
        b();
        this.f4806AcNBzu.f4295A4TApA = null;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i = 0;
        float f = sensorEvent.values[0];
        int i2 = 9;
        int i3 = 0;
        while (true) {
            if (i3 > i2) {
                break;
            }
            int i4 = (i3 + i2) / 2;
            float f2 = f4805B2KMhB[i4];
            if (f < f2) {
                i2 = i4 - 1;
            } else {
                if (f <= f2) {
                    i = i4;
                    break;
                }
                i3 = i4 + 1;
            }
        }
        if (i3 > i2) {
            i = Math.min(i3, 10);
        }
        this.f4807AlLFFp.setSolarValue(f4804B25kr6[i < 11 ? i : 10]);
    }
}
