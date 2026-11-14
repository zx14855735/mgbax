package com.kwad.components.offline.api.tk;

import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.sdk.commercial.d;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class TkLoggerReporter {

    public static final class Holder {
        private static final TkLoggerReporter sInstance = new TkLoggerReporter();

        static {
            Zuyi();
        }

        private Holder() {
        }

        private static /* synthetic */ void Zuyi() {
            char[] charArray = "p|~=tr~v=q|j=`{v\u007f\u007f=Y}zQazwtv".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 19);
            }
            String str = new String(charArray);
            char[] charArray2 = "p\u007fz}zg".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 19);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static TkLoggerReporter get() {
        return Holder.sInstance;
    }

    private void reportEvent(String str, String str2, JSONObject jSONObject, d dVar) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(dVar);
    }

    public final void reportTKDownload(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(d.FH().cR(str).i(0.1d).O("ad_tk_download_performance", "download_state").i(jSONObject));
    }

    public final void reportTKPerform(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(d.FH().cR(str).i(0.1d).k(0.001d).O("ad_tk_render_performance", "render_state").i(jSONObject));
    }

    public final void reportTKSODownload(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(d.FH().cR(str).i(0.1d).O("ad_tk_so_download_event", "download_state").i(jSONObject));
    }

    public final void reportTKSOLoad(String str, JSONObject jSONObject) {
        OfflineHostProvider.getApi().loggerReporter().reportEvent(d.FH().cR(str).i(0.1d).O("ad_tk_so_load_performence", "download_state").i(jSONObject));
    }

    private TkLoggerReporter() {
    }
}
