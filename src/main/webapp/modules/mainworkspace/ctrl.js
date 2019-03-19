/**
 * Created by zhangchenlin on 19/2/17.
 */
angular.module('mainworkspace', [])
    .controller('mainworkspaceCtrl', ['$scope', '$http', function ($scope, $http) {
        $scope.load = function () {
            $http.get('/api/seller/list')
                .success(function (data) {
                    $scope.content_list = data.result;
                })
        };
        $scope.load();
    }]);