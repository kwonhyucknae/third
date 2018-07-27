package com.nts.pjt3.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nts.pjt3.dto.Guestbook;
import com.nts.pjt3.service.GuestbookService;


//RequestMapping 같은 매핑으로 여러개를 수행하는데 이 클래스 자체에다가
//requestMapping 을 선언 하면 안쪽에 있는 것들을 다 공통으로 사용 할 수 가 있다.

@RestController
@RequestMapping(path="/guestbooks")
public class GuestbookApiController {
	@Autowired
	GuestbookService guestbookService;
	
	
	//guestbooks URL 로 get 방식 요청이 들어오면서
	//Content-Type이 application/json 로 오면 이 메서드가 실행
	//application/json 요청이기 때문에 
	//DispatcherServlet은 jsonMessageConvert 를 내부적으로 사용해서 해당 Map 객체를 
	//json 으로 변환해서 전송을 하게 된다.
	
	
	
	@GetMapping
	public Map<String, Object> list(@RequestParam(name="start", required=false, defaultValue="0") int start) {
		
		List<Guestbook> list = guestbookService.getGuestbooks(start);
		
		int count = guestbookService.getCount();
		int pageCount = count / GuestbookService.LIMIT;
		if(count % GuestbookService.LIMIT > 0)
			pageCount++;
		
		List<Integer> pageStartList = new ArrayList<>();
		for(int i = 0; i < pageCount; i++) {
			pageStartList.add(i * GuestbookService.LIMIT);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", count);
		map.put("pageStartList", pageStartList);
		
		return map;
	}
	
	// POST 방식은 write 메서드가 호출 될 거다
	// 이것도 마찬가지 json 메서드로 변환돼서 클라이언트한테 간다.
	// 클라이언트한테 응답이 갈 때는 json으로 바뀌어서 간다.
	
	@PostMapping
	public Guestbook write(@RequestBody Guestbook guestbook,
						HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		// id가 입력된 guestbook이 반환된다.
		Guestbook resultGuestbook = guestbookService.addGuestbook(guestbook, clientIp);
		return resultGuestbook;
	}
	
	//얘는 path 정보가 있다.
	//이건은 /guestbooks/id 가 온다 이걸 알 수 있다.
	//이런 id 정보를 PathVariable 이라고 했다. PathVariable 어노테이션으로 값을 받아들인다.
	//해당 메서드가 성공하면 Map 객체를 생성하는데 키 값은 success 값은 true,false 인걸 볼 수 있다.
	
	
	
	@DeleteMapping("/{id}")
	public Map<String, String> delete(@PathVariable(name="id") Long id,
			HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		
		int deleteCount = guestbookService.deleteGuestbook(id, clientIp);
		return Collections.singletonMap("success", deleteCount > 0 ? "true" : "false");
	}
}
