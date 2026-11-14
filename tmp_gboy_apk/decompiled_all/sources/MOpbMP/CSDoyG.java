package MOpbMP;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.io.File;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class CSDoyG extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final CTkVKb f5102AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ArrayList f5103AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final ArrayList f5104AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final DateFormat f5105AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final DateFormat f5106B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final /* synthetic */ CTkVKb f5107B2KMhB;

    public CSDoyG(CTkVKb cTkVKb, CTkVKb cTkVKb2, ArrayList arrayList, ArrayList arrayList2) {
        this.f5107B2KMhB = cTkVKb;
        this.f5102AcNBzu = cTkVKb2;
        this.f5103AlLFFp = arrayList;
        this.f5104AmA8tU = arrayList2;
        this.f5105AzWtSf = android.text.format.DateFormat.getMediumDateFormat(cTkVKb2.getActivity());
        this.f5106B25kr6 = android.text.format.DateFormat.getTimeFormat(cTkVKb2.getActivity());
    }

    public static void A2egSU(CSDoyG cSDoyG, String str, String str2, Runnable runnable) {
        OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(cSDoyG.f5102AcNBzu.getActivity());
        ADYaiT.AZOQYO azoqyo = a4TApA.f81AcNBzu;
        azoqyo.AMqCpz = str;
        azoqyo.f28ASJ6gh = str2;
        a4TApA.AmA8tU(2131886206, new DRlcZ9.ASJ6gh(3, runnable));
        a4TApA.AaHO0E(2131886161, null);
        a4TApA.AMqCpz();
    }

    public final String A4TApA(int i) {
        Integer num = (Integer) this.f5104AmA8tU.get(i);
        int intValue = num.intValue();
        CTkVKb cTkVKb = this.f5102AcNBzu;
        return intValue != 0 ? intValue != 10 ? cTkVKb.getString(2131886799, num) : cTkVKb.getString(2131886797) : cTkVKb.getString(2131886800);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return this.f5103AlLFFp.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        CQhlFr cQhlFr = (CQhlFr) dphsd2;
        File file = (File) this.f5103AlLFFp.get(i);
        boolean exists = file.exists();
        cQhlFr.f5094AcNBzu.setText(A4TApA(i));
        ImageView imageView = cQhlFr.f5095AlLFFp;
        TextView textView = cQhlFr.f5097AzWtSf;
        TextView textView2 = cQhlFr.f5096AmA8tU;
        if (exists) {
            Date date = new Date(file.lastModified());
            textView2.setText(this.f5105AzWtSf.format(date));
            textView.setText(this.f5106B25kr6.format(date));
            imageView.setImageBitmap(BitmapFactory.decodeFile(CTkVKb.AlLFFp(file).getAbsolutePath()));
        } else {
            textView2.setText(this.f5102AcNBzu.getString(2131886798));
            textView.setText((CharSequence) null);
            imageView.setImageBitmap(null);
        }
        MaterialButton materialButton = cQhlFr.f5099B2KMhB;
        materialButton.setEnabled(exists);
        MaterialButton materialButton2 = cQhlFr.f5100B3GDIM;
        materialButton2.setEnabled(exists);
        MaterialButton materialButton3 = cQhlFr.f5101B4ZgIw;
        materialButton3.setEnabled(exists);
        materialButton.setAlpha(exists ? 1.0f : 0.4f);
        materialButton2.setAlpha(exists ? 1.0f : 0.4f);
        materialButton3.setAlpha(exists ? 1.0f : 0.4f);
        cQhlFr.f5098B25kr6.setOnClickListener(new COJEAR(this, cQhlFr, 0));
        materialButton.setOnClickListener(new COJEAR(this, cQhlFr, 1));
        materialButton2.setOnClickListener(new COJEAR(this, cQhlFr, 2));
        materialButton3.setOnClickListener(new COJEAR(this, cQhlFr, 3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131493323, viewGroup, false);
        CQhlFr cQhlFr = new CQhlFr(inflate);
        cQhlFr.f5094AcNBzu = (TextView) inflate.findViewById(2131297685);
        cQhlFr.f5095AlLFFp = (ImageView) inflate.findViewById(2131297882);
        cQhlFr.f5096AmA8tU = (TextView) inflate.findViewById(2131296552);
        cQhlFr.f5097AzWtSf = (TextView) inflate.findViewById(2131298105);
        cQhlFr.f5098B25kr6 = (MaterialButton) inflate.findViewById(2131296443);
        cQhlFr.f5099B2KMhB = (MaterialButton) inflate.findViewById(2131296441);
        cQhlFr.f5100B3GDIM = (MaterialButton) inflate.findViewById(2131296447);
        cQhlFr.f5101B4ZgIw = (MaterialButton) inflate.findViewById(2131296433);
        return cQhlFr;
    }
}
