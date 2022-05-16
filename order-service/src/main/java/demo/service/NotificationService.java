package demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.entity.Notification;
import demo.proxies.NotificationProxy;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class NotificationService {

	@Autowired
	NotificationProxy notiProxy;

	String defaultResponse = "Something Went Wrong Notification Could not be sent";

	@CircuitBreaker(name = "sendAlert", fallbackMethod = "sendDefaultResponse")
	public String sendCreateNotification(Notification notification) {

		notiProxy.emailOrderCreate(notification);
		return "Success";

	}

	@CircuitBreaker(name = "sendAlert", fallbackMethod = "sendDefaultResponse")
	public String sendCancelNotification(Notification notification) {

		notiProxy.emailOrderCancel(notification);
		return "Success";

	}

	public String sendDefaultResponse(Throwable ex) {

		return defaultResponse;

	}
}
