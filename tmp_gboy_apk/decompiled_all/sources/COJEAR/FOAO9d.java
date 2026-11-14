package COJEAR;

import android.view.Window;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.fl.saas.videocache.ProxyCacheUtils;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class FOAO9d extends FM663C {
    @Override // JrXYwF.A4TApA
    public final boolean CcAIMM() {
        return (this.f1748AZkASS.getDecorView().getSystemUiVisibility() & ProxyCacheUtils.DEFAULT_BUFFER_SIZE) != 0;
    }

    @Override // JrXYwF.A4TApA
    public final void D6yqiO(boolean z) {
        if (!z) {
            EdQ5bb(ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
            return;
        }
        Window window = this.f1748AZkASS;
        window.clearFlags(TTAdConstant.KEY_CLICK_AREA);
        window.addFlags(Integer.MIN_VALUE);
        EY4UKY(ProxyCacheUtils.DEFAULT_BUFFER_SIZE);
    }
}
