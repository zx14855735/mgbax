package LXWm8h;

import android.graphics.Rect;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Method;
import org.apache.commons.codec.language.Soundex;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface A2egSU {

    /* renamed from: ARc23Z, reason: collision with root package name */
    public static final Rect f4858ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public static final Rect f4859ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public static final Rect f4860AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public static final Rect f4861AZOQYO;

    /* renamed from: AZkASS, reason: collision with root package name */
    public static final Rect f4862AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public static final Rect f4863AaHO0E;

    static {
        new Rect(0, 0, 160, 160);
        f4858ARc23Z = new Rect(0, 0, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        new Rect(MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, 0, 256, 48);
        f4859ASJ6gh = new Rect(0, 0, 160, 160);
        new Rect(0, 0, 160, 160);
        new Rect(0, 0, 160, 160);
        f4860AYUAbz = new Rect(0, 0, 256, 92);
        f4861AZOQYO = new Rect(0, 0, 200, 100);
        f4862AZkASS = new Rect(0, 0, 200, 100);
        new Rect(0, 0, 160, 160);
        new Rect(0, 0, 160, 160);
        new Rect(0, 0, 160, 160);
        new Rect(0, 0, 160, 160);
        new Rect(0, 0, 160, 160);
        new Rect(0, 0, 160, 160);
        new Rect(0, 0, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE);
        new Rect(0, 0, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE);
        new Rect(0, 0, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE);
        f4863AaHO0E = new Rect(0, 0, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE);
        new Rect(0, 0, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE);
        GGzc();
    }

    private static /* synthetic */ void GGzc() {
        char[] charArray = "NB@\u0003JL@H\u0003OBT\u0003^EHAA\u0003gCDo_DIJH".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ Soundex.SILENT_MARKER);
        }
        String str = new String(charArray);
        char[] charArray2 = "NADCDY".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ Soundex.SILENT_MARKER);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
