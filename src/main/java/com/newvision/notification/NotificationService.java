package com.newvision.notification;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

	 @Autowired
	    private NotificationRepository notificationRepository;

	    // 모든 알림 가져오기
	    public List<Notification> getAllNotifications() {
	        return notificationRepository.findAll();
	    }

	    // 알림 추가하기
	    public Notification addNotification(Notification notification) {
	        return notificationRepository.save(notification);
	    }

	    // 알림 상세 정보 가져오기
	    public Notification getNotificationById(Long id) {
	        Optional<Notification> optionalNotification = notificationRepository.findById(id);
	        return optionalNotification.orElse(null);
	    }

	    // 알림 수정하기
	    public Notification updateNotification(Long id, Notification notificationDetails) {
	        Optional<Notification> optionalNotification = notificationRepository.findById(id);
	        if (optionalNotification.isPresent()) {
	            Notification notification = optionalNotification.get();
	            notification.setTitle(notificationDetails.getTitle());
	            notification.setContent(notificationDetails.getContent());
	            notification.setName(notificationDetails.getName());
	            return notificationRepository.save(notification);
	        } else {
	            return null;
	        }
	    }

	    // 알림 삭제하기
	    public boolean deleteNotification(Long id) {
	        Optional<Notification> optionalNotification = notificationRepository.findById(id);
	        if (optionalNotification.isPresent()) {
	            notificationRepository.delete(optionalNotification.get());
	            return true;
	        } else {
	            return false;
	        }
	    }
}
