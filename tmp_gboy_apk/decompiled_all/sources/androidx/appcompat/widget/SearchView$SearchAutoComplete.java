package androidx.appcompat.widget;

import ADYaiT.D8MqeW;
import AaHO0E.B4ZgIw;
import AaHO0E.G58fqA;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class SearchView$SearchAutoComplete extends B4ZgIw {

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f8172B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public boolean f8173B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public final D8MqeW f8174B3GDIM;

    public SearchView$SearchAutoComplete(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8174B3GDIM = new D8MqeW(3, this);
        this.f8172B25kr6 = getThreshold();
    }

    private int getSearchViewTextMinWidthDp() {
        Configuration configuration = getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
            return 256;
        }
        if (i >= 600) {
            return MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT;
        }
        if (i < 640 || i2 < 480) {
            return 160;
        }
        return MediaPlayer.MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT;
    }

    @Override // android.widget.AutoCompleteTextView
    public final boolean enoughToFilter() {
        return this.f8172B25kr6 <= 0 || super.enoughToFilter();
    }

    @Override // AaHO0E.B4ZgIw, android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (this.f8173B2KMhB) {
            D8MqeW d8MqeW = this.f8174B3GDIM;
            removeCallbacks(d8MqeW);
            post(d8MqeW);
        }
        return onCreateInputConnection;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        throw null;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.startTracking(keyEvent, this);
                }
                return true;
            }
            if (keyEvent.getAction() == 1) {
                KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    throw null;
                }
            }
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            throw null;
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public final void performCompletion() {
    }

    @Override // android.widget.AutoCompleteTextView
    public final void replaceText(CharSequence charSequence) {
    }

    public void setImeVisibility(boolean z) {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        D8MqeW d8MqeW = this.f8174B3GDIM;
        if (!z) {
            this.f8173B2KMhB = false;
            removeCallbacks(d8MqeW);
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        } else {
            if (!inputMethodManager.isActive(this)) {
                this.f8173B2KMhB = true;
                return;
            }
            this.f8173B2KMhB = false;
            removeCallbacks(d8MqeW);
            inputMethodManager.showSoftInput(this, 0);
        }
    }

    public void setSearchView(G58fqA g58fqA) {
    }

    @Override // android.widget.AutoCompleteTextView
    public void setThreshold(int i) {
        super.setThreshold(i);
        this.f8172B25kr6 = i;
    }
}
