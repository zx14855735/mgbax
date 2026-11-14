package KpHwm4;

import android.os.Build;
import com.bykv.vk.component.ttvideo.player.C;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n {
    public static final boolean AMqCpz;

    /* renamed from: A4TApA, reason: collision with root package name */
    public long f4277A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f4278A5SV6n = 0;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f4279ADYaiT = 0;

    /* renamed from: A2egSU, reason: collision with root package name */
    public long f4276A2egSU = C.NANOS_PER_SECOND / 60;

    static {
        AMqCpz = Build.VERSION.SDK_INT >= 33;
        tpkq();
    }

    private static /* synthetic */ void tpkq() {
        char[] charArray = "ÒÞÜ\u009fÖÐÜÔ\u009fÓÞÈ\u009fÂÙÔÝÝ\u009fûßØóÃØÕÖÔ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 177);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÒÝØßØÅ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 177);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final boolean A2egSU() {
        int i;
        long nanoTime = System.nanoTime();
        long max = Math.max(1L, this.f4278A5SV6n * 2);
        long j = nanoTime - this.f4277A4TApA;
        long j2 = this.f4276A2egSU;
        if (j > max * j2) {
            this.f4277A4TApA = nanoTime - j2;
            this.f4279ADYaiT = 0;
        }
        long j3 = this.f4277A4TApA;
        if (nanoTime >= j3) {
            if ((nanoTime - j3) / j2 <= 0 || (i = this.f4279ADYaiT) >= this.f4278A5SV6n) {
                this.f4279ADYaiT = 0;
                this.f4277A4TApA = j3 + j2;
                return false;
            }
            this.f4279ADYaiT = i + 1;
            this.f4277A4TApA = j3 + j2;
            return true;
        }
        long j4 = j3 - nanoTime;
        if (j4 > 2000000) {
            try {
                Thread.sleep(j4 / C.MICROS_PER_SECOND, (int) (j4 % C.MICROS_PER_SECOND));
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            while (System.nanoTime() < this.f4277A4TApA) {
                if (AMqCpz) {
                    Thread.onSpinWait();
                } else {
                    Thread.yield();
                }
            }
        }
        this.f4279ADYaiT = 0;
        this.f4277A4TApA += this.f4276A2egSU;
        return false;
    }
}
