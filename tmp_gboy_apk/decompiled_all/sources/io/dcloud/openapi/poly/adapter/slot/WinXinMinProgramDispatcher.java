package io.dcloud.openapi.poly.adapter.slot;

import ADYaiT.BChYOn;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class WinXinMinProgramDispatcher {

    /* renamed from: a, reason: collision with root package name */
    public static final Handler f14003a = new Handler(Looper.getMainLooper());
    public static CopyOnWriteArrayList<MessageListener> sFeatureMessage = new CopyOnWriteArrayList<>();

    public interface MessageListener {
        void onReceiver(Object obj);
    }

    static {
        YDLFF();
    }

    private static /* synthetic */ void YDLFF() {
        char[] charArray = "ÞÒÐ\u0093ÚÜÐØ\u0093ßÒÄ\u0093ÎÕØÑÑ\u0093÷ÓÔÿÏÔÙÚØ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 189);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÞÑÔÓÔÉ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 189);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void dispatchMessage(Object obj) {
        try {
            Iterator<MessageListener> it = sFeatureMessage.iterator();
            while (it.hasNext()) {
                MessageListener next = it.next();
                if (obj != null) {
                    f14003a.post(new BChYOn(next, 16, obj));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void registerListener(MessageListener messageListener) {
        sFeatureMessage.add(messageListener);
    }

    public static void unregisterListener(MessageListener messageListener) {
        sFeatureMessage.remove(messageListener);
    }
}
