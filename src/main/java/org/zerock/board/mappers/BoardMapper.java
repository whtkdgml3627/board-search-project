package org.zerock.board.mappers;

import java.util.List;

import org.zerock.board.dto.board.BoardListDTO;
import org.zerock.board.dto.board.BoardReadDTO;
import org.zerock.board.dto.board.BoardRegisterDTO;
import org.zerock.board.dto.paging.PageRequestDTO;

public interface BoardMapper {
  
  //리스트
  List<BoardListDTO> list(PageRequestDTO pageRequestDTO);
  //total
  long listCount(PageRequestDTO pageRequestDTO);
  // /리스트

  //등록
  int register(BoardRegisterDTO boardRegisterDTO);

  //상세
  BoardReadDTO read(Integer bno);

}
