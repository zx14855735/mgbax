package Hjvs0g;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AmA8tU {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final Map f3726ADYaiT;

    /* renamed from: A2egSU, reason: collision with root package name */
    public boolean f3727A2egSU = true;

    /* renamed from: A4TApA, reason: collision with root package name */
    public Map f3728A4TApA = f3726ADYaiT;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f3729A5SV6n = true;

    static {
        String property = System.getProperty("http.agent");
        if (!TextUtils.isEmpty(property)) {
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            property = sb.toString();
        }
        HashMap hashMap = new HashMap(2);
        if (!TextUtils.isEmpty(property)) {
            hashMap.put("User-Agent", Collections.singletonList(new AzWtSf(property)));
        }
        f3726ADYaiT = Collections.unmodifiableMap(hashMap);
        ESmtd();
    }

    private static /* synthetic */ void ESmtd() {
        char[] charArray = "fjh+bdh`+gj|+vm`ii+OklGwlab`".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 5);
        }
        String str = new String(charArray);
        char[] charArray2 = "filklq".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 5);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A2egSU(String str, String str2) {
        AzWtSf azWtSf = new AzWtSf(str2);
        if (!this.f3729A5SV6n || !"User-Agent".equalsIgnoreCase(str)) {
            A4TApA();
            List list = (List) this.f3728A4TApA.get(str);
            if (list == null) {
                list = new ArrayList();
                this.f3728A4TApA.put(str, list);
            }
            list.add(azWtSf);
            return;
        }
        A4TApA();
        List list2 = (List) this.f3728A4TApA.get(str);
        if (list2 == null) {
            list2 = new ArrayList();
            this.f3728A4TApA.put(str, list2);
        }
        list2.clear();
        list2.add(azWtSf);
        if (this.f3729A5SV6n && "User-Agent".equalsIgnoreCase(str)) {
            this.f3729A5SV6n = false;
        }
    }

    public final void A4TApA() {
        if (this.f3727A2egSU) {
            this.f3727A2egSU = false;
            HashMap hashMap = new HashMap(this.f3728A4TApA.size());
            for (Map.Entry entry : this.f3728A4TApA.entrySet()) {
                hashMap.put(entry.getKey(), new ArrayList((Collection) entry.getValue()));
            }
            this.f3728A4TApA = hashMap;
        }
    }
}
