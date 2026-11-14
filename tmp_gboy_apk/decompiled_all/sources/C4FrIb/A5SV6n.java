package C4FrIb;

import com.fl.saas.base.cache.AdCacheManager;
import com.fl.saas.base.cache.AdCacheValue;
import com.fl.saas.base.manager.loader.AdViewManager;
import com.fl.saas.common.saas.bean.AdSource;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.a.aaaaaaao;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.aaauaaaa.aaaaaaaa;
import io.dcloud.openapi.aaaaaaaa.aaaoaaaa.b.aaaaaaa0;
import io.dcloud.openapi.core.module.DCBaseAOL;
import java.util.Comparator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final /* synthetic */ class A5SV6n implements Comparator {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f1550AcNBzu;

    public /* synthetic */ A5SV6n(int i) {
        this.f1550AcNBzu = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int lambda$addCacheAd$0;
        int lambda$addPlaceCacheAd$1;
        int lambda$setCacheAd$1;
        int aaaaaaaa;
        int aaaaaaaa2;
        switch (this.f1550AcNBzu) {
            case 0:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i = 0; i < bArr.length; i++) {
                    byte b = bArr[i];
                    byte b2 = bArr2[i];
                    if (b != b2) {
                        return b - b2;
                    }
                }
                return 0;
            case 1:
                return ((Double) obj).compareTo((Double) obj2);
            case 2:
                lambda$addCacheAd$0 = AdCacheManager.lambda$addCacheAd$0((AdCacheValue) obj, (AdCacheValue) obj2);
                return lambda$addCacheAd$0;
            case 3:
                lambda$addPlaceCacheAd$1 = AdCacheManager.lambda$addPlaceCacheAd$1((AdCacheValue) obj, (AdCacheValue) obj2);
                return lambda$addPlaceCacheAd$1;
            case 4:
                lambda$setCacheAd$1 = AdViewManager.lambda$setCacheAd$1((AdSource) obj, (AdSource) obj2);
                return lambda$setCacheAd$1;
            case 5:
                aaaaaaaa = aaaaaaao.aaaaaaaa((DCBaseAOL) obj, (DCBaseAOL) obj2);
                return aaaaaaaa;
            default:
                aaaaaaaa2 = aaaaaaaa.aaaaaaaa((aaaaaaa0) obj, (aaaaaaa0) obj2);
                return aaaaaaaa2;
        }
    }
}
