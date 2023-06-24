package org.zerock.board.dto.paging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 페이지 번호와 페이지 사이즈를 구하는 DTO
 * 어노테이션은 get만 설정
 * 페이지 번호 page
 * 페이지 사이즈 size
 * set 메소드 설정
 * - page (음수 페이지 설정시 1페이지로 고정)
 * - size (음수로 불러오거나 100 이상 설정 시 10으로 고정)
 * limit 에 들어갈 skip 계산
 * - page - 1 * size
 * 다음페이지를 위한 count 구하기
 * - page / 10.0(ceil로 올림처리) * 10*size
 * getLink로 쿼리스트링 처리
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageRequestDTO {

  //변수
  @Builder.Default
  private int page = 1; //페이지번호

  @Builder.Default
  private int size = 10; //사이즈

  private String link;   //page,size합치기

  //페이지 번호
  public void setPage(int page){
    if(page < 0){
      this.page = 1;
    }else{
      this.page = page;
    }
  }

  //사이즈
  public void setSize(int size){
    if(size < 0 || size > 100){
      this.size = 10;
    }else{
      this.size = size;
    }
  }

  //limit에 들어갈 skip 계산
  public int getSkip(){
    return (this.page - 1) * this.size;
  }

  //다음페이지를 위한 count
  public int getCountEnd(){
    int temp = (int)(Math.ceil(this.page/10.0)) * (10 * size);
    return temp + 1;
  }

  //link
  public String getLink(){

    if(link == null){
      //문자열 합치기
      StringBuilder strBuilder = new StringBuilder();

      strBuilder.append("page=" + this.page);
      strBuilder.append("&size=" + this.size);

      //toString으로 String전달
      link = strBuilder.toString();
    }

    return link;
  }
}
