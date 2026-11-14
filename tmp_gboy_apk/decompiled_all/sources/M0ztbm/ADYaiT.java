package M0ztbm;

import AZkASS.ARc23Z;
import MS6BTZ.AmA8tU;
import MTKlkd.AMqCpz;
import Mi9UWv.ASJ6gh;
import MkAsKS.AZkASS;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.EditText;
import android.widget.Toast;
import com.bykv.vk.component.ttvideo.player.C;
import com.game.boy.MyApp;
import com.game.boy.activity.PackageActivity;
import com.game.boy.emu.gba.Console;
import com.game.boy.view.Material3EditTextPreference;
import com.game.boy.view.Material3ListPreference;
import com.game.boy.viewUi.MaterialEditTextPreference;
import com.game.boy.viewUi.MaterialListPreference;
import com.google.android.material.textfield.TextInputEditText;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT implements DialogInterface.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4974AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f4975AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Object f4976AmA8tU;

    public /* synthetic */ ADYaiT(Object obj, int i, Object obj2) {
        this.f4974AcNBzu = i;
        this.f4976AmA8tU = obj;
        this.f4975AlLFFp = obj2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Object obj = this.f4975AlLFFp;
        Object obj2 = this.f4976AmA8tU;
        switch (this.f4974AcNBzu) {
            case 0:
                ((com.game.boy.activity.A5SV6n) obj).getSharedPreferences("privacy_prefs", 0).edit().putBoolean("has_agreed_all", true).apply();
                Object obj3 = ((ARc23Z) obj2).f451AlLFFp;
                break;
            case 1:
                AmA8tU amA8tU = (AmA8tU) obj2;
                ((ClipboardManager) amA8tU.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("崩溃日志", (String) obj));
                Toast.makeText(amA8tU.getContext(), "日志已复制", 0).show();
                break;
            case 2:
                dialogInterface.dismiss();
                I3HV03.A4TApA a4TApA = (I3HV03.A4TApA) obj2;
                ASJ6gh.B3GDIM((ASJ6gh) a4TApA.f3809AmA8tU, (AMqCpz) obj, (Console) a4TApA.f3808AlLFFp);
                break;
            case 3:
                String obj4 = ((EditText) obj).getText().toString();
                AZkASS aZkASS = (AZkASS) obj2;
                aZkASS.getClass();
                String trim = obj4.trim();
                if (trim.length() != 0) {
                    if (aZkASS.AlLFFp(trim) < 0) {
                        aZkASS.f5453B25kr6.add(trim);
                        aZkASS.AzWtSf();
                        aZkASS.f5455B3GDIM.setItemChecked(aZkASS.f5453B25kr6.getCount() - 1, true);
                        aZkASS.f5453B25kr6.notifyDataSetChanged();
                        aZkASS.AYUAbz(trim);
                        aZkASS.AaHO0E(trim);
                        break;
                    } else {
                        Toast.makeText(aZkASS, 2131886692, 0).show();
                        break;
                    }
                } else {
                    Toast.makeText(aZkASS, 2131886693, 0).show();
                    break;
                }
            case 4:
                String obj5 = ((TextInputEditText) obj).getText().toString();
                Material3EditTextPreference material3EditTextPreference = (Material3EditTextPreference) obj2;
                if (material3EditTextPreference.A2egSU(obj5)) {
                    material3EditTextPreference.BmvVmW(obj5);
                    break;
                }
                break;
            case 5:
                Material3ListPreference material3ListPreference = (Material3ListPreference) obj2;
                material3ListPreference.f11130DaOi9o = i;
                String charSequence = ((CharSequence[]) obj)[i].toString();
                if (material3ListPreference.A2egSU(charSequence)) {
                    material3ListPreference.BpkvW3(charSequence);
                }
                dialogInterface.dismiss();
                break;
            case 6:
                Mm8v1u.A4TApA a4TApA2 = (Mm8v1u.A4TApA) obj2;
                ((QTPNDK.A2egSU) obj).A2egSU(a4TApA2.f5459B2KMhB.getColorEnvelope());
                if (a4TApA2.f5459B2KMhB != null) {
                    K7mCWO.A4TApA.A2egSU(a4TApA2.getContext()).A4TApA(a4TApA2.f5459B2KMhB);
                    break;
                }
                break;
            case 7:
                String obj6 = ((EditText) obj).getText().toString();
                MaterialEditTextPreference materialEditTextPreference = (MaterialEditTextPreference) obj2;
                materialEditTextPreference.BmvVmW(obj6);
                materialEditTextPreference.BNL6CD(obj6);
                break;
            case 8:
                int checkedItemPosition = ((ADYaiT.AmA8tU) dialogInterface).f83B2KMhB.f53ARc23Z.getCheckedItemPosition();
                if (checkedItemPosition != -1) {
                    MaterialListPreference materialListPreference = (MaterialListPreference) obj2;
                    materialListPreference.BpkvW3((String) ((CharSequence[]) obj)[checkedItemPosition]);
                    materialListPreference.BNL6CD(materialListPreference.BniPrB());
                    break;
                }
                break;
            default:
                PackageActivity packageActivity = (PackageActivity) ((I3HV03.A4TApA) obj2).f3809AmA8tU;
                String A2egSU2 = ((MTKlkd.A2egSU) obj).A2egSU();
                int i2 = PackageActivity.f11068BI9f7h;
                packageActivity.getClass();
                if (!A2egSU2.startsWith("http://") && !A2egSU2.startsWith("https://")) {
                    A2egSU2 = "https://".concat(A2egSU2);
                }
                try {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(A2egSU2));
                        intent.addFlags(C.ENCODING_PCM_MU_LAW);
                        intent.addCategory("android.intent.category.BROWSABLE");
                        if (intent.resolveActivity(packageActivity.getPackageManager()) != null) {
                            packageActivity.startActivity(Intent.createChooser(intent, "选择浏览器"));
                            MyApp.A2egSU("正在打开...");
                            break;
                        } else {
                            try {
                                packageActivity.startActivity(intent);
                                MyApp.A2egSU("正在打开...");
                                break;
                            } catch (ActivityNotFoundException unused) {
                                MyApp.A2egSU("无法打开链接，请尝试以下操作：\n1. 检查默认浏览器设置\n2. 安装其他浏览器");
                                return;
                            }
                        }
                    } catch (ActivityNotFoundException e) {
                        MyApp.A2egSU("无法打开链接: " + e.getMessage());
                    }
                } catch (Exception e2) {
                    MyApp.A2egSU("错误: " + e2.getMessage());
                    return;
                }
                break;
        }
    }
}
