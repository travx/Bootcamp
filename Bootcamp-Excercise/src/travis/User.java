package travis;

import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;


public class User {

	private String user_id;
	private String address;
	private String city_name;
	private String country_code;
	private String date_of_birth;  //fix datatype
	private String email;
	private String first_name;
	private String gender;
	private String last_name;
	private String middle_name;
	private String phone_number;
	private String state_name;
	private String zip_code;
	
	private Session session;
	
	public User(Session session){
		this.session = session;
	}
	
	public void createFromDB(String user_id){
		PreparedStatement statement = session.prepare("select * from user where user_id = ?");
		ResultSet results = session.execute(statement.bind(user_id));
		//debug
		//System.out.println(results.toString());
		createFromDB(results.one());				
	}	
	
	public void createFromDB(Row row){
		this.setUserID(row.getString("user_id"));
		this.setAddress(row.getString("address"));
		this.setCity(row.getString("city_name"));
		this.setCountry(row.getString("country_code"));
		this.setDOB(row.getString("date_of_birth"));
		this.setEmail(row.getString("email"));
		this.setFirstName(row.getString("first_name"));
		this.setGender(row.getString("gender"));
		this.setLastName(row.getString("last_name"));
		this.setMiddleName(row.getString("middle_name"));
		this.setPhoneNumber(row.getString("phone_number"));
		this.setState(row.getString("state_name"));
		this.setZip(row.getString("zip_code"));
	}
	

	private void setCountry(String country) {
		this.country_code = country;
	}



	public String getUserID(){
		return user_id;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getCity(){
		return city_name;
	}
	
	public String getCountry(){
		return country_code;
	}
	
	public String getDOB(){
		return date_of_birth;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getFirstName(){
		return first_name;
	}
	
	public String getGender(){
		return gender;
	}
	
	public String getLastName(){
		return last_name;
	}
	
	public String getMiddleName(){
		return middle_name;
	}
	
	public String getPhoneNumber(){
		return phone_number;
	}
	
	public String getState(){
		return state_name;
	}
	
	public String getZip(){
		return zip_code;
	}
	
		
	public void setUserID(String set_user_id){
		this.user_id = set_user_id;
	}
	
	public void setAddress(String set_address){
		this.address = set_address;
	}
	
	public void setCity(String set_city_name){
		this.city_name = set_city_name;
	}
	
	public void getCountry(String set_country_code){
		this.country_code = set_country_code;
	}
	
	public void setDOB(String set_date_of_birth){
		this.date_of_birth = set_date_of_birth;
	}
	
	public void setEmail(String set_email){
		this.email = set_email;
	}
	
	public void setFirstName(String set_first_name){
		this.first_name = set_first_name;
	}
	
	public void setGender(String set_gender){
		this.gender = set_gender;
	}
	
	public void setLastName(String set_last_name){
		this.last_name = set_last_name;
	}
	
	public void setMiddleName(String set_middle_name){
		this.middle_name = set_middle_name;
	}
	
	public void setPhoneNumber(String set_phone_number){
		this.phone_number = set_phone_number;
	}
	
	public void setState(String set_state_name){
		this.state_name = set_state_name;
	}
	
	public void setZip(String set_zip_code){
		this.zip_code = set_zip_code;
	}
	

	
}
