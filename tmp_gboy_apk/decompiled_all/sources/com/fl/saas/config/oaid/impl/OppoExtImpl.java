package com.fl.saas.config.oaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.fl.saas.com.stdid.IStdID;
import com.fl.saas.config.oaid.IGetter;
import com.fl.saas.config.oaid.OAIDException;
import com.fl.saas.config.oaid.OAIDLog;
import com.fl.saas.config.oaid.impl.OAIDService;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class OppoExtImpl extends OppoImpl {
    private static final String ACTION = "action.com.oplus.stdid.ID_SERVICE";
    private static final String CLASS_NAME = "com.oplus.stdid.IdentifyService";
    private static final String PACKAGE_NAME = "com.coloros.mcs";
    private final Context context;

    public OppoExtImpl(Context context) {
        super(context);
        this.context = context;
    }

    @Override // com.fl.saas.config.oaid.impl.OppoImpl, com.fl.saas.config.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.context == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent(ACTION);
        intent.setComponent(new ComponentName(PACKAGE_NAME, CLASS_NAME));
        OAIDService.bind(this.context, intent, iGetter, new OAIDService.RemoteCaller() { // from class: com.fl.saas.config.oaid.impl.OppoExtImpl.1
            @Override // com.fl.saas.config.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) {
                try {
                    return OppoExtImpl.this.realGetOUID(iBinder);
                } catch (RemoteException e) {
                    throw e;
                } catch (OAIDException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new OAIDException(e3);
                }
            }
        });
    }

    @Override // com.fl.saas.config.oaid.impl.OppoImpl
    public String getSerId(IBinder iBinder, String str, String str2) {
        IStdID asInterface = IStdID.Stub.asInterface(iBinder);
        if (asInterface != null) {
            return asInterface.getSerID(str, str2, "OUID");
        }
        throw new OAIDException("IStdID is null");
    }

    @Override // com.fl.saas.config.oaid.impl.OppoImpl, com.fl.saas.config.oaid.IOAID
    public boolean supported() {
        Context context = this.context;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(PACKAGE_NAME, 0) != null;
        } catch (Exception e) {
            OAIDLog.print(e);
            return false;
        }
    }
}
