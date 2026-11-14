package ADYaiT;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class CtxOCS implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f206AcNBzu = 1;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public Context f207AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Object f208AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final Object f209AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public Object f210B25kr6;

    public CtxOCS(L2suez.B25kr6 b25kr6, Context context, MTKlkd.AZOQYO azoqyo, AmA8tU amA8tU) {
        this.f210B25kr6 = b25kr6;
        this.f207AlLFFp = context;
        this.f208AmA8tU = azoqyo;
        this.f209AzWtSf = amA8tU;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        Method method;
        Object obj = this.f209AzWtSf;
        Object obj2 = this.f208AmA8tU;
        switch (this.f206AcNBzu) {
            case 0:
                if (((Method) this.f210B25kr6) == null) {
                    View view2 = (View) obj2;
                    Context context = view2.getContext();
                    while (true) {
                        String str2 = (String) obj;
                        if (context == null) {
                            int id = view2.getId();
                            if (id == -1) {
                                str = "";
                            } else {
                                str = " with id '" + view2.getContext().getResources().getResourceEntryName(id) + "'";
                            }
                            StringBuilder B3GDIM2 = CtFAbx.B3GDIM("Could not find method ", str2, "(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                            B3GDIM2.append(view2.getClass());
                            B3GDIM2.append(str);
                            throw new IllegalStateException(B3GDIM2.toString());
                        }
                        try {
                            if (!context.isRestricted() && (method = context.getClass().getMethod(str2, View.class)) != null) {
                                this.f210B25kr6 = method;
                                this.f207AlLFFp = context;
                            }
                        } catch (NoSuchMethodException unused) {
                        }
                        context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
                    }
                }
                try {
                    ((Method) this.f210B25kr6).invoke(this.f207AlLFFp, view);
                    return;
                } catch (IllegalAccessException e) {
                    throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
                } catch (InvocationTargetException e2) {
                    throw new IllegalStateException("Could not execute method for android:onClick", e2);
                }
            default:
                String ADYaiT2 = ((MTKlkd.AZOQYO) obj2).ADYaiT();
                ((L2suez.B25kr6) this.f210B25kr6).getClass();
                new I3HV03.A4TApA(this.f207AlLFFp, (String) null).BJ7GGh("ignore_version", ADYaiT2);
                ((AmA8tU) obj).dismiss();
                return;
        }
    }

    public CtxOCS(View view, String str) {
        this.f208AmA8tU = view;
        this.f209AzWtSf = str;
    }
}
