package com.demo.notificationservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.notificationservice.entities.Notification;

@RestController
@RequestMapping("/notification")
public class NotificationController {

	
	
	@PostMapping("emailOrderCreate")
	public ResponseEntity<String>emailOrderCreate(Notification notification){
		
		return new ResponseEntity<>("Notification for create order sent",HttpStatus.OK);
		
	} 	
	
	@PostMapping("emailOrderCancel")
	public ResponseEntity<String>emailOrderCancel(Notification notification){
		
		return new ResponseEntity<>("Notification for cancel order sent",HttpStatus.OK);
		
	}
}
