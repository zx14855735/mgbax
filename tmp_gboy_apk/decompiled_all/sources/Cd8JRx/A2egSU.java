package Cd8JRx;

import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import androidx.fragment.app.FragmentActivity;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract /* synthetic */ class A2egSU {
    public static /* synthetic */ ShortcutInfo.Builder ADYaiT(FragmentActivity fragmentActivity, String str) {
        return new ShortcutInfo.Builder(fragmentActivity, str);
    }

    public static /* bridge */ /* synthetic */ ShortcutInfo ARc23Z(Object obj) {
        return (ShortcutInfo) obj;
    }

    public static /* bridge */ /* synthetic */ ShortcutManager ASJ6gh(Object obj) {
        return (ShortcutManager) obj;
    }

    public static /* bridge */ /* synthetic */ Class AYUAbz() {
        return ShortcutManager.class;
    }
}
