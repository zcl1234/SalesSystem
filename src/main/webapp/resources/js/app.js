/**
 * Created by zhangchenlin on 19/1/17.
 */
var modules = [
    'ngRoute',
    'login',
    'mainworkspace',
    'seller'
];

var app = angular.module('SalesSystem', modules, function () {

});

app.config(['$routeProvider', function ($routeProvider) {
    angular.forEach(modules, function (m) {
        $routeProvider.when('/',{
            templateUrl:'/modules/mainworkspace/index.html',
            controller:'mainworkspaceCtrl'
        })
            .when('/' + m, {
            templateUrl: '/modules/' + m + '/index.html',
            controller: m + 'Ctrl'
        });
    })
}]).controller('mainCtrl', [function () {

}]);
