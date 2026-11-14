package DRlcZ9;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.Dphsd2;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BV3sI0 extends Dphsd2 {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Drawable f2140AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ColorStateList f2141AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final SparseArray f2142AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public boolean f2143AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public boolean f2144B25kr6;

    public BV3sI0(View view) {
        super(view);
        SparseArray sparseArray = new SparseArray(4);
        this.f2142AmA8tU = sparseArray;
        TextView textView = (TextView) view.findViewById(R.id.title);
        sparseArray.put(R.id.title, textView);
        sparseArray.put(R.id.summary, view.findViewById(R.id.summary));
        sparseArray.put(R.id.icon, view.findViewById(R.id.icon));
        sparseArray.put(2131296725, view.findViewById(2131296725));
        sparseArray.put(R.id.icon_frame, view.findViewById(R.id.icon_frame));
        this.f2140AcNBzu = view.getBackground();
        if (textView != null) {
            this.f2141AlLFFp = textView.getTextColors();
        }
    }

    public final View A2egSU(int i) {
        SparseArray sparseArray = this.f2142AmA8tU;
        View view = (View) sparseArray.get(i);
        if (view != null) {
            return view;
        }
        View findViewById = this.itemView.findViewById(i);
        if (findViewById != null) {
            sparseArray.put(i, findViewById);
        }
        return findViewById;
    }
}
