package com.mulechina.web.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mulechina.domain.PersonInfo;
import com.mulechina.mapper.PersonInfoMapper;
@Controller
public class FileController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PersonInfoMapper personInfoMapper;
	private static List<File> filelist = new ArrayList<File>();
	public static List<File> getFileList(String strPath) {
        File dir = new File(strPath);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();
                if (files[i].isDirectory()) { // 判断是文件还是文件夹
                    getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径
                } else if (fileName.endsWith("csv")) { // 判断文件名是否以.avi结尾
                    String strFileName = files[i].getAbsolutePath();
                    System.out.println("---" + strFileName);
                    filelist.add(files[i]);
                } else {
                    continue;
                }
            }

        }
        return filelist;
    }
	
	@RequestMapping("/list")
	@ResponseBody
	public List<PersonInfo> queryAll(){
		return personInfoMapper.queryAll();
	}
	@RequestMapping("/file")
	public void insert(){
		getFileList("D:/2000W");
		for(File file:filelist){
			String str = null;
			try {
				FileInputStream is = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				while ((str = br.readLine()) != null) {
					String filename = str.trim();
					String[] args = filename.split(",");
					PersonInfo pojo = new PersonInfo();
					
					pojo.setName(args[0]);
					pojo.setCardno(args[1]);
					pojo.setDescriot(args[2]);
					pojo.setCtftp(args[3]);
					pojo.setCtfid(args[4]);
					pojo.setGender(args[5]);
					pojo.setBirthday(args[6]);
					pojo.setAddress(args[7]);
					pojo.setZip(args[8]);
					pojo.setDirty(args[9]);
					pojo.setDistrict1(args[10]);
					pojo.setDistrict2(args[11]);
					pojo.setDistrict3(args[12]);
					pojo.setDistrict4(args[13]);
					pojo.setDistrict5(args[14]);
					pojo.setDistrict6(args[15]);
					pojo.setFirstnm(args[16]);
					pojo.setLastnm(args[17]);
					pojo.setDuty(args[18]);
					pojo.setMobile(args[19]);
					pojo.setTel(args[20]);
					pojo.setFax(args[21]);
					pojo.setEmail(args[22]);
					pojo.setNation(args[23]);
					pojo.setTaste(args[24]);
					pojo.setEducation(args[25]);
					pojo.setCompany(args[26]);
					pojo.setCtel(args[27]);
					pojo.setCaddress(args[28]);
					pojo.setCzip(args[29]);
					pojo.setFamily(args[30]);
					pojo.setVersion(args[31]);
					pojo.setOldid(args[32]);
					personInfoMapper.insert(pojo);
				}
				br.close();
			} catch (Exception e) {
				logger.error("e:{} msg:{}",e.getMessage(),str);
			}
		}
	}
}
