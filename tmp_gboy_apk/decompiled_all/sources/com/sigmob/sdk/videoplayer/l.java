package com.sigmob.sdk.videoplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class l extends TextureView {

    /* renamed from: a, reason: collision with root package name */
    protected static final String f13778a = "ResizeTextureView";
    public int b;
    public int c;

    public l(Context context) {
        super(context);
        this.b = 0;
        this.c = 0;
    }

    public void a(int i, int i2) {
        if (this.b == i && this.c == i2) {
            return;
        }
        this.b = i;
        this.c = i2;
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0092, code lost:
    
        if (r13 > r8) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0094, code lost:
    
        r13 = (r8 * r2) / r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a6, code lost:
    
        if (r13 > r8) goto L40;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r13, int r14) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videoplayer.l.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public void setRotation(float f) {
        if (f != getRotation()) {
            super.setRotation(f);
            requestLayout();
        }
    }

    public l(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.c = 0;
    }
}
