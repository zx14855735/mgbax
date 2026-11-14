package com.qq.e.ads.nativ;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.NativeAbstractAD;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class NativeUnifiedAD extends NativeAbstractAD<NUADI> {

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final AdListenerAdapter f12837B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public final NativeADUnifiedListener f12838B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public final ArrayList f12839B7CMnp = new ArrayList();

    /* renamed from: B9tovu, reason: collision with root package name */
    public List f12840B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public volatile int f12841BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public volatile int f12842BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public String f12843BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public LoadAdParams f12844BJ7GGh;

    public static class AdListenerAdapter implements ADListener {

        /* renamed from: A2egSU, reason: collision with root package name */
        public final NativeADUnifiedListener f12845A2egSU;

        public AdListenerAdapter(NativeADUnifiedListener nativeADUnifiedListener) {
            this.f12845A2egSU = nativeADUnifiedListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            NativeADUnifiedListener nativeADUnifiedListener = this.f12845A2egSU;
            if (nativeADUnifiedListener != null) {
                int type = aDEvent.getType();
                if (type != 100) {
                    if (type != 101) {
                        return;
                    }
                    nativeADUnifiedListener.onNoAD(AdErrorConvertor.getAdError(aDEvent));
                    return;
                }
                List list = (List) aDEvent.getParam(List.class);
                if (list == null || list.size() <= 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new NativeUnifiedADDataAdapter((NativeUnifiedADData) it.next()));
                }
                nativeADUnifiedListener.onADLoaded(arrayList);
            }
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener) {
        this.f12838B4ZgIw = nativeADUnifiedListener;
        this.f12837B3GDIM = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str);
    }

    public final void A4TApA(int i, boolean z) {
        if (a()) {
            if (!b()) {
                if (z) {
                    this.f12839B7CMnp.add(Integer.valueOf(i));
                    return;
                }
                return;
            }
            T t = this.f12733a;
            if (t != 0) {
                LoadAdParams loadAdParams = this.f12844BJ7GGh;
                NUADI nuadi = (NUADI) t;
                if (loadAdParams != null) {
                    nuadi.loadData(i, loadAdParams);
                } else {
                    nuadi.loadData(i);
                }
            }
        }
    }

    @Override // com.qq.e.ads.AbstractAD
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public NUADI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeAdManagerDelegate(context, str, str2, str3, this.f12837B3GDIM);
    }

    public String getAdNetWorkName() {
        T t = this.f12733a;
        if (t != 0) {
            return ((NUADI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    public void loadData(int i) {
        A4TApA(i, true);
    }

    public void setCategories(List<String> list) {
        this.f12840B9tovu = list;
        T t = this.f12733a;
        if (t == 0 || list == null) {
            return;
        }
        ((NUADI) t).setCategories(list);
    }

    public void setMaxVideoDuration(int i) {
        this.f12842BI9f7h = i;
        if (this.f12842BI9f7h > 0 && this.f12841BChYOn > this.f12842BI9f7h) {
            GDTLogger.e("maxVideoDuration 设置值非法，不得小于minVideoDuration");
        }
        T t = this.f12733a;
        if (t != 0) {
            ((NUADI) t).setMaxVideoDuration(this.f12842BI9f7h);
        }
    }

    public void setMinVideoDuration(int i) {
        this.f12841BChYOn = i;
        if (this.f12842BI9f7h > 0 && this.f12841BChYOn > this.f12842BI9f7h) {
            GDTLogger.e("minVideoDuration 设置值非法，不得大于maxVideoDuration");
        }
        T t = this.f12733a;
        if (t != 0) {
            ((NUADI) t).setMinVideoDuration(this.f12841BChYOn);
        }
    }

    public void setVastClassName(String str) {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("Vast class name 不能为空");
            return;
        }
        this.f12843BIYEnU = str;
        T t = this.f12733a;
        if (t != 0) {
            ((NUADI) t).setVastClassName(str);
        }
    }

    public NativeUnifiedAD(Context context, String str, NativeADUnifiedListener nativeADUnifiedListener, String str2) {
        this.f12838B4ZgIw = nativeADUnifiedListener;
        this.f12837B3GDIM = new AdListenerAdapter(nativeADUnifiedListener);
        a(context, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i) {
        NativeADUnifiedListener nativeADUnifiedListener = this.f12838B4ZgIw;
        if (nativeADUnifiedListener != null) {
            nativeADUnifiedListener.onNoAD(AdErrorConvertor.formatErrorCode(i));
        }
    }

    public void loadData(int i, LoadAdParams loadAdParams) {
        this.f12844BJ7GGh = loadAdParams;
        loadData(i);
    }

    @Override // com.qq.e.ads.NativeAbstractAD, com.qq.e.ads.AbstractAD
    public void a(NUADI nuadi) {
        super.a((NativeUnifiedAD) nuadi);
        nuadi.setMinVideoDuration(this.f12841BChYOn);
        nuadi.setMaxVideoDuration(this.f12842BI9f7h);
        nuadi.setVastClassName(this.f12843BIYEnU);
        List<String> list = this.f12840B9tovu;
        if (list != null) {
            setCategories(list);
        }
        Iterator it = this.f12839B7CMnp.iterator();
        while (it.hasNext()) {
            A4TApA(((Integer) it.next()).intValue(), false);
        }
    }
}
