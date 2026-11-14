package com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.bytedance.sdk.openadsdk.core.ra.q;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private Context hf;
    private final Vibrator kd;
    private List<hf> xj;
    private final List<Long> w = new ArrayList();
    private final List<Integer> u = new ArrayList();
    private long y = 0;
    private long c = 0;

    public xj(Context context, q qVar) {
        this.hf = context;
        this.kd = w.w(context);
        this.xj = qVar.hf();
        xj();
    }

    private static float xj(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public void hf() {
        VibrationEffect createWaveform;
        if (!w.xj(this.hf) || this.w.isEmpty() || this.u.isEmpty()) {
            return;
        }
        long[] xj = xj(this.w);
        int[] hf = hf(this.u);
        if (Build.VERSION.SDK_INT < 26) {
            this.kd.vibrate(100L);
        } else {
            createWaveform = VibrationEffect.createWaveform(xj, hf, -1);
            this.kd.vibrate(createWaveform);
        }
    }

    public void w() {
        this.w.clear();
        this.u.clear();
        this.y = 0L;
        this.c = 0L;
    }

    public void xj() {
        w();
        List<hf> list = this.xj;
        if (list == null || list.isEmpty()) {
            return;
        }
        Collections.sort(this.xj, new Comparator<hf>() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj.xj.1
            @Override // java.util.Comparator
            /* renamed from: xj, reason: merged with bridge method [inline-methods] */
            public int compare(hf hfVar, hf hfVar2) {
                return Long.compare(hfVar.xj(), hfVar2.xj());
            }
        });
        Iterator<hf> it = this.xj.iterator();
        while (it.hasNext()) {
            long hf = it.next().hf() + r1.xj();
            if (hf > this.c) {
                this.c = hf;
            }
        }
        for (hf hfVar : this.xj) {
            if (this.y < hfVar.xj()) {
                xj(hfVar.xj() - this.y);
            }
            xj(hfVar.hf(), hfVar.w(), hfVar.u());
        }
        long j = this.y;
        long j2 = this.c;
        if (j < j2) {
            xj(j2 - j);
        }
    }

    private int[] hf(List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }

    private void xj(long j) {
        if (j > 0) {
            this.w.add(Long.valueOf(j));
            this.u.add(0);
            this.y += j;
        }
    }

    private void xj(long j, float f, float f2) {
        float xj = xj(f, 0.0f, 1.0f);
        float xj2 = xj(f2, 0.0f, 1.0f);
        int pow = (int) (((float) Math.pow(xj, 1.5d)) * 255.0f);
        int max = Math.max(1, (int) (xj2 * ((int) (j / 22))));
        long j2 = j - (max * 20);
        for (int i = 0; i < max; i++) {
            this.w.add(20L);
            this.u.add(Integer.valueOf(pow));
            int i2 = max - 1;
            if (i < i2) {
                this.w.add(Long.valueOf(Math.max(2L, j2 / i2)));
                this.u.add(0);
            }
        }
        this.y += j;
    }

    private long[] xj(List<Long> list) {
        long[] jArr = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            jArr[i] = list.get(i).longValue();
        }
        return jArr;
    }
}
