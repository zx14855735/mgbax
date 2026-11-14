package com.fl.saas.base.adapter;

import android.os.Looper;
import com.fl.saas.base.annotation.Advertiser;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.Iterator;
import java.util.ServiceLoader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class AdapterManager {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$preInitAdapter$0() {
        Iterator it = ServiceLoader.load(AdapterPreInitialize.class, DeviceUtil.getContext().getClassLoader()).iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            try {
                AdapterPreInitialize adapterPreInitialize = (AdapterPreInitialize) it.next();
                Advertiser advertiser = (Advertiser) adapterPreInitialize.getClass().getAnnotation(Advertiser.class);
                if (advertiser != null) {
                    try {
                        for (Class<?> cls : advertiser.keyClass()) {
                            if (cls != Object.class) {
                                LogcatUtil.d(cls.toString());
                            }
                        }
                        adapterPreInitialize.preInit(DeviceUtil.getContext());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    adapterPreInitialize.preInit(DeviceUtil.getContext());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void preInitAdapter() {
        Looper.myQueue().addIdleHandler(new AcNBzu());
    }
}
