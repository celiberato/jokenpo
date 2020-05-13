package br.com.celiberato.jokenpo.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StringUtils extends org.apache.commons.lang3.StringUtils {

	public static String removeNonDigits(String str) {
		return str != null ? str.replaceAll("\\D", "") : str;
	}

	public static String toCamelCase(String str) {
		String lowerCase = str.toLowerCase();
		String primeiraLetra = lowerCase.substring(0, 1).toUpperCase();
		String proximasLetras = lowerCase.substring(1, lowerCase.length());

		return primeiraLetra + proximasLetras;
	}

	public static boolean allNotBlanks(String... strings) {
		for (String string : strings) {
			if (StringUtils.isBlank(string)) {
				return false;
			}
		}

		return true;
	}

}
