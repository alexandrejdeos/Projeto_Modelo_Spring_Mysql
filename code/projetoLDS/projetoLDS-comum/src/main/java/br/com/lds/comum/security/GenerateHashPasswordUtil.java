package br.com.lds.comum.security;

import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

/**
 * @author ajsantos
 * @date 30/05/2017
 */
public class GenerateHashPasswordUtil {

	private static Object salt;

	/**
	 * @info Retornando Hash da String.
	 * @param password
	 * @return password criptografado
	 */
	public static String generateHash(String password) {
		MessageDigestPasswordEncoder digestPasswordEncoder = new MessageDigestPasswordEncoder("MD5");
		String encodePassword = digestPasswordEncoder.encodePassword(password, salt);
		return encodePassword;
	}
	
}

