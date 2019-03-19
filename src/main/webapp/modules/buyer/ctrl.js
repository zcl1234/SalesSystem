angular.module('buyer', [])
    .controller('buyerCtrl', ['$scope', '$http', '$rootScope', function ($scope, $http, $rootScope) {
        $scope.load = function () {
            $http.get('/api/buyer/list_bought?buyerId=' + $rootScope.user_id)
                .success(function (data) {
                    $scope.content_list = data.result;
                });
            $http.get('/api/buyer/list_unbought?buyerId=' + $rootScope.user_id)
                .success(function (data) {
                    $scope.unbought_content_list = data.result;
                })
        };
        $scope.load();
        $scope.current = 1;
        $scope.setCurrent = function (data) {
            if (data === 1) {
                $('#allContent').addClass('z-sel');
                $('#unboughtContent').removeClass('z-sel');
            } else {
                $('#allContent').removeClass('z-sel');
                $('#unboughtContent').addClass('z-sel');
            }
            $scope.current = data;
        }

    }]);