package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.LoginModel;
import com.example.demo.PatientinsertModel;
import com.example.demo.VerificationModel;


@Controller
public class DocAppController {
	@Autowired
	DocAppDao d;
	
	@Autowired
	private JdbcTemplate jdbcTemplete;
	SimpleJdbcCall getAllStatesJdbcCall;
	@Autowired
    private JavaMailSender mailSender;
	@GetMapping("/index")
	public String index() {
	

		return "index";
	}

	ArrayList<String> path = new ArrayList<String>();
	public static String Email_ID = "";

	public DocAppController(DataSource datsource) {
		this.getAllStatesJdbcCall = new SimpleJdbcCall(datsource);
	}

	
	
//	//Sign up Page view
	@GetMapping("/SignUp") 
	public String add_user(Model model) {

		return "SignUp";

	}
	
	
	@GetMapping("/login")
	public String login(Model model) {
		LoginModel login = new LoginModel();
		model.addAttribute("login", login);
	
		return "login";
	}
	
	@PostMapping("/login")
	public String loginUser(Model model, LoginModel user) {
		LoginModel user1 = d.getLogin(user.getUSERID(), user.getUSER_PASS());
		if(user1!=null){
			if (user1.getUSERID().equals(user.getUSERID())&& user1.getUSER_PASS().equals(user.getUSER_PASS()))  {
				return "redirect:/location";
			}else {
				return "redirect:/login";  
			}
		}else {
			return "redirect:/login";
		}
		
	}
	
	@GetMapping("/Registration_type")
	public String Registration_type() {
		

		return "Ragistration_Type";
	}
	
	
	
	
	@GetMapping("/User_Registration")
	public String User_Registration( Model model) {
		PatientinsertModel patientinsertModel=new PatientinsertModel();
		model.addAttribute("patientinsertModel", patientinsertModel);

		return "SignUp";
	}
	@PostMapping("/User_Registration")
	private String registeruser(Model model, PatientinsertModel patientinsertModel) {
		System.out.println("N");
		 byte[] array = new byte[7];

       int randomPIN = (int)(Math.random()*90000)+10000;

    
        String PINString = String.valueOf(randomPIN);
        
        System.out.println(PINString);
        patientinsertModel.setEMAIL_VERY_CODE(PINString);
        
        
        
		
		d.registerUser(patientinsertModel);
		Email_ID = patientinsertModel.getEMAILID();
		
		sendEmail(patientinsertModel.getEMAILID(),PINString);
		
		
		
		return "redirect:/Verification";
	}
	
	
	
	
	
    public void sendEmail(String to, String pin) {
        // use mailSender here...
    	
    	String from = "itbanglatesting100@gmail.com";
//    	String to = "noshinsaiyara39@gmail.com";
    	 
    	SimpleMailMessage message = new SimpleMailMessage();
    	 
    	message.setFrom(from);
    	message.setTo(to);
    	message.setSubject("This is your verification code");
    	message.setText(pin);
    	
    	
    	
    	
    	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    	mailSender.setHost("smtp.gmail.com");
    	mailSender.setPort(587);
    	mailSender.setUsername("itbanglatesting100@gmail.com");
    	mailSender.setPassword("bangladesh123");
    	 
    	Properties properties = new Properties();
    	properties.setProperty("mail.smtp.auth", "true");
    	properties.setProperty("mail.smtp.starttls.enable", "true");
    	properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    	 
    	mailSender.setJavaMailProperties(properties);
    	 
    	mailSender.send(message);
    } 
	
	
	
	@GetMapping("/Verification")
	public String Verification(Model model) {
		
		VerificationModel verificationModel=new VerificationModel();
		model.addAttribute("verificationModel", verificationModel);
		
	
	
	

		return "Verification";
	}
	
	@PostMapping("/Verification")
	public String verificationupdate(Model model, VerificationModel VerificationModel) {
	
		VerificationModel.setEMAIL_ID(Email_ID);
		int Pop= d.updateverification(VerificationModel);
		if (Pop==0) {
			
			System.out.println("ok");
			String mssg = "Code does not match!!";
			model.addAttribute("mssg",mssg);
			VerificationModel VerificationModel1 = new VerificationModel();


			model.addAttribute("VerificationModel1", VerificationModel1);
			

			return "Verification";
		
			
		}
	
		
		
		return "redirect:/login" ;
		
		
	}
	

	// Show Root level Location[Start]
	@GetMapping("/location")
	public String getLevel1(Model model) {
		String nextLevel = "nextLevel";
		model.addAttribute("nextLevel", nextLevel);

		InsertLocation insert_root_loc = new InsertLocation();
		model.addAttribute("insert_root_loc", insert_root_loc);

		ArrayList<ShowLocation> showList = d.showLocation_root();
		model.addAttribute("showList", showList);

		return "location1";
	}

	@PostMapping("/location")
	public String inset_loc_data(Model model, InsertLocation insertLoc) {
		path.clear();
		int result = d.insert_location_parent(insertLoc);

		if (result == 0)
			return "location";
		else
			return "redirect:/location";
	}

	@GetMapping("/location2/{id}")
	public String getChild(@PathVariable("id") int id, Model model) {
		String log = String.valueOf(id);
		path.add(0, log);
		model.addAttribute("path", path);
		model.addAttribute("id", id);

		String nextLevel = "nextLevel";
		model.addAttribute("nextLevel", nextLevel);

		InsertChildLocation insert_child_loc = new InsertChildLocation();
		insert_child_loc.setParentLocationId(id);
		model.addAttribute("insert_child_loc", insert_child_loc);
		insert_child_loc.setParentLocationId(id);

		ArrayList<ShowLocation> showList = d.showLocationChild(id);
		model.addAttribute("showList", showList);

		return "location2";
	}

	@PostMapping("/location2/{id}")
	public String inset_child_data(@PathVariable("id") int id, Model model, InsertChildLocation insert_child_loc) {
		String locpath = String.valueOf(id);
		int result = d.insert_location_Child(insert_child_loc);
		if (result == 0)
			return "/location2/" + locpath;
		else
			return "redirect:/location2/" + locpath;
	}
	
	
	@GetMapping("/location3/{id}")
	public String getChild3(@PathVariable("id") int id, Model model) {
		String log = String.valueOf(id);
		path.add(1, log);
		model.addAttribute("path", path);
		model.addAttribute("id", id);

		String nextLevel = "nextLevel";
		model.addAttribute("nextLevel", nextLevel);

		InsertChildLocation insert_child_loc = new InsertChildLocation();
		insert_child_loc.setParentLocationId(id);
		model.addAttribute("insert_child_loc", insert_child_loc);
		insert_child_loc.setParentLocationId(id);

		ArrayList<ShowLocation> showList = d.showLocationChild(id);
		model.addAttribute("showList", showList);

		return "location3";
	}

	@PostMapping("/location3/{id}")
	public String inset_child_data3(@PathVariable("id") int id, Model model, InsertChildLocation insert_child_loc) {
		String locpath = String.valueOf(id);
		int result = d.insert_location_Child(insert_child_loc);
		if (result == 0)
			return "/location3/" + locpath;
		else
			return "redirect:/location3/" + locpath;
	}
	
	@GetMapping("/location4/{id}")
	public String getChild4(@PathVariable("id") int id, Model model) {
		String log = String.valueOf(id);
		path.add(2, log);
		model.addAttribute("path", path);
		model.addAttribute("id", id);

		String nextLevel = "nextLevel";
		model.addAttribute("nextLevel", nextLevel);

		InsertChildLocation insert_child_loc = new InsertChildLocation();
		insert_child_loc.setParentLocationId(id);
		model.addAttribute("insert_child_loc", insert_child_loc);
		insert_child_loc.setParentLocationId(id);

		ArrayList<ShowLocation> showList = d.showLocationChild(id);
		model.addAttribute("showList", showList);

		return "location4";
	}

	@PostMapping("/location4/{id}")
	public String inset_child_data4(@PathVariable("id") int id, Model model, InsertChildLocation insert_child_loc) {
		String locpath = String.valueOf(id);
		int result = d.insert_location_Child(insert_child_loc);
		if (result == 0)
			return "/location4/" + locpath;
		else
			return "redirect:/location4/" + locpath;
	}
	
	@GetMapping("/location5/{id}")
	public String getChild5(@PathVariable("id") int id, Model model) {
		String log = String.valueOf(id);
		path.add(3, log);
		model.addAttribute("path", path);
		model.addAttribute("id", id);

		String nextLevel = "nextLevel";
		model.addAttribute("nextLevel", nextLevel);

		InsertChildLocation insert_child_loc = new InsertChildLocation();
		insert_child_loc.setParentLocationId(id);
		model.addAttribute("insert_child_loc", insert_child_loc);
		insert_child_loc.setParentLocationId(id);

		ArrayList<ShowLocation> showList = d.showLocationChild(id);
		model.addAttribute("showList", showList);

		return "location5";
	}

	@PostMapping("/location5/{id}")
	public String inset_child_data5(@PathVariable("id") int id, Model model, InsertChildLocation insert_child_loc) {
		String locpath = String.valueOf(id);
		int result = d.insert_location_Child(insert_child_loc);
		if (result == 0)
			return "/location5/" + locpath;
		else
			return "redirect:/location5/" + locpath;
	}
	
	
	@GetMapping("/location6/{id}")
	public String getChild6(@PathVariable("id") int id, Model model) {
		String log = String.valueOf(id);
		path.add(4, log);
		model.addAttribute("path", path);
		model.addAttribute("id", id);

		String nextLevel = "nextLevel";
		model.addAttribute("nextLevel", nextLevel);

		InsertChildLocation insert_child_loc = new InsertChildLocation();
		insert_child_loc.setParentLocationId(id);
		model.addAttribute("insert_child_loc", insert_child_loc);
		insert_child_loc.setParentLocationId(id);

		ArrayList<ShowLocation> showList = d.showLocationChild(id);
		model.addAttribute("showList", showList);

		return "location6";
	}

	@PostMapping("/location6/{id}")
	public String inset_child_data6(@PathVariable("id") int id, Model model, InsertChildLocation insert_child_loc) {
		String locpath = String.valueOf(id);
		int result = d.insert_location_Child(insert_child_loc);
		if (result == 0)
			return "/location6/" + locpath;
		else
			return "redirect:/location6/" + locpath;
	}
	
	
	@GetMapping("/location7/{id}")
	public String getChild7(@PathVariable("id") int id, Model model) {
		String log = String.valueOf(id);
		path.add(4, log);
		model.addAttribute("path", path);
		model.addAttribute("id", id);

		String nextLevel = "nextLevel";
		model.addAttribute("nextLevel", nextLevel);

		InsertChildLocation insert_child_loc = new InsertChildLocation();
		insert_child_loc.setParentLocationId(id);
		model.addAttribute("insert_child_loc", insert_child_loc);
		insert_child_loc.setParentLocationId(id);

		ArrayList<ShowLocation> showList = d.showLocationChild(id);
		model.addAttribute("showList", showList);

		return "location7";
	}

	@PostMapping("/location7/{id}")
	public String inset_child_data7(@PathVariable("id") int id, Model model, InsertChildLocation insert_child_loc) {
		String locpath = String.valueOf(id);
		int result = d.insert_location_Child(insert_child_loc);
		if (result == 0)
			return "/location7/" + locpath;
		else
			return "redirect:/location7/" + locpath;
	}
	
	
	@GetMapping("/locationedit1/{id}")
	public String editLocation1(@PathVariable("id") int id, Model model) {
		String nextLevel = "nextLevel";
		model.addAttribute("nextLevel", nextLevel);

		InsertLocation insert_root_loc = new InsertLocation();
		model.addAttribute("insert_root_loc", insert_root_loc);

		ArrayList<ShowLocation> showList = d.showLocation_root();
		model.addAttribute("showList", showList);
		
		ArrayList<LocationDescr> locationDescr = d.showLocation_descr(id);
		model.addAttribute("locationDescr", locationDescr);
		
		String locationName = locationDescr.get(0).getLocDescr();
		model.addAttribute("locationName", locationName);

		return "locationedit1";
	}
	
	@PostMapping("/locationedit1/{id}")
	public String updateLocations(@PathVariable("id") int id, Model model, UpdateLocation updateLocation) {
		path.clear();
		int result = d.update_location(updateLocation, id);

		if (result == 0)
			return "location";
		else
			return "redirect:/location";
	}
	
	
	@GetMapping("/location1Delete/{id}")
	public String deleteDesignation1(@PathVariable("id") int id, Model model) {
		model.addAttribute("id", id); 

		d.deletelocation(id);
		
		return "redirect:/location";
		
	}
	
	@GetMapping("/locationedit2/{id}")
	public String editLocation2(@PathVariable("id") int id, Model model) {
		String nextLevel = "nextLevel";
		model.addAttribute("nextLevel", nextLevel);
		
		String locpath = path.get(0);
		int p = Integer.valueOf(locpath);
		
		InsertChildLocation insert_child_loc = new InsertChildLocation();
		insert_child_loc.setParentLocationId(id);
		
		model.addAttribute("insert_child_loc", insert_child_loc);
		insert_child_loc.setParentLocationId(id);

		ArrayList<ShowLocation> showList = d.showLocationChild(p);
		model.addAttribute("showList", showList);
		
		ArrayList<LocationDescr> locationDescr = d.showLocation_descr(id);
		model.addAttribute("locationDescr", locationDescr);
		
		String locationName = locationDescr.get(0).getLocDescr();
		model.addAttribute("locationName", locationName);

		return "locationedit2";
	}

	@PostMapping("/locationedit2/{id}")
	public String updateLocation2(@PathVariable("id") int id, Model model, UpdateLocation updateLocation) {
		String nextLevel = "nextLevel";
		model.addAttribute("nextLevel", nextLevel);
		
		String locpath = path.get(0);
		int result = d.update_location(updateLocation, id);
		
		if (result == 0)
			return "/location2/" + locpath;
		else
			return "redirect:/location2/" + locpath;
	}
	
	
	@GetMapping("/location2Delete/{id}")
	public String deleteDesignation2(@PathVariable("id") int id, Model model) {
		model.addAttribute("id", id); 
		d.deletelocation(id);
		
		String locpath = path.get(0);

		return "redirect:/location2/" + locpath;		
	}
	
	
	@GetMapping("/locationedit3/{id}")
	public String editLocation3(@PathVariable("id") int id, Model model) {
		String nextLevel = "nextLevel";
		model.addAttribute("nextLevel", nextLevel);		
		model.addAttribute("path", path);
		
		String locpath = path.get(1);
		int p = Integer.valueOf(locpath);
		
		InsertChildLocation insert_child_loc = new InsertChildLocation();
		insert_child_loc.setParentLocationId(id);
		
		model.addAttribute("insert_child_loc", insert_child_loc);
		insert_child_loc.setParentLocationId(id);

		ArrayList<ShowLocation> showList = d.showLocationChild(p);
		model.addAttribute("showList", showList);
		
		ArrayList<LocationDescr> locationDescr = d.showLocation_descr(id);
		model.addAttribute("locationDescr", locationDescr);
		
		String locationName = locationDescr.get(0).getLocDescr();
		model.addAttribute("locationName", locationName);

		return "locationedit3";
	}

	@PostMapping("/locationedit3/{id}")
	public String updateLocation3(@PathVariable("id") int id, Model model, UpdateLocation updateLocation) {
		String nextLevel = "nextLevel";
		model.addAttribute("nextLevel", nextLevel);
		
		String locpath = path.get(1);
		int result = d.update_location(updateLocation, id);
		
		if (result == 0)
			return "/location3/" + locpath;
		else
			return "redirect:/location3/" + locpath;
	}
	
	

	@GetMapping("/location3Delete/{id}")
	public String deleteDesignation3(@PathVariable("id") int id, Model model) {
		model.addAttribute("id", id); 
		d.deletelocation(id);
		
		String locpath = path.get(1);

		return "redirect:/location3/" + locpath;		
	}
	
	
	
	@GetMapping("/locationedit4/{id}")
	public String editLocation4(@PathVariable("id") int id, Model model) {
		String nextLevel = "nextLevel";
		model.addAttribute("nextLevel", nextLevel);		
		model.addAttribute("path", path);
		
		String locpath = path.get(2);
		int p = Integer.valueOf(locpath);
		
		InsertChildLocation insert_child_loc = new InsertChildLocation();
		insert_child_loc.setParentLocationId(id);
		
		model.addAttribute("insert_child_loc", insert_child_loc);
		insert_child_loc.setParentLocationId(id);

		ArrayList<ShowLocation> showList = d.showLocationChild(p);
		model.addAttribute("showList", showList);
		
		ArrayList<LocationDescr> locationDescr = d.showLocation_descr(id);
		model.addAttribute("locationDescr", locationDescr);
		
		String locationName = locationDescr.get(0).getLocDescr();
		model.addAttribute("locationName", locationName);

		return "locationedit4";
	}

	@PostMapping("/locationedit4/{id}")
	public String updateLocation4(@PathVariable("id") int id, Model model, UpdateLocation updateLocation) {
		String nextLevel = "nextLevel";
		model.addAttribute("nextLevel", nextLevel);
		
		String locpath = path.get(2);
		int result = d.update_location(updateLocation, id);
		
		if (result == 0)
			return "/location4/" + locpath;
		else
			return "redirect:/location4/" + locpath;
	}
	
	
	@GetMapping("/location4Delete/{id}")
	public String deleteDesignation4(@PathVariable("id") int id, Model model) {
		model.addAttribute("id", id); 
		d.deletelocation(id);
		
		String locpath = path.get(2);

		return "redirect:/location4/" + locpath;		
	}
	
	
	@GetMapping("/locationedit5/{id}")
	public String editLocation5(@PathVariable("id") int id, Model model) {
		String nextLevel = "nextLevel";
		model.addAttribute("nextLevel", nextLevel);		
		model.addAttribute("path", path);
		
		String locpath = path.get(3);
		int p = Integer.valueOf(locpath);
		
		InsertChildLocation insert_child_loc = new InsertChildLocation();
		insert_child_loc.setParentLocationId(id);
		
		model.addAttribute("insert_child_loc", insert_child_loc);
		insert_child_loc.setParentLocationId(id);

		ArrayList<ShowLocation> showList = d.showLocationChild(p);
		model.addAttribute("showList", showList);
		
		ArrayList<LocationDescr> locationDescr = d.showLocation_descr(id);
		model.addAttribute("locationDescr", locationDescr);
		
		String locationName = locationDescr.get(0).getLocDescr();
		model.addAttribute("locationName", locationName);

		return "locationedit5";
	}

	@PostMapping("/locationedit5/{id}")
	public String updateLocation5(@PathVariable("id") int id, Model model, UpdateLocation updateLocation) {
		String nextLevel = "nextLevel";
		model.addAttribute("nextLevel", nextLevel);
		model.addAttribute("path", path);
		
		String locpath = path.get(3);
		int result = d.update_location(updateLocation, id);
		
		if (result == 0)
			return "/location5/" + locpath;
		else
			return "redirect:/location5/" + locpath;
	}
	
	@GetMapping("/location5Delete/{id}")
	public String deleteDesignation5(@PathVariable("id") int id, Model model) {
		model.addAttribute("id", id); 
		d.deletelocation(id);
		
		String locpath = path.get(3);

		return "redirect:/location5/" + locpath;		
	}

	
	
	@GetMapping("/locationedit6/{id}")
	public String editLocation6(@PathVariable("id") int id, Model model) {
		String nextLevel = "nextLevel";
		model.addAttribute("nextLevel", nextLevel);		
		model.addAttribute("path", path);
		
		String locpath = path.get(4);
		int p = Integer.valueOf(locpath);
		
		InsertChildLocation insert_child_loc = new InsertChildLocation();
		insert_child_loc.setParentLocationId(id);
		
		model.addAttribute("insert_child_loc", insert_child_loc);
		insert_child_loc.setParentLocationId(id);

		ArrayList<ShowLocation> showList = d.showLocationChild(p);
		model.addAttribute("showList", showList);
		
		ArrayList<LocationDescr> locationDescr = d.showLocation_descr(id);
		model.addAttribute("locationDescr", locationDescr);
		
		String locationName = locationDescr.get(0).getLocDescr();
		model.addAttribute("locationName", locationName);

		return "locationedit6";
	}

	@PostMapping("/locationedit6/{id}")
	public String updateLocation6(@PathVariable("id") int id, Model model, UpdateLocation updateLocation) {
		String nextLevel = "nextLevel";
		model.addAttribute("nextLevel", nextLevel);
		model.addAttribute("path", path);
		
		String locpath = path.get(4);
		int result = d.update_location(updateLocation, id);
		
		if (result == 0)
			return "/location6/" + locpath;
		else
			return "redirect:/location6/" + locpath;
	}
	
	@GetMapping("/location6Delete/{id}")
	public String deleteDesignation6(@PathVariable("id") int id, Model model) {
		model.addAttribute("id", id); 
		d.deletelocation(id);
		
		String locpath = path.get(4);

		return "redirect:/location6/" + locpath;		
	}



}