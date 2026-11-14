package CtFAbx;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AMqCpz extends com.bumptech.glide.AMqCpz {

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final /* synthetic */ int f1887ARc23Z;

    public /* synthetic */ AMqCpz(int i) {
        this.f1887ARc23Z = i;
    }

    @Override // com.bumptech.glide.AMqCpz
    public final float BniPrB(Object obj) {
        switch (this.f1887ARc23Z) {
            case 0:
                return ((View) obj).getAlpha();
            case 1:
                return ((View) obj).getScaleX();
            case 2:
                return ((View) obj).getScaleY();
            case 3:
                return ((View) obj).getRotation();
            case 4:
                return ((View) obj).getRotationX();
            default:
                return ((View) obj).getRotationY();
        }
    }

    @Override // com.bumptech.glide.AMqCpz
    public final void Cd8JRx(Object obj, float f) {
        switch (this.f1887ARc23Z) {
            case 0:
                ((View) obj).setAlpha(f);
                break;
            case 1:
                ((View) obj).setScaleX(f);
                break;
            case 2:
                ((View) obj).setScaleY(f);
                break;
            case 3:
                ((View) obj).setRotation(f);
                break;
            case 4:
                ((View) obj).setRotationX(f);
                break;
            default:
                ((View) obj).setRotationY(f);
                break;
        }
    }
}
