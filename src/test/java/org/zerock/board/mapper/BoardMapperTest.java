package org.zerock.board.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.board.dto.board.BoardDTO;
import org.zerock.board.dto.board.BoardRegisterDTO;
import org.zerock.board.dto.paging.PageRequestDTO;
import org.zerock.board.mappers.BoardMapper;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardMapperTest {

  //required false
  @Autowired(required = false)
  private BoardMapper boardMapper;
  
  //리스트 test
  @Test
  public void testList(){
    //PageRequestDTO list = PageRequestDTO.builder().build();
    PageRequestDTO list = PageRequestDTO.builder().type("").keyword("수정").build();

    log.info("-----------------------------------------");
    log.info("-----------------------------------------");
    boardMapper.list(list)
    .forEach(dto -> log.info(dto)); //람다식

    //total
    boardMapper.listCount(list);
  }

  //등록 test
  @Test
  public void testRegister(){
    BoardRegisterDTO dto = BoardRegisterDTO.builder()
    .title("등록 매퍼테스트")
    .content("등록 매퍼 테스트")
    .writer("등록자")
    .build();

    log.info("-----------------------------------------");
    log.info("-----------------------------------------");
    boardMapper.register(dto);
  }

  //상세 test
  @Test
  public void testRead(){

    log.info("-----------------------------------------");
    log.info("-----------------------------------------");
    log.info(boardMapper.read(720893));
  }

  //삭제 test
  @Test
  @Transactional
  public void testDelete(){
    
    log.info("-----------------------------------------");
    log.info("-----------------------------------------");
    log.info(boardMapper.delete(720877));
  }

  //수정 test
  @Test
  public void testModify(){
    
    BoardDTO boardDTO = BoardDTO.builder()
    .title("게시판수정")
    .content("수정정정정")
    .build();

    log.info("-----------------------------------------");
    log.info("-----------------------------------------");
    log.info(boardMapper.modify(boardDTO));
  }

}
