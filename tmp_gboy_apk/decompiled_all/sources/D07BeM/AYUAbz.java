package D07BeM;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AYUAbz extends JrXYwF.A4TApA {

    /* renamed from: AZkASS, reason: collision with root package name */
    public final TextView f1933AZkASS;

    /* renamed from: AaHO0E, reason: collision with root package name */
    public final AMqCpz f1934AaHO0E;

    /* renamed from: AcNBzu, reason: collision with root package name */
    public boolean f1935AcNBzu = true;

    public AYUAbz(TextView textView) {
        this.f1933AZkASS = textView;
        this.f1934AaHO0E = new AMqCpz(textView);
    }

    @Override // JrXYwF.A4TApA
    public final InputFilter[] CASmeH(InputFilter[] inputFilterArr) {
        if (!this.f1935AcNBzu) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i = 0; i < inputFilterArr.length; i++) {
                InputFilter inputFilter = inputFilterArr[i];
                if (inputFilter instanceof AMqCpz) {
                    sparseArray.put(i, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (sparseArray.indexOfKey(i3) < 0) {
                    inputFilterArr2[i2] = inputFilterArr[i3];
                    i2++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i4 = 0;
        while (true) {
            AMqCpz aMqCpz = this.f1934AaHO0E;
            if (i4 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = aMqCpz;
                return inputFilterArr3;
            }
            if (inputFilterArr[i4] == aMqCpz) {
                return inputFilterArr;
            }
            i4++;
        }
    }

    @Override // JrXYwF.A4TApA
    public final boolean Cd8JRx() {
        return this.f1935AcNBzu;
    }

    @Override // JrXYwF.A4TApA
    public final void D07BeM(boolean z) {
        if (z) {
            TextView textView = this.f1933AZkASS;
            textView.setTransformationMethod(De4eam(textView.getTransformationMethod()));
        }
    }

    @Override // JrXYwF.A4TApA
    public final void D8MqeW(boolean z) {
        this.f1935AcNBzu = z;
        TextView textView = this.f1933AZkASS;
        textView.setTransformationMethod(De4eam(textView.getTransformationMethod()));
        textView.setFilters(CASmeH(textView.getFilters()));
    }

    @Override // JrXYwF.A4TApA
    public final TransformationMethod De4eam(TransformationMethod transformationMethod) {
        return this.f1935AcNBzu ? transformationMethod instanceof AaHO0E ? transformationMethod : transformationMethod instanceof PasswordTransformationMethod ? transformationMethod : new AaHO0E(transformationMethod) : transformationMethod instanceof AaHO0E ? ((AaHO0E) transformationMethod).f1940A2egSU : transformationMethod;
    }
}
