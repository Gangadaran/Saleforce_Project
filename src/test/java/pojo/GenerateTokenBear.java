package pojo;

import lombok.Data;

@Data
public class GenerateTokenBear {
	
	 private String access_token;
	    private String instance_url;
	    private String id;
	    private String token_type;
	    private String issued_at;
	    private String signature;
	

}
