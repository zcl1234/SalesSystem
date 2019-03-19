angular.module('shoppingcart', [])
    .controller('shoppingcartCtrl', ['$scope', '$http', '$rootScope', function ($scope, $http, $rootScope) {

        $scope.load = function () {
            $http.get('/api/buyer/list_shoppingcart_item?buyerId=' + $rootScope.user_id)
                .success(function (data) {
                    $scope.shoppingCartItems = data.result;
                })
        };

        $scope.load();
    }]);