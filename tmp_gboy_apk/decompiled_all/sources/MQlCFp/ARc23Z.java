package MQlCFp;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.Dphsd2;
import com.google.android.material.carousel.MaskableFrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ARc23Z extends Dphsd2 {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final ImageView f5147AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final MaskableFrameLayout f5148AlLFFp;

    public ARc23Z(View view) {
        super(view);
        ImageView imageView = (ImageView) view.findViewById(2131296472);
        this.f5147AcNBzu = imageView;
        this.f5148AlLFFp = (MaskableFrameLayout) view.findViewById(2131296473);
        if (imageView != null) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }
}
