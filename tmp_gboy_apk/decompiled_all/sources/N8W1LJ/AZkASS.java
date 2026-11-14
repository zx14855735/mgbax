package N8W1LJ;

import Mm8v1u.B7CMnp;
import Mm8v1u.BChYOn;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.github.chrisbanes.photoview.PhotoView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZkASS implements GestureDetector.OnDoubleTapListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ AmA8tU f5556AcNBzu;

    public AZkASS(AmA8tU amA8tU) {
        this.f5556AcNBzu = amA8tU;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        AmA8tU amA8tU = this.f5556AcNBzu;
        try {
            float ADYaiT2 = amA8tU.ADYaiT();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            float f = amA8tU.f5571AzWtSf;
            if (ADYaiT2 < f) {
                amA8tU.AMqCpz(f, x, y, true);
            } else {
                if (ADYaiT2 >= f) {
                    float f2 = amA8tU.f5572B25kr6;
                    if (ADYaiT2 < f2) {
                        amA8tU.AMqCpz(f2, x, y, true);
                    }
                }
                amA8tU.AMqCpz(amA8tU.f5570AmA8tU, x, y, true);
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF rectF;
        AmA8tU amA8tU = this.f5556AcNBzu;
        View.OnClickListener onClickListener = amA8tU.f5584BTvldC;
        if (onClickListener != null) {
            onClickListener.onClick(amA8tU.f5575B4ZgIw);
        }
        amA8tU.A4TApA();
        Matrix A5SV6n2 = amA8tU.A5SV6n();
        if (amA8tU.f5575B4ZgIw.getDrawable() != null) {
            rectF = amA8tU.f5581BJ7GGh;
            rectF.set(0.0f, 0.0f, r2.getIntrinsicWidth(), r2.getIntrinsicHeight());
            A5SV6n2.mapRect(rectF);
        } else {
            rectF = null;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        AZOQYO azoqyo = amA8tU.f5583BPw6Q8;
        if (azoqyo != null) {
            B7CMnp b7CMnp = (B7CMnp) ((AZkASS.ARc23Z) azoqyo).f451AlLFFp;
            if (b7CMnp.f5508AcNBzu.getDrawable() != null) {
                PhotoView photoView = b7CMnp.f5508AcNBzu;
                Matrix imageMatrix = photoView.getImageMatrix();
                RectF rectF2 = new RectF(0.0f, 0.0f, r2.getIntrinsicWidth(), r2.getIntrinsicHeight());
                imageMatrix.mapRect(rectF2);
                float width = photoView.getWidth();
                float height = photoView.getHeight();
                float width2 = (width - rectF2.width()) / 2.0f;
                float height2 = (height - rectF2.height()) / 2.0f;
                if (new RectF(width2, height2, rectF2.width() + width2, rectF2.height() + height2).contains(x, y)) {
                    BChYOn.A2egSU(b7CMnp.f5510AmA8tU.f5511AcNBzu);
                } else if (LEPB2s.A2egSU.A4TApA().A5SV6n()) {
                    LEPB2s.A2egSU.A4TApA().A2egSU();
                }
            } else if (LEPB2s.A2egSU.A4TApA().A5SV6n()) {
                LEPB2s.A2egSU.A4TApA().A2egSU();
            }
        }
        if (rectF == null || !rectF.contains(x, y)) {
            return false;
        }
        rectF.width();
        rectF.height();
        return true;
    }
}
