package org.zerock.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.board.dto.board.BoardListDTO;
import org.zerock.board.dto.paging.PageRequestDTO;
import org.zerock.board.dto.paging.PageResponseDTO;
import org.zerock.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board/")
public class BoardController {

  private final BoardService boardService;

  //list
  @GetMapping("list")
  public void getList(
    PageRequestDTO pageRequestDTO, Model model
  ){
    log.info("get | list.....................");
    PageResponseDTO<BoardListDTO> list = boardService.list(pageRequestDTO);

    model.addAttribute("board", list);
  }
  
}
