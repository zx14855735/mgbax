package DUi7mC;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZkASS {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final int f2180A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final int f2181A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final long f2182A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final long f2183ADYaiT;

    public AZkASS(int i, int i2, long j, long j2) {
        this.f2180A2egSU = i;
        this.f2181A4TApA = i2;
        this.f2182A5SV6n = j;
        this.f2183ADYaiT = j2;
    }

    public static AZkASS A2egSU(File file) {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            AZkASS aZkASS = new AZkASS(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
            dataInputStream.close();
            return aZkASS;
        } finally {
        }
    }

    public final void A4TApA(File file) {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f2180A2egSU);
            dataOutputStream.writeInt(this.f2181A4TApA);
            dataOutputStream.writeLong(this.f2182A5SV6n);
            dataOutputStream.writeLong(this.f2183ADYaiT);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof AZkASS)) {
            AZkASS aZkASS = (AZkASS) obj;
            if (this.f2181A4TApA == aZkASS.f2181A4TApA && this.f2182A5SV6n == aZkASS.f2182A5SV6n && this.f2180A2egSU == aZkASS.f2180A2egSU && this.f2183ADYaiT == aZkASS.f2183ADYaiT) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f2181A4TApA), Long.valueOf(this.f2182A5SV6n), Integer.valueOf(this.f2180A2egSU), Long.valueOf(this.f2183ADYaiT));
    }
}
