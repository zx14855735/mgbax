package LLiCI0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import com.game.boy.viewUi.HTMLTextView;
import com.google.android.material.card.MaterialCardView;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BpkvW3 extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public List f4762AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public BmvVmW f4763AlLFFp;

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return this.f4762AcNBzu.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        BniPrB bniPrB = (BniPrB) dphsd2;
        MTKlkd.ADYaiT aDYaiT = (MTKlkd.ADYaiT) this.f4762AcNBzu.get(i);
        Context context = bniPrB.itemView.getContext();
        bniPrB.f4755AlLFFp.setText(aDYaiT.AMqCpz());
        bniPrB.f4756AmA8tU.setText("¥" + aDYaiT.ARc23Z());
        bniPrB.f4759B2KMhB.setHTMLText(aDYaiT.A4TApA());
        bniPrB.f4757AzWtSf.setText(aDYaiT.A2egSU() + "天有效期");
        boolean AYUAbz2 = aDYaiT.AYUAbz();
        TextView textView = bniPrB.f4758B25kr6;
        Button button = bniPrB.f4761B4ZgIw;
        MaterialCardView materialCardView = bniPrB.f4754AcNBzu;
        if (AYUAbz2) {
            textView.setVisibility(0);
            materialCardView.setStrokeColor(BPw6Q8.ASJ6gh.A4TApA(context, 2131099697));
            materialCardView.setStrokeWidth(4);
            button.setBackgroundColor(BPw6Q8.ASJ6gh.A4TApA(context, 2131099697));
            button.setTextColor(-1);
        } else {
            textView.setVisibility(8);
            materialCardView.setStrokeWidth(1);
        }
        LinearLayout linearLayout = bniPrB.f4760B3GDIM;
        linearLayout.removeAllViews();
        if (aDYaiT.A5SV6n() != null) {
            for (String str : aDYaiT.A5SV6n()) {
                TextView textView2 = new TextView(context);
                textView2.setText(str);
                textView2.setTextSize(14.0f);
                textView2.setCompoundDrawablesWithIntrinsicBounds(2131231075, 0, 0, 0);
                textView2.setCompoundDrawablePadding(8);
                textView2.setPadding(0, 4, 0, 4);
                linearLayout.addView(textView2);
            }
        }
        button.setOnClickListener(new BV3sI0(this, 0, aDYaiT));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131492989, viewGroup, false);
        BniPrB bniPrB = new BniPrB(inflate);
        bniPrB.f4754AcNBzu = (MaterialCardView) inflate.findViewById(2131296465);
        bniPrB.f4755AlLFFp = (TextView) inflate.findViewById(2131298164);
        bniPrB.f4756AmA8tU = (TextView) inflate.findViewById(2131298166);
        bniPrB.f4759B2KMhB = (HTMLTextView) inflate.findViewById(2131298156);
        bniPrB.f4757AzWtSf = (TextView) inflate.findViewById(2131298155);
        bniPrB.f4758B25kr6 = (TextView) inflate.findViewById(2131298167);
        bniPrB.f4760B3GDIM = (LinearLayout) inflate.findViewById(2131296658);
        bniPrB.f4761B4ZgIw = (Button) inflate.findViewById(2131296420);
        return bniPrB;
    }
}
