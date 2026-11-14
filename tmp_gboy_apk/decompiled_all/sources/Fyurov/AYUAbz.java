package Fyurov;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz extends ClickableSpan {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f2926AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f2927AlLFFp;

    public AYUAbz(AZOQYO azoqyo, int i) {
        this.f2927AlLFFp = azoqyo;
        this.f2926AcNBzu = i;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        AZkASS aZkASS = this.f2927AlLFFp.AMqCpz;
        if (aZkASS == null) {
            int i = GJee0v.AZOQYO.f3039AcNBzu;
            return;
        }
        int i2 = this.f2926AcNBzu;
        if (i2 == 1) {
            aZkASS.c(view);
        } else if (i2 == 2) {
            aZkASS.a(view);
        } else {
            if (i2 != 3) {
                return;
            }
            aZkASS.b(view);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
        textPaint.clearShadowLayer();
    }
}
