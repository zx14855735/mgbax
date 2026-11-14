package com.fl.saas.config.oaid.impl;

import com.fl.saas.config.oaid.IGetter;
import com.fl.saas.config.oaid.IOAID;
import com.fl.saas.config.oaid.OAIDException;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
class DefaultImpl implements IOAID {
    @Override // com.fl.saas.config.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (iGetter == null) {
            return;
        }
        iGetter.onOAIDGetError(new OAIDException("Unsupported"));
    }

    @Override // com.fl.saas.config.oaid.IOAID
    public boolean supported() {
        return false;
    }
}
