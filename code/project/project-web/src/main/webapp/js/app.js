var app = angular.module('webapp', ['ngRoute']);
app.config(function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : 'module/home/home.html',
            controller : 'homeController'
        })
        .when('/book', {
            templateUrl : 'module/book/book.html',
            controller : 'bookController'
        });
});
