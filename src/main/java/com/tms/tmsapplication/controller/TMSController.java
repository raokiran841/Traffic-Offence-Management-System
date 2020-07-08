package com.tms.tmsapplication.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.tms.tmsapplication.entity.*;
import com.tms.tmsapplication.joinedclasses.*;
import com.tms.tmsapplication.service.*;

@Controller
@RequestMapping("tms")
public class TMSController {

	// inject Services
	@Autowired
	private OffenceService offenceService;
	
	@Autowired
	private OffenceDetailService offenceDetailService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private OwnerService ownerService;
	
	@Autowired
	private VehicleDetailService VehicleDetailService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private HttpServletRequest request;

	@GetMapping("")
	public String hello() {
		System.out.println("entered /tms");
		return "redirect:/tms/home";
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		
		OffencePenalty op = new OffencePenalty();
		// Default Offence Types and penalties
		List<OffencePenalty> opList = new ArrayList<OffencePenalty>();
		opList.add(new OffencePenalty("General offences", 100));
		opList.add(new OffencePenalty("Driving vehicles without valid licence",300));
		opList.add(new OffencePenalty("Driving at excessive speed",200));
		opList.add(new OffencePenalty("Driving dangerously",500));
		opList.add(new OffencePenalty("Racing and trials of speed without permission",300));
		opList.add(new OffencePenalty("Talking on mobile phone while driving",200));
		opList.add(new OffencePenalty("Driving uninsured vehicle",300));
		opList.add(new OffencePenalty("Driving when mentally or physically unfit to drive",100));
		
		System.out.println("While Adding==>>"+opList);
		request.getSession().setAttribute("opList",opList);
		
		model.addAttribute("user",new UserEO());
		System.out.println("entered /tms ==>> home.html ");
		return "home";
	}
	
	@GetMapping("/main")
	public String routing(Model model) {
		String user = (String) session.getAttribute("username");
		String role = (String) session.getAttribute("rolename");
		model.addAttribute("username",user);
		model.addAttribute("rolename",role);
		System.out.println("entered /tms ==>> home ==>> validation ==>> /main " + user +" " + role); // <<<<<==================
		List<OffenceEO> offences = offenceService.findAll();
		List<OffenceDetailEO> offenceDetails = offenceDetailService.findAll();
		List<RegistrationEO> registrations = registrationService.findAll();
		List<OwnerEO> owners = ownerService.findAll();
		List<UserEO> users = userService.findAll();
		List<VehicleDetailEO> vehicleDetails = VehicleDetailService.findAll();
		List<RoleEO> roles = roleService.findAll();
		if(role.equals("ADMIN")) {
			
			model.addAttribute("offences",offences);
			model.addAttribute("offenceDetails",offenceDetails);
			model.addAttribute("registrations",registrations);
			model.addAttribute("owners",owners);
			model.addAttribute("vehicleDetails",vehicleDetails);
			model.addAttribute("users",users);
			model.addAttribute("roles",roles);
			
			model.addAttribute("EmptyOffences",new OffenceEO());
			model.addAttribute("EmptyOffenceDetails",new OffenceDetailEO());
			model.addAttribute("EmpltyRegistrations",new RegistrationEO());
			model.addAttribute("EmptyOwners",new OwnerEO());
			model.addAttribute("EmptyVehicleDetails",new VehicleDetailEO());
			model.addAttribute("EmptyUsers",new UserEO());
			model.addAttribute("EmptyRoles",new RoleEO());
			
			return "adminPage";
		} else if(role.equals("POLICE")) {
			String regDet = (String) session.getAttribute("regDet");
			List<FullOffenceDetail> fullOffDetList = (List<FullOffenceDetail>) session.getAttribute("fullOffDetList");
			OwnerRegistrationDetail ownRegDet = (OwnerRegistrationDetail) session.getAttribute("ownRegDet");
			model.addAttribute("fulloffDet",new FullOffenceDetail());
			model.addAttribute("fullOffDetList",fullOffDetList);
			model.addAttribute("regDet",regDet);
			model.addAttribute("ownRegDet",ownRegDet);
			System.out.println("entered /tms ==>> home ==>> validation ==>> /main ==>> policePage "+ user +" " + role);
			return "policePage";
		} else if(role.equals("RTO")) {
			List<OffencePenalty> opList = (List<OffencePenalty>) session.getAttribute("opList");
			OffencePenalty emptyOpObj = new OffencePenalty();
			model.addAttribute("opList",opList);
			model.addAttribute("emptyOpObj",emptyOpObj);
			model.addAttribute("owners",owners);
			model.addAttribute("vehicleDetails",vehicleDetails);
			System.out.println("Before going into page: "+opList);
			return "RTOPage";
		} else {
			List<OffenceDetailEO> offDetEOList = offenceDetailService.findAll();
			model.addAttribute("offDetEOList",offDetEOList);
			return "clerkPage";
		}
	}
	
	@GetMapping("/aboutContact")
	public String aboutPage() {
		return "aboutPage";
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/tms/home";
	}
//########################### POLICE MAPPINGS ###############################################
	@PostMapping("/formValidation")
	public String formValidation(@ModelAttribute("user") UserEO userEO,BindingResult result,
			Model model) {
		session.removeAttribute("regDet");
		session.removeAttribute("ownRegDet");
		session.removeAttribute("fullOffDetList");
		session.removeAttribute("offenceAdded");
		String user = userEO.getUsername();
		String passwd = userEO.getPassword();
		UserEO userDB = userService.findById(user);
		System.out.println(userEO);
		System.out.println(userDB);
		if (userDB != null) {
			if (user.equals(userDB.getUsername()) && passwd.equals(userDB.getPassword())) {
				request.getSession().setAttribute("username",userDB.getUsername());
				request.getSession().setAttribute("rolename",userDB.getRolename());
				System.out.println("entered /tms ==>> home ==>> validation ==>>" +userDB.getUsername()+" " +userDB.getRolename());
				return "redirect:/tms/main";
			} else {
				model.addAttribute("wrongPasswd", "Wrong password");
				return "redirect:/tms/home";
			}
		} else {
			model.addAttribute("wrongUser", "User does not exist");
			return "redirect:/tms/home";
		}
	}
	
	@PostMapping("/vehicleValidation")
	public String vehicleValidation(@RequestParam("veh_no") String vehicleNumber,
			Model model) {
		session.removeAttribute("regDet");
		session.removeAttribute("ownRegDet");
		session.removeAttribute("fullOffDetList");
		session.removeAttribute("offenceAdded");
		System.out.println("==>> vehicleValidation ==>> "+ vehicleNumber);
		RegistrationEO registrationEO = registrationService.findById(vehicleNumber);
		System.out.println("==>> vehicleValidation ==>> "+ vehicleNumber +" \nRegistration: "+registrationEO);
		OwnerRegistrationDetail ownRegDet = new OwnerRegistrationDetail();
		if(registrationEO != null) {
			OwnerEO ownerEO = ownerService.findById(registrationEO.getOwnerId());
			System.out.println("==>> vehicleValidation ==>> "+ vehicleNumber +" \nOwner: "+ownerEO);
			ownRegDet.setAppNo(registrationEO.getAppNo());
			ownRegDet.setVehNo(registrationEO.getVehNo());
			ownRegDet.setVehicleId(registrationEO.getVehicleId());
			ownRegDet.setDate(registrationEO.getDate());
			ownRegDet.setDistributerName(registrationEO.getDistributerName());
			ownRegDet.setOwnerId(ownerEO.getOwnerId());
			ownRegDet.setFname(ownerEO.getFname());
			ownRegDet.setLname(ownerEO.getLname());
			ownRegDet.setDOB(ownerEO.getDOB());
			ownRegDet.setLandlineNo(ownerEO.getLandlineNo());
			ownRegDet.setMobileNo(ownerEO.getMobileNo());
			ownRegDet.setGender(ownerEO.getGender());
			ownRegDet.setTempAddr(ownerEO.getTempAddr());
			ownRegDet.setPermAddr(ownerEO.getPermAddr());
			ownRegDet.setPincode(ownerEO.getPincode());
			ownRegDet.setOccupation(ownerEO.getOccupation());
			ownRegDet.setPancardNo(ownerEO.getPancardNo());
			ownRegDet.setAddrProofName(ownerEO.getAddrProofName());
			request.getSession().setAttribute("ownRegDet",ownRegDet);
		}else {System.out.println("==>> vehicleValidation ==>> "+ vehicleNumber+" Not present");
			request.getSession().setAttribute("regDet","<!> Vehicle not registered <!>");
			}
		System.out.println(">>==>>" + ownRegDet);
		//============== FETCHING OFFENCE DETAILS FOR VEHICLE NO. =====================
		FullOffenceDetail fullOffDet = new FullOffenceDetail();
		List<OffenceDetailEO> offences = offenceDetailService.findOffencesByVehicleNo(vehicleNumber);
		List<FullOffenceDetail> fullOffDetList = (List<FullOffenceDetail>) new ArrayList<FullOffenceDetail>();
		for(OffenceDetailEO offDet: offences) {
			FullOffenceDetail fod = new FullOffenceDetail();
			fod.setVehNo(offDet.getVehNo());
			fod.setImage(offDet.getImage());
			fod.setOffenceStatus(offDet.getOffenceStatus());
			fod.setTime(offDet.getTime());
			fod.setPlace(offDet.getPlace());
			fod.setReportedBy(offDet.getReportedBy());
			fod.setOffenceId(offDet.getOffenceId());
			fod.setOffenceDetId(offDet.getOffenceDetId());
			
			OffenceEO offEO = offenceService.findById(offDet.getOffenceId());
			
			fod.setOffenceId(offEO.getId());
			fod.setOffenceType(offEO.getOffenceType());
			fod.setVehicleType(offEO.getVehicleType());
			fod.setPenalty(offEO.getPenalty());
			
			fullOffDetList.add(fod);
		}
		request.getSession().setAttribute("fullOffDetList",fullOffDetList);
		return "redirect:/tms/main";
	}
	
	@PostMapping("/addOffence")
	public String addOffence(@ModelAttribute("fulloffDet") FullOffenceDetail fullOffenceDetail,
			BindingResult result, Model model) {
		System.out.println("====<FullOffenceDetail> to be added: " + fullOffenceDetail );
		OffenceEO offenceEO = new OffenceEO();
		OffenceDetailEO offenceDetailEO = new OffenceDetailEO();
		offenceEO.setOffenceType(fullOffenceDetail.getOffenceType());
		offenceEO.setPenalty(fullOffenceDetail.getPenalty());
		offenceEO.setVehicleType(fullOffenceDetail.getVehicleType());
		
		int id = offenceService.save(offenceEO);
		System.out.println("######  id from saved offenceEO: "+id);
		offenceDetailEO.setVehNo(fullOffenceDetail.getVehNo());
		offenceDetailEO.setImage(fullOffenceDetail.getImage());
		offenceDetailEO.setOffenceStatus(fullOffenceDetail.getOffenceStatus());
		offenceDetailEO.setOffenceId(id);
		offenceDetailEO.setTime(fullOffenceDetail.getTime());
		offenceDetailEO.setPlace(fullOffenceDetail.getPlace());
		offenceDetailEO.setReportedBy(fullOffenceDetail.getReportedBy());

		offenceDetailService.save(offenceDetailEO);
		System.out.println("##### till now it is done..!!");
		request.getSession().setAttribute("offenceAdded", true);
		session.removeAttribute("regDet");
		session.removeAttribute("ownRegDet");
		session.removeAttribute("fullOffDetList");
		return "redirect:/tms/main";
	}

	// expose /offence for get
	@GetMapping("/offences")
	public String findAll(Model model) {
		List<OffenceEO> offences = offenceService.findAll();
		model.addAttribute("offencesdata", offences);
		System.out.println("inside /offence api " + offences);
		return "allOffences";
	}
	
	@PostMapping("/update")
	public String updateStatus(@RequestParam("offenceDetId") int offenceDetId) {
		System.out.println("Request Param value: " + offenceDetId);
		offenceDetailService.findById(offenceDetId);
		offenceDetailService.updateOffenceStatus(offenceDetId);
		session.removeAttribute("regDet");
		session.removeAttribute("ownRegDet");
		session.removeAttribute("fullOffDetList");
		return "redirect:/tms/main";
	}

	// expose /offence/{offenceId}
//	@GetMapping("/offences/{offenceId}")
//	public OffenceEO getOffence(@PathVariable int offenceId) {
//		OffenceEO offenceEO = offenceService.findById(offenceId);
//		if (offenceEO == null) {
//			throw new RuntimeException("Offence Id not found: " + offenceId);
//		}
//		return offenceEO;
//	}

//########################### end POLICE MAPPINGS ###############################################
//########################### CLERK MAPPINGS ###############################################
	
	@PostMapping("/viewDetail")
	public String viewReport(@RequestParam("offenceDetId") int offenceDetId,Model model) {
		System.out.println("==>> Challan no: "+offenceDetId);
		OffenceDetailEO offDetEO =  offenceDetailService.findById(offenceDetId);
		RegistrationEO regEO = registrationService.findById(offDetEO.getVehNo());
		VehicleDetailEO vehDetEO = VehicleDetailService.findById(regEO.getVehicleId());
		OwnerEO ownEO = ownerService.findById(regEO.getOwnerId());
		model.addAttribute("offDetEO",offDetEO);
		model.addAttribute("regEO",regEO);
		model.addAttribute("vehDetEO",vehDetEO);
		model.addAttribute("ownEO",ownEO);
		List<String> vehicleList = registrationService.vehiclesFromOwner(regEO.getOwnerId());
		model.addAttribute("vehicleList",vehicleList);
		return "clerkDetailView";
	}

//########################### end CLERK MAPPINGS ###############################################
//########################### ADMIN MAPPING ###############################################
	
	@PostMapping("/updUserMaster")
	public String updUserMaster(@ModelAttribute("EmptyUsers") UserEO theUserEO) {
		userService.save(theUserEO);
		return "redirect:/tms/main";
	}
	
	@PostMapping("/updRoleMaster")
	public String updRoleMaster(@ModelAttribute("EmptyRoles") RoleEO theRoleEO) {
		roleService.save(theRoleEO);
		return "redirect:/tms/main";
	}
	
	@PostMapping("/updOwnDetail")
	public String updOwnDetail(@ModelAttribute("EmptyOwners") OwnerEO theOwnerEO) {
		ownerService.save(theOwnerEO);
		return "redirect:/tms/main";
	}
	
	@PostMapping("/updRegDetail")
	public String updRegDetail(@ModelAttribute("EmpltyRegistrations") RegistrationEO theRegistrationEO) {
		registrationService.save(theRegistrationEO);
		return "redirect:/tms/main";
	}
	
	@PostMapping("/updVehDetail")
	public String updVehDetail(@ModelAttribute("EmptyVehicleDetails") VehicleDetailEO theVehicleDetailEO) {
		VehicleDetailService.save(theVehicleDetailEO);
		return "redirect:/tms/main";
	}
	
	@PostMapping("/updOffDetail")
	public String updOffDetail(@ModelAttribute("EmptyOffenceDetails") OffenceDetailEO theOffenceDetailEO) {
		offenceDetailService.save(theOffenceDetailEO);
		return "redirect:/tms/main";
	}
	
	@PostMapping("/updOffence")
	public String updOffence(@ModelAttribute("EmptyOffences") OffenceEO theOffenceEO) {
		offenceService.save(theOffenceEO);
		return "redirect:/tms/main";
	}

	@PostMapping("/addUser")
	public String addUser(@ModelAttribute("EmptyUsers") UserEO theUserEO) {
		theUserEO.setPassword(theUserEO.getUsername());
		userService.save(theUserEO);
		return "redirect:/tms/main";
	}
	
	@PostMapping("/addOffType")
	public String addOffType(@ModelAttribute("emptyOpObj") OffencePenalty emptyOpObj) {
		System.out.println("inside addOffType");
		List<OffencePenalty> opList = (List<OffencePenalty>) session.getAttribute("opList");
		opList.add(emptyOpObj);
		
		request.getSession().setAttribute("opList", opList);
		return "redirect:/tms/main";
	}
	
	@GetMapping("/addVehDetail")
	public String addVehDetailPage(Model model) {
		VehicleDetailEO vehDetEO = new VehicleDetailEO();
		model.addAttribute("vehDetEO",vehDetEO);
		System.out.println("inside addVehDetail");
		return "addVehicleDetail";
	}
	
	@PostMapping("/addVehDetail")
	public String addVehDetail(@ModelAttribute("vehDetEO") VehicleDetailEO vehDetEO) {
		VehicleDetailService.save(vehDetEO);
		return "redirect:/tms/main";
	}
	
	@GetMapping("/addOwnDetail")
	public String addOwnDetailPage(Model model) {
		OwnerEO ownEO = new OwnerEO();
		model.addAttribute("ownEO",ownEO);
		return "addOwnerDetail";
	}
	
	@PostMapping("/addOwnDetail")
	public String addOwnDetail(@ModelAttribute("ownEO") OwnerEO ownEO) {
		ownerService.save(ownEO);
		return "redirect:/tms/main";
	}
	
	
	
	// expose /offence for post
	@PostMapping("/offences")
	public OffenceEO addOffence(@RequestBody OffenceEO theOffenceEO) {
		offenceService.save(theOffenceEO);
		return theOffenceEO;
	}

	

	@PutMapping("/offences")
	public OffenceEO UpdateOffence(@RequestBody OffenceEO theOffenceEO) {
		offenceService.save(theOffenceEO);
		return theOffenceEO;
	}

	@DeleteMapping("/offences/{offenceId}")
	public String deleteOffence(@PathVariable int offenceId) {
		OffenceEO offenceEO = offenceService.findById(offenceId);
		if (offenceEO == null) {
			throw new RuntimeException("Offence Id not found: " + offenceId);
		}
		return "Deleted Offence - " + offenceId;
	}
}
