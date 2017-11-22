package com.aws.polly.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


import com.aws.polly.model.PollyFile;
import com.wordnik.swagger.annotations.*;

@Path("/speechservice")
@Api(value="/speechservice",description="operations  for speechservices")
public class TexttoPolly {
	

	@POST
	@Path("/pollyfiles/")
	@ApiOperation(value = "Add a new file")
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Filename not found")})
	public Response addFile(@ApiParam(value = "File object that needs to be updated", required = true)  PollyFile file) {
		System.out.println("invoking addFile, File name is "+ file.getFileName());
		file.setFileContent("read the file and set the content");
		
		return Response.ok().type("application/xml").entity(file).build();
	}

}
