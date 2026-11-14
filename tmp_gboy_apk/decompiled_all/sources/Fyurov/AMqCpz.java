package Fyurov;

import android.view.animation.AnimationSet;
import android.widget.ImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class AMqCpz implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2913AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ImageView f2914AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ AnimationSet f2915AmA8tU;

    public /* synthetic */ AMqCpz(ImageView imageView, AnimationSet animationSet, int i) {
        this.f2913AcNBzu = i;
        this.f2914AlLFFp = imageView;
        this.f2915AmA8tU = animationSet;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2913AcNBzu) {
            case 0:
                GJee0v.AZkASS.f3040ADYaiT.f3043A5SV6n.post(new AMqCpz(this.f2914AlLFFp, this.f2915AmA8tU, 1));
                break;
            default:
                this.f2914AlLFFp.startAnimation(this.f2915AmA8tU);
                break;
        }
    }
}
