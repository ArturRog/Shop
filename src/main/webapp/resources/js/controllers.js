// var cartApp = angular.module('cartApp', []);
//
// cartApp.controller('cartCtrl', function ($scope, $http) {
//
//     $scope.refreshCart = function (cartId) {
//         $http.get('/rest/cart/' + $scope.cartId)
//             .success(function (data) {
//                 $scope.cart = data;
//             });
//     };
//
//     $scope.clearCart = function () {
//         $http.delete('/rest/cart/' + $scope.cartId)
//             .success($scope.refreshCart($scope.cartId));
//
//     };
//
//     $scope.initCartId = function (cartId) {
//         $scope.cartId = cartId;
//         $scope.refreshCart($scope.cartId);
//     };
//
//     $scope.addToCart = function (productId) {
//         $http.put('/rest/cart/add/' + productId)
//             .success(function (data) {
//                 $scope.refreshCart($http.get('/rest/cart/get/cartId'));
//                 alert("Produkt pomyślnie dodany do koszyka!");
//             });
//     };
//     $scope.removeFromCart = function (productId) {
//         $http.put('/webstore/rest/cart/remove/' + productId)
//             .success(function (data) {
//                 $scope.refreshCart($http.get('/rest/cart/get/cartId'));
//             });
//     };
// });



var cartApp = angular.module('cartApp', []);

    cartApp.controller('cartCtrl', function ($scope, $http) {

        $scope.refreshCart = function (cartId) {
            console.log("Cart id in refreshCart method controllers.js " + cartId);

            $http({
                method: 'GET',
                url: 'http://localhost:8080/rest/cart/' + cartId
            }).then(function successRefresh(singleCart) {
                $scope.cart = singleCart;
                console.log("Success, im inside");
                console.log(singleCart);
                console.log("After");
            }, function errorCallback(singleCart) {
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

                    alert("Product has been succesfully added to cart!");
                });
        };
        $scope.removeFromCart = function (productId) {


            $http.put('/rest/cart/remove/' + productId)
                .success(function (data) {
                    $scope.refreshCart($http.get('/rest/cart/get/cartId'));
                });
        };
    });
