package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau;

import com.sigmob.sdk.base.e;
import com.sigmob.sdk.downloader.core.c;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaca;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaaea;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaacaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaoaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaacaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaoaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaaaeaa;
import java.lang.reflect.Method;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaaaaaa implements aaaaaoaa {
    private static final Comparator aaaaaaa0 = new C0521aaaaaaaa();
    private final aaaaaaea aaaaaaaa;

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaau.aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
    public class C0521aaaaaaaa implements Comparator {
        @Override // java.util.Comparator
        /* renamed from: aaaaaaaa, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            if (str == str2) {
                return 0;
            }
            if (str == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
        }
    }

    static {
        iddqL();
    }

    public aaaaaaaa(aaaaaaea aaaaaaeaVar) {
        this.aaaaaaaa = aaaaaaeaVar;
    }

    public static Map aaaaaaaa(aaaoaaaa aaaoaaaaVar, String str) {
        TreeMap treeMap = new TreeMap(aaaaaaa0);
        int aaaaaaa02 = aaaoaaaaVar.aaaaaaa0();
        for (int i = 0; i < aaaaaaa02; i++) {
            String aaaaaaaa = aaaoaaaaVar.aaaaaaaa(i);
            String aaaaaaa03 = aaaoaaaaVar.aaaaaaa0(i);
            ArrayList arrayList = new ArrayList();
            List list = (List) treeMap.get(aaaaaaaa);
            if (list != null) {
                arrayList.addAll(list);
            }
            arrayList.add(aaaaaaa03);
            treeMap.put(aaaaaaaa, Collections.unmodifiableList(arrayList));
        }
        if (str != null) {
            treeMap.put(null, Collections.unmodifiableList(Collections.singletonList(str)));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    private static /* synthetic */ void iddqL() {
        char[] charArray = "BNL\u000fF@LD\u000fCNX\u000fRIDMM\u000fkOHcSHEFD".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '!');
        }
        String str = new String(charArray);
        char[] charArray2 = "BMHOHU".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '!');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void aaaaaaaa(aaaacaaa.aaaaaaaa aaaaaaaaVar, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (e.f13172a.equalsIgnoreCase(str) || "Cookie2".equalsIgnoreCase(str)) {
                if (!((List) entry.getValue()).isEmpty()) {
                    aaaaaaaaVar.aaaaaaaa(str, aaaaaaaa((List) entry.getValue()));
                }
            }
        }
    }

    public static String aaaaaaaa(List list) {
        if (list.size() == 1) {
            return (String) list.get(0);
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            sb.append((String) list.get(i));
        }
        return sb.toString();
    }

    @Override // io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa.aaaaaoaa
    public aaaaaaca aaaaaaaa(aaaaaoaa.aaaaaaaa aaaaaaaaVar) {
        aaaacaaa aaaaaaac = aaaaaaaaVar.aaaaaaac();
        aaaacaaa.aaaaaaaa aaaaaaan = aaaaaaac.aaaaaaan();
        aaaaacaa aaaaaaaa = aaaaaaac.aaaaaaaa();
        if (aaaaaaaa != null) {
            aaaaaaaa.aaaaaaa0();
            long aaaaaaaa2 = aaaaaaaa.aaaaaaaa();
            if (aaaaaaaa2 != -1) {
                aaaaaaan.aaaaaaa0(c.e, Long.toString(aaaaaaaa2));
                aaaaaaan.aaaaaaaa(c.h);
            } else {
                aaaaaaan.aaaaaaa0(c.h, "chunked");
                aaaaaaan.aaaaaaaa(c.e);
            }
        }
        boolean z = false;
        if (aaaaaaac.aaaaaaaa("Host") == null) {
            aaaaaaan.aaaaaaa0("Host", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa(aaaaaaac.aaaaaaae(), false));
        }
        if (aaaaaaac.aaaaaaaa("Connection") == null) {
            aaaaaaan.aaaaaaa0("Connection", "Keep-Alive");
        }
        if (aaaaaaac.aaaaaaaa("Accept-Encoding") == null && aaaaaaac.aaaaaaaa(c.b) == null) {
            aaaaaaan.aaaaaaa0("Accept-Encoding", "gzip");
            z = true;
        }
        String aaaaaaaa3 = aaaaaaac.aaaaaaaa("cookie");
        if (aaaaaaaa3 == null) {
            CookieHandler cookieHandler = CookieHandler.getDefault();
            if (cookieHandler != null) {
                try {
                    aaaaaaaa(aaaaaaan, cookieHandler.get(aaaaaaac.aaaaaaae().eaaaaaaa(), aaaaaaaa(aaaaaaac.aaaaaaao(), (String) null)));
                } catch (Exception unused) {
                }
            }
        } else {
            aaaaaaan.aaaaaaa0(e.f13172a, aaaaaaaa3);
        }
        if (aaaaaaac.aaaaaaaa("User-Agent") == null) {
            aaaaaaan.aaaaaaa0("User-Agent", io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaac.aaaaaaaa());
        }
        aaaaaaca aaaaaaaa4 = aaaaaaaaVar.aaaaaaaa(aaaaaaan.aaaaaaaa());
        try {
            CookieHandler cookieHandler2 = CookieHandler.getDefault();
            if (cookieHandler2 != null) {
                cookieHandler2.put(aaaaaaac.aaaaaaae().eaaaaaaa(), aaaaaaaa(aaaaaaaa4.aaaaaaea(), (String) null));
            }
        } catch (Exception unused2) {
        }
        aaaaaaau.aaaaaaaa(this.aaaaaaaa, aaaaaaac.aaaaaaae(), aaaaaaaa4.aaaaaaea());
        aaaaaaca.aaaaaaaa aaaaaaaa5 = aaaaaaaa4.eaaaaaaa().aaaaaaaa(aaaaaaac);
        if (z && "gzip".equalsIgnoreCase(aaaaaaaa4.aaaaaaa0("Content-Encoding")) && aaaaaaau.aaaaaaa0(aaaaaaaa4)) {
            io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaeaaaa aaaeaaaaVar = new io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaeaa.aaaeaaaa(aaaaaaaa4.aaaaaaeo().aaaaeaaa());
            aaaaaaaa5.aaaaaaaa(aaaaaaaa4.aaaaaaea().aaaaaaaa().aaaaaaa0("Content-Encoding").aaaaaaa0(c.e).aaaaaaaa());
            aaaaaaaa5.aaaaaaaa(new aaaaaaav(aaaaaaaa4.aaaaaaa0("Content-Type"), -1L, aaaaaeaa.aaaaaaaa(aaaeaaaaVar)));
        }
        return aaaaaaaa5.aaaaaaaa();
    }
}
