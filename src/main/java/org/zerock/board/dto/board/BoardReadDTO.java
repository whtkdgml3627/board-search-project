package org.zerock.board.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardReadDTO {
  //변수
  private String title;       //제목
  private String content;     //내용
  private String writer;      //작성자
  private String updateDate;  //수정일자
  private boolean status;     //삭제여부
  
}
