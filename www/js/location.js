var exec = require('cordova/exec'),
cordova = require('cordova');

function agentLocation() {

}
agentLocation.prototype.addLocation = function(successCallback, errorCallback) {
exec(successCallback, errorCallback, "AgentLocation", "addLocation", []);
};

module.exports = new agentLocation();