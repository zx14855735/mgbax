package AaHO0E;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.game.boy.activity.EmulatorActivity;
import com.game.boy.emu.gba.Console;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class D8MqeW implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f724AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ int f725AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f726AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Object f727AzWtSf;

    public /* synthetic */ D8MqeW(int i, int i2, Object obj, Object obj2) {
        this.f724AcNBzu = i2;
        this.f726AmA8tU = obj;
        this.f727AzWtSf = obj2;
        this.f725AlLFFp = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        SwipeRefreshLayout swipeRefreshLayout;
        androidx.activity.result.A4TApA a4TApA;
        LqstKO.ASJ6gh aSJ6gh;
        Object obj = this.f727AzWtSf;
        int i = this.f725AlLFFp;
        Object obj2 = this.f726AmA8tU;
        switch (this.f724AcNBzu) {
            case 0:
                ((TextView) obj2).setTypeface((Typeface) obj, i);
                break;
            case 1:
                File file = (File) obj2;
                if (file.delete()) {
                    MOpbMP.CTkVKb.AlLFFp(file).delete();
                }
                ((MOpbMP.COJEAR) obj).f5093AmA8tU.notifyItemChanged(i);
                break;
            case 2:
                Mi9UWv.A5SV6n a5SV6n = (Mi9UWv.A5SV6n) obj;
                Mi9UWv.ASJ6gh aSJ6gh2 = a5SV6n.f5393AmA8tU;
                aSJ6gh2.f5404B25kr6.clear();
                aSJ6gh2.f5404B25kr6.addAll((ArrayList) obj2);
                Mi9UWv.A4TApA a4TApA2 = aSJ6gh2.f5413BJ7GGh;
                if (a4TApA2 != null) {
                    a4TApA2.f5388AcNBzu = aSJ6gh2.f5404B25kr6;
                    a4TApA2.notifyDataSetChanged();
                }
                if (i == a5SV6n.f5392AlLFFp.size() && (swipeRefreshLayout = aSJ6gh2.f5405B2KMhB) != null) {
                    swipeRefreshLayout.setRefreshing(false);
                    break;
                }
                break;
            case 3:
                ((ActionMenuView) obj2).setTranslationX(((BottomAppBar) obj).BJ7GGh(r4, i));
                break;
            case 4:
                ((BottomSheetBehavior) obj).B4ZgIw((View) obj2, i, false);
                break;
            case 5:
                Object obj3 = ((A4TApA.A2egSU) obj2).f7AcNBzu;
                androidx.activity.ASJ6gh aSJ6gh3 = (androidx.activity.ASJ6gh) obj;
                String str = (String) aSJ6gh3.f8000A2egSU.get(Integer.valueOf(i));
                if (str != null) {
                    androidx.activity.result.AMqCpz aMqCpz = (androidx.activity.result.AMqCpz) aSJ6gh3.AMqCpz.get(str);
                    if (aMqCpz != null && (a4TApA = aMqCpz.f7996A2egSU) != null) {
                        if (aSJ6gh3.f8003ADYaiT.remove(str)) {
                            a4TApA.A5SV6n(obj3);
                            break;
                        }
                    } else {
                        aSJ6gh3.f8005ASJ6gh.remove(str);
                        aSJ6gh3.f8004ARc23Z.put(str, obj3);
                        break;
                    }
                }
                break;
            case 6:
                ((androidx.activity.ASJ6gh) obj).A2egSU(i, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) obj2));
                break;
            case 7:
                String[] strArr = (String[]) obj2;
                int[] iArr = new int[strArr.length];
                Activity activity = (Activity) obj;
                PackageManager packageManager = activity.getPackageManager();
                String packageName = activity.getPackageName();
                int length = strArr.length;
                for (int i2 = 0; i2 < length; i2++) {
                    iArr[i2] = packageManager.checkPermission(strArr[i2], packageName);
                }
                ((androidx.core.app.AMqCpz) activity).onRequestPermissionsResult(i, strArr, iArr);
                break;
            default:
                Console console = (Console) obj2;
                if (console.saveState(MOpbMP.CTkVKb.AmA8tU(i, console.f11097ADYaiT).getAbsolutePath()) == 0) {
                    StringBuilder sb = new StringBuilder();
                    String str2 = console.f11097ADYaiT;
                    WeakReference weakReference = EmulatorActivity.f10988DG07BK;
                    sb.append(new File(KpHwm4.AYUAbz.A2egSU("screenshot"), str2 + ".SaveType" + i).getAbsolutePath());
                    sb.append(".png");
                    String sb2 = sb.toString();
                    EmulatorActivity emulatorActivity = (EmulatorActivity) obj;
                    LLcl8r.ARc23Z aRc23Z = emulatorActivity.f11023CrfGsy;
                    if (aRc23Z != null && (aSJ6gh = aRc23Z.f4661AmA8tU) != null) {
                        aSJ6gh.f4952AlLFFp = new com.game.boy.activity.BIYEnU(emulatorActivity, true, sb2, false);
                        aSJ6gh.f4953AmA8tU = true;
                    }
                    emulatorActivity.COJEAR();
                    break;
                }
                break;
        }
    }

    public /* synthetic */ D8MqeW(androidx.activity.ASJ6gh aSJ6gh, int i, Object obj, int i2) {
        this.f724AcNBzu = i2;
        this.f727AzWtSf = aSJ6gh;
        this.f725AlLFFp = i;
        this.f726AmA8tU = obj;
    }

    public /* synthetic */ D8MqeW(Object obj, Object obj2, int i, int i2, boolean z) {
        this.f724AcNBzu = i2;
        this.f727AzWtSf = obj;
        this.f726AmA8tU = obj2;
        this.f725AlLFFp = i;
    }
}
