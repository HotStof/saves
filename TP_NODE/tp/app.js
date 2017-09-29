"use strict";
var fs = require("fs");
var CONFIG = require("./config.json");
process.env.CONFIG = JSON.stringify(CONFIG);
var CONFIG = JSON.parse(process.env.CONFIG);
var defaultRoute = require("./app/routes/default.route.js");
var http = require("http");
var CONFIG = require("./config.json");
var server = http.createServer(app);
var path = require("path");
var express = require("express");
console.log('It Works !')
var app = express();
app.get("/", function(request, response) {
	response.send("It works !");
});
// init server
var server = http.createServer(app);
server.listen(CONFIG.port,function() {
	var host = this.address().address;
	var port = this.address().port;
console.log('example app listening at http://%s:%s',host,port);
});
app.use(defaultRoute);
app.use("/index", express.static(path.join(__dirname, "public/")));

//Q_13.1
app.get("/loadPres",  function (request, response) {

	var jsonData = {};

	fs.readdir(CONFIG.presentationDirectory, function (err, files) {

		if (err) {
			console.error(response.status(500).end);
			return response.status(500).end;
		}

		var filteredFiles;
		files.filter(function (file) {
			filteredFiles = files.filter(extension);
		});

		var compteur = 0;
		filteredFiles.forEach(function (file) {

			fs.readFile(path.join(CONFIG.presentationDirectory, file), 'utf8', function(err,data) {  
				if (err) {
					console.error(response.status(500).end);
					return response.status(500).end;
				}				
				var obj = JSON.parse(data);
				var Id = obj["id"];

				jsonData[Id] = obj;
				compteur ++;
				if (compteur == filteredFiles.length) returnJson(Id);
			});
		});
	});

	function returnJson(Id){

		response.send(jsonData[Id]);

	}

});


function extension(element) {
	var extName = path.extname(element);
	return extName === '.json'; 
};

