package a;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.octopus.ad.NativeAd;
import com.octopus.ad.NativeAdListener;
import com.octopus.ad.NativeAdResponse;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.feed.UniAdCustomNativeAdLoader;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f extends UniAdCustomNativeAdLoader {

    /* renamed from: a, reason: collision with root package name */
    public final String f7928a = getClass().getSimpleName();
    public NativeAd b;

    public class a implements NativeAdListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UniAdSlot f7929a;

        public a(UniAdSlot uniAdSlot) {
            this.f7929a = uniAdSlot;
        }

        @Override // com.octopus.ad.NativeAdListener
        public void onAdFailed(int i) {
            String unused = f.this.f7928a;
            f.this.onLoadFail(i, String.valueOf(i));
        }

        @Override // com.octopus.ad.NativeAdListener
        public void onAdLoaded(NativeAdResponse nativeAdResponse) {
            String unused = f.this.f7928a;
            ArrayList arrayList = new ArrayList();
            e eVar = new e(f.this.b, nativeAdResponse, this.f7929a.getWidth());
            if (f.this.getBidType() == 1) {
                eVar.setBidPrice(f.this.b.getPrice());
            }
            arrayList.add(eVar);
            f.this.onLoadSuccess(arrayList);
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void load(Activity activity, UniAdSlot uniAdSlot) {
        if (TextUtils.isEmpty(uniAdSlot.getSlotId())) {
            onLoadFail(MediationConstant.ErrorCode.ADN_INIT_FAIL, "SlotId is empty!");
            return;
        }
        NativeAd nativeAd = new NativeAd(activity, uniAdSlot.getSlotId(), new a(uniAdSlot));
        this.b = nativeAd;
        nativeAd.openAdInNativeBrowser(true);
        this.b.loadAd();
    }
}
