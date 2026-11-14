package LLiCI0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import com.game.boy.activity.PermissionsActivity;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class CASmeH extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ArrayList f4772AcNBzu = new ArrayList();

    /* renamed from: AlLFFp, reason: collision with root package name */
    public com.game.boy.activity.A2egSU f4773AlLFFp;

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return this.f4772AcNBzu.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        C4FrIb c4FrIb = (C4FrIb) dphsd2;
        C2rE4F c2rE4F = (C2rE4F) this.f4772AcNBzu.get(i);
        c4FrIb.f4768AcNBzu.setImageResource(c2rE4F.f4764A2egSU);
        c4FrIb.f4769AlLFFp.setText(c2rE4F.f4765A4TApA);
        c4FrIb.f4770AmA8tU.setText(c2rE4F.f4766A5SV6n);
        int i2 = c2rE4F.f4767ADYaiT;
        TextView textView = c4FrIb.f4771AzWtSf;
        if (i2 == 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        com.game.boy.activity.A2egSU a2egSU = this.f4773AlLFFp;
        if (a2egSU != null) {
            int i3 = c2rE4F.f4767ADYaiT;
            String[] strArr = PermissionsActivity.f11076BI9f7h;
            if (((PermissionsActivity) a2egSU.f10885AcNBzu).AaHO0E(i3)) {
                textView.setText("已授权 ✓");
                textView.setTextColor(-13730510);
                return;
            }
        }
        if (c2rE4F.AMqCpz) {
            textView.setText("尚未授权 · 必须授权");
            textView.setTextColor(-3790808);
        } else {
            textView.setText("尚未授权 · 可跳过");
            textView.setTextColor(-415707);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131492990, viewGroup, false);
        C4FrIb c4FrIb = new C4FrIb(inflate);
        c4FrIb.f4768AcNBzu = (ImageView) inflate.findViewById(2131296768);
        c4FrIb.f4769AlLFFp = (TextView) inflate.findViewById(2131298242);
        c4FrIb.f4770AmA8tU = (TextView) inflate.findViewById(2131298193);
        c4FrIb.f4771AzWtSf = (TextView) inflate.findViewById(2131298235);
        return c4FrIb;
    }
}
