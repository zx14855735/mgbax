package Qo94AZ;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.logging.Level;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class A2egSU implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final InputStream f7762AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Socket f7763AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ B25kr6 f7764AmA8tU;

    public A2egSU(B25kr6 b25kr6, InputStream inputStream, Socket socket) {
        this.f7764AmA8tU = b25kr6;
        this.f7762AcNBzu = inputStream;
        this.f7763AlLFFp = socket;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OutputStream outputStream;
        InputStream inputStream = this.f7762AcNBzu;
        B25kr6 b25kr6 = this.f7764AmA8tU;
        Socket socket = this.f7763AlLFFp;
        OutputStream outputStream2 = null;
        try {
            try {
                outputStream = socket.getOutputStream();
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            b25kr6.f7823ARc23Z.getClass();
            AZOQYO azoqyo = new AZOQYO(this.f7764AmA8tU, new AYUAbz(), this.f7762AcNBzu, outputStream, socket.getInetAddress());
            while (!socket.isClosed()) {
                azoqyo.ADYaiT();
            }
            B25kr6.ADYaiT(outputStream);
            B25kr6.ADYaiT(inputStream);
            B25kr6.ADYaiT(socket);
            b25kr6.AMqCpz.f7776A4TApA.remove(this);
        } catch (Exception e2) {
            e = e2;
            outputStream2 = outputStream;
            if ((!(e instanceof SocketException) || !"NanoHttpd Shutdown".equals(e.getMessage())) && !(e instanceof SocketTimeoutException)) {
                B25kr6.f7818AZkASS.log(Level.SEVERE, "Communication with the client broken, or an bug in the handler code", (Throwable) e);
            }
            B25kr6.ADYaiT(outputStream2);
            B25kr6.ADYaiT(inputStream);
            B25kr6.ADYaiT(socket);
            b25kr6.AMqCpz.f7776A4TApA.remove(this);
        } catch (Throwable th2) {
            th = th2;
            outputStream2 = outputStream;
            B25kr6.ADYaiT(outputStream2);
            B25kr6.ADYaiT(inputStream);
            B25kr6.ADYaiT(socket);
            b25kr6.AMqCpz.f7776A4TApA.remove(this);
            throw th;
        }
    }
}
