package com.octopus.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.octopus.ad.widget.RegionClickView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private Context f12708a;

    public j(Context context) {
        this.f12708a = context;
    }

    public View a(int i, int i2, String str, boolean z) {
        if (this.f12708a == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "点击跳转至第三方应用或详情页";
        }
        com.octopus.ad.utils.b.f.c("OctopusAd", "adWidthDp = " + i + ",adHeightDp = " + i2);
        float f = ((float) i) / 360.0f;
        RegionClickView regionClickView = new RegionClickView(this.f12708a);
        regionClickView.a(str, f);
        regionClickView.setLayoutParams(a(i, i2, f));
        return regionClickView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d3, code lost:
    
        if (r0 >= 400) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.view.ViewGroup.MarginLayoutParams a(int r12, int r13, float r14) {
        /*
            Method dump skipped, instructions count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.octopus.ad.utils.j.a(int, int, float):android.view.ViewGroup$MarginLayoutParams");
    }

    public void a() {
        this.f12708a = null;
    }
}
