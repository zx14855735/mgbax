package K7mCWO;

import com.bytedance.sdk.component.tf.u.w;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ASJ6gh extends w {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final InputStream f4195AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final CopyOnWriteArrayList f4196AlLFFp;

    public ASJ6gh(InputStream inputStream, CopyOnWriteArrayList copyOnWriteArrayList) {
        super("LogcatDump$LogDumperThread");
        this.f4195AcNBzu = inputStream;
        this.f4196AlLFFp = copyOnWriteArrayList;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f4195AcNBzu));
        int i = 32768;
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (!readLine.startsWith("---------")) {
                        i -= readLine.getBytes("UTF-8").length;
                        if (i < 0) {
                            break;
                        } else {
                            this.f4196AlLFFp.add(readLine);
                        }
                    }
                } else {
                    break;
                }
            } catch (IOException unused) {
                return;
            } finally {
                com.bumptech.glide.AMqCpz.D9tr6l(bufferedReader);
            }
        }
    }
}
