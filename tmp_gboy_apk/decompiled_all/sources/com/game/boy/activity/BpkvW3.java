package com.game.boy.activity;

import android.content.DialogInterface;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BpkvW3 implements DialogInterface.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ MkAsKS.ADYaiT f10929AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ TextInputEditText f10930AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ TextInputEditText f10931AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final /* synthetic */ TextInputEditText f10932AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final /* synthetic */ TextInputEditText f10933B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public final /* synthetic */ LayoutEditor f10934B2KMhB;

    public BpkvW3(LayoutEditor layoutEditor, MkAsKS.ADYaiT aDYaiT, TextInputEditText textInputEditText, TextInputEditText textInputEditText2, TextInputEditText textInputEditText3, TextInputEditText textInputEditText4) {
        this.f10934B2KMhB = layoutEditor;
        this.f10929AcNBzu = aDYaiT;
        this.f10930AlLFFp = textInputEditText;
        this.f10931AmA8tU = textInputEditText2;
        this.f10932AzWtSf = textInputEditText3;
        this.f10933B25kr6 = textInputEditText4;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        MkAsKS.ADYaiT aDYaiT = this.f10929AcNBzu;
        TextInputEditText textInputEditText = this.f10930AlLFFp;
        TextInputEditText textInputEditText2 = this.f10931AmA8tU;
        TextInputEditText textInputEditText3 = this.f10932AzWtSf;
        TextInputEditText textInputEditText4 = this.f10933B25kr6;
        Map map = LayoutEditor.f11052BChYOn;
        LayoutEditor layoutEditor = this.f10934B2KMhB;
        try {
            int AcNBzu2 = LayoutEditor.AcNBzu(textInputEditText);
            int AcNBzu3 = LayoutEditor.AcNBzu(textInputEditText2);
            int AcNBzu4 = LayoutEditor.AcNBzu(textInputEditText3);
            int AcNBzu5 = LayoutEditor.AcNBzu(textInputEditText4);
            if (AcNBzu4 > 0 && AcNBzu5 > 0) {
                if (AcNBzu2 >= 0 && AcNBzu3 >= 0) {
                    if (AcNBzu2 + AcNBzu4 <= layoutEditor.f11057B3GDIM.getWidth() && AcNBzu3 + AcNBzu5 <= layoutEditor.f11057B3GDIM.getHeight()) {
                        aDYaiT.A2egSU(AcNBzu2, AcNBzu3, AcNBzu4, AcNBzu5);
                        layoutEditor.f11055B25kr6 = true;
                        layoutEditor.f11057B3GDIM.invalidate();
                        Toast.makeText(layoutEditor, "已更新控件位置和尺寸", 0).show();
                        return;
                    }
                    Toast.makeText(layoutEditor, "位置或尺寸超出屏幕范围", 0).show();
                    return;
                }
                Toast.makeText(layoutEditor, "坐标不能为负数", 0).show();
                return;
            }
            Toast.makeText(layoutEditor, "宽度和高度必须大于0", 0).show();
        } catch (NumberFormatException unused) {
            Toast.makeText(layoutEditor, "请输入有效的数字", 0).show();
        }
    }
}
