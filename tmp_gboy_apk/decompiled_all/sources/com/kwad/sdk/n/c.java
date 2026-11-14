package com.kwad.sdk.n;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.n.a.b;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.z;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {
    public static final String TAG = "Ranger_c";
    private String value;

    public static class a {
        private static final c bbZ = new c(0);

        static {
            ydBVou();
        }

        private static /* synthetic */ void ydBVou() {
            char[] charArray = "Q]_\u001cUS_W\u001cP]K\u001cAZW^^\u001cx\\[p@[VUW".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '2');
            }
            String str = new String(charArray);
            char[] charArray2 = "Q^[\\[F".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '2');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private c() {
    }

    public static c QK() {
        return a.bbZ;
    }

    public static /* synthetic */ com.kwad.sdk.n.b.a.d a(c cVar, String str, String str2) {
        return ao(str, str2);
    }

    private static com.kwad.sdk.n.b.a.d ao(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        com.kwad.sdk.n.b.a.d dVar = new com.kwad.sdk.n.b.a.d();
        dVar.name = str;
        dVar.bcM = str2;
        return dVar;
    }

    private Object b(com.kwad.sdk.n.a.b bVar) {
        Class<?> cls;
        if (bVar.bct.bcC) {
            try {
                if (TextUtils.isEmpty(bVar.bcp)) {
                    Object obj = bVar.bco;
                    cls = obj != null ? obj.getClass() : null;
                } else {
                    cls = Class.forName(bVar.bcp);
                }
                if (cls != null) {
                    return a(bVar, true, cls);
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e));
            }
        } else if (bVar.bco != null) {
            return a(bVar, false, (Class<?>) null);
        }
        return null;
    }

    private static String p(Object obj) {
        if (obj != null) {
            return String.valueOf(obj);
        }
        com.kwad.sdk.core.d.c.w(TAG, "value is null by ob null");
        return "";
    }

    public final void c(d dVar) {
        List<com.kwad.sdk.n.a.b> list;
        if (dVar == null || (list = dVar.bcc) == null || list.isEmpty()) {
            return;
        }
        final List<com.kwad.sdk.n.a.b> list2 = dVar.bcc;
        h.schedule(new bg() { // from class: com.kwad.sdk.n.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ArrayList arrayList = new ArrayList();
                for (com.kwad.sdk.n.a.b bVar : list2) {
                    if (bVar != null && !TextUtils.isEmpty(bVar.bcs)) {
                        String str = bVar.bcs;
                        c cVar = c.this;
                        cVar.value = cVar.a(bVar);
                        c cVar2 = c.this;
                        com.kwad.sdk.n.b.a.d a2 = c.a(cVar2, str, cVar2.value);
                        if (a2 != null) {
                            arrayList.add(a2);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                com.kwad.sdk.n.b.a.e eVar = new com.kwad.sdk.n.b.a.e();
                eVar.bcN = arrayList;
                com.kwad.sdk.n.b.a.a(eVar);
            }
        }, 20L, TimeUnit.SECONDS);
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    private static Object c(com.kwad.sdk.n.a.b bVar) {
        if (bVar.bcr) {
            try {
                return z.c(Class.forName(bVar.bcp), bVar.bcq);
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e));
                return null;
            }
        }
        Object obj = bVar.bco;
        if (obj != null) {
            return z.getField(obj, bVar.bcq);
        }
        return null;
    }

    public final String a(com.kwad.sdk.n.a.b bVar) {
        com.kwad.sdk.n.a.b bVar2 = bVar.bcu;
        if (bVar2 != null && !bVar2.QQ()) {
            if (!TextUtils.isEmpty(bVar.bcq)) {
                bVar.bcu.bco = c(bVar);
            } else {
                b.C0384b c0384b = bVar.bct;
                if (c0384b != null && !c0384b.QQ()) {
                    bVar.bcu.bco = b(bVar);
                }
            }
            return a(bVar.bcu);
        }
        if (!TextUtils.isEmpty(bVar.bcq)) {
            return p(c(bVar));
        }
        b.C0384b c0384b2 = bVar.bct;
        if (c0384b2 != null && !c0384b2.QQ()) {
            return p(b(bVar));
        }
        com.kwad.sdk.core.d.c.d(TAG, "node.nodeClassName:" + bVar.bcp);
        return z.classExists(bVar.bcp) ? "true" : "false";
    }

    private static Object a(com.kwad.sdk.n.a.b bVar, boolean z, Class<?> cls) {
        Object[] QT = bVar.bct.QT();
        if (QT == null || QT.length == 0) {
            if (z) {
                return z.callStaticMethod(cls, bVar.bct.name, new Object[0]);
            }
            return z.callMethod(bVar.bco, bVar.bct.name, new Object[0]);
        }
        if (z) {
            return z.callStaticMethod(cls, bVar.bct.name, QT);
        }
        return z.callMethod(bVar.bco, bVar.bct.name, QT);
    }
}
