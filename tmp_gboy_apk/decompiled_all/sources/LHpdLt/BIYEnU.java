package LHpdLt;

import android.os.CountDownTimer;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BIYEnU extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ArrayList f4544AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final HashMap f4545AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final AaHO0E f4546AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final AZkASS f4547AzWtSf;

    public BIYEnU(ArrayList arrayList, HashMap hashMap, AaHO0E aaHO0E, AZkASS aZkASS) {
        this.f4544AcNBzu = arrayList;
        this.f4545AlLFFp = hashMap;
        this.f4546AmA8tU = aaHO0E;
        this.f4547AzWtSf = aZkASS;
    }

    public final void A2egSU(BI9f7h bI9f7h, long j) {
        bI9f7h.f4542AmA8tU.setEnabled(false);
        bI9f7h.f4542AmA8tU.setText(Math.max(1L, j / 1000) + "s");
        CountDownTimer countDownTimer = bI9f7h.f4543AzWtSf;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        bI9f7h.f4543AzWtSf = new BChYOn(this, j, bI9f7h).start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        ArrayList arrayList = this.f4544AcNBzu;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        BJ7GGh bJ7GGh;
        BI9f7h bI9f7h = (BI9f7h) dphsd2;
        ArrayList arrayList = this.f4544AcNBzu;
        if (arrayList == null || i < 0 || i >= arrayList.size() || (bJ7GGh = (BJ7GGh) arrayList.get(i)) == null) {
            return;
        }
        TextView textView = bI9f7h.f4541AlLFFp;
        String str = bJ7GGh.f4548A2egSU;
        textView.setText((str == null || str.isEmpty()) ? "未知玩家" : bJ7GGh.f4548A2egSU);
        String str2 = bJ7GGh.f4549A4TApA;
        ShapeableImageView shapeableImageView = bI9f7h.f4540AcNBzu;
        if (str2 == null || str2.isEmpty()) {
            if (shapeableImageView.getTag() != null) {
                shapeableImageView.setTag(null);
                shapeableImageView.setImageResource(2131689472);
            }
        } else if (!str2.equals(shapeableImageView.getTag())) {
            shapeableImageView.setTag(str2);
            L2suez.AZOQYO.A4TApA(bI9f7h.itemView.getContext(), str2, shapeableImageView);
        }
        CountDownTimer countDownTimer = bI9f7h.f4543AzWtSf;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            bI9f7h.f4543AzWtSf = null;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        String str3 = bJ7GGh.f4550A5SV6n;
        Long l = str3 != null ? (Long) this.f4545AlLFFp.get(str3) : null;
        if (l == null || l.longValue() <= uptimeMillis) {
            bI9f7h.f4542AmA8tU.setEnabled(true);
            bI9f7h.f4542AmA8tU.setText("邀请");
        } else {
            A2egSU(bI9f7h, l.longValue() - uptimeMillis);
        }
        bI9f7h.f4542AmA8tU.setOnClickListener(new B9tovu(0, this, bJ7GGh, bI9f7h));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131492979, viewGroup, false);
        BI9f7h bI9f7h = new BI9f7h(inflate);
        bI9f7h.f4540AcNBzu = (ShapeableImageView) inflate.findViewById(2131296756);
        bI9f7h.f4541AlLFFp = (TextView) inflate.findViewById(2131298243);
        bI9f7h.f4542AmA8tU = (MaterialButton) inflate.findViewById(2131296439);
        return bI9f7h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onViewRecycled(Dphsd2 dphsd2) {
        BI9f7h bI9f7h = (BI9f7h) dphsd2;
        CountDownTimer countDownTimer = bI9f7h.f4543AzWtSf;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            bI9f7h.f4543AzWtSf = null;
        }
    }
}
