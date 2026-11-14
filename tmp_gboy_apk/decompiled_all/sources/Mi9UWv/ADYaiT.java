package Mi9UWv;

import ADYaiT.AmA8tU;
import LLYwnm.AYUAbz;
import android.content.DialogInterface;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.game.boy.activity.EmulatorActivity;
import java.util.concurrent.ExecutorService;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT implements DialogInterface.OnDismissListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f5394AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f5395AlLFFp;

    public /* synthetic */ ADYaiT(int i, Object obj) {
        this.f5394AcNBzu = i;
        this.f5395AlLFFp = obj;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        AMqCpz aMqCpz;
        switch (this.f5394AcNBzu) {
            case 0:
                ASJ6gh aSJ6gh = (ASJ6gh) this.f5395AlLFFp;
                aSJ6gh.f5414BNL6CD = true;
                ExecutorService executorService = aSJ6gh.f5411BI9f7h;
                if (executorService != null) {
                    executorService.shutdownNow();
                    aSJ6gh.f5411BI9f7h = null;
                }
                aSJ6gh.f5404B25kr6.clear();
                SwipeRefreshLayout swipeRefreshLayout = aSJ6gh.f5405B2KMhB;
                if (swipeRefreshLayout != null) {
                    swipeRefreshLayout.setRefreshing(false);
                }
                AppCompatEditText appCompatEditText = aSJ6gh.f5406B3GDIM;
                if (appCompatEditText != null && (aMqCpz = aSJ6gh.f5407B4ZgIw) != null) {
                    appCompatEditText.removeTextChangedListener(aMqCpz);
                    aSJ6gh.f5407B4ZgIw = null;
                }
                AYUAbz aYUAbz = aSJ6gh.f5410BChYOn;
                if (aYUAbz != null) {
                    aYUAbz.f4630ARc23Z.remove(aSJ6gh.f5415BPw6Q8);
                }
                LHpdLt.AMqCpz aMqCpz2 = aSJ6gh.f5416BTvldC;
                if (aMqCpz2 != null) {
                    aMqCpz2.disable();
                    aSJ6gh.f5416BTvldC = null;
                }
                aSJ6gh.f5409B9tovu = null;
                AmA8tU amA8tU = aSJ6gh.f5408B7CMnp;
                if (amA8tU != null) {
                    amA8tU.setOnDismissListener(null);
                    aSJ6gh.f5408B7CMnp = null;
                }
                aSJ6gh.f5412BIYEnU = null;
                aSJ6gh.f5413BJ7GGh = null;
                aSJ6gh.f5406B3GDIM = null;
                aSJ6gh.f5405B2KMhB = null;
                break;
            default:
                EmulatorActivity emulatorActivity = (EmulatorActivity) this.f5395AlLFFp;
                emulatorActivity.unregisterReceiver(emulatorActivity.f11007BmvVmW);
                break;
        }
    }
}
