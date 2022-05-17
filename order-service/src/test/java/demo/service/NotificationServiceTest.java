package demo.service;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import demo.OrderServiceApplication;
import demo.entity.Notification;
import demo.proxies.NotificationProxy;

@ExtendWith(MockitoExtension.class)
public class NotificationServiceTest {
	
	@InjectMocks
	NotificationService notificationService;
	
	@Mock
	NotificationProxy notiProxy;
	
	@Test
	public void sendCreateNotificationTest()
	{
		Notification notification = new Notification("praveen@sapient.com", "success");
		Throwable ex = new Throwable();
		String[] args = {"Java"};
		OrderServiceApplication.main(args);
		notificationService.sendDefaultResponse(ex);
		assertNotNull(notificationService.sendCancelNotification(notification));
        assertNotNull(notificationService.sendCreateNotification(notification));
	}

}
