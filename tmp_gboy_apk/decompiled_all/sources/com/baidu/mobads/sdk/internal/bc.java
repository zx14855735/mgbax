package com.baidu.mobads.sdk.internal;

import B25kr6.AMqCpz;
import B25kr6.AYUAbz;
import COJEAR.DG07BK;
import DG07BK.A5SV6n;
import android.content.Context;
import android.support.v4.media.RatingCompat;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.CkXcdM;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.AlLFFp;
import java.util.WeakHashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class bc {
    public static void a(Context context) {
        try {
            WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
            View.generateViewId();
            AccessibilityNodeInfo.obtain();
            A5SV6n.A2egSU(context);
            new AlLFFp(context);
            new NestedScrollView(context, null);
            new Fragment();
            new SwipeRefreshLayout(context, null);
            new RecyclerView(context, null);
            RatingCompat.newPercentageRating(1.0f);
            new AMqCpz();
            new AYUAbz();
            new LinearLayoutManager(1);
            new CkXcdM();
        } catch (Throwable th) {
            bv.a().a(th);
        }
    }
}
