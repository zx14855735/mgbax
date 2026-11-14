package ADYaiT;

import android.R;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController$RecycleListView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z extends ArrayAdapter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ AlertController$RecycleListView f16A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f17A4TApA;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ARc23Z(AZOQYO azoqyo, ContextThemeWrapper contextThemeWrapper, int i, CharSequence[] charSequenceArr, AlertController$RecycleListView alertController$RecycleListView) {
        super(contextThemeWrapper, i, R.id.text1, charSequenceArr);
        this.f17A4TApA = azoqyo;
        this.f16A2egSU = alertController$RecycleListView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        boolean[] zArr = this.f17A4TApA.f42B9tovu;
        if (zArr != null && zArr[i]) {
            this.f16A2egSU.setItemChecked(i, true);
        }
        return view2;
    }
}
