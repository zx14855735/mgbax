package com.sigmob.sdk.videoplayer;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public abstract class i implements TextureView.SurfaceTextureListener {

    /* renamed from: a, reason: collision with root package name */
    public SurfaceTexture f13777a;
    public Handler b;
    public Handler c;
    public h d;

    public i(h hVar) {
        this.d = hVar;
    }

    public abstract void a();

    public abstract void a(float f);

    public abstract void a(long j);

    public abstract void a(Surface surface);

    public abstract void a(boolean z);

    public abstract void b();

    public abstract void b(float f);

    public abstract void c();

    public abstract void d();

    public abstract boolean e();

    public abstract void f();

    public abstract long g();

    public abstract int h();

    public abstract int i();

    public abstract long j();
}
