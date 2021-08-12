package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.example.demo.LoginModel;
import com.example.demo.PatientinsertModel;
import com.example.demo.VerificationModel;
import com.example.demo.countrymodel;
import oracle.jdbc.OracleTypes;

@Repository
public class DocAppDao {
	@Autowired
	private JdbcTemplate jdbcTemplete;
	SimpleJdbcCall getAllStatesJdbcCall;
	SimpleJdbcCall getAllStatesJdbcCall1;
	SimpleJdbcCall getAllStatesJdbcCall2;
	SimpleJdbcCall getAllStatesJdbcCall3;
	SimpleJdbcCall getAllStatesJdbcCall4;
	SimpleJdbcCall getAllStatesJdbcCall5;
	SimpleJdbcCall getAllStatesJdbcCall6;
	SimpleJdbcCall getAllStatesJdbcCall7;
	SimpleJdbcCall getAllStatesJdbcCall8;
	SimpleJdbcCall getAllStatesJdbcCall9;
	SimpleJdbcCall getAllStatesJdbcCall10;
	SimpleJdbcCall getAllStatesJdbcCall11;
	SimpleJdbcCall getAllStatesJdbcCall12;

	public DocAppDao(DataSource dataSource) {
		// TODO Auto-generated method stub
		this.getAllStatesJdbcCall = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall1 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall2 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall3 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall4 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall5 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall6 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall7 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall8 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall9 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall10 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall11 = new SimpleJdbcCall(dataSource);
		this.getAllStatesJdbcCall12 = new SimpleJdbcCall(dataSource);

	}

	public ArrayList<ShowLocation> showLocation_root() {
		ArrayList<ShowLocation> showList = new ArrayList<>();
		Map<String, Object> result = getAllStatesJdbcCall.withCatalogName("LOCATION")
				.withProcedureName("SHOW_LOCATION_PARENT")
				.declareParameters(new SqlOutParameter("PLOCDATA", OracleTypes.CURSOR)).execute();

		JSONObject json = new JSONObject(result);
		String jesonString = json.get("PLOCDATA").toString();
		JSONArray jsonArray = new JSONArray(jesonString);

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonData = jsonArray.getJSONObject(i);
			showList.add(new ShowLocation(Integer.valueOf(jsonData.getString("LOC_CODE")),
					jsonData.getString("LOC_DESCR"), jsonData.getString("PD")));
		}
		return showList;
	}

	public int insert_location_parent(InsertLocation insertLoc) {
		if (insertLoc.getStatus() == null) {
			insertLoc.setStatus("0");
		}
		Map<String, Object> result = getAllStatesJdbcCall1.withCatalogName("LOCATION")
				.withProcedureName("INSERT_LOCATION_PARENT")
				.declareParameters(new SqlOutParameter("results", OracleTypes.INTEGER))
				.execute(insertLoc.getLocDescr(), insertLoc.getStatus());

		JSONObject json = new JSONObject(result);
		int val = Integer.valueOf(json.get("OUTPUT").toString());

		return val;
	}

	public ArrayList<ShowLocation> showLocationChild(int locId) {
		ArrayList<ShowLocation> showList = new ArrayList<>();
		Map<String, Object> result = getAllStatesJdbcCall2.withCatalogName("LOCATION")
				.withProcedureName("SHOW_LOCATION")
				.declareParameters(new SqlOutParameter("PLOCDATA", OracleTypes.CURSOR)).execute(locId);

		JSONObject json = new JSONObject(result);
		String jesonString = json.get("PLOCDATA").toString();
		JSONArray jsonArray = new JSONArray(jesonString);

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonData = jsonArray.getJSONObject(i);
			showList.add(new ShowLocation(Integer.valueOf(jsonData.getString("LOC_CODE")),
					jsonData.getString("LOC_DESCR"), jsonData.getString("PD")));
		}
		return showList;
	}

	public int insert_location_Child(InsertChildLocation insertChildLocation) {
		if (insertChildLocation.getStatus() == null) {
			insertChildLocation.setStatus("0");
		}
		Map<String, Object> result = getAllStatesJdbcCall3.withCatalogName("LOCATION")
				.withProcedureName("INSERT_LOCATION")
				.declareParameters(new SqlOutParameter("results", OracleTypes.INTEGER))
				.execute(insertChildLocation.getLocDescr(), insertChildLocation.getStatus(),
						insertChildLocation.getParentLocationId());

		JSONObject json = new JSONObject(result);
		int val = Integer.valueOf(json.get("OUTPUT").toString());

		return val;
	}

	public ArrayList<LocationDescr> showLocation_descr(int locCode) {
		ArrayList<LocationDescr> showList1 = new ArrayList<>();
		Map<String, Object> result = getAllStatesJdbcCall4.withCatalogName("LOCATION")
				.withProcedureName("EDIT_LOCATIONS")
				.declareParameters(new SqlOutParameter("LOCEDIT", OracleTypes.CURSOR)).execute(locCode);

		JSONObject json = new JSONObject(result);
		String jesonString = json.get("LOCEDIT").toString();
		JSONArray jsonArray = new JSONArray(jesonString);

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonData = jsonArray.getJSONObject(i);
			showList1.add(new LocationDescr(jsonData.getString("LOC_DESCR")));
		}

		return showList1;
	}

	public int update_location(UpdateLocation updateLocation, int locCode) {
		if (updateLocation.getStatus() == null) {
			updateLocation.setStatus("0");
		}
		Map<String, Object> result = getAllStatesJdbcCall5.withCatalogName("LOCATION")
				.withProcedureName("UPDATE_LOCATIONS")
				.declareParameters(new SqlOutParameter("results", OracleTypes.INTEGER))
				.execute(updateLocation.getLocDescr(), updateLocation.getStatus(), locCode);

		JSONObject json = new JSONObject(result);
		int val = Integer.valueOf(json.get("OUTPUT").toString());

		return val;
	}

	public int deletelocation(int itemCode) {

		Map<String, Object> result = getAllStatesJdbcCall6.withCatalogName("LOCATION")
				.withProcedureName("DETELE_LOCATIONS")
				.declareParameters(new SqlOutParameter("results", OracleTypes.INTEGER)).execute(itemCode);

		JSONObject json = new JSONObject(result);
		int val = Integer.valueOf(json.get("OUTPUT").toString());

		return val;
	}

	// -------------------------------------------------

	public LoginModel getLogin(String name, String pass) {

		LoginModel user = null;
		Map<String, Object> result = getAllStatesJdbcCall7.withCatalogName("DATA_PKG_DR_APPT")
				.withProcedureName("SELECT_USER_LOGIN")
				.declareParameters(new SqlOutParameter("results_cursor", OracleTypes.CURSOR)).execute(name, pass);

		JSONObject json = new JSONObject(result);
		String fjfhdj = json.get("CUR_DATA").toString();
		JSONArray jsonArray = new JSONArray(fjfhdj);

		System.out.println(jsonArray);

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonData = jsonArray.getJSONObject(i);
			user = new LoginModel(jsonData.getString("USERID"), jsonData.getString("USER_PASS"));

		}

		return user;
	}

	public void registerUser(PatientinsertModel patientinsertModel) {

		System.out.println(patientinsertModel);

		String a = patientinsertModel.getUSERID();
		String b = patientinsertModel.getUSER_PASS();
		String c = patientinsertModel.getEMAILID();
		String d = patientinsertModel.getEMAIL_VERY_CODE();
		int e = patientinsertModel.getUSER_TYPE_ID();
		Map<String, Object> result1 = getAllStatesJdbcCall8.withCatalogName("DATA_PKG_DR_APPT")
				.withProcedureName("ITBS_USER_P_INSERT")
				.declareParameters(new SqlOutParameter("results", OracleTypes.INTEGER)).execute(a, b, c, d, e);
		JSONObject json = new JSONObject(result1);
		String fjfhdj = json.get("OUTPUT").toString();

	}

	public List<countrymodel> drop1() {
		ArrayList<countrymodel> showdetail = new ArrayList<>();
		{

			Map<String, Object> result = getAllStatesJdbcCall9.withCatalogName("DATA_PKG_DR_APPT")
					.withProcedureName("ITBS_COUNTRY_LIST")
					.declareParameters(new SqlOutParameter("CUR_DATA", OracleTypes.CURSOR)).execute();

			JSONObject json = new JSONObject(result);
			String fjfhdj = json.get("CUR_DATA").toString();
			JSONArray jsonArray = new JSONArray(fjfhdj);

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonData = jsonArray.getJSONObject(i);
				showdetail.add(new countrymodel(Integer.valueOf(jsonData.getString("COUNTRY_ID")),
						jsonData.getString("COUNTRY_NAME")));
			}

			return showdetail;
		}

	}

	public int updateverification(VerificationModel VerificationModel) {
		String a = VerificationModel.getEMAIL_ID();
		String b = VerificationModel.getEMAIL_VERY_CODE();

		Map<String, Object> result = getAllStatesJdbcCall10.withCatalogName("DATA_PKG_DR_APPT")
				.withProcedureName("USER_VERIFY1")
				.declareParameters(new SqlOutParameter("results", OracleTypes.INTEGER)).execute(a, b);
		JSONObject json = new JSONObject(result);
		String fjfhdj = json.get("OUTPUT").toString();

		return Integer.valueOf(fjfhdj);
	}

}