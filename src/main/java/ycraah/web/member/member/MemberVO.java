package ycraah.web.member.member;

import java.sql.Date;

public class MemberVO {
  String id;
  String name;
  String email;
  String pwd;
  Date joinDate;

  public MemberVO() {
    System.out.println("MemberVO 생성자 호출");
  }

  public MemberVO(String id, String name, String email, String pwd) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.pwd = pwd;
  }

  public MemberVO(String id, String name, String email, String pwd, Date joinDate) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.pwd = pwd;
    this.joinDate = joinDate;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public Date getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(Date joinDate) {
    this.joinDate = joinDate;
  }
}
