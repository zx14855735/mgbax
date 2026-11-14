package L2suez;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Toast;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AzWtSf implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ boolean f4377AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Context f4378AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ ADYaiT.AmA8tU f4379AmA8tU;

    public AzWtSf(boolean z, Context context, ADYaiT.AmA8tU amA8tU) {
        this.f4377AcNBzu = z;
        this.f4378AlLFFp = context;
        this.f4379AmA8tU = amA8tU;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!this.f4377AcNBzu) {
            this.f4379AmA8tU.dismiss();
            return;
        }
        Context context = this.f4378AlLFFp;
        if (context instanceof Activity) {
            ((Activity) context).finishAffinity();
        } else {
            Toast.makeText(context, "请更新应用后再使用", 1).show();
        }
    }
}
