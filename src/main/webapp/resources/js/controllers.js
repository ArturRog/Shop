

var cartApp = angular.module('cartApp', []);

    cartApp.controller('cartCtrl', function ($scope, $http) {

        $scope.refreshCart = function (cartId) {
            console.log("Cart id in refreshCart method controllers.js " + cartId);

            $http({
                method: 'GET',
                url: 'http://localhost:8080/rest/cart/' + cartId
            }).then(function successRefresh(data) {
                $scope.cart = data.data;
                console.log($scope.cart);
            }, function errorCallback(data) {
                console.log("error in refreshCart");
            });

        };

        $scope.clearCart = function () {

            $http.delete('/rest/cart/' + $scope.cartId)
                .success($scope.refreshCart($scope.cartId));

        };

        $scope.initCartId = function (cartId) {

            $scope.cartId = cartId;
            $scope.refreshCart($scope.cartId);
        };


        $scope.addToCart = function (productId) {
            $http.put('/rest/cart/add/' + productId)
                .success(function (data) {

                    $http({
                        method: 'GET',
                        url: '/cart/getCartId'
                    }).then(function successCallback(response) {
                        $scope.cartId = response.data;
                        $scope.refreshCart($scope.cartId);

                    }, function errorCallback(response) {
                    });

                });
        };
        $scope.removeFromCart = function (productId) {
            $http.put('/rest/cart/remove/' + productId)
                .success(function (data) {

                    $http({
                        method: 'GET',
                        url: '/cart/getCartId'
                    }).then(function successCallback(response) {
                        $scope.cartId = response.data;
                        $scope.refreshCart($scope.cartId);

                    }, function errorCallback(response) {
                    });

                });
        };
    });
