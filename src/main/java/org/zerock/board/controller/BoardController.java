package org.zerock.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.board.dto.board.BoardListDTO;
import org.zerock.board.dto.board.BoardDTO;
import org.zerock.board.dto.board.BoardRegisterDTO;
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

  //리스트
  //get
  @GetMapping("list")
  public void getList(
    PageRequestDTO pageRequestDTO, Model model
  ){
    log.info("get | list.....................");
    PageResponseDTO<BoardListDTO> list = boardService.list(pageRequestDTO);

    model.addAttribute("board", list);
  }

  //등록
  //get
  @GetMapping("register")
  public void getRegister(){
    log.info("get | register.....................");
  }

  //post
  @PostMapping("register")
  public String postRegister(BoardRegisterDTO registerDTO){
    //등록 서비스
    boardService.register(registerDTO);

    return "redirect:/board/list";
  }

  //상세
  //get
  @GetMapping("read/{bno}")
  public String getRead(
    @PathVariable("bno") Integer bno, PageRequestDTO pageRequestDTO, Model model
  ){
    log.info("get | read.....................");
    BoardDTO readDTO = boardService.read(bno);

    model.addAttribute("read", readDTO);
    
    return "/board/read";
  }

  //수정
  //get
  @GetMapping("modify/{bno}")
  public String getModify(
    @PathVariable("bno") Integer bno, PageRequestDTO pageRequestDTO, Model model
  ){
    log.info("get | modify.....................");
    BoardDTO readDTO = boardService.read(bno);

    model.addAttribute("modify", readDTO);

    return "/board/modify";
  }
  
  //post
  @PostMapping("modify/{bno}")
  public String postModify(
    @PathVariable("bno") Integer bno, BoardDTO boardDTO, RedirectAttributes rttr
  ){
    boardService.modify(boardDTO, bno);
    rttr.addFlashAttribute("message", bno);
    
    return "redirect:/board/read/" + bno;
  }
  // /수정

  //삭제
  //post
  @PostMapping("delete/{bno}")
  public String postDelete(
    @PathVariable("bno") Integer bno, RedirectAttributes rttr
  ){
    boardService.delete(bno);
    rttr.addFlashAttribute("message", bno);

    return "redirect:/board/list";
  }
  
}
