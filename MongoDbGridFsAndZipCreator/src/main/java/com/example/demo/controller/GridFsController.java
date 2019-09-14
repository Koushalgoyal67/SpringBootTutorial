package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.activation.MimetypesFileTypeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;



@RestController
public class GridFsController {

	@Value("${spring.data.mongodb.port}")
	private int port;
	
	@Value("${spring.data.mongodb.database}")
	private String database;
	
	@Value("${spring.data.mongodb.host}")
	private String host;
	
	@Autowired
	private GridFsOperations gridFsOperations;

	String fileId = "";

	@GetMapping("/saveFiles")
	public String saveFile() throws IOException {
		
		MongoClient mongo = new MongoClient(host, port);
	    DB db = mongo.getDB(database);

	    GridFS gridFs = new GridFS(db);
	    File file= new File("/Users/govind.singh/Documents/store/logo.png");
	    
	    URLConnection connection = file.toURL().openConnection();

	    GridFSInputFile gridFsInputFile = gridFs.createFile(file);
	    
	    //Set a name on GridFS entry
	    gridFsInputFile.setFilename(gridFsInputFile .getFilename());
	    
        //set MIME type
	    gridFsInputFile.setContentType(connection.getContentType());
	    
	    //Save the file to MongoDB
	    gridFsInputFile.save();
	    
	    File file2= new File("/Users/govind.singh/Documents/store/demo.dmg");
	    connection = file2.toURL().openConnection();
	    gridFsInputFile = gridFs.createFile(file2);
	    gridFsInputFile.setFilename(gridFsInputFile .getFilename());
	    gridFsInputFile.setContentType(connection.getContentType());
	    gridFsInputFile.save();
	    
		
		return "File stored successfully...";
	}

	@GetMapping("/retrive/image")
	public String retriveImageFile() throws IOException {
		MongoClient mongo = new MongoClient(host, port);
	    DB db = mongo.getDB(database);
	
		GridFS gridFs = new GridFS(db);
		GridFSDBFile outputImageFile = gridFs.findOne("logo.png");
		
 
	    //Get the number of chunks
	    System.out.println("Total Chunks: " + outputImageFile.numChunks());

		outputImageFile.writeTo("/Users/govind.singh/Documents/store2/logo.png");
	    
		System.out.println("File name : " + outputImageFile.getFilename());
		mongo.close();
		return "Image File retrived with name : " +outputImageFile.getFilename()+outputImageFile.getMetaData();
	}

	@GetMapping("/retrive/text")
	public String retriveTextFile() throws IOException {
		
		MongoClient mongo = new MongoClient(host, port);
	    DB db = mongo.getDB(database);
	
		GridFS gridFs = new GridFS(db);
		GridFSDBFile outputImageFile = gridFs.findOne("demo.dmg");
		

	    //Get the number of chunks
	    System.out.println("Total Chunks: " + outputImageFile.numChunks());

		outputImageFile.writeTo("/Users/govind.singh/Documents/store2/demo.dmg");
	    
		System.out.println("File name : " + outputImageFile.getFilename());
		mongo.close();
		return "Image File retrived with name : "+outputImageFile.getFilename() ;
	}

}
