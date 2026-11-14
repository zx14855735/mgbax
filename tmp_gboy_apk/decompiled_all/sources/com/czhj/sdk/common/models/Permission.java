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
public final class Permission extends AndroidMessage<Permission, Builder> {
    public static final ProtoAdapter<Permission> ADAPTER;
    public static final Parcelable.Creator<Permission> CREATOR;
    public static final Boolean DEFAULT_ACCELEROMETER;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean accelerometer;

    public static final class Builder extends Message.Builder<Permission, Builder> {
        public Boolean accelerometer;

        public Builder accelerometer(Boolean bool) {
            this.accelerometer = bool;
            return this;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.Message.Builder
        public Permission build() {
            return new Permission(this.accelerometer, buildUnknownFields());
        }
    }

    public static final class ProtoAdapter_Permission extends ProtoAdapter<Permission> {
        public ProtoAdapter_Permission() {
            super(FieldEncoding.LENGTH_DELIMITED, Permission.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.czhj.wire.ProtoAdapter
        public Permission decode(ProtoReader protoReader) {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag != 1) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.accelerometer(ProtoAdapter.BOOL.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, Permission permission) {
            ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, permission.accelerometer);
            protoWriter.writeBytes(permission.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(Permission permission) {
            return permission.unknownFields().size() + ProtoAdapter.BOOL.encodedSizeWithTag(1, permission.accelerometer);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public Permission redact(Permission permission) {
            Builder newBuilder = permission.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        ProtoAdapter_Permission protoAdapter_Permission = new ProtoAdapter_Permission();
        ADAPTER = protoAdapter_Permission;
        CREATOR = AndroidMessage.newCreator(protoAdapter_Permission);
        DEFAULT_ACCELEROMETER = Boolean.FALSE;
        lGYq();
    }

    public Permission(Boolean bool) {
        this(bool, ByteString.EMPTY);
    }

    private static /* synthetic */ void lGYq() {
        char[] charArray = "<02q8>2:q=0&q,7:33q\u001516\u001d-6;8:".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '_');
        }
        String str = new String(charArray);
        char[] charArray2 = "<3616+".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '_');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Permission)) {
            return false;
        }
        Permission permission = (Permission) obj;
        return unknownFields().equals(permission.unknownFields()) && Internal.equals(this.accelerometer, permission.accelerometer);
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Boolean bool = this.accelerometer;
        int hashCode2 = hashCode + (bool != null ? bool.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.accelerometer = this.accelerometer;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.accelerometer != null) {
            sb.append(", accelerometer=");
            sb.append(this.accelerometer);
        }
        return A2egSU.AmA8tU(sb, 0, 2, "Permission{", '}');
    }

    public Permission(Boolean bool, ByteString byteString) {
        super(ADAPTER, byteString);
        this.accelerometer = bool;
    }
}
