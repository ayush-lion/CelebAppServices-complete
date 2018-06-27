package com.ctn.celebApp.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

/**
 * @author Aayush
 *
 */

@Component
@Entity(name="feedback")
public class FeedBack {
	
		@Id
		@GeneratedValue
		
		private Integer id;
		
		private String message;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}	
}
