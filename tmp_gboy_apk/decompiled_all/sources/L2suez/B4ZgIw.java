package L2suez;

import android.graphics.Bitmap;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class B4ZgIw {
    public static Bitmap A2egSU(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == height) {
            return Bitmap.createScaledBitmap(bitmap, MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT, MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT, true);
        }
        int min = Math.min(width, height);
        return Bitmap.createScaledBitmap(Bitmap.createBitmap(bitmap, (width - min) / 2, (height - min) / 2, min, min), MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT, MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT, true);
    }
}
