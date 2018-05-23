package com.skytiger.net.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.skytiger.net.entity.AddressInfo;
import com.skytiger.net.entity.SysPost;
import com.skytiger.net.service.SysService;
import com.skytiger.net.utils.GrnerateUUID;

@RestController
@RequestMapping("/address")
public class AddressInfoController {
	@Resource
	private SysService sysService;

	/**
	 * 上传注册用户所需地址信息
	 * @param multipartFile
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("fileUpload")
	public void upload(MultipartFile multipartFile) throws Exception {
		if (!multipartFile.isEmpty()) {
			XSSFWorkbook workbook = new XSSFWorkbook(multipartFile.getInputStream());
			XSSFSheet  sheet = workbook.getSheetAt(0);
			
			for (int j = 1; j <= sheet.getLastRowNum(); j++) {
				XSSFRow row=sheet.getRow(j);
				if(!"".equals(row.getCell(0).getStringCellValue())) {
					row.getCell(0).setCellType(HSSFCell.CELL_TYPE_STRING);
					row.getCell(1).setCellType(HSSFCell.CELL_TYPE_STRING);
					row.getCell(2).setCellType(HSSFCell.CELL_TYPE_STRING);
					row.getCell(3).setCellType(HSSFCell.CELL_TYPE_STRING);
					row.getCell(4).setCellType(HSSFCell.CELL_TYPE_STRING);
					row.getCell(5).setCellType(HSSFCell.CELL_TYPE_STRING);
					
					AddressInfo info=new AddressInfo();
					info.setInfoId(GrnerateUUID.getUUID());
					info.setInfoName(row.getCell(0).getStringCellValue());
					info.setInfoPhone(row.getCell(1)+"");
					info.setInfoProvince(row.getCell(2)+"");
					info.setInfoCity(row.getCell(3)+"");
					info.setInfoArea(row.getCell(4)+"");
					info.setAddressDetails(row.getCell(5)+"");
					
					sysService.addAddressInfo(info);
				}else {
					return;
				}
			}
		}
	}
	
	/**
	 * 上传运单编号
	 * @param multipartFile
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping("uploadPostNum")
	public void uploadPostNum(MultipartFile multipartFile) throws Exception {
		if (!multipartFile.isEmpty()) {
			XSSFWorkbook workbook = new XSSFWorkbook(multipartFile.getInputStream());
			XSSFSheet  sheet = workbook.getSheetAt(0);
			
			for (int j = 1; j <= sheet.getLastRowNum(); j++) {
				XSSFRow row=sheet.getRow(j);
				row.getCell(0).setCellType(HSSFCell.CELL_TYPE_STRING);
				if(!"".equals(row.getCell(0)+"")) {
					
					SysPost record=new SysPost();
					record.setPostId(GrnerateUUID.getUUID());
					record.setPostNum(row.getCell(0)+"");
					record.setCreateTime(new Date());
					
					sysService.addPostNum(record);
				}else {
					return;
				}
			}
		}
	}

}
