var http = require("http");
var url = require("url");
var mysql = require("mysql");

var mysql_con = mysql.createConnection({host: "localhost", user: "root", password: "123", port: 3307});
mysql_con.connect(function(e) {
	if (e) throw e;

	mysql_con.query("USE node_js", function (e, result) {
		if (e) throw e;
	});
});

http.createServer(function(request,response){
	var url_parts = url.parse(request.url,true);

	switch (url_parts.pathname){
		case ("/validate"):
			if (request.method == "POST"){
				var validate_from_mysql = function(name, card_number){
					var query = "SELECT * FROM nasabah WHERE name=\"" + name + "\" AND nomor_kartu=\"" + card_number +"\"";

					mysql_con.query(query,function(e,result) {
						if (e) throw e;

						response.writeHead(200);
						if (result.length > 0){
							console.log("Data available");
							response.end("OK");
						} else {
							console.log("Data unavailable");
							response.end();
						}
					});
				};

				request.on('data', function(data) {
					var data_splitted = data.toString().split("&");

					var name = (data_splitted[0].split("=")[1]).split("+").join(" ");
					var card_number = data_splitted[1].split("=")[1];

					validate_from_mysql(name,card_number);
				});
			} else {
				response.writeHead(403);
				response.end();
			}
			break;
		default:
			response.writeHead(404);
			response.end();
	}
}).listen(8081)

console.log("Listening on 127.0.0.1:8081");