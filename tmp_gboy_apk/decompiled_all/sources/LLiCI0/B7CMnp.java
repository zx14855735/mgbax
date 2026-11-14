package LLiCI0;

import ADYaiT.DUi7mC;
import L2suez.ASJ6gh;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import java.io.File;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B7CMnp implements View.OnLongClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ ASJ6gh.A2egSU f4721AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ int f4722AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ BIYEnU f4723AmA8tU;

    public B7CMnp(BIYEnU bIYEnU, ASJ6gh.A2egSU a2egSU, int i) {
        this.f4723AmA8tU = bIYEnU;
        this.f4721AcNBzu = a2egSU;
        this.f4722AlLFFp = i;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        ASJ6gh.A2egSU a2egSU = this.f4721AcNBzu;
        File file = a2egSU.f4366A2egSU;
        File file2 = a2egSU.f4367A4TApA;
        BIYEnU bIYEnU = this.f4723AmA8tU;
        BJ7GGh bJ7GGh = bIYEnU.f4736AmA8tU;
        DUi7mC dUi7mC = new DUi7mC(bJ7GGh.f4739AmA8tU, view);
        AZkASS.AmA8tU amA8tU = (AZkASS.AmA8tU) dUi7mC.f239AlLFFp;
        amA8tU.A2egSU(0, 2131297621, 0, "重命名").setIcon(2131231053);
        amA8tU.A2egSU(0, 2131297630, 0, "设置封面").setIcon(2131231009);
        String absolutePath = file.getAbsolutePath();
        FragmentActivity fragmentActivity = bJ7GGh.f4739AmA8tU;
        if ((absolutePath == null || absolutePath.isEmpty()) ? false : LCJm5h.A2egSU.A2egSU(fragmentActivity).contains(absolutePath)) {
            amA8tU.A2egSU(0, 2131297600, 0, "移除喜欢").setIcon(2131230996);
        } else {
            amA8tU.A2egSU(0, 2131297599, 0, "添加喜欢").setIcon(2131230997);
        }
        amA8tU.A2egSU(0, 2131297589, 0, "删除游戏").setIcon(2131230988);
        amA8tU.A2egSU(0, 2131297601, 0, "导入存档").setIcon(2131231010);
        amA8tU.A2egSU(0, 2131297632, 0, "创建快捷方式").setIcon(2131230978);
        amA8tU.f511BmvVmW = true;
        Iterator it = amA8tU.AcNBzu().iterator();
        while (it.hasNext()) {
            MenuItem menuItem = (MenuItem) it.next();
            int applyDimension = (int) TypedValue.applyDimension(1, 8.0f, fragmentActivity.getResources().getDisplayMetrics());
            if (menuItem.getIcon() != null) {
                if (Build.VERSION.SDK_INT > 21) {
                    menuItem.setIcon(new InsetDrawable(menuItem.getIcon(), applyDimension, 0, applyDimension, 0));
                } else {
                    menuItem.setIcon(new B9tovu(menuItem.getIcon(), applyDimension, applyDimension, applyDimension));
                }
            }
        }
        dUi7mC.f241AzWtSf = new BChYOn(bIYEnU, file, this.f4722AlLFFp, absolutePath, file2);
        AZkASS.BIYEnU bIYEnU2 = (AZkASS.BIYEnU) dUi7mC.f240AmA8tU;
        if (bIYEnU2.A4TApA()) {
            return true;
        }
        if (bIYEnU2.AMqCpz == null) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
        bIYEnU2.ADYaiT(0, 0, false, false);
        return true;
    }
}
