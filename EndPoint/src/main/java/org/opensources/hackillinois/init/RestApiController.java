package org.opensources.hackillinois.init;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

//import org.airavata.teamzenith.dao.JobDetails;
//import org.airavata.teamzenith.dao.UserDetails;
//import org.airavata.teamzenith.webmethods.CancelJob;
//import org.airavata.teamzenith.webmethods.MonitorJob;
//import org.airavata.teamzenith.webmethods.SubmitJob;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

//import com.jcraft.jsch.JSchException;
/*
 * This is the main controller class which provides the following three REST APIs
 * upload- Accepts user and job details in order to submit a job on Karst
 * monitor- Accepts user details and job ID which is used to fetch the status of the job
 * cancel - Accepts user details and job ID which is used to cancel the job
 */
@Controller
public class RestApiController {

	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public @ResponseBody String provideUploadInfo() {
		return "A Karst job can be submitted by POSTing to this URL.";
	}

	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public @ResponseBody String handleFileUpload(@RequestParam("tpath") String tPath,
			@RequestParam("user") String userName,
			@RequestParam("jobName") String jobName, @RequestParam("nodes") String nodes,
			@RequestParam("ppn") String ppn, @RequestParam("walltime") String wallTime, 
			@RequestParam("isCompile") String isComp, @RequestParam("emailId") String emailId, 
			@RequestParam("ppk") MultipartFile ppk, @RequestParam(name = "pass", defaultValue = "null") String pass){

		if (true) {
			try {
				//	return "Job submitted successfully with job Id "+jd.getJobId();
				System.out.println( );
				return "Demo Works";
				
			} catch (Exception e) {
				return "You failed to upload " + e.getMessage();
			}
		} else {
			return "failed because the file was empty.";
		}
	}

	}
