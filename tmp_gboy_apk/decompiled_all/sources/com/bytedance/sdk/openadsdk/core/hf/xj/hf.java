package com.bytedance.sdk.openadsdk.core.hf.xj;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf extends xj {
    public hf() {
    }

    public boolean hf(View view) {
        if (view != null && this.xj != null) {
            String valueOf = String.valueOf(view.getTag(2097610717));
            if (view.getTag(2097610717) != null && !TextUtils.isEmpty(valueOf)) {
                if ("click".equals(valueOf)) {
                    return this.w.kd();
                }
                return true;
            }
            Context context = this.hf;
            if (context == null) {
                context = pz.getContext();
            }
            if (xj(view, context)) {
                return this.xj.b() != 1 || this.w.kd();
            }
            if (this.xj.r() == 1 && !this.w.kd()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.hf.xj.xj
    public int xj(Map<String, Object> map, w wVar) {
        return !hf(this.u) ? 1 : 0;
    }

    public hf(ws wsVar, Context context) {
        this.xj = wsVar;
        this.hf = context;
    }

    public boolean xj(View view, Context context) {
        int id = view.getId();
        List<Integer> p = this.w.p();
        if (p != null && p.size() == 0) {
            p.add(2114387830);
            p.add(2114387864);
            p.add(2114387633);
            p.add(2114387466);
            p.add(2114387468);
            p.add(2114387962);
            p.add(2114387625);
        }
        return p != null && p.contains(Integer.valueOf(id));
    }

    public boolean xj(View view, Point point) {
        int i;
        int i2;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                Context context = this.hf;
                if (context == null) {
                    context = pz.getContext();
                }
                if (xj(childAt, context)) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    int i4 = point.x;
                    int i5 = iArr[0];
                    return i4 >= i5 && i4 <= childAt.getWidth() + i5 && (i = point.y) >= (i2 = iArr[1]) && i <= childAt.getHeight() + i2;
                }
                if (xj(childAt, point)) {
                    return true;
                }
            }
        }
        return false;
    }
}
