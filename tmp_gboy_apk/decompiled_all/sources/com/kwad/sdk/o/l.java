package com.kwad.sdk.o;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bg;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class l {
    private static a bja;
    private static final AtomicBoolean mHasInit = new AtomicBoolean(false);

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public List<String> bjc;
        public List<C0386a> bjd;

        @KsJson
        /* renamed from: com.kwad.sdk.o.l$a$a, reason: collision with other inner class name */
        public static class C0386a extends com.kwad.sdk.core.response.a.a {
            public String bje;
            public String bjf;
        }
    }

    static {
        XCiqubB();
    }

    public static void LD() {
        if (mHasInit.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.sdk.o.l.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a unused = l.bja = new a();
                try {
                    l.bja.parseJson((JSONObject) ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppConfigData(null, new com.kwad.sdk.g.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.o.l.1.1
                        private static JSONObject p(JSONObject jSONObject) {
                            if (jSONObject == null) {
                                return null;
                            }
                            jSONObject.optJSONObject("wrapperBlackConfig");
                            return null;
                        }

                        @Override // com.kwad.sdk.g.b
                        public final /* synthetic */ JSONObject apply(JSONObject jSONObject) {
                            return p(jSONObject);
                        }
                    }));
                } catch (Throwable unused2) {
                }
            }
        });
    }

    private static /* synthetic */ void XCiqubB() {
        char[] charArray = "COM\u000eGAME\u000eBOY\u000eSHELL\u000ejNIbRIDGE".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ ' ');
        }
        String str = new String(charArray);
        char[] charArray2 = "CLINIT".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ ' ');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean eu(Context context) {
        a aVar = bja;
        if (aVar == null || ap.L(aVar.bjc) || ap.L(bja.bjd) || !a(context, bja)) {
            return false;
        }
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (a(stackTraceElement, bja)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(Context context, a aVar) {
        String name = context.getClass().getName();
        Iterator it = new CopyOnWriteArrayList(aVar.bjc).iterator();
        while (it.hasNext()) {
            if (ap.a((String) it.next(), name)) {
                com.kwad.sdk.core.d.c.d("WrapperBlackHelper", "isBlackClass");
                return true;
            }
        }
        return false;
    }

    private static boolean a(StackTraceElement stackTraceElement, a aVar) {
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        Iterator it = new CopyOnWriteArrayList(aVar.bjd).iterator();
        while (it.hasNext()) {
            a.C0386a c0386a = (a.C0386a) it.next();
            String str = c0386a.bje;
            String str2 = c0386a.bjf;
            if (ap.a(str, className) && ap.a(str2, methodName)) {
                com.kwad.sdk.core.d.c.d("WrapperBlackHelper", "isBlackMethod");
                return true;
            }
        }
        return false;
    }
}
