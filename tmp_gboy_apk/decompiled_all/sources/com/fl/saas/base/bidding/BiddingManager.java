package com.fl.saas.base.bidding;

import com.fl.saas.base.adapter.MixNativeHandler;
import com.fl.saas.base.annotation.Advertiser;
import com.fl.saas.base.annotation.BiddingHandler;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.base.type.AdType;
import com.fl.saas.common.util.SPILoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class BiddingManager {
    private static final Map<Integer, Constructor<? extends Bidding>> biddingMap = new HashMap();
    private static final Map<Integer, Constructor<? extends Bidding>> handleMap = new HashMap();
    private static final Map<Integer, Map<AdType, Constructor<? extends Bidding>>> adapterBidding = new HashMap();

    public static final class Holder {
        private static final BiddingManager INSTANCE = new BiddingManager();

        static {
            aVlETVq();
        }

        private Holder() {
        }

        private static /* synthetic */ void aVlETVq() {
            char[] charArray = "\u001a\u0016\u0014W\u001e\u0018\u0014\u001cW\u001b\u0016\u0000W\n\u0011\u001c\u0015\u0015W3\u0017\u0010;\u000b\u0010\u001d\u001e\u001c".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'y');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u001a\u0015\u0010\u0017\u0010\r".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'y');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    static {
        cBQIe();
    }

    private BiddingManager() {
        registerBiddingHandle();
    }

    private static /* synthetic */ void cBQIe() {
        char[] charArray = "\u0018\u0014\u0016U\u001c\u001a\u0016\u001eU\u0019\u0014\u0002U\b\u0013\u001e\u0017\u0017U1\u0015\u00129\t\u0012\u001f\u001c\u001e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '{');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0018\u0017\u0012\u0015\u0012\u000f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '{');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private int getAdvId(Advertiser advertiser) {
        int value = advertiser.value();
        return value == -1 ? advertiser.custom() : value;
    }

    public static BiddingManager getInstance() {
        return Holder.INSTANCE;
    }

    private void registerAdapterTypeBidding(Class<? extends Bidding> cls) {
        Advertiser advertiser = (Advertiser) cls.getAnnotation(Advertiser.class);
        if (advertiser == null) {
            return;
        }
        int advId = getAdvId(advertiser);
        Constructor<? extends Bidding> constructor = cls.getConstructor(new Class[0]);
        Map<Integer, Map<AdType, Constructor<? extends Bidding>>> map = adapterBidding;
        Map<AdType, Constructor<? extends Bidding>> map2 = map.get(Integer.valueOf(advId));
        if (map2 == null) {
            map2 = new HashMap<>();
            map.put(Integer.valueOf(advId), map2);
        }
        map2.put(AdType.getType(cls), constructor);
    }

    private void registerBidding(Class<? extends Bidding> cls) {
        int advId;
        BiddingHandler biddingHandler = (BiddingHandler) cls.getAnnotation(BiddingHandler.class);
        if (biddingHandler == null) {
            return;
        }
        int value = biddingHandler.value();
        Constructor<? extends Bidding> constructor = cls.getConstructor(new Class[0]);
        biddingMap.put(Integer.valueOf(value), constructor);
        Class<? extends AdapterAPI>[] extend = biddingHandler.extend();
        if (extend == null || extend.length == 0) {
            return;
        }
        for (Class<? extends AdapterAPI> cls2 : extend) {
            Advertiser advertiser = (Advertiser) cls2.getAnnotation(Advertiser.class);
            if (advertiser != null && (advId = getAdvId(advertiser)) > 0) {
                biddingMap.put(Integer.valueOf(advId), constructor);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void registerBiddingHandle() {
        try {
            Iterator<String> it = SPILoader.loadSPINames(getClass().getClassLoader(), Bidding.class).iterator();
            while (it.hasNext()) {
                Class<?> cls = Class.forName(it.next());
                if (Bidding.class.isAssignableFrom(cls)) {
                    if (AdapterAPI.class.isAssignableFrom(cls)) {
                        registerAdapterTypeBidding(cls);
                    } else if (MixNativeHandler.class.isAssignableFrom(cls)) {
                        registerMixNativeTypeBidding(cls);
                    } else {
                        registerBidding(cls);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerMixNativeTypeBidding(Class<? extends Bidding> cls) {
        Advertiser advertiser = (Advertiser) cls.getAnnotation(Advertiser.class);
        if (advertiser == null) {
            return;
        }
        int advId = getAdvId(advertiser);
        handleMap.put(Integer.valueOf(advId), cls.getConstructor(new Class[0]));
    }

    public Bidding loadBiddingHandle(AdType adType, int i) {
        Constructor<? extends Bidding> constructor;
        Constructor<? extends Bidding> constructor2 = biddingMap.get(Integer.valueOf(i));
        if (constructor2 == null) {
            if (adType == null) {
                Map<Integer, Constructor<? extends Bidding>> map = handleMap;
                if (map.containsKey(Integer.valueOf(i))) {
                    constructor = map.get(Integer.valueOf(i));
                    constructor2 = constructor;
                }
            }
            Map<Integer, Map<AdType, Constructor<? extends Bidding>>> map2 = adapterBidding;
            if (map2.containsKey(Integer.valueOf(i))) {
                constructor = map2.get(Integer.valueOf(i)).get(adType);
                constructor2 = constructor;
            }
        }
        if (constructor2 == null) {
            return null;
        }
        try {
            return constructor2.newInstance(new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
