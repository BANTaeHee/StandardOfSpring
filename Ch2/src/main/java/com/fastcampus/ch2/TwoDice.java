package com.fastcampus.ch2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// ctrl + shift + o = 자동으로 import를 시킨다
@Controller
public class TwoDice {
	@RequestMapping("/rollDice")
	public void main(HttpServletResponse response) throws IOException {	// 브라우저에 출력하기 위해 HttpServletResponse가 필요
		int idx1 =  (int)(Math.random()*6)+1;
		int idx2 =  (int)(Math.random()*6)+1;
		
		response.setContentType("text/Html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter(); 
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<img src = 'resources/img/dice"+idx1+".jpg'>");
		out.println("<img src = 'resources/img/dice"+idx2+".jpg'>");
		out.println("</body>");
		out.println("</html>");
	} 
}
