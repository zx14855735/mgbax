package androidx.core.app;

import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh extends SharedElementCallback {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final D07BeM f8472A2egSU;

    public ASJ6gh(D07BeM d07BeM) {
        this.f8472A2egSU = d07BeM;
    }

    @Override // android.app.SharedElementCallback
    public final Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
        Parcelable parcelable;
        float f;
        int round;
        Bitmap bitmap;
        D07BeM d07BeM = this.f8472A2egSU;
        d07BeM.getClass();
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            Drawable drawable = imageView.getDrawable();
            Drawable background = imageView.getBackground();
            if (drawable != null && background == null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                    parcelable = null;
                    f = 1048576.0f;
                    bitmap = null;
                } else {
                    float min = Math.min(1.0f, 1048576.0f / (intrinsicWidth * intrinsicHeight));
                    if ((drawable instanceof BitmapDrawable) && min == 1.0f) {
                        bitmap = ((BitmapDrawable) drawable).getBitmap();
                        parcelable = null;
                        f = 1048576.0f;
                    } else {
                        int i = (int) (intrinsicWidth * min);
                        int i2 = (int) (intrinsicHeight * min);
                        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(createBitmap);
                        Rect bounds = drawable.getBounds();
                        int i3 = bounds.left;
                        int i4 = bounds.top;
                        parcelable = null;
                        int i5 = bounds.right;
                        int i6 = bounds.bottom;
                        f = 1048576.0f;
                        drawable.setBounds(0, 0, i, i2);
                        drawable.draw(canvas);
                        drawable.setBounds(i3, i4, i5, i6);
                        bitmap = createBitmap;
                    }
                }
                if (bitmap != null) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("sharedElement:snapshot:bitmap", bitmap);
                    bundle.putString("sharedElement:snapshot:imageScaleType", imageView.getScaleType().toString());
                    if (imageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                        float[] fArr = new float[9];
                        imageView.getImageMatrix().getValues(fArr);
                        bundle.putFloatArray("sharedElement:snapshot:imageMatrix", fArr);
                    }
                    return bundle;
                }
                round = Math.round(rectF.width());
                int round2 = Math.round(rectF.height());
                if (round > 0 || round2 <= 0) {
                    return parcelable;
                }
                float min2 = Math.min(1.0f, f / (round * round2));
                int i7 = (int) (round * min2);
                int i8 = (int) (round2 * min2);
                if (d07BeM.f8564A2egSU == null) {
                    d07BeM.f8564A2egSU = new Matrix();
                }
                d07BeM.f8564A2egSU.set(matrix);
                d07BeM.f8564A2egSU.postTranslate(-rectF.left, -rectF.top);
                d07BeM.f8564A2egSU.postScale(min2, min2);
                Bitmap createBitmap2 = Bitmap.createBitmap(i7, i8, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                canvas2.concat(d07BeM.f8564A2egSU);
                view.draw(canvas2);
                return createBitmap2;
            }
        }
        parcelable = null;
        f = 1048576.0f;
        round = Math.round(rectF.width());
        int round22 = Math.round(rectF.height());
        if (round > 0) {
        }
        return parcelable;
    }

    @Override // android.app.SharedElementCallback
    public final View onCreateSnapshotView(Context context, Parcelable parcelable) {
        this.f8472A2egSU.getClass();
        if (!(parcelable instanceof Bundle)) {
            if (!(parcelable instanceof Bitmap)) {
                return null;
            }
            ImageView imageView = new ImageView(context);
            imageView.setImageBitmap((Bitmap) parcelable);
            return imageView;
        }
        Bundle bundle = (Bundle) parcelable;
        Bitmap bitmap = (Bitmap) bundle.getParcelable("sharedElement:snapshot:bitmap");
        if (bitmap == null) {
            return null;
        }
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageBitmap(bitmap);
        imageView2.setScaleType(ImageView.ScaleType.valueOf(bundle.getString("sharedElement:snapshot:imageScaleType")));
        if (imageView2.getScaleType() == ImageView.ScaleType.MATRIX) {
            float[] floatArray = bundle.getFloatArray("sharedElement:snapshot:imageMatrix");
            Matrix matrix = new Matrix();
            matrix.setValues(floatArray);
            imageView2.setImageMatrix(matrix);
        }
        return imageView2;
    }

    @Override // android.app.SharedElementCallback
    public final void onMapSharedElements(List list, Map map) {
        this.f8472A2egSU.getClass();
    }

    @Override // android.app.SharedElementCallback
    public final void onRejectSharedElements(List list) {
        this.f8472A2egSU.getClass();
    }

    @Override // android.app.SharedElementCallback
    public final void onSharedElementEnd(List list, List list2, List list3) {
        this.f8472A2egSU.getClass();
    }

    @Override // android.app.SharedElementCallback
    public final void onSharedElementStart(List list, List list2, List list3) {
        this.f8472A2egSU.getClass();
    }

    @Override // android.app.SharedElementCallback
    public final void onSharedElementsArrived(List list, List list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        this.f8472A2egSU.getClass();
        A4TApA.A2egSU(onSharedElementsReadyListener);
    }
}
