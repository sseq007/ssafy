package com.ssafy.csv;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicWriteCSV {
	private static String readpath = "users.csv";
	private static String writepath = "users_copy.csv";
	private static String encoding = "utf-8";

	public static void main(String[] args) {

		// 출력 스트림 생성
		BufferedWriter bufWriter = null;
		BufferedReader br = null;
		String line = null;
		String cvsSplitBy = ",";
		List<List<String>> allData = new ArrayList<List<String>>();

		try {

			br = new BufferedReader(new InputStreamReader(new FileInputStream(readpath), encoding));
			while ((line = br.readLine()) != null) {

				String[] split = line.split(cvsSplitBy);
				List<String> field = Arrays.asList(split);
				allData.add(field);
			}

			bufWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(writepath), encoding));

			for (List<String> newLine : allData) {
				List<String> list = newLine;
				for (String data : list) {
					bufWriter.write(data);
					bufWriter.write(",");
				}
				// 추가하기
				bufWriter.write("주소");
				// 개행코드추가
				bufWriter.newLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufWriter != null) {
					bufWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
