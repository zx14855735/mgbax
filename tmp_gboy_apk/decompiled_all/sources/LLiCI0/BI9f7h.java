package LLiCI0;

import ADYaiT.CtFAbx;
import L2suez.ASJ6gh;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Toast;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BI9f7h implements DialogInterface.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4729AcNBzu = 0;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ File f4730AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ int f4731AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Object f4732AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ Object f4733B25kr6;

    public BI9f7h(BIYEnU bIYEnU, EditText editText, File file, int i) {
        this.f4733B25kr6 = bIYEnU;
        this.f4732AzWtSf = editText;
        this.f4730AlLFFp = file;
        this.f4731AmA8tU = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int i2 = this.f4731AmA8tU;
        Object obj = this.f4732AzWtSf;
        File file = this.f4730AlLFFp;
        Object obj2 = this.f4733B25kr6;
        switch (this.f4729AcNBzu) {
            case 0:
                String trim = ((EditText) obj).getText().toString().trim();
                if (!trim.isEmpty()) {
                    BIYEnU bIYEnU = (BIYEnU) obj2;
                    BJ7GGh bJ7GGh = bIYEnU.f4736AmA8tU;
                    String name = file.getName();
                    bJ7GGh.getClass();
                    int lastIndexOf = name.lastIndexOf(46);
                    String substring = lastIndexOf > 0 ? name.substring(lastIndexOf + 1) : "";
                    MOpbMP.BpkvW3 bpkvW3 = bIYEnU.f4736AmA8tU.f4738AlLFFp;
                    String AlLFFp2 = CtFAbx.AlLFFp(trim, ".", substring);
                    OOnEhG.A4TApA a4TApA = new OOnEhG.A4TApA(bpkvW3.getActivity());
                    String string = bpkvW3.getString(2131886700);
                    ADYaiT.AZOQYO azoqyo = a4TApA.f81AcNBzu;
                    azoqyo.AMqCpz = string;
                    BJ7GGh bJ7GGh2 = bpkvW3.f5066AzWtSf;
                    String name2 = file.getName();
                    bJ7GGh2.getClass();
                    String A2egSU2 = BJ7GGh.A2egSU(name2);
                    bpkvW3.f5066AzWtSf.getClass();
                    azoqyo.f28ASJ6gh = bpkvW3.getString(2131886702, A2egSU2, BJ7GGh.A2egSU(AlLFFp2));
                    a4TApA.AmA8tU(2131886206, new BI9f7h(bpkvW3, file, AlLFFp2, i2));
                    a4TApA.AaHO0E(2131886161, null);
                    a4TApA.AMqCpz();
                    break;
                }
                break;
            default:
                MOpbMP.BpkvW3 bpkvW32 = (MOpbMP.BpkvW3) obj2;
                BJ7GGh bJ7GGh3 = bpkvW32.f5066AzWtSf;
                String name3 = file.getName();
                bJ7GGh3.getClass();
                String A2egSU3 = BJ7GGh.A2egSU(name3);
                String str = (String) obj;
                bpkvW32.f5066AzWtSf.getClass();
                if (!A2egSU3.equals(BJ7GGh.A2egSU(str))) {
                    File file2 = new File(file.getParent(), str);
                    String replace = file.getParent().replace("/rom", "/image");
                    File file3 = new File(replace, file.getName().replace(LCJm5h.ARc23Z.ASJ6gh(file.getName()), ".png"));
                    File file4 = new File(replace, str.replace(LCJm5h.ARc23Z.ASJ6gh(str), ".png"));
                    String replace2 = file.getParent().replace("/rom", "/save");
                    File file5 = new File(replace2, file.getName().replace(LCJm5h.ARc23Z.ASJ6gh(file.getName()), ".sav"));
                    File file6 = new File(replace2, str.replace(LCJm5h.ARc23Z.ASJ6gh(str), ".sav"));
                    new File(replace).mkdirs();
                    new File(replace2).mkdirs();
                    boolean renameTo = file.renameTo(file2);
                    boolean renameTo2 = file3.exists() ? file3.renameTo(file4) : true;
                    boolean renameTo3 = file5.exists() ? file5.renameTo(file6) : true;
                    if (!renameTo) {
                        Toast.makeText(bpkvW32.getActivity(), 2131886701, 0).show();
                        break;
                    } else {
                        if (renameTo2 && renameTo3) {
                            Toast.makeText(bpkvW32.getActivity(), bpkvW32.getString(2131886703, str), 0).show();
                        } else {
                            Toast.makeText(bpkvW32.getActivity(), "ROM重命名成功，但部分关联文件操作失败", 0).show();
                        }
                        ((ASJ6gh.A2egSU) MOpbMP.BpkvW3.f5062CNPG0E.get(i2)).f4366A2egSU = file2;
                        bpkvW32.f5066AzWtSf.notifyItemChanged(i2);
                        break;
                    }
                } else {
                    Toast.makeText(bpkvW32.requireActivity(), bpkvW32.getString(2131886701), 1).show();
                    break;
                }
        }
    }

    public BI9f7h(MOpbMP.BpkvW3 bpkvW3, File file, String str, int i) {
        this.f4733B25kr6 = bpkvW3;
        this.f4730AlLFFp = file;
        this.f4732AzWtSf = str;
        this.f4731AmA8tU = i;
    }
}
