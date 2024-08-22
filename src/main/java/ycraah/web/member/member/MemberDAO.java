package ycraah.web.member.member;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
  private PreparedStatement pstmt;
  private Connection con;
  private DataSource dataFactory;

  public MemberDAO() {
    try {
      Context ctx = new InitialContext();
      Context envContext = (Context) ctx.lookup("java:/comp/env");
      dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public List<MemberVO> listMember() {
    List<MemberVO> membersList = new ArrayList<MemberVO>();
    try{
      con = dataFactory.getConnection();
      pstmt = con.prepareStatement("select * from t_member order by joinDate desc");
      ResultSet rs = pstmt.executeQuery();
      while(rs.next()){
        MemberVO member = new MemberVO();
        String id = rs.getString("id");
        String pwd = rs.getString("pwd");
        String name = rs.getString("name");
        String email = rs.getString("email");
        Date joinDate = rs.getDate("joinDate");

        member.setId(id);
        member.setPwd(pwd);
        member.setName(name);
        member.setEmail(email);
        member.setJoinDate(joinDate);

        membersList.add(member);
      }
      rs.close();
      pstmt.close();
      con.close();

    } catch(SQLException e) {
      e.printStackTrace();
    }
    return membersList;
  }
}
