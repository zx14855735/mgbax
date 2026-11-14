package FSFw2u;

import ADYaiT.D8MqeW;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2682AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AZkASS f2683AlLFFp;

    public /* synthetic */ ARc23Z(AZkASS aZkASS, int i) {
        this.f2682AcNBzu = i;
        this.f2683AlLFFp = aZkASS;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2682AcNBzu) {
            case 0:
                this.f2683AlLFFp.EGM26s(true);
                break;
            default:
                AZkASS aZkASS = this.f2683AlLFFp;
                HFjH17.ADYaiT aDYaiT = aZkASS.f2745I3bnmY;
                if (aDYaiT != null) {
                    aZkASS.f2717GIl1rw = aDYaiT.A2egSU(1L);
                } else {
                    Bitmap bitmap = aZkASS.f2716GIi2tl;
                    if (bitmap != null) {
                        aZkASS.f2717GIl1rw = Bitmap.createBitmap(bitmap.getWidth(), aZkASS.f2716GIi2tl.getHeight(), Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(aZkASS.f2717GIl1rw);
                        Paint paint = new Paint(1);
                        Bitmap bitmap2 = aZkASS.f2716GIi2tl;
                        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                        paint.setShader(new BitmapShader(bitmap2, tileMode, tileMode));
                        canvas.drawRoundRect(new RectF(0.0f, 0.0f, aZkASS.f2716GIi2tl.getWidth(), aZkASS.f2716GIi2tl.getHeight()), 0.0f, 0.0f, paint);
                    }
                }
                if (aZkASS.f2748IJPJ4E) {
                    aZkASS.f2717GIl1rw = JrXYwF.A4TApA.A4TApA(aZkASS.f2717GIl1rw, 40.0f);
                }
                aZkASS.f2695ErKPGd.post(new D8MqeW(15, this));
                break;
        }
    }
}
