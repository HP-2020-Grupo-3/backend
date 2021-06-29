package com.hp2020g3.venidemary.utils;


public class Constants {
	// Security
	public static final String ISSUER_TOKEN = "ISSUER";
	public static final String SIGNING_KEY = "KEY_1234";
	public static String HEADER_AUTHORIZATION_KEY = "Authorization";
	public static String TOKEN_BEARER_PREFIX = "Bearer";
	public static String SECRET = "mySecretKey";
	public static String AUTHORITIES_KEY = "CLAIM_TOKEN";
	public static Integer ACCESS_TOKEN_VALIDITY_SECONDS = 28800;

	// Default
	public static Integer DEFAULT_RUBRO_ID = 1;
	public static Integer DEFAULT_ROLE_ID = 3;
	public static Integer DEFAULT_MEDIO_PAGO_ID = 1;
	public static Integer DEFAULT_TIPO_ENTREGA_ID = 1;
	public static Integer DEFAULT_DESCUENTO_ID = 1;

	// Comprobantes
	public static String CONTADOR_COMP_VENTA = "COMPROBANTE_VENTA";
	public static String CONTADOR_COMP_PAGO = "COMPROBANTE_PAGO";
	
}
