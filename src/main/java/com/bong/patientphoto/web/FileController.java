package com.bong.patientphoto.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.imgscalr.Scalr;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bong.patientphoto.Config;
import com.bong.patientphoto.util.Token;
import com.bong.patientphoto.vo.FileMeta;
import com.bong.patientphoto.vo.Image;
import com.bong.patientphoto.vo.PhotoInfo;

@Controller
public class FileController extends BacoderController{
	private final Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody Map upload2(MultipartHttpServletRequest request, HttpServletResponse response) throws ParseException {
		String patientId = request.getParameter("patientId");
		logger.info("patientId: " + patientId);
		
		String date = request.getParameter("date");
		logger.info("date: " + date);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parsed = format.parse(date);
        java.sql.Date captureDate = new java.sql.Date(parsed.getTime());

		String doctor = request.getParameter("doctor");
		logger.info("doctor: " + doctor);
		
		String classification = request.getParameter("classification");
		logger.info("classification: " + classification);
		
		String uploader = request.getParameter("uploader");
		logger.info("uploader: " + uploader);

		
		SimpleDateFormat format1 = new SimpleDateFormat ("HHmmss");			
		Date time = new Date();			
		String time1 = format1.format(time);
		
		Iterator<String> itr = request.getFileNames();
        MultipartFile mpf;
        List<PhotoInfo> list = new LinkedList<>();
        while (itr.hasNext()) {
            mpf = request.getFile(itr.next());
            logger.info("Uploading {}" + mpf.getOriginalFilename());
//            String newFilenameBase = UUID.randomUUID().toString();
            
//            String url = "/volume1/@appstore/Tomcat7/src/webapps/storage";
            String url = "/home/phbong31/storage";

            File patientDir = new File(url + File.separator + patientId);
            logger.info("url: "+url);
            logger.info("patientDir: "+patientDir.getPath());

            if(!patientDir.exists()) {
            	patientDir.mkdir();
            }
            String newFilenameBase = patientId+"/"+patientId+"_"+date+"_"+time1;

            String originalFileExtension = mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."));
            String newFilename = newFilenameBase + originalFileExtension;
            
            //String srcPath = request.getSession().getServletContext().getRealPath("/upload");
            String srcPath = Config.srcPath;

            logger.info("srcPath: " + srcPath);
			String contentType = mpf.getContentType();
			
			File newFile = new File(srcPath + "/" + newFilename);
            try {
                mpf.transferTo(newFile);
                
                BufferedImage thumbnail = Scalr.resize(ImageIO.read(newFile), 290);
                String thumbnailFilename = newFilenameBase + "-thumbnail.JPG";
                File thumbnailFile = new File(srcPath + "/" + thumbnailFilename);
                ImageIO.write(thumbnail, "jpg", thumbnailFile);
                
                PhotoInfo photo = new PhotoInfo();
                photo.setPatientId(patientId);
                photo.setName(mpf.getOriginalFilename());
                photo.setThumbnailFilename(thumbnailFilename);
                photo.setNewFilename(newFilename);
                photo.setSize((int)mpf.getSize());
                photo.setThumbnailSize((int)thumbnailFile.length());
                photo.setContentType(contentType);
                photo.setClassification(classification);
                photo.setSync(2);
                photo.setPhotoUrl(newFilename);
                photo.setDoctor(doctor);
                photo.setCaptureDate(captureDate);
                photo.setUploader(uploader);
                
                int result = photoInfoService.insert(photo);
                
                photo.setUrl(getWebappDir(request) +"/picture/"+photo.getId());
                photo.setThumbnailUrl(getWebappDir(request) + "/thumbnail/"+photo.getId());
                
                logger.info(photo.toString());
                list.add(photo);
            } catch(IOException e) {
                logger.info("Could not upload file "+mpf.getOriginalFilename() + e.getLocalizedMessage());
            }
        }
        Map<String, Object> files = new HashMap<>();
        files.put("files", list);
        return files;
	}
	
	@RequestMapping(value = "/picture/{id}", method = RequestMethod.GET)
    public void picture(HttpServletRequest request,
    		HttpServletResponse response, @PathVariable int id, @RequestParam(value="token")Optional<String> tokenStr) {
		PhotoInfo param = new PhotoInfo();
		param.setId(id);
		logger.info(param.toString());	
		if(request.isUserInRole("ROLE_USER") || request.isUserInRole("ROLE_ADMIN"))
		{
				PhotoInfo image = photoInfoService.selectOne(param);
			      //  String srcPath = request.getSession().getServletContext().getRealPath("/upload");
			        String srcPath = Config.srcPath;
	
			        logger.info(image.toString());
			        File imageFile = new File(srcPath+"/"+image.getPhotoUrl());
			        logger.info(imageFile.getAbsolutePath());
			        
			        response.setContentType(image.getContentType());
			        response.setContentLength(image.getSize());
			        try {
			            InputStream is = new FileInputStream(imageFile);
			            IOUtils.copy(is, response.getOutputStream());
			        } catch(IOException e) {
			            logger.info("Could not show picture "+id +"/" + e.getLocalizedMessage());
			        }
		}
		if(tokenStr.isPresent()) {
			Token token = new Token();
			if(token.IsValidPhotoToken(tokenStr.get())) {
				PhotoInfo image = photoInfoService.selectOne(param);
			      //  String srcPath = request.getSession().getServletContext().getRealPath("/upload");
			        String srcPath = Config.srcPath;
	
			        logger.info(image.toString());
			        File imageFile = new File(srcPath+"/"+image.getPhotoUrl());
			        logger.info(imageFile.getAbsolutePath());
			        
			        response.setContentType(image.getContentType());
			        response.setContentLength(image.getSize());
			        try {
			            InputStream is = new FileInputStream(imageFile);
			            IOUtils.copy(is, response.getOutputStream());
			        } catch(IOException e) {
			            logger.info("Could not show picture "+id +"/" + e.getLocalizedMessage());
			        }
			} else {
				logger.info("picture :Invalid token");
			}
		} else {
			logger.info("picture : token not found");
		}
    }
	
	
	@RequestMapping(value = "/thumbnail/{id}", method = RequestMethod.GET)
	   public void thumbnail(HttpServletRequest request,
	    		HttpServletResponse response, @PathVariable int id, @RequestParam(value="token")Optional<String> tokenStr) {
			PhotoInfo param = new PhotoInfo();
			param.setId(id);
			logger.info(param.toString());	
			if(request.isUserInRole("ROLE_USER") || request.isUserInRole("ROLE_ADMIN"))
			{
					PhotoInfo image = photoInfoService.selectOne(param);
				      //  String srcPath = request.getSession().getServletContext().getRealPath("/upload");
				        String srcPath = Config.srcPath;
		
				        logger.info(image.toString());
				        
				        File imageFile = null;
				        if(image.getThumbnailFilename() != null && image.getThumbnailFilename().length() > 0) {
					        imageFile = new File(srcPath+"/"+image.getThumbnailFilename());
					        response.setContentLength(image.getThumbnailSize());
				        } else {
					        imageFile = new File(srcPath+"/"+image.getPhotoUrl());
					        response.setContentLength(image.getSize());
				        }				       
				        logger.info(imageFile.getAbsolutePath());			        
				        response.setContentType(image.getContentType());
				        
				        try {
				            InputStream is = new FileInputStream(imageFile);
				            IOUtils.copy(is, response.getOutputStream());
				        } catch(IOException e) {
				            logger.info("Could not show thumbnail "+id +"/" + e.getLocalizedMessage());
				        }
			}
			if(tokenStr.isPresent()) {
				Token token = new Token();
				if(token.IsValidPhotoToken(tokenStr.get())) {
					PhotoInfo image = photoInfoService.selectOne(param);
				      //  String srcPath = request.getSession().getServletContext().getRealPath("/upload");
				        String srcPath = Config.srcPath;
		
				        logger.info(image.toString());
				        
				        File imageFile = null;
				        if(image.getThumbnailFilename() != null && image.getThumbnailFilename().length() > 0) {
					        imageFile = new File(srcPath+"/"+image.getThumbnailFilename());
					        response.setContentLength(image.getThumbnailSize());
				        } else { //thumbnail 없으면 원본이미지 
					        imageFile = new File(srcPath+"/"+image.getPhotoUrl());
					        response.setContentLength(image.getSize());
				        }				       
				        logger.info(imageFile.getAbsolutePath());			        
				        response.setContentType(image.getContentType());
				        
				        try {
				            InputStream is = new FileInputStream(imageFile);
				            IOUtils.copy(is, response.getOutputStream());
				        } catch(IOException e) {
				            logger.info("Could not show thumbnail "+id +"/" + e.getLocalizedMessage());
				        }
				} else {
					logger.info("thumbnail :Invalid token");
				}
			} else {
				logger.info("thumbnail : token not found");
			}
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id,
    		HttpServletRequest request) {
		Image param = new Image();
		param.setId(id);
		
        Image image = imageService.selectOne(param);
        String srcPath = Config.srcPath;
        
        File imageFile = new File(srcPath+"/"+image.getNewFilename());
        imageFile.delete();
        File thumbnailFile = new File(srcPath+"/"+image.getThumbnailFilename());
        thumbnailFile.delete();
        imageService.delete(image);
	}
	/***************************************************
	 * URL: /upload  
	 * upload(): receives files
	 * @param request : MultipartHttpServletRequest auto passed
	 * @param response : HttpServletResponse auto passed
	 * @return List<FileMeta> as json format
	 ****************************************************/
	/*
	@RequestMapping(value="/upload/old", method = RequestMethod.POST)
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
	*/
	
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
	
	@ResponseBody
	@RequestMapping(value="/upload/update", method=RequestMethod.GET)
	public String updatePictures(HttpServletResponse response, @RequestParam(value="start")Integer start) {
		JSONObject json = new JSONObject();
		
		final String photoUrlParent = Config.srcPath;
		logger.info("start : "+start);
		PhotoInfo info = new PhotoInfo();
		info.setRange(start);
		
		List<PhotoInfo> list = photoInfoService.selectAll(info);
		logger.info("list size : " + list.size());
		json.put("total", list.size());
		
		//int i = 0;
		Iterator<PhotoInfo> iter = list.iterator();
		while(iter.hasNext()) {
			PhotoInfo photo = iter.next();
			File photoFile = new File(photoUrlParent + File.separator + photo.getPhotoUrl());
			final long size = photoFile.length();
			final String ext = photo.getPhotoUrl().substring(photo.getPhotoUrl().lastIndexOf(".")+1);
			final String type = "image/"+ext;
			photo.setSize((int)size);
			photo.setContentType(type);
			
			//logger.info(photo.toString());
		}
		
		int result = photoInfoService.update(list);
		json.put("update", result);
		return json.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/upload/updateOne", method=RequestMethod.GET)
	public String updateOnePicture(HttpServletResponse response, @RequestParam(value="id")Integer id) {
		JSONObject json = new JSONObject();
		
		final String photoUrlParent = Config.srcPath;  // .../storage
		
		PhotoInfo info = new PhotoInfo();
		info.setId(id);
		
		info = photoInfoService.selectOne(info);
		
		File photoFile = new File(photoUrlParent + File.separator + info.getPhotoUrl());
		
		final long size = photoFile.length();
		final String ext = info.getPhotoUrl().substring(info.getPhotoUrl().lastIndexOf(".")+1);
		String extType = "";
		if(ext.equalsIgnoreCase("JPG")) {
			extType = "JPEG";
		} else {
			extType = "JPEG";
		}
		final String type = "image/"+extType;
		info.setSize((int)size);
		info.setContentType(type);
			
		//logger.info(photo.toString());
        File patientDir = new File(photoUrlParent + File.separator + info.getPatientId());
		 if(!patientDir.exists()) {
         	patientDir.mkdir();
         }
		 
		String fileName = info.getPhotoUrl();
		int Idx = fileName.lastIndexOf(".");
		String baseFileName = fileName.substring(0, Idx);

        try {         
            BufferedImage thumbnail = Scalr.resize(ImageIO.read(photoFile), 290);
            
            String thumbnailFilename = baseFileName + "-thumbnail.jpg";
            File thumbnailFile = new File(photoUrlParent + File.separator + thumbnailFilename);
            ImageIO.write(thumbnail, "jpg", thumbnailFile);

            info.setThumbnailFilename(thumbnailFilename);
            info.setThumbnailSize((int)thumbnailFile.length());
        } catch(IOException e) {
            logger.info("Could not upload file " + e.getLocalizedMessage());
        }
		int result = photoInfoService.update(info);
		json.put("update", result);
		return json.toString();
	}
	
	//db에서 thumbnailFilename IS NULL OR size IS NULL OR size = 0  리스트 조회해서
	//contentType, size, thumbnail 비어있는 곳 업데이트 (thumbnail file 폴더에 있어야함)
	@ResponseBody
	@RequestMapping(value="/updateThumbnail", method=RequestMethod.GET)
	public String updateThumbnails(HttpServletResponse response, @RequestParam(value="start")Optional<Integer> start) {
		JSONObject json = new JSONObject();
		
		final String photoUrlParent = Config.srcPath;
		logger.info("start : "+start);
		PhotoInfo info = new PhotoInfo();
		if(start.isPresent()) {
			info.setRange(start.get());
		} else {
			info.setRange(0);
		}
			
		List<PhotoInfo> list = photoInfoService.selectThumbnail(info);
		List<PhotoInfo> updateList;
		logger.info("list size : " + list.size());
		json.put("total", list.size());
		
		int i = 0;
		Iterator<PhotoInfo> iter = list.iterator();
		while(iter.hasNext()) {
			PhotoInfo photo = iter.next();
			if(photo.getPhotoUrl() != null && photo.getPhotoUrl().length() > 0) {
				
				//size, contentType 없으면 update
				if(photo.getContentType() == null || photo.getSize() == 0 || photo.getThumbnailFilename() == null || photo.getThumbnailSize() == 0) {

					File photoFile = new File(photoUrlParent + File.separator + photo.getPhotoUrl());
					final long size = photoFile.length();
					final String ext = photo.getPhotoUrl().substring(photo.getPhotoUrl().lastIndexOf(".")+1);
					String extType = "";
					if(ext.equalsIgnoreCase("JPG")) {
						extType = "JPEG";
					} else {
						extType = "JPEG";
					}
					final String type = "image/"+extType;
					photo.setSize((int)size);
					photo.setContentType(type);
				
					String fileName = photo.getPhotoUrl();
					int Idx = fileName.lastIndexOf(".");
					String baseFileName = fileName.substring(0, Idx);
					String thumbnailFilename = baseFileName + "-thumbnail.JPG";
					File thumbnailFile = new File(photoUrlParent + File.separator + thumbnailFilename);
					//logger.info("thumbnailFilename : "+ thumbnailFile.getAbsolutePath());

					if(thumbnailFile.exists()) {
						//logger.info("thumbnail exist");
						final long thumbnailsize = thumbnailFile.length();
						//final String ext = photo.getPhotoUrl().substring(photo.getPhotoUrl().lastIndexOf(".")+1);
						//final String type = "image/JPEG";
						photo.setThumbnailSize((int)thumbnailsize);
						photo.setThumbnailFilename(thumbnailFilename);
						//photo.setContentType(type);
					}
					logger.info("id/size/type/thumbnailsize : "+ photo.getId()+"/"+photo.getSize()+"/"+photo.getContentType()+"/"+photo.getThumbnailSize());
					int result = photoInfoService.update(photo);
					i = i + result;
				}
			}
		}
		json.put("update", i);
		return json.toString();
	}
	
}