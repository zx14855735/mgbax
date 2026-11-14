package Mm8v1u;

import com.game.boy.viewUi.HTMLTextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZOQYO implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f5494AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AZkASS f5495AlLFFp;

    public /* synthetic */ AZOQYO(AZkASS aZkASS, int i) {
        this.f5494AcNBzu = i;
        this.f5495AlLFFp = aZkASS;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5494AcNBzu) {
            case 0:
                HTMLTextView hTMLTextView = this.f5495AlLFFp.f5497B25kr6.f5498A2egSU;
                hTMLTextView.setText(hTMLTextView.getText());
                break;
            default:
                this.f5495AlLFFp.f5497B25kr6.f5498A2egSU.invalidate();
                break;
        }
    }
}
