package MOpbMP;

import android.util.Patterns;
import android.view.View;
import com.game.boy.MyApp;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4994AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ARc23Z f4995AlLFFp;

    public /* synthetic */ AMqCpz(ARc23Z aRc23Z, int i) {
        this.f4994AcNBzu = i;
        this.f4995AlLFFp = aRc23Z;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        TextInputEditText textInputEditText;
        ARc23Z aRc23Z = this.f4995AlLFFp;
        int i = 1;
        switch (this.f4994AcNBzu) {
            case 0:
                MaterialButton materialButton = aRc23Z.f4996AzWtSf;
                if (materialButton != null) {
                    CharSequence text = materialButton.getText();
                    if (text != null && "登录".contentEquals(text)) {
                        aRc23Z.AzWtSf(new ADYaiT(aRc23Z, 3));
                        break;
                    } else {
                        aRc23Z.AzWtSf(new ADYaiT(aRc23Z, 2));
                        break;
                    }
                }
                break;
            case 1:
                MaterialButton materialButton2 = aRc23Z.f4996AzWtSf;
                if (materialButton2 != null) {
                    CharSequence text2 = materialButton2.getText();
                    if (text2 != null && "重置密码".contentEquals(text2)) {
                        aRc23Z.AzWtSf(new ADYaiT(aRc23Z, 3));
                        break;
                    } else {
                        aRc23Z.AzWtSf(new ADYaiT(aRc23Z, 4));
                        break;
                    }
                }
                break;
            case 2:
                MaterialButton materialButton3 = aRc23Z.f4996AzWtSf;
                if (materialButton3 != null) {
                    CharSequence text3 = materialButton3.getText();
                    String charSequence = text3 == null ? "" : text3.toString();
                    if (!"登录".equals(charSequence)) {
                        if (!"注册".equals(charSequence)) {
                            if ("重置密码".equals(charSequence) && (textInputEditText = aRc23Z.f5001B7CMnp) != null && aRc23Z.f5002B9tovu != null && aRc23Z.f5004BI9f7h != null && aRc23Z.f5003BChYOn != null && aRc23Z.f4996AzWtSf != null) {
                                String B25kr62 = ARc23Z.B25kr6(textInputEditText);
                                String B25kr63 = ARc23Z.B25kr6(aRc23Z.f5002B9tovu);
                                String B25kr64 = ARc23Z.B25kr6(aRc23Z.f5004BI9f7h);
                                String B25kr65 = ARc23Z.B25kr6(aRc23Z.f5003BChYOn);
                                if (B25kr62.length() >= 6) {
                                    if (!B25kr62.equals(B25kr63)) {
                                        MyApp.A2egSU("密码和确认密码不一致");
                                        break;
                                    } else if (B25kr64 != null && Patterns.EMAIL_ADDRESS.matcher(B25kr64).matches()) {
                                        if (!B25kr65.isEmpty()) {
                                            if (aRc23Z.f5010BV3sI0 != null) {
                                                aRc23Z.f4996AzWtSf.setEnabled(false);
                                                MyApp.A2egSU("重置密码中...");
                                                LlW7FF.ASJ6gh aSJ6gh = aRc23Z.f5010BV3sI0;
                                                A5SV6n a5SV6n = new A5SV6n(aRc23Z, 0);
                                                aSJ6gh.getClass();
                                                String ASJ6gh2 = LlW7FF.ASJ6gh.ASJ6gh("forgot_password_reset", B25kr64);
                                                if (!aSJ6gh.A5SV6n(ASJ6gh2)) {
                                                    aSJ6gh.AZOQYO(a5SV6n, "重置密码请求正在进行中，请稍候", true);
                                                    break;
                                                } else {
                                                    aSJ6gh.ARc23Z(aSJ6gh.ADYaiT(LlW7FF.ASJ6gh.A4TApA("action", "forgot_password_reset", "email", B25kr64, "verification_code", B25kr65, "new_password", B25kr62)), MTKlkd.A2egSU.class, a5SV6n, ASJ6gh2, true);
                                                    break;
                                                }
                                            } else {
                                                MyApp.A2egSU("网络工具未初始化");
                                                break;
                                            }
                                        } else {
                                            MyApp.A2egSU("请输入验证码");
                                            break;
                                        }
                                    } else {
                                        MyApp.A2egSU("请输入有效的邮箱地址");
                                        break;
                                    }
                                } else {
                                    MyApp.A2egSU("密码最小6位数");
                                    break;
                                }
                            }
                        } else {
                            TextInputEditText textInputEditText2 = aRc23Z.f5000B4ZgIw;
                            if (textInputEditText2 != null && aRc23Z.f5001B7CMnp != null && aRc23Z.f5002B9tovu != null && aRc23Z.f5004BI9f7h != null && aRc23Z.f5003BChYOn != null && aRc23Z.f4996AzWtSf != null) {
                                String B25kr66 = ARc23Z.B25kr6(textInputEditText2);
                                String B25kr67 = ARc23Z.B25kr6(aRc23Z.f5001B7CMnp);
                                String B25kr68 = ARc23Z.B25kr6(aRc23Z.f5002B9tovu);
                                String B25kr69 = ARc23Z.B25kr6(aRc23Z.f5004BI9f7h);
                                String B25kr610 = ARc23Z.B25kr6(aRc23Z.f5003BChYOn);
                                if (B25kr66.length() >= 2 && B25kr66.length() <= 10) {
                                    if (B25kr67.length() >= 6) {
                                        if (!B25kr67.equals(B25kr68)) {
                                            MyApp.A2egSU("密码和确认密码不一致");
                                            break;
                                        } else if (B25kr69 != null && Patterns.EMAIL_ADDRESS.matcher(B25kr69).matches()) {
                                            if (!B25kr610.isEmpty()) {
                                                if (aRc23Z.f5010BV3sI0 != null) {
                                                    aRc23Z.f4996AzWtSf.setEnabled(false);
                                                    MyApp.A2egSU("注册中...");
                                                    LlW7FF.ASJ6gh aSJ6gh2 = aRc23Z.f5010BV3sI0;
                                                    A4TApA a4TApA = new A4TApA(aRc23Z, 0);
                                                    aSJ6gh2.getClass();
                                                    String ASJ6gh3 = LlW7FF.ASJ6gh.ASJ6gh("register", B25kr69);
                                                    if (!aSJ6gh2.A5SV6n(ASJ6gh3)) {
                                                        aSJ6gh2.AZOQYO(a4TApA, "注册请求正在进行中，请勿重复操作", true);
                                                        break;
                                                    } else {
                                                        aSJ6gh2.ARc23Z(aSJ6gh2.ADYaiT(LlW7FF.ASJ6gh.A4TApA("action", "register", "username", B25kr66, "email", B25kr69, "password", B25kr67, "verification_code", B25kr610)), MTKlkd.AZkASS.class, a4TApA, ASJ6gh3, true);
                                                        break;
                                                    }
                                                } else {
                                                    MyApp.A2egSU("网络工具未初始化");
                                                    break;
                                                }
                                            } else {
                                                MyApp.A2egSU("请输入验证码");
                                                break;
                                            }
                                        } else {
                                            MyApp.A2egSU("请输入有效的邮箱地址");
                                            break;
                                        }
                                    } else {
                                        MyApp.A2egSU("密码最小6位数");
                                        break;
                                    }
                                } else {
                                    MyApp.A2egSU("用户名必须在2到10之间");
                                    break;
                                }
                            }
                        }
                    } else {
                        TextInputEditText textInputEditText3 = aRc23Z.f5000B4ZgIw;
                        if (textInputEditText3 != null && aRc23Z.f5001B7CMnp != null && aRc23Z.f4996AzWtSf != null) {
                            String B25kr611 = ARc23Z.B25kr6(textInputEditText3);
                            String B25kr612 = ARc23Z.B25kr6(aRc23Z.f5001B7CMnp);
                            if (!B25kr611.isEmpty()) {
                                if (!B25kr612.isEmpty()) {
                                    if (aRc23Z.f5010BV3sI0 != null) {
                                        aRc23Z.f4996AzWtSf.setEnabled(false);
                                        MyApp.A2egSU("登录中...");
                                        LlW7FF.ASJ6gh aSJ6gh3 = aRc23Z.f5010BV3sI0;
                                        A5SV6n a5SV6n2 = new A5SV6n(aRc23Z, i);
                                        aSJ6gh3.getClass();
                                        String ASJ6gh4 = LlW7FF.ASJ6gh.ASJ6gh("login", B25kr611);
                                        if (!aSJ6gh3.A5SV6n(ASJ6gh4)) {
                                            aSJ6gh3.AZOQYO(a5SV6n2, "登录请求正在进行中，请勿重复操作", true);
                                            break;
                                        } else {
                                            aSJ6gh3.ARc23Z(aSJ6gh3.ADYaiT(LlW7FF.ASJ6gh.A4TApA("action", "login", "email_or_username", B25kr611, "password", B25kr612)), MTKlkd.AZkASS.class, a5SV6n2, ASJ6gh4, true);
                                            break;
                                        }
                                    } else {
                                        MyApp.A2egSU("网络工具未初始化");
                                        break;
                                    }
                                } else {
                                    MyApp.A2egSU("密码未输入");
                                    break;
                                }
                            } else {
                                MyApp.A2egSU("用户名未输入");
                                break;
                            }
                        }
                    }
                }
                break;
            default:
                TextInputEditText textInputEditText4 = aRc23Z.f5004BI9f7h;
                if (textInputEditText4 != null) {
                    String B25kr613 = ARc23Z.B25kr6(textInputEditText4);
                    if (B25kr613 != null && Patterns.EMAIL_ADDRESS.matcher(B25kr613).matches()) {
                        if (!aRc23Z.BpkvW3) {
                            aRc23Z.f4999B3GDIM.setEnabled(false);
                            aRc23Z.f4999B3GDIM.setText("发送中...");
                            MaterialButton materialButton4 = aRc23Z.f4996AzWtSf;
                            String str = (materialButton4 == null || materialButton4.getText() == null || !"注册".contentEquals(aRc23Z.f4996AzWtSf.getText())) ? "forgot_password_send_code" : "send_verification_code";
                            LlW7FF.ASJ6gh aSJ6gh4 = aRc23Z.f5010BV3sI0;
                            if (aSJ6gh4 != null) {
                                A4TApA a4TApA2 = new A4TApA(aRc23Z, i);
                                String ASJ6gh5 = LlW7FF.ASJ6gh.ASJ6gh(str, B25kr613);
                                if (!aSJ6gh4.A5SV6n(ASJ6gh5)) {
                                    aSJ6gh4.AZOQYO(a4TApA2, "验证码请求正在进行中，请稍后再试", true);
                                    break;
                                } else {
                                    aSJ6gh4.ARc23Z(aSJ6gh4.ADYaiT(LlW7FF.ASJ6gh.A4TApA("action", str, "email", B25kr613)), MTKlkd.A2egSU.class, a4TApA2, ASJ6gh5, true);
                                    break;
                                }
                            } else {
                                MyApp.A2egSU("网络工具未初始化");
                                aRc23Z.AmA8tU();
                                break;
                            }
                        }
                    } else {
                        MyApp.A2egSU("请输入有效的邮箱地址");
                        break;
                    }
                }
                break;
        }
    }
}
