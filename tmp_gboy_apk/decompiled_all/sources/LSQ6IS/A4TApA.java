package LSQ6IS;

import android.graphics.Rect;
import android.graphics.RectF;
import com.game.boy.viewUi.GameSurfaceView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public RectF f4841A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public GameSurfaceView f4842A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f4843A5SV6n = 0;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public String f4844ADYaiT;

    public abstract int A2egSU(float f, float f2);

    public final void A4TApA(Rect rect) {
        this.f4841A2egSU = new RectF(rect);
    }

    public final void A5SV6n(int i) {
        if (i == 16) {
            this.f4842A4TApA.AZkASS(3, this.f4844ADYaiT);
            return;
        }
        if (i == 32) {
            this.f4842A4TApA.AZkASS(7, this.f4844ADYaiT);
            return;
        }
        if (i == 64) {
            this.f4842A4TApA.AZkASS(1, this.f4844ADYaiT);
            return;
        }
        if (i == 80) {
            this.f4842A4TApA.AZkASS(2, this.f4844ADYaiT);
            return;
        }
        if (i == 96) {
            this.f4842A4TApA.AZkASS(8, this.f4844ADYaiT);
            return;
        }
        if (i == 128) {
            this.f4842A4TApA.AZkASS(5, this.f4844ADYaiT);
            return;
        }
        if (i == 144) {
            this.f4842A4TApA.AZkASS(4, this.f4844ADYaiT);
        } else if (i != 160) {
            this.f4842A4TApA.AZkASS(0, this.f4844ADYaiT);
        } else {
            this.f4842A4TApA.AZkASS(6, this.f4844ADYaiT);
        }
    }
}
