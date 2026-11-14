package com.bytedance.sdk.openadsdk.core.kd.u;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.f;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class y {
    private static final Map<String, AtomicBoolean> w = new ConcurrentHashMap();
    private final com.bytedance.sdk.openadsdk.core.kd.u.hf hf;
    xj xj;

    /* renamed from: com.bytedance.sdk.openadsdk.core.kd.u.y$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] xj;

        static {
            int[] iArr = new int[xj.w.values().length];
            xj = iArr;
            try {
                iArr[xj.w.KV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xj[xj.w.DB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class hf {
        public long hf;
        public String kd;
        public int u = 7132;
        public String w;
        public long xj;

        public hf(String str, long j, long j2, String str2) {
            this.xj = j;
            this.hf = j2;
            this.w = str;
            this.kd = str2;
        }

        public boolean xj() {
            return (TextUtils.isEmpty(this.w) || this.xj == 0) ? false : true;
        }
    }

    public static class xj {
        private final int hf;
        private final w kd;
        private final int u;
        private final boolean w;
        private final String xj;
        private final hf y;

        public enum hf {
            Random,
            TimeLast,
            CustomPriority;

            static {
                bjZTske();
            }

            private static /* synthetic */ void bjZTske() {
                char[] charArray = "yuw4}{w\u007f4xuc4ir\u007fvv4PtsXhs~}\u007f".toCharArray();
                int length = charArray.length;
                for (int i = 0; i < length; i++) {
                    charArray[i] = (char) (charArray[i] ^ 26);
                }
                String str = new String(charArray);
                char[] charArray2 = "yvstsn".toCharArray();
                int length2 = charArray2.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    charArray2[i2] = (char) (charArray2[i2] ^ 26);
                }
                Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, new Object[0]);
            }

            public static hf xj(int i) {
                return i != 0 ? i != 2 ? TimeLast : CustomPriority : Random;
            }
        }

        public enum w {
            KV,
            DB;

            static {
                pkpWE();
            }

            private static /* synthetic */ void pkpWE() {
                char[] charArray = "yuw4}{w\u007f4xuc4ir\u007fvv4PtsXhs~}\u007f".toCharArray();
                int length = charArray.length;
                for (int i = 0; i < length; i++) {
                    charArray[i] = (char) (charArray[i] ^ 26);
                }
                String str = new String(charArray);
                char[] charArray2 = "yvstsn".toCharArray();
                int length2 = charArray2.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    charArray2[i2] = (char) (charArray2[i2] ^ 26);
                }
                Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, new Object[0]);
            }

            public static w xj(int i) {
                return i != 1 ? DB : KV;
            }
        }

        /* renamed from: com.bytedance.sdk.openadsdk.core.kd.u.y$xj$xj, reason: collision with other inner class name */
        public static class C0171xj {
            private int hf;
            private String xj = "Default";
            private boolean w = true;
            private int u = 1;
            private w kd = w.DB;
            private hf y = hf.TimeLast;

            public C0171xj xj(String str) {
                this.xj = str;
                return this;
            }

            public C0171xj xj(boolean z) {
                this.w = z;
                return this;
            }

            public C0171xj xj(w wVar) {
                this.kd = wVar;
                return this;
            }

            public C0171xj xj(hf hfVar) {
                this.y = hfVar;
                return this;
            }

            public C0171xj xj(int i) {
                this.u = i;
                return this;
            }

            public xj xj() {
                return new xj(this);
            }
        }

        public boolean hf() {
            return this.w;
        }

        public hf u() {
            return this.y;
        }

        public int w() {
            return this.u;
        }

        private xj(C0171xj c0171xj) {
            this.xj = c0171xj.xj;
            this.hf = c0171xj.hf;
            this.w = c0171xj.w;
            this.kd = c0171xj.kd;
            this.y = c0171xj.y;
            this.u = c0171xj.u;
        }

        public String xj() {
            return this.xj;
        }
    }

    static {
        JwpNxuh();
    }

    public y(int i) {
        xj xj2 = xj(i);
        this.xj = xj2;
        if (AnonymousClass3.xj[xj2.kd.ordinal()] != 1) {
            this.hf = new w();
        } else {
            this.hf = new u();
        }
    }

    private static /* synthetic */ void JwpNxuh() {
        char[] charArray = "vzx;rtxp;wzl;f}pyy;_{|Wg|qrp".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 21);
        }
        String str = new String(charArray);
        char[] charArray2 = "vy|{|a".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 21);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private AtomicBoolean u(String str) {
        Map<String, AtomicBoolean> map = w;
        if (!map.containsKey(str)) {
            map.put(str, new AtomicBoolean(false));
        }
        return map.get(str);
    }

    public void hf(String str) {
        try {
            this.hf.xj(str, this.xj, pz.hf().xk() ? new com.bytedance.sdk.openadsdk.core.kd.u.xj() { // from class: com.bytedance.sdk.openadsdk.core.kd.u.y.2
                @Override // com.bytedance.sdk.openadsdk.core.kd.u.xj
                public void xj(hf hfVar) {
                    try {
                        ws xj2 = com.bytedance.sdk.openadsdk.core.xj.xj(new JSONObject(com.bytedance.sdk.component.utils.xj.w(hfVar.w)));
                        xj2.rz().u(2);
                        com.bytedance.sdk.openadsdk.core.am.u.w(xj2, "embeded_ad");
                    } catch (Exception unused) {
                    }
                }
            } : null);
        } catch (Throwable unused) {
        }
    }

    public void w(String str) {
        try {
            if (u(str).compareAndSet(false, true)) {
                System.currentTimeMillis();
                this.hf.hf(str);
                System.currentTimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void xj(String str, hf hfVar, boolean z, long j) {
        try {
            this.hf.xj(str, hfVar, z, j, this.xj, pz.hf().co() ? new com.bytedance.sdk.openadsdk.core.kd.u.xj() { // from class: com.bytedance.sdk.openadsdk.core.kd.u.y.1
                @Override // com.bytedance.sdk.openadsdk.core.kd.u.xj
                public void xj(hf hfVar2) {
                    try {
                        ws xj2 = com.bytedance.sdk.openadsdk.core.xj.xj(new JSONObject(com.bytedance.sdk.component.utils.xj.w(hfVar2.w)));
                        xj2.rz().u(3);
                        com.bytedance.sdk.openadsdk.core.am.u.w(xj2, "embeded_ad");
                    } catch (Exception unused) {
                    }
                }
            } : null);
        } catch (Throwable unused) {
        }
    }

    public hf xj(String str, boolean z, long j) {
        hf xj2;
        try {
            synchronized (u(str)) {
                try {
                    System.currentTimeMillis();
                    xj2 = this.hf.xj(str, this.xj, j);
                    if (xj2 != null && xj2.xj()) {
                        if (z) {
                            this.hf.xj(str, xj2.kd, true);
                        }
                        System.currentTimeMillis();
                    }
                } finally {
                }
            }
            return xj2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public List<hf> xj(String str, boolean z, long j, int i) {
        String str2;
        ArrayList arrayList = new ArrayList();
        try {
            synchronized (u(str)) {
                try {
                    System.currentTimeMillis();
                    ArrayList arrayList2 = new ArrayList();
                    int i2 = 0;
                    while (true) {
                        if (i2 < i) {
                            str2 = str;
                            long j2 = j;
                            hf xj2 = this.hf.xj(str2, this.xj, j2, arrayList2);
                            if (xj2 == null || !xj2.xj()) {
                                break;
                            }
                            arrayList2.add(xj2.kd);
                            arrayList.add(xj2);
                            i2++;
                            str = str2;
                            j = j2;
                        } else {
                            str2 = str;
                            break;
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        hf hfVar = (hf) it.next();
                        if (z) {
                            this.hf.xj(str2, hfVar.kd, true);
                        }
                        System.currentTimeMillis();
                    }
                } finally {
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return arrayList;
        }
    }

    public hf xj(String str, long j, List<String> list) {
        hf xj2;
        try {
            synchronized (u(str)) {
                try {
                    System.currentTimeMillis();
                    xj2 = this.hf.xj(str, this.xj, j, list);
                    if (xj2 != null && xj2.xj()) {
                        System.currentTimeMillis();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return xj2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void xj() {
        try {
            this.hf.xj(this.xj);
        } catch (Throwable unused) {
        }
    }

    public void xj(String str) {
        try {
            this.hf.xj(str);
        } catch (Throwable unused) {
        }
    }

    public void xj(String str, String str2, boolean z) {
        try {
            synchronized (u(str)) {
                this.hf.xj(str, str2, z);
            }
        } catch (Throwable unused) {
        }
    }

    public void xj(String str, String str2) {
        try {
            synchronized (u(str)) {
                this.hf.xj(str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    private xj xj(int i) {
        String str;
        f.hf xj2 = f.xj(i);
        switch (i) {
            case 1:
                str = "Banner";
                break;
            case 2:
            default:
                str = "Default";
                break;
            case 3:
            case 4:
                str = ExploreConstants.SCENE_SPLASH;
                break;
            case 5:
                str = ExploreConstants.SCENE_FEED;
                break;
            case 6:
                str = "Stream";
                break;
            case 7:
                str = ExploreConstants.SCENE_REWARD;
                break;
            case 8:
                str = ExploreConstants.SCENE_FULL;
                break;
            case 9:
                str = "Draw";
                break;
        }
        if (xj2 == null) {
            return new xj.C0171xj().xj();
        }
        return new xj.C0171xj().xj(str).xj((i == 3 || i == 4) ? false : true).xj(xj.w.xj(xj2.kd())).xj(xj.hf.xj(xj2.hf())).xj(xj2.w()).xj();
    }
}
