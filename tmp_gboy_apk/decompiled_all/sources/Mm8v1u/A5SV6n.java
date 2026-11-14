package Mm8v1u;

import android.view.Choreographer;
import com.game.boy.viewUi.GameSurfaceView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n implements Choreographer.FrameCallback {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ GameSurfaceView f5463AcNBzu;

    public A5SV6n(GameSurfaceView gameSurfaceView) {
        this.f5463AcNBzu = gameSurfaceView;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        if (!this.f5463AcNBzu.f11152AcNBzu) {
            this.f5463AcNBzu.f11180CcAIMM = false;
            return;
        }
        Choreographer.getInstance().postFrameCallback(this);
        this.f5463AcNBzu.f11180CcAIMM = true;
        GameSurfaceView gameSurfaceView = this.f5463AcNBzu;
        if (gameSurfaceView.f11174CASmeH || gameSurfaceView.f11175CNPG0E) {
            gameSurfaceView.AZOQYO();
            this.f5463AcNBzu.f11179CTkVKb = 0;
        } else {
            if (!gameSurfaceView.f11169BV3sI0 || gameSurfaceView.f11166BNL6CD.isEmpty()) {
                return;
            }
            GameSurfaceView gameSurfaceView2 = this.f5463AcNBzu;
            int i = gameSurfaceView2.f11179CTkVKb + 1;
            gameSurfaceView2.f11179CTkVKb = i;
            if (i >= 1) {
                gameSurfaceView2.AZOQYO();
                this.f5463AcNBzu.f11179CTkVKb = 0;
            }
        }
    }
}
