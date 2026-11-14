package AZkASS;

import ADYaiT.CcAIMM;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BV3sI0 extends CcAIMM implements Menu {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final AmA8tU f571AmA8tU;

    public BV3sI0(Context context, AmA8tU amA8tU) {
        super(context);
        if (amA8tU == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f571AmA8tU = amA8tU;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return ASJ6gh(this.f571AmA8tU.A2egSU(0, 0, 0, charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int addIntentOptions = this.f571AmA8tU.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = ASJ6gh(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return this.f571AmA8tU.addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final void clear() {
        B25kr6.AzWtSf azWtSf = (B25kr6.AzWtSf) this.f136AlLFFp;
        if (azWtSf != null) {
            azWtSf.clear();
        }
        this.f571AmA8tU.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        this.f571AmA8tU.close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i) {
        return ASJ6gh(this.f571AmA8tU.findItem(i));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i) {
        return ASJ6gh(this.f571AmA8tU.getItem(i));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.f571AmA8tU.hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.f571AmA8tU.isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i, int i2) {
        return this.f571AmA8tU.performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.f571AmA8tU.performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i) {
        if (((B25kr6.AzWtSf) this.f136AlLFFp) != null) {
            int i2 = 0;
            while (true) {
                B25kr6.AzWtSf azWtSf = (B25kr6.AzWtSf) this.f136AlLFFp;
                if (i2 >= azWtSf.f1011AmA8tU) {
                    break;
                }
                if (((BniPrB.A2egSU) azWtSf.ARc23Z(i2)).getGroupId() == i) {
                    ((B25kr6.AzWtSf) this.f136AlLFFp).AYUAbz(i2);
                    i2--;
                }
                i2++;
            }
        }
        this.f571AmA8tU.removeGroup(i);
    }

    @Override // android.view.Menu
    public final void removeItem(int i) {
        if (((B25kr6.AzWtSf) this.f136AlLFFp) != null) {
            int i2 = 0;
            while (true) {
                B25kr6.AzWtSf azWtSf = (B25kr6.AzWtSf) this.f136AlLFFp;
                if (i2 >= azWtSf.f1011AmA8tU) {
                    break;
                }
                if (((BniPrB.A2egSU) azWtSf.ARc23Z(i2)).getItemId() == i) {
                    ((B25kr6.AzWtSf) this.f136AlLFFp).AYUAbz(i2);
                    break;
                }
                i2++;
            }
        }
        this.f571AmA8tU.removeItem(i);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i, boolean z, boolean z2) {
        this.f571AmA8tU.setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i, boolean z) {
        this.f571AmA8tU.setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i, boolean z) {
        this.f571AmA8tU.setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.f571AmA8tU.setQwertyMode(z);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f571AmA8tU.size();
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i) {
        return this.f571AmA8tU.addSubMenu(i);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i) {
        return ASJ6gh(this.f571AmA8tU.add(i));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return this.f571AmA8tU.addSubMenu(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return ASJ6gh(this.f571AmA8tU.A2egSU(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return this.f571AmA8tU.addSubMenu(i, i2, i3, i4);
    }

    @Override // android.view.Menu
    public final MenuItem add(int i, int i2, int i3, int i4) {
        return ASJ6gh(this.f571AmA8tU.add(i, i2, i3, i4));
    }
}
