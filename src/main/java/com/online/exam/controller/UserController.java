package com.online.exam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.online.exam.dto.UserResponse;
import com.online.exam.entity.UserDetails;
import com.online.exam.exception.AuthorizedUserRoleNotFoundException;
import com.online.exam.exception.NotLoggedInException;
import com.online.exam.service.UserService;
import com.online.exam.util.JwtTokenUtil;



@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController 
{
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/register")
	public String registeruser(HttpServletRequest request, @RequestBody UserDetails requestData)
			throws AuthorizedUserRoleNotFoundException {
		boolean newuser = true;
			String role = (String) request.getSession().getAttribute("role");
			System.out.println("Loggin User Role: "+role);
			if (requestData.getUserRole().equalsIgnoreCase("candidate")) {
				if (role==null) {
					throw new NotLoggedInException("you are not logged in ");
				} else {
					System.out.println("user logged in" + role);
					if (role.equals("admin")) {
						System.out.println("user logged in as admin");
						UserDetails user = new UserDetails(requestData.getUserName(), requestData.getPassword(),requestData.getUserRole());
						newuser = uService.add(user);
					} else {
						throw new AuthorizedUserRoleNotFoundException("only admin are authorized to add product master, kindly contact your admin");
					}
					
				}
			} 
			else {
				UserDetails user = new UserDetails(requestData.getUserName(), requestData.getPassword(),requestData.getUserRole());
				newuser = uService.add(user);
			}
		if (newuser) {
			return "user added successfully";
		}
		return "user not added successfully";
		}
//		@ResponseStatus(HttpStatus.ACCEPTED)
		@GetMapping("/login")
		public UserResponse login(@RequestParam String user,@RequestParam String password, HttpServletRequest request) {
			HttpSession session = request.getSession();
			System.out.println(session);
			UserDetails userDb = uService.login(new UserDetails(user, password));
			System.out.println(userDb.toString());
	       // session.setAttribute("userid", userDb.getUserId());
			session.setAttribute("username",userDb.getUserName());
			session.setAttribute("role", userDb.getUserRole());
			session.setAttribute("password", userDb.getPassword());
			String token =jwtTokenUtil.generateToken(String.valueOf(userDb.getUserId()),userDb.getUserName(),userDb.getUserRole());
			System.out.println(token.toString());
			UserResponse response= new UserResponse();
			response.setToken(token);
			response.setUserId(userDb.getUserId());
			response.setUserName(userDb.getUserName());
			response.setUserRole(userDb.getUserRole());
			ResponseEntity<UserResponse> resEntity = new ResponseEntity<UserResponse>(response,HttpStatus.OK);
	
			return response;
		}

		@ResponseStatus(HttpStatus.ACCEPTED)
		@PostMapping("/logout")
		public String logout(@RequestBody UserDetails userDetails, HttpServletRequest request) {
			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("username");
			if (userName == null) {
				throw new NotLoggedInException("You have not logged in");
			}
			else {
				if(userName.equals(userDetails.getUserName())) {
					session.invalidate();
				}	
			}
//			Enumeration<String> attrNames = session.getAttributeNames();
//			while (attrNames.hasMoreElements()) {
//				String name = (String) attrNames.nextElement();
//				System.out.println(name);
//				String uId = (String) session.getAttribute(name);
//				if (uId.equals(userDetails.getUserId())) {
//					System.out.println("invalidating session..." + uId);
//					session.invalidate();
//				}
//			}
			
			return "You have successfully logged out " +userDetails.getUserId();
		}
	}


	

