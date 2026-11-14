package io.dcloud.ads.core.entry;

import io.dcloud.openapi.core.entry.DCloudAOLSlot;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class DCloudAdSlot {
    private final DCloudAOLSlot aaaaaaaa;

    public static final class Builder {
        DCloudAOLSlot.Builder aaaaaaaa = new DCloudAOLSlot.Builder();

        public Builder adpid(String str) {
            this.aaaaaaaa.adpid(str);
            return this;
        }

        public DCloudAdSlot build() {
            return new DCloudAdSlot(this.aaaaaaaa.build());
        }

        public Builder count(int i) {
            this.aaaaaaaa.count(i);
            return this;
        }

        public Builder extra(String str) {
            this.aaaaaaaa.extra(str);
            return this;
        }

        public Builder height(int i) {
            this.aaaaaaaa.height(i);
            return this;
        }

        public Builder setVideoSoundEnable(boolean z) {
            this.aaaaaaaa.setVideoSoundEnable(z);
            return this;
        }

        public Builder userId(String str) {
            this.aaaaaaaa.userId(str);
            return this;
        }

        public Builder width(int i) {
            this.aaaaaaaa.width(i);
            return this;
        }
    }

    public String getAdpid() {
        return this.aaaaaaaa.getAdpid();
    }

    public int getCount() {
        return this.aaaaaaaa.getCount();
    }

    public String getExtra() {
        return this.aaaaaaaa.getExt();
    }

    public int getHeight() {
        return this.aaaaaaaa.getHeight();
    }

    @Deprecated
    public DCloudAOLSlot getSlot() {
        return this.aaaaaaaa;
    }

    public String getUserId() {
        return this.aaaaaaaa.getUserId();
    }

    public int getWidth() {
        return this.aaaaaaaa.getWidth();
    }

    private DCloudAdSlot(DCloudAOLSlot dCloudAOLSlot) {
        this.aaaaaaaa = dCloudAOLSlot;
    }
}
