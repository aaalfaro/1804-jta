package com.revature.jdbc;

/**
 * Service class for the TiCo DAO
 * @author Jesse
 *
 */

public class TiCoService {
	
	private TiCoService() {}
	
	private static TiCoDAO dao = new TiCoDAOImplementation();
	
	public static boolean generateTimestamp(int id) {
		return dao.generateTimestamp(id);
	}
	
	public static int getBalance(int id) {
		return dao.getBalance(id);
	}
	
	public static int getTotalBalance() {
		return dao.getTotalBalance();
	}
}