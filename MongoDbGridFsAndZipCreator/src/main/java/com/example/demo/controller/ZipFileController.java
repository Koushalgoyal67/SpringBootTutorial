package com.example.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

@RestController
@RequestMapping("/zip")
public class ZipFileController {

	List<String> fileList;
	private static final String OUTPUT_ZIP_FILE = "/Users/govind.singh/Documents/store3/MyFile.zip";
	private static final String SOURCE_FOLDER = "/Users/govind.singh/Documents/store";

	@Value("${spring.data.mongodb.port}")
	private int port;

	@Value("${spring.data.mongodb.database}")
	private String database;

	@Value("${spring.data.mongodb.host}")
	private String host;

	@Autowired
	private GridFsOperations gridFsOperations;

	@GetMapping("/saveFiles")
	public String saveFile() throws IOException {

		MongoClient mongo = new MongoClient(host, port);
		DB db = mongo.getDB(database);

		GridFS gridFs = new GridFS(db);

		// saving image file
		GridFSInputFile gridFsInputFile = gridFs.createFile(new File("/Users/govind.singh/Documents/store/logo.png"));
		gridFsInputFile.setFilename(gridFsInputFile.getFilename());

		gridFsInputFile.save();

		// saving text file
		gridFsInputFile = gridFs.createFile(new File("/Users/govind.singh/Documents/store/txt1.rtf"));
		gridFsInputFile.setFilename(gridFsInputFile.getFilename());

		gridFsInputFile.save();

		return "File stored successfully...";
	}

	@GetMapping("/retrive/zip")
	public String retriveImageFile() throws IOException {

		return zipFile();
	}

	public String zipFile() {
		try (MongoClient mongo = new MongoClient(host, port);
				OutputStream os = new ByteArrayOutputStream();
				FileOutputStream fos = new FileOutputStream(OUTPUT_ZIP_FILE);
				ZipOutputStream zip = new ZipOutputStream(fos);) {

			DB db = mongo.getDB(database);
			GridFS gridFs = new GridFS(db);
			GridFSDBFile temp = gridFs.findOne("logo.png");
			GridFSDBFile temp2 = gridFs.findOne("txt1.rtf");
			GridFSDBFile temp3 = gridFs.findOne("demo.dmg");

			List<GridFSDBFile> list = new ArrayList<>();

			list.add(temp);
			list.add(temp2);
			list.add(temp3);
			byte[] buffer = new byte[1024];

			list.forEach(item -> {
				ZipEntry ze = new ZipEntry(item.getFilename());
				try {
					zip.putNextEntry(ze);
					InputStream in = item.getInputStream();
					int len;
					while ((len = in.read(buffer)) != -1) {
						zip.write(buffer, 0, len);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

			// or

//			      for (int i=0; i < list.size(); i++) {
//	        		ZipEntry ze= new ZipEntry(list.get(i).getFilename());
//	            	zip.putNextEntry(ze);
//	                InputStream in=list.get(i).getInputStream();	   
//	         	    int len;
//	         	   
//		         	while ((len = in.read(buffer)) != -1) {
//		         		zip.write(buffer, 0, len);
//		         	}
//
//	            }

			return "Zipped Succssfully";
		} catch (IOException ioe) {
			return "Zipped failed with Exception " + ioe;
		}

	}

}
