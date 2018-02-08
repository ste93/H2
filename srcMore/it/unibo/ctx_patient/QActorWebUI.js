//QActorWebUI.js	
//console.log("QActorWebUI.js : server IP= "+document.location.host);
 /*
 * WEBSOCKET
 */
    var sock = new WebSocket("ws://"+document.location.host, "protocolOne");
    sock.onopen = function (event) {
    };
    sock.onmessage = function (event) {
    };
    sock.onerror = function (error) {
    };
	function send(message) {
		if(document.getElementById('input').value != "") {
			sock.send(message);
		}
	};
