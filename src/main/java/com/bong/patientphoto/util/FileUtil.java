package com.bong.patientphoto.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {
	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	public void copyFileIntoUpload(File file) {
		String path = "/opt/bitnami/apache-tomcat/webapps/bong/upload";
	    try {
	        if (!isFolderExists(path)) {
	            new File(path).mkdir();
	        }
	        FileUtils.copyFile(file, new File(path +  File.separator + file.getName()));
	    } catch (IOException ex) {
//	        Logger.getLogger(ThesisBean.class.getName()).log(Level.SEVERE, null, ex);
	    } finally {
	        file.delete();
	    }
	}
	private boolean isFolderExists(String path) {
		File file = new File(path);
		return file.exists();
	}

}
