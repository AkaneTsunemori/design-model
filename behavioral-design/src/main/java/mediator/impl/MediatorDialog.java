package mediator.impl;

import mediator.Component;
import mediator.Mediator;

public class MediatorDialog implements Mediator {
    String title;
    boolean loginOrRegister;
    Button ok, cancel;
    TextBox loginUserName, loginPassword;
    TextBox regUserName, regPassword, regEmail;
    CheckBox rememberMe;
    CheckBox loginOrRegisterChkBx;


    @Override
    public void signal(Component sender, String event) {
        if (sender == loginOrRegisterChkBx && event == "check") {
            if (loginOrRegisterChkBx.check()) {
                title = "登录";
                //1. 显示登录表单组件。
                // 2. 隐藏注册表单组件。
            } else {
                title = "注册";
                //1. 显示登录表单组件。
                // 2. 隐藏注册表单组件。
            }
        }
        if (sender == ok && event == "click") {
            if (loginOrRegister) {
                // 尝试找到使用登录信息的用户。
            } else {
                // 1. 使用注册字段中的数据创建用户账号。
                //2. 完成用户登录工作。
            }
        }
    }
}
