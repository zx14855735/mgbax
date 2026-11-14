package com.sigmob.sdk.nativead;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigImage;
import com.sigmob.sdk.base.models.SigVideo;
import com.sigmob.sdk.base.models.WindAdMetaData;
import com.sigmob.sdk.base.models.rtb.ResponseNativeAd;
import com.sigmob.windad.natives.AdAppInfo;
import com.sigmob.windad.natives.NativeADEventListener;
import com.sigmob.windad.natives.WindNativeAdData;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ag implements WindNativeAdData {

    /* renamed from: a, reason: collision with root package name */
    private final String f13601a;
    private final String b;
    private final String c;
    private final List<SigImage> d;
    private final SigVideo e;
    private int f;
    private final ab g;
    private final AdAppInfo h;

    public ag(BaseAdUnit baseAdUnit) {
        this.f13601a = baseAdUnit.getTitle();
        this.b = baseAdUnit.getDesc();
        this.c = baseAdUnit.getIconUrl();
        this.d = baseAdUnit.getImageUrlList();
        ResponseNativeAd nativeAd = baseAdUnit.getNativeAd();
        if (com.sigmob.sdk.base.utils.q.b(nativeAd)) {
            this.f = nativeAd.type.intValue();
        }
        this.h = baseAdUnit.getAdAppInfo();
        this.e = baseAdUnit.getNativeVideo();
        ab abVar = new ab();
        this.g = abVar;
        abVar.a(baseAdUnit, this);
    }

    public String a() {
        return "sigmob";
    }

    public double b() {
        ab abVar = this.g;
        if (abVar == null) {
            return 0.0d;
        }
        return abVar.s();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void bindImageViews(List<ImageView> list, int i) {
        ab abVar = this.g;
        if (abVar == null) {
            return;
        }
        abVar.a(list, i);
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void bindMediaView(ViewGroup viewGroup, WindNativeAdData.NativeADMediaListener nativeADMediaListener) {
        ab abVar = this.g;
        if (abVar == null) {
            return;
        }
        abVar.b(viewGroup, nativeADMediaListener);
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void bindMediaViewWithoutAppInfo(ViewGroup viewGroup, WindNativeAdData.NativeADMediaListener nativeADMediaListener) {
        ab abVar = this.g;
        if (abVar == null) {
            return;
        }
        abVar.a(viewGroup, nativeADMediaListener);
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void bindViewForInteraction(View view, List<View> list, List<View> list2, View view2, NativeADEventListener nativeADEventListener) {
        ab abVar = this.g;
        if (abVar == null) {
            return;
        }
        abVar.a(view, list, list2, view2, nativeADEventListener);
    }

    public double c() {
        ab abVar = this.g;
        if (abVar == null) {
            return 0.0d;
        }
        return abVar.t();
    }

    public int d() {
        ab abVar = this.g;
        if (abVar == null) {
            return 0;
        }
        return abVar.p();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void destroy() {
        ab abVar = this.g;
        if (abVar == null) {
            return;
        }
        abVar.w();
    }

    public int e() {
        ab abVar = this.g;
        if (abVar == null) {
            return 0;
        }
        return abVar.u();
    }

    public int f() {
        return this.f;
    }

    public void g() {
        ab abVar = this.g;
        if (abVar == null) {
            return;
        }
        abVar.v();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public AdAppInfo getAdAppInfo() {
        return this.h;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public Bitmap getAdLogo() {
        ab abVar = this.g;
        if (abVar == null) {
            return null;
        }
        return abVar.B();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public int getAdPatternType() {
        return this.f;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public View getAdView() {
        ab abVar = this.g;
        if (abVar == null) {
            return null;
        }
        return abVar.q();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getCTAText() {
        ab abVar = this.g;
        return abVar == null ? "" : abVar.A();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getDesc() {
        return this.b;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getEcpm() {
        ab abVar = this.g;
        return abVar == null ? "" : abVar.H();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getIconUrl() {
        return this.c;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public List<SigImage> getImageList() {
        return this.d;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public int getInteractionType() {
        ab abVar = this.g;
        if (abVar == null) {
            return 0;
        }
        return abVar.z();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getTitle() {
        return this.f13601a;
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public String getVideoCoverImageUrl() {
        ab abVar = this.g;
        if (abVar == null) {
            return null;
        }
        return abVar.I();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public int getVideoHeight() {
        SigVideo sigVideo = this.e;
        if (sigVideo == null) {
            return 0;
        }
        return sigVideo.getHeight();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public int getVideoWidth() {
        SigVideo sigVideo = this.e;
        if (sigVideo == null) {
            return 0;
        }
        return sigVideo.getWidth();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public WindAdMetaData getWindAdMetaData() {
        ab abVar = this.g;
        if (abVar == null) {
            return null;
        }
        return abVar.J();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void pauseVideo() {
        ab abVar = this.g;
        if (abVar == null) {
            return;
        }
        abVar.D();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void resumeVideo() {
        ab abVar = this.g;
        if (abVar == null) {
            return;
        }
        abVar.F();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void setDislikeInteractionCallback(Activity activity, WindNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        ab abVar = this.g;
        if (abVar == null) {
            return;
        }
        abVar.a(dislikeInteractionCallback);
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void startVideo() {
        ab abVar = this.g;
        if (abVar == null) {
            return;
        }
        abVar.C();
    }

    @Override // com.sigmob.windad.natives.WindNativeAdData
    public void stopVideo() {
        ab abVar = this.g;
        if (abVar == null) {
            return;
        }
        abVar.G();
    }
}
