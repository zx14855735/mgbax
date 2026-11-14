package MOpbMP;

import android.os.Handler;
import com.google.android.material.button.MaterialButton;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4992AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ARc23Z f4993AlLFFp;

    public /* synthetic */ ADYaiT(ARc23Z aRc23Z, int i) {
        this.f4992AcNBzu = i;
        this.f4993AlLFFp = aRc23Z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4992AcNBzu) {
            case 0:
                ARc23Z aRc23Z = this.f4993AlLFFp;
                MaterialButton materialButton = aRc23Z.f4999B3GDIM;
                if (materialButton != null) {
                    materialButton.setEnabled(false);
                    long currentTimeMillis = aRc23Z.f5012BniPrB - System.currentTimeMillis();
                    long j = currentTimeMillis > 0 ? (currentTimeMillis + 999) / 1000 : 0L;
                    aRc23Z.f4999B3GDIM.setText(j + "秒后重新获取");
                    break;
                }
                break;
            case 1:
                ARc23Z aRc23Z2 = this.f4993AlLFFp;
                long currentTimeMillis2 = aRc23Z2.f5012BniPrB - System.currentTimeMillis();
                if (currentTimeMillis2 <= 0) {
                    aRc23Z2.BpkvW3 = false;
                    aRc23Z2.f5012BniPrB = 0L;
                    aRc23Z2.AzWtSf(new LLYwnm.AMqCpz(6, this));
                    break;
                } else {
                    aRc23Z2.AzWtSf(new LCJm5h.A5SV6n(1, this, (currentTimeMillis2 + 999) / 1000));
                    Handler handler = aRc23Z2.f5011BmvVmW;
                    if (handler != null) {
                        handler.postDelayed(this, 500L);
                        break;
                    }
                }
                break;
            case 2:
                ARc23Z aRc23Z3 = this.f4993AlLFFp;
                MaterialButton materialButton2 = aRc23Z3.f4996AzWtSf;
                if (materialButton2 != null && aRc23Z3.f5005BIYEnU != null && aRc23Z3.f5006BJ7GGh != null && aRc23Z3.f5007BNL6CD != null && aRc23Z3.f5008BPw6Q8 != null && aRc23Z3.f4997B25kr6 != null && aRc23Z3.f4998B2KMhB != null) {
                    materialButton2.setText("登录");
                    aRc23Z3.f5005BIYEnU.setVisibility(0);
                    aRc23Z3.f5006BJ7GGh.setVisibility(8);
                    aRc23Z3.f5007BNL6CD.setVisibility(8);
                    aRc23Z3.f5008BPw6Q8.setVisibility(8);
                    aRc23Z3.f4997B25kr6.setText("注册");
                    aRc23Z3.f4998B2KMhB.setText("忘记密码");
                    break;
                }
                break;
            case 3:
                ARc23Z aRc23Z4 = this.f4993AlLFFp;
                MaterialButton materialButton3 = aRc23Z4.f4996AzWtSf;
                if (materialButton3 != null && aRc23Z4.f5005BIYEnU != null && aRc23Z4.f5006BJ7GGh != null && aRc23Z4.f5007BNL6CD != null && aRc23Z4.f5008BPw6Q8 != null && aRc23Z4.f4997B25kr6 != null && aRc23Z4.f4998B2KMhB != null) {
                    materialButton3.setText("注册");
                    aRc23Z4.f5005BIYEnU.setVisibility(0);
                    aRc23Z4.f5006BJ7GGh.setVisibility(0);
                    aRc23Z4.f5007BNL6CD.setVisibility(0);
                    aRc23Z4.f5008BPw6Q8.setVisibility(0);
                    aRc23Z4.f4997B25kr6.setText("登录");
                    aRc23Z4.f4998B2KMhB.setText("忘记密码");
                    break;
                }
                break;
            default:
                ARc23Z aRc23Z5 = this.f4993AlLFFp;
                MaterialButton materialButton4 = aRc23Z5.f4996AzWtSf;
                if (materialButton4 != null && aRc23Z5.f5005BIYEnU != null && aRc23Z5.f5006BJ7GGh != null && aRc23Z5.f5007BNL6CD != null && aRc23Z5.f5008BPw6Q8 != null && aRc23Z5.f4997B25kr6 != null && aRc23Z5.f4998B2KMhB != null) {
                    materialButton4.setText("重置密码");
                    aRc23Z5.f5005BIYEnU.setVisibility(8);
                    aRc23Z5.f5006BJ7GGh.setVisibility(0);
                    aRc23Z5.f5007BNL6CD.setVisibility(0);
                    aRc23Z5.f5008BPw6Q8.setVisibility(0);
                    aRc23Z5.f4997B25kr6.setText("登录");
                    aRc23Z5.f4998B2KMhB.setText("注册");
                    break;
                }
                break;
        }
    }
}
