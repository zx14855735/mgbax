package com.bykv.vk.openvk.component.video.xj.hf;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class pl {
    private final int c;
    private int kd = -1;
    private final int u;
    private final ArrayList<xj> w;
    private int y;
    private static final Set<String> xj = new HashSet();
    private static final Set<String> hf = new HashSet();

    public class xj {
        int hf;
        final String xj;

        public xj(String str) {
            this.xj = str;
        }

        public void hf() {
            pl.hf.add(this.xj);
        }

        public String toString() {
            return this.xj;
        }

        public void xj() {
            pl.xj.add(this.xj);
        }
    }

    static {
        eypHLU();
    }

    public pl(List<String> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("urls can't be empty");
        }
        int size = list.size();
        this.u = size;
        this.w = new ArrayList<>(size);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (String str : list) {
            xj xjVar = new xj(str);
            if (xj.contains(str)) {
                arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                arrayList2.add(xjVar);
            } else if (hf.contains(str)) {
                arrayList = arrayList == null ? new ArrayList() : arrayList;
                arrayList.add(xjVar);
            } else {
                this.w.add(xjVar);
            }
        }
        if (arrayList != null) {
            this.w.addAll(arrayList);
        }
        if (arrayList2 != null) {
            this.w.addAll(arrayList2);
        }
        Integer num = kd.d;
        this.c = (num == null || num.intValue() <= 0) ? this.u >= 2 ? 1 : 2 : num.intValue();
    }

    private static /* synthetic */ void eypHLU() {
        char[] charArray = ", \"a(.\"*a- 6a<'*##a\u0005!&\r=&+(*".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'O');
        }
        String str = new String(charArray);
        char[] charArray2 = ",#&!&;".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'O');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public xj hf() {
        if (!xj()) {
            throw new NoSuchElementException();
        }
        int i = this.kd + 1;
        if (i >= this.u - 1) {
            this.kd = -1;
            this.y++;
        } else {
            this.kd = i;
        }
        xj xjVar = this.w.get(i);
        xjVar.hf = (this.y * this.u) + this.kd;
        return xjVar;
    }

    public boolean xj() {
        return this.y < this.c;
    }

    public pl(String str) {
        ArrayList<xj> arrayList = new ArrayList<>(1);
        this.w = arrayList;
        arrayList.add(new xj(str));
        this.u = 1;
        this.c = 1;
    }
}
