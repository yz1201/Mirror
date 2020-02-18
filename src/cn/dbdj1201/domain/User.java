package cn.dbdj1201.domain;

/**
 * @author tyz1201
 * @datetime 2020-02-18 13:46
 * JAVABEAN
 **/
public class User {
    //用户编号
    private Integer id;
    //用户姓名
    private String username;
    //密码
    private String password;
    //用户性别
    private String sex;
    //年龄
    private Integer age;
    //用户籍贯
    private String address;
    //QQ号
    private String qq_number;
    //邮箱
    private String email;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq_number() {
        return qq_number;
    }

    public void setQq_number(String qq_number) {
        this.qq_number = qq_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", qq_number='" + qq_number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
