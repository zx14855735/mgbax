package com.qq.e.ads.immersive;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.AbstractAD;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.pi.IAFD;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class ImmersiveADFlow extends AbstractAD<IAFD> implements IAFD {

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final ImmersiveADFlowListener f12799B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final ADListenerAdapter f12800B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final Map f12801B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public VideoOption f12802B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public boolean f12803BChYOn = false;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public boolean f12804BI9f7h = false;

    public static class ADListenerAdapter implements ADListener {
        public ImmersiveADFlowListener adListener;

        public ADListenerAdapter(ImmersiveADFlowListener immersiveADFlowListener) {
            this.adListener = immersiveADFlowListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (this.adListener == null) {
                return;
            }
            switch (aDEvent.getType()) {
                case 100:
                    this.adListener.onADLoaded();
                    break;
                case 101:
                    AdError adError = AdErrorConvertor.getAdError(aDEvent);
                    this.adListener.onNoAD(adError);
                    if (adError.getErrorCode() == 6000) {
                        GDTLogger.e(getClass().getSimpleName().concat(":未找到RecyclerView依赖或当前不支持平板设备"));
                        break;
                    }
                    break;
                case 102:
                    this.adListener.onADPageShow();
                    break;
                case 103:
                    String str = (String) aDEvent.getParam(String.class);
                    this.adListener.onADExpose(str != null ? str : "");
                    break;
                case 105:
                    String str2 = (String) aDEvent.getParam(String.class);
                    this.adListener.onADClick(str2 != null ? str2 : "");
                    break;
                case 106:
                    this.adListener.onADPageDestroy();
                    break;
            }
        }
    }

    public ImmersiveADFlow(Context context, String str, ImmersiveADFlowListener immersiveADFlowListener, Map<String, String> map) {
        this.f12799B3GDIM = immersiveADFlowListener;
        this.f12800B4ZgIw = new ADListenerAdapter(immersiveADFlowListener);
        this.f12801B7CMnp = map;
        String str2 = map != null ? map.get("TOKEN") : "";
        if (TextUtils.isEmpty(str2)) {
            a(context, str);
        } else {
            a(context, str, str2);
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public IAFD a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getImmersiveADFlowDelegate(context, str, str2, str3, this.f12800B4ZgIw, this.f12801B7CMnp);
    }

    @Override // com.qq.e.comm.pi.IAFD
    public String getOperationInfo() {
        T t = this.f12733a;
        if (t != 0) {
            return ((IAFD) t).getOperationInfo();
        }
        a("getOperationInfo");
        return "";
    }

    @Override // com.qq.e.comm.pi.IAFD
    public void preloadImmersiveADFlow() {
        T t = this.f12733a;
        if (t != 0) {
            ((IAFD) t).preloadImmersiveADFlow();
        } else {
            this.f12803BChYOn = true;
        }
    }

    @Override // com.qq.e.comm.pi.IAFD
    public void setVideoOption(VideoOption videoOption) {
        this.f12802B9tovu = videoOption;
        T t = this.f12733a;
        if (t == 0 || videoOption == null) {
            return;
        }
        ((IAFD) t).setVideoOption(videoOption);
    }

    @Override // com.qq.e.comm.pi.IAFD
    public void showImmersiveADFlow() {
        T t = this.f12733a;
        if (t != 0) {
            ((IAFD) t).showImmersiveADFlow();
        } else {
            this.f12804BI9f7h = true;
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(IAFD iafd) {
        T t;
        T t2;
        T t3;
        VideoOption videoOption = this.f12802B9tovu;
        if (videoOption != null && (t3 = this.f12733a) != 0) {
            ((IAFD) t3).setVideoOption(videoOption);
        }
        if (this.f12804BI9f7h && (t2 = this.f12733a) != 0) {
            ((IAFD) t2).showImmersiveADFlow();
            this.f12804BI9f7h = false;
        } else {
            if (!this.f12803BChYOn || (t = this.f12733a) == 0) {
                return;
            }
            ((IAFD) t).preloadImmersiveADFlow();
            this.f12803BChYOn = false;
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        ImmersiveADFlowListener immersiveADFlowListener = this.f12799B3GDIM;
        if (immersiveADFlowListener != null) {
            immersiveADFlowListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }
}
