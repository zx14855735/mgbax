package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaaa;

import ADYaiT.CtFAbx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class aaaoaaaa {
    private final String[] aaaaaaaa;

    public aaaoaaaa(aaaaaaaa aaaaaaaaVar) {
        List list = aaaaaaaaVar.aaaaaaaa;
        this.aaaaaaaa = (String[]) list.toArray(new String[list.size()]);
    }

    public String aaaaaaa0(String str) {
        return aaaaaaaa(this.aaaaaaaa, str);
    }

    public String aaaaaaaa(int i) {
        return this.aaaaaaaa[i * 2];
    }

    public List aaaaaaao(String str) {
        int aaaaaaa0 = aaaaaaa0();
        ArrayList arrayList = null;
        for (int i = 0; i < aaaaaaa0; i++) {
            if (str.equalsIgnoreCase(aaaaaaaa(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(aaaaaaa0(i));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.EMPTY_LIST;
    }

    public boolean equals(Object obj) {
        return (obj instanceof aaaoaaaa) && Arrays.equals(((aaaoaaaa) obj).aaaaaaaa, this.aaaaaaaa);
    }

    public int hashCode() {
        return Arrays.hashCode(this.aaaaaaaa);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int aaaaaaa0 = aaaaaaa0();
        for (int i = 0; i < aaaaaaa0; i++) {
            sb.append(aaaaaaaa(i));
            sb.append(": ");
            sb.append(aaaaaaa0(i));
            sb.append("\n");
        }
        return sb.toString();
    }

    public static final class aaaaaaaa {
        final List aaaaaaaa = new ArrayList(20);

        public aaaaaaaa aaaaaaa0(String str, String str2) {
            this.aaaaaaaa.add(str);
            this.aaaaaaaa.add(str2.trim());
            return this;
        }

        public aaaaaaaa aaaaaaaa(String str) {
            int indexOf = str.indexOf(":", 1);
            return indexOf != -1 ? aaaaaaa0(str.substring(0, indexOf), str.substring(indexOf + 1)) : str.startsWith(":") ? aaaaaaa0("", str.substring(1)) : aaaaaaa0("", str);
        }

        public aaaaaaaa aaaaaaao(String str, String str2) {
            aaaoaaaa.aaaaaaaa(str);
            aaaoaaaa.aaaaaaaa(str2, str);
            aaaaaaa0(str);
            aaaaaaa0(str, str2);
            return this;
        }

        public aaaaaaaa aaaaaaa0(String str) {
            int i = 0;
            while (i < this.aaaaaaaa.size()) {
                if (str.equalsIgnoreCase((String) this.aaaaaaaa.get(i))) {
                    this.aaaaaaaa.remove(i);
                    this.aaaaaaaa.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public aaaaaaaa aaaaaaaa(String str, String str2) {
            aaaoaaaa.aaaaaaaa(str);
            aaaoaaaa.aaaaaaaa(str2, str);
            return aaaaaaa0(str, str2);
        }

        public aaaoaaaa aaaaaaaa() {
            return new aaaoaaaa(this);
        }
    }

    public int aaaaaaa0() {
        return this.aaaaaaaa.length / 2;
    }

    public aaaaaaaa aaaaaaaa() {
        aaaaaaaa aaaaaaaaVar = new aaaaaaaa();
        Collections.addAll(aaaaaaaaVar.aaaaaaaa, this.aaaaaaaa);
        return aaaaaaaaVar;
    }

    public String aaaaaaa0(int i) {
        return this.aaaaaaaa[(i * 2) + 1];
    }

    private static String aaaaaaaa(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static void aaaaaaaa(String str) {
        if (str != null) {
            if (!str.isEmpty()) {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt <= ' ' || charAt >= 127) {
                        throw new IllegalArgumentException(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                    }
                }
                return;
            }
            throw new IllegalArgumentException("name is empty");
        }
        throw new NullPointerException("name == null");
    }

    public static void aaaaaaaa(String str, String str2) {
        if (str != null) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if ((charAt <= 31 && charAt != '\t') || charAt >= 127) {
                    throw new IllegalArgumentException(io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaa0.aaaaaaao.aaaaaaaa("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(charAt), Integer.valueOf(i), str2, str));
                }
            }
            return;
        }
        throw new NullPointerException(CtFAbx.BI9f7h("value for name ", str2, " == null"));
    }
}
