package com.sigmob.sdk.base.models.rtb;

import android.os.Parcelable;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.czhj.wire.AndroidMessage;
import com.czhj.wire.FieldEncoding;
import com.czhj.wire.Message;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.ProtoReader;
import com.czhj.wire.ProtoWriter;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import com.czhj.wire.okio.ByteString;
import java.lang.reflect.Method;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class SlotAdSetting extends AndroidMessage<SlotAdSetting, Builder> {
    public static final ProtoAdapter<SlotAdSetting> ADAPTER;
    public static final Parcelable.Creator<SlotAdSetting> CREATOR;
    public static final Integer DEFAULT_APK_DOWNLOAD_TYPE;
    public static final Integer DEFAULT_CLICK_LOSE_RATE;
    public static final Boolean DEFAULT_DISABLE_X_REQUESTED_WITH;
    public static final Boolean DEFAULT_ENABLE_DEEPLINK_AND_LANDING_PAGE;
    public static final Boolean DEFAULT_RESUMABLE_DOWNLOAD;
    public static final Integer DEFAULT_RETRY_COUNT;
    public static final Boolean DEFAULT_USE_DOWNLOADED_APK;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 7)
    public final Integer apk_download_type;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 13)
    public final Integer click_lose_rate;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 5)
    public final Boolean disable_x_requested_with;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 10)
    public final Boolean enable_deeplink_and_landing_page;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.InterstitialSetting#ADAPTER", tag = 6)
    public final InterstitialSetting interstitial_setting;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.LinkAction#ADAPTER", label = WireField.Label.REPEATED, tag = 12)
    public final List<LinkAction> link_actions;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 11)
    public final List<String> market_package_name;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.NativeAdSetting#ADAPTER", tag = 3)
    public final NativeAdSetting native_setting;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean resumable_download;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer retry_count;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.RvAdSetting#ADAPTER", tag = 1)
    public final RvAdSetting rv_setting;

    @WireField(adapter = "com.sigmob.sdk.base.models.rtb.SplashAdSetting#ADAPTER", tag = 2)
    public final SplashAdSetting splash_setting;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean use_downloaded_apk;

    public static final class Builder extends Message.Builder<SlotAdSetting, Builder> {
        public InterstitialSetting interstitial_setting;
        public NativeAdSetting native_setting;
        public RvAdSetting rv_setting;
        public SplashAdSetting splash_setting;
        public Integer retry_count = SlotAdSetting.DEFAULT_RETRY_COUNT;
        public Boolean disable_x_requested_with = SlotAdSetting.DEFAULT_DISABLE_X_REQUESTED_WITH;
        public Integer apk_download_type = SlotAdSetting.DEFAULT_APK_DOWNLOAD_TYPE;
        public Boolean resumable_download = SlotAdSetting.DEFAULT_RESUMABLE_DOWNLOAD;
        public Boolean use_downloaded_apk = SlotAdSetting.DEFAULT_USE_DOWNLOADED_APK;
        public Boolean enable_deeplink_and_landing_page = SlotAdSetting.DEFAULT_ENABLE_DEEPLINK_AND_LANDING_PAGE;
        public Integer click_lose_rate = SlotAdSetting.DEFAULT_CLICK_LOSE_RATE;
        public List<String> market_package_name = Internal.newMutableList();
        public List<LinkAction> link_actions = Internal.newMutableList();

        public Builder apk_download_type(Integer num) {
            this.apk_download_type = num;
            return this;
        }

        public Builder click_lose_rate(Integer num) {
            this.click_lose_rate = num;
            return this;
        }

        public Builder disable_x_requested_with(Boolean bool) {
            this.disable_x_requested_with = bool;
            return this;
        }

        public Builder enable_deeplink_and_landing_page(Boolean bool) {
            this.enable_deeplink_and_landing_page = bool;
            return this;
        }

        public Builder interstitial_setting(InterstitialSetting interstitialSetting) {
            this.interstitial_setting = interstitialSetting;
            return this;
        }

        public Builder link_actions(List<LinkAction> list) {
            Internal.checkElementsNotNull(list);
            this.link_actions = list;
            return this;
        }

        public Builder market_package_name(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.market_package_name = list;
            return this;
        }

        public Builder native_setting(NativeAdSetting nativeAdSetting) {
            this.native_setting = nativeAdSetting;
            return this;
        }

        public Builder resumable_download(Boolean bool) {
            this.resumable_download = bool;
            return this;
        }

        public Builder retry_count(Integer num) {
            this.retry_count = num;
            return this;
        }

        public Builder rv_setting(RvAdSetting rvAdSetting) {
            this.rv_setting = rvAdSetting;
            return this;
        }

        public Builder splash_setting(SplashAdSetting splashAdSetting) {
            this.splash_setting = splashAdSetting;
            return this;
        }

        public Builder use_downloaded_apk(Boolean bool) {
            this.use_downloaded_apk = bool;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public SlotAdSetting build() {
            return new SlotAdSetting(this.rv_setting, this.splash_setting, this.native_setting, this.retry_count, this.disable_x_requested_with, this.interstitial_setting, this.apk_download_type, this.resumable_download, this.use_downloaded_apk, this.enable_deeplink_and_landing_page, this.market_package_name, this.link_actions, this.click_lose_rate, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SlotAdSetting extends ProtoAdapter<SlotAdSetting> {
        public ProtoAdapter_SlotAdSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, SlotAdSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public SlotAdSetting decode(ProtoReader protoReader) {
            List list;
            Object obj;
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                switch (nextTag) {
                    case 1:
                        builder.rv_setting(RvAdSetting.ADAPTER.decode(protoReader));
                        continue;
                    case 2:
                        builder.splash_setting(SplashAdSetting.ADAPTER.decode(protoReader));
                        continue;
                    case 3:
                        builder.native_setting(NativeAdSetting.ADAPTER.decode(protoReader));
                        continue;
                    case 4:
                        builder.retry_count(ProtoAdapter.INT32.decode(protoReader));
                        continue;
                    case 5:
                        builder.disable_x_requested_with(ProtoAdapter.BOOL.decode(protoReader));
                        continue;
                    case 6:
                        builder.interstitial_setting(InterstitialSetting.ADAPTER.decode(protoReader));
                        continue;
                    case 7:
                        builder.apk_download_type(ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    case 8:
                        builder.resumable_download(ProtoAdapter.BOOL.decode(protoReader));
                        continue;
                    case 9:
                        builder.use_downloaded_apk(ProtoAdapter.BOOL.decode(protoReader));
                        continue;
                    case 10:
                        builder.enable_deeplink_and_landing_page(ProtoAdapter.BOOL.decode(protoReader));
                        continue;
                    case 11:
                        list = builder.market_package_name;
                        obj = (String) ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 12:
                        list = builder.link_actions;
                        obj = (LinkAction) LinkAction.ADAPTER.decode(protoReader);
                        break;
                    case 13:
                        builder.click_lose_rate(ProtoAdapter.UINT32.decode(protoReader));
                        continue;
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        continue;
                }
                list.add(obj);
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, SlotAdSetting slotAdSetting) {
            RvAdSetting.ADAPTER.encodeWithTag(protoWriter, 1, slotAdSetting.rv_setting);
            SplashAdSetting.ADAPTER.encodeWithTag(protoWriter, 2, slotAdSetting.splash_setting);
            NativeAdSetting.ADAPTER.encodeWithTag(protoWriter, 3, slotAdSetting.native_setting);
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, slotAdSetting.retry_count);
            ProtoAdapter<Boolean> protoAdapter = ProtoAdapter.BOOL;
            protoAdapter.encodeWithTag(protoWriter, 5, slotAdSetting.disable_x_requested_with);
            InterstitialSetting.ADAPTER.encodeWithTag(protoWriter, 6, slotAdSetting.interstitial_setting);
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.UINT32;
            protoAdapter2.encodeWithTag(protoWriter, 7, slotAdSetting.apk_download_type);
            protoAdapter.encodeWithTag(protoWriter, 8, slotAdSetting.resumable_download);
            protoAdapter.encodeWithTag(protoWriter, 9, slotAdSetting.use_downloaded_apk);
            protoAdapter.encodeWithTag(protoWriter, 10, slotAdSetting.enable_deeplink_and_landing_page);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 11, slotAdSetting.market_package_name);
            LinkAction.ADAPTER.asRepeated().encodeWithTag(protoWriter, 12, slotAdSetting.link_actions);
            protoAdapter2.encodeWithTag(protoWriter, 13, slotAdSetting.click_lose_rate);
            protoWriter.writeBytes(slotAdSetting.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(SlotAdSetting slotAdSetting) {
            int encodedSizeWithTag = ProtoAdapter.INT32.encodedSizeWithTag(4, slotAdSetting.retry_count) + NativeAdSetting.ADAPTER.encodedSizeWithTag(3, slotAdSetting.native_setting) + SplashAdSetting.ADAPTER.encodedSizeWithTag(2, slotAdSetting.splash_setting) + RvAdSetting.ADAPTER.encodedSizeWithTag(1, slotAdSetting.rv_setting);
            ProtoAdapter<Boolean> protoAdapter = ProtoAdapter.BOOL;
            int encodedSizeWithTag2 = InterstitialSetting.ADAPTER.encodedSizeWithTag(6, slotAdSetting.interstitial_setting) + protoAdapter.encodedSizeWithTag(5, slotAdSetting.disable_x_requested_with) + encodedSizeWithTag;
            ProtoAdapter<Integer> protoAdapter2 = ProtoAdapter.UINT32;
            return slotAdSetting.unknownFields().size() + protoAdapter2.encodedSizeWithTag(13, slotAdSetting.click_lose_rate) + LinkAction.ADAPTER.asRepeated().encodedSizeWithTag(12, slotAdSetting.link_actions) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(11, slotAdSetting.market_package_name) + protoAdapter.encodedSizeWithTag(10, slotAdSetting.enable_deeplink_and_landing_page) + protoAdapter.encodedSizeWithTag(9, slotAdSetting.use_downloaded_apk) + protoAdapter.encodedSizeWithTag(8, slotAdSetting.resumable_download) + protoAdapter2.encodedSizeWithTag(7, slotAdSetting.apk_download_type) + encodedSizeWithTag2;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SlotAdSetting redact(SlotAdSetting slotAdSetting) {
            Builder newBuilder = slotAdSetting.newBuilder();
            RvAdSetting rvAdSetting = newBuilder.rv_setting;
            if (rvAdSetting != null) {
                newBuilder.rv_setting = RvAdSetting.ADAPTER.redact(rvAdSetting);
            }
            SplashAdSetting splashAdSetting = newBuilder.splash_setting;
            if (splashAdSetting != null) {
                newBuilder.splash_setting = SplashAdSetting.ADAPTER.redact(splashAdSetting);
            }
            NativeAdSetting nativeAdSetting = newBuilder.native_setting;
            if (nativeAdSetting != null) {
                newBuilder.native_setting = NativeAdSetting.ADAPTER.redact(nativeAdSetting);
            }
            InterstitialSetting interstitialSetting = newBuilder.interstitial_setting;
            if (interstitialSetting != null) {
                newBuilder.interstitial_setting = InterstitialSetting.ADAPTER.redact(interstitialSetting);
            }
            Internal.redactElements(newBuilder.link_actions, LinkAction.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SlotAdSetting protoAdapter_SlotAdSetting = new ProtoAdapter_SlotAdSetting();
        ADAPTER = protoAdapter_SlotAdSetting;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SlotAdSetting);
        DEFAULT_RETRY_COUNT = 0;
        Boolean bool = Boolean.FALSE;
        DEFAULT_DISABLE_X_REQUESTED_WITH = bool;
        DEFAULT_APK_DOWNLOAD_TYPE = 0;
        DEFAULT_RESUMABLE_DOWNLOAD = bool;
        DEFAULT_USE_DOWNLOADED_APK = bool;
        DEFAULT_ENABLE_DEEPLINK_AND_LANDING_PAGE = bool;
        DEFAULT_CLICK_LOSE_RATE = 0;
        LaTV();
    }

    public SlotAdSetting(RvAdSetting rvAdSetting, SplashAdSetting splashAdSetting, NativeAdSetting nativeAdSetting, Integer num, Boolean bool, InterstitialSetting interstitialSetting, Integer num2, Boolean bool2, Boolean bool3, Boolean bool4, List<String> list, List<LinkAction> list2, Integer num3) {
        this(rvAdSetting, splashAdSetting, nativeAdSetting, num, bool, interstitialSetting, num2, bool2, bool3, bool4, list, list2, num3, ByteString.EMPTY);
    }

    private static /* synthetic */ void LaTV() {
        char[] charArray = "\u0005\t\u000bH\u0001\u0007\u000b\u0003H\u0004\t\u001fH\u0015\u000e\u0003\n\nH,\b\u000f$\u0014\u000f\u0002\u0001\u0003".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'f');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0005\n\u000f\b\u000f\u0012".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'f');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SlotAdSetting)) {
            return false;
        }
        SlotAdSetting slotAdSetting = (SlotAdSetting) obj;
        return unknownFields().equals(slotAdSetting.unknownFields()) && Internal.equals(this.rv_setting, slotAdSetting.rv_setting) && Internal.equals(this.splash_setting, slotAdSetting.splash_setting) && Internal.equals(this.native_setting, slotAdSetting.native_setting) && Internal.equals(this.retry_count, slotAdSetting.retry_count) && Internal.equals(this.disable_x_requested_with, slotAdSetting.disable_x_requested_with) && Internal.equals(this.interstitial_setting, slotAdSetting.interstitial_setting) && Internal.equals(this.apk_download_type, slotAdSetting.apk_download_type) && Internal.equals(this.resumable_download, slotAdSetting.resumable_download) && Internal.equals(this.use_downloaded_apk, slotAdSetting.use_downloaded_apk) && Internal.equals(this.enable_deeplink_and_landing_page, slotAdSetting.enable_deeplink_and_landing_page) && this.market_package_name.equals(slotAdSetting.market_package_name) && this.link_actions.equals(slotAdSetting.link_actions) && Internal.equals(this.click_lose_rate, slotAdSetting.click_lose_rate);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        RvAdSetting rvAdSetting = this.rv_setting;
        int hashCode2 = (hashCode + (rvAdSetting != null ? rvAdSetting.hashCode() : 0)) * 37;
        SplashAdSetting splashAdSetting = this.splash_setting;
        int hashCode3 = (hashCode2 + (splashAdSetting != null ? splashAdSetting.hashCode() : 0)) * 37;
        NativeAdSetting nativeAdSetting = this.native_setting;
        int hashCode4 = (hashCode3 + (nativeAdSetting != null ? nativeAdSetting.hashCode() : 0)) * 37;
        Integer num = this.retry_count;
        int hashCode5 = (hashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.disable_x_requested_with;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        InterstitialSetting interstitialSetting = this.interstitial_setting;
        int hashCode7 = (hashCode6 + (interstitialSetting != null ? interstitialSetting.hashCode() : 0)) * 37;
        Integer num2 = this.apk_download_type;
        int hashCode8 = (hashCode7 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Boolean bool2 = this.resumable_download;
        int hashCode9 = (hashCode8 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.use_downloaded_apk;
        int hashCode10 = (hashCode9 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Boolean bool4 = this.enable_deeplink_and_landing_page;
        int A5SV6n2 = A2egSU.A5SV6n(this.link_actions, A2egSU.A5SV6n(this.market_package_name, (hashCode10 + (bool4 != null ? bool4.hashCode() : 0)) * 37, 37), 37);
        Integer num3 = this.click_lose_rate;
        int hashCode11 = A5SV6n2 + (num3 != null ? num3.hashCode() : 0);
        this.hashCode = hashCode11;
        return hashCode11;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.rv_setting != null) {
            sb.append(", rv_setting=");
            sb.append(this.rv_setting);
        }
        if (this.splash_setting != null) {
            sb.append(", splash_setting=");
            sb.append(this.splash_setting);
        }
        if (this.native_setting != null) {
            sb.append(", native_setting=");
            sb.append(this.native_setting);
        }
        if (this.retry_count != null) {
            sb.append(", retry_count=");
            sb.append(this.retry_count);
        }
        if (this.disable_x_requested_with != null) {
            sb.append(", disable_x_requested_with=");
            sb.append(this.disable_x_requested_with);
        }
        if (this.interstitial_setting != null) {
            sb.append(", interstitial_setting=");
            sb.append(this.interstitial_setting);
        }
        if (this.apk_download_type != null) {
            sb.append(", apk_download_type=");
            sb.append(this.apk_download_type);
        }
        if (this.resumable_download != null) {
            sb.append(", resumable_download=");
            sb.append(this.resumable_download);
        }
        if (this.use_downloaded_apk != null) {
            sb.append(", use_downloaded_apk=");
            sb.append(this.use_downloaded_apk);
        }
        if (this.enable_deeplink_and_landing_page != null) {
            sb.append(", enable_deeplink_and_landing_page=");
            sb.append(this.enable_deeplink_and_landing_page);
        }
        if (!this.market_package_name.isEmpty()) {
            sb.append(", market_package_name=");
            sb.append(this.market_package_name);
        }
        if (!this.link_actions.isEmpty()) {
            sb.append(", link_actions=");
            sb.append(this.link_actions);
        }
        if (this.click_lose_rate != null) {
            sb.append(", click_lose_rate=");
            sb.append(this.click_lose_rate);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "SlotAdSetting{", '}');
    }

    public SlotAdSetting(RvAdSetting rvAdSetting, SplashAdSetting splashAdSetting, NativeAdSetting nativeAdSetting, Integer num, Boolean bool, InterstitialSetting interstitialSetting, Integer num2, Boolean bool2, Boolean bool3, Boolean bool4, List<String> list, List<LinkAction> list2, Integer num3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.rv_setting = rvAdSetting;
        this.splash_setting = splashAdSetting;
        this.native_setting = nativeAdSetting;
        this.retry_count = num;
        this.disable_x_requested_with = bool;
        this.interstitial_setting = interstitialSetting;
        this.apk_download_type = num2;
        this.resumable_download = bool2;
        this.use_downloaded_apk = bool3;
        this.enable_deeplink_and_landing_page = bool4;
        this.market_package_name = Internal.immutableCopyOf("market_package_name", list);
        this.link_actions = Internal.immutableCopyOf("link_actions", list2);
        this.click_lose_rate = num3;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.rv_setting = this.rv_setting;
        builder.splash_setting = this.splash_setting;
        builder.native_setting = this.native_setting;
        builder.retry_count = this.retry_count;
        builder.disable_x_requested_with = this.disable_x_requested_with;
        builder.interstitial_setting = this.interstitial_setting;
        builder.apk_download_type = this.apk_download_type;
        builder.resumable_download = this.resumable_download;
        builder.use_downloaded_apk = this.use_downloaded_apk;
        builder.enable_deeplink_and_landing_page = this.enable_deeplink_and_landing_page;
        builder.market_package_name = Internal.copyOf("market_package_name", this.market_package_name);
        builder.link_actions = Internal.copyOf("link_actions", this.link_actions);
        builder.click_lose_rate = this.click_lose_rate;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
