package com.czhj.sdk.common.models;

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

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class Device extends AndroidMessage<Device, Builder> {
    public static final ProtoAdapter<Device> ADAPTER;
    public static final Parcelable.Creator<Device> CREATOR;
    public static final Integer DEFAULT_ANDROID_API_LEVEL;
    public static final Float DEFAULT_BATTERY_LEVEL;
    public static final Boolean DEFAULT_BATTERY_SAVE_ENABLED;
    public static final Integer DEFAULT_BATTERY_STATE;
    public static final String DEFAULT_BOOT_MARK = "";
    public static final String DEFAULT_DEVICE_NAME = "";
    public static final Integer DEFAULT_DEVICE_TYPE;
    public static final Long DEFAULT_DISK_SIZE;
    public static final Integer DEFAULT_DPI;
    public static final Long DEFAULT_FREE_DISK_SIZE;
    public static final Integer DEFAULT_HMS_VERSION;
    public static final String DEFAULT_INTERNAL_NAME = "";
    public static final Boolean DEFAULT_IS_ROOT;
    public static final Integer DEFAULT_MARKET_VERSION;
    public static final Long DEFAULT_MEM_SIZE;
    public static final String DEFAULT_MODEL = "";
    public static final Integer DEFAULT_OS_TYPE;
    public static final String DEFAULT_ROM_NAME = "";
    public static final Long DEFAULT_SD_FREE_DISK_SIZE;
    public static final Long DEFAULT_SD_TOTAL_DISK_SIZE;
    public static final Long DEFAULT_START_TIMESTAMP;
    public static final String DEFAULT_SYSTEM_UPDATE_TIME = "";
    public static final Long DEFAULT_TOTAL_DISK_SIZE;
    public static final String DEFAULT_UPDATE_MARK = "";
    public static final String DEFAULT_VENDOR = "";
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 18)
    public final Integer android_api_level;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 14)
    public final Float battery_level;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 15)
    public final Boolean battery_save_enabled;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 13)
    public final Integer battery_state;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 27)
    public final String boot_mark;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 16)
    public final String device_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 1)
    public final Integer device_type;

    @WireField(adapter = "com.sigmob.sdk.common.models.DeviceId#ADAPTER", tag = 6)
    public final DeviceId did;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 11)
    public final Long disk_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 9)
    public final Integer dpi;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 21)
    public final Long free_disk_size;

    @WireField(adapter = "com.sigmob.sdk.common.models.Geo#ADAPTER", tag = 8)
    public final Geo geo;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 35)
    public final Integer hms_version;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 26)
    public final String internal_name;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 10)
    public final Boolean is_root;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 34)
    public final Integer market_version;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 19)
    public final Long mem_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String model;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT32", tag = 2)
    public final Integer os_type;

    @WireField(adapter = "com.sigmob.sdk.common.models.Version#ADAPTER", tag = 3)
    public final Version os_version;

    @WireField(adapter = "com.sigmob.sdk.common.models.Size#ADAPTER", tag = 24)
    public final Size resolution;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 32)
    public final String rom_name;

    @WireField(adapter = "com.sigmob.sdk.common.models.Version#ADAPTER", tag = 33)
    public final Version rom_version;

    @WireField(adapter = "com.sigmob.sdk.common.models.Size#ADAPTER", tag = 7)
    public final Size screen_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 23)
    public final Long sd_free_disk_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 22)
    public final Long sd_total_disk_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 17)
    public final Long start_timestamp;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 25)
    public final String system_update_time;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#UINT64", tag = 20)
    public final Long total_disk_size;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 28)
    public final String update_mark;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String vendor;

    public static final class Builder extends Message.Builder<Device, Builder> {
        public Integer android_api_level;
        public Float battery_level;
        public Boolean battery_save_enabled;
        public Integer battery_state;
        public String boot_mark;
        public String device_name;
        public Integer device_type;
        public DeviceId did;
        public Long disk_size;
        public Integer dpi;
        public Long free_disk_size;
        public Geo geo;
        public Integer hms_version;
        public String internal_name;
        public Boolean is_root;
        public Integer market_version;
        public Long mem_size;
        public String model;
        public Integer os_type;
        public Version os_version;
        public Size resolution;
        public String rom_name;
        public Version rom_version;
        public Size screen_size;
        public Long sd_free_disk_size;
        public Long sd_total_disk_size;
        public Long start_timestamp;
        public String system_update_time;
        public Long total_disk_size;
        public String update_mark;
        public String vendor;

        public Builder android_api_level(Integer num) {
            this.android_api_level = num;
            return this;
        }

        public Builder battery_level(Float f) {
            this.battery_level = f;
            return this;
        }

        public Builder battery_save_enabled(Boolean bool) {
            this.battery_save_enabled = bool;
            return this;
        }

        public Builder battery_state(Integer num) {
            this.battery_state = num;
            return this;
        }

        public Builder boot_mark(String str) {
            this.boot_mark = str;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.Message.Builder
        public Device build() {
            return new Device(this.device_type, this.os_type, this.os_version, this.vendor, this.model, this.did, this.screen_size, this.geo, this.dpi, this.is_root, this.disk_size, this.battery_state, this.battery_level, this.battery_save_enabled, this.device_name, this.start_timestamp, this.android_api_level, this.mem_size, this.total_disk_size, this.free_disk_size, this.sd_total_disk_size, this.sd_free_disk_size, this.resolution, this.system_update_time, this.internal_name, this.boot_mark, this.update_mark, this.rom_name, this.rom_version, this.market_version, this.hms_version, buildUnknownFields());
        }

        public Builder device_name(String str) {
            this.device_name = str;
            return this;
        }

        public Builder device_type(Integer num) {
            this.device_type = num;
            return this;
        }

        public Builder did(DeviceId deviceId) {
            this.did = deviceId;
            return this;
        }

        public Builder disk_size(Long l) {
            this.disk_size = l;
            return this;
        }

        public Builder dpi(Integer num) {
            this.dpi = num;
            return this;
        }

        public Builder free_disk_size(Long l) {
            this.free_disk_size = l;
            return this;
        }

        public Builder geo(Geo geo) {
            this.geo = geo;
            return this;
        }

        public Builder hms_version(Integer num) {
            this.hms_version = num;
            return this;
        }

        public Builder internal_name(String str) {
            this.internal_name = str;
            return this;
        }

        public Builder is_root(Boolean bool) {
            this.is_root = bool;
            return this;
        }

        public Builder market_version(Integer num) {
            this.market_version = num;
            return this;
        }

        public Builder mem_size(Long l) {
            this.mem_size = l;
            return this;
        }

        public Builder model(String str) {
            this.model = str;
            return this;
        }

        public Builder os_type(Integer num) {
            this.os_type = num;
            return this;
        }

        public Builder os_version(Version version) {
            this.os_version = version;
            return this;
        }

        public Builder resolution(Size size) {
            this.resolution = size;
            return this;
        }

        public Builder rom_name(String str) {
            this.rom_name = str;
            return this;
        }

        public Builder rom_version(Version version) {
            this.rom_version = version;
            return this;
        }

        public Builder screen_size(Size size) {
            this.screen_size = size;
            return this;
        }

        public Builder sd_free_disk_size(Long l) {
            this.sd_free_disk_size = l;
            return this;
        }

        public Builder sd_total_disk_size(Long l) {
            this.sd_total_disk_size = l;
            return this;
        }

        public Builder start_timestamp(Long l) {
            this.start_timestamp = l;
            return this;
        }

        public Builder system_update_time(String str) {
            this.system_update_time = str;
            return this;
        }

        public Builder total_disk_size(Long l) {
            this.total_disk_size = l;
            return this;
        }

        public Builder update_mark(String str) {
            this.update_mark = str;
            return this;
        }

        public Builder vendor(String str) {
            this.vendor = str;
            return this;
        }
    }

    public static final class ProtoAdapter_Device extends ProtoAdapter<Device> {
        public ProtoAdapter_Device() {
            super(FieldEncoding.LENGTH_DELIMITED, Device.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public Device decode(ProtoReader protoReader) {
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
                        builder.device_type(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 2:
                        builder.os_type(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 3:
                        builder.os_version(Version.ADAPTER.decode(protoReader));
                        break;
                    case 4:
                        builder.vendor(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 5:
                        builder.model(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 6:
                        builder.did(DeviceId.ADAPTER.decode(protoReader));
                        break;
                    case 7:
                        builder.screen_size(Size.ADAPTER.decode(protoReader));
                        break;
                    case 8:
                        builder.geo(Geo.ADAPTER.decode(protoReader));
                        break;
                    case 9:
                        builder.dpi(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 10:
                        builder.is_root(ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 11:
                        builder.disk_size(ProtoAdapter.UINT64.decode(protoReader));
                        break;
                    case 12:
                    case 29:
                    case 30:
                    case 31:
                    default:
                        FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                        builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                        break;
                    case 13:
                        builder.battery_state(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 14:
                        builder.battery_level(ProtoAdapter.FLOAT.decode(protoReader));
                        break;
                    case 15:
                        builder.battery_save_enabled(ProtoAdapter.BOOL.decode(protoReader));
                        break;
                    case 16:
                        builder.device_name(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 17:
                        builder.start_timestamp(ProtoAdapter.INT64.decode(protoReader));
                        break;
                    case 18:
                        builder.android_api_level(ProtoAdapter.UINT32.decode(protoReader));
                        break;
                    case 19:
                        builder.mem_size(ProtoAdapter.UINT64.decode(protoReader));
                        break;
                    case 20:
                        builder.total_disk_size(ProtoAdapter.UINT64.decode(protoReader));
                        break;
                    case 21:
                        builder.free_disk_size(ProtoAdapter.UINT64.decode(protoReader));
                        break;
                    case 22:
                        builder.sd_total_disk_size(ProtoAdapter.UINT64.decode(protoReader));
                        break;
                    case 23:
                        builder.sd_free_disk_size(ProtoAdapter.UINT64.decode(protoReader));
                        break;
                    case 24:
                        builder.resolution(Size.ADAPTER.decode(protoReader));
                        break;
                    case 25:
                        builder.system_update_time(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 26:
                        builder.internal_name(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 27:
                        builder.boot_mark(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 28:
                        builder.update_mark(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 32:
                        builder.rom_name(ProtoAdapter.STRING.decode(protoReader));
                        break;
                    case 33:
                        builder.rom_version(Version.ADAPTER.decode(protoReader));
                        break;
                    case 34:
                        builder.market_version(ProtoAdapter.INT32.decode(protoReader));
                        break;
                    case 35:
                        builder.hms_version(ProtoAdapter.INT32.decode(protoReader));
                        break;
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Device device) {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            protoAdapter.encodeWithTag(protoWriter, 1, device.device_type);
            protoAdapter.encodeWithTag(protoWriter, 2, device.os_type);
            ProtoAdapter<Version> protoAdapter2 = Version.ADAPTER;
            protoAdapter2.encodeWithTag(protoWriter, 3, device.os_version);
            ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
            protoAdapter3.encodeWithTag(protoWriter, 4, device.vendor);
            protoAdapter3.encodeWithTag(protoWriter, 5, device.model);
            DeviceId.ADAPTER.encodeWithTag(protoWriter, 6, device.did);
            ProtoAdapter<Size> protoAdapter4 = Size.ADAPTER;
            protoAdapter4.encodeWithTag(protoWriter, 7, device.screen_size);
            Geo.ADAPTER.encodeWithTag(protoWriter, 8, device.geo);
            protoAdapter.encodeWithTag(protoWriter, 9, device.dpi);
            ProtoAdapter<Boolean> protoAdapter5 = ProtoAdapter.BOOL;
            protoAdapter5.encodeWithTag(protoWriter, 10, device.is_root);
            ProtoAdapter<Long> protoAdapter6 = ProtoAdapter.UINT64;
            protoAdapter6.encodeWithTag(protoWriter, 11, device.disk_size);
            protoAdapter.encodeWithTag(protoWriter, 13, device.battery_state);
            ProtoAdapter.FLOAT.encodeWithTag(protoWriter, 14, device.battery_level);
            protoAdapter5.encodeWithTag(protoWriter, 15, device.battery_save_enabled);
            protoAdapter3.encodeWithTag(protoWriter, 16, device.device_name);
            ProtoAdapter.INT64.encodeWithTag(protoWriter, 17, device.start_timestamp);
            protoAdapter.encodeWithTag(protoWriter, 18, device.android_api_level);
            protoAdapter6.encodeWithTag(protoWriter, 19, device.mem_size);
            protoAdapter6.encodeWithTag(protoWriter, 20, device.total_disk_size);
            protoAdapter6.encodeWithTag(protoWriter, 21, device.free_disk_size);
            protoAdapter6.encodeWithTag(protoWriter, 22, device.sd_total_disk_size);
            protoAdapter6.encodeWithTag(protoWriter, 23, device.sd_free_disk_size);
            protoAdapter4.encodeWithTag(protoWriter, 24, device.resolution);
            protoAdapter3.encodeWithTag(protoWriter, 25, device.system_update_time);
            protoAdapter3.encodeWithTag(protoWriter, 26, device.internal_name);
            protoAdapter3.encodeWithTag(protoWriter, 27, device.boot_mark);
            protoAdapter3.encodeWithTag(protoWriter, 28, device.update_mark);
            protoAdapter3.encodeWithTag(protoWriter, 32, device.rom_name);
            protoAdapter2.encodeWithTag(protoWriter, 33, device.rom_version);
            ProtoAdapter<Integer> protoAdapter7 = ProtoAdapter.INT32;
            protoAdapter7.encodeWithTag(protoWriter, 34, device.market_version);
            protoAdapter7.encodeWithTag(protoWriter, 35, device.hms_version);
            protoWriter.writeBytes(device.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Device device) {
            ProtoAdapter<Integer> protoAdapter = ProtoAdapter.UINT32;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(2, device.os_type) + protoAdapter.encodedSizeWithTag(1, device.device_type);
            ProtoAdapter<Version> protoAdapter2 = Version.ADAPTER;
            int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(3, device.os_version) + encodedSizeWithTag;
            ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
            int encodedSizeWithTag3 = DeviceId.ADAPTER.encodedSizeWithTag(6, device.did) + protoAdapter3.encodedSizeWithTag(5, device.model) + protoAdapter3.encodedSizeWithTag(4, device.vendor) + encodedSizeWithTag2;
            ProtoAdapter<Size> protoAdapter4 = Size.ADAPTER;
            int encodedSizeWithTag4 = protoAdapter.encodedSizeWithTag(9, device.dpi) + Geo.ADAPTER.encodedSizeWithTag(8, device.geo) + protoAdapter4.encodedSizeWithTag(7, device.screen_size) + encodedSizeWithTag3;
            ProtoAdapter<Boolean> protoAdapter5 = ProtoAdapter.BOOL;
            int encodedSizeWithTag5 = protoAdapter5.encodedSizeWithTag(10, device.is_root) + encodedSizeWithTag4;
            ProtoAdapter<Long> protoAdapter6 = ProtoAdapter.UINT64;
            int encodedSizeWithTag6 = protoAdapter2.encodedSizeWithTag(33, device.rom_version) + protoAdapter3.encodedSizeWithTag(32, device.rom_name) + protoAdapter3.encodedSizeWithTag(28, device.update_mark) + protoAdapter3.encodedSizeWithTag(27, device.boot_mark) + protoAdapter3.encodedSizeWithTag(26, device.internal_name) + protoAdapter3.encodedSizeWithTag(25, device.system_update_time) + protoAdapter4.encodedSizeWithTag(24, device.resolution) + protoAdapter6.encodedSizeWithTag(23, device.sd_free_disk_size) + protoAdapter6.encodedSizeWithTag(22, device.sd_total_disk_size) + protoAdapter6.encodedSizeWithTag(21, device.free_disk_size) + protoAdapter6.encodedSizeWithTag(20, device.total_disk_size) + protoAdapter6.encodedSizeWithTag(19, device.mem_size) + protoAdapter.encodedSizeWithTag(18, device.android_api_level) + ProtoAdapter.INT64.encodedSizeWithTag(17, device.start_timestamp) + protoAdapter3.encodedSizeWithTag(16, device.device_name) + protoAdapter5.encodedSizeWithTag(15, device.battery_save_enabled) + ProtoAdapter.FLOAT.encodedSizeWithTag(14, device.battery_level) + protoAdapter.encodedSizeWithTag(13, device.battery_state) + protoAdapter6.encodedSizeWithTag(11, device.disk_size) + encodedSizeWithTag5;
            ProtoAdapter<Integer> protoAdapter7 = ProtoAdapter.INT32;
            return device.unknownFields().size() + protoAdapter7.encodedSizeWithTag(35, device.hms_version) + protoAdapter7.encodedSizeWithTag(34, device.market_version) + encodedSizeWithTag6;
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Device redact(Device device) {
            Builder newBuilder = device.newBuilder();
            Version version = newBuilder.os_version;
            if (version != null) {
                newBuilder.os_version = Version.ADAPTER.redact(version);
            }
            DeviceId deviceId = newBuilder.did;
            if (deviceId != null) {
                newBuilder.did = DeviceId.ADAPTER.redact(deviceId);
            }
            Size size = newBuilder.screen_size;
            if (size != null) {
                newBuilder.screen_size = Size.ADAPTER.redact(size);
            }
            Geo geo = newBuilder.geo;
            if (geo != null) {
                newBuilder.geo = Geo.ADAPTER.redact(geo);
            }
            Size size2 = newBuilder.resolution;
            if (size2 != null) {
                newBuilder.resolution = Size.ADAPTER.redact(size2);
            }
            Version version2 = newBuilder.rom_version;
            if (version2 != null) {
                newBuilder.rom_version = Version.ADAPTER.redact(version2);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_Device protoAdapter_Device = new ProtoAdapter_Device();
        ADAPTER = protoAdapter_Device;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Device);
        DEFAULT_DEVICE_TYPE = 0;
        DEFAULT_OS_TYPE = 0;
        DEFAULT_DPI = 0;
        Boolean bool = Boolean.FALSE;
        DEFAULT_IS_ROOT = bool;
        DEFAULT_DISK_SIZE = 0L;
        DEFAULT_BATTERY_STATE = 0;
        DEFAULT_BATTERY_LEVEL = Float.valueOf(0.0f);
        DEFAULT_BATTERY_SAVE_ENABLED = bool;
        DEFAULT_START_TIMESTAMP = 0L;
        DEFAULT_ANDROID_API_LEVEL = 0;
        DEFAULT_MEM_SIZE = 0L;
        DEFAULT_TOTAL_DISK_SIZE = 0L;
        DEFAULT_FREE_DISK_SIZE = 0L;
        DEFAULT_SD_TOTAL_DISK_SIZE = 0L;
        DEFAULT_SD_FREE_DISK_SIZE = 0L;
        DEFAULT_MARKET_VERSION = 0;
        DEFAULT_HMS_VERSION = 0;
        QPolFK();
    }

    public Device(Integer num, Integer num2, Version version, String str, String str2, DeviceId deviceId, Size size, Geo geo, Integer num3, Boolean bool, Long l, Integer num4, Float f, Boolean bool2, String str3, Long l2, Integer num5, Long l3, Long l4, Long l5, Long l6, Long l7, Size size2, String str4, String str5, String str6, String str7, String str8, Version version2, Integer num6, Integer num7) {
        this(num, num2, version, str, str2, deviceId, size, geo, num3, bool, l, num4, f, bool2, str3, l2, num5, l3, l4, l5, l6, l7, size2, str4, str5, str6, str7, str8, version2, num6, num7, ByteString.EMPTY);
    }

    private static /* synthetic */ void QPolFK() {
        char[] charArray = "½±³ð¹¿³»ð¼±§ð\u00ad¶»²²ð\u0094°·\u009c¬·º¹»".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 222);
        }
        String str = new String(charArray);
        char[] charArray2 = "½²·°·ª".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 222);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Device)) {
            return false;
        }
        Device device = (Device) obj;
        return unknownFields().equals(device.unknownFields()) && Internal.equals(this.device_type, device.device_type) && Internal.equals(this.os_type, device.os_type) && Internal.equals(this.os_version, device.os_version) && Internal.equals(this.vendor, device.vendor) && Internal.equals(this.model, device.model) && Internal.equals(this.did, device.did) && Internal.equals(this.screen_size, device.screen_size) && Internal.equals(this.geo, device.geo) && Internal.equals(this.dpi, device.dpi) && Internal.equals(this.is_root, device.is_root) && Internal.equals(this.disk_size, device.disk_size) && Internal.equals(this.battery_state, device.battery_state) && Internal.equals(this.battery_level, device.battery_level) && Internal.equals(this.battery_save_enabled, device.battery_save_enabled) && Internal.equals(this.device_name, device.device_name) && Internal.equals(this.start_timestamp, device.start_timestamp) && Internal.equals(this.android_api_level, device.android_api_level) && Internal.equals(this.mem_size, device.mem_size) && Internal.equals(this.total_disk_size, device.total_disk_size) && Internal.equals(this.free_disk_size, device.free_disk_size) && Internal.equals(this.sd_total_disk_size, device.sd_total_disk_size) && Internal.equals(this.sd_free_disk_size, device.sd_free_disk_size) && Internal.equals(this.resolution, device.resolution) && Internal.equals(this.system_update_time, device.system_update_time) && Internal.equals(this.internal_name, device.internal_name) && Internal.equals(this.boot_mark, device.boot_mark) && Internal.equals(this.update_mark, device.update_mark) && Internal.equals(this.rom_name, device.rom_name) && Internal.equals(this.rom_version, device.rom_version) && Internal.equals(this.market_version, device.market_version) && Internal.equals(this.hms_version, device.hms_version);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.device_type;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.os_type;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Version version = this.os_version;
        int hashCode4 = (hashCode3 + (version != null ? version.hashCode() : 0)) * 37;
        String str = this.vendor;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.model;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        DeviceId deviceId = this.did;
        int hashCode7 = (hashCode6 + (deviceId != null ? deviceId.hashCode() : 0)) * 37;
        Size size = this.screen_size;
        int hashCode8 = (hashCode7 + (size != null ? size.hashCode() : 0)) * 37;
        Geo geo = this.geo;
        int hashCode9 = (hashCode8 + (geo != null ? geo.hashCode() : 0)) * 37;
        Integer num3 = this.dpi;
        int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool = this.is_root;
        int hashCode11 = (hashCode10 + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l = this.disk_size;
        int hashCode12 = (hashCode11 + (l != null ? l.hashCode() : 0)) * 37;
        Integer num4 = this.battery_state;
        int hashCode13 = (hashCode12 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Float f = this.battery_level;
        int hashCode14 = (hashCode13 + (f != null ? f.hashCode() : 0)) * 37;
        Boolean bool2 = this.battery_save_enabled;
        int hashCode15 = (hashCode14 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str3 = this.device_name;
        int hashCode16 = (hashCode15 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l2 = this.start_timestamp;
        int hashCode17 = (hashCode16 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num5 = this.android_api_level;
        int hashCode18 = (hashCode17 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Long l3 = this.mem_size;
        int hashCode19 = (hashCode18 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.total_disk_size;
        int hashCode20 = (hashCode19 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.free_disk_size;
        int hashCode21 = (hashCode20 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Long l6 = this.sd_total_disk_size;
        int hashCode22 = (hashCode21 + (l6 != null ? l6.hashCode() : 0)) * 37;
        Long l7 = this.sd_free_disk_size;
        int hashCode23 = (hashCode22 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Size size2 = this.resolution;
        int hashCode24 = (hashCode23 + (size2 != null ? size2.hashCode() : 0)) * 37;
        String str4 = this.system_update_time;
        int hashCode25 = (hashCode24 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.internal_name;
        int hashCode26 = (hashCode25 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.boot_mark;
        int hashCode27 = (hashCode26 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.update_mark;
        int hashCode28 = (hashCode27 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.rom_name;
        int hashCode29 = (hashCode28 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Version version2 = this.rom_version;
        int hashCode30 = (hashCode29 + (version2 != null ? version2.hashCode() : 0)) * 37;
        Integer num6 = this.market_version;
        int hashCode31 = (hashCode30 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Integer num7 = this.hms_version;
        int hashCode32 = hashCode31 + (num7 != null ? num7.hashCode() : 0);
        this.hashCode = hashCode32;
        return hashCode32;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.device_type = this.device_type;
        builder.os_type = this.os_type;
        builder.os_version = this.os_version;
        builder.vendor = this.vendor;
        builder.model = this.model;
        builder.did = this.did;
        builder.screen_size = this.screen_size;
        builder.geo = this.geo;
        builder.dpi = this.dpi;
        builder.is_root = this.is_root;
        builder.disk_size = this.disk_size;
        builder.battery_state = this.battery_state;
        builder.battery_level = this.battery_level;
        builder.battery_save_enabled = this.battery_save_enabled;
        builder.device_name = this.device_name;
        builder.start_timestamp = this.start_timestamp;
        builder.android_api_level = this.android_api_level;
        builder.mem_size = this.mem_size;
        builder.total_disk_size = this.total_disk_size;
        builder.free_disk_size = this.free_disk_size;
        builder.sd_total_disk_size = this.sd_total_disk_size;
        builder.sd_free_disk_size = this.sd_free_disk_size;
        builder.resolution = this.resolution;
        builder.system_update_time = this.system_update_time;
        builder.internal_name = this.internal_name;
        builder.boot_mark = this.boot_mark;
        builder.update_mark = this.update_mark;
        builder.rom_name = this.rom_name;
        builder.rom_version = this.rom_version;
        builder.market_version = this.market_version;
        builder.hms_version = this.hms_version;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.device_type != null) {
            sb.append(", device_type=");
            sb.append(this.device_type);
        }
        if (this.os_type != null) {
            sb.append(", os_type=");
            sb.append(this.os_type);
        }
        if (this.os_version != null) {
            sb.append(", os_version=");
            sb.append(this.os_version);
        }
        if (this.vendor != null) {
            sb.append(", vendor=");
            sb.append(this.vendor);
        }
        if (this.model != null) {
            sb.append(", model=");
            sb.append(this.model);
        }
        if (this.did != null) {
            sb.append(", did=");
            sb.append(this.did);
        }
        if (this.screen_size != null) {
            sb.append(", screen_size=");
            sb.append(this.screen_size);
        }
        if (this.geo != null) {
            sb.append(", geo=");
            sb.append(this.geo);
        }
        if (this.dpi != null) {
            sb.append(", dpi=");
            sb.append(this.dpi);
        }
        if (this.is_root != null) {
            sb.append(", is_root=");
            sb.append(this.is_root);
        }
        if (this.disk_size != null) {
            sb.append(", disk_size=");
            sb.append(this.disk_size);
        }
        if (this.battery_state != null) {
            sb.append(", battery_state=");
            sb.append(this.battery_state);
        }
        if (this.battery_level != null) {
            sb.append(", battery_level=");
            sb.append(this.battery_level);
        }
        if (this.battery_save_enabled != null) {
            sb.append(", battery_save_enabled=");
            sb.append(this.battery_save_enabled);
        }
        if (this.device_name != null) {
            sb.append(", device_name=");
            sb.append(this.device_name);
        }
        if (this.start_timestamp != null) {
            sb.append(", start_timestamp=");
            sb.append(this.start_timestamp);
        }
        if (this.android_api_level != null) {
            sb.append(", android_api_level=");
            sb.append(this.android_api_level);
        }
        if (this.mem_size != null) {
            sb.append(", mem_size=");
            sb.append(this.mem_size);
        }
        if (this.total_disk_size != null) {
            sb.append(", total_disk_size=");
            sb.append(this.total_disk_size);
        }
        if (this.free_disk_size != null) {
            sb.append(", free_disk_size=");
            sb.append(this.free_disk_size);
        }
        if (this.sd_total_disk_size != null) {
            sb.append(", sd_total_disk_size=");
            sb.append(this.sd_total_disk_size);
        }
        if (this.sd_free_disk_size != null) {
            sb.append(", sd_free_disk_size=");
            sb.append(this.sd_free_disk_size);
        }
        if (this.resolution != null) {
            sb.append(", resolution=");
            sb.append(this.resolution);
        }
        if (this.system_update_time != null) {
            sb.append(", system_update_time=");
            sb.append(this.system_update_time);
        }
        if (this.internal_name != null) {
            sb.append(", internal_name=");
            sb.append(this.internal_name);
        }
        if (this.boot_mark != null) {
            sb.append(", boot_mark=");
            sb.append(this.boot_mark);
        }
        if (this.update_mark != null) {
            sb.append(", update_mark=");
            sb.append(this.update_mark);
        }
        if (this.rom_name != null) {
            sb.append(", rom_name=");
            sb.append(this.rom_name);
        }
        if (this.rom_version != null) {
            sb.append(", rom_version=");
            sb.append(this.rom_version);
        }
        if (this.market_version != null) {
            sb.append(", market_version=");
            sb.append(this.market_version);
        }
        if (this.hms_version != null) {
            sb.append(", hms_version=");
            sb.append(this.hms_version);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "Device{", '}');
    }

    public Device(Integer num, Integer num2, Version version, String str, String str2, DeviceId deviceId, Size size, Geo geo, Integer num3, Boolean bool, Long l, Integer num4, Float f, Boolean bool2, String str3, Long l2, Integer num5, Long l3, Long l4, Long l5, Long l6, Long l7, Size size2, String str4, String str5, String str6, String str7, String str8, Version version2, Integer num6, Integer num7, ByteString byteString) {
        super(ADAPTER, byteString);
        this.device_type = num;
        this.os_type = num2;
        this.os_version = version;
        this.vendor = str;
        this.model = str2;
        this.did = deviceId;
        this.screen_size = size;
        this.geo = geo;
        this.dpi = num3;
        this.is_root = bool;
        this.disk_size = l;
        this.battery_state = num4;
        this.battery_level = f;
        this.battery_save_enabled = bool2;
        this.device_name = str3;
        this.start_timestamp = l2;
        this.android_api_level = num5;
        this.mem_size = l3;
        this.total_disk_size = l4;
        this.free_disk_size = l5;
        this.sd_total_disk_size = l6;
        this.sd_free_disk_size = l7;
        this.resolution = size2;
        this.system_update_time = str4;
        this.internal_name = str5;
        this.boot_mark = str6;
        this.update_mark = str7;
        this.rom_name = str8;
        this.rom_version = version2;
        this.market_version = num6;
        this.hms_version = num7;
    }
}
