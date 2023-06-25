package org.zerock.board.mappers;

import java.util.List;

import org.zerock.board.dto.board.BoardListDTO;
import org.apache.ibatis.annotations.Param;
import org.zerock.board.dto.board.BoardDTO;
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
  BoardDTO read(Integer bno);

  //삭제
  int delete(Integer bno);

  //수정
  int modify(
    @Param("br") BoardDTO boardDTO,
    @Param("bno") Integer bno
  );

}
