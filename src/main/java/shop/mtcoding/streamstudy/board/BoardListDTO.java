package shop.mtcoding.streamstudy.board;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 화면마다 DTO가 필요함
@ToString
@Getter
@Setter
public class BoardListDTO {
    private Integer id;
    private String title;
    private String author;

    public BoardListDTO(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.author = board.getAuthor();
    }
}
