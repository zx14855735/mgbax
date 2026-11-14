package com.bytedance.sdk.component.widget.recycler;

import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.xj.hf.u;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class am {
    final com.bytedance.sdk.component.widget.recycler.xj.hf.xj<RecyclerView.ra, xj> xj = new com.bytedance.sdk.component.widget.recycler.xj.hf.xj<>();
    final com.bytedance.sdk.component.widget.recycler.xj.hf.w<RecyclerView.ra> hf = new com.bytedance.sdk.component.widget.recycler.xj.hf.w<>();

    public interface hf {
        void hf(RecyclerView.ra raVar, RecyclerView.y.hf hfVar, RecyclerView.y.hf hfVar2);

        void w(RecyclerView.ra raVar, RecyclerView.y.hf hfVar, RecyclerView.y.hf hfVar2);

        void xj(RecyclerView.ra raVar);

        void xj(RecyclerView.ra raVar, RecyclerView.y.hf hfVar, RecyclerView.y.hf hfVar2);
    }

    public void c(RecyclerView.ra raVar) {
        int hf2 = this.hf.hf() - 1;
        while (true) {
            if (hf2 < 0) {
                break;
            }
            if (raVar == this.hf.w(hf2)) {
                this.hf.xj(hf2);
                break;
            }
            hf2--;
        }
        xj remove = this.xj.remove(raVar);
        if (remove != null) {
            xj.xj(remove);
        }
    }

    public void f(RecyclerView.ra raVar) {
        y(raVar);
    }

    public RecyclerView.y.hf hf(RecyclerView.ra raVar) {
        return xj(raVar, 4);
    }

    public void kd(RecyclerView.ra raVar) {
        xj xjVar = this.xj.get(raVar);
        if (xjVar == null) {
            xjVar = xj.xj();
            this.xj.put(raVar, xjVar);
        }
        xjVar.xj |= 1;
    }

    public boolean u(RecyclerView.ra raVar) {
        xj xjVar = this.xj.get(raVar);
        return (xjVar == null || (xjVar.xj & 4) == 0) ? false : true;
    }

    public RecyclerView.y.hf w(RecyclerView.ra raVar) {
        return xj(raVar, 8);
    }

    public void xj() {
        this.xj.clear();
        this.hf.w();
    }

    public void y(RecyclerView.ra raVar) {
        xj xjVar = this.xj.get(raVar);
        if (xjVar != null) {
            xjVar.xj &= -2;
        }
    }

    public static class xj {
        static u.xj<xj> u = new u.hf(20);
        RecyclerView.y.hf hf;
        RecyclerView.y.hf w;
        int xj;

        static {
            WLLoC();
        }

        private xj() {
        }

        private static /* synthetic */ void WLLoC() {
            char[] charArray = "úöô·þøôü·ûöà·êñüõõ·Ó÷ðÛëðýþü".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 153);
            }
            String str = new String(charArray);
            char[] charArray2 = "úõð÷ðí".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 153);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public static void hf() {
            while (u.xj() != null) {
            }
        }

        public static xj xj() {
            xj xj = u.xj();
            return xj == null ? new xj() : xj;
        }

        public static void xj(xj xjVar) {
            xjVar.xj = 0;
            xjVar.hf = null;
            xjVar.w = null;
            u.xj(xjVar);
        }
    }

    public void hf(RecyclerView.ra raVar, RecyclerView.y.hf hfVar) {
        xj xjVar = this.xj.get(raVar);
        if (xjVar == null) {
            xjVar = xj.xj();
            this.xj.put(raVar, xjVar);
        }
        xjVar.xj |= 2;
        xjVar.hf = hfVar;
    }

    public void w(RecyclerView.ra raVar, RecyclerView.y.hf hfVar) {
        xj xjVar = this.xj.get(raVar);
        if (xjVar == null) {
            xjVar = xj.xj();
            this.xj.put(raVar, xjVar);
        }
        xjVar.w = hfVar;
        xjVar.xj |= 8;
    }

    public void xj(RecyclerView.ra raVar, RecyclerView.y.hf hfVar) {
        xj xjVar = this.xj.get(raVar);
        if (xjVar == null) {
            xjVar = xj.xj();
            this.xj.put(raVar, xjVar);
        }
        xjVar.hf = hfVar;
        xjVar.xj |= 4;
    }

    public void hf() {
        xj.hf();
    }

    public boolean xj(RecyclerView.ra raVar) {
        xj xjVar = this.xj.get(raVar);
        return (xjVar == null || (xjVar.xj & 1) == 0) ? false : true;
    }

    private RecyclerView.y.hf xj(RecyclerView.ra raVar, int i) {
        xj hf2;
        RecyclerView.y.hf hfVar;
        int xj2 = this.xj.xj(raVar);
        if (xj2 >= 0 && (hf2 = this.xj.hf(xj2)) != null) {
            int i2 = hf2.xj;
            if ((i2 & i) != 0) {
                int i3 = (~i) & i2;
                hf2.xj = i3;
                if (i == 4) {
                    hfVar = hf2.hf;
                } else if (i == 8) {
                    hfVar = hf2.w;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i3 & 12) == 0) {
                    this.xj.w(xj2);
                    xj.xj(hf2);
                }
                return hfVar;
            }
        }
        return null;
    }

    public void xj(long j, RecyclerView.ra raVar) {
        this.hf.hf(j, raVar);
    }

    public RecyclerView.ra xj(long j) {
        return this.hf.xj(j);
    }

    public void xj(hf hfVar) {
        for (int size = this.xj.size() - 1; size >= 0; size--) {
            RecyclerView.ra xj2 = this.xj.xj(size);
            xj w = this.xj.w(size);
            int i = w.xj;
            if ((i & 3) == 3) {
                hfVar.xj(xj2);
            } else if ((i & 1) != 0) {
                RecyclerView.y.hf hfVar2 = w.hf;
                if (hfVar2 == null) {
                    hfVar.xj(xj2);
                } else {
                    hfVar.xj(xj2, hfVar2, w.w);
                }
            } else if ((i & 14) == 14) {
                hfVar.hf(xj2, w.hf, w.w);
            } else if ((i & 12) == 12) {
                hfVar.w(xj2, w.hf, w.w);
            } else if ((i & 4) != 0) {
                hfVar.xj(xj2, w.hf, null);
            } else if ((i & 8) != 0) {
                hfVar.hf(xj2, w.hf, w.w);
            }
            xj.xj(w);
        }
    }
}
