/**
 * Created by zhangchenlin on 19/1/17.
 */
var modules = [
    'ngRoute',
    'login',       //登陆模块
    'mainworkspace',//首页
    'seller',       //卖家首页
    'public',       //卖家发布
    'detail',        //商品详情
    'buyer',        //卖家首页
    'shoppingcart'          //购物车
];

var app = angular.module('SalesSystem', modules, function () {

});

app.config(['$routeProvider', function ($routeProvider) {
    angular.forEach(modules, function (m) {
        $routeProvider.when('/', {
            templateUrl: '/modules/mainworkspace/index.html',
            controller: 'mainworkspaceCtrl'
        }).when('/detail/:id', {
            templateUrl: '/modules/detail/index.html',
            controller: 'detailCtrl'
        }).when('/public/:id', {
            templateUrl: '/modules/public/index.html',
            controller: 'publicCtrl'
        }).when('/' + m, {
            templateUrl: '/modules/' + m + '/index.html',
            controller: m + 'Ctrl'
        });
    })
}]).controller('mainCtrl', ['$timeout', '$scope', '$location', function ($timeout, $scope, $location) {

    $scope.logout = function () {
        $http.get('/logout')
            .success(function () {
                $location.path('login');
            })
    }

}]);
