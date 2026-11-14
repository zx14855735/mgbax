package COJEAR;

import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class D8cQ8b implements OnReceiveContentListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final BPw6Q8 f1675A2egSU;

    public D8cQ8b(BPw6Q8 bPw6Q8) {
        this.f1675A2egSU = bPw6Q8;
    }

    @Override // android.view.OnReceiveContentListener
    public final ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
        AYUAbz aYUAbz = new AYUAbz(new AZkASS.ARc23Z(contentInfo));
        AYUAbz A2egSU2 = ((CikNvS.B4ZgIw) this.f1675A2egSU).A2egSU(view, aYUAbz);
        if (A2egSU2 == null) {
            return null;
        }
        if (A2egSU2 == aYUAbz) {
            return contentInfo;
        }
        ContentInfo B2KMhB2 = A2egSU2.f1624A2egSU.B2KMhB();
        Objects.requireNonNull(B2KMhB2);
        return ADYaiT.ASJ6gh(B2KMhB2);
    }
}
