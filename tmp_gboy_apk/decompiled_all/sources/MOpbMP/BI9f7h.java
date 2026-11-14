package MOpbMP;

import L2suez.ASJ6gh;
import android.content.DialogInterface;
import android.os.Environment;
import android.widget.Toast;
import com.game.boy.activity.PermissionsActivity;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BI9f7h implements DialogInterface.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f5043AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ int f5044AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Serializable f5045AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Object f5046AzWtSf;

    public /* synthetic */ BI9f7h(Object obj, Serializable serializable, int i, int i2) {
        this.f5043AcNBzu = i2;
        this.f5046AzWtSf = obj;
        this.f5045AmA8tU = serializable;
        this.f5044AlLFFp = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Object obj = this.f5046AzWtSf;
        int i2 = this.f5044AlLFFp;
        Object obj2 = this.f5045AmA8tU;
        switch (this.f5043AcNBzu) {
            case 0:
                BpkvW3 bpkvW3 = (BpkvW3) obj;
                bpkvW3.getClass();
                File file = (File) obj2;
                String absolutePath = file.getAbsolutePath();
                File parentFile = file.getParentFile();
                if (file.delete()) {
                    Toast.makeText(bpkvW3.getActivity(), bpkvW3.getString(2131886274, file.getName()), 0).show();
                    LCJm5h.A2egSU.delete(bpkvW3.requireContext(), absolutePath);
                    ArrayList arrayList = BpkvW3.f5062CNPG0E;
                    if (arrayList != null) {
                        Iterator it = arrayList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (((ASJ6gh.A2egSU) it.next()).f4366A2egSU.getAbsolutePath().equals(absolutePath)) {
                                    it.remove();
                                }
                            }
                        }
                    }
                    LLiCI0.BJ7GGh bJ7GGh = bpkvW3.f5066AzWtSf;
                    bJ7GGh.f4737AcNBzu.remove(i2);
                    bJ7GGh.notifyItemRemoved(i2);
                    if (i2 < bJ7GGh.f4737AcNBzu.size()) {
                        bJ7GGh.notifyItemRangeChanged(i2, bJ7GGh.f4737AcNBzu.size() - i2);
                    }
                    if (!bpkvW3.f5079BTvldC) {
                        File file2 = bpkvW3.f5078BPw6Q8;
                        if (file2 == null) {
                            if (parentFile != null && !parentFile.equals(new File(Environment.getExternalStorageDirectory(), "GBoy/rom")) && BpkvW3.AmA8tU(parentFile)) {
                                bpkvW3.f5078BPw6Q8 = null;
                                bpkvW3.f5079BTvldC = false;
                                bpkvW3.B3GDIM();
                                bpkvW3.AlLFFp();
                                break;
                            } else {
                                bpkvW3.AlLFFp();
                                break;
                            }
                        } else if (!BpkvW3.AmA8tU(file2)) {
                            bpkvW3.AlLFFp();
                            break;
                        } else {
                            bpkvW3.f5078BPw6Q8 = null;
                            bpkvW3.f5079BTvldC = false;
                            bpkvW3.B3GDIM();
                            bpkvW3.AlLFFp();
                            break;
                        }
                    } else {
                        bpkvW3.AlLFFp();
                        break;
                    }
                }
                break;
            case 1:
                String str = (String) obj2;
                MkAsKS.AZkASS aZkASS = (MkAsKS.AZkASS) obj;
                aZkASS.AZOQYO(str);
                int checkedItemPosition = aZkASS.f5455B3GDIM.getCheckedItemPosition();
                aZkASS.f5453B25kr6.remove(str);
                aZkASS.AzWtSf();
                aZkASS.f5453B25kr6.notifyDataSetChanged();
                int i3 = checkedItemPosition != i2 ? checkedItemPosition > i2 ? checkedItemPosition - 1 : checkedItemPosition : 0;
                aZkASS.f5455B3GDIM.setItemChecked(i3, true);
                aZkASS.AYUAbz((String) aZkASS.f5453B25kr6.getItem(i3));
                break;
            default:
                androidx.core.app.AYUAbz.requestPermissions((PermissionsActivity) obj, (String[]) obj2, i2);
                break;
        }
    }
}
