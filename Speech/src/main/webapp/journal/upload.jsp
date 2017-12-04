<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<script type="text/javascript" src="//code.jquery.com/jquery-1.5.2.js"></script>
<title>Upload File Request Page</title>
<script type='text/javascript'>//<![CDATA[
$(window).load(function(){
// jQuery
/*
$('#upload').change(function() {
    var filename = $(this).val();
    var lastIndex = filename.lastIndexOf("\\");
    if (lastIndex >= 0) {
        filename = filename.substring(lastIndex + 1);
    }
    $('#filename').val(filename);
});
*/

// javascript
//get the file input element and set its onchange method function
document.getElementById('file').onchange = uploadOnChange;
    
function uploadOnChange() {
    var filename = this.value;
    var lastIndex = filename.lastIndexOf("\\");
    if (lastIndex >= 0) {
        filename = filename.substring(lastIndex + 1);
    }
    else {
    	
    	lastIndex = filename.lastIndexOf("/");
        if (lastIndex >= 0) {
            filename = filename.substring(lastIndex + 1);
        }
    	
    }
    document.getElementById('name').value = filename;
}
});//]]> 

</script>
</head>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<body>
	<form method="POST"  action="${root}/journal/uploadFile" enctype="multipart/form-data">
		File to upload: <input type="file" name="file" id = "file" onchange="setFileInput()">
 
		Name: <input type="text" name="name" id = "name">
 
        
		<input type="submit" value="Upload"> Press here to upload the file!
	</form>	
</body>
</html>