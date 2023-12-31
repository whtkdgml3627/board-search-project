package org.zerock.board.dto.paging;
/*
 * page 반환해주는 DTO
 * List 형식과 total 선언 필요
 * Builder로 반환해주기
 */

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
//제네릭타입으로 클래스 선언
public class PageResponseDTO<E> {

  //변수
  private List<E> list; //리스트 출력해줄 List
  private long total;   //PageRequestDTO에서 getCountEnd를 담을 변수

  @Builder(builderMethodName = "withAll")
  public PageResponseDTO(List<E> list, long total){
    this.list = list;
    this.total = total;
  }
  
}
