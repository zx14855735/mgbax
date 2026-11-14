package CrfGsy;

import android.view.View;
import android.view.WindowInsets;
import androidx.drawerlayout.widget.DrawerLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements View.OnApplyWindowInsetsListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f1859A2egSU;

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        switch (this.f1859A2egSU) {
            case 0:
                DrawerLayout drawerLayout = (DrawerLayout) view;
                boolean z = false;
                boolean z2 = windowInsets.getSystemWindowInsetTop() > 0;
                drawerLayout.f8641CASmeH = windowInsets;
                drawerLayout.f8642CNPG0E = z2;
                if (!z2 && drawerLayout.getBackground() == null) {
                    z = true;
                }
                drawerLayout.setWillNotDraw(z);
                drawerLayout.requestLayout();
                break;
        }
        return windowInsets.consumeSystemWindowInsets();
    }
}
