package io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaaaua.aaaaaaae;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class aaaaaaaa {
    private static aaaaaaaa aaaaaaao;
    private final String aaaaaaaa = "UNIAPP_HostPicker_0817";
    private final String aaaaaaa0 = "SP_LAST_SUIT_HOST_NAME_0817";

    public interface aaaaaaa0 {
        boolean aaaaaaa0(C0530aaaaaaaa c0530aaaaaaaa);

        void aaaaaaaa();

        void aaaaaaaa(C0530aaaaaaaa c0530aaaaaaaa);
    }

    /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
    public static class C0530aaaaaaaa implements Comparable, Cloneable {
        EnumC0531aaaaaaaa aaaaaaa0;
        String aaaaaaaa;

        /* renamed from: io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaaaauaa.aaaaaaaa$aaaaaaaa$aaaaaaaa, reason: collision with other inner class name */
        public enum EnumC0531aaaaaaaa {
            NORMAL(0),
            FIRST(1),
            BACKUP(-1);

            int aaaaaaaa;

            static {
                kaMVp();
            }

            EnumC0531aaaaaaaa(int i) {
                this.aaaaaaaa = i;
            }

            private static /* synthetic */ void kaMVp() {
                char[] charArray = "txz9pvzr9uxn9d\u007fr{{9]y~Ue~spr".toCharArray();
                int length = charArray.length;
                for (int i = 0; i < length; i++) {
                    charArray[i] = (char) (charArray[i] ^ 23);
                }
                String str = new String(charArray);
                char[] charArray2 = "t{~y~c".toCharArray();
                int length2 = charArray2.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    charArray2[i2] = (char) (charArray2[i2] ^ 23);
                }
                Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, new Object[0]);
            }
        }

        public C0530aaaaaaaa(String str, EnumC0531aaaaaaaa enumC0531aaaaaaaa) {
            EnumC0531aaaaaaaa enumC0531aaaaaaaa2 = EnumC0531aaaaaaaa.NORMAL;
            this.aaaaaaaa = str;
            this.aaaaaaa0 = enumC0531aaaaaaaa;
        }

        public boolean aaaaaaa0() {
            return !TextUtils.isEmpty(this.aaaaaaaa);
        }

        public String aaaaaaaa() {
            String str = "";
            if (TextUtils.isEmpty(this.aaaaaaaa)) {
                return "";
            }
            try {
                str = new String(Base64.decode(this.aaaaaaaa.getBytes("UTF-8"), 2), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return aaaaaaae.aaaaaaac(str);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0530aaaaaaaa)) {
                return false;
            }
            C0530aaaaaaaa c0530aaaaaaaa = (C0530aaaaaaaa) obj;
            if (TextUtils.isEmpty(c0530aaaaaaaa.aaaaaaaa)) {
                return false;
            }
            return c0530aaaaaaaa.aaaaaaaa.equals(this.aaaaaaaa);
        }

        public int hashCode() {
            return this.aaaaaaaa.hashCode();
        }

        public String toString() {
            return "Host{hostUrl='" + this.aaaaaaaa + "', priority=" + this.aaaaaaa0 + '}';
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public C0530aaaaaaaa m22clone() {
            return new C0530aaaaaaaa(this.aaaaaaaa, this.aaaaaaa0);
        }

        @Override // java.lang.Comparable
        /* renamed from: aaaaaaaa, reason: merged with bridge method [inline-methods] */
        public int compareTo(C0530aaaaaaaa c0530aaaaaaaa) {
            if (c0530aaaaaaaa == null) {
                return 1;
            }
            return c0530aaaaaaaa.aaaaaaa0.aaaaaaaa - this.aaaaaaa0.aaaaaaaa;
        }
    }

    private aaaaaaaa() {
    }

    private void aaaaaaaa(Context context, List list, String str) {
        String BChYOn2 = CtFAbx.BChYOn("SP_LAST_SUIT_HOST_NAME_0817", str);
        SharedPreferences sharedPreferences = context.getSharedPreferences("UNIAPP_HostPicker_0817", 0);
        String string = sharedPreferences.getString(BChYOn2, "");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0530aaaaaaaa c0530aaaaaaaa = (C0530aaaaaaaa) it.next();
            if (!c0530aaaaaaaa.aaaaaaa0()) {
                throw new RuntimeException("error format host");
            }
            if (!TextUtils.isEmpty(string)) {
                if (string.equals(c0530aaaaaaaa.aaaaaaaa)) {
                    c0530aaaaaaaa.aaaaaaa0 = C0530aaaaaaaa.EnumC0531aaaaaaaa.FIRST;
                } else {
                    c0530aaaaaaaa.aaaaaaa0 = C0530aaaaaaaa.EnumC0531aaaaaaaa.NORMAL;
                }
            }
        }
        sharedPreferences.edit().remove(BChYOn2).apply();
    }

    public static aaaaaaaa aaaaaaaa() {
        if (aaaaaaao == null) {
            synchronized (aaaaaaaa.class) {
                try {
                    if (aaaaaaao == null) {
                        aaaaaaao = new aaaaaaaa();
                    }
                } finally {
                }
            }
        }
        return aaaaaaao;
    }

    public void aaaaaaaa(Context context, List list, String str, aaaaaaa0 aaaaaaa0Var) {
        if (list != null && !list.isEmpty()) {
            aaaaaaaa(context, list, str);
            Collections.sort(list);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C0530aaaaaaaa c0530aaaaaaaa = (C0530aaaaaaaa) it.next();
                if (aaaaaaa0Var.aaaaaaa0(c0530aaaaaaaa)) {
                    if (c0530aaaaaaaa.aaaaaaa0 != C0530aaaaaaaa.EnumC0531aaaaaaaa.BACKUP) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences("UNIAPP_HostPicker_0817", 0);
                        sharedPreferences.edit().putString(CtFAbx.BChYOn("SP_LAST_SUIT_HOST_NAME_0817", str), c0530aaaaaaaa.aaaaaaaa).apply();
                    }
                    aaaaaaa0Var.aaaaaaaa(c0530aaaaaaaa);
                    return;
                }
            }
            aaaaaaa0Var.aaaaaaaa();
            return;
        }
        throw new RuntimeException("call initHosts first");
    }
}
