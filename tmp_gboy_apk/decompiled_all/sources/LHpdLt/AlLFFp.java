package LHpdLt;

import android.app.Activity;
import android.content.Context;
import android.widget.Button;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.baidu.mobads.sdk.internal.cb;
import com.game.boy.MyApp;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AlLFFp extends LLYwnm.B25kr6 {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f4512A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f4513A4TApA;

    public /* synthetic */ AlLFFp(int i, Object obj) {
        this.f4512A2egSU = i;
        this.f4513A4TApA = obj;
    }

    @Override // LLYwnm.B25kr6
    public final void A2egSU(String str) {
        switch (this.f4512A2egSU) {
            case 0:
                MyApp.A2egSU("邀请失败：" + str);
                break;
            case 1:
                MyApp.A2egSU(str);
                if (str.contains("登录已失效")) {
                    MOpbMP.ARc23Z.AlLFFp(new I3HV03.A4TApA((Context) ((BTvldC) this.f4513A4TApA).f4576B2KMhB));
                    break;
                }
                break;
            case 2:
                if (!((Mi9UWv.ASJ6gh) ((LLiCI0.BV3sI0) this.f4513A4TApA).f4753AmA8tU).f5414BNL6CD) {
                    MyApp.A2egSU("创建失败：" + str);
                    break;
                }
                break;
            default:
                if (!((Mi9UWv.ASJ6gh) this.f4513A4TApA).f5414BNL6CD) {
                    Mi9UWv.ASJ6gh aSJ6gh = (Mi9UWv.ASJ6gh) this.f4513A4TApA;
                    SwipeRefreshLayout swipeRefreshLayout = aSJ6gh.f5405B2KMhB;
                    if (swipeRefreshLayout != null) {
                        swipeRefreshLayout.post(new LLYwnm.AMqCpz(12, aSJ6gh));
                    }
                    MyApp.A2egSU(str);
                    break;
                }
                break;
        }
    }

    @Override // LLYwnm.B25kr6
    public final void A4TApA(Map map) {
        switch (this.f4512A2egSU) {
            case 0:
                MyApp.A2egSU("已邀请 " + ((BJ7GGh) this.f4513A4TApA).f4548A2egSU);
                return;
            case 1:
                BTvldC bTvldC = (BTvldC) this.f4513A4TApA;
                if (bTvldC.f4578B4ZgIw) {
                    MyApp.A2egSU("已取消准备");
                    bTvldC.f4578B4ZgIw = false;
                    Button button = bTvldC.f4574AzWtSf;
                    if (button != null) {
                        button.setText("准备");
                        return;
                    }
                    return;
                }
                MyApp.A2egSU("已准备");
                bTvldC.f4578B4ZgIw = true;
                Button button2 = bTvldC.f4574AzWtSf;
                if (button2 != null) {
                    button2.setText("取消准备");
                    return;
                }
                return;
            case 2:
                if (((Mi9UWv.ASJ6gh) ((LLiCI0.BV3sI0) this.f4513A4TApA).f4753AmA8tU).f5414BNL6CD) {
                    return;
                }
                String str = (String) map.get("room_id");
                MyApp.A2egSU("创建房间成功");
                ((Mi9UWv.ASJ6gh) ((LLiCI0.BV3sI0) this.f4513A4TApA).f4753AmA8tU).f5410BChYOn.AMqCpz(str);
                return;
            default:
                if (((Mi9UWv.ASJ6gh) this.f4513A4TApA).f5414BNL6CD) {
                    return;
                }
                String json = Mi9UWv.ASJ6gh.BpkvW3.toJson(map);
                Mi9UWv.ASJ6gh aSJ6gh = (Mi9UWv.ASJ6gh) this.f4513A4TApA;
                Activity activity = aSJ6gh.f5409B9tovu;
                if (activity == null || activity.isFinishing() || aSJ6gh.f5414BNL6CD) {
                    return;
                }
                try {
                    JsonObject asJsonObject = new JsonParser().parse(json).getAsJsonObject();
                    if (!asJsonObject.has(cb.o) || !asJsonObject.get(cb.o).getAsBoolean()) {
                        throw new Exception("服务器返回不成功状态");
                    }
                    HashMap B7CMnp2 = Mi9UWv.ASJ6gh.B7CMnp(asJsonObject);
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry entry : B7CMnp2.entrySet()) {
                        MTKlkd.AMqCpz aMqCpz = (MTKlkd.AMqCpz) entry.getValue();
                        if (aMqCpz != null) {
                            aMqCpz.AZkASS((String) entry.getKey());
                            aMqCpz.f5225ASJ6gh = "检测中...";
                            arrayList.add(aMqCpz);
                        }
                    }
                    Collections.sort(arrayList, Mi9UWv.ASJ6gh.f5403C2rE4F);
                    Activity activity2 = aSJ6gh.f5409B9tovu;
                    if (activity2 != null && !activity2.isFinishing() && !aSJ6gh.f5414BNL6CD) {
                        aSJ6gh.f5409B9tovu.runOnUiThread(new Mi9UWv.A5SV6n(aSJ6gh, arrayList, 1));
                    }
                    ExecutorService executorService = aSJ6gh.f5411BI9f7h;
                    if (executorService != null) {
                        executorService.shutdownNow();
                    }
                    ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                    aSJ6gh.f5411BI9f7h = newSingleThreadExecutor;
                    newSingleThreadExecutor.execute(new Mi9UWv.A5SV6n(aSJ6gh, arrayList, 0));
                    return;
                } catch (Exception e) {
                    String message = e.getMessage();
                    Activity activity3 = aSJ6gh.f5409B9tovu;
                    if (activity3 == null || activity3.isFinishing() || aSJ6gh.f5414BNL6CD) {
                        return;
                    }
                    aSJ6gh.f5409B9tovu.runOnUiThread(new MOpbMP.A2egSU(aSJ6gh, 13, message));
                    return;
                }
        }
    }
}
