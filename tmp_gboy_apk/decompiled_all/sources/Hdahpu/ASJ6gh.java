package Hdahpu;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kuaishou.weapon.p0.t;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh implements LXWm8h.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final DisplayMetrics f3695AcNBzu;

    public ASJ6gh(Context context) {
        this.f3695AcNBzu = context.getResources().getDisplayMetrics();
    }

    public static Rect A4TApA(Rect rect, Rect rect2, float f, int i) {
        int width = (int) (rect2.width() * f);
        int height = (int) (rect2.height() * f);
        int centerX = (i & 1) != 0 ? rect.left : (i & 2) != 0 ? rect.right - width : rect.centerX() - (width / 2);
        int centerY = (i & 8) != 0 ? rect.top : (i & 16) != 0 ? rect.bottom - height : rect.centerY() - (height / 2);
        return new Rect(centerX, centerY, width + centerX, height + centerY);
    }

    public Map A2egSU(int i, int i2, boolean z) {
        int i3;
        int i4;
        HashMap hashMap = new HashMap();
        int i5 = (i2 * MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA) / 160;
        if (i5 > i) {
            i3 = (i * 160) / MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA;
            i5 = i;
        } else {
            i3 = i2;
        }
        Rect rect = new Rect(0, 0, i5, i3);
        rect.offsetTo((i - rect.width()) / 2, 0);
        if (z) {
            if ((Build.MANUFACTURER + " - " + Build.DEVICE).startsWith("Sony Ericsson - R800")) {
                hashMap.put("video", rect);
                return hashMap;
            }
        }
        DisplayMetrics displayMetrics = this.f3695AcNBzu;
        float f = 0.45f * displayMetrics.density;
        Rect rect2 = new Rect(0, 0, i, i2);
        float f2 = 10;
        int i6 = (int) (displayMetrics.density * f2);
        rect2.left += i6;
        rect2.right -= i6;
        rect2.bottom -= i6;
        float height = rect2.height();
        float f3 = MediaPlayer.MEDIA_PLAYER_OPTION_USE_CODEC_POOL;
        float f4 = displayMetrics.density;
        if (height > f3 * f4 && rect2.height() > (i4 = (int) (MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA * f4))) {
            rect2.top = rect2.bottom - i4;
        }
        Rect A4TApA2 = A4TApA(rect2, LXWm8h.A2egSU.f4858ARc23Z, f, 17);
        Rect A4TApA3 = A4TApA(rect2, LXWm8h.A2egSU.f4859ASJ6gh, 0.9f * f, 18);
        Rect rect3 = new Rect(A4TApA3);
        rect3.offset((-A4TApA3.width()) - ((int) (f2 * displayMetrics.density)), 0);
        float f5 = 1.1f * f;
        Rect A4TApA4 = A4TApA(rect2, LXWm8h.A2egSU.f4861AZOQYO, f5, 9);
        Rect A4TApA5 = A4TApA(rect2, LXWm8h.A2egSU.f4862AZkASS, f5, 10);
        Rect A4TApA6 = A4TApA(rect2, LXWm8h.A2egSU.f4860AYUAbz, 1.0f * f, 20);
        int i7 = A4TApA2.right;
        int i8 = A4TApA6.left;
        if (i7 > i8) {
            A4TApA6.offsetTo(rect2.right - A4TApA6.width(), rect2.centerY() - (A4TApA6.height() / 2));
        } else {
            int i9 = (rect2.right - i8) - ((int) (MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME * displayMetrics.density));
            if (i9 > 0) {
                A4TApA6.offset(i9, 0);
            }
        }
        float width = r13.width() / r13.height();
        int height2 = A4TApA6.height();
        int i10 = (int) (height2 * width);
        if (i10 * 2 > A4TApA6.width()) {
            i10 = A4TApA6.width() / 2;
            height2 = (int) (i10 / width);
        }
        int centerY = A4TApA6.centerY() - (height2 / 2);
        int centerX = A4TApA6.centerX();
        int i11 = height2 + centerY;
        Rect rect4 = new Rect(centerX - i10, centerY, centerX, i11);
        Rect rect5 = new Rect(centerX, centerY, i10 + centerX, i11);
        Rect A4TApA7 = A4TApA(rect2, LXWm8h.A2egSU.f4863AaHO0E, f * 0.6f, 12);
        if (A4TApA7.bottom < rect.bottom) {
            int height3 = A4TApA7.height();
            A4TApA7.bottom = height3;
            A4TApA7.top = 0;
            if (A4TApA4.top > height3) {
                A4TApA7.right = A4TApA7.width() + rect2.left;
                A4TApA7.left = rect2.left;
            }
        }
        hashMap.put("dpad", A4TApA2);
        hashMap.put(t.f, A4TApA3);
        hashMap.put(t.l, rect3);
        hashMap.put("tl", A4TApA4);
        hashMap.put("tr", A4TApA5);
        hashMap.put("select", rect4);
        hashMap.put("start", rect5);
        hashMap.put("menu", A4TApA7);
        hashMap.put("video", rect);
        return hashMap;
    }

    public ASJ6gh(DisplayMetrics displayMetrics) {
        this.f3695AcNBzu = displayMetrics;
    }
}
