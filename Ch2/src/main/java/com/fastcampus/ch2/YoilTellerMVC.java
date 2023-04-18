package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 년월일을 입력하면 요일을 알려주는 프로그램
@Controller
public class YoilTellerMVC {	// http://localhost/ch2/getYoilMVC?year=2021&month=10&day=1

//	public static void main(String[] args) {
		@RequestMapping("/getYoilMVC")
//		public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// HttpServletRequest request를 String year, String month, String day로 바꿈(직접 받을 수 있게)
		public ModelAndView main(int year, int month, int day) throws IOException {
			
			ModelAndView mv = new ModelAndView();
			
			// 1. 유효성 검사
//			if(!isValid(year, month, day))
//				return "yoilError";
		
			// 2. 요일 계산
			char yoil = getYoil(year, month, day);
		
			// 3. 계산한 결과를 model에 저장
			mv.addObject("year", year);
			mv.addObject("month", month);
			mv.addObject("day", day);
			mv.addObject("yoil", yoil);
			
			// 4. 결과를 보여줄 view를 지정
			mv.setViewName("yoil");
			
			return mv;
			
//		return "yoil";	// WEB-INF/views/yoil.jsp

	}

	private boolean isValid(int year, int month, int day) {
				// TODO Auto-generated method stub
				return true;
			}
	
	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);	// 날짜를 세팅
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토".charAt(dayOfWeek);
	}

}
