package HMGPfW;

import Hdahpu.AZOQYO;
import android.util.Base64;
import com.game.boy.MyApp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A5SV6n implements Callback {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f3383AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final Object f3384AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Object f3385AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Object f3386AzWtSf;

    public A5SV6n(MIEDxH.A2egSU a2egSU, File file, boolean z, AZOQYO azoqyo) {
        this.f3386AzWtSf = a2egSU;
        this.f3384AlLFFp = file;
        this.f3383AcNBzu = z;
        this.f3385AmA8tU = azoqyo;
    }

    public void A2egSU() {
        AMqCpz.A2egSU((AMqCpz) this.f3386AzWtSf, this, false);
    }

    public File A4TApA() {
        File file;
        synchronized (((AMqCpz) this.f3386AzWtSf)) {
            try {
                ADYaiT aDYaiT = (ADYaiT) this.f3384AlLFFp;
                if (aDYaiT.f3391ARc23Z != this) {
                    throw new IllegalStateException();
                }
                if (!aDYaiT.AMqCpz) {
                    ((boolean[]) this.f3385AmA8tU)[0] = true;
                }
                file = aDYaiT.f3390ADYaiT[0];
                ((AMqCpz) this.f3386AzWtSf).f3393AcNBzu.mkdirs();
            } catch (Throwable th) {
                throw th;
            }
        }
        return file;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        File file = (File) this.f3384AlLFFp;
        if (file.exists()) {
            file.delete();
        }
        if (!this.f3383AcNBzu || ((AZOQYO) this.f3385AmA8tU) == null) {
            return;
        }
        MyApp.A2egSU("更新失败：" + iOException.getMessage());
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        try {
            try {
                if (!response.isSuccessful()) {
                    throw new IOException("服务器错误：" + response.code());
                }
                JSONArray optJSONArray = new JSONObject(new String(MIEDxH.A2egSU.A2egSU(Base64.decode(response.body().string(), 0), MIEDxH.A2egSU.AMqCpz), "UTF-8")).optJSONArray("configs");
                if (optJSONArray == null || optJSONArray.length() == 0) {
                    throw new IOException("云端配置为空");
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i);
                    String optString = jSONObject.optString("romCode");
                    String optString2 = jSONObject.optString("configText");
                    if (!optString.isEmpty() && !optString2.isEmpty()) {
                        sb.append("[");
                        sb.append(optString);
                        sb.append("]\n");
                        for (String str : optString2.split("\n")) {
                            if (!str.trim().isEmpty()) {
                                sb.append(str);
                                sb.append("\n");
                            }
                        }
                        sb.append("\n");
                    }
                }
                byte[] A4TApA2 = MIEDxH.A2egSU.A4TApA(sb.toString().getBytes("UTF-8"), MIEDxH.A2egSU.f4978ARc23Z);
                FileOutputStream fileOutputStream = new FileOutputStream((File) this.f3384AlLFFp);
                try {
                    fileOutputStream.write(A4TApA2);
                    fileOutputStream.close();
                    if (((File) this.f3384AlLFFp).length() == 0) {
                        throw new IOException("临时文件为空");
                    }
                    synchronized (((MIEDxH.A2egSU) this.f3386AzWtSf).f4983A5SV6n) {
                        if (!((File) this.f3384AlLFFp).renameTo(((MIEDxH.A2egSU) this.f3386AzWtSf).f4981A2egSU)) {
                            throw new IOException("renameTo 失败");
                        }
                        ((MIEDxH.A2egSU) this.f3386AzWtSf).f4982A4TApA.evictAll();
                        if (this.f3383AcNBzu && ((AZOQYO) this.f3385AmA8tU) != null) {
                            MyApp.A2egSU("配置更新成功，重启游戏生效");
                        }
                    }
                    response.close();
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (Exception e) {
                if (((File) this.f3384AlLFFp).exists()) {
                    ((File) this.f3384AlLFFp).delete();
                }
                if (this.f3383AcNBzu && ((AZOQYO) this.f3385AmA8tU) != null) {
                    MyApp.A2egSU("更新失败：" + e.getMessage());
                }
                response.close();
            }
        } catch (Throwable th2) {
            response.close();
            throw th2;
        }
    }

    public A5SV6n(AMqCpz aMqCpz, ADYaiT aDYaiT) {
        this.f3386AzWtSf = aMqCpz;
        this.f3384AlLFFp = aDYaiT;
        this.f3385AmA8tU = aDYaiT.AMqCpz ? null : new boolean[aMqCpz.f3399B3GDIM];
    }
}
