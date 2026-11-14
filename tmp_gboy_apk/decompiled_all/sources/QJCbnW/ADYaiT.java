package QJCbnW;

import com.skydoves.colorpickerview.ColorPickerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final /* synthetic */ class ADYaiT implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f7471AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ColorPickerView f7472AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ int f7473AmA8tU;

    public /* synthetic */ ADYaiT(ColorPickerView colorPickerView, int i, int i2) {
        this.f7471AcNBzu = i2;
        this.f7472AlLFFp = colorPickerView;
        this.f7473AmA8tU = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ColorPickerView colorPickerView = this.f7472AlLFFp;
        int i = this.f7473AmA8tU;
        switch (this.f7471AcNBzu) {
            case 0:
                int i2 = ColorPickerView.BpkvW3;
                colorPickerView.getClass();
                try {
                    colorPickerView.ADYaiT(i);
                    break;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    return;
                }
            default:
                int i3 = ColorPickerView.BpkvW3;
                colorPickerView.getClass();
                try {
                    colorPickerView.ADYaiT(i);
                    break;
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
        }
    }
}
