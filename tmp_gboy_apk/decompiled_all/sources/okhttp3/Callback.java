package okhttp3;

import java.io.IOException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public interface Callback {
    void onFailure(Call call, IOException iOException);

    void onResponse(Call call, Response response);
}
