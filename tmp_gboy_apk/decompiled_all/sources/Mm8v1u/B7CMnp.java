package Mm8v1u;

import android.view.View;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.Dphsd2;
import com.github.chrisbanes.photoview.PhotoView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class B7CMnp extends Dphsd2 {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final PhotoView f5508AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final ProgressBar f5509AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ B9tovu f5510AmA8tU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public B7CMnp(B9tovu b9tovu, View view) {
        super(view);
        this.f5510AmA8tU = b9tovu;
        PhotoView photoView = (PhotoView) view.findViewById(2131296733);
        this.f5508AcNBzu = photoView;
        this.f5509AlLFFp = (ProgressBar) view.findViewById(2131297778);
        photoView.setMaximumScale(5.0f);
        photoView.setMediumScale(3.0f);
        photoView.setOnViewTapListener(new AZkASS.ARc23Z(28, this));
        photoView.setOnLongClickListener(new B3GDIM(this));
    }
}
