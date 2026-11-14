package com.fl.saas.base.cache;

import android.app.Activity;
import android.content.Context;
import com.fl.saas.api.AdParams;
import com.fl.saas.base.base.BaseBuilder;
import com.fl.saas.base.interfaces.PreloadDoneCallback;
import com.fl.saas.base.manager.MixNativeManager;
import com.fl.saas.base.manager.api.ManagerAPI;
import com.fl.saas.base.rest.ConfigHelper;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.saas.bean.AdPlace;
import com.fl.saas.common.saas.bean.PreAdPlace;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class PreloadHelper {
    private static WeakReference<Context> contextRef;
    private static int index;
    private static boolean isRequest;
    private static PreloadHelper sInstance;
    private List<PreAdPlace> adPlaces;

    public static PreloadHelper getInstance() {
        if (sInstance == null) {
            synchronized (PreloadHelper.class) {
                sInstance = new PreloadHelper();
                contextRef = new WeakReference<>(DeviceUtil.getContext());
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: next, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void lambda$requestAd$1(List<PreAdPlace> list) {
        int i = index + 1;
        index = i;
        if (i < list.size()) {
            requestAd(list);
        }
    }

    private void requestAd(final List<PreAdPlace> list) {
        AdPlace adPlace;
        WeakReference<Context> weakReference;
        BaseBuilder<?> createDefaultBuilder;
        PreAdPlace preAdPlace = list.get(index);
        if (preAdPlace != null && (adPlace = preAdPlace.getAdPlace()) != null && (weakReference = contextRef) != null && weakReference.get() != null) {
            Context context = contextRef.get();
            int position = preAdPlace.getPosition();
            if (position == 10) {
                String str = adPlace.place_id;
                String reqID = DeviceUtil.getReqID(str);
                AdPlace cloneObject = adPlace.cloneObject(reqID);
                ConfigHelper.getInstance().sdkTrafficReq(reqID, str, adPlace.group_id, adPlace.test_id, adPlace.track_id, true, 0L);
                MixNativeManager mixNativeManager = new MixNativeManager(context, new AdParams.Builder(adPlace.place_id).build(), null);
                final int i = 0;
                mixNativeManager.preload(cloneObject, new PreloadDoneCallback(this) { // from class: com.fl.saas.base.cache.A2egSU

                    /* renamed from: AlLFFp, reason: collision with root package name */
                    public final /* synthetic */ PreloadHelper f10739AlLFFp;

                    {
                        this.f10739AlLFFp = this;
                    }

                    @Override // com.fl.saas.base.interfaces.PreloadDoneCallback
                    public final void preloadDone() {
                        switch (i) {
                            case 0:
                                this.f10739AlLFFp.lambda$requestAd$0(list);
                                break;
                            default:
                                this.f10739AlLFFp.lambda$requestAd$1(list);
                                break;
                        }
                    }
                });
            } else {
                AdType fromPosition = AdType.fromPosition(position);
                if (fromPosition != null) {
                    String str2 = adPlace.place_id;
                    String reqID2 = DeviceUtil.getReqID(str2);
                    AdPlace cloneObject2 = adPlace.cloneObject(reqID2);
                    ConfigHelper.getInstance().sdkTrafficReq(reqID2, str2, adPlace.group_id, adPlace.test_id, adPlace.track_id, true, 0L);
                    ManagerAPI managerAPI = (ManagerAPI) fromPosition.createManager();
                    if (managerAPI != null && context != null && (createDefaultBuilder = fromPosition.createDefaultBuilder(context)) != null) {
                        final int i2 = 1;
                        managerAPI.preload(createDefaultBuilder, cloneObject2, new PreloadDoneCallback(this) { // from class: com.fl.saas.base.cache.A2egSU

                            /* renamed from: AlLFFp, reason: collision with root package name */
                            public final /* synthetic */ PreloadHelper f10739AlLFFp;

                            {
                                this.f10739AlLFFp = this;
                            }

                            @Override // com.fl.saas.base.interfaces.PreloadDoneCallback
                            public final void preloadDone() {
                                switch (i2) {
                                    case 0:
                                        this.f10739AlLFFp.lambda$requestAd$0(list);
                                        break;
                                    default:
                                        this.f10739AlLFFp.lambda$requestAd$1(list);
                                        break;
                                }
                            }
                        });
                        return;
                    }
                }
            }
        }
        lambda$requestAd$1(list);
    }

    public void addAdPlace(List<PreAdPlace> list) {
        this.adPlaces = list;
        AdCacheManager.getInstance().addAdPlace(this.adPlaces);
    }

    public Context getContext() {
        WeakReference<Context> weakReference = contextRef;
        if (weakReference != null && weakReference.get() != null) {
            Context context = contextRef.get();
            if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                return context;
            }
        }
        return DeviceUtil.getContext();
    }

    public synchronized void requestPreloadAd() {
        List<PreAdPlace> list = this.adPlaces;
        if (list != null && !list.isEmpty()) {
            if (isRequest) {
                LogcatUtil.d("YdSDK-Cache", "PreloadAd has been requested");
                return;
            }
            LogcatUtil.d("YdSDK-Cache", "Start PreloadAd");
            isRequest = true;
            index = 0;
            requestAd(this.adPlaces);
            return;
        }
        LogcatUtil.d("YdSDK-Cache", "PreloadAd place is null");
    }

    public void setPreLoadContext(Context context) {
        if (context != null) {
            contextRef = new WeakReference<>(context);
        }
    }
}
