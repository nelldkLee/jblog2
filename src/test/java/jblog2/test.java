package jblog2;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
		String uri = "/jblog2/nelldk/admin/basic";
		String context = "/jblog2";
		System.out.println(uri.contains("/admin/"));
		System.out.println(uri.split("/")[2]);
	}
}
