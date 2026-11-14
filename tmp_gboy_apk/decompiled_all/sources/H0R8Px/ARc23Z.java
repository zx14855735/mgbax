package H0R8Px;

import android.graphics.Bitmap;
import android.util.LruCache;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ARc23Z extends LruCache {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f3151A2egSU;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ARc23Z(int i, int i2) {
        super(i);
        this.f3151A2egSU = i2;
    }

    @Override // android.util.LruCache
    public final int sizeOf(Object obj, Object obj2) {
        switch (this.f3151A2egSU) {
            case 0:
                Bitmap bitmap = (Bitmap) obj2;
                return bitmap.getHeight() * bitmap.getRowBytes();
            default:
                return 1;
        }
    }
}
