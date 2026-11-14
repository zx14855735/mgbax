package D07BeM;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;
import androidx.emoji2.text.AmA8tU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AZOQYO extends JrXYwF.A4TApA {

    /* renamed from: AZkASS, reason: collision with root package name */
    public final AYUAbz f1936AZkASS;

    public AZOQYO(TextView textView) {
        this.f1936AZkASS = new AYUAbz(textView);
    }

    @Override // JrXYwF.A4TApA
    public final InputFilter[] CASmeH(InputFilter[] inputFilterArr) {
        return !(AmA8tU.f8658AaHO0E != null) ? inputFilterArr : this.f1936AZkASS.CASmeH(inputFilterArr);
    }

    @Override // JrXYwF.A4TApA
    public final boolean Cd8JRx() {
        return this.f1936AZkASS.f1935AcNBzu;
    }

    @Override // JrXYwF.A4TApA
    public final void D07BeM(boolean z) {
        if (AmA8tU.f8658AaHO0E != null) {
            this.f1936AZkASS.D07BeM(z);
        }
    }

    @Override // JrXYwF.A4TApA
    public final void D8MqeW(boolean z) {
        boolean z2 = AmA8tU.f8658AaHO0E != null;
        AYUAbz aYUAbz = this.f1936AZkASS;
        if (z2) {
            aYUAbz.D8MqeW(z);
        } else {
            aYUAbz.f1935AcNBzu = z;
        }
    }

    @Override // JrXYwF.A4TApA
    public final TransformationMethod De4eam(TransformationMethod transformationMethod) {
        return !(AmA8tU.f8658AaHO0E != null) ? transformationMethod : this.f1936AZkASS.De4eam(transformationMethod);
    }
}
