package com.yedam.java.emp.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.java.emp.service.EmpService;
import com.yedam.java.emp.service.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	
	@RequestMapping("/allList")
	public String getEmpList(Model model) {
//		List<EmpVO> list = new ArrayList<>();
//		list = empService.selectAllEmp();
//		
		model.addAttribute("allList", empService.selectAllEmp());
		return "emp/empList";
		
	}
	
	@GetMapping("/info")
	public String getEmpInfo(EmpVO empVO, Model model) {
		EmpVO findEmp = empService.selectOneEmp(empVO);
		model.addAttribute("empInfo", findEmp);
		return "emp/empInfo";
	}
	
	@GetMapping("insertForm")
	public String printInsertForm() {
		return "emp/insertForm";
	}
	
	@PostMapping("insert")
	public String empInsert(EmpVO empVO, RedirectAttributes ratt ) {
		int result = empService.insertEmpInvo(empVO);
		
		if(result == 1) {
			ratt.addAttribute("msg", "정상등록 됐다고 아오..");
		}else {
			ratt.addAttribute("msg", "똑바로 안하냐??");
			
		}
	
		return "redirect:allList";
	
	}
	@PostMapping("updateSal")
	public String updateSal(int employeeId, RedirectAttributes ratt ) {
		int result = empService.updateEmpSal(employeeId);
		
		if(result == 1) {
			ratt.addAttribute("msg", "정상등록 됐다고 아오..");
		}else {
			ratt.addAttribute("msg", "똑바로 안하냐??");
			
		}
	
		return "redirect:allList";
	
	}
	
	@GetMapping("delete/{empId}")
	@ResponseBody
	public String empDelete(@PathVariable int empId) {
		int result = empService.deleteEmpInfo(empId);
		String message = null;
		if(result == 1) {
			message = "삭제되었습니다."+ empId;
		}else {
			message ="삭제되지 않았습니다.";
		}
		
		return message;
	}
}
