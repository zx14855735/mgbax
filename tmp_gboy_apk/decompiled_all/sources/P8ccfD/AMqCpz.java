package P8ccfD;

import android.view.View;
import com.google.android.material.search.SearchView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class AMqCpz implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f6965AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ SearchView f6966AlLFFp;

    public /* synthetic */ AMqCpz(SearchView searchView, int i) {
        this.f6965AcNBzu = i;
        this.f6966AlLFFp = searchView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SearchView searchView = this.f6966AlLFFp;
        switch (this.f6965AcNBzu) {
            case 0:
                searchView.f11769BChYOn.setText("");
                searchView.AZkASS();
                break;
            case 1:
                int i = SearchView.f11758Cd8JRx;
                searchView.AcNBzu();
                break;
            default:
                int i2 = SearchView.f11758Cd8JRx;
                searchView.ASJ6gh();
                break;
        }
    }
}
