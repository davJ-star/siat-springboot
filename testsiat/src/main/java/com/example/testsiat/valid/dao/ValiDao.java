package com.example.testsiat.valid.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testsiat.valid.domain.entity.TodoEntity;

import jakarta.persistence.criteria.CriteriaBuilder.In;


/* 

// 테이블로 만들어줄수도 있고,
// crud로 만들어준다.

-> 그렇기 위해서 entity를 만들고 사용하게 된다.
// entity는 테이블과 매핑되는 클래스이다.
다만, entity는 테이블과 1:1로 매핑되는 것이 아니라, 테이블의 컬럼과 1:1로 매핑되는 것이다.
그리고 DTO처럼 쓰면 안된다.
*/
/*
 * JPA 지원하는 repository 인터페이스
 * - CrudeRepository : CRUD 기능을 지원하는 repository 인터페이스
 * - JpaRepository<T, K> : JPA 기능을 지원하는 repository 인터페이스
 * --> T : Entity Class, K : PK Class TYPE
 * 
 * - PagingAndSortingRepository : 페이징 기능을 지원하는 repository 인터페이스
 * - Repository : Spring Data JPA의 기본 repository 인터페이스
 */

 /*
  * - QueryByExampleExecutor : 예제 쿼리 기능을 지원하는 repository 인터페이스
 * - JpaSpecificationExecutor : JPA 스펙 기능을 지원하는 repository 인터페이스
 * - JpaRepositoryFactory : JPA repository 팩토리 인터페이스
  */

@Repository
public interface ValiDao extends JpaRepository<TodoEntity, Integer> {

    // DB 연결을 위한 DAO 클래스
    // DB 연결을 위한 메소드들 정의
    // DB 연결을 위한 쿼리문 정의
    // DB 연결을 위한 쿼리문 실행 메소드 정의
    // DB 연결을 위한 쿼리문 실행 결과 처리 메소드 정의
    // DB 연결을 위한 쿼리문 실행 결과 반환 메소드 정의
}