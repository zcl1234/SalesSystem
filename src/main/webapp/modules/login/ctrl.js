/**
 * Created by zhangchenlin on 19/2/16.
 */
angular.module('login', [])
    .controller('loginCtrl', ['$scope', '$location', '$http', '$rootScope', function ($scope, $location, $http, $rootScope) {
        $scope.login = function () {
            $http.get('/login?username=' + $scope.username + '&password=' + hex_md5($scope.password))
                .success(function (data) {
                    $rootScope.username = data.result.userName;
                    $rootScope.user_role = data.result.userRole;
                    $rootScope.user_id = data.result.id;
                    // $cookies.username = data.result.userName;
                    // $cookies.user_role = data.result.userRole;
                    if (data.result.userRole === 'SELLER') {
                        $location.path('seller');
                    } else {
                        $location.path('buyer');
                    }

                });
        };
    }]);
