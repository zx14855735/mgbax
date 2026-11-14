package MSeBzj;

import L2suez.ASJ6gh;
import android.view.View;
import com.game.boy.activity.BJ7GGh;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ ASJ6gh.A2egSU f5181AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ARc23Z f5182AlLFFp;

    public ADYaiT(ARc23Z aRc23Z, ASJ6gh.A2egSU a2egSU) {
        this.f5182AlLFFp = aRc23Z;
        this.f5181AcNBzu = a2egSU;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        File file;
        A2egSU a2egSU = this.f5182AlLFFp.f5185AlLFFp;
        if (a2egSU != null) {
            ASJ6gh aSJ6gh = a2egSU.f5179A2egSU;
            BJ7GGh bJ7GGh = aSJ6gh.f5188AmA8tU;
            if (bJ7GGh != null && (file = this.f5181AcNBzu.f4366A2egSU) != null) {
                String absolutePath = file.getAbsolutePath();
                new LLcl8r.ADYaiT(bJ7GGh.f10922A2egSU.f10904AlLFFp, absolutePath).execute(absolutePath);
            }
            aSJ6gh.dismissAllowingStateLoss();
        }
    }
}
