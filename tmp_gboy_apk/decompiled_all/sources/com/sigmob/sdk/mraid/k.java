package com.sigmob.sdk.mraid;

import com.sigmob.sdk.base.models.PlacementType;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public enum k {
    CLOSE("close"),
    EXPAND("expand") { // from class: com.sigmob.sdk.mraid.k.1
        @Override // com.sigmob.sdk.mraid.k
        public boolean a(PlacementType placementType) {
            return placementType == PlacementType.INLINE;
        }
    },
    USE_CUSTOM_CLOSE("usecustomclose"),
    OPEN("open") { // from class: com.sigmob.sdk.mraid.k.2
        @Override // com.sigmob.sdk.mraid.k
        public boolean a(PlacementType placementType) {
            return true;
        }
    },
    feedBack("feedback") { // from class: com.sigmob.sdk.mraid.k.3
        @Override // com.sigmob.sdk.mraid.k
        public boolean a(PlacementType placementType) {
            return true;
        }
    },
    UNLOAD("unload"),
    OPENFOURELEMENTS("openFourElements"),
    RESIZE("resize") { // from class: com.sigmob.sdk.mraid.k.4
        @Override // com.sigmob.sdk.mraid.k
        public boolean a(PlacementType placementType) {
            return true;
        }
    },
    SET_ORIENTATION_PROPERTIES("setOrientationProperties"),
    PLAY_VIDEO("playVideo") { // from class: com.sigmob.sdk.mraid.k.5
        @Override // com.sigmob.sdk.mraid.k
        public boolean a(PlacementType placementType) {
            return placementType == PlacementType.INLINE;
        }
    },
    STORE_PICTURE("storePicture") { // from class: com.sigmob.sdk.mraid.k.6
        @Override // com.sigmob.sdk.mraid.k
        public boolean a(PlacementType placementType) {
            return true;
        }
    },
    CREATE_CALENDAR_EVENT("createCalendarEvent") { // from class: com.sigmob.sdk.mraid.k.7
        @Override // com.sigmob.sdk.mraid.k
        public boolean a(PlacementType placementType) {
            return true;
        }
    },
    VPAID("vpaid") { // from class: com.sigmob.sdk.mraid.k.8
        @Override // com.sigmob.sdk.mraid.k
        public boolean a(PlacementType placementType) {
            return true;
        }
    },
    EXTENSION("extension") { // from class: com.sigmob.sdk.mraid.k.9
        @Override // com.sigmob.sdk.mraid.k
        public boolean a(PlacementType placementType) {
            return true;
        }
    },
    UNSPECIFIED("");

    private final String p;

    static {
        qfkbc();
    }

    k(String str) {
        this.p = str;
    }

    public static k a(String str) {
        for (k kVar : values()) {
            if (kVar.p.equals(str)) {
                return kVar;
            }
        }
        return UNSPECIFIED;
    }

    private static /* synthetic */ void qfkbc() {
        char[] charArray = "\u0012\u001e\u001c_\u0016\u0010\u001c\u0014_\u0013\u001e\b_\u0002\u0019\u0014\u001d\u001d_;\u001f\u00183\u0003\u0018\u0015\u0016\u0014".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'q');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0012\u001d\u0018\u001f\u0018\u0005".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'q');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public String a() {
        return this.p;
    }

    public boolean a(PlacementType placementType) {
        return false;
    }
}
