angular.module('detail', ['ngDialog'])
    .controller('detailCtrl', ['$scope', '$http', '$location', '$routeParams', 'ngDialog', '$rootScope', function ($scope, $http, $location, $routeParams, ngDialog, $rootScope) {

        //  var id = $location.search('id');

        $scope.load = function (id) {
            $scope.saleContent = $.ajax({
                url: '/api/seller/show_detail?id=' + id,
                async: false
            }).responseJSON.result;
            $http.get('/api/buyer/select_shoppingcart_item?productId=' + $scope.saleContent.id)
                .success(function (data) {
                    $scope.shoppingCartItem = data.result;
                    if ($scope.shoppingCartItem == null) {
                        $scope.shoppingCartItem = {
                            'id': null,
                            'buyerId': $rootScope.user_id,
                            'saleContent': JSON.stringify($scope.saleContent),
                            'num': 0
                        };
                    }
                });
        };

        $scope.load($routeParams.id);

        $scope.confirm = function () {
            $.MsgBox.Confirm("温馨提示", "确定要加入购物车？", add_item);
        };

        $scope.addNum = function () {
            $scope.shoppingCartItem.num += 1;
        };
        $scope.reduceNum = function () {
            if ($scope.shoppingCartItem.num > 0) {
                $scope.shoppingCartItem.num -= 1;
            }
        };

        function add_item() {
            $http({
                method: 'post',
                url: '/api/buyer/add_shoppingcart_item?buyerId=' + $rootScope.user_id + '&num=' + $scope.shoppingCartItem.num,
                headers: {'Content-Type': 'application/json'},
                data: JSON.stringify($scope.saleContent)
            }).success(function () {
                $location.path('shoppingcart');
            })
        }
    }]);