package Ogw3zR;

import android.content.Context;
import android.view.View;
import android.view.animation.PathInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class A2egSU {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final PathInterpolator f6637A2egSU = new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);

    /* renamed from: A4TApA, reason: collision with root package name */
    public final View f6638A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final int f6639A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final int f6640ADYaiT;
    public final int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public androidx.activity.A4TApA f6641ARc23Z;

    public A2egSU(View view) {
        this.f6638A4TApA = view;
        Context context = view.getContext();
        this.f6639A5SV6n = com.bumptech.glide.A5SV6n.D07BeM(context, 2130969621, 300);
        this.f6640ADYaiT = com.bumptech.glide.A5SV6n.D07BeM(context, 2130969626, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS);
        this.AMqCpz = com.bumptech.glide.A5SV6n.D07BeM(context, 2130969625, 100);
    }
}
