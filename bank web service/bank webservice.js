var http = require("http");
var url = require("url");
var mysql = require("mysql");
var fs = require("fs");

var mysql_con = mysql.createConnection({host: "localhost", user: "root", password: "kevin007", port: 3307});
mysql_con.connect(function(e) {
	if (e) throw e;

	mysql_con.query("USE node_js", function (e, result) {
		if (e) throw e;
	});
});

let transfer_get;
fs.readFile('./html/transfer_get.html','ascii',function (e, data){
	transfer_get = data;
});

http.createServer(function(request,response){
	var url_parts = url.parse(request.url,true);
	switch (url_parts.pathname){
		case ("/validate"):
			if (request.method == "GET"){
				console.log("validate GET invoked");
				var validate_from_mysql = function(name, card_number){
					var query = "SELECT * FROM nasabah WHERE name=\"" + name + "\" AND nomor_kartu=\"" + card_number +"\"";

					mysql_con.query(query,function(e,result) {
						if (e) throw e;

						response.writeHead(200,{"Access-Control-Allow-Origin" : "http://localhost"});
						if (result.length > 0){
							console.log("Data available");
							response.end("OK");
						} else {
							console.log("Data unavailable");
							response.end();
						}
					});
				};

				var name = url_parts.query.name;
				var card_number = url_parts.query.card_number;

				validate_from_mysql(name,card_number);
			} else {
				response.writeHead(403);
				response.end();
			}
			break;
		case ("/transfer"):
			if (request.method == "POST"){
				request.on('data', function(data) {
					var data_splitted = data.toString().split("&");
					
					var sender_card_num = (data_splitted[0].split("="))[1];
					var receiver_card_num = (data_splitted[1].split("="))[1];
					var amount = (data_splitted[2].split("="))[1];

					var query = "SELECT saldo FROM nasabah WHERE nomor_kartu=\"" + sender_card_num + "\"";
					mysql_con.query(query,function(e, result) {
						if (e) throw e;

						response.writeHead(200);
						if ((result[0].saldo - amount) >= 0){
							console.log("Saldo cukup");
							response.end("OK");

							var query = "UPDATE nasabah SET saldo=" + (result[0].saldo - amount) + " WHERE nomor_kartu=\"" + sender_card_num + "\"";
							
							mysql_con.query(query,null);
						} else {
							console.log("Saldo kurang");
							response.end();
						}
					});
				});

				response.writeHead(200);
				response.end()
			} else {
				response.writeHead(403);
				response.end();
			}
			break;
		default:
			response.writeHead(404);
			response.end();
	}
}).listen(8081);

console.log("Listening on 127.0.0.1:8081");