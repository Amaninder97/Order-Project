package demo.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import demo.entity.Notification;


@FeignClient(name="notificationservice", path="notification")
public interface NotificationProxy {

	
	@PostMapping("emailOrderCreate")
	public ResponseEntity<String>emailOrderCreate(Notification notification);
	
	@PostMapping("emailOrderCancel")
	public ResponseEntity<String>emailOrderCancel(Notification notification);
}