package com.fl.saas.base.inner.interstitial.coustomView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface VideoSoundControlListener {

    public interface SoundControlViewStateChangeListener {
        void changeViewVisible(boolean z);
    }

    void changeSoundEnable(boolean z);

    boolean getSoundEnable();

    void setSoundControlViewStateChangeListener(SoundControlViewStateChangeListener soundControlViewStateChangeListener);
}
