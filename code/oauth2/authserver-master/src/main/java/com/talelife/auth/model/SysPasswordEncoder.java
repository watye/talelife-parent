package com.talelife.auth.model;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.talelife.auth.util.EncodeUtil;

public class SysPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		try {
			return EncodeUtil.encoderByMd5(rawPassword.toString());
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		String password = "";
			try {
				password = EncodeUtil.encoderByMd5(rawPassword.toString());
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				e.printStackTrace();
				return false;
			}
		return encodedPassword.equals(password);
	}

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		System.out.println(EncodeUtil.encoderByMd5("1"));
	}
}
