package org.zerock.board.service;
/*
 * 서비스 인터페이스 선언
 * 트랜잭션 처리 추가
 * 페이징 처리르 위해 List를 PageResponseDTO
 */

import org.springframework.transaction.annotation.Transactional;
import org.zerock.board.dto.board.BoardListDTO;
import org.zerock.board.dto.board.BoardDTO;
import org.zerock.board.dto.board.BoardRegisterDTO;
import org.zerock.board.dto.paging.PageRequestDTO;
import org.zerock.board.dto.paging.PageResponseDTO;

@Transactional
public interface BoardService {
  
  //리스트
  PageResponseDTO<BoardListDTO> list(PageRequestDTO pageRequestDTO);

  //등록
  void register(BoardRegisterDTO boardRegisterDTO);

  //상세
  BoardDTO read(Integer bno);

  //삭제
  void delete(Integer bno);

  //수정
  void modify(BoardDTO boardDTO, Integer bno);

}
