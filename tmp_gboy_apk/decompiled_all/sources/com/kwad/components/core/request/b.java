package com.kwad.components.core.request;

import com.kwad.sdk.service.ServiceProvider;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class b {
    private final List<a> aaJ;

    public interface a {
        void tG();
    }

    /* renamed from: com.kwad.components.core.request.b$b, reason: collision with other inner class name */
    public static class C0311b {
        private static final b aaK = new b(0);

        static {
            UllC();
        }

        private static /* synthetic */ void UllC() {
            char[] charArray = "ôøú¹ðöúò¹õøî¹äÿòûû¹ÝùþÕåþóðò".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 151);
            }
            String str = new String(charArray);
            char[] charArray2 = "ôûþùþã".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 151);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static b tE() {
        return C0311b.aaK;
    }

    public final void a(a aVar) {
        this.aaJ.add(aVar);
    }

    public final void b(a aVar) {
        this.aaJ.remove(aVar);
    }

    public final void tF() {
        for (a aVar : this.aaJ) {
            if (aVar != null) {
                try {
                    aVar.tG();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }
    }

    private b() {
        this.aaJ = new CopyOnWriteArrayList();
    }
}
