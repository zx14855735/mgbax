package MlRYy2;

import com.game.boy.view.ShaderFilePreference;
import java.io.File;
import java.io.FileFilter;
import java.util.Locale;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A2egSU implements FileFilter {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ ShaderFilePreference f5456A2egSU;

    public A2egSU(ShaderFilePreference shaderFilePreference) {
        this.f5456A2egSU = shaderFilePreference;
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        if (!file.isFile()) {
            return false;
        }
        String name = file.getName();
        Locale locale = Locale.ROOT;
        return name.toLowerCase(locale).endsWith(this.f5456A2egSU.f11131D6yqiO.toLowerCase(locale));
    }
}
