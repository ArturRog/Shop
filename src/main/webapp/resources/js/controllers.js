var cartApp = angular.module('cartApp', []);

cartApp.controller('cartCtrl',  function ($scope, $http) {

    $scope.refreshCart = function(cartId) {
        alert("Jestem w funkcji refreshcart " + cartId);

        $http.get('/rest/cart/'+$scope.cartId)
            .success(function(data) {
                $scope.cart = data;
                alert("Jestem w funkcji refreshcart a to dane " + data);
            });
    };

    $scope.clearCart = function() {
        alert("Jestem w funkcji clearcart");

        $http.delete('/rest/cart/'+$scope.cartId)
            .success($scope.refreshCart($scope.cartId));

    };

    $scope.initCartId = function(cartId) {
        alert("Jestem w funkcji initcardid " + cartId);

        $scope.cartId=cartId;
        $scope.refreshCart($scope.cartId);
    };

    $scope.addToCart = function(productId) {
        alert("Jestem w funkcji " + productId);
        $http.put('/rest/cart/add/'+productId)
            .success(function(data) {
                alert("Przed refresh cart");

                $scope.refreshCart($http.get('/rest/cart/get/cartId'));
                alert("Product has been succesfully added to cart!");
            });
    };
    $scope.removeFromCart = function(productId) {
        alert("Jestem w funkcji removefromcart" + productId);


        $http.put('/rest/cart/remove/'+productId)
            .success(function(data) {
                $scope.refreshCart($http.get('/rest/cart/get/cartId'));
            });
    };
});
