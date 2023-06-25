package org.zerock.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.board.dto.board.BoardDTO;
import org.zerock.board.dto.board.BoardRegisterDTO;
import org.zerock.board.dto.paging.PageRequestDTO;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardServiceTest {

  //의존성 주입
  @Autowired(required = false)
  private BoardService boardService;

  //리스트 test
  @Test
  public void testList(){
    PageRequestDTO list = PageRequestDTO.builder().build();

    log.info("-----------------------------------------");
    log.info("-----------------------------------------");
    log.info(boardService.list(list));
  }

  //등록 test
  @Test
  public void testRegister(){
    BoardRegisterDTO dto = BoardRegisterDTO.builder()
    .title("서비스 테스트")
    .content("서비스 테스트")
    .writer("서비스 작성자")
    .build();
    
    log.info("-----------------------------------------");
    log.info("-----------------------------------------");
    boardService.register(dto);
  }

  //상세 test
  @Test
  public void testRead(){
    
    log.info("-----------------------------------------");
    log.info("-----------------------------------------");
    log.info(boardService.read(720893));
  }

  //삭제 test
  @Test
  @Rollback(true)
  @Transactional
  public void testDelete(){
    
    log.info("-----------------------------------------");
    log.info("-----------------------------------------");
    boardService.delete(720893);
  }

  //수정 test
  @Test
  public void testModify(){
    BoardDTO boardDTO = BoardDTO.builder()
    .title("서비스스스스스스")
    .content("test")
    .build();

    log.info("-----------------------------------------");
    log.info("-----------------------------------------");
    boardService.modify(boardDTO, 720892);
  }
  
}
