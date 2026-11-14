package MOpbMP;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.Dphsd2;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class CikNvS extends RecyclerView.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Context f5118AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ArrayList f5119AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ CkXcdM f5120AmA8tU;

    public CikNvS(CkXcdM ckXcdM, Context context, ArrayList arrayList) {
        this.f5120AmA8tU = ckXcdM;
        this.f5118AcNBzu = context;
        this.f5119AlLFFp = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final int getItemCount() {
        return this.f5119AlLFFp.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final void onBindViewHolder(Dphsd2 dphsd2, int i) {
        Cd8JRx cd8JRx = (Cd8JRx) dphsd2;
        try {
            InputStream open = this.f5118AcNBzu.getAssets().open("image/" + ((String) this.f5119AlLFFp.get(i)));
            cd8JRx.f5117AcNBzu.setImageBitmap(BitmapFactory.decodeStream(open));
            open.close();
            cd8JRx.f5117AcNBzu.setOnClickListener(new LLiCI0.BV3sI0(this, 1, cd8JRx));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.A2egSU
    public final Dphsd2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = this.f5118AcNBzu;
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) ((100.0f * context.getResources().getDisplayMetrics().density) + 0.5f)));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        int i2 = (int) ((4.0f * context.getResources().getDisplayMetrics().density) + 0.5f);
        imageView.setPadding(i2, i2, i2, i2);
        Cd8JRx cd8JRx = new Cd8JRx(imageView);
        cd8JRx.f5117AcNBzu = imageView;
        return cd8JRx;
    }
}
