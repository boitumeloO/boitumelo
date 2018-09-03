package com.acme.test01.boitumeloOliphant.boitumelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestApplication {

	public TestApplication() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			TestApplication test = new TestApplication();
			test.testWithdraw(14,50);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void testWithdraw(int acount, int amount) throws Exception {

        URL url = new URL(String.format("http://localhost:8080/withdraw/%s/%s",acount, amount));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
//        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
        	 System.out.println(conn.getResponseMessage());
            throw new RuntimeException("Failed : HTTP Error code : "
                    + conn.getResponseCode());
           
        }
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String output;
        while ((output = br.readLine()) != null) {
            System.out.println(output);
            
        }
        conn.disconnect();

	}
}
