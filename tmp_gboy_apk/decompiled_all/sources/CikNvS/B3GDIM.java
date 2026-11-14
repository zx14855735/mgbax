package CikNvS;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.Editable;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.baidu.mobads.sdk.internal.an;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B3GDIM implements ActionMode.Callback {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ActionMode.Callback f1812A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final TextView f1813A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public Class f1814A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public Method f1815ADYaiT;
    public boolean AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public boolean f1816ARc23Z = false;

    public B3GDIM(ActionMode.Callback callback, TextView textView) {
        this.f1812A2egSU = callback;
        this.f1813A4TApA = textView;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f1812A2egSU.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.f1812A2egSU.onCreateActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode actionMode) {
        this.f1812A2egSU.onDestroyActionMode(actionMode);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        int checkSelfPermission;
        TextView textView = this.f1813A4TApA;
        Context context = textView.getContext();
        PackageManager packageManager = context.getPackageManager();
        boolean z = this.f1816ARc23Z;
        Class<?> cls = Integer.TYPE;
        if (!z) {
            this.f1816ARc23Z = true;
            try {
                Class<?> cls2 = Class.forName("com.android.internal.view.menu.MenuBuilder");
                this.f1814A5SV6n = cls2;
                this.f1815ADYaiT = cls2.getDeclaredMethod("removeItemAt", cls);
                this.AMqCpz = true;
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                this.f1814A5SV6n = null;
                this.f1815ADYaiT = null;
                this.AMqCpz = false;
            }
        }
        try {
            Method declaredMethod = (this.AMqCpz && this.f1814A5SV6n.isInstance(menu)) ? this.f1815ADYaiT : menu.getClass().getDeclaredMethod("removeItemAt", cls);
            for (int size = menu.size() - 1; size >= 0; size--) {
                MenuItem item = menu.getItem(size);
                if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                    declaredMethod.invoke(menu, Integer.valueOf(size));
                }
            }
            ArrayList arrayList = new ArrayList();
            if (context instanceof Activity) {
                for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(new Intent().setAction("android.intent.action.PROCESS_TEXT").setType(an.e), 0)) {
                    if (!context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                        ActivityInfo activityInfo = resolveInfo.activityInfo;
                        if (activityInfo.exported) {
                            String str = activityInfo.permission;
                            if (str != null) {
                                checkSelfPermission = context.checkSelfPermission(str);
                                if (checkSelfPermission == 0) {
                                }
                            }
                        }
                    }
                    arrayList.add(resolveInfo);
                }
            }
            for (int i = 0; i < arrayList.size(); i++) {
                ResolveInfo resolveInfo2 = (ResolveInfo) arrayList.get(i);
                MenuItem add = menu.add(0, 0, i + 100, resolveInfo2.loadLabel(packageManager));
                Intent putExtra = new Intent().setAction("android.intent.action.PROCESS_TEXT").setType(an.e).putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !((textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled()));
                ActivityInfo activityInfo2 = resolveInfo2.activityInfo;
                add.setIntent(putExtra.setClassName(activityInfo2.packageName, activityInfo2.name)).setShowAsAction(1);
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
        }
        return this.f1812A2egSU.onPrepareActionMode(actionMode, menu);
    }
}
