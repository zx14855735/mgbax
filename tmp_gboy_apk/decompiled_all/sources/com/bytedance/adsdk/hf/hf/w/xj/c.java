package com.bytedance.adsdk.hf.hf.w.xj;

import com.bytedance.adsdk.hf.hf.hf.xj.qt;
import java.util.Deque;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c extends y {
    private boolean xj(String str, int i, Deque<com.bytedance.adsdk.hf.hf.hf.xj> deque) {
        if ('-' != xj(i, str)) {
            return com.bytedance.adsdk.hf.hf.kd.xj.w(xj(i, str));
        }
        if (deque.peek() != null && !com.bytedance.adsdk.hf.hf.u.w.xj(deque.peek().xj())) {
            return false;
        }
        if (com.bytedance.adsdk.hf.hf.kd.xj.w(xj(i + 1, str))) {
            return true;
        }
        throw new IllegalArgumentException("Unrecognized - symbol, not a negative number or operator, problem range:" + str.substring(0, i));
    }

    @Override // com.bytedance.adsdk.hf.hf.w.xj.y
    public int xj(String str, int i, Deque<com.bytedance.adsdk.hf.hf.hf.xj> deque, com.bytedance.adsdk.hf.hf.w.xj xjVar) {
        char xj;
        if (!xj(str, i, deque)) {
            return xjVar.xj(str, i, deque);
        }
        int i2 = xj(i, str) == '-' ? i + 1 : i;
        boolean z = false;
        while (true) {
            xj = xj(i2, str);
            if (com.bytedance.adsdk.hf.hf.kd.xj.w(xj) || (!z && xj == '.')) {
                i2++;
                if (xj == '.') {
                    z = true;
                }
            }
        }
        if (xj != '.') {
            deque.push(new qt(str.substring(i, i2)));
            return i2;
        }
        throw new IllegalArgumentException("Illegal negative number format, problem interval:" + str.substring(i, i2));
    }
}
