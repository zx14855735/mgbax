package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class t extends View {

    /* renamed from: a, reason: collision with root package name */
    Paint f13325a;
    private final float b;

    public t(Context context, float f) {
        super(context);
        this.f13325a = new Paint();
        this.b = f;
    }

    public float a(int i) {
        return (float) Math.cos((i * 3.141592653589793d) / 180.0d);
    }

    public float b(int i) {
        return (float) Math.sin((i * 3.141592653589793d) / 180.0d);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Path b;
        super.onDraw(canvas);
        int height = getHeight();
        int i = (int) this.b;
        float f = height;
        float f2 = f / 3.0f;
        float b2 = (b(18) * f2) / b(126);
        boolean z = true;
        this.f13325a.setAntiAlias(true);
        this.f13325a.setColor(Color.parseColor("#FFA500"));
        for (int i2 = i; i2 > 0; i2--) {
            if (z) {
                canvas.translate(f2 + 2.0f, f / 2.0f);
                z = false;
            } else {
                canvas.rotate(18.0f);
                canvas.translate(2.2f * f2, 0.0f);
            }
            canvas.rotate(-18.0f);
            Path b3 = b(f2, b2);
            this.f13325a.setStyle(Paint.Style.STROKE);
            canvas.drawPath(b3, this.f13325a);
            this.f13325a.setStyle(Paint.Style.FILL);
            canvas.drawPath(b3, this.f13325a);
        }
        float f3 = this.b;
        float f4 = i;
        if (f3 > f4) {
            float f5 = (f3 - f4) + 0.25f;
            if (f5 >= 1.0f) {
                canvas.rotate(18.0f);
                canvas.translate(f2 * 2.2f, 0.0f);
                canvas.rotate(-18.0f);
                b = b(f2, b2);
                this.f13325a.setStyle(Paint.Style.STROKE);
                this.f13325a.setColor(Color.parseColor("#FFA500"));
                canvas.drawPath(b, this.f13325a);
            } else {
                canvas.rotate(18.0f);
                if (f5 >= 0.5f) {
                    canvas.translate(f2 * 2.2f, 0.0f);
                    canvas.rotate(-18.0f);
                    Path b4 = b(f2, b2);
                    this.f13325a.setColor(Color.parseColor("#FFA500"));
                    this.f13325a.setStyle(Paint.Style.STROKE);
                    canvas.drawPath(b4, this.f13325a);
                    b = a(f2, b2);
                    this.f13325a.setColor(Color.parseColor("#FFA500"));
                } else {
                    canvas.translate(f2 * 2.2f, 0.0f);
                    canvas.rotate(-18.0f);
                    b = b(f2, b2);
                    this.f13325a.setStyle(Paint.Style.STROKE);
                    this.f13325a.setColor(Color.parseColor("#FFA500"));
                    canvas.drawPath(b, this.f13325a);
                }
            }
            this.f13325a.setStyle(Paint.Style.FILL);
            canvas.drawPath(b, this.f13325a);
        }
        for (int i3 = (int) (5.0f - this.b); i3 > 0; i3--) {
            canvas.rotate(18.0f);
            canvas.translate(f2 * 2.2f, 0.0f);
            canvas.rotate(-18.0f);
            Path b5 = b(f2, b2);
            this.f13325a.setStyle(Paint.Style.STROKE);
            this.f13325a.setColor(Color.parseColor("#FFA500"));
            canvas.drawPath(b5, this.f13325a);
        }
    }

    private Path a(float f, float f2) {
        Path path = new Path();
        path.moveTo(a(MediaPlayer.MEDIA_PLAYER_OPTION_UPDATE_TIMESTAMP_MODE) * f, b(MediaPlayer.MEDIA_PLAYER_OPTION_UPDATE_TIMESTAMP_MODE) * f);
        path.lineTo(a(108) * f2, b(108) * f2);
        path.lineTo(a(MediaPlayer.MEDIA_PLAYER_OPTION_SPADE) * f, b(MediaPlayer.MEDIA_PLAYER_OPTION_SPADE) * f);
        path.lineTo(a(180) * f2, b(180) * f2);
        path.lineTo(a(MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF) * f, b(MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF) * f);
        path.lineTo(a(MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF) * f2, b(MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF) * f2);
        path.close();
        return path;
    }

    private Path b(float f, float f2) {
        Path path = new Path();
        path.moveTo(a(0) * f, b(0) * f);
        path.lineTo(a(36) * f2, b(36) * f2);
        path.lineTo(a(72) * f, b(72) * f);
        path.lineTo(a(108) * f2, b(108) * f2);
        path.lineTo(a(MediaPlayer.MEDIA_PLAYER_OPTION_SPADE) * f, b(MediaPlayer.MEDIA_PLAYER_OPTION_SPADE) * f);
        path.lineTo(a(180) * f2, b(180) * f2);
        path.lineTo(a(MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF) * f, b(MediaPlayer.MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF) * f);
        path.lineTo(a(MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF) * f2, b(MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF) * f2);
        path.lineTo(a(MediaPlayer.MEDIA_PLAYER_OPTION_UPDATE_TIMESTAMP_MODE) * f, b(MediaPlayer.MEDIA_PLAYER_OPTION_UPDATE_TIMESTAMP_MODE) * f);
        path.lineTo(a(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR) * f2, b(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR) * f2);
        path.close();
        return path;
    }
}
