module.exports = {
    androidReceivedPlugin: function (data, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "AndroidReceivedPlugin", "androidReceivedPlugin", [data]);
    }
};