package dal;

import java.util.ArrayList;

public class TESTCSDL {
	public static void main(String[] args) throws Exception {
	ArrayList<String> temp = DAO.getColumnsMetadata();
	for(String s:temp){
		System.out.println(s);
	}
}
}
