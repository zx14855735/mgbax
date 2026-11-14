package EQurEW;

import FOAO9d.AYUAbz;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public View f2491A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public A2egSU f2492A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public AYUAbz f2493A5SV6n;

    public static float A2egSU(View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return -1.0f;
        }
        int i = rect.top;
        int i2 = rect.bottom;
        int i3 = rect.left;
        int i4 = rect.right;
        Point point = new Point();
        view.getRootView().getWindowVisibleDisplayFrame(rect);
        DisplayMetrics displayMetrics = view.getContext().getResources().getDisplayMetrics();
        point.set(displayMetrics.widthPixels, displayMetrics.heightPixels);
        return ((Math.max(0, Math.min(i2, point.y) - Math.max(i, 0)) * Math.max(0, Math.min(i4, point.x) - Math.max(i3, 0))) / (width * height)) * 100.0f;
    }
}
