package com.yedam.java.free.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.java.free.service.FBService;
import com.yedam.java.free.service.FBVO;

@Controller
@RequestMapping("freeBoard")
public class FreeBoardController {
	@Autowired
	FBService fbService;
	
	//등록-폼
	@GetMapping("insert")
	public String insertForm(Model model) {
		model.addAttribute("no", fbService.getBoardNO());
		return "freeBoard/insertForm";
	}
	//등록-DB insert
	@PostMapping("insert")
	public String insertFreeBoard(FBVO fbVO, RedirectAttributes ratt) {
		Map<String, Object> result = fbService.insertBoardInfo(fbVO);
		ratt.addAttribute("msg", result.get("result")+"건이 작성되었어요.");
		return "redirect:list";
	}
	
	//전체조회
	@GetMapping("list")
	public String selectFreeBoardList(Model model) {
		model.addAttribute("boardList", fbService.selectBoardList());
		
		return "freeBoard/boardList";
	}
	//단건조회
	@GetMapping("info")
	public String selectBoardInfo(FBVO fbVO, Model model) {
		model.addAttribute("boardInfo", fbService.selectBoardInfo(fbVO));
		return "freeBoard/boardInfo";
	}
	//수정-폼
	
	@GetMapping("updateForm")
	public String updateForm(FBVO fbVO, Model model) {
		model.addAttribute("boardInfo", fbService.selectBoardInfo(fbVO));
		return "freeBoard/updateForm";
	}
	
	//수정-DB update
	@PostMapping("updateForm")
	public String updateFreeBoard(FBVO fbVO, RedirectAttributes ratt) {
		Map<String, Object> result = fbService.updateBoardInfo(fbVO);
		ratt.addAttribute("msg", result.get("result")+"건이 수정되었어요.");
		return "redirect:list";
	}
	
	//삭제
	@GetMapping("delete")
	public String deleteFreeBoard(FBVO fbVO, RedirectAttributes ratt) {
		Map<String, Object> result = fbService.deleteBoardInfo(fbVO);
		ratt.addFlashAttribute("msg", result.get("result")+"건이 삭제되었어요.");
		return "rediret:list";
	}
	
}
