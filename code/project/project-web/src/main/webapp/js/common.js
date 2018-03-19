var rootPath = getRootPath();

//返回网站根目录
function getRootPath() {
    var pathName = window.location.pathname.substring(1);
    var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/'));
    if (webName == "") {
        return window.location.protocol + '//' + window.location.host;
    }
    else {
        return window.location.protocol + '//' + window.location.host + '/' + webName;
    }
}

function importJs(fileName){
	document.write('<script src="' + rootPath + fileName + '" type="text/javascript"></script>');
}

function importCss(fileName){
	document.write('<link href="' + rootPath + fileName + '" type="text/css" rel="stylesheet" />');
}

importJs("/lib/angular.min.js");
importJs("/lib/angular-route.js");
importJs("/js/app.js");

importCss("/lib/bootstrap.min.css");

//业务代码
importJs("/module/home/homeController.js");
importJs("/module/book/bookController.js");
