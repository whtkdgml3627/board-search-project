package org.zerock.board.mappers;

import java.util.List;

import org.zerock.board.dto.BoardListDTO;
import org.zerock.board.dto.PageRequestDTO;

public interface BoardMapper {
  
  //리스트
  List<BoardListDTO> list(PageRequestDTO pageRequestDTO);
  //total
  long listCount(PageRequestDTO pageRequestDTO);

}
