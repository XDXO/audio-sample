package com.sample.audio;

import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServeController {

	@Value("${upload.url}")
	private String path;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index() {
		
		return "index";
	}
	
	@RequestMapping(path = "/serve", method = RequestMethod.GET)
	@ResponseBody
	public FileSystemResource serveAudioFile() {
		
		return new FileSystemResource(Paths.get(path).toFile());
	}
}
