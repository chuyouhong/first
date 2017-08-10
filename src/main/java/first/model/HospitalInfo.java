package first.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HospitalInfo implements Serializable {
	protected String provicne_name;
	protected String city_name;
	protected String district_name;
	protected String town_name;
	protected String name;
	protected String url;
	public static final List<String> CASE_INSENSITIVE_ORDER = new ArrayList<String>();

	public String getProvicne_name() {
		return provicne_name;
	}

	public void setProvicne_name(String provicne_name) {
		this.provicne_name = provicne_name;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getDistrict_name() {
		return district_name;
	}

	public void setDistrict_name(String district_name) {
		this.district_name = district_name;
	}

	public String getTown_name() {
		return town_name;
	}

	public void setTown_name(String town_name) {
		this.town_name = town_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void show(){	
		String all="name:"+getName()+";url:"+getUrl();
		System.out.println(all);
	}
}
