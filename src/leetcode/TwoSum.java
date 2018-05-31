package leetcode;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.housejoy.subscription.bean.StatusReasons;
import com.housejoy.subscription.constant.ApplicationConstant;
import com.housejoy.subscription.util.Charset;
import com.housejoy.subscription.util.HttpClientUtil;
import com.housejoy.subscription.util.JsonConverter;

public class TwoSum {

	public static void main(String[] args) {
		
		CloseableHttpResponse response = null;// ApplicationConstant.API_BASE_URL

		String endPointUrl = ApplicationConstant.API_BASE_URL + ApplicationConstant.REASONS_LINK + categoryId + "/"
				+ requestType + "/" + userType;
		
		response = HttpClientUtil.createHttpGet(endPointUrl,null, null);

		List<StatusReasons> list = new ArrayList<StatusReasons>();
		try {
			//String jsonRes = EntityUtils.toString(response.getEntity());
			String jsonRes = EntityUtils.toString(response,Charset.);
			log.info(jsonRes);
			JSONObject jsonObject = new JSONObject(jsonRes);

			boolean isValid = jsonObject.getBoolean("isValid");
			if (isValid) {
				JSONArray jsonArray = jsonObject.getJSONArray("reasonList");
				for (int j = 0; j < jsonArray.length(); j++) {
					StatusReasons jobObj = JsonConverter.toJavaObject(jsonArray.get(j).toString(), StatusReasons.class);
					jobObj.setIsRescheduleMsg(null);
					list.add(jobObj);
				}
			}
			log.info("Job Response::  " + JsonConverter.toPrettyJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;


	}
	public static int getMaxDigits(int digit){
		int i=1;
		int result = 1;
		while(i<=digit){
			result*=10;
			i++;
		}
		return result-1;
	}
	public static String getHoursMinuteToString(String date, String separator){
		String [] str = date.split("\\"+separator);
		String time = str[0]+str[1];
		return time;
	}
	public static String getCurrentTimestamp(String format){
		
		String currentTimestamp = null;
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
	    currentTimestamp = simpleDateFormat.format(new Date());
		
		return currentTimestamp;
	}
	public static String addDaysToDate(String date, String format, Integer days){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		Calendar c = Calendar.getInstance();
		String finalDate = null;
		try {
			c.setTime(simpleDateFormat.parse(date));
			c.add(Calendar.DATE,days);
			finalDate = simpleDateFormat.format(c.getTime());
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return finalDate;
	}

	public static String addHoursToDate(String date, String format, Integer hours){
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		Calendar c = Calendar.getInstance();
		String finalDate = null;
		try {
			c.setTime(simpleDateFormat.parse(date));
			c.add(Calendar.HOUR_OF_DAY,hours);
			finalDate = simpleDateFormat.format(c.getTime());
		
		} catch (ParseException e) {
			System.out.println("can't parse given date " +e);
			e.printStackTrace();
		}
		return finalDate;
	}
	
	public static int[] twoSum(int [] nums, int target){
		int [] indices = new int[2];
		
		Map<Integer, Integer> hashDiff = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			if(hashDiff.containsKey(nums[i])){
				indices[0]=hashDiff.get(nums[i]);
				indices[1]=i;
				break;
			}
			hashDiff.put(target-nums[i], i);
		}
		
		return indices;
	}
}
class Offer{
	private double maxPrice;
	private double minPrice;

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	
}
