package newBoard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BoardDAO {
	Connection conn = DBConnection.getConnection();
	PreparedStatement pstmt;
	ResultSet rs;
	Scanner sc;

	public void insertStory(BoardVO vo) {
		String sql = "insert into board values(serial.nextval,?,?,?,sysdate,null)";

		System.out.println("글을 입력하세요.");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getStroy());
			pstmt.setString(3, vo.getWriter());

			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateStory(BoardVO vo) {

		String sql;

		System.out.println("글수정은 1번, 제목 수정은 2번을 눌러주세요");
		int opti = sc.nextInt();
		if (opti == 1)
			sql = "update board set story = ? where writer = ?";
		else
			sql = "update board set title = ? where writer = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			if (opti == 1) {
				System.out.println("글을 수정하세요.");
				vo.setStroy(sc.next());
				pstmt.setString(1, vo.getStroy());
			} else {
				System.out.println("제목을 수정하세요.");
				vo.setTitle(sc.next());
				pstmt.setString(1, vo.getTitle());
			}
			System.out.println("글쓴이를 입력하세요");
			vo.setWriter(sc.next());
			pstmt.setString(2, vo.getWriter());
			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public void selectStory(BoardVO vo) {
		String sql = "select title, story, writer, wdate from board\r\n" + "where serial = ?";

		System.out.println("글 번호를 선택하세요");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getSerial());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				do {
					vo.setTitle(rs.getString("Title"));
					vo.setStroy(rs.getString("Story"));
					vo.setWriter(rs.getString("Writer"));
					vo.setWdate(rs.getString("wdate"));
					System.out.println(vo.getTitle() + "\t" + vo.getStroy() + "\t" + vo.getWriter()+ "\t" + vo.getWdate());
				} while (rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertReply(BoardVO vo) {
		String sql = "insert into board values(serial.nextval,?,?,?,sysdate,?)";

		System.out.println("댓글을 입력하세요.");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getStroy());
			pstmt.setString(3, vo.getWriter());
			pstmt.setInt(4, vo.getRerial());

			pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
