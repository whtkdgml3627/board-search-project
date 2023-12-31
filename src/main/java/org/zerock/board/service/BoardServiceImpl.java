package org.zerock.board.service;
/*
 * BoardService implements
 * Service 어노테이션
 */

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.board.dto.board.BoardListDTO;
import org.zerock.board.dto.board.BoardDTO;
import org.zerock.board.dto.board.BoardRegisterDTO;
import org.zerock.board.dto.paging.PageRequestDTO;
import org.zerock.board.dto.paging.PageResponseDTO;
import org.zerock.board.mappers.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

  //의존성 주입
  private final BoardMapper boardMapper;

  //리스트
  @Override
  public PageResponseDTO<BoardListDTO> list(PageRequestDTO pageRequestDTO) {
    //리스트 담아주기
    List<BoardListDTO> list = boardMapper.list(pageRequestDTO);
    //total 리스트 총 개수
    long total = boardMapper.listCount(pageRequestDTO);


    return PageResponseDTO.<BoardListDTO>withAll()
      .list(list)
      .total(total)
      .build();
  }

  //등록
  @Override
  public void register(BoardRegisterDTO boardRegisterDTO) {
    boardMapper.register(boardRegisterDTO);
  }

  //상세
  @Override
  public BoardDTO read(Integer bno) {
    return boardMapper.read(bno);
  }

  //삭제
  @Override
  public void delete(Integer bno) {
    boardMapper.delete(bno);
  }

  //수정
  @Override
  public void modify(BoardDTO boardDTO) {
    boardMapper.modify(boardDTO);
  }

}
