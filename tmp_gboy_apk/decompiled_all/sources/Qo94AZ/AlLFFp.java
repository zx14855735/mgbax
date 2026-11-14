package Qo94AZ;

import com.sigmob.sdk.downloader.core.c;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.zip.GZIPOutputStream;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class AlLFFp implements Closeable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final AcNBzu f7804AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final String f7805AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final InputStream f7806AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final long f7807AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final AZkASS f7808B25kr6 = new AZkASS(this);

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final HashMap f7809B2KMhB = new HashMap();

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f7810B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public boolean f7811B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public boolean f7812B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public boolean f7813B9tovu;

    public AlLFFp(AcNBzu acNBzu, String str, InputStream inputStream, long j) {
        this.f7804AcNBzu = acNBzu;
        this.f7805AlLFFp = str;
        this.f7806AmA8tU = inputStream;
        this.f7807AzWtSf = j;
        this.f7811B4ZgIw = j < 0;
        this.f7813B9tovu = true;
    }

    public static void A5SV6n(PrintWriter printWriter, String str, String str2) {
        printWriter.append((CharSequence) str).append(": ").append((CharSequence) str2).append("\r\n");
    }

    public final String A2egSU(String str) {
        return (String) this.f7809B2KMhB.get(str.toLowerCase());
    }

    public final boolean A4TApA() {
        return "close".equals(A2egSU("connection"));
    }

    public final void ADYaiT(OutputStream outputStream) {
        String str = this.f7805AlLFFp;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        AcNBzu acNBzu = this.f7804AcNBzu;
        try {
            if (acNBzu == null) {
                throw new Error("sendResponse(): Status can't be null.");
            }
            PrintWriter printWriter = new PrintWriter((Writer) new BufferedWriter(new OutputStreamWriter(outputStream, new A4TApA(str).A2egSU())), false);
            printWriter.append("HTTP/1.1 ").append("" + acNBzu.f7802AcNBzu + " " + acNBzu.f7803AlLFFp).append(" \r\n");
            if (str != null) {
                A5SV6n(printWriter, "Content-Type", str);
            }
            if (A2egSU("date") == null) {
                A5SV6n(printWriter, "Date", simpleDateFormat.format(new Date()));
            }
            for (Map.Entry entry : this.f7808B25kr6.entrySet()) {
                A5SV6n(printWriter, (String) entry.getKey(), (String) entry.getValue());
            }
            if (A2egSU("connection") == null) {
                A5SV6n(printWriter, "Connection", this.f7813B9tovu ? "keep-alive" : "close");
            }
            if (A2egSU("content-length") != null) {
                this.f7812B7CMnp = false;
            }
            if (this.f7812B7CMnp) {
                A5SV6n(printWriter, "Content-Encoding", "gzip");
                this.f7811B4ZgIw = true;
            }
            InputStream inputStream = this.f7806AmA8tU;
            long j = inputStream != null ? this.f7807AzWtSf : 0L;
            if (this.f7810B3GDIM != 5 && this.f7811B4ZgIw) {
                A5SV6n(printWriter, c.h, "chunked");
            } else if (!this.f7812B7CMnp) {
                j = ARc23Z(printWriter, j);
            }
            printWriter.append("\r\n");
            printWriter.flush();
            if (this.f7810B3GDIM != 5 && this.f7811B4ZgIw) {
                AaHO0E aaHO0E = new AaHO0E(outputStream);
                if (this.f7812B7CMnp) {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(aaHO0E);
                    AMqCpz(gZIPOutputStream, -1L);
                    gZIPOutputStream.finish();
                } else {
                    AMqCpz(aaHO0E, -1L);
                }
                aaHO0E.A2egSU();
            } else if (this.f7812B7CMnp) {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(outputStream);
                AMqCpz(gZIPOutputStream2, -1L);
                gZIPOutputStream2.finish();
            } else {
                AMqCpz(outputStream, j);
            }
            outputStream.flush();
            B25kr6.ADYaiT(inputStream);
        } catch (IOException e) {
            B25kr6.f7818AZkASS.log(Level.SEVERE, "Could not send response to the client", (Throwable) e);
        }
    }

    public final void AMqCpz(OutputStream outputStream, long j) {
        byte[] bArr = new byte[(int) 16384];
        boolean z = j == -1;
        while (true) {
            if (j <= 0 && !z) {
                return;
            }
            int read = this.f7806AmA8tU.read(bArr, 0, (int) (z ? 16384L : Math.min(j, 16384L)));
            if (read <= 0) {
                return;
            }
            outputStream.write(bArr, 0, read);
            if (!z) {
                j -= read;
            }
        }
    }

    public final long ARc23Z(PrintWriter printWriter, long j) {
        String A2egSU2 = A2egSU("content-length");
        if (A2egSU2 != null) {
            try {
                j = Long.parseLong(A2egSU2);
            } catch (NumberFormatException unused) {
                B25kr6.f7818AZkASS.severe("content-length was no number ".concat(A2egSU2));
            }
        }
        printWriter.print("Content-Length: " + j + "\r\n");
        return j;
    }

    public final void ASJ6gh(boolean z) {
        this.f7812B7CMnp = z;
    }

    public final void AYUAbz(boolean z) {
        this.f7813B9tovu = z;
    }

    public final void AZOQYO(int i) {
        this.f7810B3GDIM = i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        InputStream inputStream = this.f7806AmA8tU;
        if (inputStream != null) {
            inputStream.close();
        }
    }
}
