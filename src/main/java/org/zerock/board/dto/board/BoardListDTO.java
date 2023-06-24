package org.zerock.board.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardListDTO {
  //변수
  private Integer bno;    //pk
  private String title;   //제목
  private String writer;  //작성자
  private String dueDate; //등록일
}
