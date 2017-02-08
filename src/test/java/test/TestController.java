package test;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;


@Controller
public class TestController {
	
	
	
	
	private static Map<String,Object> map = new HashMap<String,Object>();
	
	
	@ResponseBody
	@RequestMapping(value="/recivePost")
	public String recivePost(HttpServletRequest request,Model model,String username,String password,String page){
		/*System.out.println(username+"------"+password);
		System.out.println(request.getQueryString());
		String un = request.getParameter("username");
		String pwd = request.getParameter("password");
		System.out.println(un+pwd);*/
		System.out.println(request.getParameter("username"));
		System.out.println(username);
		System.out.println(page);
		List<Student> list = new ArrayList<Student>();
		int pagee;
		if(page==null){
			pagee=1;
		}else{
			pagee = Integer.valueOf(page);
		}
	
		for (int i= (pagee - 1) * 10 +1; i <= pagee*10; i++) {
			Student s = new Student();
			s.setAge(String.valueOf(i));
			s.setName("dd"+String.valueOf(i));
			s.setSrc("http://"+String.valueOf(i)+".你");
			list.add(s);
		}
		String str = JSON.toJSONString(list);
		System.out.println(str);
		return str;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/location")
	public String location(HttpServletRequest request,Model model,String LAT,String LNG){
		
		
		
		System.out.println("lat"+LAT+",lng"+LNG);
		
		
		return "{lat:0.00,lng:1.11}";
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/getlocation")
	public String getlocation(HttpServletRequest request,Model model,String LAT,String LNG){
		String str = JSON.toJSONString(map);
		return str;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/storyAuthers")
	public String jiuweibaTest(HttpServletRequest request,Model model){
		String str = JSON.toJSONString(map);
		return str;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/storyIndex")
	public String storyIndex(HttpServletRequest request,Model model){
		String str = JSON.toJSONString(map);
		return str;
	}
	
	
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		int pagee = Integer.valueOf("3");
		for (int i= (pagee - 1) * 10 +1; i <= pagee*10; i++) {
			Student s = new Student();
			s.setAge(String.valueOf(i));
			s.setName("dd"+String.valueOf(i));
			s.setSrc("http://"+String.valueOf(i)+".jpeg");
			list.add(s);
		}
		String str = JSON.toJSONString(list);
		System.out.println(str);
	}
}
