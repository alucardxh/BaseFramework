package com.baseframework;

import java.io.File;

import net.dongliu.apk.parser.ApkFile;

public class Test {

	public static void main(String[] args) throws Exception{
		try (ApkFile apkFile = new ApkFile(new File("C:/Users/Administrator/Desktop/app-debug.apk"))) {
			String  versionCode  = apkFile.getApkMeta().getVersionCode().toString();
			System.out.println(versionCode);
		}
	}

}
