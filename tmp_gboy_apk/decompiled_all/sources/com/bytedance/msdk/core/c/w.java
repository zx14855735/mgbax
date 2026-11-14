package com.bytedance.msdk.core.c;

import IzHBwY.AYUAbz;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.core.tf.tf;
import com.bytedance.msdk.core.xj.xj.kd;
import com.bytedance.msdk.f.ai;
import com.bytedance.msdk.f.j;
import com.bytedance.msdk.y.hf.u;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.Constants;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static String hf = "KEY_LOAD_SEQ";
    private static String w = "KEY_LOAD_SEQ_TIME";
    private static Comparator<com.bytedance.msdk.hf.w> xj;

    public static boolean hf(String str) {
        return true;
    }

    public static int u() {
        long hf2 = ai.xj((String) null, com.bytedance.msdk.core.hf.getContext()).hf(w, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        boolean xj2 = xj(new Date(hf2), new Date(currentTimeMillis));
        ai.xj((String) null, com.bytedance.msdk.core.hf.getContext()).xj(w, currentTimeMillis);
        int hf3 = (xj2 ? ai.xj((String) null, com.bytedance.msdk.core.hf.getContext()).hf(hf, 0) : 0) + 1;
        ai.xj((String) null, com.bytedance.msdk.core.hf.getContext()).xj(hf, hf3);
        return hf3;
    }

    public static String w() {
        return UUID.randomUUID().toString();
    }

    public static Comparator<com.bytedance.msdk.hf.w> xj() {
        Comparator<com.bytedance.msdk.hf.w> comparator = xj;
        return comparator != null ? comparator : hf();
    }

    public static Comparator<com.bytedance.msdk.hf.w> hf() {
        Comparator<com.bytedance.msdk.hf.w> comparator = new Comparator<com.bytedance.msdk.hf.w>() { // from class: com.bytedance.msdk.core.c.w.1
            @Override // java.util.Comparator
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public int compare(com.bytedance.msdk.hf.w wVar, com.bytedance.msdk.hf.w wVar2) {
                if (wVar.da() > wVar2.da()) {
                    return -1;
                }
                if (wVar.da() < wVar2.da()) {
                    return 1;
                }
                return (wVar.da() == wVar2.da() && wVar.gj() == 1) ? -1 : 0;
            }
        };
        xj = comparator;
        return comparator;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ca, code lost:
    
        if (r9 == 2) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d5, code lost:
    
        if (r9 != 7) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e0, code lost:
    
        if (r9 == 3) goto L79;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String hf(com.bytedance.msdk.core.tf.tf r14) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.core.c.w.hf(com.bytedance.msdk.core.tf.tf):java.lang.String");
    }

    public static void xj(List<com.bytedance.msdk.hf.w> list, Comparator<com.bytedance.msdk.hf.w> comparator) {
        if (comparator == null) {
            j.xj(list);
        } else {
            j.xj(list, comparator);
        }
    }

    public static String xj(String str, String str2, String str3) {
        return "com.bytedance.msdk.adapter." + com.bytedance.msdk.hf.xj.xj(str2) + "." + String.format(str, str2, str3);
    }

    public static boolean xj(tf tfVar) {
        Object apply;
        if (tfVar != null && TextUtils.equals(tfVar.qt(), MediationConstant.ADN_PANGLE)) {
            return true;
        }
        if (tfVar != null && kd.xj(tfVar.qt())) {
            return true;
        }
        if (tfVar == null) {
            return false;
        }
        Function<SparseArray<Object>, Object> c = com.bytedance.msdk.core.p.xj.xj().c();
        if (c != null) {
            String hf2 = hf(tfVar);
            String hf3 = u.hf(tfVar.qt());
            if (TextUtils.isEmpty(hf2)) {
                return false;
            }
            AYUAbz A4TApA2 = AYUAbz.A4TApA();
            A4TApA2.ASJ6gh(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, hf2);
            A4TApA2.ASJ6gh(8560, hf3);
            A4TApA2.AMqCpz(-99999987, 8229);
            A4TApA2.ARc23Z(-99999985, Boolean.class);
            apply = c.apply(A4TApA2.A2egSU().sparseArray());
            return ((Boolean) apply).booleanValue();
        }
        com.bytedance.msdk.xj.kd.w.hf(MediationConstant.TAG, "load ad check class loader is null ");
        return false;
    }

    public static String xj(String str) {
        return !TextUtils.isEmpty(str) ? str.substring(0, 1).toUpperCase().concat(str.substring(1).toLowerCase()) : str;
    }

    private static boolean hf(String str, com.bytedance.msdk.hf.w wVar) {
        if (wVar == null) {
            return false;
        }
        com.bytedance.msdk.core.tf.hf xj2 = com.bytedance.msdk.core.hf.hf().xj(str, wVar.ci(), 101);
        return com.bytedance.msdk.core.hf.hf().hf(str, wVar.ci()) && xj2 != null && xj2.l() != null && xj2.l().size() > 0 && xj2.io() != null && xj2.io().size() > 0;
    }

    public static tf xj(String str, String str2, int i, int i2) {
        tf tfVar = new tf();
        tfVar.w(str2);
        tfVar.kd(str);
        tfVar.tf(0);
        tfVar.y(Constants.FAIL);
        tfVar.hf("1");
        tfVar.p(i);
        tfVar.pl(i2);
        tfVar.d(3);
        tfVar.xj("%1$s%2$sAdapter");
        return tfVar;
    }

    private static boolean xj(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    public static void xj(com.bytedance.msdk.api.xj xjVar, tf tfVar) {
        if (!com.bytedance.msdk.core.hf.hf().eu() || xjVar == null || tfVar == null) {
            return;
        }
        if (820001 == xjVar.xj) {
            com.bytedance.msdk.api.u.xj(com.bytedance.msdk.core.hf.getContext(), String.format("error_adn:%1$s no ads，please check ad network", tfVar.e()));
        } else {
            com.bytedance.msdk.api.u.xj(com.bytedance.msdk.core.hf.getContext(), String.format("test error_adn:%1$s  error_slot_id: %2$s  error_code:%3$d  error_message:%4$s", tfVar.e(), tfVar.yo(), Integer.valueOf(xjVar.w), xjVar.u));
        }
    }

    public static void xj(String str, tf tfVar, com.bytedance.msdk.hf.w wVar) {
        if (com.bytedance.msdk.core.hf.hf().eu() && tfVar != null && hf(str, wVar)) {
            com.bytedance.msdk.api.u.xj(com.bytedance.msdk.core.hf.getContext(), String.format("fill_suceess ,test_adn:%1$s,slot_id : %2$s", tfVar.qt(), Integer.valueOf(tfVar.v())));
        }
    }

    public static void xj(String str, com.bytedance.msdk.hf.w wVar) {
        if (com.bytedance.msdk.core.hf.hf().eu() && wVar != null && hf(str, wVar)) {
            com.bytedance.msdk.api.u.xj(com.bytedance.msdk.core.hf.getContext(), String.format("test_suceess ,test_adn:%1$s,slot_id : %2$s", com.bytedance.msdk.hf.xj.xj(wVar.gj()), wVar.cy()));
        }
    }
}
