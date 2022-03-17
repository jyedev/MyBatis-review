package com.greedy.section01.xml;

import static com.greedy.common.Template.getSqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.greedy.common.MenuDTO;
import com.greedy.common.SearchCriteria;

public class MenuService {
	
	private DynamicSqlMapper mapper;
	
	public void selectMenuByPrice(int price) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		Map<String, Integer> map = new HashMap<>();
		map.put("price", price);
		
		List<MenuDTO> menuList = mapper.selectMenuByPrice(price);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		sqlSession.close();
		
	}

	public void searchMenu(SearchCriteria searchCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		List<MenuDTO> menuList = mapper.searchMenu(searchCriteria);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		sqlSession.close();
		
	}

	public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		List<MenuDTO> menuList = mapper.searchMenuBySupCategory(searchCriteria);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		sqlSession.close();
		
	}

	public void searchMenuByRandomMenuCode(List<Integer> randomMenuCodeList) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		Map<String, List<Integer>> criteria = new HashMap<>();
		criteria.put("randomMenuCodeList", randomMenuCodeList);
		
		List<MenuDTO> menuList = mapper.searchMenuByRandomMenuCode(criteria);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		sqlSession.close();
	}

	public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		List<MenuDTO> menuList = mapper.searchMenuByCodeOrSearchAll(searchCriteria);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		sqlSession.close();
		
	}

	public void searchMenuByNameOrCategory(Map<String, Object> searchCriteria) {
		
		SqlSession sqlSession = getSqlSession();
		mapper = sqlSession.getMapper(DynamicSqlMapper.class);
		
		List<MenuDTO> menuList = mapper.searchMenuByNameOrCategory(searchCriteria);
		
		if(menuList != null && menuList.size() > 0) {
			for(MenuDTO menu : menuList) {
				System.out.println(menu);
			}
		} else {
			System.out.println("검색 결과가 존재하지 않습니다.");
		}
		
		sqlSession.close();
		
	}

}
