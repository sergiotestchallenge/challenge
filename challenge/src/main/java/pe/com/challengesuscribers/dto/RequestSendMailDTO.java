package pe.com.challengesuscribers.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RequestSendMailDTO implements Serializable {
	private static final long serialVersionUID = 2852010998488770509L;

	private String from;

	private List<String> to;

	private List<String> cc;

	private List<String> bcc;

	private String subject;

	private String message;
}