package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class by {
    private View bgI;
    public Point bgH = new Point();
    public Rect bgF = new Rect();
    public Rect bgG = new Rect();

    public by(View view) {
        this.bgI = view;
    }

    public final boolean Ug() {
        boolean globalVisibleRect = this.bgI.getGlobalVisibleRect(this.bgF, this.bgH);
        Point point = this.bgH;
        if (point.x == 0 && point.y == 0 && this.bgF.height() == this.bgI.getHeight() && this.bgG.height() != 0 && Math.abs(this.bgF.top - this.bgG.top) > this.bgI.getHeight() / 2) {
            this.bgF.set(this.bgG);
        }
        this.bgG.set(this.bgF);
        return globalVisibleRect;
    }
}
