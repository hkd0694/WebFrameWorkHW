package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.College;
import kr.ac.hansung.model.CollegeDivider;
import kr.ac.hansung.model.CollegeSum;
import kr.ac.hansung.model.CollegeYear;
import kr.ac.hansung.service.CollegeService;

@Controller
public class CollegeController {

	@Autowired
	private CollegeService collegeService;
	
	@RequestMapping("/colleges")
	public String showOffers(Model model) {
		List<College> colleges = collegeService.getCurrent();
		model.addAttribute("colleges", colleges);
		return "colleges";
	}
	
	@RequestMapping("/createcollege")
	public String createcollege(Model model) {
		model.addAttribute("colleges", new College());
		return "createcollege";
	}
	
	@RequestMapping("/college1")
	public String showCollege1(Model model) {
		List<CollegeSum> csum = collegeService.getCollegeSum();
		model.addAttribute("cSums", csum);
		return "divisionsum";
	}
	
	@RequestMapping("/divider")
	public String showDivider(Model model) {
		List<CollegeDivider> cdivide = collegeService.getDivider();
		model.addAttribute("cdivide", cdivide);
		return "divide";
	}
	
	@RequestMapping("/cyear")
	public String showYear(Model model) {
		List<CollegeYear> cyear = collegeService.getCollegeYear();
		model.addAttribute("cyear", cyear);
		return "cyear";
	}
	
	@RequestMapping("/incollege")
	public String incollege(Model model) {
		College college = new College();
		college.setC_year(2018);
		college.setC_term(1);
		model.addAttribute("college",college);
		return "incollege";
	}
	
	@RequestMapping("/incollege2")
	public String incollege2(Model model,@Valid College college,BindingResult result) {
		college.setC_year(2018);
		college.setC_term(1);
		if(result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error : errors)
				System.out.println(error.getDefaultMessage());
			return "createcollege";
		}
		collegeService.insert(college);
		return "createcollege";
	}
	
	@RequestMapping("/clink")
	public String showLink(@RequestParam("c_year") int c_year, @RequestParam("c_term") int c_term,Model model) {
		List<College> clink = collegeService.getLink(c_year, c_term);
		model.addAttribute("cLink", clink);
		return "clink";
	}
}