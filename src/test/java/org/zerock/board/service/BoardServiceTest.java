package org.zerock.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
  
}
