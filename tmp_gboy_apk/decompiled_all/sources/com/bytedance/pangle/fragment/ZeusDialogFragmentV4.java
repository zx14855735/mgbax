package com.bytedance.pangle.fragment;

import A5SV6n.A2egSU;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.B4ZgIw;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.sdk.openadsdk.api.y;
import java.lang.reflect.InvocationTargetException;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ZeusDialogFragmentV4 extends B4ZgIw {
    Application.ActivityLifecycleCallbacks callbacks = new hf(this);

    public ZeusDialogFragmentV4() {
        xj.xj(getClass());
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        try {
            return ZeusTransformUtils.wrapperContext(super.getContext(), (String) MethodUtils.invokeStaticMethod(getClass(), "_GET_PLUGIN_PKG", new Object[0]));
        } catch (IllegalAccessException e) {
            y.xj(e);
            return super.getContext();
        } catch (NoSuchMethodException e2) {
            y.xj(e2);
            return super.getContext();
        } catch (InvocationTargetException e3) {
            y.xj(e3);
            return super.getContext();
        }
    }

    @Override // androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(this.callbacks);
    }

    @Override // androidx.fragment.app.B4ZgIw
    public Dialog onCreateDialog(Bundle bundle) {
        try {
            return new Dialog(ZeusTransformUtils.wrapperContext(getContext(), (String) MethodUtils.invokeStaticMethod(getClass(), "_GET_PLUGIN_PKG", new Object[0])), getTheme());
        } catch (IllegalAccessException e) {
            y.xj(e);
            return null;
        } catch (NoSuchMethodException e2) {
            y.xj(e2);
            return null;
        } catch (InvocationTargetException e3) {
            y.xj(e3);
            return null;
        }
    }

    @Override // androidx.fragment.app.B4ZgIw, androidx.fragment.app.Fragment
    public void onDetach() {
        Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this.callbacks);
        super.onDetach();
    }
}
