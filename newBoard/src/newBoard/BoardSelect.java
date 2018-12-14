package newBoard;

import java.util.Scanner;

public class BoardSelect {
	BoardDAO dao = new BoardDAO();
	BoardVO vo = new BoardVO();
	Scanner sc = new Scanner(System.in);
	int n;

	public void menuList() {
		int selNum;
		boolean t = true;
		do {
			System.out.println("1. 글입력             2. 글 수정");
			System.out.println("3. 글 상세 보기");
			System.out.println("4. 댓글 수정");
			System.out.println("5. 종   료");
			System.out.println("========================");
			System.out.println("메    뉴    선    택");
			selNum = sc.nextInt();
			switch (selNum) {
			case 1:
				System.out.print("글 제목: ");
				vo.setTitle(sc.next());
				System.out.print("글 내용: ");
				vo.setStroy(sc.next());
				System.out.print("글쓴이: ");
				vo.setWriter(sc.next());
				dao.insertStory(vo);
				
				System.out.println("글 입력 확인");
				break;
			case 2:
				System.out.print("글 수정입니다.");
				dao.updateStory(vo);
				break;

			case 3:
				System.out.print("글번호를 입력하세요: ");
				vo.setSerial(n = sc.nextInt());
				vo.setRerial(n);
				dao.selectStory(vo);

				System.out.print("댓글을 다시려면 1번을 누르세요.");
				System.out.print("나가시려면 2를 눌러 조의를 표하십시오.");
				int opt = sc.nextInt();
				if (opt == 1) {
					System.out.print("댓글 제목: ");
					vo.setTitle(sc.next());
					System.out.print("댓글 내용: ");
					vo.setStroy(sc.next());
					System.out.print("작성자: ");
					vo.setWriter(sc.next());

				dao.insertReply(vo);
				System.out.println("댓글이 입력되었습니다.");
				} else
					break;
					
				break;

			case 4:
				dao.updateStory(vo);
				break;
				
			case 5:
				
					System.out.print("종료합니다.");
					t=false;
				break;
			default:
				break;

			}
		} while (t);

	}
}
