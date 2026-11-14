package com.game.boy.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.preference.Preference;
import com.game.boy.R$styleable;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ShaderFilePreference extends Preference {

    /* renamed from: D6yqiO, reason: collision with root package name */
    public final String f11131D6yqiO;

    /* renamed from: D8MqeW, reason: collision with root package name */
    public final String f11132D8MqeW;

    /* renamed from: D8cQ8b, reason: collision with root package name */
    public ArrayList f11133D8cQ8b;

    public ShaderFilePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11133D8cQ8b = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f10884ADYaiT);
        String string = obtainStyledAttributes.getString(1);
        this.f11131D6yqiO = string;
        if (string == null) {
            this.f11131D6yqiO = ".shader";
        }
        this.f11132D8MqeW = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
        if (this.f11131D6yqiO == null) {
            this.f11131D6yqiO = ".shader";
        }
        this.BpkvW3 = "none";
    }

    public static String BniPrB(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append((String) arrayList.get(i));
        }
        return sb.toString();
    }

    @Override // androidx.preference.Preference
    public final void AaHO0E() {
        super.AaHO0E();
        C2rE4F();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (BPw6Q8.ASJ6gh.A2egSU(getContext(), com.kuaishou.weapon.p0.g.i) == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        if (BPw6Q8.ASJ6gh.A2egSU(getContext(), com.kuaishou.weapon.p0.g.i) == 0) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x005e  */
    @Override // androidx.preference.Preference
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void AmA8tU() {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.game.boy.view.ShaderFilePreference.AmA8tU():void");
    }

    public final ArrayList BmvVmW() {
        ArrayList arrayList = new ArrayList();
        String ARc23Z2 = ARc23Z("none");
        if (ARc23Z2 != null && !ARc23Z2.isEmpty() && !"none".equals(ARc23Z2)) {
            boolean z = false;
            for (String str : ARc23Z2.split(",")) {
                String trim = str.trim();
                if (!trim.isEmpty()) {
                    File file = new File(trim);
                    if (!file.exists() || !file.isFile()) {
                        z = true;
                    } else if (!arrayList.contains(trim)) {
                        arrayList.add(trim);
                    }
                }
            }
            if (z) {
                if (arrayList.isEmpty()) {
                    BI9f7h("none");
                    return arrayList;
                }
                BI9f7h(BniPrB(arrayList));
            }
        }
        return arrayList;
    }

    public final void BpkvW3() {
        BI9f7h("none");
        BNL6CD("无");
    }

    public final void C2rE4F() {
        try {
            ArrayList BmvVmW2 = BmvVmW();
            if (BmvVmW2.isEmpty()) {
                BNL6CD("无");
                return;
            }
            if (BmvVmW2.size() == 1) {
                BNL6CD("已选择：" + new File((String) BmvVmW2.get(0)).getName());
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("已选择 ");
            sb.append(BmvVmW2.size());
            sb.append(" 项：");
            for (int i = 0; i < BmvVmW2.size(); i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(new File((String) BmvVmW2.get(i)).getName());
            }
            BNL6CD(sb.toString());
        } catch (Exception e) {
            BNL6CD("错误: " + e.toString());
        }
    }

    public final void C4FrIb() {
        Iterator it = this.f11133D8cQ8b.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (!file.exists() || !file.isFile()) {
                it.remove();
            }
        }
    }

    public ShaderFilePreference(Context context) {
        super(context, null);
        this.f11133D8cQ8b = new ArrayList();
        if (this.f11131D6yqiO == null) {
            this.f11131D6yqiO = ".shader";
        }
        this.BpkvW3 = "none";
    }
}
