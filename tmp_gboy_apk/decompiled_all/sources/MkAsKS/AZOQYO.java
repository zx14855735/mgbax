package MkAsKS;

import ADYaiT.CtFAbx;
import android.content.DialogInterface;
import android.net.Uri;
import android.widget.EditText;
import android.widget.Toast;
import com.game.boy.view.ShaderFilePreference;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZOQYO implements DialogInterface.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f5449AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ Object f5450AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ Serializable f5451AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ Object f5452AzWtSf;

    public /* synthetic */ AZOQYO(Object obj, Object obj2, Serializable serializable, int i) {
        this.f5449AcNBzu = i;
        this.f5452AzWtSf = obj;
        this.f5450AlLFFp = obj2;
        this.f5451AmA8tU = serializable;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f5449AcNBzu) {
            case 0:
                String trim = ((EditText) this.f5450AlLFFp).getText().toString().trim();
                boolean isEmpty = trim.isEmpty();
                AZkASS aZkASS = (AZkASS) this.f5452AzWtSf;
                if (!isEmpty) {
                    int AlLFFp2 = aZkASS.AlLFFp(trim);
                    String str = (String) this.f5451AmA8tU;
                    if (AlLFFp2 >= 0 && !trim.equals(str)) {
                        Toast.makeText(aZkASS, "名称已存在", 0).show();
                        break;
                    } else {
                        File A2egSU2 = KpHwm4.AYUAbz.A2egSU("config/layout");
                        String encode = Uri.encode(str);
                        String encode2 = Uri.encode(trim);
                        File file = new File(A2egSU2, CtFAbx.AcNBzu(encode, "-landscape.xml"));
                        File file2 = new File(A2egSU2, CtFAbx.AcNBzu(encode2, "-landscape.xml"));
                        if (file.exists()) {
                            file.renameTo(file2);
                        }
                        File file3 = new File(A2egSU2, CtFAbx.AcNBzu(encode, "-portrait.xml"));
                        File file4 = new File(A2egSU2, CtFAbx.AcNBzu(encode2, "-portrait.xml"));
                        if (file3.exists()) {
                            file3.renameTo(file4);
                        }
                        File file5 = new File(A2egSU2, CtFAbx.AcNBzu(encode, "-landscape-kbopen.xml"));
                        File file6 = new File(A2egSU2, CtFAbx.AcNBzu(encode2, "-landscape-kbopen.xml"));
                        if (file5.exists()) {
                            file5.renameTo(file6);
                        }
                        File file7 = new File(A2egSU2, CtFAbx.AcNBzu(encode, "-portrait-kbopen.xml"));
                        File file8 = new File(A2egSU2, CtFAbx.AcNBzu(encode2, "-portrait-kbopen.xml"));
                        if (file7.exists()) {
                            file7.renameTo(file8);
                        }
                        aZkASS.f5453B25kr6.remove(str);
                        aZkASS.f5453B25kr6.add(trim);
                        aZkASS.AzWtSf();
                        aZkASS.f5453B25kr6.notifyDataSetChanged();
                        aZkASS.f5455B3GDIM.setItemChecked(aZkASS.AlLFFp(trim), true);
                        aZkASS.AYUAbz(trim);
                        Toast.makeText(aZkASS, "已重命名为 ".concat(trim), 0).show();
                        break;
                    }
                } else {
                    Toast.makeText(aZkASS, "名称不能为空", 0).show();
                    break;
                }
                break;
            default:
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                while (true) {
                    CharSequence[] charSequenceArr = (CharSequence[]) this.f5450AlLFFp;
                    if (i2 >= charSequenceArr.length) {
                        ShaderFilePreference shaderFilePreference = (ShaderFilePreference) this.f5452AzWtSf;
                        shaderFilePreference.getClass();
                        if (!arrayList.isEmpty()) {
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                String str2 = (String) it.next();
                                File file9 = new File(str2);
                                if (file9.exists() && file9.isFile()) {
                                    arrayList2.add(str2);
                                }
                            }
                            if (!arrayList2.isEmpty()) {
                                if (arrayList2.size() < arrayList.size()) {
                                    Toast.makeText(shaderFilePreference.getContext(), "已忽略 " + (arrayList.size() - arrayList2.size()) + " 个不存在的文件", 0).show();
                                }
                                String BniPrB2 = ShaderFilePreference.BniPrB(arrayList2);
                                if (shaderFilePreference.A2egSU(BniPrB2)) {
                                    shaderFilePreference.BI9f7h(BniPrB2);
                                    shaderFilePreference.C2rE4F();
                                    break;
                                }
                            } else {
                                Toast.makeText(shaderFilePreference.getContext(), "选中的文件均不存在", 0).show();
                                shaderFilePreference.BpkvW3();
                                break;
                            }
                        } else {
                            shaderFilePreference.BpkvW3();
                            break;
                        }
                    } else {
                        if (((boolean[]) this.f5451AmA8tU)[i2]) {
                            arrayList.add(charSequenceArr[i2].toString());
                        }
                        i2++;
                    }
                }
                break;
        }
    }
}
