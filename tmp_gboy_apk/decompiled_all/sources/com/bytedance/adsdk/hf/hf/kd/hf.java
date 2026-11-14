package com.bytedance.adsdk.hf.hf.kd;

import com.bytedance.adsdk.hf.hf.hf.xj.am;
import com.bytedance.adsdk.hf.hf.hf.xj.d;
import com.bytedance.adsdk.hf.hf.hf.xj.e;
import com.bytedance.adsdk.hf.hf.hf.xj.f;
import com.bytedance.adsdk.hf.hf.hf.xj.g;
import com.bytedance.adsdk.hf.hf.hf.xj.kd;
import com.bytedance.adsdk.hf.hf.hf.xj.p;
import com.bytedance.adsdk.hf.hf.hf.xj.pl;
import com.bytedance.adsdk.hf.hf.hf.xj.v;
import com.bytedance.adsdk.hf.hf.hf.xj.y;
import com.bytedance.adsdk.hf.hf.hf.xj.yo;
import com.bytedance.adsdk.hf.hf.u.u;
import com.bytedance.adsdk.hf.hf.u.w;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {

    /* renamed from: com.bytedance.adsdk.hf.hf.kd.hf$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] xj;

        static {
            int[] iArr = new int[w.values().length];
            xj = iArr;
            try {
                iArr[w.MINUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                xj[w.PLUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                xj[w.DIVISION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                xj[w.MULTI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                xj[w.MOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                xj[w.EQ.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                xj[w.NOT_EQ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                xj[w.GT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                xj[w.LT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                xj[w.GT_EQ.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                xj[w.LT_EQ.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                xj[w.DOUBLE_AMP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                xj[w.DOUBLE_BAR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    private static Deque<com.bytedance.adsdk.hf.hf.hf.xj> hf(List<com.bytedance.adsdk.hf.hf.hf.xj> list, String str, int i) {
        LinkedList<com.bytedance.adsdk.hf.hf.hf.xj> linkedList = new LinkedList(list);
        int i2 = 5;
        while (i2 > 0) {
            LinkedList linkedList2 = new LinkedList();
            for (com.bytedance.adsdk.hf.hf.hf.xj xjVar : linkedList) {
                if (!linkedList2.isEmpty() && w.xj(((com.bytedance.adsdk.hf.hf.hf.xj) linkedList2.peekLast()).xj()) && ((w) ((com.bytedance.adsdk.hf.hf.hf.xj) linkedList2.peekLast()).xj()).hf() == i2) {
                    com.bytedance.adsdk.hf.hf.hf.xj xjVar2 = (com.bytedance.adsdk.hf.hf.hf.xj) linkedList2.pollLast();
                    com.bytedance.adsdk.hf.hf.hf.xj xjVar3 = (com.bytedance.adsdk.hf.hf.hf.xj) linkedList2.pollLast();
                    if (w.xj(xjVar3.xj()) || w.xj(xjVar.xj())) {
                        throw new IllegalArgumentException(str.substring(0, i));
                    }
                    linkedList2.addLast(xj(xjVar3, xjVar2, xjVar));
                } else {
                    linkedList2.addLast(xjVar);
                }
            }
            i2--;
            linkedList = linkedList2;
        }
        return linkedList;
    }

    private static void w(List<com.bytedance.adsdk.hf.hf.hf.xj> list, String str, int i) {
        Iterator<com.bytedance.adsdk.hf.hf.hf.xj> it = list.iterator();
        while (it.hasNext()) {
            if (u.xj(it.next().xj())) {
                throw new IllegalArgumentException(str.substring(0, i));
            }
        }
    }

    public static com.bytedance.adsdk.hf.hf.hf.xj xj(List<com.bytedance.adsdk.hf.hf.hf.xj> list, String str, int i) {
        w(list, str, i);
        Deque<com.bytedance.adsdk.hf.hf.hf.xj> xj = xj(hf(list, str, i));
        if (xj.size() == 1) {
            return xj.getFirst();
        }
        throw new IllegalStateException();
    }

    private static Deque<com.bytedance.adsdk.hf.hf.hf.xj> xj(Deque<com.bytedance.adsdk.hf.hf.hf.xj> deque) {
        LinkedList linkedList = new LinkedList();
        for (com.bytedance.adsdk.hf.hf.hf.xj xjVar : deque) {
            if (!linkedList.isEmpty() && ((com.bytedance.adsdk.hf.hf.hf.xj) linkedList.peekLast()).xj() == w.COLON) {
                linkedList.pollLast();
                com.bytedance.adsdk.hf.hf.hf.xj xjVar2 = (com.bytedance.adsdk.hf.hf.hf.xj) linkedList.pollLast();
                if (((com.bytedance.adsdk.hf.hf.hf.xj) linkedList.pollLast()).xj() == w.QUESTION) {
                    com.bytedance.adsdk.hf.hf.hf.xj xjVar3 = (com.bytedance.adsdk.hf.hf.hf.xj) linkedList.pollLast();
                    v vVar = new v();
                    vVar.xj(xjVar3);
                    vVar.hf(xjVar2);
                    vVar.w(xjVar);
                    linkedList.addLast(vVar);
                } else {
                    throw new IllegalStateException();
                }
            } else {
                linkedList.addLast(xjVar);
            }
        }
        return linkedList;
    }

    private static com.bytedance.adsdk.hf.hf.hf.xj xj(com.bytedance.adsdk.hf.hf.hf.xj xjVar, com.bytedance.adsdk.hf.hf.hf.xj xjVar2, com.bytedance.adsdk.hf.hf.hf.xj xjVar3) {
        e pVar;
        switch (AnonymousClass1.xj[((w) xjVar2.xj()).ordinal()]) {
            case 1:
                pVar = new p();
                break;
            case 2:
                pVar = new yo();
                break;
            case 3:
                pVar = new com.bytedance.adsdk.hf.hf.hf.xj.xj();
                break;
            case 4:
                pVar = new g();
                break;
            case 5:
                pVar = new pl();
                break;
            case 6:
                pVar = new com.bytedance.adsdk.hf.hf.hf.xj.u();
                break;
            case 7:
                pVar = new am();
                break;
            case 8:
                pVar = new y();
                break;
            case 9:
                pVar = new d();
                break;
            case 10:
                pVar = new kd();
                break;
            case 11:
                pVar = new f();
                break;
            case 12:
                pVar = new com.bytedance.adsdk.hf.hf.hf.xj.hf();
                break;
            case 13:
                pVar = new com.bytedance.adsdk.hf.hf.hf.xj.w();
                break;
            default:
                throw new UnsupportedOperationException(xjVar2.xj().toString());
        }
        pVar.xj(xjVar);
        pVar.hf(xjVar3);
        return pVar;
    }

    public static boolean xj(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
            return !(obj instanceof Number) || ((Number) obj).floatValue() >= 0.0f;
        }
        return false;
    }
}
