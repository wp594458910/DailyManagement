package com.daily.util;

public class PageUtils {
	public static int getPage(int pageNumber,int totalPage,int totalNumber,int maxRows){
		totalNumber = totalNumber/maxRows+(totalNumber%maxRows==0?0:1);
		totalPage = totalNumber;
		if(pageNumber>totalPage)pageNumber=totalNumber;
		if(totalPage == 0){
			return 0;
		}else{
			return (pageNumber-1)*maxRows;
		}
	}
	
	public static int getTotalPage(int pageNumber,int totalPage,int totalNumber,int maxRows){
		return totalNumber/maxRows+(totalNumber%maxRows==0?0:1);
	}
}
