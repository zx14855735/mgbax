package Mi9UWv;

import L2suez.AZOQYO;
import LLiCI0.BV3sI0;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public ArrayList f5388AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public I3HV03.A4TApA f5389AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Context f5390AmA8tU;

    public final void A2egSU(A2egSU a2egSU, MTKlkd.AMqCpz aMqCpz) {
        String[] split = aMqCpz.ASJ6gh().split("\n");
        int A5SV6n2 = aMqCpz.A5SV6n();
        Context context = this.f5390AmA8tU;
        if (A5SV6n2 >= 1 && split.length > 0) {
            String str = split[0];
            a2egSU.f5371AcNBzu.setVisibility(0);
            String[] split2 = str.split(",");
            if (split2.length >= 2) {
                AZOQYO.A4TApA(context, split2[1], a2egSU.f5375B25kr6);
                a2egSU.f5383BIYEnU.setText(split2[0]);
            }
        }
        if (A5SV6n2 >= 2 && split.length > 1) {
            String str2 = split[1];
            a2egSU.f5372AlLFFp.setVisibility(0);
            String[] split3 = str2.split(",");
            if (split3.length >= 2) {
                AZOQYO.A4TApA(context, split3[1], a2egSU.f5376B2KMhB);
                a2egSU.f5384BJ7GGh.setText(split3[0]);
            }
        }
        if (A5SV6n2 >= 3 && split.length > 2) {
            String str3 = split[2];
            a2egSU.f5373AmA8tU.setVisibility(0);
            String[] split4 = str3.split(",");
            if (split4.length >= 2) {
                AZOQYO.A4TApA(context, split4[1], a2egSU.f5377B3GDIM);
                a2egSU.f5385BNL6CD.setText(split4[0]);
            }
        }
        if (A5SV6n2 < 4 || split.length <= 3) {
            return;
        }
        String str4 = split[3];
        a2egSU.f5374AzWtSf.setVisibility(0);
        String[] split5 = str4.split(",");
        if (split5.length >= 2) {
            AZOQYO.A4TApA(context, split5[1], a2egSU.f5378B4ZgIw);
            a2egSU.f5386BPw6Q8.setText(split5[0]);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return this.f5388AcNBzu.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        String str;
        int parseInt;
        A2egSU a2egSU = (A2egSU) dphsd2;
        MTKlkd.AMqCpz aMqCpz = (MTKlkd.AMqCpz) this.f5388AcNBzu.get(i);
        a2egSU.f5379B7CMnp.setText("ID: " + aMqCpz.AMqCpz());
        if (aMqCpz.ARc23Z() == null || aMqCpz.ARc23Z().isEmpty() || aMqCpz.ARc23Z().equals("null")) {
            str = "空闲";
        } else {
            str = "游戏: " + aMqCpz.ARc23Z();
        }
        a2egSU.f5382BI9f7h.setText(str);
        a2egSU.f5380B9tovu.setText(aMqCpz.A5SV6n() + "人");
        a2egSU.f5387BTvldC.setBackgroundColor((aMqCpz.A5SV6n() == 4 || aMqCpz.AZOQYO()) ? -833207 : -11814005);
        boolean AZOQYO2 = aMqCpz.AZOQYO();
        TextView textView = a2egSU.f5386BPw6Q8;
        TextView textView2 = a2egSU.f5385BNL6CD;
        TextView textView3 = a2egSU.f5384BJ7GGh;
        TextView textView4 = a2egSU.f5383BIYEnU;
        LinearLayout linearLayout = a2egSU.f5374AzWtSf;
        LinearLayout linearLayout2 = a2egSU.f5373AmA8tU;
        LinearLayout linearLayout3 = a2egSU.f5372AlLFFp;
        LinearLayout linearLayout4 = a2egSU.f5371AcNBzu;
        if (AZOQYO2) {
            linearLayout4.setVisibility(8);
            linearLayout3.setVisibility(8);
            linearLayout2.setVisibility(8);
            linearLayout.setVisibility(8);
        } else {
            linearLayout4.setVisibility(0);
            linearLayout3.setVisibility(0);
            linearLayout2.setVisibility(0);
            linearLayout.setVisibility(0);
            textView4.setText("空");
            textView3.setText("空");
            textView2.setText("空");
            textView.setText("空");
            a2egSU.f5375B25kr6.setImageResource(2131230987);
            a2egSU.f5376B2KMhB.setImageResource(2131230987);
            a2egSU.f5377B3GDIM.setImageResource(2131230987);
            a2egSU.f5378B4ZgIw.setImageResource(2131230987);
        }
        try {
            A2egSU(a2egSU, aMqCpz);
        } catch (Exception unused) {
            int A5SV6n2 = aMqCpz.A5SV6n();
            if (A5SV6n2 >= 1) {
                textView4.setText("1P");
                linearLayout4.setVisibility(0);
            }
            if (A5SV6n2 >= 2) {
                textView3.setText("2P");
                linearLayout3.setVisibility(0);
            }
            if (A5SV6n2 >= 3) {
                textView2.setText("3P");
                linearLayout2.setVisibility(0);
            }
            if (A5SV6n2 >= 4) {
                textView.setText("4P");
                linearLayout.setVisibility(0);
            }
        }
        String str2 = aMqCpz.f5225ASJ6gh;
        TextView textView5 = a2egSU.f5381BChYOn;
        textView5.setText(str2);
        if (str2 != null) {
            if (str2.contains("ms")) {
                parseInt = Integer.parseInt(str2.replace("ms", "").trim());
                textView5.setBackgroundResource((parseInt != -1 || parseInt > 150) ? 2131230952 : parseInt > 80 ? 2131230951 : 2131230947);
                a2egSU.itemView.setOnClickListener(new BV3sI0(this, 3, aMqCpz));
            }
        }
        parseInt = -1;
        textView5.setBackgroundResource((parseInt != -1 || parseInt > 150) ? 2131230952 : parseInt > 80 ? 2131230951 : 2131230947);
        a2egSU.itemView.setOnClickListener(new BV3sI0(this, 3, aMqCpz));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131492865, viewGroup, false);
        A2egSU a2egSU = new A2egSU(inflate);
        a2egSU.f5379B7CMnp = (TextView) inflate.findViewById(2131297831);
        a2egSU.f5380B9tovu = (TextView) inflate.findViewById(2131297832);
        a2egSU.f5382BI9f7h = (TextView) inflate.findViewById(2131298088);
        a2egSU.f5383BIYEnU = (TextView) inflate.findViewById(2131297706);
        a2egSU.f5384BJ7GGh = (TextView) inflate.findViewById(2131297707);
        a2egSU.f5385BNL6CD = (TextView) inflate.findViewById(2131297708);
        a2egSU.f5386BPw6Q8 = (TextView) inflate.findViewById(2131297709);
        a2egSU.f5375B25kr6 = (ShapeableImageView) inflate.findViewById(2131296396);
        a2egSU.f5376B2KMhB = (ShapeableImageView) inflate.findViewById(2131296397);
        a2egSU.f5377B3GDIM = (ShapeableImageView) inflate.findViewById(2131296398);
        a2egSU.f5378B4ZgIw = (ShapeableImageView) inflate.findViewById(2131296399);
        a2egSU.f5371AcNBzu = (LinearLayout) inflate.findViewById(2131297511);
        a2egSU.f5372AlLFFp = (LinearLayout) inflate.findViewById(2131297512);
        a2egSU.f5373AmA8tU = (LinearLayout) inflate.findViewById(2131297513);
        a2egSU.f5374AzWtSf = (LinearLayout) inflate.findViewById(2131297514);
        a2egSU.f5381BChYOn = (TextView) inflate.findViewById(2131297660);
        a2egSU.f5387BTvldC = inflate.findViewById(2131296275);
        return a2egSU;
    }
}
