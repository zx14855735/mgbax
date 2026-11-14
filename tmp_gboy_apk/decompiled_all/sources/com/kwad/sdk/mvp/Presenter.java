package com.kwad.sdk.mvp;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.d;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class Presenter {
    private Object aYy;
    private View mRootView;
    private final List<Presenter> aYx = new CopyOnWriteArrayList();
    private PresenterState aYz = PresenterState.INIT;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'INIT' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static abstract class PresenterState {
        private static final /* synthetic */ PresenterState[] $VALUES;
        public static final PresenterState BIND;
        public static final PresenterState CREATE;
        public static final PresenterState DESTROY;
        public static final PresenterState INIT;
        public static final PresenterState UNBIND;
        private int mIndex;

        static {
            int i = 0;
            PresenterState presenterState = new PresenterState("INIT", i, i) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.1
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                }
            };
            INIT = presenterState;
            int i2 = 1;
            PresenterState presenterState2 = new PresenterState("CREATE", i2, i2) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.2
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aYx.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).M(presenter.mRootView);
                        } catch (Exception e) {
                            d.gatherException(e);
                            c.printStackTrace(e);
                        }
                    }
                }
            };
            CREATE = presenterState2;
            int i3 = 2;
            PresenterState presenterState3 = new PresenterState("BIND", i3, i3) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.3
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aYx.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).o(presenter.aYy);
                        } catch (Throwable th) {
                            d.gatherException(th);
                            c.printStackTrace(th);
                        }
                    }
                }
            };
            BIND = presenterState3;
            int i4 = 3;
            PresenterState presenterState4 = new PresenterState("UNBIND", i4, i4) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.4
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aYx.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).nJ();
                        } catch (Exception e) {
                            d.gatherException(e);
                            c.printStackTrace(e);
                        }
                    }
                }
            };
            UNBIND = presenterState4;
            int i5 = 4;
            PresenterState presenterState5 = new PresenterState("DESTROY", i5, i5) { // from class: com.kwad.sdk.mvp.Presenter.PresenterState.5
                @Override // com.kwad.sdk.mvp.Presenter.PresenterState
                public final void performCallState(Presenter presenter) {
                    Iterator it = presenter.aYx.iterator();
                    while (it.hasNext()) {
                        try {
                            ((Presenter) it.next()).destroy();
                        } catch (Exception e) {
                            d.gatherException(e);
                            c.printStackTrace(e);
                        }
                    }
                }
            };
            DESTROY = presenterState5;
            $VALUES = new PresenterState[]{presenterState, presenterState2, presenterState3, presenterState4, presenterState5};
            KiFhtTy();
        }

        private static /* synthetic */ void KiFhtTy() {
            char[] charArray = "\u009b\u0097\u0095Ö\u009f\u0099\u0095\u009dÖ\u009a\u0097\u0081Ö\u008b\u0090\u009d\u0094\u0094Ö²\u0096\u0091º\u008a\u0091\u009c\u009f\u009d".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 248);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u009b\u0094\u0091\u0096\u0091\u008c".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 248);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }

        public static PresenterState valueOf(String str) {
            return (PresenterState) Enum.valueOf(PresenterState.class, str);
        }

        public static PresenterState[] values() {
            return (PresenterState[]) $VALUES.clone();
        }

        public int index() {
            return this.mIndex;
        }

        public abstract void performCallState(Presenter presenter);

        private PresenterState(String str, int i, int i2) {
            this.mIndex = i2;
        }
    }

    private boolean PA() {
        return this.aYz.index() >= PresenterState.CREATE.index();
    }

    private void b(Presenter presenter) {
        Object obj;
        View view;
        int index = this.aYz.index();
        PresenterState presenterState = PresenterState.UNBIND;
        if (index >= presenterState.index() || presenter.aYz.index() >= presenterState.index()) {
            return;
        }
        if (PA() && !presenter.PA() && (view = this.mRootView) != null) {
            presenter.M(view);
        }
        if (!isBound() || !presenter.PA() || presenter.isBound() || (obj = this.aYy) == null) {
            return;
        }
        presenter.o(obj);
    }

    private boolean isBound() {
        return this.aYz == PresenterState.BIND;
    }

    public final void M(View view) {
        try {
            this.aYz = PresenterState.CREATE;
            this.mRootView = view;
            onCreate();
            this.aYz.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final List<Presenter> PB() {
        return this.aYx;
    }

    public final Object PC() {
        return this.aYy;
    }

    public final void a(Presenter presenter) {
        this.aYx.add(presenter);
        if (!PA() || presenter.PA()) {
            return;
        }
        M(this.mRootView);
    }

    public void as() {
    }

    public final void destroy() {
        try {
            if (this.aYz == PresenterState.BIND) {
                nJ();
            }
            this.aYz = PresenterState.DESTROY;
            onDestroy();
            this.aYz.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final <T extends View> T findViewById(int i) {
        return (T) this.mRootView.findViewById(i);
    }

    public final Activity getActivity() {
        return m.getActivityFromContext(getContext());
    }

    public final Context getContext() {
        return this.mRootView.getContext();
    }

    public final View getRootView() {
        return this.mRootView;
    }

    public final void nJ() {
        try {
            this.aYz = PresenterState.UNBIND;
            onUnbind();
            this.aYz.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void o(Object obj) {
        try {
            PresenterState presenterState = this.aYz;
            PresenterState presenterState2 = PresenterState.BIND;
            if (presenterState == presenterState2) {
                nJ();
            }
            this.aYz = presenterState2;
            this.aYy = obj;
            as();
            this.aYz.performCallState(this);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public void onUnbind() {
    }

    public final void a(Presenter presenter, boolean z) {
        this.aYx.add(presenter);
        try {
            b(presenter);
        } catch (Throwable th) {
            d.gatherException(th);
            c.printStackTrace(th);
        }
    }
}
