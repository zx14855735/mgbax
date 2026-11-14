package com.bytedance.adsdk.xj.xj.xj;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.bytedance.adsdk.xj.xj.hf.c;
import com.bytedance.adsdk.xj.xj.hf.y;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class f<R extends com.bytedance.adsdk.xj.xj.hf.y, W extends com.bytedance.adsdk.xj.xj.hf.c> {
    protected final R c;
    public int d;
    public int f;
    public int p;

    /* renamed from: pl, reason: collision with root package name */
    public int f10097pl;
    public int tf;
    protected final Rect g = new Rect();
    protected final Rect am = new Rect();

    public f(R r) {
        this.c = r;
    }

    public abstract Bitmap xj(Canvas canvas, Paint paint, int i, Bitmap bitmap, W w);
}
