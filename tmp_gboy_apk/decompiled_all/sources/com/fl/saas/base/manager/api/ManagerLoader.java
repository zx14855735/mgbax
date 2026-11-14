package com.fl.saas.base.manager.api;

import android.content.Context;
import com.fl.saas.base.base.AdapterAPI;
import com.fl.saas.common.util.feature.Optional;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface ManagerLoader<S extends AdapterAPI> extends FailedLoader {
    S bindAdapter(S s);

    Optional<Context> getContextOpt();
}
