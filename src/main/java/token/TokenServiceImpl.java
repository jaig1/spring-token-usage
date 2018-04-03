package token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.*;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@CacheConfig(cacheNames = { "token" })
public class TokenServiceImpl implements TokenService {

	private static Logger log = LoggerFactory.getLogger(Application.class);

	private static String token = null;

	@Cacheable
	@Override
	public String getToken() {
		log.info("From within the Get token method, Getting the token");
		if (token == null) {
			// Put in code to the fetch the new token from the token endpoint, provoiding
			// the clientID and clientScerets
			this.token = "1234567890";
		}
		return this.token;
	}

	@CacheEvict
	@Override
	public void deleteToken() {
		log.info("From within the Delete Token Method, setting the token to Null");
		this.token = "NULL";
		return;
	}

	@CachePut(value = "token")
	@Override
	public String fetchToken() {
		log.info("From within the fetch Token Method, Reaching out to CR System to Fetch the new Token");
		this.token = "9876543210";
		return this.token;
	}

}
