package com.czhj.sdk.common.network;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.czhj.sdk.common.utils.DeviceUtils;
import com.czhj.volley.RequestQueue;
import com.czhj.volley.toolbox.ImageLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class MaxWidthImageLoader extends ImageLoader {

    /* renamed from: a, reason: collision with root package name */
    private final int f10571a;

    public MaxWidthImageLoader(RequestQueue requestQueue, Context context, ImageLoader.ImageCache imageCache) {
        super(requestQueue, imageCache);
        int min;
        Display display = DeviceUtils.getDisplay(context);
        if (display == null) {
            min = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        } else {
            Point point = new Point();
            display.getSize(point);
            min = Math.min(point.x, point.y);
        }
        this.f10571a = min;
    }

    @Override // com.czhj.volley.toolbox.ImageLoader
    public ImageLoader.ImageContainer get(String str, ImageLoader.ImageListener imageListener) {
        return super.get(str, imageListener, this.f10571a, 0);
    }
}
