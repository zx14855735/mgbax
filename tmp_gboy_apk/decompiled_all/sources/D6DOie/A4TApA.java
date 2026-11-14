package D6DOie;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteOrder;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA extends InputStream implements DataInput {

    /* renamed from: B25kr6, reason: collision with root package name */
    public static final ByteOrder f1943B25kr6 = ByteOrder.LITTLE_ENDIAN;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public static final ByteOrder f1944B2KMhB = ByteOrder.BIG_ENDIAN;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final DataInputStream f1945AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public ByteOrder f1946AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final int f1947AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public int f1948AzWtSf;

    static {
        prpvCXL();
    }

    public A4TApA(InputStream inputStream) {
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        this.f1946AlLFFp = byteOrder;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f1945AcNBzu = dataInputStream;
        int available = dataInputStream.available();
        this.f1947AmA8tU = available;
        this.f1948AzWtSf = 0;
        dataInputStream.mark(available);
        this.f1946AlLFFp = byteOrder;
    }

    private static /* synthetic */ void prpvCXL() {
        char[] charArray = "þòð³úüðø³ÿòä³îõøññ³×óôßïôùúø".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 157);
        }
        String str = new String(charArray);
        char[] charArray2 = "þñôóôé".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 157);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f1945AcNBzu.available();
    }

    @Override // java.io.InputStream
    public final int read() {
        this.f1948AzWtSf++;
        return this.f1945AcNBzu.read();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        this.f1948AzWtSf++;
        return this.f1945AcNBzu.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() {
        int i = this.f1948AzWtSf + 1;
        this.f1948AzWtSf = i;
        if (i > this.f1947AmA8tU) {
            throw new EOFException();
        }
        int read = this.f1945AcNBzu.read();
        if (read >= 0) {
            return (byte) read;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        this.f1948AzWtSf += 2;
        return this.f1945AcNBzu.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i2) {
        int i3 = this.f1948AzWtSf + i2;
        this.f1948AzWtSf = i3;
        if (i3 > this.f1947AmA8tU) {
            throw new EOFException();
        }
        if (this.f1945AcNBzu.read(bArr, i, i2) != i2) {
            throw new IOException("Couldn't read up to the length of buffer");
        }
    }

    @Override // java.io.DataInput
    public final int readInt() {
        int i = this.f1948AzWtSf + 4;
        this.f1948AzWtSf = i;
        if (i > this.f1947AmA8tU) {
            throw new EOFException();
        }
        DataInputStream dataInputStream = this.f1945AcNBzu;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        int read3 = dataInputStream.read();
        int read4 = dataInputStream.read();
        if ((read | read2 | read3 | read4) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f1946AlLFFp;
        if (byteOrder == f1943B25kr6) {
            return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
        }
        if (byteOrder == f1944B2KMhB) {
            return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
        }
        throw new IOException("Invalid byte order: " + this.f1946AlLFFp);
    }

    @Override // java.io.DataInput
    public final String readLine() {
        return null;
    }

    @Override // java.io.DataInput
    public final long readLong() {
        long j;
        long j2;
        int i = this.f1948AzWtSf + 8;
        this.f1948AzWtSf = i;
        if (i > this.f1947AmA8tU) {
            throw new EOFException();
        }
        DataInputStream dataInputStream = this.f1945AcNBzu;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        int read3 = dataInputStream.read();
        int read4 = dataInputStream.read();
        int read5 = dataInputStream.read();
        int read6 = dataInputStream.read();
        int read7 = dataInputStream.read();
        int read8 = dataInputStream.read();
        if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f1946AlLFFp;
        if (byteOrder == f1943B25kr6) {
            j = (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8);
            j2 = read;
        } else {
            if (byteOrder != f1944B2KMhB) {
                throw new IOException("Invalid byte order: " + this.f1946AlLFFp);
            }
            j = (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8);
            j2 = read8;
        }
        return j + j2;
    }

    @Override // java.io.DataInput
    public final short readShort() {
        int i = this.f1948AzWtSf + 2;
        this.f1948AzWtSf = i;
        if (i > this.f1947AmA8tU) {
            throw new EOFException();
        }
        DataInputStream dataInputStream = this.f1945AcNBzu;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        if ((read | read2) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f1946AlLFFp;
        if (byteOrder == f1943B25kr6) {
            return (short) ((read2 << 8) + read);
        }
        if (byteOrder == f1944B2KMhB) {
            return (short) ((read << 8) + read2);
        }
        throw new IOException("Invalid byte order: " + this.f1946AlLFFp);
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        this.f1948AzWtSf += 2;
        return this.f1945AcNBzu.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        this.f1948AzWtSf++;
        return this.f1945AcNBzu.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() {
        int i = this.f1948AzWtSf + 2;
        this.f1948AzWtSf = i;
        if (i > this.f1947AmA8tU) {
            throw new EOFException();
        }
        DataInputStream dataInputStream = this.f1945AcNBzu;
        int read = dataInputStream.read();
        int read2 = dataInputStream.read();
        if ((read | read2) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f1946AlLFFp;
        if (byteOrder == f1943B25kr6) {
            return (read2 << 8) + read;
        }
        if (byteOrder == f1944B2KMhB) {
            return (read << 8) + read2;
        }
        throw new IOException("Invalid byte order: " + this.f1946AlLFFp);
    }

    public final void seek(long j) {
        int i = this.f1948AzWtSf;
        if (i > j) {
            this.f1948AzWtSf = 0;
            DataInputStream dataInputStream = this.f1945AcNBzu;
            dataInputStream.reset();
            dataInputStream.mark(this.f1947AmA8tU);
        } else {
            j -= i;
        }
        int i2 = (int) j;
        if (skipBytes(i2) != i2) {
            throw new IOException("Couldn't seek up to the byteCount");
        }
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) {
        int min = Math.min(i, this.f1947AmA8tU - this.f1948AzWtSf);
        int i2 = 0;
        while (i2 < min) {
            i2 += this.f1945AcNBzu.skipBytes(min - i2);
        }
        this.f1948AzWtSf += i2;
        return i2;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        int read = this.f1945AcNBzu.read(bArr, i, i2);
        this.f1948AzWtSf += read;
        return read;
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) {
        int length = this.f1948AzWtSf + bArr.length;
        this.f1948AzWtSf = length;
        if (length <= this.f1947AmA8tU) {
            if (this.f1945AcNBzu.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
            return;
        }
        throw new EOFException();
    }

    public A4TApA(byte[] bArr) {
        this(new ByteArrayInputStream(bArr));
    }
}
