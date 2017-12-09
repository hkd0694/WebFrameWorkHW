package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.College;
import kr.ac.hansung.model.CollegeDivider;
import kr.ac.hansung.model.CollegeSum;
import kr.ac.hansung.model.CollegeYear;

//@Component("offerDAO") //Component 를 주고 id를 주어지면 bean자체를 안불러도 된다!
@Repository
	public class CollegeDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int getRowCount() {
		String sqlStatement = "select  count(*) from college";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}
	
	
	//query and return a single object
	public College getCollege(String name) {
		String sqlStatement = "select * from college where name=?";
		
		return jdbcTemplate.queryForObject(sqlStatement,new Object[]{name},
				new RowMapper<College>(){
					@Override
					public College mapRow(ResultSet rs, int rowNum) throws SQLException {
						College college = new College();
						college.setNum(rs.getInt("num"));
						college.setC_year(rs.getInt("c_year"));
						college.setC_term(rs.getInt("c_term"));
						college.setC_code(rs.getString("c_code"));
						college.setC_subject(rs.getString("c_subject"));
						college.setC_division(rs.getString("c_division"));
						college.setC_credit(rs.getInt("c_credit"));
						return college;
					}
			}
		);
	}
	
	public List<CollegeSum> getCollegeSum() {
		String sqlStatment="select c_year,c_term, sum(c_credit) from college group by c_year,c_term";
		return jdbcTemplate.query(sqlStatment,
				new RowMapper<CollegeSum>() {
				@Override
				public CollegeSum mapRow(ResultSet rs,int rowNum) throws SQLException{
					CollegeSum csum = new CollegeSum();
					csum.setC_year(rs.getInt("c_year"));
					csum.setC_term(rs.getInt("c_term"));
					csum.setC_credit(rs.getInt("sum(c_credit)"));
					return csum;
				}
		});
	}
	
	public List<CollegeYear> getCollegeYear() {
		String sqlStatment="select c_year,c_term,c_code,c_subject,c_division,c_credit from college where c_year='2018';";
		return jdbcTemplate.query(sqlStatment,
				new RowMapper<CollegeYear>() {
				@Override
				public CollegeYear mapRow(ResultSet rs,int rowNum) throws SQLException{
					CollegeYear cyear = new CollegeYear();
					cyear.setC_year(rs.getInt("c_year"));
					cyear.setC_term(rs.getInt("c_term"));
					cyear.setC_code(rs.getString("c_code"));
					cyear.setC_subject(rs.getString("c_subject"));
					cyear.setC_division(rs.getString("c_division"));
					cyear.setC_credit(rs.getInt("c_credit"));
					return cyear;
				}
		});
	}
	
	public List<CollegeDivider> getDivider() {
		String sqlStatment="select c_division,sum(c_credit) from college group by c_division;";
		List<CollegeDivider> list = jdbcTemplate.query(sqlStatment,
				new RowMapper<CollegeDivider>() {
				@Override
				public CollegeDivider mapRow(ResultSet rs,int rowNum) throws SQLException{
					CollegeDivider cdivider = new CollegeDivider();
					cdivider.setC_division(rs.getString("c_division"));
					cdivider.setC_credit(rs.getInt("sum(c_credit)"));
					return cdivider;
				}
		});
		int sum=0;
		for(int i=0;i<list.size();i++) {
			sum+=list.get(i).getC_credit();
		}
		list.add(new CollegeDivider("충점",sum));
		return list;
	}
	
	
	
	public List<College> getLink(int c_year, int c_term) {
	      String sqlStatement = "select * from college WHERE c_year=? AND c_term=?";

	      return jdbcTemplate.query(sqlStatement,new Object[] {c_year, c_term}, new RowMapper<College>() {

	         @Override
	         public College mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	 College college = new College();
	        	 college.setNum(rs.getInt("num"));
					college.setC_year(rs.getInt("c_year"));
					college.setC_term(rs.getInt("c_term"));
					college.setC_code(rs.getString("c_code"));
					college.setC_subject(rs.getString("c_subject"));
					college.setC_division(rs.getString("c_division"));
					college.setC_credit(rs.getInt("c_credit"));
					return college;		
	         }

	      });
	   }
	
	//query and return multiple objects
		public List<College> getColleges() {
			String sqlStatement = "select * from college";
			
			return jdbcTemplate.query(sqlStatement,
					new RowMapper<College>(){
						@Override
						public College mapRow(ResultSet rs, int rowNum) throws SQLException {
							College college = new College();
							college.setNum(rs.getInt("num"));
							college.setC_year(rs.getInt("c_year"));
							college.setC_term(rs.getInt("c_term"));
							college.setC_code(rs.getString("c_code"));
							college.setC_subject(rs.getString("c_subject"));
							college.setC_division(rs.getString("c_division"));
							college.setC_credit(rs.getInt("c_credit"));
							return college;		
						}
				}
			);
		}
		
		public boolean insert(College college) {
			int num = college.getNum();
			int c_year = college.getC_year();
			int c_term = college.getC_term();
			String c_code = college.getC_code();
			String c_subject = college.getC_subject();
			String c_division = college.getC_division();
			int c_credit = college.getC_credit();
			String sqlStatement = "insert into college (num,c_year,c_term,c_code,c_subject,c_division,c_credit) values(?,?,?,?,?,?,?)";
			
			return (jdbcTemplate.update(sqlStatement, new Object[] {num,c_year, c_term, c_code, c_subject, c_division, c_credit}) == 1);		
		}
		
		public boolean update(College college) {
			
			int num = college.getNum();
			int c_year = college.getC_year();
			int c_term = college.getC_term();
			String c_code = college.getC_code();
			String c_subject = college.getC_subject();
			String c_division = college.getC_division();
			int c_credit = college.getC_credit();
			String sqlStatement = "update college set c_year=?, c_term=?, c_code=?, c_subject=?, c_division=?, c_credit=? where num=?";
			
			return (jdbcTemplate.update(sqlStatement, new Object[] {c_year, c_term, c_code,c_subject,c_division,c_credit,num}) == 1);		
		}
		
		public boolean delete(int num) {
			String sqlStatement = "delete from college where num=?";
			return (jdbcTemplate.update(sqlStatement, new Object[] {num}) == 1);
		}
		
}


