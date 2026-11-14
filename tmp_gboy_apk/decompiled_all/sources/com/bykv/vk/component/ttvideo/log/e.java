package com.bykv.vk.component.ttvideo.log;

import B4ZgIw.AYUAbz;
import android.content.Context;
import android.provider.Settings;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public enum e {
    instance;


    /* renamed from: a, reason: collision with root package name */
    private VideoEventEngineUploader f10018a;
    private Context b;

    static {
        CtAQLWz();
    }

    private static /* synthetic */ void CtAQLWz() {
        char[] charArray = "\u0006\n\bK\u0002\u0004\b\u0000K\u0007\n\u001cK\u0016\r\u0000\t\tK/\u000b\f'\u0017\f\u0001\u0002\u0000".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'e');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0006\t\f\u000b\f\u0011".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'e');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public void a(Context context) {
        this.b = context.getApplicationContext();
    }

    public synchronized void a(VideoEventEngineUploader videoEventEngineUploader) {
        this.f10018a = videoEventEngineUploader;
    }

    private void a(JSONObject jSONObject) {
        if (((TTVideoEngineLog.LogNotifyLevel >> 2) & 1) == 1 || ((TTVideoEngineLog.LogTurnOn >> 2) & 1) == 1) {
            TTVideoEngineLog.i("VideoEventManager", jSONObject.toString());
        }
        if (((TTVideoEngineLog.LogTurnOn >> 1) & 1) == 1) {
            Context context = this.b;
            String string = context != null ? Settings.Global.getString(context.getContentResolver(), "engine.debug") : "";
            if (string != null) {
                for (String str : string.split(",", -1)) {
                    if (jSONObject.opt(str) != null) {
                        StringBuilder A5SV6n2 = AYUAbz.A5SV6n(str, ":");
                        A5SV6n2.append(jSONObject.opt(str));
                        TTVideoEngineLog.i("VideoEventManager", A5SV6n2.toString());
                    }
                }
            }
        }
    }

    public void a(boolean z, JSONObject jSONObject) {
        synchronized (e.class) {
            if (jSONObject != null) {
                try {
                    a(jSONObject);
                    VideoEventEngineUploader videoEventEngineUploader = this.f10018a;
                    if (videoEventEngineUploader != null) {
                        videoEventEngineUploader.onEvent("video_playq", jSONObject);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
