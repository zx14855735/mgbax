package com.octopus.ad.internal.view;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.octopus.ad.internal.q;
import com.octopus.ad.internal.utilities.ViewUtil;
import com.octopus.ad.utils.i;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class e implements View.OnTouchListener {

    /* renamed from: a, reason: collision with root package name */
    private long f12599a;
    private float b;
    private float c;
    private boolean d;
    private boolean e = false;
    private final boolean f;
    private final a g;
    private final com.octopus.ad.model.d h;

    public interface a {
        void a(View view, com.octopus.ad.model.d dVar);
    }

    public e(View view, boolean z, a aVar) {
        this.f = z;
        this.g = aVar;
        com.octopus.ad.model.d dVar = new com.octopus.ad.model.d(1);
        this.h = dVar;
        if (view == null || view.getWidth() <= 0 || view.getHeight() <= 0) {
            dVar.a(ViewUtil.getScreenWidth(q.a().j()));
            dVar.b(ViewUtil.getScreenHeight(q.a().j()));
        } else {
            dVar.a(view.getWidth());
            dVar.b(view.getHeight());
        }
    }

    private void a(View view) {
        a aVar = this.g;
        if (aVar != null) {
            aVar.a(view, this.h);
        }
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f12599a = System.currentTimeMillis();
            this.b = motionEvent.getX();
            this.c = motionEvent.getY();
            this.h.a(motionEvent.getRawX());
            this.h.b(motionEvent.getRawY());
            this.h.a(String.valueOf(System.currentTimeMillis()));
            this.h.d(String.valueOf(System.currentTimeMillis()));
            this.h.c(String.valueOf(System.currentTimeMillis() / 1000));
            this.d = true;
            if (this.f && !this.e) {
                int a2 = i.a(MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS) + 50;
                this.h.c(motionEvent.getRawX());
                this.h.d(motionEvent.getRawY());
                this.h.b(String.valueOf(System.currentTimeMillis() + a2));
                a(view);
                this.e = true;
            }
        } else if (action != 1) {
            if (action == 2 && this.d && a(this.b, this.c, motionEvent.getX(), motionEvent.getY()) > 15.0f) {
                this.d = false;
            }
        } else if (System.currentTimeMillis() - this.f12599a < 1000 && this.d && (!this.f || this.e)) {
            this.h.c(motionEvent.getRawX());
            this.h.d(motionEvent.getRawY());
            this.h.b(String.valueOf(System.currentTimeMillis()));
            a(view);
        }
        return true;
    }

    public static float a(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return a((float) Math.sqrt((f6 * f6) + (f5 * f5)));
    }

    private static float a(float f) {
        return f / q.a().q().density;
    }
}
