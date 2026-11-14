package GJee0v;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.SharedPreferences;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AaHO0E implements Thread.UncaughtExceptionHandler {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public static final AaHO0E f3044A5SV6n = new AaHO0E();

    /* renamed from: ADYaiT, reason: collision with root package name */
    public static final Charset f3045ADYaiT = Charset.forName("UTF-8");

    /* renamed from: A2egSU, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f3046A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public Context f3047A4TApA = null;

    static {
        JgRbS();
    }

    public static String A2egSU(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Charset charset = f3045ADYaiT;
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, charset);
        PrintWriter printWriter = new PrintWriter((Writer) outputStreamWriter, true);
        th.printStackTrace(printWriter);
        String str = new String(byteArrayOutputStream.toByteArray(), charset);
        printWriter.close();
        outputStreamWriter.close();
        byteArrayOutputStream.close();
        return str;
    }

    private static /* synthetic */ void JgRbS() {
        char[] charArray = "äèê©àæêâ©åèþ©ôïâëë©ÍéîÅõîãàâ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 135);
        }
        String str = new String(charArray);
        char[] charArray2 = "äëîéîó".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 135);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public final void A4TApA(Context context) {
        this.f3047A4TApA = context;
        this.f3046A2egSU = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        Context context2 = this.f3047A4TApA;
        if (context2 != null) {
            SharedPreferences sharedPreferences = context2.getSharedPreferences("saveddata", 0);
            String string = sharedPreferences.getString("adnsdkcrash", "");
            if (string.length() > 0) {
                CtFAbx.B7CMnp("002", string, null);
                int i = AZOQYO.f3039AcNBzu;
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("adnsdkcrash", "");
                edit.commit();
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        String str;
        try {
            str = A2egSU(th);
        } catch (IOException unused) {
            str = null;
        }
        Context context = this.f3047A4TApA;
        if (context != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("saveddata", 0);
            if (str == null) {
                str = "";
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("adnsdkcrash", str);
            edit.commit();
        }
        this.f3046A2egSU.uncaughtException(thread, th);
    }
}
