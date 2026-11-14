package com.kwad.components.core.webview.tachikoma.e;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class a {
    private List<Integer> alC;
    private final List<Integer> alD;

    /* renamed from: com.kwad.components.core.webview.tachikoma.e.a$a, reason: collision with other inner class name */
    public static class C0324a {
        private static final a alH = new a(0);

        static {
            PFfWqIg();
        }

        private static /* synthetic */ void PFfWqIg() {
            char[] charArray = "¼°²ñ¸¾²ºñ½°¦ñ¬·º³³ñ\u0095±¶\u009d\u00ad¶»¸º".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 223);
            }
            String str = new String(charArray);
            char[] charArray2 = "¼³¶±¶«".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 223);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bD(int i) {
        if (this.alD.contains(Integer.valueOf(i))) {
            this.alC.add(Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(String str) {
        int i;
        try {
            i = new JSONObject(str).optInt("elementType");
        } catch (Exception unused) {
            i = Integer.MAX_VALUE;
        }
        if (this.alD.contains(Integer.valueOf(i))) {
            this.alC.add(Integer.valueOf(i));
        }
    }

    public static a xj() {
        return C0324a.alH;
    }

    public final void bE(final int i) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.e.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.bD(i);
            }
        });
    }

    public final void bu(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.webview.tachikoma.e.a.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.bt(str);
            }
        });
    }

    public final List<Integer> xk() {
        return this.alC;
    }

    public final void xl() {
        this.alC.clear();
    }

    private a() {
        this.alC = new ArrayList();
        this.alD = Arrays.asList(123, Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO), Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY), Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME), Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH), 200);
    }
}
