package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import androidx.appcompat.R$styleable;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AlertController$RecycleListView extends ListView {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final int f8041AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final int f8042AlLFFp;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f8033B9tovu);
        this.f8042AlLFFp = obtainStyledAttributes.getDimensionPixelOffset(0, -1);
        this.f8041AcNBzu = obtainStyledAttributes.getDimensionPixelOffset(1, -1);
    }
}
