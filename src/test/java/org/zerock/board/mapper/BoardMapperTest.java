package org.zerock.board.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.board.dto.paging.PageRequestDTO;
import org.zerock.board.mappers.BoardMapper;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class BoardMapperTest {

  //required false
  @Autowired(required = false)
  private BoardMapper boardMapper;
  
  //list test
  @Test
  public void testList(){
    PageRequestDTO list = PageRequestDTO.builder().build();

    log.info("-----------------------------------------");
    log.info("-----------------------------------------");
    boardMapper.list(list)
    .forEach(dto -> log.info(dto)); //람다식

    //total
    boardMapper.listCount(list);
  }

}
