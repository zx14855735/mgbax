package FSFw2u;

import GnQT2j.AaHO0E;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.widget.ImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz implements AaHO0E, HFjH17.A5SV6n {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2687AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AZkASS f2688AlLFFp;

    public /* synthetic */ AYUAbz(AZkASS aZkASS, int i) {
        this.f2687AcNBzu = i;
        this.f2688AlLFFp = aZkASS;
    }

    @Override // GnQT2j.AaHO0E
    public void a(Bitmap bitmap) {
        Bitmap bitmap2;
        AZkASS aZkASS = this.f2688AlLFFp;
        switch (this.f2687AcNBzu) {
            case 0:
                aZkASS.f3199B7CMnp = bitmap;
                aZkASS.f2716GIi2tl = bitmap;
                aZkASS.f2735HSHyT0 = bitmap.getWidth() > bitmap.getHeight();
                aZkASS.D9tr6l();
                System.currentTimeMillis();
                int i = GJee0v.AZOQYO.f3039AcNBzu;
                break;
            default:
                ImageView imageView = aZkASS.f2700F32kj0;
                if (imageView != null) {
                    if (bitmap == null) {
                        bitmap2 = null;
                    } else {
                        float f = 80;
                        float f2 = 1.0f * f;
                        float width = f2 / bitmap.getWidth();
                        float height = f2 / bitmap.getHeight();
                        Matrix matrix = new Matrix();
                        matrix.setScale(width, height);
                        Bitmap createBitmap = Bitmap.createBitmap(80, 80, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(createBitmap);
                        Paint paint = new Paint(1);
                        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
                        bitmapShader.setLocalMatrix(matrix);
                        paint.setShader(bitmapShader);
                        float f3 = 16;
                        canvas.drawRoundRect(new RectF(0.0f, 0.0f, f, f), f3, f3, paint);
                        bitmap2 = createBitmap;
                    }
                    imageView.setImageBitmap(bitmap2);
                    break;
                }
                break;
        }
    }

    @Override // HFjH17.A5SV6n
    public void a(boolean z) {
        AZkASS aZkASS = this.f2688AlLFFp;
        if (z) {
            aZkASS.CqNSpT(aZkASS.f3187AYUAbz);
        } else {
            aZkASS.CSDoyG(aZkASS.f3187AYUAbz);
        }
    }

    @Override // GnQT2j.AaHO0E
    public void a(Exception exc) {
        switch (this.f2687AcNBzu) {
            case 0:
                exc.getMessage();
                int i = GJee0v.AZOQYO.f3039AcNBzu;
                this.f2688AlLFFp.BTvldC("1", "加载image素材失败");
                break;
            default:
                int i2 = GJee0v.AZOQYO.f3039AcNBzu;
                break;
        }
    }
}
