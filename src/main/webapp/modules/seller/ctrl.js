/**
 * Created by zhangchenlin on 19/2/17.
 */
angular.module('seller', [])
    .controller('sellerCtrl', ['$http', '$scope', '$location', function ($http, $scope, $location) {
        $scope.load = function () {
            $http.get("/api/seller/list")
                .success(function (data) {
                    $scope.content_list = data.result;
                });
        };
        $scope.load();

        $scope.show_detail = function (id) {
            $location.search('id', id);
            $location.path('detail');
        }
    }]);