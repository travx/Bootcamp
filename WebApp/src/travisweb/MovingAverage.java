package travisweb;

import com.datastax.driver.core.Row;

public class MovingAverage implements Comparable<MovingAverage>{
	private int order_date_hours;
	private double hourly_total;
	private double moving_average;
	
	public MovingAverage(Row row){
		createFromDB(row);
	}
	
	public int getOrder_date_hours() {
		return order_date_hours;
	}
	public void setOrder_date_hours(int order_date_hours) {
		this.order_date_hours = order_date_hours;
	}
	public double getHourly_total() {
		return hourly_total;
	}
	public void setHourly_total(double hourly_total) {
		this.hourly_total = hourly_total;
	}
	public double getMoving_averge() {
		return moving_average;
	}
	public void setMoving_average(double moving_average) {
		this.moving_average = moving_average;
	}
	
	private void createFromDB(Row row){
		setOrder_date_hours(row.getInt("order_date_hours"));
		setHourly_total(row.getDouble("hourly_total"));
		setMoving_average(row.getDouble("moving_average"));
	}

	public int compareTo(MovingAverage ma) {
		final int LESS=-1;
		final int EQUAL=0;
		final int GREATER=1;
		
		if (this.getOrder_date_hours() < ma.getOrder_date_hours()){
			return LESS;
		}

		if (this.getOrder_date_hours() > ma.getOrder_date_hours()){
			return GREATER;
		}
		
		return EQUAL;
	}

}
