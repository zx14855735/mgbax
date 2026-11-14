package com.bytedance.sdk.component.hf.xj.xj.hf;

import com.bytedance.sdk.component.hf.xj.e;
import com.bytedance.sdk.component.hf.xj.tf;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class c extends e {
    InputStream hf;
    HttpURLConnection xj;

    public c(HttpURLConnection httpURLConnection) {
        this.xj = httpURLConnection;
        this.hf = new kd(httpURLConnection.getInputStream(), httpURLConnection);
    }

    @Override // com.bytedance.sdk.component.hf.xj.e, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.hf.close();
            this.xj.disconnect();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.hf.xj.e
    public String hf() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.hf));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    String stringBuffer2 = stringBuffer.toString();
                    close();
                    return stringBuffer2;
                }
                stringBuffer.append(readLine + "\n");
            }
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.hf.xj.e
    public tf kd() {
        if (this.xj.getContentType() != null) {
            return tf.xj(this.xj.getContentType());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.hf.xj.e
    public byte[] u() {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            while (true) {
                try {
                    int read = this.hf.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream2.write(bArr, 0, read);
                } catch (Exception unused) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return new byte[0];
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th;
                }
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            try {
                byteArrayOutputStream2.close();
            } catch (Throwable unused4) {
            }
            return byteArray;
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.bytedance.sdk.component.hf.xj.e
    public InputStream w() {
        return this.hf;
    }

    @Override // com.bytedance.sdk.component.hf.xj.e
    public long xj() {
        try {
            return this.xj.getContentLength();
        } catch (Exception unused) {
            return 0L;
        }
    }
}
