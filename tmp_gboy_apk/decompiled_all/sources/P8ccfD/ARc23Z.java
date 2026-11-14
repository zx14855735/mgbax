package P8ccfD;

import COJEAR.DG07BK;
import COJEAR.Ff5QvW;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.google.android.material.search.SearchView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final /* synthetic */ class ARc23Z implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f6967AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ SearchView f6968AlLFFp;

    public /* synthetic */ ARc23Z(SearchView searchView, int i) {
        this.f6967AcNBzu = i;
        this.f6968AlLFFp = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ff5QvW AZkASS2;
        Ff5QvW AZkASS3;
        switch (this.f6967AcNBzu) {
            case 0:
                SearchView searchView = this.f6968AlLFFp;
                EditText editText = searchView.f11769BChYOn;
                if (editText.requestFocus()) {
                    editText.sendAccessibilityEvent(8);
                }
                if (searchView.f11784CQhlFr && (AZkASS2 = DG07BK.AZkASS(editText)) != null) {
                    AZkASS2.f1753A2egSU.DXnQ0V();
                    break;
                } else {
                    ((InputMethodManager) BPw6Q8.ASJ6gh.ADYaiT(editText.getContext(), InputMethodManager.class)).showSoftInput(editText, 1);
                    break;
                }
                break;
            case 1:
                SearchView searchView2 = this.f6968AlLFFp;
                EditText editText2 = searchView2.f11769BChYOn;
                editText2.clearFocus();
                if (searchView2.f11784CQhlFr && (AZkASS3 = DG07BK.AZkASS(editText2)) != null) {
                    AZkASS3.f1753A2egSU.CTkVKb();
                    break;
                } else {
                    InputMethodManager inputMethodManager = (InputMethodManager) BPw6Q8.ASJ6gh.ADYaiT(editText2.getContext(), InputMethodManager.class);
                    if (inputMethodManager != null) {
                        inputMethodManager.hideSoftInputFromWindow(editText2.getWindowToken(), 0);
                        break;
                    }
                }
                break;
            case 2:
                this.f6968AlLFFp.AcNBzu();
                break;
            default:
                this.f6968AlLFFp.AZkASS();
                break;
        }
    }
}
