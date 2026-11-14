package DRlcZ9;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.preference.Preference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class AzWtSf implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final Preference f2091AcNBzu;

    public AzWtSf(Preference preference) {
        this.f2091AcNBzu = preference;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Preference preference = this.f2091AcNBzu;
        CharSequence ASJ6gh2 = preference.ASJ6gh();
        if (!preference.f9105CcAIMM || TextUtils.isEmpty(ASJ6gh2)) {
            return;
        }
        contextMenu.setHeaderTitle(ASJ6gh2);
        contextMenu.add(0, 0, 0, 2131886234).setOnMenuItemClickListener(this);
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        Preference preference = this.f2091AcNBzu;
        ClipboardManager clipboardManager = (ClipboardManager) preference.getContext().getSystemService("clipboard");
        CharSequence ASJ6gh2 = preference.ASJ6gh();
        clipboardManager.setPrimaryClip(ClipData.newPlainText("Preference", ASJ6gh2));
        Toast.makeText(preference.getContext(), preference.getContext().getString(2131886688, ASJ6gh2), 0).show();
        return true;
    }
}
