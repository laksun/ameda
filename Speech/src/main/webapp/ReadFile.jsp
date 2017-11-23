<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script type="text/javascript">
	var app = angular.module('myapp2', []);

	app.controller('myappcontroller2', function($scope, $http) {
		$scope.texts = []
		$scope.textform = {
		    fileName : "",
		    filePath : ""
		};

		getTextDetails();

		function getTextDetails() {
			$http({
				method : 'GET',
				url : 'textdetails'
			}).then(function successCallback(response) {
				$scope.texts = response.data;
			}, function errorCallback(response) {
				console.log(response.statusText);
			});
		}

		$scope.processText = function() {
			$http({
				method : 'POST',
				url : 'text',
				data : angular.toJson($scope.textform),
				headers : {
					'Content-Type' : 'application/json'
				}
			}).then(getTextDetails(), clearForm())
			  .success(function(data){
				$scope.texts= data
		    });
		}
		$scope.editText = function(text) {
			$scope.textform.fileName = text.fileName;
			$scope.textform.filePath = text.filePath;
			disableName();
		}
		$scope.deleteText = function(text) {
			$http({
				method : 'DELETE',
				url : 'deletetext',
				data : angular.toJson(text),
				headers : {
					'Content-Type' : 'application/json'
				}
			}).then(getTextDetails());
		}

		function clearForm() {
			$scope.textform.fileName = "";
			$scope.textform.filePath = "";
			document.getElementById("fileName").disabled = false;
		}
		;
		function disableName() {
			document.getElementById("fileName").disabled = true;
		}
	});
</script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body ng-app="myapp2" ng-controller="myappcontroller2">
	<h3>Select a File</h3>
	<form ng-submit="processTextDetails()">
		<div class="table-responsive">
			<table class="table table-bordered" style="width: 600px">
				<tr>
					<td>File Name</td>
					<td>
						<input type="text" id="fileName" ng-model="textform.fileName" size="30" />
					</td>
				</tr>
				
				<tr>
					<td colspan="2">
						<input type="submit" class="btn btn-primary btn-sm" ng-click="processText()"	value="Read File" />
				    </td>
				</tr>
			</table>
		</div>
	</form>
	<h3>File History</h3>
	<div class="table-responsive">
		<table class="table table-bordered" style="width: 600px">
			<tr>
				<th>File Name</th>
				<th>File Location</th>
				<th>Actions</th>
			</tr>

			<tr ng-repeat="text in texts">
				<td>{{ text.fileName}}</td>
				<td>{{ text.filePath }}</td>
				<td><a ng-click="editText(text)" class="btn btn-primary btn-sm">Edit</a>
					| <a ng-click="deleteText(text)" class="btn btn-danger btn-sm">Delete</a></td>
			</tr>
		</table>
	</div>
</body>
</html>