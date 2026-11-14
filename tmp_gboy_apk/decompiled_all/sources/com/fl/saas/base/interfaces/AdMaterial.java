package com.fl.saas.base.interfaces;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface AdMaterial {

    public static class AdMaterialData {
        private static AdMaterialData emptyData;
        private int advId;
        private String advVer;
        private String data;

        public AdMaterialData(int i, String str, String str2) {
            this.advId = i;
            this.data = str2;
            this.advVer = str;
        }

        public static AdMaterialData create(int i, String str, String str2) {
            return new AdMaterialData(i, str, str2);
        }

        public static AdMaterialData createEmpty(int i) {
            if (emptyData == null) {
                emptyData = create(i, "", "");
            }
            return emptyData;
        }

        public int getAdvId() {
            return this.advId;
        }

        public String getAdvVer() {
            return this.advVer;
        }

        public String getData() {
            return this.data;
        }
    }

    AdMaterialData getAdMaterialData();
}
