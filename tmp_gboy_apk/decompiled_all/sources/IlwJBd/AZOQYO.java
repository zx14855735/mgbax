package IlwJBd;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO {

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static Integer f4059ADYaiT;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ImageView f4060A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final ArrayList f4061A4TApA = new ArrayList();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public ADYaiT f4062A5SV6n;

    public AZOQYO(ImageView imageView) {
        this.f4060A2egSU = imageView;
    }

    public final int A2egSU(int i, int i2, int i3) {
        int i4 = i2 - i3;
        if (i4 > 0) {
            return i4;
        }
        int i5 = i - i3;
        if (i5 > 0) {
            return i5;
        }
        ImageView imageView = this.f4060A2egSU;
        if (imageView.isLayoutRequested() || i2 != -2) {
            return 0;
        }
        Log.isLoggable("ViewTarget", 4);
        Context context = imageView.getContext();
        if (f4059ADYaiT == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            ItGa5w.ARc23Z.A5SV6n(windowManager, "Argument must not be null");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            f4059ADYaiT = Integer.valueOf(Math.max(point.x, point.y));
        }
        return f4059ADYaiT.intValue();
    }
}
