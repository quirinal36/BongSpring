package com.bong.patientphoto.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bong.patientphoto.Config;
import com.bong.patientphoto.util.FileUtil;
import com.bong.patientphoto.vo.UserVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class UploadController extends BacoderController{
	final Logger logger = LoggerFactory.getLogger(getClass());
	final int MAX_FILE_SIZE = 10 * 1024 * 1024;
	
	@RequestMapping(value="/photo_upload", method=RequestMethod.GET)
	public ModelAndView getPhotoUploader(ModelAndView mv) {
		
		mv.setViewName("/photo/photo_uploader");
		return mv;
	}
	
	/**
	 * 사진 업로드시 확인 버튼을 눌렀을 때
	 *  
	 * @param mv
	 * @param req
	 * @param resp
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/file_uploader")
	public ModelAndView getFileUploader(ModelAndView mv, HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		UserVO user = getUser();
		if(user.getId() > 0) {
			// 임시 업로드 디렉터리
			String srcPath = req.getSession().getServletContext().getRealPath("/upload");
			// 최종 저장할 디렉터리
			String path = makeUserPath(user.getId());
			
			if(req.getContentLength() > MAX_FILE_SIZE) {
				mv.addObject("above_permission", true);
			}else {
				MultipartRequest multi=new MultipartRequest(req, srcPath, MAX_FILE_SIZE, Config.ENCODING, new DefaultFileRenamePolicy());
				
				// 넘겨져온 파일명
				String upfile = (multi.getFilesystemName("Filedata"));
				if (!upfile.equals("")) {
					// 저장할 파일명 포맷(날짜와 시간조합) 으로 파일명을 만든다. 
					SimpleDateFormat formatter2 = new SimpleDateFormat ("yyyy_MM_dd_HHmmssSSS", java.util.Locale.KOREA);
					String dateString = formatter2.format(new java.util.Date());
					String moveFileName = dateString + upfile.substring(upfile.lastIndexOf("."));
					
					// 임시 저장장소에 저장된 파일
					File sourceFile = new File(srcPath + File.separator + upfile);
					// 최종 저장장소에 저잘될 파일
					File targetFile = new File(path + File.separator + moveFileName);
					
					// 임시 저장장소에 올라온 파일을 이미지로 변환
					BufferedImage img = ImageIO.read(sourceFile);
					try {
						ImageIO.write(img, "JPEG", targetFile);
					}catch(FileNotFoundException e) {
						e.printStackTrace();
					}
					
					// 최종 저장장소에 파일을 옮김
					new FileUtil().copyFileIntoUpload(sourceFile);

					mv.addObject("filename", moveFileName);
					
					// 방금 올린 파일에 접근할수 있도록 URL 형태로 경로를 보내준다
					mv.addObject("uploaded_url", getUploadedUrl(user.getId(), moveFileName));
					
					
				}
			}
			mv.setViewName("/photo/file_uploader");
		}else {
			mv.setViewName("redirect:/");
		}
		
		return mv;
	}
	
	/**
	 * 이미 업로드 되어 외부에서 접근 가능한 URL 
	 * 
	 * @param userId
	 * @param filename
	 * @return
	 */
	private String getUploadedUrl(int userId, String filename) {
		return new StringBuilder()
				.append("http://").append("www.bacoder.kr")
				.append("/upload/com.bong.patientphoto/")
				.append(userId).append("/")
				.append(filename).toString();
	}
	
	/**
	 * 사진 파일을 저장할 디렉터리 가져오기
	 * 
	 * @param userId
	 * @return
	 */
	private String makeUserPath(int userId) {
		String path = System.getProperty("user.dir");
		StringBuilder builder = new StringBuilder()
				.append(path.substring(0, path.lastIndexOf(File.separator)))
				.append(File.separator).append("webapps").append(File.separator)
				.append("upload").append(File.separator)
				.append("com.bong.patientphoto").append(File.separator)
				.append(userId).append(File.separator);
		
		File file = new File(builder.toString());
		file.mkdirs();
		return file.getAbsolutePath();
	}
}
