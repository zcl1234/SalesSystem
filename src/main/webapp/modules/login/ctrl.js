/**
 * Created by zhangchenlin on 19/2/16.
 */
angular.module('login', [])
    .controller('loginCtrl', ['$scope', '$location', function ($scope, $location) {
        $scope.login = function () {
            $location.search('userName', 'seller');
            $location.search('password', 'relles');
            $location.path('/seller');
        };
    }]);
