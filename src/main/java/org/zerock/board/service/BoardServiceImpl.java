package org.zerock.board.service;
/*
 * BoardService implements
 * Service 어노테이션
 */

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.board.dto.BoardListDTO;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.dto.PageResponseDTO;
import org.zerock.board.mappers.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

  private final BoardMapper boardMapper;

  @Override
  public PageResponseDTO<BoardListDTO> list(PageRequestDTO pageRequestDTO) {
    List<BoardListDTO> list = boardMapper.list(pageRequestDTO);
    long total = boardMapper.listCount(pageRequestDTO);

    return PageResponseDTO.<BoardListDTO>withAll()
      .list(list)
      .total(total)
      .build();
  }
  
}
