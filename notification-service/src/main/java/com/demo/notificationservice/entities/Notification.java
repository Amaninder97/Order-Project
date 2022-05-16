package com.demo.notificationservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Notification {

	private String emailId;
	private String notificationMessage;
	

}
