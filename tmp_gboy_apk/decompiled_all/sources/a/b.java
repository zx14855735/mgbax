package a;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.octopus.ad.DrawAd;
import com.octopus.ad.DrawAdListener;
import com.octopus.ad.NativeAdResponse;
import io.dcloud.api.custom.base.UniAdSlot;
import io.dcloud.api.custom.type.draw.UniAdCustomDrawAdLoader;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class b extends UniAdCustomDrawAdLoader {

    /* renamed from: a, reason: collision with root package name */
    public final String f7920a = getClass().getSimpleName();
    public DrawAd b;

    public class a implements DrawAdListener {
        public a() {
        }

        @Override // com.octopus.ad.NativeAdListener
        public void onAdFailed(int i) {
            String unused = b.this.f7920a;
            b.this.onLoadFail(i, String.valueOf(i));
        }

        @Override // com.octopus.ad.NativeAdListener
        public void onAdLoaded(NativeAdResponse nativeAdResponse) {
            String unused = b.this.f7920a;
            ArrayList arrayList = new ArrayList();
            a.a aVar = new a.a(b.this.b, nativeAdResponse);
            if (b.this.getBidType() == 1) {
                aVar.setBidPrice(b.this.b.getPrice());
            }
            arrayList.add(aVar);
            b.this.onLoadSuccess(arrayList);
        }
    }

    @Override // io.dcloud.api.custom.type.UniAdCustomBaseLoader
    public void load(Activity activity, UniAdSlot uniAdSlot) {
        if (TextUtils.isEmpty(uniAdSlot.getSlotId())) {
            onLoadFail(MediationConstant.ErrorCode.ADN_INIT_FAIL, "SlotId is empty!");
            return;
        }
        DrawAd drawAd = new DrawAd(activity, uniAdSlot.getSlotId(), new a());
        this.b = drawAd;
        drawAd.openAdInNativeBrowser(true);
        this.b.loadAd();
    }
}
