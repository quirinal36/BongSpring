package com.bong.patientphoto.web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bong.patientphoto.Config;
import com.bong.patientphoto.vo.FileMeta;
import com.bong.patientphoto.vo.PhotoInfo;

@Controller
public class FileController {
	private final Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	
	/***************************************************
	 * URL: /upload  
	 * upload(): receives files
	 * @param request : MultipartHttpServletRequest auto passed
	 * @param response : HttpServletResponse auto passed
	 * @return List<FileMeta> as json format
	 ****************************************************/
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	@ResponseBody
	public synchronized List<FileMeta> upload(MultipartHttpServletRequest request, HttpServletResponse response) {
		logger.info("upload controller~!!");
		List<FileMeta> files = new ArrayList<FileMeta>();
		
		//1. build an iterator
		Iterator<String> itr =  request.getFileNames();
		MultipartFile mpf = null;

		//2. get each file
		while(itr.hasNext()){

			//2.1 get next MultipartFile
			mpf = request.getFile(itr.next()); 
			logger.info(mpf.getOriginalFilename() +" uploaded! "+files.size());

			//2.2 if files > 10 remove the first from the list
			if(files.size() >= 10) files.remove(0);
				// files.pop();

			//2.3 create new fileMeta
			FileMeta fileMeta = new FileMeta();
			fileMeta.setFileName(mpf.getOriginalFilename());
			fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
			fileMeta.setFileType(mpf.getContentType());
			
			String srcPath = request.getSession().getServletContext().getRealPath("/upload");
			final String uploadedFileUri = srcPath + "/" + mpf.getOriginalFilename();
			fileMeta.setFileUri(uploadedFileUri);
			logger.info(fileMeta.getFileUri());
			try {
				fileMeta.setBytes(mpf.getBytes());

				// copy file to local disk 
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(uploadedFileUri));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			//2.4 add to files
			files.add(fileMeta);
		}
		// result will be like this
		// [{"fileName":"app_engine-85x77.png","fileSize":"8 Kb","fileType":"image/png"},...]
		return files;
	}
	
	/***************************************************
	 * URL: /rest/controller/get/{value}
	 * get(): get file as an attachment
	 * @param response : passed by the server
	 * @param value : value from the URL
	 * @return void
	 ****************************************************/
	@RequestMapping(value = "/upload/get/{value}", method = RequestMethod.GET)
	public void get(HttpServletResponse response,@PathVariable String value){
		/*
		FileMeta getFile = files.get(Integer.parseInt(value));
		try {      
			response.setContentType(getFile.getFileType());
			response.setHeader("Content-disposition", "attachment; filename=\""+getFile.getFileName()+"\"");
			FileCopyUtils.copy(getFile.getBytes(), response.getOutputStream());
		}catch (IOException e) {
			e.printStackTrace();
		}
		*/
	}
	
	@RequestMapping(value="/upload/submit", method=RequestMethod.GET)
	public void uploadSubmit(HttpServletResponse response,
			PhotoInfo photoInfo) throws IOException {
		response.setCharacterEncoding(Config.ENCODING);
		
		logger.info(photoInfo.toString());
		//logger.info("files.size(): " + files.size());
		
		JSONObject json = new JSONObject();
		response.getWriter().append(json.toString());
	}
}