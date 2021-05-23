package net.codejava;

public class Register {
    private int id;
    private String username;
    private String email;
    private String password;
    private String confirmpassword;
    
    public int getId(){
        return id;
    }
    
    public void setId(int id) {
    this.id = id;
  }
  public String getfullname(){
    return fullname;
}

public void setfullname(String username) {
this.fullname = fullname;
}
    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
    this.username = username;
  }

    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
  public String getMobilenumber() {
    return mobile;
  }

  public void setMobilenumber(String email) {
    this.mobile = mobile;
  }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
    this.password = password;
  }

    public String getConfirmpassword(){
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
    this.confirmpassword = confirmpassword;
  }
}