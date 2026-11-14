package com.sigmob.sdk.base.models.config;

import android.os.Parcelable;
import com.bykv.vk.component.ttvideo.player.A2egSU;
import com.czhj.sdk.common.models.App;
import com.czhj.sdk.common.models.Device;
import com.czhj.sdk.common.models.Network;
import com.czhj.sdk.common.models.Privacy;
import com.czhj.sdk.common.models.User;
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

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class SigmobSdkConfigRequest extends AndroidMessage<SigmobSdkConfigRequest, Builder> {
    public static final ProtoAdapter<SigmobSdkConfigRequest> ADAPTER;
    public static final Parcelable.Creator<SigmobSdkConfigRequest> CREATOR;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.sigmob.sdk.common.models.App#ADAPTER", tag = 1)
    public final App app;

    @WireField(adapter = "com.sigmob.sdk.common.models.Device#ADAPTER", tag = 2)
    public final Device device;

    @WireField(adapter = "com.sigmob.sdk.common.models.Network#ADAPTER", tag = 3)
    public final Network network;

    @WireField(adapter = "com.sigmob.sdk.common.models.Privacy#ADAPTER", tag = 4)
    public final Privacy privacy;

    @WireField(adapter = "com.sigmob.sdk.common.models.User#ADAPTER", tag = 5)
    public final User user;

    public static final class Builder extends Message.Builder<SigmobSdkConfigRequest, Builder> {
        public App app;
        public Device device;
        public Network network;
        public Privacy privacy;
        public User user;

        public Builder app(App app) {
            this.app = app;
            return this;
        }

        public Builder device(Device device) {
            this.device = device;
            return this;
        }

        public Builder network(Network network) {
            this.network = network;
            return this;
        }

        public Builder privacy(Privacy privacy) {
            this.privacy = privacy;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public SigmobSdkConfigRequest build() {
            return new SigmobSdkConfigRequest(this.app, this.device, this.network, this.privacy, this.user, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_SigmobSdkConfigRequest extends ProtoAdapter<SigmobSdkConfigRequest> {
        public ProtoAdapter_SigmobSdkConfigRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SigmobSdkConfigRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public SigmobSdkConfigRequest decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.app(App.ADAPTER.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.device(Device.ADAPTER.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.network(Network.ADAPTER.decode(protoReader));
                } else if (nextTag == 4) {
                    builder.privacy(Privacy.ADAPTER.decode(protoReader));
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.user(User.ADAPTER.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, SigmobSdkConfigRequest sigmobSdkConfigRequest) {
            App.ADAPTER.encodeWithTag(protoWriter, 1, sigmobSdkConfigRequest.app);
            Device.ADAPTER.encodeWithTag(protoWriter, 2, sigmobSdkConfigRequest.device);
            Network.ADAPTER.encodeWithTag(protoWriter, 3, sigmobSdkConfigRequest.network);
            Privacy.ADAPTER.encodeWithTag(protoWriter, 4, sigmobSdkConfigRequest.privacy);
            User.ADAPTER.encodeWithTag(protoWriter, 5, sigmobSdkConfigRequest.user);
            protoWriter.writeBytes(sigmobSdkConfigRequest.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(SigmobSdkConfigRequest sigmobSdkConfigRequest) {
            return sigmobSdkConfigRequest.unknownFields().size() + User.ADAPTER.encodedSizeWithTag(5, sigmobSdkConfigRequest.user) + Privacy.ADAPTER.encodedSizeWithTag(4, sigmobSdkConfigRequest.privacy) + Network.ADAPTER.encodedSizeWithTag(3, sigmobSdkConfigRequest.network) + Device.ADAPTER.encodedSizeWithTag(2, sigmobSdkConfigRequest.device) + App.ADAPTER.encodedSizeWithTag(1, sigmobSdkConfigRequest.app);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public SigmobSdkConfigRequest redact(SigmobSdkConfigRequest sigmobSdkConfigRequest) {
            Builder newBuilder = sigmobSdkConfigRequest.newBuilder();
            App app = newBuilder.app;
            if (app != null) {
                newBuilder.app = App.ADAPTER.redact(app);
            }
            Device device = newBuilder.device;
            if (device != null) {
                newBuilder.device = Device.ADAPTER.redact(device);
            }
            Network network = newBuilder.network;
            if (network != null) {
                newBuilder.network = Network.ADAPTER.redact(network);
            }
            Privacy privacy = newBuilder.privacy;
            if (privacy != null) {
                newBuilder.privacy = Privacy.ADAPTER.redact(privacy);
            }
            User user = newBuilder.user;
            if (user != null) {
                newBuilder.user = User.ADAPTER.redact(user);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_SigmobSdkConfigRequest protoAdapter_SigmobSdkConfigRequest = new ProtoAdapter_SigmobSdkConfigRequest();
        ADAPTER = protoAdapter_SigmobSdkConfigRequest;
        CREATOR = AndroidMessage.newCreator(protoAdapter_SigmobSdkConfigRequest);
        YVzcZpd();
    }

    public SigmobSdkConfigRequest(App app, Device device, Network network, Privacy privacy, User user) {
        this(app, device, network, privacy, user, ByteString.EMPTY);
    }

    private static /* synthetic */ void YVzcZpd() {
        char[] charArray = "\u0011\u001d\u001f\\\u0015\u0013\u001f\u0017\\\u0010\u001d\u000b\\\u0001\u001a\u0017\u001e\u001e\\8\u001c\u001b0\u0000\u001b\u0016\u0015\u0017".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'r');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0011\u001e\u001b\u001c\u001b\u0006".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'r');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SigmobSdkConfigRequest)) {
            return false;
        }
        SigmobSdkConfigRequest sigmobSdkConfigRequest = (SigmobSdkConfigRequest) obj;
        return unknownFields().equals(sigmobSdkConfigRequest.unknownFields()) && Internal.equals(this.app, sigmobSdkConfigRequest.app) && Internal.equals(this.device, sigmobSdkConfigRequest.device) && Internal.equals(this.network, sigmobSdkConfigRequest.network) && Internal.equals(this.privacy, sigmobSdkConfigRequest.privacy) && Internal.equals(this.user, sigmobSdkConfigRequest.user);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        App app = this.app;
        int hashCode2 = (hashCode + (app != null ? app.hashCode() : 0)) * 37;
        Device device = this.device;
        int hashCode3 = (hashCode2 + (device != null ? device.hashCode() : 0)) * 37;
        Network network = this.network;
        int hashCode4 = (hashCode3 + (network != null ? network.hashCode() : 0)) * 37;
        Privacy privacy = this.privacy;
        int hashCode5 = (hashCode4 + (privacy != null ? privacy.hashCode() : 0)) * 37;
        User user = this.user;
        int hashCode6 = hashCode5 + (user != null ? user.hashCode() : 0);
        this.hashCode = hashCode6;
        return hashCode6;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.app != null) {
            sb.append(", app=");
            sb.append(this.app);
        }
        if (this.device != null) {
            sb.append(", device=");
            sb.append(this.device);
        }
        if (this.network != null) {
            sb.append(", network=");
            sb.append(this.network);
        }
        if (this.privacy != null) {
            sb.append(", privacy=");
            sb.append(this.privacy);
        }
        if (this.user != null) {
            sb.append(", user=");
            sb.append(this.user);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "SigmobSdkConfigRequest{", '}');
    }

    public SigmobSdkConfigRequest(App app, Device device, Network network, Privacy privacy, User user, ByteString byteString) {
        super(ADAPTER, byteString);
        this.app = app;
        this.device = device;
        this.network = network;
        this.privacy = privacy;
        this.user = user;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.app = this.app;
        builder.device = this.device;
        builder.network = this.network;
        builder.privacy = this.privacy;
        builder.user = this.user;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
