package ADYaiT;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController$RecycleListView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz implements AdapterView.OnItemClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ AlertController$RecycleListView f20AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AcNBzu f21AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f22AmA8tU;

    public AYUAbz(AZOQYO azoqyo, AlertController$RecycleListView alertController$RecycleListView, AcNBzu acNBzu) {
        this.f22AmA8tU = azoqyo;
        this.f20AcNBzu = alertController$RecycleListView;
        this.f21AlLFFp = acNBzu;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        AZOQYO azoqyo = this.f22AmA8tU;
        boolean[] zArr = azoqyo.f42B9tovu;
        AlertController$RecycleListView alertController$RecycleListView = this.f20AcNBzu;
        if (zArr != null) {
            zArr[i] = alertController$RecycleListView.isItemChecked(i);
        }
        azoqyo.f46BJ7GGh.onClick(this.f21AlLFFp.f50A4TApA, i, alertController$RecycleListView.isItemChecked(i));
    }
}
