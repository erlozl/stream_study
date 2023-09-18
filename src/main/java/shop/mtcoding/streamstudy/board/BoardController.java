package shop.mtcoding.streamstudy.board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import shop.mtcoding.streamstudy.user.User;

@RestController
public class BoardController {
    
    @Autowired
    private HttpSession session;

    @GetMapping("/boards")
    public BoardDetailV2DTO boardList() {
        // 강제 더미 로그인
        session.setAttribute("sessionUser", User.builder().id(1).username("ssar").build());

        // board(id,title,content,user(id, username)), isOwner = 화면구성
        // 게시글 id, 게시글 제목, 게시글 내용, 작성자 아이디, 작성자 유저네임
        Board board = getDummy();

        User sessionUser = (User) session.getAttribute("sessionUser");
        
        BoardDetailV2DTO responseDTO = new BoardDetailV2DTO(board, sessionUser.getId());

        return responseDTO;
    }

    private Board getDummy() {
        return Board.builder()
        .id(1)
        .title("제목1")
        .content("내용1")
        .author("cos")
        .user(User.builder().id(2).username("cos").password("1234").build())
        .build();
    }

}
