package org.zerock.board.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.dto.PageRequestDTO;
import org.zerock.board.mappers.BoardMapper;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardServiceTest {

  @Autowired(required = false)
  private BoardMapper boardMapper;

  @Test
  public void testList(){
    PageRequestDTO list = PageRequestDTO.builder().build();

    log.info("-----------------------------------------");
    log.info("-----------------------------------------");
    log.info(boardMapper.list(list));
  }
  
}
