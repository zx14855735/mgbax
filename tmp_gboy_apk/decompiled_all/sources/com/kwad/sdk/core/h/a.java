package com.kwad.sdk.core.h;

import android.text.TextUtils;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.h;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class a {
    private static C0365a aOJ;
    private static boolean aOK;
    private static final AtomicBoolean mHasInit = new AtomicBoolean(false);
    private static boolean aOL = true;

    @KsJson
    /* renamed from: com.kwad.sdk.core.h.a$a, reason: collision with other inner class name */
    public static class C0365a extends com.kwad.sdk.core.response.a.a {
        public List<String> aOM;
        public int aON;
        public List<String> aOO;
        public List<String> aOP;
    }

    static {
        yIQCk();
    }

    public static void LD() {
        h.execute(new bg() { // from class: com.kwad.sdk.core.h.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (a.mHasInit.getAndSet(true)) {
                    return;
                }
                try {
                    C0365a unused = a.aOJ = new C0365a();
                    boolean unused2 = a.aOK = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).DE();
                    String DF = ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).DF();
                    if (a.aOK && !TextUtils.isEmpty(DF)) {
                        a.aOJ.parseJson(new JSONObject(DF));
                        a.LE();
                        return;
                    }
                    boolean unused3 = a.aOL = a.aOK;
                } catch (Throwable unused4) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void LE() {
        aOL = true;
        if (aOJ == null) {
            return;
        }
        ea(LF());
        ag.l("ksadsdk_tk_switch", "tk_config", aOL);
    }

    private static int LF() {
        int i = !aOJ.aOO.isEmpty() ? 1 : 0;
        C0365a c0365a = aOJ;
        int i2 = c0365a.aON != 0 ? 2 : 0;
        return ((i ^ i2) ^ (!c0365a.aOM.isEmpty() ? 4 : 0)) ^ (aOJ.aOP.isEmpty() ? 0 : 8);
    }

    public static boolean LG() {
        return mHasInit.get() ? aOL : ag.m("ksadsdk_tk_switch", "tk_config", true);
    }

    private static void ea(int i) {
        for (int i2 = 0; i2 < Integer.toBinaryString(i).length(); i2++) {
            if (((1 << i2) & i) != 0) {
                aOL = false;
                eb(i2);
                if (aOL) {
                    return;
                }
            }
        }
    }

    private static void eb(int i) {
        if (i == 0) {
            if (aOJ.aOO.contains(br.TN())) {
                return;
            }
            aOL = true;
        } else if (i == 1) {
            if (aOJ.aON < br.TX()) {
                aOL = true;
            }
        } else if (i == 2) {
            if (aOJ.aOM.contains(BuildConfig.VERSION_NAME)) {
                return;
            }
            aOL = true;
        } else if (i == 3 && !aOJ.aOP.contains(br.TM())) {
            aOL = true;
        }
    }

    private static /* synthetic */ void yIQCk() {
        char[] charArray = "\u0091\u009d\u009fÜ\u0095\u0093\u009f\u0097Ü\u0090\u009d\u008bÜ\u0081\u009a\u0097\u009e\u009eÜ¸\u009c\u009b°\u0080\u009b\u0096\u0095\u0097".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 242);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0091\u009e\u009b\u009c\u009b\u0086".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 242);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
