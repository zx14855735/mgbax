package io.dcloud.api.custom.base;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class UniAdConst {

    public static class AdType {
        public static final int TYPE_CONTENT = 14;
        public static final int TYPE_DRAW = 10;
        public static final int TYPE_FLOW = 4;
        public static final int TYPE_FULLSCREEN = 7;
        public static final int TYPE_INTERSTITIAL = 15;
        public static final int TYPE_NATIVE = 4;
        public static final int TYPE_NONE = -1;
        public static final int TYPE_REWARD = 9;
        public static final int TYPE_SPLASH = 1;
    }

    public static class BidType {
        public static final int BID_CLIENT = 1;
        public static final int BID_NONE = 0;
        public static final int BID_SERVER = 2;
    }

    public @interface CustomAdType {
    }

    public @interface CustomBidType {
    }
}
