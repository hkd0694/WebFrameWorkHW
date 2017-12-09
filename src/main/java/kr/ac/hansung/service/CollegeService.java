package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CollegeDAO;
import kr.ac.hansung.model.College;
import kr.ac.hansung.model.CollegeDivider;
import kr.ac.hansung.model.CollegeSum;
import kr.ac.hansung.model.CollegeYear;

@Service
public class CollegeService {
	
	@Autowired
	private CollegeDAO collegeDao;
	
	public List<College> getCurrent() {
		return collegeDao.getColleges();
	}
	
	public List<College> getLink(int c_year,int c_term) {
		return collegeDao.getLink(c_year, c_term);
	}

	public void insert(College college) {
		collegeDao.insert(college);	
	}
	
	public List<CollegeSum> getCollegeSum(){
		return collegeDao.getCollegeSum();
	}
	
	public List<CollegeYear> getCollegeYear(){
		return collegeDao.getCollegeYear();
	}
	
	public List<CollegeDivider> getDivider(){
		return collegeDao.getDivider();
	}
	
	

}
