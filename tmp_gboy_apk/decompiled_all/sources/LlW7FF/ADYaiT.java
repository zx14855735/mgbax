package LlW7FF;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT implements Callback {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ String f4872AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ AMqCpz f4873AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ boolean f4874AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Class f4875AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ ASJ6gh f4876B25kr6;

    public ADYaiT(ASJ6gh aSJ6gh, String str, AMqCpz aMqCpz, boolean z, Class cls) {
        this.f4876B25kr6 = aSJ6gh;
        this.f4872AcNBzu = str;
        this.f4873AlLFFp = aMqCpz;
        this.f4874AmA8tU = z;
        this.f4875AzWtSf = cls;
    }

    @Override // okhttp3.Callback
    public final void onFailure(Call call, IOException iOException) {
        boolean isCanceled = call.isCanceled();
        String str = this.f4872AcNBzu;
        ASJ6gh aSJ6gh = this.f4876B25kr6;
        if (isCanceled) {
            ASJ6gh.A2egSU(aSJ6gh, str);
            return;
        }
        ASJ6gh.A2egSU(aSJ6gh, str);
        aSJ6gh.AZOQYO(this.f4873AlLFFp, "网络请求失败: " + iOException.getMessage(), this.f4874AmA8tU);
    }

    @Override // okhttp3.Callback
    public final void onResponse(Call call, Response response) {
        boolean isCanceled = call.isCanceled();
        String str = this.f4872AcNBzu;
        ASJ6gh aSJ6gh = this.f4876B25kr6;
        if (isCanceled) {
            ASJ6gh.A2egSU(aSJ6gh, str);
            return;
        }
        ASJ6gh.A2egSU(aSJ6gh, str);
        boolean isSuccessful = response.isSuccessful();
        boolean z = this.f4874AmA8tU;
        AMqCpz aMqCpz = this.f4873AlLFFp;
        if (!isSuccessful) {
            aSJ6gh.AZOQYO(aMqCpz, "请求失败: " + response.message(), z);
            return;
        }
        ResponseBody body = response.body();
        if (body == null) {
            aSJ6gh.AZOQYO(aMqCpz, "响应体为空", z);
            return;
        }
        try {
            Object fromJson = aSJ6gh.f4884A4TApA.fromJson(body.string(), (Class<Object>) this.f4875AzWtSf);
            if (fromJson == null) {
                aSJ6gh.AZOQYO(aMqCpz, "服务器返回数据为空", z);
            } else {
                aSJ6gh.f4885A5SV6n.post(new C4FrIb.A2egSU(aMqCpz, 28, fromJson));
            }
        } catch (Exception e) {
            aSJ6gh.AZOQYO(aMqCpz, "解析响应失败: " + e.getMessage(), z);
        }
    }
}
