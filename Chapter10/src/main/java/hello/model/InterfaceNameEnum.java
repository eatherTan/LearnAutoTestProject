package hello.model;

public enum InterfaceNameEnum {

    GetUserList("getUserList","获取用户列表"),
    Login("login","登录"),
    GetUserInfo("getUserInfo","获取用户信息"),
    AddUser("addUser","新增用户信息"),
    UpdateUserInfo("updateUserInfo","编辑用户信息");


    private String code;
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    InterfaceNameEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
