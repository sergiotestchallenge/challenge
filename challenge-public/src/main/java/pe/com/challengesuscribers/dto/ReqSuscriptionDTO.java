package pe.com.challengesuscribers.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@ApiModel(value = "ReqSuscriptionDTO", description = "request for suscription")
public class ReqSuscriptionDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull
	@ApiModelProperty(value = "client email", position = 1)
	private String email;

	@ApiModelProperty(value = "client first name", position = 2)
	private String firstName;

	@ApiModelProperty(value = "client gender", position = 3)
	private String gender;

	@NotNull
	@ApiModelProperty(value = "client birthdate. Not null. Format example: 1989-10-25T00:00:00.000Z ", position = 4)
	private Date dateOfBirth;

	@NotNull
	@ApiModelProperty(value = "flag for consent. Not null. ", position = 5)
	Integer flag;

	@NotNull
	@ApiModelProperty(value = "the newsletter Id corresponding to the campaign", position = 6)
	Integer newsLetterId;
}